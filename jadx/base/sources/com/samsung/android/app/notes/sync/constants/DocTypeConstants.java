package com.samsung.android.app.notes.sync.constants;

import com.samsung.android.support.notes.bixby.bixby2.constants.Bixby2Constants;
import com.samsung.android.support.senl.p148nt.data.common.constants.CoverStickerConstants;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes7.dex */
public enum DocTypeConstants {
    NONE(CoverStickerConstants.Category.NONE.NAME),
    MEMO_SCLOUD("MEMO_SCLOUD"),
    MEMO_LOCAL("MEMO_LOCAL"),
    MEMO_GOOGLEDRIVE("MEMO_GOOGLEDRIVE"),
    SNOTE_SCLOUD("SNOTE_SCLOUD"),
    SNOTE_LOCAL("SNOTE_LOCAL"),
    SNOTE_GOOGLEDRIVE("SNOTE_GOOGLEDRIVE"),
    SDOC(Bixby2Constants.SLOT_VALUE_SHARE_AS_SDOC),
    SDOCX("SDOCX"),
    SDOCX_SCLOUD("SDOCX_SCLOUD"),
    TMEMO1("TMEMO1"),
    SCRAPBOOK_SCLOUD("SCRAPBOOK_SCLOUD"),
    SS_SDOC("SS_SDOC"),
    SS_NMEMO("SS_NMEMO"),
    SS_LMEMO("SS_LMEMO"),
    SS_QMEMO("SS_QMEMO"),
    SS_TMEMO("SS_TMEMO"),
    ETC("ETC");

    private String mType;

    DocTypeConstants(String str) {
        this.mType = str;
    }

    @Override // java.lang.Enum
    public String toString() {
        return this.mType;
    }
}
