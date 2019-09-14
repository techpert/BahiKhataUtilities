/**
 * copyright © 2019 Techpert It Solutions Private Limited
 */
package bahikhata.utilities.exception.handler;

import java.util.List;

import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;

import org.apache.commons.lang.exception.ExceptionUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.message.Message;
import org.hibernate.validator.internal.engine.path.PathImpl;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.web.HttpMediaTypeNotSupportedException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;

import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.JsonMappingException.Reference;
import com.fasterxml.jackson.databind.exc.InvalidFormatException;

import bahikhata.utilities.dto.BahiKhataErrorResponseDTO;
import bahikhata.utilities.responsejson.BahiKhataJsonResponseUtility;

/**
 * Techpert:Bahikhata : 0.0.1 :This class is used as an exceptionHandler class
 * for all common exceptions
 * 
 * @author Namit.Jain
 * @since 14-Sep-2019
 * @version 0.0.1
 */
@ControllerAdvice
public class BahiKhataExceptionHandler {
	/**
	 * Techpert:Bahikhata : 0.0.1 :Logger instance for
	 * BahiKhataExceptionHandler
	 */
	private static final Logger logger = LogManager.getLogger(BahiKhataExceptionHandler.class);

	/**
	 * Techpert:Bahikhata : 0.0.1 :This Method acts as an Exception handler response
	 * generator for {@link MethodArgumentTypeMismatchException}
	 * 
	 * @since 25-Aug-2019
	 * @param ex {@link MethodArgumentTypeMismatchException}
	 * @return ResponseEntity Error response
	 */
	@ExceptionHandler(MethodArgumentTypeMismatchException.class)
	@ResponseStatus(HttpStatus.BAD_REQUEST)
	public ResponseEntity<String> handleMethodArgumentTypeMismatchException(MethodArgumentTypeMismatchException ex) {
		Message m = logger.traceEntry("handleMethodArgumentTypeMismatchException");
		BahiKhataErrorResponseDTO bahiKhataErrorResponseDTO = new BahiKhataErrorResponseDTO();
		logger.debug(ExceptionUtils.getFullStackTrace(ex));
		bahiKhataErrorResponseDTO.putError(ex.getName(),
				ex.getName() + BahiKhataExceptionHandlerConstants.BAHIKHATA_NOT_SYNTACTICALLY_VALID_RESPONSE_MESSAGE);
		return logger.traceExit(m,
				new ResponseEntity<>(
						BahiKhataJsonResponseUtility.generateErrorResponseJson(bahiKhataErrorResponseDTO.getErrorList(),
								BahiKhataExceptionHandlerConstants.BAHIKHATA_ERROR_KEY),
						HttpStatus.BAD_REQUEST));
	}

	/**
	 * Techpert:Bahikhata : 0.0.1 :This Method acts as an Exception handler response
	 * generator for {@link ConstraintViolationException}
	 * 
	 * @since 25-Aug-2019
	 * @param ex {@link ConstraintViolationException}
	 * @return ResponseEntity Error response
	 */
	@ExceptionHandler(ConstraintViolationException.class)
	@ResponseStatus(HttpStatus.BAD_REQUEST)
	public ResponseEntity<Object> handleConstraintViolationException(ConstraintViolationException ex) {
		Message m = logger.traceEntry("handleConstraintViolationException");
		logger.debug(ExceptionUtils.getFullStackTrace(ex));
		BahiKhataErrorResponseDTO bahiKhataErrorResponseDTO = new BahiKhataErrorResponseDTO();
		for (ConstraintViolation<?> violation : ex.getConstraintViolations()) {
			logger.error(violation.getMessage());
			bahiKhataErrorResponseDTO.putError(((PathImpl) violation.getPropertyPath()).getLeafNode().getName(),
					violation.getMessage());
		}
		return logger.traceExit(m,
				new ResponseEntity<>(
						BahiKhataJsonResponseUtility.generateErrorResponseJson(bahiKhataErrorResponseDTO.getErrorList(),
								BahiKhataExceptionHandlerConstants.BAHIKHATA_ERROR_KEY),
						HttpStatus.BAD_REQUEST));
	}

