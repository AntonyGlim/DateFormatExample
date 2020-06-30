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
public class ObjectWithTime1 implements Serializable {
    private static final long serialVersionUID = -8836368815257459640L;
    @JsonProperty("id_object")
    private Long idObject;

    @JsonProperty("object_date")
//    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd", timezone="UTC")
    @JsonDeserialize(using = CustomJsonDateDeserializer.class)
    private Date objectDate;
}