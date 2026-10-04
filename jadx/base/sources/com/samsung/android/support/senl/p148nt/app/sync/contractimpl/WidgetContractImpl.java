package com.samsung.android.support.senl.p148nt.app.sync.contractimpl;

import android.content.Context;
import com.samsung.android.app.notes.widget.AppWidgetUtils;
import com.samsung.android.app.notes.widget.preference.WidgetPreferenceManager;
import com.samsung.android.support.senl.p148nt.base.widget.preference.BaseWidgetPreferenceManager;
import com.samsung.android.support.senl.p148nt.base.widget.util.BaseWidgetUtils;
import java.util.ArrayList;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes2.dex */
public class WidgetContractImpl {
    public String getCreatorSelectedList(Context context, int i) {
        return BaseWidgetPreferenceManager.getCreatorSelectedList(i);
    }

    public String getNoteList(Context context, int i) {
        return WidgetPreferenceManager.getNoteList(i);
    }

    public int getWidgetBackgroundColor(Context context, int i) {
        return BaseWidgetPreferenceManager.getBackgroundColor(i);
    }

    public boolean getWidgetBackgroundOnOff(Context context, int i) {
        return BaseWidgetPreferenceManager.getWidgetBackgroundOnOff(i);
    }

    public int getWidgetBackgroundShape(Context context, int i) {
        return BaseWidgetPreferenceManager.getWidgetBackgroundShape(i);
    }

    public int getWidgetDarkMode(Context context, int i) {
        return BaseWidgetPreferenceManager.getDarkMode(i);
    }

    public String getWidgetHomeMode(Context context, int i) {
        return WidgetPreferenceManager.getWidgetHomeModePref(i);
    }

    public ArrayList<String[]> getWidgetInfoList(Context context) {
        ArrayList<String[]> arrayList = new ArrayList<>();
        arrayList.addAll(AppWidgetUtils.getWidgetInfoList(context));
        arrayList.addAll(BaseWidgetUtils.getWidgetToolbarInfoList(context));
        return arrayList;
    }

    public boolean getWidgetMatchSetting(Context context, int i) {
        return BaseWidgetPreferenceManager.getWidgetMatchSetting(i);
    }

    public int getWidgetTransparency(Context context, int i) {
        return BaseWidgetPreferenceManager.getTransparency(i);
    }

    public boolean getWidgetTransparencyReverse(Context context, int i) {
        return BaseWidgetPreferenceManager.isReverseTransparency(i);
    }
}
