package com.example.esapi.extras.serializer;

import com.example.esapi.entity.Section;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

import java.io.IOException;

public class ProductSectionSerializer extends JsonSerializer<Section> {
    @Override
    public void serialize(Section section, JsonGenerator gen, SerializerProvider serializerProvider) throws IOException {
        gen.writeStartObject();
        gen.writeNumberField("id", section.getId());
        gen.writeStringField("name", section.getName());
        gen.writeEndObject();
    }
}
