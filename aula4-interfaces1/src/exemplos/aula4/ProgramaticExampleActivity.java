package exemplos.aula4;

import android.app.Activity;
import android.graphics.drawable.GradientDrawable.Orientation;
import android.os.Bundle;
import android.view.ViewGroup.LayoutParams;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

public class ProgramaticExampleActivity extends Activity {
	/** Called when the activity is first created. */

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

		LinearLayout layout = new LinearLayout(this);

		LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(
				LayoutParams.FILL_PARENT, LayoutParams.WRAP_CONTENT);

		layout.setLayoutParams(params);
		layout.setOrientation(LinearLayout.VERTICAL);

		TextView valueTV = new TextView(this);
		valueTV.setText("hello hello");
		valueTV.setId(5);
		valueTV.setLayoutParams(new LayoutParams(LayoutParams.FILL_PARENT,
				LayoutParams.WRAP_CONTENT));

		EditText valueET = new EditText(this);
		valueET.setText("ops");
		valueET.setId(6);
		valueET.setLayoutParams(new LayoutParams(LayoutParams.FILL_PARENT,
				LayoutParams.WRAP_CONTENT));

		layout.addView(valueTV);
		layout.addView(valueET);
		
		Button b = new Button(this);
		b.setText("oi");

		setContentView(layout);
	}
}