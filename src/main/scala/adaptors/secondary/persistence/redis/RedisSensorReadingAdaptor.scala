package adaptors.secondary.persistence.redis

import java.util.UUID

import domain.{SensorReading, SensorReadingStore}

object RedisSensorReadingAdaptor extends SensorReadingStore {
  override def create(reading: SensorReading): SensorReading = {
    r.hmset(
      reading.UUID,
      Map(
        "readingUUID" -> reading.UUID,
        "sensorName" -> reading.sensorName,
        "value" -> reading.value
      )
    )
    reading
  }

  override def fetchReading(readingUUID: UUID): Option[SensorReading] = {
    val data = r.hmget[String, String](readingUUID, "readingUUID", "sensorName", "value")
    val reading = SensorReading(
      readingUUID,
      data.get("sensorName"),
      BigDecimal(data.get("value"))
    )
    Some(reading)
  }

  override def delete(sensorReadingUUID: UUID): Long = r.del(sensorReadingUUID).getOrElse(0)

  // redis isn't designed for getting all keys for a given value; this is a hacky way to do that
  override def fetchAllReadingsForSensor(sensorName: String): List[SensorReading] = {
    val allKeys = r.keys("*")
    val allReadings = allKeys.get.map {
      case Some(key: String) =>
        val data = r.hmget[String, String](key, "readingUUID", "sensorName", "value")
        SensorReading(
          UUID.fromString(key),
          data.get("sensorName"),
          BigDecimal(data.get("value"))
        )
    }
    allReadings.filter(_.sensorName == sensorName)
  }
}
