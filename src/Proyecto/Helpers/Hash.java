package Proyecto.Helpers;

import java.math.BigInteger;
import java.security.MessageDigest;

public class Hash {

	public static String Encriptar(String texto) {

        MessageDigest md;

        try {

            md = MessageDigest.getInstance("SHA");
            byte[] hash = md.digest(texto.getBytes("UTF-8"));
            
            //MAs seguridad, transfromando de HASH a binario
            
            BigInteger no = new BigInteger(1, hash);
            String EncryptedPass = no.toString(16);
            while (EncryptedPass.length()<32) {
            	EncryptedPass = "0" + EncryptedPass;
            }
            return EncryptedPass;
        } catch (Exception ex) {
        	
        	
        }
       return "500";
}
	
}
