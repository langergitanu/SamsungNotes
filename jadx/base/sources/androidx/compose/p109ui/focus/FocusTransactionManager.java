package androidx.compose.p109ui.focus;

import androidx.collection.MutableScatterMap;
import androidx.collection.ScatterMapKt;
import androidx.compose.runtime.AbstractC1974b;
import androidx.compose.runtime.collection.MutableVector;
import androidx.compose.runtime.internal.StabilityInferred;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.InlineMarker;
import kotlin.jvm.internal.SourceDebugExtension;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes.dex */
@StabilityInferred(parameters = 0)
@Metadata(m13885d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0010\b\u0000\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\b\u0010\u0013\u001a\u00020\u0006H\u0002J\b\u0010\u0014\u001a\u00020\u0006H\u0002J\b\u0010\u0015\u001a\u00020\u0006H\u0002J4\u0010\u0016\u001a\u0002H\u0017\"\u0004\b\u0000\u0010\u00172\u0010\b\n\u0010\u0018\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u00052\f\u0010\u0019\u001a\b\u0012\u0004\u0012\u0002H\u00170\u0005H\u0086\b¢\u0006\u0002\u0010\u001aJ4\u0010\u001b\u001a\u0002H\u0017\"\u0004\b\u0000\u0010\u00172\u0010\b\n\u0010\u0018\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u00052\f\u0010\u0019\u001a\b\u0012\u0004\u0012\u0002H\u00170\u0005H\u0086\b¢\u0006\u0002\u0010\u001aR\u001a\u0010\u0003\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00060\u00050\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\t\u001a\u000e\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\f0\nX\u0082\u0004¢\u0006\u0002\n\u0000R,\u0010\u000e\u001a\u0004\u0018\u00010\f*\u00020\u000b2\b\u0010\r\u001a\u0004\u0018\u00010\f8F@FX\u0086\u000e¢\u0006\f\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012¨\u0006\u001c"}, m13886d2 = {"Landroidx/compose/ui/focus/FocusTransactionManager;", "", "()V", "cancellationListener", "Landroidx/compose/runtime/collection/MutableVector;", "Lkotlin/Function0;", "", "ongoingTransaction", "", "states", "Landroidx/collection/MutableScatterMap;", "Landroidx/compose/ui/focus/FocusTargetNode;", "Landroidx/compose/ui/focus/FocusStateImpl;", "value", "uncommittedFocusState", "getUncommittedFocusState", "(Landroidx/compose/ui/focus/FocusTargetNode;)Landroidx/compose/ui/focus/FocusStateImpl;", "setUncommittedFocusState", "(Landroidx/compose/ui/focus/FocusTargetNode;Landroidx/compose/ui/focus/FocusStateImpl;)V", "beginTransaction", "cancelTransaction", "commitTransaction", "withExistingTransaction", "T", "onCancelled", "block", "(Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function0;)Ljava/lang/Object;", "withNewTransaction", "ui_release"}, m13887k = 1, m13888mv = {1, 8, 0}, m13890xi = 48)
@SourceDebugExtension({"SMAP\nFocusTransactionManager.kt\nKotlin\n*S Kotlin\n*F\n+ 1 FocusTransactionManager.kt\nandroidx/compose/ui/focus/FocusTransactionManager\n+ 2 MutableVector.kt\nandroidx/compose/runtime/collection/MutableVectorKt\n+ 3 fake.kt\nkotlin/jvm/internal/FakeKt\n+ 4 MutableVector.kt\nandroidx/compose/runtime/collection/MutableVector\n+ 5 InlineClassHelper.kt\nandroidx/compose/ui/internal/InlineClassHelperKt\n+ 6 ScatterMap.kt\nandroidx/collection/ScatterMap\n+ 7 ScatterMap.kt\nandroidx/collection/ScatterMapKt\n*L\n1#1,102:1\n1208#2:103\n1187#2,2:104\n1#3:106\n728#4,2:107\n728#4,2:109\n460#4,11:145\n66#5,9:111\n405#6,3:120\n363#6,6:123\n373#6,3:130\n376#6,2:134\n409#6,2:136\n379#6,6:138\n411#6:144\n1810#7:129\n1672#7:133\n*S KotlinDebug\n*F\n+ 1 FocusTransactionManager.kt\nandroidx/compose/ui/focus/FocusTransactionManager\n*L\n31#1:103\n31#1:104,2\n46#1:107,2\n63#1:109,2\n98#1:145,11\n79#1:111,9\n87#1:120,3\n87#1:123,6\n87#1:130,3\n87#1:134,2\n87#1:136,2\n87#1:138,6\n87#1:144\n87#1:129\n87#1:133\n*E\n"})
public final class FocusTransactionManager {
    public static final int $stable = 8;
    private boolean ongoingTransaction;

    @NotNull
    private final MutableScatterMap<FocusTargetNode, FocusStateImpl> states = ScatterMapKt.mutableScatterMapOf();

    @NotNull
    private final MutableVector<Function0<Unit>> cancellationListener = new MutableVector<>(new Function0[16], 0);

