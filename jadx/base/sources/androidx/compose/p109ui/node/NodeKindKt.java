package androidx.compose.p109ui.node;

import androidx.collection.MutableObjectIntMap;
import androidx.collection.ObjectIntMapKt;
import androidx.compose.p109ui.Actual_jvmKt;
import androidx.compose.p109ui.Modifier;
import androidx.compose.p109ui.draw.DrawModifier;
import androidx.compose.p109ui.focus.FocusEventModifier;
import androidx.compose.p109ui.focus.FocusEventModifierNode;
import androidx.compose.p109ui.focus.FocusEventModifierNodeKt;
import androidx.compose.p109ui.focus.FocusOrderModifier;
import androidx.compose.p109ui.focus.FocusPropertiesModifierNode;
import androidx.compose.p109ui.focus.FocusPropertiesModifierNodeKt;
import androidx.compose.p109ui.focus.FocusTargetNode;
import androidx.compose.p109ui.focus.FocusTargetNodeKt;
import androidx.compose.p109ui.input.key.KeyInputModifierNode;
import androidx.compose.p109ui.input.key.SoftKeyboardInterceptionModifierNode;
import androidx.compose.p109ui.input.pointer.PointerInputModifier;
import androidx.compose.p109ui.input.rotary.RotaryInputModifierNode;
import androidx.compose.p109ui.internal.InlineClassHelperKt;
import androidx.compose.p109ui.layout.ApproachLayoutModifierNode;
import androidx.compose.p109ui.layout.LayoutModifier;
import androidx.compose.p109ui.layout.OnGloballyPositionedModifier;
import androidx.compose.p109ui.layout.OnPlacedModifier;
import androidx.compose.p109ui.layout.OnRemeasuredModifier;
import androidx.compose.p109ui.layout.ParentDataModifier;
import androidx.compose.p109ui.modifier.ModifierLocalConsumer;
import androidx.compose.p109ui.modifier.ModifierLocalModifierNode;
import androidx.compose.p109ui.modifier.ModifierLocalProvider;
import androidx.compose.p109ui.semantics.SemanticsModifier;
import androidx.compose.runtime.AbstractC1974b;
import androidx.compose.runtime.collection.MutableVector;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import kotlin.Metadata;
import kotlin.jvm.internal.SourceDebugExtension;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes.dex */
@Metadata(m13885d1 = {"\u0000>\n\u0000\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\u0010\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u0013H\u0000\u001a \u0010\u0014\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0015\u001a\u00020\u00012\u0006\u0010\u0016\u001a\u00020\u0001H\u0000\u001a \u0010\u0017\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0018\u001a\u00020\u00012\u0006\u0010\u0016\u001a\u00020\u0001H\u0002\u001a\u0010\u0010\u0019\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u0013H\u0000\u001a\u0010\u0010\u001a\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u0013H\u0000\u001a\u0010\u0010\u001b\u001a\u00020\u00012\u0006\u0010\u001c\u001a\u00020\u001dH\u0000\u001a\u0010\u0010\u001b\u001a\u00020\u00012\u0006\u0010\u0012\u001a\u00020\u0013H\u0000\u001a\u0010\u0010\u001e\u001a\u00020\u00012\u0006\u0010\u0012\u001a\u00020\u0013H\u0000\u001a#\u0010\u001f\u001a\u00020\f*\u00020\u00012\n\u0010 \u001a\u0006\u0012\u0002\b\u00030\rH\u0080\nø\u0001\u0000¢\u0006\u0004\b!\u0010\"\u001a#\u0010#\u001a\u00020\u0001*\u00020\u00012\n\u0010$\u001a\u0006\u0012\u0002\b\u00030\rH\u0080\fø\u0001\u0000¢\u0006\u0004\b%\u0010&\u001a\f\u0010'\u001a\u00020\u0011*\u00020(H\u0002\u001a\f\u0010)\u001a\u00020\f*\u00020(H\u0002\"\u0014\u0010\u0000\u001a\u00020\u0001X\u0082T¢\u0006\b\n\u0000\u0012\u0004\b\u0002\u0010\u0003\"\u0014\u0010\u0004\u001a\u00020\u0001X\u0082T¢\u0006\b\n\u0000\u0012\u0004\b\u0005\u0010\u0003\"\u0014\u0010\u0006\u001a\u00020\u0001X\u0082T¢\u0006\b\n\u0000\u0012\u0004\b\u0007\u0010\u0003\"\u0014\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\tX\u0082\u0004¢\u0006\u0002\n\u0000\"\u001c\u0010\u000b\u001a\u00020\f*\u0006\u0012\u0002\b\u00030\r8@X\u0080\u0004¢\u0006\u0006\u001a\u0004\b\u000e\u0010\u000f\u0082\u0002\u0007\n\u0005\b¡\u001e0\u0001¨\u0006*"}, m13886d2 = {"Inserted", "", "getInserted$annotations", "()V", "Removed", "getRemoved$annotations", "Updated", "getUpdated$annotations", "classToKindSetMap", "Landroidx/collection/MutableObjectIntMap;", "", "includeSelfInTraversal", "", "Landroidx/compose/ui/node/NodeKind;", "getIncludeSelfInTraversal-H91voCI", "(I)Z", "autoInvalidateInsertedNode", "", "node", "Landroidx/compose/ui/Modifier$Node;", "autoInvalidateNodeIncludingDelegates", "remainingSet", TypedValues.Cycle.S_WAVE_PHASE, "autoInvalidateNodeSelf", "selfKindSet", "autoInvalidateRemovedNode", "autoInvalidateUpdatedNode", "calculateNodeKindSetFrom", "element", "Landroidx/compose/ui/Modifier$Element;", "calculateNodeKindSetFromIncludingDelegates", "contains", "value", "contains-64DMado", "(II)Z", "or", "other", "or-64DMado", "(II)I", "scheduleInvalidationOfAssociatedFocusTargets", "Landroidx/compose/ui/focus/FocusPropertiesModifierNode;", "specifiesCanFocusProperty", "ui_release"}, m13887k = 2, m13888mv = {1, 8, 0}, m13890xi = 48)
@SourceDebugExtension({"SMAP\nNodeKind.kt\nKotlin\n*S Kotlin\n*F\n+ 1 NodeKind.kt\nandroidx/compose/ui/node/NodeKindKt\n+ 2 NodeKind.kt\nandroidx/compose/ui/node/Nodes\n+ 3 ObjectIntMap.kt\nandroidx/collection/MutableObjectIntMap\n+ 4 InlineClassHelper.kt\nandroidx/compose/ui/internal/InlineClassHelperKt\n+ 5 DelegatingNode.kt\nandroidx/compose/ui/node/DelegatingNode\n+ 6 DelegatableNode.kt\nandroidx/compose/ui/node/DelegatableNodeKt\n+ 7 fake.kt\nkotlin/jvm/internal/FakeKt\n+ 8 MutableVector.kt\nandroidx/compose/runtime/collection/MutableVectorKt\n+ 9 MutableVector.kt\nandroidx/compose/runtime/collection/MutableVector\n+ 10 Modifier.kt\nandroidx/compose/ui/Modifier$Node\n*L\n1#1,359:1\n58#1:363\n58#1:365\n58#1:367\n58#1:369\n58#1:371\n58#1:373\n58#1:375\n58#1:377\n58#1:379\n58#1:381\n58#1:389\n58#1:391\n58#1:393\n58#1:395\n58#1:397\n58#1:399\n58#1:401\n58#1:403\n58#1:405\n58#1:407\n58#1:409\n58#1:411\n58#1:413\n58#1:415\n58#1:417\n58#1:419\n58#1:421\n61#1:452\n61#1:455\n61#1:457\n61#1:459\n61#1:461\n61#1:463\n61#1:465\n61#1:467\n61#1:469\n90#2:360\n76#2:361\n78#2:362\n80#2:364\n82#2:366\n84#2:368\n86#2:370\n100#2:372\n98#2:374\n92#2:376\n88#2:378\n90#2:380\n76#2:387\n78#2:388\n80#2:390\n82#2:392\n84#2:394\n86#2:396\n88#2:398\n90#2:400\n92#2:402\n94#2:404\n96#2:406\n98#2:408\n100#2:410\n102#2:412\n104#2:414\n107#2:416\n110#2:418\n112#2:420\n78#2:451\n78#2:453\n90#2:454\n92#2:456\n80#2:458\n82#2:460\n88#2:462\n96#2:464\n98#2:466\n100#2:468\n96#2:470\n743#3,5:382\n748#3,2:422\n42#4,7:424\n42#4,7:431\n42#4,7:438\n245#5,6:445\n245#5,3:504\n248#5,3:524\n245#5,6:541\n297#6:471\n137#6:472\n138#6:474\n139#6,7:478\n146#6,9:486\n432#6,6:495\n442#6,2:502\n444#6,17:507\n461#6,8:527\n155#6,6:535\n1#7:473\n1208#8:475\n1187#8,2:476\n48#9:485\n249#10:501\n*S KotlinDebug\n*F\n+ 1 NodeKind.kt\nandroidx/compose/ui/node/NodeKindKt\n*L\n119#1:363\n122#1:365\n125#1:367\n128#1:369\n134#1:371\n138#1:373\n142#1:375\n145#1:377\n148#1:379\n154#1:381\n169#1:389\n172#1:391\n175#1:393\n178#1:395\n181#1:397\n184#1:399\n187#1:401\n190#1:403\n193#1:405\n196#1:407\n199#1:409\n202#1:411\n205#1:413\n208#1:415\n211#1:417\n214#1:419\n217#1:421\n266#1:452\n273#1:455\n280#1:457\n287#1:459\n290#1:461\n293#1:463\n296#1:465\n302#1:467\n311#1:469\n68#1:360\n117#1:361\n119#1:362\n122#1:364\n125#1:366\n128#1:368\n134#1:370\n138#1:372\n142#1:374\n145#1:376\n148#1:378\n154#1:380\n167#1:387\n169#1:388\n172#1:390\n175#1:392\n178#1:394\n181#1:396\n184#1:398\n187#1:400\n190#1:402\n193#1:404\n196#1:406\n199#1:408\n202#1:410\n205#1:412\n208#1:414\n211#1:416\n214#1:418\n217#1:420\n266#1:451\n269#1:453\n273#1:454\n280#1:456\n287#1:458\n290#1:460\n293#1:462\n296#1:464\n302#1:466\n311#1:468\n317#1:470\n166#1:382,5\n166#1:422,2\n231#1:424,7\n236#1:431,7\n241#1:438,7\n253#1:445,6\n317#1:504,3\n317#1:524,3\n351#1:541,6\n317#1:471\n317#1:472\n317#1:474\n317#1:478,7\n317#1:486,9\n317#1:495,6\n317#1:502,2\n317#1:507,17\n317#1:527,8\n317#1:535,6\n317#1:473\n317#1:475\n317#1:476,2\n317#1:485\n317#1:501\n*E\n"})
public final class NodeKindKt {
    private static final int Inserted = 1;
    private static final int Removed = 2;
    private static final int Updated = 0;

