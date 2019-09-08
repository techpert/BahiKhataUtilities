package bahikhata.utilities.monitoring.exception.handler;

import org.apache.commons.lang.exception.ExceptionUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.message.Message;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import bahikhata.utilities.dto.BahiKhataErrorResponseDTO;
import bahikhata.utilities.monitoring.constants.BahiKhataMonitoringConstants;
import bahikhata.utilities.monitoring.controller.BahiKhataMonitoringController;
import bahikhata.utilities.monitoring.exception.BahiKhataStatsticsBeanException;
import bahikhata.utilities.responsejson.BahiKhataJsonResponseUtility;

@ControllerAdvice(basePackageClasses = BahiKhataMonitoringController.class)
public class BahiKhatMonitoringExceptionHandler
{
    Logger logger = LogManager.getLogger(BahiKhatMonitoringExceptionHandler.class);

    @ExceptionHandler(BahiKhataStatsticsBeanException.class)
    public ResponseEntity<String> handleBahiKhataStatsticsBeanException(
            BahiKhataStatsticsBeanException bahiKhataStatsticsBeanException)
    {
        Message m = logger.traceEntry("handleBahiKhataStatsticsBeanException");
        logger.error(
                "Internal Server Error occured: " + bahiKhataStatsticsBeanException.getMessage());
        logger.debug("Error occured : ");
        logger.debug(ExceptionUtils.getFullStackTrace(bahiKhataStatsticsBeanException));
        BahiKhataErrorResponseDTO bahiKhataErrorResponseDTO = new BahiKhataErrorResponseDTO();
        bahiKhataErrorResponseDTO.putError(BahiKhataMonitoringConstants.INTERNAL_SERVER_ERROR_KEY,
                BahiKhataMonitoringConstants.INTERNAL_SERVER_ERROR_VALUE);
        bahiKhataErrorResponseDTO.putError("Monitoring Error",
                bahiKhataStatsticsBeanException.getMessage());
        return logger.traceExit(m,
                new ResponseEntity<>(
                        BahiKhataJsonResponseUtility.generateErrorResponseJson(
                                bahiKhataErrorResponseDTO.getErrorList(),
                                BahiKhataMonitoringConstants.ERROR_KEY),
                        HttpStatus.INTERNAL_SERVER_ERROR));
    }
}
