package hw6;

import com.google.gson.Gson;
import com.google.gson.stream.JsonReader;
import com.google.gson.JsonObject;
import hw6.entities.MetalsAndColorsFormTestData;
import org.testng.annotations.DataProvider;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.LinkedList;


public class JsonDataProvider {

    @DataProvider
    public Object[][] testDataFromJson() {
        Gson gson = new Gson();
        JsonReader jsonReader = null;
        LinkedList<MetalsAndColorsFormTestData> testDataList = new LinkedList<MetalsAndColorsFormTestData>();

        try {
            jsonReader = new JsonReader(new FileReader("src/test/resources/hw6/JDI_ex8_metalsColorsDataSet.json"));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        JsonObject bigObject = gson.fromJson(jsonReader, JsonObject.class);

        for(String dataKey : bigObject.keySet()) {
            MetalsAndColorsFormTestData data = gson.fromJson(bigObject.get(dataKey), MetalsAndColorsFormTestData.class);
            testDataList.add(data);
        }

        Object[][] array = new Object[testDataList.size()][1];
        int index = 0;
        for (Object[] each : array) {
            each[0] = testDataList.get(index++);
        }

        return array;
    }

    @DataProvider
    public Object[][] testDataFromJsonWithJsonSimple() {
        // Try with Json.simple library!
        Object[][] array = new Object[6][1];
        return array;
    }

}
