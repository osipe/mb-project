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

function _formatMoney(e) {
	var value = $('#' + event.target.id).val();
	var valueMoney = "";
	console.log('value : ',value);
    if (value) {
    	//valueMoney = value.toString().replace(/\D/g, '');
    	valueMoney = value.toString().replace(/[,]/g, '');
    	if(parseFloat(valueMoney) > 0){
    		var valueMoneyNumber = value.toString().replace(/\D/g, '');
    		console.log('valueMoneyNumber : ',valueMoneyNumber);
    		$('#' + event.target.id).val(valueMoneyNumber.toString().replace(/\B(?=(\d{3})+(?!\d))/g, ","));
    	}else{
    		var valueMoneyNumber = value.toString().replace(/\D/g, '');
    		console.log('valueMoneyNumber : ',valueMoneyNumber);
    		$('#' + event.target.id).val("-" + valueMoneyNumber.toString().replace(/\B(?=(\d{3})+(?!\d))/g, ","));
    	}
    }
    
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
