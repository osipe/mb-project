/**
 * 
 */

package quanly.constants;

public enum TrangThaiPhatVayEnum {
	TAT_CA(0), CHUA_THANH_TOAN(1), DA_THANH_TOAN(2), DA_TAT_TOAN(3),CO_THU_TIEN_TRUOC(4);
	private int value;

	private TrangThaiPhatVayEnum(int value) {
		this.value = value;
	}

	public int getValue() {
		return value;
	}

}
