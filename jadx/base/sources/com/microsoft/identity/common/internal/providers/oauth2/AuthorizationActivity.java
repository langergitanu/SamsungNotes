package com.microsoft.identity.common.internal.providers.oauth2;

import android.os.Bundle;
import androidx.annotation.Nullable;
import androidx.collection.AbstractC0622a;
import androidx.fragment.app.Fragment;
import com.microsoft.identity.common.internal.p131ui.DualScreenActivity;
import com.microsoft.identity.common.internal.util.CommonMoshiJsonAdapter;
import com.microsoft.identity.common.java.exception.TerminalException;
import com.microsoft.identity.common.java.opentelemetry.SerializableSpanContext;
import com.microsoft.identity.common.logging.Logger;
import io.opentelemetry.api.trace.SpanContext;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes6.dex */
public class AuthorizationActivity extends DualScreenActivity {
    public static final String TAG = "AuthorizationActivity";
    private AuthorizationFragment mFragment;
    private SpanContext mSpanContext;

    public SpanContext getSpanContext() {
        return this.mSpanContext;
    }

    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(@Nullable Bundle bundle) {
        super.onCreate(bundle);
        String strM1170p = AbstractC0622a.m1170p(TAG, ":onCreate", new StringBuilder());
        if (getIntent().getExtras() != null) {
            try {
                this.mSpanContext = (SpanContext) new CommonMoshiJsonAdapter().fromJson(getIntent().getExtras().getString(SerializableSpanContext.SERIALIZABLE_SPAN_CONTEXT), SerializableSpanContext.class);
            } catch (TerminalException unused) {
                this.mSpanContext = null;
            }
        }
        Fragment authorizationFragmentFromStartIntent = AuthorizationActivityFactory.getAuthorizationFragmentFromStartIntent(getIntent());
        if (authorizationFragmentFromStartIntent instanceof AuthorizationFragment) {
            AuthorizationFragment authorizationFragment = (AuthorizationFragment) authorizationFragmentFromStartIntent;
            this.mFragment = authorizationFragment;
            authorizationFragment.setInstanceState(getIntent().getExtras());
        } else {
            Logger.error(strM1170p, "Did not receive AuthorizationFragment from factory", new IllegalStateException("Unexpected fragment type."));
        }
        setFragment(this.mFragment);
    }
}
