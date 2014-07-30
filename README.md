LotterySystem
=============

The system is the simple lottery server.

- Core, data access and presentation layers should be clearly separated.
- System should be hosted in Apache/Tomcat. Using Spring is expected.
- Data access layer should be designed so it is easy to replace actual data storage; for the test task
 data can be stored in HSQL database. All entities mentioned below are persistent.
- Main entities to deal with are draw configuration, player and draw.
- Draw configurations are persistent entities. No admin or database needed, just one or couple of
 “stored” configurations should be pre-defined. Configuration is the table of the following structure:


| Number of Winners | Prize   |   
|-------------|---------------|  
| 1 | Euro, 1000| 
| 2 | Euro, 50 | 
| 20| Euro, 20 |


- Of course values in the table are just examples; particular prize plan is actually the draw
configuration.

- We don’t do any permissions, sessions or role restrictions in scope of the test task – all operations
  can be performed by “anonymous” user. Basic operations core supports are:
- Create draw for given (predefined) configuration
- Player X purchases Y tickets (draw is performed for tickets, not for players, i.e. if I buy two
  tickets – I have two chances). Ticket price is not important now.
- Run (calculate) the draw. In the beginning of calculation draw becomes closed for purchases,
  in the end of calculation draw is completely closed. When calculating the draw, participating
  tickets are randomly chosen to fill in the prizes.
- Get the draw results (containing participating players, tickets, and winners structure). Draw
  results is the part of the draw information.

- For accessing core operations above, solution should provide very simple REST interface
  (presentation layer). 
- REST framework and payload format is up to you.
- Write integration tests which will check created REST services by sending HTTP requests and
  validating return result (data structure, response code, etc.). Use library for making REST calls
  provided by JAX-RS implementation you choose, and any test framework you like (JUnit, TestNG,
  etc.)
- Solution should not be too dependent from specific currency
- Solution should be built in modular way. For example, it should be easy to replace component
  responsible for random number generation.
- Comment about current and future solution scalability.
- Would be good to have JUnit unit tests for appropriate classes/methods. Since test data is pre-
  configured, probably no mocking is needed and unit tests can refer that pre-configured data.
- Javadoc or any other documentation is not needed. Solution/code/unit tests should be self-
  descriptive.


--- Comments

- Solution is not dependent on currency
- Random number generation component is easily replaceable by adding a new bean and implementing the existing interface (RandomService)
- Scalability. New rest resources could be added as separate classes to restLayer package. For each resource it is recommendable to test and generate a valid user scenario. Number of lottery tickets and win tickets could be changed. Any currency you want could be added a currencyName variable and appropriatelly stored in the DB. Db could be changed by modifying the driver in the configuration file (please note Hibernate - compatible driver)


