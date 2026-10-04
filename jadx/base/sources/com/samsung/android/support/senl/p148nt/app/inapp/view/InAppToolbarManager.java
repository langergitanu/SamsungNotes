package com.samsung.android.support.senl.p148nt.app.inapp.view;

import android.app.Activity;
import android.view.ViewGroup;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.samsung.android.sdk.pen.setting.color.SpenColorThemeUtil;
import com.samsung.android.support.senl.p148nt.app.inapp.presenter.item.InAppToolbarContract;
import com.samsung.android.support.senl.p148nt.app.inapp.presenter.item.InAppToolbarPresenter;
import com.samsung.android.support.senl.p148nt.app.inapp.view.item.InAppToolbarItemManager;
import com.samsung.android.support.senl.p148nt.base.common.inapp.ContinuityClientManager;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.controller.ExternalKeyboardManager;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.controller.SoftInputManager;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.inapp.RemoteInAppPresenter;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.toolbar.remotefunction.RemoteFunctionPresenter;
import com.samsung.android.support.senl.p148nt.composer.main.base.view.menu.toolbar.common.IToolbarManager;
import com.samsung.android.support.senl.p148nt.composer.main.basic.factory.BasicComponentFactory;
import com.samsung.android.support.senl.p148nt.composer.main.screenoff.util.Constants;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes2.dex */
@Metadata(m13885d1 = {"\u0000^\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0010\u0012\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0012\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u00012\u00020\u0002B\u0017\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0004\b\u0007\u0010\bJ\u0006\u0010\u000f\u001a\u00020\u0010J\u0006\u0010\u0011\u001a\u00020\u0010J\u0006\u0010\u0012\u001a\u00020\u0010J\u0006\u0010\u0013\u001a\u00020\u0010J\u0010\u0010\u0014\u001a\u00020\u00102\b\u0010\u0015\u001a\u0004\u0018\u00010\u0016J\u0006\u0010\u0017\u001a\u00020\u0010J\u0010\u0010\u0018\u001a\u00020\u00102\u0006\u0010\u0019\u001a\u00020\u001aH\u0016J\u0010\u0010\u001b\u001a\u00020\u001a2\u0006\u0010\u001c\u001a\u00020\u001aH\u0016J\u0010\u0010\u001d\u001a\u00020\u001e2\u0006\u0010\u0003\u001a\u00020\u0004H\u0016J\b\u0010\u001f\u001a\u00020\u001eH\u0016J\u0010\u0010 \u001a\u00020\u00102\u0006\u0010!\u001a\u00020\u001eH\u0016J\b\u0010\"\u001a\u00020\u0010H\u0016J\b\u0010#\u001a\u00020\u0010H\u0016J\u0018\u0010$\u001a\u00020\u00102\u0006\u0010\u001c\u001a\u00020\u001a2\u0006\u0010%\u001a\u00020\u001aH\u0016J\b\u0010&\u001a\u00020\u0010H\u0016J\b\u0010'\u001a\u00020\u0010H\u0016J\b\u0010(\u001a\u00020\u0010H\u0016J\b\u0010)\u001a\u00020\u001eH\u0016J\b\u0010*\u001a\u00020\u001eH\u0016J\b\u0010+\u001a\u00020\u0010H\u0016J\b\u0010,\u001a\u00020\u001aH\u0016J\b\u0010-\u001a\u00020\u001eH\u0016J\b\u0010.\u001a\u00020\u001eH\u0016J\u0012\u0010/\u001a\u00020\u00102\b\u00100\u001a\u0004\u0018\u000101H\u0016J\u0012\u00102\u001a\u00020\u00102\b\u00100\u001a\u0004\u0018\u000101H\u0016J\u0012\u00103\u001a\u00020\u00102\b\u00104\u001a\u0004\u0018\u000105H\u0016J\u0012\u00106\u001a\u00020\u00102\b\u00104\u001a\u0004\u0018\u000105H\u0016J\b\u00107\u001a\u00020\u001eH\u0016R\u000e\u0010\t\u001a\u00020\nX\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u000b\u001a\u0004\u0018\u00010\fX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\r\u001a\u0004\u0018\u00010\u000eX\u0082\u000e¢\u0006\u0002\n\u0000¨\u00068"}, m13886d2 = {"Lcom/samsung/android/support/senl/nt/app/inapp/view/InAppToolbarManager;", "Lcom/samsung/android/support/senl/nt/composer/main/base/view/menu/toolbar/common/IToolbarManager;", "Lcom/samsung/android/support/senl/nt/app/inapp/presenter/item/InAppToolbarContract;", Constants.StringExtra.EXECUTE_TYPE_ACTIVITY, "Landroid/app/Activity;", "rootView", "Landroid/view/ViewGroup;", "<init>", "(Landroid/app/Activity;Landroid/view/ViewGroup;)V", "mRemoteFunctionPresenter", "Lcom/samsung/android/support/senl/nt/composer/main/base/presenter/menu/toolbar/remotefunction/RemoteFunctionPresenter;", "mInAppHwToolbarMenu", "Lcom/samsung/android/support/senl/nt/app/inapp/view/InAppHwToolbarMenu;", "mSpenColorThemeUtil", "Lcom/samsung/android/sdk/pen/setting/color/SpenColorThemeUtil;", "close", "", "release", "closeColorPopups", "hideInAppPopups", "receiveData", "data", "", "invalidateFlow", "setSpenColorThemeUtil", "colorTheme", "", "getColorTheme", "color", "isSupportDirectWrite", "", "isDirectWriteUsing", "setDirectWrite", "enable", "showDirectWrite", "hideDirectWrite", "setDirectWriteColor", "bgColor", "showSettingPenMini", "hideSettingPenMini", "reboundSettingPenMiniVI", "isDirectWriteRecognizing", "canNotChangeMode", "updateLastPenTypeSelectionState", "getBackgroundColor", "isBackgroundColorInverted", "hasBackgroundImage", "addOnSipListener", "onSipListener", "Lcom/samsung/android/support/senl/nt/composer/main/base/presenter/controller/SoftInputManager$OnSipListener;", "removeOnSipListener", "addOnExternalKeyboardConnectedListener", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "Lcom/samsung/android/support/senl/nt/composer/main/base/presenter/controller/ExternalKeyboardManager$OnExternalKeyboardConnectedListener;", "removeOnExternalKeyboardConnectedListener", "isSIPShowing", "ntApp_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
@SourceDebugExtension({"SMAP\nInAppToolbarManager.kt\nKotlin\n*S Kotlin\n*F\n+ 1 InAppToolbarManager.kt\ncom/samsung/android/support/senl/nt/app/inapp/view/InAppToolbarManager\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,152:1\n1#2:153\n*E\n"})
public final class InAppToolbarManager implements IToolbarManager, InAppToolbarContract {

    @Nullable
    private InAppHwToolbarMenu mInAppHwToolbarMenu;

    @NotNull
    private final RemoteFunctionPresenter mRemoteFunctionPresenter;

    @Nullable
    private SpenColorThemeUtil mSpenColorThemeUtil;

    public InAppToolbarManager(@NotNull Activity activity, @NotNull ViewGroup rootView) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        Intrinsics.checkNotNullParameter(rootView, "rootView");
        RemoteFunctionPresenter remoteFunctionPresenter = new RemoteFunctionPresenter(activity, ContinuityClientManager.INSTANCE.getInstance(), 2);
        this.mRemoteFunctionPresenter = remoteFunctionPresenter;
        InAppToolbarPresenter inAppToolbarPresenter = new InAppToolbarPresenter(activity, this, remoteFunctionPresenter);
        remoteFunctionPresenter.addRemoteTargetClass(inAppToolbarPresenter.getMRemoteHwSettingPresenter());
        remoteFunctionPresenter.addRemoteTargetClass(inAppToolbarPresenter.getRemoteRtSettingPresenter());
        remoteFunctionPresenter.addRemoteTargetClass(new RemoteInAppPresenter(remoteFunctionPresenter));
        this.mSpenColorThemeUtil = new SpenColorThemeUtil(activity);
        this.mInAppHwToolbarMenu = new InAppHwToolbarMenu(activity, rootView, this, inAppToolbarPresenter, new BasicComponentFactory());
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.base.view.menu.toolbar.common.IToolbarManager
    public void addOnExternalKeyboardConnectedListener(@Nullable ExternalKeyboardManager.OnExternalKeyboardConnectedListener listener) {
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.base.view.menu.toolbar.common.IToolbarManager
    public void addOnSipListener(@Nullable SoftInputManager.OnSipListener onSipListener) {
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.base.view.menu.toolbar.common.IToolbarManager
    public boolean canNotChangeMode() {
        return false;
    }

    public final void close() {
        InAppHwToolbarMenu inAppHwToolbarMenu = this.mInAppHwToolbarMenu;
        if (inAppHwToolbarMenu != null) {
            Intrinsics.checkNotNull(inAppHwToolbarMenu);
            inAppHwToolbarMenu.close();
        }
    }

    public final void closeColorPopups() {
        InAppToolbarItemManager hwToolbarItemManager;
        InAppHwToolbarMenu inAppHwToolbarMenu = this.mInAppHwToolbarMenu;
        if (inAppHwToolbarMenu == null || (hwToolbarItemManager = inAppHwToolbarMenu.getHwToolbarItemManager()) == null) {
            return;
        }
        hwToolbarItemManager.closeColorPopups();
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.base.view.menu.toolbar.common.IToolbarManager
    public int getBackgroundColor() {
        return 0;
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.base.view.menu.toolbar.common.IToolbarManager
    public int getColorTheme(int color) {
        SpenColorThemeUtil spenColorThemeUtil = this.mSpenColorThemeUtil;
        if (spenColorThemeUtil == null) {
            return 0;
        }
        Intrinsics.checkNotNull(spenColorThemeUtil);
        return spenColorThemeUtil.getColor(color);
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.base.view.menu.toolbar.common.IToolbarManager
    public boolean hasBackgroundImage() {
        return false;
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.base.view.menu.toolbar.common.IToolbarManager
    public void hideDirectWrite() {
    }

    public final void hideInAppPopups() {
        InAppToolbarItemManager hwToolbarItemManager;
        InAppHwToolbarMenu inAppHwToolbarMenu = this.mInAppHwToolbarMenu;
        if (inAppHwToolbarMenu == null || (hwToolbarItemManager = inAppHwToolbarMenu.getHwToolbarItemManager()) == null) {
            return;
        }
        hwToolbarItemManager.hideInAppPopups();
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.base.view.menu.toolbar.common.IToolbarManager
    public void hideSettingPenMini() {
    }

    public final void invalidateFlow() {
        InAppToolbarItemManager hwToolbarItemManager;
        InAppHwToolbarMenu inAppHwToolbarMenu = this.mInAppHwToolbarMenu;
        if (inAppHwToolbarMenu == null || (hwToolbarItemManager = inAppHwToolbarMenu.getHwToolbarItemManager()) == null) {
            return;
        }
        hwToolbarItemManager.invalidateFlow();
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.base.view.menu.toolbar.common.IToolbarManager
    public boolean isBackgroundColorInverted() {
        return false;
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.base.view.menu.toolbar.common.IToolbarManager
    public boolean isDirectWriteRecognizing() {
        return false;
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.base.view.menu.toolbar.common.IToolbarManager
    public boolean isDirectWriteUsing() {
        return false;
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.base.view.menu.toolbar.common.IToolbarManager
    public boolean isSIPShowing() {
        return false;
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.base.view.menu.toolbar.common.IToolbarManager
    public boolean isSupportDirectWrite(@NotNull Activity activity) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        return true;
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.base.view.menu.toolbar.common.IToolbarManager
    public void reboundSettingPenMiniVI() {
    }

    public final void receiveData(@Nullable byte[] data) {
        if (data != null) {
            RemoteFunctionPresenter remoteFunctionPresenter = this.mRemoteFunctionPresenter;
            Charset UTF_8 = StandardCharsets.UTF_8;
            Intrinsics.checkNotNullExpressionValue(UTF_8, "UTF_8");
            remoteFunctionPresenter.receiveMessage(new String(data, UTF_8));
        }
    }

    public final void release() {
        SpenColorThemeUtil spenColorThemeUtil = this.mSpenColorThemeUtil;
        if (spenColorThemeUtil != null) {
            Intrinsics.checkNotNull(spenColorThemeUtil);
            spenColorThemeUtil.close();
            this.mSpenColorThemeUtil = null;
        }
        InAppHwToolbarMenu inAppHwToolbarMenu = this.mInAppHwToolbarMenu;
        if (inAppHwToolbarMenu != null) {
            Intrinsics.checkNotNull(inAppHwToolbarMenu);
            inAppHwToolbarMenu.release();
            this.mInAppHwToolbarMenu = null;
        }
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.base.view.menu.toolbar.common.IToolbarManager
    public void removeOnExternalKeyboardConnectedListener(@Nullable ExternalKeyboardManager.OnExternalKeyboardConnectedListener listener) {
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.base.view.menu.toolbar.common.IToolbarManager
    public void removeOnSipListener(@Nullable SoftInputManager.OnSipListener onSipListener) {
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.base.view.menu.toolbar.common.IToolbarManager
    public void setDirectWrite(boolean enable) {
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.base.view.menu.toolbar.common.IToolbarManager
    public void setDirectWriteColor(int color, int bgColor) {
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.base.view.menu.toolbar.common.IToolbarManager
    public void setSpenColorThemeUtil(int colorTheme) {
        SpenColorThemeUtil spenColorThemeUtil = this.mSpenColorThemeUtil;
        if (spenColorThemeUtil != null) {
            spenColorThemeUtil.setColorTheme(colorTheme);
        }
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.base.view.menu.toolbar.common.IToolbarManager
    public void showDirectWrite() {
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.base.view.menu.toolbar.common.IToolbarManager
    public void showSettingPenMini() {
    }

    @Override // com.samsung.android.support.senl.p148nt.app.inapp.presenter.item.InAppToolbarContract
    public void updateLastPenTypeSelectionState() {
        InAppToolbarItemManager hwToolbarItemManager;
        InAppHwToolbarMenu inAppHwToolbarMenu = this.mInAppHwToolbarMenu;
        if (inAppHwToolbarMenu == null || (hwToolbarItemManager = inAppHwToolbarMenu.getHwToolbarItemManager()) == null) {
            return;
        }
        hwToolbarItemManager.updateLastPenTypeSelectionState();
    }
}
