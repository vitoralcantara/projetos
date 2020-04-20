package exemplos.aulas3;

import android.app.Activity;
import android.os.Bundle;
import exemplos.aulas3.R;

public class SaveRestoreActivity extends Activity {
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		
		  
		  boolean myBoolean = savedInstanceState.getBoolean("MyBoolean");
		  double myDouble = savedInstanceState.getDouble("myDouble");
		  int myInt = savedInstanceState.getInt("MyInt");
		  String myString = savedInstanceState.getString("MyString");

		setContentView(R.layout.main);
	}

	@Override
	public void onSaveInstanceState(Bundle savedInstanceState) {
		savedInstanceState.putBoolean("MyBoolean", true);
		savedInstanceState.putDouble("myDouble", 1.9);
		savedInstanceState.putInt("MyInt", 1);
		savedInstanceState.putString("MyString", "Welcome back to Android");
		super.onSaveInstanceState(savedInstanceState);
	}
}