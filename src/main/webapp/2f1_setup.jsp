<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%
  String uri = config.getServletContext().getAttribute("uri").toString();
%>
<!DOCTYPE html>
<html lang="en">
<head>
    <title>2FA Setup - University of Colorado</title>
    <meta charset="UTF-8">
    <link rel="stylesheet" type="text/css" href="mui-0.10.3/css/mui.css">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <style>
        body {
            font-family: Arial, sans-serif;
            background-color: #CFB87C; /* Gold background */
            color: #000000; /* Black text */
        }

        .form-container {
            max-width: 500px;
            margin: 50px auto;
            padding: 30px;
            box-shadow: 0 0 10px rgba(0,0,0,0.5);
            text-align: center;
            background-color: #FFFFFF; /* White container for contrast */
            border: 1px solid #000000; /* Black border for container */
        }

        .warning {
            color: #A7A9AC; /* Silver color for warning */
            font-weight: bold;
        }

        img.qrcode {
            max-width: 250px;
            margin: 15px 0;
            border: 1px solid #A7A9AC; /* Silver border for image */
        }

        .mui-btn {
            background-color: #000000; /* Black button */
            color: #FFFFFF; /* White text */
            border: none;
        }

        .mui-btn:hover {
            background-color: #2b2b2b; /* Slightly lighter black on hover */
        }

        h1 {
            color: #000000; /* Black title */
            border-bottom: 2px solid #000000; /* Black underline for title */
            padding-bottom: 10px;
        }

    </style>
</head>
<body>
<div class="form-container">
    <h1>2FA Setup - CSCY 3765</h1>
    <p>Please scan the QR code below with your favorite two-factor authentication app:</p>
    <img src="<%= uri %>" alt="QR Code for 2FA" class="qrcode"> <!-- Updated src attribute -->
    <p class="warning">Warning: This page will not be visible again. Ensure you save the 2FA setup properly.</p>
    <!-- Button to redirect to the login endpoint -->
    <a href="/cscy3765_lab2_war_exploded/login" class="mui-btn mui-btn--primary">Go to Login</a>
</div>
</body>
</html>
