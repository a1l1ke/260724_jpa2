<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<html>
<head>
    <title>Hello JPA</title>
</head>
<body>
<h1>Hello JPA</h1>
<section>
    <form method="post" action="/reservation/doctor">
        <input name="name" placeholder="의사 이름"><br>
        <button>추가</button>
    </form>
</section>
<section>
    <form method="post">
        <select name="doctorId">
            <c:forEach items="${doctors}" var="doctor">
                <option value="${doctor.id}">${doctor.name}</option>
            </c:forEach>
        </select>
        <select name="petId">
            <c:forEach items="${pets}" var="pet">
                <option value="${pet.id}">${pet.name}</option>
            </c:forEach>
        </select>
        <input name="description" placeholder="예약설명">
        <input type="datetime-local" name="reservationDate">
        <button>예약</button>
    </form>
</section>
<section>
    <c:forEach items="${reservations}" var="reservation">
        <%--        <p>${reservation}</p>--%>
        <p>예약ID : ${reservation.id}</p>
        <p>예약펫 : ${reservation.pet.name}</p>
        <p>예약의사 : ${reservation.doctor.name}</p>
        <p>예약일시 : ${reservation.reservationDate}</p>
        <p>예약설명 : ${reservation.description}</p>
    </c:forEach>
</section>

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
