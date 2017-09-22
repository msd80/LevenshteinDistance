package test;
import com.company.DetermineFriends;
import org.junit.Assert;
import org.junit.Test;

/**
 * Created by marvindo on 9/19/17.
 */
public class DetermineFriendsTest {

    @Test
    public void testIsEqual() {
        String test1 = "TEST";
        Assert.assertTrue(!DetermineFriends.isFriends(test1, test1));
    }

    @Test
    public void testIsOneCharReplacementTrue() {
        String test1 = "TEST";
        String test2 = "TAST";
        Assert.assertTrue(DetermineFriends.isFriends(test1, test2));

        String test3 = "CHARAST";
        String test4 = "CHARACT";
        Assert.assertTrue(DetermineFriends.isFriends(test3, test4));
    }

    @Test
    public void testIsOneCharReplacementFalse() {
        String test1 = "TEST";
        String test2 = "TACT";
        Assert.assertFalse(DetermineFriends.isFriends(test1, test2));

        String test3 = "ABCD";
        String test4 = "ADBC";
        Assert.assertFalse(DetermineFriends.isFriends(test3, test4));
    }

    @Test
    public void testIsOneCharAdditionLonger() {
        String test1 = "TEST";
        String test2 = "TEAST";
        Assert.assertTrue(DetermineFriends.isFriends(test1, test2));

        String test3 = "ATEST";
        Assert.assertTrue(DetermineFriends.isFriends(test1, test3));

    }

    @Test
    public void testIsOneCharAdditionShorter() {
        String test1 = "TEST";
        String test2 = "TEAST";
        Assert.assertTrue(DetermineFriends.isFriends(test2,test1));

        String test3 = "TSETE";
        Assert.assertFalse(DetermineFriends.isFriends(test1, test3));
        Assert.assertFalse(DetermineFriends.isFriends(test3, test1));
    }

    @Test
    public void testIsFriendsFirstCase() {

    }
    @Test
    public void testIsFriendsSecondCase() {

    }
    @Test
    public void testIsFriendsThirdCase() {

    }
    @Test
    public void testIsFriendsFourthCase() {

    }

}
