package androidx.compose.p109ui.text.platform;

import kotlin.Metadata;
import kotlin.PublishedApi;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.InlineMarker;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(m13885d1 = {"\u0000\u0012\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\b\u0010\u0000\u001a\u00020\u0001H\u0000\u001a*\u0010\u0002\u001a\u0002H\u0003\"\u0004\b\u0000\u0010\u00032\u0006\u0010\u0004\u001a\u00020\u00012\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u0002H\u00030\u0006H\u0081\b¢\u0006\u0002\u0010\u0007¨\u0006\b"}, m13886d2 = {"createSynchronizedObject", "Landroidx/compose/ui/text/platform/SynchronizedObject;", "synchronized", "R", "lock", "block", "Lkotlin/Function0;", "(Landroidx/compose/ui/text/platform/SynchronizedObject;Lkotlin/jvm/functions/Function0;)Ljava/lang/Object;", "ui-text_release"}, m13887k = 2, m13888mv = {1, 8, 0}, m13890xi = 48)
public final class Synchronization_jvmKt {
    @NotNull
    public static final SynchronizedObject createSynchronizedObject() {
        return new SynchronizedObject();
    }

    @PublishedApi
    /* JADX INFO: renamed from: synchronized, reason: not valid java name */
    public static final <R> R m20723synchronized(@NotNull SynchronizedObject synchronizedObject, @NotNull Function0<? extends R> function0) {
        R rInvoke;
        synchronized (synchronizedObject) {
            try {
                rInvoke = function0.invoke();
                InlineMarker.finallyStart(1);
            } catch (Throwable th) {
                InlineMarker.finallyStart(1);
                InlineMarker.finallyEnd(1);
                throw th;
            }
        }
        InlineMarker.finallyEnd(1);
        return rInvoke;
    }
}
