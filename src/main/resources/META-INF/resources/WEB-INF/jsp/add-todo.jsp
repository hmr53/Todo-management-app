<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<!doctype html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <link href="webjars/bootstrap/5.1.3/css/bootstrap.min.css" rel="stylesheet" >
    <title>Add todo</title>
</head>
<body>
<div class="container">
    <h1>This is Add to JSP</h1>
    <%--@elvariable id="toDo" type="com.hasith.todomanagementbyme.controllers.todo.ToDo"--%>
    <form:form method="post" modelAttribute="toDo">
        <label for="description">Description</label>
        <form:input class="form-control" name="description" id="description" path="description" type="text" required="required" />
        <form:errors path="description" cssClass="text-danger"/>
        <form:input class="form-control" name="id" id="description" path="id" type="hidden"/>
        <form:input class="form-control" name="done" id="description" path="done" type="hidden"/>
        <input type="submit" value="submit" class="btn btn-primary">
    </form:form>
</div>

</body>
</html>