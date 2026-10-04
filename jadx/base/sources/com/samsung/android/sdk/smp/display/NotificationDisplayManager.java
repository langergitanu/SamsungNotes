package com.samsung.android.sdk.smp.display;

import android.annotation.TargetApi;
import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.Icon;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import android.widget.RemoteViews;
import com.samsung.android.sdk.smp.C7794R;
import com.samsung.android.sdk.smp.SmpConfiguration;
import com.samsung.android.sdk.smp.SmpException;
import com.samsung.android.sdk.smp.SmpReceiver;
import com.samsung.android.sdk.smp.common.constants.Constants;
import com.samsung.android.sdk.smp.common.constants.FeedbackDetailConstants;
import com.samsung.android.sdk.smp.common.constants.FeedbackEvent;
import com.samsung.android.sdk.smp.common.constants.MarketingConstants;
import com.samsung.android.sdk.smp.common.exception.InternalException;
import com.samsung.android.sdk.smp.common.preference.PrefManager;
import com.samsung.android.sdk.smp.common.util.BroadcastUtil;
import com.samsung.android.sdk.smp.common.util.DeviceInfoUtil;
import com.samsung.android.sdk.smp.common.util.PackageManagerUtil;
import com.samsung.android.sdk.smp.common.util.SmpLog;
import com.samsung.android.sdk.smp.marketing.LandingIntentGenerator;
import com.samsung.android.sdk.smp.marketing.MarketingLink;
import com.samsung.android.sdk.smp.marketing.NotificationButtonNumber;
import java.util.ArrayList;
import java.util.Iterator;
import p001A.AbstractC0000a;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes7.dex */
public class NotificationDisplayManager extends DisplayManager {
    private static final String TAG = "NotificationDisplayManager";
    private static boolean mIsClickIntentLaunchable;

    private Notification buildNotificationWithBuilder(Context context, int i, int i2, int i4, String str, String str2, Bundle bundle, int i5) throws InternalException.InvalidArgumentException {
        Notification.Builder ticker = getNotificationBuilder(context, bundle).setOngoing(false).setTicker(str2);
        if (TextUtils.isEmpty(str)) {
            ticker.setSmallIcon(i4);
        } else {
            ticker.setSmallIcon(Icon.createWithBitmap(DisplayManager.decodeFile(str)));
        }
        if (i == 1) {
            setBasicBuilder(context, ticker, bundle);
        }
        if (i2 == 2) {
            setBigPictureBuilder(context, ticker, bundle);
        } else if (i2 == 4) {
            setBigTextBuilder(context, ticker, bundle);
        }
        String notificationGroupKey = getNotificationGroupKey(context);
        if (!TextUtils.isEmpty(notificationGroupKey)) {
            ticker.setGroup(notificationGroupKey);
        }
        setNotificationButtonBuilder(ticker, bundle, i5, context);
        return getCustomContentViewNotification(ticker, getContentView(context, i, bundle), getBigContentView(context, i2, bundle));
    }

