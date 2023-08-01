
import com.Model.AudioPlayerMethods;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;


import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Scanner;


import static org.junit.Assert.assertEquals;

public class AudioPlayerMethodsTest {

    AudioPlayerMethods audioPlayerMethods = null;

    @Before
    public void setUp(){
        audioPlayerMethods=new AudioPlayerMethods();

    }

    @After
    public void tearDown(){
        audioPlayerMethods=null;
    }

    @Test
    public void  givenCorrectData() throws FileNotFoundException{

    }
}
