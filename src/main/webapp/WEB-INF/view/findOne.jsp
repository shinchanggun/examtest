<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
    
<script>
function update(){
	var name=document.getElementById("upname").value
	var hp=document.getElementById("uphp").value
	var memo=document.getElementById("upmemo").value
	$.ajax({
		url:"/update?name="+name+"&hp="+hp+"&memo="+memo+"&idx="+${phonebook.idx},
		success:function(result){$("#list").html(result);}
	});
	document.querySelector("#bttt").value="수정하기";
}

  function del(){
	var name=document.getElementById("upname").value
	var hp=document.getElementById("uphp").value
	var memo=document.getElementById("upmemo").value
	$.ajax({
		url:"/delete?idx="+${phonebook.idx},
		success:function(result){$("#list").html(result);}
	});
	
	document.querySelector("#upname").value="";
	document.querySelector("#uphp").value="";
	document.querySelector("#upmemo").value="";
}  
</script>

<%-- <input hidden type="text" id="upidx" name="upidx" value="${phonebook.idx}"><br> --%>
<lable for="upname">이름 : </lable>
<input type="text" id="upname" name="upname" value="${phonebook.name}"><br>
<lable for="uphp">전화번호 : </lable>
<input type="text" id="uphp" name="uphp" value="${phonebook.hp}"><br>
<lable for="upmemo">메모 : </lable>
<input type="text" id="upmemo" name="upmemo" value="${phonebook.memo}"><br>

<input type="button" value="수정" id="bttt" onclick="update()">
<input type="button" value="삭제" id="btt" onclick="del()">

