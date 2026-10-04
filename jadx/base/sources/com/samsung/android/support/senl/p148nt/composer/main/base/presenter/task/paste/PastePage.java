package com.samsung.android.support.senl.p148nt.composer.main.base.presenter.task.paste;

import android.content.Context;
import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.WorkerThread;
import com.samsung.android.sdk.pen.document.SpenObjectContainer;
import com.samsung.android.sdk.pen.document.SpenObjectTextBox;
import com.samsung.android.sdk.pen.document.SpenUnsupportedTypeException;
import com.samsung.android.sdk.pen.document.SpenUnsupportedVersionException;
import com.samsung.android.sdk.pen.worddoc.SpenWNote;
import com.samsung.android.sdk.pen.worddoc.SpenWPage;
import com.samsung.android.support.senl.p148nt.app.addons.AbstractC8014b;
import com.samsung.android.support.senl.p148nt.composer.main.base.model.ComposerModel;
import com.samsung.android.support.senl.p148nt.composer.main.base.model.composer.NoteManager;
import com.samsung.android.support.senl.p148nt.composer.main.base.model.composer.TextManager;
import com.samsung.android.support.senl.p148nt.composer.main.base.model.menu.list.pages.BookmarkModel;
import com.samsung.android.support.senl.p148nt.composer.main.base.page.PageCopyData;
import com.samsung.android.support.senl.p148nt.composer.main.base.page.PageManager;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.task.paste.AbsPasteLogic;
import com.samsung.android.support.senl.p148nt.composer.main.base.util.BackgroundColorUtil;
import com.samsung.android.support.senl.p148nt.composer.main.base.util.Logger;
import com.samsung.android.support.senl.p148nt.model.utils.DocumentBackgroundUtils;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Objects;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes3.dex */
public class PastePage extends AbsPasteLogic {
    private static final String TAG = Logger.createTag("TaskPaste#PastePage");
    private int mAddedPageCount;
    private ComposerModel mComposerModel;
    private SpenWNote mCopiedNote;
    private boolean mLastPage;
    private NoteManager mNoteManager;
    private PageManager mPageManager;
    private final String mRestoreFilePath;
    private SpenWNote mSpenWNote;
    private int mTargetPageIndex;
    private TextManager mTextManager;

    public PastePage(AbsPasteLogic.Contract contract, Context context, Handler handler, ComposerModel composerModel, SpenWNote spenWNote, NoteManager noteManager, TextManager textManager, PageManager pageManager, String str, int i) {
        super(contract, context, handler);
        this.mLastPage = false;
        this.mComposerModel = composerModel;
        this.mSpenWNote = spenWNote;
        this.mNoteManager = noteManager;
        this.mTextManager = textManager;
        this.mPageManager = pageManager;
        this.mRestoreFilePath = str;
        this.mTargetPageIndex = i;
        this.mAddedPageCount = 0;
    }

    private boolean checkBodyTextLimit(SpenObjectTextBox spenObjectTextBox, int i, SpenWPage spenWPage) {
        int textLengthByEmptyBodyTextPage;
        if (spenObjectTextBox == null || TextUtils.isEmpty(spenObjectTextBox.getText())) {
            textLengthByEmptyBodyTextPage = this.mTextManager.getTextLengthByEmptyBodyTextPage(i, spenWPage);
            AbstractC8014b.m7217s(textLengthByEmptyBodyTextPage, "checkBodyTextLimit# TextLengthByEmptyBodyTextPage:", TAG);
        } else {
            textLengthByEmptyBodyTextPage = spenObjectTextBox.getText().length();
        }
        return isAvailableBodyTextLimit(textLengthByEmptyBodyTextPage);
    }

    private void closeCopiedNote() {
        SpenWNote spenWNote = this.mCopiedNote;
        if (spenWNote == null || spenWNote.isClosed()) {
            Logger.m11003i(TAG, "closeCopiedNote# " + this.mCopiedNote);
            return;
        }
        try {
            this.mCopiedNote.close(true);
        } catch (IOException e) {
            Logger.m11001e(TAG, "closeCopiedNote# " + e.getMessage(), e);
        }
    }

