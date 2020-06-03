
package quanly.util;

import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.OutputStream;
import java.util.Collection;
import java.util.Map;

import com.liferay.portal.kernel.exception.PortalException;

import net.sf.jasperreports.engine.JRDataSource;
import net.sf.jasperreports.engine.JREmptyDataSource;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JRExporter;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import net.sf.jasperreports.engine.export.JRCsvExporter;
import net.sf.jasperreports.engine.export.JRHtmlExporter;
import net.sf.jasperreports.engine.export.JRHtmlExporterParameter;
import net.sf.jasperreports.engine.export.JRPdfExporter;
import net.sf.jasperreports.engine.export.JRRtfExporter;
import net.sf.jasperreports.engine.export.JRTextExporter;
import net.sf.jasperreports.engine.export.JRXlsExporter;
import net.sf.jasperreports.engine.export.JRXlsExporterParameter;
import net.sf.jasperreports.engine.export.JRXmlExporter;
import net.sf.jasperreports.engine.export.oasis.JROdsExporter;
import net.sf.jasperreports.engine.export.oasis.JROdtExporter;
import net.sf.jasperreports.engine.export.ooxml.JRDocxExporter;
import net.sf.jasperreports.engine.export.ooxml.JRPptxExporter;
import net.sf.jasperreports.engine.export.ooxml.JRXlsxExporter;
import net.sf.jasperreports.engine.util.ContextClassLoaderObjectInputStream;
import quanly.constants.FileType;

public class JasperReportUtil {
	public static void exportReport(InputStream inStream, OutputStream outStream, Map<String, Object> parameters,
			Collection<Object> dataSource, String type) throws PortalException {

		try {
			JRDataSource ds = (JRDataSource) createJRDataSource(dataSource);
			Object obj = null;

			ObjectInputStream ois = null;

			try {
				ois = new ContextClassLoaderObjectInputStream(inStream);
				obj = ois.readObject();
			} catch (IOException e) {
				throw new JRException("Error loading object from InputStream", e);
			} catch (ClassNotFoundException e) {
				throw new JRException("Class not found when loading object from InputStream", e);
			}
			JasperReport jasperReport = (JasperReport) obj;
			jasperReport.setProperty("net.sf.jasperreports.xpath.executer.factory",
					"net.sf.jasperreports.engine.util.xml.JaxenXPathExecuterFactory");
			JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, parameters, ds);
			export(jasperPrint, type, outStream);

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static Object createJRDataSource(Collection<Object> data) {

		return data != null && data.size() > 0 ? new JRBeanCollectionDataSource(data) : new JREmptyDataSource();
	}

	private static void export(JasperPrint jasperPrint, String type, OutputStream outStream)
			throws JRException, IOException {

		JRExporter exporter;
		if (type.equals(FileType.XML)) {
			exporter = new JRXmlExporter();
		} else if (type.equals(FileType.CSV)) {
			exporter = new JRCsvExporter();
		} else if (type.equals(FileType.PDF)) {
			exporter = new JRPdfExporter();
		} else if (type.equals(FileType.ODT)) {
			exporter = new JROdtExporter();
		} else if (type.equals(FileType.ODS)) {
			exporter = new JROdsExporter();
		} else if (type.equals(FileType.TXT)) {
			exporter = new JRTextExporter();
		} else if (type.equals(FileType.DOCX)) {
			exporter = new JRDocxExporter();
		} else if (type.equals(FileType.XLS)) {
			exporter = new JRXlsExporter();
			exporter.setParameter(JRXlsExporterParameter.IS_ONE_PAGE_PER_SHEET, Boolean.FALSE);
			exporter.setParameter(JRXlsExporterParameter.IS_DETECT_CELL_TYPE, Boolean.TRUE);
			exporter.setParameter(JRXlsExporterParameter.IS_WHITE_PAGE_BACKGROUND, Boolean.FALSE);
			exporter.setParameter(JRXlsExporterParameter.IS_REMOVE_EMPTY_SPACE_BETWEEN_ROWS, Boolean.TRUE);
		} else if (type.equals(FileType.XLSX)) {
			exporter = new JRXlsxExporter();
			exporter.setParameter(JRXlsExporterParameter.IS_ONE_PAGE_PER_SHEET, Boolean.FALSE);
			exporter.setParameter(JRXlsExporterParameter.IS_DETECT_CELL_TYPE, Boolean.TRUE);
			exporter.setParameter(JRXlsExporterParameter.IS_WHITE_PAGE_BACKGROUND, Boolean.FALSE);
			exporter.setParameter(JRXlsExporterParameter.IS_REMOVE_EMPTY_SPACE_BETWEEN_ROWS, Boolean.TRUE);
		} else if (type.equals(FileType.PPTX)) {
			exporter = new JRPptxExporter();

		} else if (type.equals(FileType.RTF) || type.equals(FileType.DOC)) {
			exporter = new JRRtfExporter();

		} else {
			exporter = new JRHtmlExporter();
		}
		exporter.setParameter(JRHtmlExporterParameter.JASPER_PRINT, jasperPrint);
		exporter.setParameter(JRHtmlExporterParameter.OUTPUT_STREAM, outStream);
		exporter.exportReport();
		outStream.flush();
	}
}
