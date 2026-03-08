package seedu.address.model.delivery;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static seedu.address.testutil.Assert.assertThrows;

public class StartDateTest {

    @Test
    public void constructor_null_throwsNullPointerException() {
        assertThrows(NullPointerException.class, () -> new StartDate(null));
    }

    @Test
    public void constructor_invalidDate_throwsIllegalArgumentException() {
        String invalidDate = "";
        assertThrows(IllegalArgumentException.class, () -> new StartDate(invalidDate));
    }

    @Test
    public void isValidStartDate() {
        // null start date
        assertThrows(NullPointerException.class, () -> StartDate.isValidStartDate(null));

        // invalid start dates
        assertFalse(StartDate.isValidStartDate("")); // empty string
        assertFalse(StartDate.isValidStartDate(" ")); // spaces only
        assertFalse(StartDate.isValidStartDate("12")); // only date number
        assertFalse(StartDate.isValidStartDate("2012")); // only year
        assertFalse(StartDate.isValidStartDate("01-12")); // does not contain year
        assertFalse(StartDate.isValidStartDate("2020-01")); // does not contain date number
        assertFalse(StartDate.isValidStartDate("12-01-2026")); // incorrect format

        // valid start dates
        assertTrue(StartDate.isValidStartDate("2019-10-15")); // correct format
    }

    @Test
    public void equals() {
        StartDate Date = new StartDate("2019-10-15");

        // same values -> returns true
        assertTrue(Date.equals(new StartDate("2019-10-15")));

        // same object -> returns true
        assertTrue(Date.equals(Date));

        // null -> returns false
        assertFalse(Date.equals(null));

        // different types -> returns false
        assertFalse(Date.equals(5.0f));

        // different values -> returns false
        assertFalse(Date.equals(new StartDate("2020-11-12")));
    }
}
