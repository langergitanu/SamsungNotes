package com.samsung.android.support.senl.p148nt.composer.main.base.model.link;

import java.util.Date;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes3.dex */
class DateLinkSpec extends CustomLinkSpec {
    Date mEndDate;
    Date mStartDate;
    String mUrl;

    public DateLinkSpec(int i, int i2, int i4) {
        super(i, i2, i4);
    }

    public DateLinkSpec(int i, int i2, int i4, String str) {
        super(i, i2, i4);
        this.mUrl = str;
    }

    public DateLinkSpec(int i, int i2, int i4, Date date, Date date2) {
        super(i, i2, i4);
        this.mStartDate = date;
        this.mEndDate = date2;
    }
}
