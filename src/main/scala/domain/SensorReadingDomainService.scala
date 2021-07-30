package domain

import common.mathUtils._

/**
 * A domain service:
 *  - does not interact with stores/do CRUD operations
 *  - performs business decisions/contains domain knowledge
 */

class SensorReadingDomainService(sensorReadingApplicationService: SensorReadingApplicationService) {
  def analyzeReadingsForSensor(sensorName: String): SensorReport = {
    val values: Seq[BigDecimal] = sensorReadingApplicationService.fetchAllReadingsForSensor(sensorName).map(_.value)

    val sd = StandardDeviation(values)
    val mean = Mean(values)
    SensorReport(sensorName, sd, mean)
  }
}

case class SensorReport(sensorName: String,standardDeviation: Double, mean: Double) {
  // below is some made-up domain knowledge
  var sensorStable: Boolean = (standardDeviation < 1.5)
  var readableWarning: Option[String] = if(!sensorStable) Some(s"sensor may be faulty!") else None
}