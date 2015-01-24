package it.necst.grabnrun.learndcl;

import dalvik.system.DexClassLoader;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

/**
 * The aim of this stub of Android Application is letting you learn and verify how 
 * Dynamic Code Loading can be used to enhance your application.
 * 
 * Your goal here is to load and use an instance of SuccessDialogFragment, an 
 * extension of the standard Android class DialogFragment.
 * 
 * In order to accomplish this task you will have to perform several steps:
 * 1.	Fetch the target APK container which contains SuccessDialogFragment implementation.
 * 		from the provided remote URL.
 * 
 * 2.	Store the target APK container on your device in order to use it later
 * 		while initializing mDexClassLoader.
 * 
 * 3.	Initialize the variable mDexClassLoader with dexPath parameter including
 * 		the path to the target APK container that you have just downloaded.
 * 
 * 4.	Load dynamically the target class by calling the loadClass method
 * 		[ALREADY IMPLEMENTED FOR YOU]
 * 
 * 5.	Use the dynamically loaded class instance in the code :)
 * 		[ALREADY IMPLEMENTED FOR YOU]
 * 
 * P.S. Do not forget to add required permissions to the AndroidManifest.xml file!
 * 
 * As soon as your application is completely implemented, you can test it in either
 * the Android emulator or on your device as you would normally do with an Android app.
 * 
 * If everything goes smoothly, you should be able to visualize a Dialog which asks 
 * you to perform an action..
 * 
 * Enjoy your coding :D
 * 
 * @author Luca Falsina
 */
public class MainActivity extends ActionBarActivity {

	// DexClassLoader instance used to dynamically load the target class
	// DexClassLoader API: http://developer.android.com/reference/dalvik/system/DexClassLoader.html
	private DexClassLoader mDexClassLoader;
	
	// This constant contains the URL pointing to the remote APK container.
	@SuppressWarnings("unused")
	private final static String APK_CONTAINER_URL = "https://dl.dropboxusercontent.com/u/28681922/HelperApp.apk";
	
	// This constant contains the full class name of the SuccessDialogFragment class.
	private final static String FULL_CLASS_NAME = "it.necst.grabnrun.helperapp.SuccessDialogFragment";
	
	// Unique identifier used for Log entries
	private static final String TAG_MAIN = MainActivity.class.getSimpleName();
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		int id = item.getItemId();
		if (id == R.id.action_settings) {
			return true;
		}
		return super.onOptionsItemSelected(item);
	}
	
	// This method is triggered when the button is clicked.
	public void onBtnClick(View view) {
		
		/* TODO
		 * 1.	Fetch the target APK container which contains SuccessDialogFragment implementation.
		 *		The remote APK URL is stored in the field variable APK_CONTAINER_URL.
		 */
		
		/* TODO
		 * 2.	Store the target APK container on your device in use it later
		 * 		while initializing mDexClassLoader.
		 */
		
		/* TODO
		 * 3.	Initialize the variable mDexClassLoader with "dexPath" parameter including
		 *		the path to the location where you have stored the target APK container
		 *	    that you have just downloaded.
		 */
		
		// Safe check on mDexClassLoader not being null.
		if (mDexClassLoader == null)
			fail("Hey, it seems you forgot to initialize mDexClassLoader!\nGo back and revise your code ;)");
		else {
			
			try {
				
				/* [ALREADY IMPLEMENTED]
				 * 4.	Load dynamically the target class by calling the loadClass method on mDexClassLoader.
				 * 		Then create an instance of the target class by invoking the newInstance method.
				 * 		Remember to handle related exceptions.
				 */
				Class<?> dialogFragmentToLoad = mDexClassLoader.loadClass(FULL_CLASS_NAME);
				
				/*
				 * Notice that in this specific case a simple invocation of the zero constructor can
				 * be performed and that is the reason way a simple call to newInstance() is fine.
				 * On the other hand when you will need to create objects using a constructor different 
				 * from the zero, this procedure will be slightly more complex.
				 * Check out the Java Reflection API for a comprehensive introduction to the topic:
				 * https://docs.oracle.com/javase/tutorial/reflect/TOC.html 
				 */
				SuccessDialogAbstractFragment newFragment = (SuccessDialogAbstractFragment) dialogFragmentToLoad.newInstance();
				
				/* [ALREADY IMPLEMENTED]
				 * Use the dynamically loaded class instance in the code
				 */
				newFragment.show(getSupportFragmentManager(), "success");
				
			} catch (ClassNotFoundException e) {
				Log.w(TAG_MAIN, "No class was found by mDexClassLoader.");
				fail("No class was found by mDexClassLoader.\nDouble check that you have actually downloaded the APK, retrieved its path correctly and initialized mDexClassLoader properly.");
			} catch (InstantiationException e) {
				Log.w(TAG_MAIN, "Issues while instantiating SuccessDialogFragment.");
				fail("Issues while instantiating SuccessDialogFragment.\nDouble check that you have actually downloaded the APK, retrieved its path correctly and initialized mDexClassLoader properly.");
			} catch (IllegalAccessException e) {
				Log.w(TAG_MAIN, "Issues while instantiating SuccessDialogFragment.");
				fail("Issues while instantiating SuccessDialogFragment.\nDouble check that you have actually downloaded the APK, retrieved its path correctly and initialized mDexClassLoader properly.");
			}
		
		}
		
	}
	
	private void fail(String failureMessage) {
		
		Toast.makeText(getApplicationContext(), failureMessage, Toast.LENGTH_LONG).show();
	}
}
