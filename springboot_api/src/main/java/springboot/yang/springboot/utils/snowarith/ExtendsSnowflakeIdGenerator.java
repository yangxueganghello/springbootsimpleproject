package springboot.yang.springboot.utils.snowarith;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.Set;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import com.google.common.collect.Sets;

/**
 * Created by yangyi on 2018/3/15. Id = 预留(1位)|时间戳差值(41位)|业务线(5位)|机器码(10位)|seq(7位)
 *
 * @author swearwang
 * @version $Id: $Id
 */
@Component
public class ExtendsSnowflakeIdGenerator implements IdGeneratorService {

  private static long workerId;

  private static final long versionId = 0;

  private static final long idepoch = 1521101702483L;

  @Value("#{'${workerId}'}")
  private long businessId = 0;

  private static final long versionIdBits = 1L;

  private static final long businessIdBits = 5L;

  private static final long workerIdBits = 10L;

  private static final long maxWorkerId = -1L ^ (-1L << workerIdBits);

  private static final long sequenceBits = 7L;

  private static final long workerIdShift = sequenceBits;

  private static final long businessIdShift = sequenceBits + workerIdShift;

  // private static final long datacenterIdShift = sequenceBits +
  // workerIdBits;
  // 时间戳(41位)
  private static final long timestampLeftShift = sequenceBits + workerIdBits + businessIdBits; // +

  // 预留位（1位）
  private static final long versionIdLeftShift =
      sequenceBits + workerIdBits + businessIdBits + timestampLeftShift;

  // datacenterIdBits

  // 序列号(0~127位)
  private static final long sequenceMask = -1L ^ (-1L << sequenceBits);

  // 业务线(0~31位)
  private static final long businessMask = -1L ^ (-1L << businessIdBits);

  private static long lastTimestamp = -1L;

  private static long sequence;

  static {
    if (workerId <= 0) workerId = initWorkId();
  }

  /**
   * 取id后10位作为workId
   *
   * @return
   */
  private static long initWorkId() {
    InetAddress address;
    Long workId = 0L;
    try {
      address = InetAddress.getLocalHost();
    } catch (final UnknownHostException e) {
      throw new IllegalStateException("can not get localhost ");
    }
    byte[] ipAddressByteArray = address.getAddress();

    // for(byte b:ipAddressByteArray) {
    // workId+=b<0?b+256:b;
    // }
    workId =
        (long)
            (((ipAddressByteArray[ipAddressByteArray.length - 2] & 0B11) << Byte.SIZE)
                + (ipAddressByteArray[ipAddressByteArray.length - 1] & 0xFF));

    return workId;
  }

  /**
   * 业务号不可大于最大业务线(0~31) 若时间差相等,且下一个序列号等于最大序列号,则自循环一次。以免发生序列号重复问题, 同时修复时钟回调问题
   *
   * @return
   */
  private synchronized long _nextId() {
    if (businessId <= 0) {
      throw new IllegalStateException("business id is small than zero ");
    }

    if (businessId > businessMask) {
      throw new IllegalStateException("business id is large than max business id ");
    }

    long timestamp = getTime();
    if (timestamp < lastTimestamp) {
      throw new IllegalStateException("Clock moved backwards.");
    }
    if (lastTimestamp == timestamp) {
      sequence = (sequence + 1) & sequenceMask;
      if (sequence == 0) {
        timestamp = tilNextMillis(lastTimestamp);
      }
    } else {
      sequence = 0;
    }
    lastTimestamp = timestamp;
    long id =
        versionId << versionIdLeftShift
            | ((timestamp - idepoch) << timestampLeftShift) //
            | (businessId << businessIdShift)
            | (workerId << workerIdShift) //
            | sequence;
    return id;
  }

  private static long tilNextMillis(long lastTimestamp) {
    long timestamp = getTime();
    while (timestamp <= lastTimestamp) {
      timestamp = getTime();
    }
    return timestamp;
  }

  /**
   * getTime.
   *
   * @return a long.
   */
  public static long getTime() {
    return System.currentTimeMillis();
  }

  /** {@inheritDoc} */
  @Override
  public String toString() {
    final StringBuilder sb = new StringBuilder("IdWorker{");
    sb.append("workerId=").append(workerId);

    sb.append(", idepoch=").append(idepoch);
    sb.append(", lastTimestamp=").append(lastTimestamp);
    sb.append(", sequence=").append(sequence);
    sb.append(", businessId=").append(businessId);
    sb.append(", versionId=").append(versionId);
    sb.append('}');
    return sb.toString();
  }

  /**
   * nextId.
   *
   * @return a long.
   */
  public long nextId() {
    return _nextId();
  }

  /** {@inheritDoc} */
  @Override
  public String state() {
    return this.toString();
  }

  /**
   * main.
   *
   * @param args an array of {@link String} objects.
   */
  public static void main(String[] args) {
    ExtendsSnowflakeIdGenerator idGenerator = new ExtendsSnowflakeIdGenerator();
    Set<Long> idSet = Sets.newHashSet();
    for (int i = 0; i < 10000; i++) {
      long nextId = idGenerator.nextId();
      idSet.add(nextId);
    }
    assert idSet.size() == 10000;
    for (Long nextId : idSet) {
      System.out.println(nextId);
    }
    System.out.println("finish");
  }
}
