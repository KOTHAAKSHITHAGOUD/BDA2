<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<!DOCTYPE html>
<html>
<head>
    <title>Add Cricketer</title>
    <style>
        body{font-family:Arial;background:#eef2f7;padding:40px}.box{max-width:650px;margin:auto;background:#fff;padding:25px;border-radius:12px;box-shadow:0 3px 15px rgba(0,0,0,.08)}
        input,select{width:100%;padding:10px;margin:8px 0 16px;border:1px solid #ccc;border-radius:8px}button{background:#0d6efd;color:#fff;padding:10px 16px;border:none;border-radius:8px}.error{color:red}
    </style>
</head>
<body>
<div class="box">
    <h2>Add Cricketer</h2>
    <p class="error">${errorMessage}</p>
    <form:form method="post" action="/cricketers/save" modelAttribute="cricketer">
        <label>Name</label>
        <form:input path="name" />
        <label>Role</label>
        <form:input path="role" />
        <label>Runs</label>
        <form:input path="runs" type="number" />
        <label>Team</label>
        <select name="teamId">
            <c:forEach var="team" items="${teams}">
                <option value="${team.id}">${team.name}</option>
            </c:forEach>
        </select>
        <button type="submit">Save Cricketer</button>
    </form:form>
</div>
</body>
</html>