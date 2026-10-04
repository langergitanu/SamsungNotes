package com.samsung.android.support.senl.p148nt.composer.main.base.model.composer.object;

import android.graphics.Point;
import android.graphics.PointF;
import android.graphics.RectF;
import androidx.annotation.Nullable;
import com.samsung.android.sdk.composer.input.SpenNoteObjectInserter;
import com.samsung.android.sdk.composer.text.ISpenNoteTextManager;
import com.samsung.android.sdk.composer.view.zoomScroller.ISpenNoteZoomScroller;
import com.samsung.android.sdk.pen.document.SpenObjectBase;
import com.samsung.android.sdk.pen.document.SpenObjectPainting;
import com.samsung.android.sdk.pen.document.SpenObjectShape;
import com.samsung.android.sdk.pen.document.SpenObjectVoice;
import com.samsung.android.sdk.pen.document.textspan.SpenObjectSpan;
import com.samsung.android.sdk.pen.worddoc.SpenWNote;
import com.samsung.android.sdk.pen.worddoc.SpenWPage;
import com.samsung.android.support.senl.p148nt.base.composer.content.ObjectHelper;
import com.samsung.android.support.senl.p148nt.base.composer.text.common.TextUtil;
import com.samsung.android.support.senl.p148nt.composer.main.base.model.composer.object.IObjectInserter;
import com.samsung.android.support.senl.p148nt.composer.main.base.util.Logger;
import java.util.ArrayList;
import java.util.Iterator;
import p001A.AbstractC0000a;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes3.dex */
public class ObjectInserterObjectSpan implements IObjectInserter {
    private static final String TAG = Logger.createTag("ObjectInserterObjectSpan");
    private final SpenObjectShape mBodyText;
    private boolean mIsHwMode;
    private final SpenWNote mNote;
    private final ObjectLayoutOption mObjectLayoutOption;
    private final ISpenNoteZoomScroller mSpenNoteDeltaZoom;
    private final SpenNoteObjectInserter mSpenNoteObjectInserter;
    private final ISpenNoteTextManager mSpenNoteTextManager;

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static class ObjectSpanOptions implements IObjectInserter.IOptions {
        boolean mIsInlineLayout = false;
        boolean mIsAnimationEnabled = false;

        public void animationEnabled(boolean z) {
            this.mIsAnimationEnabled = z;
        }

        public void setInlineLayout(boolean z) {
            this.mIsInlineLayout = z;
        }

        public void setOption(SpenObjectSpan spenObjectSpan) {
            if (this.mIsInlineLayout) {
                ObjectHelper.setInlineOption(spenObjectSpan);
            }
        }
    }

    public ObjectInserterObjectSpan(SpenWNote spenWNote, SpenNoteObjectInserter spenNoteObjectInserter, ObjectLayoutOption objectLayoutOption, ISpenNoteTextManager iSpenNoteTextManager, ISpenNoteZoomScroller iSpenNoteZoomScroller) {
        this.mNote = spenWNote;
        this.mBodyText = spenWNote.getBodyText();
        this.mSpenNoteObjectInserter = spenNoteObjectInserter;
        this.mObjectLayoutOption = objectLayoutOption;
        this.mSpenNoteTextManager = iSpenNoteTextManager;
        this.mSpenNoteDeltaZoom = iSpenNoteZoomScroller;
    }

    private void appendObjectSpan(int i, SpenObjectBase spenObjectBase, @Nullable IObjectInserter.IOptions iOptions, boolean z) {
        SpenObjectSpan spenObjectSpan = new SpenObjectSpan(spenObjectBase, i);
        ObjectHelper.setObjectSpanDefaultOption(spenObjectSpan);
        if (iOptions instanceof ObjectSpanOptions) {
            ObjectSpanOptions objectSpanOptions = (ObjectSpanOptions) iOptions;
            objectSpanOptions.setOption(spenObjectSpan);
            if (objectSpanOptions.mIsAnimationEnabled) {
                this.mSpenNoteTextManager.appendObjectSpan(spenObjectSpan, true, z);
                return;
            }
        }
        this.mBodyText.appendObjectSpan(spenObjectSpan);
        if (z) {
            this.mNote.commitHistory();
        }
    }

    private Point getPageOffset(int i) {
        if (this.mNote.getPageMode() != SpenWNote.PageMode.SINGLE) {
            return this.mNote.getPage(i).getOffset();
        }
        RectF contentRectInView = this.mSpenNoteDeltaZoom.getContentRectInView();
        return contentRectInView == null ? new Point(0, 0) : new Point((int) contentRectInView.left, (int) contentRectInView.top);
    }

