package scalpi

import org.specs2.mutable._
import scalpi.variable._
import scalpi.constraint.Constraint
import scalpi.constraint.ConstraintType._
import scalpi.targetfunction.Maximize

class ProblemDescriptionSpec extends Specification { 

  "A ProblemDescription" should { 
    "support createion" in {
      // max 1*x1 - 2*x2 + 3*x3
      // where:
      // x1 + x2 + x3 > 4
      // x1 - x2 + 3*x3 < 2
      // 0 < x1 < 10, x1 is integer
      // 0 < x2, x2 is real
      // x3 is binary
      val variables = List(
	IntegerVariable() boundedBy(0, 10),
	RealVariable() withLowerBound(0),
	BinaryVariable())
      
      val constraints = List(
	Constraint(List(1, 1, 1), GT, 4), 
	Constraint(List(1, -1, 3), LT, 2))
      
      val targetFunction = Maximize(List(1, -2, 3))

      val problem = ProblemDescription(targetFunction, constraints, variables)

      problem.constraints.size must be equalTo 2
      
    }
  }
}
