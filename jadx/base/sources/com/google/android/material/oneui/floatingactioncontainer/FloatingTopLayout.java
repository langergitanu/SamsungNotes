package com.google.android.material.oneui.floatingactioncontainer;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import androidx.annotation.RequiresApi;
import androidx.annotation.VisibleForTesting;
import androidx.appcompat.widget.AbstractC0541b;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.core.oneui.common.internal.log.LogTagHelperKt;
import com.google.android.material.appbar.AppBarLayout;
import com.google.android.material.oneui.floatingactioncontainer.FloatingGroupLayout;
import com.google.android.material.oneui.floatingactioncontainer.FloatingTopLayout;
import com.samsung.android.sdk.bixby2.action.ActionHandler;
import com.samsung.android.support.senl.p148nt.app.sync.cloudsettings.callee.NotesSyncRpcProvider;
import com.samsung.android.support.senl.p148nt.composer.main.screenoff.util.Constants;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.text.StringsKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes5.dex */
@RequiresApi(24)
@Metadata(m13885d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\t\b\u0017\u0018\u0000 \u001f2\u00020\u0001:\u0002\u001f B%\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\u0018\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\n2\b\b\u0002\u0010\u0016\u001a\u00020\nJ\f\u0010\u0017\u001a\u0006\u0012\u0002\b\u00030\u0018H\u0016J\u0006\u0010\u0019\u001a\u00020\nJ\b\u0010\u001a\u001a\u00020\nH\u0016J)\u0010\u001b\u001a\u00020\u00142\u0006\u0010\u0016\u001a\u00020\n2\b\b\u0002\u0010\u001c\u001a\u00020\n2\b\b\u0002\u0010\u001d\u001a\u00020\nH\u0000¢\u0006\u0002\b\u001eR\u001a\u0010\t\u001a\u00020\nX\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\u0014\u0010\u000f\u001a\u00020\u00108VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0011\u0010\u0012¨\u0006!"}, m13886d2 = {"Lcom/google/android/material/oneui/floatingactioncontainer/FloatingTopLayout;", "Lcom/google/android/material/oneui/floatingactioncontainer/FloatingGroupLayout;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "enablePrjAlphaTransition", "", "getEnablePrjAlphaTransition$material_release", "()Z", "setEnablePrjAlphaTransition$material_release", "(Z)V", "logTag", "", "getLogTag", "()Ljava/lang/String;", "enableToolbarItemBackgroundTransition", "", "enable", Constants.IntentExtraValue.SHOW, "getBehavior", "Landroidx/coordinatorlayout/widget/CoordinatorLayout$Behavior;", "isEnabledToolbarItemBackgroundTransition", "needInvalidateBlurViews", "startProjectionViewAlphaAnimationInternal", "animate", NotesSyncRpcProvider.FORCE_SYNC, "startProjectionViewAlphaAnimationInternal$material_release", "Companion", "FloatingTopBehavior", "material_release"}, m13887k = 1, m13888mv = {1, 8, 0}, m13890xi = 48)
public class FloatingTopLayout extends FloatingGroupLayout {
    private static final boolean DEBUG = true;

