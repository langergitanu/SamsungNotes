package com.samsung.android.support.senl.p148nt.composer.main.lockscreen.view;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.view.View;
import androidx.fragment.app.FragmentActivity;
import com.samsung.android.sdk.smp.common.constants.MarketingConstants;
import com.samsung.android.support.senl.p145cm.base.framework.support.LoggerBase;
import com.samsung.android.support.senl.p145cm.base.framework.view.WindowManagerCompat;
import com.samsung.android.support.senl.p148nt.base.winset.view.toolbar.CustomToolbar;
import com.samsung.android.support.senl.p148nt.composer.main.base.factory.BaseComponentFactory;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.BaseComposerPresenter;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.toolbar.ToolbarPresenter;
import com.samsung.android.support.senl.p148nt.composer.main.base.util.Logger;
import com.samsung.android.support.senl.p148nt.composer.main.base.view.BaseComposerFragment;
import com.samsung.android.support.senl.p148nt.composer.main.common.presenter.keyguard.KeyguardPresenter;
import com.samsung.android.support.senl.p148nt.composer.main.editorbase.presenter.config.EditorBaseConfig;
import com.samsung.android.support.senl.p148nt.composer.main.lockscreen.factory.LsComponentFactory;
import com.samsung.android.support.senl.p148nt.composer.main.popupnote.view.PopupNoteFragment;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(m13885d1 = {"\u0000C\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007*\u0001\t\u0018\u0000 \u001c2\u00020\u0001:\u0002\u001b\u001cB\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000eH\u0016J\b\u0010\u000f\u001a\u00020\u0010H\u0014J\u0010\u0010\u0011\u001a\u00020\f2\u0006\u0010\u0012\u001a\u00020\u0013H\u0014J\u0012\u0010\u0014\u001a\u00020\f2\b\u0010\u0015\u001a\u0004\u0018\u00010\u0016H\u0016J\b\u0010\u0017\u001a\u00020\u0005H\u0014J\b\u0010\u0018\u001a\u00020\fH\u0016J\b\u0010\u0019\u001a\u00020\fH\u0002J\b\u0010\u001a\u001a\u00020\fH\u0016R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u0006\u001a\u00060\u0007R\u00020\u0000X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\b\u001a\u00020\tX\u0082\u0004¢\u0006\u0004\n\u0002\u0010\n¨\u0006\u001d"}, m13886d2 = {"Lcom/samsung/android/support/senl/nt/composer/main/lockscreen/view/LsComposerFragment;", "Lcom/samsung/android/support/senl/nt/composer/main/popupnote/view/PopupNoteFragment;", "<init>", "()V", "isLockScreenStateReceiverRegistered", "", "lockScreenStateReceiver", "Lcom/samsung/android/support/senl/nt/composer/main/lockscreen/view/LsComposerFragment$LockScreenStateReceiver;", "keyguardObserver", "com/samsung/android/support/senl/nt/composer/main/lockscreen/view/LsComposerFragment$keyguardObserver$1", "Lcom/samsung/android/support/senl/nt/composer/main/lockscreen/view/LsComposerFragment$keyguardObserver$1;", "onAttach", "", "context", "Landroid/content/Context;", "createComponentFactory", "Lcom/samsung/android/support/senl/nt/composer/main/base/factory/BaseComponentFactory;", "initToolbar", "view", "Landroid/view/View;", "attachToolbar", "presenter", "Lcom/samsung/android/support/senl/nt/composer/main/base/presenter/menu/toolbar/ToolbarPresenter;", "isCustomMenuDisabled", "onDetach", "unregisterLockScreenStateReceiver", "onDestroyView", "LockScreenStateReceiver", "Companion", "ntComposer_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
public final class LsComposerFragment extends PopupNoteFragment {

    @NotNull
    private static final String TAG;
    private boolean isLockScreenStateReceiverRegistered;

    @NotNull
    private final LockScreenStateReceiver lockScreenStateReceiver = new LockScreenStateReceiver();

    @NotNull
    private final LsComposerFragment$keyguardObserver$1 keyguardObserver = new KeyguardPresenter.Observer() { // from class: com.samsung.android.support.senl.nt.composer.main.lockscreen.view.LsComposerFragment$keyguardObserver$1
        @Override // com.samsung.android.support.senl.nt.composer.main.common.presenter.keyguard.KeyguardPresenter.Observer
        public void onDismissed() {
            this.this$0.unregisterLockScreenStateReceiver();
            KeyguardPresenter keyguardPresenter = ((BaseComposerFragment) this.this$0).mPresenter.getOptionMenuPresenter().getKeyguardPresenter();
            if (keyguardPresenter != null) {
                keyguardPresenter.removeObserver(this);
            }
            ((BaseComposerFragment) this.this$0).mComponentFactory.updateConfig(new EditorBaseConfig());
            this.this$0.updateCustomMenuVisible();
            FragmentActivity activity = this.this$0.getActivity();
            if (activity != null) {
                activity.invalidateOptionsMenu();
            }
            WindowManagerCompat.INSTANCE.getInstance().setShowWhenLocked(this.this$0.getActivity(), false, false);
        }
    };

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0082\u0004\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u001c\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u00072\b\u0010\b\u001a\u0004\u0018\u00010\tH\u0016¨\u0006\n"}, m13886d2 = {"Lcom/samsung/android/support/senl/nt/composer/main/lockscreen/view/LsComposerFragment$LockScreenStateReceiver;", "Landroid/content/BroadcastReceiver;", "<init>", "(Lcom/samsung/android/support/senl/nt/composer/main/lockscreen/view/LsComposerFragment;)V", "onReceive", "", "context", "Landroid/content/Context;", MarketingConstants.LINK_TYPE_INTENT, "Landroid/content/Intent;", "ntComposer_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
    public final class LockScreenStateReceiver extends BroadcastReceiver {
        public LockScreenStateReceiver() {
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(@Nullable Context context, @Nullable Intent intent) {
            KeyguardPresenter keyguardPresenter;
            if (intent == null) {
                return;
            }
            LoggerBase.INSTANCE.m7132d(LsComposerFragment.TAG, "onReceive, action: " + intent.getAction());
            if (!Intrinsics.areEqual(intent.getAction(), "android.intent.action.USER_PRESENT") || (keyguardPresenter = ((BaseComposerFragment) LsComposerFragment.this).mPresenter.getOptionMenuPresenter().getKeyguardPresenter()) == null) {
                return;
            }
            keyguardPresenter.updateStatus(LsComposerFragment.this.getActivity());
        }
    }

    static {
        String strCreateTag = Logger.createTag("LsComposerFragment");
        Intrinsics.checkNotNullExpressionValue(strCreateTag, "createTag(...)");
        TAG = strCreateTag;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void unregisterLockScreenStateReceiver() {
        if (this.isLockScreenStateReceiverRegistered) {
            Context context = getContext();
            if (context != null) {
                context.unregisterReceiver(this.lockScreenStateReceiver);
            }
            this.isLockScreenStateReceiverRegistered = false;
        }
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.base.view.BaseComposerFragment, com.samsung.android.support.senl.nt.composer.main.base.presenter.sub.ComposerSubContract.IView
    public void attachToolbar(@Nullable ToolbarPresenter presenter) {
        super.attachToolbar(presenter);
        KeyguardPresenter keyguardPresenter = this.mPresenter.getOptionMenuPresenter().getKeyguardPresenter();
        if (keyguardPresenter != null) {
            keyguardPresenter.addObserver(this.keyguardObserver);
        }
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.popupnote.view.PopupNoteFragment, com.samsung.android.support.senl.p148nt.composer.main.base.view.BaseComposerFragment
    @NotNull
    public BaseComponentFactory createComponentFactory() {
        return new LsComponentFactory();
    }

    @Override // com.samsung.android.support.senl.p148nt.base.winset.view.toolbar.CustomToolbarFragment
    public void initToolbar(@NotNull View view) {
        Intrinsics.checkNotNullParameter(view, "view");
        super.initToolbar(view);
        CustomToolbar customToolbar = this.mToolbar;
        if (customToolbar != null) {
            customToolbar.setNaviUpEnabled(this.mComponentFactory.getConfig().isNaviUpEnabled());
        }
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.popupnote.view.PopupNoteFragment
    public boolean isCustomMenuDisabled() {
        if (this.mPresenter.getOptionMenuPresenter().getKeyguardPresenter() == null) {
            return true;
        }
        KeyguardPresenter keyguardPresenter = this.mPresenter.getOptionMenuPresenter().getKeyguardPresenter();
        Intrinsics.checkNotNull(keyguardPresenter);
        return !keyguardPresenter.isInitialLockDismissed() || super.isCustomMenuDisabled();
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.base.view.BaseComposerFragment, androidx.fragment.app.Fragment
    public void onAttach(@NotNull Context context) {
        KeyguardPresenter keyguardPresenter;
        Intrinsics.checkNotNullParameter(context, "context");
        super.onAttach(context);
        if (this.isLockScreenStateReceiverRegistered) {
            return;
        }
        BaseComposerPresenter baseComposerPresenter = this.mPresenter;
        if (baseComposerPresenter == null || !((keyguardPresenter = baseComposerPresenter.getOptionMenuPresenter().getKeyguardPresenter()) == null || keyguardPresenter.isInitialLockDismissed())) {
            context.registerReceiver(this.lockScreenStateReceiver, new IntentFilter("android.intent.action.USER_PRESENT"));
            this.isLockScreenStateReceiverRegistered = true;
        }
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.base.view.BaseComposerFragment, com.samsung.android.support.senl.p148nt.base.winset.view.toolbar.CustomToolbarFragment, androidx.fragment.app.Fragment
    public void onDestroyView() {
        KeyguardPresenter keyguardPresenter = this.mPresenter.getOptionMenuPresenter().getKeyguardPresenter();
        if (keyguardPresenter != null) {
            keyguardPresenter.removeObserver(this.keyguardObserver);
        }
        super.onDestroyView();
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.base.view.BaseComposerFragment, androidx.fragment.app.Fragment
    public void onDetach() {
        unregisterLockScreenStateReceiver();
        super.onDetach();
    }
}