	/**
	 * Techpert:Bahikhata : 0.0.1 :This Method acts as an Exception handler response
	 * generator for {@link MissingServletRequestParameterException}
	 * 
	 * @since 25-Aug-2019
	 * @param ex {@link MissingServletRequestParameterException}
	 * @return ResponseEntity Error response
	 */
	@ExceptionHandler(MissingServletRequestParameterException.class)
	@ResponseStatus(HttpStatus.BAD_REQUEST)
	public ResponseEntity<Object> handleMissingServletRequestParameterException(
			MissingServletRequestParameterException ex) {
		logger.debug(ExceptionUtils.getFullStackTrace(ex));
		Message m = logger.traceEntry("handleMissingServletRequestParameterException");
		BahiKhataErrorResponseDTO bahiKhataErrorResponseDTO = new BahiKhataErrorResponseDTO();
		bahiKhataErrorResponseDTO.putError(ex.getParameterName(), ex.getLocalizedMessage());
		return logger.traceExit(m,
				new ResponseEntity<>(
						BahiKhataJsonResponseUtility.generateErrorResponseJson(bahiKhataErrorResponseDTO.getErrorList(),
								BahiKhataExceptionHandlerConstants.BAHIKHATA_ERROR_KEY),
						HttpStatus.BAD_REQUEST));
	}

	/**
	 * Techpert:Bahikhata : 0.0.1 :This Method acts as an Exception handler response
	 * generator for {@link MethodArgumentNotValidException}
	 * 
	 * @since 25-Aug-2019
	 * @param ex {@link MethodArgumentNotValidException}
	 * @return ResponseEntity Error response
	 */
	@ExceptionHandler(MethodArgumentNotValidException.class)
	@ResponseStatus(HttpStatus.BAD_REQUEST)
	public ResponseEntity<Object> handleMethodArgumentNotValidException(MethodArgumentNotValidException ex) {
		Message m = logger.traceEntry("handleMethodArgumentNotValidException");
		logger.debug(ExceptionUtils.getFullStackTrace(ex));
		List<FieldError> fieldErrors = ex.getBindingResult().getFieldErrors();
		List<ObjectError> globalErrors = ex.getBindingResult().getGlobalErrors();
		BahiKhataErrorResponseDTO bahiKhataErrorResponseDTO = new BahiKhataErrorResponseDTO();
		for (FieldError fieldError : fieldErrors) {
			bahiKhataErrorResponseDTO.putError(fieldError.getField(), fieldError.getDefaultMessage());
		}
		for (ObjectError objectError : globalErrors) {
			bahiKhataErrorResponseDTO.putError(objectError.getObjectName(), objectError.getDefaultMessage());
		}
		return logger.traceExit(m,
				new ResponseEntity<>(
						BahiKhataJsonResponseUtility.generateErrorResponseJson(bahiKhataErrorResponseDTO.getErrorList(),
								BahiKhataExceptionHandlerConstants.BAHIKHATA_ERROR_KEY),
						HttpStatus.BAD_REQUEST));
	}

	/**
	 * Techpert:Bahikhata : 0.0.1 :This Method acts as an Exception handler response
	 * generator for {@link HttpMediaTypeNotSupportedException}
	 * 
	 * @since 25-Aug-2019
	 * @param ex {@link HttpMediaTypeNotSupportedException}
	 * @return ResponseEntity Error response
	 */
	@ExceptionHandler(HttpMediaTypeNotSupportedException.class)
	@ResponseStatus(HttpStatus.BAD_REQUEST)
	public ResponseEntity<Object> handleHttpMediaTypeNotSupportedException(HttpMediaTypeNotSupportedException ex) {
		Message m = logger.traceEntry("handleHttpMediaTypeNotSupportedException");
		logger.debug(ExceptionUtils.getFullStackTrace(ex));
		StringBuilder builder = new StringBuilder();
		builder.append("Unsupported content type: ").append(ex.getContentType()).append(".Supported content types: ")
				.append(MediaType.toString(ex.getSupportedMediaTypes()));
		BahiKhataErrorResponseDTO bahiKhataErrorResponseDTO = new BahiKhataErrorResponseDTO();
		bahiKhataErrorResponseDTO.putError(
				BahiKhataExceptionHandlerConstants.BAHIKHATA_UNSUPPORTED_CONTENT_TYPE_RESPONSE_KEY, builder.toString());
		return logger.traceExit(m,
				new ResponseEntity<>(
						BahiKhataJsonResponseUtility.generateErrorResponseJson(bahiKhataErrorResponseDTO.getErrorList(),
								BahiKhataExceptionHandlerConstants.BAHIKHATA_ERROR_KEY),
						HttpStatus.BAD_REQUEST));
	}

