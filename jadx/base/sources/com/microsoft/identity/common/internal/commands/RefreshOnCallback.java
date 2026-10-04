package com.microsoft.identity.common.internal.commands;

import androidx.collection.AbstractC0622a;
import com.microsoft.identity.common.java.commands.CommandCallback;
import com.microsoft.identity.common.java.exception.BaseException;
import com.microsoft.identity.common.java.result.AcquireTokenResult;
import com.microsoft.identity.common.logging.Logger;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes6.dex */
public class RefreshOnCallback implements CommandCallback<AcquireTokenResult, BaseException> {
    private static final String TAG = "RefreshOnCallback";

    @Override // com.microsoft.identity.common.java.util.TaskCompletedCallbackWithError
    public void onError(BaseException baseException) {
        Logger.verbose(AbstractC0622a.m1170p(TAG, ":onError", new StringBuilder()), baseException.getMessage());
    }

    @Override // com.microsoft.identity.common.java.util.TaskCompletedCallback
    public void onTaskCompleted(AcquireTokenResult acquireTokenResult) {
        Logger.verbose(AbstractC0622a.m1170p(TAG, ":onTaskCompleted", new StringBuilder()), "Task succeeded: " + acquireTokenResult.getSucceeded() + " . CorrelationId: " + acquireTokenResult.getLocalAuthenticationResult().getCorrelationId());
    }

    @Override // com.microsoft.identity.common.java.commands.CommandCallback
    public void onCancel() {
    }
}
