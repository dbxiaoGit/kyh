function testConfirm(){
    if(confirm("确认信息？")){
    	alert("true");
        return true;
    }else{
    	alert("false");
        return false;
    }

}
function missMemberCodeFangKuang(){
    if(confirm("确定将所有放款中的交易改为还款中状态吗？")){
    	window.location.href="/missMemberCodeFangKuang";
        return true;
    }else{
        return false;
    }

}
function missMemberCodeShouXin(){
    if(confirm("确定让所有申请中的用户通过吗？")){
    	window.location.href="/missMemberCodeShouXin";
        return true;
    }else{
        return false;
    }

}