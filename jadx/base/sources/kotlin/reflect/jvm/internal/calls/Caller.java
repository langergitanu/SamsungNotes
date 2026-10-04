package kotlin.reflect.jvm.internal.calls;

import androidx.core.app.NotificationCompat;
import androidx.glance.AbstractC2821a;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.p155ai.drawing.common.Constant;
import java.lang.reflect.Member;
import java.lang.reflect.Type;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes9.dex */
@Metadata(m13885d1 = {"\u00000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\b\u0004\b`\u0018\u0000*\f\b\u0000\u0010\u0001 \u0001*\u0004\u0018\u00010\u00022\u00020\u0003J\u0019\u0010\u000f\u001a\u00020\u00102\n\u0010\u0011\u001a\u0006\u0012\u0002\b\u00030\u0012H\u0016¢\u0006\u0002\u0010\u0013J\u001b\u0010\u0014\u001a\u0004\u0018\u00010\u00032\n\u0010\u0011\u001a\u0006\u0012\u0002\b\u00030\u0012H&¢\u0006\u0002\u0010\u0015R\u0012\u0010\u0004\u001a\u00028\u0000X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0005\u0010\u0006R\u0012\u0010\u0007\u001a\u00020\bX¦\u0004¢\u0006\u0006\u001a\u0004\b\t\u0010\nR\u0018\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\b0\fX¦\u0004¢\u0006\u0006\u001a\u0004\b\r\u0010\u000e¨\u0006\u0016"}, m13886d2 = {"Lkotlin/reflect/jvm/internal/calls/Caller;", "M", "Ljava/lang/reflect/Member;", "", "member", "getMember", "()Ljava/lang/reflect/Member;", Constant.DRAWING_TOOLKIT_KEY_RETURN_TYPE, "Ljava/lang/reflect/Type;", "getReturnType", "()Ljava/lang/reflect/Type;", "parameterTypes", "", "getParameterTypes", "()Ljava/util/List;", "checkArguments", "", "args", "", "([Ljava/lang/Object;)V", NotificationCompat.CATEGORY_CALL, "([Ljava/lang/Object;)Ljava/lang/Object;", "kotlin-reflection"}, m13887k = 1, m13888mv = {2, 0, 0}, m13890xi = 48)
public interface Caller<M extends Member> {

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13887k = 3, m13888mv = {2, 0, 0}, m13890xi = 48)
    public static final class DefaultImpls {
        public static <M extends Member> void checkArguments(@NotNull Caller<? extends M> caller, @NotNull Object[] args) {
            Intrinsics.checkNotNullParameter(args, "args");
            if (CallerKt.getArity(caller) == args.length) {
                return;
            }
            StringBuilder sb = new StringBuilder("Callable expects ");
            sb.append(CallerKt.getArity(caller));
            sb.append(" arguments, but ");
            throw new IllegalArgumentException(AbstractC2821a.m2223n(sb, " were provided.", args.length));
        }
    }

    @Nullable
    Object call(@NotNull Object[] args);

    /* JADX INFO: renamed from: getMember */
    M mo23485getMember();

    @NotNull
    List<Type> getParameterTypes();

    @NotNull
    Type getReturnType();
}
