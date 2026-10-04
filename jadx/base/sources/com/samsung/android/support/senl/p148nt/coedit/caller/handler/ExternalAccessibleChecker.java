package com.samsung.android.support.senl.p148nt.coedit.caller.handler;

import android.annotation.SuppressLint;
import android.content.Context;
import com.microsoft.identity.common.java.WarningType;
import com.samsung.android.support.senl.p148nt.coedit.caller.updownloader.ExternalAccessCallback;
import com.samsung.android.support.senl.p148nt.coedit.control.CoeditHandlerManager;
import java.util.ArrayList;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes3.dex */
public class ExternalAccessibleChecker {
    private static final String TAG = "ExternalAccessibleChecker";

    @SuppressLint({WarningType.NewApi})
    public void requestExternalAccessibleNotes(Context context, ArrayList<String> arrayList, ExternalAccessCallback externalAccessCallback) {
        if (arrayList.isEmpty()) {
            return;
        }
        ArrayList arrayList2 = new ArrayList();
        for (String str : arrayList) {
            if (!CoeditHandlerManager.getInstance().isCoeditRunning(str)) {
                arrayList2.add(str);
            }
        }
        if (externalAccessCallback != null) {
            externalAccessCallback.filtered(arrayList2);
        }
    }
}
