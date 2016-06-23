package com.hellowd.cms.controller;

import com.hellowd.cms.exception.BadRequestException;
import com.hellowd.cms.exception.ConflictException;
import com.hellowd.cms.exception.ForbiddenException;
import com.hellowd.cms.exception.NotFoundException;
import com.hellowd.cms.exception.PasswordInvalidException;
import com.hellowd.cms.exception.RequestEntityTooLargeException;
import com.hellowd.cms.exception.UnauthorizedException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.ConversionNotSupportedException;
import org.springframework.beans.TypeMismatchException;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.http.converter.HttpMessageNotWritableException;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindException;
import org.springframework.web.HttpMediaTypeNotAcceptableException;
import org.springframework.web.HttpMediaTypeNotSupportedException;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.support.MissingServletRequestPartException;
import org.springframework.web.servlet.mvc.multiaction.NoSuchRequestHandlingMethodException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * @author SangHoon, Lee(devsh@helloworlds.co.kr)
 */
@Controller
@RequestMapping("/")
public class RootController {

	private Logger logger = LoggerFactory.getLogger(getClass());

	@ExceptionHandler(Exception.class)
	public Map<String, Object> handleException(Exception e, HttpServletRequest req, HttpServletResponse resp) {
		Map<String, Object> fault = new LinkedHashMap<String, Object>(4);

		int errorStatusCode = 500;
		if (e instanceof BadRequestException) {
			fault.put("faultcode", "Client");
			fault.put("faultstring", "400 Bad Request");
			errorStatusCode = HttpServletResponse.SC_BAD_REQUEST;
		} else if (e instanceof UnauthorizedException) {
			fault.put("faultcode", "Client");
			fault.put("faultstring", "401 Unauthorized");
			errorStatusCode = HttpServletResponse.SC_UNAUTHORIZED;
		} else if (e instanceof ForbiddenException) {
			fault.put("faultcode", "Client");
			fault.put("faultstring", "403 Forbidden");
			errorStatusCode = HttpServletResponse.SC_FORBIDDEN;
		} else if (e instanceof NotFoundException) {
			fault.put("faultcode", "Client");
			fault.put("faultstring", "404 Not Found");
			errorStatusCode = HttpServletResponse.SC_NOT_FOUND;
		} else if (e instanceof ConflictException) {
			fault.put("faultcode", "Client");
			fault.put("faultstring", "409 Conflict");
			errorStatusCode = HttpServletResponse.SC_CONFLICT;
		} else if (e instanceof RequestEntityTooLargeException) {
			fault.put("faultcode", "Client");
			fault.put("faultstring", "413 Request Entity Too Large");
			errorStatusCode = HttpServletResponse.SC_REQUEST_ENTITY_TOO_LARGE;
		} else if (e instanceof BindException) {
			fault.put("faultcode", "Client");
			fault.put("faultstring", "400 Bad Request");
			errorStatusCode = HttpServletResponse.SC_BAD_REQUEST;
		} else if (e instanceof MethodArgumentNotValidException) {
			fault.put("faultcode", "Client");
			fault.put("faultstring", "400 Bad Request");
			errorStatusCode = HttpServletResponse.SC_BAD_REQUEST;
		} else if (e instanceof MissingServletRequestParameterException) {
			fault.put("faultcode", "Client");
			fault.put("faultstring", "400 Bad Request");
			errorStatusCode = HttpServletResponse.SC_BAD_REQUEST;
		} else if (e instanceof MissingServletRequestPartException) {
			fault.put("faultcode", "Client");
			fault.put("faultstring", "400 Bad Request");
			errorStatusCode = HttpServletResponse.SC_BAD_REQUEST;
		} else if (e instanceof HttpMessageNotReadableException) {
			fault.put("faultcode", "Client");
			fault.put("faultstring", "400 Bad Request");
			errorStatusCode = HttpServletResponse.SC_BAD_REQUEST;
		} else if (e instanceof TypeMismatchException) {
			fault.put("faultcode", "Client");
			fault.put("faultstring", "400 Bad Request");
			errorStatusCode = HttpServletResponse.SC_BAD_REQUEST;
		} else if (e instanceof NoSuchRequestHandlingMethodException) {
			fault.put("faultcode", "Client");
			fault.put("faultstring", "404 Not Found");
			errorStatusCode = HttpServletResponse.SC_NOT_FOUND;
		} else if (e instanceof HttpRequestMethodNotSupportedException) {
			fault.put("faultcode", "Client");
			fault.put("faultstring", "405 Method Not Allowed");
			errorStatusCode = HttpServletResponse.SC_METHOD_NOT_ALLOWED;
		} else if (e instanceof HttpMediaTypeNotAcceptableException) {
			fault.put("faultcode", "Client");
			fault.put("faultstring", "406 Not Acceptable");
			errorStatusCode = HttpServletResponse.SC_NOT_ACCEPTABLE;
		} else if (e instanceof PasswordInvalidException) {
			fault.put("faultcode", "Server");
			fault.put("faultstring", "412 Precondition Failed");
			errorStatusCode = HttpServletResponse.SC_PRECONDITION_FAILED;
		} else if (e instanceof HttpMediaTypeNotSupportedException) {
			fault.put("faultcode", "Client");
			fault.put("faultstring", "415 Unsupported Media Type");
			errorStatusCode = HttpServletResponse.SC_UNSUPPORTED_MEDIA_TYPE;
		} else if (e instanceof ConversionNotSupportedException) {
			fault.put("faultcode", "Server");
			fault.put("faultstring", "500 Internal Server Error");
			errorStatusCode = HttpServletResponse.SC_INTERNAL_SERVER_ERROR;
		} else if (e instanceof HttpMessageNotWritableException) {
			fault.put("faultcode", "Server");
			fault.put("faultstring", "500 Internal Server Error");
			errorStatusCode = HttpServletResponse.SC_INTERNAL_SERVER_ERROR;
		} else {
			fault.put("faultcode", "Server");
			fault.put("faultstring", "500 Internal Server Error");
			errorStatusCode = HttpServletResponse.SC_INTERNAL_SERVER_ERROR;
		}

		try {
			fault.put("faultactor", req.getRequestURI());

			Map<String, String> detail = new LinkedHashMap<String, String>(2);
			detail.put("message", e.getMessage());
			detail.put("stacktrace", getStackTrace(e));

			fault.put("detail", detail);

			resp.sendError(errorStatusCode, fault.toString());

		} catch (Exception ex) {
			logger.error("Error at HttpServletResponse.sendError(" + errorStatusCode + ")", ex);
		}
		return fault;

	}

	private String getStackTrace(Throwable thrown) {
		StringWriter sw = new StringWriter();
		thrown.printStackTrace(new PrintWriter(sw));
		return sw.toString();
	}

}
