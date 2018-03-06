package net.likehike.geojson4j;

import java.util.Map;

/**
 * Created by Francis_Peng on 3/5/2018.
 *
 * {
 */

public class Feature {
    public final String type= "Feature";

    public String id;
    public float[] bbox;
    public Map<String, Object> properties;
    public Geometry geometry;

}

