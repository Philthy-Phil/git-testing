package model;

import controller.ElfUtil;

public class Elf extends ElfUtil {

	public int elfID;
	public String elfName;
	public String elfTier;
	public int elfAge;
	public String elfCity;

	public Elf(int elfID, String elfName) {

		this.elfID = elfID;
		this.elfName = elfName + " Santa's Henchman";
		this.elfTier = super.elfSetRandomTier();
		this.elfAge = super.elfSetRandomAge();
		this.elfCity = "Snowy White";

	}

	public Elf() {

		this.elfName = "Dullnose Santa's Henchman";
		this.elfTier = "Expert";
		this.elfAge = super.elfSetRandomAge();
		this.elfCity = "Snowy White";

	}

	public void printElfAdded() {
		System.out.println("******************************************************************");
		System.out.println("** [system].stamped in to today's shift:						**");
		System.out.println("******************************************************************");
		System.out.println("** 																**");
		System.out.println("** " + elfID + " | " + elfName + " | " + elfTier + " | " + elfAge + " | " + elfCity + " **");
		System.out.println("** 																**");
	}

}
