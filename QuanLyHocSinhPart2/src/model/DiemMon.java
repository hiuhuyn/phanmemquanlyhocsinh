package model;

public class DiemMon {
	private String maMH= "";
	private String maHS= "";
	private String maHK = "";
	private float diemMieng = 0, diem15p= 0, diem1Tiet= 0, diemThi= 0;
	

	public DiemMon(String monHoc, String hocSinh, String hocKy, float diemMieng, float diem15p, float diem1Tiet,
			float diemThi) {
		
		this.maMH = monHoc;
		this.maHS = hocSinh;
		this.maHK = hocKy;
		this.diemMieng = diemMieng;
		this.diem15p = diem15p;
		this.diem1Tiet = diem1Tiet;
		this.diemThi = diemThi;
	}
	
	
	/**
	 * @param monHoc
	 * @param hocSinh
	 * @param hocKy
	 */
	public DiemMon(String monHoc, String hocSinh, String hocKy) {
		super();
		this.maMH = monHoc;
		this.maHS = hocSinh;
		this.maHK = hocKy;
	}
	
	/**
	 * 
	 */
	public DiemMon() {
		super();
	}
	public String getMonHoc() {
		return maMH;
	}
	public void setMonHoc(String monHoc) {
		this.maMH = monHoc;
	}
	public String getHocSinh() {
		return maHS;
	}
	public void setHocSinh(String hocSinh) {
		this.maHS = hocSinh;
	}
	public String getHocKy() {
		return maHK;
	}
	public void setHocKy(String hocKy) {
		this.maHK = hocKy;
	}
	public float getDiemMieng() {
		return diemMieng;
	}
	public void setDiemMieng(float diemMieng) {
		this.diemMieng = diemMieng;
	}
	public float getDiem15p() {
		return diem15p;
	}
	public void setDiem15p(float diem15p) {
		this.diem15p = diem15p;
	}
	public float getDiem1Tiet() {
		return diem1Tiet;
	}
	public void setDiem1Tiet(float diem1Tiet) {
		this.diem1Tiet = diem1Tiet;
	}
	public float getDiemThi() {
		return diemThi;
	}
	public void setDiemThi(float diemThi) {
		this.diemThi = diemThi;
	}
	public float getDiemTBmon() {
		
//		diemTBmon = (float) 8.8;
		return (float) (this.diemMieng + this.diem15p + 2*this.diem1Tiet + 3*this.diemThi )/7;
	}
	@Override
	public String toString() {
		return "DiemMon [monHoc=" + maMH + ", hocSinh=" + maHS + ", hocKy=" + maHK + ", diemMieng=" + diemMieng
				+ ", diem15p=" + diem15p + ", diem1Tiet=" + diem1Tiet + ", diemThi=" + diemThi + ", diemTBmon="
				+ this.getDiemTBmon() + "]";
	}
	
	
	
	
	
	
	
	
	
}
