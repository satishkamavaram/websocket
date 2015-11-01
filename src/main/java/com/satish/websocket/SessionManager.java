package com.satish.websocket;

import java.util.ArrayList;
import java.util.List;

import javax.websocket.Session;
/**
 * 
 * @author satishkamavaram
 *
 */
public class SessionManager {
	
	private static volatile SessionManager sessionManager = new SessionManager();
	
	private List<Session> listOfClientSessions = new ArrayList<Session>();
	
	private SessionManager()
	{
		
	}
	
	public static SessionManager getSessionManager()
	{
		return sessionManager;
	}

	public List<Session> getListOfClientSessions() {
		return listOfClientSessions;
	}

	public void setListOfClientSessions(List<Session> listOfClientSessions) {
		this.listOfClientSessions = listOfClientSessions;
	}
	
	public void addSession(Session session)
	{
		listOfClientSessions.add(session);
	}
	
	public void removeSession(Session session)
	{
		listOfClientSessions.remove(session);
	}
	
	
}