package com.samsung.android.support.senl.p148nt.composer.main.base.model.composer.object;

import android.graphics.PointF;
import com.samsung.android.sdk.composer.input.SpenNoteObjectInserter;
import com.samsung.android.sdk.pen.document.SpenObjectBase;
import com.samsung.android.sdk.pen.worddoc.SpenWPage;
import com.samsung.android.support.senl.p148nt.composer.main.base.util.Logger;
import java.util.ArrayList;
import java.util.Arrays;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes3.dex */
public class InsertObjectBuilder {
    public static final int PRIORITY_PAGE = 0;
    public static final int PRIORITY_POSITION = 1;
    private static final String TAG = Logger.createTag("ObjectInserterBuilder");
    private boolean mCommitHistory;
    private boolean mFitWidth;
    private boolean mFixedMaxPage;
    private ArrayList<SpenObjectBase> mObjectList;
    private SpenWPage mPage;
    private PointF mPosition;
    private int mPriority;
    private final SpenNoteObjectInserter mSpenNoteObjectInserter;
    private boolean mWithMargin;

    private InsertObjectBuilder(SpenNoteObjectInserter spenNoteObjectInserter) {
        this.mFitWidth = false;
        this.mWithMargin = true;
        this.mFixedMaxPage = false;
        this.mCommitHistory = true;
        this.mPriority = 0;
        this.mSpenNoteObjectInserter = spenNoteObjectInserter;
    }

    private SpenWPage insertToPage() {
        SpenWPage spenWPage = this.mPage;
        if (spenWPage == null) {
            return null;
        }
        return this.mSpenNoteObjectInserter.insertObject(spenWPage, this.mObjectList, this.mFitWidth, this.mWithMargin, this.mFixedMaxPage, this.mCommitHistory);
    }

    private SpenWPage insertToPosition() {
        PointF pointF = this.mPosition;
        if (pointF == null) {
            return null;
        }
        return this.mSpenNoteObjectInserter.insertObject(this.mObjectList, pointF, this.mFitWidth, this.mWithMargin, this.mFixedMaxPage, this.mCommitHistory);
    }

    public SpenWPage build() {
        SpenWPage spenWPageInsertToPage;
        ArrayList<SpenObjectBase> arrayList = this.mObjectList;
        if (arrayList == null || arrayList.isEmpty()) {
            Logger.m11000e(TAG, "build# mObjectList is null.");
            return null;
        }
        if (this.mPriority == 1) {
            spenWPageInsertToPage = insertToPosition();
            if (spenWPageInsertToPage == null) {
                spenWPageInsertToPage = insertToPage();
            }
        } else {
            spenWPageInsertToPage = insertToPage();
            if (spenWPageInsertToPage == null) {
                spenWPageInsertToPage = insertToPosition();
            }
        }
        if (spenWPageInsertToPage == null) {
            Logger.m11000e(TAG, "build# mPage and mPosition are null.");
        }
        return spenWPageInsertToPage;
    }

    public InsertObjectBuilder setCommitHistory(boolean z) {
        this.mCommitHistory = z;
        return this;
    }

    public InsertObjectBuilder setFitWidth(boolean z) {
        this.mFitWidth = z;
        return this;
    }

    public InsertObjectBuilder setFixedMaxPage(boolean z) {
        this.mFixedMaxPage = z;
        return this;
    }

    public InsertObjectBuilder setPriority(int i) {
        this.mPriority = i;
        return this;
    }

    public InsertObjectBuilder setWithMargin(boolean z) {
        this.mWithMargin = z;
        return this;
    }

    public InsertObjectBuilder(SpenNoteObjectInserter spenNoteObjectInserter, SpenWPage spenWPage, ArrayList<SpenObjectBase> arrayList) {
        this(spenNoteObjectInserter);
        this.mPage = spenWPage;
        this.mObjectList = arrayList;
    }

    public InsertObjectBuilder(SpenNoteObjectInserter spenNoteObjectInserter, SpenWPage spenWPage, SpenObjectBase spenObjectBase) {
        this(spenNoteObjectInserter, spenWPage, (ArrayList<SpenObjectBase>) new ArrayList(Arrays.asList(spenObjectBase)));
    }

    public InsertObjectBuilder(SpenNoteObjectInserter spenNoteObjectInserter, ArrayList<SpenObjectBase> arrayList, PointF pointF) {
        this(spenNoteObjectInserter);
        this.mPosition = pointF;
        this.mObjectList = arrayList;
    }

    public InsertObjectBuilder(SpenNoteObjectInserter spenNoteObjectInserter, SpenObjectBase spenObjectBase, PointF pointF) {
        this(spenNoteObjectInserter, (ArrayList<SpenObjectBase>) new ArrayList(Arrays.asList(spenObjectBase)), pointF);
    }

    public InsertObjectBuilder(SpenNoteObjectInserter spenNoteObjectInserter, SpenWPage spenWPage, SpenObjectBase spenObjectBase, PointF pointF) {
        this(spenNoteObjectInserter, spenWPage, (ArrayList<SpenObjectBase>) new ArrayList(Arrays.asList(spenObjectBase)));
        this.mPosition = pointF;
    }
}
