package androidx.compose.foundation.lazy.layout;

import androidx.appcompat.widget.AbstractC0541b;
import androidx.compose.foundation.gestures.Orientation;
import androidx.compose.p109ui.Modifier;
import androidx.compose.p109ui.node.SemanticsModifierNode;
import androidx.compose.p109ui.node.SemanticsModifierNodeKt;
import androidx.compose.p109ui.semantics.CollectionInfo;
import androidx.compose.p109ui.semantics.ScrollAxisRange;
import androidx.compose.p109ui.semantics.SemanticsPropertiesKt;
import androidx.compose.p109ui.semantics.SemanticsPropertyReceiver;
import com.samsung.android.support.senl.p148nt.base.common.constants.Constants;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;
import org.apache.commons.beanutils.PropertyUtils;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes.dex */
@Metadata(m13885d1 = {"\u0000Z\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0002\u0018\u00002\u00020\u00012\u00020\u0002B3\u0012\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\u000b\u0012\u0006\u0010\f\u001a\u00020\u000b¢\u0006\u0002\u0010\rJ4\u0010\u001d\u001a\u00020\u001e2\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u00042\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u000bJ\b\u0010\u001f\u001a\u00020\u001eH\u0002J\f\u0010 \u001a\u00020\u001e*\u00020!H\u0016R\u0014\u0010\u000e\u001a\u00020\u000f8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u0010\u0010\u0011R\u001a\u0010\u0012\u001a\u000e\u0012\u0004\u0012\u00020\u0014\u0012\u0004\u0012\u00020\u00150\u0013X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0016\u001a\u00020\u000b8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u0016\u0010\u0017R\u0014\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\u0019X\u0082.¢\u0006\u0002\n\u0000R\u001c\u0010\u001a\u001a\u0010\u0012\u0004\u0012\u00020\u0015\u0012\u0004\u0012\u00020\u000b\u0018\u00010\u0013X\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u001b\u001a\u00020\u000b8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u001c\u0010\u0017R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\""}, m13886d2 = {"Landroidx/compose/foundation/lazy/layout/LazyLayoutSemanticsModifierNode;", "Landroidx/compose/ui/Modifier$Node;", "Landroidx/compose/ui/node/SemanticsModifierNode;", "itemProviderLambda", "Lkotlin/Function0;", "Landroidx/compose/foundation/lazy/layout/LazyLayoutItemProvider;", "state", "Landroidx/compose/foundation/lazy/layout/LazyLayoutSemanticState;", "orientation", "Landroidx/compose/foundation/gestures/Orientation;", "userScrollEnabled", "", "reverseScrolling", "(Lkotlin/jvm/functions/Function0;Landroidx/compose/foundation/lazy/layout/LazyLayoutSemanticState;Landroidx/compose/foundation/gestures/Orientation;ZZ)V", "collectionInfo", "Landroidx/compose/ui/semantics/CollectionInfo;", "getCollectionInfo", "()Landroidx/compose/ui/semantics/CollectionInfo;", "indexForKeyMapping", "Lkotlin/Function1;", "", "", "isVertical", "()Z", "scrollAxisRange", "Landroidx/compose/ui/semantics/ScrollAxisRange;", "scrollToIndexAction", "shouldAutoInvalidate", "getShouldAutoInvalidate", Constants.ARG_UPDATE, "", "updateCachedSemanticsValues", "applySemantics", "Landroidx/compose/ui/semantics/SemanticsPropertyReceiver;", "foundation_release"}, m13887k = 1, m13888mv = {1, 8, 0}, m13890xi = 48)
final class LazyLayoutSemanticsModifierNode extends Modifier.Node implements SemanticsModifierNode {

