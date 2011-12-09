package scalpi.constraint
import org.specs2.mutable._
import scalpi.constraint.ConstraintType._

class ConstraintSpec extends Specification {
  "The Constraint class" should { 
    "have a constraint type that supports pattern matching" in { 
      val constraints = List(Constraint(List(1,2,3), Eq, 0), Constraint(List(1,2,3), LT, 0), Constraint(List(1,2,3), GT, 0))
      val expected = constraints map(_.constraintType);
      val supports = constraints.map{
	_ match { 
	  case Constraint(_, Eq, _) => Eq
	  case Constraint(_, LT, _) => LT
	  case Constraint(_, GT, _) => GT
	}
      }
      supports must be equalTo expected
    }
  }
}
