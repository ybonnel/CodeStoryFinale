package fr.codestory;

import org.junit.After;
import org.junit.Before;
import org.mortbay.jetty.Server;

import java.util.Random;


public abstract class AbstractWebTest {


    private Integer portNumber;

    private final Random random = new Random();

    protected int getRandomPort() {
        return random.nextInt(1000) + 20000;
    }

    private int getPortNumber() {
        if (portNumber == null) {
            portNumber = getRandomPort();
        }
        return portNumber;
    }

    public String getURL() {
        return getURL(getPortNumber());
    }

    public static String getURL(int portNumber) {
        return "http://localhost:" + portNumber + '/';
    }

    private Server server;

    @Before
    public void startServer() throws Exception {

        server = WebServer.getServer(getPortNumber());
        server.start();
    }

    @After
    public void stopServer() throws Exception {
        server.stop();
    }
}
