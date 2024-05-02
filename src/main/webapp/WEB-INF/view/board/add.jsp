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
            <h3 class="mb-3">새 게시물 작성</h3>
            <form action="/add" method="post">
                <div>
                    <label for="inputTitle" class="col-form-label">
                        제목
                    </label>
                    <input id="inputTitle" class="form-control" type="text" name="title" required>
                </div>
                <div>
                    <label for="textareaContent" class="col-form-label">
                        본문
                    </label>
                    <textarea id="textareaContent" class="form-control" name="content" cols="30" rows="10"
                              required></textarea>
                </div>
                <div>
                    <label for="inputWriter" class="col-form-label">
                        작성자
                    </label>
                    <input type="text" id="inputWriter" class="form-control" name="writer" required>
                </div>
                <div class="mt-3">
                    <button class="btn btn-outline-primary">저장</button>
                </div>
            </form>
        </div>
    </div>
</div>
<script src="https://cdnjs.cloudflare.com/ajax/libs/bootstrap/5.3.3/js/bootstrap.min.js"
        integrity="sha512-ykZ1QQr0Jy/4ZkvKuqWn4iF3lqPZyij9iRv6sGqLRdTPkY69YX6+7wvVGmsdBbiIfN/8OdsI7HABjvEok6ZopQ=="
        crossorigin="anonymous" referrerpolicy="no-referrer"></script>
</body>
</html>
