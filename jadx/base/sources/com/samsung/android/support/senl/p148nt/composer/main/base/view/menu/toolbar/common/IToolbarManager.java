package com.samsung.android.support.senl.p148nt.composer.main.base.view.menu.toolbar.common;

import android.app.Activity;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.controller.ExternalKeyboardManager;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.controller.SoftInputManager;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes3.dex */
public interface IToolbarManager {
    void addOnExternalKeyboardConnectedListener(ExternalKeyboardManager.OnExternalKeyboardConnectedListener onExternalKeyboardConnectedListener);

    void addOnSipListener(SoftInputManager.OnSipListener onSipListener);

    boolean canNotChangeMode();

    int getBackgroundColor();

    int getColorTheme(int i);

    boolean hasBackgroundImage();

    void hideDirectWrite();

    void hideSettingPenMini();

    boolean isBackgroundColorInverted();

    boolean isDirectWriteRecognizing();

    boolean isDirectWriteUsing();

    boolean isSIPShowing();

    boolean isSupportDirectWrite(Activity activity);

    void reboundSettingPenMiniVI();

    void removeOnExternalKeyboardConnectedListener(ExternalKeyboardManager.OnExternalKeyboardConnectedListener onExternalKeyboardConnectedListener);

    void removeOnSipListener(SoftInputManager.OnSipListener onSipListener);

    void setDirectWrite(boolean z);

    void setDirectWriteColor(int i, int i2);

    void setSpenColorThemeUtil(int i);

    void showDirectWrite();

    void showSettingPenMini();
}
