# 5주차 : 클래스

---

# 목표

1. 자바 Class에 대한 학습
2. 이진 트리 Node 구현

---

# 학습 할 것 (필수)

## [클래스 정의하는 방법]

Java는 객체 지향 & **Class기반**

< Doc 정의 >

```java
/** Represents a Cartesian (x,y) point */
public class Point {
	// The coordinates of the point
	public double x, y;
	public Point(double x, double y) { // A constructor that
		this.x = x; this.y = y; // initializes the fields
	}
	public double distanceFromOrigin() { // A method that operates
		return Math.sqrt(x*x + y*y); // on the x and y fields
	}
}
```

### **[결과]**

- **Point 클래스는 [Point.java](http://point.java) 파일이 생성 된 뒤 이 파일에 정의 된다.**
- double 형 x, y **속성**이 정의된다.
- double 형 매개변수 x, y 2개를 받는 **생성자**가 정의된다.
- double 형을 반환하는 distanceFromOrigin() **메소드**가 정의된다.

### [의문]

- 생성자를 정의 안하면?
**⇒ Default 생성자**
- **생성자를 private을 주면?
⇒ Instance를 생성하지 못하도록 제안할 때 사용된다.**

    **< private 생성자 클래스 >**

    - 하위 클래스를 만들 수 없다.
    - 정적 메소드만으로 구성되 있을 수 있다.
    - ex) Java.lang.Math / java.util.Arrays 처럼 기본 자료형 or 배열에 적용되는 메소드를 한군데 모아놓는다.
    - final 클래스에 적용할 메소드를 모아놓는데 활용한다. ( 상속 금지 된 클래스 )

    **< 불필요한 객체 >**

    ( 피해야 할 예 )

    ```java
    String s = new String("string");
    ```

    string 이라는 문자열 사용 시, 개별로 메모리에 인스턴스로 올라간다.

    ( 올바른 예)

    ```java
    String s = "string";
    ```

    실행 시 객체 대신 "string"객체를 재사용하게 된다.

- 타 언어는 매개변수 2개 생성자를 정의하면 default 매개변수도 정의해야 되지 않나?
⇒ 컴파일러는 생성자가 하나도 없을 때만 기본 생성자를 바이트 코드에 추가.
⇒ 즉, 매개변수 2개 생성자를 정의하면 필요시 default 생성자도 정의 필요.

## [객체 만드는 방법 (new 키워드 이해)]

< Doc 예 >

```java
Point p = new Point(2.0, -3.5);
```

### **[결과]**

- 새 Point 객체의 내부 필드를 초기화 한 인스턴스를 생성해준다.

### **[객체 생성 과정]**

![5%E1%84%8C%E1%85%AE%E1%84%8E%E1%85%A1%20%E1%84%8F%E1%85%B3%E1%86%AF%E1%84%85%E1%85%A2%E1%84%89%E1%85%B3%203c019a43289947d79c8b19766e6293c6/5th_4.png](5%E1%84%8C%E1%85%AE%E1%84%8E%E1%85%A1%20%E1%84%8F%E1%85%B3%E1%86%AF%E1%84%85%E1%85%A2%E1%84%89%E1%85%B3%203c019a43289947d79c8b19766e6293c6/5th_4.png)

1. **new**  :  객체가 저장될 메모리 공간 할당. **(Heap)** 영역.
2. **생성자** : 객체 초기화.
3. **new**  :  새로 생성된 객체의 주소(reference)를 변수에 저장.
4. 변수를 통해 접근.

### [예외 Object Literals]

- STRING LITERALS

```java
String name = "David";

String x = "~~~ \n  ~~~";

String a = "~~~~" +
					 "~~~~~~";
* 주의 * A + B => C 객체를 반환하여 GC 가 A, B를 지워버릴 수 있음.
String A += B;  // 새로운 C를 할당하게 됨.
=> StringBuilder  ||  StringBuffer 로 대체 하자.
=> Compiler 에서 간단한 연산은 바꾸어 준다.
```

StringBuilder  :  Thread-unsafe

StringBuffer    :  Thread-safe

- TYPE LITERALS < 모르는 거 >

```java
Class<?> typeInt = int.class;
Class<?> typeIntArray = int[].class;
Class<?> typePoint = Point.class;
```

class 의 data type을 알아내기 위한 Class class.

