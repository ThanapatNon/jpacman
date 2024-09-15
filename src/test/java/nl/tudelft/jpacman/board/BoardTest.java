package nl.tudelft.jpacman.board;
import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

public class BoardTest {
    @Test
    public void createBoardTest(){
        BasicSquare[][] bs = new BasicSquare[1][1];
        bs[0][0] = new BasicSquare();

        Board b = new Board(bs);
        assertThat(b.invariant()).isTrue();

        assertThat(b.squareAt(0,0).invariant()).isTrue();

    }

    @Test
    public void createNullBoardTest() {
        BasicSquare[][] bs = new BasicSquare[1][1];
        bs[0][0] = null;
        Board b = new Board(bs);
        assertThat(b.invariant()).isFalse();
        assertThat(b.squareAt(0,0).invariant()).isTrue();

    }

}
