/**
 * copyright © 2019 Techpert It Solutions Private Limited
 */
package bahikhata.utilities.monitoring.controller;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.message.Message;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import bahikhata.utilities.monitoring.constants.BahiKhataMonitoringConstants;
import bahikhata.utilities.monitoring.dto.BahiKhataCacheStatisticsDTO;
import bahikhata.utilities.monitoring.dto.BahiKhataMemoryStatsticsDTO;
import bahikhata.utilities.monitoring.dto.BahiKhataOperatingSystemStatisticsDTO;
import bahikhata.utilities.monitoring.dto.BahiKhataRuntimeStatisticsDTO;
import bahikhata.utilities.monitoring.exception.BahiKhataStatsticsBeanException;
import bahikhata.utilities.monitoring.service.BahiKhataMonitoringService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

/**
 * @author Neeraj1.Jain
 */

@RestController
@Api(tags = BahiKhataMonitoringConstants.MONITORING_SERVICE_CLASS_TAG, value = BahiKhataMonitoringConstants.MONITORING_SERVICE_CLASS_VALUE)
@RequestMapping(BahiKhataMonitoringConstants.MONITORING_ENDPOINT_PRINCIPLE_PATH)
@CrossOrigin(origins = { BahiKhataMonitoringConstants.BAHIKHATA_URL })
public class BahiKhataMonitoringController
{
    /**
     * 
     */
    Logger logger = LogManager.getLogger(BahiKhataMonitoringController.class);

    /**
     *  
     */
    @Autowired
    BahiKhataMonitoringService bahiKhataMonitoringService;

    /**
     * Techpert:Bahikhata : 0.0.1 :This method fetches the Cache statstics
     * 
     * @since 8 Sep 2019
     * @return JSON representation of {@link BahiKhataCacheStatisticsDTO}
     * @throws BahiKhataStatsticsBeanException
     */
    @GetMapping(value = BahiKhataMonitoringConstants.MONITORING_ENDPOINT_CACHE_STATISTICS, produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(value = "getCacheStatstics", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE, notes = "The method fetches cache statistics", response = BahiKhataCacheStatisticsDTO.class, protocols = "https")
    @PreAuthorize(BahiKhataMonitoringConstants.ADMIN_WITH_WRITE_PERMISSION)
    @ApiResponses({ @ApiResponse(code = 200, message = "Successfully fetched cache statistics") })
    public ResponseEntity<Object> getCacheStatstics() throws BahiKhataStatsticsBeanException
    {
        Message m = logger.traceEntry("getcacheStatstics");
        return logger.traceExit(m, bahiKhataMonitoringService.getCacheStatstics());
    }

    /**
     * Techpert:Bahikhata : 0.0.1 :This method fetches the Memory statstics
     * 
     * @since 5 Oct 2019
     * @return JSON representation of {@link BahiKhataMemoryStatsticsDTO}
     * @throws BahiKhataStatsticsBeanException
     */
    @GetMapping(value = BahiKhataMonitoringConstants.MONITORING_ENDPOINT_MEMORY_STATISTICS, produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(value = "getMemoryStatstics", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE, notes = "The method fetches cache statistics", response = BahiKhataCacheStatisticsDTO.class, protocols = "https")
    @PreAuthorize(BahiKhataMonitoringConstants.ADMIN_WITH_WRITE_PERMISSION)
    @ApiResponses({ @ApiResponse(code = 200, message = "Successfully fetched memory statistics") })
    public ResponseEntity<BahiKhataMemoryStatsticsDTO> getMemoryStatstics()
            throws BahiKhataStatsticsBeanException
    {
        Message m = logger.traceEntry("getMemoryStatstics");
        return logger.traceExit(m, bahiKhataMonitoringService.getMemoryStatstics());
    }

    /**
     * Techpert:Bahikhata : 0.0.1 :This method fetches the Operating System statstics
     * 
     * @since 5 Oct 2019
     * @return JSON representation of {@link BahiKhataOperatingSystemStatisticsDTO}
     * @throws BahiKhataStatsticsBeanException
     */
    @GetMapping(value = BahiKhataMonitoringConstants.MONITORING_ENDPOINT_OPERATING_SYSTEM_STATISTICS, produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(value = "getOperatingSystemStatstics", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE, notes = "The method fetches cache statistics", response = BahiKhataCacheStatisticsDTO.class, protocols = "https")
    @PreAuthorize(BahiKhataMonitoringConstants.ADMIN_WITH_WRITE_PERMISSION)
    @ApiResponses({ @ApiResponse(code = 200, message = "Successfully fetched Operating System statistics") })
    public ResponseEntity<BahiKhataOperatingSystemStatisticsDTO> getOperatingSystemStatstics()
            throws BahiKhataStatsticsBeanException
    {
        Message m = logger.traceEntry("getOperatingSystemStatstics");
        return logger.traceExit(m, bahiKhataMonitoringService.getOperatingSystemStatstics());
    }
    
    /**
     * Techpert:Bahikhata : 0.0.1 :This method fetches the Runtime statstics
     * 
     * @since 5 Oct 2019
     * @return JSON representation of {@link BahiKhataRuntimeStatisticsDTO}
     * @throws BahiKhataStatsticsBeanException
     */
    @GetMapping(value = BahiKhataMonitoringConstants.MONITORING_ENDPOINT_RUNTIIME_STATISTICS, produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(value = "getRuntimeStatstics", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE, notes = "The method fetches cache statistics", response = BahiKhataCacheStatisticsDTO.class, protocols = "https")
    @PreAuthorize(BahiKhataMonitoringConstants.ADMIN_WITH_WRITE_PERMISSION)
    @ApiResponses({ @ApiResponse(code = 200, message = "Successfully fetched runtime statistics") })
    public ResponseEntity<BahiKhataRuntimeStatisticsDTO> getRuntimeStatstics()
            throws BahiKhataStatsticsBeanException
    {
        Message m = logger.traceEntry("getRuntimeStatstics");
        return logger.traceExit(m, bahiKhataMonitoringService.getRuntimeStatstics());
    }
}
