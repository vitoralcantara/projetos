package aula7.exemplos;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;

public class SimpleProgramaticMenu extends Activity {
	private int MENU_ADD = 1;
	private int MENU_RESET = 2;

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {

		menu.add(Menu.NONE, MENU_ADD, Menu.NONE, "Add New")
			.setIcon(R.drawable.add_icon);
	

		menu.add(Menu.NONE, MENU_RESET, Menu.NONE, "Reset")
			.setIcon(R.drawable.refresh_icon);

		return true;
	}

}