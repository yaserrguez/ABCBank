/*
 * Copyright (c) 2022. DATYS, Tecnología y Servicios.
 * SRNT Sistema de Registro Nacional de Tramites
 * Todos los derechos reservados.
 * www.datys.co.cu
 *
 * LastUpdate: 5/27/22, 10:38 AM.
 *
 */

package ABCBankService.com.group.bestvision.yrm.test.response;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

import java.net.URI;


@Component
@Qualifier("responseUtil")
public class ResponseUtil
{
//    protected static final ResponseEntity NO_DATA_TO_PROCESS_RESPONSE = Response.status(Response.Status.BAD_REQUEST)
//                                                                          .entity(new ErrorResponse(
//                                                                                  Response.Status.BAD_REQUEST
//                                                                                          .getStatusCode(),
//                                                                                  Response.Status.BAD_REQUEST
//                                                                                          .getReasonPhrase(),
//                                                                                  "No hay datos que procesar."))
//                                                                          .build();
//    protected static final Response NO_CONTENT_RESPONSE = Response.noContent().build();
//    protected static final Response OK_RESPONSE = Response.ok().build();
//    protected static final Response UNAUTHORIZED_RESPONSE = Response.status(Response.Status.UNAUTHORIZED).build();
//    protected static final Response NOT_PRIVILEGES = Response.status(Response.Status.FORBIDDEN).build();

    // === 2xx ======

    /**
     * Ok.
     * <p>
     * Peticion correcta, codigo de retorno 200.
     *
     * @param entity Respuesta
     * @return the response
     */
    public ResponseEntity okResponse(Object entity)
    {
        if (entity == null)
        {
            return ResponseEntity.ok().build();
        }

        return ResponseEntity.ok(entity);
    }

    /**
     * Ok.
     * <p>
     * Peticion correcta, codigo de retorno 200.
     *
     * @return the response
     */
    public ResponseEntity okResponse()
    {
        return ResponseEntity.ok().build();
    }

    public ResponseEntity createdResponse(URI location)
    {
        return ResponseEntity.created(location).build();
    }

    public ResponseEntity createdResponse(Object entity)
    {
        return ResponseEntity.status(HttpStatus.CREATED).body(entity);
    }

    public ResponseEntity createdResponse(URI location, Object entity)
    {
        return ResponseEntity.created(location).body(entity);
    }

    /**
     * No hay contenido que retornar.
     * <p>
     * Peticion correcta, codigo de retorno 204.
     *
     * @return the response
     */
    public ResponseEntity noContentResponse()
    {
        return ResponseEntity.noContent().build();
    }

    public ResponseEntity noContentResponse(String enity, String field, String value)
    {
        return ResponseEntity.status(HttpStatus.NO_CONTENT).body(new ErrorResponse(HttpStatus.NOT_FOUND,
                String.format("No se a encontrado %s con %s '%s'", enity, field, value)));
    }

    public ResponseEntity noContentResponse(String m)
    {
        return ResponseEntity.status(HttpStatus.NO_CONTENT).body(new ErrorResponse(HttpStatus.NOT_FOUND,
                m));
    }

    /**
     * Ok.
     * <p>
     * Peticion correcta, codigo de retorno 206.
     *
     * @param entity Respuesta
     * @return the response
     */
    public ResponseEntity partialContentResponse(Object entity)
    {
        if (entity == null)
        {
            return ResponseEntity.ok().build();
        }

        return ResponseEntity.status(HttpStatus.PARTIAL_CONTENT).body(entity);
    }
//
//    //=== 3xx ======
//
//    //=== 4xx ======
//
    /**
     * No hay datos que procesar.
     * <p>
     * Errores del cliente, codigo de retorno 400.
     *
     * @return the response
     */
    public ResponseEntity badRequestResponse()
    {
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new ErrorResponse(HttpStatus.BAD_REQUEST.value(),
                "Bad Request"));
    }

    public ResponseEntity badRequestResponse(String details)
    {
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new ErrorResponse(HttpStatus.BAD_REQUEST.value(),
                "Bad Request", details));
    }


    public ResponseEntity noData2ProcessResponse()
    {
        return ResponseEntity.unprocessableEntity().body(new ErrorResponse(HttpStatus.UNPROCESSABLE_ENTITY));
    }

    /**
     * Error de autenticacion.
     * <p>
     * Errores del cliente, codigo de retorno 401.
     *
     * @return the response
     */
    public ResponseEntity unauthorizedResponse()
    {
        return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(new ErrorResponse(HttpStatus.UNAUTHORIZED.value(),
                "Credenciales invalidas"));
    }

    public ResponseEntity unauthorizedResponse(String details)
    {
        return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(new ErrorResponse(HttpStatus.UNAUTHORIZED.value(),
                "Credenciales invalidas",
                details));
    }


    /**
     * Error de autenticacion por Token.
     * <p>
     * Errores del cliente, codigo de retorno 401.
     *
     * @param details Detalles
     * @return the response
     */
    public ResponseEntity unauthorizedTokenResponse(String details)
    {
        return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(new ErrorResponse(HttpStatus.UNAUTHORIZED.value(), "El token es inválido",
                details));
    }

    /**
     * No tiene suficientes privilegios.
     * <p>
     * Errores del cliente, codigo de retorno 403.
     *
     * @return the response
     */
    public ResponseEntity insufficientPrivilegesResponse()
    {
        return ResponseEntity.status(HttpStatus.FORBIDDEN).body(new ErrorResponse(HttpStatus.FORBIDDEN));
    }

    /**
     * No tiene suficientes privilegios.
     * <p>
     * Errores del cliente, codigo de retorno 403.
     *
     * @return the response
     */
    public ResponseEntity insufficientPrivilegesResponse(String details)
    {
        return ResponseEntity.status(HttpStatus.FORBIDDEN).body(new ErrorResponse(HttpStatus.FORBIDDEN.value(), "Insuficientes privilegios",
                details));
    }

    public ResponseEntity notFoundResponse()
    {
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new ErrorResponse(HttpStatus.NOT_FOUND));
    }

    public ResponseEntity notFoundResponse(String enity, String field, String value)
    {
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new ErrorResponse(HttpStatus.NOT_FOUND,
                String.format("No se a encontrado %s con %s '%s'", enity, field, value)));
    }

    public ResponseEntity notFoundResponse(String message)
    {
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new ErrorResponse(HttpStatus.NOT_FOUND,message));
    }

    /**
     * No se cumple alguna precondition.
     * <p>
     * Error del cliente, codigo de retorno 412.
     *
     * @param details Detalles de la condicion que falla
     * @return the response
     */
    public ResponseEntity preconditionFailResponse(String details)
    {
        return ResponseEntity.status(HttpStatus.PRECONDITION_FAILED).
                body(new ErrorResponse(HttpStatus.PRECONDITION_FAILED, details));
    }
