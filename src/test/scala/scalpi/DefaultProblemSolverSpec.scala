package scalpi

import org.specs2.mutable._
import scalpi.variable._
import scalpi.targetfunction.Maximize
import scalpi.constraint.Constraint
import scalpi.constraint.ConstraintType.GT

class DefaultProblemSolverSpec extends Specification { 
  "The DefaultProblemSolverSpec" should { 
    "return default values and ignore target function and constraints" in { 
      val targetFunction = Maximize(List(0, 0))
      val constraints = List(Constraint(List(0), GT, 0))
      val variables = List(BinaryVariable(), IntegerVariable(), RealVariable());

      val description  = ProblemDescription(targetFunction, Nil, variables)

      val solution = DefaultProblemSolver.solve(description)
      solution.targetValue must be equalTo(0) 
      solution.variableValues.map{_.getValue} must be equalTo List(false, 0, 0.0)
    }
  }

}
