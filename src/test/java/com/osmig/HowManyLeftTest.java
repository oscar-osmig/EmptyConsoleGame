package com.osmig;
import org.junit.jupiter.api.Test;
//import org.junit.Test;

import static org.junit.jupiter.api.Assertions.*;

class HowManyLeftTest {

    @Test
    void aiMove() {

        assertEquals(1, HowManyLeft.aiMove(5));
    }
}