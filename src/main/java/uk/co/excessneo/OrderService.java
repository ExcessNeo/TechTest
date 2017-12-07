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

    public int updateOrder(int id, int quantity) throws InvalidOrderReferenceException
    {
        if (id < orders.size())
        {
            Order order = orders.get(id);
            if (!order.isDispatched())
            {
                order.setQuantity(quantity);
            }
            else
            {
                throw new InvalidOrderReferenceException("Dispatched orders cannot be updated");
            }
            return order.getId();
        }
        throw new InvalidOrderReferenceException("Invalid order id");
    }

    public void fulfilOrder(int id) throws InvalidOrderReferenceException
    {
        if (id < orders.size())
        {
            orders.get(id).setDispatched(true);
        }
        else
        {
            throw new InvalidOrderReferenceException("Invalid order id");
        }
    }
}
