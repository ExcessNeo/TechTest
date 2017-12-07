package uk.co.excessneo;

public class Order
{
    private int id;
    private int quantity;
    private boolean dispatched;

    public Order(int id, int quantity)
    {
        this.id = id;
        this.quantity = quantity;
    }

    public int getId()
    {
        return id;
    }

    public void setId(int id)
    {
        this.id = id;
    }

    public int getQuantity()
    {
        return quantity;
    }

    public void setQuantity(int quantity)
    {
        this.quantity = quantity;
    }

    public boolean isDispatched()
    {
        return dispatched;
    }

    public void setDispatched(boolean dispatched)
    {
        this.dispatched = dispatched;
    }
}
