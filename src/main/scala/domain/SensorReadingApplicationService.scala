package domain

import java.util.UUID

/**
 * An application service:
 *  - interacts with stores (CRUD operations)
 *  - does not perform business decisions/knowledge
 */

class SensorReadingApplicationService(sensorReadingStore: SensorReadingStore) {
  def create(sensorReading: SensorReading): SensorReading ={
    sensorReadingStore.create(sensorReading)
  }

  def fetchReading(readingUUID: UUID): Option[SensorReading] ={
    sensorReadingStore.fetchReading(readingUUID)
  }

  def fetchAllReadingsForSensor(sensorName: String): List[SensorReading] = {
    sensorReadingStore.fetchAllReadingsForSensor(sensorName)
  }

  def delete(sensorReadingUUID: UUID): Long ={
    sensorReadingStore.delete(sensorReadingUUID)
  }
}
