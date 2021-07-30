import adaptors.primary.CLI
import adaptors.secondary.persistence.redis.RedisSensorReadingAdaptor
import domain.{SensorReadingApplicationService, SensorReadingDomainService}

/**
 * Add more adaptors to the below `match`'s as needed
 */

object SensorApp extends App {
  val storeChoice = sys.env("STORE")
  def sensorReadingService = storeChoice match {
    case "redis" => new SensorReadingApplicationService(RedisSensorReadingAdaptor)
    case _ => new SensorReadingApplicationService(RedisSensorReadingAdaptor)
  }

  def sensorReadingDomainService = new SensorReadingDomainService(sensorReadingService)

  val facadeChoice = sys.env("FACADE")
  facadeChoice match {
    case "cli" => new CLI(sensorReadingService, sensorReadingDomainService)
    case _ => new CLI(sensorReadingService, sensorReadingDomainService)
  }
}

