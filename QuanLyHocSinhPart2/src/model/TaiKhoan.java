package model;

public class TaiKhoan {
	private String user, pass, hoten, sdt, email;

	
	
	
	/**
	 * @param user
	 * @param pass
	 */
	public TaiKhoan(String user, String pass) {
		super();
		this.user = user;
		this.pass = pass;
	}

	/**
	 * 
	 */
	public TaiKhoan() {
		super();
	}

	/**
	 * @param user
	 * @param pass
	 * @param hoten
	 * @param sdt
	 * @param email
	 */
	public TaiKhoan(String user, String pass, String hoten, String sdt, String email) {
		super();
		this.user = user;
		this.pass = pass;
		this.hoten = hoten;
		this.sdt = sdt;
		this.email = email;
	}

	public String getUser() {
		return user;
	}

	public void setUser(String user) {
		this.user = user;
	}

	public String getPass() {
		return pass;
	}

	public void setPass(String pass) {
		this.pass = pass;
	}

	public String getHoten() {
		return hoten;
	}

	public void setHoten(String hoten) {
		this.hoten = hoten;
	}

	public String getSdt() {
		return sdt;
	}

	public void setSdt(String sdt) {
		this.sdt = sdt;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
	
	
	
}
