package com.samsung.android.support.senl.p148nt.coedit.control;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.samsung.android.sdk.pen.worddoc.SpenWNote;
import com.samsung.android.support.senl.p148nt.coedit.control.CoeditHandlerManager;
import com.samsung.android.support.senl.p148nt.coedit.control.common.SnapControlCallback;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes3.dex */
public class InternalSnapQueue {
    private final Map<String, SnapObject> mSnapObjectMap = new HashMap();

    @Nullable
    public SnapObject deQueueSnapObject(String str) {
        SnapObject snapObject = this.mSnapObjectMap.get(str);
        if (snapObject != null) {
            this.mSnapObjectMap.remove(str);
        }
        return snapObject;
    }

    public void enQueueSnapObject(@NonNull SpenWNote spenWNote, @NonNull String str, @NonNull String str2, @NonNull String str3, @NonNull String str4, SnapControlCallback snapControlCallback, CoeditHandlerManager.Contract contract) {
        this.mSnapObjectMap.put(str, new SnapObject(spenWNote, str, str2, str3, str4, snapControlCallback, contract));
    }

    public void increaseCount(String str) {
        SnapObject snapObject = this.mSnapObjectMap.get(str);
        if (snapObject != null) {
            snapObject.increaseCount();
        }
    }

    public boolean isEmpty() {
        return this.mSnapObjectMap.isEmpty();
    }

    public boolean isNeedRetryWaitingSnapStart(String str) {
        SnapObject snapObject = this.mSnapObjectMap.get(str);
        return snapObject != null && snapObject.needRetry();
    }

    public boolean isWaitingSnapStart(String str) {
        return this.mSnapObjectMap.get(str) != null;
    }

    public void refreshWaitingSnapStart(String str, @NonNull SpenWNote spenWNote, SnapControlCallback snapControlCallback, CoeditHandlerManager.Contract contract) {
        SnapObject snapObject = this.mSnapObjectMap.get(str);
        snapObject.refresh(spenWNote, snapControlCallback, contract);
        snapObject.resetCount();
    }
}
