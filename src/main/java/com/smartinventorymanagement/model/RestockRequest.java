package com.smartinventorymanagement.model;

public class RestockRequest {

    private Long itemId;
    private int restockQty;

    public Long getItemId() { return itemId; }
    public void setItemId(Long itemId) { this.itemId = itemId; }

    public int getRestockQty() { return restockQty; }
    public void setRestockQty(int restockQty) { this.restockQty = restockQty; }
}
