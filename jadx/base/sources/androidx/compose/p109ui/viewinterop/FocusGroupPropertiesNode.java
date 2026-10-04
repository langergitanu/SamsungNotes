package androidx.compose.p109ui.viewinterop;

import android.graphics.Rect;
import android.view.FocusFinder;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import androidx.compose.p109ui.Modifier;
import androidx.compose.p109ui.focus.FocusDirection;
import androidx.compose.p109ui.focus.FocusInteropUtils_androidKt;
import androidx.compose.p109ui.focus.FocusOwner;
import androidx.compose.p109ui.focus.FocusProperties;
import androidx.compose.p109ui.focus.FocusPropertiesModifierNode;
import androidx.compose.p109ui.focus.FocusRequester;
import androidx.compose.p109ui.focus.FocusTargetNode;
import androidx.compose.p109ui.focus.FocusTransactionManager;
import androidx.compose.p109ui.focus.FocusTransactionsKt;
import androidx.compose.p109ui.internal.InlineClassHelperKt;
import androidx.compose.p109ui.node.DelegatableNodeKt;
import androidx.compose.p109ui.node.DelegatingNode;
import androidx.compose.p109ui.node.NodeKind;
import androidx.compose.p109ui.node.Owner;
import androidx.compose.runtime.collection.MutableVector;
import com.samsung.android.support.senl.document.memoconverter.core.SNBUtils.vml.vector.shape.pathdata.VPathDataCmd;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(m13885d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000b\b\u0002\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u00032\u00020\u0004B\u0005¢\u0006\u0002\u0010\u0005J\u0010\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000fH\u0016J\b\u0010\u0010\u001a\u00020\u0011H\u0002J\b\u0010\u0012\u001a\u00020\rH\u0016J\b\u0010\u0013\u001a\u00020\rH\u0016J\u0018\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u0017ø\u0001\u0000¢\u0006\u0004\b\u0018\u0010\u0019J\u0018\u0010\u001a\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u0017ø\u0001\u0000¢\u0006\u0004\b\u001b\u0010\u0019J\u001c\u0010\u001c\u001a\u00020\r2\b\u0010\u001d\u001a\u0004\u0018\u00010\u00072\b\u0010\u001e\u001a\u0004\u0018\u00010\u0007H\u0016J\u0010\u0010\u001f\u001a\u00020\r2\u0006\u0010 \u001a\u00020\u0007H\u0016J\u0010\u0010!\u001a\u00020\r2\u0006\u0010 \u001a\u00020\u0007H\u0016R\u001c\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000b\u0082\u0002\u0007\n\u0005\b¡\u001e0\u0001¨\u0006\""}, m13886d2 = {"Landroidx/compose/ui/viewinterop/FocusGroupPropertiesNode;", "Landroidx/compose/ui/Modifier$Node;", "Landroidx/compose/ui/focus/FocusPropertiesModifierNode;", "Landroid/view/ViewTreeObserver$OnGlobalFocusChangeListener;", "Landroid/view/View$OnAttachStateChangeListener;", "()V", "focusedChild", "Landroid/view/View;", "getFocusedChild", "()Landroid/view/View;", "setFocusedChild", "(Landroid/view/View;)V", "applyFocusProperties", "", "focusProperties", "Landroidx/compose/ui/focus/FocusProperties;", "getFocusTargetOfEmbeddedViewWrapper", "Landroidx/compose/ui/focus/FocusTargetNode;", "onAttach", "onDetach", "onEnter", "Landroidx/compose/ui/focus/FocusRequester;", "focusDirection", "Landroidx/compose/ui/focus/FocusDirection;", "onEnter-3ESFkO8", "(I)Landroidx/compose/ui/focus/FocusRequester;", "onExit", "onExit-3ESFkO8", "onGlobalFocusChanged", "oldFocus", "newFocus", "onViewAttachedToWindow", VPathDataCmd.RCurveTo, "onViewDetachedFromWindow", "ui_release"}, m13887k = 1, m13888mv = {1, 8, 0}, m13890xi = 48)
@SourceDebugExtension({"SMAP\nFocusGroupNode.android.kt\nKotlin\n*S Kotlin\n*F\n+ 1 FocusGroupNode.android.kt\nandroidx/compose/ui/viewinterop/FocusGroupPropertiesNode\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n+ 3 NodeKind.kt\nandroidx/compose/ui/node/Nodes\n+ 4 DelegatableNode.kt\nandroidx/compose/ui/node/DelegatableNodeKt\n+ 5 InlineClassHelper.kt\nandroidx/compose/ui/internal/InlineClassHelperKt\n+ 6 Modifier.kt\nandroidx/compose/ui/Modifier$Node\n+ 7 DelegatingNode.kt\nandroidx/compose/ui/node/DelegatingNode\n+ 8 MutableVector.kt\nandroidx/compose/runtime/collection/MutableVectorKt\n+ 9 FocusTransactionManager.kt\nandroidx/compose/ui/focus/FocusTransactionManager\n+ 10 MutableVector.kt\nandroidx/compose/runtime/collection/MutableVector\n*L\n1#1,240:1\n1#2:241\n1#2:325\n96#3:242\n240#4:243\n193#4,12:244\n205#4,6:263\n241#4:269\n432#4,6:270\n442#4,2:277\n444#4,8:282\n452#4,9:293\n461#4,8:305\n242#4:313\n212#4,3:314\n197#4:317\n42#5,7:256\n249#6:276\n245#7,3:279\n248#7,3:302\n1208#8:290\n1187#8,2:291\n40#9,7:318\n47#9,4:328\n728#10,2:326\n*S KotlinDebug\n*F\n+ 1 FocusGroupNode.android.kt\nandroidx/compose/ui/viewinterop/FocusGroupPropertiesNode\n*L\n151#1:325\n125#1:242\n125#1:243\n125#1:244,12\n125#1:263,6\n125#1:269\n125#1:270,6\n125#1:277,2\n125#1:282,8\n125#1:293,9\n125#1:305,8\n125#1:313\n125#1:314,3\n125#1:317\n125#1:256,7\n125#1:276\n125#1:279,3\n125#1:302,3\n125#1:290\n125#1:291,2\n151#1:318,7\n151#1:328,4\n151#1:326,2\n*E\n"})
final class FocusGroupPropertiesNode extends Modifier.Node implements FocusPropertiesModifierNode, ViewTreeObserver.OnGlobalFocusChangeListener, View.OnAttachStateChangeListener {

