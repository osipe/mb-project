package quanly.portlet.phatvay.phatvay;

import java.util.List;

import javax.portlet.PortletResponse;

import com.liferay.portal.kernel.dao.search.RowChecker;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.util.ListUtil;
import com.liferay.portal.kernel.util.Validator;
import com.mb.model.PhatVay;

public class PhatVayChecker extends RowChecker {
	public PhatVayChecker(PortletResponse portletResponse) {
		super(portletResponse);
	}

	public PhatVayChecker(PortletResponse portletResponse, String[] array) {
		super(portletResponse);
		this.array = array;
	}

	@Override
	public boolean isChecked(Object obj) {
		PhatVay entry = (PhatVay) obj;
		try {
			List<String> items = ListUtil.fromArray(array);
			return items.contains(String.valueOf(entry.getPhatVayId()));
		} catch (Exception e) {
			_log.error(e, e);
			return false;
		}
	}

	@Override
	public String getAllRowsCheckBox() {
		if (Validator.isNull(getAllRowIds())) {
			return "";
		} else {
			StringBuilder sb = new StringBuilder();
			sb.append("<input id=\"");
			sb.append(getAllRowIds());
			sb.append("\" name=\"");
			sb.append(getAllRowIds());
			sb.append("\" type=\"checkbox\" ");
			sb.append("onClick=\"Liferay.Util.checkAll(");
			sb.append("AUI().one(this).ancestor('");
			sb.append("table.taglib-search-iterator'), '");
			sb.append(getRowIds());
			sb.append("', this, '.results-row'");
			sb.append(");\">");
			return sb.toString();
		}
	}

	private String[] array;
	private static Log _log = LogFactoryUtil.getLog(PhatVay.class);
}
