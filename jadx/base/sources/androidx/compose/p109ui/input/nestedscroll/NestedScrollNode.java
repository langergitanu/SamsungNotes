package androidx.compose.p109ui.input.nestedscroll;

import androidx.compose.p109ui.Modifier;
import androidx.compose.p109ui.geometry.Offset;
import androidx.compose.p109ui.node.TraversableNode;
import androidx.compose.p109ui.node.TraversableNodeKt;
import androidx.compose.p109ui.unit.Velocity;
import androidx.compose.runtime.internal.StabilityInferred;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes.dex */
@StabilityInferred(parameters = 0)
@Metadata(m13885d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000f\b\u0000\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u0003B\u0017\u0012\u0006\u0010\u0004\u001a\u00020\u0002\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\u0002\u0010\u0007J\b\u0010\u001a\u001a\u00020\u001bH\u0016J\b\u0010\u001c\u001a\u00020\u001bH\u0016J#\u0010\u001d\u001a\u00020\u001e2\u0006\u0010\u001f\u001a\u00020\u001e2\u0006\u0010 \u001a\u00020\u001eH\u0096@ø\u0001\u0000¢\u0006\u0004\b!\u0010\"J*\u0010#\u001a\u00020$2\u0006\u0010\u001f\u001a\u00020$2\u0006\u0010 \u001a\u00020$2\u0006\u0010%\u001a\u00020&H\u0016ø\u0001\u0000¢\u0006\u0004\b'\u0010(J\u001b\u0010)\u001a\u00020\u001e2\u0006\u0010 \u001a\u00020\u001eH\u0096@ø\u0001\u0000¢\u0006\u0004\b*\u0010+J\"\u0010,\u001a\u00020$2\u0006\u0010 \u001a\u00020$2\u0006\u0010%\u001a\u00020&H\u0016ø\u0001\u0000¢\u0006\u0004\b-\u0010.J\b\u0010/\u001a\u00020\u001bH\u0002J\u0012\u00100\u001a\u00020\u001b2\b\u00101\u001a\u0004\u0018\u00010\u0006H\u0002J\b\u00102\u001a\u00020\u001bH\u0002J\u001f\u00103\u001a\u00020\u001b2\u0006\u0010\u0004\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006H\u0000¢\u0006\u0002\b4R\u001a\u0010\u0004\u001a\u00020\u0002X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR\u0014\u0010\f\u001a\u00020\r8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u000e\u0010\u000fR\u0016\u0010\u0010\u001a\u0004\u0018\u00010\u00028BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u0011\u0010\tR\u0016\u0010\u0012\u001a\u0004\u0018\u00010\u00008@X\u0080\u0004¢\u0006\u0006\u001a\u0004\b\u0013\u0010\u0014R\u000e\u0010\u0015\u001a\u00020\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u0016\u001a\u00020\u0017X\u0096D¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0019\u0082\u0002\u0007\n\u0005\b¡\u001e0\u0001¨\u00065"}, m13886d2 = {"Landroidx/compose/ui/input/nestedscroll/NestedScrollNode;", "Landroidx/compose/ui/node/TraversableNode;", "Landroidx/compose/ui/input/nestedscroll/NestedScrollConnection;", "Landroidx/compose/ui/Modifier$Node;", "connection", "dispatcher", "Landroidx/compose/ui/input/nestedscroll/NestedScrollDispatcher;", "(Landroidx/compose/ui/input/nestedscroll/NestedScrollConnection;Landroidx/compose/ui/input/nestedscroll/NestedScrollDispatcher;)V", "getConnection", "()Landroidx/compose/ui/input/nestedscroll/NestedScrollConnection;", "setConnection", "(Landroidx/compose/ui/input/nestedscroll/NestedScrollConnection;)V", "nestedCoroutineScope", "Lkotlinx/coroutines/CoroutineScope;", "getNestedCoroutineScope", "()Lkotlinx/coroutines/CoroutineScope;", "parentConnection", "getParentConnection", "parentNestedScrollNode", "getParentNestedScrollNode$ui_release", "()Landroidx/compose/ui/input/nestedscroll/NestedScrollNode;", "resolvedDispatcher", "traverseKey", "", "getTraverseKey", "()Ljava/lang/Object;", "onAttach", "", "onDetach", "onPostFling", "Landroidx/compose/ui/unit/Velocity;", "consumed", "available", "onPostFling-RZ2iAVY", "(JJLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "onPostScroll", "Landroidx/compose/ui/geometry/Offset;", "source", "Landroidx/compose/ui/input/nestedscroll/NestedScrollSource;", "onPostScroll-DzOQY0M", "(JJI)J", "onPreFling", "onPreFling-QWom1Mo", "(JLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "onPreScroll", "onPreScroll-OzD1aCk", "(JI)J", "resetDispatcherFields", "updateDispatcher", "newDispatcher", "updateDispatcherFields", "updateNode", "updateNode$ui_release", "ui_release"}, m13887k = 1, m13888mv = {1, 8, 0}, m13890xi = 48)
public final class NestedScrollNode extends Modifier.Node implements TraversableNode, NestedScrollConnection {
    public static final int $stable = 8;

    @NotNull
    private NestedScrollConnection connection;

    @NotNull
    private NestedScrollDispatcher resolvedDispatcher;

    @NotNull
    private final Object traverseKey;

    public NestedScrollNode(@NotNull NestedScrollConnection nestedScrollConnection, @Nullable NestedScrollDispatcher nestedScrollDispatcher) {
        this.connection = nestedScrollConnection;
        this.resolvedDispatcher = nestedScrollDispatcher == null ? new NestedScrollDispatcher() : nestedScrollDispatcher;
        this.traverseKey = "androidx.compose.ui.input.nestedscroll.NestedScrollNode";
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final CoroutineScope getNestedCoroutineScope() {
        CoroutineScope nestedCoroutineScope;
        NestedScrollNode parentNestedScrollNode$ui_release = getParentNestedScrollNode$ui_release();
        if (parentNestedScrollNode$ui_release != null && (nestedCoroutineScope = parentNestedScrollNode$ui_release.getNestedCoroutineScope()) != null) {
            return nestedCoroutineScope;
        }
        CoroutineScope scope = this.resolvedDispatcher.getScope();
        if (scope != null) {
            return scope;
        }
        throw new IllegalStateException("in order to access nested coroutine scope you need to attach dispatcher to the `Modifier.nestedScroll` first.");
    }

    private final NestedScrollConnection getParentConnection() {
        if (getIsAttached()) {
            return getParentNestedScrollNode$ui_release();
        }
        return null;
    }

    private final void resetDispatcherFields() {
        if (this.resolvedDispatcher.getNestedScrollNode() == this) {
            this.resolvedDispatcher.setNestedScrollNode$ui_release(null);
        }
    }

    private final void updateDispatcher(NestedScrollDispatcher newDispatcher) {
        resetDispatcherFields();
        if (newDispatcher == null) {
            this.resolvedDispatcher = new NestedScrollDispatcher();
        } else if (!Intrinsics.areEqual(newDispatcher, this.resolvedDispatcher)) {
            this.resolvedDispatcher = newDispatcher;
        }
        if (getIsAttached()) {
            updateDispatcherFields();
        }
    }

    private final void updateDispatcherFields() {
        this.resolvedDispatcher.setNestedScrollNode$ui_release(this);
        this.resolvedDispatcher.setCalculateNestedScrollScope$ui_release(new Function0<CoroutineScope>() { // from class: androidx.compose.ui.input.nestedscroll.NestedScrollNode.updateDispatcherFields.1
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final CoroutineScope invoke() {
                return NestedScrollNode.this.getNestedCoroutineScope();
            }
        });
        this.resolvedDispatcher.setScope$ui_release(getCoroutineScope());
    }

    @NotNull
    public final NestedScrollConnection getConnection() {
        return this.connection;
    }

    @Nullable
    public final NestedScrollNode getParentNestedScrollNode$ui_release() {
        if (getIsAttached()) {
            return (NestedScrollNode) TraversableNodeKt.findNearestAncestor(this);
        }
        return null;
    }

    @Override // androidx.compose.p109ui.node.TraversableNode
    @NotNull
    public Object getTraverseKey() {
        return this.traverseKey;
    }

    @Override // androidx.compose.ui.Modifier.Node
    public void onAttach() {
        updateDispatcherFields();
    }

    @Override // androidx.compose.ui.Modifier.Node
    public void onDetach() {
        resetDispatcherFields();
    }

    /* JADX WARN: Removed duplicated region for block: B:8:0x0014  */
    @Override // androidx.compose.p109ui.input.nestedscroll.NestedScrollConnection
    @Nullable
    /* JADX INFO: renamed from: onPostFling-RZ2iAVY */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public Object mo15655onPostFlingRZ2iAVY(long j, long j2, @NotNull Continuation<? super Velocity> continuation) {
        NestedScrollNode$onPostFling$1 nestedScrollNode$onPostFling$1;
        NestedScrollNode nestedScrollNode;
        long j3;
        long j5;
        long packedValue;
        long jM21216getZero9UxMQ8M;
        long j6;
        if (continuation instanceof NestedScrollNode$onPostFling$1) {
            nestedScrollNode$onPostFling$1 = (NestedScrollNode$onPostFling$1) continuation;
            int i = nestedScrollNode$onPostFling$1.label;
            if ((i & Integer.MIN_VALUE) != 0) {
                nestedScrollNode$onPostFling$1.label = i - Integer.MIN_VALUE;
            } else {
                nestedScrollNode$onPostFling$1 = new NestedScrollNode$onPostFling$1(this, continuation);
            }
        }
        NestedScrollNode$onPostFling$1 nestedScrollNode$onPostFling$12 = nestedScrollNode$onPostFling$1;
        Object objMo15655onPostFlingRZ2iAVY = nestedScrollNode$onPostFling$12.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i2 = nestedScrollNode$onPostFling$12.label;
        if (i2 == 0) {
            ResultKt.throwOnFailure(objMo15655onPostFlingRZ2iAVY);
            NestedScrollConnection nestedScrollConnection = this.connection;
            nestedScrollNode$onPostFling$12.L$0 = this;
            nestedScrollNode$onPostFling$12.J$0 = j;
            nestedScrollNode$onPostFling$12.J$1 = j2;
            nestedScrollNode$onPostFling$12.label = 1;
            objMo15655onPostFlingRZ2iAVY = nestedScrollConnection.mo15655onPostFlingRZ2iAVY(j, j2, nestedScrollNode$onPostFling$12);
            if (objMo15655onPostFlingRZ2iAVY != coroutine_suspended) {
                nestedScrollNode = this;
                j3 = j;
                j5 = j2;
            }
            return coroutine_suspended;
        }
        if (i2 != 1) {
            if (i2 != 2) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            j6 = nestedScrollNode$onPostFling$12.J$0;
            ResultKt.throwOnFailure(objMo15655onPostFlingRZ2iAVY);
            jM21216getZero9UxMQ8M = ((Velocity) objMo15655onPostFlingRZ2iAVY).getPackedValue();
            packedValue = j6;
            return Velocity.m21196boximpl(Velocity.m21209plusAH228Gc(packedValue, jM21216getZero9UxMQ8M));
        }
        j5 = nestedScrollNode$onPostFling$12.J$1;
        j3 = nestedScrollNode$onPostFling$12.J$0;
        nestedScrollNode = (NestedScrollNode) nestedScrollNode$onPostFling$12.L$0;
        ResultKt.throwOnFailure(objMo15655onPostFlingRZ2iAVY);
        packedValue = ((Velocity) objMo15655onPostFlingRZ2iAVY).getPackedValue();
        NestedScrollConnection parentConnection = nestedScrollNode.getParentConnection();
        if (parentConnection == null) {
            jM21216getZero9UxMQ8M = Velocity.INSTANCE.m21216getZero9UxMQ8M();
            return Velocity.m21196boximpl(Velocity.m21209plusAH228Gc(packedValue, jM21216getZero9UxMQ8M));
        }
        long jM21209plusAH228Gc = Velocity.m21209plusAH228Gc(j3, packedValue);
        long jM21208minusAH228Gc = Velocity.m21208minusAH228Gc(j5, packedValue);
        nestedScrollNode$onPostFling$12.L$0 = null;
        nestedScrollNode$onPostFling$12.J$0 = packedValue;
        nestedScrollNode$onPostFling$12.label = 2;
        objMo15655onPostFlingRZ2iAVY = parentConnection.mo15655onPostFlingRZ2iAVY(jM21209plusAH228Gc, jM21208minusAH228Gc, nestedScrollNode$onPostFling$12);
        if (objMo15655onPostFlingRZ2iAVY != coroutine_suspended) {
            j6 = packedValue;
            jM21216getZero9UxMQ8M = ((Velocity) objMo15655onPostFlingRZ2iAVY).getPackedValue();
            packedValue = j6;
            return Velocity.m21196boximpl(Velocity.m21209plusAH228Gc(packedValue, jM21216getZero9UxMQ8M));
        }
        return coroutine_suspended;
    }

    @Override // androidx.compose.p109ui.input.nestedscroll.NestedScrollConnection
    /* JADX INFO: renamed from: onPostScroll-DzOQY0M */
    public long mo15656onPostScrollDzOQY0M(long consumed, long available, int source) {
        long jMo15656onPostScrollDzOQY0M = this.connection.mo15656onPostScrollDzOQY0M(consumed, available, source);
        NestedScrollConnection parentConnection = getParentConnection();
        return Offset.m18289plusMKHz9U(jMo15656onPostScrollDzOQY0M, parentConnection != null ? parentConnection.mo15656onPostScrollDzOQY0M(Offset.m18289plusMKHz9U(consumed, jMo15656onPostScrollDzOQY0M), Offset.m18288minusMKHz9U(available, jMo15656onPostScrollDzOQY0M), source) : Offset.INSTANCE.m18300getZeroF1C5BW0());
    }

    /* JADX WARN: Code restructure failed: missing block: B:26:0x007a, code lost:
    
        if (r11 != r1) goto L28;
     */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    @Override // androidx.compose.p109ui.input.nestedscroll.NestedScrollConnection
    @Nullable
    /* JADX INFO: renamed from: onPreFling-QWom1Mo */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public Object mo15929onPreFlingQWom1Mo(long j, @NotNull Continuation<? super Velocity> continuation) {
        NestedScrollNode$onPreFling$1 nestedScrollNode$onPreFling$1;
        long jM21216getZero9UxMQ8M;
        NestedScrollNode nestedScrollNode;
        long j2;
        if (continuation instanceof NestedScrollNode$onPreFling$1) {
            nestedScrollNode$onPreFling$1 = (NestedScrollNode$onPreFling$1) continuation;
            int i = nestedScrollNode$onPreFling$1.label;
            if ((i & Integer.MIN_VALUE) != 0) {
                nestedScrollNode$onPreFling$1.label = i - Integer.MIN_VALUE;
            } else {
                nestedScrollNode$onPreFling$1 = new NestedScrollNode$onPreFling$1(this, continuation);
            }
        }
        Object objMo15929onPreFlingQWom1Mo = nestedScrollNode$onPreFling$1.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i2 = nestedScrollNode$onPreFling$1.label;
        if (i2 == 0) {
            ResultKt.throwOnFailure(objMo15929onPreFlingQWom1Mo);
            NestedScrollConnection parentConnection = getParentConnection();
            if (parentConnection != null) {
                nestedScrollNode$onPreFling$1.L$0 = this;
                nestedScrollNode$onPreFling$1.J$0 = j;
                nestedScrollNode$onPreFling$1.label = 1;
                objMo15929onPreFlingQWom1Mo = parentConnection.mo15929onPreFlingQWom1Mo(j, nestedScrollNode$onPreFling$1);
                if (objMo15929onPreFlingQWom1Mo != coroutine_suspended) {
                    nestedScrollNode = this;
                }
                return coroutine_suspended;
            }
            jM21216getZero9UxMQ8M = Velocity.INSTANCE.m21216getZero9UxMQ8M();
            nestedScrollNode = this;
            long j3 = jM21216getZero9UxMQ8M;
            long j5 = j;
            j2 = j3;
            NestedScrollConnection nestedScrollConnection = nestedScrollNode.connection;
            long jM21208minusAH228Gc = Velocity.m21208minusAH228Gc(j5, j2);
            nestedScrollNode$onPreFling$1.L$0 = null;
            nestedScrollNode$onPreFling$1.J$0 = j2;
            nestedScrollNode$onPreFling$1.label = 2;
            objMo15929onPreFlingQWom1Mo = nestedScrollConnection.mo15929onPreFlingQWom1Mo(jM21208minusAH228Gc, nestedScrollNode$onPreFling$1);
        } else {
            if (i2 != 1) {
                if (i2 != 2) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                j2 = nestedScrollNode$onPreFling$1.J$0;
                ResultKt.throwOnFailure(objMo15929onPreFlingQWom1Mo);
                return Velocity.m21196boximpl(Velocity.m21209plusAH228Gc(j2, ((Velocity) objMo15929onPreFlingQWom1Mo).getPackedValue()));
            }
            j = nestedScrollNode$onPreFling$1.J$0;
            nestedScrollNode = (NestedScrollNode) nestedScrollNode$onPreFling$1.L$0;
            ResultKt.throwOnFailure(objMo15929onPreFlingQWom1Mo);
        }
        jM21216getZero9UxMQ8M = ((Velocity) objMo15929onPreFlingQWom1Mo).getPackedValue();
        long j32 = jM21216getZero9UxMQ8M;
        long j52 = j;
        j2 = j32;
        NestedScrollConnection nestedScrollConnection2 = nestedScrollNode.connection;
        long jM21208minusAH228Gc2 = Velocity.m21208minusAH228Gc(j52, j2);
        nestedScrollNode$onPreFling$1.L$0 = null;
        nestedScrollNode$onPreFling$1.J$0 = j2;
        nestedScrollNode$onPreFling$1.label = 2;
        objMo15929onPreFlingQWom1Mo = nestedScrollConnection2.mo15929onPreFlingQWom1Mo(jM21208minusAH228Gc2, nestedScrollNode$onPreFling$1);
    }

    @Override // androidx.compose.p109ui.input.nestedscroll.NestedScrollConnection
    /* JADX INFO: renamed from: onPreScroll-OzD1aCk */
    public long mo15930onPreScrollOzD1aCk(long available, int source) {
        NestedScrollConnection parentConnection = getParentConnection();
        long jMo15930onPreScrollOzD1aCk = parentConnection != null ? parentConnection.mo15930onPreScrollOzD1aCk(available, source) : Offset.INSTANCE.m18300getZeroF1C5BW0();
        return Offset.m18289plusMKHz9U(jMo15930onPreScrollOzD1aCk, this.connection.mo15930onPreScrollOzD1aCk(Offset.m18288minusMKHz9U(available, jMo15930onPreScrollOzD1aCk), source));
    }

    public final void setConnection(@NotNull NestedScrollConnection nestedScrollConnection) {
        this.connection = nestedScrollConnection;
    }

    public final void updateNode$ui_release(@NotNull NestedScrollConnection connection, @Nullable NestedScrollDispatcher dispatcher) {
        this.connection = connection;
        updateDispatcher(dispatcher);
    }
}
