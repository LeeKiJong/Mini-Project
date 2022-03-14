$(function () {
  let loginInfo = JSON.parse(localStorage.getItem("loginInfo"));

  if (loginInfo === null) {
    $("#nav-item-signup").css("display", "block");
    $("#nav-item-login").css("display", "block");
    $("#nav-item-logout").css("display", "none");
    $("#nav-item-userinfo").css("display", "none");

    $("#exploreSurroud").css("display", "none");
    $("#setInterestArea").css("display", "none");
    $("#exploreInterestArea").css("display", "none");
  } else {
    $("#nav-item-signup").css("display", "none");
    $("#nav-item-login").css("display", "none");
    $("#nav-item-logout").css("display", "block");
    $("#nav-item-userinfo").css("display", "block");

    $("#exploreSurroud").css("display", "block");
    $("#setInterestArea").css("display", "block");
    $("#exploreInterestArea").css("display", "block");
  }

  $("#nav-item-login").on("click", function () {
    let status = "width=300,height=300,top=-230";

    let openWin = window.open("./login.html", "", status);
    openWin.focus();
  });

  $("#nav-item-logout").on("click", function () {
    let loginInfo = JSON.parse(localStorage.getItem("loginInfo"));

    if (loginInfo === null) {
      alert("다시 로그인 해주세요.");
    } else {
      localStorage.removeItem("loginInfo");
      
      window.location.replace("./index.html");
      console.log("logout");
      alert("로그아웃 하셨습니다.");
    }
  });

  $("#nav-item-signup").on("click", function () {
    window.location.replace("./signup.html");
  });

  $("#nav-item-userinfo").on("click", function () {
    window.location.replace("./userinfo.html");
  });
});

function isLogin(f) {
  if (f === true) {
    window.location.replace("./index.html");
  }
}
