package test;
import com.company.SocialNetwork;
import org.junit.Assert;
import org.junit.Test;

import java.io.IOException;
import java.util.ArrayList;

/**
 * Created by marvindo on 9/21/17.
 */
public class SocialNetworkTest {

    @Test
    public void testSimpleDictionary1() {
        SocialNetwork network = new SocialNetwork("example.txt");
        Assert.assertEquals(network.findNetworkSize("HI"), 7);
    }

    @Test
    public void testSimpleDictionary2() {
        SocialNetwork network = new SocialNetwork("example.txt");
        Assert.assertEquals(network.findNetworkSize("HEAR"), 7);
    }

    @Test
    public void testOneWordDictionary() {
        SocialNetwork network = new SocialNetwork("empty.txt");
        Assert.assertEquals(network.findNetworkSize("HI"), 1);
    }

    @Test
    public void testVerySmallTestDictionary() {
        SocialNetwork network = new SocialNetwork("very_small_test_dictionary.txt");
        Assert.assertEquals(network.findNetworkSize("LISTY"), 5);
    }

    @Test
    public void testVerySmallTest2Dictionary() {
        SocialNetwork network = new SocialNetwork("very_small_test_dictionary.txt");
        Assert.assertEquals(network.findNetworkSize("FIST"), 5);
    }

    @Test
    public void testVerySmallTest3Dictionary() {
        SocialNetwork network = new SocialNetwork("very_small_test_dictionary.txt");
        Assert.assertEquals(network.findNetworkSize("LUSTY"), 5);
    }

}
