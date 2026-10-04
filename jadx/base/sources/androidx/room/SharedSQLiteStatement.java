package androidx.room;

import androidx.annotation.RestrictTo;
import androidx.sqlite.p113db.SupportSQLiteStatement;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(m13885d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\b'\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\b\u0010\r\u001a\u00020\bH\u0016J\b\u0010\u000e\u001a\u00020\u000fH\u0014J\b\u0010\u0010\u001a\u00020\bH\u0002J\b\u0010\u0011\u001a\u00020\u0012H$J\u0010\u0010\t\u001a\u00020\b2\u0006\u0010\u0013\u001a\u00020\u0014H\u0002J\u0010\u0010\u0015\u001a\u00020\u000f2\u0006\u0010\u0016\u001a\u00020\bH\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u001b\u0010\u0007\u001a\u00020\b8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u000b\u0010\f\u001a\u0004\b\t\u0010\n¨\u0006\u0017"}, m13886d2 = {"Landroidx/room/SharedSQLiteStatement;", "", "database", "Landroidx/room/RoomDatabase;", "(Landroidx/room/RoomDatabase;)V", "lock", "Ljava/util/concurrent/atomic/AtomicBoolean;", "stmt", "Landroidx/sqlite/db/SupportSQLiteStatement;", "getStmt", "()Landroidx/sqlite/db/SupportSQLiteStatement;", "stmt$delegate", "Lkotlin/Lazy;", "acquire", "assertNotMainThread", "", "createNewStatement", "createQuery", "", "canUseCached", "", "release", "statement", "room-runtime_release"}, m13887k = 1, m13888mv = {1, 7, 1}, m13890xi = 48)
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
public abstract class SharedSQLiteStatement {

    @NotNull
    private final RoomDatabase database;

    @NotNull
    private final AtomicBoolean lock;

    /* JADX INFO: renamed from: stmt$delegate, reason: from kotlin metadata */
    @NotNull
    private final Lazy stmt;

    public SharedSQLiteStatement(@NotNull RoomDatabase database) {
        Intrinsics.checkNotNullParameter(database, "database");
        this.database = database;
        this.lock = new AtomicBoolean(false);
        this.stmt = LazyKt.lazy(new Function0<SupportSQLiteStatement>() { // from class: androidx.room.SharedSQLiteStatement$stmt$2
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final SupportSQLiteStatement invoke() {
                return this.this$0.createNewStatement();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final SupportSQLiteStatement createNewStatement() {
        return this.database.compileStatement(createQuery());
    }

    private final SupportSQLiteStatement getStmt() {
        return (SupportSQLiteStatement) this.stmt.getValue();
    }

    @NotNull
    public SupportSQLiteStatement acquire() {
        assertNotMainThread();
        return getStmt(this.lock.compareAndSet(false, true));
    }

    public void assertNotMainThread() {
        this.database.assertNotMainThread();
    }

    @NotNull
    public abstract String createQuery();

    public void release(@NotNull SupportSQLiteStatement statement) {
        Intrinsics.checkNotNullParameter(statement, "statement");
        if (statement == getStmt()) {
            this.lock.set(false);
        }
    }

    private final SupportSQLiteStatement getStmt(boolean canUseCached) {
        return canUseCached ? getStmt() : createNewStatement();
    }
}