- getFields();
- getMethods();
- getDeclared();
- etc... 
[https://docs.oracle.com/javase/8/docs/api/java/lang/Class.html](https://docs.oracle.com/javase/8/docs/api/java/lang/Class.html)

- THE NULL REFERENCE

```java
String s = null;
Point p = null;
```

## [메소드 정의하는 방법]

```java
**접근** **제어자**   **반환타입   메소드이름  (매개변수)** {  **//선언부**
		**// 구현부**
}
```

- **접근 제어자** :
    - **default** - 같은 클래스, 같은 패키지에서 접근 O
    - **private** - 외부에서 접근 X , 해당 객체의 public을 통해서 접근 O
    - **public** -  외부에 공개 O, private 멤버 사이의 인터페이스 역할.
    - **protect** - 부모클래스에 대해서는 public, 외부에서는 private
- **반환타입** :  return 할 타입
- **메소드이름** :  함수의 이름
- **매개변수** :  함수 호출 시 받을 매개변수

## [생성자 정의하는 방법]

```java
**클래스 이름**  **( 인수, ..., ... ) { ... }**
```

- 생성자를 정의 안하면?
**⇒ Default 생성자**
- 매개변수 2개 생성자를 정의하면 default 매개변수도 정의해야 되지 않나?
⇒ 컴파일러는 생성자가 하나도 없을 때만 기본 생성자를 바이트 코드에 추가.
⇒ 즉, 매개변수 2개 생성자를 정의하면 필요시 default 생성자도 정의 필요.

## [this 키워드 이해하기]

![5%E1%84%8C%E1%85%AE%E1%84%8E%E1%85%A1%20%E1%84%8F%E1%85%B3%E1%86%AF%E1%84%85%E1%85%A2%E1%84%89%E1%85%B3%203c019a43289947d79c8b19766e6293c6/Untitled.png](5%E1%84%8C%E1%85%AE%E1%84%8E%E1%85%A1%20%E1%84%8F%E1%85%B3%E1%86%AF%E1%84%85%E1%85%A2%E1%84%89%E1%85%B3%203c019a43289947d79c8b19766e6293c6/Untitled.png)

---

# 학습 할 것 (선택)

## [int 값을 가지고 있는 이진 트리를 나타내는 Node클래스 정의]
[int value, Node left, right를 가짐.]

[limyeonsoo/live-study](https://github.com/limyeonsoo/live-study/tree/main/liveStudy_5th/src/main/java)

### < ~~첫번째 작성 Node 클래스 >~~

```java
public class Node {
    int value;
    Node left;
    Node right;

    Node(int initValue){
        this.value = initValue;
        this.left = null;
        this.right = null;
    }

    private int getValue(){
        return this.value;
    }

    public Node add(Node childNode){
        if(this.left == null){
            this.left = childNode;
            return this.left;
        }else{
            this.right = childNode;
            return this.right;
        }
    }

    public void print(Node cur){
        System.out.println(cur.getValue());
        if(cur.left != null){
            print(cur.left);
            if(cur.right != null){
                print(cur.right);
            }
        }
    }

}
```

### 문제점

CS 배경지식을 활용하여 Node라는 새로운 자료형을 구현한게 아니라,
Tree 자체를 구현 한 것 같다.
⇒ OOP 규칙 중 SRP 위반.
단 하나의 역할만 해야 한다.

근데 단말 노드가 다 하고 있다.

- Node를 잇는 add();
- Node를 탐색하는 print();

### 개선

Node는 value, left, right를 가지고 있는 struct 같은 역할만 하도록.

![5%E1%84%8C%E1%85%AE%E1%84%8E%E1%85%A1%20%E1%84%8F%E1%85%B3%E1%86%AF%E1%84%85%E1%85%A2%E1%84%89%E1%85%B3%203c019a43289947d79c8b19766e6293c6/5th_2.png](5%E1%84%8C%E1%85%AE%E1%84%8E%E1%85%A1%20%E1%84%8F%E1%85%B3%E1%86%AF%E1%84%85%E1%85%A2%E1%84%89%E1%85%B3%203c019a43289947d79c8b19766e6293c6/5th_2.png)

```java
public class Node {
    private  int value;
    Node left;
    Node right;

    public int getValue(){ return this.value; }
    public void setValue(int value) { this.value = value;}

    public static void main(String[] args) {
        Node root = new Node();
        Node node1 = new Node();
        Node node2 = new Node();

        root.setValue(1);
        node1.setValue(10);
        node2.setValue(100);

        System.out.println(root.getValue());
        System.out.println(node1.getValue());
        System.out.println(node2.getValue());
    }
}
```

![5%E1%84%8C%E1%85%AE%E1%84%8E%E1%85%A1%20%E1%84%8F%E1%85%B3%E1%86%AF%E1%84%85%E1%85%A2%E1%84%89%E1%85%B3%203c019a43289947d79c8b19766e6293c6/Untitled%201.png](5%E1%84%8C%E1%85%AE%E1%84%8E%E1%85%A1%20%E1%84%8F%E1%85%B3%E1%86%AF%E1%84%85%E1%85%A2%E1%84%89%E1%85%B3%203c019a43289947d79c8b19766e6293c6/Untitled%201.png)

## [BinaryTree라는 클래스를 정의, Node를 기준으로 출력하는 bfs, dfs 메소드 구현]
[dfs는 왼쪽, 루트, 오른쪽 순으로 순회 ⇒ 중위순회]

### < BinaryTree >

### 설계

- 필요한 속성, 메소드
- Node를 add할 때, 어느 Node의 left/right에 들어가야 하는지를 어떻게 알 수 있을까?
    1. 2진수 식을 세운다.
    2. 가장 끝을 기억하고 있는다.
    3. 뒤에서 부터 찾는다.
    4. ... ...

![5%E1%84%8C%E1%85%AE%E1%84%8E%E1%85%A1%20%E1%84%8F%E1%85%B3%E1%86%AF%E1%84%85%E1%85%A2%E1%84%89%E1%85%B3%203c019a43289947d79c8b19766e6293c6/5th.png](5%E1%84%8C%E1%85%AE%E1%84%8E%E1%85%A1%20%E1%84%8F%E1%85%B3%E1%86%AF%E1%84%85%E1%85%A2%E1%84%89%E1%85%B3%203c019a43289947d79c8b19766e6293c6/5th.png)

📘 윤성우의 자료구조

Tree는 배열,연결리스트 모두 가능하지만, Tree를 표현하는데는 연결리스트가 가장 적합하다.
하지만, 완전 이진트리는 빈번한 탐색때문에 배열로 구현하면 유리할 수 있다. ex) Heap

### < BinaryTree >

```java
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class BinaryTree {
    Node head;
    int size;

    BinaryTree(Node head) {
        this.head = head;
        this.size = 1;
    }

    public void add(Node childNode) {
        // size+1 => 이제 생성될 노드
        // size+1 짝수면 left => true
        // size+1 홀수면 right => false
        // 부모 노드는 (int)(size+1)/2;
        boolean leftRight = (size + 1) % 2 == 0;
        int parentIdx = (size + 1) / 2;
        Stack stack = new Stack<Boolean>();
        while (true) {
            if (parentIdx == 1) break;
            stack.push(parentIdx % 2 == 0);
            parentIdx = parentIdx / 2;
        }
        Node parentNode = this.head;
        while (!stack.empty()) {
            Boolean isLeft = (Boolean) stack.pop();
            if (isLeft) {
                parentNode = parentNode.left;
            } else {
                parentNode = parentNode.right;
            }
        }
        if (leftRight) {
            parentNode.left = childNode;
        } else {
            parentNode.right = childNode;
        }
        this.size++;
    }
    public void dfs(Node node){
        System.out.print(node.getValue()+" ");
        if(node.left != null){
            dfs(node.left);
            if(node.right != null){
                dfs(node.right);
            }
        }
    }

    public void bfs(){
        Queue q = new LinkedList();
        q.offer(this.head);
        while(!q.isEmpty()){
            Node now = (Node) q.poll();
            System.out.print(now.getValue()+" ");
            if(now.left != null) q.offer(now.left);
            if(now.right != null) q.offer(now.right);
        }

    }

    public static void main(String[] args) {
        Node root = new Node();
        Node node2 = new Node();
        Node node3 = new Node();
        Node node4 = new Node();
        Node node5 = new Node();
        Node node6 = new Node();
        Node node7 = new Node();
        Node node8 = new Node();
        Node node9 = new Node();
        Node node10 = new Node();
        root.setValue(1);
        node2.setValue(2);
        node3.setValue(3);
        node4.setValue(4);
        node5.setValue(5);
        node6.setValue(6);
        node7.setValue(7);
        node8.setValue(8);
        node9.setValue(9);
        node10.setValue(10);
        BinaryTree bt = new BinaryTree(root);
        bt.add(node2);
        bt.add(node3);
        bt.add(node4);
        bt.add(node5);
        bt.add(node6);
        bt.add(node7);
        bt.add(node8);
        bt.add(node9);
        bt.add(node10);
        System.out.print("dfs : ");
        bt.dfs(root);
        System.out.print("\nbfs : ");
        bt.bfs();
    }
}
```

![5%E1%84%8C%E1%85%AE%E1%84%8E%E1%85%A1%20%E1%84%8F%E1%85%B3%E1%86%AF%E1%84%85%E1%85%A2%E1%84%89%E1%85%B3%203c019a43289947d79c8b19766e6293c6/Untitled%202.png](5%E1%84%8C%E1%85%AE%E1%84%8E%E1%85%A1%20%E1%84%8F%E1%85%B3%E1%86%AF%E1%84%85%E1%85%A2%E1%84%89%E1%85%B3%203c019a43289947d79c8b19766e6293c6/Untitled%202.png)

---

# 마감 일시

## 2020년 12월 19일 토요일 오후 1시