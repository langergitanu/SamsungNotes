package com.samsung.android.support.senl.p148nt.app.main.noteslist.tipcard.type;

import android.content.res.Resources;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.samsung.android.support.senl.p145cm.base.framework.support.BaseUtils;
import com.samsung.android.support.senl.p148nt.app.C8003R;
import com.samsung.android.support.senl.p148nt.base.common.tipcard.TipCard;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes2.dex */
public class TipCardFailToConvertStorageError extends TipCard {
    private final int mFailCount;

    public TipCardFailToConvertStorageError(int i) {
        super(22, 0, C8003R.plurals.tipcard_fail_to_convert_storage_error, C8003R.string.f6004OK, 0, 1);
        this.mFailCount = i;
    }

    @Override // com.samsung.android.support.senl.p148nt.base.common.tipcard.TipCard
    public boolean equals(@Nullable Object obj) {
        return super.equals(obj);
    }

    @Override // com.samsung.android.support.senl.p148nt.base.common.tipcard.TipCard
    @NonNull
    public String getMessage() {
        Resources resources = BaseUtils.getApplicationContext().getResources();
        int bodyResource = getBodyResource();
        int i = this.mFailCount;
        return resources.getQuantityString(bodyResource, i, Integer.valueOf(i));
    }

    @Override // com.samsung.android.support.senl.p148nt.base.common.tipcard.TipCard
    public int getNeutralButtonResourceId() {
        return 0;
    }

    @Override // com.samsung.android.support.senl.p148nt.base.common.tipcard.TipCard
    public int hashCode() {
        return super.hashCode();
    }
}
