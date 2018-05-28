package sample;

import com.google.gson.Gson;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class JsonManager {
    public ObservableList<String> readFromJson() {
        Gson gson = new Gson();
        Service[] services = {};
        try {
            BufferedReader br = new BufferedReader(new FileReader("servicesNames.json"));

            services = gson.fromJson(br, Service[].class);
        } catch(IOException e){
            e.printStackTrace();
        }

        ObservableList<String> result = FXCollections.observableArrayList();

        for(int i = 0 ; i < services.length; i++) result.add(services[i].getName());

        return result;
    }

    public void writeToJson(ObservableList<String> listToWrite) {

        ArrayList<Service> tmp = new ArrayList<>();

        for(int i = 0; i < listToWrite.size(); i ++) {
            tmp.add(new Service(listToWrite.get(i)));
        }

        Service[] o = tmp.toArray(new Service[tmp.size()]);
        Gson gson = new Gson();

        String json = gson.toJson(o);

        try {
            FileWriter writer = new FileWriter("servicesNames.json");
            writer.write(json);
            writer.close();
        } catch(IOException e) {
            e.printStackTrace();
        }
    }
}
