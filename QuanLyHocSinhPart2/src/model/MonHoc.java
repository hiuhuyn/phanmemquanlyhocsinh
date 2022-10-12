package model;

public class MonHoc {
	private String maMon;
	private String tenMon;
	/**
	 * @param maMon
	 * @param tenMon
	 */
	public MonHoc(String maMon, String tenMon) {
		super();
		this.maMon = maMon;
		this.tenMon = tenMon;
	}
	/**
	 * 
	 */
	public MonHoc() {
		super();
	}
	/**
	 * @param maMon
	 */
	public MonHoc(String maMon) {
		super();
		this.maMon = maMon;
	}
	public String getMaMon() {
		return maMon;
	}
	public void setMaMon(String maMon) {
		this.maMon = maMon;
	}
	public String getTenMon() {
		return tenMon;
	}
	public void setTenMon(String tenMon) {
		this.tenMon = tenMon;
	}
	@Override
	public String toString() {
		return "MonHoc [maMon=" + maMon + ", tenMon=" + tenMon + "]";
	}
	
	

}
