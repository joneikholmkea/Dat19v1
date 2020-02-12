package getcity;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;

public class Main {
    public static void main(String[] args) {
        try {
            URL url = new URL("http://ipinfo.io");
            BufferedReader br = new BufferedReader(new InputStreamReader(url.openStream()));
            String line = br.readLine();
            String s = "";
            while(line != null){
                line = br.readLine();
                s = s + line;
            }
            System.out.println(getValue("city", s));

        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static String getValue(String key, String body){
        key = "\"" + key + "\":";
        int valueIndex = body.indexOf(key);
        String rest = body.substring(valueIndex + key.length() + 1);
        int commaIndex = rest.indexOf(", ");
        return rest.substring(1, commaIndex - 1);
    }
}

// Dette var koden, før vi lavede getValue() metoden:
//    int cityIndex = s.indexOf("\"city\":");
//            System.out.println("fandt city på index: " + cityIndex);
//                    String rest = s.substring(cityIndex + 8);
//                    int commaIndex = rest.indexOf(',');
//                    String city = rest.substring(1, commaIndex - 1);
//                    System.out.println(city);

//Lav en metode kaldet getValue(String key, String body), som returnerer en String
// med værdien, hvis der findes en.
// F.eks. getValue("city", s) skal returnere "Glostrup"
