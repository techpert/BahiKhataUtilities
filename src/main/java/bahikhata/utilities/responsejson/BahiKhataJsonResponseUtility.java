/**
 *  copyright © 2019 Techpert It Solutions Private Limited
 */
package bahikhata.utilities.responsejson;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Set;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;

/**
 * Techpert:Bahikhata : 0.0.1 :This class contains helper methods for generating
 * response JSONs
 * 
 * @author Rudhra Koul
 *
 */
public class BahiKhataJsonResponseUtility {

	/**
	 * 
	 */
	public BahiKhataJsonResponseUtility() {
	}

	/**
	 * Techpert:Bahikhata : 0.0.1 :This method is used for generating successful
	 * response JSONs for the supplied POJO class. This method also adds some
	 * additional keys to the JSON like isError, isSuccess etc
	 * 
	 * @author Rudhra Koul
	 * @param pojo
	 * @return jsonstring String
	 */
	public static <T> String generateSuccessResponseJson(T pojo) {

		ObjectMapper mapper = new ObjectMapper();

		ObjectNode pojoObjectNode = mapper.createObjectNode();
		pojoObjectNode.putPOJO(pojo.getClass().getSimpleName(), pojo);
		pojoObjectNode.put("isSuccess", true);
		try {
			return mapper.writeValueAsString(pojoObjectNode);
		} catch (JsonProcessingException e) {
			e.printStackTrace();
		}
		return null;
	}

	/**
	 * Techpert:Bahikhata : 0.0.1 :This method is used for generating error response
	 * JSONs for the supplied errorMap.
	 * 
	 * @author Rudhra Koul
	 * @param errorMap
	 *            HashMap<String, Object>
	 * @return jsonErrorString String
	 */
	public static String generateErrorResponseJson(HashMap<String, Object> errorMap) {

		errorMap.put("isSuccess", false);
		ObjectMapper mapper = new ObjectMapper();

		try {
			return mapper.writerWithDefaultPrettyPrinter().writeValueAsString(errorMap);
		} catch (JsonProcessingException e) {
			e.printStackTrace();
		}
		return null;
	}

	/**
	 * Techpert:Bahikhata : 0.0.1 :This method is used for generating POJO from
	 * supplied JSON.
	 * 
	 * @author Rudhra Koul
	 * @param json
	 *            String
	 * @param type
	 *            Class<T>
	 * @return pojo
	 */
	public static <T> T generatePojoFromJson(String json, Class<T> type) {

		// create ObjectMapper instance
		
		if (json != null) {
			byte[] jsonData = json.toString().getBytes();
			if (jsonData!= null && jsonData.length>0) {
				
				ObjectMapper mapper = new ObjectMapper();
				try {
					return mapper.readValue(jsonData, type);
				} catch (IOException e) {
					e.printStackTrace();
				}
			} 
		}
		return null;
	}

	/**
	 * Techpert:Bahikhata : 0.0.1 :This method is used for generating successful
	 * response JSON for a collection of objects supplied as a HashMap<Identifier,
	 * POJO>.
	 * 
	 * @author Rudhra Koul
	 * @param pojoMap
	 *            HashMap<P, T>
	 * @param collectionName
	 *            String
	 * @return responseJson String
	 */
	public static <P, T> String generateSuccessResponseJsonForMap(HashMap<P, T> pojoMap, String collectionName) {

		ObjectMapper mapper = new ObjectMapper();

		ObjectNode pojoObjectNode = mapper.createObjectNode();
		Set<P> keyset = pojoMap.keySet();
		List<T> values = new ArrayList<>();
		for (P p : keyset) {
			values.add(pojoMap.get(p));
		}
		pojoObjectNode.putPOJO(collectionName, values);
		pojoObjectNode.put("isSuccess", true);
		try {
			return mapper.writeValueAsString(pojoObjectNode);
		} catch (JsonProcessingException e) {
			e.printStackTrace();
		}
		return null;
	}

	/**
	 * Techpert:Bahikhata : 0.0.1 :This method is used for generating successful
	 * response JSON for a collection of objects supplied as a List<T>
	 * 
	 * @author Rudhra Koul
	 * @param pojoList
	 *            List<T>
	 * @param collectionName
	 *            String
	 * @return responseJson String
	 */
	public static <T> String generateSuccessResponseJsonForList(List<T> pojoList, String collectionName) {

		ObjectMapper mapper = new ObjectMapper();

		ObjectNode pojoObjectNode = mapper.createObjectNode();
		pojoObjectNode.putPOJO(collectionName, pojoList);
		pojoObjectNode.put("isSuccess", true);
		try {
			return mapper.writeValueAsString(pojoObjectNode);
		} catch (JsonProcessingException e) {
			e.printStackTrace();
		}
		return null;
	}
}