    /* JADX INFO: Access modifiers changed from: private */
    public final void beginTransaction() {
        this.ongoingTransaction = true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void cancelTransaction() {
        this.states.clear();
        int i = 0;
        this.ongoingTransaction = false;
        MutableVector<Function0<Unit>> mutableVector = this.cancellationListener;
        int size = mutableVector.getSize();
        if (size > 0) {
            Function0<Unit>[] content = mutableVector.getContent();
            do {
                content[i].invoke();
                i++;
            } while (i < size);
        }
        this.cancellationListener.clear();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:14:0x0042  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void commitTransaction() {
        MutableScatterMap<FocusTargetNode, FocusStateImpl> mutableScatterMap = this.states;
        Object[] objArr = mutableScatterMap.keys;
        long[] jArr = mutableScatterMap.metadata;
        int length = jArr.length - 2;
        if (length >= 0) {
            int i = 0;
            while (true) {
                long j = jArr[i];
                if ((((~j) << 7) & j & (-9187201950435737472L)) != -9187201950435737472L) {
                    int i2 = 8 - ((~(i - length)) >>> 31);
                    for (int i4 = 0; i4 < i2; i4++) {
                        if ((255 & j) < 128) {
                            ((FocusTargetNode) objArr[(i << 3) + i4]).commitFocusState$ui_release();
                        }
                        j >>= 8;
                    }
                    if (i2 != 8) {
                        break;
                    } else if (i == length) {
                        break;
                    } else {
                        i++;
                    }
                }
            }
        }
        this.states.clear();
        this.ongoingTransaction = false;
        this.cancellationListener.clear();
    }

    public static /* synthetic */ Object withExistingTransaction$default(FocusTransactionManager focusTransactionManager, Function0 function0, Function0 function02, int i, Object obj) {
        if ((i & 1) != 0) {
            function0 = null;
        }
        if (function0 != null) {
            focusTransactionManager.cancellationListener.add(function0);
        }
        if (focusTransactionManager.ongoingTransaction) {
            return function02.invoke();
        }
        try {
            focusTransactionManager.beginTransaction();
            return function02.invoke();
        } finally {
            InlineMarker.finallyStart(1);
            focusTransactionManager.commitTransaction();
            InlineMarker.finallyEnd(1);
        }
    }

    public static /* synthetic */ Object withNewTransaction$default(FocusTransactionManager focusTransactionManager, Function0 function0, Function0 function02, int i, Object obj) {
        if ((i & 1) != 0) {
            function0 = null;
        }
        try {
            if (focusTransactionManager.ongoingTransaction) {
                focusTransactionManager.cancelTransaction();
            }
            focusTransactionManager.beginTransaction();
            if (function0 != null) {
                focusTransactionManager.cancellationListener.add(function0);
            }
            Object objInvoke = function02.invoke();
            InlineMarker.finallyStart(1);
            focusTransactionManager.commitTransaction();
            InlineMarker.finallyEnd(1);
            return objInvoke;
        } catch (Throwable th) {
            InlineMarker.finallyStart(1);
            focusTransactionManager.commitTransaction();
            InlineMarker.finallyEnd(1);
            throw th;
        }
    }

    @Nullable
    public final FocusStateImpl getUncommittedFocusState(@NotNull FocusTargetNode focusTargetNode) {
        return this.states.get(focusTargetNode);
    }

    public final void setUncommittedFocusState(@NotNull FocusTargetNode focusTargetNode, @Nullable FocusStateImpl focusStateImpl) {
        MutableScatterMap<FocusTargetNode, FocusStateImpl> mutableScatterMap = this.states;
        if (focusStateImpl == null) {
            throw AbstractC1974b.m1327t("requires a non-null focus state");
        }
        mutableScatterMap.set(focusTargetNode, focusStateImpl);
    }

    public final <T> T withExistingTransaction(@Nullable Function0<Unit> onCancelled, @NotNull Function0<? extends T> block) {
        if (onCancelled != null) {
            this.cancellationListener.add(onCancelled);
        }
        if (this.ongoingTransaction) {
            return block.invoke();
        }
        try {
            beginTransaction();
            return block.invoke();
        } finally {
            InlineMarker.finallyStart(1);
            commitTransaction();
            InlineMarker.finallyEnd(1);
        }
    }

    public final <T> T withNewTransaction(@Nullable Function0<Unit> onCancelled, @NotNull Function0<? extends T> block) {
        try {
            if (this.ongoingTransaction) {
                cancelTransaction();
            }
            beginTransaction();
            if (onCancelled != null) {
                this.cancellationListener.add(onCancelled);
            }
            T tInvoke = block.invoke();
            InlineMarker.finallyStart(1);
            commitTransaction();
            InlineMarker.finallyEnd(1);
            return tInvoke;
        } catch (Throwable th) {
            InlineMarker.finallyStart(1);
            commitTransaction();
            InlineMarker.finallyEnd(1);
            throw th;
        }
    }
}
