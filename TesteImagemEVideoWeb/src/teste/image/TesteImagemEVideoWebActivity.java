package teste.image;

import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;

import android.app.Activity;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.widget.ImageView;
import android.widget.MediaController;
import android.widget.VideoView;

public class TesteImagemEVideoWebActivity extends Activity {

	ImageView img;
	VideoView videoView;

	/** Called when the activity is first created. */
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);

		Drawable image = ImageOperations(this,
				"http://vitor.netne.net/fotos/0/cod3.jpg", "image.jpg");

		img = (ImageView) findViewById(R.id.imageView1);
		img.setImageDrawable(image);

		
		// A parte de v�deo
		videoView = (VideoView) findViewById(R.id.videoView1);

		MediaController mediaController = new MediaController(this);
		mediaController.setAnchorView(videoView);
		Uri video = Uri.parse("http://vitor.netne.net/videos/1/bf3.mp4");
		videoView.setMediaController(mediaController);
		videoView.setVideoURI(video);
		videoView.start();
		videoView.setOnTouchListener(new OnTouchListener() {

			@Override
			public boolean onTouch(View v, MotionEvent event) {
				if (event.getAction() == MotionEvent.ACTION_MOVE) {
					videoView.stopPlayback();
				} else {
					videoView.start();
				}
				return true;
			}
		});
	}

	private Drawable ImageOperations(Context ctx, String url,
			String saveFilename) {
		try {
			InputStream is = (InputStream) this.fetch(url);
			Drawable d = Drawable.createFromStream(is, "src");
			return d;
		} catch (MalformedURLException e) {
			e.printStackTrace();
			return null;
		} catch (IOException e) {
			e.printStackTrace();
			return null;
		}
	}

	public Object fetch(String address) throws MalformedURLException,
			IOException {
		URL url = new URL(address);
		Object content = url.getContent();
		return content;
	}
	
}