    private void completePaste() {
        AbstractC8014b.m7195A(new StringBuilder("completePaste# mAddedPageCount:"), TAG, this.mAddedPageCount);
        if (this.mAddedPageCount > 0) {
            updateDummyPage();
            this.mPageManager.setBlockNotiToInsert(false);
            PageManager pageManager = this.mPageManager;
            pageManager.notifyDataSetChanged(3, this.mTargetPageIndex + 1, pageManager.getPageCount());
            this.mPageManager.getDocPageInfo().setCurrentPageIndex(this.mTargetPageIndex + this.mAddedPageCount, true);
            this.mNoteManager.commitHistory();
        }
        closeCopiedNote();
        this.mContract.release();
    }

    private void handlePastePage(@NonNull Message message) {
        String str = TAG;
        AbstractC8014b.m7195A(new StringBuilder("handlePastePage# start:"), str, message.arg1);
        if (this.mSpenWNote.getOrientation() == this.mCopiedNote.getOrientation()) {
            if (this.mSpenWNote.getPageMode() != SpenWNote.PageMode.SINGLE) {
                pastePage(message.arg1);
                return;
            }
            Logger.m11004w(str, "handlePastePage# user try to paste pages on single mode");
            setErrorCode(1);
            closeCopiedNote();
            this.mContract.release();
            return;
        }
        setErrorCode(8192);
        if (this.mComposerModel.getDoc().getPageMode() == SpenWNote.PageMode.SINGLE) {
            setErrorCodeSubType(1);
        } else if (this.mComposerModel.getDoc().getOrientation() == SpenWNote.Orientation.LANDSCAPE_NEW) {
            setErrorCodeSubType(3);
        } else {
            setErrorCodeSubType(2);
        }
        Logger.m11003i(str, "handlePastePage# note getOrientation = " + this.mComposerModel.getDoc().getOrientation() + " / mCopiedNote = " + this.mCopiedNote.getOrientation());
        closeCopiedNote();
        this.mContract.release();
    }

    private boolean isAvailableBodyTextLimit(int i) {
        int length;
        int length2;
        if (this.mSpenWNote.getBodyText() == null || TextUtils.isEmpty(this.mSpenWNote.getBodyText().getText()) || this.mSpenWNote.getBodyText().getTextLimit() >= (length2 = i + (length = this.mSpenWNote.getBodyText().getText().length()))) {
            return true;
        }
        Logger.m11000e(TAG, "availableBodyTextLimit# Text limit error. bodyTextLength:" + length + ", totalTextLength:" + length2);
        return false;
    }

    private void pastePage(int i) {
        boolean z;
        BookmarkModel bookmarkModel;
        String str = TAG;
        AbstractC8014b.m7217s(i, "pastePage# start loadPageIndex:", str);
        if (i < this.mCopiedNote.getPageCount()) {
            int i2 = this.mTargetPageIndex + 1 + this.mAddedPageCount;
            SpenWPage page = this.mCopiedNote.getPage(i);
            if (page.getTemplateType() == 17) {
                setErrorCode(16384);
                completePaste();
                return;
            }
            SpenWPage page2 = this.mCopiedNote.getPage(i + 1);
            Logger.m11003i(str, "pastePage# getPage insetIndex:" + i2);
            if (page2.getObjectCount(false) > 0) {
                SpenObjectContainer spenObjectContainer = (SpenObjectContainer) page2.getObject(0);
                boolean z2 = spenObjectContainer.getExtraDataInt(PageCopyData.PAGE_COPY_BOOKMARK_KEY) == 1;
                spenObjectTextBox = spenObjectContainer.getObjectList().isEmpty() ? null : (SpenObjectTextBox) spenObjectContainer.getObject(0);
                z = z2;
            } else {
                z = false;
            }
            SpenObjectTextBox spenObjectTextBox = spenObjectTextBox;
            if (!checkBodyTextLimit(spenObjectTextBox, i2, page)) {
                setErrorCode(16);
                completePaste();
                return;
            }
            SpenWPage spenWPageInsertPage = this.mNoteManager.insertPage(i2, page.getWidth(), page.getHeight(), page, spenObjectTextBox, this.mCopiedNote.getBodyTextFontSizeDelta(), false);
            this.mNoteManager.getNotePdfData().setHavingPdf(spenWPageInsertPage);
            if (!this.mUpdateInvertBG) {
                DocumentBackgroundUtils.InvertBackgroundColorType invertBackgroundColorType = DocumentBackgroundUtils.InvertBackgroundColorType.None;
                ArrayList arrayList = new ArrayList(1);
                Object obj = new Object[]{spenWPageInsertPage}[0];
                Objects.requireNonNull(obj);
                arrayList.add(obj);
                if (invertBackgroundColorType != BackgroundColorUtil.getInvertBackgroundColorType(Collections.unmodifiableList(arrayList))) {
                    this.mUpdateInvertBG = true;
                }
            }
            this.mAddedPageCount++;
            if (z && (bookmarkModel = this.mComposerModel.getBookmarkModel()) != null) {
                bookmarkModel.update(spenWPageInsertPage.getId(), i2, true, false, false);
            }
            Handler handler = this.mHandler;
            handler.sendMessage(handler.obtainMessage(7, i + 2, 0));
        } else {
            completePaste();
        }
        Logger.m11003i(str, "pastePage# done");
    }

