/**
 * copyright © 2019 Techpert It Solutions Private Limited
 */
package bahikhata.utilities.testingutilities;
import org.meanbean.lang.Factory;
/**
* Techpert:Bahikhata : 0.0.1 :This class is used
 * @author Rudhra Koul 
 * @since 1 Sep 2019
 * @version 1.0
 * @param <T>
 */
public interface BahiKhataFactory<T> extends Factory{

	public Class<T> getClassProducedByFactory();
	
	public BahiKhataFactory<T> getFactoryObjectInstance();
}
