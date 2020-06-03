toastr.options.closeButton = true;
function _formatNumber(e) {
	$('#' + event.target.id).priceFormat({
		prefix : '',
		centsLimit : 0,
		centsSeparator : '.',
		thousandsSeparator : ',',
		clearOnEmpty : true
	});
}
function isNumber(e) {
	var event = (e) ? e : window.event;
	var charCode = (event.which) ? event.which : event.keyCode;
	if (charCode > 31 && (charCode < 48 || charCode > 57) && charCode != 46) {
		if(e){
			e.preventDefault();
		}
		return false;
	}else if(charCode == 46){
		if($('#' + event.target.id).val() == '' || $('#' + event.target.id).val().indexOf('.') > -1){
			e.preventDefault();
		}
	}
	return true;
}
Array.prototype.max = function() {
	return Math.max.apply(null, this);
};
