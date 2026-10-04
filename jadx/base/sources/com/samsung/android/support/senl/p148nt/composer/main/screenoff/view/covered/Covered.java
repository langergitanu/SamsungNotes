package com.samsung.android.support.senl.p148nt.composer.main.screenoff.view.covered;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Build;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowInsets;
import android.view.WindowManager;
import com.samsung.android.mcf.continuity.interfaces.ContinuityCommand;
import com.samsung.android.support.senl.p145cm.base.framework.view.DisplayCutoutCompat;
import com.samsung.android.support.senl.p145cm.base.framework.view.ViewCompat;
import com.samsung.android.support.senl.p145cm.base.framework.view.WindowInsetsCompat;
import com.samsung.android.support.senl.p145cm.base.framework.view.WindowManagerCompat;
import com.samsung.android.support.senl.p148nt.app.addons.AbstractC8014b;
import com.samsung.android.support.senl.p148nt.composer.C9086R;
import com.samsung.android.support.senl.p148nt.composer.main.screenoff.presenter.covered.CoveredContract;
import com.samsung.android.support.senl.p148nt.composer.main.screenoff.presenter.covered.CoveredPresenter;
import com.samsung.android.support.senl.p148nt.composer.main.screenoff.util.SOLogger;
import com.samsung.android.support.senl.p148nt.composer.main.screenoff.util.feature.CoveredAnimationFeature;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import p059N3.ViewOnApplyWindowInsetsListenerC0186a;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(m13885d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\b\u0018\u0000 \u001f2\u00020\u0001:\u0001\u001fB%\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\u0004\b\b\u0010\tJ\u0018\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u0018H\u0016J\u0010\u0010\u0019\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u0016H\u0016J\b\u0010\u001a\u001a\u00020\u0014H\u0016J\n\u0010\u001b\u001a\u0004\u0018\u00010\u0012H\u0016J\b\u0010\u001c\u001a\u00020\u0014H\u0002J\b\u0010\u001d\u001a\u00020\u0014H\u0003J\b\u0010\u001e\u001a\u00020\u0014H\u0002R\u0010\u0010\n\u001a\u0004\u0018\u00010\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u000b\u001a\u0004\u0018\u00010\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\f\u001a\u0004\u0018\u00010\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\r\u001a\u0004\u0018\u00010\u000eX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000f\u001a\u0004\u0018\u00010\u0010X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0011\u001a\u0004\u0018\u00010\u0012X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006 "}, m13886d2 = {"Lcom/samsung/android/support/senl/nt/composer/main/screenoff/view/covered/Covered;", "Lcom/samsung/android/support/senl/nt/composer/main/screenoff/presenter/covered/CoveredContract$IView;", "context", "Landroid/content/Context;", "presenter", "Lcom/samsung/android/support/senl/nt/composer/main/screenoff/presenter/covered/CoveredPresenter;", "coveredListener", "Lcom/samsung/android/support/senl/nt/composer/main/screenoff/view/covered/ICoveredListener;", "<init>", "(Landroid/content/Context;Lcom/samsung/android/support/senl/nt/composer/main/screenoff/presenter/covered/CoveredPresenter;Lcom/samsung/android/support/senl/nt/composer/main/screenoff/view/covered/ICoveredListener;)V", "mContext", "mPresenter", "mCoveredListener", "mWindowManager", "Landroid/view/WindowManager;", "mWindowParams", "Landroid/view/WindowManager$LayoutParams;", "mView", "Landroid/view/View;", "init", "", "visibility", "", "withAnimation", "", "updateVisibility", "onDetachView", "getView", "initializeWindowParams", "initializeView", "setSystemUiVisibility", "Companion", "ntComposer_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
public final class Covered implements CoveredContract.IView {

    @NotNull
    private static final String TAG = SOLogger.createTag("Covered");

    @Nullable
    private final Context mContext;

    @Nullable
    private ICoveredListener mCoveredListener;

    @Nullable
    private CoveredPresenter mPresenter;

    @Nullable
    private View mView;

    @Nullable
    private WindowManager mWindowManager;

    @Nullable
    private WindowManager.LayoutParams mWindowParams;

    public Covered(@Nullable Context context, @Nullable CoveredPresenter coveredPresenter, @Nullable ICoveredListener iCoveredListener) {
        SOLogger.INSTANCE.SOLoggerD(TAG, "Covered#");
        this.mContext = context;
        this.mPresenter = coveredPresenter;
        if (coveredPresenter != null) {
            coveredPresenter.setView(this);
        }
        this.mCoveredListener = iCoveredListener;
        initializeWindowParams();
        initializeView();
        setSystemUiVisibility();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final WindowInsets init$lambda$0(Covered covered, View v, WindowInsets insets) {
        Intrinsics.checkNotNullParameter(v, "v");
        Intrinsics.checkNotNullParameter(insets, "insets");
        if (covered.mPresenter != null && WindowInsetsCompat.INSTANCE.getInstance().isFullScreenWindow(insets)) {
            WindowManagerCompat.INSTANCE.getInstance().clearWindowFlag(covered.mWindowManager, covered.mView, covered.mWindowParams, 2097152, true);
            View view = covered.mView;
            if (view != null) {
                view.setOnApplyWindowInsetsListener(null);
            }
            CoveredPresenter coveredPresenter = covered.mPresenter;
            if (coveredPresenter != null) {
                coveredPresenter.onStartAnimation();
            }
        }
        View view2 = covered.mView;
        WindowInsets windowInsetsOnApplyWindowInsets = view2 != null ? view2.onApplyWindowInsets(insets) : null;
        Intrinsics.checkNotNull(windowInsetsOnApplyWindowInsets);
        return windowInsetsOnApplyWindowInsets;
    }

    @SuppressLint({"InflateParams"})
    private final void initializeView() {
        SOLogger.INSTANCE.SOLoggerD(TAG, "initializeView#");
        Context context = this.mContext;
        Object systemService = context != null ? context.getSystemService("layout_inflater") : null;
        Intrinsics.checkNotNull(systemService, "null cannot be cast to non-null type android.view.LayoutInflater");
        this.mView = ((LayoutInflater) systemService).inflate(C9086R.layout.screenoff_covered_layout, (ViewGroup) null);
    }

    private final void initializeWindowParams() {
        WindowManager.LayoutParams displayCutoutMode;
        SOLogger.INSTANCE.SOLoggerD(TAG, "initializeWindowParams#");
        Context context = this.mContext;
        Object systemService = context != null ? context.getSystemService("window") : null;
        Intrinsics.checkNotNull(systemService, "null cannot be cast to non-null type android.view.WindowManager");
        this.mWindowManager = (WindowManager) systemService;
        WindowManager.LayoutParams layoutParams = new WindowManager.LayoutParams(ContinuityCommand.CMD_ASYNC_UNREGISTER_SIMPLE_MESSAGE_LISTENER, 17696544, -3);
        layoutParams.width = -1;
        layoutParams.height = -1;
        layoutParams.gravity = 51;
        layoutParams.softInputMode = 32;
        WindowManager.LayoutParams layoutParams2 = (Build.VERSION.SDK_INT < 28 || (displayCutoutMode = DisplayCutoutCompat.INSTANCE.getInstance().setDisplayCutoutMode(layoutParams, 1)) == null) ? layoutParams : displayCutoutMode;
        WindowManagerCompat.Companion companion = WindowManagerCompat.INSTANCE;
        companion.getInstance().addWindowFlag(this.mWindowManager, this.mView, layoutParams2, 2097152, true);
        companion.getInstance().setExtensionFlagDozeMode(layoutParams2);
        companion.getInstance().setExtensionFlagMultiWindowHandlerHidden(layoutParams2);
        if (CoveredAnimationFeature.INSTANCE.needToStartCoveredAnimation()) {
            layoutParams2.flags |= 8;
        }
        this.mWindowParams = layoutParams2;
    }

    private final void setSystemUiVisibility() {
        SOLogger.INSTANCE.SOLoggerD(TAG, "setSystemUiVisibility#");
        ViewCompat companion = ViewCompat.INSTANCE.getInstance();
        View view = this.mView;
        companion.setSystemUiVisibility(view != null ? view.getRootView() : null, 5382, true, true, true);
    }

    @Override // com.samsung.android.support.senl.nt.composer.main.screenoff.presenter.covered.CoveredContract.IView
    @Nullable
    /* JADX INFO: renamed from: getView, reason: from getter */
    public View getMView() {
        return this.mView;
    }

    @Override // com.samsung.android.support.senl.nt.composer.main.screenoff.presenter.covered.CoveredContract.IView
    public void init(int visibility, boolean withAnimation) {
        View view;
        SOLogger.INSTANCE.SOLoggerD(TAG, "init# visibility/withAnimation " + visibility + "/" + withAnimation);
        try {
            updateVisibility(visibility);
            WindowManager windowManager = this.mWindowManager;
            if (windowManager != null) {
                windowManager.addView(this.mView, this.mWindowParams);
            }
            if (!withAnimation || (view = this.mView) == null) {
                return;
            }
            view.setOnApplyWindowInsetsListener(new ViewOnApplyWindowInsetsListenerC0186a(this, 1));
        } catch (Exception e) {
            AbstractC8014b.m7208j("init# ", e.getMessage(), SOLogger.INSTANCE, TAG);
        }
    }

    @Override // com.samsung.android.support.senl.nt.composer.main.screenoff.presenter.covered.CoveredContract.IView
    public void onDetachView() {
        SOLogger.INSTANCE.SOLoggerD(TAG, "onDetachView#");
        ICoveredListener iCoveredListener = this.mCoveredListener;
        if (iCoveredListener != null) {
            iCoveredListener.notifyOnDestroy();
        }
        CoveredPresenter coveredPresenter = this.mPresenter;
        if (coveredPresenter != null) {
            coveredPresenter.onCancelAnimation();
        }
        View view = this.mView;
        if (view != null) {
            view.setOnApplyWindowInsetsListener(null);
        }
        try {
            WindowManager windowManager = this.mWindowManager;
            if (windowManager != null) {
                windowManager.removeView(this.mView);
            }
        } catch (Exception e) {
            AbstractC8014b.m7208j("onDestroy# ", e.getMessage(), SOLogger.INSTANCE, TAG);
        }
        this.mPresenter = null;
        this.mCoveredListener = null;
        this.mWindowManager = null;
        this.mWindowParams = null;
        this.mView = null;
    }

    @Override // com.samsung.android.support.senl.nt.composer.main.screenoff.presenter.covered.CoveredContract.IView
    public void updateVisibility(int visibility) {
        AbstractC8014b.m7206h("updateVisibility# visibility ", visibility, SOLogger.INSTANCE, TAG);
        View view = this.mView;
        if (view != null) {
            view.setVisibility(visibility);
        }
    }
}
