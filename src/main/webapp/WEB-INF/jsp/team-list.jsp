<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<!DOCTYPE html>
<html>
<head>
    <title>Teams</title>
    <style>
        body{font-family:Arial,sans-serif;background:#f4f7fb;padding:30px;color:#222}
        .container{max-width:1000px;margin:auto;background:#fff;padding:25px;border-radius:12px;box-shadow:0 4px 20px rgba(0,0,0,.08)}
        table{width:100%;border-collapse:collapse;margin-top:20px}
        th,td{padding:12px;border-bottom:1px solid #ddd;text-align:left}
        th{background:#0d6efd;color:#fff}.btn{display:inline-block;padding:10px 14px;background:#0d6efd;color:#fff;text-decoration:none;border-radius:8px;margin-right:10px}
    </style>
</head>
<body>
<div class="container">
    <h2>Team List</h2>
    <a class="btn" href="/teams/new">Add Team</a>
    <a class="btn" href="/cricketers">View Cricketers</a>
    <table>
        <tr><th>ID</th><th>Name</th><th>Coach</th></tr>
        <c:forEach var="team" items="${teams}">
            <tr>
                <td>${team.id}</td>
                <td>${team.name}</td>
                <td>${team.coach}</td>
            </tr>
        </c:forEach>
    </table>
</div>
</body>
</html>