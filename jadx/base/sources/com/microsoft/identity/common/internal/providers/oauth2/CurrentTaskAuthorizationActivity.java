package com.microsoft.identity.common.internal.providers.oauth2;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import androidx.annotation.Nullable;
import androidx.collection.AbstractC0622a;
import androidx.fragment.app.Fragment;
import androidx.localbroadcastmanager.content.LocalBroadcastManager;
import com.microsoft.identity.common.adal.internal.AuthenticationConstants;
import com.microsoft.identity.common.internal.p131ui.DualScreenActivity;
import com.microsoft.identity.common.logging.Logger;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes6.dex */
public class CurrentTaskAuthorizationActivity extends DualScreenActivity {
    private static final String TAG = "CurrentTaskAuthorizationActivity";
    private boolean mCloseCustomTabs = true;
    private CurrentTaskBrowserAuthorizationFragment mFragment;
    private BroadcastReceiver redirectReceiver;

    private void unregisterAndFinish() {
        LocalBroadcastManager.getInstance(this).unregisterReceiver(this.redirectReceiver);
        finish();
    }

    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(@Nullable Bundle bundle) {
        super.onCreate(bundle);
        String strM1170p = AbstractC0622a.m1170p(TAG, ":onCreate", new StringBuilder());
        Fragment authorizationFragmentFromStartIntent = AuthorizationActivityFactory.getAuthorizationFragmentFromStartIntent(getIntent());
        if (!(authorizationFragmentFromStartIntent instanceof CurrentTaskBrowserAuthorizationFragment)) {
            IllegalStateException illegalStateException = new IllegalStateException("Unexpected fragment type");
            Logger.error(strM1170p, "Fragment provided was not of type CurrentTaskBrowserAuthorizationFragment", illegalStateException);
            throw illegalStateException;
        }
        CurrentTaskBrowserAuthorizationFragment currentTaskBrowserAuthorizationFragment = (CurrentTaskBrowserAuthorizationFragment) authorizationFragmentFromStartIntent;
        this.mFragment = currentTaskBrowserAuthorizationFragment;
        currentTaskBrowserAuthorizationFragment.setInstanceState(getIntent().getExtras());
        if (!AuthenticationConstants.AuthorizationIntentAction.REDIRECT_RETURNED_ACTION.equals(getIntent().getAction())) {
            setFragment(this.mFragment);
            if (bundle == null) {
                this.mCloseCustomTabs = false;
                this.redirectReceiver = new BroadcastReceiver() { // from class: com.microsoft.identity.common.internal.providers.oauth2.CurrentTaskAuthorizationActivity.1
                    @Override // android.content.BroadcastReceiver
                    public void onReceive(Context context, Intent intent) {
                        Intent intent2 = new Intent(CurrentTaskAuthorizationActivity.this, (Class<?>) CurrentTaskAuthorizationActivity.class);
                        intent2.setAction(AuthenticationConstants.AuthorizationIntentAction.REFRESH_TO_CLOSE);
                        intent2.addFlags(603979776);
                        CurrentTaskAuthorizationActivity.this.startActivity(intent2);
                    }
                };
                LocalBroadcastManager.getInstance(this).registerReceiver(this.redirectReceiver, new IntentFilter(AuthenticationConstants.AuthorizationIntentAction.REDIRECT_RETURNED_ACTION));
                return;
            }
            return;
        }
        if (CurrentTaskBrowserAuthorizationFragment.class.isInstance(this.mFragment)) {
            Bundle bundle2 = new Bundle();
            bundle2.putBoolean("RESPONSE", true);
            this.mFragment.setArguments(bundle2);
            this.mFragment.completeAuthorizationInBrowserFlow(getIntent().getStringExtra("RESPONSE_URI"));
            finish();
        }
    }

    @Override // androidx.activity.ComponentActivity, android.app.Activity
    public void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        if (AuthenticationConstants.AuthorizationIntentAction.REFRESH_TO_CLOSE.equals(intent.getAction())) {
            LocalBroadcastManager.getInstance(this).sendBroadcast(new Intent(AuthenticationConstants.AuthorizationIntentAction.DESTROY_REDIRECT_RECEIVING_ACTIVITY_ACTION));
            unregisterAndFinish();
        }
        setIntent(intent);
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        if (AuthenticationConstants.AuthorizationIntentAction.REDIRECT_RETURNED_ACTION.equals(getIntent().getAction())) {
            Bundle bundle = new Bundle();
            bundle.putBoolean("RESPONSE", true);
            this.mFragment.setArguments(bundle);
            this.mFragment.completeAuthorizationInBrowserFlow(getIntent().getStringExtra("RESPONSE_URI"));
            setResult(-1);
            unregisterAndFinish();
        }
        if (this.mCloseCustomTabs) {
            unregisterAndFinish();
        }
        this.mCloseCustomTabs = true;
    }
}
