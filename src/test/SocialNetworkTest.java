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
    public void testSimpleDictionary() {
        SocialNetwork network = new SocialNetwork("example.txt");
        Assert.assertEquals(network.findNetworkSize("HI"), 7);
     //   Assert.assertEquals(network.findNetworkSize("HEAR"), 7);
        Assert.assertEquals(network.findNetworkSize("HALLOW"), 1);
    }

    @Test
    public void testVerySmallTestDictionary() {
        SocialNetwork network = new SocialNetwork("very_small_test_dictionary.txt");
        Assert.assertEquals(network.findNetworkSize("LISTY"), 5);
    }

}