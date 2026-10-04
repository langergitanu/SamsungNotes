package com.samsung.android.support.senl.p148nt.composer.main.base.presenter.voice;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.Resources;
import android.database.Cursor;
import android.media.AudioManager;
import android.net.Uri;
import android.os.Build;
import android.os.PowerManager;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.samsung.android.support.senl.p145cm.base.framework.feature.FloatingFeature;
import com.samsung.android.support.senl.p148nt.app.addons.AbstractC8014b;
import com.samsung.android.support.senl.p148nt.composer.C9086R;
import com.samsung.android.support.senl.p148nt.composer.main.base.util.Logger;
import com.samsung.android.support.senl.p148nt.data.common.constants.SearchConstants;
import com.samsung.android.support.senl.p148nt.data.common.utils.VoiceTimeDataUtils;
import java.util.List;
import java.util.ListIterator;
import kotlin.Metadata;
import kotlin.collections.AbstractC12991c;
import kotlin.collections.CollectionsKt;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.text.CharsKt;
import kotlin.text.Regex;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import p001A.AbstractC0000a;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(m13885d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\r\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001:\u0001)B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0018\u0010\u000b\u001a\u00020\u00052\b\u0010\f\u001a\u0004\u0018\u00010\r2\u0006\u0010\u000e\u001a\u00020\u0005J\u001a\u0010\u000f\u001a\u00020\u00052\u0006\u0010\u0010\u001a\u00020\u00112\b\b\u0002\u0010\u0012\u001a\u00020\u0013H\u0007J\u0010\u0010\u0014\u001a\u00020\u00112\b\u0010\u0015\u001a\u0004\u0018\u00010\u0005J\u001a\u0010\u0016\u001a\u00020\u00172\b\u0010\u0018\u001a\u0004\u0018\u00010\u00192\b\u0010\u000e\u001a\u0004\u0018\u00010\u001aJ\u0010\u0010\u001b\u001a\u00020\u00132\b\u0010\u001c\u001a\u0004\u0018\u00010\u001dJ\u0010\u0010#\u001a\u00020\u00132\b\u0010\u001c\u001a\u0004\u0018\u00010\u001dJ\u0012\u0010$\u001a\u00020\u00132\b\u0010\u001c\u001a\u0004\u0018\u00010\u001dH\u0007J\u0016\u0010%\u001a\u00020\u00172\u0006\u0010&\u001a\u00020'2\u0006\u0010(\u001a\u00020\u0013R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u001e\u001a\u00020\u00058BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u001f\u0010 R\u0011\u0010!\u001a\u00020\u00138F¢\u0006\u0006\u001a\u0004\b!\u0010\"¨\u0006*"}, m13886d2 = {"Lcom/samsung/android/support/senl/nt/composer/main/base/presenter/voice/VoiceUtil;", "", "<init>", "()V", SearchConstants.TargetContents.TAG, "", "TIME_SPLIT", "RESTRICTION1_URI", "RESTRICTIONPOLICY_AUDIORECORDALLOWED_METHOD", "mIsGalaxyOn5ChinaModel", "Lcom/samsung/android/support/senl/nt/composer/main/base/presenter/voice/VoiceUtil$DeviceModel;", "createTimeDescription", "resources", "Landroid/content/res/Resources;", "time", "createTimeString", "timeInSecond", "", "includeHour", "", "changeTimeType", "timeStr", "updateTimeEms", "", "timeView", "Landroid/widget/TextView;", "", "isScreenOn", "context", "Landroid/content/Context;", "galaxyOn5ChinaModelBgColor", "getGalaxyOn5ChinaModelBgColor", "()Ljava/lang/String;", "isGalaxyOn5ChinaModel", "()Z", "isCalling", "isAllowAudioRecord", "enableControls", "view", "Landroid/view/View;", "enable", "DeviceModel", "ntComposer_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
@SourceDebugExtension({"SMAP\nVoiceUtil.kt\nKotlin\n*S Kotlin\n*F\n+ 1 VoiceUtil.kt\ncom/samsung/android/support/senl/nt/composer/main/base/presenter/voice/VoiceUtil\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n+ 3 ArraysJVM.kt\nkotlin/collections/ArraysKt__ArraysJVMKt\n*L\n1#1,262:1\n739#2,9:263\n739#2,9:276\n37#3:272\n36#3,3:273\n37#3:285\n36#3,3:286\n*S KotlinDebug\n*F\n+ 1 VoiceUtil.kt\ncom/samsung/android/support/senl/nt/composer/main/base/presenter/voice/VoiceUtil\n*L\n55#1:263,9\n99#1:276,9\n56#1:272\n56#1:273,3\n100#1:285\n100#1:286,3\n*E\n"})
public final class VoiceUtil {

