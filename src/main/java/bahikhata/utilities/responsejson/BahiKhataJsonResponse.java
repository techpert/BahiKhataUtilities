/**
 * copyright © 2017 Techpert It Solutions Private Limited
 */
package bahikhata.utilities.responsejson;

import java.io.IOException;
import java.io.Serializable;
import java.util.HashMap;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.google.gson.Gson;

/**
 * Techpert:Bahikhata : 0.0.1 :This class is used
 * 
 * @author Rudhra Koul
 *
 */
public class BahiKhataJsonResponse<T extends Serializable> {

	/**
	 * 
	 */
	public BahiKhataJsonResponse() {
	}

	public String generateSuccessResponseJson(T pojo) {

		ObjectMapper mapper = new ObjectMapper();

		ObjectNode pojoObjectNode = mapper.createObjectNode();
		pojoObjectNode.putPOJO(pojo.getClass().getSimpleName(), pojo);
		pojoObjectNode.put("isSuccess", true);
		pojoObjectNode.put("isError", false);

		try {
			return mapper.writeValueAsString(pojoObjectNode);
		} catch (JsonProcessingException e) {
			e.printStackTrace();
		}
		return null;
	}

	public String generateErrorResponseJson(HashMap<String, Object> errorMap) {

		ObjectMapper mapper = new ObjectMapper();

		try {
			return mapper.writerWithDefaultPrettyPrinter().writeValueAsString(errorMap);
		} catch (JsonProcessingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	public T generatePojoFromJson(String json, Class<T> type) {
		/*ObjectMapper mapper = new ObjectMapper();
		if (json != null) {
			try {
				mapper.i
				mapper.readValue(json, type);
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return null;*/
		
		/*return new Gson().fromJson(json, type);*/
		
		//create ObjectMapper instance
		ObjectMapper objectMapper = new ObjectMapper();

		//read JSON like DOM Parser
		JsonNode rootNode = null;
		try {
			rootNode = objectMapper.readTree(json);
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		JsonNode idNode = rootNode.path(type.getSimpleName());

		
		ObjectMapper mapper = new ObjectMapper();
		if (json != null) {
			try {
				
				return mapper.readValue(idNode.asText(), type);
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return null;
	}
}
