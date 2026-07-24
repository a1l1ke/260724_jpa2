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
        <input name="name" placeholder="펫 이름"><br>
        <input name="age" type="number" placeholder="펫 나이"><br>
        <select name="animalId">
            <c:forEach items="${animals}" var="animal">
                <option value="${animal.id}">${animal.name}</option>
            </c:forEach>
        </select>
        <button>추가</button>
    </form>
</section>
<section>
    <form method="post" action="/animal">
        <input name="name" placeholder="동물 이름"><br>
        <button>추가</button>
    </form>
</section>
<section>
    <c:forEach items="${pets}" var="pet">
        <p>${pet} <a href="/${pet.id}">상세</a></p>
    </c:forEach>
</section>
</body>
</html>
