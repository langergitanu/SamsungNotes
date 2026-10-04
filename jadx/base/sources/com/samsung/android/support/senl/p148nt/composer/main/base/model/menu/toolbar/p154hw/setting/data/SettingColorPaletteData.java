package com.samsung.android.support.senl.p148nt.composer.main.base.model.menu.toolbar.p154hw.setting.data;

import com.samsung.android.sdk.pen.setting.pencommon.SpenColorSettingInfo;
import com.samsung.android.support.senl.p148nt.app.addons.AbstractC8014b;
import com.samsung.android.support.senl.p148nt.base.winset.app.picker.color.ColorPaletteData;
import com.samsung.android.support.senl.p148nt.composer.main.base.model.menu.toolbar.p154hw.setting.migration.AbsMigrationPolicy;
import com.samsung.android.support.senl.p148nt.composer.main.base.model.menu.toolbar.p154hw.setting.migration.LegacyVersionException;
import com.samsung.android.support.senl.p148nt.composer.main.base.util.Logger;
import com.samsung.android.support.senl.p148nt.data.database.core.query.sqlbuilder.SQLKeyword;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes3.dex */
public class SettingColorPaletteData extends AbsMigrationPolicy<List<Integer>> {
    private static final String KEY_SETTING_COLOR_PALETTE = "KEY_SETTING_COLOR_PALETTE";
    private static final String TAG = Logger.createTag("SettingColorPaletteData");
    private List<Integer> mList;

    public SettingColorPaletteData() {
        super(KEY_SETTING_COLOR_PALETTE);
        ArrayList arrayList = new ArrayList();
        this.mList = arrayList;
        super.restore(arrayList);
    }

    private void loadData(List<Integer> list, String str) {
        for (String str2 : str.split(";")) {
            this.mList.add(Integer.valueOf(str2));
        }
    }

    public SpenColorSettingInfo getColorSettingInfo() {
        return new SpenColorSettingInfo(getSwatchList(), getMaxSelectCount());
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.base.model.menu.toolbar.p154hw.setting.migration.AbsMigrationPolicy
    public String getInfoString() {
        return getInfoString(this.mList);
    }

    public int getMaxSelectCount() {
        return 4;
    }

    public List<Integer> getSelectList() {
        return this.mList;
    }

    public List<Integer> getSwatchList() {
        return ColorPaletteData.getDefaultSwatchList();
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.base.model.menu.toolbar.p154hw.setting.migration.AbsMigrationPolicy
    public boolean replace(String str) {
        this.mList.clear();
        return super.replace(this.mList, str);
    }

    public void setSelectList(List<Integer> list) {
        if (list == null) {
            return;
        }
        List<Integer> list2 = this.mList;
        if (list2 == null) {
            this.mList = new ArrayList();
        } else {
            list2.clear();
        }
        this.mList.addAll(list);
        String infoString = getInfoString();
        AbstractC8014b.m7197C("setSelectList : ", infoString, TAG);
        super.saveData(infoString);
    }

    private String getInfoString(List<Integer> list) {
        StringBuilder sb = new StringBuilder();
        Iterator<Integer> it = list.iterator();
        while (it.hasNext()) {
            sb.append(it.next());
            sb.append(SQLKeyword.DELIMITER);
        }
        return sb.toString();
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.base.model.menu.toolbar.p154hw.setting.migration.AbsMigrationPolicy
    public void loadDefault(List<Integer> list) {
        list.addAll(ColorPaletteData.getDefaultSelectList());
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.base.model.menu.toolbar.p154hw.setting.migration.AbsMigrationPolicy
    public void loadPreference(List<Integer> list, String str) {
        loadData(list, str);
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.base.model.menu.toolbar.p154hw.setting.migration.AbsMigrationPolicy
    public void migrate(List<Integer> list, LegacyVersionException legacyVersionException) {
        list.clear();
        loadData(list, legacyVersionException.getValue());
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.base.model.menu.toolbar.p154hw.setting.migration.AbsMigrationPolicy
    public void store(List<Integer> list) {
        String infoString = getInfoString(list);
        AbstractC8014b.m7197C("setSelectList : ", infoString, TAG);
        super.saveData(infoString);
    }
}
