package com.samsung.android.sdk.scs.p142ai.suggestion;

import android.content.Context;
import androidx.annotation.NonNull;
import androidx.annotation.RestrictTo;
import com.samsung.android.sdk.scs.base.tasks.Task;
import com.samsung.android.sdk.scs.base.utils.Log;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes6.dex */
public class AppCategorizer {
    private static final String TAG = "AppCategorizer";
    private Context mContext;
    private SuggestionProviderExecutor mProviderExecutor;

    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public AppCategorizer(@NonNull Context context) {
        this.mContext = context;
        this.mProviderExecutor = new SuggestionProviderExecutor(context);
    }

    public Task<List<String>> getAppCategories(@NonNull List<String> list) {
        Log.m6489i(TAG, "getAppCategories() executed");
        AppCategorizationRunnable appCategorizationRunnable = new AppCategorizationRunnable(this.mContext);
        appCategorizationRunnable.setPackageNames(list);
        this.mProviderExecutor.execute(appCategorizationRunnable);
        return appCategorizationRunnable.getTask();
    }

    public Task<List<AppCategoryResult>> getAppCategoryDetails(@NonNull List<String> list) {
        Log.m6489i(TAG, "getAppCategoryDetails() executed");
        AppCategoryDetailsRunnable appCategoryDetailsRunnable = new AppCategoryDetailsRunnable(this.mContext);
        appCategoryDetailsRunnable.setPackageNames(list);
        this.mProviderExecutor.execute(appCategoryDetailsRunnable);
        return appCategoryDetailsRunnable.getTask();
    }
}
