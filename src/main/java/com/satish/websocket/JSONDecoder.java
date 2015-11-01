package com.satish.websocket;


import javax.websocket.DecodeException;
import javax.websocket.Decoder;
import javax.websocket.EndpointConfig;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
/**
 * 
 * @author satishkamavaram
 *
 */
public class JSONDecoder implements Decoder.Text<Student>{

	@Override
	public void destroy() {
		System.out.println("JSONDecoder....Destroy");
	}

	@Override
	public void init(EndpointConfig arg0) {
		System.out.println("JSONDecoder....init");
	}

	@Override
	public Student decode(String json) throws DecodeException {
		System.out.println("JSONDecoder...decoding");
		//JsonObject jsonObject = Json.createReader(new StringReader(json)).readObject();
		GsonBuilder builder = new GsonBuilder();
	    Gson gson = builder.create();
	    return gson.fromJson(json, Student.class);
	}

	@Override
	public boolean willDecode(String json) {
		System.out.println("JSONDecoder....willdecode..."+json);
		if(json==null)
			return false;
		else 
			return true;
	}

	


}
