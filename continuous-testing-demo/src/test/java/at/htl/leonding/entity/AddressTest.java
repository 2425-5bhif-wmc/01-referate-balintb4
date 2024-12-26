package at.htl.leonding.entity;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class AddressTest {

    @Test
    public void testAddressValidity() {
        Address validAddress = new Address("Hauptstraße 1", "Linz", "4020");
        Address invalidAddress = new Address("", "Linz", "4020");

        assertThat(validAddress.isValid()).isTrue();
        assertThat(invalidAddress.isValid()).isFalse();
    }

    @Test
    public void testAddressEquality() {
        Address address1 = new Address("Hauptstraße 1", "Linz", "4020");
        Address address2 = new Address("Hauptstraße 1", "Linz", "4020");
        Address address3 = new Address("Nebenstraße 5", "Wien", "1010");

        assertThat(address1).isEqualTo(address2);
        assertThat(address1).isNotEqualTo(address3);
    }

    @Test
    public void testAddressHashCodeConsistency() {
        Address address1 = new Address("Hauptstraße 1", "Linz", "4020");
        Address address2 = new Address("Hauptstraße 1", "Linz", "4020");

        assertThat(address1.hashCode()).isEqualTo(address2.hashCode());
    }

    @Test
    public void testCalculateShippingCost_Linz() {
        Address address = new Address("Hauptstraße 1", "Linz", "4020");

        double shippingCost = address.calculateShippingCost();

        assertThat(shippingCost).isEqualTo(5.0);
    }

    @Test
    public void testCalculateShippingCost_Wien() {
        Address address = new Address("Ringstraße 10", "Wien", "1010");

        double shippingCost = address.calculateShippingCost();

        assertThat(shippingCost).isEqualTo(10.0);
    }

    @Test
    public void testCalculateShippingCost_AndereRegion() {
        Address address = new Address("Musterstraße 15", "Salzburg", "5020");

        double shippingCost = address.calculateShippingCost();

        assertThat(shippingCost).isEqualTo(15.0);
    }

}