
package com.educandoweb.course2.entities.enums;

/**
 *
 * @author Jonas created 19/01/2021
 */

public enum OrderStatus {
    
    WAITING_PAYMENT(1),
    PAID(2),
    SHIPPED(3),
    DELIVERED(4),
    CANCELED(5);
    
    private int code;
    
    //Construtor to type enumeration 
    private OrderStatus(int code){
        this.code = code;
    }
    
    //Method to acess the code out 
    public int getCode(){
        return code;
    }
    
    //Method Static to convert a value numeric for type enumeration
    public static OrderStatus valueOf(int code){
        for(OrderStatus value : OrderStatus.values()){
            if(value.getCode() == code){
                return  value;
            }
        }
            throw new IllegalArgumentException("Invalid OrderStatus code");
    }
}
