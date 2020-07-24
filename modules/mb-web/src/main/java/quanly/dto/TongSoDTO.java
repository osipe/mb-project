package quanly.dto;

/**
 * @author Annn
 *
 */
public class TongSoDTO {
	private String muc;
	private String ten;
	private String soHieu;
	private String soDauKy;
	private String soThu;
	private String soChi;
	private String soTon;
	public TongSoDTO(String muc, String ten, String soHieu, String soDauKy, String soThu, String soChi, String soTon) {
		super();
		this.muc = muc;
		this.ten = ten;
		this.soHieu = soHieu;
		this.soDauKy = soDauKy;
		this.soThu = soThu;
		this.soChi = soChi;
		this.soTon = soTon;
	}
	public String getMuc() {
		return muc;
	}
	public void setMuc(String muc) {
		this.muc = muc;
	}
	public String getTen() {
		return ten;
	}
	public void setTen(String ten) {
		this.ten = ten;
	}
	public String getSoHieu() {
		return soHieu;
	}
	public void setSoHieu(String soHieu) {
		this.soHieu = soHieu;
	}
	public String getSoDauKy() {
		return soDauKy;
	}
	public void setSoDauKy(String soDauKy) {
		this.soDauKy = soDauKy;
	}
	public String getSoThu() {
		return soThu;
	}
	public void setSoThu(String soThu) {
		this.soThu = soThu;
	}
	public String getSoChi() {
		return soChi;
	}
	public void setSoChi(String soChi) {
		this.soChi = soChi;
	}
	public String getSoTon() {
		return soTon;
	}
	public void setSoTon(String soTon) {
		this.soTon = soTon;
	}
	
	
}