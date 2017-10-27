package com.newbiewz.learn.util.jackson;

import com.fasterxml.jackson.annotation.*;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import lombok.Data;

import java.util.Date;

@Data
public class Person {
    private String name;
    private Gender gender;
    @JsonProperty("gmt")
    @JsonFormat(pattern="yyyy-MM-dd")
    private Date dirthday;
}

@JsonSerialize(using = DistanceSerializer.class)
@JsonDeserialize(using = GenderDeserializer.class)
enum Gender {
    MAN(1, "男"),
    WOMAN(2, "女");

    private int code;
    private String value;

    Gender(int code, String value) {
        this.code = code;
        this.value = value;
    }

    @JsonValue
    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public static Gender of(int code) {
        switch (code) {
            case 1:
                return MAN;
            case 2:
                return WOMAN;
                default:
                    return null;
        }
    }
}
