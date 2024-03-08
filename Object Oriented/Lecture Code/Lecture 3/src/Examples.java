import org.junit.jupiter.api.Test;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertFalse;

public class Examples {

    public Album juliansJazzAlbum = new Album("Julian", "Jazz");
    public Album profEngling;
    public Album profAhrensRapAlbum = new Album("Ahrens", "Rap");
    public Song inTheJungle = new Song("In The Jungle", profAhrensRapAlbum);
    public Song codeIsPoetry = new Song("Code is Poetry", juliansJazzAlbum);

    public Examples(){
        profEngling = new Album("Prof. Engling", "Spoken Poetry");
    }
    @Test
    public void testTwoSongsOnSameAlbum(){
        assertFalse(inTheJungle.onSameAlbum(codeIsPoetry));
    }
    @Test
    public void testSameGenre(){
        assertFalse(inTheJungle.hasSameGenre(codeIsPoetry));
    }
}
