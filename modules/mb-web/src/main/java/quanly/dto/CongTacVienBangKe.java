package quanly.dto;

import java.util.List;

/**
 * @author Annn
 *
 */
public class CongTacVienBangKe {
	private String ten;
	private String ma;
	private String soThue;
	private String tongVon;
	private String tongLai;
	private String tongThue;
	private List<BangKeDTO> bks;
	
	public CongTacVienBangKe() {
		super();
	}




	public CongTacVienBangKe(String ten, String ma, String soThue, String tongVon, String tongLai, String tongThue,
			List<BangKeDTO> bangKes) {
		super();
		this.ten = ten;
		this.ma = ma;
		this.soThue = soThue;
		this.tongVon = tongVon;
		this.tongLai = tongLai;
		this.tongThue = tongThue;
		this.bks = bangKes;
	}




	public String getSoThue() {
		return soThue;
	}



	public void setSoThue(String soThue) {
		this.soThue = soThue;
	}

	public List<BangKeDTO> getBks() {
		return bks;
	}




	public void setBks(List<BangKeDTO> bks) {
		this.bks = bks;
	}




	public String getTen() {
		return ten;
	}

	public void setTen(String ten) {
		this.ten = ten;
	}

	public String getMa() {
		return ma;
	}

	public void setMa(String ma) {
		this.ma = ma;
	}

	public String getTongVon() {
		return tongVon;
	}

	public void setTongVon(String tongVon) {
		this.tongVon = tongVon;
	}

	public String getTongLai() {
		return tongLai;
	}

	public void setTongLai(String tongLai) {
		this.tongLai = tongLai;
	}

	public String getTongThue() {
		return tongThue;
	}

	public void setTongThue(String tongThue) {
		this.tongThue = tongThue;
	}

}