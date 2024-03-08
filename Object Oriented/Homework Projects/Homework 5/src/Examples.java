import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class Examples {
    IBinTree mt = new EmptyBT();

    @Test
    public void validateAddedContainsElt(){
        MaxHeapValidator validator = new MaxHeapValidator();
        assertTrue(validator.validAdd(mt, 3, new NodeBT(3, mt, mt)));
        assertFalse(validator.validAdd(mt, 4, new NodeBT(3, mt, mt)));
    }
    @Test
    public void validateRemovedContainsElt(){
        MaxHeapValidator validator = new MaxHeapValidator();
        assertTrue(validator.validRemove(new NodeBT(3, mt, mt), 3, mt));
        assertFalse(validator.validRemove(new NodeBT(3, mt, mt), 3, (new NodeBT(3, mt, mt))));
    }
    @Test
    public void validateAddedTooManyElements(){
        MaxHeapValidator validator = new MaxHeapValidator();
        assertFalse(validator.validAdd(mt, 3, new NodeBT(3, new NodeBT(0, mt, mt), mt)));
    }
    @Test
    public void validateRemovedTooManyElements(){
        MaxHeapValidator validator = new MaxHeapValidator();
        assertFalse(validator.validRemove(new NodeBT(4, new NodeBT(2, mt, mt), new NodeBT(3, mt, mt)),
                3, new NodeBT(4, mt, mt)));
    }
    @Test
    public void validateAddedLostElements(){
        MaxHeapValidator validator = new MaxHeapValidator();
        assertFalse(validator.validAdd(new NodeBT(4, new NodeBT(2, mt, mt), mt),
                3, new NodeBT(4, new NodeBT(3, mt, mt), mt)));
    }
    @Test
    public void validateRemovedLostElements(){
        MaxHeapValidator validator = new MaxHeapValidator();
        assertFalse(validator.validRemove(new NodeBT(4, new NodeBT(2, mt, mt), new NodeBT(3, mt, mt)),
                3, new NodeBT(4, mt, mt)));
    }
    @Test
    public void validateAddedValidMaxHeap(){
        MaxHeapValidator validator = new MaxHeapValidator();
        assertFalse(validator.validAdd(new NodeBT(4, new NodeBT(2, mt, mt), mt), 3,
                new NodeBT(3, new NodeBT(4, new NodeBT(2, mt, mt), mt), mt)));
    }
    @Test
    public void validateRemovedValidMaxHeap(){
        MaxHeapValidator validator = new MaxHeapValidator();
        assertFalse(validator.validRemove(new NodeBT(4, new NodeBT(3, new NodeBT(2, mt, mt), mt), mt),
                4, new NodeBT(2, new NodeBT(3, mt, mt), mt)));
    }
    @Test
    public void validateRemovedNewInOld() {
        MaxHeapValidator validator = new MaxHeapValidator();
        assertFalse(validator.validRemove(new NodeBT(5, new NodeBT(2, mt, mt), new NodeBT(3, mt, mt)),
                3, new NodeBT(5, new NodeBT(2, mt, mt), new NodeBT(4, mt, mt))));
    }
}
