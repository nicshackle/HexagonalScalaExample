package adaptors.primary

import java.util.UUID

import domain.{SensorReading, SensorReadingApplicationService, SensorReadingDomainService}

import scala.io.StdIn.readLine
import scala.util.control.Breaks.break

class CLI(sensorReadingApplicationService: SensorReadingApplicationService, sensorReadingDomainService: SensorReadingDomainService) {
  while (true) {
    print("What would you like to do? [create] sensor reading, [fetch] a reading or generate a [report] for a sensor (q to exit): ")
    val action: String = readLine()

    action match {
      case "create" => {
        print(s"What is the name of sensor? ")
        val sensorName: String = readLine()
        print(s"What is the value of the reading? ")
        val value: BigDecimal = BigDecimal(readLine())

        val newReadingUUID = UUID.randomUUID()

        val entry = sensorReadingApplicationService.create(SensorReading(newReadingUUID, sensorName, value))

        println(s"created entry: $entry")
      }
      case "fetch" => {
        print(s"What is the UUID of the sensor reading? ")
        val uuid: UUID = UUID.fromString(readLine())
        println(sensorReadingApplicationService.fetchReading(uuid))
      }
      case "report" => {
        println("What is the name of the sensor? ")
        val name: String = readLine()
        val res = sensorReadingDomainService.analyzeReadingsForSensor(name)
        println(s"${res.sensorName} ${res.readableWarning.getOrElse("is nominal")} (SD=${res.standardDeviation})")
      }
      case "q" => {
        println("Goodbye!")
        break
      }
      case _ => {
        println("Please try again")
      }
    }
  }
}