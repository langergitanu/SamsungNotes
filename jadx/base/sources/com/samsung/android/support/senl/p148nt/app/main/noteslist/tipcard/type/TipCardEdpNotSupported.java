package com.samsung.android.support.senl.p148nt.app.main.noteslist.tipcard.type;

import com.samsung.android.support.senl.p148nt.app.C8003R;
import com.samsung.android.support.senl.p148nt.base.common.tipcard.TipCard;
import com.samsung.android.support.senl.p148nt.base.common.util.DeviceUtils;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes2.dex */
public class TipCardEdpNotSupported extends TipCard {
    public TipCardEdpNotSupported() {
        super(29, C8003R.string.tipcard_edp_not_supported_title, DeviceUtils.isTabletModel() ? C8003R.string.tipcard_edp_not_supported_content_tablet : C8003R.string.tipcard_edp_not_supported_content_phone, 0, C8003R.string.base_string_cancel, 3);
    }

    @Override // com.samsung.android.support.senl.p148nt.base.common.tipcard.TipCard
    public int getNeutralButtonResourceId() {
        return 0;
    }
}
