package ugyfel_gate_rest;

import com.project.ugyfel_gate_rest.MD5;
import org.junit.Test;

import javax.xml.bind.DatatypeConverter;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import static junit.framework.Assert.assertEquals;
import static org.hamcrest.MatcherAssert.assertThat;

public class MD5Test
{
    @Test
    public void givenPassword_whenHashing_thenVerifying()
            throws NoSuchAlgorithmException {
        String hash = "35454B055CC325EA1AF2126E27707052";
        String password = "ILoveJava";
        System.out.println(MD5.Translate_to_MD5_HASH(password));
        assertEquals(MD5.Translate_to_MD5_HASH(password), hash);
    }
}
