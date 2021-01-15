# 9주차 : 예외처리

# 목표

## 자바의 예외 처리에 대한 학습.

---

# 학습할 것

## 💭 자바에서 예외 처리 방법

try, catch, throw, throws, finally

- try : 예외가 날 수 있는 상화에 대한 알림.
- catch : 예외를 처리하는 함수.
- finally : 성공이던 실패던 무조건 실행되는 구문.

### < The try/catch/finally Statement >

try → 예외 발생 시 → catch → 무조건 → finally

try → 정상 실행 시 → 무조건 → finally

![9%E1%84%8C%E1%85%AE%E1%84%8E%E1%85%A1%20%E1%84%8B%E1%85%A8%E1%84%8B%E1%85%AC%E1%84%8E%E1%85%A5%E1%84%85%E1%85%B5%20e3b616c28b2e4eebab6a1909cc492baa/PNG_.png](9%E1%84%8C%E1%85%AE%E1%84%8E%E1%85%A1%20%E1%84%8B%E1%85%A8%E1%84%8B%E1%85%AC%E1%84%8E%E1%85%A5%E1%84%85%E1%85%B5%20e3b616c28b2e4eebab6a1909cc492baa/PNG_.png)

```java
try { 
    res = divideByZero(a,b); 
} catch(NumberFormatException ex) { 
    System.out.println("NumberFormatException is occured");  
} finally{
		System.out.println("Always");
}
```

- 여러개의 catch문이 있다면 단 하나의 catch문만 실행한다.
- finally는 try/catch에 return이 있더라도 실행된다.

### Multicatch Block

JDK 1.7이후, 여러개의 catch를 합칠 수 있다.

```java
try {
    System.out.println(1 / 0);
} catch (IllegalArgumentException e1){

} catch (ArithmeticException e2) {

}
```

```java
try {
    System.out.println(1 / 0);
} catch (IllegalArgumentException | ArithmeticException e) {
    System.out.println(e.getMessage());
}
```

**주의사항**

1. **사용된 예외들이 부모와 자식관계이면 안된다.**
→ Exception 하나로 처리되기 때문에 컴파일 에러를 일으킨다.
2. **공통된 조상의 멤버만 사용할 수 있다.**
→ 다른 조상의 멤버라면 e가 어느 예외처리인지 판별 할 수 없기 때문에 1번 주의사항과 마찬가지로 Exception 하나로 처리할 수 있어야 한다.

### < throw & throws의 차이 >

- throw : Exception을 위해 예외를 발생시키는 것. try & catch에서 특정 예외 처리를 정의하고 발생시키기 위함.

    ```java
    try{
    	throw new Exception();
    } catch (Exception e) {
    	;;;
    }
    ```

- throws : 예외를 발생시키는건 같지만, 자신을 호출하는 메소드에게 **책임을 전가** 하는 것. 
throws를 사용한 method를 사용한다면 이에 해당하는 예외를 책임져야한다.

    ```java
    void method() throws Exception1, Exception2, ... ExceptionN {
    		// throws된 Exception들에 대한 예외 처리를 해주어야 한다.
    }
    ```

## 💭 자바가 제공하는 예외 계층 구조

![9%E1%84%8C%E1%85%AE%E1%84%8E%E1%85%A1%20%E1%84%8B%E1%85%A8%E1%84%8B%E1%85%AC%E1%84%8E%E1%85%A5%E1%84%85%E1%85%B5%20e3b616c28b2e4eebab6a1909cc492baa/Untitled.png](9%E1%84%8C%E1%85%AE%E1%84%8E%E1%85%A1%20%E1%84%8B%E1%85%A8%E1%84%8B%E1%85%AC%E1%84%8E%E1%85%A5%E1%84%85%E1%85%B5%20e3b616c28b2e4eebab6a1909cc492baa/Untitled.png)

