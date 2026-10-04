package com.samsung.android.support.senl.p148nt.model.collector.common.mining;

import androidx.arch.core.executor.ExecutorC0579a;
import com.samsung.android.sdk.scs.base.tasks.OnCompleteListener;
import com.samsung.android.sdk.scs.base.tasks.Task;
import com.samsung.android.sdk.scs.p142ai.AiServices;
import com.samsung.android.sdk.scs.p142ai.text.phrase.KeyPhrase;
import com.samsung.android.sdk.scs.p142ai.text.phrase.KeyPhraseExtractor;
import com.samsung.android.support.senl.p145cm.base.common.util.UnicodeUtils;
import com.samsung.android.support.senl.p145cm.base.framework.support.BaseUtils;
import com.samsung.android.support.senl.p148nt.data.common.log.DataLogger;
import com.samsung.android.support.senl.p148nt.data.database.core.document.dao.C11253j;
import com.samsung.android.support.senl.p148nt.model.common.log.CollectLogger;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes6.dex */
public abstract class AbsMiningExtractor implements IMiningExtractor {
    private static final String TAG = CollectLogger.createTag("AbsMiningExtractor");
    protected static final int TOP_K = 10;
    protected ICompleteListener mCompleteListener;
    protected final Map<Integer, String> mExtra = new HashMap();
    protected KeyPhraseExtractor.ExtractOptions mExtractOptions;
    protected KeyPhraseExtractor mKeyPhraseExtractor;

    private OnCompleteListener<List<KeyPhrase>> getOnCompleteListener() {
        return new C11253j(this, 7);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$getOnCompleteListener$0(Task task) {
        boolean zIsSuccessful = task.isSuccessful();
        ArrayList<String> arrayList = new ArrayList<>();
        if (zIsSuccessful && task.getResult() != null) {
            for (KeyPhrase keyPhrase : (List) task.getResult()) {
                arrayList.add(keyPhrase.getString());
                keyPhrase.getString();
            }
        }
        DataLogger.m12302d(TAG, "onComplete " + getClass().getSimpleName() + ", isSuccessful : " + zIsSuccessful);
        this.mCompleteListener.onCompleted(arrayList);
    }

    @Override // com.samsung.android.support.senl.p148nt.model.collector.common.mining.IMiningExtractor
    public void extract(String str, ICompleteListener iCompleteListener) {
        initExtract();
        initExtractOptions();
        this.mCompleteListener = iCompleteListener;
        if (!isValid()) {
            this.mCompleteListener.onCompleted(new ArrayList<>());
        } else {
            this.mExtractOptions.setExtraInfo(this.mExtra);
            this.mKeyPhraseExtractor.extract(UnicodeUtils.removeObjectReplacementChar(str), this.mExtractOptions).addOnCompleteListener(new ExecutorC0579a(2), getOnCompleteListener());
        }
    }

    @Override // com.samsung.android.support.senl.p148nt.model.collector.common.mining.IMiningExtractor
    public void initExtract() {
        this.mKeyPhraseExtractor = AiServices.getKeyPhraseExtractor(BaseUtils.getContext());
    }

    @Override // com.samsung.android.support.senl.p148nt.model.collector.common.mining.IMiningExtractor
    public abstract void initExtractOptions();

    @Override // com.samsung.android.support.senl.p148nt.model.collector.common.mining.IMiningExtractor
    public boolean isValid() {
        return this.mExtractOptions != null;
    }

    @Override // com.samsung.android.support.senl.p148nt.model.collector.common.mining.IMiningExtractor
    public void setExtraTitle(String str) {
        this.mExtra.put(0, str);
    }
}
