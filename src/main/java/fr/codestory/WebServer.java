package fr.codestory;


import org.mortbay.jetty.Handler;
import org.mortbay.jetty.Server;
import org.mortbay.jetty.handler.AbstractHandler;
import org.mortbay.jetty.handler.HandlerList;
import org.mortbay.jetty.handler.ResourceHandler;
import org.mortbay.resource.Resource;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;

public class WebServer extends AbstractHandler {

    @Override
    public void handle(String s, HttpServletRequest httpServletRequest, HttpServletResponse resp, int i) throws IOException, ServletException {
        String path = httpServletRequest.getPathInfo();

        if (path.startsWith("/data")) {
            resp.setStatus(404);
            PrintWriter writer = resp.getWriter();
            writer.print("Not Implemented");
            writer.close();
        }


        //http://code-story.net/data/codestory2013.json

    }

    public static void main(String[] args) throws Exception {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss,SSS");
        System.err.println(sdf.format(new Date()) + ":ybo-tv-server starting");
        int defaultPort = 8080;
        if (args.length == 1) {
            defaultPort = Integer.parseInt(args[0]);
        }

        Server server = getServer(defaultPort);

        server.start();
        server.join();

        System.err.println(sdf.format(new Date()) + ":ybo-tv-server stopped");
    }

    static Server getServer(int defaultPort) {
        Server server = new Server(defaultPort);

        ResourceHandler resourceHandler = new ResourceHandler();
        Resource publicResources = Resource.newClassPathResource("/public");
        resourceHandler.setBaseResource(publicResources);
        resourceHandler.setWelcomeFiles(new String[]{"index.html"});

        HandlerList handlers = new HandlerList();
        handlers.setHandlers(new Handler[]{new WebServer(), resourceHandler});
        server.setHandler(handlers);
        return server;
    }
}
