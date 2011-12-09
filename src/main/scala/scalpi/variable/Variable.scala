package scalpi.variable

  trait UpperBound[T] {
      def getUpperBound: Option[T]
  }

  trait LowerBound[T] { 
    def getLowerBound: Option[T]
  }

  abstract sealed class Variable[T]

  abstract sealed class BoundedVariable[T] extends Variable[T] with UpperBound[T] with LowerBound[T]{ 
    var lowerBound: Option[T] = None
    var upperBound: Option[T] = None
    
    def withLowerBound(lower: T) = { 
      lowerBound = Some(lower)
      this
    } 

    def andUpperBound(upper: T) = { 
      upperBound = Some(upper)
      this
    }

    def boundedBy(lower: T, upper: T) ={ 
      lowerBound = Some(lower)
      upperBound = Some(upper)
      this
    }

    override def getLowerBound: Option[T] = lowerBound
    override def getUpperBound: Option[T] = upperBound
  }

  case class BinaryVariable() extends Variable[Boolean]
  case class IntegerVariable() extends BoundedVariable[Int] 
  case class RealVariable() extends BoundedVariable[Double]
    




