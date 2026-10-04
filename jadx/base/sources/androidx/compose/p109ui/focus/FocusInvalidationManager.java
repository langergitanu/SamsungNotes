package androidx.compose.p109ui.focus;

import androidx.collection.MutableScatterSet;
import androidx.collection.ScatterSetKt;
import androidx.compose.p109ui.Modifier;
import androidx.compose.p109ui.internal.InlineClassHelperKt;
import androidx.compose.p109ui.node.DelegatableNodeKt;
import androidx.compose.p109ui.node.DelegatingNode;
import androidx.compose.p109ui.node.NodeKind;
import androidx.compose.runtime.AbstractC1974b;
import androidx.compose.runtime.collection.MutableVector;
import androidx.compose.runtime.internal.StabilityInferred;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.SourceDebugExtension;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes.dex */
@StabilityInferred(parameters = 0)
@Metadata(m13885d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0006\b\u0000\u0018\u00002\u00020\u0001B-\u0012\u0018\u0010\u0002\u001a\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\u0004\u0012\u0004\u0012\u00020\u00050\u0003\u0012\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004¢\u0006\u0002\u0010\u0007J\u0006\u0010\u0010\u001a\u00020\u0011J\b\u0010\u0012\u001a\u00020\u0005H\u0002J\u000e\u0010\u0013\u001a\u00020\u00052\u0006\u0010\u0014\u001a\u00020\nJ\u000e\u0010\u0013\u001a\u00020\u00052\u0006\u0010\u0014\u001a\u00020\fJ\u000e\u0010\u0013\u001a\u00020\u00052\u0006\u0010\u0014\u001a\u00020\u000eJ%\u0010\u0013\u001a\u00020\u0005\"\u0004\b\u0000\u0010\u0015*\b\u0012\u0004\u0012\u0002H\u00150\t2\u0006\u0010\u0014\u001a\u0002H\u0015H\u0002¢\u0006\u0002\u0010\u0016R\u0014\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\f0\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u000e0\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u000e0\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R \u0010\u0002\u001a\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\u0004\u0012\u0004\u0012\u00020\u00050\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0017"}, m13886d2 = {"Landroidx/compose/ui/focus/FocusInvalidationManager;", "", "onRequestApplyChangesListener", "Lkotlin/Function1;", "Lkotlin/Function0;", "", "invalidateOwnerFocusState", "(Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function0;)V", "focusEventNodes", "Landroidx/collection/MutableScatterSet;", "Landroidx/compose/ui/focus/FocusEventModifierNode;", "focusPropertiesNodes", "Landroidx/compose/ui/focus/FocusPropertiesModifierNode;", "focusTargetNodes", "Landroidx/compose/ui/focus/FocusTargetNode;", "focusTargetsWithInvalidatedFocusEvents", "hasPendingInvalidation", "", "invalidateNodes", "scheduleInvalidation", "node", "T", "(Landroidx/collection/MutableScatterSet;Ljava/lang/Object;)V", "ui_release"}, m13887k = 1, m13888mv = {1, 8, 0}, m13890xi = 48)
@SourceDebugExtension({"SMAP\nFocusInvalidationManager.kt\nKotlin\n*S Kotlin\n*F\n+ 1 FocusInvalidationManager.kt\nandroidx/compose/ui/focus/FocusInvalidationManager\n+ 2 ScatterSet.kt\nandroidx/collection/ScatterSet\n+ 3 ScatterMap.kt\nandroidx/collection/ScatterMapKt\n+ 4 NodeKind.kt\nandroidx/compose/ui/node/Nodes\n+ 5 DelegatableNode.kt\nandroidx/compose/ui/node/DelegatableNodeKt\n+ 6 Modifier.kt\nandroidx/compose/ui/Modifier$Node\n+ 7 DelegatingNode.kt\nandroidx/compose/ui/node/DelegatingNode\n+ 8 MutableVector.kt\nandroidx/compose/runtime/collection/MutableVectorKt\n+ 9 fake.kt\nkotlin/jvm/internal/FakeKt\n+ 10 MutableVector.kt\nandroidx/compose/runtime/collection/MutableVector\n+ 11 InlineClassHelper.kt\nandroidx/compose/ui/internal/InlineClassHelperKt\n*L\n1#1,154:1\n267#2,4:155\n237#2,7:159\n248#2,3:167\n251#2,2:171\n272#2:173\n273#2:284\n254#2,6:285\n274#2:291\n267#2,4:292\n237#2,7:296\n248#2,3:304\n251#2,2:308\n272#2:310\n273#2:421\n254#2,6:422\n274#2:428\n267#2,4:429\n237#2,7:433\n248#2,3:441\n251#2,2:445\n272#2,2:447\n254#2,6:449\n274#2:455\n1810#3:166\n1672#3:170\n1810#3:303\n1672#3:307\n1810#3:440\n1672#3:444\n96#4:174\n96#4:311\n303#5:175\n432#5,6:176\n442#5,2:183\n444#5,8:188\n452#5,9:199\n461#5,8:211\n304#5:219\n137#5:220\n138#5,8:222\n146#5,9:231\n432#5,37:240\n155#5,6:277\n305#5:283\n303#5:312\n432#5,6:313\n442#5,2:320\n444#5,8:325\n452#5,9:336\n461#5,8:348\n304#5:356\n137#5:357\n138#5,8:359\n146#5,9:368\n432#5,37:377\n155#5,6:414\n305#5:420\n249#6:182\n249#6:319\n245#7,3:185\n248#7,3:208\n245#7,3:322\n248#7,3:345\n1208#8:196\n1187#8,2:197\n1208#8:333\n1187#8,2:334\n1#9:221\n1#9:358\n48#10:230\n48#10:367\n42#11,7:456\n42#11,7:463\n42#11,7:470\n*S KotlinDebug\n*F\n+ 1 FocusInvalidationManager.kt\nandroidx/compose/ui/focus/FocusInvalidationManager\n*L\n70#1:155,4\n70#1:159,7\n70#1:167,3\n70#1:171,2\n70#1:173\n70#1:284\n70#1:285,6\n70#1:291\n82#1:292,4\n82#1:296,7\n82#1:304,3\n82#1:308,2\n82#1:310\n82#1:421\n82#1:422,6\n82#1:428\n130#1:429,4\n130#1:433,7\n130#1:441,3\n130#1:445,2\n130#1:447,2\n130#1:449,6\n130#1:455\n70#1:166\n70#1:170\n82#1:303\n82#1:307\n130#1:440\n130#1:444\n75#1:174\n96#1:311\n75#1:175\n75#1:176,6\n75#1:183,2\n75#1:188,8\n75#1:199,9\n75#1:211,8\n75#1:219\n75#1:220\n75#1:222,8\n75#1:231,9\n75#1:240,37\n75#1:277,6\n75#1:283\n96#1:312\n96#1:313,6\n96#1:320,2\n96#1:325,8\n96#1:336,9\n96#1:348,8\n96#1:356\n96#1:357\n96#1:359,8\n96#1:368,9\n96#1:377,37\n96#1:414,6\n96#1:420\n75#1:182\n96#1:319\n75#1:185,3\n75#1:208,3\n96#1:322,3\n96#1:345,3\n75#1:196\n75#1:197,2\n96#1:333\n96#1:334,2\n75#1:221\n96#1:358\n75#1:230\n96#1:367\n149#1:456,7\n150#1:463,7\n151#1:470,7\n*E\n"})
public final class FocusInvalidationManager {
    public static final int $stable = 8;

