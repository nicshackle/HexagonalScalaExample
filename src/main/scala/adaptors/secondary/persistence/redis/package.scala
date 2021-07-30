package adaptors.secondary.persistence

import com.redis.RedisClient

package object redis {
  val r = new RedisClient("localhost", 6379)
}
