package uk.co.excessneo;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class OrderService
{
    private List<Order> orders = new ArrayList<>();

    public int createOrder(int quantity)
    {
        Order order = new Order(orders.size(), quantity);
        orders.add(order);
        return order.getId();
    }

    public Order getOrder(int id)
    {
        try
        {
            return orders.get(id);
        }
        catch (IndexOutOfBoundsException e)
        {
            return null;
        }
    }

    public List<Order> getOrders()
    {
        return orders;
    }

    public int updateOrder(int id, int quantity)
    {
        if (id < orders.size())
        {
            orders.get(id).setQuantity(quantity);
            return id;
        }
        return -1;
    }
}
