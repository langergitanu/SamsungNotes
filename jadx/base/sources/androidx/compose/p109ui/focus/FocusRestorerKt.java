package androidx.compose.p109ui.focus;

import androidx.compose.p109ui.ExperimentalComposeUiApi;
import androidx.compose.p109ui.Modifier;
import androidx.compose.p109ui.layout.PinnableContainer;
import androidx.compose.p109ui.layout.PinnableContainerKt;
import androidx.compose.p109ui.node.CompositionLocalConsumerModifierNodeKt;
import androidx.compose.p109ui.node.DelegatableNodeKt;
import androidx.compose.p109ui.node.DelegatingNode;
import androidx.compose.p109ui.node.NodeKind;
import androidx.compose.runtime.AbstractC1974b;
import androidx.compose.runtime.collection.MutableVector;
import androidx.compose.runtime.saveable.SaveableStateRegistry;
import androidx.compose.runtime.saveable.SaveableStateRegistryKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.SourceDebugExtension;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes.dex */
@Metadata(m13885d1 = {"\u0000*\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\u001a\u001e\u0010\u0002\u001a\u00020\u0003*\u00020\u00032\u0010\b\u0002\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005H\u0007\u001a\u000e\u0010\u0007\u001a\u0004\u0018\u00010\b*\u00020\tH\u0000\u001a\f\u0010\n\u001a\u00020\u000b*\u00020\tH\u0001\u001a\f\u0010\f\u001a\u00020\u000b*\u00020\tH\u0001\"\u000e\u0010\u0000\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000¨\u0006\r"}, m13886d2 = {"PrevFocusedChild", "", "focusRestorer", "Landroidx/compose/ui/Modifier;", "onRestoreFailed", "Lkotlin/Function0;", "Landroidx/compose/ui/focus/FocusRequester;", "pinFocusedChild", "Landroidx/compose/ui/layout/PinnableContainer$PinnedHandle;", "Landroidx/compose/ui/focus/FocusTargetNode;", "restoreFocusedChild", "", "saveFocusedChild", "ui_release"}, m13887k = 2, m13888mv = {1, 8, 0}, m13890xi = 48)
@SourceDebugExtension({"SMAP\nFocusRestorer.kt\nKotlin\n*S Kotlin\n*F\n+ 1 FocusRestorer.kt\nandroidx/compose/ui/focus/FocusRestorerKt\n+ 2 NodeKind.kt\nandroidx/compose/ui/node/Nodes\n+ 3 DelegatableNode.kt\nandroidx/compose/ui/node/DelegatableNodeKt\n+ 4 fake.kt\nkotlin/jvm/internal/FakeKt\n+ 5 MutableVector.kt\nandroidx/compose/runtime/collection/MutableVectorKt\n+ 6 MutableVector.kt\nandroidx/compose/runtime/collection/MutableVector\n+ 7 Modifier.kt\nandroidx/compose/ui/Modifier$Node\n+ 8 DelegatingNode.kt\nandroidx/compose/ui/node/DelegatingNode\n*L\n1#1,145:1\n96#2:146\n96#2:217\n297#3:147\n137#3:148\n138#3:150\n139#3,7:154\n146#3,9:162\n432#3,6:171\n442#3,2:178\n444#3,17:183\n461#3,8:203\n155#3,6:211\n297#3:218\n137#3:219\n138#3:221\n139#3,7:225\n146#3,9:233\n432#3,6:242\n442#3,2:249\n444#3,17:254\n461#3,8:274\n155#3,6:282\n1#4:149\n1#4:220\n1208#5:151\n1187#5,2:152\n1208#5:222\n1187#5,2:223\n48#6:161\n48#6:232\n249#7:177\n249#7:248\n245#8,3:180\n248#8,3:200\n245#8,3:251\n248#8,3:271\n*S KotlinDebug\n*F\n+ 1 FocusRestorer.kt\nandroidx/compose/ui/focus/FocusRestorerKt\n*L\n39#1:146\n59#1:217\n39#1:147\n39#1:148\n39#1:150\n39#1:154,7\n39#1:162,9\n39#1:171,6\n39#1:178,2\n39#1:183,17\n39#1:203,8\n39#1:211,6\n59#1:218\n59#1:219\n59#1:221\n59#1:225,7\n59#1:233,9\n59#1:242,6\n59#1:249,2\n59#1:254,17\n59#1:274,8\n59#1:282,6\n39#1:149\n59#1:220\n39#1:151\n39#1:152,2\n59#1:222\n59#1:223,2\n39#1:161\n59#1:232\n39#1:177\n59#1:248\n39#1:180,3\n39#1:200,3\n59#1:251,3\n59#1:271,3\n*E\n"})
public final class FocusRestorerKt {

    @NotNull
    private static final String PrevFocusedChild = "previouslyFocusedChildHash";

    @ExperimentalComposeUiApi
    @NotNull
    public static final Modifier focusRestorer(@NotNull Modifier modifier, @Nullable Function0<FocusRequester> function0) {
        return modifier.then(new FocusRestorerElement(function0));
    }

    public static /* synthetic */ Modifier focusRestorer$default(Modifier modifier, Function0 function0, int i, Object obj) {
        if ((i & 1) != 0) {
            function0 = null;
        }
        return focusRestorer(modifier, function0);
    }

    @Nullable
    public static final PinnableContainer.PinnedHandle pinFocusedChild(@NotNull FocusTargetNode focusTargetNode) {
        PinnableContainer pinnableContainer;
        FocusTargetNode focusTargetNodeFindActiveFocusNode = FocusTraversalKt.findActiveFocusNode(focusTargetNode);
        if (focusTargetNodeFindActiveFocusNode == null || (pinnableContainer = (PinnableContainer) CompositionLocalConsumerModifierNodeKt.currentValueOf(focusTargetNodeFindActiveFocusNode, PinnableContainerKt.getLocalPinnableContainer())) == null) {
            return null;
        }
        return pinnableContainer.pin();
    }

