package com.sadman.loginapp.response;

/**
 * @author Sadman
 * @since Jul 28, 2016
 */
public class Response extends BaseResponse {
    Object item;

    public Response(int responseCode, Object item) {
        super(responseCode);
        this.item = item;
    }

    public Object getItem() {
        return item;
    }

    public void setItem(Object item) {
        this.item = item;
    }
}
