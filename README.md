# Radix

A simple java API to transform numbers in any radix.

The root class is org.lioda.radix.Polynomial.

For example : 

```java
Polynomial polynomial = new Polynomial("123", 10);
String hexValue = polynomial.toString(16); // "7B"
```

The polynomial representation of 123 in hexadecimal is : 
```
7 * 16^1 + 11 * 16^0 // 7B
```

We can provide a character set to render it by "7B" or any means.
If the characters need to be [A-Z], then 123 is "HL" :)