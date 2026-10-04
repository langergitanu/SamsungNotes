package com.microsoft.identity.common.java.p132ui.webview.authorization;

import com.microsoft.identity.common.java.providers.RawAuthorizationResult;
import edu.umd.cs.findbugs.annotations.NonNull;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes6.dex */
public interface IAuthorizationCompletionCallback {
    void onChallengeResponseReceived(@NonNull RawAuthorizationResult rawAuthorizationResult);

    void setPKeyAuthStatus(boolean z);
}
