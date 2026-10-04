package com.samsung.android.support.notes.bixby.bixby2.aid;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes8.dex */
@Metadata(m13885d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\b\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003R\u001a\u0010\u0004\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u001a\u0010\n\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\u0007\"\u0004\b\f\u0010\t¨\u0006\r"}, m13886d2 = {"Lcom/samsung/android/support/notes/bixby/bixby2/aid/FolderInfo;", "", "<init>", "()V", "folderID", "", "getFolderID", "()Ljava/lang/String;", "setFolderID", "(Ljava/lang/String;)V", "folderName", "getFolderName", "setFolderName", "bixby_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
public final class FolderInfo {

    @NotNull
    private String folderID = "";

    @NotNull
    private String folderName = "";

    @NotNull
    public final String getFolderID() {
        return this.folderID;
    }

    @NotNull
    public final String getFolderName() {
        return this.folderName;
    }

    public final void setFolderID(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.folderID = str;
    }

    public final void setFolderName(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.folderName = str;
    }
}
