package oop;

public class MovieInfo implements Comparable<MovieInfo> {
    String title;
    String country;
    String director;
    int year;


    public String getDirector() {
        return director;
    }

    public void setDirector(String director) {
        this.director = director;
    }

    public int getYear() {
        return year;
    }

    public void setYear(String year) {
        try {
            this.year = Integer.parseInt(year);
        }catch (Exception e){

        }
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    @Override
    public int compareTo(MovieInfo o) {
        if(o.getYear() == this.year) {
            return 0;
        }
        return o.getYear() < this.year ? 1 : -1;
    }
}
