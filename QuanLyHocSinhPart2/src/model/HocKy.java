package model;

public class HocKy {
	private String maHK;
	private String tenHK;
	private int NamBatDau, NamKetThuc;

	
	
	/**
	 * @param maHK
	 */
	public HocKy(String maHK) {
		super();
		this.maHK = maHK;
	}
	/**
	 * @param maHK
	 * @param tenHK
	 * @param namBatDau
	 * @param namKetThuc
	 */
	public HocKy(String maHK, String tenHK, int namBatDau, int namKetThuc) {
		super();
		this.maHK = maHK;
		this.tenHK = tenHK;
		NamBatDau = namBatDau;
		NamKetThuc = namKetThuc;
	}
	public HocKy() {
		super();
	}
	public String getMaHK() {
		return maHK;
	}
	public void setMaHK(String maHK) {
		this.maHK = maHK;
	}
	public String getTenHK() {
		return tenHK;
	}
	public void setTenHK(String tenHK) {
		this.tenHK = tenHK;
	}
	public int getNamBatDau() {
		return NamBatDau;
	}
	public void setNamBatDau(int namBatDau) {
		NamBatDau = namBatDau;
	}
	public int getNamKetThuc() {
		return NamKetThuc;
	}
	public void setNamKetThuc(int namKetThuc) {
		NamKetThuc = namKetThuc;
	}
//
	@Override
	public String toString() {
		return "HocKy [maHK=" + maHK + ", tenHK=" + tenHK + ", NamBatDau=" + NamBatDau + ", NamKetThuc=" + NamKetThuc
				+ "]";
	}
	
}
