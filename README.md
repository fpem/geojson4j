# geojson4j
Java POJO classes for geojson, you can use it to parse/export geojson files directly

Tried to look for java lib to parse geojson, but there are too complex or too many dependencies,
so I created this tiny project which contains few POJO classes only, but you can use it to parse geojson file 
simply by below few line:

  Gson gson = new Gson();
  String jsonFile= ".\\src\\test\\resources\\sample1.geo.json";
  FeatureCollection featureCollection
                = gson.fromJson(new FileReader(jsonFile), FeatureCollection.class);

more test case you can find in JUnit test case: GeojsonTest.java
