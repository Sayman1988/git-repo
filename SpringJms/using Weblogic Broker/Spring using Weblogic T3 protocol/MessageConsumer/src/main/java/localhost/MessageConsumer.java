package localhost;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Service;

import javax.jms.JMSException;
import javax.jms.TextMessage;


/**
 * Created by seroole on 3/31/2017.
 */

@Service
class MessageConsumer {
    private final static Log log = LogFactory.getLog(MessageConsumer.class);

    @JmsListener(destination = "jms/feedTopic")
    public void receive(final TextMessage message){
        try {
            log.info("Message (id = " + message.getJMSMessageID() + ") is received with next content: " + message.getText());
        } catch (JMSException e) {
            log.error("Error getting message " + message, e);
        }
    }
}

