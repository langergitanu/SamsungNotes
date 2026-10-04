package com.samsung.android.support.senl.p148nt.composer.main.base.model.link;

import android.content.Context;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import com.samsung.android.sdk.pen.document.textspan.SpenHyperTextSpan;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes3.dex */
public class LinkActionHelper {
    private static final Comparator<CustomLinkSpec> mCustomLinkSpecComparator = new Comparator<CustomLinkSpec>() { // from class: com.samsung.android.support.senl.nt.composer.main.base.model.link.LinkActionHelper.1
        @Override // java.util.Comparator
        public int compare(CustomLinkSpec customLinkSpec, CustomLinkSpec customLinkSpec2) {
            if (customLinkSpec.getStart() < customLinkSpec2.getStart()) {
                return -1;
            }
            if (customLinkSpec.getStart() <= customLinkSpec2.getStart() && customLinkSpec.getEnd() >= customLinkSpec2.getEnd()) {
                return customLinkSpec.getEnd() > customLinkSpec2.getEnd() ? -1 : 0;
            }
            return 1;
        }
    };
    private static CustomLinkSpec mLastContextMenuHyperTextCustomLinkSpec;

    public static CustomLinkSpec getFirstLinkOnParsing(Context context, @NonNull String str) {
        ArrayList<CustomLinkSpec> arrayListAddLinks = CustomLinkify.getInstance(context).addLinks(str, 31);
        pruneOverlapsSpanList(arrayListAddLinks);
        return arrayListAddLinks.isEmpty() ? new CustomLinkSpec(0, 0, 0) : arrayListAddLinks.get(0);
    }

    public static String getHiddenLink(SpenHyperTextSpan spenHyperTextSpan, String str) {
        return (spenHyperTextSpan == null || spenHyperTextSpan.getHyperTextType() != 3 || TextUtils.isEmpty(spenHyperTextSpan.getCustomData())) ? str : spenHyperTextSpan.getCustomData();
    }

    public static CustomLinkSpec getLastHypertextType() {
        return mLastContextMenuHyperTextCustomLinkSpec;
    }

    private static ArrayList<SpenHyperTextSpan> getSpanListByLinkSpec(List<CustomLinkSpec> list, int i) {
        ArrayList<SpenHyperTextSpan> arrayList = new ArrayList<>();
        if (list != null && !list.isEmpty()) {
            for (CustomLinkSpec customLinkSpec : list) {
                SpenHyperTextSpan spenHyperTextSpan = new SpenHyperTextSpan(customLinkSpec.start + i, customLinkSpec.end + i, 2);
                spenHyperTextSpan.setHyperTextType(customLinkSpec.type);
                arrayList.add(spenHyperTextSpan);
            }
        }
        return arrayList;
    }

    public static ArrayList<SpenHyperTextSpan> parseHyperText(Context context, String str, int i, boolean z) {
        ArrayList<CustomLinkSpec> arrayListAddLinks = CustomLinkify.getInstance(context).addLinks(str, z ? 63 : 31);
        pruneOverlapsSpanList(arrayListAddLinks);
        return getSpanListByLinkSpec(arrayListAddLinks, i);
    }

    public static ArrayList<SpenHyperTextSpan> parseHyperTextForCalculator(Context context, ArrayList<SpenHyperTextSpan> arrayList, String str, int i) {
        arrayList.addAll(getSpanListByLinkSpec(CustomLinkify.getInstance(context).addLinks(str, 32), i));
        return arrayList;
    }

    private static void pruneOverlapsSpanList(ArrayList<CustomLinkSpec> arrayList) {
        if (arrayList == null || arrayList.isEmpty()) {
            return;
        }
        Collections.sort(arrayList, mCustomLinkSpecComparator);
        int size = arrayList.size();
        int i = 0;
        while (i < size - 1) {
            CustomLinkSpec customLinkSpec = arrayList.get(i);
            int i2 = i + 1;
            CustomLinkSpec customLinkSpec2 = arrayList.get(i2);
            if (customLinkSpec.getStart() <= customLinkSpec2.getStart() && customLinkSpec.getEnd() > customLinkSpec2.getStart()) {
                int i4 = (customLinkSpec2.getEnd() > customLinkSpec.getEnd() && customLinkSpec.getEnd() - customLinkSpec.getStart() <= customLinkSpec2.getEnd() - customLinkSpec2.getStart()) ? customLinkSpec.getEnd() - customLinkSpec.getStart() < customLinkSpec2.getEnd() - customLinkSpec2.getStart() ? i : -1 : i2;
                if (i4 != -1) {
                    arrayList.remove(i4);
                    size--;
                }
            }
            i = i2;
        }
    }

    public static void setLastHypertextType(CustomLinkSpec customLinkSpec) {
        mLastContextMenuHyperTextCustomLinkSpec = customLinkSpec;
    }
}
