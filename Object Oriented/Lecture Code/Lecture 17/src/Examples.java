import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class Examples {

    IBinTree mt = new EmptyBT();
    @Test
    public void validCalls(){
        IBinTree baseBST = new NodeBT(5,
                                          new NodeBT( 1, mt, mt),
                                          new NodeBT(9, mt, mt));
        BSTValidator bstValidator = new BSTValidator();
        // pretend to add 4

        IBinTree goodNewBST4 = new NodeBT(5,
                new NodeBT( 1, mt, new NodeBT(4, mt, mt)),
                new NodeBT(9, mt, mt));

        assertTrue(bstValidator.validAdd(baseBST, 4, goodNewBST4));
        assertTrue(bstValidator.validRemove(goodNewBST4,4,baseBST));

        // pretend to add 6
        IBinTree goodNewBST6 = new NodeBT(5,
                new NodeBT( 1, mt, mt),
                new NodeBT(9, new NodeBT(6,mt,mt), mt));

        assertTrue(bstValidator.validAdd(baseBST, 6, goodNewBST6));
        assertTrue(bstValidator.validRemove(goodNewBST6,6,baseBST));

    }

    @Test
    public void invalidAdds(){
        IBinTree baseBST = new NodeBT(5,
                new NodeBT( 1, mt, mt),
                new NodeBT(9, mt, mt));
        BSTValidator bstValidator = new BSTValidator();
        // pretend to add 4, but just add it to the left most

        IBinTree badNewBST4 = new NodeBT(5,
                new NodeBT( 1, new NodeBT(4, mt, mt), mt),
                new NodeBT(9, mt, mt));

        assertFalse(bstValidator.validAdd(baseBST, 4, badNewBST4));

        // pretend to add 6, but just add it to the right most
        IBinTree badNewBST6 = new NodeBT(5,
                new NodeBT( 1, mt, mt),
                new NodeBT(9, mt, new NodeBT(6,mt,mt)));

        assertFalse(bstValidator.validAdd(baseBST, 6, badNewBST6));

    }
}
