window.onload=function () {
    // 1.给表单绑定onsubmit事件
    document.getElementById("form").onsubmit=function () {
        //调用用户名校验方法  checkUsername（）
        //return checkUsername() &&checkPassword();
        //调用密码校验方法  checkPassword（）
        var flag = checkUsername() && checkPassword() && checkEmail() &&checkTel() && checkRepassword();
        if(flag) {
            return true;
        }else {
            alert("请检查你的表单是否填写正确！")
            return false;
        }
    }
    //添加失去焦点事件
    document.getElementById("username").onblur = checkUsername;
    document.getElementById("password").onblur=checkPassword;
    document.getElementById("email").onblur=checkEmail;
    document.getElementById("phoneid").onblur=checkTel;
    document.getElementById("repassword").onblur=checkRepassword;
}

function reg(){
    if(!confirm("确认注册吗？")){
        window.event.returnValue = false;
    }
}

//验证用户名（为3~16个字符，且不能包含”@”和”#”字符）
function checkUsername(){
    var name=document.getElementById("username").value.trim();
    var nameRegex=/^[^@#]{2,16}$/;
    if(!nameRegex.test(name)){
        document.getElementById("userErr").innerHTML="用户名为2~16个字符，且不能包含”@”和”#”字符";

        return false;
    }else{
        document.getElementById("userErr").innerHTML="";
        return true;
    }

}
//验证密码（长度在8个字符到16个字符）
function checkPassword(){
    var password=document.getElementById("password").value;
    var passwordRegex=/^[0-9A-Za-z_]\w{7,15}$/;
    if(!passwordRegex.test(password)){
        document.getElementById("pwdErr").innerHTML="密码长度必须在8个字符到16个字符之间";
        return false;
    }else{
        document.getElementById("pwdErr").innerHTML="";
        return true;
    }
}

//验证校验密码（和上面密码必须一致）
function checkRepassword(){
    var repassword=document.getElementById("repassword").value;
    var password=document.getElementById("password").value;
    //校验密码和上面密码必须一致
    if(repassword!==password){
        document.getElementById("repwdErr").innerHTML="两次输入的密码不一致";
        return false;
    }else if(repassword==password){
        document.getElementById("repwdErr").innerHTML="";
        return true;
    }
}
//校验邮箱
function checkEmail() {
    //1.获取邮箱的值
    var email = document.getElementById('email').value;
    //2.定义正则表达式
    var reg_email=/^\w+@[a-z0-9]+\.[a-z]{2,4}$/;
    //3.判断值是否符合正则的规则
    if(!reg_email.test(email)) {
        document.getElementById("emailErr").innerHTML="请输入正确的邮箱格式";
        return false;
    }
    else{
        document.getElementById("emailErr").innerHTML="";
        return true;
    }
}
//校验手机号
function checkTel() {
    //1.获取手机号的值
    var tel = document.getElementById('phoneid').value;
    //2.定义正则表达式
    var reg_tel=/^(((13[0-9]{1})|(15[0-9]{1})|(18[0-9]{1}))+\d{8})$/;
    //3.判断值是否符合正则的规则
    if(!reg_tel.test(tel)) {
        document.getElementById("phoneErr").innerHTML="请输入正确的电话格式";
        return false;
    }
    else{
        document.getElementById("phoneErr").innerHTML="";
        return true;
    }
}