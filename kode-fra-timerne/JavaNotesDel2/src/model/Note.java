package model;

public class Note implements Comparable<Note> {

    long tid = 0; // til at gemme tidspunkt for seneste "Save"
    String navn = "";
    String tekst = "";

    public Note(long tid, String navn, String tekst) {
        this.tid = tid;
        this.navn = navn;
        this.tekst = tekst;
    }

    @Override
    public int compareTo(Note o) { // den er god
        if(tid == o.tid){
            return 0;
        }
        return tid < o.tid ? 1 : -1; // ternary operator
    }

    @Override
    public String toString() {
        return "Note{" +
                "tid=" + tid +
                ", navn='" + navn + '\'' +
                ", tekst='" + tekst + '\'' +
                '}';
    }

    public String getNavn() {
        return navn;
    }

    public String getTekst() {
        return tekst;
    }

    public void setTekst(String tekst) {
        this.tekst = tekst;
    }

    public void setTid(long tid) {
        this.tid = tid;
    }
}
