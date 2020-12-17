# 3주차 : 연산자

# 목표

## 자바가 제공하는 다양한 연산자 학습.

---

# 학습할 것

## 산술 연산자

- Addition (+)

    **+가  되는 과정.**

    ![3%E1%84%8C%E1%85%AE%E1%84%8E%E1%85%A1%20%E1%84%8B%E1%85%A7%E1%86%AB%E1%84%89%E1%85%A1%E1%86%AB%E1%84%8C%E1%85%A1%20ac4c7d407bd7446fb67434145a765e58/Untitled.png](3%E1%84%8C%E1%85%AE%E1%84%8E%E1%85%A1%20%E1%84%8B%E1%85%A7%E1%86%AB%E1%84%89%E1%85%A1%E1%86%AB%E1%84%8C%E1%85%A1%20ac4c7d407bd7446fb67434145a765e58/Untitled.png)

0번 bit 의 1 + 1 에 의해 
**carry**  :  1
1번 bit 의 1 + C 에 의해 2bit가 넘어 **overflow** : 1

carry와 overflow 는 상태 레지스터에 flag 로 저장된다.

- Subtraction (-)

    ![3%E1%84%8C%E1%85%AE%E1%84%8E%E1%85%A1%20%E1%84%8B%E1%85%A7%E1%86%AB%E1%84%89%E1%85%A1%E1%86%AB%E1%84%8C%E1%85%A1%20ac4c7d407bd7446fb67434145a765e58/Untitled%201.png](3%E1%84%8C%E1%85%AE%E1%84%8E%E1%85%A1%20%E1%84%8B%E1%85%A7%E1%86%AB%E1%84%89%E1%85%A1%E1%86%AB%E1%84%8C%E1%85%A1%20ac4c7d407bd7446fb67434145a765e58/Untitled%201.png)

    -  연산은 빼려는 수를 **2의 보수** 처리 한 후, + 연산을 진행한다.
    이때, 비트 연산자를 추가하여 양수, 음수를 구분해준다.
    ⇒ 결과물에서 비트에 맞는 수만 읽으면 결과물을 확인할 수 있다.

- Multiplication (*)
- Division (/)

⇒ 곱셈과 나눗셈은  반복적인  덧셈, 뺄셈과  시프트 연산으로 수행.
시프트 연산 : 

![3%E1%84%8C%E1%85%AE%E1%84%8E%E1%85%A1%20%E1%84%8B%E1%85%A7%E1%86%AB%E1%84%89%E1%85%A1%E1%86%AB%E1%84%8C%E1%85%A1%20ac4c7d407bd7446fb67434145a765e58/Untitled%202.png](3%E1%84%8C%E1%85%AE%E1%84%8E%E1%85%A1%20%E1%84%8B%E1%85%A7%E1%86%AB%E1%84%89%E1%85%A1%E1%86%AB%E1%84%8C%E1%85%A1%20ac4c7d407bd7446fb67434145a765e58/Untitled%202.png)

 bit 가 1개 씩 이동할 때마다 *2의 값을 얻을 수 있다.

- Modulo (%)
- Unary minus (-)

## 비트 연산자

![3%E1%84%8C%E1%85%AE%E1%84%8E%E1%85%A1%20%E1%84%8B%E1%85%A7%E1%86%AB%E1%84%89%E1%85%A1%E1%86%AB%E1%84%8C%E1%85%A1%20ac4c7d407bd7446fb67434145a765e58/Untitled%203.png](3%E1%84%8C%E1%85%AE%E1%84%8E%E1%85%A1%20%E1%84%8B%E1%85%A7%E1%86%AB%E1%84%89%E1%85%A1%E1%86%AB%E1%84%8C%E1%85%A1%20ac4c7d407bd7446fb67434145a765e58/Untitled%203.png)

- Bitwise complement (~)
- Bitwise AND (&)
- Bitwise OR (|)
- Bitwise XOR (^)
- Left shift (<<)
**left는 MSB가 새로 생기는 것이 아니라서 공통.**

