package com.microsoft.identity.common.internal.p131ui;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import com.microsoft.identity.common.internal.p131ui.browser.BrowserAuthorizationStrategy;
import com.microsoft.identity.common.java.providers.oauth2.AuthorizationRequest;
import com.microsoft.identity.common.java.providers.oauth2.OAuth2Strategy;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes6.dex */
public class CurrentTaskBrowserAuthorizationStrategy<GenericOAuth2Strategy extends OAuth2Strategy, GenericAuthorizationRequest extends AuthorizationRequest> extends BrowserAuthorizationStrategy<GenericOAuth2Strategy, GenericAuthorizationRequest> {
    public CurrentTaskBrowserAuthorizationStrategy(@NonNull Context context, @NonNull Activity activity, @Nullable Fragment fragment) {
        super(context, activity, fragment);
    }

    @Override // com.microsoft.identity.common.internal.p131ui.browser.BrowserAuthorizationStrategy
    public void setIntentFlag(@NonNull Intent intent) {
    }
}
