## Example Hexagonal Scala Service
A sample hexagonal scala application, which uses IoT sensors as an example use case.

Only Redis and CLI adaptors have been implemented, but more can be added easily (the beauty of hexagonal!)

## Reading material
- https://herbertograca.com/2017/11/16/explicit-architecture-01-ddd-hexagonal-onion-clean-cqrs-how-i-put-it-all-together/comment-page-1/

- https://www.youtube.com/watch?v=K1EJBmwg9EQ

1. https://www.youtube.com/watch?v=rQnTtQZGpg8
1. https://www.youtube.com/watch?v=xUYDkiPdfWs
1. https://www.youtube.com/watch?v=QyBXz9SpPqE
1. https://github.com/tensor-programming/hex-microservice/tree/part-3


## Run
#### Start a local Redis server

```bash
redis-server
```

#### Start the application with your choice of facade and store
```bash
STORE=[redis|etc] FACADE=[cli|etc] sbt run
```

#### Example Output
```bash
What would you like to do? [create] sensor reading, [fetch] a reading or generate a [report] for a sensor (q to exit): create
What is the name of sensor? temp
What is the value of the reading? 22
created entry: SensorReading(aea8ca63-114d-42f9-91f1-2cfe376ec937,temp,22)
What would you like to do? [create] sensor reading, [fetch] a reading or generate a [report] for a sensor (q to exit): create
What is the name of sensor? temp
What is the value of the reading? 23
created entry: SensorReading(a637d3c3-b886-4635-b716-fbc3a02b3f52,temp,23)
What would you like to do? [create] sensor reading, [fetch] a reading or generate a [report] for a sensor (q to exit): create
What is the name of sensor? temp
What is the value of the reading? 50
created entry: SensorReading(64d53432-c751-495a-96ef-06d6d02d9dfa,temp,50)
What would you like to do? [create] sensor reading, [fetch] a reading or generate a [report] for a sensor (q to exit): fetch
What is the UUID of the sensor reading? 64d53432-c751-495a-96ef-06d6d02d9dfa
Some(SensorReading(64d53432-c751-495a-96ef-06d6d02d9dfa,temp,50))
What would you like to do? [create] sensor reading, [fetch] a reading or generate a [report] for a sensor (q to exit): report
What is the name of the sensor? 
temp
temp sensor may be faulty! (SD=12.970050972229146)

```