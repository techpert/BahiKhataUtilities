/**
 * copyright © 2018 Techpert It Solutions Private Limited
 */
package bahikhata.utilities.testingutilities;

import org.aspectj.lang.annotation.Aspect;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import bahikhata.utilities.config.BahiKhataCommonSpringBeanConstantsIfc;


/**
 * Techpert:Bahikhata : 0.0.1 : This is the service class for BahiKhataTestDataPreparator
 * @author Rudhra Koul
 *
 */
@Service(BahiKhataCommonSpringBeanConstantsIfc.BAHIKHATA_TEST_DATA_PREPERATOR_SERVICE)
@Scope(value = ConfigurableBeanFactory.SCOPE_SINGLETON)
@Aspect
public class BahiKhataTestDataPreparatorService implements BahiKhataTestDataPreparatorServiceIfc {

	@Autowired
	public BahiKhataTestDataPreparatorIfc bahiKhataTestDataPreparator;

	/**
	 * Techpert:Bahikhata : 0.0.1 :This method runs Sql script based on passed
	 * scriptName
	 * 
	 * @param scriptName
	 *            String
	 * 
	 * @return 1 on success 0 on failure
	 */
	@Override
	public int testRunSql(String sqlFile) {

		return bahiKhataTestDataPreparator.runSqlScript(sqlFile);
	}

}
