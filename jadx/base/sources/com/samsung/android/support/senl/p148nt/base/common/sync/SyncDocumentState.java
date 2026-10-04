package com.samsung.android.support.senl.p148nt.base.common.sync;

import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes2.dex */
@Metadata(m13885d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000e\u0010\u0004\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0007X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000¨\u0006\n"}, m13886d2 = {"Lcom/samsung/android/support/senl/nt/base/common/sync/SyncDocumentState;", "", "<init>", "()V", "DOCUMENT_STATE_TYPE", "", "INVALID_VERSION_TYPE", "", "DELETED_FROM_SERVER_TYPE", "SDOCX_UUID", "ntBase_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
public final class SyncDocumentState {
    public static final int DELETED_FROM_SERVER_TYPE = 2;

    @NotNull
    public static final String DOCUMENT_STATE_TYPE = "state_type";

    @NotNull
    public static final SyncDocumentState INSTANCE = new SyncDocumentState();
    public static final int INVALID_VERSION_TYPE = 1;

    @NotNull
    public static final String SDOCX_UUID = "sdocx_uuid";

    private SyncDocumentState() {
    }
}