    @NotNull
    private final Function1<Object, Integer> indexForKeyMapping = new Function1<Object, Integer>() { // from class: androidx.compose.foundation.lazy.layout.LazyLayoutSemanticsModifierNode$indexForKeyMapping$1
        {
            super(1);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlin.jvm.functions.Function1
        @NotNull
        public final Integer invoke(@NotNull Object obj) {
            LazyLayoutItemProvider lazyLayoutItemProvider = (LazyLayoutItemProvider) this.this$0.itemProviderLambda.invoke();
            int itemCount = lazyLayoutItemProvider.getItemCount();
            int i = 0;
            while (true) {
                if (i >= itemCount) {
                    i = -1;
                    break;
                }
                if (Intrinsics.areEqual(lazyLayoutItemProvider.getKey(i), obj)) {
                    break;
                }
                i++;
            }
            return Integer.valueOf(i);
        }
    };

    @NotNull
    private Function0<? extends LazyLayoutItemProvider> itemProviderLambda;

    @NotNull
    private Orientation orientation;
    private boolean reverseScrolling;
    private ScrollAxisRange scrollAxisRange;

    @Nullable
    private Function1<? super Integer, Boolean> scrollToIndexAction;

    @NotNull
    private LazyLayoutSemanticState state;
    private boolean userScrollEnabled;

    public LazyLayoutSemanticsModifierNode(@NotNull Function0<? extends LazyLayoutItemProvider> function0, @NotNull LazyLayoutSemanticState lazyLayoutSemanticState, @NotNull Orientation orientation, boolean z, boolean z2) {
        this.itemProviderLambda = function0;
        this.state = lazyLayoutSemanticState;
        this.orientation = orientation;
        this.userScrollEnabled = z;
        this.reverseScrolling = z2;
        updateCachedSemanticsValues();
    }

    private final CollectionInfo getCollectionInfo() {
        return this.state.collectionInfo();
    }

    private final boolean isVertical() {
        return this.orientation == Orientation.Vertical;
    }

    private final void updateCachedSemanticsValues() {
        this.scrollAxisRange = new ScrollAxisRange(new Function0<Float>() { // from class: androidx.compose.foundation.lazy.layout.LazyLayoutSemanticsModifierNode.updateCachedSemanticsValues.1
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final Float invoke() {
                return Float.valueOf(LazyLayoutSemanticsModifierNode.this.state.getScrollOffset());
            }
        }, new Function0<Float>() { // from class: androidx.compose.foundation.lazy.layout.LazyLayoutSemanticsModifierNode.updateCachedSemanticsValues.2
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final Float invoke() {
                return Float.valueOf(LazyLayoutSemanticsModifierNode.this.state.getMaxScrollOffset());
            }
        }, this.reverseScrolling);
        this.scrollToIndexAction = this.userScrollEnabled ? new Function1<Integer, Boolean>() { // from class: androidx.compose.foundation.lazy.layout.LazyLayoutSemanticsModifierNode.updateCachedSemanticsValues.3

            /* JADX INFO: renamed from: androidx.compose.foundation.lazy.layout.LazyLayoutSemanticsModifierNode$updateCachedSemanticsValues$3$2, reason: invalid class name */
            /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
            @Metadata(m13885d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, m13886d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, m13887k = 3, m13888mv = {1, 8, 0}, m13890xi = 48)
            @DebugMetadata(m14020c = "androidx.compose.foundation.lazy.layout.LazyLayoutSemanticsModifierNode$updateCachedSemanticsValues$3$2", m14021f = "LazyLayoutSemantics.kt", m14022i = {}, m14023l = {205}, m14024m = "invokeSuspend", m14025n = {}, m14026s = {})
            public static final class AnonymousClass2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
                final /* synthetic */ int $index;
                int label;
                final /* synthetic */ LazyLayoutSemanticsModifierNode this$0;

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                public AnonymousClass2(LazyLayoutSemanticsModifierNode lazyLayoutSemanticsModifierNode, int i, Continuation<? super AnonymousClass2> continuation) {
                    super(2, continuation);
                    this.this$0 = lazyLayoutSemanticsModifierNode;
                    this.$index = i;
                }

                @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                @NotNull
                public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
                    return new AnonymousClass2(this.this$0, this.$index, continuation);
                }

                @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                @Nullable
                public final Object invokeSuspend(@NotNull Object obj) {
                    Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                    int i = this.label;
                    if (i == 0) {
                        ResultKt.throwOnFailure(obj);
                        LazyLayoutSemanticState lazyLayoutSemanticState = this.this$0.state;
                        int i2 = this.$index;
                        this.label = 1;
                        if (lazyLayoutSemanticState.scrollToItem(i2, this) == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                    } else {
                        if (i != 1) {
                            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                        }
                        ResultKt.throwOnFailure(obj);
                    }
                    return Unit.INSTANCE;
                }

                @Override // kotlin.jvm.functions.Function2
                @Nullable
                public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super Unit> continuation) {
                    return ((AnonymousClass2) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
                }
            }

            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Boolean invoke(Integer num) {
                return invoke(num.intValue());
            }

            @NotNull
            public final Boolean invoke(int i) {
                LazyLayoutItemProvider lazyLayoutItemProvider = (LazyLayoutItemProvider) LazyLayoutSemanticsModifierNode.this.itemProviderLambda.invoke();
                if (i >= 0 && i < lazyLayoutItemProvider.getItemCount()) {
                    BuildersKt__Builders_commonKt.launch$default(LazyLayoutSemanticsModifierNode.this.getCoroutineScope(), null, null, new AnonymousClass2(LazyLayoutSemanticsModifierNode.this, i, null), 3, null);
                    return Boolean.TRUE;
                }
                StringBuilder sbM778t = AbstractC0541b.m778t(i, "Can't scroll to index ", ", it is out of bounds [0, ");
                sbM778t.append(lazyLayoutItemProvider.getItemCount());
                sbM778t.append(PropertyUtils.MAPPED_DELIM2);
                throw new IllegalArgumentException(sbM778t.toString().toString());
            }
        } : null;
    }

