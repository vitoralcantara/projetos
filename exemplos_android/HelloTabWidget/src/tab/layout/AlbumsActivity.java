package tab.layout;

import android.app.Activity;
import android.os.Bundle;
import android.widget.TextView;

public class AlbumsActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		TextView textview = new TextView(this);
		textview.setText("This is the Albuns tab");
		setContentView(textview);
	}

}
