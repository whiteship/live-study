# 8주차 : 인터페이스

# 목표

## 자바의 인터페이스

---

# 학습할 것

## 💭 인터페이스

### 역할

- **규칙을 정의**한다.
- 공통적인 부분을 추상화한다. (**다형성**)

### 메소드

- 구현부가 없는 메소드로 이루어져있다.  ( **추상메소드** )
- 구현 클래스에서 반드시 **추상메소드 모두를 구현**해야 한다.  X→ Compile Error
- abstract 키워드를 붙이지 않으면 컴파일러가 abstract 키워드를 붙인다.
public abstract method()  (바이트코드)

### 변수

- 상수만 사용할 수 있다.
- 그냥 변수로 선언 시 컴파일러가 final 키워드를 붙인다.
public final variable = 1

### 상속

- 인터페이스 사이에 다중 상속이 가능하다. ⇒ 클래스와의 차이점.
- 구체 클래스에서는 인터페이스를 <구현>/<implements> 한다.

### 정의

```java
interface **Centered** {
		void setCenter(double x, double y);
		double getCenterX();
		double getCenterY();
}
```

- **규칙을 정의했다.**
    - Center 좌표를 set 하는 규칙.
    - Center의 X좌표를 반환하는 규칙.
    - Center의 Y좌표를 반환하는 규칙.

- **내부에 구현되지 않은 추상메소드가 있다.**
    - setCenter(double x, double y) 메소드
    - getCenterX() 메소드
    - getCenterY() 메소드

## 💭 인터페이스 구현하는 방법

- 인터페이스 내부의 **추상메소드는 반드시 구체클래스에서 구현**되어야 한다.

### 구현

```java
public class CenteredRectangle implements Centered {
		// New instance fields
		private double cx, cy;

		// implementations of all the Centered methods.
		public void setCenter (double x, double y) { cx = x;  cy = y; }
		public double getCenterX()  { return cx; }
		public double getCenterY()  { return cy; }
}
```

- @Override 애노테이션을 이용하여 오버라이드 판별.
- 구체클래스 Human은 Walkable의 walk() 규칙을 만족하도록 **구현**해준다.
- 구체클래스 Bird는 Flyable의 fly() 규칙을 만족하도록 **구현**해준다.

## 💭 인터페이스 레퍼런스를 통해 구현체를 사용하는 방법

```java
public interface Mac {
    void modelName();
}

class MacBookAir implements Mac{

    public void modelName() {
        System.out.println("This is MacBookAir4");
    }
    public void price(){
        System.out.println("1,600,000 won");
    }
}

class MacBookPro implements Mac{
    public void modelName(){
        System.out.println("This is MacBookPro");
    }
    public void price(){
        System.out.println("2,000,000 won");
    }
}
```

![8%E1%84%8C%E1%85%AE%E1%84%8E%E1%85%A1%20%E1%84%8B%E1%85%B5%E1%86%AB%E1%84%90%E1%85%A5%E1%84%91%E1%85%A6%E1%84%8B%E1%85%B5%E1%84%89%E1%85%B3%20b17b84f78b944118a6209844e8031bf8/Untitled.png](8%E1%84%8C%E1%85%AE%E1%84%8E%E1%85%A1%20%E1%84%8B%E1%85%B5%E1%86%AB%E1%84%90%E1%85%A5%E1%84%91%E1%85%A6%E1%84%8B%E1%85%B5%E1%84%89%E1%85%B3%20b17b84f78b944118a6209844e8031bf8/Untitled.png)

- MacBookAir , MacBookPro 각 클래스의 인스턴스는 price() 메소드를 사용할 수 있다.
- Mac (인터페이스) 형태의 인스턴스는 price() 를 사용할 수 없다.

### 캐스팅

Mac 타입의 인스턴스를  price()메소드가 있는 클래스 형태로 캐스팅한다.

![8%E1%84%8C%E1%85%AE%E1%84%8E%E1%85%A1%20%E1%84%8B%E1%85%B5%E1%86%AB%E1%84%90%E1%85%A5%E1%84%91%E1%85%A6%E1%84%8B%E1%85%B5%E1%84%89%E1%85%B3%20b17b84f78b944118a6209844e8031bf8/Untitled%201.png](8%E1%84%8C%E1%85%AE%E1%84%8E%E1%85%A1%20%E1%84%8B%E1%85%B5%E1%86%AB%E1%84%90%E1%85%A5%E1%84%91%E1%85%A6%E1%84%8B%E1%85%B5%E1%84%89%E1%85%B3%20b17b84f78b944118a6209844e8031bf8/Untitled%201.png)

![8%E1%84%8C%E1%85%AE%E1%84%8E%E1%85%A1%20%E1%84%8B%E1%85%B5%E1%86%AB%E1%84%90%E1%85%A5%E1%84%91%E1%85%A6%E1%84%8B%E1%85%B5%E1%84%89%E1%85%B3%20b17b84f78b944118a6209844e8031bf8/Untitled%202.png](8%E1%84%8C%E1%85%AE%E1%84%8E%E1%85%A1%20%E1%84%8B%E1%85%B5%E1%86%AB%E1%84%90%E1%85%A5%E1%84%91%E1%85%A6%E1%84%8B%E1%85%B5%E1%84%89%E1%85%B3%20b17b84f78b944118a6209844e8031bf8/Untitled%202.png)

## 💭 인터페이스 상속

### **인터페이스를 extends할 경우 superInterface의 모든 abstract methods들을 구현해야한다.**

```java
interface **Positionable** extends **Centered** {
		void setUpperRightCorner(double x, double y);
		double getUpperRightX();
		double getUpperRightY();
}
interface **Transformable** extends **Scalable, Translatable, Rotatable** {}
interface **SuperShape** extends **Positionable, Transformable** {}
```

