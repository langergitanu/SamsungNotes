package androidx.work.impl.model;

import androidx.sqlite.p113db.SupportSQLiteQuery;
import androidx.work.WorkInfo;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineDispatcher;
import kotlinx.coroutines.flow.Flow;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes.dex */
@Metadata(m13885d1 = {"\u0000 \n\u0000\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u001a&\u0010\u0000\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\u00020\u0001*\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b¨\u0006\t"}, m13886d2 = {"getWorkInfoPojosFlow", "Lkotlinx/coroutines/flow/Flow;", "", "Landroidx/work/WorkInfo;", "Landroidx/work/impl/model/RawWorkInfoDao;", "dispatcher", "Lkotlinx/coroutines/CoroutineDispatcher;", "query", "Landroidx/sqlite/db/SupportSQLiteQuery;", "work-runtime_release"}, m13887k = 2, m13888mv = {1, 8, 0}, m13890xi = 48)
public final class RawWorkInfoDaoKt {
    @NotNull
    public static final Flow<List<WorkInfo>> getWorkInfoPojosFlow(@NotNull RawWorkInfoDao rawWorkInfoDao, @NotNull CoroutineDispatcher dispatcher, @NotNull SupportSQLiteQuery query) {
        Intrinsics.checkNotNullParameter(rawWorkInfoDao, "<this>");
        Intrinsics.checkNotNullParameter(dispatcher, "dispatcher");
        Intrinsics.checkNotNullParameter(query, "query");
        return WorkSpecDaoKt.dedup(rawWorkInfoDao.getWorkInfoPojosFlow(query), dispatcher);
    }
}
