package com.samsung.android.support.senl.p148nt.base.common.sync;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes2.dex */
@Metadata(m13885d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0010\t\n\u0002\b\u0015\u0018\u00002\u00020\u0001B7\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\t¢\u0006\u0004\b\u000b\u0010\fR\u001a\u0010\u0002\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R\u001a\u0010\u0004\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u000e\"\u0004\b\u0012\u0010\u0010R\u001a\u0010\u0005\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u000e\"\u0004\b\u0014\u0010\u0010R\u001a\u0010\u0006\u001a\u00020\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0015\"\u0004\b\u0016\u0010\u0017R\u001a\u0010\b\u001a\u00020\tX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0018\u0010\u0019\"\u0004\b\u001a\u0010\u001bR\u001a\u0010\n\u001a\u00020\tX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001c\u0010\u0019\"\u0004\b\u001d\u0010\u001b¨\u0006\u001e"}, m13886d2 = {"Lcom/samsung/android/support/senl/nt/base/common/sync/TagContentItem;", "", "sDocUUID", "", "tagUUID", "extraInfo", "isDeleted", "", "tagModifiedTime", "", "tagServerTime", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;IJJ)V", "getSDocUUID", "()Ljava/lang/String;", "setSDocUUID", "(Ljava/lang/String;)V", "getTagUUID", "setTagUUID", "getExtraInfo", "setExtraInfo", "()I", "setDeleted", "(I)V", "getTagModifiedTime", "()J", "setTagModifiedTime", "(J)V", "getTagServerTime", "setTagServerTime", "ntBase_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
public final class TagContentItem {

    @NotNull
    private String extraInfo;
    private int isDeleted;

    @NotNull
    private String sDocUUID;
    private long tagModifiedTime;
    private long tagServerTime;

    @NotNull
    private String tagUUID;

    public TagContentItem(@NotNull String sDocUUID, @NotNull String tagUUID, @NotNull String extraInfo, int i, long j, long j2) {
        Intrinsics.checkNotNullParameter(sDocUUID, "sDocUUID");
        Intrinsics.checkNotNullParameter(tagUUID, "tagUUID");
        Intrinsics.checkNotNullParameter(extraInfo, "extraInfo");
        this.sDocUUID = sDocUUID;
        this.tagUUID = tagUUID;
        this.extraInfo = extraInfo;
        this.isDeleted = i;
        this.tagModifiedTime = j;
        this.tagServerTime = j2;
    }

    @NotNull
    public final String getExtraInfo() {
        return this.extraInfo;
    }

    @NotNull
    public final String getSDocUUID() {
        return this.sDocUUID;
    }

    public final long getTagModifiedTime() {
        return this.tagModifiedTime;
    }

    public final long getTagServerTime() {
        return this.tagServerTime;
    }

    @NotNull
    public final String getTagUUID() {
        return this.tagUUID;
    }

    /* JADX INFO: renamed from: isDeleted, reason: from getter */
    public final int getIsDeleted() {
        return this.isDeleted;
    }

    public final void setDeleted(int i) {
        this.isDeleted = i;
    }

    public final void setExtraInfo(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.extraInfo = str;
    }

    public final void setSDocUUID(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.sDocUUID = str;
    }

    public final void setTagModifiedTime(long j) {
        this.tagModifiedTime = j;
    }

    public final void setTagServerTime(long j) {
        this.tagServerTime = j;
    }

    public final void setTagUUID(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.tagUUID = str;
    }
}
