package com.samsung.android.support.senl.p148nt.data.database.temp.p165di;

import com.samsung.android.support.senl.p148nt.data.common.constants.SearchConstants;
import com.samsung.android.support.senl.p148nt.data.common.log.DataLogger;
import com.samsung.android.support.senl.p148nt.data.database.access.NotesExtraDatabaseManager;
import com.samsung.android.support.senl.p148nt.data.database.temp.infra.dao.DeletedNoteDao;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(m13885d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0006\u0010\b\u001a\u00020\tR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\n"}, m13886d2 = {"Lcom/samsung/android/support/senl/nt/data/database/temp/di/ExtraDbModule;", "", "<init>", "()V", SearchConstants.TargetContents.TAG, "", "getTAG", "()Ljava/lang/String;", "provideDeletedNoteDao", "Lcom/samsung/android/support/senl/nt/data/database/temp/infra/dao/DeletedNoteDao;", "ntData_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
public final class ExtraDbModule {

    @NotNull
    public static final ExtraDbModule INSTANCE = new ExtraDbModule();

    @NotNull
    private static final String TAG;

    static {
        String strCreateTag = DataLogger.createTag("ExtraDatabaseModule");
        Intrinsics.checkNotNullExpressionValue(strCreateTag, "createTag(...)");
        TAG = strCreateTag;
    }

    private ExtraDbModule() {
    }

    @NotNull
    public final String getTAG() {
        return TAG;
    }

    @NotNull
    public final DeletedNoteDao provideDeletedNoteDao() {
        DeletedNoteDao deletedNoteDao = NotesExtraDatabaseManager.getInstance().deletedNoteDao();
        Intrinsics.checkNotNullExpressionValue(deletedNoteDao, "deletedNoteDao(...)");
        return deletedNoteDao;
    }
}
