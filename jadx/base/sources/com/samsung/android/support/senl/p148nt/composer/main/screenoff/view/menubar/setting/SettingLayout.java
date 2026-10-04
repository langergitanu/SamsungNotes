package com.samsung.android.support.senl.p148nt.composer.main.screenoff.view.menubar.setting;

import com.samsung.android.support.senl.p148nt.composer.main.screenoff.util.Constants;
import kotlin.Metadata;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(m13885d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0005\b&\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\n\u001a\u00020\u000bH&J\b\u0010\f\u001a\u00020\u000bH&J\b\u0010\r\u001a\u00020\u000bH&J\b\u0010\u000e\u001a\u00020\u000fH&J\u0010\u0010\u0010\u001a\u00020\u000b2\u0006\u0010\u0011\u001a\u00020\u000fH&J\u0010\u0010\u0012\u001a\u00020\u000b2\b\u0010\u0013\u001a\u0004\u0018\u00010\u0005R\u001c\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0084\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\t¨\u0006\u0014"}, m13886d2 = {"Lcom/samsung/android/support/senl/nt/composer/main/screenoff/view/menubar/setting/SettingLayout;", "", "<init>", "()V", "mSettingViewManager", "Lcom/samsung/android/support/senl/nt/composer/main/screenoff/view/menubar/setting/ISettingViewManager;", "getMSettingViewManager", "()Lcom/samsung/android/support/senl/nt/composer/main/screenoff/view/menubar/setting/ISettingViewManager;", "setMSettingViewManager", "(Lcom/samsung/android/support/senl/nt/composer/main/screenoff/view/menubar/setting/ISettingViewManager;)V", "init", "", Constants.IntentExtraValue.SHOW, "hide", "isVisible", "", com.samsung.android.support.senl.p148nt.base.common.constants.Constants.ARG_UPDATE, "initialize", "setSettingViewManager", "settingViewManager", "ntComposer_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
public abstract class SettingLayout {

    @Nullable
    private ISettingViewManager mSettingViewManager;

    @Nullable
    public final ISettingViewManager getMSettingViewManager() {
        return this.mSettingViewManager;
    }

    public abstract void hide();

    public abstract void init();

    public abstract boolean isVisible();

    public final void setMSettingViewManager(@Nullable ISettingViewManager iSettingViewManager) {
        this.mSettingViewManager = iSettingViewManager;
    }

    public final void setSettingViewManager(@Nullable ISettingViewManager settingViewManager) {
        this.mSettingViewManager = settingViewManager;
    }

    public abstract void show();

    public abstract void update(boolean initialize);
}