	/**
	 * Techpert:Bahikhata : 0.0.1 :This Method acts as an Exception handler response
	 * generator for {@link HttpMessageNotReadableException},
	 * {@link InvalidFormatException} and {@link JsonMappingException}
	 * 
	 * @since 25-Aug-2019
	 * @param ex {@link HttpMessageNotReadableException}
	 * @return ResponseEntity Error response
	 */
	@ExceptionHandler(HttpMessageNotReadableException.class)
	@ResponseStatus(HttpStatus.BAD_REQUEST)
	public ResponseEntity<Object> handleHttpMessageNotReadableException(HttpMessageNotReadableException ex) {
		Message m = logger.traceEntry("handleHttpMessageNotReadableException");
		Throwable throwable = ex.getCause();
		BahiKhataErrorResponseDTO bahiKhataErrorResponseDTO = new BahiKhataErrorResponseDTO();
		if (throwable instanceof InvalidFormatException) {
			InvalidFormatException invalidFormatException = (InvalidFormatException) throwable;
			logger.debug(ExceptionUtils.getFullStackTrace(invalidFormatException));
			List<Reference> list = invalidFormatException.getPath();
			if (!list.isEmpty()) {
				String errorFieldName = list.get(list.size() - 1).getFieldName();
				bahiKhataErrorResponseDTO.putError(errorFieldName, errorFieldName + BahiKhataExceptionHandlerConstants.BAHIKHATA_NOT_SYNTACTICALLY_VALID_RESPONSE_MESSAGE);
			}
		} else if (throwable instanceof JsonMappingException) {
			JsonMappingException jsonMappingException = (JsonMappingException) throwable;
			logger.debug(ExceptionUtils.getFullStackTrace(jsonMappingException));
			List<Reference> list = jsonMappingException.getPath();
			if (!list.isEmpty()) {
				String errorFieldName = list.get(list.size() - 1).getFieldName();
				bahiKhataErrorResponseDTO.putError(errorFieldName, jsonMappingException.getOriginalMessage());
			}
		}

		if (bahiKhataErrorResponseDTO.getErrorList().isEmpty()) {
			logger.debug(ExceptionUtils.getFullStackTrace(ex));
			if (ex.getMessage().contains("Required request body is missing:")) {
				bahiKhataErrorResponseDTO.putError(
						BahiKhataExceptionHandlerConstants.BAHIKHATA_REQUEST_BODY_EXCEPTION_RESPONSE_KEY,
						BahiKhataExceptionHandlerConstants.BAHIKHATA_MISSING_REQUEST_BODY_RESPONSE_MESSAGE);
			} else {
				bahiKhataErrorResponseDTO.putError(
						BahiKhataExceptionHandlerConstants.BAHIKHATA_REQUEST_BODY_EXCEPTION_RESPONSE_KEY,
						BahiKhataExceptionHandlerConstants.BAHIKHATA_INVALID_REQUEST_BODY_RESPONSE_KEY);
			}
		}
		return logger.traceExit(m,
				new ResponseEntity<>(
						BahiKhataJsonResponseUtility.generateErrorResponseJson(bahiKhataErrorResponseDTO.getErrorList(),
								BahiKhataExceptionHandlerConstants.BAHIKHATA_ERROR_KEY),
						HttpStatus.BAD_REQUEST));
	}

}
