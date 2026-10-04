package com.samsung.android.support.senl.p148nt.composer.main.base.view.menu.template.util;

import android.content.res.TypedArray;
import com.samsung.android.support.senl.p145cm.base.framework.content.TypedArrayCompat;
import com.samsung.android.support.senl.p148nt.composer.C9086R;
import com.samsung.android.support.senl.p148nt.composer.main.base.util.CTLogger;
import com.samsung.android.support.senl.p148nt.composer.main.base.util.Logger;
import java.util.HashMap;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes3.dex */
public class TemplateIndexConverter {
    private static final String TAG = CTLogger.createTag("TemplateIndexConverter");
    private static HashMap<String, Integer> mWPageIndexMap;

    public static void clearWPageIndexMap() {
        Logger.m10999d(TAG, "clearWPageIndexMap#");
        mWPageIndexMap = null;
    }

    public static int convertTemplateNameToWPageIndex(String str) {
        if (mWPageIndexMap == null) {
            initWPageIndexMap();
        }
        int iIntValue = -1;
        try {
            if (mWPageIndexMap.containsKey(str)) {
                iIntValue = mWPageIndexMap.get(str).intValue();
            }
        } catch (Exception unused) {
            Logger.m11000e(TAG, "convertTemplateNameToWPageIndex# exception");
        }
        Logger.m10999d(TAG, "convertTemplateNameToWPageIndex# " + iIntValue + " templateName# " + str);
        return iIntValue;
    }

    private static void initWPageIndexMap() {
        Logger.m10999d(TAG, "initWPageIndexMap#");
        mWPageIndexMap = new HashMap<>();
        TypedArrayCompat.Companion companion = TypedArrayCompat.INSTANCE;
        TypedArray typedArrayObtainTypedArray = companion.getInstance().obtainTypedArray(C9086R.array.comp_change_template_essential_template_name);
        TypedArray typedArrayObtainTypedArray2 = companion.getInstance().obtainTypedArray(C9086R.array.comp_change_template_essential_template_wpage_index);
        try {
            try {
                int length = typedArrayObtainTypedArray.length();
                for (int i = 0; i < length; i++) {
                    mWPageIndexMap.put(typedArrayObtainTypedArray.getString(i), Integer.valueOf(typedArrayObtainTypedArray2.getInt(i, 0)));
                }
            } catch (Exception unused) {
                Logger.m11000e(TAG, "TemplateIndexConverter# exception");
            }
        } finally {
            typedArrayObtainTypedArray.recycle();
            typedArrayObtainTypedArray2.recycle();
        }
    }
}
