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
        <button>추가</button>
    </form>
</section>
<section>
    <c:forEach items="${pets}" var="pet">
        <p>${pet}</p>
    </c:forEach>
</section>
</body>
</html>
