package com.samsung.android.support.senl.p148nt.composer.main.base.presenter.bixby;

import android.os.Handler;
import android.os.Looper;
import com.samsung.android.support.notes.bixby.bixby2.constants.Bixby2Constants;
import com.samsung.android.support.senl.p148nt.app.addons.AbstractC8014b;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.option.OptionMenuSharePresenter;
import com.samsung.android.support.senl.p148nt.composer.main.base.util.Logger;
import com.samsung.android.support.senl.p148nt.composer.main.base.widget.share.ShareMenuContract;
import com.samsung.android.support.senl.p148nt.data.database.core.query.sqlbuilder.SQLKeyword;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes3.dex */
public class BixbyActionShare extends BixbyAction {
    private final String TAG = Logger.createTag("BixbyActionShare");
    String mActivityName;
    String mPackageName;
    ShareMenuContract.ShareType mShareType;

    public BixbyActionShare(String str, String str2, String str3) {
        if (str == null) {
            this.mShareType = null;
        } else if (Bixby2Constants.SLOT_VALUE_SHARE_AS_SDOC.equalsIgnoreCase(str)) {
            this.mShareType = ShareMenuContract.ShareType.SDOC;
        } else if ("PDF".equalsIgnoreCase(str)) {
            this.mShareType = ShareMenuContract.ShareType.PDF;
        } else if ("Image".equalsIgnoreCase(str)) {
            this.mShareType = ShareMenuContract.ShareType.IMAGE;
        } else if (Bixby2Constants.SLOT_VALUE_SHARE_AS_TEXT_ONLY.equalsIgnoreCase(str) || Bixby2Constants.SLOT_VALUE_SHARE_AS_TEXT.equalsIgnoreCase(str)) {
            this.mShareType = ShareMenuContract.ShareType.TEXT;
        } else if (Bixby2Constants.SLOT_VALUE_SHARE_AS_DOC.equalsIgnoreCase(str)) {
            this.mShareType = ShareMenuContract.ShareType.DOC;
        }
        this.mPackageName = str2;
        this.mActivityName = str3;
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.base.presenter.bixby.BixbyAction
    public void execute(final BixbyContract bixbyContract) {
        new Handler(Looper.getMainLooper()).postDelayed(new Runnable() { // from class: com.samsung.android.support.senl.nt.composer.main.base.presenter.bixby.BixbyActionShare.1
            @Override // java.lang.Runnable
            public void run() {
                String str = BixbyActionShare.this.TAG;
                StringBuilder sb = new StringBuilder("execute# ");
                sb.append(BixbyActionShare.this.mShareType);
                sb.append(SQLKeyword.COMMA);
                sb.append(BixbyActionShare.this.mPackageName);
                sb.append(SQLKeyword.COMMA);
                AbstractC8014b.m7213o(sb, BixbyActionShare.this.mActivityName, str);
                OptionMenuSharePresenter optionMenuSharePresenter = bixbyContract.getMenuManager().getOptionMenuPresenter().getOptionMenuSharePresenter();
                BixbyActionShare bixbyActionShare = BixbyActionShare.this;
                optionMenuSharePresenter.setShareTo(bixbyActionShare.mPackageName, bixbyActionShare.mActivityName);
                ShareMenuContract.ShareType shareType = BixbyActionShare.this.mShareType;
                if (shareType == null) {
                    optionMenuSharePresenter.showShareMenu(bixbyContract.getActivity());
                } else {
                    optionMenuSharePresenter.setShareType(shareType);
                    optionMenuSharePresenter.shareNote();
                }
            }
        }, 500L);
    }
}
