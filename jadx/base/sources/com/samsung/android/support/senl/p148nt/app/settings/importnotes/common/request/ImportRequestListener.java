package com.samsung.android.support.senl.p148nt.app.settings.importnotes.common.request;

import android.os.Bundle;
import android.os.Message;
import com.samsung.android.app.notes.sync.constants.DocTypeConstants;
import com.samsung.android.app.notes.sync.importing.core.tasks.ImportBaseTask;
import com.samsung.android.app.notes.sync.items.ImportItem;
import com.samsung.android.support.senl.p148nt.app.common.log.MainLogger;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes2.dex */
@Metadata(m13885d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\f\u0018\u0000 !2\u00020\u0001:\u0001!B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0010\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH\u0016J\u0010\u0010\n\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH\u0016J\u0010\u0010\u000b\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH\u0016J\u001e\u0010\n\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000e0\rH\u0016J0\u0010\u000f\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u00132\u000e\u0010\u0014\u001a\n\u0018\u00010\u0015j\u0004\u0018\u0001`\u0016H\u0016J(\u0010\u0017\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\u0018\u001a\u00020\u00112\u0006\u0010\u0019\u001a\u00020\u00112\u0006\u0010\u001a\u001a\u00020\u000eH\u0016J \u0010\u001b\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\u001a\u001a\u00020\u000e2\u0006\u0010\u001c\u001a\u00020\u0011H\u0016J(\u0010\u001d\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\u001e\u001a\u00020\u00112\u0006\u0010\u001f\u001a\u00020\u00112\u0006\u0010 \u001a\u00020\u0011H\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\""}, m13886d2 = {"Lcom/samsung/android/support/senl/nt/app/settings/importnotes/common/request/ImportRequestListener;", "Lcom/samsung/android/app/notes/sync/importing/core/tasks/ImportBaseTask$Listener;", "mHandler", "Lcom/samsung/android/support/senl/nt/app/settings/importnotes/common/request/ImportHandler;", "<init>", "(Lcom/samsung/android/support/senl/nt/app/settings/importnotes/common/request/ImportHandler;)V", "onImportStart", "", "type", "Lcom/samsung/android/app/notes/sync/constants/DocTypeConstants;", "onImportEnded", "onGetListEnded", "items", "", "Lcom/samsung/android/app/notes/sync/items/ImportItem;", "onImportError", "errorCode", "", "message", "", "e", "Ljava/lang/Exception;", "Lkotlin/Exception;", "onUpdated", "now", ImportHandler.KEY_TOTAL, "item", "onDownloaded", "state", "onItemImportFinished", "processedCount", "successListSize", "allListSize", "Companion", "ntApp_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
public final class ImportRequestListener implements ImportBaseTask.Listener {

    @NotNull
    private static final String TAG = "ST$ImportRequestListener";

    @NotNull
    private final ImportHandler mHandler;

    public ImportRequestListener(@NotNull ImportHandler mHandler) {
        Intrinsics.checkNotNullParameter(mHandler, "mHandler");
        this.mHandler = mHandler;
    }

    @Override // com.samsung.android.app.notes.sync.importing.core.tasks.ImportBaseTask.Listener
    public void onDownloaded(@NotNull DocTypeConstants type, @NotNull ImportItem item, int state) {
        Intrinsics.checkNotNullParameter(type, "type");
        Intrinsics.checkNotNullParameter(item, "item");
        MainLogger.m7258i(TAG, "onDownloaded()");
        Message messageObtainMessage = this.mHandler.obtainMessage(5, type.ordinal(), state, item);
        Intrinsics.checkNotNullExpressionValue(messageObtainMessage, "obtainMessage(...)");
        this.mHandler.sendMessage(messageObtainMessage);
    }

    @Override // com.samsung.android.app.notes.sync.importing.core.tasks.ImportBaseTask.Listener
    public void onGetListEnded(@NotNull DocTypeConstants type) {
        Intrinsics.checkNotNullParameter(type, "type");
        MainLogger.m7258i(TAG, "onGetListEnded()");
        Message messageObtainMessage = this.mHandler.obtainMessage(1, type);
        Intrinsics.checkNotNullExpressionValue(messageObtainMessage, "obtainMessage(...)");
        this.mHandler.sendMessage(messageObtainMessage);
    }

    @Override // com.samsung.android.app.notes.sync.importing.core.tasks.ImportBaseTask.Listener
    public void onImportEnded(@NotNull DocTypeConstants type) {
        Intrinsics.checkNotNullParameter(type, "type");
        MainLogger.m7258i(TAG, "onSyncEnded()");
        Message messageObtainMessage = this.mHandler.obtainMessage(0, type);
        Intrinsics.checkNotNullExpressionValue(messageObtainMessage, "obtainMessage(...)");
        this.mHandler.sendMessage(messageObtainMessage);
    }

    @Override // com.samsung.android.app.notes.sync.importing.core.tasks.ImportBaseTask.Listener
    public void onImportError(@NotNull DocTypeConstants type, int errorCode, @NotNull String message, @Nullable Exception e) {
        Intrinsics.checkNotNullParameter(type, "type");
        Intrinsics.checkNotNullParameter(message, "message");
        MainLogger.m7255e(TAG, "onImportError()");
        Message messageObtainMessage = this.mHandler.obtainMessage(3, type.ordinal(), errorCode, e);
        Intrinsics.checkNotNullExpressionValue(messageObtainMessage, "obtainMessage(...)");
        Bundle bundle = new Bundle();
        bundle.putString("message", message);
        messageObtainMessage.setData(bundle);
        this.mHandler.sendMessage(messageObtainMessage);
    }

    @Override // com.samsung.android.app.notes.sync.importing.core.tasks.ImportBaseTask.Listener
    public void onImportStart(@NotNull DocTypeConstants type) {
        Intrinsics.checkNotNullParameter(type, "type");
        MainLogger.m7258i(TAG, "onSyncStart()");
    }

    @Override // com.samsung.android.app.notes.sync.importing.core.tasks.ImportBaseTask.Listener
    public void onItemImportFinished(@NotNull DocTypeConstants type, int processedCount, int successListSize, int allListSize) {
        Intrinsics.checkNotNullParameter(type, "type");
        MainLogger.m7258i(TAG, "onItemImportFinished()");
    }

    @Override // com.samsung.android.app.notes.sync.importing.core.tasks.ImportBaseTask.Listener
    public void onUpdated(@NotNull DocTypeConstants type, int now, int total, @NotNull ImportItem item) {
        Intrinsics.checkNotNullParameter(type, "type");
        Intrinsics.checkNotNullParameter(item, "item");
        MainLogger.m7258i(TAG, "onUpdated : now = " + now + "/" + total);
        Message messageObtainMessage = this.mHandler.obtainMessage(4, type.ordinal(), now, item);
        Intrinsics.checkNotNullExpressionValue(messageObtainMessage, "obtainMessage(...)");
        Bundle bundle = new Bundle();
        bundle.putInt(ImportHandler.KEY_TOTAL, total);
        messageObtainMessage.setData(bundle);
        this.mHandler.sendMessage(messageObtainMessage);
    }

    @Override // com.samsung.android.app.notes.sync.importing.core.tasks.ImportBaseTask.Listener
    public void onImportEnded(@NotNull DocTypeConstants type, @NotNull List<? extends ImportItem> items) {
        Intrinsics.checkNotNullParameter(type, "type");
        Intrinsics.checkNotNullParameter(items, "items");
        MainLogger.m7258i(TAG, "onImportEnded()");
        Message messageObtainMessage = this.mHandler.obtainMessage(2, type.ordinal(), 0, items);
        Intrinsics.checkNotNullExpressionValue(messageObtainMessage, "obtainMessage(...)");
        this.mHandler.sendMessage(messageObtainMessage);
    }
}
