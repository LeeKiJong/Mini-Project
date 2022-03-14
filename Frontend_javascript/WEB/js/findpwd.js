$(function () {
  $("#submitButton").on("click", function () {
    let userid = $("#userid").val();
    let name = $("#name").val();
    let tel = $("#tel").val();

    if (!userid || !name || !tel) {
      alert("빈 칸을 모두 입력하세요.");
      return;
    }

    let json = JSON.parse(localStorage.getItem("users"));

    if (json === null) {
      alert("입력 정보를 다시 확인해주세요.");
      return;
    }

    for (let data of json) {
      if (data.USERID === userid && data.NAME === name && data.TEL === tel) {
        alert(`비밀번호: ${data.PASSWORD}`);
        return;
      }
    }

    alert("입력한 정보에 해당하는 회원을 찾지 못했습니다.");
  });
});
