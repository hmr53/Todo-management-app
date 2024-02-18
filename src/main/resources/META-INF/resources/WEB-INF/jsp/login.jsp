<!doctype html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <link href="webjars/bootstrap/5.1.3/css/bootstrap.min.css" rel="stylesheet" >
    <title>Login JSP</title>
</head>
<body>
<h1 class="text-center">Login JSP</h1>
<div class="container" >

    <form  method="post">
        <div class="d-grid gap-3">
            <div>
                <label for="username">Username</label>
                <input class="form-control" type="text" id="username" name="username">
            </div>
            <div>
                <label for="password">Password</label>
                <input class="form-control" type="text" id="password" name="password">
            </div>
            <div><input type="submit" value="Submit" class="btn btn-primary"></div>
        </div>
    </form>
</div>
</body>
</html>