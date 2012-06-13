package com.action;

public class WelcomeUser 
{
	private String title;
	private String userName;
	private String message;
	private String bio;
	
	private Artist artist;
	
	public String execute()
	{
		setMessage("Hello Dude "+userName);
		System.out.println("jsdjjshkfdhkfgasjdghkjasgfasgfasjd");
		title = "Thriller";
		setArtist(new Artist("King of pop"));
		return "success";
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getBio() {
		return bio;
	}

	public void setBio(String bio) {
		this.bio = bio;
	}

	public void setArtist(Artist artist) {
		this.artist = artist;
	}

	public Artist getArtist() {
		return artist;
	}
	

}
