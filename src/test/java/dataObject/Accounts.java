package dataObject;

public class Accounts {
	private String email;
	private String password;
	private String newPassword;
	private String lastName;
	private String firstName;
	private String phoneNumber;
	
	private static final String _email = "oui.oui@yopmail.com";
	private static final String _password = "Sogeti_33";
	private static final String _fakeEmail = "kent@yopmail.com";
	private static final String _fakePassword = "1234";
	private static final String _firstName = "Clark";
	private static final String _lastName = "Kent";
	private static final String _phoneNumber = "0123456789";
	
	public Accounts() {
		this.setEmail(_email);
		this.setFakeEmail(_fakeEmail);
		this.setLastName(_lastName);
		this.setFirstName(_firstName);
		this.setFakePassword(_fakePassword);
		this.setNewPassword(_password);
		this.setPhoneNumber(_phoneNumber);
	}
	
	public String getFakeEmail() {
		return email;
	}
	
	public void setFakeEmail(String email) {
		this.email = email;
	}
	
	public String getEmail() {
		return email;
	}
	
	public void setEmail(String email) {
		this.email = email;
	}
	
	public String getFakePassword() {
		return password;
	}
	
	public void setFakePassword(String password) {
		this.password = password;
	}
	
	public String getPassword() {
		return password;
	}
	
	public void setPassword(String password) {
		this.password = password;
	}
	
	public String getLastName() {
		return lastName;
	}
	
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	
	public String getFirstName() {
		return firstName;
	}
	
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	
	public String getPhoneNumber() {
		return phoneNumber;
	}
	
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getNewPassword() {
		return newPassword;
	}

	public void setNewPassword(String newPassword) {
		this.newPassword = newPassword;
	}

}
