package day5;

public class Maps {

    Range source;
    long destinationStart;

    public Maps(long destinationStart, long sourceStart, long size) {
        source = new Range(sourceStart, sourceStart + size - 1);
        this.destinationStart = destinationStart;
    }

    public Long map(long sourceLong) {
        if (source.contains(sourceLong)) {
            return destinationStart + (sourceLong - source.start);
        }
        return null;
    }

    @Override
    public String toString() {
        return "[" + source.start + "-" + source.end + " -> " + destinationStart + "...]";
    }

}
