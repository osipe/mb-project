
package quanly.util;

import com.liferay.portal.kernel.util.Validator;

public class DocSo {

	private static int ty = 1000000000;
	private static int trieu = 1000000;
	private static int ngan = 1000;
	private static int tram = 100;
	private static int muoi = 10;

	private static String _docSo(long soTien) {

		long temp = soTien;
		StringBuilder sb = new StringBuilder();

		docSoTy(sb, temp, soTien);
		temp = temp % ty;
		docSoTrieu(sb, temp, soTien);
		temp = temp % trieu;
		docSoNgan(sb, temp, soTien);
		temp = temp % ngan;
		docSoTram(sb, temp, soTien);
		temp = temp % tram;
		docSoChuc(sb, temp, soTien);

		return sb.toString();
	}

	public static String docSoBasic(long value) {

		String s = _docSo(value);

		s = s.trim();

		if (s.length() > 0) {
			String s1 = s.substring(0, 1);
			String s2 = s.substring(1);
			s = s1.toUpperCase() + s2;
		}
		return s;
	}
	public static String docSo(long soTien) {
		
		String s = _docSo(soTien);
		
		s = s.trim();
		
		if (s.length() > 0) {
			String s1 = s.substring(0, 1);
			String s2 = s.substring(1);
			s = s1.toUpperCase() + s2;
		}
		if (Validator.isNotNull(s)) {
			s += " \u0111\u1ED3ng";
		}
		return s;
	}

	private static void docSoChuc(StringBuilder sb, long temp, long soTienBanDau) {

		String tienStr = String.valueOf(temp);
		if (tienStr.length() == 2) {
			if (temp > 19) {
				sb.append(docSoDonVi((int) (temp / 10)));
				sb.append(" m\u01B0\u01A1i");
				if ((temp % 10) == 0) {
				}
				else if ((temp % 10) == 1) {
					sb.append(" m\u1ED1t");
				}
				else if ((temp % 10) == 5) {
					sb.append(" l\u0103m");
				}
				else {
					sb.append(docSoDonVi((int) (temp % 10)));
				}
			}
			else {
				sb.append(" m\u01B0\u1EDDi");
				if ((temp % 10) > 0) {
					if ((temp % 10) == 5) {
						sb.append(" l\u0103m");
					}
					else {
						sb.append(docSoDonVi((int) (temp % 10)));
					}
				}
			}
		}
		else if (temp > 0) {
			if (soTienBanDau > 99) {
				sb.append(" l\u1EBB");
			}
			sb.append(docSoDonVi((int) temp));
		}
	}

	private static void docSoTram(StringBuilder sb, long soTien, long soTienBanDau) {

		if ((soTienBanDau < tram) || (soTien == 0)) {
			return;
		}
		sb.append(docSoDonVi((int) soTien / tram));
		sb.append(" tr\u0103m");

	}

	private static void docSoNgan(StringBuilder sb, long soTien, long soTienBanDau) {

		if ((soTienBanDau < ngan) || (soTien == 0)) {
			return;
		}
		else if ((soTien / ngan) == 0) {
			sb.append(docSoDonVi(0));
		}
		else {
			sb.append(_docSo(soTien / ngan));
		}
		sb.append(" ng\u00E0n");
	}

	private static void docSoTrieu(StringBuilder sb, long soTien, long soTienBanDau) {

		if ((soTienBanDau < trieu) || (soTien == 0)) {
			return;
		}
		else if ((soTien / trieu) == 0) {
			sb.append(docSoDonVi(0));
		}
		else {
			sb.append(_docSo(soTien / trieu));
		}
		sb.append(" tri\u1EC7u");

	}

	private static void docSoTy(StringBuilder sb, long soTien, long soTienBanDau) {

		if ((soTienBanDau < ty) || (soTien == 0)) {
			return;
		}
		else if ((soTien / ty) == 0) {
			sb.append(docSoDonVi(0));
		}
		else {
			sb.append(_docSo(soTien / ty));
		}
		sb.append(" t\u1EF7");
	}

	private static String docSoDonVi(int so) {

		switch (so) {
		case 0:

			return " kh\u00F4ng";
		case 1:

			return " m\u1ED9t";
		case 2:

			return " hai";
		case 3:

			return " ba";
		case 4:

			return " b\u1ED1n";
		case 5:

			return " n\u0103m";
		case 6:

			return " s\u00E1u";
		case 7:

			return " b\u1EA3y";
		case 8:

			return " t\u00E1m";
		case 9:

			return " ch\u00EDn";

		default:
			return "";
		}
	}

}
