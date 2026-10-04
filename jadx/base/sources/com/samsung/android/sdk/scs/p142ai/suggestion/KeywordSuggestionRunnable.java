package com.samsung.android.sdk.scs.p142ai.suggestion;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import androidx.annotation.RestrictTo;
import androidx.appcompat.widget.AbstractC0541b;
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
public class KeywordSuggestionRunnable extends TaskRunnable<List<Keyword>> {
    private static final String TAG = "ScsApi@KeywordSuggestionRunnable";
    private Context mContext;
    private int mCount;
    private boolean mIsLocationGranted;
    private KeywordSuggestionType mSuggestionType;

    public KeywordSuggestionRunnable(Context context, KeywordSuggestionType keywordSuggestionType, int i, boolean z) {
        this.mContext = context;
        this.mSuggestionType = keywordSuggestionType;
        this.mCount = i;
        this.mIsLocationGranted = z;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference incomplete: some casts might be missing */
    @Override // com.samsung.android.sdk.scs.base.tasks.TaskRunnable
    public void execute() {
        Log.m6485d(TAG, "run");
        Bundle bundle = new Bundle();
        bundle.putInt("count", this.mCount);
        bundle.putBoolean(SuggestionConst.KEY_PARAM_LOCATION_ACCESS, this.mIsLocationGranted);
        bundle.putString(SuggestionConst.KEY_PARAM_CLIENT, this.mSuggestionType.getType());
        try {
            Bundle bundleCall = this.mContext.getContentResolver().call(Uri.parse(SuggestionConst.URI_STRING), SuggestionConst.METHOD_SUGGEST, (String) null, bundle);
            if (bundleCall == null) {
                Log.m6487e(TAG, "returnBundle is null");
                AbstractC6670b.m4749j(5, "returnBundle is null", this.mSource);
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
            ArrayList<String> stringArrayList = bundleCall.getStringArrayList(SuggestionConst.KEY_QUERY_STRING_LIST);
            ArrayList<String> stringArrayList2 = bundleCall.getStringArrayList(SuggestionConst.KEY_TAG_TYPE_LIST);
            if (stringArrayList == null || stringArrayList2 == null) {
                Log.m6487e(TAG, "null!! queryStringList: " + stringArrayList + ", tagTypeList: " + stringArrayList2);
                AbstractC6670b.m4749j(2000, "bundle content is null", this.mSource);
                return;
            }
            int size = stringArrayList.size();
            if (size != stringArrayList2.size()) {
                StringBuilder sbM778t = AbstractC0541b.m778t(size, "unexpected size!!! : ", " vs ");
                sbM778t.append(stringArrayList2.size());
                Log.m6487e(TAG, sbM778t.toString());
                AbstractC6670b.m4749j(2000, "list size mismatched", this.mSource);
                return;
            }
            ArrayList arrayList = new ArrayList();
            for (int i2 = 0; i2 < size; i2++) {
                arrayList.add(new Keyword(stringArrayList.get(i2), stringArrayList2.get(i2)));
            }
            this.mSource.setResult((TResult) arrayList);
        } catch (IllegalArgumentException e) {
            Log.m6487e(TAG, e.toString() + ", Cannot call suggestion provider");
            this.mSource.setException(e);
        }
    }

    @Override // com.samsung.android.sdk.scs.base.tasks.TaskRunnable
    public String getFeatureName() {
        return "FEATURE_SUGGESTION_SUGGEST_KEYWORD";
    }
}
