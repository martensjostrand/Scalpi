The Scala Linear Programming Interface
==============
Defines types and traits to solve linear programming problems.


Build
-------
The project is built using sbt.


Using the Scalpi 
-------
The Scala linear programming interface is used to model linear programming problems with scala. 
The project contains types for problem descriptions and solutions, variables and constraints. 
There is also a trait for any implementations.

To model the problem:

    max x1 + 2*x2 - 3 x3
    where:
    x1 + 2.3 * x2 + 0.5 * x3 < 1.0
    2 * x1 - x2 - 2 * x3 > 2.0
    0 < x1 , x1 is real
    -4 < x2 < 7, x2 is an integer
    x3 is binary
    
one can use the following Scala code

    // Import are omitted for clearity.)
    val variables = List(RealVariable() withLowerBound(0), IntegerVariable() boundedBy(-4, 7), BinaryVariable())
    val constraints = List(
      Constraint(List(1, 2.3, 0.5), LT, 1.0),
      Constraint(List(2, -1, -2), GT, 2.0)
    )
    val targetFunction = Maximize(List(1, 2, -3))
    val problem = ProblemDescription(targetFunction, constraints, variables)
    
    val solver: ProblemSolver = // Obtain an implementation
    
    val solution = solver.solve(problem)
    println("maximum is" + solution.targetValue)
    println("x1* = " + solution.variableValues(0).getValue)
    println("x2* = " + solution.variableValues(1).getValue)
    println("x3* = " + solution.variableValues(2).getValue)
    
    
  