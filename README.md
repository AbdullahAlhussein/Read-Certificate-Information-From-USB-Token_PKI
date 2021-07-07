# Read-Certificate-Information-From-USB-Token

## 1.	Read certificate information from token, such as:

A.	Issuer 

B.	Subject Name

C.	Public key

D.	Key length 

E.	Key usage

F.	Signature algorithm 


# Specifications of the usb token that worked on :

Token name: My Token

Token category: Hardware

Product name: SafeNet eToken 5110 FIPS

Model: Token 15.0.0.3 15.0.19

Card type: Java Card

OS version: eToken Java Applet 1.8.5


# Add an external configuration file which content following information:

Adding the path of the library dedicated to the usb token, which is the eTPKCS11.dll library

Add the USB slot

Add the username of the token

# Also, add an external library, which is sunpkcs11.jar to run this code :

code : sun.security.pkcs11.SunPKCS11 providerPKCS11 = new sun.security.pkcs11.SunPKCS11(pkcs11Config);
