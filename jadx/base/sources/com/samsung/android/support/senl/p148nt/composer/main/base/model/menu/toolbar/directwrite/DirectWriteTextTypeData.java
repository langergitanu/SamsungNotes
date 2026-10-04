package com.samsung.android.support.senl.p148nt.composer.main.base.model.menu.toolbar.directwrite;

import android.os.Bundle;
import androidx.annotation.NonNull;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes3.dex */
public class DirectWriteTextTypeData extends AbsStoredData<Integer> {
    private static final int DEFAULT_DIRECT_WRITE_TEXT_TYPE = 0;
    private static final String KEY_DIRECT_WRITE_TEXT_TYPE = "KEY_DIRECT_WRITE_TEXT_TYPE";

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Retention(RetentionPolicy.SOURCE)
    public @interface DWTextType {
    }

    public DirectWriteTextTypeData() {
        super(KEY_DIRECT_WRITE_TEXT_TYPE, 0);
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.base.model.menu.toolbar.directwrite.AbsStoredData, com.samsung.android.support.senl.p148nt.composer.main.base.model.menu.toolbar.directwrite.ISaveInstance
    public /* bridge */ /* synthetic */ void onSaveInstanceState(@NonNull Bundle bundle) {
        super.onSaveInstanceState(bundle);
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.base.model.menu.toolbar.directwrite.AbsStoredData, com.samsung.android.support.senl.p148nt.composer.main.base.model.menu.toolbar.directwrite.ISaveInstance
    public /* bridge */ /* synthetic */ void restoreState(Bundle bundle) {
        super.restoreState(bundle);
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.samsung.android.support.senl.p148nt.composer.main.base.model.menu.toolbar.directwrite.AbsStoredData
    public Integer getValue() {
        return (Integer) super.getValue();
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.base.model.menu.toolbar.directwrite.AbsStoredData
    public void setValue(Integer num) {
        super.setValue(num);
    }
}
