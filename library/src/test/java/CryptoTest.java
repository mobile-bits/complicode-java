/**
 * Created by iluretar on 02-Apr-15.
 */
import com.mobilebits.facturacodigocontrol.crypto.*;
import org.junit.Test;
import static org.junit.Assert.*;

public class CryptoTest {

    @Test
    public void testBase64() {

        Base64 base64 = new Base64();

        String result =base64.generate(19058106);
        assertEquals("18isw", result);

    }

    @Test
    public void testVerhoeff() {

        Verhoeff verhoeff = new Verhoeff();
        String value = "1503";

        value= value + verhoeff.generate(value);
        assertEquals("15031", value);

    }

    @Test
    public void testARC4() {

        ARC4 arc4 = new ARC4("Key");
        String result =arc4.generate("Plaintext");
        assertEquals("BBF316E8D940AF0AD3", result);

    }
}
