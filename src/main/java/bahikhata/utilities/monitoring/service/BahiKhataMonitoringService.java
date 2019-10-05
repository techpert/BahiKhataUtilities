/**
 * copyright © 2019 Techpert It Solutions Private Limited
 */
package bahikhata.utilities.monitoring.service;

import java.lang.management.MemoryMXBean;
import java.lang.management.RuntimeMXBean;
import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

import javax.cache.CacheManager;
import javax.cache.management.CacheStatisticsMXBean;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.message.Message;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.sun.management.OperatingSystemMXBean;

import bahikhata.utilities.monitoring.dto.BahiKhataCacheStatisticsDTO;
import bahikhata.utilities.monitoring.dto.BahiKhataMemoryStatsticsDTO;
import bahikhata.utilities.monitoring.dto.BahiKhataOperatingSystemStatisticsDTO;
import bahikhata.utilities.monitoring.dto.BahiKhataRuntimeStatisticsDTO;
import bahikhata.utilities.monitoring.exception.BahiKhataStatsticsBeanException;
import bahikhata.utilities.monitoring.factory.BahiKhataMonitoringMBeanFactory;

/**
 * Techpert:Bahikhata : 0.0.1 :This class will handle all functional operations for
 * {@link BahiKhataCacheStatisticsDTO}, {@link BahiKhataOperatingSystemStatisticsDTO},
 * {@link BahiKhataMemoryStatsticsDTO}, {@link BahiKhataRuntimeStatisticsDTO} 
 * 
 * @author Neeraj Jain
 * @see BahiKhataMonitoringMBeanFactory
 * @since Oct 05,2019
 * @version 0.0.1
 */
@Service
public class BahiKhataMonitoringService
{
    /*
     * Techpert:Bahikhata : 0.0.1 :Autowired instance of BahiKhataMonitoringMBeanFactory
     * Bean
     */
    private final BahiKhataMonitoringMBeanFactory bahiKhataMonitoringMBeanFactory;
    /*
     * Techpert:Bahikhata : 0.0.1 :Autowired instance of CacheManager Bean
     */
    private CacheManager cacheManager;
    /*
     * Techpert:Bahikhata : 0.0.1 :Logger instance for BahiKhataMonitoringService
     */
    private static final Logger logger = LogManager.getLogger(BahiKhataMonitoringService.class);

    @Autowired
    public BahiKhataMonitoringService(
            BahiKhataMonitoringMBeanFactory bahiKhataMonitoringMBeanFactory)
    {
        this.bahiKhataMonitoringMBeanFactory = bahiKhataMonitoringMBeanFactory;
    }

