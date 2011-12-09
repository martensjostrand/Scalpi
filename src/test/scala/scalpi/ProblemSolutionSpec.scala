package scalpi

import org.specs2.mutable._
import scalpi.variable.{BinaryVariableValue, RealVariableValue}

class ProblemSolutionSpec extends Specification { 
  "A ProblemSolutionSpec" should { 
    "be easy to crate" in { 
      val variableValues = List(BinaryVariableValue(true), RealVariableValue(2))
      val solution = ProblemSolution(1.0, variableValues)

      solution.targetValue must be equalTo 1.0
      solution.variableValues.map{ _.getValue} must be equalTo(List(true, 2))
    }
  }

}
