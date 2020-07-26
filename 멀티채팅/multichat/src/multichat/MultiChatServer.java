package multichat;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.logging.Logger;
import com.google.gson.Gson;

public class MultiChatServer {
	private ServerSocket ss = null;
	private Socket s = null;
	
	private ArrayList<ChatThread> chatThreads = new ArrayList<ChatThread>();
	
	Logger logger;
	
	public MultiChatServer() {
		start();
	}
	public void start() {
		logger = Logger.getLogger(this.getClass().getName());
		
		try {
			ss = new ServerSocket(8888);
			logger.info("MultiChatServer start");
			
			while(true) {
				s = ss.accept();
				ChatThread chat = new ChatThread();
				chatThreads.add(chat);
				chat.start();
			}
		}
		catch(Exception e) {
				logger.info("[MulitChatServer]start() Exception 발생");
				e.printStackTrace();
		}
		
	}
	
	public void msgSendAll(String msg) {
		for(ChatThread ct : chatThreads) {
			ct.outMsg.println(msg);
		}
	}
	

	class ChatThread extends Thread {
		String msg;
		Message m;
		String[] rmsg;
		String secret;
		Gson gson = new Gson();
		public String id = null;
		
		private BufferedReader inMsg = new BufferedReader(new InputStreamReader(s.getInputStream()));
		private PrintWriter outMsg = new PrintWriter(s.getOutputStream(),true);
		
		ChatThread() throws IOException{
		}
		public void run() {
			boolean status = true;
				
				while(status) {
					try {
					msg = inMsg.readLine();
					m = gson.fromJson(msg, Message.class);
					
					if(m.type.equals("logout")) {
						chatThreads.remove(this);
						msgSendAll(gson.toJson(new Message(m.id, "", "님이 종료했습니다.", "server")));
						
						status = false;
						this.interrupt();
						logger.info(this.getName() + " 종료됨");
					}
					
					else if(m.type.equals("login")) {
						if(id==null) id = m.id;
						msgSendAll(gson.toJson(new Message(m.id, "", "님이 로그인했습니다.", "server")));
					}
					
					else if(m.type.equals("whisper")) {
						for (ChatThread ct : chatThreads) {
                            if (ct.id.equals(m.receiver)) {
                                ct.outMsg.println(gson.toJson(new Message(m.id, "", m.msg, "whisper")));
                            }
                        }
					}
					else {
						msgSendAll(msg);
					}
			}catch(Exception e) {
				e.printStackTrace();
			}
		}
		}
		}
	
	public static void main(String[] args) {
		MultiChatServer server = new MultiChatServer();
	}
}