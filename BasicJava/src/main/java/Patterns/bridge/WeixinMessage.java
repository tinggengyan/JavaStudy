package Patterns.bridge;

/**
 * Created by yantinggeng on 2015/11/12.
 */
public class WeixinMessage implements IMessage {
    private String string;
    private ISendMessage sendMessage;

    public WeixinMessage(String string, ISendMessage sendMessage) {
        this.string = string;
        this.sendMessage = sendMessage;
    }

    @Override
    public void sendMessage() {

        sendMessage.sendMessage(string);

    }

    @Override
    public void sendTime() {

    }
}
