import java.io.*;
public class User {
	private String nick;
	private String realName;
	private String server;
	
	public void setNick(String n) {
		nick=n;
	}
	
	public String getNick() {
		return(nick);
	}
	
	public void setRealName(String r) {
		realName=r;
	}
	
	public String getRealName() {
		return(realName);
	}
	
	public void setServer(String s) {
		server=s;
	}
	
	public String getServer() {
		return(server);
	}
	
	public void saveInfo() {
		try {
			FileOutputStream userSaveFile = new FileOutputStream("user.dat");
			ObjectOutputStream os = new ObjectOutputStream(userSaveFile);
			
			os.writeObject(nick);
			os.writeObject(realName);
			os.writeObject(server);
			os.close();
		}
		
		catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void loadInfo() {
		try {
			FileInputStream userSaveFile = new FileInputStream("user.dat");
			ObjectInputStream is = new ObjectInputStream(userSaveFile);
			
			nick=(String) is.readObject();
			realName=(String) is.readObject();
			server=(String) is.readObject();
			is.close();
		}
		catch (Exception e) {
			e.printStackTrace();
		}
	}
}