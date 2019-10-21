package com.java_server_replication_routes.replication.Model;

public class PythonPostRequest {

    private String last_entry;

//    public PythonPostRequest(String last_entry) {
//        this.last_entry = last_entry;
//    }

    public PythonPostRequest() {

    }

    public String getLast_entry() {
        return last_entry;
    }

    public void setLast_entry(String last_entry) {
        this.last_entry = last_entry;
    }
}
