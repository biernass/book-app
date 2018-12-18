package com.soft.book.bookapp.services;

import com.soft.book.bookapp.dto.OrderDto;
import com.soft.book.bookapp.entities.OrderDetail;

import java.util.List;

public interface OrderService {

    void save(OrderDto orderDto);

    List<OrderDetail> findAllItemsByOrderId(Long orderId);

    OrderDto findById(Long orderId);

    List<OrderDto> findAllOrders();

    void processOrder(Long bookId, int count);



}
