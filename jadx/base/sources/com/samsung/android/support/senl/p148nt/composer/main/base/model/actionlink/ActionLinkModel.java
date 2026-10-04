package com.samsung.android.support.senl.p148nt.composer.main.base.model.actionlink;

import android.os.Bundle;
import androidx.annotation.NonNull;
import com.samsung.android.sdk.pen.document.SpenObjectBase;
import com.samsung.android.sdk.pen.document.SpenObjectStroke;
import com.samsung.android.sdk.pen.document.changedInfo.SpenObjectChangedInfo;
import com.samsung.android.sdk.pen.worddoc.SpenWNote;
import com.samsung.android.sdk.pen.worddoc.SpenWPage;
import com.samsung.android.support.senl.p148nt.composer.main.base.util.Logger;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes3.dex */
public class ActionLinkModel {
    private static final String TAG = Logger.createTag("ActionLinkModel");
    private SpenWNote.ObjectEventListener mObjectEventListener = new SpenWNote.ObjectEventListener() { // from class: com.samsung.android.support.senl.nt.composer.main.base.model.actionlink.ActionLinkModel.1
        @Override // com.samsung.android.sdk.pen.worddoc.SpenWNote.ObjectEventListener
        public void onObjectAdded(SpenWPage spenWPage, @NonNull ArrayList<SpenObjectBase> arrayList, int i) {
        }

        @Override // com.samsung.android.sdk.pen.worddoc.SpenWNote.ObjectEventListener
        public void onObjectChanged(SpenWPage spenWPage, @NonNull SpenObjectChangedInfo spenObjectChangedInfo, int i) {
        }

        @Override // com.samsung.android.sdk.pen.worddoc.SpenWNote.ObjectEventListener
        public void onObjectRemoved(SpenWPage spenWPage, @NonNull ArrayList<SpenObjectBase> arrayList, int i) {
            if (ActionLinkModel.this.mRemovedObjectIdList != null) {
                for (SpenObjectBase spenObjectBase : arrayList) {
                    if (spenObjectBase instanceof SpenObjectStroke) {
                        ActionLinkModel.this.mRemovedObjectIdList.add(spenObjectBase.getId());
                    }
                }
            }
        }
    };
    private HashSet<String> mRemovedObjectIdList;
    private SpenWNote mWNote;

    public void onDestroy() {
        Logger.m10999d(TAG, "onDestroy#");
        release();
        this.mObjectEventListener = null;
    }

    public void onSaveInstanceState(@NonNull Bundle bundle) {
        Logger.m10999d(TAG, "onSaveInstanceState#");
    }

    public void release() {
        try {
            SpenWNote spenWNote = this.mWNote;
            if (spenWNote != null && !spenWNote.isClosed()) {
                this.mWNote.deregisterObjectEventListener(this.mObjectEventListener);
            }
        } catch (Exception e) {
            Logger.m10999d(TAG, "onDestroy#, error " + e.getMessage());
        }
        HashSet<String> hashSet = this.mRemovedObjectIdList;
        if (hashSet != null) {
            hashSet.clear();
        }
        this.mRemovedObjectIdList = null;
    }

    public void restoreState(Bundle bundle) {
        Logger.m10999d(TAG, "restoreState#");
    }

    public void setDoc(SpenWNote spenWNote) {
        Logger.m10999d(TAG, "setDoc#");
        this.mWNote = spenWNote;
        spenWNote.registerObjectEventListener(this.mObjectEventListener);
        this.mRemovedObjectIdList = new HashSet<>();
    }

    public void updateActionLinkData() {
        try {
            int i = 0;
            for (SpenWPage spenWPage : this.mWNote.getPageList()) {
                if (spenWPage.isChanged()) {
                    ArrayList<SpenWPage.StrokeRecognitionData> strokeRecognitionData = spenWPage.getStrokeRecognitionData();
                    ArrayList<SpenWPage.StrokeRecognitionData> arrayList = (ArrayList) strokeRecognitionData.clone();
                    for (SpenWPage.StrokeRecognitionData strokeRecognitionData2 : strokeRecognitionData) {
                        SpenWPage.StrokeRecognitionData.LinkData linkData = strokeRecognitionData2.actionLinkData;
                        if (linkData != null) {
                            String str = linkData.repObjectUuid;
                            Iterator<String> it = this.mRemovedObjectIdList.iterator();
                            while (it.hasNext()) {
                                if (it.next().equals(str)) {
                                    arrayList.remove(strokeRecognitionData2);
                                    i++;
                                }
                            }
                        }
                    }
                    spenWPage.setStrokeRecognitionData(arrayList);
                }
            }
            this.mRemovedObjectIdList.clear();
            Logger.m10999d(TAG, "updateActionLinkData# " + i);
        } catch (Exception e) {
            Logger.m10999d(TAG, "updateActionLinkData#, error " + e.getMessage());
        }
    }
}
