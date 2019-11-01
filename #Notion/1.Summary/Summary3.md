# 알고리즘 개요 3

<br>

> ### 점근적 표기법

<br>

점근적 표기법에는 대표적으로 대문자 오(O) 표기법, 대문자 오메가(Ω) 표기법, 대문자 세타(Θ) 표기법, 소문자 오(o) 표기법, 소문자 오메가(ω) 표기법으로 다섯 종류가 있다.



###### * 잠깐! 그래프가 아래에 있을수록 수행시간이 짧은 것이므로 성능이 좋은 것이다.

#### # O Notation (빅-오 표기법) - 최악의 경우

: O(g(n)) = { f(n) : n ≥ n<sub>0</sub> 인 모든 n에 대해 0 ≤ f(n) ≤ cg(n) 를 만족하는 양수 상수 c 와 n<sub>0</sub> 가 존재 }

<p align="center">
    <img src="https://user-images.githubusercontent.com/33328991/72201144-6d31b600-3494-11ea-91f8-b28be835c9e4.JPG" alt="bigo" />
    <img src="https://i.imgur.com/QmfDswm.png" alt="img" width="30%" />
</p>

- g(n)을 함수 f(n)의 **점근적 상한 (Asymptotic Upper Bound)** 이라고 한다.

- n<sub>0</sub>보다 오른쪽에 있는 모든 n에 대해서 함수 f(n)의 값은 cg(n)과 같거나 아래쪽에(작음) 있다.

  f(n)의 절댓값이 n이 무한대(∞)로 감에 따라 언젠가는(n<sub>0</sub>의 값을 만나면)

  g(n)의 절댓값에 임의의 양의 상수 c를 곱한 값보다 작아진다. (양의 상수가 하나만 존재해도 성립한다)

- 주어진 알고리즘이 아무리 나빠도(최악의 경우라도) 비교하는 함수와 같거나 좋다.

<br>

#### # Ω Notation (빅-오메가 표기법) - 최선의 경우

: Ω(g(n)) = { f(n) : n ≥ n<sub>0</sub> 인 모든 n에 대해 0 ≤ cg(n) ≤ f(n)를 만족하는 양수 상수 c 와 n<sub>0</sub> 가 존재 }

<p align="center">
    <img src="https://user-images.githubusercontent.com/33328991/72201145-6dca4c80-3494-11ea-806f-1d6a124a701e.JPG" alt="bigomega" />
    <img src="https://i.imgur.com/1Hnuy1s.png" alt="img" width="30%" />
</p>

- g(n)을 함수 f(n)의 **점근적 하한 (Asymptotic Lower Bound)** 이라고 한다.

- n<sub>0</sub> 보다 오른쪽에 있는 모든 n에 대해서 함수 f(n)의 값은 cg(n)과 같거나 위쪽에(큼) 있다.

  f(n)의 절댓값이 n이 무한대(∞)로 감에 따라 언젠가는(n<sub>0</sub>의 값을 만나면)

  g(n)의 절댓값에 임의의 양의 상수 c를 곱한 값보다 커진다.

- 주어진 알고리즘이 아무리 좋아도(최선의 경우라도) 비교하는 함수와 같거나 나쁘다.

<br>

#### # Θ Notation (세타 표기법) - 평균(최악과 최선의 중간 어느 지점)의 경우

: Θ(g(n)) = { f(n) : n ≥ n<sub>0</sub> 인 모든 n에 대해 0 ≤ c<sub>1</sub>g(n) ≤ f(n) ≤ c<sub>2</sub>g(n) 을 만족하는 양수 상수 c<sub>1</sub>, c<sub>2</sub>와 n<sub>0</sub> 가 존재 }

<p align="center">
    <img src="https://user-images.githubusercontent.com/33328991/72201146-6efb7980-3494-11ea-9de3-afb803a2cf28.JPG" alt="bigtheta" />
    <img src="https://i.imgur.com/Bx7ykk3.png" alt="img" width="30%" />
</p>

- g(n)을 함수 f(n)의 **점근적 상한 및 하한의 교집합 (Asymptotically Tight Bound)** 이라고 한다.

- n<sub>0</sub>보다 오른쪽에 있는 모든 n에 대해서 함수 f(n)의 값은 c<sub>1</sub>g(n)과 같거나 위쪽에(큼) 있고

  c<sub>2</sub>g(n)과 같거나 아래쪽에(작음) 있다.

- 주어진 알고리즘이 아무리 좋거나 나쁘더라도 비교하는 함수의 범위 안에 있다.

<br>

#### # o Notation (리틀-오 표기법) - 보다 엄격한 최악의 경우

<p align="center"><img src="https://user-images.githubusercontent.com/33328991/72201147-702ca680-3494-11ea-9014-f1755448e08a.JPG" alt="littleo" /></p>

- g(n)을 함수 f(n)의 점근적 상한 (Asymptotic Upper Bound) **보다 여유 있는 상한**이라고 한다.

- Big O는 n이 무한대로 커질 때만이 아니라 특정 값에 가까워질 때에 대해서도 사용될 수 있는 개념인데,

  Little O는 n이 무한대로 커지는 상황에서만 사용되는 개념이다.

- g(n)의 절댓값에 어떤 작은 양의 숫자 c를 곱해도 f(n)보다 커지는 순간이 n을 키우다 보면 언젠가는 나타난다.

  (모든 양의 상수가 성립해야 한다)

- '어떤 작은 양의 숫자 c를 곱해도'라는 조건이 추가되었기 때문에 빅-오 보다 조건이 더욱 엄격하다.

  (리틀-오를 성립한다면 빅-오도 성립한다)

<br>

