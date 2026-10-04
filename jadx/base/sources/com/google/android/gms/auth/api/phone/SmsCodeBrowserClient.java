package com.google.android.gms.auth.api.phone;

import androidx.annotation.NonNull;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.HasApiKey;
import com.google.android.gms.tasks.Task;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes5.dex */
public interface SmsCodeBrowserClient extends HasApiKey<Api.ApiOptions.NoOptions> {
    @NonNull
    Task<Void> startSmsCodeRetriever();
}
