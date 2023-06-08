/*
 * Copyright (c) 2023.  Yaser Rodriguez
 * yaser.rguez@gmail.com
 * LastUpdate: 6/7/23, 9:18 PM
 *
 */

package ABCBankService.com.group.bestvision.yrm.test.response;

import ABCBankService.com.group.bestvision.yrm.test.utils.DateUtils;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.http.HttpStatus;

@Data
@AllArgsConstructor
@NoArgsConstructor
@JsonInclude( JsonInclude.Include.NON_NULL )
@JsonIgnoreProperties( ignoreUnknown = true )
public class CustomResponse<T>
{
	/**
     * Estado de la respuesta
     *
     */
    private HttpStatus status;
	/**
     * Objeto de respuesta
     *
     */
    private T payload;
	/**
     * Error ocurrido
     *
     */
    private Object errors;
	/**
     * Informacion adicional
     *
     */
    private Object metadata;

    // 200 ************************************

    /**
     * Respuesta correcta 200, operacion exitosa, sin contenido de rotorno.
     *
     * @return the custom response
     */
    public static CustomResponse ok()
    {
        CustomResponse response = new CustomResponse();
        response.status = HttpStatus.OK;
        return response;
    }

    /**
     * Respuesta correcta 200, operacion exitosa, con contenido de rotorno.
     *
     * @param <T>  Tipo de dato
     * @param data Informacion a retornar
     * @return the custom response
     */
    public static <T> CustomResponse ok(T data)
    {
        CustomResponse<T> response = new CustomResponse<>();
        response.status = HttpStatus.OK;
        response.payload = data;
        return response;
    }

    // 201 ***********************************

    /**
     * Respuesta correcta 201, creacion exitosa, sin contenido de rotorno.
     *
     * @return the custom response
     */
    public static CustomResponse created()
    {
        CustomResponse response = new CustomResponse();
        response.status = HttpStatus.CREATED;
        return response;
    }

    /**
     * Respuesta correcta 201, creacion exitosa, con contenido de rotorno.
     *
     * @param <T>  Tipo de dato
     * @param data Informacion a retornar
     * @return the custom response
     */
    public static <T> CustomResponse created(T data)
    {
        CustomResponse<T> response = new CustomResponse<>();
        response.status = HttpStatus.CREATED;
        response.payload = data;
        return response;
    }

    // 204 **********************************

    /**
     * Respuesta correcta 204, operacion exitosa, nada que rotornar.
     *
     * @return the custom response
     */
    public static CustomResponse noContent()
    {
        CustomResponse response = new CustomResponse();
        response.status = HttpStatus.NO_CONTENT;
        return response;
    }

    // 206 **********************************

    /**
     * Respuesta correcta 206, operacion exitosa, el contenido es una parte del retorno.
     *
     * @param <T>  Tipo de dato
     * @param data Informacion a retornar
     * @return the custom response
     */
    public static <T> CustomResponse partialContent(T data)
    {
        CustomResponse response = new CustomResponse();
        response.status = HttpStatus.PARTIAL_CONTENT;
        response.payload = data;
        return response;
    }

    // 400 **********************************

    /**
     * Respuesta incorrecta 400, peticion incorrecta.
     *
     * @return the custom response
     */
    public static CustomResponse badRequest()
    {
        CustomResponse response = new CustomResponse();
        response.status = HttpStatus.BAD_REQUEST;
        return response;
    }

    /**
     * Respuesta incorrecta 400, peticion incorrecta, con detalles del error.
     *
     * @param <T>  Tipo de dato
     * @param details Informacion a retornar
     * @return the custom response
     */
    public static <T> CustomResponse badRequest(String details)
    {
        CustomResponse response = new CustomResponse();
        response.status = HttpStatus.BAD_REQUEST;
        response.errors = ErrorResponse.builder()
                .message(HttpStatus.BAD_REQUEST.getReasonPhrase())
                .details(details)
                .timestamp(DateUtils.today())
                .build();
        return response;
    }

    // 401 **********************************

    /**
     * Respuesta incorrecta 401, peticion no autorizada.
     *
     * @return the custom response
     */
    public static CustomResponse unauthorized()
    {
        CustomResponse response = new CustomResponse();
        response.status = HttpStatus.UNAUTHORIZED;
        return response;
    }