[https://www.geeksforgeeks.org/exceptions-in-java/?ref=lbp](https://www.geeksforgeeks.org/exceptions-in-java/?ref=lbp)

위 그림을 통해 알 수 있는 것.

1. **Erorr와 Exceptions의 차이.**
2. **Exceptions에서 checked 와 unchecked의 차이.**
3. **모든 예외의 부모 클래스는 Throwable 클래스다.**

    Throwable Class : 

    ![9%E1%84%8C%E1%85%AE%E1%84%8E%E1%85%A1%20%E1%84%8B%E1%85%A8%E1%84%8B%E1%85%AC%E1%84%8E%E1%85%A5%E1%84%85%E1%85%B5%20e3b616c28b2e4eebab6a1909cc492baa/Untitled%201.png](9%E1%84%8C%E1%85%AE%E1%84%8E%E1%85%A1%20%E1%84%8B%E1%85%A8%E1%84%8B%E1%85%AC%E1%84%8E%E1%85%A5%E1%84%85%E1%85%B5%20e3b616c28b2e4eebab6a1909cc492baa/Untitled%201.png)

    즉 위와 같은 메소드들을 오버라이딩하여 사용할 수 있다.

## 💭 Exception과 Error의 차이는?

프로그램 오류 :  프로그램 실행 중 어떤 원인에 의해서 오작동을 하거나, 비정상적으로 종료되는 경우.
프로그램 오류는   **에러(Error)와 예외(Exception)** 두 가지로 구분.

~~⇒ Error 상황을 대비해 개발자가 Exception으로 상황을 만들 수 있다.
이때, 사용되는게 try-catch~~

### ~~에러(Error)~~

~~메모리 부족, 스택오버플로우 등 심각한 오류.~~

~~→ JVM에 문제가 있다.~~

### ~~예외(Exception)~~

~~에러에 비해 비교적 덜 치명적인 오류.~~

~~→ 사용자, 개발자의 실수.~~

라고 대부분 블로그에서 나누는데,,,  이해가 안되는 것.

1. 에러도 예외도 모두 프로그램 실행에서 치명적일 거 같다.
2. 모두 다 개발자가 처리 했어야 했던 것 아닐까? ⇒ 즉 모든 것이 다 Exception아닐까.
OOM  memory를 잘못 가르키는것, 오버플로우가 발생하도록 하는 것 모두 개발자의 탓 아닐까.

[Error (Java SE 15 & JDK 15)](https://docs.oracle.com/en/java/javase/15/docs/api/java.base/java/lang/Error.html)

### Error

> An Error is a subclass of Throwable that a reasonable application should not try to catch.

⇒ 일단 try to catch로 잡을 수 없는 것이 Error.

⇒ 또한, 절대 발생해서는 안되기 때문에, 발생한다는 가정을 할 필요도 없고, throws 같은 체크를 할 필요가 없다.

![9%E1%84%8C%E1%85%AE%E1%84%8E%E1%85%A1%20%E1%84%8B%E1%85%A8%E1%84%8B%E1%85%AC%E1%84%8E%E1%85%A5%E1%84%85%E1%85%B5%20e3b616c28b2e4eebab6a1909cc492baa/Untitled%202.png](9%E1%84%8C%E1%85%AE%E1%84%8E%E1%85%A1%20%E1%84%8B%E1%85%A8%E1%84%8B%E1%85%AC%E1%84%8E%E1%85%A5%E1%84%85%E1%85%B5%20e3b616c28b2e4eebab6a1909cc492baa/Untitled%202.png)

- 이중 VirtualMachineError
    - InternalError
    - OutOfMemoryError
    - StackOverflowError
    - UnknownError

    이들은 JVM에 손상이 되어서 더이상 진행을 할 수 없다. 

### Exception

> The class Exception is that indicates conditions that a reasonable application might want to catch.

⇒ catch 하고 싶은 상황.

⇒ 발생할 것이라고 알고 있다는 것이다.

## 💭 < checkedException vs uncheckedException >

**컴파일 단계에서 확인 할 수 있는가**

### CheckedException

미리 컴파일 시 알 수 있는 예외.

Java에서 알 수 있는 예외는 처리 해주고 가자는 의미에서 만듬.

ex) main에서 어떤 객체를 쓰려고 할 때, Exception을 만들라고 한다.

BufferedReader를 사용할려면 IOException 을 throws하라는 경고와 함께 컴파일이 되지 않는다.

![9%E1%84%8C%E1%85%AE%E1%84%8E%E1%85%A1%20%E1%84%8B%E1%85%A8%E1%84%8B%E1%85%AC%E1%84%8E%E1%85%A5%E1%84%85%E1%85%B5%20e3b616c28b2e4eebab6a1909cc492baa/Untitled%203.png](9%E1%84%8C%E1%85%AE%E1%84%8E%E1%85%A1%20%E1%84%8B%E1%85%A8%E1%84%8B%E1%85%AC%E1%84%8E%E1%85%A5%E1%84%85%E1%85%B5%20e3b616c28b2e4eebab6a1909cc492baa/Untitled%203.png)

```java
public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int testCase = Integer.parseInt(br.readLine());
```

### Unchecked Exception

정 반대로 컴파일 단계에서 확인 할 수 없다. Java에서는 처리해줄 수 없기 때문에 개발자가 처리할 수 있어야 한다.

ex) RuntimeException, NullPointerException  and   Error

