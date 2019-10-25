# 멱집합 powerset

: 어떤 집합의 모든 부분 집합의 집합



![image-20191219182341033](C:\Users\김연정\AppData\Roaming\Typora\typora-user-images\image-20191219182341033.png)

- {a,b,c,d,e,f}의 모든 부분집합을 나열하려면?

  - a를 제외한 {b,c,d,e,f}의 모든 부분집합들을 나열하고
  - {b,c,d,e,f}의 모든 부분집합에 {a}를 추가한 집합들을 나열한다.

  - {b,c,d,e,f}의 모든 부분집합에 {a}를 추가한 집합들을 나열하려면?
    - {c,d,e,f}의 모든 부분집합들에 {a}를 추가한 집합들을 나열하고
    - {c,d,e,f}의 모든 부분집합에 {a,b}를 추가한 집합들을 나열한다.
    - {c,d,e,f}의 모든 부분에 {a}를 추가한 집합들을 나열하려면?
      - {d,e,f}의 모든 부분집합들에 {a}를 추가한 집합들을 나열하고
      - {d,e,f}의 모든 부분집합에 {a,c}를 추가한 집합들을 나열한다.



powerSet(S) // S의 멱집합을 출력

if S is an empty set // 공집합이라면

​	print nothing;

else

​	let t be the first element of S;

​	find all subsets of S-{t} by calling powerSet(S-{t});

​	print the subsets;

​	print the subsets with adding t;

이렇게 하려면 powerSet 함수는 여러 개의 집합들을 return 해야한다. 어떻게???

2의 n승개의 집합들을 어딘가 메모리에 저장해두어야하기에 별로 좋지 않은 방법

<u>__recursion으로 해결__</u>

powerSet(P, S) // S의 멱집합을 구한 후 각각에 집합 P를 합집합하여 출력

if S is an empty set // 공집합이라면

​	print P;

else

​	let t be the first element of S;

​	powerSet(P, S-{t}); // t 포함 x

​	powerSet(PU{t}, S-{t}); // t 포함 o

recursion 함수가 두 개의 집합을 매개변수로 받고록 설계해야한다는 의미이다. 두 번째 집합의 모든 부분집합들에 첫번째 집합을 합집합하여 출력한다.

집합 S : k번째부터 마지막 원소까지 연속된 원소들이다. {c,d,e,f}

집합 P : 처음부터 k-1번째 원소들 중 일부이다. {a,b}



###### 두 집합의 표현

![image-20191219184442040](C:\Users\김연정\AppData\Roaming\Typora\typora-user-images\image-20191219184442040.png)

TRUE : 포함 / FALSE : 불포함



```java
private static char data[] = {'a', 'b', 'c', 'd', 'e', 'f'};
private static int n = data.length;
private static boolean [] include = new boolean [n];
public static void powerSet(int k) {
    if (k==n) { // 집합 S가 공집합이라는 의미
        for (int i=0; i<n; i++)
            if (include[i]) System.out.print(data[i] + " ");
        System.out.println();
        return;
    }
    include[k]=false; // k번째 원소를 포함하지 않는 경우
    powerSet(k+1);
    include[k]=true; // k번째 원소를 포함하는 경우
    powerSet(k+1);
}
```

처음 이 함수를 호출할 때는 powerSet(0)으로 호출한다. 즉, P는 공집합이고 S는 전체집합이다.



상태공간트리 state space tree

![image-20191219185315993](C:\Users\김연정\AppData\Roaming\Typora\typora-user-images\image-20191219185315993.png)

*그림잘못됨. include와 exclude 위치가 바뀜

- 해를 찾기 위해 탐색할 필요가 있는 모든 후보들을 포함하는 트리
- 트리의 모든 노드들을 방문하면 해를 찾을 수 있다.
- 루트에서 출발하여 체계적으로 모든 노드를 방문하는 절차를 기술한다.

![image-20191219185849065](C:\Users\김연정\AppData\Roaming\Typora\typora-user-images\image-20191219185849065.png)