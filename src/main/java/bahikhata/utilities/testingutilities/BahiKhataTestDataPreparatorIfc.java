/**
 * copyright © 2018 Techpert It Solutions Private Limited
 */
package bahikhata.utilities.testingutilities;

import org.springframework.core.io.Resource;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author Rudhra Koul This is an interface for BahiKhataTestDataPreparator
 *
 */
@Transactional(readOnly = true, propagation = Propagation.REQUIRED, rollbackFor = { java.lang.Exception.class })
public interface BahiKhataTestDataPreparatorIfc {
	/**
	 * Techpert:Bahikhata : 0.0.1 :This method runs Sql script based on passed
	 * scriptName
	 * 
	 * @param scriptName
	 *            String
	 * 
	 * @return 1 on success 0 on failure
	 */

	@Transactional(readOnly = false, propagation = Propagation.REQUIRED, rollbackFor = { java.lang.Exception.class })
	int runSqlScript(String scriptName);

	/**
	 * Techpert:Bahikhata : 0.0.1 :This method fetches Sql file from classpath
	 * 
	 * @param fileName
	 *            String
	 * 
	 * @return resource org.springframework.core.io.Resource
	 */
	Resource getSqlFile(String fileName);

}