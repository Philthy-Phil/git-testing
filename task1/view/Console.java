package view;

import controller.ElfUtil;
import model.Child;
import model.Elf;
import model.Presents;
import model.Sledge;

import java.util.ArrayList;
import java.util.Scanner;

public class Console extends ElfUtil {

	public Scanner scanBot = new Scanner(System.in);
	public int ID = 1;
	public int elfID = 1;
	public Sledge sledge = new Sledge();

	ArrayList<Child> children = new ArrayList<>();
	ArrayList<Presents> vault = new ArrayList<>();
	ArrayList<Elf> shift = new ArrayList<>();

	// display login screen
	public void dialogLoginScreen() {

		System.out.println("##################################################################");
		System.out.println("##          Welcome to the Login-Screen of Santa's App!         ##");
		System.out.println("##################################################################");
		System.out.println();
		System.out.println("******************************************************************");
		System.out.println("** [system].Please login to proceed to your home-screen:		**");
		System.out.println("******************************************************************");
		System.out.println("** [1].Santa													**");
		System.out.println("** [2].Elf														**");
		System.out.println("** [3].Child													**");
		System.out.println("******************************************************************");

		String input = scanBot.nextLine();
		switch (input) {
			case "1" -> dialogSanta();	// login as Santa
			case "2" -> dialogElf(); 	// login as Elf
			case "3" -> dialogChild();	// login as Child
			default -> {
				dialogError();
				dialogLoginScreen();
			}
		}

	}

	// display santa home-screen
	public void dialogSanta() {

		String usr = "santa";
		System.out.println("******************************************************************");
		System.out.println("** [system].HoHoHo Santa! what would you like to do?			**");
		System.out.println("******************************************************************");
		System.out.println("** [1].list all presents stored in xmas-vault.					**");
		System.out.println("** [2].list all children & their wishes.						**");
		System.out.println("** [3].check sledge-load-status.								**");
		System.out.println("** [4].list all working elves for today's shift.				**");
		System.out.println("** [5].search for a specific child-name.						**");
		System.out.println("** [x].logout / back to Login-Screen.							**");
		System.out.println("******************************************************************");

		String input = scanBot.nextLine();
		switch (input) {
			case "1" -> {
				dialogShowSantaVaultItems();
				backToHome(usr);
			}
			case "2" -> {
				dialogShowSantaVaultItemsInclusiveInfos();
				backToHome(usr);
			}
			case "3" -> {
				dialogShowSantaSledgeStatus();
				backToHome(usr);
			}
			case "4" -> {
				dialogShowSantaTodayShift();
				backToHome(usr);
			}
			case "5" -> {
				dialogShowSantaSearchChild();
				backToHome(usr);
			}
			case "x" -> {
				dialogLoginScreen();
			}
			default -> {
				dialogError();
				dialogSanta();
			}
		}
	}

	// display elf home-screen
	public void dialogElf() {

		String usr = "elf";
		System.out.println("******************************************************************");
		System.out.println("** [system].HoHoHo my little elf! what would you like to do? 	**");
		System.out.println("******************************************************************");
		System.out.println("** [1].register in today's shift.								**");
		System.out.println("** [2].sort presents by country.								**");
		System.out.println("** [3].prepare loading the sledge.								**");
		System.out.println("** [4].prepare unloading the sledge.							**");
		System.out.println("** [x].logout / back to Login-Screen.							**");
		System.out.println("******************************************************************");

		String input = scanBot.nextLine();
		switch (input) {
			case "1" -> {
				System.out.println("******************************************************************");
				System.out.println("** [system].ok let's get some things done.						**");
				System.out.println("******************************************************************");
				dialogRegisterElfForShift();
				backToHome(usr);
			}
			case "2" -> {
				System.out.println("******************************************************************");
				System.out.println("** [system].sorting presents by country.						**");
				System.out.println("******************************************************************");
				dialogElfSortingChildren();
				backToHome(usr);
			}
			case "3" -> {
				System.out.println("******************************************************************");
				System.out.println("** [system].prepare loading the sledge.							**");
				System.out.println("******************************************************************");
				dialogElvesSledgeLoad();
				backToHome(usr);
			}
			case "4" -> {
				System.out.println("******************************************************************");
				System.out.println("** [system].prepare unloading the sledge.						**");
				System.out.println("******************************************************************");
				dialogElvesSledgeUnload();
				backToHome(usr);
			}
			case "x" -> {
				dialogLoginScreen();
			}
			default -> {
				dialogError();
				dialogElf();
			}
		}
	}

