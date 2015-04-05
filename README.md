# factura-codigo-control-java
Generador de codigo de control para facturas dentro del Servicio Nacional de Impuestos de Bolivia escrito en Java.

## Como Agregar al proyecto

El generador de codigo de control puede ser agregado como dependencia ya sea por maven o gradle de la siguiente forma:

### Maven

Agregar el repositorio Jitpack en el  archivo pom.xml

```xml
    <repository>
	    <id>jitpack.io</id>
	    <url>https://jitpack.io</url>
	</repository>
```
Agregar la dependencia a la libreria en el  archivo pom.xml

```xml
    <dependency>
	    <groupId>com.github.mobilebits-bolivia.factura-codigo-control-java</groupId>
	    <artifactId>facturacodigocontrol</artifactId>
	    <version>1.01-SNAPSHOT</version>
	</dependency>
```

### Gradle

Agregar el repositorio Jitpack en el  archivo build.gradle

```java
    repositories {
    	    maven {
    	        url "https://jitpack.io"
    	    }
    	}
```

Agregar la dependencia a la libreria en el  archivo build.gradle

```java
    compile 'com.github.mobilebits-bolivia:factura-codigo-control-java:facturacodigocontrol:1.01-SNAPSHOT'
```

## Forma de Uso:

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
