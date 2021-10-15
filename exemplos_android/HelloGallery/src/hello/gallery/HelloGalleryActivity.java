package hello.gallery;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.TypedArray;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.Gallery;
import android.widget.ImageView;

public class HelloGalleryActivity extends Activity {
	/** Called when the activity is first created. */

	public Integer[] mImageIds = { R.drawable.sample_0, //
			R.drawable.sample_1, //
			R.drawable.sample_2, //
			R.drawable.sample_3, //
			R.drawable.sample_4, //
			R.drawable.sample_5, //
			R.drawable.sample_6, //
			R.drawable.sample_7 };

	private ImageView imageView;
	private Button buttonVideo;

	private int pos = 0;

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);
		if (savedInstanceState != null) {
			pos = savedInstanceState.getInt("pos");
		}

		imageView = (ImageView) findViewById(R.id.imageView1);
		imageView.setImageResource(mImageIds[pos]);
		imageView.setEnabled(true);
		imageView.setVisibility(ImageView.VISIBLE);

		buttonVideo = (Button) findViewById(R.id.buttonVideo);

		buttonVideo.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				Intent intent = new Intent(v.getContext(),
						VideoGalleryActivity.class);
				startActivity(intent);
			}
		});

		Gallery gallery = (Gallery) findViewById(R.id.gallery);
		gallery.setAdapter(new ImageAdapter(this));

		gallery.setOnItemClickListener(new OnItemClickListener() {
			public void onItemClick(AdapterView<?> parent, View v,
					int position, long id) {
				imageView.setImageDrawable((((ImageView) v).getDrawable()));
				pos = position;
			}
		});
	}

	@Override
	protected void onSaveInstanceState(Bundle outState) {
		super.onSaveInstanceState(outState);
		outState.putInt("pos", pos);
	}

	public class ImageAdapter extends BaseAdapter {
		int mGalleryItemBackground;
		private Context mContext;

		public ImageAdapter(Context c) {
			mContext = c;
			TypedArray attr = mContext
					.obtainStyledAttributes(R.styleable.HelloGallery);
			mGalleryItemBackground = attr.getResourceId(
					R.styleable.HelloGallery_android_galleryItemBackground, 0);
			attr.recycle();
		}

		public int getCount() {
			return mImageIds.length;
		}

		public Object getItem(int position) {
			return position;
		}

		public long getItemId(int position) {
			return position;
		}

		public View getView(int position, View convertView, ViewGroup parent) {
			ImageView imageView = new ImageView(mContext);

			imageView.setImageResource(mImageIds[position]);
			imageView.setLayoutParams(new Gallery.LayoutParams(150, 100));
			imageView.setScaleType(ImageView.ScaleType.FIT_XY);
			imageView.setBackgroundResource(mGalleryItemBackground);

			return imageView;
		}

	}
}
