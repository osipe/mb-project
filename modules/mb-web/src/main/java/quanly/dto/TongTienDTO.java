package quanly.dto;

/**
 * @author Annn
 *
 */
public class TongTienDTO {
	private String tongTienVay;
	private String tongGocNgay;
	private String tongLaiNgay;
	private String tongGocDaThu;
	private String tongLaiDaThu;
	private String tongDuNoGoc;

	public TongTienDTO(String tongTienVay, String tongGocNgay, String tongLaiNgay, String tongGocDaThu,
			String tongLaiDaThu, String tongDuNoGoc) {
		super();
		this.tongTienVay = tongTienVay;
		this.tongGocNgay = tongGocNgay;
		this.tongLaiNgay = tongLaiNgay;
		this.tongGocDaThu = tongGocDaThu;
		this.tongLaiDaThu = tongLaiDaThu;
		this.tongDuNoGoc = tongDuNoGoc;
	}

	public String getTongTienVay() {
		return tongTienVay;
	}

	public void setTongTienVay(String tongTienVay) {
		this.tongTienVay = tongTienVay;
	}

	public String getTongGocNgay() {
		return tongGocNgay;
	}

	public void setTongGocNgay(String tongGocNgay) {
		this.tongGocNgay = tongGocNgay;
	}

	public String getTongLaiNgay() {
		return tongLaiNgay;
	}

	public void setTongLaiNgay(String tongLaiNgay) {
		this.tongLaiNgay = tongLaiNgay;
	}

	public String getTongGocDaThu() {
		return tongGocDaThu;
	}

	public void setTongGocDaThu(String tongGocDaThu) {
		this.tongGocDaThu = tongGocDaThu;
	}

	public String getTongLaiDaThu() {
		return tongLaiDaThu;
	}

	public void setTongLaiDaThu(String tongLaiDaThu) {
		this.tongLaiDaThu = tongLaiDaThu;
	}

	public String getTongDuNoGoc() {
		return tongDuNoGoc;
	}

	public void setTongDuNoGoc(String tongDuNoGoc) {
		this.tongDuNoGoc = tongDuNoGoc;
	}

}