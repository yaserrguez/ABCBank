/*
 * Copyright (c) 2022. DATYS, Tecnología y Servicios.
 * SRNT Sistema de Registro Nacional de Tramites
 * Todos los derechos reservados.
 * www.datys.co.cu
 *
 * LastUpdate: 3/29/22, 12:24 PM.
 *
 */

package ABCBankService.com.group.bestvision.yrm.test.exception;

import ABCBankService.com.group.bestvision.yrm.test.response.ErrorResponse;
import ABCBankService.com.group.bestvision.yrm.test.response.ResponseUtil;
import lombok.extern.slf4j.Slf4j;
import org.hibernate.exception.JDBCConnectionException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.ConversionFailedException;
import org.springframework.core.env.Environment;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.OptimisticLockingFailureException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.orm.ObjectOptimisticLockingFailureException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.lang.reflect.InvocationTargetException;

/**
 * REST exception handlers defined at a global level for the application
 */
@ControllerAdvice
@RestController
@Slf4j
public class RestResponseEntityExceptionHandler extends ResponseEntityExceptionHandler
{
    @Autowired
    private Environment env;

    @Autowired
    private ResponseUtil responseUtil;

    @SuppressWarnings({ "rawtypes", "unchecked" })
    @ExceptionHandler(ResourceNotFoundException.class)
    public final ResponseEntity handleNotFountExceptions(Exception ex)
    {
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new ErrorResponse(HttpStatus.NOT_FOUND, ex.getMessage()));
    }

    @SuppressWarnings({ "rawtypes", "unchecked" })
    @ExceptionHandler(ResourceValidationException.class)
    public final ResponseEntity handleValidationExceptions(Exception ex)
    {
        return ResponseEntity.status(HttpStatus.PRECONDITION_FAILED).body(new ErrorResponse(HttpStatus.PRECONDITION_FAILED, ex.getMessage()));
    }

    @SuppressWarnings({ "rawtypes", "unchecked" })
    @ExceptionHandler(ResourceInternalException.class)
    public final ResponseEntity handleInternalExceptions(Exception ex)
    {
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(new ErrorResponse(HttpStatus.INTERNAL_SERVER_ERROR, ex.getMessage()));
    }

    @ExceptionHandler({InvocationTargetException.class,
            IllegalArgumentException.class,
            ClassCastException.class,
            ConversionFailedException.class})
    public ResponseEntity handleMiscFailures(Throwable t) {
        log.error(t.getMessage());
        return responseUtil.badRequestResponse(t.getMessage());
    }

    /**
     * Send a 409 Conflict in case of concurrent modification
     */
    @ExceptionHandler({ObjectOptimisticLockingFailureException.class,
            OptimisticLockingFailureException.class,
            DataIntegrityViolationException.class})
    public ResponseEntity handleConflict(Exception ex) {
        log.error(ex.getMessage());
        return responseUtil.conflictResponse(ex.getMessage());
    }

    @ExceptionHandler({JDBCConnectionException.class})
    public ResponseEntity jDBCConnectionException(Exception ex) {
        log.error(ex.getMessage());
        return responseUtil.internalErrorResponse(ex.getMessage());
    }

    @ExceptionHandler({Exception.class})
    public ResponseEntity<?> handleAnyException(Exception e) {
        log.error(e.getMessage());
        return responseUtil.internalErrorResponse(e.getMessage());
    }
}
