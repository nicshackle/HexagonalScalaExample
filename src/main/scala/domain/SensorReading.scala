package domain

import java.util.UUID

case class SensorReading(
                          UUID: UUID,
                          sensorName: String,
                          value: BigDecimal
                        )
