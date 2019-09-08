/**
 * copyright © 2019 Techpert It Solutions Private Limited
 */
package bahikhata.utilities.monitoring.exception;

import org.springframework.http.HttpStatus;

import bahikhata.utilities.dto.BahiKhataErrorResponseDTO;


/**
 * Techpert:Bahikhata : 0.0.1 :This class is used as an exception class for
 * BahiKhataAddressValidation
 * 
 * @author Neeraj Jain
 * @since 8 Sep 2019
 * @version 1.0
 */
public class BahiKhataStatsticsBeanException extends Exception
{

    /**
     * 
     */
    private final BahiKhataErrorResponseDTO bahiKhataErrorResponseDTO;
    private final HttpStatus httpStatus;

    public BahiKhataStatsticsBeanException(final BahiKhataErrorResponseDTO bahiKhataErrorResponseDTO,
            final HttpStatus httpStatus) {
    super(bahiKhataErrorResponseDTO.getErrorList().toString());
    this.bahiKhataErrorResponseDTO = bahiKhataErrorResponseDTO;
    this.httpStatus = httpStatus;
}

    /**
     * @param message
     */
    public BahiKhataStatsticsBeanException(String message)
    {
        super(message);
        bahiKhataErrorResponseDTO=null;
        httpStatus=null;
    }

    /**
     * @param cause
     */
    public BahiKhataStatsticsBeanException(Throwable cause)
    {
        super(cause);
        bahiKhataErrorResponseDTO=null;
        httpStatus=null;
    }

    /**
     * @param message
     * @param cause
     */
    public BahiKhataStatsticsBeanException(String message, Throwable cause)
    {
        super(message, cause);
        bahiKhataErrorResponseDTO=null;
        httpStatus=null;
    }

    /**
     * @param message
     * @param cause
     * @param enableSuppression
     * @param writableStackTrace
     */
    public BahiKhataStatsticsBeanException(String message, Throwable cause,
            boolean enableSuppression, boolean writableStackTrace)
    {
        super(message, cause, enableSuppression, writableStackTrace);
        bahiKhataErrorResponseDTO=null;
        httpStatus=null;
    }
}
