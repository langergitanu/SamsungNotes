package com.samsung.android.support.senl.p148nt.composer.main.base.model.menu.toolbar.directwrite;

import android.os.Bundle;
import androidx.annotation.NonNull;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes3.dex */
public class DirectWriteEnableStateData extends AbsStoredData<Boolean> {
    private static final Boolean DEFAULT_DIRECT_WRITE_ENABLE = Boolean.FALSE;
    private static final String KEY_DIRECT_WRITE_ENABLE = "KEY_DIRECT_WRITE_ENABLE";
    private boolean currentIsEnable;

    /* JADX WARN: Illegal instructions before constructor call */
    public DirectWriteEnableStateData() {
        Boolean bool = DEFAULT_DIRECT_WRITE_ENABLE;
        super(KEY_DIRECT_WRITE_ENABLE, bool);
        this.currentIsEnable = bool.booleanValue();
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.base.model.menu.toolbar.directwrite.AbsStoredData, com.samsung.android.support.senl.p148nt.composer.main.base.model.menu.toolbar.directwrite.ISaveInstance
    public void onSaveInstanceState(@NonNull Bundle bundle) {
        bundle.putBoolean(KEY_DIRECT_WRITE_ENABLE, getValue().booleanValue());
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.base.model.menu.toolbar.directwrite.AbsStoredData, com.samsung.android.support.senl.p148nt.composer.main.base.model.menu.toolbar.directwrite.ISaveInstance
    public void restoreState(Bundle bundle) {
        setValue(Boolean.valueOf(bundle.getBoolean(KEY_DIRECT_WRITE_ENABLE, DEFAULT_DIRECT_WRITE_ENABLE.booleanValue())));
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.samsung.android.support.senl.p148nt.composer.main.base.model.menu.toolbar.directwrite.AbsStoredData
    public Boolean getValue() {
        return Boolean.valueOf(this.currentIsEnable);
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.base.model.menu.toolbar.directwrite.AbsStoredData
    public void setValue(Boolean bool) {
        this.currentIsEnable = bool.booleanValue();
    }
}
