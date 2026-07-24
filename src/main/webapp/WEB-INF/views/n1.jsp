<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<html>
<head>
    <title>Hello JPA</title>
</head>
<body>
<h1>Hello JPA</h1>
<section>
    <h3>N+1</h3>
    <c:forEach items="${doctorReservations}" var="reservation">
        <%--        <p>${reservation}</p>--%>
        <p>예약ID : ${reservation.id()}</p>
        <p>예약펫 : ${reservation.pet().name}</p>
        <p>예약의사 : ${reservation.doctorName()}</p>
    </c:forEach>
</section>
</body>
</html>
