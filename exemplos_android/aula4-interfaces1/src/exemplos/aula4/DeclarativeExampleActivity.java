package exemplos.aula4;

import android.app.Activity;
import android.os.Bundle;
import android.widget.Button;

public class DeclarativeExampleActivity extends Activity {
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
    	
        super.onCreate(savedInstanceState);
        
        setContentView(R.layout.linearlayout);
    }
}