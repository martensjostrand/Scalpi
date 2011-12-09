package scalpi

import scalpi.variable._
import scalpi.constraint.Constraint
import scalpi.targetfunction.TargetFunction

case class ProblemDescription(targetFunction: TargetFunction, constraints: List[Constraint], variables: List[Variable[_]]) {
  def isMixedInteger() = { 
    variables match {
      case Nil => false
      case _ => variables.exists(
	_ match {
	  case BinaryVariable() => true
	  case IntegerVariable() => true
	  case _ => false
	  }
      )
    }
  }
}
