package scalpi.variable
import org.specs2.mutable._

class Variable extends Specification {
  "A Variable" should { 
    "support pattern matching" in {
      val vars = List(
	BinaryVariable(),
	RealVariable(), 
	IntegerVariable())
      val varTypes = vars map{ _ match {
	case IntegerVariable()=> "i"
	case RealVariable() => "r"
	case BinaryVariable() => "b"
	case _ => throw new Exception("No!")}}

      varTypes must be equalTo(List("b", "r", "i"))
    }
    
    "be boundable" in { 
      val lB = Some(2.0)
      val uB = Some(5.0)

      val doubleBounded = RealVariable() withLowerBound(lB.get) andUpperBound(uB.get)
      doubleBounded.getLowerBound must be equalTo lB 
      doubleBounded.getUpperBound must be equalTo uB

      val semiBounded = RealVariable() withLowerBound lB.get
      semiBounded.getLowerBound must be equalTo lB
      semiBounded.getUpperBound must be equalTo None
    }

  }

}
