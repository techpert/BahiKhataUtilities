/**
 * copyright © 2017 Techpert It Solutions Private Limited
 */
package bahikhata.utilities.dbutilities;

import java.math.BigInteger;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.message.Message;
import org.hibernate.Session;

import bahikhata.utilities.stringutilities.BahiKhataStringUtility;

/**
 * @author Rudhra Koul This is a utility class for database related methods
 *
 */
public class DbUtil implements CommonDatabaseConstantsIfc {

	private static Logger logger = LogManager.getLogger(DbUtil.class);

	/**
	 * BahiKhata :0.0.1:fetches next value from the given sequence
	 * 
	 * @return Next value from the given sequence on success else 0
	 * @param session
	 *            org.hibernate.Session
	 * @param sequenceName
	 */
	public static int getNextValFromSequence(String sequenceName, Session session) {
		int nextVal = 0;
		Message m = logger.traceEntry("getNextValFromSequence");
		if (session != null && BahiKhataStringUtility.isNotNullAndNotEmpty(sequenceName)) {
			BigInteger bigIntNextVal = (BigInteger) session.createNativeQuery(SEQUENCE_NEXTVAL_SQL.concat(sequenceName))
					.getSingleResult();
			if (bigIntNextVal != null) {
				nextVal = bigIntNextVal.intValue();
			}
		}
		return logger.traceExit(m, nextVal);
	}

}
