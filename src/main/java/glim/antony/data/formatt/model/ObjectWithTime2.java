package glim.antony.data.formatt.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import glim.antony.data.formatt.utils.CustomJsonDateDeserializer;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ObjectWithTime2 implements Serializable {
    private static final long serialVersionUID = -2568815257459648L;
    @JsonProperty("id_object_2")
    private Long idObject;

    @JsonProperty("object_date_2")
//    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd", timezone="UTC")
    @JsonDeserialize(using = CustomJsonDateDeserializer.class)
    private Date objectDate;

    public ObjectWithTime2(ObjectWithTime1 objectWithTime1) {
        this.idObject = objectWithTime1.getIdObject();
        this.objectDate = objectWithTime1.getObjectDate();
    }
}