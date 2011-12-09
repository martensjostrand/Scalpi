package scalpi.variable

trait  VariableValue[T] { 
  def getValue: T
}

case class BinaryVariableValue(value: Boolean) extends VariableValue[Boolean] { 
  override def getValue = value
}

case class RealVariableValue(value: Double) extends VariableValue[Double] { 
  override def getValue = value
}

case class IntegerVariableValue(value: Int) extends VariableValue[Int] { 
  override def getValue = value
}
