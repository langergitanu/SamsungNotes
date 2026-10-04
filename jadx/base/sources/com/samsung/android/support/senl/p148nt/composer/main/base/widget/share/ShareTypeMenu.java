package com.samsung.android.support.senl.p148nt.composer.main.base.widget.share;

import android.app.Activity;
import android.view.View;
import com.samsung.android.support.senl.p148nt.app.addons.AbstractC8014b;
import com.samsung.android.support.senl.p148nt.base.common.UserInputSkipper;
import com.samsung.android.support.senl.p148nt.base.common.constants.Constants;
import com.samsung.android.support.senl.p148nt.base.composer.share.ShareIntentCreationHelper;
import com.samsung.android.support.senl.p148nt.composer.main.base.util.Logger;
import com.samsung.android.support.senl.p148nt.composer.main.base.widget.share.AbsPopupMenu;
import com.samsung.android.support.senl.p148nt.composer.main.base.widget.share.ShareMenuContract;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes3.dex */
class ShareTypeMenu extends AbsPopupMenu {
    private static final String TAG = Logger.createTag("ShareTypeMenu");
    List<ShareMenuContract.ShareType> mMenuList;
    ShareMenuContract.ShareType mShareType;
    LinkedHashMap<ShareMenuContract.ShareType, String> mShareTypeItems = null;

    @Override // com.samsung.android.support.senl.p148nt.composer.main.base.widget.share.AbsPopupMenu
    public ArrayList<String> getMenuItems() {
        return new ArrayList<>(this.mShareTypeItems.values());
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.base.widget.share.AbsPopupMenu
    public View.OnClickListener getOnClickListener() {
        return new View.OnClickListener() { // from class: com.samsung.android.support.senl.nt.composer.main.base.widget.share.ShareTypeMenu.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                int iIntValue = ((Integer) view.getTag()).intValue();
                if (iIntValue < ShareTypeMenu.this.mShareTypeItems.size()) {
                    ShareTypeMenu shareTypeMenu = ShareTypeMenu.this;
                    shareTypeMenu.mShareType = (ShareMenuContract.ShareType) shareTypeMenu.mShareTypeItems.keySet().toArray()[iIntValue];
                    String tag = ShareTypeMenu.this.getTag();
                    StringBuilder sb = new StringBuilder("onClick# which: ");
                    ShareTypeMenu shareTypeMenu2 = ShareTypeMenu.this;
                    AbstractC8014b.m7213o(sb, shareTypeMenu2.mShareTypeItems.get(shareTypeMenu2.mShareType), tag);
                    UserInputSkipper.setHoldingEventTime(2000L, UserInputSkipper.Tag.ShareViaChooser);
                    AbsPopupMenu.OnItemClickListener onItemClickListener = ShareTypeMenu.this.mOnItemClickListener;
                    if (onItemClickListener != null) {
                        onItemClickListener.onItemClick();
                    }
                }
                ShareTypeMenu.this.mPopupMenu.dismiss();
            }
        };
    }

    public ShareMenuContract.ShareType getShareType() {
        return this.mShareType;
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.base.widget.share.AbsPopupMenu
    public String getTag() {
        return TAG;
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.base.widget.share.AbsPopupMenu
    public void initShareTypeItems(Activity activity) {
        if (this.mShareTypeItems != null) {
            return;
        }
        this.mShareTypeItems = new LinkedHashMap<>();
        for (ShareMenuContract.ShareType shareType : this.mMenuList) {
            if (shareType == ShareMenuContract.ShareType.DOC && ShareIntentCreationHelper.getActionViewSendInfo(activity, Constants.MIME_DOCX).isEmpty()) {
                Logger.m11003i(getTag(), "initShareTypeItems# app of MIME_DOCX is empty");
            } else if (shareType == ShareMenuContract.ShareType.PPTX && ShareIntentCreationHelper.getActionViewSendInfo(activity, Constants.MIME_PPTX).isEmpty()) {
                Logger.m11003i(getTag(), "initShareTypeItems# app of MIME_PPTX is empty");
            } else {
                this.mShareTypeItems.put(shareType, activity.getResources().getString(shareType.resId));
            }
        }
    }

    public void setMenuList(List<ShareMenuContract.ShareType> list) {
        this.mMenuList = list;
    }
}
