package com.samsung.android.support.senl.p148nt.composer.main.base.view.menu.option;

import android.graphics.drawable.Drawable;
import androidx.annotation.StringRes;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes3.dex */
public abstract class OptionMenuBehavior {
    public abstract void addMenu(OptionMenuParam optionMenuParam, int i, int i2, int i4, @StringRes int i5, int i6);

    public abstract Object findMenuItem(OptionMenuParam optionMenuParam);

    public abstract CharSequence getTitle(OptionMenuParam optionMenuParam);

    public abstract void hideMenu(OptionMenuParam optionMenuParam);

    public abstract void removeMenu(OptionMenuParam optionMenuParam);

    public abstract void setBadgeText(OptionMenuParam optionMenuParam);

    public abstract void setContentDescription(OptionMenuParam optionMenuParam, String str);

    public abstract void setEnabledMenu(OptionMenuParam optionMenuParam, boolean z);

    public abstract void setIcon(OptionMenuParam optionMenuParam, Drawable drawable);

    public abstract void setTitle(OptionMenuParam optionMenuParam, @StringRes int i);

    public abstract void showMenu(OptionMenuParam optionMenuParam);
}
