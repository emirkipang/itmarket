package restuibu.com.itmarket.notifications;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.util.Log;

import com.google.firebase.iid.FirebaseInstanceId;
import com.google.firebase.iid.FirebaseInstanceIdService;

public class MyFirebaseInstanceIDService extends FirebaseInstanceIdService {
    private static final String TAG = "MyFirebaseIIDService";

    @Override
    public void onTokenRefresh() {
        // Get updated InstanceID token.
        String refreshedToken = FirebaseInstanceId.getInstance().getToken();
        Log.d(TAG, refreshedToken);

        // token : cjtD0V_g7wg:APA91bHuHMTlRvJVdTCsR5DJbC8bVH2rQFm-n2BFXZ6XNl-8UzAGcCemx3NvDhK67JHLvgnVFuiRWsN81v1HWofPscElRuy4w7vNEQT4aRMvD9oDQAmimRZiZsuUvjgCfUZfx8BP_Da8
        // If you want to send messages to this application instance or
        // manage this apps subscriptions on the server side, send the
        // Instance ID token to your app server.
        SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences(getApplicationContext());
        preferences.edit().putString(Constants.FIREBASE_TOKEN, refreshedToken).apply();

    }
}


