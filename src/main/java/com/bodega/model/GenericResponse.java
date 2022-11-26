package com.bodega.model;
import com.fasterxml.jackson.annotation.JsonProperty;

public class GenericResponse extends Response{
	
	@JsonProperty("body")
    private Object body;

    public GenericResponse() {}

    public GenericResponse(int status, String message) {
        super(status, message);
    }

    public Object getBody() {
        return body;
    }

    public void setBody(Object body) {
        this.body = body;
    }
}