package gray.c.one.util;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

import java.io.IOException;
import java.util.Properties;

/**
 * Created by jykang on 2016. 7. 14..
 */
@Slf4j
@Configuration
public class RestClient {

    private static final ObjectMapper OBJECT_MAPPER = new ObjectMapper();

    private static String host;

    private static  String clientId;

    private static String clientSecret;

    static {
        try {
            Properties properties = PropertiesLoader.fromResource("naver-api.properties");
            host = properties.getProperty("naver.api.host");
            clientId = properties.getProperty("naver.api.client.id");
            clientSecret = properties.getProperty("naver.api.client.secret");

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

//    private static boolean initialized = false;

//    public static synchronized RestClient init() {
//        if (!initialized) {
//            Unirest.setObjectMapper(new com.mashape.unirest.http.ObjectMapper() {
//                private ObjectMapper OBJECT_MAPPER = new ObjectMapper();
//
//                public <T> T readValue(String value, Class<T> valueType) {
//                    try {
//                        return OBJECT_MAPPER.readValue(value, valueType);
//                    } catch (IOException e) {
//                        throw new RuntimeException(e);
//                    }
//                }
//
//                public String writeValue(Object value) {
//                    try {
//                        String result = OBJECT_MAPPER.writeValueAsString(value);
//                        return result;
//                    } catch (JsonProcessingException e) {
//                        throw new RuntimeException(e);
//                    }
//                }
//            });
//
//            initialized = true;
//        }
//
//        return new RestClient();
//    }

    private <T> T asObject(HttpResponse<String> response, Class<T> type) {
        try {
            return OBJECT_MAPPER.readValue(response.getBody(), type);
        } catch (IOException e) {
            e.printStackTrace();
            log.error("Json Mapping error");
        }
        return null;
    }


    public HttpResponse<String> searchByBlog(String keyword) {
        try {
            return Unirest.get(host+"/blog.xml")
                    .header("X-Naver-Client-Id", clientId)
                    .header("X-Naver-Client-Secret", clientSecret)
                    .header("Content-Type", "application/json;charset=UTF-8")
                    .queryString("query", keyword)
                    .asString();

        } catch (UnirestException e) {
            e.printStackTrace();
        }
        return null;
    }
}




