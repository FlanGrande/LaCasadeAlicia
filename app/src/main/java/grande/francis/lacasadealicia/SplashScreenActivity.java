package grande.francis.lacasadealicia;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;

public class SplashScreenActivity extends AppCompatActivity
{
	// Set the duration of the splash screen
	private static final long SPLASH_SCREEN_DELAY = 2000;
	private Handler handler = new Handler();

	@Override
	protected void onCreate(Bundle savedInstanceState)
	{
		super.onCreate(savedInstanceState);
		setContentView(R.layout.splash_screen);
		handler.postDelayed(runnable, SPLASH_SCREEN_DELAY);
	}

	private Runnable runnable = new Runnable()
	{
		@Override
		public void run()
		{
			// Start the next activity
			Intent mainIntent = new Intent().setClass(SplashScreenActivity.this, HomeScreenActivity.class);
			startActivity(mainIntent);

			// Close the activity so the user won't able to go back this
			// activity pressing Back button
			finish();
		}
	};
}
