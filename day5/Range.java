package day5;

public class Range implements Comparable<Range> {
    long start, end;

    public Range(long start, long end) {
        this.start = start;
        this.end = end;
    }

    public boolean overlapOrAdjacent(Range bigger) {
        return bigger.contains(start) || bigger.contains(end + 1) || contains(bigger.start);
    }

    public boolean contains(long number) {
        return number >= start && number <= end;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (!(o instanceof Range range))
            return false;
        if (start != range.start)
            return false;
        return end == range.end;
    }

    @Override
    public int compareTo(Range o) {
        long range = start - o.start;
        if (range == 0) {
            range = end - o.end;
        }
        if (range < 0) {
            return -1;
        }
        if (range > 0) {
            return 1;
        }
        return 0;
    }

}
