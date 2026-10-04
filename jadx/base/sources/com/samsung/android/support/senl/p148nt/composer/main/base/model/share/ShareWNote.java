package com.samsung.android.support.senl.p148nt.composer.main.base.model.share;

import com.samsung.android.sdk.pen.worddoc.SpenWNote;
import com.samsung.android.support.senl.p145cm.base.framework.support.LoggerBase;
import com.samsung.android.support.senl.p148nt.composer.main.base.util.Logger;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes3.dex */
public class ShareWNote {
    private static final String TAG = Logger.createTag("ShareWNote");
    private SpenWNote mSpenWNote;

    public ShareWNote(SpenWNote spenWNote) {
        this.mSpenWNote = spenWNote;
    }

    public void close() {
        Logger.m11003i(TAG, "close# skip");
    }

    public SpenWNote getNote() {
        return this.mSpenWNote;
    }

    public void close(String str) {
        Logger.m11003i(TAG, "close# skip : " + LoggerBase.getEncode(str));
    }
}
