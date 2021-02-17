package trius.springframework.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import trius.springframework.commands.OrderForm;
import trius.springframework.converters.OrderFormToOrder;
import trius.springframework.domain.Order;
import trius.springframework.repositories.OrderRepository;
import java.util.ArrayList;
import java.util.List;

@Service
public class OrderServiceImpl implements OrderService{
    private OrderRepository orderRepository;
    private OrderFormToOrder orderFormToOrder;

    @Autowired
    public OrderServiceImpl(OrderRepository orderRepository, OrderFormToOrder orderFormToOrder) {
        this.orderRepository = orderRepository;
        this.orderFormToOrder = orderFormToOrder;
    }

    @Override
    public List<Order> listAll() {
        List<Order> orders = new ArrayList<>();
        orderRepository.findAll().forEach(orders::add); //fun with Java 8
        return orders;
    }

    @Override
    public Order getById(String id) {
        return orderRepository.findById(id).orElse(null);
    }

    @Override
    public Order saveOrUpdate(Order order) {
        orderRepository.save(order);
        return order;
    }

    @Override
    public void delete(String id) {
        orderRepository.deleteById(id);
    }

    @Override
    public Order saveOrUpdateOrderForm(OrderForm orderForm) {
        Order savedOrder = saveOrUpdate(orderFormToOrder.convert(orderForm));

        System.out.println("Saved Order Id: " + savedOrder.getId());
        return savedOrder;
    }
}

