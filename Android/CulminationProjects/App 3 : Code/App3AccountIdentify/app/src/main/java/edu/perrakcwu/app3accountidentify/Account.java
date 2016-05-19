package edu.perrakcwu.app3accountidentify;

/**
 * Created by kyle on 7/16/15.
 */

public class Account {

    private int id;
    private String account;
    public long getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getAccount() {
        return this.account;
    }
    public void setAccount(String account) {
        this.account = account;
    }
    @Override
    public String toString() {
        return account;
    }
}
