package com.samsung.android.support.senl.p148nt.composer.main.base.model.share;

import android.text.TextUtils;
import androidx.annotation.Nullable;
import com.samsung.android.sdk.pen.worddoc.SpenWNote;
import com.samsung.android.support.senl.p145cm.base.framework.support.LoggerBase;
import com.samsung.android.support.senl.p148nt.app.addons.AbstractC8014b;
import com.samsung.android.support.senl.p148nt.base.common.util.FileUtils;
import com.samsung.android.support.senl.p148nt.composer.main.base.util.Logger;
import com.samsung.android.support.senl.p148nt.model.documents.file.DocumentFileManager;
import java.io.File;
import java.io.IOException;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes3.dex */
public class ShareCreatedWNote extends ShareWNote {
    private static final String TAG = Logger.createTag("SharePageWNote");
    private final String mFilePath;

    public ShareCreatedWNote(SpenWNote spenWNote, @Nullable String str) {
        super(spenWNote);
        this.mFilePath = str;
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.base.model.share.ShareWNote
    public void close() {
        Logger.m11003i(TAG, "close#");
        try {
            if (this.mFilePath == null) {
                getNote().close(true);
            } else {
                DocumentFileManager.getInstance().close(this.mFilePath, getNote(), true);
            }
        } catch (IOException e) {
            AbstractC8014b.m7204f(e, new StringBuilder("close# SpenWNote fail e : "), TAG);
        }
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.base.model.share.ShareWNote
    public void close(String str) {
        String str2 = TAG;
        Logger.m11003i(str2, "close# " + LoggerBase.getEncode(str));
        try {
            if (this.mFilePath == null) {
                getNote().close(true);
            } else {
                DocumentFileManager.getInstance().close(this.mFilePath, getNote(), true);
            }
            if (TextUtils.isEmpty(str)) {
                return;
            }
            if (str.contains(ShareUtils.getDefaultNoteFilePath())) {
                Logger.m11002f(str2, "close# error " + LoggerBase.getEncode(str));
                return;
            }
            FileUtils.deleteFile(new File(str));
        } catch (IOException e) {
            AbstractC8014b.m7204f(e, new StringBuilder("close# SpenWNote fail e : "), TAG);
        }
    }
}
