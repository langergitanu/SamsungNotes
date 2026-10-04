package com.samsung.android.support.senl.p148nt.composer.main.base.view.menu.option;

import android.app.Activity;
import androidx.annotation.NonNull;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.option.OptionMenuPresenter;
import com.samsung.android.support.senl.p148nt.composer.main.base.util.Logger;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes3.dex */
public class OptionMenuNone extends OptionMenu {
    private static final String TAG = Logger.createTag("OptionMenuNone");

    public OptionMenuNone(Activity activity, OptionMenuPresenter optionMenuPresenter) {
        super(activity, optionMenuPresenter);
        this.mType = 0;
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.base.view.menu.option.OptionMenu
    public String getTag() {
        return TAG;
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.base.view.menu.option.OptionMenu
    public void onCreateOptionsMenu(@NonNull OptionMenuParam optionMenuParam) {
    }
}
