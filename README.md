# factura-codigo-control-java
Generador de codigo de control para facturas dentro del Servicio Nacional de Impuestos de Bolivia escrito en Java.

Forma de Uso:

```java
String code = new FacturaCodigoControl.Builder()
                .authorization("29040011007")
                .nit("4189179011")
                .number(1503)
                .date(new SimpleDateFormat("yyyyMMdd").parse("20070702"))
                .amount(2500.0)
                .key("9rCB7Sv4X29d)5k7N%3ab89p-3(5[A")
                .build();
```

Tambien se puede omitir el Nit si es que es 0

```java
String code = new FacturaCodigoControl.Builder()
                .authorization("29040011007")
                .number(1503)
                .date(new SimpleDateFormat("yyyyMMdd").parse("20070702"))
                .amount(2500.0)
                .key("9rCB7Sv4X29d)5k7N%3ab89p-3(5[A")
                .build();
```
