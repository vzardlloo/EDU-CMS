package com.vzard.educms.util;





public class JSON {

    /**

    public static ObjectMapper getMapper() {
        return new ObjectMapper()
                .configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false)
                .configure(JsonParser.Feature.IGNORE_UNDEFINED, true)
                .setSerializationInclusion(JsonInclude.Include.NON_NULL)
                .configure(JsonGenerator.Feature.IGNORE_UNKNOWN, true);
    }

    public static <T> T deserialize(String json, JavaType type) {
        try {
            return getMapper().readValue(json, type);
        } catch (IOException e) {
            throw new RuntimeException(StringUtil.valueOrDefault(e.getMessage(), "JSON deserialize fail."), e);
        }
    }

    public static <T> T deserialize(String json, Type type) {
        return deserialize(json, getMapper().constructType(type));
    }

    public static <T> T deserialize(String json, Class<? extends T> type) {
        return deserialize(json, TypeFactory.defaultInstance().constructType(type));
    }

    public static <T> T deserialize(String json, TypeReference<T> type){
        return deserialize(json, TypeFactory.defaultInstance().constructType(type));
    }

    public static <T> T deserialize(Reader jsonReader, JavaType type) {
        try {
            return getMapper().readValue(jsonReader, type);
        } catch (IOException e) {
            throw new RuntimeException(StringUtil.valueOrDefault(e.getMessage(), "JSON deserialize fail."), e);
        }
    }

    public static <T> T deserialize(Reader jsonReader, Type type) {
        return deserialize(jsonReader, getMapper().constructType(type));
    }

    public static <T> T deserialize(Reader jsonReader, Class<? extends T> type) {
        return deserialize(jsonReader, TypeFactory.defaultInstance().constructType(type));
    }

    public static <T> T deserialize(Reader jsonReader, TypeReference<T> type){
        return deserialize(jsonReader, TypeFactory.defaultInstance().constructType(type));
    }

    public static JsonNode deserialize(String json) {
        try {
            return getMapper().readTree(json);
        } catch (IOException e) {
            throw new RuntimeException(StringUtil.valueOrDefault(e.getMessage(), "JSON deserialize fail."), e);
        }
    }

    public static JsonNode deserialize(Reader jsonReader) {
        try {
            return getMapper().readTree(jsonReader);
        } catch (IOException e) {
            throw new RuntimeException(StringUtil.valueOrDefault(e.getMessage(), "JSON deserialize fail."), e);
        }
    }

    public static String serialize(Object object){
        try {
            return getMapper().writeValueAsString(object);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(StringUtil.valueOrDefault(e.getMessage(), "JSON serialize fail."), e);
        }
    }



    **/

}
