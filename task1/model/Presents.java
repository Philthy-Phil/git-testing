package model;

public class Presents {

	public String presentsName;
	public Child child;

	public Presents(String presentsName, Child child) {

		this.presentsName = presentsName;
		this.child = child;

	}

	public Presents() {

		this.presentsName = "Super Christmas Lollipop";
		this.child = new Child();

	}

}
