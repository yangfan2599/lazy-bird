var CONST_EMPTY = "empty";
var CONST_PWD = "password";
var CONST_EMAIL = "email";
var CONST_LGTH6 = "length6";
var CONST_LGTH8 = "length8";

var MSG_EMPTY = "<p class='validator'><i class='icon-remove-sign'></i>不能为空！</p>";
var MSG_PWD = "<p class='validator'><i class='icon-remove-sign'></i>密码不能小于6位，数字与字母组合！</p>";
var MSG_EMAIL = "<p class='validator'><i class='icon-remove-sign'></i>邮箱格式不正确！</p>";

function validator(...args){
	$("p").remove(".validator");
	var result = false;
	for( x in args){  
        var element = $("#"+args[x]).attr('data-valid');
        switch(element) {
	        case CONST_EMPTY:
	        	if($("#"+args[x]).val() == ''){
	        		$("#"+args[x]).after(MSG_EMPTY);
	        		result = true;
	        	}
	          break;
	        case CONST_EMAIL:
	        	if(validEmail($("#"+args[x]).val()) == false){
	        		$("#"+args[x]).after(MSG_EMAIL);
	        		result = true;
	        	}
		        break;
		        
	        default:
        }
        
    }
	
	return result;
}

function validEmail(email){
	var reg = /^([\.a-zA-Z0-9_-])+@([a-zA-Z0-9_-])+(\.[a-zA-Z0-9_-])+/;
	//不合法
	if(!reg.test(email)){
        return false;
    }
	return true;
}