    /**
     * Respuesta incorrecta 401, peticion no autorizada, con detalles del error.
     *
     * @param details Informacion a retornar
     * @return the custom response
     */
    public static CustomResponse unauthorized(String details)
    {
        CustomResponse response = new CustomResponse();
        response.status = HttpStatus.UNAUTHORIZED;
        response.errors = ErrorResponse.builder()
                .message(HttpStatus.UNAUTHORIZED.getReasonPhrase())
                .details(details)
                .timestamp(DateUtils.today())
                .build();
        return response;
    }

    // 404 **********************************

    /**
     * Respuesta incorrecta 404, peticion no encontrada.
     *
     * @return the custom response
     */
    public static CustomResponse notFound()
    {
        CustomResponse response = new CustomResponse();
        response.status = HttpStatus.NOT_FOUND;
        response.errors = ErrorResponse.builder()
                .message(HttpStatus.NOT_FOUND.getReasonPhrase())
                .details(HttpStatus.NOT_FOUND.getReasonPhrase())
                .build();
        return response;
    }

    /**
     * Respuesta incorrecta 404, peticion no encontrada, con detalles del error.
     *
     * @param details Informacion a retornar
     * @return the custom response
     */
    public static CustomResponse notFound(String details)
    {
        CustomResponse response = new CustomResponse();
        response.status = HttpStatus.NOT_FOUND;
        response.errors = ErrorResponse.builder()
                .message(HttpStatus.NOT_FOUND.getReasonPhrase())
                .details(details)
                .timestamp(DateUtils.today())
                .build();
        return response;
    }

    // 409 **********************************

    /**
     * Respuesta incorrecta 409, existe conflicto.
     *
     * @return the custom response
     */
    public static CustomResponse conflict()
    {
        CustomResponse response = new CustomResponse();
        response.status = HttpStatus.CONFLICT;
        return response;
    }

    /**
     * Respuesta incorrecta 409, existe conflicto, con detalles del error.
     *
     * @param details Informacion a retornar
     * @return the custom response
     */
    public static CustomResponse conflict(String details)
    {
        CustomResponse response = new CustomResponse();
        response.status = HttpStatus.CONFLICT;
        response.errors = ErrorResponse.builder()
                .message(HttpStatus.CONFLICT.getReasonPhrase())
                .details(details)
                .timestamp(DateUtils.today())
                .build();
        return response;
    }

    // 412 **********************************

    /**
     * Respuesta incorrecta 412, no se cumplre alguna precondicion, con detalles del error.
     *
     * @return the custom response
     */
    public static CustomResponse preconditionFailed()
    {
        CustomResponse response = new CustomResponse();
        response.status = HttpStatus.PRECONDITION_FAILED;
        return response;
    }

    /**
     * Respuesta incorrecta 412, no se cumplre alguna precondicion, con detalles del error.
     *
     * @param details Informacion a retornar
     * @return the custom response
     */
    public static CustomResponse preconditionFailed(String details)
    {
        CustomResponse response = new CustomResponse();
        response.status = HttpStatus.PRECONDITION_FAILED;
        response.errors = ErrorResponse.builder()
                .message(HttpStatus.PRECONDITION_FAILED.getReasonPhrase())
                .details(details)
                .timestamp(DateUtils.today())
                .build();
        return response;
    }

    // 500 **********************************

    /**
     * Respuesta incorrecta 500, error interno.
     *
     * @return the custom response
     */
    public static CustomResponse internalServerError()
    {
        CustomResponse response = new CustomResponse();
        response.status = HttpStatus.INTERNAL_SERVER_ERROR;
        response.errors = ErrorResponse.builder()
                .message(HttpStatus.INTERNAL_SERVER_ERROR.getReasonPhrase())
                .details("UNKNOWN")
                .timestamp(DateUtils.today())
                .build();
        return response;
    }

    /**
     * Respuesta incorrecta 500, error interno, con detalles del error.
     *
     * @param details the details
     * @return the custom response
     */
    public static CustomResponse internalServerError(String details)
    {
        CustomResponse response = new CustomResponse();
        response.status = HttpStatus.INTERNAL_SERVER_ERROR;
        response.errors = ErrorResponse.builder()
                .message(HttpStatus.INTERNAL_SERVER_ERROR.getReasonPhrase())
                .details(details)
                .timestamp(DateUtils.today())
                .build();
        return response;
    }
}
