/**
 * Created by iluretar on 04-Apr-15.
 */

import com.mobilebits.complicode.CompliCode;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import static org.junit.Assert.*;

public class CodeTest {

    @Test
    public void testCode() {

        Date date=null;
        try {
            date = new SimpleDateFormat("yyyyMMdd").parse("20070702");
        } catch (ParseException e) {
            e.printStackTrace();
        }

        String code = new CompliCode.Builder()
                .authorization("29040011007")
                .nit("4189179011")
                .number(1503)
                .date(date)
                .amount(2500.0)
                .key("9rCB7Sv4X29d)5k7N%3ab89p-3(5[A")
                .build();

        assertEquals("6A-DC-53-05-14", code);
    }

    @Test
    public void testNitZero() {

        Date date=null;
        try {
            date = new SimpleDateFormat("yyyyMMdd").parse("20080201");
        } catch (ParseException e) {
            e.printStackTrace();
        }

        String code = new CompliCode.Builder()
                .authorization("1904008691195")
                .number(978256)
                .date(date)
                .amount(26006.0)
                .key("pPgiFS%)v}@N4W3aQqqXCEHVS2[aDw_n%3)pFyU%bEB9)YXt%xNBub4@PZ4S9)ct")
                .build();

        assertEquals("62-12-AF-1B", code);
    }

    @Test
    public void testRoundAmount() {
        String codeRoundedUp,codeRoundedDown,codeUp,codeDown;
        Date date=null;

        try {
            date = new SimpleDateFormat("yyyyMMdd").parse("20080201");
        } catch (ParseException e) {
            e.printStackTrace();
        }

        codeUp = new CompliCode.Builder()
                .authorization("1904008691195")
                .nit("0")
                .number(978256)
                .date(date)
                .amount(26006.0)
                .key("pPgiFS%)v}@N4W3aQqqXCEHVS2[aDw_n%3)pFyU%bEB9)YXt%xNBub4@PZ4S9)ct")
                .build();

        codeDown = new CompliCode.Builder()
                .authorization("1904008691195")
                .nit("0")
                .number(978256)
                .date(date)
                .amount(26005.0)
                .key("pPgiFS%)v}@N4W3aQqqXCEHVS2[aDw_n%3)pFyU%bEB9)YXt%xNBub4@PZ4S9)ct")
                .build();

        codeRoundedUp = new CompliCode.Builder()
                .authorization("1904008691195")
                .nit("0")
                .number(978256)
                .date(date)
                .amount(26005.65)
                .key("pPgiFS%)v}@N4W3aQqqXCEHVS2[aDw_n%3)pFyU%bEB9)YXt%xNBub4@PZ4S9)ct")
                .build();

        codeRoundedDown = new CompliCode.Builder()
                .authorization("1904008691195")
                .nit("0")
                .number(978256)
                .date(date)
                .amount(26005.23)
                .key("pPgiFS%)v}@N4W3aQqqXCEHVS2[aDw_n%3)pFyU%bEB9)YXt%xNBub4@PZ4S9)ct")
                .build();

        assertEquals(codeUp, codeRoundedUp);
        assertEquals(codeDown, codeRoundedDown);
    }

    @Rule
    public ExpectedException thrown = ExpectedException.none();

    @Test
    public void testMissingMember() throws Exception {
        thrown.expect(NullPointerException.class);
        Date date=null;

        try {
            date = new SimpleDateFormat("yyyyMMdd").parse("20080201");
        } catch (ParseException e) {
            e.printStackTrace();
        }

         new CompliCode.Builder()
                //.authorization("1904008691195")
                .number(978256)
                .date(date)
                .amount(26006.0)
                .key("pPgiFS%)v}@N4W3aQqqXCEHVS2[aDw_n%3)pFyU%bEB9)YXt%xNBub4@PZ4S9)ct")
                .build();
    }
}
