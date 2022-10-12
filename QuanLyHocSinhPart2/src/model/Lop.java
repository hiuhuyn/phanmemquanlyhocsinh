package model;

import java.util.ArrayList;
import java.util.Objects;

public class Lop {
	private String maLop;
	private String tenLop;
	private int siSo;

	
	
	
	/**
	 * @param maLop
	 */
	public Lop(String maLop) {
		super();
		this.maLop = maLop;
	}
	/**
	 * 
	 */
	public Lop() {
		super();
	}
	/**
	 * @param maLop
	 * @param tenLop
	 * @param siSo
	 */
	public Lop(String maLop, String tenLop, int siSo) {
		super();
		this.maLop = maLop;
		this.tenLop = tenLop;
		this.siSo = siSo;
	}

	public String getMaLop() {
		return maLop;
	}
	public void setMaLop(String maLop) {
		this.maLop = maLop;
	}
	public String getTenLop() {
		return tenLop;
	}
	public void setTenLop(String tenLop) {
		this.tenLop = tenLop;
	}
	public int getSiSo() {
		return siSo;
	}
	public void setSiSo(int siSo) {
		this.siSo = siSo;
	}

	@Override
	public String toString() {
		return "Lop [maLop=" + maLop + ", tenLop=" + tenLop + ", siSo=" + siSo + "]";
	}
	@Override
	public int hashCode() {
		return Objects.hash(maLop, siSo, tenLop);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Lop other = (Lop) obj;
		return Objects.equals(maLop, other.maLop) && siSo == other.siSo && Objects.equals(tenLop, other.tenLop);
	}	
	
	
	
}
