
// import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.security.Key;
import javax.crypto.Cipher;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.DESedeKeySpec;
import javax.crypto.spec.IvParameterSpec;
import java.util.Base64;
// import java.util.Base64.Encoder;

/**
 *
 *
 *
 * working only with jdk8
 *
 *
 */

public class TDes {

  public static void main(String[] args) {
    

  }

  private static byte[] key = { 0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00,
      0x00, 0x01, 0x01, 0x01, 0x01, 0x01, 0x01, 0x01, 0x01, 0x02, 0x02,
      0x02, 0x02, 0x02, 0x02, 0x02, 0x02 };

  private static byte[] keyiv = { 0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00,
      0x00 };

  public static String encode(String args) {

    System.out.println("plain data==>  " + args);

    byte[] encoding;
    try {
      encoding = Base64.getEncoder().encode(args.getBytes("UTF-8"));

      System.out.println("Base64.encodeBase64==>" + new String(encoding));
      byte[] str5 = des3EncodeCBC(key, keyiv, encoding);

      System.out.println("des3EncodeCBC==>  " + new String(str5));

      byte[] encoding1 = Base64.getEncoder().encode(str5);
      System.out.println("Base64.encodeBase64==> " + new String(encoding1));
      return new String(encoding1);
    } catch (UnsupportedEncodingException e) {
      // TO DO
      e.printStackTrace();
    }
    return null;
  }

  public static String decode(String args) {
    try {
      System.out.println("encrypted data==>" + new String(args.getBytes("UTF-8")));

      byte[] decode = Base64.getDecoder().decode(args.getBytes("UTF-8"));
      System.out.println("Base64.decodeBase64(main encription)==>" + new String(decode));

      byte[] str6 = des3DecodeCBC(key, keyiv, decode);
      System.out.println("des3DecodeCBC==>" + new String(str6));
      String data = new String(str6);
      byte[] decode1 = Base64.getDecoder().decode(data.trim().getBytes("UTF-8"));
      System.out.println("plaintext==>  " + new String(decode1));
      return new String(decode1);
    }
    // TO DO
    catch (Exception e) {
      e.printStackTrace();
    }
    return "u mistaken in try block";
  }
