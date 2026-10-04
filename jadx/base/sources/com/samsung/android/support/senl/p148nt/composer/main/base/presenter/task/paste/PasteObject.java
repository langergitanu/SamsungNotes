package com.samsung.android.support.senl.p148nt.composer.main.base.presenter.task.paste;

import android.content.Context;
import android.graphics.PointF;
import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import com.samsung.android.sdk.pen.document.SpenObjectBase;
import com.samsung.android.sdk.pen.worddoc.SpenWNote;
import com.samsung.android.sdk.pen.worddoc.SpenWNoteFile;
import com.samsung.android.support.senl.p148nt.app.addons.AbstractC8014b;
import com.samsung.android.support.senl.p148nt.base.composer.clipboard.ClipboardCacheManager;
import com.samsung.android.support.senl.p148nt.composer.main.base.model.ComposerModel;
import com.samsung.android.support.senl.p148nt.composer.main.base.model.composer.ObjectManager;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.task.paste.AbsPasteLogic;
import com.samsung.android.support.senl.p148nt.composer.main.base.util.Logger;
import java.io.IOException;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes3.dex */
public class PasteObject extends AbsPasteLogic {
    private static final String TAG = Logger.createTag("TaskPaste#PasteObject");
    private ComposerModel mComposerModel;
    private List<SpenObjectBase> mObjectList;
    private ObjectManager mObjectManager;
    private final PointF mPastePosition;
    private final String mRestoreFilePath;
    private SpenWNote mSpenWNote;
    private final int mTargetPageIndex;

    public PasteObject(AbsPasteLogic.Contract contract, Context context, Handler handler, ComposerModel composerModel, ObjectManager objectManager, SpenWNote spenWNote, String str, int i, PointF pointF) {
        super(contract, context, handler);
        this.mComposerModel = composerModel;
        this.mObjectManager = objectManager;
        this.mSpenWNote = spenWNote;
        this.mRestoreFilePath = str;
        this.mTargetPageIndex = i;
        this.mPastePosition = pointF;
    }

    private void handlePasteNextObject(@NonNull Message message) {
        Object obj = message.obj;
        if (obj instanceof Integer) {
            AbstractC8014b.m7217s(((Integer) obj).intValue(), "MESSAGE_PASTE_NEXT_OBJECT# index - ", TAG);
            List<SpenObjectBase> list = this.mObjectList;
            if (list == null) {
                this.mContract.release();
            } else {
                this.mObjectManager.addObjects(this.mTargetPageIndex, list, this.mPastePosition);
                this.mContract.release();
            }
        }
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.base.presenter.task.paste.AbsPasteLogic
    public void handleMessage(@NonNull Message message) {
        handlePasteNextObject(message);
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.base.presenter.task.paste.AbsPasteLogic
    public void readyContents() {
        this.mObjectList = this.mSpenWNote.restoreObjectList(this.mRestoreFilePath);
        int iApplyCoeditRestrictionToObjects = new CoeditRestriction(this.mComposerModel).applyCoeditRestrictionToObjects(this.mObjectList, this.mRestoreFilePath.contains(ClipboardCacheManager.CLIPBOARD_BODY_TEXT_PREFIX));
        if (iApplyCoeditRestrictionToObjects == 1) {
            setErrorCode(32);
        } else if (iApplyCoeditRestrictionToObjects == 3) {
            setErrorCode(128);
        }
        if (this.mObjectList != null) {
            Logger.addFileLog(TAG, "pasteObj:" + this.mObjectList.size(), 0);
        }
        if (this.mIsReleased) {
            return;
        }
        Handler handler = this.mHandler;
        handler.sendMessage(handler.obtainMessage(4, 0));
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.base.presenter.task.paste.AbsPasteLogic
    public void release() {
        List<SpenObjectBase> list = this.mObjectList;
        if (list != null) {
            list.clear();
            this.mObjectList = null;
        }
        if (this.mContext != null && !TextUtils.isEmpty(this.mRestoreFilePath)) {
            Logger.m11003i(TAG, "release# removeCache");
            try {
                SpenWNoteFile.removeClosedCache(this.mContext, this.mRestoreFilePath);
            } catch (IOException unused) {
                Logger.m11000e(TAG, "release# fail to remove cache.");
            }
        }
        this.mSpenWNote = null;
        this.mObjectManager = null;
        this.mComposerModel = null;
        this.mContext = null;
    }
}
