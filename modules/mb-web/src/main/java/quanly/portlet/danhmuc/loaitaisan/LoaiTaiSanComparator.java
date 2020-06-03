package quanly.portlet.danhmuc.loaitaisan;

import com.liferay.portal.kernel.util.OrderByComparator;

public class LoaiTaiSanComparator extends OrderByComparator {

	private static final long serialVersionUID = 1L;

	public static String ORDER_BY_ASC;

	public static String ORDER_BY_DESC;

	public static String[] ORDER_BY_FIELDS = { "ten" };

	private boolean _ascending;

	public LoaiTaiSanComparator() {
		this("createdate", false);
	}

	public LoaiTaiSanComparator(String field, boolean ascending) {
		ORDER_BY_ASC = field + " ASC";
		ORDER_BY_DESC = field + " DESC";
		_ascending = ascending;
	}

	@Override
	public int compare(Object obj1, Object obj2) {
		return 0;
	}

	@Override
	public String getOrderBy() {
		if (_ascending) {
			return ORDER_BY_ASC;
		} else {
			return ORDER_BY_DESC;
		}
	}

	@Override
	public String[] getOrderByFields() {
		return ORDER_BY_FIELDS;
	}

	@Override
	public boolean isAscending() {
		return _ascending;
	}

}