package androidx.room.migration;

import androidx.annotation.NonNull;
import androidx.sqlite.p113db.SupportSQLiteDatabase;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes4.dex */
public interface AutoMigrationSpec {
    default void onPostMigrate(@NonNull SupportSQLiteDatabase supportSQLiteDatabase) {
    }
}
