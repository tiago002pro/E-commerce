package com.pleno.ecommerce.infrasctructure.mapper;

import com.pleno.ecommerce.application.dto.response.OrderResponse;
import com.pleno.ecommerce.domain.model.Order;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring", uses = OrderItemMapper.class)
public interface OrderMapper {

    @Mapping(target = "customerEmail", expression = "java(order.getCustomerEmail().getValue())")
    OrderResponse toResponse(Order order);
}