    private static Bitmap drawableToBitmap(Drawable drawable) {
        if (drawable instanceof BitmapDrawable) {
            return ((BitmapDrawable) drawable).getBitmap();
        }
        Bitmap bitmapCreateBitmap = Bitmap.createBitmap(drawable.getIntrinsicWidth(), drawable.getIntrinsicHeight(), Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(bitmapCreateBitmap);
        drawable.setBounds(0, 0, canvas.getWidth(), canvas.getHeight());
        drawable.draw(canvas);
        return bitmapCreateBitmap;
    }

    private static Bitmap getApplicationIconWithBitmap(Context context) throws InternalException.AppIconNotfoundException {
        try {
            return drawableToBitmap(PackageManagerUtil.getApplicationInfo(context, context.getPackageName(), 0).loadIcon(context.getPackageManager()));
        } catch (Exception e) {
            SmpLog.m6494e(TAG, e.toString());
            throw new InternalException.AppIconNotfoundException();
        }
    }

    private int getBannerOrFoldedViewFlipperLayoutId(Context context) throws InternalException.NotSupportedTypeException {
        String contentsType = DeviceInfoUtil.getContentsType(context);
        if (!"type3".equals(contentsType)) {
            return "type2".equals(contentsType) ? C7794R.layout.noti_banner_or_folded_viewflipper_for_tablet : C7794R.layout.noti_banner_or_folded_viewflipper;
        }
        SmpLog.m6494e(TAG, "fail to get banner or viewflipper layout id. invalid contents type : " + contentsType);
        throw new InternalException.NotSupportedTypeException();
    }

    private RemoteViews getBannerRemoteView(Context context, Bundle bundle) throws InternalException.InvalidArgumentException {
        String string = bundle.getString("banner");
        if (string == null) {
            SmpLog.m6494e(TAG, "fail to make notification. banner path null");
            throw new InternalException.InvalidArgumentException();
        }
        Bitmap bitmapDecodeFile = DisplayManager.decodeFile(string);
        RemoteViews remoteViews = new RemoteViews(context.getPackageName(), getBannerOrFoldedViewFlipperLayoutId(context));
        remoteViews.setImageViewBitmap(C7794R.id.banner_icon, bitmapDecodeFile);
        return remoteViews;
    }

    private RemoteViews getBigContentView(Context context, int i, Bundle bundle) {
        if (i == 5) {
            return getViewFlipperRemoteView(context, bundle, true);
        }
        return null;
    }

    private NotificationButtonNumber getButtonNum(int i) {
        return i != 0 ? i != 1 ? i != 2 ? NotificationButtonNumber.NONE : NotificationButtonNumber.THIRD : NotificationButtonNumber.SECOND : NotificationButtonNumber.FIRST;
    }

    private PendingIntent getClickPendingIntent(Context context, String str, int i, boolean z, ArrayList<Bundle> arrayList) {
        if (DeviceInfoUtil.getTargetSdkVersion(context) >= 31 && Build.VERSION.SDK_INT >= 31) {
            return getClickPendingIntentSOrOver(context, str, NotificationButtonNumber.NONE, i, arrayList, false, z);
        }
        Intent clickIntent = DisplayManager.getClickIntent(context, str, z, arrayList);
        mIsClickIntentLaunchable = true;
        return PendingIntent.getBroadcast(context, i, clickIntent, 201326592);
    }

    private RemoteViews getContentView(Context context, int i, Bundle bundle) {
        if (i == 2) {
            return getBannerRemoteView(context, bundle);
        }
        if (i != 3) {
            return null;
        }
        return getViewFlipperRemoteView(context, bundle, false);
    }

    private Notification getCustomContentViewNotification(Notification.Builder builder, RemoteViews remoteViews, RemoteViews remoteViews2) {
        if (remoteViews != null) {
            builder.setCustomContentView(remoteViews);
        }
        if (remoteViews2 != null) {
            builder.setCustomBigContentView(remoteViews2);
        }
        return builder.build();
    }

    private PendingIntent getDeletePendingIntent(Context context, String str, int i) {
        return PendingIntent.getBroadcast(context, i, DisplayManager.getDeleteIntent(context, str, "1", i), 201326592);
    }

    private int getExpandedViewFlipperLayoutId(Context context) throws InternalException.NotSupportedTypeException {
        String contentsType = DeviceInfoUtil.getContentsType(context);
        if (!"type3".equals(contentsType)) {
            return C7794R.layout.expanded_viewflipper;
        }
        SmpLog.m6494e(TAG, "fail to get expanded viewflipper layout id. invalid contents type : " + contentsType);
        throw new InternalException.NotSupportedTypeException();
    }

    private Notification getNotification(Context context, Bundle bundle, int i) throws InternalException.InvalidArgumentException {
        SmpException.IllegalStateException illegalStateException;
        int notifSmallIcon;
        int i2 = bundle.getInt(MarketingConstants.DisplayConst.NOTIF_F_TYPE, -1);
        int i4 = bundle.getInt(MarketingConstants.DisplayConst.NOTIF_E_TYPE, -1);
        if (!MarketingConstants.NotificationConst.isSupportType(i2, i4)) {
            SmpLog.m6494e(TAG, "fail to get notification. not supported type");
            throw new InternalException.InvalidArgumentException();
        }
        String string = bundle.getString("mid");
        String string2 = bundle.getString("ticker");
        try {
            if (SmpConfiguration.getNotifSmallIcon() > 0) {
                try {
                    notifSmallIcon = SmpConfiguration.getNotifSmallIcon();
                } catch (SmpException.IllegalStateException e) {
                    illegalStateException = e;
                    SmpLog.m6494e(TAG, "fail to get notification. IllegalStateException. " + illegalStateException.toString());
                    throw new InternalException.InvalidArgumentException();
                }
            } else {
                notifSmallIcon = DisplayManager.getApplicationIcon(context);
            }
            int i5 = notifSmallIcon;
            String string3 = bundle.getString(MarketingConstants.DisplayConst.NOTIF_SMALL_ICON_PATH);
            ArrayList<Bundle> linkList = DisplayManager.getLinkList(bundle, "click_link");
            if (TextUtils.isEmpty(string) || TextUtils.isEmpty(string2) || linkList.size() == 0) {
                SmpLog.m6494e(TAG, "fail to get notification. invalid data");
                throw new InternalException.InvalidArgumentException();
            }
            boolean z = bundle.getBoolean("p_link", false);
            Notification notificationBuildNotificationWithBuilder = buildNotificationWithBuilder(context, i2, i4, i5, string3, string2, bundle, i);
            notificationBuildNotificationWithBuilder.contentIntent = getClickPendingIntent(context, string, i, z, linkList);
            notificationBuildNotificationWithBuilder.deleteIntent = getDeletePendingIntent(context, string, i);
            return notificationBuildNotificationWithBuilder;
        } catch (SmpException.IllegalStateException e2) {
            illegalStateException = e2;
        }
    }

    private Notification.Builder getNotificationBuilder(Context context, Bundle bundle) {
        return new Notification.Builder(context, getNotificationChannelId(context, bundle.getInt(MarketingConstants.DisplayConst.CHANNEL_TYPE, -1)));
    }

    private Intent getNotificationButtonClickIntentUnderS(String str, int i, ArrayList<Bundle> arrayList, int i2, Context context, boolean z) {
        String str2;
        Intent intent = new Intent(context, (Class<?>) SmpReceiver.class);
        FeedbackEvent feedbackEvent = FeedbackEvent.CLICKED;
        if (i == 0) {
            feedbackEvent = FeedbackEvent.CLICKED_BUTTON_1;
            str2 = Constants.ACTION_MARKETING_BUTTON_1_CLICK;
        } else if (i == 1) {
            feedbackEvent = FeedbackEvent.CLICKED_BUTTON_2;
            str2 = Constants.ACTION_MARKETING_BUTTON_2_CLICK;
        } else if (i != 2) {
            str2 = null;
        } else {
            feedbackEvent = FeedbackEvent.CLICKED_BUTTON_3;
            str2 = Constants.ACTION_MARKETING_BUTTON_3_CLICK;
        }
        intent.setAction(str2);
        intent.putExtra("mid", str);
        intent.putExtra("p_link", z);
        intent.putExtra(Constants.EXTRA_KEY_FEEDBACK_EVENT, feedbackEvent.value());
        intent.putExtra(MarketingConstants.DisplayConst.DISPLAYID, i2);
        for (int i4 = 0; i4 < arrayList.size(); i4++) {
            intent.putExtra(AbstractC0000a.m11h(i4, "click_link"), arrayList.get(i4));
        }
        return intent;
    }

    private PendingIntent getNotificationButtonClickPendingIntent(String str, int i, ArrayList<Bundle> arrayList, int i2, Context context, boolean z) {
        return (DeviceInfoUtil.getTargetSdkVersion(context) < 31 || Build.VERSION.SDK_INT < 31) ? PendingIntent.getBroadcast(context, i2, getNotificationButtonClickIntentUnderS(str, i, arrayList, i2, context, z), 201326592) : getClickPendingIntentSOrOver(context, str, getButtonNum(i), i2, arrayList, true, z);
    }

    private static ArrayList<Bundle> getNotificationButtonLinkList(Bundle bundle, String str, int i) {
        ArrayList<Bundle> arrayList = new ArrayList<>();
        Bundle bundle2 = bundle.getBundle(str + i);
        if (bundle2 != null) {
            for (int i2 = 0; i2 < 5; i2++) {
                Bundle bundle3 = bundle2.getBundle("click_link" + i2);
                if (bundle3 == null) {
                    break;
                }
                arrayList.add(bundle3);
            }
        }
        return arrayList;
    }

    private static ArrayList<Bundle> getNotificationButtonList(Bundle bundle, String str) {
        ArrayList<Bundle> arrayList = new ArrayList<>();
        for (int i = 0; i < 3; i++) {
            Bundle bundle2 = bundle.getBundle(str + i);
            if (bundle2 == null) {
                break;
            }
            arrayList.add(bundle2);
        }
        return arrayList;
    }

    private String getNotificationGroupKey(Context context) {
        return PrefManager.getInstance(context).getNotiGroup();
    }

    private int getViewFlipperLayoutId(Context context, boolean z) {
        return z ? getExpandedViewFlipperLayoutId(context) : getBannerOrFoldedViewFlipperLayoutId(context);
    }

    private RemoteViews getViewFlipperRemoteView(Context context, Bundle bundle, boolean z) throws InternalException.ImageDecodingException, InternalException.InvalidArgumentException {
        ArrayList<String> stringArrayList = bundle.getStringArrayList(z ? MarketingConstants.DisplayConst.NOTIF_E_FLIPPER_PATH : MarketingConstants.DisplayConst.NOTIF_F_FLIPPER_PATH);
        if (stringArrayList == null) {
            SmpLog.m6494e(TAG, "fail to make notification. flipper paths null");
            throw new InternalException.InvalidArgumentException();
        }
        ArrayList<Bitmap> arrayListDecodeFileList = DisplayManager.decodeFileList(stringArrayList);
        int i = z ? bundle.getInt(MarketingConstants.DisplayConst.NOTIF_E_FLIPPER_PERIOD) : bundle.getInt(MarketingConstants.DisplayConst.NOTIF_F_FLIPPER_PERIOD);
        if (i <= 0 || arrayListDecodeFileList.size() <= 0) {
            SmpLog.m6494e(TAG, "fail to make notification. invalid flipper period, images");
            throw new InternalException.ImageDecodingException();
        }
        int viewFlipperResId = getViewFlipperResId(z ? bundle.getInt(MarketingConstants.DisplayConst.NOTIF_E_FLIPPER_ANIMATION, 0) : bundle.getInt(MarketingConstants.DisplayConst.NOTIF_F_FLIPPER_ANIMATION, 0));
        RemoteViews remoteViews = new RemoteViews(context.getPackageName(), C7794R.layout.noti_viewflipper);
        remoteViews.setViewVisibility(viewFlipperResId, 0);
        remoteViews.setInt(viewFlipperResId, "setFlipInterval", i);
        Iterator<Bitmap> it = arrayListDecodeFileList.iterator();
        while (it.hasNext()) {
            RemoteViews remoteViews2 = new RemoteViews(context.getPackageName(), getViewFlipperLayoutId(context, z));
            if (z) {
                remoteViews2.setImageViewBitmap(C7794R.id.flipper_expanded_icon, it.next());
            } else {
                remoteViews2.setImageViewBitmap(C7794R.id.banner_icon, it.next());
            }
            remoteViews.addView(viewFlipperResId, remoteViews2);
        }
        return remoteViews;
    }

    private int getViewFlipperResId(int i) {
        return i != 1 ? i != 2 ? i != 3 ? C7794R.id.viewflipper : C7794R.id.viewflipper_anim3 : C7794R.id.viewflipper_anim2 : C7794R.id.viewflipper_anim1;
    }

    private boolean isUndeletableNotification(Context context, Bundle bundle) {
        return bundle.getBoolean("undeletable", false) && DeviceInfoUtil.isSamsungPushService(context) && bundle.getInt(MarketingConstants.DisplayConst.CHANNEL_TYPE) == 1;
    }

    private void setBasicBuilder(Context context, Notification.Builder builder, Bundle bundle) throws InternalException.InvalidArgumentException {
        String string = bundle.getString(MarketingConstants.DisplayConst.NOTIF_CONTENT_TITLE);
        String string2 = bundle.getString(MarketingConstants.DisplayConst.NOTIF_CONTENT_TEXT);
        if (string == null || string2 == null) {
            SmpLog.m6494e(TAG, "fail to build basic notification. invalid params");
            throw new InternalException.InvalidArgumentException();
        }
        String string3 = bundle.getString(MarketingConstants.DisplayConst.NOTIF_LARGE_ICON_PATH);
        Bitmap bitmapDecodeFile = !TextUtils.isEmpty(string3) ? DisplayManager.decodeFile(string3) : getApplicationIconWithBitmap(context);
        if (bundle.getBoolean(MarketingConstants.DisplayConst.NOTIF_ICON)) {
            builder.setContentTitle(string).setContentText(string2).setLargeIcon(bitmapDecodeFile);
        } else {
            builder.setContentTitle(string).setContentText(string2);
        }
    }

    private void setBigPictureBuilder(Context context, Notification.Builder builder, Bundle bundle) throws InternalException.InvalidArgumentException {
        setBasicBuilder(context, builder, bundle);
        String string = bundle.getString(MarketingConstants.DisplayConst.NOTIF_CONTENT_TEXT);
        String string2 = bundle.getString(MarketingConstants.DisplayConst.NOTIF_BIG_PICTURE_PATH);
        if (string == null || TextUtils.isEmpty(string2)) {
            SmpLog.m6494e(TAG, "fail to build bigpicture notification. invalid map");
            throw new InternalException.InvalidArgumentException();
        }
        builder.setStyle(new Notification.BigPictureStyle().bigPicture(DisplayManager.decodeFile(string2)).setSummaryText(string));
        String string3 = bundle.getString(MarketingConstants.DisplayConst.NOTIF_SUB_CONTENT_TEXT);
        if (string3 != null) {
            builder.setContentText(string3);
        }
    }

    private void setBigTextBuilder(Context context, Notification.Builder builder, Bundle bundle) throws InternalException.InvalidArgumentException {
        setBasicBuilder(context, builder, bundle);
        String string = bundle.getString(MarketingConstants.DisplayConst.NOTIF_CONTENT_TEXT);
        if (string == null) {
            SmpLog.m6494e(TAG, "fail to build bigtext notification. invalid map");
            throw new InternalException.InvalidArgumentException();
        }
        builder.setStyle(new Notification.BigTextStyle().bigText(string));
        String string2 = bundle.getString(MarketingConstants.DisplayConst.NOTIF_SUB_CONTENT_TEXT);
        if (string2 != null) {
            builder.setContentText(string2);
        }
    }

    private void setNotificationButtonBuilder(Notification.Builder builder, Bundle bundle, int i, Context context) {
        String string = bundle.getString("mid");
        ArrayList<Bundle> notificationButtonList = getNotificationButtonList(bundle, MarketingConstants.DisplayConst.NOTIF_BUTTON);
        int i2 = 0;
        boolean z = bundle.getBoolean("p_link", false);
        while (i2 < notificationButtonList.size()) {
            int i4 = i;
            Context context2 = context;
            builder.addAction(new Notification.Action.Builder((Icon) null, notificationButtonList.get(i2).getString("title"), getNotificationButtonClickPendingIntent(string, i2, getNotificationButtonLinkList(bundle, MarketingConstants.DisplayConst.NOTIF_BUTTON, i2), i4, context2, z)).build());
            i2++;
            i = i4;
            context = context2;
        }
    }

    private void setNotificationConfigs(Context context, Bundle bundle, Notification notification) {
        notification.when = 0L;
        if (isUndeletableNotification(context, bundle)) {
            notification.flags = 2;
        } else {
            notification.flags = 16;
        }
        int notiColor = PrefManager.getInstance(context).getNotiColor();
        if (notiColor != 0) {
            notification.color = notiColor;
        }
        if (notification.getChannelId() == null) {
            notification.priority = 2;
            if (context != null) {
                PrefManager prefManager = PrefManager.getInstance(context);
                if (prefManager.getVibrateEnabled()) {
                    long[] vibratePattern = prefManager.getVibratePattern();
                    if (vibratePattern == null) {
                        notification.defaults |= 2;
                    } else {
                        notification.vibrate = vibratePattern;
                    }
                }
                if (prefManager.getSoundEnabled()) {
                    String soundUriString = prefManager.getSoundUriString();
                    if (TextUtils.isEmpty(soundUriString)) {
                        notification.defaults |= 1;
                    } else {
                        notification.sound = Uri.parse(soundUriString);
                    }
                }
            }
        }
    }

    @Override // com.samsung.android.sdk.smp.display.DisplayManager
    public boolean clear(Context context, int i) {
        NotificationManager notificationManager;
        SmpLog.m6498i(TAG, "clear notification in the noti bar. displayId : " + i);
        if (context == null || i <= 0 || (notificationManager = (NotificationManager) context.getSystemService("notification")) == null) {
            return false;
        }
        notificationManager.cancel(i);
        return true;
    }

    @Override // com.samsung.android.sdk.smp.display.DisplayManager
    public void display(Context context, Bundle bundle, DisplayResultHandler displayResultHandler) {
        Context context2;
        InternalException.WrongMarketingDataException wrongMarketingDataException;
        Throwable th;
        String str;
        if (bundle == null) {
            SmpLog.m6494e(TAG, "fail to display. data null");
            displayResultHandler.onFail(context, FeedbackEvent.CLIENT_INTERNAL_ERROR, null);
            return;
        }
        printBundle(bundle);
        int i = bundle.getInt(MarketingConstants.DisplayConst.DISPLAYID, -1);
        if (i < 0) {
            SmpLog.m6494e(TAG, "fail to display. invalid displayid");
            displayResultHandler.onFail(context, FeedbackEvent.CLIENT_INTERNAL_ERROR, null);
            return;
        }
        try {
            try {
                Notification notification = getNotification(context, bundle, i);
                setNotificationConfigs(context, bundle, notification);
                ((NotificationManager) context.getSystemService("notification")).notify(i, notification);
                displayResultHandler.onSuccess(context, mIsClickIntentLaunchable ? null : FeedbackDetailConstants.LANDING_PAGE_MAY_NOT_LAUNCHABLE, true);
                String string = bundle.getString(MarketingConstants.DisplayConst.NOTIF_CONTENT_TITLE);
                if (TextUtils.isEmpty(string)) {
                    try {
                        string = bundle.getString("ticker");
                    } catch (InternalException.ImageDecodingException e) {
                        e = e;
                        th = e;
                        context2 = context;
                        SmpLog.m6494e(TAG, th.toString());
                        displayResultHandler.onFail(context2, FeedbackEvent.CLIENT_INTERNAL_ERROR, FeedbackDetailConstants.IMAGE_DECODE_FAIL);
                    } catch (InternalException.WrongMarketingDataException e2) {
                        wrongMarketingDataException = e2;
                        context2 = context;
                        displayResultHandler.onFail(context2, FeedbackEvent.CONTENTS_FILE_ERROR, wrongMarketingDataException.getMessage());
                    } catch (OutOfMemoryError e3) {
                        e = e3;
                        th = e;
                        context2 = context;
                        SmpLog.m6494e(TAG, th.toString());
                        displayResultHandler.onFail(context2, FeedbackEvent.CLIENT_INTERNAL_ERROR, FeedbackDetailConstants.IMAGE_DECODE_FAIL);
                    }
                }
                str = string;
                context2 = context;
            } catch (InternalException.ImageDecodingException e5) {
                e = e5;
                context2 = context;
                th = e;
                SmpLog.m6494e(TAG, th.toString());
                displayResultHandler.onFail(context2, FeedbackEvent.CLIENT_INTERNAL_ERROR, FeedbackDetailConstants.IMAGE_DECODE_FAIL);
            } catch (InternalException.WrongMarketingDataException e6) {
                e = e6;
                context2 = context;
            } catch (OutOfMemoryError e7) {
                e = e7;
                context2 = context;
                th = e;
                SmpLog.m6494e(TAG, th.toString());
                displayResultHandler.onFail(context2, FeedbackEvent.CLIENT_INTERNAL_ERROR, FeedbackDetailConstants.IMAGE_DECODE_FAIL);
            }
        } catch (InternalException.AppIconNotfoundException unused) {
            context2 = context;
        } catch (InternalException.IllegalPushChannelException unused2) {
            context2 = context;
        } catch (InternalException.NotSupportedTypeException unused3) {
            context2 = context;
        } catch (Exception unused4) {
            context2 = context;
        }
        try {
            BroadcastUtil.broadcastMarketingDisplay(context2, "display", "noti", displayResultHandler.getMid(), displayResultHandler.isFirstDisplay(), str, bundle.getString(MarketingConstants.DisplayConst.NOTIF_CONTENT_TEXT, null), bundle.getStringArray(MarketingConstants.DisplayConst.CLICK_LINK_URIS));
        } catch (InternalException.AppIconNotfoundException unused5) {
            displayResultHandler.onFail(context2, FeedbackEvent.CLIENT_INTERNAL_ERROR, FeedbackDetailConstants.APP_ICON_NOT_FOUND);
        } catch (InternalException.IllegalPushChannelException unused6) {
            displayResultHandler.onFail(context2, FeedbackEvent.PUSH_CHANNEL_NOT_CREATED, null);
        } catch (InternalException.ImageDecodingException e8) {
            e = e8;
            th = e;
            SmpLog.m6494e(TAG, th.toString());
            displayResultHandler.onFail(context2, FeedbackEvent.CLIENT_INTERNAL_ERROR, FeedbackDetailConstants.IMAGE_DECODE_FAIL);
        } catch (InternalException.NotSupportedTypeException unused7) {
            displayResultHandler.onFail(context2, FeedbackEvent.UNSUPPORTED_TYPE, null);
        } catch (InternalException.WrongMarketingDataException e9) {
            e = e9;
            wrongMarketingDataException = e;
            displayResultHandler.onFail(context2, FeedbackEvent.CONTENTS_FILE_ERROR, wrongMarketingDataException.getMessage());
        } catch (Exception unused8) {
            displayResultHandler.onFail(context2, FeedbackEvent.CLIENT_INTERNAL_ERROR, null);
        } catch (OutOfMemoryError e10) {
            e = e10;
            th = e;
            SmpLog.m6494e(TAG, th.toString());
            displayResultHandler.onFail(context2, FeedbackEvent.CLIENT_INTERNAL_ERROR, FeedbackDetailConstants.IMAGE_DECODE_FAIL);
        }
    }

    @TargetApi(31)
    public PendingIntent getClickPendingIntentSOrOver(Context context, String str, NotificationButtonNumber notificationButtonNumber, int i, ArrayList<Bundle> arrayList, boolean z, boolean z2) throws InternalException.WrongMarketingDataException {
        String str2 = TAG;
        StringBuilder sb = new StringBuilder("get click pending intent. isButton:");
        boolean z3 = z;
        sb.append(z3);
        sb.append(", isPLink:");
        boolean z4 = z2;
        sb.append(z4);
        SmpLog.m6499i(str2, str, sb.toString());
        LandingIntentGenerator landingIntentGenerator = new LandingIntentGenerator(LandingIntentGenerator.RunType.RUN_VIA_NOTIFICATION);
        Iterator<Bundle> it = arrayList.iterator();
        MarketingLink marketingLink = null;
        while (it.hasNext()) {
            MarketingLink marketingLink2 = MarketingLink.parse(it.next());
            if (MarketingConstants.LINK_TYPE_IGNORE.equals(marketingLink2.getType())) {
                SmpLog.m6499i(TAG, str, "click intent : switch to delete intent. link type:" + marketingLink2.getType());
                return getDeletePendingIntent(context, str, i);
            }
            Intent landingIntentByLinkType = landingIntentGenerator.getLandingIntentByLinkType(context, str, notificationButtonNumber, marketingLink2, true, z3, z4);
            if (landingIntentByLinkType != null) {
                mIsClickIntentLaunchable = true;
                return PendingIntent.getActivity(context, i, landingIntentByLinkType, 201326592);
            }
            if (marketingLink == null) {
                marketingLink = marketingLink2;
            }
            z3 = z;
            z4 = z2;
        }
        Intent landingIntentByLinkType2 = landingIntentGenerator.getLandingIntentByLinkType(context, str, notificationButtonNumber, marketingLink, false, z, z2);
        if (landingIntentByLinkType2 == null) {
            SmpLog.m6495e(TAG, str, "fail to get click intent. nothing supported");
            throw new InternalException.WrongMarketingDataException(FeedbackDetailConstants.LANDING_PAGE_ERROR);
        }
        SmpLog.m6502w(TAG, str, "landing page may not be launchable");
        mIsClickIntentLaunchable = false;
        return PendingIntent.getActivity(context, i, landingIntentByLinkType2, 201326592);
    }
}
