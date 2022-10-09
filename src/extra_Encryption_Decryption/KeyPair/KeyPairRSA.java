package extra_Encryption_Decryption.KeyPair;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.security.KeyFactory;
import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.SecureRandom;
import java.security.spec.PKCS8EncodedKeySpec;
import java.security.spec.X509EncodedKeySpec;
import java.util.Base64;
import java.util.Scanner;

import javax.crypto.Cipher;

public class KeyPairRSA {

    private static void keyPairGenerateAndSave(File filePublicKey, File filePrivateKey) throws Exception {
        // generate
        KeyPairGenerator kpg = KeyPairGenerator.getInstance("RSA"); // key pair generator with RSA algorithm
        SecureRandom random = new SecureRandom();
        kpg.initialize(2048, random); // 2048 is key's size
        KeyPair kp = kpg.genKeyPair(); // generate a random pair key
        PublicKey publicKey = kp.getPublic();
        PrivateKey privateKey = kp.getPrivate();

        // save
        FileOutputStream fos = new FileOutputStream(filePublicKey); // create a new file if file doesn’t exist
        fos.write(publicKey.getEncoded());
        fos.close();
        fos = new FileOutputStream(filePrivateKey);
        fos.write(privateKey.getEncoded());
        fos.close();
    }

    private static String encryptUsingPublicKey(String originalStr, File filePublicKey) throws Exception {
        // create public key from the saved file
        FileInputStream fis = new FileInputStream(filePublicKey); // exception if file does’t exist
        byte[] byteArr = new byte[fis.available()]; // new empty byte array with length ‘fis.available()’
        fis.read(byteArr); // read from this input stream into a byte array
        fis.close();
        // encode public key using X.509 format
        X509EncodedKeySpec encodedKeyX509 = new X509EncodedKeySpec(byteArr);
        KeyFactory factory = KeyFactory.getInstance("RSA"); // key factory with RSA algorithm
        PublicKey publicKey = factory.generatePublic(encodedKeyX509);
        // encrypt data using public key
        // Cipher object implements a specified transformation on the input data to produce output
        Cipher cipher = Cipher.getInstance("RSA");
        cipher.init(Cipher.ENCRYPT_MODE, publicKey);
        byte[] encryptedArr = cipher.doFinal(originalStr.getBytes()); // encrypt input data
        String encryptedStr = new String(Base64.getEncoder().encode(encryptedArr));
        return encryptedStr;
    }

    private static String decryptUsingPrivateKey(String encryptedStr, File filePrivateKey) throws Exception {
        // create private key from the saved file
        FileInputStream fis = new FileInputStream(filePrivateKey); // exception if file does’t exist
        byte[] byteArr = new byte[fis.available()]; // new empty byte array with length ‘fis.available()’
        fis.read(byteArr); // read from this input stream into a byte array
        fis.close();
        // encode private key using PKCS #8 format
        PKCS8EncodedKeySpec encodedKeyPKCS8 = new PKCS8EncodedKeySpec(byteArr);
        KeyFactory factory = KeyFactory.getInstance("RSA"); // key factory with RSA algorithm
        PrivateKey privateKey = factory.generatePrivate(encodedKeyPKCS8);
        // decrypt data using private key
        Cipher cipher = Cipher.getInstance("RSA");
        cipher.init(Cipher.DECRYPT_MODE, privateKey);
        byte[] decryptedArr = cipher.doFinal(Base64.getDecoder().decode(encryptedStr)); // decrypt input data
        String decryptedStr = new String(decryptedArr);
        return decryptedStr;
    }

    public static void main(String[] args) {
        String path = "src/" + KeyPairRSA.class.getPackage().getName().replace(".", "/");
        File filePublicKey = new File(path + "/PublicKey.bin");
        File filePrivateKey = new File(path + "/PrivateKey.bin");
        System.out.print("enter a string for encryption: ");
        Scanner scanner = new Scanner(System.in);
        String inputStr = scanner.nextLine();
        scanner.close();
        try {
            keyPairGenerateAndSave(filePublicKey, filePrivateKey);
            System.out.println("\nkey pair generated and saved successfully!");

            String encryptedStr = encryptUsingPublicKey(inputStr, filePublicKey);
            System.out.println("\n‘" + inputStr + "’ after encrypted: " + encryptedStr);

            String encryptedInt = decryptUsingPrivateKey(encryptedStr, filePrivateKey);
            System.out.println("\nafter decrypted: " + encryptedInt);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
