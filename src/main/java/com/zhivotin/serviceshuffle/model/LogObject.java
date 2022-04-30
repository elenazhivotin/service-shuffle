package com.zhivotin.serviceshuffle.model;

public class LogObject<T> {
    private String appName;
    private T inputObject;

    public LogObject() {}

    public LogObject(String appName, T inputObject) {
        this.appName = appName;
        this.inputObject = inputObject;
    }

    public String getAppName() {
        return appName;
    }

    public void setAppName(String appName) {
        this.appName = appName;
    }

    public T getInputObject() {
        return inputObject;
    }

    public void setInputObject(T inputObject) {
        this.inputObject = inputObject;
    }

    @Override
    public String toString() {
        return "LogObject{" +
                "appName='" + appName + '\'' +
                ", inputObject=" + inputObject +
                '}';
    }
}