	// dialog elf sorting children
	public void dialogElfSortingChildren() {

		System.out.println("**																**");
		if (children.size() == 0) {
			System.out.println("** [system].there are no children registered so far!			**");
			System.out.println("** [system].return later!										**");
		} else if (shift.size() == 0) {
			System.out.println("** [system].there are no elves here to do the sorting work!		**");
			System.out.println("** [system]. check the registered elves! return later!			**");
		} else {
			System.out.println("** [system].registered children were sorted by their countries! **");
			System.out.println("**  															**");
			System.out.println("** [system].[ID] | [Name] | [Age] | [City] | [Present]  		**");
			System.out.println("**  															**");
			elfSortingChildren(children);

			for (Child child : children) {
				System.out.println("** " + child.childID + " | " + child.childName + " | " +
						child.childAge + " | " + child.childCity + " | " + child.presentsName + " **");
			}

		}

		System.out.println("**																**");

	}

	// dialog elf sledge load
	public void dialogElvesSledgeUnload() {

		sledge.status = elvesUnloadSledge(shift, sledge.status);
		if (sledge.status) {
			System.out.println("**  															**");
			System.out.println("** [system].sledge is now fully unloaded!				 		**");
			sledge.status = false;
		} else {
			System.out.println("**  															**");
			System.out.println("** [system].sledge is not unloaded! check working elves!		**");
			System.out.println("**  															**");
			System.out.println("** [system].too few elves have the tier to unload the sledge!	**");
			System.out.println("** [system].get more high-tier elves working! come back later!	**");
		}
		System.out.println("**  															**");
	}

	// dialog elf sledge load
	public void dialogElvesSledgeLoad() {

		sledge.status = elvesLoadSledge(shift, sledge.status);
		if (sledge.status) {
			System.out.println("**  															**");
			System.out.println("** [system].sledge is now fully loaded!					 		**");
			sledge.status = true;
		} else {
			System.out.println("**  															**");
			System.out.println("** [system].sledge is not loaded! check working elves!			**");
			System.out.println("**  															**");
			System.out.println("** [system].too few elves have the tier to load the sledge!		**");
			System.out.println("** [system].get more high-tier elves working! come back later!	**");
		}
		System.out.println("**  															**");
	}

	// display child home-screen
	public void dialogChild() {

		String usr = "child";
		System.out.println("******************************************************************");
		System.out.println("** [system].Hello my dear! What do you want to do?				**");
		System.out.println("******************************************************************");
		System.out.println("** [1].register in santa's list as a new child?					**");
//		System.out.println("** [2].change your details in santa's list?	(ID needed) 		**");
		System.out.println("** [x].logout / back to Login-Screen.							**");
		System.out.println("******************************************************************");

		String input = scanBot.nextLine().toLowerCase();
		switch (input) {
			case "1" -> {
				System.out.println("******************************************************************");
				System.out.println("** [system].ok let's get some things done.						**");
				System.out.println("******************************************************************");
				dialogRegisterChild();
				backToHome(usr);
			}
//			case "2" -> {
//				System.out.println("** [update] ok let's search your ID?							**");
//				System.out.println("******************************************************************");
//				backToHome(usr);
//			}
			case "x" -> {
				dialogLoginScreen();
			}
			default -> {
				dialogError();
				dialogChild();
			}
		}

	}

