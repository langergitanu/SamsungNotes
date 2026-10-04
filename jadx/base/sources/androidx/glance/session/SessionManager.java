package androidx.glance.session;

import androidx.annotation.RestrictTo;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function2;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(m13885d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bg\u0018\u00002\u00020\u0001J=\u0010\u0006\u001a\u0002H\u0007\"\u0004\b\u0000\u0010\u00072'\u0010\b\u001a#\b\u0001\u0012\u0004\u0012\u00020\n\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00070\u000b\u0012\u0006\u0012\u0004\u0018\u00010\u00010\t¢\u0006\u0002\b\fH¦@¢\u0006\u0002\u0010\rR\u0014\u0010\u0002\u001a\u00020\u00038VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0004\u0010\u0005ø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001¨\u0006\u000eÀ\u0006\u0003"}, m13886d2 = {"Landroidx/glance/session/SessionManager;", "", "keyParam", "", "getKeyParam", "()Ljava/lang/String;", "runWithLock", "T", "block", "Lkotlin/Function2;", "Landroidx/glance/session/SessionManagerScope;", "Lkotlin/coroutines/Continuation;", "Lkotlin/ExtensionFunctionType;", "(Lkotlin/jvm/functions/Function2;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "glance_release"}, m13887k = 1, m13888mv = {1, 9, 0}, m13890xi = 48)
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
public interface SessionManager {

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13887k = 3, m13888mv = {1, 9, 0}, m13890xi = 48)
    public static final class DefaultImpls {
        @Deprecated
        @NotNull
        public static String getKeyParam(@NotNull SessionManager sessionManager) {
            return SessionManager.super.getKeyParam();
        }
    }

    @NotNull
    default String getKeyParam() {
        return "KEY";
    }

    @Nullable
    <T> Object runWithLock(@NotNull Function2<? super SessionManagerScope, ? super Continuation<? super T>, ? extends Object> function2, @NotNull Continuation<? super T> continuation);
}
