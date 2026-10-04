package com.samsung.android.support.senl.p148nt.base.common.sync;

import kotlin.Metadata;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes2.dex */
@Metadata(m13885d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003R\u001c\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u001c\u0010\n\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\u0007\"\u0004\b\f\u0010\tR\u001c\u0010\r\u001a\u0004\u0018\u00010\u000eX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012¨\u0006\u0013"}, m13886d2 = {"Lcom/samsung/android/support/senl/nt/base/common/sync/TemporalServerNoteInfo;", "", "<init>", "()V", "docUuid", "", "getDocUuid", "()Ljava/lang/String;", "setDocUuid", "(Ljava/lang/String;)V", "fullFolderPath", "getFullFolderPath", "setFullFolderPath", "tempServerNoteListener", "Lcom/samsung/android/support/senl/nt/base/common/sync/ITempServerNoteListener;", "getTempServerNoteListener", "()Lcom/samsung/android/support/senl/nt/base/common/sync/ITempServerNoteListener;", "setTempServerNoteListener", "(Lcom/samsung/android/support/senl/nt/base/common/sync/ITempServerNoteListener;)V", "ntBase_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
public final class TemporalServerNoteInfo {

    @Nullable
    private String docUuid;

    @Nullable
    private String fullFolderPath;

    @Nullable
    private ITempServerNoteListener tempServerNoteListener;

    @Nullable
    public final String getDocUuid() {
        return this.docUuid;
    }

    @Nullable
    public final String getFullFolderPath() {
        return this.fullFolderPath;
    }

    @Nullable
    public final ITempServerNoteListener getTempServerNoteListener() {
        return this.tempServerNoteListener;
    }

    public final void setDocUuid(@Nullable String str) {
        this.docUuid = str;
    }

    public final void setFullFolderPath(@Nullable String str) {
        this.fullFolderPath = str;
    }

    public final void setTempServerNoteListener(@Nullable ITempServerNoteListener iTempServerNoteListener) {
        this.tempServerNoteListener = iTempServerNoteListener;
    }
}
