<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <title>Login Page</title>
    <meta charset="UTF-8">
    <link rel="stylesheet" type="text/css" href="mui-0.10.3/css/mui.css">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <style>
        body {
            font-family: 'Arial', sans-serif;
            background-color: #CFB87C; /* Gold */
            color: #000; /* Black */
        }
        .form-container {
            max-width: 400px;
            margin: 50px auto;
            padding: 20px;
            background-color: #FFFFFF; /* White background for readability */
            border-radius: 8px;
            box-shadow: 0 0 10px rgba(0,0,0,0.2);
        }
        h1 {
            margin-bottom: 30px;
            color: #2C2C2C; /* Dark gray for better visibility on gold */
        }
        table {
            width: 100%;
            border-collapse: separate;
            border-spacing: 0 15px;
        }
        td {
            vertical-align: top;
            padding: 5px;
        }
        label {
            display: block;
            font-weight: bold;
            color: #2C2C2C; /* Dark gray */
        }
        .mui-btn {
            background-color: #2C2C2C; /* Dark gray */
            color: #CFB87C; /* Gold */
            border: none;
        }
        .mui-btn:hover {
            background-color: #000; /* Black */
            color: #FFFFFF; /* White */
        }
    </style>
</head>
<body>
<div class="form-container">
    <h1>Login Page</h1>
    <form method="post" action="/cscy3765_lab2_war_exploded/login">
        <table>
            <tr>
                <td>
                    <label for="username">Username</label>
                </td>
                <td>
                    <div class="mui-textfield mui-textfield--float-label">
                        <input type="text" id="username" name="username" required>
                    </div>
                </td>
            </tr>
            <tr>
                <td>
                    <label for="password">Password</label>
                </td>
                <td>
                    <div class="mui-textfield mui-textfield--float-label">
                        <input type="password" id="password" name="password" required>
                    </div>
                </td>
            </tr>
            <tr>
                <td>
                    <label for="verification-code">Verification Code</label>
                </td>
                <td>
                    <div class="mui-textfield mui-textfield--float-label">
                        <input type="text" id="verification-code" name="verification-code" required>
                    </div>
                </td>
            </tr>
            <tr>
                <td colspan="2">
                    <input class="mui-btn" type="submit" value="Login" style="width: 100%;">
                </td>
            </tr>
        </table>
    </form>
</div>
</body>
</html>
