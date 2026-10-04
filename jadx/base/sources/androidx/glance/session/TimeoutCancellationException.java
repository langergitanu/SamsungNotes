package androidx.glance.session;

import androidx.compose.runtime.AbstractC1974b;
import androidx.compose.runtime.internal.StabilityInferred;
import com.samsung.android.support.senl.p148nt.data.database.core.query.sqlbuilder.SQLKeyword;
import java.util.concurrent.CancellationException;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes4.dex */
@StabilityInferred(parameters = 1)
@Metadata(m13885d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\b\b\u0000\u0018\u00002\u00060\u0001j\u0002`\u0002B\u0015\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0002\u0010\u0007J\b\u0010\f\u001a\u00020\u0000H\u0016J\b\u0010\r\u001a\u00020\u0004H\u0016R\u0014\u0010\u0005\u001a\u00020\u0006X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0014\u0010\u0003\u001a\u00020\u0004X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\u000e"}, m13886d2 = {"Landroidx/glance/session/TimeoutCancellationException;", "Ljava/util/concurrent/CancellationException;", "Lkotlinx/coroutines/CancellationException;", "message", "", "block", "", "(Ljava/lang/String;I)V", "getBlock$glance_release", "()I", "getMessage", "()Ljava/lang/String;", "fillInStackTrace", "toString", "glance_release"}, m13887k = 1, m13888mv = {1, 9, 0}, m13890xi = 48)
public final class TimeoutCancellationException extends CancellationException {
    public static final int $stable = 0;
    private final int block;

    @NotNull
    private final String message;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public TimeoutCancellationException(@NotNull String message, int i) {
        super(message);
        Intrinsics.checkNotNullParameter(message, "message");
        this.message = message;
        this.block = i;
    }

    @Override // java.lang.Throwable
    @NotNull
    public TimeoutCancellationException fillInStackTrace() {
        return this;
    }

    /* JADX INFO: renamed from: getBlock$glance_release, reason: from getter */
    public final int getBlock() {
        return this.block;
    }

    @Override // java.lang.Throwable
    @NotNull
    public String getMessage() {
        return this.message;
    }

    @Override // java.lang.Throwable
    @NotNull
    public String toString() {
        return AbstractC1974b.m1319l("TimeoutCancellationException(", this.block, getMessage(), SQLKeyword.COMMA, ")");
    }
}
