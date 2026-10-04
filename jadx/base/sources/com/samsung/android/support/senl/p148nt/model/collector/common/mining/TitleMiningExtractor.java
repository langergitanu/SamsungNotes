package com.samsung.android.support.senl.p148nt.model.collector.common.mining;

import com.samsung.android.sdk.scs.p142ai.text.phrase.KeyPhraseExtractor;
import com.samsung.android.support.senl.p145cm.base.common.util.LocaleUtils;
import com.samsung.android.support.senl.p145cm.base.framework.support.BaseUtils;
import com.samsung.android.support.senl.p148nt.data.common.log.DataLogger;
import com.samsung.android.support.senl.p148nt.model.common.log.CollectLogger;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes6.dex */
public class TitleMiningExtractor extends AbsMiningExtractor {
    private static final String TAG = CollectLogger.createTag("TitleMiningExtractor");
    private static final int TOP_K = 5;

    @Override // com.samsung.android.support.senl.p148nt.model.collector.common.mining.AbsMiningExtractor, com.samsung.android.support.senl.p148nt.model.collector.common.mining.IMiningExtractor
    public void initExtractOptions() {
        try {
            this.mExtractOptions = new KeyPhraseExtractor.ExtractOptions(KeyPhraseExtractor.RequestType.NOTE_TITLE, KeyPhraseExtractor.ActionType.MANUAL).setLanguage(LocaleUtils.getLocale(BaseUtils.getApplicationContext().getResources().getConfiguration()).getLanguage()).setTopK(5);
        } catch (NoSuchFieldError e) {
            DataLogger.m12303e(TAG, "initExtractOptions : " + e.getMessage());
        }
    }
}
