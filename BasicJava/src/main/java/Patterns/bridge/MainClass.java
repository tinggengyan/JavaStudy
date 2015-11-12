package Patterns.bridge;

/**
 * Created by yantinggeng on 2015/11/12.
 */
public class MainClass {
    public static void main(String[] args) {
        QQMessage qqMessage=new QQMessage(new QQSendMessage(),"爱我别走");
        WeixinMessage weixinMessage=new WeixinMessage("中流击水",new WeixinSendMessage());
        qqMessage.sendMessage();
        weixinMessage.sendMessage();
    }
}
