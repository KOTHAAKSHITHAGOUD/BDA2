<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<!DOCTYPE html>
<html>
<head>
    <title>Edit Cricketer</title>
    <style>
        body{font-family:Arial;background:#eef2f7;padding:40px}.box{max-width:650px;margin:auto;background:#fff;padding:25px;border-radius:12px;box-shadow:0 3px 15px rgba(0,0,0,.08)}
        input,select{width:100%;padding:10px;margin:8px 0 16px;border:1px solid #ccc;border-radius:8px}button{background:#fd7e14;color:#fff;padding:10px 16px;border:none;border-radius:8px}
    </style>
</head>
<body>
<div class="box">
    <h2>Edit Cricketer</h2>
    <form:form method="post" action="/cricketers/update/${cricketer.id}" modelAttribute="cricketer">
        <label>Name</label>
        <form:input path="name" />
        <label>Role</label>
        <form:input path="role" />
        <label>Runs</label>
        <form:input path="runs" type="number" />
        <label>Team</label>
        <select name="teamId">
            <c:forEach var="team" items="${teams}">
                <option value="${team.id}" ${team.id == cricketer.team.id ? 'selected' : ''}>${team.name}</option>
            </c:forEach>
        </select>
        <button type="submit">Update Cricketer</button>
    </form:form>
</div>
</body>
</html>