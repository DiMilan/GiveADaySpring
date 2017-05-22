package be.hogent.giveaday.config;

public class Authentication {
	
	private String username;
	private String password;
	private String role;
	
	public Authentication() {
		setUsername("myuser");
		setPassword("mypass");
	}

	private void setUsername(String username) {
		this.username = username;
	}
	
	private String getUsername(){
		return this.username;
	}

	private void setPassword(String password) {
		this.password = password;
	}
	
	private String getPassword(){
		return this.password;
	}

	public String getRole() {return role;}

	public void setRole(String role) {this.role = role;}

	public Boolean authenticate(String username, String password){
		if(username.equals(getUsername()) && password.equals(getPassword())){
			return true;
		}
		return false;
	}

}
