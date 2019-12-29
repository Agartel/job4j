package stream;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class Profiles {
    private final List<Address> collect(List<Profile> profiles) {

    }
    public static void main (String[] args) {
        Profiles prfs = new Profiles();
        // Arrays.asList(new Profile(), new Profile(), new Profile())
        List<Address> addrss = prfs.collect(Collections.toList);
    }
}
