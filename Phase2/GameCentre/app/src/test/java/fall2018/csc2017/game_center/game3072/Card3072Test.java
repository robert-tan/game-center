package fall2018.csc2017.game_center.game3072;

import org.junit.Test;
import org.mockito.Mock;
import android.content.Context;

import static org.junit.Assert.*;

public class Card3072Test {

    @Mock
    private Context mMockContext;

    @Test
    public void getNum() {
        Card3072 card1 = new Card3072(mMockContext);
        for (int i = 1; i < 13; i++) {
            card1.setNum(i);
            assertEquals(i, card1.getNum());
        }
    }

    @Test
    public void setNum() {
        Card3072 card2 = new Card3072(mMockContext);
        for (int i = 1; i < 13; i++) {
            card2.setNum(i);
            assertEquals(i, card2.getNum());
        }
    }

    //TODO: change this number
    @Test
    public void getCardWidth() {
        Card3072 card3 = new Card3072(mMockContext);
        assertEquals(0, card3.getCardWidth());
    }

    @Test
    public void equals() {
        Card3072 card4 = new Card3072(mMockContext);
        Card3072 card5 = new Card3072(mMockContext);
        card4.setNum(3072);
        card5.setNum(1536);
        assertEquals(card4.getNum(),card5.getNum() * 2);
    }

    //TODO or not?
    //@Test
    //public void hashCode() {
    //}
}