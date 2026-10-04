package com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.option;

import android.app.Activity;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes3.dex */
public interface IOptionMenuFingerDrawingPresenter {
    public static final int OPTION_MENU_SMART_TIP_EMPTY_FINGER_DRAWING = -2;
    public static final int OPTION_MENU_SMART_TIP_HIDE_FINGER_DRAWING = 0;
    public static final int OPTION_MENU_SMART_TIP_NONE_FINGER_DRAWING = -1;
    public static final String OPTION_MENU_SMART_TIP_PREF = "OptionMenuSmartTipPref";
    public static final int OPTION_MENU_SMART_TIP_SHOW_FINGER_DRAWING = 1;

    void blockSmartTip();

    int getSmartTipState();

    boolean isSpenOnlyMode();

    void onAttachView(Activity activity);

    void onClickFingerDrawing();

    void onDetachView();

    void setSmartTipState(int i);
}
