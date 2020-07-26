package multichat;

public class Message {
	public String id;
	public String password;
	public String msg;
	public String type;
	public String receiver = "";

	
	public Message(String id, String password, String msg, String type) {
		this.id = id;
		this.password = password;
		this.msg = msg;
		this.type = type;
	}
	
	public Message(String id, String password, String msg, String type, String receiver) {
		this.id = id;
		this.password = password;
		this.msg = msg;
		this.type = type;
		this.receiver = receiver;
	}
	
}