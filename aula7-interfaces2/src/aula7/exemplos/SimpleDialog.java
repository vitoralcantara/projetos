package aula7.exemplos;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class SimpleDialog extends Activity {

	private final int  DIALOG_CONFIRMATION = 1;

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_dialog);

		Button fecharButton = (Button) findViewById(R.id.button1);

		fecharButton.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				showDialog(DIALOG_CONFIRMATION);
			}

		});

	}

	protected Dialog onCreateDialog(int id) {
		Dialog dialog = null;
		switch (id) {
		
		case DIALOG_CONFIRMATION:
			
			AlertDialog.Builder builder = new AlertDialog.Builder(this);
		builder.setMessage("Tem certeza que quer sair?")
			       .setCancelable(false)
			       .setPositiveButton("Sim", new DialogInterface.OnClickListener() {
			           public void onClick(DialogInterface dialog, int id) {
			                SimpleDialog.this.finish();
			           }
			       })
			       .setNegativeButton("Não", new DialogInterface.OnClickListener() {
			           public void onClick(DialogInterface dialog, int id) {
			                dialog.cancel();
			           }
			       });
			
			AlertDialog alert = builder.create();
			
			alert.show();
			
			break;

		default:
			dialog = null;
		}

		return dialog;
	}

}
