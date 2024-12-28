package at.htl.leonding.entity;

import jakarta.persistence.*;

import java.util.Objects;

@Entity
public class Address {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String street;
    private String city;
    private String zipCode;


    public Address() {
    }

    public Address(String street, String city, String zipCode) {
        this.street = street;
        this.city = city;
        this.zipCode = zipCode;

    }


    public double calculateShippingCost() {
        // Angenommen, für jede Postleitzahl gibt es einen festgelegten Preis.
        if (this.zipCode.startsWith("40")) {
            return 5.0; // Versandkosten für Linz
        } else if (this.zipCode.startsWith("10")) {
            return 10.0; // Versandkosten für Wien
        } else {
            return 15.0; // Standard-Versandkosten
        }
    }

    public boolean isValid() {
        return street != null && !street.isEmpty() && city != null && !city.isEmpty() && zipCode != null && !zipCode.isEmpty();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getZipCode() {
        return zipCode;
    }

    public void setZipCode(String zipCode) {
        this.zipCode = zipCode;
    }

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof Address address)) return false;
        return Objects.equals(getId(), address.getId()) && Objects.equals(getStreet(), address.getStreet()) && Objects.equals(getCity(), address.getCity()) && Objects.equals(getZipCode(), address.getZipCode());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getStreet(), getCity(), getZipCode());
    }

    @Override
    public String toString() {
        return "Address{" + "id=" + id + ", street='" + street + '\'' + ", city='" + city + '\'' + ", zipCode='" + zipCode + '\'' + '}';
    }
}
