/**
 * copyright © 2019 Techpert It Solutions Private Limited
 */
package bahikhata.utilities.testingutilities;

import java.time.LocalDateTime;

/**
* Techpert:Bahikhata : 0.0.1 :This class is used
 * @author Rudhra Koul 
 * @since 1 Sep 2019
 * @version 1.0
 */
public class BahiKhataLocalDateTimeFactory implements BahiKhataFactory<LocalDateTime> {

	/**
	* Techpert:Bahikhata : 0.0.1 :This Method
	* @author Rudhra Koul
	 * @since 1 Sep 2019
	 * @version 1.0 
	 * @return
	 */
	 @Override
     public LocalDateTime create() {
         return LocalDateTime.now();
     }

	/**
	* Techpert:Bahikhata : 0.0.1 :This Method
	* @author Rudhra Koul
	 * @since 1 Sep 2019
	 * @version 1.0 
	 * @return
	 */
	@Override
	public Class<LocalDateTime> getClassProducedByFactory() {
		return LocalDateTime.class;
	}

	/**
	* Techpert:Bahikhata : 0.0.1 :This Method
	* @author Rudhra Koul
	 * @since 1 Sep 2019
	 * @version 1.0 
	 * @return
	 */
	@Override
	public BahiKhataFactory<LocalDateTime> getFactoryObjectInstance() {
		return new BahiKhataLocalDateTimeFactory();
	}

}