    @NotNull
    public static final VoiceUtil INSTANCE = new VoiceUtil();

    @NotNull
    private static final String RESTRICTION1_URI = "content://com.sec.knox.provider/RestrictionPolicy1";

    @NotNull
    private static final String RESTRICTIONPOLICY_AUDIORECORDALLOWED_METHOD = "isAudioRecordAllowed";

    @NotNull
    private static final String TAG;

    @NotNull
    public static final String TIME_SPLIT = ":";

    @NotNull
    private static DeviceModel mIsGalaxyOn5ChinaModel;

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* JADX WARN: Unknown enum class pattern. Please report as an issue! */
    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0006\b\u0080\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006¨\u0006\u0007"}, m13886d2 = {"Lcom/samsung/android/support/senl/nt/composer/main/base/presenter/voice/VoiceUtil$DeviceModel;", "", "<init>", "(Ljava/lang/String;I)V", "NeedToCheck", "GALAXY_ON_5", "NORMAL", "ntComposer_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
    public static final class DeviceModel {
        private static final /* synthetic */ EnumEntries $ENTRIES;
        private static final /* synthetic */ DeviceModel[] $VALUES;
        public static final DeviceModel NeedToCheck = new DeviceModel("NeedToCheck", 0);
        public static final DeviceModel GALAXY_ON_5 = new DeviceModel("GALAXY_ON_5", 1);
        public static final DeviceModel NORMAL = new DeviceModel("NORMAL", 2);

        private static final /* synthetic */ DeviceModel[] $values() {
            return new DeviceModel[]{NeedToCheck, GALAXY_ON_5, NORMAL};
        }

        static {
            DeviceModel[] deviceModelArr$values = $values();
            $VALUES = deviceModelArr$values;
            $ENTRIES = EnumEntriesKt.enumEntries(deviceModelArr$values);
        }

        private DeviceModel(String str, int i) {
        }

        @NotNull
        public static EnumEntries<DeviceModel> getEntries() {
            return $ENTRIES;
        }

        public static DeviceModel valueOf(String str) {
            return (DeviceModel) Enum.valueOf(DeviceModel.class, str);
        }

        public static DeviceModel[] values() {
            return (DeviceModel[]) $VALUES.clone();
        }
    }

    static {
        String strCreateTag = Logger.createTag("VoiceUtil");
        Intrinsics.checkNotNullExpressionValue(strCreateTag, "createTag(...)");
        TAG = strCreateTag;
        mIsGalaxyOn5ChinaModel = DeviceModel.NeedToCheck;
    }

    private VoiceUtil() {
    }

