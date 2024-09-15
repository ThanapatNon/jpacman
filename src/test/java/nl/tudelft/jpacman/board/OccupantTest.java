package nl.tudelft.jpacman.board;

import static org.assertj.core.api.Assertions.assertThat;

import nl.tudelft.jpacman.sprite.Sprite;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * Test suite to confirm that {@link Unit}s correctly (de)occupy squares.
 *
 * @author Jeroen Roosen 
 *
 */
class OccupantTest {

    /**
     * The unit under test.
     */
    private Unit unit;

    /**
     * Resets the unit under test.
     */
    @BeforeEach
    void setUp() {
        unit = new BasicUnit();
    }

    /**
     * Asserts that a unit has no square to start with.
     */
    @Test
    void noStartSquare() {
        // Remove the following placeholder:
//        assertThat(unit).isNotNull();
        assertThat(unit.hasSquare()).isFalse();
    }

    /**
     * Tests that the unit indeed has the target square as its base after
     * occupation.
     */
    @Test
    void testOccupy() {
        // Remove the following placeholder:
//        assertThat(unit).isNotNull();
        Square s = new Square() {
            @Override
            public boolean isAccessibleTo(Unit unit) {
                return true;
            }

            @Override
            public Sprite getSprite() {
                return null;
            }
        };
        unit.occupy(s);

        // Assert that the unit is now occupying the square
        assertThat(unit.hasSquare()).isTrue();
        assertThat(unit.getSquare()).isEqualTo(s);

        assertThat(s.getOccupants()).contains(unit);
    }

    /**
     * Test that the unit indeed has the target square as its base after
     * double occupation.
     */
    @Test
    void testReoccupy() {
        // Remove the following placeholder:
//        assertThat(unit).isNotNull();
        Square first = new Square() {
            @Override
            public boolean isAccessibleTo(Unit unit) {
                return true;
            }

            @Override
            public Sprite getSprite() {
                return null;
            }
        };

        Square second = new Square() {
            @Override
            public boolean isAccessibleTo(Unit unit) {
                return true;
            }

            @Override
            public Sprite getSprite() {
                return null;
            }
        };

        //Occupy first square
        unit.occupy(first);
        // Assert that the unit is occupying the first square
        assertThat(unit.getSquare()).isEqualTo(first);
        assertThat(first.getOccupants()).contains(unit);

        // Now occupy the second square
        unit.occupy(second);
        // Assert that the unit has moved to the second square
        assertThat(unit.getSquare()).isEqualTo(second);
        assertThat(second.getOccupants()).contains(unit);

        // Assert that the first square no longer contains the unit
        assertThat(first.getOccupants()).doesNotContain(unit);
    }
}
