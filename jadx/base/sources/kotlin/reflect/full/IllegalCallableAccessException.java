package kotlin.reflect.full;

import kotlin.Metadata;
import kotlin.SinceKotlin;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes9.dex */
@SinceKotlin(version = "1.1")
@Metadata(m13885d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0007\u0018\u00002\u00060\u0002j\u0002`\u0001B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, m13886d2 = {"Lkotlin/reflect/full/IllegalCallableAccessException;", "Lkotlin/Exception;", "Ljava/lang/Exception;", "cause", "Ljava/lang/IllegalAccessException;", "<init>", "(Ljava/lang/IllegalAccessException;)V", "kotlin-reflection"}, m13887k = 1, m13888mv = {2, 0, 0}, m13890xi = 48)
public final class IllegalCallableAccessException extends Exception {
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public IllegalCallableAccessException(@NotNull IllegalAccessException cause) {
        super(cause);
        Intrinsics.checkNotNullParameter(cause, "cause");
    }
}
