package com.samsung.android.sdk.scs.p142ai.suggestion;

import android.content.ContentResolver;
import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.annotation.RestrictTo;
import com.samsung.android.app.notes.sync.coedit.sharecore.strategy.AbstractC6670b;
import com.samsung.android.scs.p140ai.sdkcommon.suggestion.AppCategoryDetail;
import com.samsung.android.scs.p140ai.sdkcommon.suggestion.SuggestionConst;
import com.samsung.android.sdk.scs.base.ResultException;
import com.samsung.android.sdk.scs.base.tasks.TaskRunnable;
import com.samsung.android.sdk.scs.base.utils.Log;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes6.dex */
@RestrictTo({RestrictTo.Scope.LIBRARY})
public class AppCategoryDetailsRunnable extends TaskRunnable<List<AppCategoryResult>> {
    private static final String TAG = "AppCategoryDetailsRunnable";
    private List<AppCategoryResult> mAppCategoryResult;
    private Context mContext;
    private ArrayList<String> mPackageNames = new ArrayList<>();

    public AppCategoryDetailsRunnable(@NonNull Context context) {
        this.mContext = context;
    }

    private void generateResult(List<AppCategoryDetail> list) {
        for (AppCategoryDetail appCategoryDetail : list) {
            AppCategoryResult appCategoryResultCreate = AppCategoryResult.create();
            appCategoryResultCreate.setPackageName(appCategoryDetail.getPackageName());
            appCategoryResultCreate.setCategoryString(appCategoryDetail.getCategoryString());
            appCategoryResultCreate.setCategoryId(appCategoryDetail.getCategoryId());
            this.mAppCategoryResult.add(appCategoryResultCreate);
        }
    }

    /* JADX WARN: Type inference incomplete: some casts might be missing */
    @Override // com.samsung.android.sdk.scs.base.tasks.TaskRunnable
    public void execute() {
        Log.m6489i(TAG, "execute() called");
        ContentResolver contentResolver = this.mContext.getContentResolver();
        Bundle bundle = new Bundle();
        bundle.putStringArrayList(SuggestionConst.KEY_PACKAGE_NAMES, this.mPackageNames);
        Bundle bundleCall = contentResolver.call(Uri.parse(SuggestionConst.URI_STRING), SuggestionConst.METHOD_SUGGEST_APP_CATEGORY_DETAILS, (String) null, bundle);
        if (bundleCall == null) {
            Log.m6487e(TAG, "getAppCategories ContentResolver result is null!!");
            AbstractC6670b.m4749j(5, "ContentResolver is null", this.mSource);
            return;
        }
        bundleCall.setClassLoader(AppCategoryDetail.class.getClassLoader());
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
        ArrayList parcelableArrayList = bundleCall.getParcelableArrayList(SuggestionConst.KEY_RESULT_SUGGEST_APP_CATEGORY_DETAILS);
        if (parcelableArrayList != null) {
            this.mAppCategoryResult = new ArrayList();
            generateResult(parcelableArrayList);
            this.mSource.setResult((TResult) this.mAppCategoryResult);
        } else {
            Log.m6487e(TAG, "null!! result: " + parcelableArrayList);
            AbstractC6670b.m4749j(2000, "bundle content is null", this.mSource);
        }
    }

    @Override // com.samsung.android.sdk.scs.base.tasks.TaskRunnable
    public String getFeatureName() {
        return "FEATURE_SUGGESTION_SUGGEST_APP_CATEGORY_DETAILS";
    }

    public void setPackageNames(List<String> list) {
        this.mPackageNames.addAll(list);
    }
}
