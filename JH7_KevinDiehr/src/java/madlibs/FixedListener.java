/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package madlibs;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

/**
 * Web application lifecycle listener.
 *
 * @author Kevin Diehr
 */
public class FixedListener implements ServletContextListener {

    ConnectionPool connectionPool;
    SentenceCollection sentenceCollection;
    
    @Override
    public void contextInitialized(ServletContextEvent sce) {
        System.out.println("@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@");
        connectionPool = new ConnectionPool();
        sentenceCollection = new SentenceCollection(connectionPool);
        System.out.println(sentenceCollection);
        sce.getServletContext().setAttribute("sentenceCollection", sentenceCollection);
        System.out.println("@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@");
        
        //app starts
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {
        connectionPool.closeAllConnections();
        //app ends
    }
}
