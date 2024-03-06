package edu.iu.habahram.ducksservice.model;

public record DuckData(int id, String type) implements Comparable {

    public static DuckData fromLine(String line) {
        String[] tokens = line.split(",");
        return new DuckData(Integer.parseInt(tokens[0]), tokens[1]);
    }

    public String toLine() {
        return String.format("%1$s,%2$s", id(), type());
    }

    public int compareTo(Object object) {
        DuckData otherDuck = (DuckData) object;
        if (this.type().compareTo(otherDuck.type()) < 0) {
            return -1;
        }
        if (this.type().compareTo(otherDuck.type()) > 0) {
            return 1;
        }
        return 0;
    }

}
