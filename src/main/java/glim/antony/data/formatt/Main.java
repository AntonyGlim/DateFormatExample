package glim.antony.data.formatt;

import glim.antony.data.formatt.model.ObjectWithTime1;
import glim.antony.data.formatt.model.ObjectWithTime2;
import glim.antony.data.formatt.utils.JsonMapper;

/*
 *
 * @author a.yatsenko
 * Created at 29.06.2020
 */
public class Main {

    private static JsonMapper mapper = new JsonMapper();

    public static void main(String[] args) {

        String jsonObjectWithTime1 = "{\"id_object\":1,\"object_date\":\"2020-06-29\"}";
        ObjectWithTime1 objectWithTime1 = mapper.deserializeObjectFromJson(jsonObjectWithTime1, ObjectWithTime1.class);

        ObjectWithTime2 objectWithTime2 = new ObjectWithTime2(objectWithTime1);
        System.out.println(mapper.serializeObjectToJson(objectWithTime2));
    }
}
