/*
 * Copyright (c) 2023.  Yaser Rodriguez
 * yaser.rguez@gmail.com
 * LastUpdate: 6/9/23, 12:35 AM
 *
 */

package com.group.bestvision.yrm.test.controller.cache;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.Parameters;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;

@Tag(name = "Cache")
public interface CacheApi
{
    /**
     * @tag {DELETE} /cache clearAllCaches
     */
    @Operation(summary = "Borra todas las Cache.")
    @ApiResponses( value = {
            @ApiResponse(responseCode = "200", description = "Found the resources", content = @Content()),
            @ApiResponse(responseCode = "404", description = "Resources not found", content = @Content()),
            @ApiResponse(responseCode = "500", description = "Errores del servidor")} )
    ResponseEntity clearAllCaches();

    /**
     * @tag {DELETE} /cache/{cacheName} clearCache
     */

    @Operation(summary = "Borra la Cache especificada.")
    @Parameters(value = { @Parameter(name = "cacheName", required = true, description = "Nombre de la cache")})
    @ApiResponses( value = {
            @ApiResponse(responseCode = "200", description = "Found the resources", content = @Content()),
            @ApiResponse(responseCode = "404", description = "Resources not found", content = @Content()),
            @ApiResponse(responseCode = "500", description = "Errores del servidor")} )
    ResponseEntity clearCache(String cacheName);
}
