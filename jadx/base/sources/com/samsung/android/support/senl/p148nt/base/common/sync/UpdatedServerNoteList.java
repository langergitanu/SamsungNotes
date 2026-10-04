package com.samsung.android.support.senl.p148nt.base.common.sync;

import com.samsung.android.support.senl.p148nt.base.common.log.Debugger;
import com.samsung.android.support.senl.p148nt.data.common.constants.SearchConstants;
import java.util.HashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes2.dex */
@Metadata(m13885d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010%\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0005\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0012\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\u0005H\u0007J\u0010\u0010\f\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\u0005H\u0007J\u0018\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000b\u001a\u00020\u00052\u0006\u0010\u000f\u001a\u00020\bH\u0007J\u0010\u0010\u0010\u001a\u00020\u000e2\u0006\u0010\u000b\u001a\u00020\u0005H\u0007J\b\u0010\u0011\u001a\u00020\u000eH\u0007J\b\u0010\u0012\u001a\u00020\u000eH\u0007R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u001a\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\b0\u0007X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0013"}, m13886d2 = {"Lcom/samsung/android/support/senl/nt/base/common/sync/UpdatedServerNoteList;", "", "<init>", "()V", SearchConstants.TargetContents.TAG, "", "updatedServerNotes", "", "", "isServerNoteUpdated", "", "docUuid", "getServerTimeStamp", "addUpdatedServerNote", "", "serverTimeStamp", "deleteUpdatedServerNote", "clear", "printUpdatedServerNoteList", "ntBase_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
public final class UpdatedServerNoteList {

    @NotNull
    private static final String TAG = "UpdatedServerNoteList";

    @NotNull
    public static final UpdatedServerNoteList INSTANCE = new UpdatedServerNoteList();

    @NotNull
    private static final Map<String, Long> updatedServerNotes = new HashMap();

    private UpdatedServerNoteList() {
    }

    @JvmStatic
    public static final void addUpdatedServerNote(@NotNull String docUuid, long serverTimeStamp) {
        Intrinsics.checkNotNullParameter(docUuid, "docUuid");
        updatedServerNotes.put(docUuid, Long.valueOf(serverTimeStamp));
    }

    @JvmStatic
    public static final void clear() {
        Map<String, Long> map = updatedServerNotes;
        if (map.isEmpty()) {
            return;
        }
        map.clear();
    }

    @JvmStatic
    public static final void deleteUpdatedServerNote(@NotNull String docUuid) {
        Intrinsics.checkNotNullParameter(docUuid, "docUuid");
        Map<String, Long> map = updatedServerNotes;
        if (map.containsKey(docUuid)) {
            map.remove(docUuid);
        }
    }

    @JvmStatic
    public static final long getServerTimeStamp(@NotNull String docUuid) {
        Intrinsics.checkNotNullParameter(docUuid, "docUuid");
        Map<String, Long> map = updatedServerNotes;
        if (!map.containsKey(docUuid)) {
            return -1L;
        }
        Long l = map.get(docUuid);
        Intrinsics.checkNotNull(l);
        return l.longValue();
    }

    @JvmStatic
    public static final boolean isServerNoteUpdated(@Nullable String docUuid) {
        return updatedServerNotes.containsKey(docUuid);
    }

    @JvmStatic
    public static final void printUpdatedServerNoteList() {
        Debugger.INSTANCE.m8627i(TAG, "printUpdatedServerNoteList() : " + updatedServerNotes);
    }
}