	//dialog register new child
	public void dialogRegisterElfForShift() {

		String usr = "elf";
		int inputElfID = elfID++;

		System.out.println("** [register].what's your name? [e.g. 'Donald'] 				**");
		String inputElfName = scanBot.nextLine();

		System.out.println("** [register].great job! you stamped in for today's shift.		**");
		Elf elf = new Elf(inputElfID, inputElfName);

		elf.printElfAdded();
		shift.add(elf);

		System.out.println("******************************************************************");
		System.out.println("** [system].stamp in another elf? [y].for yes [x].stop adding	**");
		String inputOneMore = scanBot.nextLine().toLowerCase();

		if (inputOneMore.equals("y")) {
			System.out.println("** [system].ok let's get some things done first.				**");
			System.out.println("******************************************************************");
			dialogRegisterElfForShift();
			backToHome(usr);
		}
		else if (inputOneMore.equals("x")) {
			backToHome(usr);
		}
	}

	// dialog show all children inclusive their infos in vault
	public void dialogShowSantaVaultItemsInclusiveInfos() {

		String usr = "santa";
		System.out.println("******************************************************************");
		System.out.println("** [system].vault loading! here are all stored infos so far!	**");
		System.out.println("******************************************************************");

		if (children.size() == 0) {
			System.out.println("**  															**");
			System.out.println("** [system].looks like the vault is still empty! return later!	**");
		} else {
			System.out.println("**  															**");
			System.out.println("** [system].[ID] | [Name] | [Age] | [City] | [Present] 			**");
			System.out.println("**  															**");
			for (Child child : children) {
				System.out.println("** " + child.childID + " | " + child.childName + " | " +
						child.childAge + " | " + child.childCity + " | " + child.presentsName + " **");
			}
		}
		System.out.println("**  															**");
	}

	// dialog show sante child by searched name
	public void dialogShowSantaSearchChild() {

		String usr = "santa";
		System.out.println("******************************************************************");
		System.out.println("** [system].search module loading! 								**");
		System.out.println("******************************************************************");

		System.out.println("**  															**");
		System.out.println("** [search].how's the name of the child you're looking for?		**");
		String inputSearchChildName = scanBot.nextLine().toLowerCase();

		if (children.size() == 0) {
			System.out.println("**  															**");
			System.out.println("** [search].sorry there isn't any child registered yet!			**");
			System.out.println("** [search].return later!										**");
			System.out.println("**  															**");
		} else {
			boolean search = false;
			for (Child child : children) {

				if (child.getChildName().equalsIgnoreCase(inputSearchChildName)) {
					search = true;
					System.out.println("** 																**");
					System.out.println("** [system].found following child listed below.					**");
					System.out.println("** [system].[ID] | [Name] | [Age] | [City] | [Present] 			**");
					System.out.println("** 																**");
					System.out.println("** " + child.childID + " | " + child.childName + " | " +
							child.childAge + " | " + child.childCity + " | " + child.presentsName + " **");
					System.out.println("** 																**");
					break;
				}

			}

			if (!search) {
				System.out.println("**  															**");
				System.out.println("** [search].sorry there isn't any child with this name!			**");
				System.out.println("**  															**");
			}
		}

		System.out.println("******************************************************************");
		System.out.println("** [system].do another search? [y].for yes [x].stop adding		**");
		String inputOneMore = scanBot.nextLine().toLowerCase();

		if (inputOneMore.equals("y")) {
			dialogShowSantaSearchChild();
			backToHome(usr);
		}
		else if (inputOneMore.equals("x")) {
			backToHome(usr);
		}

		System.out.println("**  															**");
		
	}
	
	// dialog show all working elves for today's shift
	public void dialogShowSantaTodayShift() {

		String usr = "santa";
		System.out.println("******************************************************************");
		System.out.println("** [system].shift loading! all stamped in elves for today.		**");
		System.out.println("******************************************************************");

		if (shift.size() == 0) {
			System.out.println("**  															**");
			System.out.println("** [system].there are no working elves today yet! return later!	**");
		} else {
			System.out.println("** [system].[ID] | [Name] | [Tier] | [Age] | [City]				**");
			System.out.println("**  															**");
			for (Elf elf : shift) {
				System.out.println("** " + elf.elfID + " | " + elf.elfName + " | " +
						elf.elfTier + " | " + elf.elfAge + " | " + elf.elfCity + " **");
			}
		}
		System.out.println("**  															**");
	}

