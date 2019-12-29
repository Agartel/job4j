package stream;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Profiles {
    private final List<Profile> profiles = Arrays.asList(new Profile(new Address("Moscow", "qwe", 4, 5)),
                                                         new Profile(new Address("Moscow", "qwe", 1, 16)),
                                                         new Profile(new Address("SPB", "asdads", 55, 22)));
    private final List<Address> collect(List<Profile> profiles) {
        List<Address> l = new ArrayList<>();
        return l;
    /*

    List<String> numbers = Arrays.asList("1", "2", "3", "4", "5", "6");
    System.out.println("original list: " + numbers);
    List<Integer> even = numbers.stream()
                                .map(s -> Integer.valueOf(s))
                                .filter(number -> number % 2 == 0)
                                .collect(Collectors.toList());
     */
      //  List<Address> addrs = profiles.stream().map(a -> )
    }
    public static void main (String[] args) {
        Profiles prfs = new Profiles();
        // Arrays.asList(new Profile(), new Profile(), new Profile())
        //List<Address> addrss = prfs.collect(Collections.toList);
    }
}
