package hello.gallery;

import android.app.Activity;
import android.net.Uri;
import android.os.Bundle;
import android.widget.MediaController;
import android.widget.VideoView;

public class VideoGalleryActivity extends Activity {

	private VideoView videoView;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		this.setContentView(R.layout.video);

		videoView = (VideoView) findViewById(R.id.videoView1);
		MediaController mediaController = new MediaController(this);
		mediaController.setAnchorView(videoView);
		Uri video = Uri.parse("/sdcard/media/video/anarmyonebyone1.mp4");
		videoView.setMediaController(mediaController);
		videoView.setVideoURI(video);
	}

}