    /* JADX WARN: Code restructure failed: missing block: B:71:0x005a, code lost:
    
        continue;
     */
    @ExperimentalComposeUiApi
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final boolean restoreFocusedChild(@NotNull FocusTargetNode focusTargetNode) {
        SaveableStateRegistry saveableStateRegistry;
        Object objConsumeRestored;
        if (focusTargetNode.getPreviouslyFocusedChildHash() == 0 && (saveableStateRegistry = (SaveableStateRegistry) CompositionLocalConsumerModifierNodeKt.currentValueOf(focusTargetNode, SaveableStateRegistryKt.getLocalSaveableStateRegistry())) != null && (objConsumeRestored = saveableStateRegistry.consumeRestored(PrevFocusedChild)) != null) {
            focusTargetNode.setPreviouslyFocusedChildHash(((Integer) objConsumeRestored).intValue());
        }
        if (focusTargetNode.getPreviouslyFocusedChildHash() == 0) {
            return false;
        }
        int iM20090constructorimpl = NodeKind.m20090constructorimpl(1024);
        if (!focusTargetNode.getNode().getIsAttached()) {
            throw new IllegalStateException("visitChildren called on an unattached node");
        }
        MutableVector mutableVector = new MutableVector(new Modifier.Node[16], 0);
        Modifier.Node child = focusTargetNode.getNode().getChild();
        if (child == null) {
            DelegatableNodeKt.addLayoutNodeChildren(mutableVector, focusTargetNode.getNode());
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
                                FocusTargetNode focusTargetNode2 = (FocusTargetNode) nodePop;
                                if (focusTargetNode2.getIsAttached() && DelegatableNodeKt.requireLayoutNode(focusTargetNode2).getCompositeKeyHash() == focusTargetNode.getPreviouslyFocusedChildHash()) {
                                    return restoreFocusedChild(focusTargetNode2) || FocusTransactionsKt.requestFocus(focusTargetNode2);
                                }
                            } else if ((nodePop.getKindSet() & iM20090constructorimpl) != 0 && (nodePop instanceof DelegatingNode)) {
                                int i = 0;
                                for (Modifier.Node delegate = ((DelegatingNode) nodePop).getDelegate(); delegate != null; delegate = delegate.getChild()) {
                                    if ((delegate.getKindSet() & iM20090constructorimpl) != 0) {
                                        i++;
                                        if (i == 1) {
                                            nodePop = delegate;
                                        } else {
                                            if (mutableVector2 == null) {
                                                mutableVector2 = new MutableVector(new Modifier.Node[16], 0);
                                            }
                                            if (nodePop != null) {
                                                mutableVector2.add(nodePop);
                                                nodePop = null;
                                            }
                                            mutableVector2.add(delegate);
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
        return false;
    }

    /* JADX WARN: Code restructure failed: missing block: B:59:0x003a, code lost:
    
        continue;
     */
    @ExperimentalComposeUiApi
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final boolean saveFocusedChild(@NotNull final FocusTargetNode focusTargetNode) {
        if (!focusTargetNode.getFocusState().getHasFocus()) {
            return false;
        }
        int iM20090constructorimpl = NodeKind.m20090constructorimpl(1024);
        if (!focusTargetNode.getNode().getIsAttached()) {
            throw new IllegalStateException("visitChildren called on an unattached node");
        }
        MutableVector mutableVector = new MutableVector(new Modifier.Node[16], 0);
        Modifier.Node child = focusTargetNode.getNode().getChild();
        if (child == null) {
            DelegatableNodeKt.addLayoutNodeChildren(mutableVector, focusTargetNode.getNode());
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
                                FocusTargetNode focusTargetNode2 = (FocusTargetNode) nodePop;
                                if (focusTargetNode2.getFocusState().getHasFocus()) {
                                    focusTargetNode.setPreviouslyFocusedChildHash(DelegatableNodeKt.requireLayoutNode(focusTargetNode2).getCompositeKeyHash());
                                    SaveableStateRegistry saveableStateRegistry = (SaveableStateRegistry) CompositionLocalConsumerModifierNodeKt.currentValueOf(focusTargetNode, SaveableStateRegistryKt.getLocalSaveableStateRegistry());
                                    if (saveableStateRegistry != null) {
                                        saveableStateRegistry.registerProvider(PrevFocusedChild, new Function0<Object>() { // from class: androidx.compose.ui.focus.FocusRestorerKt$saveFocusedChild$1$1
                                            {
                                                super(0);
                                            }

                                            @Override // kotlin.jvm.functions.Function0
                                            @Nullable
                                            public final Object invoke() {
                                                return Integer.valueOf(focusTargetNode.getPreviouslyFocusedChildHash());
                                            }
                                        });
                                    }
                                    return true;
                                }
                            } else if ((nodePop.getKindSet() & iM20090constructorimpl) != 0 && (nodePop instanceof DelegatingNode)) {
                                int i = 0;
                                for (Modifier.Node delegate = ((DelegatingNode) nodePop).getDelegate(); delegate != null; delegate = delegate.getChild()) {
                                    if ((delegate.getKindSet() & iM20090constructorimpl) != 0) {
                                        i++;
                                        if (i == 1) {
                                            nodePop = delegate;
                                        } else {
                                            if (mutableVector2 == null) {
                                                mutableVector2 = new MutableVector(new Modifier.Node[16], 0);
                                            }
                                            if (nodePop != null) {
                                                mutableVector2.add(nodePop);
                                                nodePop = null;
                                            }
                                            mutableVector2.add(delegate);
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
        return false;
    }
}
