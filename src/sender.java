/**
 * package belongs to messaging
 */
package messaging;

import javax.jms.Connection; // Import from javax.jms  library creates a connection
import javax.jms.MessageProducer; // Import from java.jms library creates a Message
import javax.jms.Queue; //Import from javax.jms library creates a Queue
import javax.jms.Session; //Import from javax.jms library creates a Session
import javax.jms.TextMessage; //Import from javax.jms library crates a TextMessage

import org.apache.activemq.ActiveMQConnectionFactory; // 

public class sender {

    public static void main(String[] args) throws Exception {
        ActiveMQConnectionFactory cf = new ActiveMQConnectionFactory("tcp://192.168.0.247:61616");
        Connection connection = cf.createConnection();
        connection.start();
        Session session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);
        Queue queue = session.createQueue("");
        MessageProducer sender = session.createProducer(queue);
        TextMessage msg = session.createTextMessage(" ");
        msg.setStringProperty("User", "Testing");
        sender.send(msg);
        System.out.println("Message sent");
        connection.close();

    }


}
