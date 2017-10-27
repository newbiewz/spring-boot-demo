package com.newbiewz.learn.util.jackson;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.ser.std.StdSerializer;

import java.io.IOException;

public class DistanceSerializer extends StdSerializer<Gender> {
    public DistanceSerializer() {
        super(Gender.class);
    }

    public DistanceSerializer(Class t) {
        super(t);
    }

    @Override
    public void serialize(Gender gender, JsonGenerator generator, SerializerProvider provider) throws IOException {
        generator.writeStartObject();
        generator.writeFieldName("value");
        generator.writeString(gender.getValue());
        generator.writeFieldName("code");
        generator.writeNumber(gender.getCode());
        generator.writeEndObject();
    }
}