    @NotNull
    private static final String TAG = "FloatingTopLayout";
    private boolean enablePrjAlphaTransition;

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\b\u0016\u0018\u0000*\b\b\u0000\u0010\u0001*\u00020\u00022\b\u0012\u0004\u0012\u0002H\u00010\u0003B\u0019\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\u0002\u0010\bJ\u0010\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u0017H\u0003J%\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u00172\u0006\u0010\u001b\u001a\u00020\u00172\u0006\u0010\u001c\u001a\u00028\u0000H\u0016¢\u0006\u0002\u0010\u001dJ\u0010\u0010\u001e\u001a\u00020\u00192\u0006\u0010\u001f\u001a\u00020 H\u0016J%\u0010!\u001a\u00020\u00102\u0006\u0010\"\u001a\u00020#2\u0006\u0010\u001c\u001a\u00028\u00002\u0006\u0010$\u001a\u00020\u0017H\u0016¢\u0006\u0002\u0010%J\u001d\u0010&\u001a\u00020\u00192\u0006\u0010'\u001a\u00020\n2\u0006\u0010\u001c\u001a\u00028\u0000H\u0002¢\u0006\u0002\u0010(J%\u0010)\u001a\u00020\u00192\u0006\u0010\u001c\u001a\u00028\u00002\u0006\u0010\u001a\u001a\u00020\u00172\u0006\u0010\u001b\u001a\u00020\u0017H\u0002¢\u0006\u0002\u0010*R\u001c\u0010\t\u001a\u0004\u0018\u00010\nX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\u001a\u0010\u000f\u001a\u00020\u0010X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\u0011\"\u0004\b\u0012\u0010\u0013¨\u0006+"}, m13886d2 = {"Lcom/google/android/material/oneui/floatingactioncontainer/FloatingTopLayout$FloatingTopBehavior;", "T", "Lcom/google/android/material/oneui/floatingactioncontainer/FloatingTopLayout;", "Lcom/google/android/material/oneui/floatingactioncontainer/FloatingGroupLayout$FloatingActionBehavior;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "appbarLayout", "Lcom/google/android/material/appbar/AppBarLayout;", "getAppbarLayout", "()Lcom/google/android/material/appbar/AppBarLayout;", "setAppbarLayout", "(Lcom/google/android/material/appbar/AppBarLayout;)V", "isFirstLayoutChild", "", "()Z", "setFirstLayoutChild", "(Z)V", "getStateString", "", "state", "", "onAppBarStateChanged", "", "oldState", "newState", "child", "(IILcom/google/android/material/oneui/floatingactioncontainer/FloatingTopLayout;)V", "onAttachedToLayoutParams", ActionHandler.PARAMS, "Landroidx/coordinatorlayout/widget/CoordinatorLayout$LayoutParams;", "onLayoutChild", "parent", "Landroidx/coordinatorlayout/widget/CoordinatorLayout;", "layoutDirection", "(Landroidx/coordinatorlayout/widget/CoordinatorLayout;Lcom/google/android/material/oneui/floatingactioncontainer/FloatingTopLayout;I)Z", "performFirstLayoutChild", "appBarLayout", "(Lcom/google/android/material/appbar/AppBarLayout;Lcom/google/android/material/oneui/floatingactioncontainer/FloatingTopLayout;)V", "startProjectionViewAlphaAnimationByAppBarStateChanged", "(Lcom/google/android/material/oneui/floatingactioncontainer/FloatingTopLayout;II)V", "material_release"}, m13887k = 1, m13888mv = {1, 8, 0}, m13890xi = 48)
    @SourceDebugExtension({"SMAP\nFloatingTopLayout.kt\nKotlin\n*S Kotlin\n*F\n+ 1 FloatingTopLayout.kt\ncom/google/android/material/oneui/floatingactioncontainer/FloatingTopLayout$FloatingTopBehavior\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,178:1\n1#2:179\n*E\n"})
    public static class FloatingTopBehavior<T extends FloatingTopLayout> extends FloatingGroupLayout.FloatingActionBehavior<T> {

        @Nullable
        private AppBarLayout appbarLayout;
        private boolean isFirstLayoutChild;

        public /* synthetic */ FloatingTopBehavior(Context context, AttributeSet attributeSet, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this(context, (i & 2) != 0 ? null : attributeSet);
        }

        @VisibleForTesting
        private final String getStateString(int state) {
            String strM756B = (state & 4) != 0 ? "HIDE " : "";
            if ((state & 2) != 0) {
                strM756B = AbstractC0541b.m756B(strM756B, "COLLAPSED ");
            }
            if ((state & 1) != 0) {
                strM756B = AbstractC0541b.m756B(strM756B, "EXPANDED");
            }
            return "[ " + StringsKt.trim((CharSequence) strM756B).toString() + " ]";
        }

        private final void performFirstLayoutChild(AppBarLayout appBarLayout, T child) {
            final T t;
            if ((appBarLayout.seslGetAppBarState().getState() & 4) != 0) {
                t = child;
                FloatingTopLayout.m3500x6e4cc6f7(t, true, false, false, 4, null);
            } else {
                t = child;
                FloatingTopLayout.m3500x6e4cc6f7(t, false, false, false, 4, null);
            }
            appBarLayout.seslAddAppBarStateChangedListener(new AppBarLayout.AppBarStateChangedListener() { // from class: com.google.android.material.oneui.floatingactioncontainer.f
                @Override // com.google.android.material.appbar.AppBarLayout.AppBarStateChangedListener
                public final void onStateChanged(int i, int i2) {
                    FloatingTopLayout.FloatingTopBehavior.performFirstLayoutChild$lambda$7(this.f2323a, t, i, i2);
                }
            });
            this.isFirstLayoutChild = false;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void performFirstLayoutChild$lambda$7(FloatingTopBehavior this$0, FloatingTopLayout child, int i, int i2) {
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            Intrinsics.checkNotNullParameter(child, "$child");
            this$0.onAppBarStateChanged(i, i2, child);
        }

        private final void startProjectionViewAlphaAnimationByAppBarStateChanged(T child, int oldState, int newState) {
            int i = newState & 4;
            if (i != 0 && (oldState & 4) == 0) {
                FloatingTopLayout.m3500x6e4cc6f7(child, true, false, false, 6, null);
            } else {
                if (i != 0 || (oldState & 4) == 0) {
                    return;
                }
                FloatingTopLayout.m3500x6e4cc6f7(child, false, false, false, 6, null);
            }
        }

        @Nullable
        public final AppBarLayout getAppbarLayout() {
            return this.appbarLayout;
        }

        /* JADX INFO: renamed from: isFirstLayoutChild, reason: from getter */
        public final boolean getIsFirstLayoutChild() {
            return this.isFirstLayoutChild;
        }

        public void onAppBarStateChanged(int oldState, int newState, @NotNull T child) {
            Intrinsics.checkNotNullParameter(child, "child");
            LogTagHelperKt.info(this, "AppBarState Changed old:" + getStateString(oldState) + " new:" + getStateString(newState));
            startProjectionViewAlphaAnimationByAppBarStateChanged(child, oldState, newState);
        }

        @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
        public void onAttachedToLayoutParams(@NotNull CoordinatorLayout.LayoutParams params) {
            Intrinsics.checkNotNullParameter(params, "params");
            if ((params.getAnchorId() == -1 ? params : null) != null) {
                LogTagHelperKt.error(this, "anchorId is not set");
            }
            CoordinatorLayout.LayoutParams layoutParams = params.gravity == 0 ? params : null;
            if (layoutParams != null) {
                layoutParams.gravity = 48;
            }
            if (params.anchorGravity != 0) {
                params = null;
            }
            if (params != null) {
                params.anchorGravity = 80;
            }
        }

        public final void setAppbarLayout(@Nullable AppBarLayout appBarLayout) {
            this.appbarLayout = appBarLayout;
        }

        public final void setFirstLayoutChild(boolean z) {
            this.isFirstLayoutChild = z;
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public FloatingTopBehavior(@NotNull Context context, @Nullable AttributeSet attributeSet) {
            super(context, attributeSet);
            Intrinsics.checkNotNullParameter(context, "context");
            this.isFirstLayoutChild = true;
        }

        @Override // com.google.android.material.oneui.floatingactioncontainer.FloatingGroupLayout.FloatingActionBehavior
        public boolean onLayoutChild(@NotNull CoordinatorLayout parent, @NotNull T child, int layoutDirection) {
            Intrinsics.checkNotNullParameter(parent, "parent");
            Intrinsics.checkNotNullParameter(child, "child");
            List<View> dependencies = parent.getDependencies(child);
            Intrinsics.checkNotNullExpressionValue(dependencies, "parent.getDependencies(child)");
            AppBarLayout appBarLayout$material_release = child.getAppBarLayout$material_release(dependencies);
            if (appBarLayout$material_release != null) {
                LogTagHelperKt.info(this, "onLayoutChild of Behavior First AppBarState " + getStateString(appBarLayout$material_release.seslGetAppBarState().getState()));
                if (this.isFirstLayoutChild) {
                    performFirstLayoutChild(appBarLayout$material_release, child);
                    FloatingGroupLayout.SeslProjectionView.startProjectionViewItemAnimation$default(child.getProjectionView(), false, 1, null);
                }
                this.appbarLayout = appBarLayout$material_release;
            }
            return false;
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public FloatingTopLayout(@NotNull Context context) {
        this(context, null, 0, 6, null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    public static /* synthetic */ void enableToolbarItemBackgroundTransition$default(FloatingTopLayout floatingTopLayout, boolean z, boolean z2, int i, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: enableToolbarItemBackgroundTransition");
        }
        if ((i & 2) != 0) {
            z2 = true;
        }
        floatingTopLayout.enableToolbarItemBackgroundTransition(z, z2);
    }

    /* JADX INFO: renamed from: startProjectionViewAlphaAnimationInternal$material_release$default */
    public static /* synthetic */ void m3500x6e4cc6f7(FloatingTopLayout floatingTopLayout, boolean z, boolean z2, boolean z3, int i, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: startProjectionViewAlphaAnimationInternal");
        }
        if ((i & 2) != 0) {
            z2 = true;
        }
        if ((i & 4) != 0) {
            z3 = false;
        }
        floatingTopLayout.startProjectionViewAlphaAnimationInternal$material_release(z, z2, z3);
    }

    public final void enableToolbarItemBackgroundTransition(boolean enable, boolean show) {
        LogTagHelperKt.info(this, "enable Toolbar Item BG Transition enabled:" + enable + " show:" + show);
        this.enablePrjAlphaTransition = enable;
        if (!enable) {
            showFloatingItemBackground(show, false);
            return;
        }
        AppBarLayout appBarLayout$material_release = getAppBarLayout$material_release();
        if (appBarLayout$material_release != null) {
            m3500x6e4cc6f7(this, appBarLayout$material_release.seslIsHided(), false, false, 6, null);
        }
    }

    @Override // com.google.android.material.oneui.floatingactioncontainer.FloatingGroupLayout, androidx.coordinatorlayout.widget.CoordinatorLayout.AttachedBehavior
    @NotNull
    public CoordinatorLayout.Behavior<?> getBehavior() {
        Context context = getContext();
        Intrinsics.checkNotNullExpressionValue(context, "context");
        return new FloatingTopBehavior(context, getAttrs());
    }

    /* JADX INFO: renamed from: getEnablePrjAlphaTransition$material_release, reason: from getter */
    public final boolean getEnablePrjAlphaTransition() {
        return this.enablePrjAlphaTransition;
    }

    @Override // com.google.android.material.oneui.floatingactioncontainer.FloatingGroupLayout, androidx.core.oneui.common.internal.log.LogTag
    @NotNull
    public String getLogTag() {
        return TAG;
    }

    public final boolean isEnabledToolbarItemBackgroundTransition() {
        return this.enablePrjAlphaTransition;
    }

    @Override // com.google.android.material.oneui.floatingactioncontainer.FloatingGroupLayout
    public boolean needInvalidateBlurViews() {
        return (getAlpha() == 0.0f || getProjectionView().getAlpha() == 0.0f) ? false : true;
    }

    public final void setEnablePrjAlphaTransition$material_release(boolean z) {
        this.enablePrjAlphaTransition = z;
    }

    public final void startProjectionViewAlphaAnimationInternal$material_release(boolean show, boolean animate, boolean force) {
        if (force || this.enablePrjAlphaTransition) {
            float f = show ? 1.0f : 0.0f;
            FloatingGroupLayout.SeslProjectionView.startProjectionViewItemAnimation$default(getProjectionView(), false, 1, null);
            getProjectionView().startProjectionViewAlphaAnimation(f, !animate);
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public FloatingTopLayout(@NotNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    public /* synthetic */ FloatingTopLayout(Context context, AttributeSet attributeSet, int i, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i2 & 2) != 0 ? null : attributeSet, (i2 & 4) != 0 ? 0 : i);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public FloatingTopLayout(@NotNull Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        Intrinsics.checkNotNullParameter(context, "context");
        this.enablePrjAlphaTransition = true;
    }
}
