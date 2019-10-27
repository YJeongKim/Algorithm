# 알고리즘 개요 1

<br>

> ### 컴퓨터 알고리즘의 정의

<br>

#### # 컴퓨터 알고리즘이란?

- 컴퓨터 언어 (Computer Language)

  : 컴퓨터와 대화하기 위해서 사용하는 언어

  예) C, C++, Java, Python 등  

- 컴퓨터 알고리즘 (Computer Algorithm)

  : 컴퓨터를 이용하여 주어진 문제를 풀기 위한 방법이나 절차

  문제를 효율적으로 풀기 위한 방법을 단계별로 기술해 놓은 것

  예) 정렬, 해쉬, 최단거리 알고리즘 등  

- 컴퓨터 프로그램 (Computer Program)

  : 컴퓨터가 특정 작업을 수행하기 위해 짜여진 명령의 순서  

<br>

#### # 컴퓨터 알고리즘을 설명하기 위한 4단계

- 문제 정의 (Problem Definition)

  - 해결하고자 하는 문제는 무엇인가?

  - 입력과 출력의 형태로 정의될 수 있는가?

  - 컴퓨터가 수행할 수 있는 형태로 전환이 가능한가?  

- 알고리즘 설명 (Algorithm Description)

  - 컴퓨터가 수행해야 할 내용을 하나씩 차례대로 정의한 과정  

- 정확성 증명 (Correctness Proof)

  - 과정대로 수행하면 출력으로 항상 올바른 답을 내보내는가?

  - 잘못된 답을 내보내는 경우는 없는가?

  - 올바른 출력을 내보내고 정상적으로 종료되는가?  

- 성능 분석 (Performance Analysis)

  - 수행시간 (Running Time)

  - 사용공간 (Space Consumption)  

<br>

******

<br>

> ### 컴퓨터 알고리즘의 분석

<br>

#### # 컴퓨터 알고리즘의 수행시간 분석

- 수행시간은 실행 환경에 따라 달라진다.

  : 하드웨어, 운영체제, 언어, 컴파일러 등

- 특정 기계에서 수행시간을 측정하는 것은 공정하지 않다.

  : 조건이 동일한 특정 기계에서 모든 알고리즘의 수행시간을 측정해야 하는데 현실적으로 불가능

- **수행연산의 횟수를 비교**하는 방식으로 성능을 분석한다.  

<br>

#### # 성능 분석의 비교 대상

- 산술 연산 (Arithmetic Calculation)

  : Add, Multiply, Exponent, Modular, ...

- 데이터 입출력 (Data Movement)

  : Copy, Move, Save, Load, ...

- 제어 연산 (Access Control)

  : If, While, Register, ...

<br>

#### # 시간 복잡도 (Time Complexity)

: 문제를 해결하는데 걸리는 시간과 입력의 함수 관계이다.  

<img src="https://t1.daumcdn.net/cfile/tistory/234A3548565E79A50E" alt="img" style="zoom: 100%;" align="left" />  











- 연산의 실행 횟수는 입력 데이터의 크기에 관한 함수로 표현

  : 수행시간은 입력의 크기가 커질수록 시간이 많이 걸린다.

  따라서 수행시간은 입력 크기 n에 대한 함수로 표현한다. 예) T(n)

- n에 대한 다항식에서 최고차항만을 고려한다.

- 데이터의 크기가 같더라도 실제 데이터에 따라서 달라진다.

  - 최악의 경우 시간복잡도 (worst-case analysis)

  - 평균 시간복잡도 (average-case analysis)

<br>

#### # 점근적 표기법 (Asymptotic Notaion)

: 데이터의 개수 n→∞일때 수행시간이 증가하는 비율(growth rate)로 시간복잡도를 표현하는 기법이다.  

- 성능분석을 위해 알고리즘에 포함된 연산들의 실행 횟수를 표기하는 하나의 기법

- 원 함수를 단순화하여 <u>최고차항의 차수</u>만으로 표시한다. (최고차항의 계수, 나머지 항 모두 무시)  

- 가장 자주 실행되는 연산 혹은 문장의 실행 횟수를 고려하는 것으로 충분하다.

  - o-notation (리틀오 표기) / O-notation (빅오 표기)
- Θ-notation (쎄타 표기)
  - Ω-notation (오메가 표기) / ω-notation (리틀오메가 표기)

<br>

******
#### 참고

###### [블로그] [https://gompangs.tistory.com/entry/알고리즘](https://gompangs.tistory.com/entry/%EC%95%8C%EA%B3%A0%EB%A6%AC%EC%A6%98-%EC%8B%9C%EA%B0%84%EB%B3%B5%EC%9E%A1%EB%8F%84Time-Complexity) - 그림

