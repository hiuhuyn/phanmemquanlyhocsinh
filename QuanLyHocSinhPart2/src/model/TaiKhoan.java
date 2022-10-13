package model;

public class TaiKhoan {
	private String user, pass, hoten, sdt, email;
	private String quyenTruyCap;

	
	
	
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
		this.quyenTruyCap = "member";
	}

	/**
	 * @param user
	 * @param pass
	 * @param hoten
	 * @param sdt
	 * @param email
	 * @param quyenTruyCap
	 */
	public TaiKhoan(String user, String pass, String hoten, String sdt, String email, String quyenTruyCap) {
		super();
		this.user = user;
		this.pass = pass;
		this.hoten = hoten;
		this.sdt = sdt;
		this.email = email;
		this.quyenTruyCap = quyenTruyCap;
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

	public String getQuyenTruyCap() {
		return quyenTruyCap;
	}

	public void setQuyenTruyCap(String quyenTruyCap) {
		this.quyenTruyCap = quyenTruyCap;
	}

	@Override
	public String toString() {
		return "TaiKhoan [user=" + user + ", pass=" + pass + ", hoten=" + hoten + ", sdt=" + sdt + ", email=" + email
				+ ", quyenTruyCap=" + quyenTruyCap + "]";
	}
	
	
	
	
	
}
