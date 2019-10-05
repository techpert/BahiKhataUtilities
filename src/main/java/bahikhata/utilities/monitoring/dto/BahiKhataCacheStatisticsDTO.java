/**
 *  copyright © 2019 Techpert It Solutions Private Limited
 */
package bahikhata.utilities.monitoring.dto;

import bahikhata.utilities.monitoring.constants.BahiKhataMonitoringConstants;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * Techpert:Bahikhata : 0.0.1 :This class is model class for Cache Statistics
 * 
 * @author Neeraj.Jain
 * @since 5-Oct-2019
 * @version 1.0
 */
@ApiModel(description = BahiKhataMonitoringConstants.BAHIKHATA_CACHE_STATISTICS_CLASS_DESCRIPTION, reference = "BahiKhataCacheStatisticsDTO")
public class BahiKhataCacheStatisticsDTO
{
    @ApiModelProperty(required = true, notes = BahiKhataMonitoringConstants.BAHIKHATA_CACHE_STATISTICS_CACHE_HITS_DESCRIPTION, example = BahiKhataMonitoringConstants.BAHIKHATA_CACHE_STATISTICS_CACHE_HITS_VALUE)
    private long cacheHits;
    @ApiModelProperty(required = true, notes = BahiKhataMonitoringConstants.BAHIKHATA_CACHE_STATISTICS_CACHE_HIT_PERCENTAGE_DESCRIPTION, example = BahiKhataMonitoringConstants.BAHIKHATA_CACHE_STATISTICS_CACHE_HIT_PERCENTAGE_VALUE)
    private float cacheHitsPercencantage;
    @ApiModelProperty(required = true, notes = BahiKhataMonitoringConstants.BAHIKHATA_CACHE_STATISTICS_CACHE_MISSES_DESCRIPTION, example = BahiKhataMonitoringConstants.BAHIKHATA_CACHE_STATISTICS_CACHE_MISSES_VALUE)
    private long cacheMisses;
    @ApiModelProperty(required = true, notes = BahiKhataMonitoringConstants.BAHIKHATA_CACHE_STATISTICS_CACHE_MISS_PERCENTAGE_DESCRIPTION, example = BahiKhataMonitoringConstants.BAHIKHATA_CACHE_STATISTICS_CACHE_MISS_PERCENTAGE_VALUE)
    private float cacheMissPercentage;
    @ApiModelProperty(required = true, notes = BahiKhataMonitoringConstants.BAHIKHATA_CACHE_STATISTICS_CACHE_GETS_DESCRIPTION, example = BahiKhataMonitoringConstants.BAHIKHATA_CACHE_STATISTICS_CACHE_GETS_VALUE)
    private long cacheGets;
    @ApiModelProperty(required = true, notes = BahiKhataMonitoringConstants.BAHIKHATA_CACHE_STATISTICS_CACHE_PUTS_DESCRIPTION, example = BahiKhataMonitoringConstants.BAHIKHATA_CACHE_STATISTICS_CACHE_PUTS_VALUE)
    private long cachePuts;
    @ApiModelProperty(required = true, notes = BahiKhataMonitoringConstants.BAHIKHATA_CACHE_STATISTICS_CACHE_REMOVALS_DESCRIPTION, example = BahiKhataMonitoringConstants.BAHIKHATA_CACHE_STATISTICS_CACHE_REMOVALS_VALUE)
    private long cacheRemovals;
    @ApiModelProperty(required = true, notes = BahiKhataMonitoringConstants.BAHIKHATA_CACHE_STATISTICS_CACHE_EVICTS_DESCRIPTION, example = BahiKhataMonitoringConstants.BAHIKHATA_CACHE_STATISTICS_CACHE_EVICTS_VALUE)
    private long cacheEvictions;
    @ApiModelProperty(required = true, notes = BahiKhataMonitoringConstants.BAHIKHATA_CACHE_STATISTICS_CACHE_AVERAGE_GET_TIME_DESCRIPTION, example = BahiKhataMonitoringConstants.BAHIKHATA_CACHE_STATISTICS_CACHE_AVERAGE_GET_TIME_VALUE)
    private float averageGetTime;
    @ApiModelProperty(required = true, notes = BahiKhataMonitoringConstants.BAHIKHATA_CACHE_STATISTICS_CACHE_AVERAGE_PUT_TIME_DESCRIPTION, example = BahiKhataMonitoringConstants.BAHIKHATA_CACHE_STATISTICS_CACHE_AVERAGE_PUT_TIME_VALUE)
    private float averagePutTime;
    @ApiModelProperty(required = true, notes = BahiKhataMonitoringConstants.BAHIKHATA_CACHE_STATISTICS_CACHE_AVERAGE_REMOVAL_TIME_DESCRIPTION, example = BahiKhataMonitoringConstants.BAHIKHATA_CACHE_STATISTICS_CACHE_AVERAGE_REMOVAL_TIME_VALUE)
    private float averageRemoveTime;

