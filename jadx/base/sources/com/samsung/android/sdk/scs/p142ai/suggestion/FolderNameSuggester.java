package com.samsung.android.sdk.scs.p142ai.suggestion;

import android.content.Context;
import androidx.annotation.NonNull;
import androidx.annotation.RestrictTo;
import com.samsung.android.sdk.scs.base.tasks.Task;
import com.samsung.android.sdk.scs.base.utils.Log;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes6.dex */
public class FolderNameSuggester {
    private static final String TAG = "FolderNameSuggester";
    private Context mContext;
    private SuggestionProviderExecutor mProviderExecutor;

    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public FolderNameSuggester(@NonNull Context context) {
        this.mContext = context;
        this.mProviderExecutor = new SuggestionProviderExecutor(context);
    }

    public Task<List<String>> suggest(@NonNull List<String> list) {
        Log.m6485d(TAG, "suggest() executed");
        FolderNameSuggestionRunnable folderNameSuggestionRunnable = new FolderNameSuggestionRunnable(this.mContext);
        folderNameSuggestionRunnable.setPackageNames(list);
        this.mProviderExecutor.execute(folderNameSuggestionRunnable);
        return folderNameSuggestionRunnable.getTask();
    }
}
