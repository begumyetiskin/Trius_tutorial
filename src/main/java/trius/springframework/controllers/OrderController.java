package trius.springframework.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import trius.springframework.commands.OrderForm;
import trius.springframework.commands.ProductForm;
import trius.springframework.converters.OrderToOrderForm;
import trius.springframework.domain.Order;
import trius.springframework.domain.Product;
import trius.springframework.services.OrderService;
import trius.springframework.services.ProductService;

import javax.validation.Valid;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Date;

@Controller
public class OrderController {
    private OrderService orderService;
    private OrderToOrderForm orderToOrderForm;

    @Autowired
    private ProductService productService;

    @Autowired
    public void setOrderToOrderForm(OrderToOrderForm orderToOrderForm) {
        this.orderToOrderForm = orderToOrderForm;
    }

    @Autowired
    public void setOrderService(OrderService orderService) {
        this.orderService = orderService;
    }

    @RequestMapping({"/order/list", "/order"})
    public String listOrders(Model model){
        model.addAttribute("orders", orderService.listAll());
        return "order/list";
    }

    @RequestMapping("/order/show/{id}")
    public String getOrder(@PathVariable String id, Model model){
        model.addAttribute("order", orderService.getById(id));
        return "order/show";
    }

    @RequestMapping("order/edit/{id}")
    public String edit(@PathVariable String id, Model model){
        Order order = orderService.getById(id);
        OrderForm orderForm = orderToOrderForm.convert(order);
        model.addAttribute("orderForm", orderForm);
        return "order/orderform";
    }

    @RequestMapping("order/new/{productId}")
    public String newOrder(@PathVariable String productId, Model model){
        OrderForm orderForm = new OrderForm();
        Product product = productService.getById(productId);
        if(product.getStock().compareTo(BigDecimal.ZERO) != 0) {
            orderForm.setName(product.getName());
            orderForm.setPrice(product.getPrice());
            orderForm.setDescription(product.getDescription());
            orderForm.setAmount(BigDecimal.ONE);
            orderForm.setDate(LocalDate.now());
            product.setStock(product.getStock().subtract(new BigDecimal(1)));
            productService.saveOrUpdate(product);
            model.addAttribute("orderForm", orderForm);
            return "order/orderform";
        }
        else
            return "product/noproduct";
    }

    @RequestMapping(value = "/order", method = RequestMethod.POST)
    public String saveOrUpdateOrder(@Valid OrderForm orderForm, BindingResult bindingResult){

        if(bindingResult.hasErrors()){
            return "order/orderform";
        }

        Order savedOrder = orderService.saveOrUpdateOrderForm(orderForm);

        return "redirect:/order/show/" + savedOrder.getId();
    }

    @RequestMapping("/order/delete/{id}")
    public String delete(@PathVariable String id){
        orderService.delete(id);
        return "redirect:/order/list";
    }
}
