package com.samsung.android.support.senl.p148nt.base.common.sync;

import com.samsung.android.support.senl.p148nt.base.common.log.Debugger;
import com.samsung.android.support.senl.p148nt.data.database.core.schema.SyncDBSchema;
import com.samsung.scsp.framework.core.identity.IdentityApiContract;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes2.dex */
@Metadata(m13885d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u001c\n\u0002\u0010\u0002\n\u0002\b\u0002\u0018\u0000 .2\u00020\u0001:\u0001.B\t\b\u0016¢\u0006\u0004\b\u0002\u0010\u0003B\u0013\b\u0016\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\b\u0002\u0010\u0006BY\b\u0016\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0005\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\t\u0012\u0006\u0010\u000b\u001a\u00020\f\u0012\b\u0010\r\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u000e\u001a\u0004\u0018\u00010\u0005\u0012\u0006\u0010\u000f\u001a\u00020\u0010\u0012\u0006\u0010\u0011\u001a\u00020\f¢\u0006\u0004\b\u0002\u0010\u0012J\u0006\u0010,\u001a\u00020-R\u001c\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0006R\u001c\u0010\u0016\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\u0014\"\u0004\b\u0018\u0010\u0006R\u001a\u0010\b\u001a\u00020\tX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0019\u0010\u001a\"\u0004\b\u001b\u0010\u001cR\u001a\u0010\n\u001a\u00020\tX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001d\u0010\u001a\"\u0004\b\u001e\u0010\u001cR\u000e\u0010\u000b\u001a\u00020\fX\u0082\u000e¢\u0006\u0002\n\u0000R\u001c\u0010\r\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001f\u0010\u0014\"\u0004\b \u0010\u0006R\u001c\u0010\u000e\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b!\u0010\u0014\"\u0004\b\"\u0010\u0006R\u001a\u0010\u000f\u001a\u00020\u0010X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b#\u0010$\"\u0004\b%\u0010&R\u001a\u0010\u0011\u001a\u00020\fX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010'\"\u0004\b(\u0010)R$\u0010*\u001a\u00020\f2\u0006\u0010\u000b\u001a\u00020\f8F@FX\u0086\u000e¢\u0006\f\u001a\u0004\b*\u0010'\"\u0004\b+\u0010)¨\u0006/"}, m13886d2 = {"Lcom/samsung/android/support/senl/nt/base/common/sync/ServerNoteInfo;", "", "<init>", "()V", "docUuid", "", "(Ljava/lang/String;)V", "serverResourceId", "syncModifiedTime", "", "modifiedTime", "isDeleted", "", IdentityApiContract.Parameter.MODEL_NAME, SyncDBSchema.SyncInfo.COMMIT_ID, "minFormatVersion", "", "isHighFormatVer", "(Ljava/lang/String;Ljava/lang/String;JJZLjava/lang/String;Ljava/lang/String;IZ)V", "getDocUuid", "()Ljava/lang/String;", "setDocUuid", "serverId", "getServerId", "setServerId", "getSyncModifiedTime", "()J", "setSyncModifiedTime", "(J)V", "getModifiedTime", "setModifiedTime", "getModelName", "setModelName", "getCommitId", "setCommitId", "getMinFormatVersion", "()I", "setMinFormatVersion", "(I)V", "()Z", "setHighFormatVer", "(Z)V", "isExists", "setExists", "printServerNoteInfo", "", "Companion", "ntBase_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
public final class ServerNoteInfo {

    @NotNull
    private static final String TAG = "ServerNoteInfo";

    @Nullable
    private String commitId;

    @Nullable
    private String docUuid;
    private boolean isDeleted;
    private boolean isHighFormatVer;
    private int minFormatVersion;

    @Nullable
    private String modelName;
    private long modifiedTime;

    @Nullable
    private String serverId;
    private long syncModifiedTime;

    public ServerNoteInfo() {
    }

    @Nullable
    public final String getCommitId() {
        return this.commitId;
    }

    @Nullable
    public final String getDocUuid() {
        return this.docUuid;
    }

    public final int getMinFormatVersion() {
        return this.minFormatVersion;
    }

    @Nullable
    public final String getModelName() {
        return this.modelName;
    }

    public final long getModifiedTime() {
        return this.modifiedTime;
    }

    @Nullable
    public final String getServerId() {
        return this.serverId;
    }

    public final long getSyncModifiedTime() {
        return this.syncModifiedTime;
    }

    public final boolean isExists() {
        return !this.isDeleted;
    }

    /* JADX INFO: renamed from: isHighFormatVer, reason: from getter */
    public final boolean getIsHighFormatVer() {
        return this.isHighFormatVer;
    }

    public final void printServerNoteInfo() {
        Debugger.Companion companion = Debugger.INSTANCE;
        companion.m8627i(TAG, "docUuid = " + this.docUuid);
        companion.m8627i(TAG, "serverResourceId = " + this.serverId);
        companion.m8627i(TAG, "syncModifiedTime = " + this.syncModifiedTime);
        companion.m8627i(TAG, "modifiedTime = " + this.modifiedTime);
        companion.m8627i(TAG, "isDeleted = " + this.isDeleted);
        companion.m8627i(TAG, "modelName = " + this.modelName);
        companion.m8627i(TAG, "commitId = " + this.commitId);
        companion.m8627i(TAG, "minFormatVersion = " + this.minFormatVersion);
        companion.m8627i(TAG, "isHighFormatVer = " + this.isHighFormatVer);
    }

    public final void setCommitId(@Nullable String str) {
        this.commitId = str;
    }

    public final void setDocUuid(@Nullable String str) {
        this.docUuid = str;
    }

    public final void setExists(boolean z) {
        this.isDeleted = !z;
    }

    public final void setHighFormatVer(boolean z) {
        this.isHighFormatVer = z;
    }

    public final void setMinFormatVersion(int i) {
        this.minFormatVersion = i;
    }

    public final void setModelName(@Nullable String str) {
        this.modelName = str;
    }

    public final void setModifiedTime(long j) {
        this.modifiedTime = j;
    }

    public final void setServerId(@Nullable String str) {
        this.serverId = str;
    }

    public final void setSyncModifiedTime(long j) {
        this.syncModifiedTime = j;
    }

    public ServerNoteInfo(@Nullable String str) {
        this.docUuid = str;
    }

    public ServerNoteInfo(@Nullable String str, @Nullable String str2, long j, long j2, boolean z, @Nullable String str3, @Nullable String str4, int i, boolean z2) {
        this.docUuid = str;
        this.serverId = str2;
        this.syncModifiedTime = j;
        this.modifiedTime = j2;
        this.isDeleted = z;
        this.modelName = str3;
        this.commitId = str4;
        this.minFormatVersion = i;
        this.isHighFormatVer = z2;
    }
}
