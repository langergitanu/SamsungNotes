package com.samsung.android.support.senl.p148nt.coedit.control;

import androidx.annotation.NonNull;
import com.samsung.android.sdk.pen.worddoc.SpenWNote;
import com.samsung.android.support.senl.p148nt.coedit.control.CoeditHandlerManager;
import com.samsung.android.support.senl.p148nt.coedit.control.common.SnapControlCallback;
import com.samsung.android.support.senl.p148nt.coedit.log.CoeditLogger;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes3.dex */
public class SnapObject {
    private static final String TAG = "CoeditSnapObject";
    private SnapControlCallback callback;
    private CoeditHandlerManager.Contract contract;

    @NonNull
    private String filePath;

    @NonNull
    private String groupId;

    @NonNull
    private SpenWNote note;

    @NonNull
    private String uuid;

    @NonNull
    private String workspaceId;
    private final int MAX_TRIED_COUNT = 10;
    int count = 0;

    public SnapObject(@NonNull SpenWNote spenWNote, @NonNull String str, @NonNull String str2, @NonNull String str3, @NonNull String str4, SnapControlCallback snapControlCallback, CoeditHandlerManager.Contract contract) {
        this.note = spenWNote;
        this.uuid = str;
        this.filePath = str2;
        this.groupId = str3;
        this.workspaceId = str4;
        this.callback = snapControlCallback;
        this.contract = contract;
    }

    public SnapControlCallback getCallback() {
        return this.callback;
    }

    public CoeditHandlerManager.Contract getContract() {
        return this.contract;
    }

    public String getFilePath() {
        return this.filePath;
    }

    public String getGroupId() {
        return this.groupId;
    }

    public SpenWNote getNote() {
        return this.note;
    }

    public String getUuid() {
        return this.uuid;
    }

    public String getWorkspaceId() {
        return this.workspaceId;
    }

    public void increaseCount() {
        this.count++;
        CoeditLogger.m8920e(TAG, "clearAfterCreateCoeditTask wait uuid, " + this.uuid + " count, " + this.count);
    }

    public boolean needRetry() {
        return this.count < 10;
    }

    public void refresh(@NonNull SpenWNote spenWNote, SnapControlCallback snapControlCallback, CoeditHandlerManager.Contract contract) {
        this.note = spenWNote;
        this.callback = snapControlCallback;
        this.contract = contract;
    }

    public void resetCount() {
        this.count = 0;
    }
}