    private void insertObjectSpan(SpenObjectBase spenObjectBase, int i) {
        insertObjectSpan(spenObjectBase, i, null, true);
    }

    private void insertObjectSpanToCursor(SpenObjectBase spenObjectBase, @Nullable IObjectInserter.IOptions iOptions, int i, boolean z) {
        AbstractC0000a.m3D(i, "insertObjectSpan# ", TAG);
        setRect(i, spenObjectBase);
        appendObjectSpan(i, spenObjectBase, iOptions, z);
    }

    private void setRect(int i, SpenObjectBase spenObjectBase) {
        spenObjectBase.setRect(this.mSpenNoteObjectInserter.getBodyObjectRect(spenObjectBase, i, this.mObjectLayoutOption.isFitWidthEnabled(spenObjectBase)), false);
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.base.model.composer.object.IObjectInserter
    public boolean insertBodyText(SpenObjectShape spenObjectShape, SpenWPage spenWPage, float f, boolean z) {
        return this.mSpenNoteObjectInserter.insertBodyText(spenObjectShape, spenWPage, f, false, z);
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.base.model.composer.object.IObjectInserter
    public void insertObject(ArrayList<SpenObjectBase> arrayList, int i) {
        if (!this.mIsHwMode) {
            Iterator<SpenObjectBase> it = arrayList.iterator();
            while (it.hasNext()) {
                insertObjectSpan(it.next(), i);
            }
        } else {
            for (int size = arrayList.size() - 1; size >= 0; size--) {
                insertObjectSpan(arrayList.get(size), i);
            }
        }
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.base.model.composer.object.IObjectInserter
    public void insertObjectKeepPage(SpenWPage spenWPage, SpenObjectBase spenObjectBase, PointF pointF, boolean z) {
        insertObjectSpan(spenObjectBase, null, z);
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.base.model.composer.object.IObjectInserter
    public void insertPainting(SpenObjectPainting spenObjectPainting, int i) {
        insertObjectSpan(spenObjectPainting, i, null, false);
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.base.model.composer.object.IObjectInserter
    public void insertVoice(SpenObjectVoice spenObjectVoice, int i) {
        insertObjectSpan(spenObjectVoice, i);
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.base.model.composer.object.IObjectInserter
    public boolean isObjectSpan() {
        return true;
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.base.model.composer.object.IObjectInserter
    public void setHwMode(boolean z) {
        this.mIsHwMode = z;
    }

    private void insertObjectSpan(SpenObjectBase spenObjectBase, int i, @Nullable IObjectInserter.IOptions iOptions, boolean z) {
        Logger.m11003i(TAG, "insertObjectSpan# mIsHwMode:" + this.mIsHwMode + ", targetPageIndex:" + i);
        if (!this.mIsHwMode) {
            int[] cursor = TextUtil.getCursor(this.mNote.getBodyText());
            if (cursor[0] == 0) {
                this.mSpenNoteTextManager.setCursorOnScreen(this.mNote.getBodyText(), i);
                cursor = TextUtil.getCursor(this.mNote.getBodyText());
            }
            insertObjectSpanToCursor(spenObjectBase, iOptions, cursor[0], z);
            return;
        }
        Point pageOffset = getPageOffset(i);
        PointF pointF = new PointF(pageOffset.x, pageOffset.y + 1);
        TextUtil.insertLineFeed(this.mNote.getBodyText(), this.mSpenNoteTextManager.getLineCountFromBodyTextBottom(pointF));
        int cursorIndexToInsertIntoBodyText = this.mSpenNoteTextManager.getCursorIndexToInsertIntoBodyText(pointF);
        this.mNote.getBodyText().setCursorPosition(cursorIndexToInsertIntoBodyText);
        insertObjectSpanToCursor(spenObjectBase, iOptions, cursorIndexToInsertIntoBodyText, z);
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.base.model.composer.object.IObjectInserter
    public SpenWPage insertObject(SpenWPage spenWPage, SpenObjectBase spenObjectBase, PointF pointF, @Nullable IObjectInserter.IOptions iOptions, boolean z) {
        insertObjectSpan(spenObjectBase, iOptions, z);
        return spenWPage;
    }

    private void insertObjectSpan(SpenObjectBase spenObjectBase, @Nullable IObjectInserter.IOptions iOptions, boolean z) {
        insertObjectSpanToCursor(spenObjectBase, iOptions, TextUtil.getCursor(this.mNote.getBodyText())[0], z);
    }
}
