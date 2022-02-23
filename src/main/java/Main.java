import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;

public class Main {
    private final static String QUEUE_NAME = "test-queue";

    public static void main(String[] arg) throws Exception {
        ConnectionFactory factory = new ConnectionFactory();
        factory.setHost("localhost");
        try (Connection connection = factory.newConnection();
                Channel channel = connection.createChannel();) {
            channel.queueDeclare(QUEUE_NAME, true, false, false, null);
            String message = "HELLO RABBITMQ !";
            channel.basicPublish("test-exchange", "red", null, message.getBytes());
            System.out.println(" [x] Sent '" + message + "'");
        }
    }
}
