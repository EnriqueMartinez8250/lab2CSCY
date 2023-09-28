package edu.ucdenver.cscy3765_lab2;

import edu.ucdenver.cscy3765_lab2.library.Library;
import edu.ucdenver.cscy3765_lab2.library.User;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

/*
This class allows API functionality for our webapp. When pages make calls to the endpoint URL shown in the urlPatterns
variable, they are directed to do the appropriate method doX where X is the type of REST API call made. We will just be
working with 2 for now, GET which we are using to load webpages, and POST to process form submissions from the client/user.
 */

@WebServlet(name = "SignupServlet", urlPatterns = {"/cscy3765_lab2_war_exploded/signup"})
public class SignupServlet extends HttpServlet {

    /** TODO-8: [TO DO/DONE]
     * Review the code to understand the logic flow of what is being done.
     * This method is invoked when the user clicks the "Submit" button on the signup.jsp page.
     * If you look at its code:
     *      you will see "<form method="post" action="/cscy3765_lab2_war_exploded/signup">" at
     *      the beginning of the data entry part of the page.
     *      This means that when "Submit" is clicked, the server will take us to the api endpoint
     *      specified in `action.`
     *      Since the `method` is "post," our `doPost` method is called by the server.
     */
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // we are using `request.getParameter(parameterName)` to retrieve text box entries from the form filled out by
        // the client. These are all bundled inside the `request` object of type HttpServletRequest.
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        String email = request.getParameter("email");

        // This retrieves a reference to the `Library` object being used by our Tomcat server.
        Library currentLibrary = (Library) getServletContext().getAttribute("library");

        try {
            /** TODO-9:  [TO DO/DONE]
             *  using the information provided by the user,
             *  use the methods provided by the Library class to sign up the user.
             *  The variables are setup for you and are listed above.
             */
            // ########################################################## //

            //YOUR CODE HERE

            // ########################################################## //
            // Getting the QR URI and sendint it to the webpage.
            User newUser = currentLibrary.getUser(username, password);
            String uri = newUser.getQRCode().getURI();
            getServletContext().setAttribute("uri", uri);
            // This command now redirects the client to the next page in the signup process.
            response.sendRedirect("/cscy3765_lab2_war_exploded/2f1_setup.jsp");
        } catch (IllegalArgumentException iae) {
            // If for some reason the user can't be created, output the error.
            response.getWriter().println(iae);
        }
    }

    // If the browser is directed to the API endpoint: "/cscy3765_lab2_war_exploded/login" a GET request will be made.
    //  This will invoke the doGet method we have defined below which loads the login.jsp page.
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Redirect to signup page
        response.sendRedirect("/cscy3765_lab2_war_exploded/signup.jsp");
    }
}
