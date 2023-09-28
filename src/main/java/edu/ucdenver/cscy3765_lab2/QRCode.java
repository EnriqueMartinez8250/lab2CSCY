package edu.ucdenver.cscy3765_lab2;


import dev.samstevens.totp.code.*;
import dev.samstevens.totp.exceptions.QrGenerationException;
import dev.samstevens.totp.qr.QrData;
import dev.samstevens.totp.qr.QrGenerator;
import dev.samstevens.totp.qr.ZxingPngQrGenerator;
import dev.samstevens.totp.secret.DefaultSecretGenerator;
import dev.samstevens.totp.secret.SecretGenerator;
import dev.samstevens.totp.time.SystemTimeProvider;
import dev.samstevens.totp.time.TimeProvider;

import java.io.FileOutputStream;

import static dev.samstevens.totp.util.Utils.getDataUriForImage;
import static java.lang.System.exit;

public class QRCode {
    String secret;  //the secret used to generate the TOTP.
    String codeURI; //to provide the image to webapp.

    private QRCode(String secret, String codeURI) {
        this.secret = secret;
        this.codeURI = codeURI;
    }


    public static QRCode buildCode() {
        // Builds a QR Code for the authenticator app.

        /** TODO-2: [TO DO/DONE]
         *  review the implementation of this class to understand how it is implemented.
         *  no code here, but try to get the gist of what's going on.
         */
        String codeURI = "";
        // creates a random secret key that is 64 characters long
        SecretGenerator secretGenerator = new DefaultSecretGenerator(64);
        String secret = secretGenerator.generate();
        // construct a data object that will hold all relevant information for our QR Code
        /** TODO-3: [TO DO/DONE]
         *  use the following data to build your QR Code. It is given to you as key:value pairs. Take the value and
         *  insert it in the parenthesis of the corresponding key. Replace the <> characters and their prompt with the
         *  variable they refer to  { .label : "CSCY3765-Lab2", .secret : <The secret variable initialized above>,
         *  .issuer ("Lab2LibrarySite"), .algorithm : HashingAlgorithm.SHA256, .digits : 6, .period : 30 }
         *  Look at the provided documentation of the class QrData linked on the course website.
         */

        QrData data = //YOUR CODE HERE


        try {
            QrGenerator generator = new ZxingPngQrGenerator();
            //this turns the data into a byte array that we can write to file and display on a webpage
            byte[] imageData = generator.generate(data);
            //get the MIME type (image/png) of the file
            String mimeType = generator.getImageMimeType();
            // create the URI for an image, which we can use to display it on a webpage
            codeURI = getDataUriForImage(imageData, mimeType);
        } catch (Exception e) {
            System.out.println(e);
        }

        // hand back the QRCode object, storing the randomly generated secret and the codeURI for future comparison / reference
        return new QRCode(secret, codeURI);
    }

    public String getURI() {
        return this.codeURI;
    }

    public boolean validateCode(String code) {
        // used to get the current time
        TimeProvider timeProvider = new SystemTimeProvider();
        // a class that generates authentication codes given a secret. By default,
        // the codes it generates are 6 digits long and uses SHa-1. We are telling it to use SHA.256 by passing that
        // as an argument to the constructor but leaving the default code length at 6. Constructor overloading allows
        // for this flexibility
        CodeGenerator codeGenerator = new DefaultCodeGenerator(HashingAlgorithm.SHA256);
        // our verifier will be made up of a codeGenerator and the timeProvider we just set up
        CodeVerifier verifier = new DefaultCodeVerifier(codeGenerator, timeProvider);

        // isValidCode takes a secret, uses the generator and the time provider to convert that into a list of all
        // possible valid verification codes. There is generally a small range of valid options in any window of time.
        // Additionally, some auth programs allow for "recently expired" or "soon to exist" codes to be valid to allow for
        // clock differences between machines.
        // Finally, that range of valid codes is compared with the one given by the user. Return `true` if there's a match, else `false`
        // secret = the shared secret for the user, stored in the `QRCode` variable of the `User`
        // code = the code submitted by the user
        return verifier.isValidCode(this.secret, code);
    }
}



