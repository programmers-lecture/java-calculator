# 우선 피연산자 2개와 연산자 1개로 이루어진 식을 처리하는 Calculator를 먼저 만들어보려고 합니다.

# 고려사항
# 최소 메서드단위 최대 클래스 단위로 생각해보고 enum을 활용해서 구현하기.
# 20221214 우선 클래스화 생각 말고 메소드 단위로 먼저 구조화하기

# 변수
   1. 문자열(상수로 관리 -> 찾기 편하게)
   2. 피연산자 (pre, fix)
   3. 연산자 
   4. enum 연산자
# 메서드
   1. 입력 메서드 (입력받는 기능)
   2. 연산 메서드 (매개변수 : 연산자 { enum을 이용해서 연산 })
   3. 출력 메서드 (연산결과를 출력하는 기능)
----------------------------------------------------------------
# 메서드
inputMethod()       : 입력메서드
outputMethod()      : 출력메서드
getPreOperand(String)     : 식에서 charAt을 이용해 첫번째 피연산자 추출
getFixOperand(String)     : 식에서 charAt을 이용해 두번째 피연산자 추출
getOperator(String)       : 식에서 charAt을 이용, enum Operator의 필드를 이용, 해당 enum Operator 객체 반환
operateExpression(int, int, Operator) : 매개변수를 이용해 switch문을 통해 String형태로 연산결과 반환 

[y] 입력 메서드
[y] 피연산자 추출
[y] 연산자 추출
[y] enum생성
[y] 연산 메서드
[y] 출력 메서드

