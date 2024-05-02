<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<html>
<head>
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>Title</title>
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/bootstrap/5.3.3/css/bootstrap.min.css"
          integrity="sha512-jnSuA4Ss2PkkikSOLtYs8BlYIeeIK1h99ty4YfvRPAlzr377vr3CXDb7sb7eEEBYjDtcYj+AjBH3FLv5uSJuXg=="
          crossorigin="anonymous" referrerpolicy="no-referrer"/>
</head>
<body>

<c:import url="/WEB-INF/fragment/navbar.jsp"/>

<%--div.container>div.row.justify-content-center>div.col-6--%>
<div class="container">
    <div class="row justify-content-center">
        <div class="col-6">
            <h3 class="mb-4">회원 가입</h3>
            <form action="/member/modify" method="post" onsubmit="return checkValues()">
                <%-- div*3>label.form-label+input.form-control--%>
                <input type="hidden" value="${memberInfo.id}" name="id">
                <div class="mb-3">
                    <label for="inputEmail" class="form-label">이메일</label>
                    <input name="email" id="inputEmail" readonly type="email" class="form-control-plaintext"
                           value="${memberInfo.email}">
                </div>
                <div class="mb-3">
                    <label for="inputPassword" class="form-label">패스워드</label>
                    <input oninput="passwordCheck()" name="password" id="inputPassword" required type="password"
                           class="form-control"
                           value="${memberInfo.password}">
                </div>
                <div class="mb-3">
                    <label for="inputPasswordCheck" class="form-label">패스워드 확인</label>
                    <input oninput="passwordCheck()" id="inputPasswordCheck" required type="password"
                           class="form-control">
                </div>
                <div class="form-text" id="passwordMessage" style="color: red"></div>
                <div class="mb-3">
                    <label for="inputNickName" class="form-label">별명</label>
                    <input name="nickName" id="inputNickName" required type="text" class="form-control"
                           value="${memberInfo.nickName}">
                </div>
                <div>
                    <button class="btn btn-primary">UPDATE</button>
                </div>
            </form>
        </div>
    </div>
</div>

<script>
    function checkValues() {
        const password = document.getElementById("inputPassword").value;
        const passwordCheck = document.getElementById("inputPasswordCheck").value;
        if (password != "" && password == passwordCheck) {
            return true;
        } else {
            alert("비밀번호 불일치")
        }
    }

    function passwordCheck() {
        const password = document.querySelector("#inputPassword").value;
        const passwordCheck = document.querySelector("#inputPasswordCheck").value;

        if (password != passwordCheck) {
            document.querySelector("#passwordMessage").textContent = "패스워드 불일치";
        } else {
            document.querySelector("#passwordMessage").textContent = "";
        }
    }
</script>


<script src="https://cdnjs.cloudflare.com/ajax/libs/bootstrap/5.3.3/js/bootstrap.min.js"
        integrity="sha512-ykZ1QQr0Jy/4ZkvKuqWn4iF3lqPZyij9iRv6sGqLRdTPkY69YX6+7wvVGmsdBbiIfN/8OdsI7HABjvEok6ZopQ=="
        crossorigin="anonymous" referrerpolicy="no-referrer"></script>
</body>
</html>