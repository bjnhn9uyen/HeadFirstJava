package extra_Encryption_Decryption;

import java.security.KeyFactory;
import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.spec.X509EncodedKeySpec;
import java.util.Base64;
import java.util.Objects;
import java.util.Scanner;

import javax.crypto.Cipher;
import javax.crypto.KeyAgreement;
import javax.crypto.SecretKey;
import javax.crypto.interfaces.DHPublicKey;
import javax.crypto.spec.DHParameterSpec;
import javax.crypto.spec.SecretKeySpec;

public class KeyAgreementTest {

    private static byte[] senderPublicKeyEncoded, receiverPublicKeyEncoded;

    private static PrivateKey sendPublicKeyToReceiver() throws Exception {
        KeyPairGenerator keyPairGenerator = KeyPairGenerator.getInstance("DH");
        keyPairGenerator.initialize(512); // 512 is key's size
        KeyPair keyPair = keyPairGenerator.generateKeyPair();
        // sender sends his own public key to the receiver
        senderPublicKeyEncoded = keyPair.getPublic().getEncoded();
        return keyPair.getPrivate(); // sender's private key
    }

    private static SecretKey receiverMakesKeyAgreement() throws Exception {
        // get sender's public key
        X509EncodedKeySpec encodedKeyX509 = new X509EncodedKeySpec(senderPublicKeyEncoded);
        KeyFactory keyFactory = KeyFactory.getInstance("DH");
        PublicKey senderPublicKey = keyFactory.generatePublic(encodedKeyX509);

        // receiver takes sender's public key to generate his own key pair,
        // public key to send back to the sender and private key for key agreement (with sender's public key)
        KeyPairGenerator keyPairGenerator = KeyPairGenerator.getInstance("DH");
        DHParameterSpec parameterSpecDH = ((DHPublicKey) senderPublicKey).getParams();
        keyPairGenerator.initialize(parameterSpecDH);
        KeyPair keyPair = keyPairGenerator.generateKeyPair();
        // receiver sends his own public key to the sender
        receiverPublicKeyEncoded = keyPair.getPublic().getEncoded();

        // receiver takes sender's public key and his private key to make key agreement
        KeyAgreement keyAgreement = KeyAgreement.getInstance("DH");
        keyAgreement.init(keyPair.getPrivate());
        keyAgreement.doPhase(senderPublicKey, true);
        // receiver generates the secret key from key agreement using same algorithm
        byte[] secretKeyArr = keyAgreement.generateSecret();
        // if the algorithm is DES, the key must be 8 bytes long
        return new SecretKeySpec(secretKeyArr, 0, 8, "DES");
    }

    private static SecretKey senderMakesKeyAgreement(PrivateKey senderPrivateKey) throws Exception {
        // get receiver's public key
        X509EncodedKeySpec encodedKeyX509 = new X509EncodedKeySpec(receiverPublicKeyEncoded);
        KeyFactory keyFactory = KeyFactory.getInstance("DH");
        PublicKey receiverPublicKey = keyFactory.generatePublic(encodedKeyX509);

        // sender takes receiver's public key and his private key to make key agreement
        KeyAgreement keyAgreement = KeyAgreement.getInstance("DH");
        keyAgreement.init(senderPrivateKey);
        keyAgreement.doPhase(receiverPublicKey, true);
        // sender generates the secret key from key agreement using same algorithm
        byte[] secretKeyArr = keyAgreement.generateSecret();
        // if the algorithm is DES, the key must be 8 bytes long
        return new SecretKeySpec(secretKeyArr, 0, 8, "DES");
    }

    public static void main(String[] args) {
        try {
            PrivateKey senderPrivateKey = sendPublicKeyToReceiver();
            SecretKey receiverSecretKey = receiverMakesKeyAgreement();
            SecretKey senderSecretKey = senderMakesKeyAgreement(senderPrivateKey);
            // test secret keys of both sides (sender and receiver)
            if (Objects.equals(senderSecretKey, receiverSecretKey)) {
                System.out.println("both sides generated the same secret key!");
            }

            Scanner scanner = new Scanner(System.in);
            System.out.print("enter a message to send to the receiver: ");
            String senderMessage = scanner.nextLine();
            scanner.close();
            // sender
            Cipher cipherSender = Cipher.getInstance("DES");
            cipherSender.init(Cipher.ENCRYPT_MODE, senderSecretKey);
            byte[] encryptedArr = cipherSender.doFinal(senderMessage.getBytes("UTF8"));
            String messageEncrypted = new String(Base64.getEncoder().encode(encryptedArr));
            System.out.println(messageEncrypted);
            // receiver
            Cipher cipherReceiver = Cipher.getInstance("DES");
            cipherReceiver.init(Cipher.DECRYPT_MODE, receiverSecretKey);
            byte[] decryptedArr = cipherReceiver.doFinal(Base64.getDecoder().decode(messageEncrypted));
            String messageDecrypted = new String(decryptedArr, "UTF8");
            System.out.println(messageDecrypted);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
