package scalpi

import scalpi.variable.VariableValue

case class ProblemSolution(targetValue: Double, variableValues: List[VariableValue[_]])
