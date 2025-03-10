package Service;

import Model.Message;
import DAO.MessageDAO;

import java.util.List;

public class MessageService {
    private MessageDAO messageDAO;

    public MessageService() {
        messageDAO = new MessageDAO();
    }

    public MessageService(MessageDAO messageDAO) {
        this.messageDAO = messageDAO;
    }

    public Message addMessage(Message message) {
        return messageDAO.createMessage(message.getPosted_by(), message.getMessage_text(), message.getTime_posted_epoch());
    }

    public List<Message> getAllMessages() {
        return messageDAO.getAllMessages();
    }

    public Message getMessage(int message_id) {
        return messageDAO.getMessageByMessageID(message_id);
    }

    public Message deleteMessage(int message_id) {
        Message message = messageDAO.getMessageByMessageID(message_id);
        
        if (message != null) {
            messageDAO.deleteMessageByMessageID(message_id);
        }

        return message;
    }

    public Message modifyMessage(String message_text, int message_id) {
        return messageDAO.updateMessageByMessageID(message_text, message_id) ? messageDAO.getMessageByMessageID(message_id) : null;
    }

    public List<Message> getMessages(int user_id) {
        return messageDAO.getAllMessageByUserID(user_id);
    }
}