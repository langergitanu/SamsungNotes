package com.samsung.android.support.senl.addons.base.model;

import kotlin.Metadata;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes8.dex */
@Metadata(m13885d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\bf\u0018\u00002\u00020\u0001J \u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u0007H&J \u0010\t\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u0007H&J\b\u0010\n\u001a\u00020\u0007H&¨\u0006\u000b"}, m13886d2 = {"Lcom/samsung/android/support/senl/addons/base/model/IKeyListener;", "", "onKeyUp", "", "keycode", "", "withCtrl", "", "withShift", "onKeyDown", "onBack", "ntAddons_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
public interface IKeyListener {
    boolean onBack();

    void onKeyDown(int keycode, boolean withCtrl, boolean withShift);

    void onKeyUp(int keycode, boolean withCtrl, boolean withShift);
}
