package utilities;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.LinkedList;
import java.util.List;

public class CSV {
    public static List<String[]> raedData(String file) throws IOException {
        List<String[]> data = new LinkedList<>();
        String dataRow;
        try ( BufferedReader br = new BufferedReader(new FileReader(file))) {
            while ((dataRow = br.readLine()) != null){
                String[] splitData = dataRow.split(",");
                data.add(splitData);
            }
        }
        return data;
    }
}