    @Override // androidx.compose.p109ui.node.SemanticsModifierNode
    public void applySemantics(@NotNull SemanticsPropertyReceiver semanticsPropertyReceiver) {
        SemanticsPropertiesKt.setTraversalGroup(semanticsPropertyReceiver, true);
        SemanticsPropertiesKt.indexForKey(semanticsPropertyReceiver, this.indexForKeyMapping);
        if (isVertical()) {
            ScrollAxisRange scrollAxisRange = this.scrollAxisRange;
            if (scrollAxisRange == null) {
                Intrinsics.throwUninitializedPropertyAccessException("scrollAxisRange");
                scrollAxisRange = null;
            }
            SemanticsPropertiesKt.setVerticalScrollAxisRange(semanticsPropertyReceiver, scrollAxisRange);
        } else {
            ScrollAxisRange scrollAxisRange2 = this.scrollAxisRange;
            if (scrollAxisRange2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("scrollAxisRange");
                scrollAxisRange2 = null;
            }
            SemanticsPropertiesKt.setHorizontalScrollAxisRange(semanticsPropertyReceiver, scrollAxisRange2);
        }
        Function1<? super Integer, Boolean> function1 = this.scrollToIndexAction;
        if (function1 != null) {
            SemanticsPropertiesKt.scrollToIndex$default(semanticsPropertyReceiver, null, function1, 1, null);
        }
        SemanticsPropertiesKt.getScrollViewportLength$default(semanticsPropertyReceiver, null, new Function0<Float>() { // from class: androidx.compose.foundation.lazy.layout.LazyLayoutSemanticsModifierNode.applySemantics.2
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @Nullable
            public final Float invoke() {
                return Float.valueOf(LazyLayoutSemanticsModifierNode.this.state.getViewport() - LazyLayoutSemanticsModifierNode.this.state.getContentPadding());
            }
        }, 1, null);
        SemanticsPropertiesKt.setCollectionInfo(semanticsPropertyReceiver, getCollectionInfo());
    }

    @Override // androidx.compose.ui.Modifier.Node
    public boolean getShouldAutoInvalidate() {
        return false;
    }

    public final void update(@NotNull Function0<? extends LazyLayoutItemProvider> itemProviderLambda, @NotNull LazyLayoutSemanticState state, @NotNull Orientation orientation, boolean userScrollEnabled, boolean reverseScrolling) {
        this.itemProviderLambda = itemProviderLambda;
        this.state = state;
        if (this.orientation != orientation) {
            this.orientation = orientation;
            SemanticsModifierNodeKt.invalidateSemantics(this);
        }
        if (this.userScrollEnabled == userScrollEnabled && this.reverseScrolling == reverseScrolling) {
            return;
        }
        this.userScrollEnabled = userScrollEnabled;
        this.reverseScrolling = reverseScrolling;
        updateCachedSemanticsValues();
        SemanticsModifierNodeKt.invalidateSemantics(this);
    }
}
