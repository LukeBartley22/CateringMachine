package com.techelevator;

import com.techelevator.view.Menu;

public class CaTEringCapstoneCLI {

/* 1. display menu
main menu options displayed
Display feed money, select item, finish transaction
print cost of money remaining
if app is closed it resets
create Audit file
update file
after item is despensed balance must be updated and costumer returned to the purchase menu

 */

	private final Menu menu;

	public CaTEringCapstoneCLI(Menu menu) {
		this.menu = menu;
	}

	public static void main(String[] args) {
		Menu menu = new Menu();
		CaTEringCapstoneCLI cli = new CaTEringCapstoneCLI(menu);
		cli.run();
	}

	public void run() {
		while (true) {
			menu.run();

			//  to do -- build out main menu

		}
	}
}
