package com.samsung.android.support.senl.p148nt.data.database.core.sqlite;

import androidx.annotation.NonNull;
import androidx.sqlite.p113db.SupportSQLiteOpenHelper;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes3.dex */
public class NotesSQLiteOpenHelperFactory implements SupportSQLiteOpenHelper.Factory {
    @Override // androidx.sqlite.db.SupportSQLiteOpenHelper.Factory
    @NonNull
    public SupportSQLiteOpenHelper create(SupportSQLiteOpenHelper.Configuration configuration) {
        return new NotesSQLiteOpenHelper(configuration.context, configuration.name, configuration.callback);
    }
}
