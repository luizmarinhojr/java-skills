package com.luizmarinho.vehicles.Service;

import java.util.List;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.type.CollectionType;


public class ConvertJson implements IConvertJson {
    private final ObjectMapper mapper = new ObjectMapper();

    @Override
    public <T> T convertToObject(String json, Class<T> catchClass) {
        try {
            return mapper.readValue(json, catchClass);

        } catch (JsonProcessingException e) {
            System.out.println("A error happened to convert the Json for class");
            throw new RuntimeException();
        }
    }

    @Override
    public <T> List<T> convertToList(String json, Class<T> catchClass) {
        CollectionType list = mapper.getTypeFactory().constructCollectionType(List.class, catchClass);
        try {
            return mapper.readValue(json, list);
        } catch (JsonProcessingException e) {
            System.out.println("A error happened to convert the Json for class");
            throw new RuntimeException();
        }
    }

    



}
