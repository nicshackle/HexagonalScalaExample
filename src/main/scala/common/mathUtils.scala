package common

object mathUtils {

  def Mean[A](a: Seq[A])(implicit num: Numeric[A]):Double = {
    num.toDouble(a.sum) / a.size
  }

  def StandardDeviation[A](a: Seq[A])(implicit num: Numeric[A]):Double = {
    def variance(a: Seq[A]): Double = {
      val avg = Mean(a)
      a.map(num.toDouble).map(x => math.pow((x - avg),2)).sum / a.size
    }
    math.sqrt(variance(a))
  }

}
