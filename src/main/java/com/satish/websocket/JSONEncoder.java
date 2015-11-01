package com.satish.websocket;

import javax.websocket.EncodeException;
import javax.websocket.Encoder;
import javax.websocket.EndpointConfig;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

/**
 * 
 * @author satishkamavaram
 *
 */
public class JSONEncoder implements Encoder.Text<Student>{

	@Override
	public void destroy() {
		System.out.println("JSONEncoder....Destroy");
	}

	@Override
	public void init(EndpointConfig arg0) {
		System.out.println("JSONEncoder....init");
	}

	@Override
	public String encode(Student student) throws EncodeException {
		 GsonBuilder builder = new GsonBuilder();
	     Gson gson = builder.create();
	     System.out.println("JSONEncoder....encode.."+gson.toJson(student));
		 return gson.toJson(student);
	}
}
