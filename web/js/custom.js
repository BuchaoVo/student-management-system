var delf = document.getElementById("delfriend");

function deleteFriend(e) {
	var msg = "您确定要删除该记录吗？";   
	if (confirm(msg)==true){   
		e.returnValue =true;
	}else{ 
		e.returnValue =false;
	}   
}

//3. DOM监听器
//element.addEventListener('event', functionName, [, Boolean])
delf.addEventListener('click', function(e) { deleteFriend(e) }, false);