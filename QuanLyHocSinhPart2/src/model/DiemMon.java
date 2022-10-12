package model;

public class DiemMon {
	private String monHoc= "";
	private String hocSinh= "";
	private String hocKy = "";
	private float diemMieng = 0, diem15p= 0, diem1Tiet= 0, diemThi= 0;
	private float diemTBmon= 0;
	
	public void setDiemTBmon(float diemTB) {
		this.diemTBmon = diemTB;
	}


	/**
	 * @param monHoc
	 * @param hocSinh
	 * @param hocKy
	 * @param diemMieng
	 * @param diem15p
	 * @param diem1Tiet
	 * @param diemThi

	 */
	
	public DiemMon(String monHoc, String hocSinh, String hocKy, float diemMieng, float diem15p, float diem1Tiet,
			float diemThi) {
		
		this.monHoc = monHoc;
		this.hocSinh = hocSinh;
		this.hocKy = hocKy;
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
		this.monHoc = monHoc;
		this.hocSinh = hocSinh;
		this.hocKy = hocKy;
	}
	
	/**
	 * 
	 */
	public DiemMon() {
		super();
	}
	public String getMonHoc() {
		return monHoc;
	}
	public void setMonHoc(String monHoc) {
		this.monHoc = monHoc;
	}
	public String getHocSinh() {
		return hocSinh;
	}
	public void setHocSinh(String hocSinh) {
		this.hocSinh = hocSinh;
	}
	public String getHocKy() {
		return hocKy;
	}
	public void setHocKy(String hocKy) {
		this.hocKy = hocKy;
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
		
		diemTBmon =  (float) (this.diemMieng + this.diem15p + 2*this.diem1Tiet + 3*this.diemThi )/7;
//		diemTBmon = (float) 8.8;
		return diemTBmon;
	}
	@Override
	public String toString() {
		return "DiemMon [monHoc=" + monHoc + ", hocSinh=" + hocSinh + ", hocKy=" + hocKy + ", diemMieng=" + diemMieng
				+ ", diem15p=" + diem15p + ", diem1Tiet=" + diem1Tiet + ", diemThi=" + diemThi + ", diemTBmon="
				+ this.getDiemTBmon() + "]";
	}
	
	
	
	
	
	
	
	
	
}
