package com.microsoft.identity.common.internal.p131ui.browser;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import com.microsoft.identity.common.java.providers.oauth2.AuthorizationRequest;
import com.microsoft.identity.common.java.providers.oauth2.OAuth2Strategy;
import com.samsung.android.support.senl.p148nt.composer.main.base.util.ComposerConstants;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes6.dex */
public class DefaultBrowserAuthorizationStrategy<GenericOAuth2Strategy extends OAuth2Strategy, GenericAuthorizationRequest extends AuthorizationRequest> extends BrowserAuthorizationStrategy<GenericOAuth2Strategy, GenericAuthorizationRequest> {
    private final boolean mIsRequestFromBroker;

    public DefaultBrowserAuthorizationStrategy(@NonNull Context context, @NonNull Activity activity, @Nullable Fragment fragment, boolean z) {
        super(context, activity, fragment);
        this.mIsRequestFromBroker = z;
    }

    @Override // com.microsoft.identity.common.internal.p131ui.browser.BrowserAuthorizationStrategy
    public void setIntentFlag(@NonNull Intent intent) {
        if (this.mIsRequestFromBroker) {
            intent.setFlags(ComposerConstants.ACTIVITY_FLAG_CALLEE);
        } else {
            intent.setFlags(268435456);
        }
    }
}
