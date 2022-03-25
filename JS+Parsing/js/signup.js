$(function () {
  $("#registButton").on("click", function () {
    let userid = $("#userid").val();
    let password = $("#password").val();
    let name = $("#name").val();
    let address = $("#email").val();
    let tel = $("#tel").val();

    console.log("id : " + userid);
    console.log("password : " + password);
    console.log("name : " + name);
    console.log("address : " + address);
    console.log("tel : " + tel);
    alert("회원가입이 완료되었습니다.")
    if (!userid || !password || !name || !address || !tel) {
      alert("빈 칸을 모두 입력하세요.");
      return;
    } else {
      let user = {
        USERID: userid,
        PASSWORD: password,
        NAME: name,
        ADDRESS: address,
        TEL: tel,
      };

      let json = JSON.parse(localStorage.getItem("users"));

      if (json === null) {
        json = [user];
      } else {
        for (let data of json) {
          if (data.USERID === user.USERID) {
            alert("이미 등록된 아이디입니다.");
            return;
          }
        }

        json.push(user);
      }

      localStorage.setItem("users", JSON.stringify(json));

      window.location.replace("./index.html");

      console.log(user);
    }
  });
});
