package aula7.exemplos;

import android.app.Activity;
import android.app.ListActivity;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.SubMenu;
import android.view.View;

public class SimpleContextMenu extends Activity {

	@Override
	public void onCreate(Bundle savedInstanceState) {
		setContentView(R.layout.main);

		View txtView = findViewById(R.id.helloText);
		registerForContextMenu(txtView);

		super.onCreate(savedInstanceState);

	}

	@Override
	public void onCreateContextMenu(ContextMenu menu, View v,
	ContextMenu.ContextMenuInfo menuInfo) {
		
	  super.onCreateContextMenu(menu, v, menuInfo);
	  menu.setHeaderTitle("Context Menu");
	  menu.add(0, Menu.FIRST, Menu.NONE,"Item 1");
	  menu.add(0, Menu.FIRST+1, Menu.NONE, "Item 2");
	  menu.add(0, Menu.FIRST+2, Menu.NONE, "Item 3");
	  SubMenu sub = menu.addSubMenu("Submenu");
	  sub.add("Submenu Item");
	}
}