    public BahiKhataCacheStatisticsDTO(long cacheHits, float cacheHitsPercencantage,
            long cacheMisses, float cacheMissPercentage, long cacheGets, long cachePuts,
            long cacheRemovals, long cacheEvictions, float averageGetTime, float averagePutTime,
            float averageRemoveTime)
    {
        this.cacheHits = cacheHits;
        this.cacheHitsPercencantage = cacheHitsPercencantage;
        this.cacheMisses = cacheMisses;
        this.cacheMissPercentage = cacheMissPercentage;
        this.cacheGets = cacheGets;
        this.cachePuts = cachePuts;
        this.cacheRemovals = cacheRemovals;
        this.cacheEvictions = cacheEvictions;
        this.averageGetTime = averageGetTime;
        this.averagePutTime = averagePutTime;
        this.averageRemoveTime = averageRemoveTime;
    }

    public BahiKhataCacheStatisticsDTO()
    {
    }

    public long getCacheHits()
    {
        return cacheHits;
    }

    public void setCacheHits(long cacheHits)
    {
        this.cacheHits = cacheHits;
    }

    public float getCacheHitsPercencantage()
    {
        return cacheHitsPercencantage;
    }

    public void setCacheHitsPercencantage(float cacheHitsPercencantage)
    {
        this.cacheHitsPercencantage = cacheHitsPercencantage;
    }

    public long getCacheMisses()
    {
        return cacheMisses;
    }

    public void setCacheMisses(long cacheMisses)
    {
        this.cacheMisses = cacheMisses;
    }

    public float getCacheMissPercentage()
    {
        return cacheMissPercentage;
    }

    public void setCacheMissPercentage(float cacheMissPercentage)
    {
        this.cacheMissPercentage = cacheMissPercentage;
    }

    public long getCacheGets()
    {
        return cacheGets;
    }

    public void setCacheGets(long cacheGets)
    {
        this.cacheGets = cacheGets;
    }

    public long getCachePuts()
    {
        return cachePuts;
    }

    public void setCachePuts(long cachePuts)
    {
        this.cachePuts = cachePuts;
    }

    public long getCacheRemovals()
    {
        return cacheRemovals;
    }

    public void setCacheRemovals(long cacheRemovals)
    {
        this.cacheRemovals = cacheRemovals;
    }

    public long getCacheEvictions()
    {
        return cacheEvictions;
    }

    public void setCacheEvictions(long cacheEvictions)
    {
        this.cacheEvictions = cacheEvictions;
    }

    public float getAverageGetTime()
    {
        return averageGetTime;
    }

    public void setAverageGetTime(float averageGetTime)
    {
        this.averageGetTime = averageGetTime;
    }

    public float getAveragePutTime()
    {
        return averagePutTime;
    }

    public void setAveragePutTime(float averagePutTime)
    {
        this.averagePutTime = averagePutTime;
    }

    public float getAverageRemoveTime()
    {
        return averageRemoveTime;
    }

    public void setAverageRemoveTime(float averageRemoveTime)
    {
        this.averageRemoveTime = averageRemoveTime;
    }

    @Override
    public String toString()
    {
        return "BahiKhataCacheStatisticsDTO [cacheHits=" + cacheHits + ", cacheHitsPercencantage="
                + cacheHitsPercencantage + ", cacheMisses=" + cacheMisses + ", cacheMissPercentage="
                + cacheMissPercentage + ", cacheGets=" + cacheGets + ", cachePuts=" + cachePuts
                + ", cacheRemovals=" + cacheRemovals + ", cacheEvictions=" + cacheEvictions
                + ", averageGetTime=" + averageGetTime + ", averagePutTime=" + averagePutTime
                + ", averageRemoveTime=" + averageRemoveTime + "]";
    }
}