    public static /* synthetic */ String createTimeString$default(VoiceUtil voiceUtil, int i, boolean z, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            z = false;
        }
        return voiceUtil.createTimeString(i, z);
    }

    private final String getGalaxyOn5ChinaModelBgColor() {
        FloatingFeature companion = FloatingFeature.INSTANCE.getInstance();
        String string = companion != null ? companion.getString("SEC_FLOATING_FEATURE_SYSTEMUI_CONFIG_NOTIFICATION_BG_COLOR", "") : "";
        AbstractC8014b.m7196B("getGalaxyOn5ChinaModelBgColor: ", string, TAG);
        return string;
    }

    @JvmStatic
    @SuppressLint({"Range"})
    public static final boolean isAllowAudioRecord(@Nullable Context context) {
        if (context == null) {
            return false;
        }
        Cursor cursorQuery = context.getContentResolver().query(Uri.parse(RESTRICTION1_URI), null, RESTRICTIONPOLICY_AUDIORECORDALLOWED_METHOD, new String[]{"true"}, null);
        if (cursorQuery == null) {
            return true;
        }
        try {
            cursorQuery.moveToFirst();
            if (!Intrinsics.areEqual(cursorQuery.getString(cursorQuery.getColumnIndex(RESTRICTIONPOLICY_AUDIORECORDALLOWED_METHOD)), "false")) {
                return true;
            }
            Logger.m10999d(TAG, "isAllowAudioRecord = false");
            return false;
        } finally {
            cursorQuery.close();
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:29:0x008a, code lost:
    
        throw new java.lang.ArithmeticException("Overflow detected");
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final int changeTimeType(@Nullable String timeStr) {
        List listEmptyList;
        int i;
        int i2 = 0;
        if (TextUtils.isEmpty(timeStr)) {
            return 0;
        }
        Intrinsics.checkNotNull(timeStr);
        List<String> listSplit = new Regex(":").split(timeStr, 0);
        if (listSplit.isEmpty()) {
            listEmptyList = CollectionsKt.emptyList();
        } else {
            ListIterator<String> listIterator = listSplit.listIterator(listSplit.size());
            while (listIterator.hasPrevious()) {
                if (listIterator.previous().length() != 0) {
                    listEmptyList = AbstractC12991c.m14000u(listIterator, 1, listSplit);
                    break;
                }
            }
            listEmptyList = CollectionsKt.emptyList();
        }
        String[] strArr = (String[]) listEmptyList.toArray(new String[0]);
        try {
            int length = strArr.length - 1;
            long j = 0;
            int i4 = 0;
            if (length >= 0) {
                while (true) {
                    int i5 = length - 1;
                    int i6 = i4 + 1;
                    double d = i4;
                    i = i2;
                    try {
                        long j2 = Long.parseLong(strArr[length]) * ((long) Math.pow(60.0d, d));
                        if (j2 > 2147483647L || j2 < -2147483648L) {
                            break;
                        }
                        j += j2;
                        if (i5 < 0) {
                            break;
                        }
                        i2 = i;
                        length = i5;
                        i4 = i6;
                    } catch (ArithmeticException e) {
                        e = e;
                        AbstractC8014b.m7198D("Overflow detected, e: ", e.getMessage(), TAG);
                        return i;
                    } catch (NumberFormatException e2) {
                        e = e2;
                        AbstractC8014b.m7198D("changeTimeType, e: ", e.getMessage(), TAG);
                        return i;
                    }
                }
            }
            if (j > 2147483647L || j < -2147483648L) {
                throw new ArithmeticException("Overflow detected");
            }
            return (int) j;
        } catch (ArithmeticException e3) {
            e = e3;
            i = 0;
        } catch (NumberFormatException e5) {
            e = e5;
            i = 0;
        }
    }

    @NotNull
    public final String createTimeDescription(@Nullable Resources resources, @NotNull String time) {
        List listEmptyList;
        int i;
        int i2;
        String str;
        Intrinsics.checkNotNullParameter(time, "time");
        int i4 = 0;
        List<String> listSplit = new Regex(":").split(time, 0);
        if (listSplit.isEmpty()) {
            listEmptyList = CollectionsKt.emptyList();
        } else {
            ListIterator<String> listIterator = listSplit.listIterator(listSplit.size());
            while (listIterator.hasPrevious()) {
                if (listIterator.previous().length() != 0) {
                    listEmptyList = AbstractC12991c.m14000u(listIterator, 1, listSplit);
                    break;
                }
            }
            listEmptyList = CollectionsKt.emptyList();
        }
        String[] strArr = (String[]) listEmptyList.toArray(new String[0]);
        try {
            int length = strArr.length;
            if (length == 2) {
                i = Integer.parseInt(strArr[0]);
                i2 = Integer.parseInt(strArr[1]);
            } else {
                if (length != 3) {
                    throw new NumberFormatException("time format error, not HH:mm:ss or mm:ss");
                }
                i4 = Integer.parseInt(strArr[0]);
                i = Integer.parseInt(strArr[1]);
                i2 = Integer.parseInt(strArr[2]);
            }
            if (i4 > 0) {
                str = i4 + " " + (resources != null ? resources.getString(C9086R.string.hour) : null) + " ";
            } else {
                str = "";
            }
            if (i > 0) {
                str = str + i + " " + (resources != null ? resources.getString(C9086R.string.minute) : null) + " ";
            }
            return str + i2 + " " + (resources != null ? resources.getString(C9086R.string.second) : null);
        } catch (NumberFormatException e) {
            AbstractC8014b.m7197C("createTimeDescription ", e.getMessage(), TAG);
            return time;
        }
    }

    @JvmOverloads
    @NotNull
    public final String createTimeString(int i) {
        return createTimeString$default(this, i, false, 2, null);
    }

    public final void enableControls(@NotNull View view, boolean enable) {
        Intrinsics.checkNotNullParameter(view, "view");
        if (view instanceof ViewGroup) {
            ViewGroup viewGroup = (ViewGroup) view;
            int childCount = viewGroup.getChildCount();
            for (int i = 0; i < childCount; i++) {
                View childAt = viewGroup.getChildAt(i);
                if (childAt != null && ((childAt instanceof ImageView) || (childAt instanceof Button))) {
                    childAt.setClickable(enable);
                    childAt.setEnabled(enable);
                }
                if (childAt != null && (childAt instanceof ViewGroup) && !(childAt instanceof RecyclerView)) {
                    enableControls(childAt, enable);
                }
            }
        }
    }

    public final boolean isCalling(@Nullable Context context) {
        if (context == null) {
            return false;
        }
        if (Build.VERSION.SDK_INT < 31) {
            Object systemService = context.getSystemService("phone");
            Intrinsics.checkNotNull(systemService, "null cannot be cast to non-null type android.telephony.TelephonyManager");
            int callState = ((TelephonyManager) systemService).getCallState();
            if (callState != 0) {
                AbstractC0000a.m3D(callState, "isCalling] CallState: ", TAG);
                return true;
            }
        }
        Object systemService2 = context.getSystemService("audio");
        Intrinsics.checkNotNull(systemService2, "null cannot be cast to non-null type android.media.AudioManager");
        int mode = ((AudioManager) systemService2).getMode();
        if (mode == 0) {
            return false;
        }
        AbstractC0000a.m3D(mode, "isCalling] AudioMode: ", TAG);
        return true;
    }

    public final boolean isGalaxyOn5ChinaModel() {
        if (mIsGalaxyOn5ChinaModel == DeviceModel.NeedToCheck) {
            String galaxyOn5ChinaModelBgColor = getGalaxyOn5ChinaModelBgColor();
            if (TextUtils.isEmpty(galaxyOn5ChinaModelBgColor)) {
                mIsGalaxyOn5ChinaModel = DeviceModel.NORMAL;
            } else {
                try {
                    if (((int) Long.parseLong(galaxyOn5ChinaModelBgColor, CharsKt.checkRadix(16))) != 0) {
                        mIsGalaxyOn5ChinaModel = DeviceModel.GALAXY_ON_5;
                    }
                } catch (Exception unused) {
                    Logger.m11000e(TAG, "isGalaxyOn5ChinaModel exception");
                    mIsGalaxyOn5ChinaModel = DeviceModel.NORMAL;
                }
            }
        }
        return mIsGalaxyOn5ChinaModel == DeviceModel.GALAXY_ON_5;
    }

    public final boolean isScreenOn(@Nullable Context context) {
        PowerManager powerManager;
        if (context == null || (powerManager = (PowerManager) context.getSystemService("power")) == null) {
            return false;
        }
        return powerManager.isScreenOn();
    }

    public final void updateTimeEms(@Nullable TextView timeView, @Nullable CharSequence time) {
        if (timeView == null || time == null) {
            return;
        }
        if (time.length() > 5) {
            timeView.setEms(4);
        } else {
            timeView.setEms(3);
        }
        timeView.setText(time);
    }

    @JvmOverloads
    @NotNull
    public final String createTimeString(int timeInSecond, boolean includeHour) {
        String strCreateTimeString = VoiceTimeDataUtils.createTimeString(timeInSecond, includeHour);
        Intrinsics.checkNotNullExpressionValue(strCreateTimeString, "createTimeString(...)");
        return strCreateTimeString;
    }
}
