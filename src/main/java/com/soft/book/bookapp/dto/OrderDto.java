package com.soft.book.bookapp.dto;

import com.soft.book.bookapp.entities.Customer;
import com.soft.book.bookapp.entities.OrderDetail;
import com.soft.book.bookapp.entities.OrderStatus;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

public class OrderDto {

    private Long id;

    private Customer customer;

    private LocalDateTime orderDate;

    private OrderStatus orderStatus;

    private List<OrderDetail> orderDetails;

    public OrderDto() {
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public void setOrderDate(LocalDateTime orderDate) {
        this.orderDate = orderDate;
    }

    public void setOrderStatus(OrderStatus orderStatus) {
        this.orderStatus = orderStatus;
    }

    public void setOrderDetails(List<OrderDetail> orderDetails) {
        this.orderDetails = orderDetails;
    }

}
