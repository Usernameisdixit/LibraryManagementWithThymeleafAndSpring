package com.csm.model;

//LibraryAndApplicant.java
public class LibraryAndApplicant {
	private Library library;
	private Applicant applicant;

	// Constructors

	public LibraryAndApplicant() {
		this.library = new Library();
		this.applicant = new Applicant();
	}

	// Getters and setters

	public Library getLibrary() {
		return library;
	}

	public void setLibrary(Library library) {
		this.library = library;
	}

	public Applicant getApplicant() {
		return applicant;
	}

	public void setApplicant(Applicant applicant) {
		this.applicant = applicant;
	}
}
