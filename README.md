# prometheus-back
1. Camunda:
 id: demo
 password: demo


2. SM

Пример переключения состояний SM (из AWAITING в CHECKING): 
http://localhost:8080/sendEvent?event=UNIT_ARRIVED


будет 4 состоянии: AWAITING, CHECKING, PROCCESSING_ALLOWED_NUMBER, PROCCESSING_FORBIDEN_NUMBER
4 перехода: UNIT_ARRIVED, NUMBER_ALLOWED, NUMBER_FORBIDEN, IN_AWAITING.
