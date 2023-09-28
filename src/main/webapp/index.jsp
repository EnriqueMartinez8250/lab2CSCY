<%@ page import="edu.ucdenver.cscy3765_lab2.library.Library" %>
<%@ page import="edu.ucdenver.cscy3765_lab2.library.Book" %>
<%@ page import="java.util.ArrayList" %>
<!DOCTYPE html>
<html lang='en'>
<head>
    <title>Welcome to the Library</title>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link href="https://cdn.muicss.com/mui-0.10.3/css/mui.min.css" rel="stylesheet" type="text/css" />
    <script src="https://cdn.muicss.com/mui-0.10.3/js/mui.min.js"></script>
    <style>
        body {
            font-family: 'Arial', sans-serif;
            padding: 20px;
            text-align: center;
            background-color: #CFB87C;
            color: #494949;
        }
        .container {
            max-width: 600px;
            margin: 20px auto;
            padding: 20px;
            border: 1px solid #e0e0e0;
            border-radius: 5px;
            background-color: #FFFFFF;
            box-shadow: 0 4px 8px rgba(0,0,0,0.05);
        }
        .mui-btn.mui-btn--primary {
            background-color: #CFB87C;
            color: #FFFFFF;
        }
        .mui-btn.mui-btn--accent {
            background-color: #494949;
            color: #FFFFFF;
        }
        .book-list {
            text-align: left;
            list-style-type: disc;
            margin-left: 40px;
        }
        table {
            width: 100%;
            border-collapse: collapse;
            margin-top: 20px;
        }
        table, th, td {
            border: 1px solid #CFB87C;
        }
        th, td {
            padding: 10px;
            text-align: left;
        }
        th {
            background-color: #CFB87C;
            color: #FFFFFF;
        }
    </style>
</head>
<body>
<div class="container">
    <%-- Check if user is logged in --%>
    <% if(request.getSession().getAttribute("username") != null) { %>
    <h2>Welcome back to the Library!</h2>
    <p>Congratulations! You've securely logged in with 2FA.</p>

    <%-- Display the list of books --%>
    <h3>Available Books:</h3>
        <table>
            <thead>
            <tr>
                <th>Title</th>
                <th>Author</th>
                <th>Publication Date</th>
                <th>Number of Pages</th>
            </tr>
            </thead>
            <tbody>
            <%
                ArrayList<Book> books = ((Library) config.getServletContext().getAttribute("library")).getBooks();
                for(Book bookObj : books) {
            %>
            <tr>
                <td><%= bookObj.getTitle() %></td>
                <td><%= bookObj.getAuthor() %></td>
                <td><%= bookObj.getPublicationDate() %></td>
                <td><%= bookObj.getNumOfPages() %></td>
            </tr>
            <%
                }
            %>
            </tbody>
        </table>
    <% } else { %>
    <h2>Welcome to the Library</h2>
    <p>To access our vast collection, please log in or sign up.</p>
    <a href="/cscy3765_lab2_war_exploded/login" class="mui-btn mui-btn--primary">Log In</a>
    <a href="/cscy3765_lab2_war_exploded/signup" class="mui-btn mui-btn--accent">Sign Up</a>
    <% } %>
</div>
</body>
</html>
