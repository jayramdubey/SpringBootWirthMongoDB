package com.cts.personservice.model;

public class ModelHolder<T> {

    private T body;
    private String version;

    public ModelHolder(T body, String version) {
        this.body = body;
        this.version = version;
    }

    public T getBody() {
        return body;
    }

    public String getVersion() {
        return version;
    }
}
