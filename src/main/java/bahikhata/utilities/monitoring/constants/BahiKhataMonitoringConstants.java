/**
 * copyright © 2019 Techpert It Solutions Private Limited
 */
package bahikhata.utilities.monitoring.constants;

/**
 * Techpert:Bahikhata : 0.0.1 :This class contains constants for BahiKhata Monitoring
 * 
 * @author Neeraj Jain
 * @since 8 Sep 2019
 * @version 1.0
 */
public final class BahiKhataMonitoringConstants
{
    private BahiKhataMonitoringConstants()
    {
        throw new UnsupportedOperationException(BahiKhataMonitoringConstants.class.getName());
    }

    /**
     * Techpert:Bahikhata : 0.0.1 :API Path Constants
     */
    public static final String MONITORING_ENDPOINT_PRINCIPLE_PATH = "monitoring";
    public static final String MONITORING_ENDPOINT_CACHE_STATISTICS = "/cache-stats";

    public static final String MONITORING_SERVICE_CLASS_TAG = "Bahikhata-Monitoring";
    public static final String MONITORING_SERVICE_CLASS_VALUE = "BahikhataMonitoring";

    /**
     * Techpert:Bahikhata : 0.0.1 :URL Constants
     */
    public static final String BAHIKHATA_URL = "https://www.bahikhata.com:4200";
    public static final String ADMIN_WITH_WRITE_PERMISSION = "(hasAuthority('Admin')) and #oauth2.hasScope('write')";

    /**
     * Techpert:Bahikhata : 0.0.1 :BahiKhata Address Class Constants
     */

    public static final String BAHIKHATA_CACHE_STATISTICS_CLASS_DESCRIPTION = "Model class for BahiKhataCacheStatistics";

    public static final String BAHIKHATA_CACHE_STATISTICS_CACHE_HITS_DESCRIPTION = "Number of hits in the cache";
    public static final String BAHIKHATA_CACHE_STATISTICS_CACHE_MISSES_DESCRIPTION = "Number of misses in the cache";
    public static final String BAHIKHATA_CACHE_STATISTICS_CACHE_PUTS_DESCRIPTION = "Number of puts in the cache";
    public static final String BAHIKHATA_CACHE_STATISTICS_CACHE_GETS_DESCRIPTION = "Number of gets in the cache";
    public static final String BAHIKHATA_CACHE_STATISTICS_CACHE_REMOVALS_DESCRIPTION = "Number of removals in the cache";
    public static final String BAHIKHATA_CACHE_STATISTICS_CACHE_EVICTS_DESCRIPTION = "Number of evicts in the cache";
    public static final String BAHIKHATA_CACHE_STATISTICS_CACHE_HIT_PERCENTAGE_DESCRIPTION = "Percentage of cache hits";
    public static final String BAHIKHATA_CACHE_STATISTICS_CACHE_MISS_PERCENTAGE_DESCRIPTION = "Percentage of cache misses";
    public static final String BAHIKHATA_CACHE_STATISTICS_CACHE_AVERAGE_GET_TIME_DESCRIPTION = "Average get time from cache";
    public static final String BAHIKHATA_CACHE_STATISTICS_CACHE_AVERAGE_PUT_TIME_DESCRIPTION = "Average put time in cache";
    public static final String BAHIKHATA_CACHE_STATISTICS_CACHE_AVERAGE_REMOVAL_TIME_DESCRIPTION = "Average removal time from cache";

    public static final String BAHIKHATA_CACHE_STATISTICS_CACHE_HITS_VALUE = "2";
    public static final String BAHIKHATA_CACHE_STATISTICS_CACHE_MISSES_VALUE = "3";
    public static final String BAHIKHATA_CACHE_STATISTICS_CACHE_PUTS_VALUE = "1";
    public static final String BAHIKHATA_CACHE_STATISTICS_CACHE_GETS_VALUE = "67";
    public static final String BAHIKHATA_CACHE_STATISTICS_CACHE_REMOVALS_VALUE = "4";
    public static final String BAHIKHATA_CACHE_STATISTICS_CACHE_EVICTS_VALUE = "2";
    public static final String BAHIKHATA_CACHE_STATISTICS_CACHE_HIT_PERCENTAGE_VALUE = "23.43";
    public static final String BAHIKHATA_CACHE_STATISTICS_CACHE_MISS_PERCENTAGE_VALUE = "33.43";
    public static final String BAHIKHATA_CACHE_STATISTICS_CACHE_AVERAGE_GET_TIME_VALUE = "2.3";
    public static final String BAHIKHATA_CACHE_STATISTICS_CACHE_AVERAGE_PUT_TIME_VALUE = "3.2";
    public static final String BAHIKHATA_CACHE_STATISTICS_CACHE_AVERAGE_REMOVAL_TIME_VALUE = "1.2";
    
    public static final String ERROR_KEY = "errors";
    public static final String INTERNAL_SERVER_ERROR_KEY = "Internal Server Error";
    public static final String INTERNAL_SERVER_ERROR_VALUE = "Service Temporarily Down.Please Try Again In Some Time.";
}
