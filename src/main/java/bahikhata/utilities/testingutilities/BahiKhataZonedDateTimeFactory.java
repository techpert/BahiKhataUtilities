/**
 * copyright © 2019 Techpert It Solutions Private Limited
 */
package bahikhata.utilities.testingutilities;

import java.time.ZonedDateTime;

/**
 * Techpert:Bahikhata : 0.0.1 :This class is used
 * 
 * @author Rudhra Koul
 * @since 1 Sep 2019
 * @version 1.0
 */
public class BahiKhataZonedDateTimeFactory implements BahiKhataFactory<ZonedDateTime> {

	/**
	 * Techpert:Bahikhata : 0.0.1 :This Method
	 * 
	 * @author Rudhra Koul
	 * @since 1 Sep 2019
	 * @version 1.0
	 * @return
	 */
	@Override
	public ZonedDateTime create() {
		return ZonedDateTime.now();
	}

	/**
	 * Techpert:Bahikhata : 0.0.1 :This Method
	 * 
	 * @author Rudhra Koul
	 * @since 1 Sep 2019
	 * @version 1.0
	 * @return
	 */
	@Override
	public Class<ZonedDateTime> getClassProducedByFactory() {
		return ZonedDateTime.class;
	}

	/**
	 * Techpert:Bahikhata : 0.0.1 :This Method
	 * 
	 * @author Rudhra Koul
	 * @since 1 Sep 2019
	 * @version 1.0
	 * @return
	 */
	@Override
	public BahiKhataFactory<ZonedDateTime> getFactoryObjectInstance() {
		return new BahiKhataZonedDateTimeFactory();
	}

}
