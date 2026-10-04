package com.samsung.android.support.senl.p148nt.composer.main.base.model.composer.object;

import android.graphics.Point;
import android.graphics.PointF;
import android.graphics.RectF;
import androidx.annotation.Nullable;
import com.samsung.android.sdk.composer.input.SpenNoteObjectInserter;
import com.samsung.android.sdk.pen.document.SpenObjectBase;
import com.samsung.android.sdk.pen.document.SpenObjectPainting;
import com.samsung.android.sdk.pen.document.SpenObjectShape;
import com.samsung.android.sdk.pen.document.SpenObjectVoice;
import com.samsung.android.sdk.pen.worddoc.SpenWNote;
import com.samsung.android.sdk.pen.worddoc.SpenWPage;
import com.samsung.android.support.senl.p148nt.composer.main.base.model.composer.object.IObjectInserter;
import com.samsung.android.support.senl.p148nt.composer.main.base.util.Logger;
import java.util.ArrayList;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes3.dex */
public class ObjectInserterNormal implements IObjectInserter {
    private static final String TAG = Logger.createTag("ObjectInserterNormal");
    private Contract mContract;
    private int mInsertObjectMargin;
    private SpenWNote mNote;
    private ObjectLayoutOption mObjectLayoutOption;
    private SpenNoteObjectInserter mSpenNoteObjectInserter;

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public interface Contract {
        void insertBodyText(SpenWPage spenWPage, PointF pointF, boolean z);

        boolean isFixedMaxPage();

        boolean isFocusedTextBox();
    }

    public ObjectInserterNormal(SpenWNote spenWNote, SpenNoteObjectInserter spenNoteObjectInserter, ObjectLayoutOption objectLayoutOption, int i, Contract contract) {
        this.mNote = spenWNote;
        this.mSpenNoteObjectInserter = spenNoteObjectInserter;
        this.mObjectLayoutOption = objectLayoutOption;
        this.mInsertObjectMargin = i;
        this.mContract = contract;
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.base.model.composer.object.IObjectInserter
    public boolean insertBodyText(SpenObjectShape spenObjectShape, SpenWPage spenWPage, float f, boolean z) {
        return this.mSpenNoteObjectInserter.insertBodyText(spenObjectShape, spenWPage, f, z, z);
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.base.model.composer.object.IObjectInserter
    public void insertObject(ArrayList<SpenObjectBase> arrayList, int i) {
        new InsertObjectBuilder(this.mSpenNoteObjectInserter, this.mNote.getPage(i), arrayList).setFitWidth(this.mObjectLayoutOption.isFitWidthEnabled()).setFixedMaxPage(this.mContract.isFixedMaxPage()).build();
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.base.model.composer.object.IObjectInserter
    public void insertObjectKeepPage(SpenWPage spenWPage, SpenObjectBase spenObjectBase, PointF pointF, boolean z) {
        RectF insertObjectRect = this.mSpenNoteObjectInserter.getInsertObjectRect(spenWPage, spenObjectBase);
        Point offset = spenWPage.getOffset();
        if (pointF != null) {
            insertObjectRect.offsetTo(pointF.x - offset.x, pointF.y - offset.y);
        }
        RectF rectFAdjustRectInPage = this.mSpenNoteObjectInserter.adjustRectInPage(spenWPage, insertObjectRect);
        PointF pointF2 = new PointF(rectFAdjustRectInPage.left + offset.x, (rectFAdjustRectInPage.top + offset.y) - 1.0f);
        SpenWPage spenWPageBuild = new InsertObjectBuilder(this.mSpenNoteObjectInserter, spenObjectBase, pointF2).setFitWidth(this.mObjectLayoutOption.isFitWidthEnabled(spenObjectBase)).setFixedMaxPage(this.mContract.isFixedMaxPage()).setCommitHistory(z).build();
        if (spenWPageBuild == null) {
            Logger.m11000e(TAG, "insertObjectKeepPage# insertObject return is null. object : " + spenObjectBase);
            return;
        }
        RectF rect = spenObjectBase.getRect();
        Point offset2 = spenWPageBuild.getOffset();
        pointF2.set(rect.left + offset2.x, rect.bottom + offset2.y + this.mInsertObjectMargin);
        if (pointF != null) {
            pointF.set(pointF2);
        }
        Logger.m11003i(TAG, "insertObjectKeepPage# page : " + offset + " -> " + offset2 + ", rect : " + rect + ", newPosition : " + pointF2);
        if (this.mContract.isFocusedTextBox()) {
            this.mContract.insertBodyText(spenWPageBuild, pointF2, true);
        }
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.base.model.composer.object.IObjectInserter
    public void insertPainting(SpenObjectPainting spenObjectPainting, int i) {
        new InsertObjectBuilder(this.mSpenNoteObjectInserter, this.mNote.getPage(i), spenObjectPainting).setFixedMaxPage(this.mContract.isFixedMaxPage()).setCommitHistory(false).build();
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.base.model.composer.object.IObjectInserter
    public void insertVoice(SpenObjectVoice spenObjectVoice, int i) {
        new InsertObjectBuilder(this.mSpenNoteObjectInserter, this.mNote.getPage(i), spenObjectVoice).setFixedMaxPage(this.mContract.isFixedMaxPage()).build();
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.base.model.composer.object.IObjectInserter
    public boolean isObjectSpan() {
        return false;
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.base.model.composer.object.IObjectInserter
    public void setHwMode(boolean z) {
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.base.model.composer.object.IObjectInserter
    public SpenWPage insertObject(SpenWPage spenWPage, SpenObjectBase spenObjectBase, PointF pointF, @Nullable IObjectInserter.IOptions iOptions, boolean z) {
        boolean zIsFitWidthEnabled = this.mObjectLayoutOption.isFitWidthEnabled(spenObjectBase);
        SpenWPage spenWPageBuild = new InsertObjectBuilder(this.mSpenNoteObjectInserter, spenWPage, spenObjectBase).setFitWidth(zIsFitWidthEnabled).setFixedMaxPage(this.mContract.isFixedMaxPage()).setCommitHistory(z).build();
        if (spenWPageBuild == null) {
            Logger.m11000e(TAG, "insertObject# insertObject return is null. object : " + spenObjectBase);
            return spenWPageBuild;
        }
        Point offset = spenWPage.getOffset();
        Point offset2 = spenWPageBuild.getOffset();
        RectF rect = spenObjectBase.getRect();
        if (pointF != null) {
            pointF.x += Math.abs(offset2.x - offset.x);
            pointF.y = rect.top + offset2.y;
            spenWPageBuild = new InsertObjectBuilder(this.mSpenNoteObjectInserter, spenObjectBase, pointF).setFitWidth(zIsFitWidthEnabled).setFixedMaxPage(this.mContract.isFixedMaxPage()).setCommitHistory(z).build();
            rect = spenObjectBase.getRect();
        }
        PointF pointF2 = new PointF(rect.left + offset2.x, rect.bottom + offset2.y + this.mInsertObjectMargin);
        if (pointF != null) {
            pointF.set(pointF2);
        }
        Logger.m11003i(TAG, "insertObject# page : " + offset + " -> " + offset2 + ", rect : " + rect + ", newPosition : " + pointF2);
        if (this.mContract.isFocusedTextBox()) {
            this.mContract.insertBodyText(spenWPageBuild, pointF2, true);
        }
        return spenWPageBuild;
    }
}
