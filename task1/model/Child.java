package model;

public class Child {

	public int childID;
	public String childName;
	public int childAge;
	public String childCity;
	public String presentsName;

	public Child(int childID, String childName, int childAge, String childCity, String presentsName) {

		this.childID = childID;
		this.childName = childName;
		this.childAge = childAge;
		this.childCity = childCity;
		this.presentsName = presentsName;

	}

	public Child() {

		this.childID = 9999;
		this.childName = "Mickey Mouse";
		this.childAge = 90;
		this.childCity = "Disneyland";
		this.presentsName = "Lollipop";

	}

	public void printChildAdded() {
		System.out.println("******************************************************************");
		System.out.println("** [system].added to santa's list: 								**");
		System.out.println("******************************************************************");
		System.out.println("** 																**");
		System.out.println("** " + childID + " | " + childName + " | " + childAge + " | " + childCity + " | " + presentsName + " **");
		System.out.println("** 																**");
	}

	public String getChildCity() {
		return childCity;
	}
	public String getChildName() {
		return childName;
	}
}