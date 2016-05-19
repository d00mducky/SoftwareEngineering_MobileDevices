package edu.perrakcwu.myjokes;

/**
 * Created by kyle on 7/16/15.
 */
public class Joke {

    private int id;
    private String joke;
    public long getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getJoke() {
        return this.joke;
    }
    public void setJoke(String joke) {
        this.joke = joke;
    }
    @Override
    public String toString() {
        return joke;
    }
}
