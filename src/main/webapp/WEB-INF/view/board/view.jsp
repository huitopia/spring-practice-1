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
<div class="container">
    <div class="row justify-content-center">
        <div class="col-6">
            <h3>${board.id} 번 게시물</h3>
            <div class="mb-3">
                <label for="inputTitle" class="col-form-label">
                    제목
                </label>
                <input type="text" id="inputTitle" class="form-control" value="${board.title}" readonly>
            </div>
            <div class="mb-3">
                <label for="textareaContent" class="col-form-label">
                    본문
                </label>
                <textarea id="textareaContent" class="form-control" cols="30" rows="10"
                          readonly>${board.content}</textarea>
            </div>
            <div class="mb-3">
                <label for="inputWriter" class="col-form-label">
                    작성자
                </label>
                <input type="text" id="inputWriter" class="form-control" value="${board.writer}" readonly>
            </div>
            <div class="mb-3">
                <label for="inputInserted" class="col-form-label">
                    작성일
                </label>
                <input type="datetime-local" id="inputInserted" class="form-control" value="${board.inserted}" readonly>
            </div>
            <%-- button --%>
            <div style="margin: 10px">
                <button form="formDelete" type="submit" class="btn btn-danger">delete</button>
                <button form="formUpdate" type="submit" class="btn btn-warning">update</button>
            </div>
        </div>
    </div>
</div>
<%-- button form --%>
<div style="display: none">
    <form id="formDelete" action="/delete" method="post"
          onsubmit="return confirm('delete?')">
        <input type="hidden" name="id" value="${board.id}">
    </form>
    <form id="formUpdate" action="/modify?id=${board.id}">
        <input type="hidden" name="id" value="${board.id}">
    </form>
</div>
<script src="https://cdnjs.cloudflare.com/ajax/libs/bootstrap/5.3.3/js/bootstrap.min.js"
        integrity="sha512-ykZ1QQr0Jy/4ZkvKuqWn4iF3lqPZyij9iRv6sGqLRdTPkY69YX6+7wvVGmsdBbiIfN/8OdsI7HABjvEok6ZopQ=="
        crossorigin="anonymous" referrerpolicy="no-referrer"></script>
</body>
</html>
