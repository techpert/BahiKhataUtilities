/**
 * copyright © 2019 Techpert It Solutions Private Limited
 */
package bahikhata.utilities.testingutilities;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.apache.commons.lang3.SerializationUtils;
import org.junit.jupiter.api.Test;
import org.meanbean.factories.FactoryCollection;
import org.meanbean.test.BeanTester;

import nl.jqno.equalsverifier.EqualsVerifier;
import nl.jqno.equalsverifier.EqualsVerifierApi;
import nl.jqno.equalsverifier.Warning;

/**
 * Techpert:Bahikhata : 0.0.1 :This class is used to test beans / DTO's /Model
 * classes
 * 
 * @author Rudhra Koul
 * @since 1 Sep 2019
 * @version 1.0
 */
@SuppressWarnings("rawtypes")
public final class BahiKhataModelAndDTOTester {

	private ArrayList<BahiKhataFactory> customFactories = new ArrayList<>();
	private ArrayList<Warning> suppressWarnings = new ArrayList<>();

	/**
	 * 
	 */
	public BahiKhataModelAndDTOTester() {
		customFactories.add(new BahiKhataLocalDateTimeFactory());
		customFactories.add(new BahiKhataZonedDateTimeFactory());
		suppressWarnings.add(Warning.STRICT_INHERITANCE);
		suppressWarnings.add(Warning.NONFINAL_FIELDS);
	}

	@Test
	public <T> void beanIsSerializable(T obj) {
		final T myBean = obj;
		final byte[] serializedMyBean = SerializationUtils.serialize((Serializable) myBean);
		final T deserializedMyBean = SerializationUtils.deserialize(serializedMyBean);
		assertEquals(myBean, deserializedMyBean);
	}

	@Test
	public <T> void equalsAndHashCodeContract(Class<T> type) {
		EqualsVerifier.forClass(type).suppress(suppressWarnings.toArray(new Warning[suppressWarnings.size()])).verify();
	}
	
	@Test
	public <T> void equalsAndHashCodeContractWithPrefabValues(Class<T> type,Class[] prefabType,Object[] prefabValues) {
		EqualsVerifierApi<T> api=EqualsVerifier.forClass(type).suppress(suppressWarnings.toArray(new Warning[suppressWarnings.size()]));
		int prefabValuesSize=prefabValues.length;
		int count=0;
		int prefabTypeCount=0;
		while(prefabValuesSize>0) {
			api=api.withPrefabValues(prefabType[prefabTypeCount], prefabValues[count], prefabValues[++count]);
			prefabValuesSize=prefabValuesSize-2;
			count++;
			prefabTypeCount++;
		}
		
		api.verify();
	}
	
	@Test
	public <T> void equalsAndHashCodeContractWithPrefabValuesAndIgnoredAnnotations(Class<T> type,Class[] prefabType,Object[] prefabValues,Class... ignoredAnnotations) {
		EqualsVerifierApi<T> api=EqualsVerifier.forClass(type).withIgnoredAnnotations(ignoredAnnotations).suppress(suppressWarnings.toArray(new Warning[suppressWarnings.size()]));
		int prefabValuesSize=prefabValues.length;
		int count=0;
		int prefabTypeCount=0;
		while(prefabValuesSize>0) {
			api=api.withPrefabValues(prefabType[prefabTypeCount], prefabValues[count], prefabValues[++count]);
			prefabValuesSize=prefabValuesSize-2;
			count++;
			prefabTypeCount++;
		}
		
		api.verify();
	}
	
	@Test
	public <T> void equalsAndHashCodeContractWithIgnoredAnnotations(Class<T> type,Class... ignoredAnnotations) {
		EqualsVerifier.forClass(type).withIgnoredAnnotations(ignoredAnnotations).suppress(suppressWarnings.toArray(new Warning[suppressWarnings.size()])).verify();
	}
	
	@Test
	public <T> void equalsAndHashCodeContractWithPrefabValuesAndIgnoredAnnotationsAndIgnoredFields(Class<T> type,Class[] prefabType,Object[] prefabValues,Class[] ignoredAnnotations, String[] ignoredFields) {
		EqualsVerifierApi<T> api=EqualsVerifier.forClass(type).withIgnoredAnnotations(ignoredAnnotations).suppress(suppressWarnings.toArray(new Warning[suppressWarnings.size()])).withIgnoredFields(ignoredFields);
		int prefabValuesSize=prefabValues.length;
		int count=0;
		int prefabTypeCount=0;
		while(prefabValuesSize>0) {
			api=api.withPrefabValues(prefabType[prefabTypeCount], prefabValues[count], prefabValues[++count]);
			prefabValuesSize=prefabValuesSize-2;
			count++;
			prefabTypeCount++;
		}
		
		api.verify();
	}
	@Test
	public <T> void equalsAndHashCodeContractWithIgnoredAnnotationsAndIgnoredFields(Class<T> type,Class[] ignoredAnnotations, String[] ignoredFields) {
		EqualsVerifier.forClass(type).withIgnoredAnnotations(ignoredAnnotations).withIgnoredFields(ignoredFields).suppress(suppressWarnings.toArray(new Warning[suppressWarnings.size()])).verify();
	}

	@Test
	public <T> void getterAndSetterCorrectness(Class<T> type) {
		final BeanTester beanTester = new BeanTester();
		Iterator<BahiKhataFactory> factoryIterator = customFactories.iterator();
		FactoryCollection factoryCollection = beanTester.getFactoryCollection();
		while (factoryIterator.hasNext()) {
			BahiKhataFactory<?> factory = factoryIterator.next();
			factoryCollection.addFactory(factory.getClassProducedByFactory(), factory.getFactoryObjectInstance());
		}
		beanTester.testBean(type);
	}


	/**
	 * @return the suppressWarnings
	 */
	public ArrayList<Warning> getSuppressWarnings() {
		return suppressWarnings;
	}

	/**
	 * @param suppressWarnings the suppressWarnings to set
	 */
	public void setSuppressWarnings(ArrayList<Warning> suppressWarnings) {
		this.suppressWarnings = suppressWarnings;
	}

	/**
	 * @param suppressWarnings the suppressWarnings to set
	 */
	public void addSuppressWarnings(Warning suppressWarning) {
		this.suppressWarnings.add(suppressWarning);
	}
	/**
	 * @return the customFactories
	 */
	public List<BahiKhataFactory> getCustomFactories() {
		return customFactories;
	}

	/**
	 * @param customFactories the customFactories to set
	 */
	public void setCustomFactories(List<BahiKhataFactory> customFactories) {
		this.customFactories = (ArrayList<BahiKhataFactory>) customFactories;
	}

	/**
	 * @param customFactories the customFactories to set
	 */
	public void addCustomFactories(BahiKhataFactory<?> customFactory) {
		this.customFactories.add(customFactory);
	}

}
