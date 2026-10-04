package com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.toolbar.common;

import android.content.Context;
import androidx.compose.foundation.layout.AbstractC1038a;
import com.samsung.android.sdk.pen.setting.color.SpenColorPaletteData;
import com.samsung.android.sdk.pen.setting.color.SpenColorPaletteUtil;
import com.samsung.android.support.senl.p148nt.composer.main.base.util.Logger;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes3.dex */
public class ColorSettingUtil {
    private static final String TAG = Logger.createTag("ColorSettingUtil");
    private static HashMap<Integer, String> mColorMap = new HashMap<>();

    public static String getColorName(Context context, int i) {
        if (mColorMap.isEmpty()) {
            init(context);
        }
        String str = mColorMap.get(Integer.valueOf(i));
        return (str == null || str.isEmpty()) ? intToHexColor(i) : str;
    }

    public static boolean hasColorName(Context context, int i) {
        if (mColorMap.isEmpty()) {
            init(context);
        }
        return mColorMap.containsKey(Integer.valueOf(i));
    }

    private static void init(Context context) {
        SpenColorPaletteUtil spenColorPaletteUtil = new SpenColorPaletteUtil(context);
        ArrayList<Integer> arrayList = new ArrayList();
        for (int iM1200a = 1; iM1200a < 23; iM1200a = AbstractC1038a.m1200a(iM1200a, iM1200a, 1, arrayList)) {
        }
        spenColorPaletteUtil.getValidTaleIDs(arrayList);
        ArrayList arrayList2 = new ArrayList();
        for (Integer num : arrayList) {
            SpenColorPaletteData spenColorPaletteData = new SpenColorPaletteData();
            spenColorPaletteData.index = num.intValue();
            arrayList2.add(spenColorPaletteData);
        }
        spenColorPaletteUtil.getColorTables(arrayList2);
        setColorInfoInHashMap(arrayList2);
    }

    private static String intToHexColor(int i) {
        return String.format("#%06X", Integer.valueOf(i & 16777215));
    }

    private static void setColorInfoInHashMap(List<SpenColorPaletteData> list) {
        mColorMap.clear();
        for (SpenColorPaletteData spenColorPaletteData : list) {
            int i = 0;
            while (true) {
                int[] iArr = spenColorPaletteData.values;
                if (i < iArr.length) {
                    mColorMap.put(Integer.valueOf(iArr[i]), spenColorPaletteData.names[i]);
                    i++;
                }
            }
        }
    }
}
