package Patterns.bridge;

/**
 * Created by yantinggeng on 2015/11/12.
 */
public class QQSendMessage implements ISendMessage {

    @Override
    public void sendMessage(String s) {

        System.out.println("QQSendMessage:" + s);

    }
}
