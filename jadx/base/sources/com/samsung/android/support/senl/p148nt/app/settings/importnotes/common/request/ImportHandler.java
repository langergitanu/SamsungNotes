package com.samsung.android.support.senl.p148nt.app.settings.importnotes.common.request;

import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.samsung.android.app.notes.sync.constants.DocTypeConstants;
import com.samsung.android.app.notes.sync.items.ImportItem;
import com.samsung.android.support.senl.p148nt.app.addons.AbstractC8014b;
import java.util.List;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes2.dex */
@Metadata(m13885d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 \n2\u00020\u0001:\u0001\nB\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0010\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u000b"}, m13886d2 = {"Lcom/samsung/android/support/senl/nt/app/settings/importnotes/common/request/ImportHandler;", "Landroid/os/Handler;", "mImport", "Lcom/samsung/android/support/senl/nt/app/settings/importnotes/common/request/ImportResult;", "<init>", "(Lcom/samsung/android/support/senl/nt/app/settings/importnotes/common/request/ImportResult;)V", "handleMessage", "", "msg", "Landroid/os/Message;", "Companion", "ntApp_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
public final class ImportHandler extends Handler {

    @NotNull
    public static final String KEY_MESSAGE = "message";

    @NotNull
    public static final String KEY_TOTAL = "total";
    public static final int MSG_ON_DOWNLOADED = 5;
    public static final int MSG_ON_ERROR = 3;
    public static final int MSG_ON_GET_LIST_ENDED = 1;
    public static final int MSG_ON_IMPORT_ENDED = 2;
    public static final int MSG_ON_QUOTA_RECEIVED = 102;
    public static final int MSG_ON_SYNC_ENDED = 0;
    public static final int MSG_ON_UPDATED = 4;

    @NotNull
    private static final String TAG = "ST$ImportHandler";

    @NotNull
    private final ImportResult mImport;

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13887k = 3, m13888mv = {2, 1, 0}, m13890xi = 48)
    public /* synthetic */ class EntriesMappings {
        public static final /* synthetic */ EnumEntries<DocTypeConstants> entries$0 = EnumEntriesKt.enumEntries(DocTypeConstants.values());
    }

    /* JADX WARN: Illegal instructions before constructor call */
    public ImportHandler(@NotNull ImportResult mImport) {
        Intrinsics.checkNotNullParameter(mImport, "mImport");
        Looper looperMyLooper = Looper.myLooper();
        Intrinsics.checkNotNull(looperMyLooper);
        super(looperMyLooper);
        this.mImport = mImport;
    }

    @Override // android.os.Handler
    public void handleMessage(@NotNull Message msg) {
        Intrinsics.checkNotNullParameter(msg, "msg");
        Bundle data = msg.getData();
        int i = msg.what;
        if (i == 0) {
            this.mImport.onSyncEnded(EntriesMappings.entries$0.get(msg.arg1));
            return;
        }
        if (i == 1) {
            this.mImport.onGetListEnded(EntriesMappings.entries$0.get(msg.arg1));
            return;
        }
        if (i == 2) {
            ImportResult importResult = this.mImport;
            DocTypeConstants docTypeConstants = EntriesMappings.entries$0.get(msg.arg1);
            Object obj = msg.obj;
            Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.collections.List<com.samsung.android.app.notes.sync.items.ImportItem>");
            importResult.onImportEnded(docTypeConstants, (List) obj);
            return;
        }
        if (i == 3) {
            if (data == null) {
                throw new IllegalArgumentException("no bundle is assigned to message");
            }
            String string = data.getString("message", null);
            if (!(msg.obj instanceof Exception)) {
                this.mImport.onError(EntriesMappings.entries$0.get(msg.arg1), msg.arg2, string, null);
                return;
            }
            ImportResult importResult2 = this.mImport;
            DocTypeConstants docTypeConstants2 = EntriesMappings.entries$0.get(msg.arg1);
            int i2 = msg.arg2;
            Object obj2 = msg.obj;
            Intrinsics.checkNotNull(obj2, "null cannot be cast to non-null type java.lang.Exception");
            importResult2.onError(docTypeConstants2, i2, string, (Exception) obj2);
            return;
        }
        if (i == 4) {
            if (data == null) {
                throw new IllegalArgumentException("no bundle is assigned to message");
            }
            int i4 = data.getInt(KEY_TOTAL, 0);
            ImportResult importResult3 = this.mImport;
            DocTypeConstants docTypeConstants3 = EntriesMappings.entries$0.get(msg.arg1);
            int i5 = msg.arg2;
            Object obj3 = msg.obj;
            Intrinsics.checkNotNull(obj3, "null cannot be cast to non-null type com.samsung.android.app.notes.sync.items.ImportItem");
            importResult3.onUpdated(docTypeConstants3, i5, i4, (ImportItem) obj3);
            return;
        }
        if (i != 5) {
            if (i != 102) {
                AbstractC8014b.m7201c(i, "Unknown message : ", TAG);
                super.handleMessage(msg);
                return;
            }
            return;
        }
        if (msg.obj instanceof ImportItem) {
            ImportResult importResult4 = this.mImport;
            DocTypeConstants docTypeConstants4 = EntriesMappings.entries$0.get(msg.arg1);
            Object obj4 = msg.obj;
            Intrinsics.checkNotNull(obj4, "null cannot be cast to non-null type com.samsung.android.app.notes.sync.items.ImportItem");
            importResult4.onDownloaded(docTypeConstants4, (ImportItem) obj4, msg.arg2);
        }
    }
}