	// dialog show all presents in vault
	public void dialogShowSantaVaultItems() {

		String usr = "santa";
		System.out.println("******************************************************************");
		System.out.println("** [system].vault loading! here are all stored presents so far!	**");
		System.out.println("******************************************************************");

		if (children.size() == 0) {
			System.out.println("**  															**");
			System.out.println("** [system].looks like the vault is still empty! return later!	**");
		} else {
			System.out.println("** [system]. listed [presentName] 								**");
			System.out.println("**  															**");
			for (Child child : children) {
				System.out.println("** [slot] presentsName = " + child.presentsName + "  **");
			}
		}
		System.out.println("**  															**");
	}

	// dialog check sledge-status
	public void dialogShowSantaSledgeStatus() {
		System.out.println("******************************************************************");
		System.out.println("** [system].sledge-status loading! 								**");
		System.out.println("******************************************************************");
		System.out.println("**  															**");
		if (!sledge.status) {
			System.out.println("** [system].looks like the sledge isn't still loaded yet! 		**");
			System.out.println("** [system].kick some elves asses! and come back later!			**");
		} else {
			System.out.println("** [system].HoHoHo santa!										**");
			System.out.println("** [system].sledge is loaded and ready for take off!			**");
			System.out.println("** [system].Merry fucking Christmas! 							**");
		}
		System.out.println("**  															**");
	}

	//dialog register new child
	public void dialogRegisterChild() {

		String usr = "child";
		int inputChildID = ID++;
		System.out.println("** [register].what's your name? [e.g. 'Donald Duck']			**");
		String inputChildName = scanBot.nextLine();

		System.out.println("** [register].what's your age? [e.g. '11']						**");
		int inputChildAge = scanBot.nextInt();
		scanBot.nextLine();

		//TO-DO catch wrong verification types

		System.out.println("** [register].what's your city name? 	[e.g. 'Vienna']			**");
		String inputChildCity = scanBot.nextLine();

		System.out.println("** [register].what's your presentWish? [e.g. 'lollipop']		**");
		String inputPresentsName = scanBot.nextLine();

		System.out.println("** [register].great job! santa now knows about you & your wish.	**");

		Child child = new Child(inputChildID, inputChildName, inputChildAge, inputChildCity, inputPresentsName);
		Presents present = new Presents(inputPresentsName, child);
		child.printChildAdded();

		children.add(child);
		vault.add(present);

		System.out.println("******************************************************************");
		System.out.println("** [system].add another child? [y].for yes [x].stop adding		**");
		String inputOneMore = scanBot.nextLine().toLowerCase();

		if (inputOneMore.equals("y")) {
			System.out.println("** [system].ok let's get some things done first.				**");
			System.out.println("******************************************************************");
			dialogRegisterChild();
			backToHome(usr);
		}
		else if (inputOneMore.equals("x")) {
			backToHome(usr);
		}

	}

	// back to home-screen
	public void backToHome(String usr) {

		System.out.println("** [x].back to Home-Screen.										**");
		System.out.println("******************************************************************");
		String input = scanBot.nextLine().toLowerCase();
		if(input.equals("x")) {
			switch (usr) {
				case "santa" -> dialogSanta();
				case "elf" -> dialogElf();
				case "child" -> dialogChild();
			}
		} else {
			System.out.println("** input is incorrect! please try again!						**");
			System.out.println("******************************************************************");
			backToHome(usr);
		}
	}

	// error statement
	public void dialogError() {
		System.out.println("******************************************************************");
		System.out.println("** [system].input is incorrect! please try again!				**");
		System.out.println("******************************************************************");
	}

}
