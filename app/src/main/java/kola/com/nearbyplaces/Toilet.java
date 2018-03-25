package kola.com.nearbyplaces;

/**
 * Created by acer on 1/27/2018.
 */

public class Toilet {
    String id;
    int rating;
    //String name;

    public Toilet() {

    }

    public Toilet(String id, int rating) {
        this.id = id;
        this.rating = rating;
       // this.name = name;String name
    }

    public String getId() {
        return id;
    }

    public int getRating() {
        return rating;
    }

  /*  public String getName() {
        return name;
    }*/
}
