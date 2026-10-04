package com.samsung.android.support.senl.p148nt.composer.main.pdfwriter.presenter.config;

import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.config.BaseConfig;
import cz.msebera.android.httpclient.impl.client.cache.CacheValidityPolicy;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes3.dex */
public class PwConfig extends BaseConfig {
    public PwConfig() {
        this.mIsVoiceRecordingEnabled = false;
        this.mIsTitleEditable = false;
        this.mIsBookmarkMenuEnabled = false;
        this.mIsAudioFileAttachable = false;
        this.mIsHandWritingHelpEnabled = false;
        this.mIsHashTagEnabled = false;
        this.mIsStickyMemoEnabled = false;
        this.mIsTableEnabled = false;
        this.mIsAutoSaveOptionEnabled = Boolean.FALSE;
        this.mIsRestoreEnabled = true;
        this.mMaxDocumentSize = CacheValidityPolicy.MAX_AGE;
    }
}
