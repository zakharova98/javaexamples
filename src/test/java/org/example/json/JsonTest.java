package org.example.json;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.jayway.jsonpath.JsonPath;
import com.networknt.schema.JsonSchema;
import com.networknt.schema.JsonSchemaFactory;
import com.networknt.schema.SpecVersion;
import com.networknt.schema.ValidationMessage;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class JsonTest {

    String personJsonFilePath = "src/test/resources/json/person.json";

    @Test
    public void jsonSchemeTest() throws Exception {
        ObjectMapper mapper = new ObjectMapper();

        FileInputStream jsonExample = new FileInputStream(new File("src/test/resources/json/product_invalid.json"));
        FileInputStream schemaExample = new FileInputStream(new File("src/test/resources/json/schema.json"));

        JsonSchemaFactory factory = JsonSchemaFactory.getInstance(SpecVersion.VersionFlag.V4);
        JsonSchema jsonSchema = factory.getSchema(schemaExample);
        JsonNode jsonNode = mapper.readTree(jsonExample);
        Set<ValidationMessage> errors = jsonSchema.validate(jsonNode);

        Assertions.assertFalse(errors.isEmpty());
        System.out.println(errors);
    }

    @Test
    public void orgJsonSimpleCreateTest() throws Exception {
        JSONObject personObj = new JSONObject();

        personObj.put("firstName", "Ivan");
        personObj.put("lastName", "Ivanov");
        personObj.put("children", null);
        personObj.put("married", true);
        personObj.put("age", 27);

        JSONObject address = new JSONObject();
        address.put("streetAddress", "First street, building 1, flat 1");
        address.put("city", "Nizhny Novgorod");
        personObj.put("address", address);

        JSONArray phoneNumbers = new JSONArray();
        phoneNumbers.add("88005553535");
        phoneNumbers.add("89205476254");
        personObj.put("phoneNumbers", phoneNumbers);

        FileWriter file = new FileWriter("person_created_from_code.json");
        file.write(personObj.toJSONString());
        file.flush();
        file.close();

        System.out.print(personObj.toJSONString());
    }


    @Test
    public void orgJsonSimpleParseTest() throws Exception {
        JSONParser parser = new JSONParser();
        Reader reader = new FileReader(personJsonFilePath);

        Object personObj = parser.parse(reader);
        JSONObject personObject = (JSONObject) personObj;

        Assertions.assertEquals("Ivan", personObject.get("firstName").toString());
        Assertions.assertEquals("Ivanov", personObject.get("lastName").toString());
        Assertions.assertNull(personObject.get("children"));
        Assertions.assertTrue(Boolean.parseBoolean(personObject.get("married").toString()));
        Assertions.assertEquals(27, Integer.parseInt(personObject.get("age").toString()));

        JSONObject address = (JSONObject) personObject.get("address");
        Assertions.assertEquals("First street, building 1, flat 1", address.get("streetAddress").toString());
        Assertions.assertEquals("Nizhny Novgorod", address.get("city").toString());

        JSONArray phoneNumbers = (JSONArray) personObject.get("phoneNumbers");
        Assertions.assertEquals("88005553535", phoneNumbers.get(0).toString());
        Assertions.assertEquals("89205476254", phoneNumbers.get(1).toString());
    }

    @Test
    public void jsonPathParseTest() {
        String personFileContent = getTextFromFile(personJsonFilePath);

        Assertions.assertEquals("Ivan", JsonPath.read(personFileContent, "$.firstName"));
        Assertions.assertEquals("Ivanov", JsonPath.read(personFileContent, "$.lastName"));
        Assertions.assertNull(JsonPath.read(personFileContent, "$.children"));
        Assertions.assertEquals(true, JsonPath.read(personFileContent, "$.married"));
        Assertions.assertEquals(Integer.valueOf(27), JsonPath.read(personFileContent, "$.age"));

        Assertions.assertEquals("First street, building 1, flat 1",
                JsonPath.read(personFileContent, "$.address.streetAddress"));
        Assertions.assertEquals("Nizhny Novgorod", JsonPath.read(personFileContent, "$.address.city"));

        List<String> phoneNumbers = JsonPath.read(personFileContent, "$.phoneNumbers");
        Assertions.assertTrue(phoneNumbers.contains("88005553535"));
        Assertions.assertTrue(phoneNumbers.contains("89205476254"));
    }

    @Test
    public void jacksonCreateTest() throws Exception {
        ObjectMapper mapper = new ObjectMapper();

        Address address = new Address("First street, building 1, flat 1", "Nizhny Novgorod");
        List<String> phoneNumbers = new ArrayList<>() {{
            add("88005553535");
            add("89205476254");
        }};
        Person person = new Person("Ivan", "Ivanov", null, true, 27, address, phoneNumbers);

        String personJson = mapper.writeValueAsString(person);
        System.out.println(personJson);
    }

    @Test
    public void jacksonParseTest() throws Exception {
        String personJson = getTextFromFile(personJsonFilePath);
        ObjectMapper mapper = new ObjectMapper();
        Person person = mapper.readValue(personJson, Person.class);

        Assertions.assertEquals("Ivan", person.getFirstName());
        Assertions.assertEquals("Ivanov", person.getLastName());
        Assertions.assertNull(person.getChildren());
        Assertions.assertFalse(person.isMarried());
        Assertions.assertEquals(27, person.getAge());

        Assertions.assertEquals("First street, building 1, flat 1", person.getAddress().getStreetAddress());
        Assertions.assertEquals("Nizhny Novgorod", person.getAddress().getCity());

        Assertions.assertEquals("88005553535", person.getPhone_numbers().get(0));
        Assertions.assertEquals("89205476254", person.getPhone_numbers().get(1));
    }

    @Test
    public void jacksonJsonNodeTest() throws Exception {
        String personJson = getTextFromFile(personJsonFilePath);
        ObjectMapper mapper = new ObjectMapper();
        JsonNode actualObj = mapper.readTree(personJson);

        Assertions.assertEquals("Ivan", actualObj.get("firstName").asText());
        Assertions.assertEquals("Ivanov", actualObj.get("lastName").asText());
        Assertions.assertTrue(actualObj.get("children").isEmpty());
        Assertions.assertTrue(actualObj.get("married").asBoolean());
        Assertions.assertEquals(27, actualObj.get("age").asInt());

        JsonNode address = actualObj.get("address");
        Assertions.assertEquals("First street, building 1, flat 1", address.get("streetAddress").asText());
        Assertions.assertEquals("Nizhny Novgorod", address.get("city").asText());

        ArrayNode arrayNode = (ArrayNode) actualObj.get("phoneNumbers");
        Assertions.assertEquals("88005553535", arrayNode.get(0).asText());
        Assertions.assertEquals("89205476254", arrayNode.get(1).asText());
    }

    private String getTextFromFile(String fileName) {
        StringBuilder text = new StringBuilder();
        try (InputStream fileInputStream = new FileInputStream(fileName)) {
            int data;
            do {
                data = fileInputStream.read();
                if (data != -1) {
                    text.append((char) data);
                }
            } while (data != -1);
        } catch (IOException e) {
            System.out.println("Error reading file: " + e.getMessage());
        }
        return text.toString();
    }

    @Test
    public void gsonCreateTest() {
        Address address = new Address("First street, building 1, flat 1", "Nizhny Novgorod");
        List<String> phoneNumbers = new ArrayList<>() {{
            add("88005553535");
            add("89205476254");
        }};
        Person person = new Person("Ivan", "Ivanov", null, true, 27, address, phoneNumbers);

        String personJson = new Gson().toJson(person);
        System.out.println(personJson);
    }

    @Test
    public void gsonParseTest() {
        Gson gson = new GsonBuilder().setVersion(1.0).create();
        //Gson gson = new GsonBuilder().excludeFieldsWithoutExposeAnnotation().create();
        Person person = gson.fromJson(getTextFromFile(personJsonFilePath), Person.class);

        Assertions.assertEquals("Ivan", person.getFirstName());
        Assertions.assertEquals("Ivanov", person.getLastName());

        Assertions.assertNull(person.getChildren());
        Assertions.assertTrue(person.isMarried());
        Assertions.assertEquals(27, person.getAge());

        Assertions.assertEquals("First street, building 1, flat 1", person.getAddress().getStreetAddress());
        Assertions.assertEquals("Nizhny Novgorod", person.getAddress().getCity());

        Assertions.assertEquals("88005553535", person.getPhone_numbers().get(0));
        Assertions.assertEquals("89205476254", person.getPhone_numbers().get(1));
    }
}
