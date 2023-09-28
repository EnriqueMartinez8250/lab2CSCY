package edu.ucdenver.cscy3765_lab2;

import edu.ucdenver.cscy3765_lab2.library.Library;
import jakarta.servlet.ServletContextEvent;
import jakarta.servlet.ServletContextListener;
import jakarta.servlet.annotation.WebListener;

import java.time.LocalDate;

/*
This class is a context listener, meaning it sets up certain triggers and then waits for one of those conditions to be
met. We are using the `contextInitialized(ServletContextEvent)` trigger. This occurs whenever the server is initialized.
Here we are constructing our library, adding some Authors and Books to it, and then saving it into the "Servlet Context."
This acts as a sort of State tracker for our server and can hold objects in memory for us.
*NOTE: This memory may get wiped if you reboot your server*
 */

@WebListener
public class LibraryContextListener implements ServletContextListener {

    @Override
    public void contextInitialized(ServletContextEvent sce) {
        // Initialize our Library with some Authors and Books loaded in for us.
        Library library = Library.initTesterLibrary();
        sce.getServletContext().setAttribute("library", library);
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {
        // Cleanup resources, if needed
    }
}

