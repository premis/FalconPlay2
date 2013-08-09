package controllers;


import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;
import com.rabbitmq.client.QueueingConsumer;
import com.typesafe.plugin.RedisPlugin;
import models.Message;
import org.codehaus.jackson.JsonNode;
import org.codehaus.jackson.node.ObjectNode;
import play.Logger;
import play.Play;
import play.libs.F;
import play.libs.Json;
import play.mvc.Controller;
import play.mvc.Result;
import play.mvc.WebSocket;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import services.ConsumerService;
import views.html.messager;


import java.io.IOException;
import java.util.*;

/**
 *
 * @author premis
 *
 * This class will display the messager page and perform all the actions relating to it.
 * This page will have to be active, using WebSocks it refreshes to show in real time what's going on with
 * all the messages on the server.
 *
 */
public class Messager extends Controller {

    /**
     * A list of active websockets, that is synchronized and is maintained (i.e. socks get added and removed
     * from it when they are closed)
     */
    public static Map<WebSocket.In<String>, WebSocket.Out<String>> socketsMap =
            Collections.synchronizedMap(new HashMap<WebSocket.In<String>, WebSocket.Out<String>>());


    /**
     * This returns the messages page.
     * @return
     */
    public static Result getMessagerPage(){

        JedisPool p = Play.application().plugin(RedisPlugin.class).jedisPool();

        Jedis j = p.getResource();

        Set<String> allKeys = j.keys("*");

        List<Message> messageList = new ArrayList<Message>();

        String value = null;
        for (String key : allKeys){
            value = j.get(key);
            messageList.add(new Message(key, value));
        }

        p.returnResource(j);

        return ok(messager.render(messageList));
    }


    /**
     * This performs the sending of a message as a JSON object.
     * @return
     */
    public static Result postMessage(){

        JsonNode json = request().body().asJson();

        if(json == null) {

            ObjectNode result = Json.newObject();
            result.put("status", "BAD");
            result.put("message", "Expecting JSON data" );
            return ok(result);

        } else {

            String value = json.get("key").toString();

            Logger.info("placing message on queue " + value);

            try {
                ConnectionFactory factory = new ConnectionFactory();
                factory.setHost("localhost");
                Connection connection = factory.newConnection();
                Channel channel = connection.createChannel();

                channel.queueDeclare(ConsumerService.QUEUE_NAME, false, false, false, null);
                channel.basicPublish("", ConsumerService.QUEUE_NAME, null, value.getBytes());
                Logger.info(" published '" + value + "'");

                broadcast(value+" was received from a client!");

                channel.close();
                connection.close();


            } catch (IOException ex){
                ex.printStackTrace();
            }

            ObjectNode result = Json.newObject();
            result.put("status", "OK");
            result.put("message", "Message Posted" );
            return ok(result);

        }

    }


    /**
     * This performs the deletion of all the messages in the Redis database.
     * @return
     */
    public static Result deleteAllMessages(){

        Logger.info("deleting all messages ");

        JedisPool p = Play.application().plugin(RedisPlugin.class).jedisPool();

        Jedis j = p.getResource();

        Set<String> allKeys = j.keys("*");

        for (String key : allKeys){
            j.del(key);
        }

        p.returnResource(j);

        ObjectNode result = Json.newObject();
        result.put("status", "OK");
        result.put("message", "Messages Deleted" );
        return ok(result);
    }


    /**
     * This registers a websocket for a client which is going to listen to our push notifications.
     * @return
     */
    public static WebSocket<String> registerSocket() {

        //return ok(play.libs.Json.toJson(run));

        return new WebSocket<String>() {
            // called when the websocket is established
            public void onReady(final WebSocket.In<String> in, final WebSocket.Out<String> out) {

                socketsMap.put(in, out);

                // register a callback for processing instream events
                in.onMessage(new F.Callback<String>() {
                    public void invoke(String event) {
                        broadcast(event);
                    }
                });

                // When the socket is closed.
                in.onClose(new F.Callback0() {
                    public void invoke() {
                        socketsMap.remove(in);
                        Logger.info("removed "+in);
                    }
                });

            }
        };
    }

    /**
     * Internal method used to broadcast a message to all listening clients through WebSockets. This should be moved
     * somewhere else to be more generic and not specific to this controller alone.
     * @param notification
     */
    private static void broadcast(String notification){
        for (WebSocket.Out out : socketsMap.values()){
            out.write( notification );
        }
    }

}
