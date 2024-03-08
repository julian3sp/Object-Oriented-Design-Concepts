import org.junit.Test;

import java.io.IOException;

import static org.junit.Assert.assertEquals;

public class Examples {

    @Test
    public void test_animalwords() throws IOException {
        AnimalWords aw = new AnimalWords();
        assertEquals(400, aw.getWords().length);
    }


    @Test
    public void testTypicalCase(){
        WordGame wg = new WordGame("test");
        wg.guessLetter("t");
        wg.guessLetter("e");
        wg.guessLetter("s");
        wg.guessWord("test");
        assertEquals(WordGame.STATUS.WON, wg.currentStatus());
    }
}
