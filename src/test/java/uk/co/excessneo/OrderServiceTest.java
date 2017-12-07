package uk.co.excessneo;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

public class OrderServiceTest
{
    private OrderService orderService;

    @Before
    public void setUp()
    {
        orderService = new OrderService();
        orderService.createOrder(5);
    }

    @Test
    public void testCreate()
    {
        assertEquals(1, orderService.createOrder(10));
    }

    @Test
    public void testGetValidOrder()
    {
        assertNotNull(orderService.getOrder(0));
    }

    @Test
    public void testGetInvalidOrder()
    {
        assertNull(orderService.getOrder(1));
    }

    @Test
    public void testGetOrders()
    {
        assertEquals(1, orderService.getOrders().size());
    }

    @Test
    public void testUpdateOrder() throws InvalidOrderReferenceException
    {
        assertEquals(0, orderService.updateOrder(0, 10));
    }

    @Test(expected = InvalidOrderReferenceException.class)
    public void testInvalidUpdateOrder() throws InvalidOrderReferenceException
    {
        orderService.updateOrder(1, 10);
    }

    @Test
    public void testFulfilOrder()
    {
        InvalidOrderReferenceException exception = null;
        try
        {
            orderService.fulfilOrder(0);
        }
        catch (InvalidOrderReferenceException e)
        {
            exception = e;
        }
        assertEquals(null, exception);
    }

    @Test(expected = InvalidOrderReferenceException.class)
    public void testInvalidFulfilOrder() throws InvalidOrderReferenceException
    {
        orderService.fulfilOrder(1);
    }
}