#### # ω Notation (리틀-오메가 표기법) - 보다 엄격한 최선의 경우

<p align="center"><img src="https://user-images.githubusercontent.com/33328991/72201148-715dd380-3494-11ea-80b6-c300d99a0a52.JPG" alt="littleomega" /></p>

- g(n)을 함수 f(n)의 점근적 하한 (Asymptotic Lower Bound) **보다 여유 있는 하한**이라고 한다.

<br>

#### # 표기법 간의 관계

|   표기법   |         대략적 의미         |
| :--------: | ------------------------- |
| **f=ω(g)** |    f는 g보다 크다,  f>g     |
| **f=Ω(g)** | f는 g보다 크거나 같다,  f≥g |
| **f=Θ(g)** |   f는 g와 대략 같다,  f=g   |
| **f=O(g)** | f는 g보다 작거나 같다,  f≤g |
| **f=o(g)** |    f는 g보다 작다,  f<g     |

ω(g), Ω(g), Θ(g), O(g), o(g)는 각각 함수의 **집합**을 의미한다. 각 집합의 요소 수는 무한히 많을 것이다.

다섯 집합 사이의 관계를 따져보면 다음과 같다.

<p align="center"><img src="https://i.imgur.com/tMfg0j8.png" alt="img" width="50%" /></p>
<br>

******

<br>

> ### Big-O 표기법의 종류와 성능

<br>

#### # Big-O 표기법의 종류

|       Notation       |          Name          |
| ------------------ | -------------------- |
|       **O(1)**       |    Constant (상수)     |
|     **O(log n)**     |   Logarithmic (로그)   |
|       **O(n)**       |     Linear (선형)      |
|    **O(n log n)**    | Log Linear (선형 로그) |
| **O(n<sup>2</sup>)** |    Quadratic (2차)     |
| **O(n<sup>3</sup>)** |      Cubic (3차)       |
| **O(2<sup>n</sup>)** |   Exponential (지수)   |
|      **O(n!)**       |  Factorial (팩토리얼)  |

- O(1)

  - 문제를 해결하는데 오직 한 단계만 거친다.
  - 입력 데이터와 상관없이 일정한 실행 시간을 가진다.
    - 스택에서 push, pop

- O(log n)

  - 문제를 해결하는 데 필요한 단계들이 연산마다 특정 요인에 의해 줄어든다. 

  - 입력 데이터가 증가하면 실행 시간이 조금씩 증가한다.

  - 주로 커다란 문제를 일정한 크기를 갖는 작은 문제로 쪼갤 때 나타나는 유형이다.

    (성능이 좋은 탐색 알고리즘은 대부분 log n의 수행 시간을 가진다.)

    - 이진 트리, 이진 검색

- O(n) 

  - 문제를 해결하기 위한 단계의 수와 입력값이 1:1 관계를 가진다.
  - 입력 데이터 수와 비례하여 실행 시간이 선형적으로 증가한다.
  - for문, 순차 검색

- O(n log n)

  - 입력 데이터가 늘어난 양보다 조금 더 늘어난 실행 시간을 가진다.
  - 주로 커다란 문제를 나누어 해결하고 이를 다시 합치는 과정에서 나타나는 유형이다.
  - n이 두 배로 늘어나면 실행 시간은 두 배보다 약간 더 많이 늘어난다.
    - 퀵 정렬, 합병 정렬, 힙 정렬

- O(n<sup>2</sup>)
- 문제를 해결하기 위한 단계의 수는 입력값 n의 제곱이다.
  - 입력 데이터가 커질수록 배수로 늘어나는 실행 시간을 가진다.
- 데이터의 제곱에 비례하여 효율이 좋지 않다.
  - n이 두 배면 수행 시간은 네 배로 늘어나고 데이터가 많으면 감당할 수 없다.
- 주로 이중 루프 내에서 입력 자료를 처리하는 경우에 나타나는 유형이다.
  - 이중 for 문, 삽입 정렬, 버블 정렬, 선택 정렬
- O(n<sup>3</sup>)
  - 입력 데이터가 커질수록 배수로 늘어나는 실행 시간을 가진다.
  - n이 두 배면 수행 시간은 여덟 배로 늘어나고 데이터가 많으면 감당할 수 없다.
  - 주로 삼중 루프 내에서 입력 자료를 처리하는 경우에 나타나는 유형이다.

- O(2<sup>n</sup>)
  - 문제를 해결하기 위한 단계의 수는 주어진 상숫값(c) 의 n 제곱이다.
  - 입력 데이터가 증가하면 실행 시간이 급격하게 증가한다.
    - 피보나치 수열

- O(n!)
  - 입력 데이터에 따라 데이터의 양이 팩토리얼만큼 증가한다.

<br>

#### # 성능 비교

<p align="center"><img src="https://t1.daumcdn.net/cfile/tistory/99EF1E395C7EB4B601" alt="img" width="70%" /></p>
그래프에 나와 있는 시간 복잡도의 성능을 비교하면 다음과 같다.

(왼쪽에서 오른쪽으로 갈수록 효율성이 떨어진다.)

<div align="center">faster&emsp;&emsp;<img src="https://t1.daumcdn.net/cfile/tistory/995DFD335C7EB57801" alt="img" />&emsp;&emsp;slower</div>

<br>

******

#### 참고

###### [블로그] [https://ratsgo.github.io](https://ratsgo.github.io/data%20structure&algorithm/2017/09/13/asymptotic/) - 그림, 내용

###### [블로그] [https://noahlogs.tistory.com](https://noahlogs.tistory.com/27) - 그림

###### [블로그] [https://sdolnote.tistory.com](https://sdolnote.tistory.com/entry/BigOLittleo) - 내용

