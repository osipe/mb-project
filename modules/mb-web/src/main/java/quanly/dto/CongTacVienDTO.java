package quanly.dto;

import java.util.List;

public class CongTacVienDTO {
	private String so;
	private String maSo;
	private String hoTen;
	private String diaChi;
	private String vonTra;
	private String laiTra;
	private String tongTien;
	private String tongTienBangChu;
	private String duNoGoc;
	private String ngayThuTienTruoc;
	private String dinhMucTheChap;
	private String dinhMucTinChap;
	private String tongDinhMucDuNo;
	private List<PhatVayDTO> phatVayDTOs;
	private TongTienDTO tongTienDTO;
	private String ngay;
	private String thang;
	private String nam;

	public CongTacVienDTO(String so, String maSo, String hoTen, String diaChi, String vonTra, String laiTra,
			String tongTien, String tongTienBangChu, String duNoGoc, String ngayThuTienTruoc, String dinhMucTheChap,
			String dinhMucTinChap, String tongDinhMucDuNo, List<PhatVayDTO> phatVayDTOs, TongTienDTO tongTienDTO,
			String ngay, String thang, String nam) {
		super();
		this.so = so;
		this.maSo = maSo;
		this.hoTen = hoTen;
		this.diaChi = diaChi;
		this.vonTra = vonTra;
		this.laiTra = laiTra;
		this.tongTien = tongTien;
		this.tongTienBangChu = tongTienBangChu;
		this.duNoGoc = duNoGoc;
		this.ngayThuTienTruoc = ngayThuTienTruoc;
		this.dinhMucTheChap = dinhMucTheChap;
		this.dinhMucTinChap = dinhMucTinChap;
		this.tongDinhMucDuNo = tongDinhMucDuNo;
		this.phatVayDTOs = phatVayDTOs;
		this.tongTienDTO = tongTienDTO;
		this.ngay = ngay;
		this.thang = thang;
		this.nam = nam;
	}

	public String getNgay() {
		return ngay;
	}

	public void setNgay(String ngay) {
		this.ngay = ngay;
	}

	public String getThang() {
		return thang;
	}

	public void setThang(String thang) {
		this.thang = thang;
	}

	public String getNam() {
		return nam;
	}

	public void setNam(String nam) {
		this.nam = nam;
	}

	public TongTienDTO getTongTienDTO() {
		return tongTienDTO;
	}

	public void setTongTienDTO(TongTienDTO tongTienDTO) {
		this.tongTienDTO = tongTienDTO;
	}

	public String getDinhMucTheChap() {
		return dinhMucTheChap;
	}

	public void setDinhMucTheChap(String dinhMucTheChap) {
		this.dinhMucTheChap = dinhMucTheChap;
	}

	public String getDinhMucTinChap() {
		return dinhMucTinChap;
	}

	public void setDinhMucTinChap(String dinhMucTinChap) {
		this.dinhMucTinChap = dinhMucTinChap;
	}

	public String getTongDinhMucDuNo() {
		return tongDinhMucDuNo;
	}

	public void setTongDinhMucDuNo(String tongDinhMucDuNo) {
		this.tongDinhMucDuNo = tongDinhMucDuNo;
	}

	public List<PhatVayDTO> getPhatVayDTOs() {
		return phatVayDTOs;
	}

	public void setPhatVayDTOs(List<PhatVayDTO> phatVayDTOs) {
		this.phatVayDTOs = phatVayDTOs;
	}

	public String getNgayThuTienTruoc() {
		return ngayThuTienTruoc;
	}

	public void setNgayThuTienTruoc(String ngayThuTienTruoc) {
		this.ngayThuTienTruoc = ngayThuTienTruoc;
	}

	public String getSo() {
		return so;
	}

	public void setSo(String so) {
		this.so = so;
	}

	public String getMaSo() {
		return maSo;
	}

	public void setMaSo(String maSo) {
		this.maSo = maSo;
	}

	public String getHoTen() {
		return hoTen;
	}

	public void setHoTen(String hoTen) {
		this.hoTen = hoTen;
	}

	public String getDiaChi() {
		return diaChi;
	}

	public void setDiaChi(String diaChi) {
		this.diaChi = diaChi;
	}

	public String getVonTra() {
		return vonTra;
	}

	public void setVonTra(String vonTra) {
		this.vonTra = vonTra;
	}

	public String getLaiTra() {
		return laiTra;
	}

	public void setLaiTra(String laiTra) {
		this.laiTra = laiTra;
	}

	public String getTongTien() {
		return tongTien;
	}

	public void setTongTien(String tongTien) {
		this.tongTien = tongTien;
	}

	public String getTongTienBangChu() {
		return tongTienBangChu;
	}

	public void setTongTienBangChu(String tongTienBangChu) {
		this.tongTienBangChu = tongTienBangChu;
	}

	public String getDuNoGoc() {
		return duNoGoc;
	}

	public void setDuNoGoc(String duNoGoc) {
		this.duNoGoc = duNoGoc;
	}

}