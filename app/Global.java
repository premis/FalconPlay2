import com.rabbitmq.client.QueueingConsumer;
import play.*;

import com.rabbitmq.client.ConnectionFactory;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.Channel;
import services.ConsumerService;

import java.io.IOException;

/**
 * Global configurations for the Play application.
 */
public class Global extends GlobalSettings {

    public final static String QUEUE_NAME = "hello";

    @Override
    public void onStart(Application app) {
        //super.onStart(application);
        ConsumerService.registerConsumer(app);

    }

    @Override
    public void onStop(Application application) {
        //super.onStop(application);
        ConsumerService.unregisterConsumer();
    }
}