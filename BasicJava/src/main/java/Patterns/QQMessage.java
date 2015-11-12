package Patterns;

/**
 * Created by yantinggeng on 2015/11/12.
 */
public class QQMessage implements IMessage {

    private ISendMessage sendMessage;
    private String string;

    public QQMessage(ISendMessage sendMessage, String string) {
        this.sendMessage = sendMessage;
        this.string = string;
    }

    @Override
    public void sendMessage() {

        sendMessage.sendMessage(string);
        
    }

    @Override
    public void sendTime() {

    }
}
