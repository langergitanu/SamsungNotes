package com.samsung.android.support.senl.p148nt.data.database.core.migration.version;

import androidx.room.migration.Migration;
import androidx.sqlite.p113db.SupportSQLiteDatabase;
import com.samsung.android.support.senl.p148nt.data.common.log.DataLogger;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(m13885d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u0000 \t2\u00020\u0001:\u0001\tB\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0016J\u0010\u0010\b\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0002¨\u0006\n"}, m13886d2 = {"Lcom/samsung/android/support/senl/nt/data/database/core/migration/version/MigrationToVersion67;", "Landroidx/room/migration/Migration;", "<init>", "()V", "migrate", "", "database", "Landroidx/sqlite/db/SupportSQLiteDatabase;", "addColumns", "Companion", "ntData_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
public final class MigrationToVersion67 extends Migration {
    private static final String TAG = DataLogger.createTag("MigrationToVersion67");

    public MigrationToVersion67() {
        super(66, 67);
    }

    private final void addColumns(SupportSQLiteDatabase database) {
        database.execSQL("ALTER TABLE document_extra ADD `hasImage` INTEGER NOT NULL DEFAULT 0");
        database.execSQL("ALTER TABLE document_extra ADD `hasStroke` INTEGER NOT NULL DEFAULT 0");
        database.execSQL("ALTER TABLE document_extra ADD `hasPdf` INTEGER NOT NULL DEFAULT 0");
    }

    @Override // androidx.room.migration.Migration
    public void migrate(@NotNull SupportSQLiteDatabase database) {
        Intrinsics.checkNotNullParameter(database, "database");
        String str = TAG;
        DataLogger.m12307i(str, "migrate, start");
        addColumns(database);
        DataLogger.m12307i(str, "migrate, end");
    }
}
