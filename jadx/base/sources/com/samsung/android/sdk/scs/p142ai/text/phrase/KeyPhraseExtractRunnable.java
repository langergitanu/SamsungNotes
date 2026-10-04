package com.samsung.android.sdk.scs.p142ai.text.phrase;

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
import com.samsung.android.sdk.scs.p142ai.text.phrase.KeyPhraseExtractor;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Locale;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes6.dex */
@RestrictTo({RestrictTo.Scope.LIBRARY})
public class KeyPhraseExtractRunnable extends TaskRunnable<List<KeyPhrase>> {
    private static final String TAG = "ScsApi@KeyPhraseExtractRunnable";
    private KeyPhraseExtractor.ExtractOptions mOptions;
    private String mRequestType;
    private TextServiceExecutor mServiceExecutor;
    private String mText;

    public KeyPhraseExtractRunnable(@NonNull TextServiceExecutor textServiceExecutor, String str) {
        this.mRequestType = str;
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
        bundle.putString("actionType", this.mOptions.getActionType());
        bundle.putSerializable(TextConst.KEY_PARAM_USER_TAGS, (Serializable) this.mOptions.getUserTags());
        bundle.putSerializable("extraInfo", (Serializable) this.mOptions.getExtraInfo());
        bundle.putInt(TextConst.KEY_PARAM_TOP_K, this.mOptions.getTopK());
        bundle.putString("string", this.mText);
        Bundle bundleCall = textContentResolver.call(Uri.parse(TextConst.URI_STRING), TextConst.METHOD_GET_KEY_PHRASE, (String) null, bundle);
        if (bundleCall == null) {
            Log.m6487e(TAG, "KeyPhraseExtractor.extract(). ContentResolver result is null!!");
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
        ArrayList<String> stringArrayList = bundleCall.getStringArrayList(TextConst.KEY_PHRASE_TEXT_LIST);
        double[] doubleArray = bundleCall.getDoubleArray(TextConst.KEY_PHRASE_SCORE_ARRAY);
        if (stringArrayList == null || doubleArray == null) {
            Log.m6487e(TAG, "null!! keyPhraseTextList: " + stringArrayList + ", keyPhraseScoreArray: " + Arrays.toString(doubleArray));
            AbstractC6670b.m4749j(2000, "bundle content is null", this.mSource);
            return;
        }
        int size = stringArrayList.size();
        if (size != doubleArray.length) {
            StringBuilder sbM778t = AbstractC0541b.m778t(size, "unexpected size!!! : ", " vs ");
            sbM778t.append(doubleArray.length);
            Log.m6487e(TAG, sbM778t.toString());
            AbstractC6670b.m4749j(2000, "list size mismatched", this.mSource);
            return;
        }
        ArrayList arrayList = new ArrayList();
        for (int i2 = 0; i2 < size; i2++) {
            KeyPhrase keyPhrase = new KeyPhrase();
            keyPhrase.setString(stringArrayList.get(i2));
            keyPhrase.setScore(doubleArray[i2]);
            arrayList.add(keyPhrase);
        }
        this.mSource.setResult((TResult) arrayList);
    }

    @Override // com.samsung.android.sdk.scs.base.tasks.TaskRunnable
    public String getFeatureName() {
        return KeyPhraseExtractor.RequestType.EVENT_TITLE.name().equals(this.mRequestType) ? "FEATURE_TEXT_GET_KEY_PHRASE_EVENT_TITLE" : "FEATURE_TEXT_GET_KEY_PHRASE";
    }

    public void setOptions(KeyPhraseExtractor.ExtractOptions extractOptions) {
        this.mOptions = extractOptions;
        if (extractOptions.getLanguage() == null) {
            extractOptions.setLanguage(Locale.getDefault().getLanguage());
        }
    }

    public void setText(String str) {
        this.mText = str;
    }
}