//
//    /**
//     * No se cumple alguna precondition.
//     * <p>
//     * Error del cliente, codigo de retorno 412.
//     *
//     * @return the response
//     */
    public ResponseEntity preconditionFailResponse()
    {
        return ResponseEntity.status(HttpStatus.PRECONDITION_FAILED)
                       .body(new ErrorResponse(HttpStatus.PRECONDITION_FAILED, HttpStatus.PRECONDITION_FAILED.getReasonPhrase()));
    }

    public ResponseEntity rangeNotSatisfiableResponse()
    {
        return ResponseEntity.status(HttpStatus.REQUESTED_RANGE_NOT_SATISFIABLE)
                .body(new ErrorResponse(HttpStatus.REQUESTED_RANGE_NOT_SATISFIABLE, HttpStatus.REQUESTED_RANGE_NOT_SATISFIABLE.getReasonPhrase()));
    }

    public ResponseEntity rangeNotSatisfiableResponse(String details)
    {
        return ResponseEntity.status(HttpStatus.REQUESTED_RANGE_NOT_SATISFIABLE)
                .body(new ErrorResponse(HttpStatus.REQUESTED_RANGE_NOT_SATISFIABLE, details));
    }

    public ResponseEntity conflictResponse(String details)
    {
        return ResponseEntity.status(HttpStatus.CONFLICT)
                .body(new ErrorResponse(HttpStatus.CONFLICT, details));
    }



//
//    //=== 5xx ======
//
    /**
     * Error interno.
     * <p>
     * Error del servidor, codigo de retorno 500.
     *
     * @param error Error
     * @return the response
     */
    public ResponseEntity internalErrorResponse(Exception error)
    {
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(new ErrorResponse(HttpStatus.INTERNAL_SERVER_ERROR, error.getMessage()));
    }

    /**
     * Error interno.
     * <p>
     * Error del servidor, codigo de retorno 500.
     *
     * @param error Error
     * @return the response
     */
    public ResponseEntity internalErrorResponse(String error)
    {
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(new ErrorResponse(HttpStatus.INTERNAL_SERVER_ERROR, error));
    }

    /**
     * Error interno.
     * <p>
     * Error del servidor, codigo de retorno 500.
     *
     * @return the response
     */
    public ResponseEntity internalErrorResponse()
    {
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(new ErrorResponse(HttpStatus.INTERNAL_SERVER_ERROR));
    }
//
//    /**
//     * Error interno.
//     * <p>
//     * Error del servidor, codigo de retorno 500.
//     *
//     * @param error Error
//     * @return the response
//     */
//    public Response jsonInternalErrorResponse(@NotNull Exception error)
//    {
//        return Response.serverError().entity(new ErrorResponse(error.toString()).toJson()).build();
//    }
//
//    //=== URL ======
//
//    public java.net.URI getFindByIdUri(@NotNull HttpServletRequest request, @NotNull String findUrlResource)
//    {
//        try
//        {
//            String findByIdStrUri = "";
//
//            String scheme = request.getScheme();
//            String serverName = request.getServerName();
//            int serverPort = request.getServerPort();
//            String contextPath = request.getContextPath();
//
//            findByIdStrUri = scheme + "://" + serverName + ":" + serverPort + contextPath + findUrlResource;
//
//            return new java.net.URI(findByIdStrUri);
//        }
//        catch (Exception e)
//        {
//            return null;
//        }
//    }


}
