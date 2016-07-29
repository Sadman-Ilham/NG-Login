package com.sadman.nglogin.model;

/**
 * @author Sadman
 * @since Jul 28, 2016
 */
public class Response extends BaseResponse {
    Object item;

    public Response(int responseCode, String responseMessage) {
        super(responseCode, responseMessage);
    }

    public Response(int responseCode, String responseMessage, Object item) {
        this(responseCode, responseMessage);
        this.item = item;
    }

    public Object getItem() {
        return item;
    }

    public void setItem(Object item) {
        this.item = item;
    }
}
