package com.microsoft.identity.client;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;
import androidx.collection.AbstractC0622a;
import com.microsoft.identity.common.internal.providers.oauth2.BrowserAuthorizationFragment;
import com.microsoft.identity.common.internal.util.StringUtil;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes6.dex */
public final class BrowserTabActivity extends Activity {
    private static final String TAG = "BrowserTabActivity";

    @Override // android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        String strM1170p = AbstractC0622a.m1170p(TAG, ":onCreate", new StringBuilder());
        if (bundle != null || getIntent() == null || StringUtil.isEmpty(getIntent().getDataString())) {
            return;
        }
        Intent intentCreateCustomTabResponseIntent = BrowserAuthorizationFragment.createCustomTabResponseIntent(this, getIntent().getDataString());
        if (intentCreateCustomTabResponseIntent != null) {
            startActivity(intentCreateCustomTabResponseIntent);
        } else {
            com.microsoft.identity.common.logging.Logger.warn(strM1170p, "Received NULL response intent. Unable to complete authorization.");
            Toast.makeText(getApplicationContext(), "Unable to complete authorization as there is no interactive call in progress. This can be due to closing the app while the authorization was in process.", 1).show();
        }
        finish();
    }
}
