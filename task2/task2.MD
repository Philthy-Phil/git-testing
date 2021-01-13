# Das ist eine Wiederholung der objektorientierten Konzepte.

Bitte versuche, als Übung alles in Markdown zu beantworten. Hier ist ein [Cheatsheet](https://github.com/adam-p/markdown-here/wiki/Markdown-Cheatsheet).

### 1. Was ist das Ziel der Objektorientierung?

 * **never repeat your code**
 * **alles ist getrennt voneinander**
 * **alles ist ein Objekt**
 * **macht Vererbung möglich**
 * **Wiederverwendung von Codeblöcken**
 * **spart Arbeitszeit** 
 * **vermeidet Copy-and-Paste Fehler**

 ___

### 2. Gibt es OOP nur in Java?

 * **Nein.**
 * *Andere wären z.B. Javascript, C++, C#, PHP, Python, Ruby, ...* 

 ___

### 3. Was ist der Unterschied zwischen Objekt und Klasse?

 * **Klasse** = *die Definition was ein Objekt ausmacht (Attribute, Konstruktoren, Methoden)*
 * **Objekt** = *eine Instanz einer Klasse, kann mit Hilfe der Beschreibung der Klasse (Blueprint) erstellt werden*

 ___

### 4. Wie erzeuge ich eine neue Instanz? (Welches Schlüsselwort gibt es dafür)

 * Schlüsselwort **new**
 ```java
 Main myObj = new Main(); // creates an object of class Main (This will call the constructor)
 ```

 ___

### 5. Was bedeutet das Schlüsselwort `static` und wo kann es überall verwendet werden?

 * **static** bei ***Variablen*** -> aufrufbar ohne vorher ein Objekt der Klasse erzeugt zu haben
 
```java
 public class Static {
  
    static int number = 1;  // static
    int number2 = 2;        // non static
    
    public static void main(String[] args) {
        System.out.println(number);     // works, cause initialized static
    //  System.out.println(number2);    // doesn't work
        Static s = new Static();
        System.out.println(s.number2);  // works, cause referring to the class
    }
 }
 ```  

 * **static** bei ***Methoden*** -> aufrufbar ohne vorher ein Objekt der Klasse erzeugt zu haben

```java
 public class Static {
    
    public static void print1() {                      // static
        System.out.println("static print1");
    }
    
    public void print2() {                              // non static
        System.out.println("non static print2");
    }
    
    public static void main(String[] args) {
        
        print1();                   // works, cause initialized static
    //  print2();                   // doesn't work
        Static s = new Static();
        s.print2();                 // works, cause referring to the class
    }
 }
 ```

* **static** bei ***Statements*** -> um Klassen-Variablen zu initialisieren

```java
 public class Static {
    
    static {
        System.out.println("Static block aufgerufen");
        testStr = "Test String";
    }
        
    public static void main(String[] args) {
        testStr = "changed" + testStr;
        System.out.println(testStr);
    }
 }
 ```

 ___

### 6. Wozu dient die Vererbung?

 * Mit Hilfe der Vererbung können Programmteile wiederverwendet werden,
   dabei werden die Merkmale bereits vorhandener Klassen auf abgeleitete Klassen übertragen.

 ___

### 7. Kann in Java von mehreren Klassen geerbt werden? Wenn ja wie?

 * ***Java*** kennt ***keine Multi Inheritance*** (Mehrfach Vererbung)
    * jede Klasse (außer Object) erbt von genau einer Klasse direkt
    * kann aber beliebig viele Schnittstellen ***"implementieren"*** (Interfaces)

 ___

### 8. Welche Vererbungshierarchien kennst du? (Ein Bild reicht aus)

 * ***Single Inheritance***
 
 ```java
    public class A { ... }
    public class B extends A { ... }
 ``` 
  
 * ***Multi Inheritance***  
   
    * (DIAMOND OF DEATH) 
    
 ```
                           ↙ class A ↘
                   class B ↗         ↖ class C
                           ↖ class D ↗
 ```

 ```java
    public class A { ... }              // for example: has a method add() - our super class
    public class B extends A { ... }    // also has method add() from class A
    public class C extends A { ... }    // also has method add() from class A
    public class D extends B, C { ... } // can't be decided which add() needs invoked from class B or C
    // deshalb Achtung! --- Java Compiler Error --- Java doesn't support Multi inheritance
 ``` 
 
 * ***Multi Level Inheritance***

 ```java
    public class A { ... }              // our super class
    public class B extends A { ... }    // gets everything from class A
    public class C extends B { ... }    // gets everything from class B, also everything from class A
 ```

 * ***Hierarchical Inheritance***

 ```java
    public class A { ... }
    public class B extends A { ... }
    public class C extends A { ... }
 ``` 

___

### 9. Was bedeutet Casten und wie ist die Syntax in Java dafür?

 * primitive Datentypen aufsteigend (vom Kleinsten zum Größten):  
    *byte, short, char, int, long, float, double*
     

 * für **Upcasten** wird nichts benötigt, Voraussetzung ist, dass wir von einem kleineren Datentyp in einen größeren wollen
    z.B. 

 ```java    
    int x = 1;
    double y = x;   // y = 1.0
 ```
    
 * für **Downcasten**, wenn wir von einem größeren Datentype in einen niedrigeren wollen, müssen wir casten (Datentyp) 
    z.B.
   
 ```java    
    double x = 1.0;
    int y = x;          // Fehler, da von höher auf niedriger nicht gecastet wurde
    int y = (int) x;    // 1 hier casten wir den Typ double zu int
    // Achtung! Java rundet immer ab
 ```

 ___

### 10. Was ist der Unterschied zwischen expliziten und impliziten Typecasting?

 * siehe Punkt 9
 * explizites Typecasting ist ***Downcasten*** (vom größeren Datentyp in den kleineren)

 ```java
 public class Typecasting {
    public static void main(String[] args) {
        
        double kommaZahl = 1.0;
        int ganzZahl = 2;
        int summeGanzZahl = (int) kommaZahl + ganzZahl;
        
        System.out.println(summeGanzZahl);
        // Achtung! Java rundet default immer ab
    }
 }

 ```      

   * impliziertes Typecasting ist ***Upcasten*** (vom kleineren Datentyp in den größeren)

 ```java
 public class Typecasting {
    public static void main(String[] args) {
        
        double kommaZahl = 1.0;
        int ganzZahl = 2;
        double summeKommaZahl = kommaZahl + ganzZahl;
        
        System.out.println(summeKommaZahl);
    }
 }
 ```

 ___

### 11. Erkläre die folgenden Schlüsselwörter: `super`, `this`

 * ***this*** wird zum Auflösen von Namenskonflikten verwendet
 * ***super*** wird verwendet, um auf die Dinge in unserer Superklasse zuzugreifen

 ___

### 12. Für was dient der `instanceof` Operator. Gib ein sinnvolles Beispiel.

 * liefert einen Boolean zurück

 ```java
 interface Bird {                   // cause its an interface we're just listing our methods
    public void sing();                             
 }

 class Eagle implements Bird {      // subclass of Bird
    
    public void sing() {
        System.out.println("Singing!");    
    }
    
 }

 public class Main {
    public static void main(String[] args) {

        Eagle e = new Eagle();                  // erzeugt Instanz/Objekt Eagle 
        System.out.println(e instanceof Bird);  // checks if Eagle is an Instance of Bird
        System.out.println(e.sing());
        // because wie extends Eagle to Bird -> it returns "true"

    }
 }

 ```

 ---
 Eclipse bietet auch Markdown unterstützung inklusive Preview. Für die Verwendung muss kein Plugin installiert werden.  
 For IntelliJ IDEA you need the <a href="https://plugins.jetbrains.com/plugin/7793-markdown"> Markdown Plugin</a>.