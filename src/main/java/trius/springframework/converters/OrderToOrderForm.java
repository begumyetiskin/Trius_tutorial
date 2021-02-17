package trius.springframework.converters;

import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;
import trius.springframework.commands.OrderForm;
import trius.springframework.domain.Order;


@Component
public class OrderToOrderForm implements Converter<Order, OrderForm> {
    @Override
    public OrderForm convert(Order order) {
        OrderForm orderForm = new OrderForm();
        orderForm.setId(order.getId().toHexString());
        orderForm.setName(order.getName());
        orderForm.setDescription(order.getDescription());
        orderForm.setPrice(order.getPrice());
        orderForm.setAmount(order.getAmount());
        orderForm.setDate(order.getDate());
        return orderForm;
    }
}