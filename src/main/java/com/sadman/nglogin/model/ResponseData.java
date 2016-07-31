package com.sadman.nglogin.model;

/**
 * @author Sadman
 * @since Jul 28, 2016
 */
public class ResponseData extends Response {
    Object item;

    public ResponseData(int responseCode, String responseMessage) {
        super(responseCode, responseMessage);
    }

    public ResponseData(int responseCode, String responseMessage, Object item) {
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
