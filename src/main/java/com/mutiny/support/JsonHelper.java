package com.mutiny.support;

import java.io.IOException;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;

public class JsonHelper {

	protected final static Logger LOGGER = LoggerFactory.getLogger(JsonHelper.class);

	protected final static ObjectMapper OBJECT_MAPPER = new ObjectMapper()
			.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false)
			.configure(SerializationFeature.FAIL_ON_EMPTY_BEANS, false)
			.enable(SerializationFeature.WRITE_ENUMS_USING_TO_STRING)
			.enable(DeserializationFeature.READ_ENUMS_USING_TO_STRING)
			.disable(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS)
			.disable(DeserializationFeature.ADJUST_DATES_TO_CONTEXT_TIME_ZONE);

	public static <T> String toJson(T object) {
		if (object != null) {
			try {
				return OBJECT_MAPPER.writeValueAsString(object);
			} catch (JsonProcessingException e) {
				LOGGER.error("Unable to serialize object to JSON", e);
				throw new RuntimeException(e);
			}
		}
		return null;
	}

	public static <T> T fromJson(String json, TypeReference<T> valueType) {
		if (StringUtils.isNotBlank(json)) {
			try {
				return OBJECT_MAPPER.readValue(json, valueType);
			} catch (IOException e) {
				LOGGER.error("Unable to deserialize json to object", e);
				throw new RuntimeException(e);
			}
		}
		return null;
	}

	public static <T> T fromByteArray(byte[] bytes, Class<T> clazz) {
		try {
			return OBJECT_MAPPER.readValue(bytes, clazz);
		} catch (IOException e) {
			LOGGER.error("Unable to deserialize byte array to object", e);
			throw new RuntimeException(e);
		}
	}
}
