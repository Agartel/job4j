package stream;

import java.util.Objects;

public class Address {
    private String city;
    private String street;

    private int home;

    private int apartment;

    public Address(String city, String street, int home, int apartment) {
        this.city = city;
        this.street = street;
        this.home = home;
        this.apartment = apartment;
    }

    public String getCity() {
        return this.city;
    }

    public String getStreet() {
        return this.street;
    }

    public int getHome() {
        return this.home;
    }

    public int getApartment() {
        return this.apartment;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Address addr = (Address) o;
        return Objects.equals(this.city, addr.city) && Objects.equals(this.street, addr.street) && this.home == addr.home && this.apartment == apartment;
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.city, this.street, this.home, this.apartment);
    }
}
