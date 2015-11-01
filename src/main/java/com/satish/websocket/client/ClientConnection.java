package com.satish.websocket.client;

import java.io.IOException;
import java.net.URI;

import javax.websocket.ContainerProvider;
import javax.websocket.DeploymentException;
import javax.websocket.WebSocketContainer;

public class ClientConnection {

	static
	{
		WebSocketContainer container = ContainerProvider.getWebSocketContainer();
		String uri = "ws://localhost:8080/websocket" + "/lastStudent";
		try {
			container.connectToServer(WebSocketClient.class, URI.create(uri));
		} catch (DeploymentException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
