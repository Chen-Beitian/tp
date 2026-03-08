package seedu.address.model.delivery;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static seedu.address.testutil.Assert.assertThrows;

public class DeliveryTimeTest {
    @Test
    public void constructor_null_throwsNullPointerException() {
        assertThrows(NullPointerException.class, () -> new DeliveryTime(null));
    }

    @Test
    public void constructor_invalidTime_throwsIllegalArgumentException() {
        String invalidTime = "";
        assertThrows(IllegalArgumentException.class, () -> new DeliveryTime(invalidTime));
    }

    @Test
    public void isValidDeliveryTime() {
        // null time
        assertThrows(NullPointerException.class, () -> DeliveryTime.isValidDeliveryTime(null));

        // invalid times
        assertFalse(DeliveryTime.isValidDeliveryTime("")); // empty string
        assertFalse(DeliveryTime.isValidDeliveryTime(" ")); // spaces only
        assertFalse(DeliveryTime.isValidDeliveryTime("12")); // only one number
        assertFalse(DeliveryTime.isValidDeliveryTime("01-12")); // does not contain year
        assertFalse(DeliveryTime.isValidDeliveryTime("2020-01")); // does not contain date number
        assertFalse(DeliveryTime.isValidDeliveryTime("2026-01-12")); // date format

        // valid time
        assertTrue(DeliveryTime.isValidDeliveryTime("12:59")); // correct time format
    }

    @Test
    public void equals() {
        DeliveryTime Time = new DeliveryTime("12:59");

        // same values -> returns true
        assertTrue(Time.equals(new DeliveryTime("12:59")));

        // same object -> returns true
        assertTrue(Time.equals(Time));

        // null -> returns false
        assertFalse(Time.equals(null));

        // different types -> returns false
        assertFalse(Time.equals(5.0f));

        // different values -> returns false
        assertFalse(Time.equals(new DeliveryTime("13:43")));
    }
}
