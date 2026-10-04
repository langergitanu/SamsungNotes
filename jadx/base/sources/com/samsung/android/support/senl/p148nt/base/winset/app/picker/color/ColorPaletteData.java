package com.samsung.android.support.senl.p148nt.base.winset.app.picker.color;

import androidx.compose.foundation.layout.AbstractC1038a;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes2.dex */
public class ColorPaletteData {
    public static final int MAX_SELECT_COUNT = 4;
    private static final int OTHERSAPP_DEFAULT_PALETTE_START_ID = 11;
    private static final int OTHERSAPP_WRITING_SWATCH_END_ID = 20;
    private static final int[] DEFAULT_PALETTE_SELECTED_PEN_INDEX = {1, 4, 21, 5};
    private static final int[] DEFAULT_PALETTE_LIST_PEN_INDEX = {1, 4, 21, 5, 2, 9, 7, 3, 6, 8, 10};

    public static List<Integer> getDefaultSelectList() {
        int length = DEFAULT_PALETTE_SELECTED_PEN_INDEX.length;
        ArrayList arrayList = new ArrayList(length);
        for (int iM1200a = 0; iM1200a < length; iM1200a = AbstractC1038a.m1200a(DEFAULT_PALETTE_SELECTED_PEN_INDEX[iM1200a], iM1200a, 1, arrayList)) {
        }
        return arrayList;
    }

    public static List<Integer> getDefaultSwatchList() {
        int length = DEFAULT_PALETTE_LIST_PEN_INDEX.length;
        ArrayList arrayList = new ArrayList(23);
        for (int iM1200a = 0; iM1200a < length; iM1200a = AbstractC1038a.m1200a(DEFAULT_PALETTE_LIST_PEN_INDEX[iM1200a], iM1200a, 1, arrayList)) {
        }
        for (int iM1200a2 = 11; iM1200a2 <= 20; iM1200a2 = AbstractC1038a.m1200a(iM1200a2, iM1200a2, 1, arrayList)) {
        }
        return arrayList;
    }
}
