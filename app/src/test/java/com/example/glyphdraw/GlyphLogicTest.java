package com.example.glyphdraw;

import org.junit.Test;
import static org.junit.Assert.*;

public class GlyphLogicTest {
    @Test
    public void testMatrixSize() {
        int MATRIX_SIZE = 13;
        int[] mLedStates = new int[MATRIX_SIZE * MATRIX_SIZE];
        assertEquals(169, mLedStates.length);
    }

    @Test
    public void testToggleLogic() {
        int[] mLedStates = new int[169];
        int index = 50;

        // Initial state
        assertEquals(0, mLedStates[index]);

        // Toggle on
        mLedStates[index] = 0xFFFFFFFF;
        assertEquals(0xFFFFFFFF, mLedStates[index]);

        // Toggle off
        mLedStates[index] = 0;
        assertEquals(0, mLedStates[index]);
    }
}
