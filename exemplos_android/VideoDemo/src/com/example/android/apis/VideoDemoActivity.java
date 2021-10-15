package com.example.android.apis;

import android.app.Activity;
import android.net.Uri;
import android.os.Bundle;
import android.widget.MediaController;
import android.widget.VideoView;

public class VideoDemoActivity extends Activity {
	/** Called when the activity is first created. */

	private VideoView videoView;

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);

		videoView = (VideoView) findViewById(R.id.videoView1);
		MediaController mediaController = new MediaController(this);
		mediaController.setAnchorView(videoView);
		Uri video = Uri.parse("/sdcard/media/video/anarmyonebyone1.mp4");
		videoView.setMediaController(mediaController);
		videoView.setVideoURI(video);
		videoView.start();
	}
}