    @NotNull
    private static final MutableObjectIntMap<Object> classToKindSetMap = ObjectIntMapKt.mutableObjectIntMapOf();

    public static final void autoInvalidateInsertedNode(@NotNull Modifier.Node node) {
        if (!node.getIsAttached()) {
            InlineClassHelperKt.throwIllegalStateException("autoInvalidateInsertedNode called on unattached node");
        }
        autoInvalidateNodeIncludingDelegates(node, -1, 1);
    }

    public static final void autoInvalidateNodeIncludingDelegates(@NotNull Modifier.Node node, int i, int i2) {
        if (!(node instanceof DelegatingNode)) {
            autoInvalidateNodeSelf(node, i & node.getKindSet(), i2);
            return;
        }
        DelegatingNode delegatingNode = (DelegatingNode) node;
        autoInvalidateNodeSelf(node, delegatingNode.getSelfKindSet() & i, i2);
        int i4 = (~delegatingNode.getSelfKindSet()) & i;
        for (Modifier.Node delegate$ui_release = delegatingNode.getDelegate(); delegate$ui_release != null; delegate$ui_release = delegate$ui_release.getChild()) {
            autoInvalidateNodeIncludingDelegates(delegate$ui_release, i4, i2);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    private static final void autoInvalidateNodeSelf(Modifier.Node node, int i, int i2) {
        if (i2 != 0 || node.getShouldAutoInvalidate()) {
            if ((NodeKind.m20090constructorimpl(2) & i) != 0 && (node instanceof LayoutModifierNode)) {
                LayoutModifierNodeKt.invalidateMeasurement((LayoutModifierNode) node);
                if (i2 == 2) {
                    DelegatableNodeKt.m19977requireCoordinator64DMado(node, NodeKind.m20090constructorimpl(2)).onRelease();
                }
            }
            if ((NodeKind.m20090constructorimpl(128) & i) != 0 && (node instanceof LayoutAwareModifierNode) && i2 != 2) {
                DelegatableNodeKt.requireLayoutNode(node).invalidateMeasurements$ui_release();
            }
            if ((NodeKind.m20090constructorimpl(256) & i) != 0 && (node instanceof GlobalPositionAwareModifierNode) && i2 != 2) {
                DelegatableNodeKt.requireLayoutNode(node).invalidateOnPositioned$ui_release();
            }
            if ((NodeKind.m20090constructorimpl(4) & i) != 0 && (node instanceof DrawModifierNode)) {
                DrawModifierNodeKt.invalidateDraw((DrawModifierNode) node);
            }
            if ((NodeKind.m20090constructorimpl(8) & i) != 0 && (node instanceof SemanticsModifierNode)) {
                SemanticsModifierNodeKt.invalidateSemantics((SemanticsModifierNode) node);
            }
            if ((NodeKind.m20090constructorimpl(64) & i) != 0 && (node instanceof ParentDataModifierNode)) {
                ParentDataModifierNodeKt.invalidateParentData((ParentDataModifierNode) node);
            }
            if ((NodeKind.m20090constructorimpl(1024) & i) != 0 && (node instanceof FocusTargetNode) && i2 != 2) {
                FocusTargetNodeKt.invalidateFocusTarget((FocusTargetNode) node);
            }
            if ((NodeKind.m20090constructorimpl(2048) & i) != 0 && (node instanceof FocusPropertiesModifierNode)) {
                FocusPropertiesModifierNode focusPropertiesModifierNode = (FocusPropertiesModifierNode) node;
                if (specifiesCanFocusProperty(focusPropertiesModifierNode)) {
                    if (i2 == 2) {
                        scheduleInvalidationOfAssociatedFocusTargets(focusPropertiesModifierNode);
                    } else {
                        FocusPropertiesModifierNodeKt.invalidateFocusProperties(focusPropertiesModifierNode);
                    }
                }
            }
            if ((i & NodeKind.m20090constructorimpl(4096)) == 0 || !(node instanceof FocusEventModifierNode)) {
                return;
            }
            FocusEventModifierNodeKt.invalidateFocusEvent((FocusEventModifierNode) node);
        }
    }

    public static final void autoInvalidateRemovedNode(@NotNull Modifier.Node node) {
        if (!node.getIsAttached()) {
            InlineClassHelperKt.throwIllegalStateException("autoInvalidateRemovedNode called on unattached node");
        }
        autoInvalidateNodeIncludingDelegates(node, -1, 2);
    }

    public static final void autoInvalidateUpdatedNode(@NotNull Modifier.Node node) {
        if (!node.getIsAttached()) {
            InlineClassHelperKt.throwIllegalStateException("autoInvalidateUpdatedNode called on unattached node");
        }
        autoInvalidateNodeIncludingDelegates(node, -1, 0);
    }

    public static final int calculateNodeKindSetFrom(@NotNull Modifier.Node node) {
        if (node.getKindSet() != 0) {
            return node.getKindSet();
        }
        MutableObjectIntMap<Object> mutableObjectIntMap = classToKindSetMap;
        Object objClassKeyForObject = Actual_jvmKt.classKeyForObject(node);
        int iFindKeyIndex = mutableObjectIntMap.findKeyIndex(objClassKeyForObject);
        if (iFindKeyIndex >= 0) {
            return mutableObjectIntMap.values[iFindKeyIndex];
        }
        int iM20090constructorimpl = NodeKind.m20090constructorimpl(1);
        if (node instanceof LayoutModifierNode) {
            iM20090constructorimpl |= NodeKind.m20090constructorimpl(2);
        }
        if (node instanceof DrawModifierNode) {
            iM20090constructorimpl |= NodeKind.m20090constructorimpl(4);
        }
        if (node instanceof SemanticsModifierNode) {
            iM20090constructorimpl |= NodeKind.m20090constructorimpl(8);
        }
        if (node instanceof PointerInputModifierNode) {
            iM20090constructorimpl |= NodeKind.m20090constructorimpl(16);
        }
        if (node instanceof ModifierLocalModifierNode) {
            iM20090constructorimpl |= NodeKind.m20090constructorimpl(32);
        }
        if (node instanceof ParentDataModifierNode) {
            iM20090constructorimpl |= NodeKind.m20090constructorimpl(64);
        }
        if (node instanceof LayoutAwareModifierNode) {
            iM20090constructorimpl |= NodeKind.m20090constructorimpl(128);
        }
        if (node instanceof GlobalPositionAwareModifierNode) {
            iM20090constructorimpl |= NodeKind.m20090constructorimpl(256);
        }
        if (node instanceof ApproachLayoutModifierNode) {
            iM20090constructorimpl |= NodeKind.m20090constructorimpl(512);
        }
        if (node instanceof FocusTargetNode) {
            iM20090constructorimpl |= NodeKind.m20090constructorimpl(1024);
        }
        if (node instanceof FocusPropertiesModifierNode) {
            iM20090constructorimpl |= NodeKind.m20090constructorimpl(2048);
        }
        if (node instanceof FocusEventModifierNode) {
            iM20090constructorimpl |= NodeKind.m20090constructorimpl(4096);
        }
        if (node instanceof KeyInputModifierNode) {
            iM20090constructorimpl |= NodeKind.m20090constructorimpl(8192);
        }
        if (node instanceof RotaryInputModifierNode) {
            iM20090constructorimpl |= NodeKind.m20090constructorimpl(16384);
        }
        if (node instanceof CompositionLocalConsumerModifierNode) {
            iM20090constructorimpl |= NodeKind.m20090constructorimpl(32768);
        }
        if (node instanceof SoftKeyboardInterceptionModifierNode) {
            iM20090constructorimpl |= NodeKind.m20090constructorimpl(131072);
        }
        if (node instanceof TraversableNode) {
            iM20090constructorimpl |= NodeKind.m20090constructorimpl(262144);
        }
        mutableObjectIntMap.set(objClassKeyForObject, iM20090constructorimpl);
        return iM20090constructorimpl;
    }

    public static final int calculateNodeKindSetFromIncludingDelegates(@NotNull Modifier.Node node) {
        if (!(node instanceof DelegatingNode)) {
            return calculateNodeKindSetFrom(node);
        }
        DelegatingNode delegatingNode = (DelegatingNode) node;
        int selfKindSet$ui_release = delegatingNode.getSelfKindSet();
        for (Modifier.Node delegate$ui_release = delegatingNode.getDelegate(); delegate$ui_release != null; delegate$ui_release = delegate$ui_release.getChild()) {
            selfKindSet$ui_release |= calculateNodeKindSetFromIncludingDelegates(delegate$ui_release);
        }
        return selfKindSet$ui_release;
    }

    /* JADX INFO: renamed from: contains-64DMado, reason: not valid java name */
    public static final boolean m20098contains64DMado(int i, int i2) {
        return (i & i2) != 0;
    }

    /* JADX INFO: renamed from: getIncludeSelfInTraversal-H91voCI, reason: not valid java name */
    public static final boolean m20099getIncludeSelfInTraversalH91voCI(int i) {
        return (i & NodeKind.m20090constructorimpl(128)) != 0;
    }

    /* JADX INFO: renamed from: or-64DMado, reason: not valid java name */
    public static final int m20100or64DMado(int i, int i2) {
        return i | i2;
    }

    private static final void scheduleInvalidationOfAssociatedFocusTargets(FocusPropertiesModifierNode focusPropertiesModifierNode) {
        int iM20090constructorimpl = NodeKind.m20090constructorimpl(1024);
        if (!focusPropertiesModifierNode.getNode().getIsAttached()) {
            throw new IllegalStateException("visitChildren called on an unattached node");
        }
        MutableVector mutableVector = new MutableVector(new Modifier.Node[16], 0);
        Modifier.Node child = focusPropertiesModifierNode.getNode().getChild();
        if (child == null) {
            DelegatableNodeKt.addLayoutNodeChildren(mutableVector, focusPropertiesModifierNode.getNode());
        } else {
            mutableVector.add(child);
        }
        while (mutableVector.isNotEmpty()) {
            Modifier.Node nodePop = (Modifier.Node) AbstractC1974b.m1314g(mutableVector, 1);
            if ((nodePop.getAggregateChildKindSet() & iM20090constructorimpl) == 0) {
                DelegatableNodeKt.addLayoutNodeChildren(mutableVector, nodePop);
            } else {
                while (true) {
                    if (nodePop == null) {
                        break;
                    }
                    if ((nodePop.getKindSet() & iM20090constructorimpl) != 0) {
                        MutableVector mutableVector2 = null;
                        while (nodePop != null) {
                            if (nodePop instanceof FocusTargetNode) {
                                FocusTargetNodeKt.invalidateFocusTarget((FocusTargetNode) nodePop);
                            } else if ((nodePop.getKindSet() & iM20090constructorimpl) != 0 && (nodePop instanceof DelegatingNode)) {
                                int i = 0;
                                for (Modifier.Node delegate$ui_release = ((DelegatingNode) nodePop).getDelegate(); delegate$ui_release != null; delegate$ui_release = delegate$ui_release.getChild()) {
                                    if ((delegate$ui_release.getKindSet() & iM20090constructorimpl) != 0) {
                                        i++;
                                        if (i == 1) {
                                            nodePop = delegate$ui_release;
                                        } else {
                                            if (mutableVector2 == null) {
                                                mutableVector2 = new MutableVector(new Modifier.Node[16], 0);
                                            }
                                            if (nodePop != null) {
                                                mutableVector2.add(nodePop);
                                                nodePop = null;
                                            }
                                            mutableVector2.add(delegate$ui_release);
                                        }
                                    }
                                }
                                if (i == 1) {
                                }
                            }
                            nodePop = DelegatableNodeKt.pop(mutableVector2);
                        }
                    } else {
                        nodePop = nodePop.getChild();
                    }
                }
            }
        }
    }

    private static final boolean specifiesCanFocusProperty(FocusPropertiesModifierNode focusPropertiesModifierNode) {
        CanFocusChecker canFocusChecker = CanFocusChecker.INSTANCE;
        canFocusChecker.reset();
        focusPropertiesModifierNode.applyFocusProperties(canFocusChecker);
        return canFocusChecker.isCanFocusSet();
    }

    private static /* synthetic */ void getInserted$annotations() {
    }

    private static /* synthetic */ void getRemoved$annotations() {
    }

    private static /* synthetic */ void getUpdated$annotations() {
    }

    public static final int calculateNodeKindSetFrom(@NotNull Modifier.Element element) {
        int iM20090constructorimpl = NodeKind.m20090constructorimpl(1);
        if (element instanceof LayoutModifier) {
            iM20090constructorimpl |= NodeKind.m20090constructorimpl(2);
        }
        if (element instanceof DrawModifier) {
            iM20090constructorimpl |= NodeKind.m20090constructorimpl(4);
        }
        if (element instanceof SemanticsModifier) {
            iM20090constructorimpl |= NodeKind.m20090constructorimpl(8);
        }
        if (element instanceof PointerInputModifier) {
            iM20090constructorimpl |= NodeKind.m20090constructorimpl(16);
        }
        if ((element instanceof ModifierLocalConsumer) || (element instanceof ModifierLocalProvider)) {
            iM20090constructorimpl |= NodeKind.m20090constructorimpl(32);
        }
        if (element instanceof FocusEventModifier) {
            iM20090constructorimpl |= NodeKind.m20090constructorimpl(4096);
        }
        if (element instanceof FocusOrderModifier) {
            iM20090constructorimpl |= NodeKind.m20090constructorimpl(2048);
        }
        if (element instanceof OnGloballyPositionedModifier) {
            iM20090constructorimpl |= NodeKind.m20090constructorimpl(256);
        }
        if (element instanceof ParentDataModifier) {
            iM20090constructorimpl |= NodeKind.m20090constructorimpl(64);
        }
        return ((element instanceof OnPlacedModifier) || (element instanceof OnRemeasuredModifier)) ? NodeKind.m20090constructorimpl(128) | iM20090constructorimpl : iM20090constructorimpl;
    }
}
