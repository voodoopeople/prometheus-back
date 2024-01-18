# prometheus-back
1. Camunda:
 id: demo
 password: demo


2. SM

Пример переключения состояний SM (из AWAITING в CHECKING): 
http://localhost:8080/sendEvent?event=UNIT_ARRIVED


будет 4 состоянии: AWAITING, CHECKING, PROCCESSING_ALLOWED_NUMBER, PROCCESSING_FORBIDEN_NUMBER
4 перехода: UNIT_ARRIVED, NUMBER_ALLOWED, NUMBER_FORBIDEN, IN_AWAITING.


==================================================================================================
Graph-support - это реализация инструмента graphviz на основе Java без каких-либо дополнительных 
зависимостей.

Graphviz невероятно полезен для быстрого создания изображений или графиков, но его часто необходимо 
загружать и устанавливать, что не всегда идеально, особенно в производственных средах.

С помощью этой реализации Java вы можете легко генерировать изображения для своих графиков, 
что значительно облегчает понимание происходящего.