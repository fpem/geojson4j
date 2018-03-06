package net.likehike.geojson4j;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import org.junit.Test;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Arrays;

import static org.junit.Assert.*;

public class GeojsonTest {

    @Test
    public void parseGeoJSON() throws FileNotFoundException {
        Gson gson = new Gson();
        String jsonFile= "C:\\Users\\francis_peng\\Desktop\\dev\\github\\geojson4j\\src\\test\\resources\\sample1.geo.json";
        FeatureCollection featureCollection
                = gson.fromJson(new FileReader(jsonFile), FeatureCollection.class);
        for(Feature feature: featureCollection.features) {
            System.out.println("\n==========Feature=========\n"+ gson.toJson(feature));
            if(GeometryType.Point.equals(feature.geometry.type))
                System.out.println("\nPointCoordinates: "+ Arrays.toString(feature.geometry.getPointCoordinates()));
            if(GeometryType.LineString.equals(feature.geometry.type) || GeometryType.MultiPoint.equals(feature.geometry.type))
                System.out.println("\nLineCoordinates: "+ Arrays.toString(feature.geometry.getLineCoordinates()));
        }
    }

    @Test
    public void parseGeoJSON2() throws FileNotFoundException {
        Gson gson = new Gson();
        String jsonFile= "C:\\Users\\francis_peng\\Desktop\\dev\\github\\geojson4j\\src\\test\\resources\\sample2.geo.json";
        FeatureCollection featureCollection
                = gson.fromJson(new FileReader(jsonFile), FeatureCollection.class);
        for(Feature feature: featureCollection.features) {
            System.out.println("\n==========Feature=========\n"+ gson.toJson(feature));
            if(GeometryType.Point.equals(feature.geometry.type))
                System.out.println("\nPointCoordinates: "+ Arrays.toString(feature.geometry.getPointCoordinates()));
            if(GeometryType.LineString.equals(feature.geometry.type) || GeometryType.MultiPoint.equals(feature.geometry.type))
                System.out.println("\nLineCoordinates: "+ Arrays.toString(feature.geometry.getLineCoordinates()));
        }

        String json= gson.toJson(featureCollection, FeatureCollection.class);
        System.out.println("\n\n==========gson.toJson(featureCollection, FeatureCollection.class)=========\n"+ json);

    }

    @Test
    public void parseGeoJSON3() throws FileNotFoundException {
        Gson gson = new Gson();
        String jsonFile= "C:\\Users\\francis_peng\\Desktop\\dev\\github\\geojson4j\\src\\test\\resources\\sample3.json";
        Feature feature = gson.fromJson(new FileReader(jsonFile), Feature.class);
        System.out.println("\n==========Feature=========\n"+ gson.toJson(feature));
        if(GeometryType.Point.equals(feature.geometry.type))
            System.out.println("\nPointCoordinates: "+ Arrays.toString(feature.geometry.getPointCoordinates()));
        if(GeometryType.LineString.equals(feature.geometry.type) || GeometryType.MultiPoint.equals(feature.geometry.type))
            System.out.println("\nLineCoordinates: "+ Arrays.toString(feature.geometry.getLineCoordinates()));
    }
}