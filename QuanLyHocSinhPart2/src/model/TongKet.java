package model;

public class TongKet {
	private String malop, maHS, hoTenHS, maHK;
	private int soMon;
	private double diemTk;
	public TongKet(String malop, String maHS, String hoTenHS, String maHK, int soMon, double diemTk) {
		super();
		this.malop = malop;
		this.maHS = maHS;
		this.hoTenHS = hoTenHS;
		this.maHK = maHK;
		this.soMon = soMon;
		this.diemTk = diemTk;
	}
	public TongKet() {
		super();
	}
	public String getMalop() {
		return malop;
	}
	public void setMalop(String malop) {
		this.malop = malop;
	}
	public String getMaHS() {
		return maHS;
	}
	public void setMaHS(String maHS) {
		this.maHS = maHS;
	}
	public String getHoTenHS() {
		return hoTenHS;
	}
	public void setHoTenHS(String hoTenHS) {
		this.hoTenHS = hoTenHS;
	}
	public String getMaHK() {
		return maHK;
	}
	public void setMaHK(String maHK) {
		this.maHK = maHK;
	}
	public int getSoMon() {
		return soMon;
	}
	public void setSoMon(int soMon) {
		this.soMon = soMon;
	}
	public double getDiemTk() {
		return diemTk;
	}
	public void setDiemTk(double diemTk) {
		this.diemTk = diemTk;
	}
	
	
	
	
}
