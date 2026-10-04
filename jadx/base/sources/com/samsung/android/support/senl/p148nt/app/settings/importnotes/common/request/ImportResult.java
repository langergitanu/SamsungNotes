package com.samsung.android.support.senl.p148nt.app.settings.importnotes.common.request;

import com.samsung.android.app.notes.sync.constants.DocTypeConstants;
import com.samsung.android.app.notes.sync.items.ImportItem;
import java.util.List;
import kotlin.Metadata;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes2.dex */
@Metadata(m13885d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\bf\u0018\u00002\u00020\u0001J\u0012\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H&J\u0012\u0010\u0006\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H&J\"\u0010\u0007\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00052\u000e\u0010\b\u001a\n\u0012\u0004\u0012\u00020\n\u0018\u00010\tH&J4\u0010\u000b\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00052\u0006\u0010\f\u001a\u00020\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u000f2\u000e\u0010\u0010\u001a\n\u0018\u00010\u0011j\u0004\u0018\u0001`\u0012H&J,\u0010\u0013\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0014\u001a\u00020\r2\u0006\u0010\u0015\u001a\u00020\r2\b\u0010\u0016\u001a\u0004\u0018\u00010\nH&J$\u0010\u0017\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00052\b\u0010\u0016\u001a\u0004\u0018\u00010\n2\u0006\u0010\u0018\u001a\u00020\rH&¨\u0006\u0019"}, m13886d2 = {"Lcom/samsung/android/support/senl/nt/app/settings/importnotes/common/request/ImportResult;", "", "onSyncEnded", "", "type", "Lcom/samsung/android/app/notes/sync/constants/DocTypeConstants;", "onGetListEnded", "onImportEnded", "items", "", "Lcom/samsung/android/app/notes/sync/items/ImportItem;", "onError", "errorCode", "", "message", "", "e", "Ljava/lang/Exception;", "Lkotlin/Exception;", "onUpdated", "now", ImportHandler.KEY_TOTAL, "item", "onDownloaded", "state", "ntApp_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
public interface ImportResult {
    void onDownloaded(@Nullable DocTypeConstants type, @Nullable ImportItem item, int state);

    void onError(@Nullable DocTypeConstants type, int errorCode, @Nullable String message, @Nullable Exception e);

    void onGetListEnded(@Nullable DocTypeConstants type);

    void onImportEnded(@Nullable DocTypeConstants type, @Nullable List<? extends ImportItem> items);

    void onSyncEnded(@Nullable DocTypeConstants type);

    void onUpdated(@Nullable DocTypeConstants type, int now, int total, @Nullable ImportItem item);
}
