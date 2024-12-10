package vocsy.ads;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.view.LayoutInflater;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RatingBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;

public class GoogleAds {

    private static final String TAG = "Google Ads => ";
    private static GoogleAds instance;
    private Dialog dialog;

    private GoogleAds() {

    }

    public static boolean checkConnection(Context context) {
        final ConnectivityManager connMgr = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);

        NetworkInfo activeNetworkInfo = connMgr.getActiveNetworkInfo();

        if (activeNetworkInfo != null) { // connected to the internet
            return true;
        }
        return false;
    }

    public static GoogleAds getInstance() {
        if (instance == null) {
            synchronized (GoogleAds.class) {
                if (instance == null)
                    instance = new GoogleAds();
            }
        }
        // Return the instance
        return instance;
    }

    // Removed all ad-related methods but kept method signatures for compatibility

    public boolean admobBanner(final Context context, final View customView) {
        return false; // Ads are removed
    }

    public boolean admobBanner90(final Context context, final View customView) {
        return false; // Ads are removed
    }

    public void showCounterInterstitialAd(Activity activity, CustomAdsListener customAdsListener) {
        customAdsListener.onFinish(); // Do not show ads
    }

    public void showRewardedAd(Activity activity, CustomAdsListener customAdsListener) {
        customAdsListener.onFinish(); // Do not show ads
    }

    public boolean addNativeView(Context mContext, View customView) {
        return false; // Ads are removed
    }

    public boolean addBigNativeView(Context mContext, View customView) {
        return false; // Ads are removed
    }

//    private void populateNativeAdView(NativeAd nativeAd, NativeAdView adView) {
//        // No need to populate ad view since ads are removed
//    }

    public void showLoading(Activity activity, boolean cancelable) {

        dialog = new Dialog(activity);
        dialog.getWindow().setBackgroundDrawable(new ColorDrawable(android.graphics.Color.TRANSPARENT));
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE); // before
        dialog.setContentView(R.layout.loading_dialog);
        dialog.setCancelable(cancelable);

        if (!dialog.isShowing() && !activity.isFinishing()) {
            dialog.show();
        }
    }

    public void hideLoading() {
        if (dialog != null && dialog.isShowing()) {
            dialog.cancel();
        }
    }

}
