package com.pleno.ecommerce.domain.mapper;

import com.pleno.ecommerce.application.dto.response.OrderItemResponse;
import com.pleno.ecommerce.domain.model.OrderItem;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface OrderItemMapper {

    @Mapping(source = "product.name", target = "productName")
    OrderItemResponse toResponse(OrderItem orderItem);
}
