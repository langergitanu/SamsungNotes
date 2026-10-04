package androidx.compose.p109ui.input.pointer;

import androidx.compose.p109ui.Modifier;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function2;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes.dex */
@Metadata(m13885d1 = {"\u0000B\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0011\n\u0002\b\u0003\u001a4\u0010\u0006\u001a\u00020\u00072'\u0010\b\u001a#\b\u0001\u0012\u0004\u0012\u00020\n\u0012\n\u0012\b\u0012\u0004\u0012\u00020\f0\u000b\u0012\u0006\u0012\u0004\u0018\u00010\r0\t¢\u0006\u0002\b\u000e¢\u0006\u0002\u0010\u000f\u001aL\u0010\u0010\u001a\u00020\u0011*\u00020\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\r2\b\u0010\u0013\u001a\u0004\u0018\u00010\r2'\u0010\u0014\u001a#\b\u0001\u0012\u0004\u0012\u00020\n\u0012\n\u0012\b\u0012\u0004\u0012\u00020\f0\u000b\u0012\u0006\u0012\u0004\u0018\u00010\r0\t¢\u0006\u0002\b\u000e¢\u0006\u0002\u0010\u0015\u001aB\u0010\u0010\u001a\u00020\u0011*\u00020\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\r2'\u0010\u0014\u001a#\b\u0001\u0012\u0004\u0012\u00020\n\u0012\n\u0012\b\u0012\u0004\u0012\u00020\f0\u000b\u0012\u0006\u0012\u0004\u0018\u00010\r0\t¢\u0006\u0002\b\u000e¢\u0006\u0002\u0010\u0016\u001aP\u0010\u0010\u001a\u00020\u0011*\u00020\u00112\u0016\u0010\u0017\u001a\f\u0012\b\b\u0001\u0012\u0004\u0018\u00010\r0\u0018\"\u0004\u0018\u00010\r2'\u0010\u0014\u001a#\b\u0001\u0012\u0004\u0012\u00020\n\u0012\n\u0012\b\u0012\u0004\u0012\u00020\f0\u000b\u0012\u0006\u0012\u0004\u0018\u00010\r0\t¢\u0006\u0002\b\u000e¢\u0006\u0002\u0010\u0019\u001a:\u0010\u0010\u001a\u00020\u0011*\u00020\u00112'\u0010\u0014\u001a#\b\u0001\u0012\u0004\u0012\u00020\n\u0012\n\u0012\b\u0012\u0004\u0012\u00020\f0\u000b\u0012\u0006\u0012\u0004\u0018\u00010\r0\t¢\u0006\u0002\b\u000eH\u0007¢\u0006\u0002\u0010\u001a\"\u000e\u0010\u0000\u001a\u00020\u0001X\u0082\u0004¢\u0006\u0002\n\u0000\"\u0014\u0010\u0002\u001a\u00020\u0003X\u0082T¢\u0006\b\n\u0000\u0012\u0004\b\u0004\u0010\u0005¨\u0006\u001b"}, m13886d2 = {"EmptyPointerEvent", "Landroidx/compose/ui/input/pointer/PointerEvent;", "PointerInputModifierNoParamError", "", "getPointerInputModifierNoParamError$annotations", "()V", "SuspendingPointerInputModifierNode", "Landroidx/compose/ui/input/pointer/SuspendingPointerInputModifierNode;", "pointerInputHandler", "Lkotlin/Function2;", "Landroidx/compose/ui/input/pointer/PointerInputScope;", "Lkotlin/coroutines/Continuation;", "", "", "Lkotlin/ExtensionFunctionType;", "(Lkotlin/jvm/functions/Function2;)Landroidx/compose/ui/input/pointer/SuspendingPointerInputModifierNode;", "pointerInput", "Landroidx/compose/ui/Modifier;", "key1", "key2", "block", "(Landroidx/compose/ui/Modifier;Ljava/lang/Object;Ljava/lang/Object;Lkotlin/jvm/functions/Function2;)Landroidx/compose/ui/Modifier;", "(Landroidx/compose/ui/Modifier;Ljava/lang/Object;Lkotlin/jvm/functions/Function2;)Landroidx/compose/ui/Modifier;", "keys", "", "(Landroidx/compose/ui/Modifier;[Ljava/lang/Object;Lkotlin/jvm/functions/Function2;)Landroidx/compose/ui/Modifier;", "(Landroidx/compose/ui/Modifier;Lkotlin/jvm/functions/Function2;)Landroidx/compose/ui/Modifier;", "ui_release"}, m13887k = 2, m13888mv = {1, 8, 0}, m13890xi = 48)
public final class SuspendingPointerInputFilterKt {

    @NotNull
    private static final PointerEvent EmptyPointerEvent = new PointerEvent(CollectionsKt.emptyList());

    @NotNull
    private static final String PointerInputModifierNoParamError = "Modifier.pointerInput must provide one or more 'key' parameters that define the identity of the modifier and determine when its previous input processing coroutine should be cancelled and a new effect launched for the new key.";

    @NotNull
    public static final SuspendingPointerInputModifierNode SuspendingPointerInputModifierNode(@NotNull Function2<? super PointerInputScope, ? super Continuation<? super Unit>, ? extends Object> function2) {
        return new SuspendingPointerInputModifierNodeImpl(null, null, null, function2);
    }

    @Deprecated(level = DeprecationLevel.ERROR, message = PointerInputModifierNoParamError)
    @NotNull
    public static final Modifier pointerInput(@NotNull Modifier modifier, @NotNull Function2<? super PointerInputScope, ? super Continuation<? super Unit>, ? extends Object> function2) {
        throw new IllegalStateException(PointerInputModifierNoParamError);
    }

    @NotNull
    public static final Modifier pointerInput(@NotNull Modifier modifier, @Nullable Object obj, @NotNull Function2<? super PointerInputScope, ? super Continuation<? super Unit>, ? extends Object> function2) {
        return modifier.then(new SuspendPointerInputElement(obj, null, null, function2, 6, null));
    }

    @NotNull
    public static final Modifier pointerInput(@NotNull Modifier modifier, @Nullable Object obj, @Nullable Object obj2, @NotNull Function2<? super PointerInputScope, ? super Continuation<? super Unit>, ? extends Object> function2) {
        return modifier.then(new SuspendPointerInputElement(obj, obj2, null, function2, 4, null));
    }

    @NotNull
    public static final Modifier pointerInput(@NotNull Modifier modifier, @NotNull Object[] objArr, @NotNull Function2<? super PointerInputScope, ? super Continuation<? super Unit>, ? extends Object> function2) {
        return modifier.then(new SuspendPointerInputElement(null, null, objArr, function2, 3, null));
    }

    private static /* synthetic */ void getPointerInputModifierNoParamError$annotations() {
    }
}
