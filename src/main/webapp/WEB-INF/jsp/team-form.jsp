<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
    <title>Add Team</title>
    <style>
        body{font-family:Arial;background:#eef2f7;padding:40px}.box{max-width:600px;margin:auto;background:#fff;padding:25px;border-radius:12px;box-shadow:0 3px 15px rgba(0,0,0,.08)}
        input{width:100%;padding:10px;margin:8px 0 16px;border:1px solid #ccc;border-radius:8px}button{background:#198754;color:#fff;padding:10px 16px;border:none;border-radius:8px}.error{color:red}
    </style>
</head>
<body>
<div class="box">
    <h2>Add Team</h2>
    <p class="error">${errorMessage}</p>
    <form:form method="post" action="/teams/save" modelAttribute="team">
        <label>Name</label>
        <form:input path="name" />
        <label>Coach</label>
        <form:input path="coach" />
        <button type="submit">Save Team</button>
    </form:form>
</div>
</body>
</html>