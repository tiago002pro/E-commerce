package com.pleno.ecommerce.domain.dto;

import java.time.LocalDateTime;

public record ErrorResponse(
   int status,
   String error,
   String message,
   String path,
   LocalDateTime timestamp
) {}
