<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<!DOCTYPE html>
<html>
<head>
    <title>Cricketers</title>
    <style>
        body{font-family:Arial,sans-serif;background:#f8fbff;padding:30px}.container{max-width:1100px;margin:auto;background:white;padding:25px;border-radius:12px;box-shadow:0 4px 18px rgba(0,0,0,.08)}
        table{width:100%;border-collapse:collapse;margin-top:20px}th,td{padding:12px;border-bottom:1px solid #ddd;text-align:left}th{background:#212529;color:#fff}
        .btn{display:inline-block;padding:10px 14px;background:#0d6efd;color:#fff;text-decoration:none;border-radius:8px;margin-right:10px}.btn2{background:#198754}.btn3{background:#6c757d}
    </style>
</head>
<body>
<div class="container">
    <h2>Cricketer List</h2>
    <a class="btn" href="/cricketers/new">Add Cricketer</a>
    <a class="btn btn2" href="/teams">View Teams</a>
    <table>
        <tr><th>ID</th><th>Name</th><th>Role</th><th>Runs</th><th>Team</th><th>Action</th></tr>
        <c:forEach var="c" items="${cricketers}">
            <tr>
                <td>${c.id}</td>
                <td>${c.name}</td>
                <td>${c.role}</td>
                <td>${c.runs}</td>
                <td>${c.team.name}</td>
                <td><a class="btn btn3" href="/cricketers/edit/${c.id}">Edit</a></td>
            </tr>
        </c:forEach>
    </table>

    <h3>Inner Join Result</h3>
    <table>
        <tr><th>Cricketer</th><th>Role</th><th>Runs</th><th>Team</th></tr>
        <c:forEach var="row" items="${joinedData}">
            <tr>
                <td>${row[0]}</td>
                <td>${row[1]}</td>
                <td>${row[2]}</td>
                <td>${row[3]}</td>
            </tr>
        </c:forEach>
    </table>
</div>
</body>
</html>