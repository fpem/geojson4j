package net.likehike.geojson4j;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * Created by Francis_Peng on 3/5/2018.
 */

public class Geometry{
    public GeometryType type;
    //public float[][][] coordinates;

    public List coordinates;/*
    public abstract float[] getPosition();
    public abstract float[][] getPositions();
    public abstract float[][][] getPositionsArray();
    public abstract float[][][][] getPositionsArrayArray();*/

    public Geometry() {
    }
    public Geometry(GeometryType type, List coordinates) {
        this.type = type;
        this.coordinates = coordinates;
    }

    public float[] getPointCoordinates() {
        if(coordinates== null || coordinates.isEmpty()
                || !GeometryType.Point.equals(type))
            return null;

        float[] arr= new float[coordinates.size()];
        for(int i= 0; i< coordinates.size(); i++){
            arr[i]= ((Number)coordinates.get(i)).floatValue();
        }
        return arr;
    }

    public float[] getLineCoordinates() {
        if(coordinates== null || coordinates.isEmpty()
                || !(GeometryType.LineString.equals(type) || GeometryType.MultiPoint.equals(type))
                || coordinates.get(0)== null || !(coordinates.get(0) instanceof List)
                )
            return null;

        List<Number> list= new ArrayList();
        for(int i= 0; i< coordinates.size(); i++){
            list.addAll((Collection)coordinates.get(i));
        }

        float[] arr= new float[list.size()];
        for(int i= 0; i< list.size(); i++){
            arr[i]= list.get(i).floatValue();
        }
        return arr;
    }
    /*
    public String toString(){
        String s= "{\"type\":\""+ type.name() +"\",\"coordinates\":";
        switch (type){
            case Point:
                return s+ Arrays.toString(getPosition())+ "}";
            case LineString:
            case MultiPoint:
                return s+ Utils.toString(getPositions())+ "}";
            case Polygon:
            case MultiLineString:
                return s+ Utils.toString(getPositionsArray())+ "}";
            case MultiPolygon:
                return s+ Utils.toString(getPositionsArrayArray())+ "}";
            case GeometryCollection:
                return s+ "[]}";
        }
        return null;
    }
*/
}
