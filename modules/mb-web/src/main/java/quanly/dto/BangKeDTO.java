package quanly.dto;

/**
 * @author Annn
 *
 */
public class BangKeDTO {
	private String stt;
	private String ten;
	private String thuVon;
	private String thuLai;
	private String thue;
	private String ghiChu;
	
	
	public BangKeDTO(String stt, String ten, String thuVon, String thuLai, String thue, String ghiChu) {
		super();
		this.stt = stt;
		this.ten = ten;
		this.thuVon = thuVon;
		this.thuLai = thuLai;
		this.thue = thue;
		this.ghiChu = ghiChu;
	}
	public String getStt() {
		return stt;
	}
	public void setStt(String stt) {
		this.stt = stt;
	}
	
	public String getTen() {
		return ten;
	}
	public void setTen(String ten) {
		this.ten = ten;
	}
	public String getThuVon() {
		return thuVon;
	}
	public void setThuVon(String thuVon) {
		this.thuVon = thuVon;
	}
	public String getThuLai() {
		return thuLai;
	}
	public void setThuLai(String thuLai) {
		this.thuLai = thuLai;
	}
	public String getThue() {
		return thue;
	}
	public void setThue(String thue) {
		this.thue = thue;
	}
	public String getGhiChu() {
		return ghiChu;
	}
	public void setGhiChu(String ghiChu) {
		this.ghiChu = ghiChu;
	}


}