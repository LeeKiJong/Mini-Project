$(function () {
  $(".btn-login").on("click", function () {
    let userid = $("#userid").val();
    let password = $("#password").val();
    
    if (!userid || !password) {
      alert("모두 입력해주세요.");
      return;
    }

    let data = JSON.parse(localStorage.getItem("users"));

    if (data === null) {
      alert("아이디 또는 비밀번호를 확인해주세요.");
      return;
    }

    for (let user of data) {
      if (user.USERID === userid && user.PASSWORD === password) {
        console.log("login");
        console.log("id : " + userid);
        console.log("password : " + password);
        alert("id : " + userid + "password : " + password + " 로 로그인 하셨습니다.");
        let loginInfo = [user];

        localStorage.setItem("loginInfo", JSON.stringify(loginInfo));
        
        window.opener.isLogin(true);
        window.close(); 
        return;
      }
    }

    alert("아이디 또는 비밀번호를 확인해주세요.");
  });

  $(".btn-findpwd").on("click", function () {
    window.opener.location.replace("./findpwd.html");
    window.close();
  });
});
