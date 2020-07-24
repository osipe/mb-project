package quanly.dto;

import java.util.List;

/**
 * @author Annn
 *
 */
public class SaoKeChiTietDTO {
	private String hoTen;
	private String maSo;
	private String tongDinhMucDuNo;
	private String dinhMucTinChap;
	private String dinhMucTheChap;

	private String soTienTinChap;
	private String gocNgayTinChap;
	private String laiNgayTinChap;
	private String gocDaThuTinChap;
	private String laiDaThuTinChap;
	private String duNoGocTinChap;

	private String soTienTheChap;
	private String gocNgayTheChap;
	private String laiNgayTheChap;
	private String gocDaThuTheChap;
	private String laiDaThuTheChap;
	private String duNoGocTheChap;

	private List<PhatVayDTO> phatVayTinChaps;
	private List<PhatVayDTO> phatVayTheChaps;
	private TongTienDTO tongTienDTO;
	private boolean coTinChap;
	private boolean coTheChap;

	public SaoKeChiTietDTO(String hoTen, String maSo, String tongDinhMucDuNo, String dinhMucTinChap,
			String dinhMucTheChap, String soTienTinChap, String gocNgayTinChap, String laiNgayTinChap,
			String gocDaThuTinChap, String laiDaThuTinChap, String duNoGocTinChap, String soTienTheChap,
			String gocNgayTheChap, String laiNgayTheChap, String gocDaThuTheChap, String laiDaThuTheChap,
			String duNoGocTheChap, List<PhatVayDTO> phatVayTinChaps, List<PhatVayDTO> phatVayTheChaps,
			TongTienDTO tongTienDTO, boolean coTinChap, boolean coTheChap) {
		super();
		this.hoTen = hoTen;
		this.maSo = maSo;
		this.tongDinhMucDuNo = tongDinhMucDuNo;
		this.dinhMucTinChap = dinhMucTinChap;
		this.dinhMucTheChap = dinhMucTheChap;
		this.soTienTinChap = soTienTinChap;
		this.gocNgayTinChap = gocNgayTinChap;
		this.laiNgayTinChap = laiNgayTinChap;
		this.gocDaThuTinChap = gocDaThuTinChap;
		this.laiDaThuTinChap = laiDaThuTinChap;
		this.duNoGocTinChap = duNoGocTinChap;
		this.soTienTheChap = soTienTheChap;
		this.gocNgayTheChap = gocNgayTheChap;
		this.laiNgayTheChap = laiNgayTheChap;
		this.gocDaThuTheChap = gocDaThuTheChap;
		this.laiDaThuTheChap = laiDaThuTheChap;
		this.duNoGocTheChap = duNoGocTheChap;
		this.phatVayTinChaps = phatVayTinChaps;
		this.phatVayTheChaps = phatVayTheChaps;
		this.tongTienDTO = tongTienDTO;
		this.coTinChap = coTinChap;
		this.coTheChap = coTheChap;
	}

	public TongTienDTO getTongTienDTO() {
		return tongTienDTO;
	}

	public void setTongTienDTO(TongTienDTO tongTienDTO) {
		this.tongTienDTO = tongTienDTO;
	}

	public boolean isCoTinChap() {
		return coTinChap;
	}

	public void setCoTinChap(boolean coTinChap) {
		this.coTinChap = coTinChap;
	}

	public boolean isCoTheChap() {
		return coTheChap;
	}

	public void setCoTheChap(boolean coTheChap) {
		this.coTheChap = coTheChap;
	}

	public List<PhatVayDTO> getPhatVayTinChaps() {
		return phatVayTinChaps;
	}

	public void setPhatVayTinChaps(List<PhatVayDTO> phatVayTinChaps) {
		this.phatVayTinChaps = phatVayTinChaps;
	}

	public List<PhatVayDTO> getPhatVayTheChaps() {
		return phatVayTheChaps;
	}

	public void setPhatVayTheChaps(List<PhatVayDTO> phatVayTheChaps) {
		this.phatVayTheChaps = phatVayTheChaps;
	}

	public String getHoTen() {
		return hoTen;
	}

	public void setHoTen(String hoTen) {
		this.hoTen = hoTen;
	}

	public String getMaSo() {
		return maSo;
	}

	public void setMaSo(String maSo) {
		this.maSo = maSo;
	}

	public String getTongDinhMucDuNo() {
		return tongDinhMucDuNo;
	}

	public void setTongDinhMucDuNo(String tongDinhMucDuNo) {
		this.tongDinhMucDuNo = tongDinhMucDuNo;
	}

	public String getDinhMucTinChap() {
		return dinhMucTinChap;
	}

	public void setDinhMucTinChap(String dinhMucTinChap) {
		this.dinhMucTinChap = dinhMucTinChap;
	}

	public String getDinhMucTheChap() {
		return dinhMucTheChap;
	}

	public void setDinhMucTheChap(String dinhMucTheChap) {
		this.dinhMucTheChap = dinhMucTheChap;
	}

	public String getSoTienTinChap() {
		return soTienTinChap;
	}

	public void setSoTienTinChap(String soTienTinChap) {
		this.soTienTinChap = soTienTinChap;
	}

	public String getGocNgayTinChap() {
		return gocNgayTinChap;
	}

	public void setGocNgayTinChap(String gocNgayTinChap) {
		this.gocNgayTinChap = gocNgayTinChap;
	}

	public String getLaiNgayTinChap() {
		return laiNgayTinChap;
	}

	public void setLaiNgayTinChap(String laiNgayTinChap) {
		this.laiNgayTinChap = laiNgayTinChap;
	}

	public String getGocDaThuTinChap() {
		return gocDaThuTinChap;
	}

	public void setGocDaThuTinChap(String gocDaThuTinChap) {
		this.gocDaThuTinChap = gocDaThuTinChap;
	}

	public String getLaiDaThuTinChap() {
		return laiDaThuTinChap;
	}

	public void setLaiDaThuTinChap(String laiDaThuTinChap) {
		this.laiDaThuTinChap = laiDaThuTinChap;
	}

	public String getDuNoGocTinChap() {
		return duNoGocTinChap;
	}

	public void setDuNoGocTinChap(String duNoGocTinChap) {
		this.duNoGocTinChap = duNoGocTinChap;
	}

	public String getSoTienTheChap() {
		return soTienTheChap;
	}

	public void setSoTienTheChap(String soTienTheChap) {
		this.soTienTheChap = soTienTheChap;
	}

	public String getGocNgayTheChap() {
		return gocNgayTheChap;
	}

	public void setGocNgayTheChap(String gocNgayTheChap) {
		this.gocNgayTheChap = gocNgayTheChap;
	}

	public String getLaiNgayTheChap() {
		return laiNgayTheChap;
	}

	public void setLaiNgayTheChap(String laiNgayTheChap) {
		this.laiNgayTheChap = laiNgayTheChap;
	}

	public String getGocDaThuTheChap() {
		return gocDaThuTheChap;
	}

	public void setGocDaThuTheChap(String gocDaThuTheChap) {
		this.gocDaThuTheChap = gocDaThuTheChap;
	}

	public String getLaiDaThuTheChap() {
		return laiDaThuTheChap;
	}

	public void setLaiDaThuTheChap(String laiDaThuTheChap) {
		this.laiDaThuTheChap = laiDaThuTheChap;
	}

	public String getDuNoGocTheChap() {
		return duNoGocTheChap;
	}

	public void setDuNoGocTheChap(String duNoGocTheChap) {
		this.duNoGocTheChap = duNoGocTheChap;
	}

}