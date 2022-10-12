package model;

import java.io.Serializable;
import java.sql.Date;
import java.sql.Statement;

import java.util.Objects;

public class HocSinh {
	private String maHS, hoTen, maLop;
	private Date ngaySinh;
	private String gioiTinh,sdt_LienLac, danToc, noiSinh, diaChi, 
	 hoten_PhuHuynh, ngheNnghiep, chuongTrinhTieuHoc;
	

	


	/**
	 * @param maHS
	 */
	public HocSinh(String maHS) {
		super();
		this.maHS = maHS;
	}



	/**
	 * @param maHS
	 * @param hoTen
	 * @param ngaySinh
	 * @param gioiTinh
	 * @param sdt_LienLac
	 * @param danToc
	 * @param noiSinh
	 * @param diaChi
	 * @param hoten_PhuHuynh
	 * @param ngheNnghiep
	 * @param chuongTrinhTieuHoc


	/**
	 * 
	 */
	public HocSinh() {
		super();
	}



	/**
	 * @param maHS
	 * @param hoTen
	 * @param maLop
	 * @param ngaySinh
	 * @param gioiTinh
	 * @param sdt_LienLac
	 * @param danToc
	 * @param noiSinh
	 * @param diaChi
	 * @param hoten_PhuHuynh
	 * @param ngheNnghiep
	 * @param chuongTrinhTieuHoc
	 */
	public HocSinh(String maHS, String hoTen, String maLop, Date ngaySinh, String gioiTinh, String sdt_LienLac,
			String danToc, String noiSinh, String diaChi, String hoten_PhuHuynh, String ngheNnghiep,
			String chuongTrinhTieuHoc) {
		super();
		this.maHS = maHS;
		this.hoTen = hoTen;
		this.maLop = maLop;
		this.ngaySinh = ngaySinh;
		this.gioiTinh = gioiTinh;
		this.sdt_LienLac = sdt_LienLac;
		this.danToc = danToc;
		this.noiSinh = noiSinh;
		this.diaChi = diaChi;
		this.hoten_PhuHuynh = hoten_PhuHuynh;
		this.ngheNnghiep = ngheNnghiep;
		this.chuongTrinhTieuHoc = chuongTrinhTieuHoc;
	}



	public String getHoTen() {
		return hoTen;
	}

	public void setHoTen(String hoTen) {
		this.hoTen = hoTen;
	}

	public String getGioiTinh() {
		return gioiTinh;
	}

	public void setGioiTinh(String gioiTinh) {
		this.gioiTinh = gioiTinh;
	}

	public String getDanToc() {
		return danToc;
	}

	public String getMaHS() {
		return maHS;
	}

	public void setMaHS(String maHS) {
		this.maHS = maHS;
	}



	public void setDanToc(String danToc) {
		this.danToc = danToc;
	}

	public String getNoiSinh() {
		return noiSinh;
	}

	public void setNoiSinh(String noiSinh) {
		this.noiSinh = noiSinh;
	}

	public String getDiaChi() {
		return diaChi;
	}

	public void setDiaChi(String diaChi) {
		this.diaChi = diaChi;
	}

	public String getSdt_LienLac() {
		return sdt_LienLac;
	}

	public void setSdt_LienLac(String sdt_LienLac) {
		this.sdt_LienLac = sdt_LienLac;
	}

	public String getHoten_PhuHuynh() {
		return hoten_PhuHuynh;
	}

	public void setHoten_PhuHuynh(String hoten_PhuHuynh) {
		this.hoten_PhuHuynh = hoten_PhuHuynh;
	}

	public String getNgheNnghiep() {
		return ngheNnghiep;
	}

	public void setNgheNnghiep(String ngheNnghiep) {
		this.ngheNnghiep = ngheNnghiep;
	}

	public String getChuongTrinhTieuHoc() {
		return chuongTrinhTieuHoc;
	}

	public void setChuongTrinhTieuHoc(String chuongTrinhTieuHoc) {
		this.chuongTrinhTieuHoc = chuongTrinhTieuHoc;
	}

	public Date getNgaySinh() {
		return ngaySinh;
	}

	public void setNgaySinh(Date ngaySinh) {
		this.ngaySinh = ngaySinh;
	}



	public String getMaLop() {
		return maLop;
	}



	public void setMaLop(String maLop) {
		this.maLop = maLop;
	}



	@Override
	public String toString() {
		return "HocSinh [maHS=" + maHS + ", hoTen=" + hoTen + ", maLop=" + maLop + ", ngaySinh=" + ngaySinh
				+ ", gioiTinh=" + gioiTinh + ", sdt_LienLac=" + sdt_LienLac + ", danToc=" + danToc + ", noiSinh="
				+ noiSinh + ", diaChi=" + diaChi + ", hoten_PhuHuynh=" + hoten_PhuHuynh + ", ngheNnghiep=" + ngheNnghiep
				+ ", chuongTrinhTieuHoc=" + chuongTrinhTieuHoc + "]";
	}


//
	
	
}
