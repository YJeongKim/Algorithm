# 알고리즘 유형 분류 1

<br>

> #### 실행(구현) 방법에 따른 알고리즘 분류

<br>

1. 재귀 (Recursion)  

   : 자신을 정의할 때 자기 자신을 재참조 하는 방법이다.  
    어떤 조건이 만족할 때까지 반복적으로 수행하는 방법이다.  
    예) 하노이의 탑(towers of Hanoi), 피보나치  
   <br>

2. 논리 추론 (Logical)  

   : 프로그래밍 언어론에서 구문분석(Semantics) 같은 것이다.  
   <br>

3. 직렬, 병렬 혹은 분산 (Serial, Parallel or distributed)  

   : 한 번에 하나의 명령어를 수행하는 컴퓨터를 직렬 컴퓨터라고 하는데,   
    이 직렬 컴퓨터에서 동작하는 알고리즘을 직렬 알고리즘이라고 한다.  
    이와 반대로 병렬 혹은 분산 알고리즘이 있다.  
    병렬 알고리즘은 동시에 몇몇 프로세서가 하나의 문제를 푸는 컴퓨터 구조를 이용한다.  
   <br>

4. 결정적 혹은 비결정적 (Deterministic or non-deterministic)  

   : 결정적 알고리즘은 같은 입력에 대해 항상 같은 출력을 내보낸다.  
    즉, 알고리즘의 각 단계마다 정확한 결정을 내린다.  
    비결정적 알고리즘은 같은 입력이 주어지더라도 실행될 때마다 다른 행동을 취한다.  
    추측을 통해 문제를 해결한다고 볼 수 있다.  
   <br>

5. 정확한가 혹은 대략적인가 (Exact or approximate)  

   : 많은 알고리즘들은 정확한 해에 도달하지만,  
    근사 알고리즘(Approximation algorithms)은 진짜 해에 가까운 근사 해에 도달한다.  
    근사 알고리즘 예) 배낭 문제(Knapsack algorithm)  
   <br>

6. 양자 알고리즘 (Quantum algorithm)  

   : 양자 컴퓨터에서 동작하는 알고리즘이다.  
   <br>
<br>

> #### 설계 양식(Design Paradigm)에 따른 분류

<br>

1. 무차별 공격 (Brute-force or exhaustive search)  

   : 가능한 모든 해에 대해 검사하는 방법이다.  
   <br>

2. 분할 정복 (Divide and Conquer)  

   : 문제를 쉽게 해결할 수 있는 하나의 똑같은 작은 문제로 쪼개어 나가는 방법이다.  
    예) 합병 정렬(Merge sort)  
    이 방법의 변형으로 Decrease and Conquer가 있다.  
    예) 이진 탐색(Binary Search Algorithm)  
   Divide and Conquer 방법이 Decrease and Conquer 방법보다 Conquer 과정에서 복잡하다.  
   <br>

3. 검색 열거 (Search and enumeration)  

   : 많은 문제들은 그래프 문제로 모델링 할 수 있다.  
    그래프 탐색 알고리즘(Graph exploration algorithms)은 이러한 문제에 유용하다.  
    탐색 알고리즘(Search algorithm), 분기 한정법(Branch and bound) 등을 포함한다.  
   <br>

4. 무작위 알고리즘 (Randomized algorithm)  

   : 정확한 해를 찾는 것이 실용적이지 않은 문제에서  
    대략적인 해를 찾는데 유용한 알고리즘이다.  
    크게 Monte Carlo Algorithms과 Las Vegas Algorithms으로 나뉜다.  
   <br>

5. 복잡도 환원 (Reduction of complexity)  

   : 어려운 문제를 잘 알려진 다른 문제로 바꾸는 방법이다.  
    예를 들어 중간값을 찾는 문제는 정렬 문제로 바꾸어 풀 수 있다.  
    Transform and Conquer 라 불리기도 한다.  
   <br>

6. 역추적 (Back Tracking)

   : 다양한 해를 얻은 다음에 유효하지 않은 해들은 버리는 방법이다.  
    후보들을 줄이는 방법이라고 생각하면 된다.  
   <br>
<br>

> #### 최적화 문제(Optimization problems)

<br>

1. 선형 프로그래밍, 선형 계획법 (Linear programming)  

   : 선형 함수를 모델링되는 문제에 대해 최적 해를 찾는 방법이다.  
    문제에서 추가적으로 미지수가 정수여야 한다는 조건이 주어지면 integer programming.  
    예) 단체법(Simplex Algorithm), Maximum flow problem  
   <br>

2. 동적 프로그래밍 (Dynamic Programming)  

   : 똑같은 계산을 줄이는 방법이다.  
    메모이제이션(계산 값을 메모리에 저장하는 기술)을 이용한다.  
    예) Floyd-Warshall algorithm   
    문제에 대한 최적해(Optimal solution)가 하부문제에 대한 최적해로부터 만들어질 때 사용된다.  
    
    동적 프로그래밍과 분할 정복의 차이는 분할 정복의 하부 문제들이 보다 독립적이다.  
    반면에 동적 프로그래밍에서 하부 문제들은 서로 겹쳐진다.  
    동적 프로그래밍과 재귀(Straightforward recursion)의 차이는  
    재귀 함수 콜이 메모이제이션을 이용하냐 캐싱을 이용하냐에 따라 다르다.  

    하부 문제들이 독립적이고 반복되지 않을 때는 메모이제이션의 효율은 떨어진다.  
    동적 프로그래밍이 복잡한 문제에 대해 항상 해를 가지는 것은 아니다.  
  <br>

3. 탐욕 알고리즘 (The Greedy Method)  

   :  하부 구조를 평가하면서 동작한다는 관점에서 동적 프로그래밍과 비슷하다.  
    동적 프로그래밍은 문제의 하부 구조를 평가하지만,  
    탐욕 알고리즘은 해의 하부 구조를 평가한다.  
    예) Huffman Tree, Kruskal, Prim, Sollin Algorithms  
   <br>

4. 체험적인 방법 (The Heuristic Method)  

   : 최적 해를 찾는 것이 실용적이지 않은 문제에서 사용한다.  
    예) local search, tabu search, simulated annealing, genetic algorithms  
   <br>
<br>

> #### 그 외

<br>

연구 분야에 따라 알고리즘을 분류 할 수도 있다.  
컴퓨터 과학의 모든 분야들은 각각의 알고리즘들을 가지고 있다.  
네트워크, 암호학, 인공지능 등 각 분야마다 알고리즘을 가지고 있다.  
<br>
복잡도에 따라서도 알고리즘을 분류 할 수 있다.  
상수 시간이 걸리는 배열에 접근하는 방법이나, 리스트를 탐색하는 선형시간이 걸리는 알고리즘 등  
복잡도에 따라 구분지을 수 있다.  
<br>

******
#### 참고  

###### [블로그] https://inpages.tistory.com/85  
