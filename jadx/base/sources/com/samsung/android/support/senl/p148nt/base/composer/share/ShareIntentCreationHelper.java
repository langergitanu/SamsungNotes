package com.samsung.android.support.senl.p148nt.base.composer.share;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.net.Uri;
import android.os.Build;
import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import androidx.annotation.Nullable;
import com.samsung.android.support.senl.p148nt.base.C8875R;
import com.samsung.android.support.senl.p148nt.base.common.constants.Constants;
import com.samsung.android.support.senl.p148nt.base.common.util.FileUtils;
import com.samsung.android.support.senl.p148nt.base.composer.share.ShareCallbackReceiver;
import com.samsung.android.support.senl.p148nt.base.framework.provider.ShareFileProvider;
import com.samsung.android.support.senl.p148nt.base.framework.support.Logger;
import com.samsung.android.support.senl.p148nt.composer.main.screenoff.util.Constants;
import java.io.ByteArrayOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes2.dex */
public class ShareIntentCreationHelper {
    private static final int DELAY_TIME_TO_DELETE_DATA = 2000;
    public static final String KEY_SHARED_INTENT = "KEY_SHARED_INTENT";
    private static final String TAG = Logger.createTag("CPLog$ShareIntentCreationHelper");

    private static void applyAlertIntentToDropList(@Nullable List<Intent> list, ArrayList<ComponentName> arrayList) {
        if (list == null || list.isEmpty()) {
            return;
        }
        if (list.size() > 1) {
            arrayList.addAll(ShareComponents.getDocShareComponent());
            arrayList.addAll(ShareComponents.getKnoxComponent());
        }
        if (Build.VERSION.SDK_INT > 34) {
            return;
        }
        Iterator<Intent> it = list.iterator();
        while (it.hasNext()) {
            ComponentName component = it.next().getComponent();
            if (component != null && component.getPackageName() != null && component.getClassName() != null) {
                ComponentName componentName = new ComponentName(component.getPackageName(), component.getClassName());
                if (!arrayList.contains(componentName)) {
                    arrayList.add(componentName);
                }
            }
        }
    }

    private static void applyIntentToDropList(Context context, Intent intent, ArrayList<ComponentName> arrayList) {
        if (needToAddChinaDropShareComponent(intent)) {
            arrayList.addAll(ShareComponents.getChinaDropShareComponent());
        }
        arrayList.addAll(ShareComponents.getDropShareComponent(context));
        if (Constants.MIME_IMAGE.equals(intent.getType())) {
            String stringExtra = intent.getStringExtra("android.intent.extra.TITLE");
            String stringExtra2 = intent.getStringExtra("android.intent.extra.SUBJECT");
            String stringExtra3 = intent.getStringExtra("android.intent.extra.TEXT");
            if (!"android.intent.action.SEND_MULTIPLE".equals(intent.getAction()) && TextUtils.isEmpty(stringExtra) && TextUtils.isEmpty(stringExtra3) && TextUtils.isEmpty(stringExtra2)) {
                return;
            }
            arrayList.add(new ComponentName(Constants.ExternalPackageName.AOD_SERVICE, "com.samsung.android.app.aodservice.settings.AODPinnedPreviewActivity"));
        }
    }

    @SuppressLint({"UnspecifiedRegisterReceiverFlag"})
    private static Intent createChooserCompat(Context context, Intent intent, @Nullable List<Intent> list, @Nullable ShareCallbackReceiver.ShareCaller shareCaller) {
        ShareComponents.putExcludeComponentsForKnox(intent);
        Intent intentCreateChooser = Intent.createChooser(intent, context.getString(C8875R.string.action_share), new ShareCallbackReceiver().getIntentSender(context, shareCaller, context instanceof Activity ? getPathAfterCreateSharedDataInIntent((Activity) context, intent) : null));
        if (list != null && !list.isEmpty()) {
            intentCreateChooser.putExtra("android.intent.extra.ALTERNATE_INTENTS", (Parcelable[]) list.toArray(new Intent[list.size()]));
        }
        return intentCreateChooser;
    }

    public static Intent createChooserIntentCompat(Context context, Intent intent, @Nullable List<Intent> list, @Nullable ShareCallbackReceiver.ShareCaller shareCaller) {
        ArrayList<? extends Parcelable> arrayList = new ArrayList<>();
        applyIntentToDropList(context, intent, arrayList);
        applyAlertIntentToDropList(list, arrayList);
        Intent intentCreateChooserCompat = createChooserCompat(context, intent, list, shareCaller);
        if (!arrayList.isEmpty()) {
            if (Build.VERSION.SDK_INT > 34) {
                intentCreateChooserCompat.putExtra("android.intent.extra.EXCLUDE_COMPONENTS", (Parcelable[]) arrayList.toArray(new Parcelable[0]));
                return intentCreateChooserCompat;
            }
            intentCreateChooserCompat.putParcelableArrayListExtra(ShareComponents.EXTRA_CHOOSER_DROPLIST, arrayList);
        }
        return intentCreateChooserCompat;
    }

