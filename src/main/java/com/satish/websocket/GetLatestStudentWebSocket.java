package com.satish.websocket;


import java.io.IOException;

import javax.websocket.EncodeException;
import javax.websocket.OnClose;
import javax.websocket.OnError;
import javax.websocket.OnMessage;
import javax.websocket.OnOpen;
import javax.websocket.Session;
import javax.websocket.server.ServerEndpoint;
/**
 * 
 * @author satishkamavaram
 *
 */
@ServerEndpoint(value="/lastStudent",encoders={JSONEncoder.class},decoders={JSONDecoder.class})
public class GetLatestStudentWebSocket  {

	private SessionManager sessionManager = SessionManager.getSessionManager();
	private DataManager dataManager = DataManager.getDataManager();
	
	@OnOpen
    public void open(Session session) {
		System.out.println("Opening and adding Session to cache : "+session.getId());
		sessionManager.addSession(session);
		try {
			if(dataManager.getNumberOfStudents()>0)
				session.getBasicRemote().sendObject(dataManager.getLatestStudent());
		} catch (IOException | EncodeException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}catch(Exception ex)
		{
			ex.printStackTrace();
		}
	}

	@OnClose
    public void close(Session session) {
		System.out.println("Closing and removing Session from cache : "+session.getId());
		sessionManager.removeSession(session);
	}

	@OnError
    public void onError(Throwable error) {
		System.out.println("Error : "+error.getMessage());
		error.printStackTrace();
	}

	@OnMessage
    public void handleMessage(String string, Session session) {
		System.out.println("incoming message : "+string);
	}
	
}

	
