package quanly.dto;

/**
 * @author Annn
 *
 */
public class LichSuThuPhatChDTO {
	private String stt;
	private String ten;
	private String ngay;
	// Chi phát vay
	private String tienChi;
	// thuVon
	private String tienVon;
	// thuLai
	private String tienLai;
	// TongThu
	private String tongThu;
	// Loai 1 : phát vay - 2 tất toán - 3 thu hằng ngày - 4 thu trước
	private int loai;

	public LichSuThuPhatChDTO(String stt, String ten, String ngay, String tienChi, String tienVon, String tienLai,
			String tongThu, int loai) {
		super();
		this.stt = stt;
		this.ten = ten;
		this.ngay = ngay;
		this.tienChi = tienChi;
		this.tienVon = tienVon;
		this.tienLai = tienLai;
		this.tongThu = tongThu;
		this.loai = loai;
	}

	public int getLoai() {
		return loai;
	}

	public void setLoai(int loai) {
		this.loai = loai;
	}

	public String getTienChi() {
		return tienChi;
	}

	public void setTienChi(String tienChi) {
		this.tienChi = tienChi;
	}

	public String getTongThu() {
		return tongThu;
	}

	public void setTongThu(String tongThu) {
		this.tongThu = tongThu;
	}

	public String getTienVon() {
		return tienVon;
	}

	public void setTienVon(String tienVon) {
		this.tienVon = tienVon;
	}

	public String getTienLai() {
		return tienLai;
	}

	public void setTienLai(String tienLai) {
		this.tienLai = tienLai;
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

	public String getNgay() {
		return ngay;
	}

	public void setNgay(String ngay) {
		this.ngay = ngay;
	}

}