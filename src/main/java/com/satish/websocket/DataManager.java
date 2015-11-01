package com.satish.websocket;

import java.util.ArrayList;
import java.util.List;



/**
 * 
 * @author satishkamavaram
 *
 */
public class DataManager {

	private static volatile DataManager dataManager = new DataManager();
	
	private List<Student> listOfStudents = new ArrayList<Student>();
	
	private DataManager()
	{
		
	}
	
	public static DataManager getDataManager()
	{
		return dataManager;
	}

	public List<Student> getListOfStudents() {
		return listOfStudents;
	}

	public void setListOfStudents(List<Student> listOfStudents) {
		this.listOfStudents = listOfStudents;
	}

	public void addStudent(Student student)
	{
		listOfStudents.add(student);
	}
	
	public Student getLatestStudent()
	{
		return listOfStudents.get(listOfStudents.size()-1);
	}
	
	public int getNumberOfStudents()
	{
		return listOfStudents.size();
	}
	
}
