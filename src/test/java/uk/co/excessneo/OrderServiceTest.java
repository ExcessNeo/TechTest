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
    public void testUpdateOrder()
    {
        assertEquals(0, orderService.updateOrder(0, 10));
    }

    @Test
    public void testInvalidUpdateOrder()
    {
        assertEquals(-1, orderService.updateOrder(1, 10));
    }
}
