package seedu.address.model.delivery;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static seedu.address.testutil.Assert.assertThrows;

public class EndDateTest {

    @Test
    public void constructor_null_throwsNullPointerException() {
        assertThrows(NullPointerException.class, () -> new EndDate(null));
    }

    @Test
    public void constructor_invalidDate_throwsIllegalArgumentException() {
        String invalidDate = "";
        assertThrows(IllegalArgumentException.class, () -> new EndDate(invalidDate));
    }

    @Test
    public void isValidEndDate() {
        // null start date
        assertThrows(NullPointerException.class, () -> EndDate.isValidEndDate(null));

        // invalid start dates
        assertFalse(EndDate.isValidEndDate("")); // empty string
        assertFalse(EndDate.isValidEndDate(" ")); // spaces only
        assertFalse(EndDate.isValidEndDate("12")); // only date number
        assertFalse(EndDate.isValidEndDate("2012")); // only year
        assertFalse(EndDate.isValidEndDate("01-12")); // does not contain year
        assertFalse(EndDate.isValidEndDate("2020-01")); // does not contain date number
        assertFalse(EndDate.isValidEndDate("12-01-2026")); // incorrect format

        // valid start dates
        assertTrue(EndDate.isValidEndDate("2019-10-15")); // correct format
    }

    @Test
    public void equals() {
        EndDate Date = new EndDate("2019-10-15");

        // same values -> returns true
        assertTrue(Date.equals(new EndDate("2019-10-15")));

        // same object -> returns true
        assertTrue(Date.equals(Date));

        // null -> returns false
        assertFalse(Date.equals(null));

        // different types -> returns false
        assertFalse(Date.equals(5.0f));

        // different values -> returns false
        assertFalse(Date.equals(new EndDate("2020-11-12")));
    }
}