    /**
     * Techpert:Bahikhata : 0.0.1 :This method fetches Cache Statistics from Cache MXBean
     * 
     * @since 05 Oct 2019
     * @return ResponseEntity<Object>
     */
    public ResponseEntity<Object> getCacheStatstics() throws BahiKhataStatsticsBeanException
    {
        Message m = logger.traceEntry("getCacheStatstics");
        if (null != cacheManager)
        {
            List<BahiKhataCacheStatisticsDTO> bahiKhataCacheStatisticsDTOList = new ArrayList<>();
            List<CacheStatisticsMXBean> cacheStatisticsBeans = bahiKhataMonitoringMBeanFactory
                    .getCacheStatisticsMXBeans();
            ;
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
                bahiKhataCacheStatisticsDTO
                        .setCacheRemovals(cacheStatisticsMXBean.getCacheRemovals());
                bahiKhataCacheStatisticsDTOList.add(bahiKhataCacheStatisticsDTO);
            }
            return logger.traceExit(m,
                    ResponseEntity.status(HttpStatus.OK).body(bahiKhataCacheStatisticsDTOList));
        }
        else
        {
            return logger.traceExit(m, ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body(new String("Cache is not configured in application")));
        }
    }

    /**
     * Techpert:Bahikhata : 0.0.1 :This method fetches Memory Statistics from Memory
     * MXBean
     * 
     * @since 05 Oct 2019
     * @return ResponseEntity<{ {@link BahiKhataMemoryStatsticsDTO}>
     */
    public ResponseEntity<BahiKhataMemoryStatsticsDTO> getMemoryStatstics()
            throws BahiKhataStatsticsBeanException
    {
        Message m = logger.traceEntry("getMemoryStatstics");
        MemoryMXBean memoryMXBean = bahiKhataMonitoringMBeanFactory.getMemoryMXBean();
        BahiKhataMemoryStatsticsDTO bahiKhataMemoryStatsticsDTO = new BahiKhataMemoryStatsticsDTO();
        StringBuilder committedNonHeapMemory = new StringBuilder();
        StringBuilder initialNonHeapMemory = new StringBuilder();
        StringBuilder usedNonHeapMemory = new StringBuilder();
        StringBuilder maxNonHeapMemory = new StringBuilder();
        StringBuilder initialHeapMemory = new StringBuilder();
        StringBuilder usedHeapMemory = new StringBuilder();
        StringBuilder committedHeapMemory = new StringBuilder();
        StringBuilder maxHeapMemory = new StringBuilder();
        committedNonHeapMemory
                .append(((memoryMXBean.getNonHeapMemoryUsage().getCommitted()) / (1024 * 1024)));
        committedNonHeapMemory.append(" MB");
        initialNonHeapMemory
                .append(((memoryMXBean.getNonHeapMemoryUsage().getInit()) / (1024 * 1024)));
        initialNonHeapMemory.append(" MB");
        usedNonHeapMemory
                .append(((memoryMXBean.getNonHeapMemoryUsage().getUsed()) / (1024 * 1024)));
        usedNonHeapMemory.append(" MB");
        maxNonHeapMemory.append(((memoryMXBean.getNonHeapMemoryUsage().getMax()) / (1024 * 1024)));
        maxNonHeapMemory.append(" MB");
        initialHeapMemory
                .append(((memoryMXBean.getNonHeapMemoryUsage().getInit()) / (1024 * 1024)));
        initialHeapMemory.append(" MB");
        usedHeapMemory.append(((memoryMXBean.getNonHeapMemoryUsage().getUsed()) / (1024 * 1024)));
        usedHeapMemory.append(" MB");
        committedHeapMemory
                .append(((memoryMXBean.getNonHeapMemoryUsage().getCommitted()) / (1024 * 1024)));
        committedHeapMemory.append(" MB");
        maxHeapMemory.append(((memoryMXBean.getNonHeapMemoryUsage().getMax()) / (1024 * 1024)));
        maxHeapMemory.append(" MB");
        bahiKhataMemoryStatsticsDTO.setCommittedHeapMemory(committedHeapMemory.toString());
        bahiKhataMemoryStatsticsDTO.setCommittedNonHeapMemory(committedNonHeapMemory.toString());
        bahiKhataMemoryStatsticsDTO.setInitialHeapMemory(initialHeapMemory.toString());
        bahiKhataMemoryStatsticsDTO.setInitialNonHeapMemory(initialNonHeapMemory.toString());
        bahiKhataMemoryStatsticsDTO.setMaxHeapMemory(maxHeapMemory.toString());
        bahiKhataMemoryStatsticsDTO.setMaxNonHeapMemory(maxNonHeapMemory.toString());
        bahiKhataMemoryStatsticsDTO.setUsedHeapMemory(usedHeapMemory.toString());
        bahiKhataMemoryStatsticsDTO.setUsedNonHeapMemory(usedNonHeapMemory.toString());
        return logger.traceExit(m,
                ResponseEntity.status(HttpStatus.OK).body(bahiKhataMemoryStatsticsDTO));
    }

    /**
     * Techpert:Bahikhata : 0.0.1 :This method fetches Operating System Statistics from
     * Operating System MXBean
     * 
     * @since 05 Oct 2019
     * @return ResponseEntity<{ @link BahiKhataOperatingSystemStatisticsDTO}>
     */
    public ResponseEntity<BahiKhataOperatingSystemStatisticsDTO> getOperatingSystemStatstics()
            throws BahiKhataStatsticsBeanException
    {
        Message m = logger.traceEntry("getOperatingSystemStatstics");
        BahiKhataOperatingSystemStatisticsDTO bahiKhataOperatingSystemStatisticsDTO = new BahiKhataOperatingSystemStatisticsDTO();
        StringBuilder cpuUsedByJVM = new StringBuilder();
        StringBuilder cpuUsedBySystem = new StringBuilder();
        OperatingSystemMXBean operatingSystemMXBean = bahiKhataMonitoringMBeanFactory
                .getOperatingSystemMXBean();
        bahiKhataOperatingSystemStatisticsDTO
                .setOperatingSystemName(operatingSystemMXBean.getName());
        bahiKhataOperatingSystemStatisticsDTO
                .setAvailableProcessors(operatingSystemMXBean.getAvailableProcessors());
        DecimalFormat decimalFormat = new DecimalFormat("#.##");
        decimalFormat.setRoundingMode(RoundingMode.CEILING);
        cpuUsedByJVM.append(decimalFormat.format(operatingSystemMXBean.getProcessCpuLoad() * 100));
        cpuUsedByJVM.append("%");
        bahiKhataOperatingSystemStatisticsDTO.setJvmCPUUsage(cpuUsedByJVM.toString());
        cpuUsedBySystem
                .append(decimalFormat.format(operatingSystemMXBean.getSystemCpuLoad() * 100));
        cpuUsedBySystem.append("%");
        bahiKhataOperatingSystemStatisticsDTO.setSystemCPUUsage(cpuUsedBySystem.toString());
        return logger.traceExit(m,
                ResponseEntity.status(HttpStatus.OK).body(bahiKhataOperatingSystemStatisticsDTO));
    }

    /**
     * Techpert:Bahikhata : 0.0.1 :This method fetches Runtime Statistics from Operating
     * System MXBean
     * 
     * @since 05 Oct 2019
     * @return ResponseEntity<{@link BahiKhataRuntimeStatisticsDTO}>
     */
    public ResponseEntity<BahiKhataRuntimeStatisticsDTO> getRuntimeStatstics()
            throws BahiKhataStatsticsBeanException
    {
        Message m = logger.traceEntry("getOperatingSystemStatstics");
        RuntimeMXBean runtimeMXBean = bahiKhataMonitoringMBeanFactory.getGarbageRuntimeMXBean();
        BahiKhataRuntimeStatisticsDTO bahiKhataRuntimeStatisticsDTO = new BahiKhataRuntimeStatisticsDTO();
        bahiKhataRuntimeStatisticsDTO.setBootClassPath(runtimeMXBean.getBootClassPath());
        bahiKhataRuntimeStatisticsDTO.setClassPath(runtimeMXBean.getClassPath());
        bahiKhataRuntimeStatisticsDTO.setLibraryPath(runtimeMXBean.getLibraryPath());
        return logger.traceExit(m,
                ResponseEntity.status(HttpStatus.OK).body(bahiKhataRuntimeStatisticsDTO));
    }

    public CacheManager getCacheManager()
    {
        return cacheManager;
    }

    @Autowired
    public void setCacheManager(CacheManager cacheManager)
    {
        this.cacheManager = cacheManager;
    }

    /**
     * Techpert:Bahikhata : 0.0.1 :This method evict all caches
     * 
     * @since 05 Oct 2019
     * @return ResponseEntity<Object>
     */
    public void evictAllCaches()
    {
        for (String name : cacheManager.getCacheNames())
        {
            cacheManager.getCache(name).clear();
        }
    }
}