    @NotNull
    private final Function0<Unit> invalidateOwnerFocusState;

    @NotNull
    private final Function1<Function0<Unit>, Unit> onRequestApplyChangesListener;

    @NotNull
    private final MutableScatterSet<FocusTargetNode> focusTargetNodes = ScatterSetKt.mutableScatterSetOf();

    @NotNull
    private final MutableScatterSet<FocusEventModifierNode> focusEventNodes = ScatterSetKt.mutableScatterSetOf();

    @NotNull
    private final MutableScatterSet<FocusPropertiesModifierNode> focusPropertiesNodes = ScatterSetKt.mutableScatterSetOf();

    @NotNull
    private final MutableScatterSet<FocusTargetNode> focusTargetsWithInvalidatedFocusEvents = ScatterSetKt.mutableScatterSetOf();

    /* JADX INFO: renamed from: androidx.compose.ui.focus.FocusInvalidationManager$scheduleInvalidation$1 */
    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13887k = 3, m13888mv = {1, 8, 0}, m13890xi = 48)
    public /* synthetic */ class C20371 extends FunctionReferenceImpl implements Function0<Unit> {
        public C20371(Object obj) {
            super(0, obj, FocusInvalidationManager.class, "invalidateNodes", "invalidateNodes()V", 0);
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Unit invoke() {
            invoke2();
            return Unit.INSTANCE;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2() {
            ((FocusInvalidationManager) this.receiver).invalidateNodes();
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public FocusInvalidationManager(@NotNull Function1<? super Function0<Unit>, Unit> function1, @NotNull Function0<Unit> function0) {
        this.onRequestApplyChangesListener = function1;
        this.invalidateOwnerFocusState = function0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:85:0x018a  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void invalidateNodes() {
        char c;
        long j;
        long j2;
        int i;
        long[] jArr;
        Object[] objArr;
        long[] jArr2;
        Object[] objArr2;
        long j3;
        int i2;
        FocusState focusState;
        MutableVector mutableVector;
        int i4;
        MutableVector mutableVector2;
        int i5;
        Object[] objArr3;
        long j5;
        long j6;
        int i6;
        MutableVector mutableVector3;
        long[] jArr3;
        long[] jArr4;
        char c2;
        int i7;
        long[] jArr5;
        int i8;
        long[] jArr6;
        MutableVector mutableVector4;
        MutableScatterSet<FocusPropertiesModifierNode> mutableScatterSet = this.focusPropertiesNodes;
        Object[] objArr4 = mutableScatterSet.elements;
        long[] jArr7 = mutableScatterSet.metadata;
        int length = jArr7.length - 2;
        char c4 = 7;
        int i9 = 16;
        int i10 = 8;
        int i11 = 1;
        int i12 = 0;
        if (length >= 0) {
            int i13 = 0;
            j = 255;
            while (true) {
                long j7 = jArr7[i13];
                j2 = -9187201950435737472L;
                if ((((~j7) << c4) & j7 & (-9187201950435737472L)) != -9187201950435737472L) {
                    int i14 = 8 - ((~(i13 - length)) >>> 31);
                    int i15 = i12;
                    while (i15 < i14) {
                        if ((j7 & 255) < 128) {
                            FocusPropertiesModifierNode focusPropertiesModifierNode = (FocusPropertiesModifierNode) objArr4[(i13 << 3) + i15];
                            if (focusPropertiesModifierNode.getNode().getIsAttached()) {
                                int iM20090constructorimpl = NodeKind.m20090constructorimpl(1024);
                                c2 = c4;
                                Modifier.Node node = focusPropertiesModifierNode.getNode();
                                MutableVector mutableVector5 = null;
                                while (node != null) {
                                    if (node instanceof FocusTargetNode) {
                                        this.focusTargetNodes.add((FocusTargetNode) node);
                                    } else if ((node.getKindSet() & iM20090constructorimpl) != 0 && (node instanceof DelegatingNode)) {
                                        Modifier.Node delegate = ((DelegatingNode) node).getDelegate();
                                        i8 = i10;
                                        int i16 = i12;
                                        while (delegate != null) {
                                            if ((delegate.getKindSet() & iM20090constructorimpl) != 0) {
                                                i16++;
                                                if (i16 == i11) {
                                                    jArr6 = jArr7;
                                                    node = delegate;
                                                } else {
                                                    if (mutableVector5 == null) {
                                                        jArr6 = jArr7;
                                                        mutableVector4 = new MutableVector(new Modifier.Node[i9], i12);
                                                    } else {
                                                        jArr6 = jArr7;
                                                        mutableVector4 = mutableVector5;
                                                    }
                                                    if (node != null) {
                                                        mutableVector4.add(node);
                                                        node = null;
                                                    }
                                                    mutableVector4.add(delegate);
                                                    mutableVector5 = mutableVector4;
                                                }
                                            } else {
                                                jArr6 = jArr7;
                                            }
                                            delegate = delegate.getChild();
                                            jArr7 = jArr6;
                                            i11 = 1;
                                        }
                                        jArr5 = jArr7;
                                        int i17 = i11;
                                        if (i16 == i17) {
                                            i11 = i17;
                                            i10 = i8;
                                            jArr7 = jArr5;
                                        } else {
                                            node = DelegatableNodeKt.pop(mutableVector5);
                                            i10 = i8;
                                            jArr7 = jArr5;
                                            i11 = 1;
                                        }
                                    }
                                    jArr5 = jArr7;
                                    i8 = i10;
                                    node = DelegatableNodeKt.pop(mutableVector5);
                                    i10 = i8;
                                    jArr7 = jArr5;
                                    i11 = 1;
                                }
                                jArr4 = jArr7;
                                i7 = i10;
                                if (!focusPropertiesModifierNode.getNode().getIsAttached()) {
                                    throw new IllegalStateException("visitChildren called on an unattached node");
                                }
                                MutableVector mutableVector6 = new MutableVector(new Modifier.Node[i9], i12);
                                Modifier.Node child = focusPropertiesModifierNode.getNode().getChild();
                                if (child == null) {
                                    DelegatableNodeKt.addLayoutNodeChildren(mutableVector6, focusPropertiesModifierNode.getNode());
                                } else {
                                    mutableVector6.add(child);
                                }
                                while (mutableVector6.isNotEmpty()) {
                                    Modifier.Node nodePop = (Modifier.Node) AbstractC1974b.m1314g(mutableVector6, 1);
                                    if ((nodePop.getAggregateChildKindSet() & iM20090constructorimpl) == 0) {
                                        DelegatableNodeKt.addLayoutNodeChildren(mutableVector6, nodePop);
                                    } else {
                                        while (true) {
                                            if (nodePop == null) {
                                                break;
                                            }
                                            if ((nodePop.getKindSet() & iM20090constructorimpl) != 0) {
                                                MutableVector mutableVector7 = null;
                                                while (nodePop != null) {
                                                    if (nodePop instanceof FocusTargetNode) {
                                                        this.focusTargetNodes.add((FocusTargetNode) nodePop);
                                                    } else {
                                                        if ((nodePop.getKindSet() & iM20090constructorimpl) != 0 && (nodePop instanceof DelegatingNode)) {
                                                            Modifier.Node delegate2 = ((DelegatingNode) nodePop).getDelegate();
                                                            int i18 = i12;
                                                            while (delegate2 != null) {
                                                                if ((delegate2.getKindSet() & iM20090constructorimpl) != 0) {
                                                                    i18++;
                                                                    if (i18 == 1) {
                                                                        nodePop = delegate2;
                                                                    } else {
                                                                        if (mutableVector7 == null) {
                                                                            mutableVector7 = new MutableVector(new Modifier.Node[i9], 0);
                                                                        }
                                                                        if (nodePop != null) {
                                                                            mutableVector7.add(nodePop);
                                                                            nodePop = null;
                                                                        }
                                                                        mutableVector7.add(delegate2);
                                                                    }
                                                                }
                                                                delegate2 = delegate2.getChild();
                                                                i9 = 16;
                                                            }
                                                            if (i18 == 1) {
                                                            }
                                                        }
                                                        i12 = 0;
                                                        i9 = 16;
                                                    }
                                                    nodePop = DelegatableNodeKt.pop(mutableVector7);
                                                    i12 = 0;
                                                    i9 = 16;
                                                }
                                            } else {
                                                nodePop = nodePop.getChild();
                                                i12 = 0;
                                                i9 = 16;
                                            }
                                        }
                                    }
                                }
                            } else {
                                jArr4 = jArr7;
                                c2 = c4;
                                i7 = i10;
                            }
                        }
                        j7 >>= i7;
                        i15++;
                        c4 = c2;
                        i10 = i7;
                        jArr7 = jArr4;
                        i11 = 1;
                        i12 = 0;
                        i9 = 16;
                    }
                    jArr3 = jArr7;
                    c = c4;
                    if (i14 != i10) {
                        break;
                    }
                } else {
                    jArr3 = jArr7;
                    c = c4;
                }
                if (i13 == length) {
                    break;
                }
                i13++;
                c4 = c;
                jArr7 = jArr3;
                i11 = 1;
                i12 = 0;
                i9 = 16;
                i10 = 8;
            }
        } else {
            c = 7;
            j = 255;
            j2 = -9187201950435737472L;
        }
        this.focusPropertiesNodes.clear();
        MutableScatterSet<FocusEventModifierNode> mutableScatterSet2 = this.focusEventNodes;
        Object[] objArr5 = mutableScatterSet2.elements;
        long[] jArr8 = mutableScatterSet2.metadata;
        int length2 = jArr8.length - 2;
        if (length2 >= 0) {
            int i19 = 0;
            while (true) {
                long j8 = jArr8[i19];
                if ((((~j8) << c) & j8 & j2) != j2) {
                    int i20 = 8 - ((~(i19 - length2)) >>> 31);
                    int i21 = 0;
                    while (i21 < i20) {
                        if ((j8 & j) < 128) {
                            FocusEventModifierNode focusEventModifierNode = (FocusEventModifierNode) objArr5[(i19 << 3) + i21];
                            if (focusEventModifierNode.getNode().getIsAttached()) {
                                int iM20090constructorimpl2 = NodeKind.m20090constructorimpl(1024);
                                Modifier.Node node2 = focusEventModifierNode.getNode();
                                boolean z = false;
                                boolean z2 = true;
                                FocusTargetNode focusTargetNode = null;
                                MutableVector mutableVector8 = null;
                                while (node2 != null) {
                                    long[] jArr9 = jArr8;
                                    if (node2 instanceof FocusTargetNode) {
                                        FocusTargetNode focusTargetNode2 = (FocusTargetNode) node2;
                                        if (focusTargetNode != null) {
                                            z = true;
                                        }
                                        if (this.focusTargetNodes.contains(focusTargetNode2)) {
                                            this.focusTargetsWithInvalidatedFocusEvents.add(focusTargetNode2);
                                            z2 = false;
                                        }
                                        objArr3 = objArr5;
                                        j5 = j8;
                                        focusTargetNode = focusTargetNode2;
                                    } else if ((node2.getKindSet() & iM20090constructorimpl2) == 0 || !(node2 instanceof DelegatingNode)) {
                                        objArr3 = objArr5;
                                        j5 = j8;
                                    } else {
                                        Modifier.Node delegate3 = ((DelegatingNode) node2).getDelegate();
                                        objArr3 = objArr5;
                                        int i22 = 0;
                                        while (delegate3 != null) {
                                            if ((delegate3.getKindSet() & iM20090constructorimpl2) != 0) {
                                                i22++;
                                                j6 = j8;
                                                if (i22 == 1) {
                                                    node2 = delegate3;
                                                } else {
                                                    if (mutableVector8 == null) {
                                                        i6 = i22;
                                                        mutableVector3 = new MutableVector(new Modifier.Node[16], 0);
                                                    } else {
                                                        i6 = i22;
                                                        mutableVector3 = mutableVector8;
                                                    }
                                                    if (node2 != null) {
                                                        mutableVector3.add(node2);
                                                        node2 = null;
                                                    }
                                                    mutableVector3.add(delegate3);
                                                    mutableVector8 = mutableVector3;
                                                    i22 = i6;
                                                }
                                            } else {
                                                j6 = j8;
                                            }
                                            delegate3 = delegate3.getChild();
                                            j8 = j6;
                                        }
                                        j5 = j8;
                                        if (i22 == 1) {
                                        }
                                        jArr8 = jArr9;
                                        objArr5 = objArr3;
                                        j8 = j5;
                                    }
                                    node2 = DelegatableNodeKt.pop(mutableVector8);
                                    jArr8 = jArr9;
                                    objArr5 = objArr3;
                                    j8 = j5;
                                }
                                jArr2 = jArr8;
                                objArr2 = objArr5;
                                j3 = j8;
                                if (!focusEventModifierNode.getNode().getIsAttached()) {
                                    throw new IllegalStateException("visitChildren called on an unattached node");
                                }
                                MutableVector mutableVector9 = new MutableVector(new Modifier.Node[16], 0);
                                Modifier.Node child2 = focusEventModifierNode.getNode().getChild();
                                if (child2 == null) {
                                    DelegatableNodeKt.addLayoutNodeChildren(mutableVector9, focusEventModifierNode.getNode());
                                } else {
                                    mutableVector9.add(child2);
                                }
                                while (mutableVector9.isNotEmpty()) {
                                    Modifier.Node nodePop2 = (Modifier.Node) AbstractC1974b.m1314g(mutableVector9, 1);
                                    if ((nodePop2.getAggregateChildKindSet() & iM20090constructorimpl2) == 0) {
                                        DelegatableNodeKt.addLayoutNodeChildren(mutableVector9, nodePop2);
                                    } else {
                                        while (nodePop2 != null) {
                                            if ((nodePop2.getKindSet() & iM20090constructorimpl2) != 0) {
                                                MutableVector mutableVector10 = null;
                                                while (nodePop2 != null) {
                                                    if (nodePop2 instanceof FocusTargetNode) {
                                                        FocusTargetNode focusTargetNode3 = (FocusTargetNode) nodePop2;
                                                        if (focusTargetNode != null) {
                                                            z = true;
                                                        }
                                                        if (this.focusTargetNodes.contains(focusTargetNode3)) {
                                                            this.focusTargetsWithInvalidatedFocusEvents.add(focusTargetNode3);
                                                            z2 = false;
                                                        }
                                                        mutableVector = mutableVector9;
                                                        focusTargetNode = focusTargetNode3;
                                                    } else if ((nodePop2.getKindSet() & iM20090constructorimpl2) == 0 || !(nodePop2 instanceof DelegatingNode)) {
                                                        mutableVector = mutableVector9;
                                                    } else {
                                                        Modifier.Node delegate4 = ((DelegatingNode) nodePop2).getDelegate();
                                                        int i23 = 0;
                                                        while (delegate4 != null) {
                                                            if ((delegate4.getKindSet() & iM20090constructorimpl2) != 0) {
                                                                i23++;
                                                                mutableVector2 = mutableVector9;
                                                                if (i23 == 1) {
                                                                    nodePop2 = delegate4;
                                                                } else {
                                                                    if (mutableVector10 == null) {
                                                                        i5 = i21;
                                                                        mutableVector10 = new MutableVector(new Modifier.Node[16], 0);
                                                                    } else {
                                                                        i5 = i21;
                                                                    }
                                                                    if (nodePop2 != null) {
                                                                        mutableVector10.add(nodePop2);
                                                                        nodePop2 = null;
                                                                    }
                                                                    mutableVector10.add(delegate4);
                                                                    delegate4 = delegate4.getChild();
                                                                    mutableVector9 = mutableVector2;
                                                                    i21 = i5;
                                                                }
                                                            } else {
                                                                mutableVector2 = mutableVector9;
                                                            }
                                                            i5 = i21;
                                                            delegate4 = delegate4.getChild();
                                                            mutableVector9 = mutableVector2;
                                                            i21 = i5;
                                                        }
                                                        mutableVector = mutableVector9;
                                                        i4 = i21;
                                                        if (i23 != 1) {
                                                            nodePop2 = DelegatableNodeKt.pop(mutableVector10);
                                                        }
                                                        mutableVector9 = mutableVector;
                                                        i21 = i4;
                                                    }
                                                    i4 = i21;
                                                    nodePop2 = DelegatableNodeKt.pop(mutableVector10);
                                                    mutableVector9 = mutableVector;
                                                    i21 = i4;
                                                }
                                            } else {
                                                nodePop2 = nodePop2.getChild();
                                                mutableVector9 = mutableVector9;
                                            }
                                        }
                                    }
                                    mutableVector9 = mutableVector9;
                                    i21 = i21;
                                }
                                i2 = i21;
                                if (z2) {
                                    if (z) {
                                        focusState = FocusEventModifierNodeKt.getFocusState(focusEventModifierNode);
                                    } else if (focusTargetNode == null || (focusState = focusTargetNode.getFocusState()) == null) {
                                        focusState = FocusStateImpl.Inactive;
                                    }
                                    focusEventModifierNode.onFocusEvent(focusState);
                                }
                            } else {
                                focusEventModifierNode.onFocusEvent(FocusStateImpl.Inactive);
                                jArr2 = jArr8;
                                objArr2 = objArr5;
                                j3 = j8;
                                i2 = i21;
                            }
                        } else {
                            jArr2 = jArr8;
                            objArr2 = objArr5;
                            j3 = j8;
                            i2 = i21;
                        }
                        i21 = i2 + 1;
                        j8 = j3 >> 8;
                        jArr8 = jArr2;
                        objArr5 = objArr2;
                    }
                    jArr = jArr8;
                    objArr = objArr5;
                    i = 0;
                    if (i20 != 8) {
                        break;
                    }
                } else {
                    jArr = jArr8;
                    objArr = objArr5;
                    i = 0;
                }
                if (i19 == length2) {
                    break;
                }
                i19++;
                jArr8 = jArr;
                objArr5 = objArr;
            }
        } else {
            i = 0;
        }
        this.focusEventNodes.clear();
        MutableScatterSet<FocusTargetNode> mutableScatterSet3 = this.focusTargetNodes;
        Object[] objArr6 = mutableScatterSet3.elements;
        long[] jArr10 = mutableScatterSet3.metadata;
        int length3 = jArr10.length - 2;
        if (length3 >= 0) {
            int i24 = i;
            while (true) {
                long j9 = jArr10[i24];
                if ((((~j9) << c) & j9 & j2) != j2) {
                    int i25 = 8 - ((~(i24 - length3)) >>> 31);
                    for (int i26 = i; i26 < i25; i26++) {
                        if ((j9 & j) < 128) {
                            FocusTargetNode focusTargetNode4 = (FocusTargetNode) objArr6[(i24 << 3) + i26];
                            if (focusTargetNode4.getIsAttached()) {
                                FocusStateImpl focusState2 = focusTargetNode4.getFocusState();
                                focusTargetNode4.invalidateFocus$ui_release();
                                if (focusState2 != focusTargetNode4.getFocusState() || this.focusTargetsWithInvalidatedFocusEvents.contains(focusTargetNode4)) {
                                    FocusEventModifierNodeKt.refreshFocusEventNodes(focusTargetNode4);
                                }
                            }
                        }
                        j9 >>= 8;
                    }
                    if (i25 != 8) {
                        break;
                    }
                }
                if (i24 == length3) {
                    break;
                } else {
                    i24++;
                }
            }
        }
        this.focusTargetNodes.clear();
        this.focusTargetsWithInvalidatedFocusEvents.clear();
        this.invalidateOwnerFocusState.invoke();
        if (!this.focusPropertiesNodes.isEmpty()) {
            InlineClassHelperKt.throwIllegalStateException("Unprocessed FocusProperties nodes");
        }
        if (!this.focusEventNodes.isEmpty()) {
            InlineClassHelperKt.throwIllegalStateException("Unprocessed FocusEvent nodes");
        }
        if (this.focusTargetNodes.isEmpty()) {
            return;
        }
        InlineClassHelperKt.throwIllegalStateException("Unprocessed FocusTarget nodes");
    }

    public final boolean hasPendingInvalidation() {
        return this.focusTargetNodes.isNotEmpty() || this.focusPropertiesNodes.isNotEmpty() || this.focusEventNodes.isNotEmpty();
    }

    public final void scheduleInvalidation(@NotNull FocusTargetNode node) {
        scheduleInvalidation(this.focusTargetNodes, node);
    }

    public final void scheduleInvalidation(@NotNull FocusEventModifierNode node) {
        scheduleInvalidation(this.focusEventNodes, node);
    }

    public final void scheduleInvalidation(@NotNull FocusPropertiesModifierNode node) {
        scheduleInvalidation(this.focusPropertiesNodes, node);
    }

    private final <T> void scheduleInvalidation(MutableScatterSet<T> mutableScatterSet, T t) {
        if (mutableScatterSet.add(t)) {
            if (this.focusPropertiesNodes.get_size() + this.focusEventNodes.get_size() + this.focusTargetNodes.get_size() == 1) {
                this.onRequestApplyChangesListener.invoke(new C20371(this));
            }
        }
    }
}
