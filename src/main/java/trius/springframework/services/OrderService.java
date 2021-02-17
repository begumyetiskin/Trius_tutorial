package trius.springframework.services;

import trius.springframework.commands.OrderForm;
import trius.springframework.domain.Order;

import java.util.List;

public interface OrderService {
    List<Order> listAll();

    Order getById(String id);

    Order saveOrUpdate(Order order);

    void delete(String id);

    Order saveOrUpdateOrderForm(OrderForm orderForm);
}
