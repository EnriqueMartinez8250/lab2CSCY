package edu.ucdenver.cscy3765_lab2;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

import edu.ucdenver.cscy3765_lab2.library.*;

/*
This class allows API functionality for our webapp. When pages make calls to the endpoint URL shown in the urlPatterns
variable, they are directed to do the appropriate method doX where X is the type of REST API call made. We will just be
working with 2 for now, GET which we are using to load webpages, and POST to process form submissions from the client/user.
 */

@WebServlet(name = "LoginServlet", urlPatterns = {"/cscy3765_lab2_war_exploded/login"})
public class LoginServlet extends HttpServlet {

    /** TODO-10: [TO DO/DONE]
     *  Review the code to understand the logic flow of what is being done.
     *  This method is invoked when the user clicks the "Submit" button on the login.jsp page.
     *  If you look at its code:
     *      you will see "<form method="post" action="/cscy3765_lab2_war_exploded/login">"
     *      at the beginning of the data entry part of the page.
     *      This means that when "Submit" is clicked, the server will take us to the api endpoint
     *      specified in `action.` Since the `method` is "post," our `doPost` method is called by the server.
     */
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        // we are using `request.getParameter(parameterName)` to retrieve text box entries from the form filled out by
        // the client. These are all bundled inside the `request` object of type HttpServletRequest.

        String username = request.getParameter("username");
        String password = request.getParameter("password");
        String verificationCode = request.getParameter("verification-code");

        Library currentLibrary = (Library) getServletContext().getAttribute("library");

        /** TODO-11: [TO DO/DONE]
         *  create a variable called `authenticated` of type `boolean.`
         *  Initialize it by calling the `authenticatedUser` method you defined below.
         */
        // ########################################################## //

        boolean authenticated = // YOUR CODE HERE

        // ########################################################## //
        // Check if user is authenticated.
        // If they are, log their username to the session and send them back to the home page.
        if (authenticated) {
                // Set user session attribute
                HttpSession session = request.getSession();
                session.setAttribute("username", username);
                // Redirect to the home page or some other authenticated page
                response.sendRedirect("/cscy3765_lab2_war_exploded/index.jsp");
        // If the log in didn't go through, send them back to the login page.
        } else {
            // Show error message on login page
            request.setAttribute("errorMessage", "Invalid login credentials");
            // Redirect to login page
            response.sendRedirect("/cscy3765_lab2_war_exploded/login.jsp");
        }
    }

    /** TODO-12: [TO DO/DONE]
     *  implement the authenticateUser method which will login the user to the library,
     *  provided they have submitted valid credentials via the form.
     */
    // ########################################################## //
    //YOUR CODE HERE.
    private boolean authenticateUser(String username, String password, String verificationCode, Library lib) {
        // Perform secure authentication here

        // YOUR CODE HERE

    }

    // ########################################################## //

    // If the browser is directed to the API endpoint: "/cscy3765_lab2_war_exploded/login" a GET request will be made.
    //  This will invoke the doGet method we have defined below which loads the login.jsp page.
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Redirect to login page
        response.sendRedirect("/cscy3765_lab2_war_exploded/login.jsp");
    }

}
