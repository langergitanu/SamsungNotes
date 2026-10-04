package com.samsung.android.sdk.composer.util;

import android.content.Context;
import android.content.pm.PackageManager;
import android.graphics.RectF;
import android.icu.text.BreakIterator;
import android.os.Environment;
import android.os.StatFs;
import android.provider.Settings;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import androidx.appcompat.widget.AbstractC0541b;
import androidx.collection.AbstractC0622a;
import androidx.constraintlayout.motion.widget.AbstractC2322a;
import androidx.glance.AbstractC2821a;
import com.samsung.android.app.notes.sync.coedit.sharecore.strategy.AbstractC6670b;
import com.samsung.android.sdk.composer.document.sdoc.SpenContentText;
import com.samsung.android.sdk.smp.common.constants.MarketingConstants;
import com.samsung.android.spen.libwrapper.FloatingFeatureWrapper;
import com.samsung.android.spen.libwrapper.SystemPropertiesWrapper;
import com.samsung.android.spen.libwrapper.ViewWrapper;
import com.samsung.android.spen.libwrapper.utils.PlatformException;
import com.samsung.android.spen.libwrapper.utils.PlatformUtils;
import com.samsung.android.support.senl.p145cm.base.framework.sem.provider.SettingsCompatImplFactory;
import com.samsung.android.support.senl.p148nt.data.common.constants.SearchConstants;
import com.samsung.android.support.senl.p148nt.data.database.core.query.sqlbuilder.SQLKeyword;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.regex.PatternSyntaxException;
import kotlin.Metadata;
import kotlin.collections.AbstractC12991c;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.ArrayIteratorKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.text.Regex;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes7.dex */
@Metadata(m13885d1 = {"\u0000\u0084\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0010\u0015\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0014\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010\f\n\u0002\b\f\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000e\bÆ\u0002\u0018\u00002\u00020\u0001:\u0001]B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u001a\u0010\r\u001a\u00020\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\u00102\u0006\u0010\u0011\u001a\u00020\u0007H\u0007J\u0012\u0010\u001a\u001a\u00020\u00132\b\u0010\u001b\u001a\u0004\u0018\u00010\u001cH\u0007J\u0012\u0010\u001d\u001a\u00020\u00132\b\u0010\u001b\u001a\u0004\u0018\u00010\u001cH\u0007J\u0012\u0010\u001e\u001a\u00020\u00132\b\u0010\u001b\u001a\u0004\u0018\u00010\u001cH\u0007J\u0012\u0010\u001f\u001a\u00020\u00132\b\u0010\u001b\u001a\u0004\u0018\u00010\u001cH\u0007J\u001a\u0010 \u001a\u00020!2\b\u0010\"\u001a\u0004\u0018\u00010#2\u0006\u0010$\u001a\u00020\u0007H\u0007J\u0012\u0010%\u001a\u00020\u00132\b\u0010\u001b\u001a\u0004\u0018\u00010\u001cH\u0007J&\u0010&\u001a\u00020\u000e2\b\u0010'\u001a\u0004\u0018\u00010\u00052\b\u0010(\u001a\u0004\u0018\u00010\u00052\b\u0010)\u001a\u0004\u0018\u00010*H\u0002J\u001c\u0010+\u001a\u00020\u00132\b\u0010'\u001a\u0004\u0018\u00010\u00052\b\u0010(\u001a\u0004\u0018\u00010\u0005H\u0002JB\u0010,\u001a\u00020\u00072\b\u0010'\u001a\u0004\u0018\u00010\u00052\b\u0010,\u001a\u0004\u0018\u00010\u00052\b\u0010-\u001a\u0004\u0018\u00010*2\u001a\u0010.\u001a\u0016\u0012\u0004\u0012\u000200\u0018\u00010/j\n\u0012\u0004\u0012\u000200\u0018\u0001`1H\u0002JL\u00102\u001a\u00020!2\b\u00103\u001a\u0004\u0018\u0001042\b\u0010,\u001a\u0004\u0018\u00010\u00052\b\u0010'\u001a\u0004\u0018\u00010\u00052\b\u0010-\u001a\u0004\u0018\u00010*2\u001a\u0010.\u001a\u0016\u0012\u0004\u0012\u000200\u0018\u00010/j\n\u0012\u0004\u0012\u000200\u0018\u0001`1H\u0002J0\u0010&\u001a\u00020!2\b\u00105\u001a\u0004\u0018\u00010\u00052\b\u0010(\u001a\u0004\u0018\u00010\u00052\b\u0010-\u001a\u0004\u0018\u00010*2\b\u0010.\u001a\u0004\u0018\u00010\u000eH\u0007J\u0014\u00106\u001a\u0004\u0018\u0001042\b\u00107\u001a\u0004\u0018\u00010\u0005H\u0002J:\u00108\u001a\u00020!2\b\u00109\u001a\u0004\u0018\u0001042\b\u0010(\u001a\u0004\u0018\u00010\u00052\b\u00105\u001a\u0004\u0018\u00010\u00052\b\u0010-\u001a\u0004\u0018\u00010*2\b\u0010.\u001a\u0004\u0018\u00010\u000eH\u0002J*\u0010:\u001a\u00020!2\b\u0010.\u001a\u0004\u0018\u00010\u000e2\u0006\u0010;\u001a\u00020\u00072\u0006\u0010<\u001a\u00020\u00072\u0006\u0010=\u001a\u00020\u0007H\u0002J\u0010\u0010>\u001a\u00020\u00132\u0006\u0010?\u001a\u00020@H\u0002J\u0010\u0010A\u001a\u00020\u00132\u0006\u0010?\u001a\u00020@H\u0002J\u0010\u0010B\u001a\u00020\u00132\u0006\u0010?\u001a\u00020@H\u0002J\u0010\u0010C\u001a\u00020\u00132\u0006\u0010?\u001a\u00020@H\u0002J\u0010\u0010D\u001a\u00020\u00132\u0006\u0010?\u001a\u00020@H\u0002J\u0010\u0010E\u001a\u00020\u00132\u0006\u0010?\u001a\u00020@H\u0002J\u0010\u0010F\u001a\u00020\u00132\u0006\u0010G\u001a\u00020@H\u0007J\u0010\u0010H\u001a\u00020\u00132\u0006\u0010?\u001a\u00020@H\u0002J@\u0010O\u001a\u00020P2\u0006\u0010Q\u001a\u00020\u00072\u0006\u0010R\u001a\u00020M2\u0006\u0010S\u001a\u00020\u00072\u0006\u0010T\u001a\u00020\u00072\u0006\u0010U\u001a\u00020M2\u0006\u0010V\u001a\u00020\u00072\u0006\u0010W\u001a\u00020\u0013H\u0007J(\u0010X\u001a\u00020M2\u0006\u0010R\u001a\u00020M2\u0006\u0010Q\u001a\u00020\u00072\u0006\u0010S\u001a\u00020\u00072\u0006\u0010T\u001a\u00020\u0007H\u0002J0\u0010Y\u001a\u00020M2\u0006\u0010R\u001a\u00020M2\u0006\u0010Z\u001a\u00020\u00072\u0006\u0010[\u001a\u00020M2\u0006\u0010V\u001a\u00020\u00072\u0006\u0010W\u001a\u00020\u0013H\u0002J\u0012\u0010\\\u001a\u00020\u00132\b\u0010\u001b\u001a\u0004\u0018\u00010\u001cH\u0007R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\b\u001a\u00020\t8FX\u0087\u0004¢\u0006\f\u0012\u0004\b\n\u0010\u0003\u001a\u0004\b\u000b\u0010\fR\u001a\u0010\u0012\u001a\u00020\u00138FX\u0087\u0004¢\u0006\f\u0012\u0004\b\u0014\u0010\u0003\u001a\u0004\b\u0012\u0010\u0015R\u001a\u0010\u0016\u001a\u00020\u00138FX\u0087\u0004¢\u0006\f\u0012\u0004\b\u0017\u0010\u0003\u001a\u0004\b\u0016\u0010\u0015R\u0018\u0010\u0018\u001a\u00020\u00078\u0002@\u0002X\u0083\u000e¢\u0006\b\n\u0000\u0012\u0004\b\u0019\u0010\u0003R\u000e\u0010I\u001a\u00020\u0007X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010J\u001a\u00020\u0007X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010K\u001a\u00020\u0007X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010L\u001a\u00020MX\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010N\u001a\u00020\u0007X\u0082T¢\u0006\u0002\n\u0000¨\u0006^"}, m13886d2 = {"Lcom/samsung/android/sdk/composer/util/SpenComposerUtil;", "", "<init>", "()V", SearchConstants.TargetContents.TAG, "", "mIsOtherCorpDevice", "", "availableInternalMemorySize", "", "getAvailableInternalMemorySize$annotations", "getAvailableInternalMemorySize", "()J", "getWord", "", MarketingConstants.NotificationConst.CONTENT_TEXT, "Lcom/samsung/android/sdk/composer/document/sdoc/SpenContentText;", "index", "isSemDevice", "", "isSemDevice$annotations", "()Z", "isOtherCorpDevice", "isOtherCorpDevice$annotations", "mIsWifiOnlyModel", "getMIsWifiOnlyModel$annotations", "isWifiOnlyModel", "context", "Landroid/content/Context;", "isLDUModel", "isShopDemo", "isShopDemoDevice", "performHapticFeedback", "", "view", "Landroid/view/View;", "pattern", "isAccessibilityEnabled", "setHighlightText", "originText", "highlightText", "widthArray", "", "findHighlightText", "searchText", "measureWidths", "output", "Ljava/util/ArrayList;", "Lcom/samsung/android/sdk/composer/util/SpenComposerUtil$SearchInfo;", "Lkotlin/collections/ArrayList;", "searchTextWithPattern", "searchPattern", "Ljava/util/regex/Pattern;", "text", "createSearchHightlightPattern", "searchString", "highlightMessage", "highlight", "setArray", "start", "end", "value", "isSurrogate", "charcode", "", "isIndianChar", "isThaiChar", "isKhmerChar", "isMyanmarChar", "isLaoChar", "isCombinedCode", "c", "isHalant", "MAX_TEXTURE_SIZE", "IMAGE_RESIZE_MIN_WIDTH", "IMAGE_MIN_SIZE", "TASK_STATUS_DONE_RATIO", "", "VIEW_LEFT_RIGHT_MARGIN", "getImageViewSize", "Landroid/graphics/RectF;", "screenWidthPixel", "density", "bitmapWidth", "bitmapHeight", "resizeRatio", "maxWidth", "taskDone", "calculateDefaultRatioOnScreen", "calculateEditedResizeRatioOnScreen", "currentWidth", "imageRatio", "isUPSM", "SearchInfo", "SDK_fullRelease"}, m13887k = 1, m13888mv = {2, 0, 0}, m13890xi = 48)
@SourceDebugExtension({"SMAP\nSpenComposerUtil.kt\nKotlin\n*S Kotlin\n*F\n+ 1 SpenComposerUtil.kt\ncom/samsung/android/sdk/composer/util/SpenComposerUtil\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n+ 3 ArraysJVM.kt\nkotlin/collections/ArraysKt__ArraysJVMKt\n+ 4 Strings.kt\nkotlin/text/StringsKt__StringsKt\n*L\n1#1,636:1\n731#2,9:637\n731#2,9:648\n731#2,9:682\n37#3,2:646\n37#3,2:657\n37#3,2:691\n107#4:659\n79#4,22:660\n107#4:693\n79#4,22:694\n107#4:716\n79#4,22:717\n*S KotlinDebug\n*F\n+ 1 SpenComposerUtil.kt\ncom/samsung/android/sdk/composer/util/SpenComposerUtil\n*L\n190#1:637,9\n221#1:648,9\n318#1:682,9\n190#1:646,2\n221#1:657,2\n318#1:691,2\n238#1:659\n238#1:660,22\n334#1:693\n334#1:694,22\n365#1:716\n365#1:717,22\n*E\n"})
public final class SpenComposerUtil {
    private static final int IMAGE_MIN_SIZE = 74;
    private static final int IMAGE_RESIZE_MIN_WIDTH = 180;
    private static final int MAX_TEXTURE_SIZE = 8192;

