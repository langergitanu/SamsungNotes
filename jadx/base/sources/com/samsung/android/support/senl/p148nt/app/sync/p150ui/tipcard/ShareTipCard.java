package com.samsung.android.support.senl.p148nt.app.sync.p150ui.tipcard;

import android.content.Context;
import com.samsung.android.support.notes.sync.C7943R;
import com.samsung.android.support.senl.p148nt.base.common.log.Debugger;
import com.samsung.android.support.senl.p148nt.base.common.tipcard.TipCard;
import com.samsung.android.support.senl.p148nt.base.common.tipcard.TipCardListener;
import java.util.ArrayList;
import java.util.Iterator;
import p038I1.C0131g;
import p038I1.C0137m;
import p260z0.AbstractC14519b;
import p260z0.C14518a;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes2.dex */
public class ShareTipCard implements IModelTipCard {
    private static final String TAG = "ShareTipCard";

    @Override // com.samsung.android.support.senl.p148nt.app.sync.p150ui.tipcard.IModelTipCard
    public void addErrorTipCard(Context context, C14518a c14518a) {
        int i = c14518a.f10350b;
        if (i != 4 && i != 64 && i != 128 && i != 1024) {
            if (i != 4096) {
                Debugger.m8607d(TAG, "addErrorTipCard() : Unknown error code!");
                return;
            }
            return;
        }
        C0137m c0137mM280d = C0137m.m280d();
        C0131g c0131g = new C0131g(13, 0, C7943R.string.sync_tipcard_fail_to_share_something_went_wrong_body, C7943R.string.sync_tipcard_btn_retry, 0, 4);
        c0137mM280d.getClass();
        Debugger.m8607d("TipCardManager", "addTipCardCallListener()");
        if (!c0137mM280d.m283a(c0131g)) {
            Debugger.m8607d("TipCardManager", "addTipCardCallListener() : can't added tipCard " + C0137m.m282j(c0131g.getType()) + ". already exist");
            return;
        }
        ArrayList arrayList = C0137m.f389c;
        synchronized (arrayList) {
            try {
                if (!arrayList.isEmpty()) {
                    Iterator it = arrayList.iterator();
                    while (it.hasNext()) {
                        ((TipCardListener) it.next()).onCreate(c0131g);
                    }
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // com.samsung.android.support.senl.p148nt.app.sync.p150ui.tipcard.IModelTipCard
    public void addInfoTipCard(Context context, AbstractC14519b abstractC14519b) {
    }

    @Override // com.samsung.android.support.senl.p148nt.app.sync.p150ui.tipcard.IModelTipCard
    public void removeTipCard(Context context, int i) {
        if (i != 0) {
            Debugger.m8607d(TAG, "removeTipCard() : Unknown error code!");
            return;
        }
        C0137m c0137mM280d = C0137m.m280d();
        Debugger.m8607d("TipCardManager", "removeTipCardsBeforeSharing() : " + c0137mM280d.f391a.size());
        ArrayList arrayList = new ArrayList();
        synchronized (c0137mM280d.f391a) {
            for (TipCard tipCard : c0137mM280d.f391a) {
                if (tipCard.getType() == 13) {
                    ArrayList<TipCardListener> arrayList2 = C0137m.f389c;
                    synchronized (arrayList2) {
                        try {
                            for (TipCardListener tipCardListener : arrayList2) {
                                Debugger.m8607d("TipCardManager", "Remove TipCard for Listener : " + C0137m.m282j(tipCard.getType()));
                                tipCardListener.onEnd(tipCard);
                            }
                        } catch (Throwable th) {
                            throw th;
                        }
                    }
                    arrayList.add(tipCard);
                }
            }
        }
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            c0137mM280d.m286g(((TipCard) it.next()).getType());
        }
    }
}
