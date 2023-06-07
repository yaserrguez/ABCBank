package ABCBankService.com.group.bestvision.yrm.test.controller.impl;

import ABCBankService.com.group.bestvision.yrm.test.response.CustomResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.net.URI;

@Slf4j
public abstract class BaseController<T>
{

    // 200 ************************************

    public ResponseEntity okResponse()
    {
        return ResponseEntity.ok(CustomResponse.ok());

    }
    public ResponseEntity okResponse(Object entity)
    {
        return ResponseEntity.ok(CustomResponse.ok(entity));
    }

    // 201 ***********************************

    public ResponseEntity createdResponse()
    {
        return ResponseEntity.status(HttpStatus.CREATED).body(CustomResponse.created());
    }
    public ResponseEntity createdResponse(URI location)
    {
        return ResponseEntity.created(location).body(CustomResponse.created());
    }
    public ResponseEntity createdResponse(Object entity)
    {
        return ResponseEntity.status(HttpStatus.CREATED).body(CustomResponse.created(entity));
    }
    public ResponseEntity createdResponse(URI location, Object entity)
    {
        return ResponseEntity.created(location).body(CustomResponse.created(entity));
    }

    // 204 **********************************

    public ResponseEntity noContentResponse()
    {
        return ResponseEntity.status(HttpStatus.NO_CONTENT).body(CustomResponse.noContent());
    }

    // 206 **********************************

    public ResponseEntity partialContentResponse(Object entity)
    {
        return ResponseEntity.status(HttpStatus.PARTIAL_CONTENT).body(CustomResponse.partialContent(entity));
    }

    // 400 **********************************

    public ResponseEntity badRequestResponse()
    {
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(CustomResponse.badRequest());
    }
    public ResponseEntity badRequestResponse(Object entity)
    {
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(CustomResponse.badRequest(entity.toString()));
    }

    // 401 **********************************

    public ResponseEntity unauthorizedResponse()
    {
        return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(CustomResponse.unauthorized());
    }
    public ResponseEntity unauthorizedResponse(Object entity)
    {
        return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(CustomResponse.unauthorized(entity.toString()));
    }

    // 404 **********************************

    public ResponseEntity notFoundResponse()
    {
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(CustomResponse.notFound());
    }
    public ResponseEntity notFoundResponse(Object entity)
    {
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(CustomResponse.notFound(entity.toString()));
    }

    // 409 **********************************

    public ResponseEntity conflictResponse()
    {
        return ResponseEntity.status(HttpStatus.CONFLICT).body(CustomResponse.conflict());
    }
    public ResponseEntity conflictResponse(Object entity)
    {
        return ResponseEntity.status(HttpStatus.CONFLICT).body(CustomResponse.conflict(entity.toString()));
    }

    // 412 **********************************

    public ResponseEntity preconditionFailedResponse()
    {
        return ResponseEntity.status(HttpStatus.PRECONDITION_FAILED).body(CustomResponse.preconditionFailed());
    }
    public ResponseEntity preconditionFailedResponse(Object entity)
    {
        return ResponseEntity.status(HttpStatus.PRECONDITION_FAILED).body(CustomResponse.preconditionFailed(entity.toString()));
    }

    // 500 **********************************

    public ResponseEntity internalErrorResponse()
    {
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(CustomResponse.internalServerError());
    }
    public ResponseEntity internalErrorResponse(Object entity)
    {
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(CustomResponse.internalServerError(entity.toString()));
    }
}
