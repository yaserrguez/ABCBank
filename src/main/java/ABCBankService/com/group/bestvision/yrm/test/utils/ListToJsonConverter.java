/*
 * Copyright (c) 2022. DATYS, Tecnología y Servicios.
 * SRNT Sistema de Registro Nacional de Tramites
 * Todos los derechos reservados.
 * www.datys.co.cu
 *
 * LastUpdate: 11/5/22 11:35.
 *
 */

package ABCBankService.com.group.bestvision.yrm.test.utils;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import javax.persistence.AttributeConverter;
import java.util.List;

public class ListToJsonConverter implements AttributeConverter<List<String>, String> {

    static final ObjectMapper mapper = new ObjectMapper();

    @Override
    public String convertToDatabaseColumn(List<String> list) {
        if (list == null)
            return null;
        try {
            return mapper.writeValueAsString(list);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
    }


    @Override
    public List<String> convertToEntityAttribute(String dbJson) {
        if (dbJson == null)
            return null;
        try {
            return mapper.readValue(dbJson, new TypeReference<List<String>>() {
            });
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
    }
}

