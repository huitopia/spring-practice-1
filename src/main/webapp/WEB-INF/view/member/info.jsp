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
            <h3 class="mb-4">회원정보</h3>
            <%--div.mb-4>div*4>label.form-label+input[readonly].form-control--%>
            <div class="mb-4">
                <div class="mb-3">
                    email
                    <label for="inputEmail" class="form-label"></label>
                    <input type="email" readonly="" class="form-control" id="inputEmail" value="${memberInfo.email}">
                </div>
                <div class="mb-3">
                    password
                    <label for="inputPassword" class="form-label"></label>
                    <input type="password" readonly="" class="form-control" id="inputPassword"
                           value="${memberInfo.password}">
                </div>
                <div class="mb-3">
                    nickName
                    <label for="inputNickName" class="form-label"></label>
                    <input type="text" readonly="" class="form-control" id="inputNickName"
                           value="${memberInfo.nickName}">
                </div>
                <div class="mb-3">
                    inserted
                    <label for="inputInserted" class="form-label"></label>
                    <input type="datetime-local" readonly="" class="form-control" id="inputInserted"
                           value="${memberInfo.inserted}">
                </div>
                <div>
                    <button class="btn btn-outline-danger" form="formDelete">DELETE</button>
                    <button class="btn btn-outline-info" form="formUpdate">UPDATE</button>
                </div>
            </div>
        </div>
    </div>
</div>

<div class="d-none" onsubmit="return confirm('delete?')">
    <form action="/member/remove" id="formDelete" method="post">
        <input type="hidden" name="id" value="${memberInfo.id}">
    </form>
</div>
<div class="d-none" onsubmit="return confirm('update?')">
    <form action="/member/update" id="formUpdate">
        <input type="hidden" name="id" value="${memberInfo.id}">
    </form>
</div>

<script src="https://cdnjs.cloudflare.com/ajax/libs/bootstrap/5.3.3/js/bootstrap.min.js"
        integrity="sha512-ykZ1QQr0Jy/4ZkvKuqWn4iF3lqPZyij9iRv6sGqLRdTPkY69YX6+7wvVGmsdBbiIfN/8OdsI7HABjvEok6ZopQ=="
        crossorigin="anonymous" referrerpolicy="no-referrer"></script>
</body>
</html>
