/**
 * copyright © 2019 Techpert It Solutions Private Limited
 */
package bahikhata.utilities.dbutilities;

/**
 * Techpert:Bahikhata : 0.0.1 : This interface contains database related
 * constants
 * 
 * @author Rudhra Koul
 *
 */
public class CommonDatabaseConstants {

	/**
	 * 
	 */
	private CommonDatabaseConstants() {
		throw new UnsupportedOperationException(CommonDatabaseConstants.class.getName());
	}

	/**
	 * Techpert:Bahikhata : 0.0.1 :Database specific constants
	 */
	public static final String DATABASE_SCHEMA = "dbo";
	/**
	 * Techpert:Bahikhata : 0.0.1 :Sequence Constants
	 */
	public static final String PRIMARY_KEY_GENERATOR_NAME = "generator";
	public static final String PRIMARY_KEY_GENERATOR_STRATEGY = "identity";
	public static final String PRIMARY_KEY_GENERATOR_SEQUENCE = "sequence";

	/**
	 * Techpert:Bahikhata : 0.0.1 :Hibernate specific constants
	 */
	public static final int BATCH_SIZE = 50;

	/**
	 * Techpert:Bahikhata : 0.0.1 :git test specific constants
	 */
	public static final int TESTING_GIT = 50;

	public static final String PERCENTAGE_WILDCARD = "%";
	public static final String BOOLEAN_TYPE_T_F = "true_false";
	public static final int BIG_DECIMAL_PRECISION = 9;
	public static final int BIG_DECIMAL_SCALE = 2;
	public static final String CONSTRAINT_IN = "IN";

	/**
	 * Techpert:Bahikhata : 0.0.1 :Audit Column constants
	 */
	public static final String COLUMN_CREATE_TIMESTAMP = "CREATE_TIMESTAMP";
	public static final String COLUMN_UPDATE_TIMESTAMP = "LAST_UPDATE_TIMESTAMP";
}
