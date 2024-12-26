package at.htl.leonding.entity;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

    public class PersonTest {

        @Test
        public void testPersonValidity() {
            Address address = new Address("Hauptstraße 1", "Linz", "4020");
            Person person = new Person("Max", "Mustermann", 30, "max@example.com", 40, 20, address);

            assertThat(person.isValid()).isTrue();
        }

        @Test
        public void testCalculateSalary() {
            Person person = new Person();
            person.setHoursWorked(40);
            person.setHourlyWage(20);

            assertThat(person.calculateSalary()).isEqualTo(800);
        }
    }