## 💭 RuntimeException과 R.E가 아닌 것의 차이는?

### RuntimeException

- UncheckedException의 하나이다. 
→ 컴파일 단계에서 알 수 없어 개발자가 예외처리를 해주어야 한다.
- 개발 구조, 코드 로 인해 발생하는 문제이므로 일어나지 않도록 해주어야 한다.

    ex)

    1. NullPointer Exception
    2. ArrayIndexOutOfBoundsException
    3. 등등.

### RuntimeException이 아닌 것?

1. 컴파일 시간에 알 수 있는 예외?

    CheckedException : AWTException,  SQLException,  IOExecption, ...

## 💭 커스텀 예외를 만드는 방법

1. Exception 클래스를 상속 받는다.

    ```java
    public class customException extends Exception{
        customException(){
            System.out.println("홀수입니다");
        }
        customException(int i){
            System.out.println(i+"는 홀수입니다.");
        }
    }
    ```

2. 커스텀 클래스를 throw 한다.

    ```java
    public class Main {
        public static void main(String[] args) {
            int sum = 0;
            for(int i=1; i<=20; i++){
                try{
                    if(i %2 != 0) throw new customException(i);
                    sum += i;
                } catch (customException e) {
                    e.printStackTrace();
                }
            }
        }
    }
    ```

![9%E1%84%8C%E1%85%AE%E1%84%8E%E1%85%A1%20%E1%84%8B%E1%85%A8%E1%84%8B%E1%85%AC%E1%84%8E%E1%85%A5%E1%84%85%E1%85%B5%20e3b616c28b2e4eebab6a1909cc492baa/Untitled%204.png](9%E1%84%8C%E1%85%AE%E1%84%8E%E1%85%A1%20%E1%84%8B%E1%85%A8%E1%84%8B%E1%85%AC%E1%84%8E%E1%85%A5%E1%84%85%E1%85%B5%20e3b616c28b2e4eebab6a1909cc492baa/Untitled%204.png)

## 💭 try-catch-resource

자원 해제를 자동으로 해준다.

Python의   with open 과 같은 것 같다.

```java
try(
		자원 할당을 () 사이에서 해준다.
) {
		...
} catch (IOException e){
		...
}
```

모든 객체에 대한 해제를 자동으로 해주는 것은 아니다.

interface AutoCloseable 을 구현한 객체만 가능하다.

[AutoCloseable (Java Platform SE 7 )](https://docs.oracle.com/javase/7/docs/api/java/lang/AutoCloseable.html)

```java
package java.lang;

public interface AutoCloseable {
    void close() throws Exception;
}
```

 

---

# 마감 일시

## 2021년 01월 16일 13시 전

---