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

view/InputView => 문자열을 받아 배열로 반환하는 객체입니다.  
domain/Operator => 연산을 수행하는 enum 객체입니다.  
domain/StringCalculator => 사칙연산을 수행하는 객체입니다.  
domain/PosfixConvertor => 중위표현식을 후위표현식으로 바꾸어주는 객체입니다.  
