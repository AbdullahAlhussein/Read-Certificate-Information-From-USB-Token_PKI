
import java.security.Provider;
import java.security.cert.Certificate;
import java.security.cert.X509Certificate;
import java.security.KeyStore;
import java.security.Key;


public class eToken_21 {
	    
	public static void main(String[] args){

    try {
		
	    	// Create instance of SunPKCS11 provider  
	     	String pkcs11Config = "C:\\Users\\Hello\\eclipse-workspace\\eToken_21\\config.cfg";
	    	java.io.ByteArrayInputStream pkcs11ConfigStream = new java.io.ByteArrayInputStream(pkcs11Config.getBytes());
		sun.security.pkcs11.SunPKCS11 providerPKCS11 = new sun.security.pkcs11.SunPKCS11(pkcs11Config);
		java.security.Security.addProvider(providerPKCS11);
		    

		// Get provider KeyStore and login with PIN 
	        KeyStore.CallbackHandlerProtection chp = new KeyStore.CallbackHandlerProtection(new MyGuiCallbackHandler() {});
	        KeyStore.Builder builder = KeyStore.Builder.newInstance("PKCS11", null, chp);
	        KeyStore keyStore = builder.getKeyStore();
	    
		    
	   
	        // Enumerate items (certificates and private keys) in the KeyStore
	        java.util.Enumeration<String> aliases = keyStore.aliases();	 
	        String alias = null;   
	     
	        while (aliases.hasMoreElements()) {
	        	
 
	        // load keystore present and print aliases found (only one, so nextElement always prints same information (name of certificate inside usb token I want to open)
	        alias = aliases.nextElement();
	      
	        Certificate cert = keyStore.getCertificate(alias);
                Key key = keyStore.getKey(alias,  null); // Here I try to access the private key of my hardware certificate
                System.out.println("Algorithm  :: " + key.getAlgorithm());
                System.out.println("access private key :: " + key);
             
                X509Certificate x509Certificate =  (X509Certificate)cert ;
              
                System.out.println("SubjectAlternativeNames  :: " + x509Certificate.getSubjectAlternativeNames());
                System.out.println("IssuerDN   :: " + x509Certificate.getIssuerDN());
                System.out.println("SubjectDN  :: " + x509Certificate.getSubjectDN());
                System.out.println("PublicKey  :: " + x509Certificate.getPublicKey());
                
             
               // print all certificate information
               // System.out.println(cert);
                
                
                System.out.println("\n @@@@@@@@@@@@@@@@@@ Next Certificate @@@@@@@@@@@@@@@@@@@ \n");
                
         }
}
    
    catch(Exception e) {
	
    	e.printStackTrace();
	
    }
	       
  }
	
}
