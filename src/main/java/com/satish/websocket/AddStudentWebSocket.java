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
@ServerEndpoint(value="/addStudent",encoders={JSONEncoder.class},decoders={JSONDecoder.class})
public class AddStudentWebSocket  {

	private SessionManager sessionManager = SessionManager.getSessionManager();
	private DataManager dataManager = DataManager.getDataManager();
	
	@OnOpen
    public void open(Session session) {
		System.out.println("Opening  Session : "+session.getId());
		//sessionManager.addSession(session);
	}

	@OnClose
    public void close(Session session) {
		System.out.println("Closing  Session : "+session.getId());
		//sessionManager.removeSession(session);
	}

	@OnError
    public void onError(Throwable error) {
		System.out.println("Error : "+error.getMessage());
		error.printStackTrace();
	}

	@OnMessage
    public String handleMessage(Student student, Session session) {
		System.out.println("Student id : "+student.getId()+" , name : "+student.getName()+" , from session : "+session.getId());
		dataManager.addStudent(student);
		sessionManager.getListOfClientSessions().stream().forEach(s -> sendMessage(s,student));
		return "Studnet added Successfully!";
	}
	
	private void sendMessage(Session session,Student student)
	{
		try {
			session.getBasicRemote().sendObject(student);
		} catch (IOException | EncodeException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}

	
