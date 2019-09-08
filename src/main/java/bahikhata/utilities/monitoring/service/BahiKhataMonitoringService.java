package bahikhata.utilities.monitoring.service;

import java.util.ArrayList;
import java.util.List;

import javax.cache.management.CacheStatisticsMXBean;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.message.Message;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import bahikhata.utilities.monitoring.dto.BahiKhataCacheStatisticsDTO;
import bahikhata.utilities.monitoring.exception.BahiKhataStatsticsBeanException;
import bahikhata.utilities.monitoring.factory.BahiKhataMonitoringMBeanFactory;

@Service
public class BahiKhataMonitoringService
{
    private  final BahiKhataMonitoringMBeanFactory bahiKhataMonitoringMBeanFactory;
    /*
     * Techpert:Bahikhata : 0.0.1 :Logger instance for
     * BahiKhataMonitoringService
     */
    private static final Logger logger= LogManager.getLogger(BahiKhataMonitoringService.class);
   
    @Autowired
    public BahiKhataMonitoringService(
            BahiKhataMonitoringMBeanFactory bahiKhataMonitoringMBeanFactory)
    {
        this.bahiKhataMonitoringMBeanFactory = bahiKhataMonitoringMBeanFactory;
    }
    
    public ResponseEntity<List<BahiKhataCacheStatisticsDTO>> getCacheStatstics()
            throws BahiKhataStatsticsBeanException
    {
        Message m = logger.traceEntry("getCacheStatstics");
        List<BahiKhataCacheStatisticsDTO> bahiKhataCacheStatisticsDTOList = new ArrayList<>();
        List<CacheStatisticsMXBean> cacheStatisticsBeans = bahiKhataMonitoringMBeanFactory
                .getCacheStatisticsMXBeans();
        for (CacheStatisticsMXBean cacheStatisticsMXBean : cacheStatisticsBeans)
        {
            BahiKhataCacheStatisticsDTO bahiKhataCacheStatisticsDTO = new BahiKhataCacheStatisticsDTO();
            bahiKhataCacheStatisticsDTO
                    .setAverageGetTime(cacheStatisticsMXBean.getAverageGetTime());
            bahiKhataCacheStatisticsDTO
                    .setAveragePutTime(cacheStatisticsMXBean.getAveragePutTime());
            bahiKhataCacheStatisticsDTO
                    .setAverageRemoveTime(cacheStatisticsMXBean.getAverageRemoveTime());
            bahiKhataCacheStatisticsDTO
                    .setCacheEvictions(cacheStatisticsMXBean.getCacheEvictions());
            bahiKhataCacheStatisticsDTO.setCacheGets(cacheStatisticsMXBean.getCacheGets());
            bahiKhataCacheStatisticsDTO.setCacheHits(cacheStatisticsMXBean.getCacheHits());
            bahiKhataCacheStatisticsDTO
                    .setCacheHitsPercencantage(cacheStatisticsMXBean.getCacheHitPercentage());
            bahiKhataCacheStatisticsDTO.setCacheMisses(cacheStatisticsMXBean.getCacheMisses());
            bahiKhataCacheStatisticsDTO
                    .setCacheMissPercentage(cacheStatisticsMXBean.getCacheMissPercentage());
            bahiKhataCacheStatisticsDTO.setCachePuts(cacheStatisticsMXBean.getCachePuts());
            bahiKhataCacheStatisticsDTO.setCacheRemovals(cacheStatisticsMXBean.getCacheRemovals());
            bahiKhataCacheStatisticsDTOList.add(bahiKhataCacheStatisticsDTO);
        }
        return logger.traceExit(m,
                ResponseEntity.status(HttpStatus.OK).body(bahiKhataCacheStatisticsDTOList));
    }

    
}
