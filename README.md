# Radix

A simple java API to transform numbers in any radix.

The root class is org.lioda.radix.Polynomial.

For example : 

```java
Polynomial polynomial = new Polynomial("123", 10);
String hexValue = polynomial.toString(16); // "7B"
```
