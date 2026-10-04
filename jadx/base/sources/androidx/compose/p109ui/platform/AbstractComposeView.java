package androidx.compose.p109ui.platform;

import android.content.Context;
import android.os.IBinder;
import android.util.AttributeSet;
import android.view.KeyEvent;
import android.view.View;
import android.view.ViewGroup;
import androidx.compose.p109ui.InternalComposeUiApi;
import androidx.compose.p109ui.UiComposable;
import androidx.compose.p109ui.node.Owner;
import androidx.compose.runtime.Composable;
import androidx.compose.runtime.ComposableTarget;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.Composition;
import androidx.compose.runtime.CompositionContext;
import androidx.compose.runtime.Recomposer;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.runtime.internal.StabilityInferred;
import com.samsung.android.sdk.bixby2.action.ActionHandler;
import java.lang.ref.WeakReference;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.SourceDebugExtension;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes.dex */
@StabilityInferred(parameters = 0)
@Metadata(m13885d1 = {"\u0000^\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0010\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b \n\u0002\u0018\u0002\n\u0002\b\u0003\b'\u0018\u00002\u00020\u0001B%\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\r\u0010*\u001a\u00020\u0012H'¢\u0006\u0002\u0010+J\u0012\u0010,\u001a\u00020\u00122\b\u0010-\u001a\u0004\u0018\u00010.H\u0016J\u001c\u0010,\u001a\u00020\u00122\b\u0010-\u001a\u0004\u0018\u00010.2\b\u0010/\u001a\u0004\u0018\u000100H\u0016J\u001a\u0010,\u001a\u00020\u00122\b\u0010-\u001a\u0004\u0018\u00010.2\u0006\u00101\u001a\u00020\u0007H\u0016J$\u0010,\u001a\u00020\u00122\b\u0010-\u001a\u0004\u0018\u00010.2\u0006\u00101\u001a\u00020\u00072\b\u0010/\u001a\u0004\u0018\u000100H\u0016J\"\u0010,\u001a\u00020\u00122\b\u0010-\u001a\u0004\u0018\u00010.2\u0006\u00102\u001a\u00020\u00072\u0006\u00103\u001a\u00020\u0007H\u0016J$\u00104\u001a\u00020\u000f2\b\u0010-\u001a\u0004\u0018\u00010.2\u0006\u00101\u001a\u00020\u00072\b\u0010/\u001a\u0004\u0018\u000100H\u0014J,\u00104\u001a\u00020\u000f2\b\u0010-\u001a\u0004\u0018\u00010.2\u0006\u00101\u001a\u00020\u00072\b\u0010/\u001a\u0004\u0018\u0001002\u0006\u00105\u001a\u00020\u000fH\u0014J\b\u00106\u001a\u00020\u0012H\u0002J\u0006\u00107\u001a\u00020\u0012J\u0006\u00108\u001a\u00020\u0012J\b\u00109\u001a\u00020\u0012H\u0002J5\u0010:\u001a\u00020\u00122\u0006\u0010;\u001a\u00020\u000f2\u0006\u0010<\u001a\u00020\u00072\u0006\u0010=\u001a\u00020\u00072\u0006\u0010>\u001a\u00020\u00072\u0006\u0010?\u001a\u00020\u0007H\u0010¢\u0006\u0002\b@J\u001d\u0010A\u001a\u00020\u00122\u0006\u0010B\u001a\u00020\u00072\u0006\u0010C\u001a\u00020\u0007H\u0010¢\u0006\u0002\bDJ\b\u0010E\u001a\u00020\u000fH\u0016J\b\u0010F\u001a\u00020\u0012H\u0014J0\u0010G\u001a\u00020\u00122\u0006\u0010;\u001a\u00020\u000f2\u0006\u0010<\u001a\u00020\u00072\u0006\u0010=\u001a\u00020\u00072\u0006\u0010>\u001a\u00020\u00072\u0006\u0010?\u001a\u00020\u0007H\u0004J\u0018\u0010H\u001a\u00020\u00122\u0006\u0010B\u001a\u00020\u00072\u0006\u0010C\u001a\u00020\u0007H\u0004J\u0010\u0010I\u001a\u00020\u00122\u0006\u0010J\u001a\u00020\u0007H\u0016J\b\u0010K\u001a\u00020\u000bH\u0002J\u0010\u0010L\u001a\u00020\u00122\b\u0010M\u001a\u0004\u0018\u00010\u000bJ\u0010\u0010N\u001a\u00020\u00122\u0006\u0010E\u001a\u00020\u000fH\u0016J\u000e\u0010O\u001a\u00020\u00122\u0006\u0010P\u001a\u00020QJ\b\u0010R\u001a\u00020\u000fH\u0016J\f\u0010S\u001a\u00020\u000b*\u00020\u000bH\u0002R\u0016\u0010\t\u001a\n\u0012\u0004\u0012\u00020\u000b\u0018\u00010\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\f\u001a\u0004\u0018\u00010\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX\u0082\u000e¢\u0006\u0002\n\u0000R\u001c\u0010\u0010\u001a\n\u0012\u0004\u0012\u00020\u0012\u0018\u00010\u0011X\u0082\u000e¢\u0006\b\n\u0000\u0012\u0004\b\u0013\u0010\u0014R\u0011\u0010\u0015\u001a\u00020\u000f8F¢\u0006\u0006\u001a\u0004\b\u0016\u0010\u0017R\u000e\u0010\u0018\u001a\u00020\u000fX\u0082\u000e¢\u0006\u0002\n\u0000R\"\u0010\u001a\u001a\u0004\u0018\u00010\u000b2\b\u0010\u0019\u001a\u0004\u0018\u00010\u000b@BX\u0082\u000e¢\u0006\b\n\u0000\"\u0004\b\u001b\u0010\u001cR\"\u0010\u001e\u001a\u0004\u0018\u00010\u001d2\b\u0010\u0019\u001a\u0004\u0018\u00010\u001d@BX\u0082\u000e¢\u0006\b\n\u0000\"\u0004\b\u001f\u0010 R\u0014\u0010!\u001a\u00020\u000f8TX\u0094\u0004¢\u0006\u0006\u001a\u0004\b\"\u0010\u0017R,\u0010#\u001a\u00020\u000f2\u0006\u0010\u0019\u001a\u00020\u000f8F@FX\u0087\u000e¢\u0006\u0014\n\u0000\u0012\u0004\b$\u0010\u0014\u001a\u0004\b%\u0010\u0017\"\u0004\b&\u0010'R\u0018\u0010(\u001a\u00020\u000f*\u00020\u000b8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b(\u0010)¨\u0006T"}, m13886d2 = {"Landroidx/compose/ui/platform/AbstractComposeView;", "Landroid/view/ViewGroup;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "cachedViewTreeCompositionContext", "Ljava/lang/ref/WeakReference;", "Landroidx/compose/runtime/CompositionContext;", "composition", "Landroidx/compose/runtime/Composition;", "creatingComposition", "", "disposeViewCompositionStrategy", "Lkotlin/Function0;", "", "getDisposeViewCompositionStrategy$annotations", "()V", "hasComposition", "getHasComposition", "()Z", "isTransitionGroupSet", "value", "parentContext", "setParentContext", "(Landroidx/compose/runtime/CompositionContext;)V", "Landroid/os/IBinder;", "previousAttachedWindowToken", "setPreviousAttachedWindowToken", "(Landroid/os/IBinder;)V", "shouldCreateCompositionOnAttachedToWindow", "getShouldCreateCompositionOnAttachedToWindow", "showLayoutBounds", "getShowLayoutBounds$annotations", "getShowLayoutBounds", "setShowLayoutBounds", "(Z)V", "isAlive", "(Landroidx/compose/runtime/CompositionContext;)Z", "Content", "(Landroidx/compose/runtime/Composer;I)V", "addView", "child", "Landroid/view/View;", ActionHandler.PARAMS, "Landroid/view/ViewGroup$LayoutParams;", "index", "width", "height", "addViewInLayout", "preventRequestLayout", "checkAddView", "createComposition", "disposeComposition", "ensureCompositionCreated", "internalOnLayout", "changed", "left", "top", "right", "bottom", "internalOnLayout$ui_release", "internalOnMeasure", "widthMeasureSpec", "heightMeasureSpec", "internalOnMeasure$ui_release", "isTransitionGroup", "onAttachedToWindow", "onLayout", "onMeasure", "onRtlPropertiesChanged", "layoutDirection", "resolveParentCompositionContext", "setParentCompositionContext", "parent", "setTransitionGroup", "setViewCompositionStrategy", "strategy", "Landroidx/compose/ui/platform/ViewCompositionStrategy;", "shouldDelayChildPressedState", "cacheIfAlive", "ui_release"}, m13887k = 1, m13888mv = {1, 8, 0}, m13890xi = 48)
@SourceDebugExtension({"SMAP\nComposeView.android.kt\nKotlin\n*S Kotlin\n*F\n+ 1 ComposeView.android.kt\nandroidx/compose/ui/platform/AbstractComposeView\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,461:1\n1#2:462\n*E\n"})
public abstract class AbstractComposeView extends ViewGroup {
    public static final int $stable = 8;

    @Nullable
    private WeakReference<CompositionContext> cachedViewTreeCompositionContext;

    @Nullable
    private Composition composition;
    private boolean creatingComposition;

    @Nullable
    private Function0<Unit> disposeViewCompositionStrategy;
    private boolean isTransitionGroupSet;

    @Nullable
    private CompositionContext parentContext;

    @Nullable
    private IBinder previousAttachedWindowToken;
    private boolean showLayoutBounds;

    @JvmOverloads
    public AbstractComposeView(@NotNull Context context) {
        this(context, null, 0, 6, null);
    }

    private final CompositionContext cacheIfAlive(CompositionContext compositionContext) {
        CompositionContext compositionContext2 = isAlive(compositionContext) ? compositionContext : null;
        if (compositionContext2 != null) {
            this.cachedViewTreeCompositionContext = new WeakReference<>(compositionContext2);
        }
        return compositionContext;
    }

    private final void checkAddView() {
        if (this.creatingComposition) {
            return;
        }
        throw new UnsupportedOperationException("Cannot add views to " + getClass().getSimpleName() + "; only Compose content is supported");
    }

    private final void ensureCompositionCreated() {
        if (this.composition == null) {
            try {
                this.creatingComposition = true;
                this.composition = Wrapper_androidKt.setContent(this, resolveParentCompositionContext(), ComposableLambdaKt.composableLambdaInstance(-656146368, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.ui.platform.AbstractComposeView.ensureCompositionCreated.1
                    {
                        super(2);
                    }

                    @Override // kotlin.jvm.functions.Function2
                    public /* bridge */ /* synthetic */ Unit invoke(Composer composer, Integer num) {
                        invoke(composer, num.intValue());
                        return Unit.INSTANCE;
                    }

                    @ComposableTarget(applier = "androidx.compose.ui.UiComposable")
                    @Composable
                    public final void invoke(@Nullable Composer composer, int i) {
                        if ((i & 3) == 2 && composer.getSkipping()) {
                            composer.skipToGroupEnd();
                            return;
                        }
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(-656146368, i, -1, "androidx.compose.ui.platform.AbstractComposeView.ensureCompositionCreated.<anonymous> (ComposeView.android.kt:258)");
                        }
                        AbstractComposeView.this.Content(composer, 0);
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                    }
                }));
            } finally {
                this.creatingComposition = false;
            }
        }
    }

    private final boolean isAlive(CompositionContext compositionContext) {
        return !(compositionContext instanceof Recomposer) || ((Recomposer) compositionContext).getCurrentState().getValue().compareTo(Recomposer.State.ShuttingDown) > 0;
    }

    private final CompositionContext resolveParentCompositionContext() {
        CompositionContext compositionContext;
        CompositionContext compositionContextCacheIfAlive = this.parentContext;
        if (compositionContextCacheIfAlive == null) {
            CompositionContext compositionContextFindViewTreeCompositionContext = WindowRecomposer_androidKt.findViewTreeCompositionContext(this);
            CompositionContext compositionContext2 = null;
            compositionContextCacheIfAlive = compositionContextFindViewTreeCompositionContext != null ? cacheIfAlive(compositionContextFindViewTreeCompositionContext) : null;
            if (compositionContextCacheIfAlive == null) {
                WeakReference<CompositionContext> weakReference = this.cachedViewTreeCompositionContext;
                if (weakReference != null && (compositionContext = weakReference.get()) != null && isAlive(compositionContext)) {
                    compositionContext2 = compositionContext;
                }
                return compositionContext2 == null ? cacheIfAlive(WindowRecomposer_androidKt.getWindowRecomposer(this)) : compositionContext2;
            }
        }
        return compositionContextCacheIfAlive;
    }

    private final void setParentContext(CompositionContext compositionContext) {
        if (this.parentContext != compositionContext) {
            this.parentContext = compositionContext;
            if (compositionContext != null) {
                this.cachedViewTreeCompositionContext = null;
            }
            Composition composition = this.composition;
            if (composition != null) {
                composition.dispose();
                this.composition = null;
                if (isAttachedToWindow()) {
                    ensureCompositionCreated();
                }
            }
        }
    }

    private final void setPreviousAttachedWindowToken(IBinder iBinder) {
        if (this.previousAttachedWindowToken != iBinder) {
            this.previousAttachedWindowToken = iBinder;
            this.cachedViewTreeCompositionContext = null;
        }
    }

    @Composable
    @UiComposable
    public abstract void Content(@Nullable Composer composer, int i);

    @Override // android.view.ViewGroup
    public void addView(@Nullable View child) {
        checkAddView();
        super.addView(child);
    }

    @Override // android.view.ViewGroup
    public boolean addViewInLayout(@Nullable View child, int index, @Nullable ViewGroup.LayoutParams params) {
        checkAddView();
        return super.addViewInLayout(child, index, params);
    }

    public final void createComposition() {
        if (this.parentContext == null && !isAttachedToWindow()) {
            throw new IllegalStateException("createComposition requires either a parent reference or the View to be attachedto a window. Attach the View or call setParentCompositionReference.");
        }
        ensureCompositionCreated();
    }

    public final void disposeComposition() {
        Composition composition = this.composition;
        if (composition != null) {
            composition.dispose();
        }
        this.composition = null;
        requestLayout();
    }

    public final boolean getHasComposition() {
        return this.composition != null;
    }

    public boolean getShouldCreateCompositionOnAttachedToWindow() {
        return true;
    }

    public final boolean getShowLayoutBounds() {
        return this.showLayoutBounds;
    }

    public void internalOnLayout$ui_release(boolean changed, int left, int top, int right, int bottom) {
        View childAt = getChildAt(0);
        if (childAt != null) {
            childAt.layout(getPaddingLeft(), getPaddingTop(), (right - left) - getPaddingRight(), (bottom - top) - getPaddingBottom());
        }
    }

    public void internalOnMeasure$ui_release(int widthMeasureSpec, int heightMeasureSpec) {
        View childAt = getChildAt(0);
        if (childAt == null) {
            super.onMeasure(widthMeasureSpec, heightMeasureSpec);
            return;
        }
        childAt.measure(View.MeasureSpec.makeMeasureSpec(Math.max(0, (View.MeasureSpec.getSize(widthMeasureSpec) - getPaddingLeft()) - getPaddingRight()), View.MeasureSpec.getMode(widthMeasureSpec)), View.MeasureSpec.makeMeasureSpec(Math.max(0, (View.MeasureSpec.getSize(heightMeasureSpec) - getPaddingTop()) - getPaddingBottom()), View.MeasureSpec.getMode(heightMeasureSpec)));
        setMeasuredDimension(getPaddingRight() + getPaddingLeft() + childAt.getMeasuredWidth(), getPaddingBottom() + getPaddingTop() + childAt.getMeasuredHeight());
    }

    @Override // android.view.ViewGroup
    public boolean isTransitionGroup() {
        return !this.isTransitionGroupSet || super.isTransitionGroup();
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        setPreviousAttachedWindowToken(getWindowToken());
        if (getShouldCreateCompositionOnAttachedToWindow()) {
            ensureCompositionCreated();
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onLayout(boolean changed, int left, int top, int right, int bottom) {
        internalOnLayout$ui_release(changed, left, top, right, bottom);
    }

    @Override // android.view.View
    public final void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        ensureCompositionCreated();
        internalOnMeasure$ui_release(widthMeasureSpec, heightMeasureSpec);
    }

    @Override // android.view.View
    public void onRtlPropertiesChanged(int layoutDirection) {
        View childAt = getChildAt(0);
        if (childAt == null) {
            return;
        }
        childAt.setLayoutDirection(layoutDirection);
    }

    public final void setParentCompositionContext(@Nullable CompositionContext parent) {
        setParentContext(parent);
    }

    public final void setShowLayoutBounds(boolean z) {
        this.showLayoutBounds = z;
        KeyEvent.Callback childAt = getChildAt(0);
        if (childAt != null) {
            ((Owner) childAt).setShowLayoutBounds(z);
        }
    }

    @Override // android.view.ViewGroup
    public void setTransitionGroup(boolean isTransitionGroup) {
        super.setTransitionGroup(isTransitionGroup);
        this.isTransitionGroupSet = true;
    }

    public final void setViewCompositionStrategy(@NotNull ViewCompositionStrategy strategy) {
        Function0<Unit> function0 = this.disposeViewCompositionStrategy;
        if (function0 != null) {
            function0.invoke();
        }
        this.disposeViewCompositionStrategy = strategy.installFor(this);
    }

    @Override // android.view.ViewGroup
    public boolean shouldDelayChildPressedState() {
        return false;
    }

    @JvmOverloads
    public AbstractComposeView(@NotNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, null);
    }

    public /* synthetic */ AbstractComposeView(Context context, AttributeSet attributeSet, int i, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i2 & 2) != 0 ? null : attributeSet, (i2 & 4) != 0 ? 0 : i);
    }

    @Override // android.view.ViewGroup
    public void addView(@Nullable View child, int index) {
        checkAddView();
        super.addView(child, index);
    }

    @Override // android.view.ViewGroup
    public boolean addViewInLayout(@Nullable View child, int index, @Nullable ViewGroup.LayoutParams params, boolean preventRequestLayout) {
        checkAddView();
        return super.addViewInLayout(child, index, params, preventRequestLayout);
    }

    @JvmOverloads
    public AbstractComposeView(@NotNull Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        setClipChildren(false);
        setClipToPadding(false);
        this.disposeViewCompositionStrategy = ViewCompositionStrategy.INSTANCE.getDefault().installFor(this);
    }

    @Override // android.view.ViewGroup
    public void addView(@Nullable View child, int width, int height) {
        checkAddView();
        super.addView(child, width, height);
    }

    @Override // android.view.ViewGroup, android.view.ViewManager
    public void addView(@Nullable View child, @Nullable ViewGroup.LayoutParams params) {
        checkAddView();
        super.addView(child, params);
    }

    @Override // android.view.ViewGroup
    public void addView(@Nullable View child, int index, @Nullable ViewGroup.LayoutParams params) {
        checkAddView();
        super.addView(child, index, params);
    }

    private static /* synthetic */ void getDisposeViewCompositionStrategy$annotations() {
    }

    @InternalComposeUiApi
    public static /* synthetic */ void getShowLayoutBounds$annotations() {
    }
}
