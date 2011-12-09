package scalpi

import scalpi.variable._

object DefaultProblemSolver extends ProblemSolver { 
  override def solve(description: ProblemDescription) = { 
    val variableValues = description.variables.map{
      _ match { 
	case BinaryVariable() => BinaryVariableValue(false)
	case IntegerVariable() => IntegerVariableValue(0)
	case RealVariable() => RealVariableValue(0)
      }
    }
    ProblemSolution(0, variableValues)
  } 
}
