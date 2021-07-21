## Overview
![Group-1198](https://user-images.githubusercontent.com/70335592/125410523-a0c10980-e3c5-11eb-85c3-e99214753fc5.png)

A USB token is a password-protected physical device used to store digital certificates.

 USB token based certificates are an implementation of PKCS#11, one of the Public-Key Cryptography Standards. Digital signature certificates are issued by a Certificate Authority (CA).
 
---
## PKCS#11 

The PKCS #11 standard defines a platform-independent API to cryptographic tokens, such as hardware security modules (HSM) and smart cards.

The API defines most commonly used cryptographic object types (RSA keys, X.509 Certificates, DES/Triple DES keys, etc.) and all the functions needed to use, create/generate, modify and delete those objects [Read more PKCS11]( https://docs.oracle.com/javase/7/docs/technotes/guides/security/p11guide.html#Intro).


---
##	Read certificate information from token, such as:

*	Private Key
*	Public key
*	Issuer 
*	Key usage 
*	Signature Algorithm
*	Certificate Extensions
* And a lot of information ....

---
## Specifications of the usb token that worked on :

Token name: eToken

Token category: Hardware

Product name: SafeNet eToken 5110 FIPS

Model: Token 15.0.0.3 15.0.19

Card type: Java Card

OS version: eToken Java Applet 1.8.5

---
## Add an external configuration file which content following information:

In order to enable the JDK to access the security token, you will first need to create a configuration file. Open any plain-text editor and create a file named eToken.cfg. The file should contain 2, possibly 3, lines:

* Add the username of the token <br>
* Adding the path of the library dedicated to the usb token, which is the eTPKCS11.dll library <br>
* Add the USB slot


```
name=eTokenn 
library=c:\WINDOWS\system32\eTPKCS11.dll  
slot=0
```

Note: The default slot number when left unspecified is 0. SafeNet eToken 5100 will automatically assign to slot 0, therefore there will be no need for the slot line in the .cfg file. However this may need to be changed depending on the number of eTokens/SmartCard readers installed. The default slot number for the SafeNet Ikey 4000 is slot 3. The slot line will be required when using a SafeNet iKey 4000.

---
## Also, add an external library, which is sunpkcs11.jar to run  provider PKCS11 :
```
 sun.security.pkcs11.SunPKCS11 providerPKCS11 = new sun.security.pkcs11.SunPKCS11(pkcs11Config);
```
<br>

---
## Run the program
When you run the program, a window will appear to enter the password to be able to connect to the USB Token and get the Certificates
<br>

![PKI23](https://user-images.githubusercontent.com/70335592/126527885-e50af583-0970-4032-ae43-776b42326524.png)

<br>

```
 KeyStore.CallbackHandlerProtection chp = new KeyStore.CallbackHandlerProtection(new MyGuiCallbackHandler() {});
 KeyStore.Builder builder = KeyStore.Builder.newInstance("PKCS11", null, chp);
 KeyStore keyStore = builder.getKeyStore();
 ```
