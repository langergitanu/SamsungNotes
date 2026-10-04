package com.samsung.android.model.contractimpl;

import android.content.Context;
import com.samsung.android.sdk.pen.document.textspan.SpenHyperTextSpan;
import com.samsung.android.support.senl.p148nt.composer.main.base.model.link.LinkActionHelper;
import com.samsung.android.support.senl.p148nt.data.contract.ParseHyperTextContract;
import java.util.ArrayList;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes7.dex */
public class ParseHyperTextContractImpl implements ParseHyperTextContract {
    @Override // com.samsung.android.support.senl.p148nt.data.contract.ParseHyperTextContract
    public ArrayList<SpenHyperTextSpan> parseHyperText(Context context, String str, int i, boolean z) {
        return LinkActionHelper.parseHyperText(context, str, i, z);
    }
}
