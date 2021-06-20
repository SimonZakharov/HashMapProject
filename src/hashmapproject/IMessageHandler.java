package hashmapproject;

public interface IMessageHandler {
    public String[] generateMessage(int added, int deleted, int changed);
    public void send(String[] msg);
    public void send(String[] msg, String ...par);
}
