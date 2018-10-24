import com.che.test.AppTest;
import org.junit.runner.JUnitCore;

import javax.xml.bind.JAXBException;

public class App
{
    public static void main( String[] args ) throws JAXBException
    {
        JUnitCore jUnitCore = new JUnitCore();
        jUnitCore.run(AppTest.class);
    }

}
