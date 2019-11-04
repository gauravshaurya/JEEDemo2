package com.iris.listeners;

import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

@WebListener
public class MyListener implements HttpSessionListener {

    public MyListener() {
     
    }

    public void sessionCreated(HttpSessionEvent se)  { 
       
    }

    public void sessionDestroyed(HttpSessionEvent se)  { 
        
    }
	
}
