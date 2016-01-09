package lnmiit.madclub.plinth.Model;

import java.io.Serializable;
import java.util.ArrayList;

/**
 * Created by Ankur Shukla on 12/31/2015.
 */
public class ModelGrid implements Serializable{

    public String name;
    public int image;
    public String color;
    public String colorDark;
    public String status_color;
    public ArrayList<ModelEvents> eventsArrayList = new ArrayList<>();

}
