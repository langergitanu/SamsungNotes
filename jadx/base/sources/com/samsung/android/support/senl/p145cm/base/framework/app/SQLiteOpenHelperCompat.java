package com.samsung.android.support.senl.p145cm.base.framework.app;

import android.database.sqlite.SQLiteOpenHelper;
import com.samsung.android.support.senl.p145cm.base.framework.sem.app.AbsSQLiteOpenHelperCompatImplFactory;
import com.samsung.android.support.senl.p145cm.base.framework.sem.app.SQLiteOpenHelperCompatImplFactory;
import com.samsung.android.support.senl.p145cm.base.framework.support.DeviceInfo;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes9.dex */
@Metadata(m13885d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 \n2\u00020\u0001:\u0001\nB\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0010\u0010\u0006\u001a\u00020\u00072\b\u0010\b\u001a\u0004\u0018\u00010\tR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u000b"}, m13886d2 = {"Lcom/samsung/android/support/senl/cm/base/framework/app/SQLiteOpenHelperCompat;", "", "mImpl", "Lcom/samsung/android/support/senl/cm/base/framework/sem/app/AbsSQLiteOpenHelperCompatImplFactory$ISQLiteOpenHelperCompatImpl;", "<init>", "(Lcom/samsung/android/support/senl/cm/base/framework/sem/app/AbsSQLiteOpenHelperCompatImplFactory$ISQLiteOpenHelperCompatImpl;)V", "enableDataRecovery", "", "sqLiteOpenHelper", "Landroid/database/sqlite/SQLiteOpenHelper;", "Companion", "cmBase_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
public final class SQLiteOpenHelperCompat {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    @Nullable
    private static SQLiteOpenHelperCompat sInstance;

    @NotNull
    private final AbsSQLiteOpenHelperCompatImplFactory.ISQLiteOpenHelperCompatImpl mImpl;

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u0011\u0010\u0006\u001a\u00020\u00058F¢\u0006\u0006\u001a\u0004\b\u0007\u0010\b¨\u0006\t"}, m13886d2 = {"Lcom/samsung/android/support/senl/cm/base/framework/app/SQLiteOpenHelperCompat$Companion;", "", "<init>", "()V", "sInstance", "Lcom/samsung/android/support/senl/cm/base/framework/app/SQLiteOpenHelperCompat;", "instance", "getInstance", "()Lcom/samsung/android/support/senl/cm/base/framework/app/SQLiteOpenHelperCompat;", "cmBase_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @NotNull
        public final synchronized SQLiteOpenHelperCompat getInstance() {
            SQLiteOpenHelperCompat sQLiteOpenHelperCompat;
            try {
                if (SQLiteOpenHelperCompat.sInstance == null) {
                    SQLiteOpenHelperCompat.sInstance = new SQLiteOpenHelperCompat(new SQLiteOpenHelperCompatImplFactory().create(DeviceInfo.getDeviceType()), null);
                }
                sQLiteOpenHelperCompat = SQLiteOpenHelperCompat.sInstance;
                Intrinsics.checkNotNull(sQLiteOpenHelperCompat, "null cannot be cast to non-null type com.samsung.android.support.senl.cm.base.framework.app.SQLiteOpenHelperCompat");
            } catch (Throwable th) {
                throw th;
            }
            return sQLiteOpenHelperCompat;
        }

        private Companion() {
        }
    }

    public /* synthetic */ SQLiteOpenHelperCompat(AbsSQLiteOpenHelperCompatImplFactory.ISQLiteOpenHelperCompatImpl iSQLiteOpenHelperCompatImpl, DefaultConstructorMarker defaultConstructorMarker) {
        this(iSQLiteOpenHelperCompatImpl);
    }

    public final void enableDataRecovery(@Nullable SQLiteOpenHelper sqLiteOpenHelper) {
        this.mImpl.enableDataRecovery(sqLiteOpenHelper);
    }

    private SQLiteOpenHelperCompat(AbsSQLiteOpenHelperCompatImplFactory.ISQLiteOpenHelperCompatImpl iSQLiteOpenHelperCompatImpl) {
        this.mImpl = iSQLiteOpenHelperCompatImpl;
    }
}