    @Nullable
    private View focusedChild;

    /* JADX INFO: renamed from: androidx.compose.ui.viewinterop.FocusGroupPropertiesNode$applyFocusProperties$1 */
    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13887k = 3, m13888mv = {1, 8, 0}, m13890xi = 48)
    public /* synthetic */ class C22631 extends FunctionReferenceImpl implements Function1<FocusDirection, FocusRequester> {
        public C22631(Object obj) {
            super(1, obj, FocusGroupPropertiesNode.class, "onEnter", "onEnter-3ESFkO8(I)Landroidx/compose/ui/focus/FocusRequester;", 0);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ FocusRequester invoke(FocusDirection focusDirection) {
            return m21220invoke3ESFkO8(focusDirection.getValue());
        }

        @NotNull
        /* JADX INFO: renamed from: invoke-3ESFkO8, reason: not valid java name */
        public final FocusRequester m21220invoke3ESFkO8(int i) {
            return ((FocusGroupPropertiesNode) this.receiver).m21218onEnter3ESFkO8(i);
        }
    }

    /* JADX INFO: renamed from: androidx.compose.ui.viewinterop.FocusGroupPropertiesNode$applyFocusProperties$2 */
    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13887k = 3, m13888mv = {1, 8, 0}, m13890xi = 48)
    public /* synthetic */ class C22642 extends FunctionReferenceImpl implements Function1<FocusDirection, FocusRequester> {
        public C22642(Object obj) {
            super(1, obj, FocusGroupPropertiesNode.class, "onExit", "onExit-3ESFkO8(I)Landroidx/compose/ui/focus/FocusRequester;", 0);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ FocusRequester invoke(FocusDirection focusDirection) {
            return m21221invoke3ESFkO8(focusDirection.getValue());
        }

        @NotNull
        /* JADX INFO: renamed from: invoke-3ESFkO8, reason: not valid java name */
        public final FocusRequester m21221invoke3ESFkO8(int i) {
            return ((FocusGroupPropertiesNode) this.receiver).m21219onExit3ESFkO8(i);
        }
    }

    private final FocusTargetNode getFocusTargetOfEmbeddedViewWrapper() {
        int iM20090constructorimpl = NodeKind.m20090constructorimpl(1024);
        if (!getNode().getIsAttached()) {
            InlineClassHelperKt.throwIllegalStateException("visitLocalDescendants called on an unattached node");
        }
        Modifier.Node node = getNode();
        if ((node.getAggregateChildKindSet() & iM20090constructorimpl) != 0) {
            boolean z = false;
            for (Modifier.Node child = node.getChild(); child != null; child = child.getChild()) {
                if ((child.getKindSet() & iM20090constructorimpl) != 0) {
                    Modifier.Node nodePop = child;
                    MutableVector mutableVector = null;
                    while (nodePop != null) {
                        if (nodePop instanceof FocusTargetNode) {
                            FocusTargetNode focusTargetNode = (FocusTargetNode) nodePop;
                            if (z) {
                                return focusTargetNode;
                            }
                            z = true;
                        } else if ((nodePop.getKindSet() & iM20090constructorimpl) != 0 && (nodePop instanceof DelegatingNode)) {
                            int i = 0;
                            for (Modifier.Node delegate = ((DelegatingNode) nodePop).getDelegate(); delegate != null; delegate = delegate.getChild()) {
                                if ((delegate.getKindSet() & iM20090constructorimpl) != 0) {
                                    i++;
                                    if (i == 1) {
                                        nodePop = delegate;
                                    } else {
                                        if (mutableVector == null) {
                                            mutableVector = new MutableVector(new Modifier.Node[16], 0);
                                        }
                                        if (nodePop != null) {
                                            mutableVector.add(nodePop);
                                            nodePop = null;
                                        }
                                        mutableVector.add(delegate);
                                    }
                                }
                            }
                            if (i == 1) {
                            }
                        }
                        nodePop = DelegatableNodeKt.pop(mutableVector);
                    }
                }
            }
        }
        throw new IllegalStateException("Could not find focus target of embedded view wrapper");
    }

    @Override // androidx.compose.p109ui.focus.FocusPropertiesModifierNode
    public void applyFocusProperties(@NotNull FocusProperties focusProperties) {
        focusProperties.setCanFocus(false);
        focusProperties.setEnter(new C22631(this));
        focusProperties.setExit(new C22642(this));
    }

    @Nullable
    public final View getFocusedChild() {
        return this.focusedChild;
    }

    @Override // androidx.compose.ui.Modifier.Node
    public void onAttach() {
        super.onAttach();
        FocusGroupNode_androidKt.getView(this).addOnAttachStateChangeListener(this);
    }

    @Override // androidx.compose.ui.Modifier.Node
    public void onDetach() {
        FocusGroupNode_androidKt.getView(this).removeOnAttachStateChangeListener(this);
        this.focusedChild = null;
        super.onDetach();
    }

    @NotNull
    /* JADX INFO: renamed from: onEnter-3ESFkO8, reason: not valid java name */
    public final FocusRequester m21218onEnter3ESFkO8(int focusDirection) {
        View view = FocusGroupNode_androidKt.getView(this);
        if (view.isFocused() || view.hasFocus()) {
            return FocusRequester.INSTANCE.getDefault();
        }
        FocusOwner focusOwner = DelegatableNodeKt.requireOwner(this).getFocusOwner();
        Object objRequireOwner = DelegatableNodeKt.requireOwner(this);
        Intrinsics.checkNotNull(objRequireOwner, "null cannot be cast to non-null type android.view.View");
        return FocusInteropUtils_androidKt.requestInteropFocus(view, FocusInteropUtils_androidKt.m18210toAndroidFocusDirection3ESFkO8(focusDirection), FocusGroupNode_androidKt.getCurrentlyFocusedRect(focusOwner, (View) objRequireOwner, view)) ? FocusRequester.INSTANCE.getDefault() : FocusRequester.INSTANCE.getCancel();
    }

    @NotNull
    /* JADX INFO: renamed from: onExit-3ESFkO8, reason: not valid java name */
    public final FocusRequester m21219onExit3ESFkO8(int focusDirection) {
        View view = FocusGroupNode_androidKt.getView(this);
        if (!view.hasFocus()) {
            return FocusRequester.INSTANCE.getDefault();
        }
        FocusOwner focusOwner = DelegatableNodeKt.requireOwner(this).getFocusOwner();
        Object objRequireOwner = DelegatableNodeKt.requireOwner(this);
        Intrinsics.checkNotNull(objRequireOwner, "null cannot be cast to non-null type android.view.View");
        View view2 = (View) objRequireOwner;
        if (!(view instanceof ViewGroup)) {
            if (view2.requestFocus()) {
                return FocusRequester.INSTANCE.getDefault();
            }
            throw new IllegalStateException("host view did not take focus");
        }
        Rect currentlyFocusedRect = FocusGroupNode_androidKt.getCurrentlyFocusedRect(focusOwner, view2, view);
        Integer numM18210toAndroidFocusDirection3ESFkO8 = FocusInteropUtils_androidKt.m18210toAndroidFocusDirection3ESFkO8(focusDirection);
        int iIntValue = numM18210toAndroidFocusDirection3ESFkO8 != null ? numM18210toAndroidFocusDirection3ESFkO8.intValue() : 130;
        FocusFinder focusFinder = FocusFinder.getInstance();
        View view3 = this.focusedChild;
        View viewFindNextFocus = view3 != null ? focusFinder.findNextFocus((ViewGroup) view2, view3, iIntValue) : focusFinder.findNextFocusFromRect((ViewGroup) view2, currentlyFocusedRect, iIntValue);
        if (viewFindNextFocus != null && FocusGroupNode_androidKt.containsDescendant(view, viewFindNextFocus)) {
            viewFindNextFocus.requestFocus(iIntValue, currentlyFocusedRect);
            return FocusRequester.INSTANCE.getCancel();
        }
        if (view2.requestFocus()) {
            return FocusRequester.INSTANCE.getDefault();
        }
        throw new IllegalStateException("host view did not take focus");
    }

    @Override // android.view.ViewTreeObserver.OnGlobalFocusChangeListener
    public void onGlobalFocusChanged(@Nullable View oldFocus, @Nullable View newFocus) {
        if (DelegatableNodeKt.requireLayoutNode(this).getOwner() == null) {
            return;
        }
        View view = FocusGroupNode_androidKt.getView(this);
        FocusOwner focusOwner = DelegatableNodeKt.requireOwner(this).getFocusOwner();
        Owner ownerRequireOwner = DelegatableNodeKt.requireOwner(this);
        boolean z = (oldFocus == null || Intrinsics.areEqual(oldFocus, ownerRequireOwner) || !FocusGroupNode_androidKt.containsDescendant(view, oldFocus)) ? false : true;
        boolean z2 = (newFocus == null || Intrinsics.areEqual(newFocus, ownerRequireOwner) || !FocusGroupNode_androidKt.containsDescendant(view, newFocus)) ? false : true;
        if (z && z2) {
            this.focusedChild = newFocus;
            return;
        }
        if (!z2) {
            if (!z) {
                this.focusedChild = null;
                return;
            }
            this.focusedChild = null;
            if (getFocusTargetOfEmbeddedViewWrapper().getFocusState().isFocused()) {
                focusOwner.mo18213clearFocusI7lrPNg(false, true, false, FocusDirection.INSTANCE.m18204getExitdhqQ8s());
                return;
            }
            return;
        }
        this.focusedChild = newFocus;
        FocusTargetNode focusTargetOfEmbeddedViewWrapper = getFocusTargetOfEmbeddedViewWrapper();
        if (focusTargetOfEmbeddedViewWrapper.getFocusState().getHasFocus()) {
            return;
        }
        FocusTransactionManager focusTransactionManager = focusOwner.getFocusTransactionManager();
        try {
            if (focusTransactionManager.ongoingTransaction) {
                focusTransactionManager.cancelTransaction();
            }
            focusTransactionManager.beginTransaction();
            FocusTransactionsKt.performRequestFocus(focusTargetOfEmbeddedViewWrapper);
            focusTransactionManager.commitTransaction();
        } catch (Throwable th) {
            focusTransactionManager.commitTransaction();
            throw th;
        }
    }

    @Override // android.view.View.OnAttachStateChangeListener
    public void onViewAttachedToWindow(@NotNull View v) {
        v.getViewTreeObserver().addOnGlobalFocusChangeListener(this);
    }

    @Override // android.view.View.OnAttachStateChangeListener
    public void onViewDetachedFromWindow(@NotNull View v) {
        v.getViewTreeObserver().removeOnGlobalFocusChangeListener(this);
    }

    public final void setFocusedChild(@Nullable View view) {
        this.focusedChild = view;
    }
}
