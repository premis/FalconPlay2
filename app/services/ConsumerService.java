package services;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;
import com.rabbitmq.client.QueueingConsumer;
import com.typesafe.plugin.RedisPlugin;
import play.Application;
import play.Logger;
import play.Play;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;

import java.util.Date;

/**
 *
 * @author premis
 *
 * This class represents a consumer for RabbitMQ messages. Whenever a message is found pending on the queue it
 * is consumed, and persisted to Redis.
 *
 */
public class ConsumerService {

    private static Thread consumerThread = null;

    /**
     * This should spawn it's own thread and have some sleep or wait-notify mechanism to consume less processing power.
     * This method is idempotent.
     *
     */
    public static void registerConsumer(Application app){

        if (consumerThread != null) {
            if (!consumerThread.isAlive()){
                consumerThread.start();
            }
            return;
        }

        consumerThread = new Thread(){

            public void run() {
                try {
                    ConnectionFactory factory = new ConnectionFactory();
                    factory.setHost("localhost");
                    Connection connection = factory.newConnection();
                    Channel channel = connection.createChannel();

                    channel.queueDeclare("hello", false, false, false, null);
                    Logger.info(" [*] Waiting for messages. To exit press CTRL+C");

                    QueueingConsumer consumer = new QueueingConsumer(channel);
                    channel.basicConsume("hello", true, consumer);

                    while (true) {
                        QueueingConsumer.Delivery delivery = consumer.nextDelivery();
                        String value = new String(delivery.getBody());
                        Logger.info(" consuming '" + value + "'");

                        JedisPool pool = Play.application().plugin(RedisPlugin.class).jedisPool();
                        Jedis j = pool.getResource();

                        String key = String.valueOf(new Date().getTime());
                        j.set(key, value);
                        Logger.info(" persisted '" + key +"','"+value + "'");

                        pool.returnResource(j);

                        Thread.yield();
                        sleep(1000);
                    }

                } catch (Exception ex){
                    ex.printStackTrace();
                }
            }
        };

        consumerThread.start();

    }

    public static void unregisterConsumer(){

        consumerThread.interrupt();

    }


}
