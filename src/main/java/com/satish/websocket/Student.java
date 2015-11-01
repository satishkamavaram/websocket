package com.satish.websocket;

/**
 * 
 * @author satishkamavaram
 *
 */
public class Student {

	private String id;
	private String name;
	
	public Student(){
		
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	
	/*public Student(JsonObject jsonObject)
	{
		this.jsonObject = jsonObject;
	}

	public JsonObject getJsonObject() {
		return jsonObject;
	}

	public void setJsonObject(JsonObject jsonObject) {
		this.jsonObject = jsonObject;
	}
	
	@Override
	public String toString()
	{
		StringWriter stringWriter = new StringWriter();
		Json.createWriter(stringWriter).write(jsonObject);
		return stringWriter.toString();
	}*/
}
