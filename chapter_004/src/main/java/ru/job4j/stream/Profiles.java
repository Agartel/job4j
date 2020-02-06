package ru.job4j.stream;

import java.util.*;
import java.util.stream.Collectors;

public class Profiles {
    private final List<Address> collect(List<Profile> profiles)  {
        Comparator<Address> compareCity = new Comparator<Address>() {
            @Override
            public int compare(Address first, Address second) {
                return second.getCity().compareTo(first.getCity());
            }
        };
        Comparator<Address> compareStreet = new Comparator<Address>() {
            @Override
            public int compare(Address first, Address second) {
                return second.getStreet().compareTo(first.getStreet());
            }
        };
        Comparator<Address> compareHome = new Comparator<Address>() {
            @Override
            public int compare(Address first, Address second) {
                return Integer.compare(second.getHome(), first.getHome());
            }
        };
        Comparator<Address> compareApartment = new Comparator<Address>() {
            @Override
            public int compare(Address first, Address second) {
                return Integer.compare(second.getApartment(), first.getApartment());
            }
        };
        List<Address> res = profiles.stream().map(p -> p.getAddress()).sorted(compareCity.
                                                                thenComparing(compareStreet).
                                                                thenComparing(compareHome).
                                                                thenComparing(compareApartment)).distinct().collect(Collectors.toList());
        return res;
    }
    public static void main(String[] args) {
        List<Profile> profiles = Arrays.asList(new Profile(new Address("Moscow", "qwe", 4, 5)),
                                                     new Profile(new Address("Moscow", "qwe", 4, 6)),
                                                     new Profile(new Address("SPB", "asdads", 55, 22)));
        Profiles prfs = new Profiles();
        List<Address> list = prfs.collect(profiles);
        System.out.println(list.size());
    }
}