- **Transformable 인터페이스는**

    **Scalable의 추상 메소드,
    Translatable의 추상 메소드,
    Rotatable의 추상 메소드**

    를 모두 구현해야한다.

- **SuperShape 인터페이스는**

    **Positionable의 추상 메소드,
    Transformable의 추상 메소드**

    를 모두 구현해야한다.

### **상속**과 **구현**을 동시에 할 수 있다.

- 상속 받은 Rectangle의 필드, 메소드를 모두 가진다.
- 구현 할 Centered의 추상 메소드를 모두 구현해야한다.

> **NOTE**
Interfaces are data types in Java, just like classes. When a class implements an interface, instances of that class can be assigned to variables of the interface type.

```java
public class CenteredRectangle extends Rectangle implements Centered {
		...   inherit
		...   implement
}
```

## 💭 인터페이스의 기본 메소드 (Default Method), 자바 8

> From Java 8 onward, it is possible to declare methods in interfaces that include an implementation. In this section, we’ll discuss these methods, which should be understood as optional methods in the API the interfaces represent they’re usually called default methods. Let’s start by looking at the reasons why we need the default mechanism in the first place.

- Mac 인터페이스를 구현하는 각 모델 클래스는 이름이 다를 것이다.
modelName() 을 따로 따로 구현해 줄 필요가 있다.
- 하지만, brand()는 apple로 매번 같을 텐데 ? 
**- Java8 부터 default 메소드로 선언을 하면 공통적인 메소드를 만들 수 있다.**

```java
public interface Mac {
    void modelName();
    
		default void brand(){
        System.out.println("apple");
    }
}
```

```java
public class Main {
    public static void main(String[] args) {
        MacBookAir air = new MacBookAir();
        MacBookPro pro = new MacBookPro();

        air.brand();
        pro.brand();
    }
}
```

![8%E1%84%8C%E1%85%AE%E1%84%8E%E1%85%A1%20%E1%84%8B%E1%85%B5%E1%86%AB%E1%84%90%E1%85%A5%E1%84%91%E1%85%A6%E1%84%8B%E1%85%B5%E1%84%89%E1%85%B3%20b17b84f78b944118a6209844e8031bf8/Untitled%203.png](8%E1%84%8C%E1%85%AE%E1%84%8E%E1%85%A1%20%E1%84%8B%E1%85%B5%E1%86%AB%E1%84%90%E1%85%A5%E1%84%91%E1%85%A6%E1%84%8B%E1%85%B5%E1%84%89%E1%85%B3%20b17b84f78b944118a6209844e8031bf8/Untitled%203.png)

## 💭 인터페이스 static 메소드, 자바 8

> As of Java 8, an interface may contain static methods. Previous versions of Java did not allow this, and this is widely believed to have been a flaw in the design of the Java language.

- **default 메소드는 재정의가 가능하다.**
- **static 메소드는 재정의를 방지한다.**

+ **인스턴스 없이 수행할 수 있는 작업 정의**

```java
public interface Mac {
    void modelName();
    default void brand(){
        System.out.println("apple");
    }
    static void cpu(){
        System.out.println("M1");
    }
}

public static void main(String[] args){
		MacBookAir.cpu();
}
```

![8%E1%84%8C%E1%85%AE%E1%84%8E%E1%85%A1%20%E1%84%8B%E1%85%B5%E1%86%AB%E1%84%90%E1%85%A5%E1%84%91%E1%85%A6%E1%84%8B%E1%85%B5%E1%84%89%E1%85%B3%20b17b84f78b944118a6209844e8031bf8/Untitled%204.png](8%E1%84%8C%E1%85%AE%E1%84%8E%E1%85%A1%20%E1%84%8B%E1%85%B5%E1%86%AB%E1%84%90%E1%85%A5%E1%84%91%E1%85%A6%E1%84%8B%E1%85%B5%E1%84%89%E1%85%B3%20b17b84f78b944118a6209844e8031bf8/Untitled%204.png)

## 💭 인터페이스 private 메소드, 자바 9

> As of Java 9, an interface may contain private methods. These have limited use cases, but with the other changes to the interface construct, it seems arbitary to disallow them. It is a compile­ time error to try to define a protected method in an interface.

### < Java8의 Default, Static 의 단점 >

- 특정 기능을 수행하는데, public으로 된다.
- Access or Inherit 을 방지할 필요가 있다.

      ⇒  private 제어가 필요하다.   (캡슐화)

### private method & private static method

- private 의 특성을 살려 클래스 내부에서 사용할 수 있다.
non-static 에서 호출 or static 에서 호출

![8%E1%84%8C%E1%85%AE%E1%84%8E%E1%85%A1%20%E1%84%8B%E1%85%B5%E1%86%AB%E1%84%90%E1%85%A5%E1%84%91%E1%85%A6%E1%84%8B%E1%85%B5%E1%84%89%E1%85%B3%20b17b84f78b944118a6209844e8031bf8/Untitled%205.png](8%E1%84%8C%E1%85%AE%E1%84%8E%E1%85%A1%20%E1%84%8B%E1%85%B5%E1%86%AB%E1%84%90%E1%85%A5%E1%84%91%E1%85%A6%E1%84%8B%E1%85%B5%E1%84%89%E1%85%B3%20b17b84f78b944118a6209844e8031bf8/Untitled%205.png)

Java8은 바꿨는데 Java9는 어떻게...?

⇒ JDK 9를 설치한다.

Java5에서 8로는 왜 바로 바꼈을까?

⇒ Language Level 변경  Java5가 아니라 level5

---

# 마감 일시

## 2021년 1월 9일 오후 1시

---