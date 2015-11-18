$.fn.serializeObject = function() {   
	var o = {};   
	var a = this.serializeArray();   
	$.each(a, function() {   
		if (o[this.name]) {   
			if (!o[this.name].push) {   
				o[this.name] = [ o[this.name] ];   
			}   
			o[this.name].push(this.value || '');   
		} else {   
			o[this.name] = this.value || '';   
		}   
	});   
	return o;   
};
/**
 * Check email format
 */
function emailCheck(obj, labelName) {
	var objName = eval("document.all." + obj);
	var pattern = /^([.a-zA-Z0-9_-])+@([a-zA-Z0-9_-])+(\.[a-zA-Z0-9_-])+/;
	if (!pattern.test(objName.value)) {
		alert("Please input the correct mail!");
		objName.focus();
		return false;
	}
	return true;
}