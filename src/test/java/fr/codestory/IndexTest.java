package fr.codestory;

import org.junit.Test;

import static net.sourceforge.jwebunit.junit.JWebUnit.assertTitleEquals;
import static net.sourceforge.jwebunit.junit.JWebUnit.beginAt;
import static net.sourceforge.jwebunit.junit.JWebUnit.setBaseUrl;

public class IndexTest extends AbstractWebTest {

    @Test
    public void should_say_coucou() {

        setBaseUrl(getURL());

        beginAt("/");
        assertTitleEquals("Code Story 2013");
    }
}
