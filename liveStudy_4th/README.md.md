# 4주차 : 제어문

# 목표

## 자바가 제공하는 제어문 학습.

선택문 / 반복문

---

# 학습할 것

## 제어문

![4%E1%84%8C%E1%85%AE%E1%84%8E%E1%85%A1%20%E1%84%8C%E1%85%A6%E1%84%8B%E1%85%A5%E1%84%86%E1%85%AE%E1%86%AB%203b58e276e4434f4c85abcc5380b22dd0/Untitled.png](4%E1%84%8C%E1%85%AE%E1%84%8E%E1%85%A1%20%E1%84%8C%E1%85%A6%E1%84%8B%E1%85%A5%E1%84%86%E1%85%AE%E1%86%AB%203b58e276e4434f4c85abcc5380b22dd0/Untitled.png)

## 선택문

### if / else / else if

```java
void range(int number){
    if(number < 10){
        System.out.println("0 ~ 10");
    }else if(number == 10){
        System.out.println("10");
    }else{
        System.out.println("10 ~");
    }
}

->
0 ~ 10
10
10 ~
```

### switch

: 판별 가능한 자료형 →  **정수 자료형 + 문자 자료형** 
  (실수 자료형 X)

```java
void _switch(int number){
    switch(number){
        case 5:
            System.out.println("5");
            break;
        case 10:
            System.out.println("10");
            break;
        case 100:
            System.out.println("100");
            break;
    }
}

->
5
10
100
```

main

```java
public static void main(String[] args) {
    select_statement state = new select_statement();
    int num1 = 5;
    int num2 = 10;
    int num3 = 100;
    state.ifelse(num1);
    state.ifelse(num2);
    state.ifelse(num3);
    state._switch(num1);
    state._switch(num2);
    state._switch(num3);
}
```

## 반복문

### for

```java
public int for_statement(int num, int iter){
    for(int i=0; i<iter; i++) num++;
    return num;
}

->
15
```

### while

while(iter—){}  가 안된다!
오직 boolean 만 들어가야 되는 것 같다.

```java
public int while_statement(int num, int iter){
    while(iter != 0){
        num++;
        iter--;
    }
    return num;
}

->
15
```

### do~while

```java
public int do_statement(int num, int iter){
    do{
        num++;
        iter--;
    }while(iter!=0);
    return num;
}

->
15
```

### foreach

```java
public void foreach_statement(int [] data){
    for(int datum : data) System.out.print(datum+" ");
}

->
1 2 3 4 5 
```

### main

```java
public static void main(String[] args) {
    repeat_statement state = new repeat_statement();
    int forNum = state.for_statement(10, 5);
    int whileNum = state.while_statement(10, 5);
    int doNum = state.do_statement(10, 5);
    int[] temp = {1, 2, 3, 4, 5};
    System.out.println(forNum);
    System.out.println(whileNum);
    System.out.println(doNum);
    state.foreach_statement(temp);
}
```

## 과제 0. JUnit 5 학습.

