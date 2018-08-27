var sever_addr = "http://localhost:8080";
var dict_article= 1;


function route(url){
	$("#content").load(url);
}

function radioVal(name){
	return $("input[name='"+name+"']:checked").val();
}

function radioChecked(name,value){
	$(":radio[name='"+name+"'][value='"+value+"']").prop("checked", "checked");
}

function parseMills(value){
	var date = value.replace(new RegExp("-","gm"),"/");
    return (new Date(date)).getTime();
}

function resultHandler(data){
	if(data.code != 200){
		toastr.error(data.msg);
		return false;
	}else{
		toastr.success("操作成功！");
		return true;
	}
}

