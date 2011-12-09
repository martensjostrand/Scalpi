package scalpi

import scalpi.variable.Variable
import scalpi.constraint.Constraint
import scalpi.target.TargetFunction

case class ProblemDescription(targetFunction: TargetFunction, constraints: List[Constraint], variables: List[Variable[_]])
