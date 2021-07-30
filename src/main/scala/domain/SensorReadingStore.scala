package domain

import java.util.UUID

trait SensorReadingStore {
  def create(reading: SensorReading): SensorReading

  def fetchReading(readingUUID: UUID): Option[SensorReading]

  def fetchAllReadingsForSensor(sensorName: String): List[SensorReading]

  def delete(sensorReadingUUID: UUID): Long
}
