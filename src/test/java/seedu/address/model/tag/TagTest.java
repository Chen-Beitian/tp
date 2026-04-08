package seedu.address.model.tag;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static seedu.address.testutil.Assert.assertThrows;

import org.junit.jupiter.api.Test;

public class TagTest {

    @Test
    public void constructor_validTagName_success() {
        String validTagName = "vegan";
        Tag tag = new Tag(validTagName);
        assertEquals(validTagName, tag.tagName);

        // BVA: tag with exactly 35 characters
        String longestValidTagName = "a".repeat(35);
        tag = new Tag(longestValidTagName);
        assertEquals(longestValidTagName, tag.tagName);
    }

    @Test
    public void constructor_null_throwsNullPointerException() {
        assertThrows(NullPointerException.class, () -> new Tag(null));
    }

    @Test
    public void constructor_invalidTagName_throwsIllegalArgumentException() {
        // empty tag
        String emptyTagName = "";
        assertThrows(IllegalArgumentException.class, () -> new Tag(emptyTagName));

        // non alphanumeric tag
        String nonAlphanumericTagName = "(vegan)";
        assertThrows(IllegalArgumentException.class, () -> new Tag(nonAlphanumericTagName));

        // BVA: tag longer than 35 characters
        String longTagName = "a".repeat(36);
        assertThrows(IllegalArgumentException.class, () -> new Tag(longTagName));
    }

    @Test
    public void isValidTagName() {
        // null tag name
        assertThrows(NullPointerException.class, () -> Tag.isValidTagName(null));
    }

}
