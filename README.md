# multi-datasource
springboot搭建的多数据源demo实现读写分离

主数据库：master用来实现写功能以及重要的部分读取
从数据库：slave1和slave2用来实现数据读取功能，并且读取的两个数据库交替切换数据源

本DEMO主要使用应用程序来实现数据库的读写分离，优点是易于实现，操作简单，缺点是不够灵活，新增数据源需要改代码
