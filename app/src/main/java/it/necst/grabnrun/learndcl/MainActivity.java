package it.necst.grabnrun.learndcl;

import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

/**
 * Once that you have understood how to properly setup and use a DexClassLoader instance, the aim
 * of this second stub of Android Application is showing, in a simple use case, how to migrate your
 * code to use Grab'n Run API and in particular the class SecureDexClassLoader.
 *
 * Your goal here is the same as before: load and use an instance of SuccessDialogFragment, an
 * extension of the standard Android class DialogFragment. What changes is that this time we are
 * going to use SecureLoaderFactory and SecureDexClassLoader in stead of DexClassLoader.
 *
 * In order to accomplish this task you will have to perform several steps:
 * 1.   Import Grab'n Run library inside your project.
 *
 * 2.   Adding missing permissions to the AndroidManifest.xml file.
 *
 * For step 1 and 2, I suggest to follow the "Quick Setup" section here:
 * https://github.com/lukeFalsina/Grab-n-Run#quick-setup
 *
 * 3.   Instantiate and initialize a SecureLoaderFactory object.
 *
 * 4.   Instantiate, initialize and populate an HashMap which links the PACKAGE NAME of the class to load
 *      (see FULL_CLASS_NAME) with the certificate used for the verification (see CERTIFICATE_URL).
 *      Remember to handle the MalformedURLException in your implementation!
 *
 * 5.   Initialize the variable mSecureDexClassLoader by means of the SecureLoaderFactory object.
 *      This time dexPath can be directly the APK_CONTAINER_URL string since Grab'n Run will handle
 *      the download and store process on the container for you :)
 *
 * 6.	Load dynamically the target class by calling the loadClass method
 * 		[ALREADY IMPLEMENTED FOR YOU]
 *
 * 7.	Check that the previous returned object is not null and in such a case use the dynamically
 *      loaded class instance in the code :)
 * 		[ALREADY IMPLEMENTED FOR YOU]
 *
 * 	For steps 3 to 7, a useful resource is Grab'n Run tutorial page in the documentation:
 * 	http://grab-n-run.readthedocs.org/en/latest/tutorial.html#tutorial
 *
 * 	At the end of the day you should obtain a working code very similar to the one shown here:
 * 	https://github.com/lukeFalsina/Grab-n-Run#5-set-up-dynamic-code-loading-with-gnr-in-the-application
 *
 * 	As soon as your application is ready, test it again and you should see the same Dialog you
 * 	encountered before.
 *
 * 	OK you had to read some stuff to make Grab'n Run work but wasn't this code implementation
 * 	easier after all compared to the previous one? :)
 *
 * 	Or at least I hope so :D
 *
 * @author Luca Falsina
 */
public class MainActivity extends ActionBarActivity {

	// SecureDexClassLoader instance used to dynamically load the target class
	// GNR API: https://rawgit.com/lukeFalsina/Grab-n-Run/master/docs/javaDoc/index.html
	private SecureDexClassLoader mSecureDexClassLoader;
	
	// This constant contains the URL pointing to the remote APK container.
	@SuppressWarnings("unused")
	private final static String APK_CONTAINER_URL = "https://dl.dropboxusercontent.com/u/28681922/HelperApp.apk";
	
	// This constant contains the full class name of the SuccessDialogFragment class.
	private final static String FULL_CLASS_NAME = "it.necst.grabnrun.helperapp.SuccessDialogFragment";

    // This constant contains the URL pointing to the remote container used to verify the target APK.
    @SuppressWarnings("unused")
    private final static String CERTIFICATE_URL = "https://dl.dropboxusercontent.com/u/28681922/verify_cert.pem";
	
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
         * 3.   Instantiate and initialize a SecureLoaderFactory object.
		 */
		
		/* TODO
		 * 4.	Instantiate, initialize and populate an HashMap which links the PACKAGE NAME of the class to load
		 *      (see FULL_CLASS_NAME) with the certificate used for the verification (see CERTIFICATE_URL).
		 * 		Remember to handle the MalformedURLException in your implementation!
		 */
		
		/* TODO
		 * 5.	Initialize the variable mSecureDexClassLoader by means of the SecureLoaderFactory object.
		 *      This time dexPath can be directly the APK_CONTAINER_URL string since Grab'n Run will handle
		 *		the download and store process on the container for you :)
		 */
		
		// Safe check on mSecureDexClassLoader not being null.
		if (mSecureDexClassLoader == null)
			fail("Hey, it seems you forgot to initialize mDexClassLoader!\nGo back and revise your code ;)");
		else {
			
			try {
				
				/* [ALREADY IMPLEMENTED]
				 * 6.	Load dynamically the target class by calling the loadClass method on mSecureDexClassLoader.
				 * 		Remember to handle related exceptions.
				 */
				Class<?> dialogFragmentToLoad = mSecureDexClassLoader.loadClass(FULL_CLASS_NAME);

                /* [ALREADY IMPLEMENTED]
                 * 7.	Check that the previous dialogFragmentToLoad is not null and in such a case
                 *      use the dynamically loaded class instance in the code :)
                 *
                 *      Notice that obtaining a null object, after a loadClass invocation, in Grab'n Run
                 *      means that a security constraint was violated and so no class loading can happen!
                 */
                if (dialogFragmentToLoad != null) {
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

                } else {

                    Log.i(TAG_MAIN, "No class was loaded by mSecureDexClassLoader. A security constraint was violated!");
                    Toast.makeText(getApplicationContext(), "No class was loaded by mSecureDexClassLoader.", Toast.LENGTH_LONG).show();

                }

				
			} catch (ClassNotFoundException e) {
				Log.w(TAG_MAIN, "No class was found by mSecureDexClassLoader.");
				fail("No class was found by mSecureDexClassLoader.\nDouble check the way in which you initialize mSecureDexClassLoader.");
			} catch (InstantiationException e) {
				Log.w(TAG_MAIN, "Issues while instantiating SuccessDialogFragment.");
				fail("Issues while instantiating SuccessDialogFragment.\nDouble check the way in which you initialize mSecureDexClassLoader.");
			} catch (IllegalAccessException e) {
				Log.w(TAG_MAIN, "Issues while instantiating SuccessDialogFragment.");
				fail("Issues while instantiating SuccessDialogFragment.\nDouble check the way in which you initialize mSecureDexClassLoader.");
			}
		
		}
		
	}
	
	private void fail(String failureMessage) {
		
		Toast.makeText(getApplicationContext(), failureMessage, Toast.LENGTH_LONG).show();
	}
}