    public static Intent createIntentForEmail(String str, String str2) {
        Intent baseIntentWithActionSend = getBaseIntentWithActionSend();
        baseIntentWithActionSend.setType(com.samsung.android.support.senl.p148nt.base.common.constants.Constants.MIME_HTML);
        baseIntentWithActionSend.setComponent(ShareComponents.getEmailComponent());
        if (!TextUtils.isEmpty(str)) {
            baseIntentWithActionSend.putExtra("android.intent.extra.SUBJECT", str);
        }
        if (TextUtils.isEmpty(str2)) {
            str2 = "";
        }
        baseIntentWithActionSend.putExtra("android.intent.extra.TEXT", str2);
        return baseIntentWithActionSend;
    }

    /* JADX WARN: Removed duplicated region for block: B:23:0x0049  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static void deleteSharedData(String str, String str2) {
        FileInputStream fileInputStream;
        byte[] bArr;
        ByteArrayOutputStream byteArrayOutputStream;
        ArrayList<Uri> arrayListDeserializeUriList = null;
        try {
            fileInputStream = new FileInputStream(str);
            try {
                bArr = new byte[1024];
                byteArrayOutputStream = new ByteArrayOutputStream();
            } finally {
            }
        } catch (Exception e) {
            Logger.m8698e(TAG, "readIntentFromFile# e = " + e);
        }
        while (true) {
            int i = fileInputStream.read(bArr);
            if (i == -1) {
                break;
            } else {
                byteArrayOutputStream.write(bArr, 0, i);
            }
            Logger.m8698e(TAG, "readIntentFromFile# e = " + e);
            if (arrayListDeserializeUriList != null) {
                for (Uri uri : arrayListDeserializeUriList) {
                    if (uri != null) {
                        String strExtractFile = FileUtils.extractFile(uri.getPath());
                        if (!TextUtils.isEmpty(strExtractFile)) {
                            FileUtils.deleteFile(str2 + "/" + strExtractFile, false);
                        }
                    }
                }
            }
            FileUtils.deleteFile(str, false);
        }
        arrayListDeserializeUriList = deserializeUriList(byteArrayOutputStream.toByteArray());
        fileInputStream.close();
        if (arrayListDeserializeUriList != null) {
        }
        FileUtils.deleteFile(str, false);
    }

    public static void deleteSharedDataInIntent(Activity activity) {
        if (activity == null || activity.getIntent() == null) {
            return;
        }
        final String stringExtra = activity.getIntent().getStringExtra(KEY_SHARED_INTENT);
        if (TextUtils.isEmpty(stringExtra)) {
            return;
        }
        final String absolutePath = ShareFileProvider.getShareDir(activity).getAbsolutePath();
        if (activity.getWindow() == null || activity.getWindow().getDecorView() == null) {
            return;
        }
        activity.getWindow().getDecorView().postDelayed(new Runnable() { // from class: com.samsung.android.support.senl.nt.base.composer.share.ShareIntentCreationHelper.1
            @Override // java.lang.Runnable
            public void run() {
                ShareIntentCreationHelper.deleteSharedData(stringExtra, absolutePath);
            }
        }, 2000L);
    }

    private static ArrayList<Uri> deserializeUriList(byte[] bArr) {
        Parcel parcelObtain = Parcel.obtain();
        parcelObtain.unmarshall(bArr, 0, bArr.length);
        parcelObtain.setDataPosition(0);
        ArrayList<Uri> arrayList = new ArrayList<>();
        parcelObtain.readList(arrayList, Uri.class.getClassLoader());
        parcelObtain.recycle();
        return arrayList;
    }

    public static List<ResolveInfo> getActionViewAppInfo(Context context, String str) {
        Intent intent = new Intent("android.intent.action.VIEW");
        intent.setType(str);
        return context.getPackageManager().queryIntentActivities(intent, 131072);
    }

    public static List<ResolveInfo> getActionViewSendInfo(Context context, String str) {
        ArrayList arrayList = new ArrayList();
        PackageManager packageManager = context.getPackageManager();
        Intent intent = new Intent();
        intent.setAction("android.intent.action.VIEW");
        intent.setType(str);
        arrayList.addAll(packageManager.queryIntentActivities(intent, 131072));
        intent.setAction("android.intent.action.SEND");
        arrayList.addAll(packageManager.queryIntentActivities(intent, 131072));
        return arrayList;
    }

    public static Intent getBaseIntentWithActionSend() {
        Intent intent = new Intent("android.intent.action.SEND");
        intent.setFlags(268435456);
        return intent;
    }

    public static Intent getBaseIntentWithActionSendMultiple() {
        Intent intent = new Intent("android.intent.action.SEND_MULTIPLE");
        intent.setFlags(268435456);
        return intent;
    }

    public static String getPathAfterCreateSharedDataInIntent(Activity activity, Intent intent) {
        String str = null;
        if (intent == null) {
            return null;
        }
        try {
            ArrayList parcelableArrayListExtra = intent.getParcelableArrayListExtra("android.intent.extra.STREAM");
            if (parcelableArrayListExtra == null) {
                parcelableArrayListExtra = new ArrayList();
                Uri uri = (Uri) intent.getParcelableExtra("android.intent.extra.STREAM");
                if (uri != null) {
                    parcelableArrayListExtra.add(uri);
                }
            }
            if (!parcelableArrayListExtra.isEmpty()) {
                str = ShareFileProvider.getShareDir(activity).getAbsolutePath() + "/" + (System.currentTimeMillis() + ".dat");
                try {
                    FileOutputStream fileOutputStream = new FileOutputStream(str, true);
                    try {
                        fileOutputStream.write(serializeUriList(parcelableArrayListExtra));
                        activity.getIntent().putExtra(KEY_SHARED_INTENT, str);
                        fileOutputStream.close();
                    } catch (Throwable th) {
                        try {
                            fileOutputStream.close();
                        } catch (Throwable th2) {
                            th.addSuppressed(th2);
                        }
                        throw th;
                    }
                } catch (IOException e) {
                    Logger.m8698e(TAG, "saveIntentToFile: IOException " + e.getMessage());
                }
            }
        } catch (Exception e2) {
            Logger.m8697d(TAG, "saveIntentToFile# e = " + e2);
        }
        return str;
    }

    private static boolean hasShareFileProviderAuthority(Uri uri) {
        return (uri == null || uri.getAuthority() == null || !uri.getAuthority().contains(ShareFileProvider.getAUTHORITY())) ? false : true;
    }

    public static void insertInitialIntentWithMsOfficeApp(Context context, Intent intent, Uri uri, String str) {
        List<ResolveInfo> actionViewAppInfo = getActionViewAppInfo(context, str);
        if (actionViewAppInfo == null || actionViewAppInfo.isEmpty()) {
            return;
        }
        List<String> mobileOfficePackageList = ShareComponents.getMobileOfficePackageList();
        ArrayList arrayList = new ArrayList(3);
        Iterator<ResolveInfo> it = actionViewAppInfo.iterator();
        while (it.hasNext()) {
            String str2 = it.next().activityInfo.packageName;
            if (mobileOfficePackageList.contains(str2.toLowerCase())) {
                Intent intent2 = new Intent("android.intent.action.VIEW");
                intent2.setPackage(str2);
                intent2.setDataAndType(uri, str);
                intent2.putExtra("android.intent.extra.STREAM", uri);
                intent2.setFlags(268435456);
                intent2.addFlags(1);
                arrayList.add(intent2);
            } else {
                Logger.m8697d(TAG, "insertInitialIntentWithMsOfficeApp: pkg = ".concat(str2));
            }
        }
        if (arrayList.isEmpty()) {
            return;
        }
        Intent[] intentArr = new Intent[arrayList.size()];
        arrayList.toArray(intentArr);
        intent.putExtra("android.intent.extra.INITIAL_INTENTS", intentArr);
    }

    private static boolean needToAddChinaDropShareComponent(Intent intent) {
        ArrayList parcelableArrayListExtra;
        if ("android.intent.action.SEND".equals(intent.getAction())) {
            if (hasShareFileProviderAuthority((Uri) intent.getParcelableExtra("android.intent.extra.STREAM")) && BaseShareUtil.isNotSupportedFileProviderForChina()) {
                return true;
            }
        } else {
            if (!"android.intent.action.SEND_MULTIPLE".equals(intent.getAction()) || (parcelableArrayListExtra = intent.getParcelableArrayListExtra("android.intent.extra.STREAM")) == null) {
                return false;
            }
            Iterator it = parcelableArrayListExtra.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                if (hasShareFileProviderAuthority((Uri) it.next())) {
                    if (BaseShareUtil.isNotSupportedFileProviderForChina()) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    private static byte[] serializeUriList(ArrayList<Uri> arrayList) {
        Parcel parcelObtain = Parcel.obtain();
        parcelObtain.writeList(arrayList);
        byte[] bArrMarshall = parcelObtain.marshall();
        parcelObtain.recycle();
        return bArrMarshall;
    }
}
