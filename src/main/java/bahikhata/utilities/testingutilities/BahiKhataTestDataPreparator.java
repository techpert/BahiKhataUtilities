/**
 * copyright © 2018 Techpert It Solutions Private Limited
 */
package bahikhata.utilities.testingutilities;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;
import org.springframework.stereotype.Repository;

import bahikhata.utilities.config.BahiKhataCommonSpringBeanConstantsIfc;

/**
 * Techpert:Bahikhata : 0.0.1 : This class is used to prepare test data for
 * testing
 * 
 * @author Rudhra Koul
 *
 */
@Repository(BahiKhataCommonSpringBeanConstantsIfc.BAHIKHATA_TEST_DATA_PREPARATOR_REPOSITORY)
@Scope(value = ConfigurableBeanFactory.SCOPE_SINGLETON)
public class BahiKhataTestDataPreparator
		implements BahiKhataTestDataPreparatorConstantsIfc, BahiKhataTestDataPreparatorIfc {
	/**
	 * Techpert:Bahikhata : 0.0.1 :Logger instance for BahiKhataTestDataPreparator
	 */
	private static Logger logger = LogManager.getLogger(BahiKhataTestDataPreparator.class);

	/**
	 * Techpert:Bahikhata : 0.0.1 :Autowired instance for ResourceLoader
	 */
	@Autowired
	private ResourceLoader resourceLoader;

	/**
	 * Techpert:Bahikhata : 0.0.1 :Autowired instance for EntityManager
	 */
	@PersistenceContext
	private EntityManager entityManager;

	/**
	 * Techpert:Bahikhata : 0.0.1 :This method is used to return session to interact
	 * with database
	 * 
	 * @return Session org.hibernate.Session
	 */
	protected Session getSession() {
		return entityManager.unwrap(Session.class);
	}

	/**
	 * Techpert:Bahikhata : 0.0.1 :This method runs Sql script based on passed
	 * scriptName
	 * 
	 * @param scriptName String
	 * 
	 * @return 1 on success 0 on failure
	 */
	@Override
	public int runSqlScript(String scriptName) {
		Resource sqlScript = getSqlFile(scriptName);
		Scanner read = null;
		int result = 1;
		try {
			read = new Scanner(sqlScript.getFile());
		} catch (IOException fileNotFoundException) {
			fileNotFoundException.printStackTrace();
		}
		read.useDelimiter(SQL_DELIMITER);
		ArrayList<String> sqlList = new ArrayList<>();

		while (read.hasNext()) {
			sqlList.add(read.next());

		}
		read.close();

		try {
			for (Iterator<String> iterator = sqlList.iterator(); iterator.hasNext();) {
				String sql = (String) iterator.next();
				if (getSession().createNativeQuery(sql).executeUpdate() == 0) {
					result = 0;
				}

			}
		} catch (Exception exception) {
			StringBuilder debugMessage = new StringBuilder("exception caught while executing SQL");
			result = 0;
			logger.debug(debugMessage.append(exception.getMessage()).toString());

		}

		return result;

	}

	/**
	 * Techpert:Bahikhata : 0.0.1 :This method fetches Sql file from classpath
	 * 
	 * @param fileName String
	 * 
	 * @return resource org.springframework.core.io.Resource
	 */
	@Override
	public Resource getSqlFile(String fileName) {
		Resource resource = resourceLoader.getResource(BAHIKHATA_CLASSPATH.concat(fileName).concat(SQL_EXTENSION));
		return resource;
	}
}
