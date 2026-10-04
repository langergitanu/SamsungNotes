package com.samsung.android.sdk.smp.display;

import android.annotation.TargetApi;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import com.samsung.android.sdk.smp.C7794R;
import com.samsung.android.sdk.smp.SmpReceiver;
import com.samsung.android.sdk.smp.common.constants.Constants;
import com.samsung.android.sdk.smp.common.constants.MarketingConstants;
import com.samsung.android.sdk.smp.common.exception.InternalException;
import com.samsung.android.sdk.smp.common.preference.PrefManager;
import com.samsung.android.sdk.smp.common.util.PackageManagerUtil;
import com.samsung.android.sdk.smp.common.util.SmpLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Set;
import p001A.AbstractC0000a;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes7.dex */
public abstract class DisplayManager {
    private static final String TAG = "DisplayManager";

    @TargetApi(26)
    private void createDefaultNotificationChannel(Context context, int i, String str, int i2, boolean z) throws InternalException.IllegalPushChannelException {
        NotificationManager notificationManager = (NotificationManager) context.getSystemService("notification");
        if (notificationManager == null) {
            SmpLog.m6494e(TAG, "create default channel error. notification manager null");
            throw new InternalException.IllegalPushChannelException();
        }
        SmpLog.m6492d(TAG, "create default channel - " + str);
        NotificationChannel notificationChannel = new NotificationChannel(str, context.getResources().getString(i2), 4);
        notificationChannel.setSound(null, null);
        notificationChannel.enableVibration(z);
        notificationChannel.enableLights(false);
        notificationManager.createNotificationChannel(notificationChannel);
        PrefManager.getInstance(context).setNotiChannelId(i, str);
    }

    @TargetApi(26)
    private String createDefaultNotificationChannelByType(Context context, int i) throws InternalException.IllegalPushChannelException {
        if (i == 1) {
            createDefaultNotificationChannel(context, i, Constants.DEFAULT_NOTICE_CHANNELID, C7794R.string.chan_ntc, true);
            return Constants.DEFAULT_NOTICE_CHANNELID;
        }
        if (i != 2) {
            String notiChannelId = PrefManager.getInstance(context).getNotiChannelId(2);
            return TextUtils.isEmpty(notiChannelId) ? createDefaultNotificationChannelByType(context, 2) : notiChannelId;
        }
        createDefaultNotificationChannel(context, i, Constants.DEFAULT_MARKETING_CHANNELID, C7794R.string.chan_mkt, false);
        return Constants.DEFAULT_MARKETING_CHANNELID;
    }

    public static Bitmap decodeFile(String str) {
        if (str == null) {
            throw new InternalException.ImageDecodingException("empty image url");
        }
        Bitmap bitmapDecodeFile = BitmapFactory.decodeFile(Uri.parse(str).getPath());
        if (bitmapDecodeFile != null) {
            return bitmapDecodeFile;
        }
        throw new InternalException.ImageDecodingException(str.concat(" can't be decoded"));
    }

    public static ArrayList<Bitmap> decodeFileList(ArrayList<String> arrayList) {
        ArrayList<Bitmap> arrayList2 = new ArrayList<>();
        Iterator<String> it = arrayList.iterator();
        while (it.hasNext()) {
            arrayList2.add(decodeFile(it.next()));
        }
        return arrayList2;
    }

    public static int getApplicationIcon(Context context) {
        try {
            int i = PackageManagerUtil.getApplicationInfo(context, context.getPackageName(), 0).icon;
            if (i >= 0) {
                return i;
            }
            throw new InternalException.AppIconNotfoundException();
        } catch (Exception e) {
            SmpLog.m6494e(TAG, e.toString());
            throw new InternalException.AppIconNotfoundException();
        }
    }

    public static Intent getClickIntent(Context context, String str, boolean z, ArrayList<Bundle> arrayList) {
        Intent intent = new Intent(context, (Class<?>) SmpReceiver.class);
        intent.setAction(Constants.ACTION_MARKETING_CLICK);
        intent.putExtra("mid", str);
        intent.putExtra("p_link", z);
        for (int i = 0; i < arrayList.size(); i++) {
            intent.putExtra(AbstractC0000a.m11h(i, "click_link"), arrayList.get(i));
        }
        return intent;
    }

    public static Intent getDeleteIntent(Context context, String str, String str2, int i) {
        Intent intent = new Intent(context, (Class<?>) SmpReceiver.class);
        intent.setAction(Constants.ACTION_MARKETING_CLEAR);
        intent.putExtra("mid", str);
        intent.putExtra(Constants.EXTRA_KEY_DISPLAYID, i);
        intent.putExtra(MarketingConstants.MARKETING_TYPE, str2);
        return intent;
    }

    public static DisplayManager getDisplayManager(String str) {
        if ("1".equals(str)) {
            return new NotificationDisplayManager();
        }
        if ("2".equals(str)) {
            return new PopupDisplayManager();
        }
        return null;
    }

    public static ArrayList<Bundle> getLinkList(Bundle bundle, String str) {
        ArrayList<Bundle> arrayList = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            Bundle bundle2 = bundle.getBundle(str + i);
            if (bundle2 == null) {
                break;
            }
            arrayList.add(bundle2);
        }
        return arrayList;
    }

    public abstract boolean clear(Context context, int i);

    public abstract void display(Context context, Bundle bundle, DisplayResultHandler displayResultHandler);

    @TargetApi(26)
    public String getNotificationChannelId(Context context, int i) throws InternalException.IllegalPushChannelException {
        PrefManager prefManager = PrefManager.getInstance(context);
        NotificationManager notificationManager = (NotificationManager) context.getSystemService("notification");
        if (notificationManager == null) {
            SmpLog.m6494e(TAG, "cannot show noti : notification manager null");
            throw new InternalException.IllegalPushChannelException();
        }
        String notiChannelId = prefManager.getNotiChannelId(i);
        if (TextUtils.isEmpty(notiChannelId)) {
            notiChannelId = createDefaultNotificationChannelByType(context, i);
        }
        if (notificationManager.getNotificationChannel(notiChannelId) != null) {
            return notiChannelId;
        }
        SmpLog.m6494e(TAG, "cannot show noti : channel is not created");
        throw new InternalException.IllegalPushChannelException();
    }

    public void printBundle(Bundle bundle) {
        if (bundle != null) {
            Set<String> setKeySet = bundle.keySet();
            StringBuilder sb = new StringBuilder("[");
            for (String str : setKeySet) {
                sb.append(str);
                sb.append(":");
                sb.append(bundle.get(str));
                sb.append(",");
            }
            sb.append("]");
            SmpLog.m6498i(TAG, "data:" + sb.toString());
        }
    }
}
