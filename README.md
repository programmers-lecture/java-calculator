## 깃허브

**[java-calculator](https://github.com/programmers-lecture/java-calculator)**

## 필수 요구사항

1. 입력을 받았을 경우 사칙연산(+, -, *, /)이 가능해야 한다.
2. 피연산자(숫자)의 범위는 Integer로 한정한다.

## 추가 요구사항
1. 숫자에 소수를 적용해본다.
2. 사칙연산 우선순위를 적용한다.
    - *, /와 +, -가 있다면 *, / 가 먼저 진행되어야 한다.

cf) 추가 요구사항은 순서대로 적용해보시고, 필수 요구사항이 모두 구현을 하고 난 이후에 구현해주시길 바랍니다. 

## 프로그램 실행 결과

```jsx
1 + 2
결과 : 3

1 - 2 + 5
결과 : 4

3 * 4
결과 : 12

3 + 2 * 3
결과 : 9
```

## 미션 가이드 (학생)

1. ReadMe에 각 객체에 대한 간단한 다이어그램(설명)을 작성한다.
2. ReadMe에 각 요구사항에 대한 체크 리스트를 작성한다.
3. 커밋은 최소한의 단위로 진행한다.
4. 객체지향 생활 체조를 지켜서 개발한다.
    
    [객체지향 생활 체조 총정리](https://developerfarm.wordpress.com/2012/02/03/object_calisthenics_summary/)


## 구현 기능 목록

- 전체 계산식 입력한 값을 받는다.
- 띄어쓰기는 제거한다.
- 입력된 계산식을 후위 표기식으로 변경한다.
- 변경된 후위 표기식 계산식을 한글자씩 읽는다.
- 숫자인 경우 스택에 저장한다.
- 연산자인 경우 저장된 숫자를 뒤에서 두 개씩 꺼내서 연산한다.
- 연산자 + 인 경우 더한다.
- 연산자 - 인 경우 뺀다.
- 연산자 * 인 경우 곱한다.
- 연산자 / 인 경우 나눈다. (0으로 나누는 경우 에러 발생)
- 계산된 값을 다시 저장한다.
- 숫자와 연산자 제외한 값이 존재하는 경우 에러를 발생시킨다.
- 계산식을 모두 읽을 때까지 한글자씩 읽으며 위 과정(5 ~ 12)을 반복한다.
- 연산자 계산이 완료되면 계산된 결과를 출력한다.


## 구조 설명

- InputView: 전체 계산식 입력받는 객체
- OutputView: 계산 결과를 받아서 출력하는 객체
- Operator: 연산자 정보 저장하고 사칙연산하는 객체
- Caculator: 계산식을 받아서 계산 수행하는 객체
- CaculatorController: 계산기 작동 수행을 위한 객체