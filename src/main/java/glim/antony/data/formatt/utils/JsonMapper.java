package glim.antony.data.formatt.utils;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;

import javax.annotation.PostConstruct;
import java.io.IOException;
import java.io.StringReader;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Locale;
import java.util.TimeZone;

/*
 *
 * @author a.yatsenko
 * Created at 18.06.2020
 */
@Slf4j
public class JsonMapper {
    private static ObjectMapper mapper;

    static {
        mapper = new ObjectMapper();
        mapper.setTimeZone(TimeZone.getTimeZone("UTC"));
        mapper.setLocale(Locale.ENGLISH);
    }

    public String serializeObjectToJson(Object object) {
        String json = null;
        try {
            json = mapper.writeValueAsString(object);
        } catch (JsonProcessingException e) {
            log.warn("[60011] serialization error. Error cause: {}, message: {}", e.getCause().toString(), e.getMessage());
        }
        return json;
    }

    public <T> T deserializeObjectFromJson(String json, Class<T> clazz) {
        T object = null;
        try (StringReader reader = new StringReader(json)) {
            object = mapper.readValue(reader, clazz);
        } catch (IOException e) {
            log.warn("[60012] deserialization error. Error cause: {}, message: {}", e.getCause(), e.getMessage());
            e.printStackTrace();
        }
        return object;
    }
}
