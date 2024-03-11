package com.classDevSuperiorSpringboot.course.model.enums;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public enum OrderStatus {

    WAITING_PAYMENT(1),
    PAID(2),
    SHIPPED(3),
    DELIVERED(4),
    CANCELED(5);

    private int code;
    OrderStatus(int code){
        this.code = code;
    }

    public int getCode(){
        return code;
    }

    public static OrderStatus valueOf(int code){
        for (OrderStatus value : OrderStatus.values()){
            if(value.getCode() == code){
                return value;
            }
        }
        throw new IllegalArgumentException("Invalid order status code");

//        List<OrderStatus> list = Arrays.stream(OrderStatus.values()).toList();
//        list.stream().filter(x -> x.code == code).collect(Collectors.toList());

    }
}
