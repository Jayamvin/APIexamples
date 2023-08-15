package POJO;

public class Credentials {
	
	private String username;
	private String password;
	
	//right click and go to source and click on Generate constructor using these fields   
	public Credentials(String username, String password) {
	
		this.username = username;
		this.password = password;
	}
	//getter/setter:
	//right click and go to source and click on Generate getters and setters 
	
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}

}
