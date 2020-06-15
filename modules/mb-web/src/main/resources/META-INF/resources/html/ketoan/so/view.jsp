<%@page import="com.liferay.portal.kernel.util.GetterUtil"%>
<%@page import="java.util.Date"%>
<%@page import="com.liferay.portal.kernel.portlet.LiferayWindowState"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.text.DecimalFormat"%>
<%@ include file="/html/ketoan/init.jsp"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
	Date now = new Date();
	int thang = GetterUtil.getInteger(new SimpleDateFormat("MM").format(now));
	int nam = GetterUtil.getInteger(new SimpleDateFormat("yyyy").format(now));
%>
<aui:form name="frm">
	<ul class="nav nav-tabs" id="myTab" role="tablist">
		<li class="nav-item">
			<a class="nav-link active" id="soCai-tab" data-toggle="tab" href="#<portlet:namespace />soCai" role="tab" aria-controls="<portlet:namespace />soCai" aria-selected="false">Sổ cái</a>
		</li>
		<li class="nav-item">
			<a class="nav-link" id="soDuNoCTV-tab" data-toggle="tab" href="#<portlet:namespace />soDuNoCTV" role="tab" aria-controls="<portlet:namespace />soDuNoCTV" aria-selected="false">Sổ dư nợ CTV</a>
		</li
		<li class="nav-item">
			<a class="nav-link" id="soQuyTienMat-tab" data-toggle="tab" href="#<portlet:namespace />soQuyTienMat" role="tab" aria-controls="<portlet:namespace />soQuyTienMat" aria-selected="false">Sổ quỷ tiền mặt</a>
		</li>		
	</ul>
	<div class="tab-content" id="myTabContent">
		<div class="tab-pane fade show active" id="<portlet:namespace />soCai" role="tabpanel" aria-labelledby="soCai-tab">
			<%@ include file="/html/ketoan/so/socai/view.jsp"%>
		</div>
		<div class="tab-pane" id="<portlet:namespace />soDuNoCTV" role="tabpanel" aria-labelledby="soDuNoCTV-tab">
			<%@ include file="/html/ketoan/so/soCTV/view.jsp"%>
		</div>
		<div class="tab-pane" id="<portlet:namespace />soQuyTienMat" role="tabpanel" aria-labelledby="soQuyTienMat-tab">
			<%@ include file="/html/ketoan/so/soquytienmat/view.jsp"%>
		</div>
	</div>
</aui:form>
<aui:script
	use="aui-base,aui-io-plugin-deprecated,aui-loading-mask-deprecated,node-event-simulate,liferay-util-list-fields,liferay-util-window,liferay-portlet-url">
AUI().ready(['aui-base'], function(A) {
	$('.input-date').datepicker();
	$('.input-date').mask('99/99/9999');
	$('.input-select2').select2({
		placeholder : 'Chọn',
		allowClear : true,
		language : {
			noResults : function() {
				return '';
			}
		}
	});
});
</aui:script>