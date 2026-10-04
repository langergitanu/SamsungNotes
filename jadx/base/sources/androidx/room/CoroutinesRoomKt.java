package androidx.room;

import androidx.annotation.RestrictTo;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineDispatcher;
import kotlinx.coroutines.ExecutorsKt;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(m13885d1 = {"\u0000\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u001a\f\u0010\u0005\u001a\u00020\u0001*\u00020\u0002H\u0007\"\u0018\u0010\u0000\u001a\u00020\u0001*\u00020\u00028@X\u0080\u0004¢\u0006\u0006\u001a\u0004\b\u0003\u0010\u0004¨\u0006\u0006"}, m13886d2 = {"transactionDispatcher", "Lkotlinx/coroutines/CoroutineDispatcher;", "Landroidx/room/RoomDatabase;", "getTransactionDispatcher", "(Landroidx/room/RoomDatabase;)Lkotlinx/coroutines/CoroutineDispatcher;", "getQueryDispatcher", "room-ktx_release"}, m13887k = 2, m13888mv = {1, 7, 1}, m13890xi = 48)
public final class CoroutinesRoomKt {
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    @NotNull
    public static final CoroutineDispatcher getQueryDispatcher(@NotNull RoomDatabase roomDatabase) {
        Intrinsics.checkNotNullParameter(roomDatabase, "<this>");
        Map<String, Object> backingFieldMap = roomDatabase.getBackingFieldMap();
        Object objFrom = backingFieldMap.get("QueryDispatcher");
        if (objFrom == null) {
            objFrom = ExecutorsKt.from(roomDatabase.getQueryExecutor());
            backingFieldMap.put("QueryDispatcher", objFrom);
        }
        Intrinsics.checkNotNull(objFrom, "null cannot be cast to non-null type kotlinx.coroutines.CoroutineDispatcher");
        return (CoroutineDispatcher) objFrom;
    }

    @NotNull
    public static final CoroutineDispatcher getTransactionDispatcher(@NotNull RoomDatabase roomDatabase) {
        Intrinsics.checkNotNullParameter(roomDatabase, "<this>");
        Map<String, Object> backingFieldMap = roomDatabase.getBackingFieldMap();
        Object objFrom = backingFieldMap.get("TransactionDispatcher");
        if (objFrom == null) {
            objFrom = ExecutorsKt.from(roomDatabase.getTransactionExecutor());
            backingFieldMap.put("TransactionDispatcher", objFrom);
        }
        Intrinsics.checkNotNull(objFrom, "null cannot be cast to non-null type kotlinx.coroutines.CoroutineDispatcher");
        return (CoroutineDispatcher) objFrom;
    }
}
