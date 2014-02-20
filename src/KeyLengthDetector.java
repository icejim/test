import javax.crypto.Cipher;
import java.security.NoSuchAlgorithmException;
import java.io.UnsupportedEncodingException;
import java.security.InvalidKeyException;
import java.security.SecureRandom;

import javax.crypto.BadPaddingException;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.KeyGenerator;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;

public class KeyLengthDetector {
public static void main(String[] args) {
int allowedKeyLength = 0;

try {
allowedKeyLength = Cipher.getMaxAllowedKeyLength("AES");
String content = "123456789123456789123456789";
            String password = "e710af854b1322e72c0f9b0006eaee667c4617ba";
            //..
            System.out.println("...." + content);
            byte[] encryptResult = KeyLengthDetector.encrypt(content, password);
byte[] decryptResult = KeyLengthDetector.decrypt(encryptResult,password);
System.out.println("...." + new String(decryptResult));
} catch (NoSuchAlgorithmException e) {
e.printStackTrace();
}

System.out.println("The allowed key length for AES is: " + allowedKeyLength);
}

/**
     * ..
     *
     * @param content .......
     * @param password  ....
     * @return
     */
    public static byte[] encrypt(String content, String password) {
            try {
            		SecretKey secretKey = getKey(password);
                    byte[] enCodeFormat = secretKey.getEncoded();
                    SecretKeySpec key = new SecretKeySpec(enCodeFormat, "AES");
                    Cipher cipher = Cipher.getInstance("AES");// .....
                    byte[] byteContent = content.getBytes("utf-8");
                    cipher.init(Cipher.ENCRYPT_MODE, key);// ...
                    byte[] result = cipher.doFinal(byteContent);
                    return result; // ..
            } catch (NoSuchAlgorithmException e) {
                e.printStackTrace();
            } catch (NoSuchPaddingException e) {
                e.printStackTrace();
            } catch (InvalidKeyException e) {
                e.printStackTrace();
            } catch (UnsupportedEncodingException e) {
                e.printStackTrace();
            } catch (IllegalBlockSizeException e) {
                e.printStackTrace();
            } catch (BadPaddingException e) {
                e.printStackTrace();
               }
               return null;
       }

       /**..
        * @param content  .....
        * @param password ....
        * @return
        */
       public static byte[] decrypt(byte[] content, String password) {
               try {
                        SecretKey secretKey = getKey(password);
                        byte[] enCodeFormat = secretKey.getEncoded();
                        SecretKeySpec key = new SecretKeySpec(enCodeFormat, "AES");
                        Cipher cipher = Cipher.getInstance("AES");// .....
                       cipher.init(Cipher.DECRYPT_MODE, key);// ...
                       byte[] result = cipher.doFinal(content);
                       return result; // ..
               } catch (NoSuchAlgorithmException e) {
                   e.printStackTrace();
               } catch (NoSuchPaddingException e) {
                   e.printStackTrace();
               } catch (InvalidKeyException e) {
                   e.printStackTrace();
               } catch (IllegalBlockSizeException e) {
                   e.printStackTrace();
               } catch (BadPaddingException e) {
                   e.printStackTrace();
               }
               return null;
       }
       
       public static SecretKey getKey(String strKey) {  
           try {           
              KeyGenerator _generator = KeyGenerator.getInstance( "AES" );  
               SecureRandom secureRandom = SecureRandom.getInstance("SHA1PRNG" );  
              secureRandom.setSeed(strKey.getBytes());  
              _generator.init(256,secureRandom);  
                  return _generator.generateKey();  
          }  catch (Exception e) {   
               throw new RuntimeException( " 初始化密钥出现异常 " );  
          }  
        }   
   }
