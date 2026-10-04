package com.samsung.android.support.senl.p148nt.composer.main.popupnote.view;

import android.app.Activity;
import android.app.ActivityOptions;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import androidx.fragment.app.FragmentActivity;
import com.samsung.android.support.senl.p145cm.base.framework.desktopmode.DesktopModeCompat;
import com.samsung.android.support.senl.p145cm.base.framework.view.InputMethodCompat;
import com.samsung.android.support.senl.p145cm.base.framework.view.ViewCompat;
import com.samsung.android.support.senl.p145cm.base.framework.view.WindowManagerCompat;
import com.samsung.android.support.senl.p148nt.base.common.util.DeviceUtils;
import com.samsung.android.support.senl.p148nt.base.winset.accessibility.VoiceAssistantTTS;
import com.samsung.android.support.senl.p148nt.base.winset.view.toolbar.CustomToolbar;
import com.samsung.android.support.senl.p148nt.composer.C9086R;
import com.samsung.android.support.senl.p148nt.composer.main.base.factory.BaseComponentFactory;
import com.samsung.android.support.senl.p148nt.composer.main.base.util.BackgroundColorUtil;
import com.samsung.android.support.senl.p148nt.composer.main.base.util.CommonUtil;
import com.samsung.android.support.senl.p148nt.composer.main.base.util.ComposerConstants;
import com.samsung.android.support.senl.p148nt.composer.main.base.util.Logger;
import com.samsung.android.support.senl.p148nt.composer.main.base.view.BaseComposerFragment;
import com.samsung.android.support.senl.p148nt.composer.main.popupnote.factory.PopupNoteComponentFactory;
import com.samsung.android.support.senl.p148nt.composer.main.popupnote.presenter.PopupNoteContract;
import com.samsung.android.support.senl.p148nt.composer.main.popupnote.util.PopupNoteUtils;
import com.samsung.android.support.senl.p148nt.composer.main.screenoff.util.Constants;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import p051L3.ViewOnClickListenerC0170a;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(m13885d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\t\b\u0016\u0018\u0000 '2\u00020\u00012\u00020\u0002:\u0001'B\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\b\u0010\u0007\u001a\u00020\bH\u0014J\u0012\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\fH\u0016J\u001e\u0010\r\u001a\u0004\u0018\u00010\f2\b\u0010\u000e\u001a\u0004\u0018\u00010\u000f2\b\u0010\u000b\u001a\u0004\u0018\u00010\fH\u0002J\u001a\u0010\u0010\u001a\u00020\n2\u0006\u0010\u0011\u001a\u00020\u00062\b\u0010\u000b\u001a\u0004\u0018\u00010\fH\u0016J\b\u0010\u0012\u001a\u00020\nH\u0016J\b\u0010\u0013\u001a\u00020\nH\u0004J\b\u0010\u0014\u001a\u00020\nH\u0016J\b\u0010\u0015\u001a\u00020\nH\u0002J\b\u0010\u0016\u001a\u00020\nH\u0002J\b\u0010\u0017\u001a\u00020\nH\u0002J\b\u0010\u0018\u001a\u00020\u0019H\u0014J\b\u0010\u001a\u001a\u00020\nH\u0002J\b\u0010\u001b\u001a\u00020\nH\u0002J\u0010\u0010\u001c\u001a\u00020\n2\u0006\u0010\u001d\u001a\u00020\u0019H\u0016J\b\u0010\u001e\u001a\u00020\u001fH\u0014J \u0010 \u001a\u00020\n2\u0006\u0010!\u001a\u00020\u001f2\u0006\u0010\"\u001a\u00020\u00192\u0006\u0010#\u001a\u00020\u0019H\u0016J\u0018\u0010$\u001a\u00020\n2\u0006\u0010%\u001a\u00020\u001f2\u0006\u0010&\u001a\u00020\u001fH\u0002R\u0010\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006("}, m13886d2 = {"Lcom/samsung/android/support/senl/nt/composer/main/popupnote/view/PopupNoteFragment;", "Lcom/samsung/android/support/senl/nt/composer/main/base/view/BaseComposerFragment;", "Lcom/samsung/android/support/senl/nt/composer/main/popupnote/presenter/PopupNoteContract$IView;", "<init>", "()V", "mCustomLayer", "Landroid/view/View;", "createComponentFactory", "Lcom/samsung/android/support/senl/nt/composer/main/base/factory/BaseComponentFactory;", "onCreate", "", "savedInstanceState", "Landroid/os/Bundle;", "getSavedInstanceState", Constants.StringExtra.EXECUTE_TYPE_ACTIVITY, "Landroid/app/Activity;", "onViewCreated", "view", "onResume", "updateCustomMenuVisible", "setCustomMenu", "initializeResizeButton", "initializeCloseButton", "checkCustomMenuVisibility", "isCustomMenuDisabled", "", "closeCustomMenu", "updateVisibilityOfResizeButton", "onMultiWindowModeChanged", "isInMultiWindowMode", "getLayoutRes", "", "setBackgroundColorOfCustomMenu", "color", "invert", "hasBackgroundImage", "setTintColorToImageView", "id", "tintColor", "Companion", "ntComposer_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
public class PopupNoteFragment extends BaseComposerFragment implements PopupNoteContract.IView {
    private static final String TAG = Logger.createTag("PopupNoteFragment");

    @Nullable
    private View mCustomLayer;

    private final void checkCustomMenuVisibility() {
        if (isCustomMenuDisabled()) {
            closeCustomMenu();
            return;
        }
        View view = this.mCustomLayer;
        if (view != null) {
            view.setVisibility(0);
        }
        CustomToolbar customToolbar = this.mToolbar;
        if (customToolbar != null) {
            customToolbar.setPopupNoteView(this.mCustomLayer);
        }
    }

    private final void closeCustomMenu() {
        View view = this.mCustomLayer;
        if (view != null) {
            view.setVisibility(8);
        }
        CustomToolbar customToolbar = this.mToolbar;
        if (customToolbar != null) {
            customToolbar.setPopupNoteView(null);
        }
    }

    private final Bundle getSavedInstanceState(Activity activity, Bundle savedInstanceState) {
        if (savedInstanceState != null || activity == null) {
            return savedInstanceState;
        }
        Bundle bundleExtra = activity.getIntent().getBundleExtra(ComposerConstants.ARG_INSTANCE_STATE);
        if (bundleExtra == null) {
            return null;
        }
        Logger.m11003i(TAG, "getSavedInstanceState# change from getBundleExtra");
        return bundleExtra;
    }

    private final void initializeCloseButton() {
        View viewFindViewById;
        View view = this.mCustomLayer;
        if (view == null || (viewFindViewById = view.findViewById(C9086R.id.popup_note_custom_close_button)) == null) {
            return;
        }
        ViewCompat.INSTANCE.getInstance().setTooltipText(viewFindViewById);
        viewFindViewById.setOnClickListener(new ViewOnClickListenerC0170a(this, 1));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void initializeCloseButton$lambda$1(PopupNoteFragment popupNoteFragment, View view) {
        Logger.m11003i(TAG, "onClick# closeView");
        FragmentActivity activity = popupNoteFragment.getActivity();
        if (activity != null) {
            activity.finish();
        }
    }

    private final void initializeResizeButton() {
        View view = this.mCustomLayer;
        View viewFindViewById = view != null ? view.findViewById(C9086R.id.popup_note_custom_resize_window_button) : null;
        if (viewFindViewById == null || getContext() == null) {
            return;
        }
        ViewCompat.INSTANCE.getInstance().setTooltipText(viewFindViewById);
        viewFindViewById.setOnClickListener(new ViewOnClickListenerC0170a(this, 0));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void initializeResizeButton$lambda$0(PopupNoteFragment popupNoteFragment, View view) {
        Logger.m11003i(TAG, "onClick# resizeView");
        view.setVisibility(4);
        Bundle bundle = new Bundle();
        popupNoteFragment.onSaveInstanceState(bundle);
        if (CommonUtil.isSos()) {
            popupNoteFragment.closeCustomMenu();
        } else {
            popupNoteFragment.mPresenter.onPause();
            popupNoteFragment.mPresenter.onDestroy(popupNoteFragment.getActivity(), false, false);
            FragmentActivity activity = popupNoteFragment.getActivity();
            if (activity != null) {
                activity.finish();
            }
        }
        FragmentActivity activity2 = popupNoteFragment.getActivity();
        Intent intent = new Intent(activity2 != null ? activity2.getIntent() : null);
        intent.setFlags(intent.getFlags() & (-268435457));
        intent.putExtra(ComposerConstants.ARG_INSTANCE_STATE, bundle);
        FragmentActivity activity3 = popupNoteFragment.getActivity();
        ActivityOptions popupNoteInfo = PopupNoteUtils.getPopupNoteInfo(activity3 != null ? activity3.getApplicationContext() : null);
        if (popupNoteInfo != null) {
            FragmentActivity activity4 = popupNoteFragment.getActivity();
            if (activity4 != null) {
                activity4.startActivity(intent, popupNoteInfo.toBundle());
            }
            FragmentActivity activity5 = popupNoteFragment.getActivity();
            if (activity5 != null) {
                activity5.overridePendingTransition(C9086R.anim.popup_note_resize_enter, C9086R.anim.popup_note_resize_exit);
            }
        }
    }

    private final void setTintColorToImageView(int id, int tintColor) {
        View view = this.mCustomLayer;
        View viewFindViewById = view != null ? view.findViewById(id) : null;
        if (viewFindViewById instanceof ImageView) {
            ((ImageView) viewFindViewById).getDrawable().setTint(tintColor);
        }
    }

    private final void updateVisibilityOfResizeButton() {
        View view = this.mCustomLayer;
        View viewFindViewById = view != null ? view.findViewById(C9086R.id.popup_note_custom_resize_window_button) : null;
        if (viewFindViewById == null || getContext() == null) {
            return;
        }
        if (VoiceAssistantTTS.INSTANCE.isVoiceAssistantEnabled(requireContext()) || DeviceUtils.isPowerManageMode(getContext()) || InputMethodCompat.INSTANCE.getInstance().isEnabledMobileKeyboard(getContext())) {
            viewFindViewById.setVisibility(4);
        } else {
            viewFindViewById.setVisibility(0);
        }
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.base.view.BaseComposerFragment
    @NotNull
    public BaseComponentFactory createComponentFactory() {
        return new PopupNoteComponentFactory();
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.base.view.BaseComposerFragment
    public int getLayoutRes() {
        return C9086R.layout.popup_note_fragment_main;
    }

    public boolean isCustomMenuDisabled() {
        return WindowManagerCompat.INSTANCE.getInstance().isMultiWindowMode(getActivity()) || DesktopModeCompat.INSTANCE.getInstance().isDexMode(getActivity());
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.base.view.BaseComposerFragment, androidx.fragment.app.Fragment
    public void onCreate(@Nullable Bundle savedInstanceState) {
        Logger.m11003i(TAG, "onCreate# : " + hashCode());
        super.onCreate(getSavedInstanceState(getActivity(), savedInstanceState));
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.base.view.BaseComposerFragment, androidx.fragment.app.Fragment
    public void onMultiWindowModeChanged(boolean isInMultiWindowMode) {
        super.onMultiWindowModeChanged(isInMultiWindowMode);
        updateCustomMenuVisible();
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.base.view.BaseComposerFragment, androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
        updateCustomMenuVisible();
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.base.view.BaseComposerFragment, androidx.fragment.app.Fragment
    public void onViewCreated(@NotNull View view, @Nullable Bundle savedInstanceState) {
        Intrinsics.checkNotNullParameter(view, "view");
        Logger.m11003i(TAG, "onViewCreated# ");
        super.onViewCreated(view, getSavedInstanceState(getActivity(), savedInstanceState));
    }

    @Override // com.samsung.android.support.senl.nt.composer.main.popupnote.presenter.PopupNoteContract.IView
    public void setBackgroundColorOfCustomMenu(int color, boolean invert, boolean hasBackgroundImage) {
        if (this.mCustomLayer == null) {
            return;
        }
        int[] backgroundThemeColorTable = BackgroundColorUtil.getBackgroundThemeColorTable(getActivity(), color, invert, hasBackgroundImage);
        View view = this.mCustomLayer;
        if (view != null) {
            view.setBackgroundColor(backgroundThemeColorTable[0]);
        }
        setTintColorToImageView(C9086R.id.popup_note_custom_close_image, backgroundThemeColorTable[1]);
        setTintColorToImageView(C9086R.id.popup_note_custom_resize_window_image, backgroundThemeColorTable[1]);
    }

    @Override // com.samsung.android.support.senl.nt.composer.main.popupnote.presenter.PopupNoteContract.IView
    public void setCustomMenu() {
        View viewFindViewById;
        View view = getView();
        if (view == null || (viewFindViewById = view.findViewById(C9086R.id.popup_note_main)) == null) {
            return;
        }
        View viewFindViewById2 = viewFindViewById.findViewById(C9086R.id.popup_note_custom_containter);
        this.mCustomLayer = viewFindViewById2;
        if (viewFindViewById2 == null) {
            Logger.m11000e(TAG, "mCustomLayer is null");
            return;
        }
        initializeResizeButton();
        initializeCloseButton();
        checkCustomMenuVisibility();
    }

    public final void updateCustomMenuVisible() {
        if (this.mCustomLayer == null) {
            setCustomMenu();
        } else {
            checkCustomMenuVisibility();
        }
        updateVisibilityOfResizeButton();
    }
}
