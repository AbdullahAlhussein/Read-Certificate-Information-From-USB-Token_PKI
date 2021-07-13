## Overview

A USB token is a password-protected physical device used to store digital certificates.

 USB token based certificates are an implementation of PKCS#11, one of the Public-Key Cryptography Standards. Digital signature certificates are issued by a Certificate Authority (CA).
 
---
##	Read certificate information from token, such as:

A.	Issuer 

B.	Subject Name

C.	Public key

D.	Key length 

E.	Key usage

F.	Signature algorithm 

---
## Specifications of the usb token that worked on :

Token name: My Token

Token category: Hardware

Product name: SafeNet eToken 5110 FIPS

Model: Token 15.0.0.3 15.0.19

Card type: Java Card

OS version: eToken Java Applet 1.8.5

---
## Add an external configuration file which content following information:

In order to enable the JDK to access the security token, you will first need to create a configuration file. Open any plain-text editor and create a file named eToken.cfg. The file should contain 2, possibly 3, lines:
```
name=eTokenn 
library=c:\WINDOWS\system32\eTPKCS11.dll  
slot=3 
```

* Add the username of the token <br>
* Adding the path of the library dedicated to the usb token, which is the eTPKCS11.dll library <br>
* Add the USB slot


Note: The default slot number when left unspecified is 0. SafeNet eToken 5100 will automatically assign to slot 0, therefore there will be no need for the slot line in the .cfg file. However this may need to be changed depending on the number of eTokens/SmartCard readers installed. The default slot number for the SafeNet Ikey 4000 is slot 3. The slot line will be required when using a SafeNet iKey 4000.

---
## Also, add an external library, which is sunpkcs11.jar to run this code :
```
 sun.security.pkcs11.SunPKCS11 providerPKCS11 = new sun.security.pkcs11.SunPKCS11(pkcs11Config);
```
