package top.pengcheng789.util;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;

/**
 * JSON 工具类
 *
 * CreateDate:2017-07-24
 *
 * @author pen
 */
public final class JsonUtil {

    private static final ObjectMapper OBJECT_MAPPER = new ObjectMapper();

    /**
     * 将 POJO 转化为 JSON
     */
    public static <T> String toJson(T obj) throws JsonProcessingException {
        return OBJECT_MAPPER.writeValueAsString(obj);
    }

    /**
     * 将 JSON 转化为 POJO
     */
    public static <T> T fromJson(String json, Class<T> type) throws IOException {

        return OBJECT_MAPPER.readValue(json, type);
    }
}