![3%E1%84%8C%E1%85%AE%E1%84%8E%E1%85%A1%20%E1%84%8B%E1%85%A7%E1%86%AB%E1%84%89%E1%85%A1%E1%86%AB%E1%84%8C%E1%85%A1%20ac4c7d407bd7446fb67434145a765e58/Untitled%204.png](3%E1%84%8C%E1%85%AE%E1%84%8E%E1%85%A1%20%E1%84%8B%E1%85%A7%E1%86%AB%E1%84%89%E1%85%A1%E1%86%AB%E1%84%8C%E1%85%A1%20ac4c7d407bd7446fb67434145a765e58/Untitled%204.png)

[http://blog.naver.com/PostView.nhn?blogId=wooin0707&logNo=221591437956](http://blog.naver.com/PostView.nhn?blogId=wooin0707&logNo=221591437956)

하지만, 우측 연산은 MSB를 추가하기 때문에 구분해주어야 한다.

- Signed right shift (>>)
- unsigned right shift (>>>)

## 관계 연산자

- Equals (==)
- Not equals (!=)
- Less than (<)
- Less than or equal (<=)
- Greater than (>)
- Greater than or equal (>=)

## 논리 연산자

### 비트 연산과 논리 연산의 차이

비트 연산 :  **0과 1**  (값의 비트) 를 비트 연산자로 다룬다.
논리 연산 :  **true, false**  (boolean)을 논리 연산자로 다룬다.

- Conditional And (&&)
- Conditional OR (| |)
- Boolean NOT (!)
- Boolean AND (&)
- Boolean OR (|)
- Boolean XOR (^)

## instanceof

- 타입을 알아보기 위한 사용.
- 형변환이 가능한지에 대한 사용.

👎🏾 사실 안쓰는게 좋다고 한다. 잘못된, 의심스러운 설계의 증거가 될 수 있음.

```java
"string" instanceof String           // True: all strings are instances of String
"" instanceof Object                 // True: strings are also instances of Object              
null instanceof String               // False: null is never an instance of anything

Object o = new int[] {1,2,3};
o instanceof int[]                // True: the array value is an int array
o instanceof byte[]               // False: the array value is not a byte array
o instanceof Object               // True: all arrays are instances of Object

// Use instanceof to make sure that it is safe to cast an object
if (object instanceof Point) {
Point p = (Point) object;
}
```

## assignment(=) operator

=== 할당 연산자

=, /=, %=, &=, |=, ^=, >>=, >>>=, <<=

## 화살표(->) 연산자

=== Lambda expression

(매개변수, ...)  - > { 실행문 ... }         // 매개변수 0개 이상.

```java
num.add((a, b) -> {
	return a+b;
});
```

## 3항 연산자

### 간단 3항 연산자 예시

```java
int max = (x > y) ? x : y;
String name = (name != null) ? name : "unknown";
```

### 3항 연산자 중첩.

```java
(a > b) ? "a는 b보다 크다" : (a < b) ? "b는 a보다 크다" : "a와 b는 같다."
```

## 연산자 우선 순위

- 최우선연산자 ( ., [], (), 후위연산자 )
- 단항연산자 ( ++,--, (전위연산자), !, ~, +/- : 부정, bit변환>부호>증감)
- new, (type, any)
- 산술연산자 ( *,/,%,+,-,shift)
- 시프트연산자 ( >>,<<,>>> )
- 비교연산자 ( >,<,>=,<=,==,!= )
- 비트연산자 ( &,|,,~ )
- 논리연산자 (&& , || , !)
- 삼항연산자 (조건식) ? :
- 대입연산자 =,*=,/=,%=,+=,-=
- 람다표현식 →

### 후위 연산자 vs 전위 연산자

후위 연산자는 temp 를 만들어 전개를 하여 살짝 느릴 수 있다.
→ 하지만 요즘은 컴파일러의 최적화가 뛰어나 거의 차이가 없다.

## (optional) Java 13.switch 연산자

**이전 Java와 차이점. *yield***

yield :  "다른 스레드에게 실행 양보"
→ 더이상 제어를 안해도 되기 때문에 (스레드 상태 제어)

```java
case "a":
case "b":
	break 1;
case "c":
	break 2;
```

break vs yield 의 차이를 모르겠다

```java
case "a", "b":
	yield 1;
case "c":
	yield 2;
```

### thread 상태 제어 명령

- sleep : 주어진 시간 동안 일시 정지
- yield : 다른 스레드에게 양보
- join : 다른 스레드의 종료를 기다림

---

# 마감 일시

## 2020년 11월 28일 오후 3시

---