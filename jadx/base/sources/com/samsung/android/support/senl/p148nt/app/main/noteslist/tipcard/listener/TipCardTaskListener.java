package com.samsung.android.support.senl.p148nt.app.main.noteslist.tipcard.listener;

import com.samsung.android.support.senl.p148nt.base.common.tipcard.TipCard;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes2.dex */
public interface TipCardTaskListener {
    void addTipCard(TipCard tipCard);

    void filteredInvalidateOptionsMenu();

    boolean onUnsupportedVersionError();

    void removeTipCard(int i);

    void updateProgress(TipCard tipCard);
}
