/**
 * copyright © 2019 Techpert It Solutions Private Limited
 */
package bahikhata.utilities.datetimeutilities;

import java.sql.Date;
import java.time.Instant;
import java.time.LocalDate;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.message.Message;

import bahikhata.utilities.stringutilities.BahiKhataStringUtility;

/**
 * @author Rudhra Koul This is a utility class for date related methods
 *
 */
public class BahiKhataDateTimeUtility implements BahiKhataDateTimeConstantsIfc {
	/**
	 * Techpert:Bahikhata : 0.0.1 :Logger instance for DateTimeUtility
	 */
	private static final Logger logger = LogManager.getLogger(BahiKhataDateTimeUtility.class);

	/**
	 * Techpert:Bahikhata : 0.0.1 : This method returns Sql date
	 * 
	 * @return date in java.sql.date format
	 */
	public static Date getCurrentSqlDate() {

		long millis = System.currentTimeMillis();
		Date date = new Date(millis);
		return date;
	}

	/**
	 * Techpert:Bahikhata : 0.0.1 :This method returns date in string format
	 * 
	 * @return date in yyy/MM/dd format
	 */

	public static String getCurrentDateString() {
		LocalDate localDate = LocalDate.now();
		return (DateTimeFormatter.ofPattern(LOCAL_DATE_FORMAT).format(localDate));
	}

	/**
	 * Techpert:Bahikhata : 0.0.1 :This method returns System default locale based
	 * current date time
	 * 
	 * @return currentDateTime java.time.ZonedDateTime
	 */
	public static ZonedDateTime getcurrentZonedDateTime() {
		Message m = logger.traceEntry("getcurrentZonedDateTime");
		Instant instant = Instant.now();
		ZonedDateTime currentDateTime = instant.atZone(ZoneId.systemDefault());
		return logger.traceExit(m, currentDateTime);

	}

	/**
	 * Techpert:Bahikhata : 0.0.1 :This method checks the supplied timestamp for
	 * expiry
	 * 
	 * @return true if date is expired else false boolean
	 */
	public static Boolean isDateExpired(ZonedDateTime timeStampToCheck) {
		Message m = logger.traceEntry("isDateExpired");
		Instant instant = Instant.now();
		ZonedDateTime currentDateTime = instant.atZone(ZoneId.systemDefault());
		return logger.traceExit(m, currentDateTime.isAfter(timeStampToCheck));

	}

	/**
	 * Techpert:Bahikhata : 0.0.1 :This method returns System default locale based
	 * date time N hours after current date time
	 * 
	 * @param hours
	 *            long
	 * @return dateTimeAfterNHours java.time.ZonedDateTime
	 */
	public static ZonedDateTime getTimestampAfterNHours(long hours) {
		Message m = logger.traceEntry("getTimestampAfterNHours");
		Instant instant = Instant.now();
		ZonedDateTime dateTimeAfterNHours = instant.atZone(ZoneId.systemDefault()).plusHours(hours);
		return logger.traceExit(m, dateTimeAfterNHours);

	}

	/**
	 * Techpert:Bahikhata : 0.0.1 :This method checks if supplied date is ahead of
	 * GMT
	 * 
	 * @param zonedDateTime
	 *            java.time.ZonedDateTime
	 * @return afterGMT boolean
	 */
	public static boolean isTimeZoneAfterGMT(ZonedDateTime zonedDateTime) {
		Message m = logger.traceEntry("isTimeZoneAfterGMT");
		boolean afterGMT = false;
		String zonedDateTimeString = zonedDateTime.toString();
		if (zonedDateTime != null && zonedDateTimeString.contains(GMT_AFTER)) {
			afterGMT = true;
			return logger.traceExit(m, afterGMT);
		} else {
			logger.debug("Supplied date is empty");
			return logger.traceExit(m, afterGMT);

		}
	}

	/**
	 * Techpert:Bahikhata : 0.0.1 :This method checks if supplied date is ahead of
	 * GMT
	 * 
	 * @param zonedDateTime
	 *            String
	 * @return afterGMT boolean
	 */
	public static boolean isTimeZoneAfterGMT(String zonedDateTime) {
		Message m = logger.traceEntry("isTimeZoneAfterGMT");
		boolean afterGMT = false;
		if (BahiKhataStringUtility.isNotNullAndNotEmpty(zonedDateTime) && zonedDateTime.contains(GMT_AFTER)) {
			afterGMT = true;
			return logger.traceExit(m, afterGMT);
		} else {
			logger.debug("Supplied date is empty");
			return logger.traceExit(m, afterGMT);
		}
	}

	/**
	 * Techpert:Bahikhata : 0.0.1 :This method checks if supplied date is behind GMT
	 * 
	 * @param zonedDateTime
	 *            java.time.ZonedDateTime
	 * @return beforeGMT boolean
	 */
	public static boolean isTimeZoneBeforeGMT(ZonedDateTime zonedDateTime) {
		Message m = logger.traceEntry("isTimeZoneBeforeGMT");
		boolean beforeGMT = false;
		String zonedDateTimeString = zonedDateTime.toString();
		if (zonedDateTime != null && zonedDateTimeString.contains(GMT_BEFORE)) {
			beforeGMT = true;
			return logger.traceExit(m, beforeGMT);
		} else {
			logger.debug("Supplied date is empty");
			return logger.traceExit(m, beforeGMT);
		}
	}

	/**
	 * Techpert:Bahikhata : 0.0.1 :This method checks if supplied date is behind GMT
	 * 
	 * @param zonedDateTime
	 *            String
	 * @return beforeGMT boolean
	 */
	public static boolean isTimeZoneBeforeGMT(String zonedDateTime) {
		Message m = logger.traceEntry("isTimeZoneBeforeGMT");
		boolean beforeGMT = false;
		if (BahiKhataStringUtility.isNotNullAndNotEmpty(zonedDateTime) && zonedDateTime.contains(GMT_BEFORE)) {
			beforeGMT = true;
			return logger.traceExit(m, beforeGMT);
		} else {
			logger.debug("Supplied date is empty");
			return logger.traceExit(m, beforeGMT);
		}
	}

	/**
	 * Techpert:Bahikhata : 0.0.1 :This method converts String Date To ZonedDateTime
	 * 
	 * @param dateTime
	 *            in 2007-12-03T10:15:30+01:00z format String
	 * @param timeLag
	 *            Value should be either + or - based on whether ahead or behind GMT
	 *            String
	 * @return zonedDateTime java.time.ZonedDateTime
	 */
	public static ZonedDateTime convertStringDateToZonedDateTime(String dateTime, String timeLag) {
		Message m = logger.traceEntry("convertStringDateToZonedDateTime");
		ZonedDateTime zonedDateTime = null;
		if (BahiKhataStringUtility.isNotNullAndNotEmpty(dateTime)
				&& BahiKhataStringUtility.isNotNullAndNotEmpty(timeLag)) {
			zonedDateTime = Instant.parse(dateTime.substring(0, dateTime.indexOf(timeLag)).concat(ZONE_PLACEHOLDER))
					.atZone(ZoneId.systemDefault());
			return logger.traceExit(m, zonedDateTime);
		} else {
			logger.debug("Supplied date or time lag is empty");
			return logger.traceExit(m, zonedDateTime);
		}
	}
}
