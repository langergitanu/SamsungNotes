package com.samsung.android.support.senl.p148nt.base.composer.share;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.os.Parcelable;
import com.microsoft.identity.common.adal.internal.AuthenticationConstants;
import com.samsung.android.support.senl.p148nt.base.framework.support.Logger;
import com.samsung.android.support.senl.p148nt.model.securefolder.common.SecureFolderConstants;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes2.dex */
public class ShareComponents {
    public static final String EXTRA_CHOOSER_DROPLIST = "extra_chooser_droplist";
    private static final String TAG = Logger.createTag("CPLog$ShareComponents");
    private static ArrayList<Class<?>> mAppActivityList;

    public static List<ComponentName> getChinaDropShareComponent() {
        ArrayList arrayList = new ArrayList();
        arrayList.add(new ComponentName("com.tencent.mm", "com.tencent.mm.ui.tools.ShareImgUI"));
        arrayList.add(new ComponentName("com.tencent.mm", "com.tencent.mm.ui.tools.ShareToTimeLineUI"));
        arrayList.add(new ComponentName("com.tencent.mm", "com.tencent.mm.ui.tools.AddFavoriteUI"));
        arrayList.add(new ComponentName("com.tencent.mobileqq", "com.tencent.mobileqq.activity.JumpActivity"));
        arrayList.add(new ComponentName("com.tencent.mobileqq", "com.tencent.mobileqq.activity.qfileJumpActivity"));
        arrayList.add(new ComponentName("com.tencent.mobileqq", "cooperation.qqfav.widget.QfavJumpActivity"));
        arrayList.add(new ComponentName("com.tencent.mobileqq", "cooperation.qlink.QlinkShareJumpActivity"));
        arrayList.add(new ComponentName("com.tencent.mobileqqi", "com.tencent.mobileqq.activity.JumpActivity"));
        arrayList.add(new ComponentName("com.tencent.mobileqqi", "com.tencent.mobileqq.activity.LoginActivity"));
        arrayList.add(new ComponentName("com.tencent.mobileqqi", "com.tencent.mobileqq.activity.qfileJumpActivity"));
        return arrayList;
    }

    public static List<ComponentName> getDocShareComponent() {
        ArrayList arrayList = new ArrayList();
        arrayList.add(new ComponentName("com.samsung.android.app.FileShareClient", "com.samsung.android.app.FileShareClient.DeviceSelectActivity"));
        arrayList.add(new ComponentName("com.samsung.android.allshare.service.fileshare", "com.samsung.android.allshare.service.fileshare.client.DeviceSelectActivity"));
        arrayList.add(new ComponentName("com.android.bluetooth", "com.android.bluetooth.opp.BluetoothOppLauncherActivity"));
        arrayList.add(new ComponentName("com.android.nfc", "com.android.nfc.BeamShareActivity"));
        return arrayList;
    }

    public static List<ComponentName> getDropShareComponent(Context context) {
        ArrayList arrayList = new ArrayList();
        ArrayList<Class<?>> arrayList2 = mAppActivityList;
        if (arrayList2 == null || arrayList2.isEmpty()) {
            Logger.m8697d(TAG, "getDropShareComponent# mAppActivityList is null");
        } else {
            Iterator<Class<?>> it = mAppActivityList.iterator();
            while (it.hasNext()) {
                arrayList.add(new ComponentName(context, it.next()));
            }
        }
        arrayList.add(new ComponentName("com.google.android.youtube", "com.google.android.youtube.UploadIntentHandlingActivity"));
        arrayList.add(new ComponentName("com.google.android.youtube", "com.google.android.apps.youtube.app.honeycomb.phone.UploadActivity"));
        arrayList.add(new ComponentName("com.sec.knox.switcher", "com.sec.knox.switcher.B2CStoreFilesActivity"));
        return arrayList;
    }

    public static ComponentName getEmailComponent() {
        return new ComponentName("com.samsung.android.email.provider", "com.samsung.android.email.composer.activity.MessageCompose");
    }

    public static ArrayList<ComponentName> getExcludeComponentsForKnox() {
        ArrayList<ComponentName> arrayList = new ArrayList<>();
        arrayList.add(new ComponentName(SecureFolderConstants.SECURE_FOLDER_PACKAGE, "com.samsung.knox.securefolder.switcher.B2CStoreFilesActivity"));
        arrayList.add(new ComponentName("com.samsung.android.knox.containeragent", "com.samsung.android.knox.containeragent.switcher.fileshare.B2CStoreFilesActivity"));
        return arrayList;
    }

    public static List<ComponentName> getKnoxComponent() {
        ArrayList arrayList = new ArrayList();
        arrayList.add(new ComponentName("com.sec.knox.switcher", "com.sec.knox.switcher.SwitchSfActivity"));
        arrayList.add(new ComponentName("com.sec.knox.switcher", "com.sec.knox.switcher.SwitchB2bActivityI"));
        return arrayList;
    }

    public static List<String> getMobileOfficePackageList() {
        ArrayList arrayList = new ArrayList();
        arrayList.add("com.microsoft.office.word");
        arrayList.add("com.microsoft.office.powerpoint");
        arrayList.add("com.microsoft.office.officehubrow");
        arrayList.add(AuthenticationConstants.Broker.LTW_APP_PACKAGE_NAME);
        arrayList.add("com.microsoft.office.officehubhl");
        arrayList.add("com.microsoft.office.officehub");
        arrayList.add("com.hancom.office.editor.netffice");
        arrayList.add("com.hancom.office.editor.hidden");
        arrayList.add("com.hancom.office.viewer");
        return arrayList;
    }

    public static void initAppDropList(ArrayList<Class<?>> arrayList) {
        mAppActivityList = arrayList;
    }

    public static void putExcludeComponentsForKnox(Intent intent) {
        intent.putExtra("android.intent.extra.EXCLUDE_COMPONENTS", (Parcelable[]) getExcludeComponentsForKnox().toArray(new Parcelable[0]));
    }
}
