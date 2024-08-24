<%@ page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" type="text/css" href="css/styles.css">
        <title>Login</title>
    </head>
    <body>
        <div class="login-form">
            <h2>Login</h2>
            <form action="LoginServlet" method="post">
                <input type="email" name="email" placeholder="Email" required>
                <input type="password" name="password" placeholder="Password" required>
                <input type="submit" value="Login">
            </form>
            <div class="register-link">
                Don't have an account? <a href="register.jsp">Register here</a>
            </div>
        </div>
    </body>
</html>
