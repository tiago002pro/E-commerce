package com.pleno.ecommerce.domain.model.mapper;

import com.pleno.ecommerce.application.dto.response.OrderResponse;
import com.pleno.ecommerce.domain.model.Order;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring", uses = OrderItemMapper.class)
public interface OrderMapper {

    OrderResponse toResponse(Order order);
}
