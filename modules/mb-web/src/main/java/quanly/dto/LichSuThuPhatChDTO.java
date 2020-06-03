package quanly.dto;

/**
 * @author Annn
 *
 */
public class LichSuThuPhatChDTO {
	private String stt;
	private String ten;
	private String ngay;
	private String soTien;
	private String tienVon;
	private String tienLai;
	public LichSuThuPhatChDTO(String stt, String ten, String ngay, String soTien,String tienVon,String tienLai) {
		super();
		this.stt = stt;
		this.ten = ten;
		this.ngay = ngay;
		this.soTien = soTien;
		this.tienVon = tienVon;
		this.tienLai = tienLai;
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

	public String getSoTien() {
		return soTien;
	}

	public void setSoTien(String soTien) {
		this.soTien = soTien;
	}

}