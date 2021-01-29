# 11주차 : Enum

# 목표

## 자바의 열거형에 대한 학습.

---

# 학습할 것

## 💭 enum 정의하는 방법

### Enums

→ 특정 역할을 수행하는데 사용되는 class or interface 중 하나.

> We want to define a type to represent something,
and these to be the only possible values of the type.

⇒ 어떤 타입을 정의하고, 그 타입에서 가능한 것들만 나열해놓는 것.

```cpp
public enum PrimaryColor{
	RED, GREEN, BLUE
}
```

### 사용 시

```cpp
PrimaryColor.RED,  PrimaryColor.Green,  PrimaryColor.BLUE
```

### 멤버 필드, 메소드

Enum도 Class이므로, field, method를 가질 수 있다.

### Java 만의 특징

C++에서는 상수로만 정의 가능하다.

But, Java에서는 더 유연하고 많은 유형을 제공한다.

⇒ 이게 무슨 말일까?  C++도 Java와 비슷한 것 같은데,,,
→ C/C++ 의 enum은 결국 int 이다.  **`but, Java는 완전한 Class이다.`**

[Other data types](http://www.cplusplus.com/doc/tutorial/other_data_types/)

### Enum의 특징.

- **java.lang.Enum을 상속받는다.**
- **generic이 될 수 없다.**
- **Interface를 구현할 수 있다.**
- **상속 될 수 없다.**
- **모든 enum values들이 구현됐을 때만 추상메소드를 가질 수 있다. ???**
- **new로 바로 인스턴스화 될 수 없다.**
- **Enum은 Runtime에 생성되고,
외부에서 Instance화 할 수 없다.
⇒ 생성자 비공개로 인스턴스 생성을 제한한다. ⇒ 상수는 다른 값으로 할당 되면 안되므로,**

### Example

Triangle, square, pentagon, hexagon 을 만든다고 할 때.

원래라면,  new Triangle() ,  new Pentagon()  ...를 class를 사용하는 입장에서 매개변수를 전달해야 할 것 이다.

하지만, RegularPolygon 이라는 class 내부에 Enum 타입을 선언해놓으면 class 내부에서 할 수 있는 것 같다.

단지 RegularPolygon 생성자에 sides에 해당하는 int를 넣어주면, 그에 맞게 다른 Class의 Instance가 생성된다.

```java
public enum RegularPolygon {
		// The ; is mandatory for enums that have parameters
		**TRIANGLE(3), SQUARE(4), PENTAGON(5), HEXAGON(6);**
		private Shape shape;
		
		public Shape getShape() {
				return shape;
		}
		private RegularPolygon(int sides) {
				switch (sides) {
						case 3:
							shape = new Triangle(1,1,1,60,60,60);
							break;
						case 4:
							shape = new Rectangle(1,1);
							break;
						case 5:
							shape = new Pentagon(1,1,1,1,1,108,108,108,108,108);
							break;
						case 6:
							shape = new Hexagon(1,1,1,1,1,1,120,120,120,120,120,120);
							break;
				}
		}
}
```

**TRIANGLE(3), SQUARE(4), PENTAGON(5), HEXAGON(6);**

이부분을 통해 문자로 접근하던 것을 원하는 매개변수를 통해 접근하도록 할 수 있다.

## 💭 실습

```java
import java.sql.SQLOutput;

public enum Tottenham {

    //상수를 지정해준다.
    HarryKane(10, "20만 파운드"),
    TanguyNdombele(28, "20만 파운드"),
    HeungminSon(7, "14만 파운드"),
    HugoLloris(1, "10만 파운드"),
    DeleAlie(20, "10만 파운드"),
    LucasMoura(27, "8만 파운드");

    private String pay;
    private int number;
    private Tottenham(int number, String pay){
        this.number = number; this.pay = pay;
        System.out.println(this+"의 등번호 : "+this.number);
        System.out.println(this+"의 주 급 : "+this.pay);
    }

    public static void main(String[] args) {
        Tottenham player;
        player = Tottenham.HeungminSon;

        System.out.println(player);
    }
}
```

![11%E1%84%8C%E1%85%AE%E1%84%8E%E1%85%A1%20Enum%20dde4e9af0c06410cab09bf7b70e06b28/Untitled.png](11%E1%84%8C%E1%85%AE%E1%84%8E%E1%85%A1%20Enum%20dde4e9af0c06410cab09bf7b70e06b28/Untitled.png)

**HeungminSon 만 불렀는데, 모든 enum이 다 출력되었다.**

## 💭 Enum의 장점

( 우아한 형제들 기술 블로그 ) 

[Java Enum 활용기 - 우아한형제들 기술 블로그](https://woowabros.github.io/tools/2017/07/10/java-enum-uses.html)

- 문자열과 비교하기 떄문에 IDE의 적극적인 지원.
    - 자동완성, 오타검증, 텍스트 리팩토리 등
- 허용 가능한 값들을 **제한**.
- Enum코드만 수정해서 리팩토링 가능.

## 💭 java.lang.Enum

`public abstract class Enum<E extends Enum<E>>`

`extends Object`

`implements Constable, Comparable<E>, Serializable`

[Enum (Java SE 15 & JDK 15)](https://docs.oracle.com/en/java/javase/15/docs/api/java.base/java/lang/Enum.html)

## 💭 enum이 제공하는 메소드(values()와 valueOf())

### valueOf()

public static <T extends Enum<T>> T valueOf(Class<T> enumType, String name)

- **매개변수**
    - T - 상수를 반환 할 enum 의 타입
    - enumType - 정의한 enum Class
    - name - 반환할 상수의 이름
- **반환 값**
    - 이름에 매칭되는 상수화된 enum 을 반환.
- **예외**
    - IllegalArgumentException - 지정해 둔 enum type 상수가 없을 경우 or enum Class 에 맞지 않는 경우
    - NullPointerException - enumType or name 이 null 일 때.

```java
System.out.println(player.valueOf(LucasMoura.name()));
```

**⇒ LucasMoura**

### values() ??? docs에 없다.

```java
System.out.println(player.values());
System.out.println(player.HeungminSon.values());
System.out.println(Tottenham.values());
```

**⇒ [LTottenham;@1b6d3586** 

**⇒ [LTottenham;@1b6d3586**

**⇒ [LTottenham;@4554617c**

// 주소값이 출력된다.

```java
System.out.println(Arrays.toString(Tottenham.values()));
```

**⇒ [HarryKane, TanguyNdombele, HeungminSon, HugoLloris, DeleAlie, LucasMoura]**

// intelliJ가 하라는데로 하면 Array를 출력하게 되는데, 이때 모든 enum값을 준다.

모든 enum type은 values()메소드를 호출해서  

## 💭 EnumSet

[EnumSet (Java SE 15 & JDK 15)](https://docs.oracle.com/en/java/javase/15/docs/api/java.base/java/util/EnumSet.html)

Interface Set<E> 가 구현되어 있다.

> A specialized Set implementation for use with enum types

enum types를 위한 set인 것 같다.

set : 자료구조 중, 중복을 허용하지 않는 자료구조.

- 상수만 나열할 때, 가독성이 좋지 않은 경우가 있다.

    → enumSet에 문자열 등을 넣어 관리할 수 있다.

### Method

`EnumSet enumSet1 = EnumSet.noneOf(DayOfWeek.class);`
*//DayOfWeek라는 Enum을 다루는 Set으로 비어있는 Set을 반환*

`EnumSet enumSet2 = EnumSet.allOf(DayOfWeek.class);`
*//모든 DayOfWeek Enum의 값을 담고있는 Set을 반환*

`public static <E extends Enum<E>> EnumSet<E> complementOf(EnumSet<E> s)`
// 매개 변수의 EnumSet<E> s 에 포함되어 있지 않은 요소들을 포함하는(차집합) enumSet 생성.

### 유사 :  EnumMap

---

# 마감 일시

## 2021년 1월 30일 13시

---