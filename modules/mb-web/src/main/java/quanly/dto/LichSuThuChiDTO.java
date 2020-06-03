package quanly.dto;

/**
 * @author Annn
 *
 */
public class LichSuThuChiDTO {
	private String ngayChungTu;
	private String ngayGhiSo;
	private String soHieu;
	private String soHieuPhieuThu;
	private String soHieuPhieuChi;
	private String dienGiai;
	private String taiKhoanDoiUng;
	private String soTienThu;
	private String soTienChi;
	private String soTienTon;
	public LichSuThuChiDTO(String ngayChungTu, String ngayGhiSo, String soHieu, String soHieuPhieuThu,
			String soHieuPhieuChi, String dienGiai, String taiKhoanDoiUng, String soTienThu, String soTienChi,
			String soTienTon) {
		super();
		this.ngayChungTu = ngayChungTu;
		this.ngayGhiSo = ngayGhiSo;
		this.soHieu = soHieu;
		this.soHieuPhieuThu = soHieuPhieuThu;
		this.soHieuPhieuChi = soHieuPhieuChi;
		this.dienGiai = dienGiai;
		this.taiKhoanDoiUng = taiKhoanDoiUng;
		this.soTienThu = soTienThu;
		this.soTienChi = soTienChi;
		this.soTienTon = soTienTon;
	}
	public String getNgayChungTu() {
		return ngayChungTu;
	}
	public void setNgayChungTu(String ngayChungTu) {
		this.ngayChungTu = ngayChungTu;
	}
	public String getNgayGhiSo() {
		return ngayGhiSo;
	}
	public void setNgayGhiSo(String ngayGhiSo) {
		this.ngayGhiSo = ngayGhiSo;
	}
	public String getSoHieu() {
		return soHieu;
	}
	public void setSoHieu(String soHieu) {
		this.soHieu = soHieu;
	}
	public String getSoHieuPhieuThu() {
		return soHieuPhieuThu;
	}
	public void setSoHieuPhieuThu(String soHieuPhieuThu) {
		this.soHieuPhieuThu = soHieuPhieuThu;
	}
	public String getSoHieuPhieuChi() {
		return soHieuPhieuChi;
	}
	public void setSoHieuPhieuChi(String soHieuPhieuChi) {
		this.soHieuPhieuChi = soHieuPhieuChi;
	}
	public String getDienGiai() {
		return dienGiai;
	}
	public void setDienGiai(String dienGiai) {
		this.dienGiai = dienGiai;
	}
	public String getTaiKhoanDoiUng() {
		return taiKhoanDoiUng;
	}
	public void setTaiKhoanDoiUng(String taiKhoanDoiUng) {
		this.taiKhoanDoiUng = taiKhoanDoiUng;
	}
	public String getSoTienThu() {
		return soTienThu;
	}
	public void setSoTienThu(String soTienThu) {
		this.soTienThu = soTienThu;
	}
	public String getSoTienChi() {
		return soTienChi;
	}
	public void setSoTienChi(String soTienChi) {
		this.soTienChi = soTienChi;
	}
	public String getSoTienTon() {
		return soTienTon;
	}
	public void setSoTienTon(String soTienTon) {
		this.soTienTon = soTienTon;
	}
	
}