package com.samsung.android.sdk.scs.p142ai.language;

import android.content.Context;
import android.os.RemoteException;
import androidx.annotation.NonNull;
import androidx.annotation.RestrictTo;
import com.google.android.material.color.utilities.C4662f;
import com.samsung.android.sdk.scs.base.tasks.Task;
import com.samsung.android.sdk.scs.base.utils.Log;
import com.samsung.android.sdk.scs.p142ai.language.service.AuthHeader;
import com.samsung.android.sdk.scs.p142ai.language.service.LlmServiceObserver2;
import com.samsung.android.sdk.scs.p142ai.language.service.LlmServiceRunnable;
import com.samsung.android.sdk.scs.p142ai.language.service.NotesOrganizationServiceExecutor;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes6.dex */
public class NotesOrganizer {
    private static final String TAG = "NotesOrganizer";
    private final NotesOrganizationServiceExecutor mServiceExecutor;

    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public NotesOrganizer(@NonNull Context context) {
        Log.m6485d(TAG, TAG);
        this.mServiceExecutor = new NotesOrganizationServiceExecutor(context);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$notesOrganize$0(AppInfo appInfo, String str, NotesOrganizationFormatType notesOrganizationFormatType, Map map, LlmServiceObserver2 llmServiceObserver2) {
        try {
            this.mServiceExecutor.getService().organizeWithType3(new AuthHeader(appInfo).generateHeaderMap(this.mServiceExecutor.context), str, notesOrganizationFormatType.name(), llmServiceObserver2, map);
        } catch (RemoteException e) {
            throw new RuntimeException(e);
        }
    }

    public Task<Result> notesOrganize(AppInfo appInfo, @NonNull String str, NotesOrganizationFormatType notesOrganizationFormatType) {
        return notesOrganize(appInfo, str, notesOrganizationFormatType, new HashMap());
    }

    public void release() {
        Log.m6489i(TAG, "release: " + this.mServiceExecutor.isConnected());
        this.mServiceExecutor.deInit();
    }

    public Task<Result> notesOrganize(AppInfo appInfo, @NonNull String str, NotesOrganizationFormatType notesOrganizationFormatType, @NonNull Map<String, String> map) {
        LlmServiceRunnable llmServiceRunnable = new LlmServiceRunnable("FEATURE_AI_GEN_NOTES_ORGANIZATION", appInfo.isStreamingMode(), new C7736a(this, appInfo, str, notesOrganizationFormatType, map, 6), new C4662f(15));
        this.mServiceExecutor.execute(llmServiceRunnable);
        return llmServiceRunnable.getTask();
    }
}
