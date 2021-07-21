package za.co.mukondle.controllers.dto;

import za.co.mukondle.entities.Item;

public class Response {
    private Boolean status = false;
    private Item item = null;

    public Response(Boolean status, Item item) {
        this.status = status;
        this.item = item;
    }

    public Item getItem() {
        return item;
    }

    public void setItem(Item item) {
        this.item = item;
    }

    public Boolean getStatus() {
        return status;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }
}
