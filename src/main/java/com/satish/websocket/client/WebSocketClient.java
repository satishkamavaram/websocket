package com.satish.websocket.client;

import java.io.IOException;

import javax.websocket.ClientEndpoint;
import javax.websocket.OnClose;
import javax.websocket.OnError;
import javax.websocket.OnMessage;
import javax.websocket.OnOpen;
import javax.websocket.Session;

@ClientEndpoint
public class WebSocketClient {

	@OnOpen
    public void open(Session session) {
		System.out.println("Opening client Session : "+session.getId());
		try {
			session.getBasicRemote().sendText("test");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@OnClose
    public void close(Session session) {
		System.out.println("Closing client Session : "+session.getId());
	}

	@OnError
    public void onError(Throwable error) {
		System.out.println("Client Error : "+error.getMessage());
		error.printStackTrace();
	}

	@OnMessage
    public String handleMessage(String message, Session session) {
		System.out.println("Client recieved message" +message+" from session : "+session.getId());
		return "success!";
	}
}
