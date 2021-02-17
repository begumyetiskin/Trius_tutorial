package trius.springframework.converters;

import org.bson.types.ObjectId;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import trius.springframework.commands.OrderForm;
import trius.springframework.domain.Order;


@Component
public class OrderFormToOrder implements Converter<OrderForm, Order> {

    @Override
    public Order convert(OrderForm orderForm) {
        Order order = new Order();
        if (orderForm.getId() != null  && !StringUtils.isEmpty(orderForm.getId())) {
            order.setId(new ObjectId(orderForm.getId()));
        }
        order.setName(orderForm.getName());
        order.setDescription(orderForm.getDescription());
        order.setPrice(orderForm.getPrice());
        order.setAmount(orderForm.getAmount());
        order.setDate(orderForm.getDate());
        return order;
    }
}