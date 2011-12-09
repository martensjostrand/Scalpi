package scalpi.targetfunction

abstract sealed class TargetFunction(coefficients: List[Double])

case class Maximize(coefficients: List[Double]) extends TargetFunction(coefficients)
case class Minimize(coefficients: List[Double]) extends TargetFunction(coefficients)
