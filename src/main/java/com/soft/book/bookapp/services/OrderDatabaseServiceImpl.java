package com.soft.book.bookapp.services;

import com.soft.book.bookapp.dto.OrderDto;
import com.soft.book.bookapp.entities.OrderDetail;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderDatabaseServiceImpl implements OrderService{


    @Override
    public void save(OrderDto orderDto) {

    }

    @Override
    public List<OrderDetail> findAllItemsByOrderId(Long orderId) {
        return null;
    }

    @Override
    public OrderDto findById(Long orderId) {
        return null;
    }

    @Override
    public List<OrderDto> findAllOrders() {
        return null;
    }

    @Override
    public void processOrder(Long bookId, int count) {

    }
}