    @NotNull
    private static final String TAG = "ComposerUtil";
    private static final float TASK_STATUS_DONE_RATIO = 0.7f;
    private static final int VIEW_LEFT_RIGHT_MARGIN = 24;

    @NotNull
    public static final SpenComposerUtil INSTANCE = new SpenComposerUtil();
    private static int mIsOtherCorpDevice = -1;
    private static int mIsWifiOnlyModel = -1;

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\n\b\u0000\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0004\b\u0005\u0010\u0006R\u001a\u0010\u0002\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR\u001a\u0010\u0004\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\b\"\u0004\b\f\u0010\n¨\u0006\r"}, m13886d2 = {"Lcom/samsung/android/sdk/composer/util/SpenComposerUtil$SearchInfo;", "", "start", "", "end", "<init>", "(II)V", "getStart", "()I", "setStart", "(I)V", "getEnd", "setEnd", "SDK_fullRelease"}, m13887k = 1, m13888mv = {2, 0, 0}, m13890xi = 48)
    public static final class SearchInfo {
        private int end;
        private int start;

        public SearchInfo(int i, int i2) {
            this.start = i;
            this.end = i2;
        }

        public final int getEnd() {
            return this.end;
        }

        public final int getStart() {
            return this.start;
        }

        public final void setEnd(int i) {
            this.end = i;
        }

        public final void setStart(int i) {
            this.start = i;
        }
    }

    private SpenComposerUtil() {
    }

    /* JADX WARN: Removed duplicated region for block: B:18:0x0056  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private final float calculateDefaultRatioOnScreen(float density, int screenWidthPixel, int bitmapWidth, int bitmapHeight) {
        float fCalculateEditedResizeRatioOnScreen;
        if (bitmapWidth <= 0 || bitmapHeight <= 0) {
            return 1.0f;
        }
        float f = bitmapHeight;
        float f4 = bitmapWidth;
        float f5 = f / f4;
        int i = screenWidthPixel - ((int) (24 * density));
        if (i <= 0) {
            return 1.0f;
        }
        float fCalculateEditedResizeRatioOnScreen2 = calculateEditedResizeRatioOnScreen(density, bitmapWidth, f5, i, false);
        RectF imageViewSize = getImageViewSize(screenWidthPixel, density, bitmapWidth, bitmapHeight, fCalculateEditedResizeRatioOnScreen2, i, false);
        if (imageViewSize.height() > 8192.0f) {
            int i2 = (int) (180 * density);
            if (imageViewSize.width() > i2) {
                int i4 = (int) ((f4 * 8192) / f);
                fCalculateEditedResizeRatioOnScreen = calculateEditedResizeRatioOnScreen(density, i4 < i2 ? i2 : i4, f5, i, false);
            } else {
                fCalculateEditedResizeRatioOnScreen = fCalculateEditedResizeRatioOnScreen2;
            }
        }
        Log.d(TAG, "calculateDefaultRatioOnScreen result - resizeRatio:" + fCalculateEditedResizeRatioOnScreen);
        return fCalculateEditedResizeRatioOnScreen;
    }

    private final float calculateEditedResizeRatioOnScreen(float density, int currentWidth, float imageRatio, int maxWidth, boolean taskDone) {
        int i = (int) (74 * density);
        if (imageRatio < 1.0f) {
            i = (int) (i / imageRatio);
        }
        if (i > maxWidth) {
            i = maxWidth;
        }
        float f = maxWidth <= currentWidth ? 1.0f : currentWidth <= i ? 0.0f : (currentWidth - i) / (maxWidth - i);
        if (taskDone) {
            f /= 0.7f;
        }
        float f4 = f <= 1.0f ? f : 1.0f;
        Log.d(TAG, "calculateEditedResizeRatioOnScreen result - ratio:" + f4);
        return f4;
    }

    private final Pattern createSearchHightlightPattern(String searchString) {
        if (TextUtils.isEmpty(searchString) || searchString == null) {
            return null;
        }
        int length = searchString.length() - 1;
        int i = 0;
        boolean z = false;
        while (i <= length) {
            boolean z2 = Intrinsics.compare((int) searchString.charAt(!z ? i : length), 32) <= 0;
            if (z) {
                if (!z2) {
                    break;
                }
                length--;
            } else if (z2) {
                i++;
            } else {
                z = true;
            }
        }
        String strReplace = new Regex(" ").replace(searchString.subSequence(i, length + 1).toString(), "");
        boolean z3 = strReplace.length() != 1;
        Pattern patternCompile = Pattern.compile("[$*()+|<>?{}\\[\\]\\{\\}\\^\\\\\\.]");
        StringBuilder sb = new StringBuilder(strReplace);
        for (int length2 = strReplace.length() - 1; -1 < length2; length2--) {
            if (patternCompile.matcher(strReplace.subSequence(length2, length2 + 1)).find()) {
                sb.insert(length2, "\\");
            }
            if (z3 && !Character.isLowSurrogate(strReplace.charAt(length2)) && length2 != 0) {
                sb.insert(length2, "[\\s]{0,}");
            }
        }
        return Pattern.compile(sb.toString(), 2);
    }

    /* JADX WARN: Removed duplicated region for block: B:17:0x003a  */
    /* JADX WARN: Removed duplicated region for block: B:18:0x0045  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private final boolean findHighlightText(String originText, String highlightText) {
        String[] strArr;
        List listM13999t;
        List listEmptyList;
        if (highlightText == null || (listM13999t = AbstractC12991c.m13999t(0, " ", highlightText)) == null) {
            strArr = null;
        } else if (listM13999t.isEmpty()) {
            listEmptyList = CollectionsKt.emptyList();
            if (listEmptyList == null) {
            }
        } else {
            ListIterator listIterator = listM13999t.listIterator(listM13999t.size());
            while (listIterator.hasPrevious()) {
                if (((String) listIterator.previous()).length() != 0) {
                    listEmptyList = AbstractC12991c.m14000u(listIterator, 1, listM13999t);
                    break;
                }
            }
            listEmptyList = CollectionsKt.emptyList();
            if (listEmptyList == null) {
                strArr = (String[]) listEmptyList.toArray(new String[0]);
            }
        }
        if (strArr != null) {
            Iterator it = ArrayIteratorKt.iterator(strArr);
            while (it.hasNext()) {
                String str = (String) it.next();
                Pattern patternCreateSearchHightlightPattern = createSearchHightlightPattern(str);
                Log.d(TAG, "findHighlightText : " + originText + SQLKeyword.COMMA + patternCreateSearchHightlightPattern + SQLKeyword.COMMA + str);
                if (patternCreateSearchHightlightPattern == null) {
                    return false;
                }
                try {
                    if (!patternCreateSearchHightlightPattern.matcher(String.valueOf(originText)).find()) {
                        return false;
                    }
                } catch (IllegalArgumentException unused) {
                    Log.e(TAG, "IllegalArgumentException");
                    return false;
                }
            }
        }
        return true;
    }

    public static final long getAvailableInternalMemorySize() {
        StatFs statFs = new StatFs(Environment.getDataDirectory().getPath());
        return statFs.getAvailableBlocksLong() * statFs.getBlockSizeLong();
    }

    @JvmStatic
    public static /* synthetic */ void getAvailableInternalMemorySize$annotations() {
    }

    @JvmStatic
    @NotNull
    public static final RectF getImageViewSize(int screenWidthPixel, float density, int bitmapWidth, int bitmapHeight, float resizeRatio, int maxWidth, boolean taskDone) {
        StringBuilder sbM1628r = AbstractC2322a.m1628r("getImageViewSize screenWidthPixel:", screenWidthPixel, ",density:", density, "bitmap W:");
        AbstractC2821a.m2235z(sbM1628r, bitmapWidth, bitmapHeight, ",H:", ", resizeRatio:");
        sbM1628r.append(resizeRatio);
        sbM1628r.append(", maxWidth:");
        sbM1628r.append(maxWidth);
        sbM1628r.append(", done?");
        sbM1628r.append(taskDone);
        Log.d(TAG, sbM1628r.toString());
        int i = (int) (74 * density);
        if (resizeRatio < 0.0f) {
            resizeRatio = INSTANCE.calculateDefaultRatioOnScreen(density, screenWidthPixel, bitmapWidth, bitmapHeight);
        }
        if (resizeRatio > 1.0f) {
            resizeRatio = 1.0f;
        }
        if (bitmapWidth > bitmapHeight) {
            i = (int) ((bitmapWidth / bitmapHeight) * i);
        }
        RectF rectF = new RectF();
        float f = bitmapWidth != 0 ? bitmapHeight / bitmapWidth : 0.0f;
        if (taskDone) {
            resizeRatio *= 0.7f;
        }
        int i2 = screenWidthPixel - ((int) (24 * density));
        if (maxWidth >= i2) {
            maxWidth = i2;
        }
        AbstractC0541b.m783y(i2, maxWidth, "getImageViewSize oldW:", ", maxImgW:", TAG);
        if (i < maxWidth) {
            i += (int) ((maxWidth - i) * resizeRatio);
        }
        float f4 = i;
        int i4 = (int) (f * f4);
        rectF.set(0.0f, 0.0f, f4, i4);
        StringBuilder sbM1173s = AbstractC0622a.m1173s(i, i4, "getImageViewSize result - W:", ",H:", ", ratio:");
        sbM1173s.append(resizeRatio);
        Log.d(TAG, sbM1173s.toString());
        return rectF;
    }

    @JvmStatic
    private static /* synthetic */ void getMIsWifiOnlyModel$annotations() {
    }

    @JvmStatic
    @NotNull
    public static final int[] getWord(@Nullable SpenContentText contentText, int index) {
        int[] iArr = new int[2];
        if (contentText != null && contentText.getText() != null && index >= 0) {
            String text = contentText.getText();
            Intrinsics.checkNotNull(text);
            if (index <= text.length()) {
                BreakIterator wordInstance = BreakIterator.getWordInstance();
                wordInstance.setText(contentText.getText());
                wordInstance.following(index);
                iArr[0] = wordInstance.previous();
                iArr[1] = wordInstance.next();
                return iArr;
            }
        }
        iArr[0] = 0;
        iArr[1] = 0;
        return iArr;
    }

    private final void highlightMessage(Pattern highlight, String highlightText, String text, float[] measureWidths, int[] output) {
        boolean z;
        if (highlight == null || highlightText == null || text == null || measureWidths == null || output == null) {
            return;
        }
        try {
            int length = highlightText.length() - 1;
            int i = 0;
            int i2 = 0;
            boolean z2 = false;
            while (i2 <= length) {
                boolean z3 = Intrinsics.compare((int) highlightText.charAt(!z2 ? i2 : length), 32) <= 0;
                if (z2) {
                    if (!z3) {
                        break;
                    } else {
                        length--;
                    }
                } else if (z3) {
                    i2++;
                } else {
                    z2 = true;
                }
            }
            char[] charArray = new Regex(" ").replace(highlightText.subSequence(i2, length + 1).toString(), "").toCharArray();
            Intrinsics.checkNotNullExpressionValue(charArray, "this as java.lang.String).toCharArray()");
            char[] charArray2 = text.toCharArray();
            Intrinsics.checkNotNullExpressionValue(charArray2, "this as java.lang.String).toCharArray()");
            int length2 = charArray2.length;
            int length3 = charArray.length;
            int i4 = 0;
            while (true) {
                if (i4 >= length3) {
                    z = false;
                    i4 = 0;
                    break;
                } else {
                    if (isCombinedCode(charArray[i4])) {
                        z = true;
                        break;
                    }
                    i4++;
                }
            }
            Matcher matcher = highlight.matcher(text);
            while (matcher.find()) {
                if (z) {
                    String strGroup = matcher.group();
                    Intrinsics.checkNotNullExpressionValue(strGroup, "group(...)");
                    char[] charArray3 = strGroup.toCharArray();
                    Intrinsics.checkNotNullExpressionValue(charArray3, "this as java.lang.String).toCharArray()");
                    int i5 = i4;
                    while (i5 < matcher.end() && !isCombinedCode(charArray3[i5])) {
                        i5++;
                    }
                    if (i5 == matcher.end()) {
                        Log.e(TAG, "highlightMessage:: it is not combined.");
                    } else {
                        int iStart = matcher.start();
                        if (isIndianChar(charArray3[i5])) {
                            while (iStart > i && isHalant(charArray2[iStart - 1])) {
                                iStart -= 2;
                            }
                            if (iStart < i) {
                                Log.e(TAG, "highlightMessage:: pre pos halant is smaller than min.");
                                iStart = matcher.start();
                            }
                        } else {
                            while (iStart > i && measureWidths[iStart] == 0.0f) {
                                iStart--;
                            }
                        }
                        int iEnd = matcher.end();
                        while (iEnd < length2 && (measureWidths[iEnd] == 0.0f || isHalant(charArray2[iEnd - 1]))) {
                            iEnd++;
                        }
                        i = iEnd - 1;
                        setArray(output, iStart, iEnd, 1);
                    }
                } else {
                    setArray(output, matcher.start(), matcher.end(), 1);
                }
            }
        } catch (IllegalArgumentException unused) {
            Log.e(TAG, "IllegalArgumentException");
        }
    }

    @JvmStatic
    public static final boolean isAccessibilityEnabled(@Nullable Context context) {
        String string;
        if (context != null && (string = Settings.Secure.getString(context.getContentResolver(), "enabled_accessibility_services")) != null) {
            try {
                if (new Regex("(?i).*com.samsung.android.app.talkback.TalkBackService.*").matches(string) || new Regex("(?i).*com.samsung.android.marvin.talkback.TalkBackService.*").matches(string)) {
                    return true;
                }
                return new Regex("(?i).*com.google.android.marvin.talkback.TalkBackService.*").matches(string);
            } catch (PatternSyntaxException e) {
                Log.e(TAG, "isAccessibilityEnabled() error:" + e);
            }
        }
        return false;
    }

    @JvmStatic
    public static final boolean isCombinedCode(char c) {
        SpenComposerUtil spenComposerUtil = INSTANCE;
        return spenComposerUtil.isSurrogate(c) || spenComposerUtil.isIndianChar(c) || spenComposerUtil.isThaiChar(c) || spenComposerUtil.isKhmerChar(c) || spenComposerUtil.isMyanmarChar(c) || spenComposerUtil.isLaoChar(c);
    }

    private final boolean isHalant(char charcode) {
        return charcode == 2381 || charcode == 2509 || charcode == 2637 || charcode == 2765 || charcode == 3021 || charcode == 3149 || charcode == 3277 || charcode == 3405 || charcode == 3551 || charcode == 2893;
    }

    private final boolean isIndianChar(char charcode) {
        return charcode >= 2304 && charcode < 3583;
    }

    private final boolean isKhmerChar(char charcode) {
        return charcode >= 6016 && charcode <= 6137;
    }

    @JvmStatic
    public static final boolean isLDUModel(@Nullable Context context) {
        if (!isSemDevice()) {
            return false;
        }
        try {
            if (FloatingFeatureWrapper.create(context).getBoolean("SEC_FLOATING_FEATURE_COMMON_SUPPORT_UNPACK")) {
                return true;
            }
            String salesCode = SystemPropertiesWrapper.create(context).getSalesCode();
            if (!TextUtils.isEmpty(salesCode)) {
                if (!Intrinsics.areEqual("PAP", salesCode) && !Intrinsics.areEqual("FOP", salesCode)) {
                    if (!Intrinsics.areEqual("LDU", salesCode)) {
                        return false;
                    }
                }
                return true;
            }
        } catch (PlatformException unused) {
        }
        return false;
    }

    private final boolean isLaoChar(char charcode) {
        if (charcode < 3713 || charcode > 3805) {
            return charcode >= 57345 && charcode <= 57368;
        }
        return true;
    }

    private final boolean isMyanmarChar(char charcode) {
        return charcode >= 4096 && charcode <= 4247;
    }

    public static final boolean isOtherCorpDevice() {
        if (mIsOtherCorpDevice == -1) {
            if (isSemDevice()) {
                mIsOtherCorpDevice = 0;
            } else {
                try {
                    mIsOtherCorpDevice = 0;
                } catch (Error unused) {
                    mIsOtherCorpDevice = 1;
                } catch (Exception unused2) {
                    mIsOtherCorpDevice = 1;
                }
            }
        }
        return mIsOtherCorpDevice == 1;
    }

    @JvmStatic
    public static /* synthetic */ void isOtherCorpDevice$annotations() {
    }

    public static final boolean isSemDevice() {
        return PlatformUtils.isSemDevice();
    }

    @JvmStatic
    public static /* synthetic */ void isSemDevice$annotations() {
    }

    @JvmStatic
    public static final boolean isShopDemo(@Nullable Context context) {
        return Settings.Secure.getInt(context != null ? context.getContentResolver() : null, "shopdemo", 0) == 1;
    }

    @JvmStatic
    public static final boolean isShopDemoDevice(@Nullable Context context) {
        boolean z = isLDUModel(context) || isShopDemo(context);
        AbstractC6670b.m4759t("isShopDemoDevice : ", TAG, z);
        return z;
    }

    private final boolean isSurrogate(char charcode) {
        return (charcode & 64512) == 55296;
    }

    private final boolean isThaiChar(char charcode) {
        return charcode >= 3585 && charcode < 3675;
    }

    @JvmStatic
    public static final boolean isUPSM(@Nullable Context context) {
        int i;
        if (context == null || isOtherCorpDevice()) {
            return false;
        }
        try {
            i = Settings.System.getInt(context.getContentResolver(), SettingsCompatImplFactory.UPSM_MODE_KEY, 0);
        } catch (IllegalArgumentException unused) {
            Log.e(TAG, "IllegalArgumentException UPSM");
            i = 0;
        }
        return i == 1;
    }

    @JvmStatic
    public static final boolean isWifiOnlyModel(@Nullable Context context) {
        if (mIsWifiOnlyModel == -1) {
            PackageManager packageManager = context != null ? context.getPackageManager() : null;
            if (packageManager != null) {
                mIsWifiOnlyModel = !packageManager.hasSystemFeature("android.hardware.telephony") ? 1 : 0;
            }
        }
        return mIsWifiOnlyModel == 1;
    }

    @JvmStatic
    public static final void performHapticFeedback(@Nullable View view, int pattern) {
        Context context;
        if (view != null) {
            try {
                context = view.getContext();
            } catch (PlatformException unused) {
                return;
            }
        } else {
            context = null;
        }
        ViewWrapper.create(context, view).performHapticFeedback(pattern);
    }

    /* JADX WARN: Removed duplicated region for block: B:18:0x004b A[LOOP:1: B:17:0x0049->B:18:0x004b, LOOP_END] */
    /* JADX WARN: Removed duplicated region for block: B:21:0x005f  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private final int searchText(String originText, String searchText, float[] measureWidths, ArrayList<SearchInfo> output) {
        List listEmptyList;
        if (!TextUtils.isEmpty(searchText) && searchText != null) {
            List listM13999t = AbstractC12991c.m13999t(0, " ", searchText);
            if (listM13999t.isEmpty()) {
                listEmptyList = CollectionsKt.emptyList();
                while (i < r2) {
                }
                if (output != null) {
                }
            } else {
                ListIterator listIterator = listM13999t.listIterator(listM13999t.size());
                while (listIterator.hasPrevious()) {
                    if (((String) listIterator.previous()).length() != 0) {
                        listEmptyList = AbstractC12991c.m14000u(listIterator, 1, listM13999t);
                        break;
                    }
                }
                listEmptyList = CollectionsKt.emptyList();
                for (String str : (String[]) listEmptyList.toArray(new String[0])) {
                    searchTextWithPattern(createSearchHightlightPattern(str), searchText, originText, measureWidths, output);
                }
                if (output != null) {
                    return output.size();
                }
            }
        }
        return 0;
    }

    private final void searchTextWithPattern(Pattern searchPattern, String searchText, String originText, float[] measureWidths, ArrayList<SearchInfo> output) {
        if (searchPattern == null || searchText == null || originText == null || measureWidths == null || output == null) {
            return;
        }
        try {
            boolean z = true;
            int length = searchText.length() - 1;
            int i = 0;
            int i2 = 0;
            boolean z2 = false;
            while (i2 <= length) {
                boolean z3 = Intrinsics.compare((int) searchText.charAt(!z2 ? i2 : length), 32) <= 0;
                if (z2) {
                    if (!z3) {
                        break;
                    } else {
                        length--;
                    }
                } else if (z3) {
                    i2++;
                } else {
                    z2 = true;
                }
            }
            char[] charArray = new Regex(" ").replace(searchText.subSequence(i2, length + 1).toString(), "").toCharArray();
            Intrinsics.checkNotNullExpressionValue(charArray, "this as java.lang.String).toCharArray()");
            char[] charArray2 = originText.toCharArray();
            Intrinsics.checkNotNullExpressionValue(charArray2, "this as java.lang.String).toCharArray()");
            int length2 = charArray2.length;
            int length3 = charArray.length;
            int i4 = 0;
            while (true) {
                if (i4 >= length3) {
                    z = false;
                    i4 = 0;
                    break;
                } else if (isCombinedCode(charArray[i4])) {
                    break;
                } else {
                    i4++;
                }
            }
            Matcher matcher = searchPattern.matcher(originText);
            while (matcher.find()) {
                if (z) {
                    String strGroup = matcher.group();
                    Intrinsics.checkNotNullExpressionValue(strGroup, "group(...)");
                    char[] charArray3 = strGroup.toCharArray();
                    Intrinsics.checkNotNullExpressionValue(charArray3, "this as java.lang.String).toCharArray()");
                    int i5 = i4;
                    while (i5 < matcher.end() && !isCombinedCode(charArray3[i5])) {
                        i5++;
                    }
                    if (i5 == matcher.end()) {
                        Log.e(TAG, "highlightMessage:: it is not combined.");
                    } else {
                        int iStart = matcher.start();
                        if (isIndianChar(charArray3[i5])) {
                            while (iStart > i && isHalant(charArray2[iStart - 1])) {
                                iStart -= 2;
                            }
                            if (iStart < i) {
                                Log.e(TAG, "highlightMessage:: pre pos halant is smaller than min.");
                                iStart = matcher.start();
                            }
                        } else {
                            while (iStart > i && measureWidths[iStart] == 0.0f) {
                                iStart--;
                            }
                        }
                        int iEnd = matcher.end();
                        while (iEnd < length2 && (measureWidths[iEnd] == 0.0f || isHalant(charArray2[iEnd - 1]))) {
                            iEnd++;
                        }
                        int i6 = iEnd - 1;
                        output.add(new SearchInfo(iStart, iEnd));
                        i = i6;
                    }
                } else {
                    output.add(new SearchInfo(matcher.start(), matcher.end()));
                }
            }
        } catch (IllegalArgumentException unused) {
            Log.e(TAG, "IllegalArgumentException");
        }
    }

    private final void setArray(int[] output, int start, int end, int value) {
        if (output == null) {
            return;
        }
        if (end > output.length) {
            end = output.length;
        }
        while (start < end) {
            output[start] = value;
            start++;
        }
    }

    private final int[] setHighlightText(String originText, String highlightText, float[] widthArray) {
        int[] iArr = new int[originText != null ? originText.length() : 0];
        setHighlightText(originText, highlightText, widthArray, iArr);
        return iArr;
    }

    /* JADX WARN: Removed duplicated region for block: B:19:0x0042  */
    /* JADX WARN: Removed duplicated region for block: B:20:0x004d  */
    @JvmStatic
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final void setHighlightText(@Nullable String text, @Nullable String highlightText, @Nullable float[] measureWidths, @Nullable int[] output) {
        String[] strArr;
        List listM13999t;
        List listEmptyList;
        if (TextUtils.isEmpty(highlightText)) {
            return;
        }
        if (highlightText == null || (listM13999t = AbstractC12991c.m13999t(0, " ", highlightText)) == null) {
            strArr = null;
        } else if (!listM13999t.isEmpty()) {
            ListIterator listIterator = listM13999t.listIterator(listM13999t.size());
            while (listIterator.hasPrevious()) {
                if (((String) listIterator.previous()).length() != 0) {
                    listEmptyList = AbstractC12991c.m14000u(listIterator, 1, listM13999t);
                    break;
                }
            }
            listEmptyList = CollectionsKt.emptyList();
            if (listEmptyList == null) {
                strArr = (String[]) listEmptyList.toArray(new String[0]);
            }
        } else {
            listEmptyList = CollectionsKt.emptyList();
            if (listEmptyList == null) {
            }
        }
        if (strArr != null) {
            Iterator it = ArrayIteratorKt.iterator(strArr);
            while (it.hasNext()) {
                String str = (String) it.next();
                SpenComposerUtil spenComposerUtil = INSTANCE;
                spenComposerUtil.highlightMessage(spenComposerUtil.createSearchHightlightPattern(str), highlightText, text, measureWidths, output);
            }
        }
    }
}
