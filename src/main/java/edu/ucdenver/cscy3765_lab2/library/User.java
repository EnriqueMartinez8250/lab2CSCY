package edu.ucdenver.cscy3765_lab2.library;
import edu.ucdenver.cscy3765_lab2.QRCode;

public class User {
    /** TODO-4: [TO DO/DONE]
     *  add a member variable qrCode of type QRCode to store the user's 2FA information
     */
    private final String username;
    private final String password;
    private final String email;


    public User(String username, String password, String email){
        this.username = username;
        this.password = password;
        this.email = email;
        /** TODO-5: [TO DO/DONE]
         *  initialize the QRCode using the static method buildCode() in the QRCode class
         *  make sure you made the changes to the code builder before you try to use it.
         */
        // ########################################################## //

        //Your code here.

        // ########################################################## //

    }

    @Override
    public String toString() {
        return this.username + " (User)";
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public String getUsername() {
        return username;
    }

    /** TODO-6: [DONE]
     *  add a getter for your QRCode variable
     */
    // ########################################################## //

    public QRCode getQRCode() {
        return QRCode;
    }


    // ########################################################## //
}
