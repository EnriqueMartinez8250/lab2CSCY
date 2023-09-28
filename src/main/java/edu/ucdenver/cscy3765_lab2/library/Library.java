package edu.ucdenver.cscy3765_lab2.library;

import java.lang.reflect.Array;
import java.time.LocalDate;
import java.util.ArrayList;

public class Library {

    private final String name;
    private final ArrayList<Author> authorList;
    private final ArrayList<Book> bookList;
    private final ArrayList<User> userList;

    /**
     * Initialize the Library class with its name
     * @param name
     */
    public Library(String name) {
        this.name = name;
        this.authorList = new ArrayList<>();
        this.bookList = new ArrayList<>();
        this.userList = new ArrayList<>();
    }

    /**
     * try to add a `User` with the given info to the list of Users. Fail if the `User` alreadu exists.
     * @param username String
     * @param password String
     * @param email String
     * @throws IllegalArgumentException if the `User` already exists.
     */
    public void signUp(String username, String password, String email)
            throws IllegalArgumentException{
        for (User u: userList) {
            if (u.getUsername().equals(username) || u.getEmail().equals(email)){
                throw new IllegalArgumentException("Invalid information entered.");
            }
        }
        this.userList.add(new User(username, password, email));
    }

    /** TODO-7: [TO DO/DONE]
     *  update the logIn method to also check the verification code from the 2FA app.
     *      use the method `validateCode(String verificationCode)` which is defined for you
     *      as a member of the QRCode class.
     *      You will call it on the QRCode variable held by the `User.`
     *      It returns a `boolean` `true` if the code is valid and `false` if the code isn't valid
     */

    /**
     * Validate the info provided matches a registered `User`
     * @param username
     * @param password
     * @param verificationCode
     * @return `true` if the data matches a `User`. Else `false`
     */
    // ########################################################## //
    public boolean logIn(String username, String password, String verificationCode){
        User user = getUser(username, password); // this theoretically retreives a user object by its username

        if (user == null) {
            return false;
        }

        if (!user.getPassword().equals(password)) {
            // if pw is incorrect
            return false;
        }

        if (!user.getQRCode().validateCode(verificationCode)) {
            // if verif code is wrong
            return false;
        }
        else{
            return true;
        }
        // if pw and verif code are both correct

    }
    // ########################################################## //

    public String getName() {
        return name;
    }

    public User getUser(String username, String password) {
        for (User u : userList) {
            if (u.getUsername().equals(username) && u.getPassword().equals(password)){
                return u;
            }
        }
        return null;
    }

    public void addBook(String title, LocalDate date, String[] otherTitles, String authorName, int numPages)
            throws IllegalArgumentException {
        boolean authorExists = false;
        for (Author i : authorList) {
            if (i.getAuthorName().equals(authorName)) {
                authorExists = true;
                break;
            }
        }

        if (authorExists){
            bookList.add(new Book(title, date, otherTitles, numPages, authorName));
        }
        else{
            throw new IllegalArgumentException("The author name does not exist");
        }

    }

    public void addAuthor(String name) throws IllegalArgumentException {

        for (Author i : authorList) {
            if (i.getAuthorName().equals(name)) {
                throw new IllegalArgumentException("Author already exists!");
            }
        }

        authorList.add(new Author(name));
    }

    public void printUsers() {
        System.out.println("Current Registered Users are:");
        System.out.println("#############################");
        for(User u : userList) {
            System.out.println(u);
        }
        System.out.println("#############################");
    }

    public ArrayList<Book> getBooks() {
        return bookList;
    }

    public String toString() {

        String libraryInformation = "";

        libraryInformation += "This is the " + name + " library.\n== Author List ==\n";
        for (Author i : authorList) {
            libraryInformation += (i + "\n");
        }
        libraryInformation += "== Book List ==\n";
        for (Book i : bookList) {
            libraryInformation += (i + "\n");
        }
        libraryInformation += "--o--";

        return libraryInformation;
    }

