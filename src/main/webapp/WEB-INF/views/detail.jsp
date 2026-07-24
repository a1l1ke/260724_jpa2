<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<html>
<head>
    <title>Hello JPA</title>
</head>
<body>
<h1>Hello JPA</h1>
<section>
    <form method="post">
        <p>펫 ID : ${pet.id}</p>
        <input name="name" placeholder="펫 이름" value="${pet.name}"><br>
        <input name="age" type="number" placeholder="펫 나이" value="${pet.age}"><br>
        <button>수정</button>
        <a href="/${pet.id}/delete">삭제</a>
    </form>
    <a href="/">뒤로가기</a>
</section>
</body>
</html>