- 인텔리J, 이클립스, VS Code에서 JUnit 5로 테스트 코드 작성하는 방법에 익숙해 질 것.
- 이미 JUnit 알고 계신분들은 다른 것 아무거나!
- [더 자바, 테스트](https://www.inflearn.com/course/the-java-application-test?inst=86d1fbb8) 강의도 있으니 참고하세요~

### TDD ( Test Driven Development )

기능을 추가 할 때, 테스트를 먼저 작성한 후, 개발을 한다.

내가 개발 시 불편했던 점.
웹 개발 시 계속 같은 이벤트를 걸어 수동으로 확인해야 했다.
**⇒ TDD 개발 시 작성된 테스트 케이스가 자동으로 확인해준다.**

👎🏾 단점 :
빠른 생산이 요구될 때, 개발 기간이 느릴 수 있다.
단, 리팩토링 시간을 줄여 전체적으로 보면 안 느려질 수도 있다.
→ 천천히 해도 되는 과제 1을 TDD로 개발해보자.

## 과제 1. live-study 대시 보드를 만드는 코드를 작성.

- 깃헙 이슈 1번부터 18번까지 댓글을 순회하며 댓글을 남긴 사용자를 체크 할 것.
- 참여율을 계산하세요. 총 18회에 중에 몇 %를 참여했는지 소숫점 두자리가지 보여줄 것.
- [Github 자바 라이브러리](https://github-api.kohsuke.org/)를 사용하면 편리합니다.
- 깃헙 API를 익명으로 호출하는데 제한이 있기 때문에 본인의 깃헙 프로젝트에 이슈를 만들고 테스트를 하시면 더 자주 테스트할 수 있습니다.

### <필요한 기능>

1. 깃허브 접근
2. 이슈 긁어오기 (사용자, 참여율)
3. 참여율 계산 후 소숫점 두자리 반환

### Github Java Library

[https://mvnrepository.com/artifact/org.kohsuke/github-api/1.117](https://mvnrepository.com/artifact/org.kohsuke/github-api/1.117)

![4%E1%84%8C%E1%85%AE%E1%84%8E%E1%85%A1%20%E1%84%8C%E1%85%A6%E1%84%8B%E1%85%A5%E1%84%86%E1%85%AE%E1%86%AB%203b58e276e4434f4c85abcc5380b22dd0/Untitled%201.png](4%E1%84%8C%E1%85%AE%E1%84%8E%E1%85%A1%20%E1%84%8C%E1%85%A6%E1%84%8B%E1%85%A5%E1%84%86%E1%85%AE%E1%86%AB%203b58e276e4434f4c85abcc5380b22dd0/Untitled%201.png)

**< Error 1 >** 

maven pom.xml에 추가하면 될 것 같다.
→ Error : dependency에 빨간줄
**⇒ dependency는 dependencies 태그로 감싸야 한다고 한다.**

**< Error 2 >**

![4%E1%84%8C%E1%85%AE%E1%84%8E%E1%85%A1%20%E1%84%8C%E1%85%A6%E1%84%8B%E1%85%A5%E1%84%86%E1%85%AE%E1%86%AB%203b58e276e4434f4c85abcc5380b22dd0/Untitled%202.png](4%E1%84%8C%E1%85%AE%E1%84%8E%E1%85%A1%20%E1%84%8C%E1%85%A6%E1%84%8B%E1%85%A5%E1%84%86%E1%85%AE%E1%86%AB%203b58e276e4434f4c85abcc5380b22dd0/Untitled%202.png)

→ Maven setting에서 source, documentation 자동 다운로드를 해도 똑같다.

**⇒ reload Project를 하니 해결되었다.
: 강제로 프로젝트를 새로고침 하는 것.**

### < 기능 1 > : gitHubConnection

gitHub에 연결하는 방법으로는
1.  withPassword  //권장 X
**2.  withOAuthToken**
3.  withJwtToken
4.  withAppInstallationToken 
이 있다.

[https://github-api.kohsuke.org/apidocs/org/kohsuke/github/GitHubBuilder.html](https://github-api.kohsuke.org/apidocs/org/kohsuke/github/GitHubBuilder.html)

그 중, withOAuthToken 이용.

![4%E1%84%8C%E1%85%AE%E1%84%8E%E1%85%A1%20%E1%84%8C%E1%85%A6%E1%84%8B%E1%85%A5%E1%84%86%E1%85%AE%E1%86%AB%203b58e276e4434f4c85abcc5380b22dd0/Untitled%203.png](4%E1%84%8C%E1%85%AE%E1%84%8E%E1%85%A1%20%E1%84%8C%E1%85%A6%E1%84%8B%E1%85%A5%E1%84%86%E1%85%AE%E1%86%AB%203b58e276e4434f4c85abcc5380b22dd0/Untitled%203.png)

- Test를 어떻게 작성 할 것인가?

return 하는 객체가 the git hub builder

< Error >

```java
@Test
    void gitHubConnectionDefault() throws IOException, ParseException {
        gitHub.gitHubConnection();
        assertEquals(gitHub, "org.kohsuke.github.GitHub@d2cc05a");
    }
```

🤔 기본적으로 "org.kohsuke.github.GitHub@ [해시값?] " 이 바뀌어서 asserEquals를 할 수 없다.

**⇒ <Solve >**

```java
@Test
    void gitHubConnectionWhiteship() throws IOException, ParseException {
        GHRepository repository = gitHub.gitHubConnection("whiteship/live-study","");
        assertEquals(repository.getDescription(), "온라인 스터디");
    }
```

repository (매개변수 : name/repository) 를 연결한 후, 반환되는 객체에 getDescription 메소드가 존재.
whiteship/live-study에 연결을 하면 "온라인 스터디"를 얻게 될 것이다.

### <기능 2> Issue 긁어오기

연결된 GHRepository에는 [getIssues](https://github-api.kohsuke.org/apidocs/org/kohsuke/github/GHRepository.html#getIssue(int)) 메소드가 있다. return (List<GHIssue>)

getIssues의 매개변수는 [GHIssueState](https://github-api.kohsuke.org/apidocs/org/kohsuke/github/GHIssueState.html)
→ enum으로  "ALL", "OPEN", "CLOSE" 가 있고, GHIssueState.valueOf("")로 넘겨줄 수 있다.
→ 편의상 "ALL"을 이용. → List<GHIssue> 를 반환함.

@Test 방법

현재 whiteship/live-study는 15개의 open issues & 3개의 close issues가 있다.

```java
@Test
    void checkIssuesSize() throws IOException, ParseException {
        gitHubIssues gitHub = new gitHubIssues();
        gitHub.gitHubConnection("whiteship/live-study");
        assertEquals(gitHub.getIssues().size(), 18);
    }
```

### <기능 3> Issue 계산

1. 반환받은 List<[GHIssue](https://github-api.kohsuke.org/apidocs/org/kohsuke/github/GHIssue.html)> 를 Issue별로 나눈다.

```java
for(GHIssue issue : issues){ }
```

2. [GHIssue](https://github-api.kohsuke.org/apidocs/org/kohsuke/github/GHIssue.html)에는 issue하나 당 정보 중 listComments() 로 [GHIssueComment](https://github-api.kohsuke.org/apidocs/org/kohsuke/github/GHIssueComment.html)를 가져올 수 있다.

```java
for(GHIssue issue : issues){
    PagedIterable<GHIssueComment> lists = issue.listComments();
    for(GHIssueComment list : lists){
        System.out.println(list);
    }
}
```

![4%E1%84%8C%E1%85%AE%E1%84%8E%E1%85%A1%20%E1%84%8C%E1%85%A6%E1%84%8B%E1%85%A5%E1%84%86%E1%85%AE%E1%86%AB%203b58e276e4434f4c85abcc5380b22dd0/Untitled%204.png](4%E1%84%8C%E1%85%AE%E1%84%8E%E1%85%A1%20%E1%84%8C%E1%85%A6%E1%84%8B%E1%85%A5%E1%84%86%E1%85%AE%E1%86%AB%203b58e276e4434f4c85abcc5380b22dd0/Untitled%204.png)

3. 이 중, getUser()를 이용해 comment를 단 사용자의 정보를 가져온다.

```java
for(GHIssue issue : issues){
    PagedIterable<GHIssueComment> lists = issue.listComments();
    for(GHIssueComment list : lists){
        System.out.println(list.getUser());
    }
}
```

![4%E1%84%8C%E1%85%AE%E1%84%8E%E1%85%A1%20%E1%84%8C%E1%85%A6%E1%84%8B%E1%85%A5%E1%84%86%E1%85%AE%E1%86%AB%203b58e276e4434f4c85abcc5380b22dd0/Untitled%205.png](4%E1%84%8C%E1%85%AE%E1%84%8E%E1%85%A1%20%E1%84%8C%E1%85%A6%E1%84%8B%E1%85%A5%E1%84%86%E1%85%AE%E1%86%AB%203b58e276e4434f4c85abcc5380b22dd0/Untitled%205.png)

4. [GHUser](https://github-api.kohsuke.org/apidocs/org/kohsuke/github/GHUser.html) 중 login은 github 고유 ID로서 중복이 되지 않을 것이다.
→ getLogin()메소드로 ID를 가져올 수 있다.

~~중복되지 않으므로 ID를 vector에 하나씩 추가하자~~

issue바뀔 때 마다, vector에 이미 있는 User인지 확인하므로, O(N * issue)가 걸릴 것이다.

O(1)의 Java Hash Map 이용. [https://sabarada.tistory.com/57](https://sabarada.tistory.com/57)

이미 존재하는 지 확인  O(1)

- 있으면 : + 1
- 없으면 :  = 1

```java
String crew = list.getUser().getLogin();
if(crewList.containsKey(crew)){
    crewList.put(crew,crewList.get(crew)+1);
}else {
    crewList.put(crew, 1);
}
```

```java
writer.write(String.format("ID : %s  -> 참여율 : %.2f", key, crewList.get(key) / issues.size() * 100));
```

### <기능 4> File Write

HashMap에 담겨있는 crew들과 계산된 비율을 함께 write한다.

"ID : %s -> 참여율 : %.2f\n", key, (float)crewList.get(key) / 18 * 100));

```java
@Test
    void writeFile(){
        String path = "resources/tempList.txt";
        Map<String, Integer> tempList = new HashMap<String, Integer>();
        tempList.put("image",1);
        tempList.put("maven", 10);
        tempList.put("ysl",18);
        
        File file = new File(path);
        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter(file));
            for(String key : tempList.keySet()){
                writer.write(String.format("ID : %s  -> 참여율 : %.2f\n", key, (float)tempList.get(key) / 18 * 100));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        assertTrue(file.exists());
    }
```

임시로 crewList를 만들어서 파일이 작성되는지 테스트 해본다.

![4%E1%84%8C%E1%85%AE%E1%84%8E%E1%85%A1%20%E1%84%8C%E1%85%A6%E1%84%8B%E1%85%A5%E1%84%86%E1%85%AE%E1%86%AB%203b58e276e4434f4c85abcc5380b22dd0/Untitled%206.png](4%E1%84%8C%E1%85%AE%E1%84%8E%E1%85%A1%20%E1%84%8C%E1%85%A6%E1%84%8B%E1%85%A5%E1%84%86%E1%85%AE%E1%86%AB%203b58e276e4434f4c85abcc5380b22dd0/Untitled%206.png)

```java
public void writeFile(String path, Map<String, Integer> crewList){
        File file = new File(path);
        try{
            BufferedWriter writer = new BufferedWriter(new FileWriter(file));
            for (String key : crewList.keySet()) {
                writer.write(String.format("ID : %s  -> 참여율 : %.2f\n", key, (float)crewList.get(key) / 18 * 100));
            }
            writer.close();
        }catch(IOException e){
            e.printStackTrace();
        }
    }
```

### 최종 결과물

**< crewList.txt >**

[limyeonsoo/live-study](https://github.com/limyeonsoo/live-study/blob/main/liveStudy_4th/resources/crewList.txt)

**< sourceCode >**

[limyeonsoo/live-study](https://github.com/limyeonsoo/live-study/tree/main/liveStudy_4th)

![4%E1%84%8C%E1%85%AE%E1%84%8E%E1%85%A1%20%E1%84%8C%E1%85%A6%E1%84%8B%E1%85%A5%E1%84%86%E1%85%AE%E1%86%AB%203b58e276e4434f4c85abcc5380b22dd0/Untitled%207.png](4%E1%84%8C%E1%85%AE%E1%84%8E%E1%85%A1%20%E1%84%8C%E1%85%A6%E1%84%8B%E1%85%A5%E1%84%86%E1%85%AE%E1%86%AB%203b58e276e4434f4c85abcc5380b22dd0/Untitled%207.png)

resources 디렉토리에 crewList.txt 가 생성되고 각 사용자가 얼마의 참여율을 갖는지 계산된 값이 작성되었다.

## 과제 2. LinkedList를 구현.

[limyeonsoo/live-study](https://github.com/limyeonsoo/live-study/blob/main/liveStudy_4th/src/main/java/yslLinkedList.java)

- LinkedList에 대해 공부하세요.

    일단  java Collection에  LinkedList와 ArrayList가 있다.

    - ArrayList :

        내부적으로 데이터를 배열에서 관리.
        → 추가, 삭제 시 임시 배열 생성해 복사.
        이 부분이 상당한 성능 저하의 요인. $O(N)$
        → but, 배열로 관리 하므로, **Index가 있고**,
        Index를 통해 검색에는 장점을 지닌다. $O(1)$

    - LinkedList :

        Node간의 연결을 통해 관리.
        → 데이터 검색 시 첫 노드(head)부터 순회.
        탐색이 성능 저하의 요인. $O(N)$
        → 추가, 삭제 시 복사가 없고 노드만으로 가능. $O(1)$

### LinkedList, ArrayList와 Vector의 차이점.

![4%E1%84%8C%E1%85%AE%E1%84%8E%E1%85%A1%20%E1%84%8C%E1%85%A6%E1%84%8B%E1%85%A5%E1%84%86%E1%85%AE%E1%86%AB%203b58e276e4434f4c85abcc5380b22dd0/Untitled%208.png](4%E1%84%8C%E1%85%AE%E1%84%8E%E1%85%A1%20%E1%84%8C%E1%85%A6%E1%84%8B%E1%85%A5%E1%84%86%E1%85%AE%E1%86%AB%203b58e276e4434f4c85abcc5380b22dd0/Untitled%208.png)

**+ vector
동기화 기능 제공 → 쓰레드 세이프**

- 정수를 저장하는 ListNode 클래스를 구현하세요.
- ListNode add(ListNode head, ListNode nodeToAdd, int position)를 구현하세요.
- ListNode remove(ListNode head, int positionToRemove)를 구현하세요.
- boolean contains(ListNode head, ListNode nodeTocheck)를 구현하세요.
- int 배열을 사용해서 정수를 저장하는 Stack을 구현하세요.

```java
public class yslLinkedList {
    private int value;
    private int size;
    public yslLinkedList next;

    public int getValue() { return value; }
    public int getSize() { return size; }
    public void setSize(int newSize) {this.size = newSize;}
    public yslLinkedList(){
        this.size = 0;
        this.next = null;
    }
    public yslLinkedList(int value){
        this.value = value;
        this.size += 1;
    }

    public yslLinkedList add(yslLinkedList head, yslLinkedList nodeToAdd, int position){
        // node추가 시 제일 앞 / 중간 / 제일 뒤  고려.
        if(position == 1) {  // 첫 노드
            if(head.getSize() > 0){ // 들어올 노드에 기존 노드를 연결해주어야 함.
                nodeToAdd.next = head.next;
            }
            head.next = nodeToAdd;
        }
        else if(1 < position && position <= head.getSize()) {  // 중간 노드
            // 중간이니 탐색을 해야함.
            yslLinkedList temp = head;
            for(int i=0; i<position-1; i++){
                temp = temp.next;
            }
            nodeToAdd.next = temp.next;
            temp.next = nodeToAdd;
        }
        else if(position == head.getSize()+1){  // 끝 노드
            // 중간이니 탐색을 해야함.
            yslLinkedList temp = head;
            for(int i=0; i<position-1; i++){
                temp = temp.next;
            }
            nodeToAdd.next = null;
            temp.next = nodeToAdd;
        }
        else {
            System.out.println("=====Out of Range=====\n("+position+")");
            return nodeToAdd;
        }
        head.setSize(head.getSize()+1);
        return nodeToAdd;
    }

    public yslLinkedList remove(yslLinkedList head, int positionToRemove){
        // 대상 앞 노드 -> 대상 뒤 노드
        yslLinkedList targetNode = null;
        yslLinkedList preNode = head;
        for(int i=0; i<positionToRemove-1; i++){
            preNode = preNode.next;
        }
        targetNode = preNode.next;
        preNode.next = targetNode.next;

        head.setSize(head.getSize()-1);
        System.out.println(positionToRemove+"번째 값 : "+targetNode.getValue()+" 삭제");
        return targetNode;
    }
    public boolean contains(yslLinkedList head, yslLinkedList nodeToCheck) {
        yslLinkedList search = head;
        for (int i = 0; i < head.getSize(); i++) {
            search = search.next;
            if (search == nodeToCheck) {
                System.out.println("in " + (i + 1) + "  value : " + search.getValue());
                return true;
            }
        }
        System.out.println("No Matching Node");
        return false;
    }

    public void print(){
        System.out.println("=====Current State=====");
        yslLinkedList temp = this.next;
        for(int i=0; i<this.size; i++) {
            System.out.print(temp.getValue());
            System.out.print(" ");
            temp = temp.next;
        }
        System.out.println();
    }
public static void main(String[] args) {
        yslLinkedList head1 = new yslLinkedList();
        yslLinkedList ll1 = new yslLinkedList(3);
        yslLinkedList ll2 = new yslLinkedList(5);
        yslLinkedList ll3 = new yslLinkedList(7);

        head1.add(head1, ll1, 1);
        head1.add(head1, ll2, 1);
        head1.add(head1, ll3, 1);
        head1.print();

        yslLinkedList head2 = new yslLinkedList();
        yslLinkedList ll21 = new yslLinkedList(3);
        yslLinkedList ll22 = new yslLinkedList(5);
        yslLinkedList ll23 = new yslLinkedList(7);
        yslLinkedList ll24 = new yslLinkedList(10);
        yslLinkedList ll25 = new yslLinkedList(8);
        head2.add(head2, ll21, 1);
        head2.add(head2, ll22, 2);
        head2.add(head2, ll23, 3);
        head2.add(head2, ll24, 1);
        head2.add(head2, ll25, 6);
        head2.print();

        head1.remove(head1, 2);
        head2.remove(head2, 3);
        head1.print();
        head2.print();

        head1.contains(head1, ll21);
        head1.contains(head1, ll1);

        head2.contains(head2, ll2);
        head2.contains(head2, ll21);
    }
```

![4%E1%84%8C%E1%85%AE%E1%84%8E%E1%85%A1%20%E1%84%8C%E1%85%A6%E1%84%8B%E1%85%A5%E1%84%86%E1%85%AE%E1%86%AB%203b58e276e4434f4c85abcc5380b22dd0/Untitled%209.png](4%E1%84%8C%E1%85%AE%E1%84%8E%E1%85%A1%20%E1%84%8C%E1%85%A6%E1%84%8B%E1%85%A5%E1%84%86%E1%85%AE%E1%86%AB%203b58e276e4434f4c85abcc5380b22dd0/Untitled%209.png)

## 과제 3. Stack 구현.

[limyeonsoo/live-study](https://github.com/limyeonsoo/live-study/blob/main/liveStudy_4th/src/main/java/yslStack.java)

→  int 배열을 미리 크게 할당하지 않는 이상. 동적할당이 필요하다.
⇒ vector를 통해 쉽게 add, remove, clear 가능.

```java
public yslStack(){
		data = new Vector<Integer>();
}
public void push(int x){
    data.add(x);
}
public void pop(){
    data.remove(data.size()-1);
}
public void clear(){
    data.removeAllElements();
}
```

---

⇒ 동적할당을 이용  or  넉넉한 공간 할당.

1. ~~배열의 크기가 작성되면 크기를 변경할 수 없다.
즉, 새로운 배열을 동적으로 생성하여, 데이터를 옮겨주어야 한다.~~
2. 메모리도 스택영역이 따로 존재한다. 크기가 정해져있다.
지정된 영역만큼 사용하도록 프로그래밍 하는 것도 중요하다.

![4%E1%84%8C%E1%85%AE%E1%84%8E%E1%85%A1%20%E1%84%8C%E1%85%A6%E1%84%8B%E1%85%A5%E1%84%86%E1%85%AE%E1%86%AB%203b58e276e4434f4c85abcc5380b22dd0/Untitled%2010.png](4%E1%84%8C%E1%85%AE%E1%84%8E%E1%85%A1%20%E1%84%8C%E1%85%A6%E1%84%8B%E1%85%A5%E1%84%86%E1%85%AE%E1%86%AB%203b58e276e4434f4c85abcc5380b22dd0/Untitled%2010.png)

[https://velog.io/@hidaehyunlee/메모리-구조를-알아보자](https://velog.io/@hidaehyunlee/%EB%A9%94%EB%AA%A8%EB%A6%AC-%EA%B5%AC%EC%A1%B0%EB%A5%BC-%EC%95%8C%EC%95%84%EB%B3%B4%EC%9E%90)

- void push(int data)를 구현하세요.
**⇒ topPointer가 위치한 곳에 data를 삽입한 후,
     topPointer를 다음 위치로 증가시킨다.**
- int pop()을 구현하세요.
**⇒ Empty하지 않는지 확인한 후,
    topPointer는 비어있는 곳을 가르키므로,
    그 아래 위치한 data를 반환 해주고, topPointer를 감소시킨다.**

```java
public class yslStack {
    private int topPointer;
    private int bottomPointer;
    private int[] data = new int[1024];
		
		// 생성자  topPointer == bottomPointer == 0
    public yslStack(){
        topPointer = 0;
        bottomPointer = 0;
    }

		// topPointer와 bottomPointer가 같으면 Empty
    public boolean isEmpty(){
        return (topPointer==bottomPointer);
    }
		
		// push는 topPointer를 후위증가시키면서 data를 push
    public void push(int x){
        data[topPointer++] = x;
    }

		// 비어있는지 확인 후, topPointer를 전위감소시키면서 pop
    public int pop(){
        if(isEmpty()){
            System.out.println("Do Not Pop");
            return -1;
        }
        return data[--topPointer];
    }
		// stack 초기화 -> pointer들의 값만 바꿔준다.
    public void clear(){
        topPointer = bottomPointer = 0;
    }
		
		// 단순 print용
    public void print(){
        if(isEmpty()){ System.out.print("---clear---\n"); return;}
        for (int i = 0; i < topPointer; i++) {
            System.out.print(data[i]);
            System.out.print(" ");
        }
        System.out.print("\n");
    }

    public static void main(String[] args) {
        yslStack st = new yslStack();
        st.print();
        st.pop();
        st.push(1);
        st.push(3);
        st.push(5);
        st.print();
        st.pop();
        st.print();
        st.clear();
        st.print();
    }
}
```

![4%E1%84%8C%E1%85%AE%E1%84%8E%E1%85%A1%20%E1%84%8C%E1%85%A6%E1%84%8B%E1%85%A5%E1%84%86%E1%85%AE%E1%86%AB%203b58e276e4434f4c85abcc5380b22dd0/Untitled%2011.png](4%E1%84%8C%E1%85%AE%E1%84%8E%E1%85%A1%20%E1%84%8C%E1%85%A6%E1%84%8B%E1%85%A5%E1%84%86%E1%85%AE%E1%86%AB%203b58e276e4434f4c85abcc5380b22dd0/Untitled%2011.png)

## 과제 4. ListNode를 사용해 Stack 구현.

[limyeonsoo/live-study](https://github.com/limyeonsoo/live-study/blob/main/liveStudy_4th/src/main/java/yslListNodeStack.java)

- ListNode head를 가지고 있는 ListNodeStack 클래스를 구현하세요.
- void push(int data)를 구현하세요.
- int pop()을 구현하세요.

```java
public class yslListNodeStack {
    private int topPointer;
    private int bottomPointer;
    private yslLinkedList head;
    public yslListNodeStack(yslLinkedList head){
        this.head = head;
        topPointer = 0;
        bottomPointer = 0;
    }
    public boolean isEmpty(){
        return (topPointer == bottomPointer);
    }
    public void push(int data){
        yslLinkedList newNode = new yslLinkedList(data);
        this.head.add(this.head, newNode, this.head.getSize()+1);
        topPointer++;
    }
    public int pop(){
        if(isEmpty()) return -1;
        topPointer--;
        return this.head.remove(this.head, 1).getValue();
    }
    public void print(){
        yslLinkedList temp = this.head;
        System.out.println("=====Current Stack=====");
        for(int i=0; i<this.head.getSize(); i++) {
            temp = temp.next;
            System.out.print(temp.getValue());
            System.out.print(" ");
        }
        System.out.println();
    }
    public static void main(String[] args) {
        yslLinkedList stHead = new yslLinkedList();
        yslListNodeStack st = new yslListNodeStack(stHead);
        st.push(1);
        st.push(2);
        st.push(3);
        st.print();
        st.pop();
        st.pop();
        st.print();
    }
}
```

![4%E1%84%8C%E1%85%AE%E1%84%8E%E1%85%A1%20%E1%84%8C%E1%85%A6%E1%84%8B%E1%85%A5%E1%84%86%E1%85%AE%E1%86%AB%203b58e276e4434f4c85abcc5380b22dd0/Untitled%2012.png](4%E1%84%8C%E1%85%AE%E1%84%8E%E1%85%A1%20%E1%84%8C%E1%85%A6%E1%84%8B%E1%85%A5%E1%84%86%E1%85%AE%E1%86%AB%203b58e276e4434f4c85abcc5380b22dd0/Untitled%2012.png)

## (optional) 과제 5. Queue 구현.

- 배열을 사용해서 한번

```java
public class yslArrayQueue {
    private int [] array = new int [1000];
    private int front;
    private int end;

    public yslArrayQueue(){
        front = 0;
        end = 0;
    }
    public void push(int x){
        array[end++] = x;
    }
    public void pop(){
        array[front++] = 0;
    }
    public void print(){
        for(int i=front; i<end; i++) System.out.print(array[i]+" ");
        System.out.println();
    }
    public static void main(String[] args) {
        yslArrayQueue queue = new yslArrayQueue();
        for(int i=1; i<=10; i++) queue.push(i);
        queue.print();
        queue.pop(); queue.pop();
        queue.print();
    }
}
```

![4%E1%84%8C%E1%85%AE%E1%84%8E%E1%85%A1%20%E1%84%8C%E1%85%A6%E1%84%8B%E1%85%A5%E1%84%86%E1%85%AE%E1%86%AB%203b58e276e4434f4c85abcc5380b22dd0/Untitled%2013.png](4%E1%84%8C%E1%85%AE%E1%84%8E%E1%85%A1%20%E1%84%8C%E1%85%A6%E1%84%8B%E1%85%A5%E1%84%86%E1%85%AE%E1%86%AB%203b58e276e4434f4c85abcc5380b22dd0/Untitled%2013.png)

- ListNode를 사용해서 한번.

```java
public class yslListQueue {
    private yslLinkedList head = new yslLinkedList();
    private int front = 0;
    private int end = 1;

    public void push(int x){
        yslLinkedList newNode = new yslLinkedList(x);
        head.add(head, newNode, end++);
    }
    public void pop(){
        head.remove(head, front++);
    }
    public void print(){
        yslLinkedList temp = head.next;
        for(int i=front; i<end-1; i++) {
            System.out.print(temp.getValue()+" ");
            temp = temp.next;
        }
        System.out.println();
    }
    public static void main(String[] args) {
        yslListQueue q = new yslListQueue();
        for(int i=1; i<=10; i++) q.push(i);
        q.print();
        q.pop(); q.pop();
        q.print();
    }
}
```

![4%E1%84%8C%E1%85%AE%E1%84%8E%E1%85%A1%20%E1%84%8C%E1%85%A6%E1%84%8B%E1%85%A5%E1%84%86%E1%85%AE%E1%86%AB%203b58e276e4434f4c85abcc5380b22dd0/Untitled%2014.png](4%E1%84%8C%E1%85%AE%E1%84%8E%E1%85%A1%20%E1%84%8C%E1%85%A6%E1%84%8B%E1%85%A5%E1%84%86%E1%85%AE%E1%86%AB%203b58e276e4434f4c85abcc5380b22dd0/Untitled%2014.png)

### Queue Test

ArrayQueue 에서 1000개를 다 채우면?

array 가 0~999의 Index가 있으니 0번째를 확인해야한다.

**< getter 추가 >**

```java
public int getFront() {return front;}
public int getEnd() {return end;}
```

**< queueLimitPushCheck   @Test>**

```java
@Test
void queueLimitPushCheck(){
    // given
    yslArrayQueue queue = new yslArrayQueue();

    // when
    for(int i=0; i<1000; i++) queue.push(i);
    queue.pop();
    
    // then  1000개를 넣은 뒤 다음은 0번.
    assertEquals(0, queue.getEnd());
}
```

**< Fail >**

![4%E1%84%8C%E1%85%AE%E1%84%8E%E1%85%A1%20%E1%84%8C%E1%85%A6%E1%84%8B%E1%85%A5%E1%84%86%E1%85%AE%E1%86%AB%203b58e276e4434f4c85abcc5380b22dd0/Untitled%2015.png](4%E1%84%8C%E1%85%AE%E1%84%8E%E1%85%A1%20%E1%84%8C%E1%85%A6%E1%84%8B%E1%85%A5%E1%84%86%E1%85%AE%E1%86%AB%203b58e276e4434f4c85abcc5380b22dd0/Untitled%2015.png)

Index 1000은 없다.

### 원형 큐로 개선.

```java
public void push(int x){
    end = (end+1)%1000;
    array[end] = x;
}
```

![4%E1%84%8C%E1%85%AE%E1%84%8E%E1%85%A1%20%E1%84%8C%E1%85%A6%E1%84%8B%E1%85%A5%E1%84%86%E1%85%AE%E1%86%AB%203b58e276e4434f4c85abcc5380b22dd0/Untitled%2016.png](4%E1%84%8C%E1%85%AE%E1%84%8E%E1%85%A1%20%E1%84%8C%E1%85%A6%E1%84%8B%E1%85%A5%E1%84%86%E1%85%AE%E1%86%AB%203b58e276e4434f4c85abcc5380b22dd0/Untitled%2016.png)

---

# 마감 일시

## 2020년 12월 12일 오후 1시

---