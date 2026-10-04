package com.samsung.android.support.senl.p145cm.base.framework.sem.app;

import android.database.sqlite.SQLiteOpenHelper;
import com.samsung.android.support.senl.p145cm.base.framework.support.LoggerBase;
import com.samsung.android.support.senl.p148nt.base.common.mcf.handoff.common.HandoffConstant;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes9.dex */
@Metadata(m13885d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\b\u0016\u0018\u0000 \n2\u00020\u0001:\u0003\b\t\nB\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0016¨\u0006\u000b"}, m13886d2 = {"Lcom/samsung/android/support/senl/cm/base/framework/sem/app/AbsSQLiteOpenHelperCompatImplFactory;", "", "<init>", "()V", "create", "Lcom/samsung/android/support/senl/cm/base/framework/sem/app/AbsSQLiteOpenHelperCompatImplFactory$ISQLiteOpenHelperCompatImpl;", HandoffConstant.KEY_DEVICE_TYPE, "", "ISQLiteOpenHelperCompatImpl", "SQLiteOpenHelperCompatPureImpl", "Companion", "cmBase_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
public class AbsSQLiteOpenHelperCompatImplFactory {

    @NotNull
    private static final String TAG = "SQLiteOpenHelperCompatImpl";

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\u0012\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H&¨\u0006\u0006"}, m13886d2 = {"Lcom/samsung/android/support/senl/cm/base/framework/sem/app/AbsSQLiteOpenHelperCompatImplFactory$ISQLiteOpenHelperCompatImpl;", "", "enableDataRecovery", "", "sqLiteOpenHelper", "Landroid/database/sqlite/SQLiteOpenHelper;", "cmBase_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
    public interface ISQLiteOpenHelperCompatImpl {
        void enableDataRecovery(@Nullable SQLiteOpenHelper sqLiteOpenHelper);
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0002\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0012\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007H\u0016¨\u0006\b"}, m13886d2 = {"Lcom/samsung/android/support/senl/cm/base/framework/sem/app/AbsSQLiteOpenHelperCompatImplFactory$SQLiteOpenHelperCompatPureImpl;", "Lcom/samsung/android/support/senl/cm/base/framework/sem/app/AbsSQLiteOpenHelperCompatImplFactory$ISQLiteOpenHelperCompatImpl;", "<init>", "()V", "enableDataRecovery", "", "sqLiteOpenHelper", "Landroid/database/sqlite/SQLiteOpenHelper;", "cmBase_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
    public static final class SQLiteOpenHelperCompatPureImpl implements ISQLiteOpenHelperCompatImpl {
        @Override // com.samsung.android.support.senl.cm.base.framework.sem.app.AbsSQLiteOpenHelperCompatImplFactory.ISQLiteOpenHelperCompatImpl
        public void enableDataRecovery(@Nullable SQLiteOpenHelper sqLiteOpenHelper) {
            LoggerBase.INSTANCE.m7132d(AbsSQLiteOpenHelperCompatImplFactory.TAG, "SQLiteOpenHelperCompatPureImpl enableDataRecovery# ");
        }
    }

    @NotNull
    public ISQLiteOpenHelperCompatImpl create(int deviceType) {
        return new SQLiteOpenHelperCompatPureImpl();
    }
}
