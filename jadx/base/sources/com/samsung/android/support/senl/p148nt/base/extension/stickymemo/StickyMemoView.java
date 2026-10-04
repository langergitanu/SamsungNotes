package com.samsung.android.support.senl.p148nt.base.extension.stickymemo;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.PointF;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import androidx.annotation.AttrRes;
import com.airbnb.lottie.LottieAnimationView;
import com.airbnb.lottie.LottieProperty;
import com.airbnb.lottie.model.KeyPath;
import com.airbnb.lottie.value.LottieFrameInfo;
import com.airbnb.lottie.value.SimpleLottieValueCallback;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.samsung.android.sdk.pen.worddoc.SpenWNote;
import com.samsung.android.support.senl.p145cm.base.framework.view.ViewCompat;
import com.samsung.android.support.senl.p148nt.app.sync.cloudsettings.callee.NotesSyncRpcProvider;
import com.samsung.android.support.senl.p148nt.base.C8875R;
import com.samsung.android.support.senl.p148nt.base.extension.stickymemo.FloatingControl;
import com.samsung.android.support.senl.p148nt.base.extension.stickymemo.SmViewConfig;
import com.samsung.android.support.senl.p148nt.base.extension.stickymemo.StickyMemoView;
import com.samsung.android.support.senl.p148nt.base.extension.stickymemo.common.util.SmLogger;
import com.samsung.android.support.senl.p148nt.base.extension.stickymemo.composer.SmComposerView;
import com.samsung.android.support.senl.p148nt.base.extension.stickymemo.composer.control.ControlFactory;
import com.samsung.android.support.senl.p148nt.base.extension.stickymemo.composer.control.SmControlManager;
import com.samsung.android.support.senl.p148nt.base.extension.stickymemo.composer.control.ToolShareControl;
import com.samsung.android.support.senl.p148nt.base.extension.stickymemo.composer.listener.SpenTextManagerActionListenerImpl;
import com.samsung.android.support.senl.p148nt.base.extension.stickymemo.composer.sip.SipController;
import com.samsung.android.support.senl.p148nt.base.extension.stickymemo.document.SmDocumentManager;
import com.samsung.android.support.senl.p148nt.base.extension.stickymemo.toolbar.SmToolbar;
import com.samsung.android.support.senl.p148nt.base.winset.toast.ToastHandler;
import com.samsung.android.support.senl.p148nt.composer.main.screenoff.util.Constants;
import java.io.IOException;
import kotlin.Metadata;
import kotlin.collections.ArraysKt;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes2.dex */
@Metadata(m13885d1 = {"\u0000¨\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0007\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u0000 _2\u00020\u0001:\u0003^_`B'\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0003\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tJ\b\u00108\u001a\u000209H\u0014J:\u0010:\u001a\u0002092\u0006\u0010;\u001a\u00020\u00072\u0006\u0010<\u001a\u00020\u00072\u0006\u0010=\u001a\u00020\u00072\u0006\u0010>\u001a\u00020\u00072\u0006\u0010?\u001a\u00020\u00072\b\b\u0002\u0010@\u001a\u00020AH\u0007J\u000e\u0010:\u001a\u0002092\u0006\u0010 \u001a\u00020!J\b\u0010B\u001a\u000209H\u0002J\b\u0010C\u001a\u000209H\u0002J\u0018\u0010D\u001a\u0002092\u0006\u0010E\u001a\u00020\u00072\b\b\u0002\u0010F\u001a\u00020GJ\u0010\u0010H\u001a\u0002092\b\u0010I\u001a\u0004\u0018\u000107J\u0006\u0010J\u001a\u000209J\u0006\u0010K\u001a\u000209J\u0006\u0010L\u001a\u000209J\u0006\u0010M\u001a\u00020GJ\u0006\u0010N\u001a\u00020OJ\u0010\u0010P\u001a\u0002092\u0006\u0010Q\u001a\u00020RH\u0014J\u0006\u0010S\u001a\u00020GJ\u0006\u0010T\u001a\u000209J\u0006\u0010U\u001a\u000209J\u000e\u0010V\u001a\u0002092\u0006\u0010W\u001a\u00020GJ\u000e\u0010X\u001a\u0002092\u0006\u0010Y\u001a\u00020GJ\u0006\u0010Z\u001a\u00020[J\u0006\u0010\\\u001a\u00020]R\u000e\u0010\n\u001a\u00020\u000bX\u0082.¢\u0006\u0002\n\u0000R\u001a\u0010\f\u001a\u00020\rX\u0086.¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R\u001a\u0010\u0012\u001a\u00020\u0013X\u0086.¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017R\u0012\u0010\u0018\u001a\u00060\u0019R\u00020\u0000X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u001a\u001a\u00020\u001bX\u0082\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\u001c\u001a\u00020\u001d¢\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u001fR\u001a\u0010 \u001a\u00020!X\u0086.¢\u0006\u000e\n\u0000\u001a\u0004\b\"\u0010#\"\u0004\b$\u0010%R\u000e\u0010&\u001a\u00020'X\u0082.¢\u0006\u0002\n\u0000R\u0010\u0010(\u001a\u0004\u0018\u00010)X\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u0010*\u001a\u00020+X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b,\u0010-\"\u0004\b.\u0010/R\u001c\u00100\u001a\u0004\u0018\u000101X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b2\u00103\"\u0004\b4\u00105R\u0010\u00106\u001a\u0004\u0018\u000107X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006a"}, m13886d2 = {"Lcom/samsung/android/support/senl/nt/base/extension/stickymemo/StickyMemoView;", "Landroid/widget/FrameLayout;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "writingContainerView", "Landroid/view/ViewGroup;", "topDecorView", "Landroid/widget/ImageView;", "getTopDecorView", "()Landroid/widget/ImageView;", "setTopDecorView", "(Landroid/widget/ImageView;)V", "lottieAnimationView", "Lcom/airbnb/lottie/LottieAnimationView;", "getLottieAnimationView", "()Lcom/airbnb/lottie/LottieAnimationView;", "setLottieAnimationView", "(Lcom/airbnb/lottie/LottieAnimationView;)V", "decorator", "Lcom/samsung/android/support/senl/nt/base/extension/stickymemo/StickyMemoView$SmDecorator;", "writingView", "Lcom/samsung/android/support/senl/nt/base/extension/stickymemo/composer/SmComposerView;", "docManager", "Lcom/samsung/android/support/senl/nt/base/extension/stickymemo/document/SmDocumentManager;", "getDocManager", "()Lcom/samsung/android/support/senl/nt/base/extension/stickymemo/document/SmDocumentManager;", "viewConfig", "Lcom/samsung/android/support/senl/nt/base/extension/stickymemo/SmViewConfig;", "getViewConfig", "()Lcom/samsung/android/support/senl/nt/base/extension/stickymemo/SmViewConfig;", "setViewConfig", "(Lcom/samsung/android/support/senl/nt/base/extension/stickymemo/SmViewConfig;)V", "topToolbar", "Lcom/samsung/android/support/senl/nt/base/extension/stickymemo/toolbar/SmToolbar;", "floatingControl", "Lcom/samsung/android/support/senl/nt/base/extension/stickymemo/FloatingControl;", "controlFactory", "Lcom/samsung/android/support/senl/nt/base/extension/stickymemo/composer/control/ControlFactory;", "getControlFactory", "()Lcom/samsung/android/support/senl/nt/base/extension/stickymemo/composer/control/ControlFactory;", "setControlFactory", "(Lcom/samsung/android/support/senl/nt/base/extension/stickymemo/composer/control/ControlFactory;)V", "toolbarActionListener", "Lcom/samsung/android/support/senl/nt/base/extension/stickymemo/toolbar/SmToolbar$ActionListener;", "getToolbarActionListener", "()Lcom/samsung/android/support/senl/nt/base/extension/stickymemo/toolbar/SmToolbar$ActionListener;", "setToolbarActionListener", "(Lcom/samsung/android/support/senl/nt/base/extension/stickymemo/toolbar/SmToolbar$ActionListener;)V", "actionListener", "Lcom/samsung/android/support/senl/nt/base/extension/stickymemo/StickyMemoView$OnActionListener;", "onFinishInflate", "", Constants.IntentExtraValue.SHOW, "x", "y", "width", "height", "docWidth", "filePath", "", "initView", "initFloatingControl", "updateBackgroundColor", "color", NotesSyncRpcProvider.FORCE_SYNC, "", "setOnActionListener", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "saveDoc", "release", "releaseControl", "onBackPressed", "getLeftTop", "Landroid/graphics/PointF;", "onConfigurationChanged", "newConfig", "Landroid/content/res/Configuration;", "isEmptyNewMemo", "showToastNothingToSave", "requestFocusWritingView", "notifyAnimationState", "start", "updateDarkTheme", "isViewDarkTheme", "getComposerView", "Landroid/view/View;", "getSmViewControlManager", "Lcom/samsung/android/support/senl/nt/base/extension/stickymemo/composer/control/SmControlManager;", "OnActionListener", "Companion", "SmDecorator", "ntBase_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
@SourceDebugExtension({"SMAP\nStickyMemoView.kt\nKotlin\n*S Kotlin\n*F\n+ 1 StickyMemoView.kt\ncom/samsung/android/support/senl/nt/base/extension/stickymemo/StickyMemoView\n+ 2 View.kt\nandroidx/core/view/ViewKt\n*L\n1#1,354:1\n348#2:355\n*S KotlinDebug\n*F\n+ 1 StickyMemoView.kt\ncom/samsung/android/support/senl/nt/base/extension/stickymemo/StickyMemoView\n*L\n201#1:355\n*E\n"})
public final class StickyMemoView extends FrameLayout {

    @NotNull
    private static final String TAG = SmLogger.createTag("StickyMemoView");

    @Nullable
    private OnActionListener actionListener;

    @NotNull
    private ControlFactory controlFactory;

    @NotNull
    private final SmDecorator decorator;

    @NotNull
    private final SmDocumentManager docManager;

    @Nullable
    private FloatingControl floatingControl;
    public LottieAnimationView lottieAnimationView;

    @Nullable
    private SmToolbar.ActionListener toolbarActionListener;
    public ImageView topDecorView;
    private SmToolbar topToolbar;
    public SmViewConfig viewConfig;
    private ViewGroup writingContainerView;

    @NotNull
    private final SmComposerView writingView;

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&¨\u0006\u0006"}, m13886d2 = {"Lcom/samsung/android/support/senl/nt/base/extension/stickymemo/StickyMemoView$OnActionListener;", "", "onClosed", "", "view", "Landroid/view/View;", "ntBase_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
    public interface OnActionListener {
        void onClosed(@NotNull View view);
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public StickyMemoView(@NotNull Context context) {
        this(context, null, 0, 6, null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    private final void initFloatingControl() {
        Object parent = getParent();
        Intrinsics.checkNotNull(parent, "null cannot be cast to non-null type android.view.View");
        FloatingControl floatingControl = new FloatingControl(this, (View) parent, new FloatingControl.ISpenView() { // from class: com.samsung.android.support.senl.nt.base.extension.stickymemo.StickyMemoView.initFloatingControl.1
            @Override // com.samsung.android.support.senl.nt.base.extension.stickymemo.FloatingControl.ISpenView
            public void close() {
                SmToolbar.ActionListener toolbarActionListener = StickyMemoView.this.getToolbarActionListener();
                if (toolbarActionListener != null) {
                    toolbarActionListener.onCloseClicked(false);
                }
            }

            @Override // com.samsung.android.support.senl.nt.base.extension.stickymemo.FloatingControl.ISpenView
            public void endResize() {
                StickyMemoView.this.writingView.getSpenView().endLazyViewUpdate();
            }

            @Override // com.samsung.android.support.senl.nt.base.extension.stickymemo.FloatingControl.ISpenView
            public boolean hasFocus() {
                return StickyMemoView.this.writingView.getSpenView().hasFocus();
            }

            @Override // com.samsung.android.support.senl.nt.base.extension.stickymemo.FloatingControl.ISpenView
            public void readyResize() {
                StickyMemoView.this.writingView.getSpenView().startLazyViewUpdate();
            }
        });
        floatingControl.init();
        SipController sipController = this.controlFactory.getSipController();
        boolean z = false;
        if (sipController != null && sipController.isInputMethodShown()) {
            z = true;
        }
        floatingControl.setSipShowing(z);
        SipController sipController2 = this.controlFactory.getSipController();
        if (sipController2 != null) {
            sipController2.addListener(floatingControl);
        }
        this.floatingControl = floatingControl;
        this.writingView.getListenerManager().getOnFocusChangeListenerImpl().addListener(new View.OnFocusChangeListener() { // from class: com.samsung.android.support.senl.nt.base.extension.stickymemo.a
            @Override // android.view.View.OnFocusChangeListener
            public final void onFocusChange(View view, boolean z2) {
                StickyMemoView.initFloatingControl$lambda$4(this.f6455a, view, z2);
            }
        });
        this.writingView.getListenerManager().getSpenTextManagerActionListenerImpl().setFloatingControl(new SpenTextManagerActionListenerImpl.IFloatingControl() { // from class: com.samsung.android.support.senl.nt.base.extension.stickymemo.StickyMemoView.initFloatingControl.4
            @Override // com.samsung.android.support.senl.nt.base.extension.stickymemo.composer.listener.SpenTextManagerActionListenerImpl.IFloatingControl
            public void moveIntoBounds() {
                FloatingControl floatingControl2 = StickyMemoView.this.floatingControl;
                if (floatingControl2 != null) {
                    floatingControl2.moveIntoBounds();
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void initFloatingControl$lambda$4(StickyMemoView stickyMemoView, View view, boolean z) {
        FloatingControl floatingControl;
        if (!z || (floatingControl = stickyMemoView.floatingControl) == null) {
            return;
        }
        floatingControl.moveIntoBounds();
    }

    private final void initView() {
        SmToolbar smToolbar = new SmToolbar(this, this.writingView);
        smToolbar.setActionListener(new SmToolbar.ActionListener() { // from class: com.samsung.android.support.senl.nt.base.extension.stickymemo.StickyMemoView$initView$1$1
            @Override // com.samsung.android.support.senl.nt.base.extension.stickymemo.toolbar.SmToolbar.ActionListener
            public void onCloseClicked(boolean withAnimation) {
                StickyMemoView.OnActionListener onActionListener = this.this$0.actionListener;
                if (onActionListener != null) {
                    onActionListener.onClosed(this.this$0);
                }
                SmToolbar.ActionListener toolbarActionListener = this.this$0.getToolbarActionListener();
                if (toolbarActionListener != null) {
                    toolbarActionListener.onCloseClicked(withAnimation);
                }
            }

            @Override // com.samsung.android.support.senl.nt.base.extension.stickymemo.toolbar.SmToolbar.ActionListener
            public void onDeleteClicked() {
                StickyMemoView.OnActionListener onActionListener = this.this$0.actionListener;
                if (onActionListener != null) {
                    onActionListener.onClosed(this.this$0);
                }
                SmToolbar.ActionListener toolbarActionListener = this.this$0.getToolbarActionListener();
                if (toolbarActionListener != null) {
                    toolbarActionListener.onDeleteClicked();
                }
            }
        });
        smToolbar.updateTheme(this.writingView.getColorTheme() == 1);
        this.topToolbar = smToolbar;
        if (getViewConfig().getStandalone()) {
            return;
        }
        initFloatingControl();
    }

    public static /* synthetic */ void show$default(StickyMemoView stickyMemoView, int i, int i2, int i4, int i5, int i6, String str, int i7, Object obj) {
        if ((i7 & 32) != 0) {
            str = "";
        }
        stickyMemoView.show(i, i2, i4, i5, i6, str);
    }

    public static /* synthetic */ void updateBackgroundColor$default(StickyMemoView stickyMemoView, int i, boolean z, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            z = false;
        }
        stickyMemoView.updateBackgroundColor(i, z);
    }

    @NotNull
    public final View getComposerView() {
        return this.writingView.getSpenView();
    }

    @NotNull
    public final ControlFactory getControlFactory() {
        return this.controlFactory;
    }

    @NotNull
    public final SmDocumentManager getDocManager() {
        return this.docManager;
    }

    @NotNull
    public final PointF getLeftTop() {
        float translationX = getTranslationX();
        float translationY = getTranslationY();
        ViewGroup viewGroup = this.writingContainerView;
        if (viewGroup == null) {
            Intrinsics.throwUninitializedPropertyAccessException("writingContainerView");
            viewGroup = null;
        }
        ViewGroup.LayoutParams layoutParams = viewGroup.getLayoutParams();
        return new PointF(translationX, translationY + ((layoutParams instanceof ViewGroup.MarginLayoutParams ? (ViewGroup.MarginLayoutParams) layoutParams : null) != null ? r4.topMargin : 0));
    }

    @NotNull
    public final LottieAnimationView getLottieAnimationView() {
        LottieAnimationView lottieAnimationView = this.lottieAnimationView;
        if (lottieAnimationView != null) {
            return lottieAnimationView;
        }
        Intrinsics.throwUninitializedPropertyAccessException("lottieAnimationView");
        return null;
    }

    @NotNull
    public final SmControlManager getSmViewControlManager() {
        return this.writingView.getControlManager();
    }

    @Nullable
    public final SmToolbar.ActionListener getToolbarActionListener() {
        return this.toolbarActionListener;
    }

    @NotNull
    public final ImageView getTopDecorView() {
        ImageView imageView = this.topDecorView;
        if (imageView != null) {
            return imageView;
        }
        Intrinsics.throwUninitializedPropertyAccessException("topDecorView");
        return null;
    }

    @NotNull
    public final SmViewConfig getViewConfig() {
        SmViewConfig smViewConfig = this.viewConfig;
        if (smViewConfig != null) {
            return smViewConfig;
        }
        Intrinsics.throwUninitializedPropertyAccessException("viewConfig");
        return null;
    }

    public final boolean isEmptyNewMemo() {
        SmViewConfig.MemoObjectInfo memoObjectInfo;
        return this.docManager.isEmptyDoc() && (memoObjectInfo = getViewConfig().getMemoObjectInfo()) != null && memoObjectInfo.getIsNew();
    }

    public final void notifyAnimationState(boolean start) {
        ToolShareControl toolShareControl = this.controlFactory.getToolShareControl();
        if (toolShareControl != null) {
            toolShareControl.setStartAnimating(start);
        }
    }

    public final boolean onBackPressed() {
        SmToolbar smToolbar = this.topToolbar;
        if (smToolbar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("topToolbar");
            smToolbar = null;
        }
        if (smToolbar.onBackPressed()) {
            return true;
        }
        return this.writingView.onBackPressed();
    }

    @Override // android.view.View
    public void onConfigurationChanged(@NotNull Configuration newConfig) {
        Intrinsics.checkNotNullParameter(newConfig, "newConfig");
        this.writingView.onConfiguration(newConfig);
        FloatingControl floatingControl = this.floatingControl;
        if (floatingControl != null) {
            floatingControl.onConfigurationChanged(newConfig);
        }
    }

    @Override // android.view.View
    public void onFinishInflate() {
        super.onFinishInflate();
        this.writingContainerView = (ViewGroup) findViewById(C8875R.id.sticky_memo_container);
        ImageView imageView = (ImageView) findViewById(C8875R.id.top_decoration_view);
        imageView.setImportantForAccessibility(2);
        setTopDecorView(imageView);
        setLottieAnimationView((LottieAnimationView) findViewById(C8875R.id.flip_animation_view));
    }

    public final void release() {
        SmLogger smLogger = SmLogger.INSTANCE;
        String strValueOf = String.valueOf(hashCode());
        String str = TAG;
        smLogger.startTime(strValueOf, str, "release# start");
        SmToolbar smToolbar = this.topToolbar;
        if (smToolbar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("topToolbar");
            smToolbar = null;
        }
        smToolbar.release();
        this.writingView.release();
        SmDocumentManager.release$default(this.docManager, false, 1, null);
        FloatingControl floatingControl = this.floatingControl;
        if (floatingControl != null) {
            floatingControl.release();
        }
        smLogger.endTime(String.valueOf(hashCode()), str, "release# end");
    }

    public final void releaseControl() {
        this.writingView.releaseControl();
    }

    public final void requestFocusWritingView() {
        this.writingView.getSpenView().requestFocus();
        ViewCompat.INSTANCE.getInstance().requestAccessibilityFocus(this.writingView.getSpenView());
    }

    public final void saveDoc() throws IOException {
        SmLogger smLogger = SmLogger.INSTANCE;
        String strValueOf = String.valueOf(hashCode());
        String str = TAG;
        smLogger.startTime(strValueOf, str, "saveDoc# start");
        if (isEmptyNewMemo()) {
            smLogger.endTime(String.valueOf(hashCode()), str, "saveDoc# end no save because of empty");
            return;
        }
        this.writingView.requestReadyForSave();
        this.docManager.save();
        smLogger.endTime(String.valueOf(hashCode()), str, "saveDoc# end");
    }

    public final void setControlFactory(@NotNull ControlFactory controlFactory) {
        Intrinsics.checkNotNullParameter(controlFactory, "<set-?>");
        this.controlFactory = controlFactory;
    }

    public final void setLottieAnimationView(@NotNull LottieAnimationView lottieAnimationView) {
        Intrinsics.checkNotNullParameter(lottieAnimationView, "<set-?>");
        this.lottieAnimationView = lottieAnimationView;
    }

    public final void setOnActionListener(@Nullable OnActionListener listener) {
        this.actionListener = listener;
    }

    public final void setToolbarActionListener(@Nullable SmToolbar.ActionListener actionListener) {
        this.toolbarActionListener = actionListener;
    }

    public final void setTopDecorView(@NotNull ImageView imageView) {
        Intrinsics.checkNotNullParameter(imageView, "<set-?>");
        this.topDecorView = imageView;
    }

    public final void setViewConfig(@NotNull SmViewConfig smViewConfig) {
        Intrinsics.checkNotNullParameter(smViewConfig, "<set-?>");
        this.viewConfig = smViewConfig;
    }

    @SuppressLint({"ClickableViewAccessibility"})
    public final void show(int x, int y2, int width, int height, int docWidth, @NotNull String filePath) {
        Intrinsics.checkNotNullParameter(filePath, "filePath");
        setViewConfig(new SmViewConfig(x, y2, width, height, docWidth, filePath, filePath, false, null, 384, null));
        show(getViewConfig());
    }

    public final void showToastNothingToSave() {
        ToastHandler.show(getContext(), C8875R.string.nothing_to_save, 0);
    }

    public final void updateBackgroundColor(int color, boolean force) {
        if (force) {
            this.decorator.setInitialized(false);
        }
        this.decorator.updateDecoration(color);
    }

    public final void updateDarkTheme(boolean isViewDarkTheme) {
        this.writingView.updateDarkTheme(isViewDarkTheme);
        if (this.viewConfig != null) {
            SmToolbar smToolbar = this.topToolbar;
            if (smToolbar == null) {
                Intrinsics.throwUninitializedPropertyAccessException("topToolbar");
                smToolbar = null;
            }
            smToolbar.updateTheme(isViewDarkTheme);
            updateBackgroundColor$default(this, this.writingView.getBackgroundColor(), false, 2, null);
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public StickyMemoView(@NotNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    public /* synthetic */ StickyMemoView(Context context, AttributeSet attributeSet, int i, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i2 & 2) != 0 ? null : attributeSet, (i2 & 4) != 0 ? 0 : i);
    }

    public final void show(@NotNull SmViewConfig viewConfig) {
        Intrinsics.checkNotNullParameter(viewConfig, "viewConfig");
        SmLogger smLogger = SmLogger.INSTANCE;
        String strValueOf = String.valueOf(hashCode());
        String str = TAG;
        smLogger.startTime(strValueOf, str, "show# start");
        setViewConfig(viewConfig);
        getLayoutParams().width = viewConfig.getWidth();
        getLayoutParams().height = viewConfig.getHeight();
        SmDocumentManager smDocumentManager = this.docManager;
        Context context = getContext();
        Intrinsics.checkNotNullExpressionValue(context, "getContext(...)");
        SmDocumentManager.loadDoc$default(smDocumentManager, context, viewConfig.getFilePath(), viewConfig.getSavePath(), viewConfig.getDocWidth(), null, 16, null);
        Integer backgroundColor = this.docManager.getBackgroundColor();
        if (backgroundColor != null) {
            updateBackgroundColor$default(this, backgroundColor.intValue(), false, 2, null);
        }
        SmComposerView smComposerView = this.writingView;
        View viewFindViewById = findViewById(C8875R.id.sticky_memo_layout);
        Intrinsics.checkNotNullExpressionValue(viewFindViewById, "findViewById(...)");
        smComposerView.addViewTo((ViewGroup) viewFindViewById);
        SmComposerView smComposerView2 = this.writingView;
        SpenWNote doc = this.docManager.getDoc();
        Intrinsics.checkNotNull(doc);
        smComposerView2.init(doc, this.controlFactory);
        if (getParent() == null) {
            SmLogger.m8662e(str, "parent is null");
            return;
        }
        initView();
        FloatingControl floatingControl = this.floatingControl;
        if (floatingControl != null) {
            floatingControl.move(viewConfig.getX(), viewConfig.getY());
        }
        smLogger.endTime(String.valueOf(hashCode()), str, "show# end");
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public StickyMemoView(@NotNull Context context, @Nullable AttributeSet attributeSet, @AttrRes int i) {
        super(context, attributeSet, i);
        Intrinsics.checkNotNullParameter(context, "context");
        this.decorator = new SmDecorator();
        SmComposerView smComposerView = new SmComposerView(context);
        this.writingView = smComposerView;
        this.docManager = new SmDocumentManager();
        this.controlFactory = new ControlFactory();
        smComposerView.setBackgroundListener(new SmComposerView.BackgroundListener() { // from class: com.samsung.android.support.senl.nt.base.extension.stickymemo.StickyMemoView.1
            @Override // com.samsung.android.support.senl.nt.base.extension.stickymemo.composer.SmComposerView.BackgroundListener
            public void onBackgroundColorChanged(int color) {
                StickyMemoView.updateBackgroundColor$default(StickyMemoView.this, color, false, 2, null);
            }
        });
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0015\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\b\b\u0082\u0004\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\fH\u0002J\u000e\u0010\u001b\u001a\u00020\u00192\u0006\u0010\u001c\u001a\u00020\u0012J(\u0010\u001b\u001a\u00020\u00192\u0006\u0010\u001c\u001a\u00020\u00122\u0006\u0010\u001d\u001a\u00020\u00052\u0006\u0010\u001e\u001a\u00020\u00052\u0006\u0010\u001f\u001a\u00020\u0005H\u0002J\b\u0010 \u001a\u00020\u0019H\u0002R\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0006\u001a\u0004\u0018\u00010\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0007\u001a\u0004\u0018\u00010\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\b\u001a\u0004\u0018\u00010\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\t\u001a\u0004\u0018\u00010\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\n\u001a\u0004\u0018\u00010\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\u000b\u001a\u00020\fX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R\u000e\u0010\u0011\u001a\u00020\u0012X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0012X\u0082\u000e¢\u0006\u0002\n\u0000R\u001c\u0010\u0014\u001a\u0010\u0012\f\u0012\n \u0016*\u0004\u0018\u00010\u00120\u00120\u0015X\u0082\u000e¢\u0006\u0002\n\u0000R\u001c\u0010\u0017\u001a\u0010\u0012\f\u0012\n \u0016*\u0004\u0018\u00010\u00120\u00120\u0015X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006!"}, m13886d2 = {"Lcom/samsung/android/support/senl/nt/base/extension/stickymemo/StickyMemoView$SmDecorator;", "", "<init>", "(Lcom/samsung/android/support/senl/nt/base/extension/stickymemo/StickyMemoView;)V", "drawableResList", "", "bgColorList", "bgBackColorList", "darkDrawableResList", "darkBgColorList", "darkBgBackColorList", "initialized", "", "getInitialized", "()Z", "setInitialized", "(Z)V", "frontColor", "", "backColor", "frontCallback", "Lcom/airbnb/lottie/value/SimpleLottieValueCallback;", "kotlin.jvm.PlatformType", "backColorCallback", "initRes", "", "isDark", "updateDecoration", "color", "drawables", "frontColors", "backColors", "initCallback", "ntBase_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
    public final class SmDecorator {
        private int backColor;

        @NotNull
        private SimpleLottieValueCallback<Integer> backColorCallback;

        @Nullable
        private int[] bgBackColorList;

        @Nullable
        private int[] bgColorList;

        @Nullable
        private int[] darkBgBackColorList;

        @Nullable
        private int[] darkBgColorList;

        @Nullable
        private int[] darkDrawableResList;

        @Nullable
        private int[] drawableResList;

        @NotNull
        private SimpleLottieValueCallback<Integer> frontCallback;
        private int frontColor;
        private boolean initialized;

        public SmDecorator() {
            final int i = 0;
            this.frontCallback = new SimpleLottieValueCallback(this) { // from class: com.samsung.android.support.senl.nt.base.extension.stickymemo.b

                /* JADX INFO: renamed from: b */
                public final /* synthetic */ StickyMemoView.SmDecorator f6457b;

                {
                    this.f6457b = this;
                }

                @Override // com.airbnb.lottie.value.SimpleLottieValueCallback
                public final Object getValue(LottieFrameInfo lottieFrameInfo) {
                    switch (i) {
                        case 0:
                            return StickyMemoView.SmDecorator.frontCallback$lambda$0(this.f6457b, lottieFrameInfo);
                        default:
                            return StickyMemoView.SmDecorator.backColorCallback$lambda$1(this.f6457b, lottieFrameInfo);
                    }
                }
            };
            final int i2 = 1;
            this.backColorCallback = new SimpleLottieValueCallback(this) { // from class: com.samsung.android.support.senl.nt.base.extension.stickymemo.b

                /* JADX INFO: renamed from: b */
                public final /* synthetic */ StickyMemoView.SmDecorator f6457b;

                {
                    this.f6457b = this;
                }

                @Override // com.airbnb.lottie.value.SimpleLottieValueCallback
                public final Object getValue(LottieFrameInfo lottieFrameInfo) {
                    switch (i2) {
                        case 0:
                            return StickyMemoView.SmDecorator.frontCallback$lambda$0(this.f6457b, lottieFrameInfo);
                        default:
                            return StickyMemoView.SmDecorator.backColorCallback$lambda$1(this.f6457b, lottieFrameInfo);
                    }
                }
            };
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final Integer backColorCallback$lambda$1(SmDecorator smDecorator, LottieFrameInfo lottieFrameInfo) {
            return Integer.valueOf(smDecorator.backColor);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final Integer frontCallback$lambda$0(SmDecorator smDecorator, LottieFrameInfo lottieFrameInfo) {
            return Integer.valueOf(smDecorator.frontColor);
        }

        private final void initCallback() {
            if (this.initialized) {
                return;
            }
            this.initialized = true;
            LottieAnimationView lottieAnimationView = StickyMemoView.this.getLottieAnimationView();
            KeyPath keyPath = new KeyPath("front_memo", "Rectangle 1", "Fill 1");
            Integer num = LottieProperty.COLOR;
            lottieAnimationView.addValueCallback(keyPath, num, this.frontCallback);
            StickyMemoView.this.getLottieAnimationView().addValueCallback(new KeyPath("back_memo", "Rectangle 1", "Fill 1"), num, this.backColorCallback);
        }

        private final void initRes(boolean isDark) {
            if (this.bgColorList == null) {
                this.bgColorList = StickyMemoView.this.getContext().getResources().getIntArray(C8875R.array.sticky_memo_background_color);
            }
            if (!isDark) {
                if (this.drawableResList == null) {
                    Resources resources = StickyMemoView.this.getContext().getResources();
                    this.drawableResList = new int[]{C8875R.drawable.sticky_memo_clip_01, C8875R.drawable.sticky_memo_clip_02, C8875R.drawable.sticky_memo_clip_04, C8875R.drawable.sticky_memo_clip_03};
                    this.bgBackColorList = resources.getIntArray(C8875R.array.sticky_memo_background_color_back);
                    return;
                }
                return;
            }
            if (this.darkDrawableResList == null) {
                Resources resources2 = StickyMemoView.this.getContext().getResources();
                this.darkDrawableResList = new int[]{C8875R.drawable.sticky_memo_clip_dark_01, C8875R.drawable.sticky_memo_clip_dark_02, C8875R.drawable.sticky_memo_clip_dark_04, C8875R.drawable.sticky_memo_clip_dark_03};
                this.darkBgColorList = resources2.getIntArray(C8875R.array.sticky_memo_dark_background_color);
                this.darkBgBackColorList = resources2.getIntArray(C8875R.array.sticky_memo_dark_background_color_back);
            }
        }

        public final boolean getInitialized() {
            return this.initialized;
        }

        public final void setInitialized(boolean z) {
            this.initialized = z;
        }

        public final void updateDecoration(int color) {
            if (StickyMemoView.this.writingView.getColorTheme() == 1) {
                initRes(true);
                int[] iArr = this.darkDrawableResList;
                Intrinsics.checkNotNull(iArr);
                int[] iArr2 = this.darkBgColorList;
                Intrinsics.checkNotNull(iArr2);
                int[] iArr3 = this.darkBgBackColorList;
                Intrinsics.checkNotNull(iArr3);
                updateDecoration(color, iArr, iArr2, iArr3);
                return;
            }
            initRes(false);
            int[] iArr4 = this.drawableResList;
            Intrinsics.checkNotNull(iArr4);
            int[] iArr5 = this.bgColorList;
            Intrinsics.checkNotNull(iArr5);
            int[] iArr6 = this.bgBackColorList;
            Intrinsics.checkNotNull(iArr6);
            updateDecoration(color, iArr4, iArr5, iArr6);
        }

        private final void updateDecoration(int color, int[] drawables, int[] frontColors, int[] backColors) {
            int[] iArr = this.bgColorList;
            if (iArr != null) {
                StickyMemoView stickyMemoView = StickyMemoView.this;
                int iIndexOf = ArraysKt.indexOf(iArr, color);
                if (iIndexOf < 0 || iIndexOf >= iArr.length) {
                    return;
                }
                int i = drawables[iIndexOf];
                this.frontColor = frontColors[iIndexOf];
                this.backColor = backColors[iIndexOf];
                stickyMemoView.getTopDecorView().setImageResource(i);
                initCallback();
                stickyMemoView.getLottieAnimationView().invalidate();
            }
        }
    }
}
