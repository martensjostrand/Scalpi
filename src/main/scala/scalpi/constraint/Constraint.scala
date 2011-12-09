package scalpi.constraint

object ConstraintType extends Enumeration { 
  type ConstraintType = Value
  val Eq, LT, GT = Value
}
import ConstraintType._
case class Constraint(coefficients: List[Double], constraintType: ConstraintType, rhs:Double)