    private boolean readyPastePage(String str) {
        try {
            if (this.mComposerModel.getMdeManager().getCoeditAdapter().isCoeditNote()) {
                setErrorCode(64);
                return false;
            }
            this.mCopiedNote = new SpenWNote(this.mContext, str, this.mSpenWNote.getPageDefaultWidth(), 1000, true, false, false);
            Logger.m11003i(TAG, "readyPastePage# new SpenWNote");
            int pageCount = this.mNoteManager.getNote().getPageCount();
            if (this.mNoteManager.isDummyPage(this.mTargetPageIndex, pageCount)) {
                this.mTargetPageIndex--;
                this.mLastPage = true;
            } else if (this.mNoteManager.isLastPage(this.mTargetPageIndex, pageCount)) {
                this.mLastPage = true;
            }
            return true;
        } catch (SpenUnsupportedTypeException e) {
            e = e;
            Throwable th = e;
            Logger.m11001e(TAG, th.getMessage(), th);
            setErrorCode(4);
            return false;
        } catch (SpenUnsupportedVersionException e2) {
            e = e2;
            Throwable th2 = e;
            Logger.m11001e(TAG, th2.getMessage(), th2);
            setErrorCode(4);
            return false;
        } catch (IOException e3) {
            e = e3;
            Throwable th22 = e;
            Logger.m11001e(TAG, th22.getMessage(), th22);
            setErrorCode(4);
            return false;
        } catch (NullPointerException e5) {
            e = e5;
            Throwable th222 = e;
            Logger.m11001e(TAG, th222.getMessage(), th222);
            setErrorCode(4);
            return false;
        }
    }

    private void updateDummyPage() {
        if (this.mLastPage) {
            this.mNoteManager.updateDummyPage();
        }
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.base.presenter.task.paste.AbsPasteLogic
    public void handleMessage(@NonNull Message message) {
        handlePastePage(message);
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.base.presenter.task.paste.AbsPasteLogic
    @WorkerThread
    public void readyContents() {
        if (!readyPastePage(this.mRestoreFilePath)) {
            this.mHandler.sendEmptyMessage(9);
            return;
        }
        Logger.addFileLog(TAG, "pastePage", 0);
        if (this.mIsReleased) {
            return;
        }
        this.mPageManager.setBlockNotiToInsert(true);
        Handler handler = this.mHandler;
        handler.sendMessage(handler.obtainMessage(7, 0, 0));
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.base.presenter.task.paste.AbsPasteLogic
    public void release() {
        PageManager pageManager = this.mPageManager;
        if (pageManager != null) {
            pageManager.setBlockNotiToInsert(false);
        }
        this.mComposerModel = null;
        this.mSpenWNote = null;
        this.mNoteManager = null;
        this.mTextManager = null;
        this.mPageManager = null;
        this.mContext = null;
    }
}
