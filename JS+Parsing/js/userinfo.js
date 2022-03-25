$(function () {
  $("#secessionButton").css("display", "block");
  let inputs = $(".form-control");
  for (let i = 0; i < inputs.length; i++) {
    inputs[i].disabled = true;
  }

  let loginInfo = JSON.parse(localStorage.getItem("loginInfo"))[0];

  $("#userid").val(loginInfo.USERID);
  $("#password").val(loginInfo.PASSWORD);
  $("#name").val(loginInfo.NAME);
  $("#email").val(loginInfo.ADDRESS);
  $("#tel").val(loginInfo.TEL);

  $("#modifyButton").on("click", function () {
    for (let i = 1; i < inputs.length; i++) {
      inputs[i].disabled = false;
    }
  });

  $("#checkButton").on("click", function () {
    let modify = confirm("수정하시겠습니까?");
    if (modify === true) {
      let user = {
        USERID: $("#userid").val(),
        PASSWORD: $("#password").val(),
        NAME: $("#name").val(),
        ADDRESS: $("#email").val(),
        TEL: $("#tel").val(),
      };

      loginInfo = [user];
      localStorage.setItem("loginInfo", JSON.stringify(loginInfo));

      let users = JSON.parse(localStorage.getItem("users"));
      for (let i = 0; i < users.length; i++) {
        if (users[i].USERID === user.USERID) {
          users[i] = user;
        }
      }

      localStorage.setItem("users", JSON.stringify(users));

      for (let i = 0; i < inputs.length; i++) {
        inputs[i].disabled = true;
      }
      $("#secessionButton").css("display", "none");
    }
  });

  $("#secessionButton").on("click", function () {
    let secession = confirm("회원 탈퇴 하시겠습니까?");
    if (secession === true) {
      let user = {
        USERID: $("#userid").val(),
        PASSWORD: $("#password").val(),
        NAME: $("#name").val(),
        ADDRESS: $("#email").val(),
        TEL: $("#tel").val(),
      };

      let users = JSON.parse(localStorage.getItem("users"));
      for (let i = 0; i < users.length; i++) {
        if (users[i].USERID === user.USERID) {
          users.splice(i, i + 1);
          break;
        }
      }

      localStorage.setItem("users", JSON.stringify(users));

      $("#nav-item-logout").trigger("click");
    }
  });
});
