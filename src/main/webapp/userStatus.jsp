<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Products - Shopping Website</title>
    <link rel="stylesheet" href="styles.css">
    <link rel="stylesheet" href="cartStyles.css"> <!-- Include CSS file for cart styling -->
</head>
<body>
    <header>
        <h1>Our Products</h1>
    </header>
    <nav>
        <ul>
            <li><a href="index.html">Home</a></li>
            <li><a href="#">Products</a></li>
            <li><a href="#">About</a></li>
            <li><a href="#">Contact</a></li>
        </ul>
    </nav>
    <main>

        <section class="result">
            <h2>Hey ${userName}, you are ${status} to ${operation}.</h2>

            <%-- You can't assign a value using EL expression ${} --%>
            <%-- Instead, you can directly use the value of status in scriptlet --%>
            <% String status = (String) request.getAttribute("status"); %>
            <% String operation = (String) request.getAttribute("operation"); %>
            <%
                //When using scriptlet tags in JSP, you don't need to use ${}
                if (status.equals("failed")) {
                    if(operation.equals("sign up")) {
            %>
                        <meta http-equiv="refresh" content="5;url=register_user.html">
            <%
                    } else {
            %>
                        <meta http-equiv="refresh" content="5;url=user_login.html">
            <%
                    }
                } else {
            %>
            <meta http-equiv="refresh" content="5;url=userOptions.html">
            <%
                }
            %>
        </section>
    </main>
</body>
</html>
