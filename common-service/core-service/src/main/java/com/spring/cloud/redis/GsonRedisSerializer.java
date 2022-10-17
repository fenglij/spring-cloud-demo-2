package com.spring.cloud.redis;

import com.google.gson.Gson;
import org.springframework.data.redis.serializer.RedisSerializer;
import org.springframework.data.redis.serializer.SerializationException;

import java.nio.charset.Charset;

/**
 * 覆盖redis 序列化方式
 * 定义通用序列化类
 * @param <T>
 */
public class GsonRedisSerializer<T> implements RedisSerializer<T> {

    public static final Charset DEFAULT_CHARSET = Charset.forName("UTF-8");

    private Class<T> clazz;

    public GsonRedisSerializer(Class<T> clazz) {
        super();
        this.clazz = clazz;
    }

    @Override
    public byte[] serialize(T t) throws SerializationException {
        if (null == t) {
            return new byte[0];
        }
        Gson gson = new Gson();
        String str = gson.toJson(t);
        byte[] bytes = str.getBytes(DEFAULT_CHARSET);
        return bytes;
        // return new Gson().toJSONString(t, SerializerFeature.WriteClassName).getBytes(DEFAULT_CHARSET);
    }

    @Override
    public T deserialize(byte[] bytes) throws SerializationException {
        if (null == bytes || bytes.length <= 0) {
            return null;
        }
        String str = new String(bytes, DEFAULT_CHARSET);
        Gson gson = new Gson();
        return gson.fromJson(str, clazz);
        // return (T) JSON.parseObject(str, clazz);
    }
}
