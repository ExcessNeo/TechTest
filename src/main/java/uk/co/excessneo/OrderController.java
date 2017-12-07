package uk.co.excessneo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class OrderController
{
    private final OrderService orderService;

    @Autowired
    public OrderController(OrderService orderService)
    {
        this.orderService = orderService;
    }

    @RequestMapping("/create")
    public int createOrder(@RequestParam("quantity") int quantity)
    {
        return orderService.createOrder(quantity);
    }

    @RequestMapping("/getOrder")
    public Order getOrder(@RequestParam("id") int id)
    {
        return orderService.getOrder(id);
    }

    @RequestMapping("/getOrders")
    public List<Order> getOrders()
    {
        return orderService.getOrders();
    }

    @RequestMapping("/updateOrder")
    public ResponseEntity<Integer> updateOrder(@RequestParam("id") int id, @RequestParam("quantity") int quantity)
    {
        try
        {
            return new ResponseEntity<>(orderService.updateOrder(id, quantity), HttpStatus.OK);
        }
        catch (InvalidOrderReferenceException e)
        {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @RequestMapping("/fulfilOrder")
    public ResponseEntity<Order> fulfilOrder(@RequestParam("id") int id)
    {
        try
        {
            orderService.fulfilOrder(id);
            return new ResponseEntity<>(orderService.getOrder(id), HttpStatus.OK);
        }
        catch (InvalidOrderReferenceException e)
        {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }
}
