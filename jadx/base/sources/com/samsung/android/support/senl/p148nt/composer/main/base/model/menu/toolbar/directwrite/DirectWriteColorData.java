package com.samsung.android.support.senl.p148nt.composer.main.base.model.menu.toolbar.directwrite;

import android.os.Bundle;
import androidx.annotation.NonNull;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes3.dex */
public class DirectWriteColorData extends AbsStoredData<Integer> {
    private static final int DEFAULT_DIRECT_WRITE_COLOR = 255;
    private static final String KEY_DIRECT_WRITE_COLOR = "KEY_DIRECT_WRITE_COLOR";

    public DirectWriteColorData() {
        super(KEY_DIRECT_WRITE_COLOR, 255);
    }

    /* JADX WARN: Type inference failed for: r0v0, types: [java.lang.Integer, java.lang.Object] */
    @Override // com.samsung.android.support.senl.p148nt.composer.main.base.model.menu.toolbar.directwrite.AbsStoredData
    public /* bridge */ /* synthetic */ Integer getValue() {
        return super.getValue();
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.base.model.menu.toolbar.directwrite.AbsStoredData, com.samsung.android.support.senl.p148nt.composer.main.base.model.menu.toolbar.directwrite.ISaveInstance
    public /* bridge */ /* synthetic */ void onSaveInstanceState(@NonNull Bundle bundle) {
        super.onSaveInstanceState(bundle);
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.base.model.menu.toolbar.directwrite.AbsStoredData, com.samsung.android.support.senl.p148nt.composer.main.base.model.menu.toolbar.directwrite.ISaveInstance
    public /* bridge */ /* synthetic */ void restoreState(Bundle bundle) {
        super.restoreState(bundle);
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.base.model.menu.toolbar.directwrite.AbsStoredData
    public /* bridge */ /* synthetic */ void setValue(Integer num) {
        super.setValue(num);
    }
}
