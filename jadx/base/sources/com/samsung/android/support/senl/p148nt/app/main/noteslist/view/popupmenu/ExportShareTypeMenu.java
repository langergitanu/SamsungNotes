package com.samsung.android.support.senl.p148nt.app.main.noteslist.view.popupmenu;

import android.app.Activity;
import android.content.res.Resources;
import android.view.View;
import com.samsung.android.support.senl.p145cm.base.framework.feature.CscFeature;
import com.samsung.android.support.senl.p148nt.app.C8003R;
import com.samsung.android.support.senl.p148nt.app.addons.AbstractC8014b;
import com.samsung.android.support.senl.p148nt.app.common.log.MainLogger;
import com.samsung.android.support.senl.p148nt.app.main.noteslist.model.checkdata.CheckedNoteInfo;
import com.samsung.android.support.senl.p148nt.base.common.UserInputSkipper;
import com.samsung.android.support.senl.p148nt.base.common.constants.Constants;
import com.samsung.android.support.senl.p148nt.base.composer.share.ShareIntentCreationHelper;
import com.samsung.android.support.senl.p148nt.composer.main.base.widget.share.AbsPopupMenu;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes2.dex */
public class ExportShareTypeMenu extends AbsPopupMenu {
    private static final String TAG = "ExportShareTypeMenu";
    private final ArrayList<CheckedNoteInfo> mCheckedNoteInfoList;
    private boolean mIsMenuClicked;
    private final boolean mIsZipFileTypeNeed;
    private int mShareType;
    private final Map<Integer, String> mShareTypeItems = new LinkedHashMap();
    private final int mShareableNoteListSize;

    public ExportShareTypeMenu(ArrayList<CheckedNoteInfo> arrayList, boolean z) {
        this.mCheckedNoteInfoList = arrayList;
        this.mShareableNoteListSize = arrayList.size();
        this.mIsZipFileTypeNeed = z;
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.base.widget.share.AbsPopupMenu
    public ArrayList<String> getMenuItems() {
        return new ArrayList<>(this.mShareTypeItems.values());
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.base.widget.share.AbsPopupMenu
    public View.OnClickListener getOnClickListener() {
        return new View.OnClickListener() { // from class: com.samsung.android.support.senl.nt.app.main.noteslist.view.popupmenu.ExportShareTypeMenu.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                int iIntValue = ((Integer) view.getTag()).intValue();
                if (iIntValue < ExportShareTypeMenu.this.mShareTypeItems.size()) {
                    ExportShareTypeMenu exportShareTypeMenu = ExportShareTypeMenu.this;
                    exportShareTypeMenu.mShareType = ((Integer) exportShareTypeMenu.mShareTypeItems.keySet().toArray()[iIntValue]).intValue();
                    MainLogger.m7254d(ExportShareTypeMenu.this.getTag(), "onClick# which: " + ((String) ExportShareTypeMenu.this.mShareTypeItems.get(Integer.valueOf(ExportShareTypeMenu.this.mShareType))));
                    UserInputSkipper.setHoldingEventTime(2000L, UserInputSkipper.Tag.ShareViaChooser);
                    ExportShareTypeMenu.this.mIsMenuClicked = true;
                    if (((AbsPopupMenu) ExportShareTypeMenu.this).mOnItemClickListener != null) {
                        ((AbsPopupMenu) ExportShareTypeMenu.this).mOnItemClickListener.onItemClick();
                    }
                }
                ((AbsPopupMenu) ExportShareTypeMenu.this).mPopupMenu.dismiss();
            }
        };
    }

    public int getShareType() {
        return this.mShareType;
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.base.widget.share.AbsPopupMenu
    public String getTag() {
        return TAG;
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.base.widget.share.AbsPopupMenu
    public void initShareTypeItems(Activity activity) {
        this.mShareTypeItems.clear();
        if (this.mShareableNoteListSize <= 0) {
            MainLogger.m7255e(TAG, "initShareTypeItems# sharableNoteList is null or empty");
            return;
        }
        Resources resources = activity.getResources();
        this.mShareTypeItems.put(0, resources.getString(CscFeature.INSTANCE.getInstance().isSecBrandAsGalaxy() ? C8003R.string.composer_share_sdoc_jp : C8003R.string.composer_share_sdoc));
        if (this.mShareableNoteListSize <= 100) {
            Iterator<CheckedNoteInfo> it = this.mCheckedNoteInfoList.iterator();
            while (true) {
                if (!it.hasNext()) {
                    this.mShareTypeItems.put(1, resources.getString(C8003R.string.composer_share_pdf));
                    break;
                } else if (it.next().getUnknownMinVersion() != 0) {
                    break;
                }
            }
        } else {
            AbstractC8014b.m7212n(new StringBuilder("initShareTypeItems# MAXIMUM_PDF_SHARE_COUNT - sharableNoteListSize : "), getTag(), this.mShareableNoteListSize);
        }
        if (ShareIntentCreationHelper.getActionViewSendInfo(activity, Constants.MIME_DOCX).isEmpty()) {
            MainLogger.m7258i(getTag(), "initShareTypeItems# app of MIME_DOCX is empty");
        } else {
            this.mShareTypeItems.put(2, resources.getString(C8003R.string.composer_share_doc));
        }
        if (ShareIntentCreationHelper.getActionViewSendInfo(activity, Constants.MIME_PPTX).isEmpty()) {
            MainLogger.m7258i(getTag(), "initShareTypeItems# app of MIME_PPTX is empty");
        } else {
            this.mShareTypeItems.put(3, resources.getString(C8003R.string.composer_share_pptx));
        }
        this.mShareTypeItems.put(4, resources.getString(C8003R.string.composer_share_image));
        this.mShareTypeItems.put(5, resources.getString(C8003R.string.composer_share_text_only));
        if (this.mIsZipFileTypeNeed) {
            Map<Integer, String> map = this.mShareTypeItems;
            StringBuilder sb = new StringBuilder();
            AbstractC8014b.m7202d(resources, C8003R.string.action_save_as_zip, sb, " ");
            sb.append(resources.getString(C8003R.string.action_save_as_file));
            map.put(7, sb.toString());
        }
    }

    public boolean isMenuClicked() {
        return this.mIsMenuClicked;
    }
}
