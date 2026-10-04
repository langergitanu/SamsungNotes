package com.samsung.android.support.senl.p148nt.app.main.noteslist.tipcard.type;

import com.samsung.android.support.senl.p145cm.base.framework.feature.CscFeature;
import com.samsung.android.support.senl.p145cm.base.framework.p146os.UserHandleCompat;
import com.samsung.android.support.senl.p145cm.base.framework.support.BaseUtils;
import com.samsung.android.support.senl.p148nt.app.C8003R;
import com.samsung.android.support.senl.p148nt.base.common.tipcard.TipCard;
import com.samsung.android.support.senl.p148nt.base.common.util.CommonUtils;
import com.samsung.android.support.senl.p148nt.base.common.util.DeviceUtils;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes2.dex */
public class TipCardImportNoteFromAccount extends TipCard {
    /* JADX WARN: Illegal instructions before constructor call */
    public TipCardImportNoteFromAccount() {
        CscFeature.Companion companion = CscFeature.INSTANCE;
        super(18, companion.getInstance().isSecBrandAsGalaxy() ? C8003R.string.tipcard_import_account_title_jp : C8003R.string.tipcard_import_account_title, 0, C8003R.string.base_string_settings, 0, 4);
        if (UserHandleCompat.getInstance().isSecureFolderMode() || UserHandleCompat.getInstance().isKnoxMode() || !CommonUtils.hasCloudSetting(BaseUtils.getApplicationContext())) {
            setBodyResource(DeviceUtils.isTabletModel() ? C8003R.string.tipcard_import_account_message_secure_folder_tablet : C8003R.string.tipcard_import_account_message_secure_folder);
        } else if (DeviceUtils.isTabletModel()) {
            setBodyResource(companion.getInstance().isSecBrandAsGalaxy() ? C8003R.string.tipcard_import_account_message_jp_tablet : C8003R.string.tipcard_import_account_message_tablet);
        } else {
            setBodyResource(companion.getInstance().isSecBrandAsGalaxy() ? C8003R.string.tipcard_import_account_message_jp : C8003R.string.tipcard_import_account_message);
        }
    }
}
