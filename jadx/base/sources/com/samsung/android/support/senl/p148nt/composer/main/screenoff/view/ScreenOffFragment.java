package com.samsung.android.support.senl.p148nt.composer.main.screenoff.view;

import android.content.res.Configuration;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.RelativeLayout;
import androidx.fragment.app.FragmentActivity;
import androidx.glance.AbstractC2821a;
import com.samsung.android.support.senl.p145cm.base.common.util.LocaleUtils;
import com.samsung.android.support.senl.p148nt.app.addons.AbstractC8014b;
import com.samsung.android.support.senl.p148nt.composer.C9086R;
import com.samsung.android.support.senl.p148nt.composer.main.base.factory.BaseComponentFactory;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.BaseComposerPresenter;
import com.samsung.android.support.senl.p148nt.composer.main.base.view.BaseComposerFragment;
import com.samsung.android.support.senl.p148nt.composer.main.screenoff.ScreenOffActivity;
import com.samsung.android.support.senl.p148nt.composer.main.screenoff.factory.ScreenOffComponentFactory;
import com.samsung.android.support.senl.p148nt.composer.main.screenoff.model.loadednote.LoadedNote;
import com.samsung.android.support.senl.p148nt.composer.main.screenoff.model.state.IState;
import com.samsung.android.support.senl.p148nt.composer.main.screenoff.model.state.StateStarting;
import com.samsung.android.support.senl.p148nt.composer.main.screenoff.model.statical.ConfigurationModel;
import com.samsung.android.support.senl.p148nt.composer.main.screenoff.presenter.SOMBasePresenter;
import com.samsung.android.support.senl.p148nt.composer.main.screenoff.presenter.ScreenOffContract;
import com.samsung.android.support.senl.p148nt.composer.main.screenoff.presenter.ScreenOffPresenter;
import com.samsung.android.support.senl.p148nt.composer.main.screenoff.presenter.covered.CoveredPresenter;
import com.samsung.android.support.senl.p148nt.composer.main.screenoff.presenter.guide.GuidePresenter;
import com.samsung.android.support.senl.p148nt.composer.main.screenoff.presenter.menubar.MenuBarPresenter;
import com.samsung.android.support.senl.p148nt.composer.main.screenoff.presenter.scroll.ScrollPresenter;
import com.samsung.android.support.senl.p148nt.composer.main.screenoff.util.Constants;
import com.samsung.android.support.senl.p148nt.composer.main.screenoff.util.SOLogger;
import com.samsung.android.support.senl.p148nt.composer.main.screenoff.view.covered.Covered;
import com.samsung.android.support.senl.p148nt.composer.main.screenoff.view.dialog.DialogCreator;
import com.samsung.android.support.senl.p148nt.composer.main.screenoff.view.guide.Guide;
import com.samsung.android.support.senl.p148nt.composer.main.screenoff.view.menubar.MenuBar;
import com.samsung.android.support.senl.p148nt.composer.main.screenoff.view.scroll.Scroll;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import p001A.AbstractC0000a;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(m13885d1 = {"\u0000\u0086\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u0002\u0018\u0000 52\u00020\u00012\u00020\u0002:\u00015B\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\b\u0010\u0011\u001a\u00020\u0012H\u0014J\u0012\u0010\u0013\u001a\u00020\u00142\b\u0010\u0015\u001a\u0004\u0018\u00010\u0016H\u0016J\b\u0010\u0017\u001a\u00020\u0018H\u0014J\u001a\u0010\u0019\u001a\u00020\u00142\u0006\u0010\u001a\u001a\u00020\u001b2\b\u0010\u0015\u001a\u0004\u0018\u00010\u0016H\u0016J\u0010\u0010\u001c\u001a\u00020\u00142\u0006\u0010\u001d\u001a\u00020\u001eH\u0016J\b\u0010\u001f\u001a\u00020\u0014H\u0016J\b\u0010 \u001a\u00020\u0014H\u0016J\b\u0010!\u001a\u00020\u0014H\u0016J\u0010\u0010\"\u001a\u00020\u00142\u0006\u0010#\u001a\u00020$H\u0014J\u0010\u0010%\u001a\u00020\u00142\u0006\u0010#\u001a\u00020&H\u0016J\u0010\u0010'\u001a\u00020\u00142\u0006\u0010#\u001a\u00020(H\u0016J\u0010\u0010)\u001a\u00020\u00142\u0006\u0010#\u001a\u00020*H\u0016J\u0010\u0010+\u001a\u00020\u00142\u0006\u0010#\u001a\u00020,H\u0016J\u000e\u0010-\u001a\u00020\u00142\u0006\u0010.\u001a\u00020\u0018J\u0006\u0010/\u001a\u00020\u0014J\u0006\u00100\u001a\u00020\u0014J\u0006\u00101\u001a\u00020\u0014J\u0006\u00102\u001a\u00020\u0014J\b\u00103\u001a\u000204H\u0014R\u0010\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0007\u001a\u0004\u0018\u00010\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\t\u001a\u0004\u0018\u00010\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000b\u001a\u0004\u0018\u00010\fX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\r\u001a\u0004\u0018\u00010\u000eX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000f\u001a\u0004\u0018\u00010\u0010X\u0082\u000e¢\u0006\u0002\n\u0000¨\u00066"}, m13886d2 = {"Lcom/samsung/android/support/senl/nt/composer/main/screenoff/view/ScreenOffFragment;", "Lcom/samsung/android/support/senl/nt/composer/main/base/view/BaseComposerFragment;", "Lcom/samsung/android/support/senl/nt/composer/main/screenoff/presenter/ScreenOffContract$IScreenOffView;", "<init>", "()V", "mScreenOffPresenter", "Lcom/samsung/android/support/senl/nt/composer/main/screenoff/presenter/ScreenOffPresenter;", "mMenuBar", "Lcom/samsung/android/support/senl/nt/composer/main/screenoff/view/menubar/MenuBar;", "mGuide", "Lcom/samsung/android/support/senl/nt/composer/main/screenoff/view/guide/Guide;", "mScroll", "Lcom/samsung/android/support/senl/nt/composer/main/screenoff/view/scroll/Scroll;", "mCovered", "Lcom/samsung/android/support/senl/nt/composer/main/screenoff/view/covered/Covered;", "mScreenOffDialogCreator", "Lcom/samsung/android/support/senl/nt/composer/main/screenoff/view/dialog/DialogCreator;", "createComponentFactory", "Lcom/samsung/android/support/senl/nt/composer/main/base/factory/BaseComponentFactory;", "onCreate", "", "savedInstanceState", "Landroid/os/Bundle;", "getLayoutRes", "", "onViewCreated", "view", "Landroid/view/View;", "onConfigurationChanged", "newConfig", "Landroid/content/res/Configuration;", "requestRelayout", "onDestroy", "onDetach", "setPresenter", "presenter", "Lcom/samsung/android/support/senl/nt/composer/main/base/presenter/BaseComposerPresenter;", "attachMenuBar", "Lcom/samsung/android/support/senl/nt/composer/main/screenoff/presenter/menubar/MenuBarPresenter;", "attachGuide", "Lcom/samsung/android/support/senl/nt/composer/main/screenoff/presenter/guide/GuidePresenter;", "attachScroll", "Lcom/samsung/android/support/senl/nt/composer/main/screenoff/presenter/scroll/ScrollPresenter;", "attachCovered", "Lcom/samsung/android/support/senl/nt/composer/main/screenoff/presenter/covered/CoveredPresenter;", "onDisplayStateChanged", "displayState", "onHomeKeyPressed", "onDispatchActionDownEvent", "onDispatchActionUpEvent", "onInterrupted", "changeLayout", "", "Companion", "ntComposer_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
public final class ScreenOffFragment extends BaseComposerFragment implements ScreenOffContract.IScreenOffView {

    @NotNull
    private static final String TAG = SOLogger.createTag("ScreenOffFragment");

    @Nullable
    private Covered mCovered;

    @Nullable
    private Guide mGuide;

    @Nullable
    private MenuBar mMenuBar;

    @Nullable
    private DialogCreator mScreenOffDialogCreator;

    @Nullable
    private ScreenOffPresenter mScreenOffPresenter;

    @Nullable
    private Scroll mScroll;

    @Override // com.samsung.android.support.senl.nt.composer.main.screenoff.presenter.ScreenOffContract.IScreenOffView
    public void attachCovered(@NotNull CoveredPresenter presenter) {
        Intrinsics.checkNotNullParameter(presenter, "presenter");
        SOLogger.INSTANCE.SOLoggerD(TAG, "attachCovered#");
        if (this.mCovered == null) {
            this.mCovered = new Covered(getContext(), presenter, null);
        }
    }

    @Override // com.samsung.android.support.senl.nt.composer.main.screenoff.presenter.ScreenOffContract.IScreenOffView
    public void attachGuide(@NotNull GuidePresenter presenter) {
        Window window;
        Intrinsics.checkNotNullParameter(presenter, "presenter");
        SOLogger.INSTANCE.SOLoggerD(TAG, "attachGuide#");
        if (this.mGuide == null) {
            FragmentActivity activity = getActivity();
            View decorView = (activity == null || (window = activity.getWindow()) == null) ? null : window.getDecorView();
            Intrinsics.checkNotNull(decorView, "null cannot be cast to non-null type android.view.ViewGroup");
            this.mGuide = new Guide((ViewGroup) decorView, presenter);
        }
    }

    @Override // com.samsung.android.support.senl.nt.composer.main.screenoff.presenter.ScreenOffContract.IScreenOffView
    public void attachMenuBar(@NotNull MenuBarPresenter presenter) {
        Window window;
        Intrinsics.checkNotNullParameter(presenter, "presenter");
        SOLogger.INSTANCE.SOLoggerD(TAG, "attachMenu#");
        if (this.mMenuBar == null) {
            FragmentActivity activity = getActivity();
            View decorView = (activity == null || (window = activity.getWindow()) == null) ? null : window.getDecorView();
            Intrinsics.checkNotNull(decorView, "null cannot be cast to non-null type android.view.ViewGroup");
            this.mMenuBar = new MenuBar((ViewGroup) decorView, presenter);
        }
    }

    @Override // com.samsung.android.support.senl.nt.composer.main.screenoff.presenter.ScreenOffContract.IScreenOffView
    public void attachScroll(@NotNull ScrollPresenter presenter) {
        Window window;
        Intrinsics.checkNotNullParameter(presenter, "presenter");
        SOLogger.INSTANCE.SOLoggerD(TAG, "attachScroll#");
        if (this.mScroll == null) {
            FragmentActivity activity = getActivity();
            View decorView = (activity == null || (window = activity.getWindow()) == null) ? null : window.getDecorView();
            Intrinsics.checkNotNull(decorView, "null cannot be cast to non-null type android.view.ViewGroup");
            this.mScroll = new Scroll((ViewGroup) decorView, presenter);
        }
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.base.view.BaseComposerFragment
    public boolean changeLayout() {
        return false;
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.base.view.BaseComposerFragment
    @NotNull
    public BaseComponentFactory createComponentFactory() {
        return new ScreenOffComponentFactory();
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.base.view.BaseComposerFragment
    public int getLayoutRes() {
        return C9086R.layout.screenoff_fragment_main;
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.base.view.BaseComposerFragment, com.samsung.android.support.senl.p148nt.base.winset.view.toolbar.CustomToolbarFragment, androidx.fragment.app.Fragment, android.content.ComponentCallbacks
    public void onConfigurationChanged(@NotNull Configuration newConfig) {
        Intrinsics.checkNotNullParameter(newConfig, "newConfig");
        AbstractC8014b.m7206h("onConfigurationChanged# orientation ", newConfig.orientation, SOLogger.INSTANCE, TAG);
        super.onConfigurationChanged(newConfig);
        ScreenOffPresenter screenOffPresenter = this.mScreenOffPresenter;
        if (screenOffPresenter != null) {
            screenOffPresenter.onConfigurationChanged(false);
        }
        if (ConfigurationModel.INSTANCE.isSupportNavigationRotation()) {
            return;
        }
        requestRelayout();
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.base.view.BaseComposerFragment, androidx.fragment.app.Fragment
    public void onCreate(@Nullable Bundle savedInstanceState) {
        SOLogger.INSTANCE.SOLoggerD(TAG, "onCreate#");
        super.onCreate(savedInstanceState);
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.base.view.BaseComposerFragment, androidx.fragment.app.Fragment
    public void onDestroy() {
        SOLogger.INSTANCE.SOLoggerD(TAG, "onDestroy#");
        super.onDestroy();
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.base.view.BaseComposerFragment, androidx.fragment.app.Fragment
    public void onDetach() {
        SOLogger.INSTANCE.SOLoggerD(TAG, "onDetach#");
        super.onDetach();
        this.mMenuBar = null;
        this.mGuide = null;
        this.mScroll = null;
        this.mCovered = null;
        this.mScreenOffDialogCreator = null;
    }

    public final void onDispatchActionDownEvent() {
        ScreenOffPresenter screenOffPresenter = this.mScreenOffPresenter;
        if (screenOffPresenter != null) {
            screenOffPresenter.onDispatchActionDownEvent();
        }
    }

    public final void onDispatchActionUpEvent() {
        ScreenOffPresenter screenOffPresenter = this.mScreenOffPresenter;
        if (screenOffPresenter != null) {
            screenOffPresenter.onDispatchActionUpEvent();
        }
    }

    public final void onDisplayStateChanged(int displayState) {
        ScreenOffPresenter screenOffPresenter = this.mScreenOffPresenter;
        if (screenOffPresenter != null) {
            screenOffPresenter.onDisplayStateChanged(displayState);
        }
    }

    public final void onHomeKeyPressed() {
        ScreenOffPresenter screenOffPresenter = this.mScreenOffPresenter;
        if (screenOffPresenter != null) {
            screenOffPresenter.onHomeKeyPressed();
        }
    }

    public final void onInterrupted() {
        ScreenOffPresenter screenOffPresenter = this.mScreenOffPresenter;
        if (screenOffPresenter != null) {
            screenOffPresenter.onInterrupted();
        }
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.base.view.BaseComposerFragment, androidx.fragment.app.Fragment
    public void onViewCreated(@NotNull View view, @Nullable Bundle savedInstanceState) {
        Intrinsics.checkNotNullParameter(view, "view");
        super.onViewCreated(view, savedInstanceState);
        Bundle arguments = getArguments();
        SOLogger.INSTANCE.SOLoggerD(TAG, "onViewCreated bundle# " + arguments);
        try {
            ScreenOffPresenter screenOffPresenter = this.mScreenOffPresenter;
            if (screenOffPresenter != null) {
                Bundle arguments2 = getArguments();
                screenOffPresenter.setState((IState) (arguments2 != null ? arguments2.getParcelable("state") : null));
            }
            ScreenOffPresenter screenOffPresenter2 = this.mScreenOffPresenter;
            if (screenOffPresenter2 != null) {
                Bundle arguments3 = getArguments();
                screenOffPresenter2.setLoadedNote(arguments3 != null ? (LoadedNote) arguments3.getParcelable(Constants.DeliveryParcelableKey.LOADED_NOTE_TYPE) : null);
            }
        } catch (Exception e) {
            AbstractC0000a.m24u("onViewCreated# getMessage ", e.getMessage(), SOLogger.INSTANCE, TAG);
            ScreenOffPresenter screenOffPresenter3 = this.mScreenOffPresenter;
            if (screenOffPresenter3 != null) {
                FragmentActivity activity = getActivity();
                Intrinsics.checkNotNull(activity, "null cannot be cast to non-null type com.samsung.android.support.senl.nt.composer.main.screenoff.ScreenOffActivity");
                screenOffPresenter3.setState(new StateStarting((ScreenOffActivity) activity));
            }
            ScreenOffPresenter screenOffPresenter4 = this.mScreenOffPresenter;
            if (screenOffPresenter4 != null) {
                screenOffPresenter4.setLoadedNote(new LoadedNote());
            }
        }
        this.mScreenOffDialogCreator = new DialogCreator();
        ScreenOffPresenter screenOffPresenter5 = this.mScreenOffPresenter;
        if (screenOffPresenter5 != null) {
            screenOffPresenter5.onActivityCreated(getActivity(), this.mScreenOffDialogCreator);
        }
    }

    @Override // com.samsung.android.support.senl.nt.composer.main.screenoff.presenter.ScreenOffContract.IScreenOffView
    public void requestRelayout() {
        int i = getResources().getConfiguration().orientation;
        boolean zIsRTLMode = LocaleUtils.isRTLMode();
        int dimension = (int) getResources().getDimension(C9086R.dimen.screenoff_menu_bar_layout_width_height);
        SOLogger sOLogger = SOLogger.INSTANCE;
        String str = TAG;
        StringBuilder sbM2226q = AbstractC2821a.m2226q("requestRelayout# orientation/isRTLMode/menuBarHeight ", i, "/", zIsRTLMode, "/");
        sbM2226q.append(dimension);
        sOLogger.SOLoggerD(str, sbM2226q.toString());
        FragmentActivity activity = getActivity();
        RelativeLayout relativeLayout = activity != null ? (RelativeLayout) activity.findViewById(C9086R.id.main_layout_container) : null;
        ViewGroup.LayoutParams layoutParams = relativeLayout != null ? relativeLayout.getLayoutParams() : null;
        Intrinsics.checkNotNull(layoutParams, "null cannot be cast to non-null type android.widget.RelativeLayout.LayoutParams");
        RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) layoutParams;
        if (relativeLayout == null) {
            return;
        }
        if (ConfigurationModel.INSTANCE.isSupportNavigationRotation() || i != 2) {
            layoutParams2.setMarginStart(0);
            layoutParams2.setMarginEnd(0);
            layoutParams2.topMargin = dimension;
        } else if (zIsRTLMode) {
            layoutParams2.setMarginStart(0);
            layoutParams2.topMargin = 0;
            layoutParams2.setMarginEnd(dimension);
        } else {
            layoutParams2.setMarginEnd(0);
            layoutParams2.topMargin = 0;
            layoutParams2.setMarginStart(dimension);
        }
        relativeLayout.setLayoutParams(layoutParams2);
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.base.view.BaseComposerFragment
    public void setPresenter(@NotNull BaseComposerPresenter presenter) {
        Intrinsics.checkNotNullParameter(presenter, "presenter");
        SOLogger.INSTANCE.SOLoggerD(TAG, "setPresenter#");
        super.setPresenter(presenter);
        if (this.mScreenOffPresenter == null) {
            ScreenOffPresenter screenOffPresenter = new ScreenOffPresenter((SOMBasePresenter) presenter);
            this.mScreenOffPresenter = screenOffPresenter;
            screenOffPresenter.setView(this);
        }
    }
}