    public static Library initTesterLibrary() {
        Library library = new Library("UC Denver - Main Branch");
        library.addAuthor("John Grisham");
        library.addAuthor("Brandon Sanderson");
        library.addAuthor("David Baldacci");
        library.addAuthor("William Shakespeare");
        library.addAuthor("Mary Shelley");
        library.addAuthor("Isaac Asimov");
        library.addAuthor("Maya Angelou");
        library.addAuthor("Gabriel García Márquez");
        library.addAuthor("Kazuo Ishiguro");
        library.addAuthor("Toni Morrison");
        library.addAuthor("Aldous Huxley");
        library.addAuthor("Margaret Atwood");
        library.addAuthor("Douglas Adams");
        library.addAuthor("Zora Neale Hurston");
        library.addAuthor("Chinua Achebe");
        // Books by John Grisham
        library.addBook("The Firm", LocalDate.of(1991, 2, 1), null, "John Grisham", 432);
        library.addBook("A Time to Kill", LocalDate.of(1989, 6, 1), null, "John Grisham", 480);
        library.addBook("The Whistler", LocalDate.of(2016, 10, 25), null, "John Grisham", 384);

        // Books by David Baldacci
        library.addBook("Memory Man", LocalDate.of(2015, 4, 21), null, "David Baldacci", 416);
        library.addBook("The Target", LocalDate.of(2014, 4, 22), null, "David Baldacci", 432);
        library.addBook("The Winner", LocalDate.of(1997, 11, 1), null, "David Baldacci", 528);
        library.addBook("Absolute Power", LocalDate.of(1996, 11, 5), null, "David Baldacci", 512);

        // Books by Brandon Sanderson
        library.addBook("Mistborn: The Final Empire", LocalDate.of(2006, 7, 25), null, "Brandon Sanderson", 541);
        library.addBook("The Way of Kings", LocalDate.of(2010, 8, 31), null, "Brandon Sanderson", 1007);
        library.addBook("Words of Radiance", LocalDate.of(2014, 3, 4), null, "Brandon Sanderson", 1087);
        library.addBook("Elantris", LocalDate.of(2005, 4, 21), null, "Brandon Sanderson", 492);
        library.addBook("Warbreaker", LocalDate.of(2009, 6, 9), null, "Brandon Sanderson", 688);


        // Books by William Shakespeare
        library.addBook("Macbeth", LocalDate.of(1606, 1, 1), null, "William Shakespeare", 147);
        library.addBook("Romeo and Juliet", LocalDate.of(1597, 1, 1), null, "William Shakespeare", 113);
        library.addBook("Hamlet", LocalDate.of(1601, 1, 1), null, "William Shakespeare", 208);

        // Books by Mary Shelley
        library.addBook("Frankenstein", LocalDate.of(1818, 1, 1), null, "Mary Shelley", 280);

        // Books by Isaac Asimov
        library.addBook("Foundation", LocalDate.of(1951, 6, 1), null, "Isaac Asimov", 244);
        library.addBook("I, Robot", LocalDate.of(1950, 12, 2), null, "Isaac Asimov", 253);

        // Books by Maya Angelou
        library.addBook("I Know Why the Caged Bird Sings", LocalDate.of(1969, 4, 28), null, "Maya Angelou", 289);

        // Books by Gabriel García Márquez
        library.addBook("One Hundred Years of Solitude", LocalDate.of(1967, 5, 30), null, "Gabriel García Márquez", 417);
        library.addBook("Love in the Time of Cholera", LocalDate.of(1985, 4, 10), null, "Gabriel García Márquez", 348);

        // Books by Kazuo Ishiguro
        library.addBook("Never Let Me Go", LocalDate.of(2005, 3, 3), null, "Kazuo Ishiguro", 288);
        library.addBook("The Remains of the Day", LocalDate.of(1989, 7, 22), null, "Kazuo Ishiguro", 245);

        // Books by Toni Morrison
        library.addBook("Beloved", LocalDate.of(1987, 9, 2), null, "Toni Morrison", 324);

        // Books by Aldous Huxley
        library.addBook("Brave New World", LocalDate.of(1932, 8, 24), null, "Aldous Huxley", 311);

        // Books by Margaret Atwood
        library.addBook("The Handmaid's Tale", LocalDate.of(1985, 9, 10), null, "Margaret Atwood", 311);
        library.addBook("Oryx and Crake", LocalDate.of(2003, 5, 30), null, "Margaret Atwood", 376);

        // Books by Zora Neale Hurston
        library.addBook("Their Eyes Were Watching God", LocalDate.of(1937, 9, 18), null, "Zora Neale Hurston", 219);

        // Books by Chinua Achebe
        library.addBook("Things Fall Apart", LocalDate.of(1958, 11, 16), null, "Chinua Achebe", 209);

        // Books by Douglas Adams
        library.addBook("The Hitchhiker's Guide to the Galaxy", LocalDate.of(1979, 10, 12), null, "Douglas Adams", 216);



        return library;
    }

}