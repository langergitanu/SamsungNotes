package com.samsung.android.sdk.scs.p142ai.text.category;

import android.content.ContentResolver;
import android.net.Uri;
import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.annotation.RestrictTo;
import androidx.appcompat.widget.AbstractC0541b;
import com.samsung.android.app.notes.sync.coedit.sharecore.strategy.AbstractC6670b;
import com.samsung.android.scs.p140ai.sdkcommon.text.TextConst;
import com.samsung.android.sdk.scs.base.ResultException;
import com.samsung.android.sdk.scs.base.tasks.TaskRunnable;
import com.samsung.android.sdk.scs.base.utils.Log;
import com.samsung.android.sdk.scs.p142ai.text.TextServiceExecutor;
import com.samsung.android.sdk.scs.p142ai.text.category.DocumentCategoryClassifier;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Locale;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes6.dex */
@RestrictTo({RestrictTo.Scope.LIBRARY})
public class SimilarityRunnable extends TaskRunnable<List<DocumentSimilarity>> {
    private static final String TAG = "ScsApi@SimilarityRunnable";
    private DocumentCategoryClassifier.ClassifyOptions mOptions;
    private TextServiceExecutor mServiceExecutor;
    private String mSourceText;
    private ArrayList<String> mTargetTextList;

    public SimilarityRunnable(@NonNull TextServiceExecutor textServiceExecutor) {
        this.mServiceExecutor = textServiceExecutor;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference incomplete: some casts might be missing */
    @Override // com.samsung.android.sdk.scs.base.tasks.TaskRunnable
    public void execute() {
        ContentResolver textContentResolver = this.mServiceExecutor.getTextContentResolver();
        Bundle bundle = new Bundle();
        bundle.putString("language", this.mOptions.getLanguage());
        bundle.putString(TextConst.KEY_PARAM_REQUEST_TYPE, this.mOptions.getRequestType());
        bundle.putString("country", this.mOptions.getCountry());
        bundle.putString(TextConst.KEY_PARAM_SOURCE_STRING, this.mSourceText);
        bundle.putStringArrayList(TextConst.KEY_PARAM_TARGET_STRING_LIST, this.mTargetTextList);
        Bundle bundleCall = textContentResolver.call(Uri.parse(TextConst.URI_STRING), TextConst.METHOD_GET_CATEGORY_SIMILARITY, (String) null, bundle);
        if (bundleCall == null) {
            Log.m6487e(TAG, "DocumentCategoryClassifier.isSimilar(). ContentResolver result is null!!");
            AbstractC6670b.m4749j(5, "ContentResolver result is null", this.mSource);
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
        boolean[] booleanArray = bundleCall.getBooleanArray(TextConst.KEY_DOCUMENT_SIMILARITY_ARRAY);
        double[] doubleArray = bundleCall.getDoubleArray(TextConst.KEY_DOCUMENT_SIMILARITY_SCORE_ARRAY);
        if (booleanArray == null || doubleArray == null) {
            Log.m6487e(TAG, "null!! similarityList: " + Arrays.toString(booleanArray) + ", similarityScoreList: " + Arrays.toString(doubleArray));
            AbstractC6670b.m4749j(2000, "bundle content is null", this.mSource);
            return;
        }
        int length = booleanArray.length;
        if (length != doubleArray.length) {
            StringBuilder sbM778t = AbstractC0541b.m778t(length, "unexpected size!!! : ", " vs ");
            sbM778t.append(doubleArray.length);
            Log.m6487e(TAG, sbM778t.toString());
            AbstractC6670b.m4749j(2000, "list size mismatched", this.mSource);
            return;
        }
        ArrayList arrayList = new ArrayList();
        for (int i2 = 0; i2 < length; i2++) {
            DocumentSimilarity documentSimilarity = new DocumentSimilarity();
            documentSimilarity.setSimilarity(booleanArray[i2]);
            documentSimilarity.setScore(doubleArray[i2]);
            arrayList.add(documentSimilarity);
        }
        this.mSource.setResult((TResult) arrayList);
    }

    @Override // com.samsung.android.sdk.scs.base.tasks.TaskRunnable
    public String getFeatureName() {
        return "FEATURE_TEXT_GET_DOCUMENT_CATEGORY";
    }

    public void setOptions(DocumentCategoryClassifier.ClassifyOptions classifyOptions) {
        this.mOptions = classifyOptions;
        if (classifyOptions.getLanguage() == null) {
            classifyOptions.setLanguage(Locale.getDefault().getLanguage());
        }
    }

    public void setSourceText(String str) {
        this.mSourceText = str;
    }

    public void setTargetTextList(ArrayList<String> arrayList) {
        this.mTargetTextList = arrayList;
    }
}
