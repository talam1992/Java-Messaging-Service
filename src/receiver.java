/**
 * package belong to messaging
 */
package messaging;

import javax.jms.Connection; // import from java.jms library creates a connection
import javax.jms.MessageConsumer; //import from java.jms library create a Message
import javax.jms.Queue; //import from java.jms library crates a Queue
import javax.jms.Session; //import from java.jms library creates a Session
import javax.jms.TextMessage; //import from java.jms library creates a TextMessage

/**
 * Import from activemq library
 */
import org.apache.activemq.ActiveMQConnectionFactory;

public class receiver {

    /**
     * @param args
     * @throws Exception
     */
    public static void main(String[] args)throws Exception {
        /**
         * Create a new ActiveMQconnectionFactory(String)
         * form connection object
         */
        Connection connection = new ActiveMQConnectionFactory("tcp://172.20.4.247:61616").createConnection();
        connection.start(); // Start the oonnection
        Session session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE); //
        Queue queue= session.createQueue(""); //
        MessageConsumer receiver = session.createConsumer(queue); //
        TextMessage msg= (TextMessage)receiver.receive();
        String user = msg.getStringProperty("User");
        System.out.println(msg.getText()+ ".... The message = " + user);
        connection.close();
    }
}
