package oop;

import java.io.File;
import java.util.*;

public class Main {

    public static void main(String[] args) {
        MovieInfo movieInfo = new MovieInfo();
        movieInfo.setCountry("USA");
        movieInfo.setYear("2000");
        movieInfo.setTitle("Matrix");
        movieInfo.setDirector("Wachowsky");
        MovieInfo movieInfo2 = new MovieInfo();
        movieInfo2.setCountry("Indien");
        movieInfo2.setYear("2016");
        movieInfo2.setTitle("Dangal");
        movieInfo2.setDirector("Nitesh");
        List<MovieInfo> list = new ArrayList<>();
        list.add(movieInfo);
        list.add(movieInfo2);

        List<MovieInfo> soegResultat = findMovieInfos("adf", list);
        System.out.println("fandt: " + soegResultat.size());
    }

    static List<MovieInfo> findMovieInfos(String director, List<MovieInfo> list){
        List<MovieInfo> resultat = new ArrayList<>();
        for (MovieInfo mInfo:list ) {
            if(mInfo.getDirector().equalsIgnoreCase(director)){
                resultat.add(mInfo);
            }
        }
        return resultat;
    }


//    private static void runDemoLineScan() {
//        String line = "anna,bert,1980,,,,denmark";
//        Scanner lineScan = new Scanner(line).useDelimiter(",");
//        List<String> lineWords = new ArrayList<>();
//        while (lineScan.hasNext()){
//            lineWords.add(lineScan.next()); // tilføjer også tomme felter
//        }
//        System.out.println(lineWords.size());
//    }

}








//    public static void main(String[] args) {
//        Map<String, Integer> wordsAndCount = new HashMap<>();
//
//        for (Map.Entry<String,Integer> entry: wordsAndCount.entrySet()) {
//            System.out.println("key " + entry.getKey() + " value :" + entry.getValue());
//        }
//        String path = System.getProperty("user.dir");
//        String filePath = path + "/" + "mov.csv";
//        try {
//            Scanner scanner = new Scanner(new File(filePath));
//            String line = scanner.nextLine();
//
//        }catch (Exception e){
//
//        }
//    }
