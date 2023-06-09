/*
 * Copyright (c) 2023.  Yaser Rodriguez
 * yaser.rguez@gmail.com
 * LastUpdate: 6/9/23, 12:05 AM
 *
 */

package com.group.bestvision.yrm.test.controller;

import com.group.bestvision.yrm.test.dto.AddressDto;
import com.group.bestvision.yrm.test.dto.ContactDto;
import com.group.bestvision.yrm.test.dto.PhoneDto;
import com.group.bestvision.yrm.test.dto.PhotoDto;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.ArraySchema;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;

import java.util.List;

@Tag(name = "Contact API")
public interface ContactController
{
    @Operation(description = "Recuperar Contacto por su identificador",
            parameters = {
                    @Parameter(name = "id", required = true, description = "Identificador del Contacto.")
            },
            responses = {
                    @ApiResponse(responseCode = "200", description = "La operación se ha realizado con exito",
                            content = {@Content(mediaType = MediaType.APPLICATION_JSON_VALUE), @Content(schema = @Schema(name = "ContactDto"))}),
                    @ApiResponse(responseCode = "500", description = "Errores del servidor")
            }
    )
    ResponseEntity<ContactDto> findById(long id);

    @Operation(description = "Recuperar todos los Contactos",
            responses = {
                    @ApiResponse(responseCode = "200", description = "La operación se ha realizado con exito",
                            content = @Content(array = @ArraySchema(schema = @Schema(name = "ContactDto")))),
                    @ApiResponse(responseCode = "500", description = "Errores del servidor")
            }
    )
    ResponseEntity<List<ContactDto>> list(String name, String address);

    @Operation(description = "Recuperar todos los Contactos con paginado",
            responses = {
                    @ApiResponse(responseCode = "200", description = "La operación se ha realizado con exito",
                            content = @Content(array = @ArraySchema(schema = @Schema(name = "ContactDto")))),
                    @ApiResponse(responseCode = "500", description = "Errores del servidor")
            }
    )
    ResponseEntity<Page<ContactDto>> pageQuery(String name, String address,Pageable pageable);

    @Operation(description = "Crear Contacto",
            responses = {
                    @ApiResponse(responseCode = "201", description = "La operación se ha realizado con exito",
                            content = {@Content(mediaType = MediaType.APPLICATION_JSON_VALUE), @Content(schema = @Schema(name = "ContactDto"))}),
                    @ApiResponse(responseCode = "500", description = "Errores del servidor")
            }
    )
    ResponseEntity<ContactDto> save(ContactDto contactDTO);

    @Operation(description = "Actualizar Contacto",
            parameters = {
                    @Parameter(name = "id", description = "Identificador del Contacto")
            },
            responses = {
                    @ApiResponse(responseCode = "201", description = "La operación se ha realizado con exito",
                            content = {@Content(mediaType = MediaType.APPLICATION_JSON_VALUE), @Content(schema = @Schema(name = "ContactDto"))}),
                    @ApiResponse(responseCode = "500", description = "Errores del servidor")
            }
    )
    ResponseEntity<ContactDto> update(ContactDto dto, long id);

    @Operation(description = "Eliminar Contacto",
            parameters = {
                    @Parameter(name = "id", description = "Identificador del Contacto")
            },
            responses = {
                    @ApiResponse(responseCode = "201", description = "La operación se ha realizado con exito",
                            content = {@Content(mediaType = MediaType.APPLICATION_JSON_VALUE)}),
                    @ApiResponse(responseCode = "500", description = "Errores del servidor")
            }
    )
    void delete(long id);

    @Operation(description = "Foto del Contacto",
            parameters = {
                    @Parameter(name = "id", description = "Identificador del Contacto")
            },
            responses = {
                    @ApiResponse(responseCode = "201", description = "La operación se ha realizado con exito",
                            content = {@Content(mediaType = MediaType.APPLICATION_JSON_VALUE), @Content(schema = @Schema(name = "PhotoDto"))}),
                    @ApiResponse(responseCode = "500", description = "Errores del servidor")
            }
    )
    ResponseEntity<PhotoDto> getPhoto(long id);

    @Operation(description = "Direcciones del Contacto",
            parameters = {
                    @Parameter(name = "id", description = "Identificador del Contacto")
            },
            responses = {
                    @ApiResponse(responseCode = "201", description = "La operación se ha realizado con exito",
                            content = @Content(array = @ArraySchema(schema = @Schema(name = "AddressDto")))),
                    @ApiResponse(responseCode = "500", description = "Errores del servidor")
            }
    )
    ResponseEntity<AddressDto> getAddress(long id);

    @Operation(description = "Telefonos del Contacto",
            parameters = {
                    @Parameter(name = "id", description = "Identificador del Contacto")
            },
            responses = {
                    @ApiResponse(responseCode = "201", description = "La operación se ha realizado con exito",
                            content = @Content(array = @ArraySchema(schema = @Schema(name = "PhoneDto")))),
                    @ApiResponse(responseCode = "500", description = "Errores del servidor")
            }
    )
    ResponseEntity<List<PhoneDto>> getPhones(long id);

    @Operation(description = "Contactos en rango de edades",
            parameters = {
                    @Parameter(name = "min", description = "Edad minima en años"),
                    @Parameter(name = "max", description = "Edad maxima en años")
            },
            responses = {
                    @ApiResponse(responseCode = "201", description = "La operación se ha realizado con exito",
                            content = @Content(array = @ArraySchema(schema = @Schema(name = "PhoneDto")))),
                    @ApiResponse(responseCode = "500", description = "Errores del servidor")
            }
    )
    ResponseEntity<List<ContactDto>> getInRangeAge(int min, int max);
}
