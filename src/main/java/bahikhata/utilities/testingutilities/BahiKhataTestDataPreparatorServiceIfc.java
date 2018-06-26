/**
 * copyright © 2018 Techpert It Solutions Private Limited
 */
package bahikhata.utilities.testingutilities;


import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

/**
 * Techpert:Bahikhata : 0.0.1 : This is the interface for BahiKhataTestDataPreparatorService
 * @author Rudhra Koul
 *
 */
@Transactional(readOnly = true, propagation = Propagation.REQUIRED, rollbackFor = { java.lang.Exception.class })
public interface BahiKhataTestDataPreparatorServiceIfc {

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
	int testRunSql(String sqlFile);

}