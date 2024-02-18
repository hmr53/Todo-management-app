<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!doctype html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <link href="webjars/bootstrap/5.1.3/css/bootstrap.min.css" rel="stylesheet" >
    <title>List ToDos</title>
</head>
<body>
<div class="container">
    <h1 class="display-1">List todos</h1>
    <table class="table">
        <thead>
        <tr>
            <th>id</th>
            <th>Description</th>
            <th>Target date</th>
            <th>is Done.?</th>
        </tr>
        </thead>
        <tbody>
            <c:forEach items="${todos}" var="todo">
                <tr>
                    <td>${todo.id}</td>
                    <td>${todo.description}</td>
                    <td>${todo.targetDate}</td>
                    <td>${todo.done}</td>
                </tr>
            </c:forEach>
        </tbody>
    </table>
    <div>
        <a href="add-todo" class="btn btn-success text-start">add todo</a>
    </div>
</div>
</body>
</html>