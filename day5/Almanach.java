package day5;

import java.util.ArrayList;
import java.util.List;

public class Almanach {
    private List<Maps> maps = new ArrayList<>();

    public void addMap(String... spec) {
        if (spec.length != 3) {
            throw new IllegalArgumentException();
        }
        maps.add(new Maps(Long.parseLong(spec[0]), Long.parseLong(spec[1]), Long.parseLong(spec[2])));
    }

    public long map(long src) {
        for (Maps map : maps) {
            Long cand = map.map(src);
            if (cand != null) {
                return cand;
            }
        }
        return src;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (Maps map : maps) {
            sb.append(map.toString());
            sb.append(" ");
        }
        return sb.toString();
    }
}
