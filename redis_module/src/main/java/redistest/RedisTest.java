package redistest;

import redis.clients.jedis.Jedis;

public class RedisTest {
  Jedis jedis = null;

  public void connect() {
    jedis = new Jedis("localhost");
  }

  public void set(String key, String val){
    if(jedis != null){
      jedis.set(key, val);
    }
  }

  public String get(String key){
    if(jedis != null){
      return jedis.get(key);
    }
    return null;
  }
}
