package com.samsung.android.support.senl.p148nt.composer.main.base.widget.share;

import android.app.Activity;
import android.view.View;
import com.samsung.android.support.senl.p145cm.base.framework.content.SharedPreferencesCompat;
import com.samsung.android.support.senl.p148nt.app.addons.AbstractC8014b;
import com.samsung.android.support.senl.p148nt.base.common.UserInputSkipper;
import com.samsung.android.support.senl.p148nt.base.common.constants.SettingsConstants;
import com.samsung.android.support.senl.p148nt.composer.C9086R;
import com.samsung.android.support.senl.p148nt.composer.main.base.util.Logger;
import com.samsung.android.support.senl.p148nt.composer.main.base.util.p156sa.ComposerSA;
import com.samsung.android.support.senl.p148nt.composer.main.base.util.p156sa.ComposerSAConstants;
import com.samsung.android.support.senl.p148nt.composer.main.base.widget.share.AbsPopupMenu;
import java.util.ArrayList;
import java.util.LinkedHashMap;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes3.dex */
public class WordTypeMenu extends AbsPopupMenu {
    private static final String TAG = Logger.createTag("WordTypeMenu");
    protected LinkedHashMap<Integer, String> mWordShareTypeItems = null;
    private LinkedHashMap<Integer, String> mSATypeItems = null;

    @Override // com.samsung.android.support.senl.p148nt.composer.main.base.widget.share.AbsPopupMenu
    public ArrayList<String> getMenuItems() {
        return new ArrayList<>(this.mWordShareTypeItems.values());
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.base.widget.share.AbsPopupMenu
    public View.OnClickListener getOnClickListener() {
        return new View.OnClickListener() { // from class: com.samsung.android.support.senl.nt.composer.main.base.widget.share.WordTypeMenu.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                int iIntValue = ((Integer) view.getTag()).intValue();
                if (iIntValue < WordTypeMenu.this.mWordShareTypeItems.size()) {
                    Integer num = (Integer) WordTypeMenu.this.mWordShareTypeItems.keySet().toArray()[iIntValue];
                    int iIntValue2 = num.intValue();
                    AbstractC8014b.m7213o(new StringBuilder("onClick# which: "), WordTypeMenu.this.mWordShareTypeItems.get(num), WordTypeMenu.this.getTag());
                    UserInputSkipper.setHoldingEventTime(2000L, UserInputSkipper.Tag.ShareViaChooser);
                    SharedPreferencesCompat.getInstance("Settings").putInt(SettingsConstants.SETTINGS_EXPORT, iIntValue2);
                    ComposerSA.insertLog("748", (String) WordTypeMenu.this.mSATypeItems.get(num));
                    AbsPopupMenu.OnItemClickListener onItemClickListener = WordTypeMenu.this.mOnItemClickListener;
                    if (onItemClickListener != null) {
                        onItemClickListener.onItemClick();
                    }
                }
                WordTypeMenu.this.mPopupMenu.dismiss();
            }
        };
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.base.widget.share.AbsPopupMenu
    public String getTag() {
        return TAG;
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.base.widget.share.AbsPopupMenu
    public void initShareTypeItems(Activity activity) {
        if (this.mWordShareTypeItems != null) {
            return;
        }
        LinkedHashMap<Integer, String> linkedHashMap = new LinkedHashMap<>();
        this.mWordShareTypeItems = linkedHashMap;
        linkedHashMap.put(0, activity.getString(C9086R.string.export_text_only));
        this.mWordShareTypeItems.put(1, activity.getString(C9086R.string.export_image_only));
        this.mWordShareTypeItems.put(2, activity.getString(C9086R.string.export_image_and_text));
        LinkedHashMap<Integer, String> linkedHashMap2 = new LinkedHashMap<>();
        this.mSATypeItems = linkedHashMap2;
        linkedHashMap2.put(0, ComposerSAConstants.EVENT_DIALOGS_EXPORT_HW_AS_TEXT_ONLY);
        this.mSATypeItems.put(1, ComposerSAConstants.EVENT_DIALOGS_EXPORT_HW_AS_IMAGE_ONLY);
        this.mSATypeItems.put(2, ComposerSAConstants.EVENT_DIALOGS_EXPORT_HW_AS_IMAGE_AND_TEXT);
    }

    public void showPopupMenu(Activity activity, View view) {
        super.showPopupMenu(activity, view, activity.getString(C9086R.string.header_export_handwriting_as));
    }
}
