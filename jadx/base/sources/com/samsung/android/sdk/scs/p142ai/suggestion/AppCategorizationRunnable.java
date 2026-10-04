package com.samsung.android.sdk.scs.p142ai.suggestion;

import android.content.ContentResolver;
import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.annotation.RestrictTo;
import com.samsung.android.app.notes.sync.coedit.sharecore.strategy.AbstractC6670b;
import com.samsung.android.scs.p140ai.sdkcommon.suggestion.SuggestionConst;
import com.samsung.android.sdk.scs.base.ResultException;
import com.samsung.android.sdk.scs.base.tasks.TaskRunnable;
import com.samsung.android.sdk.scs.base.utils.Log;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes6.dex */
@RestrictTo({RestrictTo.Scope.LIBRARY})
public class AppCategorizationRunnable extends TaskRunnable<List<String>> {
    private static final String TAG = "AppCategorizationRunnable";
    private Context mContext;
    private ArrayList<String> mPackageNames = new ArrayList<>();

    public AppCategorizationRunnable(@NonNull Context context) {
        this.mContext = context;
    }

    /* JADX WARN: Type inference incomplete: some casts might be missing */
    @Override // com.samsung.android.sdk.scs.base.tasks.TaskRunnable
    public void execute() {
        ContentResolver contentResolver = this.mContext.getContentResolver();
        Bundle bundle = new Bundle();
        bundle.putStringArrayList(SuggestionConst.KEY_PACKAGE_NAMES, this.mPackageNames);
        Bundle bundleCall = contentResolver.call(Uri.parse(SuggestionConst.URI_STRING), SuggestionConst.METHOD_SUGGEST_APP_CATEGORY, (String) null, bundle);
        if (bundleCall == null) {
            Log.m6487e(TAG, "getAppCategories ContentResolver result is null!!");
            AbstractC6670b.m4749j(5, "ContentResolver is null", this.mSource);
            return;
        }
        int i = bundleCall.getInt("resultCode");
        if (i != 1) {
            AbstractC6670b.m4750k(i, "unexpected resultCode!!! resultCode: ", TAG);
            if (i == 500) {
                AbstractC6670b.m4748i(500, this.mSource);
                return;
            } else {
                this.mSource.setException(new ResultException(2000, Integer.toString(i)));
                return;
            }
        }
        Object stringArrayList = bundleCall.getStringArrayList(SuggestionConst.KEY_RESULT_SUGGEST_APP_CATEGORIES);
        if (stringArrayList != null) {
            this.mSource.setResult((TResult) stringArrayList);
            return;
        }
        Log.m6487e(TAG, "null!! result: " + stringArrayList);
        AbstractC6670b.m4749j(2000, "bundle content is null", this.mSource);
    }

    @Override // com.samsung.android.sdk.scs.base.tasks.TaskRunnable
    public String getFeatureName() {
        return "FEATURE_SUGGESTION_SUGGEST_APP_CATEGORY";
    }

    public void setPackageNames(List<String> list) {
        this.mPackageNames.addAll(list);
    }
}
