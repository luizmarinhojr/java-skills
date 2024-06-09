package com.luizmarinho.vehicles.Service;

import java.util.List;

public interface IConvertJson {
    <T> T convertToObject (String json, Class<T> catchClass);

    <T> List<T> convertToList (String json, Class<T> catchClass);
}
