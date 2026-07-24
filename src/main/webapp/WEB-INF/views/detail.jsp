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
        <select name="animalId">
            <c:forEach items="${animals}" var="animal">
                <c:choose>
                    <c:when test="${animal.id == pet.animal.id}">
                        <option value="${animal.id}" selected>${animal.name}</option>
                    </c:when>
                    <c:otherwise>
                        <option value="${animal.id}">${animal.name}</option>
                    </c:otherwise>
                </c:choose>
            </c:forEach>
        </select>
        <button>수정</button>
        <a href="/${pet.id}/delete">삭제</a>
    </form>
    <a href="/">뒤로가기</a>
</section>
</body>
</html>
