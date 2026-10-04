package com.samsung.android.app.notes.widget.util;

import android.app.WallpaperColors;
import android.app.WallpaperManager;
import android.appwidget.AppWidgetManager;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.hardware.display.DisplayManager;
import android.os.Build;
import android.os.Bundle;
import android.text.SpannableString;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.text.style.StrikethroughSpan;
import android.util.SizeF;
import android.util.TypedValue;
import androidx.annotation.RequiresApi;
import androidx.appcompat.widget.AbstractC0541b;
import androidx.compose.runtime.AbstractC1974b;
import androidx.compose.runtime.internal.StabilityInferred;
import androidx.constraintlayout.motion.widget.AbstractC2322a;
import androidx.core.content.ContextCompat;
import androidx.core.graphics.ColorUtils;
import androidx.glance.AbstractC2821a;
import com.google.android.gms.common.data.AbstractC4539a;
import com.microsoft.identity.common.java.cache.CacheKeyValueDelegate;
import com.samsung.android.sdk.mobileservice.social.group.provider.GroupContract;
import com.samsung.android.sdk.smp.common.constants.MarketingConstants;
import com.samsung.android.support.senl.document.memoconverter.core.SNBUtils.vml.vector.shape.elements.VElementFormulasCmd;
import com.samsung.android.support.senl.p145cm.base.common.util.LocaleUtils;
import com.samsung.android.support.senl.p145cm.base.framework.support.DeviceInfo;
import com.samsung.android.support.senl.p148nt.base.common.util.DeviceUtils;
import com.samsung.android.support.senl.p148nt.base.common.util.FileUtils;
import com.samsung.android.support.senl.p148nt.base.common.util.ImageUtils;
import com.samsung.android.support.senl.p148nt.base.framework.support.Logger;
import com.samsung.android.support.senl.p148nt.base.widget.constant.BaseWidgetConstant;
import com.samsung.android.support.senl.p148nt.base.widget.preference.BaseWidgetPreferenceManager;
import com.samsung.android.support.senl.p148nt.base.widget.util.BaseWidgetUtils;
import com.samsung.android.support.senl.p148nt.base.winset.toast.ToastHandler;
import com.samsung.android.support.senl.p148nt.data.common.constants.SearchConstants;
import com.samsung.android.support.senl.p148nt.data.database.core.document.data.MainListDocumentData;
import com.samsung.android.support.senl.p148nt.data.database.core.query.sqlbuilder.SQLKeyword;
import com.samsung.android.support.senl.p148nt.data.database.core.schema.DBSchema;
import com.samsung.android.support.senl.p148nt.data.repository.NotesDataRepositoryFactory;
import com.samsung.android.support.senl.p148nt.homewidget.C11391R;
import com.samsung.android.support.senl.p148nt.model.document.save.autotitle.AutoTitleCreator;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.collections.AbstractC12991c;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.ArrayIteratorKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.text.StringsKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes7.dex */
@StabilityInferred(parameters = 0)
@Metadata(m13885d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0017\u0018\u0000 \u00042\u00020\u0001:\u0001\u0004B\u0007¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0005"}, m13886d2 = {"Lcom/samsung/android/app/notes/widget/util/WidgetUtils;", "Lcom/samsung/android/support/senl/nt/base/widget/util/BaseWidgetUtils;", "<init>", "()V", "Companion", "ntHomeWidget_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
public class WidgetUtils extends BaseWidgetUtils {

    @NotNull
    public static final String BLACK_THEME_FILE_NAME = "_black.png";

    @NotNull
    public static final String CACHE_DATA_FILE_NAME = "widgetCache.dat";

    @NotNull
    private static final String TAG = "WidgetUtils";

    @NotNull
    public static final String WHITE_THEME_FILE_NAME = "_white.png";

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);
    public static final int $stable = 8;

    @NotNull
    private static final String WIDGET_CACHE_FOLDER_NAME = AbstractC0541b.m772n("widgetCache", File.separator);

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000v\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\r\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0018\u0010\n\u001a\u00020\u00052\b\u0010\u000b\u001a\u0004\u0018\u00010\f2\u0006\u0010\r\u001a\u00020\u0005J\u0016\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\u0010\u001a\u00020\u0011J\u0016\u0010\u0012\u001a\u00020\u000f2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\u0010\u001a\u00020\u0011J$\u0010\u0013\u001a\u000e\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\u000f0\u00142\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\u0010\u001a\u00020\u0011H\u0007J\u0018\u0010\u0015\u001a\u00020\u000f2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\u0016\u001a\u00020\u000fH\u0007J\u0016\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u0005J\u0018\u0010\u0019\u001a\u00020\u00052\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u0005H\u0002J\"\u0010\u001a\u001a\u00020\u00052\b\u0010\u001b\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u001c\u001a\u00020\u00112\u0006\u0010\u001d\u001a\u00020\u001eH\u0002J\u001e\u0010\u001f\u001a\u00020\u00052\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010 \u001a\u00020\u00052\u0006\u0010\r\u001a\u00020\u0005J2\u0010!\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u000b\u001a\u00020\f2\b\u0010\"\u001a\u0004\u0018\u00010#2\u0006\u0010\r\u001a\u00020\u00052\u0006\u0010$\u001a\u00020\u00112\u0006\u0010\u001d\u001a\u00020\u001eJ\u001c\u0010%\u001a\u0004\u0018\u00010\u00052\b\u0010\"\u001a\u0004\u0018\u00010#2\b\u0010&\u001a\u0004\u0018\u00010\u0005J8\u0010'\u001a\u00020\u00052\u0006\u0010\u000b\u001a\u00020\f2\b\u0010\r\u001a\u0004\u0018\u00010\u00052\u0006\u0010$\u001a\u00020\u00112\u0006\u0010\u001d\u001a\u00020\u001e2\u0006\u0010(\u001a\u00020\u00112\u0006\u0010)\u001a\u00020\u0011J\u0012\u0010*\u001a\u0004\u0018\u00010#2\b\u0010+\u001a\u0004\u0018\u00010\u0005J\u0018\u0010,\u001a\u00020\u00052\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u0005H\u0002J\u0018\u0010-\u001a\u00020\u00052\b\u0010\u000b\u001a\u0004\u0018\u00010\f2\u0006\u0010\r\u001a\u00020\u0005J(\u0010.\u001a\u00020\u00112\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010/\u001a\u00020\u00112\u0006\u00100\u001a\u00020\u001e2\u0006\u00101\u001a\u00020\u001eH\u0007J(\u00102\u001a\u00020\u001e2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010/\u001a\u00020\u00112\u0006\u00100\u001a\u00020\u001e2\u0006\u00101\u001a\u00020\u001eH\u0007J(\u00103\u001a\u00020\u001e2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010/\u001a\u00020\u00112\u0006\u00100\u001a\u00020\u001e2\u0006\u00101\u001a\u00020\u001eH\u0007J\u0018\u00104\u001a\u00020\u001e2\u0006\u0010\u000b\u001a\u00020\f2\b\u0010\r\u001a\u0004\u0018\u00010\u0005J\u001a\u00108\u001a\u00020\u00182\u0006\u0010\u000b\u001a\u00020\f2\b\b\u0002\u00109\u001a\u00020\u0011H\u0007J\u0010\u0010:\u001a\u00020\u00182\u0006\u0010\u000b\u001a\u00020\fH\u0007J\u0018\u0010:\u001a\u00020\u00182\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010;\u001a\u00020\u0005H\u0007J\u0010\u0010<\u001a\u00020\u00182\u0006\u0010\u000b\u001a\u00020\fH\u0007J\u0010\u0010=\u001a\u00020\u001e2\u0006\u0010>\u001a\u00020\u0011H\u0007J\"\u0010B\u001a\u00020\u00052\b\u0010\u000b\u001a\u0004\u0018\u00010\f2\b\u0010C\u001a\u0004\u0018\u00010D2\u0006\u0010>\u001a\u00020\u0011J\u001a\u0010E\u001a\u0004\u0018\u00010F2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010G\u001a\u00020HH\u0007J\u0010\u0010I\u001a\u00020\u00052\u0006\u0010J\u001a\u00020KH\u0007J\u0018\u0010L\u001a\u00020F2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010M\u001a\u00020FH\u0002J\u0010\u0010N\u001a\u00020F2\u0006\u0010O\u001a\u00020FH\u0002J\u0010\u0010P\u001a\u00020F2\u0006\u0010Q\u001a\u00020FH\u0002J\u0010\u0010R\u001a\u00020F2\u0006\u0010Q\u001a\u00020FH\u0002J*\u0010S\u001a\u00020F2\u0006\u0010\u000b\u001a\u00020\f2\b\u0010T\u001a\u0004\u0018\u00010U2\u0006\u0010V\u001a\u00020F2\u0006\u0010W\u001a\u00020KH\u0002J\u0010\u0010X\u001a\u00020\u001e2\u0006\u0010\u000b\u001a\u00020\fH\u0007J\f\u0010Y\u001a\u00020\u001e*\u00020ZH\u0003J\f\u0010[\u001a\u00020\u001e*\u00020ZH\u0003R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u00105\u001a\u00020\u001e8FX\u0087\u0004¢\u0006\f\u0012\u0004\b6\u0010\u0003\u001a\u0004\b5\u00107R\u0011\u0010?\u001a\u00020\u00118F¢\u0006\u0006\u001a\u0004\b@\u0010A¨\u0006\\"}, m13886d2 = {"Lcom/samsung/android/app/notes/widget/util/WidgetUtils$Companion;", "", "<init>", "()V", SearchConstants.TargetContents.TAG, "", "CACHE_DATA_FILE_NAME", "BLACK_THEME_FILE_NAME", "WHITE_THEME_FILE_NAME", "WIDGET_CACHE_FOLDER_NAME", "createCacheFilePath", "context", "Landroid/content/Context;", "uuid", "getWidgetWidth", "", BaseWidgetConstant.EXTRA_KEY_FROM_WIDGET_ID, "", "getWidgetHeight", "getWidgetSizeF", "Lkotlin/Pair;", "dipToPixels", "dipValue", "removeCacheFiles", "", "createCacheDir", "getCacheFilePath", "cacheDir", "index", "isDarkMode", "", "getWidgetCacheFilePath", "fileName", "saveCaptureBitmap", "bitmap", "Landroid/graphics/Bitmap;", "page", "saveCaptureTextOnlyBitmap", "path", "getCacheTextOnlyFilePath", "width", "orientation", "getCacheThumbnailFile", "filePath", "getCacheUuidPath", "getCacheDataFilePath", "getWidgetBgThemeColor", "color", "backgroundImage", "settingDarkTheme", "isWidgetBgDarkThemeColor", "isWidgetTitleDarkThemeColor", "isSDoc", "isSupportSettingByQuickOption", "isSupportSettingByQuickOption$annotations", "()Z", "showWidgetMaximumToast", VElementFormulasCmd.FMAX, "showWidgetAlreadyPinToast", "msg", "showWidgetAlreadyPinOnCoverToast", "needReverseColor", "widgetId", "emptyWidgetAlpha", "getEmptyWidgetAlpha", "()I", "printWidgetOptions", "bundle", "Landroid/os/Bundle;", "getRecommendTitleText", "", "mainListDocumentData", "Lcom/samsung/android/support/senl/nt/data/database/core/document/data/MainListDocumentData;", "getTitleTime", "createdAt", "", "getTextContentTitle", "textContent", "removeNewline", "title", "removeStrikethroughSpan", "text", "removeZeroWidthSpace", "getRecommendedTitle", "recommendedType", "Lcom/samsung/android/support/senl/nt/model/document/save/autotitle/AutoTitleCreator$CreationPriority;", DBSchema.Document.RECOMMENDED_TITLE, GroupContract.Group.CREATED_TIME, "isDarkWallpaperOneUi7x", "isDark1", "Landroid/app/WallpaperColors;", "isDark2", "ntHomeWidget_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
    @SourceDebugExtension({"SMAP\nWidgetUtils.kt\nKotlin\n*S Kotlin\n*F\n+ 1 WidgetUtils.kt\ncom/samsung/android/app/notes/widget/util/WidgetUtils$Companion\n+ 2 Strings.kt\nkotlin/text/StringsKt__StringsKt\n+ 3 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n+ 4 ArraysJVM.kt\nkotlin/collections/ArraysKt__ArraysJVMKt\n*L\n1#1,408:1\n108#2:409\n80#2,22:410\n739#3,9:432\n37#4:441\n36#4,3:442\n*S KotlinDebug\n*F\n+ 1 WidgetUtils.kt\ncom/samsung/android/app/notes/widget/util/WidgetUtils$Companion\n*L\n320#1:409\n320#1:410,22\n331#1:432,9\n331#1:441\n331#1:442,3\n*E\n"})
    public static final class Companion {

        /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
        @Metadata(m13887k = 3, m13888mv = {2, 1, 0}, m13890xi = 48)
        public /* synthetic */ class WhenMappings {
            public static final /* synthetic */ int[] $EnumSwitchMapping$0;

            static {
                int[] iArr = new int[AutoTitleCreator.CreationPriority.values().length];
                try {
                    iArr[AutoTitleCreator.CreationPriority.RECORDING.ordinal()] = 1;
                } catch (NoSuchFieldError unused) {
                }
                try {
                    iArr[AutoTitleCreator.CreationPriority.IMAGE.ordinal()] = 2;
                } catch (NoSuchFieldError unused2) {
                }
                try {
                    iArr[AutoTitleCreator.CreationPriority.DRAWING.ordinal()] = 3;
                } catch (NoSuchFieldError unused3) {
                }
                $EnumSwitchMapping$0 = iArr;
            }
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private final String createCacheDir(Context context, String uuid) {
            String cacheDirPath = FileUtils.INSTANCE.getCacheDirPath(context);
            String str = File.separator;
            StringBuilder sb = new StringBuilder(AbstractC0541b.m757C(cacheDirPath, str, WidgetUtils.WIDGET_CACHE_FOLDER_NAME));
            String string = sb.toString();
            Intrinsics.checkNotNullExpressionValue(string, "toString(...)");
            FileUtils.makeDirectory(string);
            sb.append(StringsKt.m14139M(uuid, CacheKeyValueDelegate.CACHE_VALUE_SEPARATOR, "_"));
            sb.append(str);
            String string2 = sb.toString();
            Intrinsics.checkNotNullExpressionValue(string2, "toString(...)");
            FileUtils.makeDirectory(string2);
            String string3 = sb.toString();
            Intrinsics.checkNotNullExpressionValue(string3, "toString(...)");
            return string3;
        }

        private final String getCacheFilePath(String cacheDir, int index, boolean isDarkMode) {
            if (isDarkMode) {
                return cacheDir + index + WidgetUtils.BLACK_THEME_FILE_NAME;
            }
            return cacheDir + index + WidgetUtils.WHITE_THEME_FILE_NAME;
        }

        private final String getCacheUuidPath(Context context, String uuid) {
            String cacheDirPath = FileUtils.INSTANCE.getCacheDirPath(context);
            String str = File.separator;
            return AbstractC2322a.m1622l(cacheDirPath, str, WidgetUtils.WIDGET_CACHE_FOLDER_NAME, StringsKt.m14139M(uuid, CacheKeyValueDelegate.CACHE_VALUE_SEPARATOR, "_"), str);
        }

        private final CharSequence getRecommendedTitle(Context context, AutoTitleCreator.CreationPriority recommendedType, CharSequence recommendedTitle, long createdTime) {
            if (recommendedType != null) {
                int i = WhenMappings.$EnumSwitchMapping$0[recommendedType.ordinal()];
                if (i == 1) {
                    String string = context.getString(C11391R.string.base_title_voice_recording_ps, getTitleTime(createdTime));
                    Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
                    return string;
                }
                if (i == 2) {
                    String string2 = context.getString(C11391R.string.base_title_image_ps, getTitleTime(createdTime));
                    Intrinsics.checkNotNullExpressionValue(string2, "getString(...)");
                    return string2;
                }
                if (i == 3) {
                    String string3 = context.getString(C11391R.string.base_title_drawing_ps, getTitleTime(createdTime));
                    Intrinsics.checkNotNullExpressionValue(string3, "getString(...)");
                    return string3;
                }
            }
            return recommendedTitle;
        }

        private final CharSequence getTextContentTitle(Context context, CharSequence textContent) {
            if (textContent.length() > 300) {
                textContent = textContent.subSequence(0, 300);
            }
            CharSequence charSequenceRemoveStrikethroughSpan = removeStrikethroughSpan(textContent);
            if (StringsKt.m14162r(charSequenceRemoveStrikethroughSpan.toString(), "\u200b")) {
                charSequenceRemoveStrikethroughSpan = removeZeroWidthSpace(charSequenceRemoveStrikethroughSpan);
            }
            String strM14139M = StringsKt.m14139M(charSequenceRemoveStrikethroughSpan.toString(), "\n", "");
            int length = strM14139M.length() - 1;
            int i = 0;
            boolean z = false;
            while (i <= length) {
                boolean z2 = Intrinsics.compare((int) strM14139M.charAt(!z ? i : length), 32) <= 0;
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
            if (!TextUtils.isEmpty(strM14139M.subSequence(i, length + 1).toString())) {
                return charSequenceRemoveStrikethroughSpan;
            }
            String string = context.getString(C11391R.string.base_title_no_title);
            Intrinsics.checkNotNull(string);
            return string;
        }

        @RequiresApi(27)
        private final boolean isDark1(WallpaperColors wallpaperColors) {
            int argb = wallpaperColors.getPrimaryColor().toArgb();
            int iRed = Color.red(argb);
            return AbstractC1974b.m1308a((double) Color.blue(argb), 0.114d, (((double) Color.green(argb)) * 0.587d) + (((double) iRed) * 0.299d), 255.0d) < 0.5d;
        }

        @RequiresApi(31)
        private final boolean isDark2(WallpaperColors wallpaperColors) {
            int colorHints = wallpaperColors.getColorHints();
            return (colorHints & 1) == 0 || (colorHints & 2) != 0;
        }

        @JvmStatic
        public static /* synthetic */ void isSupportSettingByQuickOption$annotations() {
        }

        private final CharSequence removeNewline(CharSequence title) {
            List listEmptyList;
            if (!StringsKt.m14162r(title.toString(), "\n")) {
                return title;
            }
            List listM13999t = AbstractC12991c.m13999t(0, "\n", title.toString());
            if (listM13999t.isEmpty()) {
                listEmptyList = CollectionsKt.emptyList();
            } else {
                ListIterator listIterator = listM13999t.listIterator(listM13999t.size());
                while (listIterator.hasPrevious()) {
                    if (((String) listIterator.previous()).length() != 0) {
                        listEmptyList = AbstractC12991c.m14000u(listIterator, 1, listM13999t);
                        break;
                    }
                }
                listEmptyList = CollectionsKt.emptyList();
            }
            return title.subSequence(0, ((String[]) listEmptyList.toArray(new String[0]))[0].length());
        }

        private final CharSequence removeStrikethroughSpan(CharSequence text) {
            SpannableString spannableString = new SpannableString(text);
            Iterator it = ArrayIteratorKt.iterator((StrikethroughSpan[]) spannableString.getSpans(0, spannableString.length(), StrikethroughSpan.class));
            while (it.hasNext()) {
                spannableString.removeSpan((StrikethroughSpan) it.next());
            }
            return spannableString;
        }

        private final CharSequence removeZeroWidthSpace(CharSequence text) {
            Pattern patternCompile = Pattern.compile("\u200b", 64);
            SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(text);
            Matcher matcher = patternCompile.matcher(text);
            int i = 0;
            while (matcher.find()) {
                spannableStringBuilder.delete(matcher.start() - i, matcher.end() - i);
                i++;
            }
            return spannableStringBuilder;
        }

        public static /* synthetic */ void showWidgetMaximumToast$default(Companion companion, Context context, int i, int i2, Object obj) {
            if ((i2 & 2) != 0) {
                i = DeviceUtils.isOldSepLiteModel() ? 3 : 20;
            }
            companion.showWidgetMaximumToast(context, i);
        }

        @NotNull
        public final String createCacheFilePath(@Nullable Context context, @NotNull String uuid) {
            Intrinsics.checkNotNullParameter(uuid, "uuid");
            StringBuilder sb = new StringBuilder(AbstractC0541b.m757C(FileUtils.INSTANCE.getCacheDirPath(context), File.separator, WidgetUtils.WIDGET_CACHE_FOLDER_NAME));
            sb.append(StringsKt.m14139M(uuid, CacheKeyValueDelegate.CACHE_VALUE_SEPARATOR, "_"));
            Logger.m8697d(WidgetUtils.TAG, "createCacheFilePath : " + ((Object) sb));
            String string = sb.toString();
            Intrinsics.checkNotNullExpressionValue(string, "toString(...)");
            return string;
        }

        @JvmStatic
        public final float dipToPixels(@NotNull Context context, float dipValue) {
            Intrinsics.checkNotNullParameter(context, "context");
            Object systemService = context.getSystemService("display");
            Intrinsics.checkNotNull(systemService, "null cannot be cast to non-null type android.hardware.display.DisplayManager");
            return TypedValue.applyDimension(1, dipValue, context.createDisplayContext(((DisplayManager) systemService).getDisplays()[0]).getResources().getDisplayMetrics());
        }

        @NotNull
        public final String getCacheDataFilePath(@Nullable Context context, @NotNull String uuid) {
            Intrinsics.checkNotNullParameter(uuid, "uuid");
            String cacheDirPath = FileUtils.INSTANCE.getCacheDirPath(context);
            String str = File.separator;
            StringBuilder sbM2228s = AbstractC2821a.m2228s(cacheDirPath, str, WidgetUtils.WIDGET_CACHE_FOLDER_NAME, StringsKt.m14139M(uuid, CacheKeyValueDelegate.CACHE_VALUE_SEPARATOR, "_"), str);
            sbM2228s.append(WidgetUtils.CACHE_DATA_FILE_NAME);
            return sbM2228s.toString();
        }

        @NotNull
        public final String getCacheTextOnlyFilePath(@NotNull Context context, @Nullable String uuid, int page, boolean isDarkMode, int width, int orientation) {
            Intrinsics.checkNotNullParameter(context, "context");
            String str = createCacheDir(context, String.valueOf(uuid)) + width + "_" + orientation + "_";
            if (isDarkMode) {
                return str + page + WidgetUtils.BLACK_THEME_FILE_NAME;
            }
            return str + page + WidgetUtils.WHITE_THEME_FILE_NAME;
        }

        @Nullable
        public final Bitmap getCacheThumbnailFile(@Nullable String filePath) {
            if (FileUtils.exists(String.valueOf(filePath))) {
                return BitmapFactory.decodeFile(filePath);
            }
            return null;
        }

        public final int getEmptyWidgetAlpha() {
            return 0;
        }

        /* JADX WARN: Removed duplicated region for block: B:18:0x008c  */
        /* JADX WARN: Removed duplicated region for block: B:20:0x0098 A[RETURN] */
        @JvmStatic
        @Nullable
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public final CharSequence getRecommendTitleText(@NotNull Context context, @NotNull MainListDocumentData mainListDocumentData) {
            Context context2;
            CharSequence string;
            Intrinsics.checkNotNullParameter(context, "context");
            Intrinsics.checkNotNullParameter(mainListDocumentData, "mainListDocumentData");
            String recommendedTitle = mainListDocumentData.getRecommendedTitle();
            Intrinsics.checkNotNullExpressionValue(recommendedTitle, "getRecommendedTitle(...)");
            AutoTitleCreator.CreationPriority creationPriorityFind = AutoTitleCreator.CreationPriority.find(recommendedTitle.toString());
            if (mainListDocumentData.getIsLock() == 5) {
                string = context.getString(C11391R.string.base_title_lock_note);
                Intrinsics.checkNotNull(string);
            } else {
                if (TextUtils.isEmpty(mainListDocumentData.getStrokeUuid())) {
                    if (TextUtils.isEmpty(recommendedTitle)) {
                        context2 = context;
                        if (TextUtils.isEmpty(mainListDocumentData.getContent())) {
                            string = context2.getString(C11391R.string.base_title_no_title);
                            Intrinsics.checkNotNull(string);
                        } else {
                            String content = mainListDocumentData.getContent();
                            Intrinsics.checkNotNullExpressionValue(content, "getContent(...)");
                            string = removeNewline(getTextContentTitle(context2, content));
                        }
                    } else {
                        context2 = context;
                        string = getRecommendedTitle(context2, creationPriorityFind, recommendedTitle, mainListDocumentData.getCreatedAt());
                    }
                    if (TextUtils.isEmpty(string)) {
                        return string;
                    }
                    String string2 = context2.getString(C11391R.string.base_title_no_title);
                    Intrinsics.checkNotNullExpressionValue(string2, "getString(...)");
                    return string2;
                }
                string = context.getString(C11391R.string.base_title_handwritten_note_ps, getTitleTime(mainListDocumentData.getCreatedAt()));
                Intrinsics.checkNotNull(string);
            }
            context2 = context;
            if (TextUtils.isEmpty(string)) {
            }
        }

        @JvmStatic
        @NotNull
        public final String getTitleTime(long createdAt) {
            return LocaleUtils.getTitleTime(createdAt);
        }

        @JvmStatic
        public final int getWidgetBgThemeColor(@NotNull Context context, int color, boolean backgroundImage, boolean settingDarkTheme) {
            Intrinsics.checkNotNullParameter(context, "context");
            return (color == ContextCompat.getColor(context, C11391R.color.widget_note_page_color_light) && settingDarkTheme && !backgroundImage) ? ContextCompat.getColor(context, C11391R.color.widget_bg_color_black) : (color == ContextCompat.getColor(context, C11391R.color.widget_note_page_color_dark) || !settingDarkTheme) ? color : ColorUtils.blendARGB(color, -16777216, 0.1f);
        }

        @NotNull
        public final String getWidgetCacheFilePath(@NotNull Context context, @NotNull String fileName, @NotNull String uuid) {
            Intrinsics.checkNotNullParameter(context, "context");
            Intrinsics.checkNotNullParameter(fileName, "fileName");
            Intrinsics.checkNotNullParameter(uuid, "uuid");
            return AbstractC0541b.m757C(createCacheDir(context, uuid), fileName, ".sdocx");
        }

        public final float getWidgetHeight(@NotNull Context context, int appWidgetId) {
            Intrinsics.checkNotNullParameter(context, "context");
            AppWidgetManager appWidgetManager = AppWidgetManager.getInstance(context);
            Resources resources = context.getResources();
            Bundle appWidgetOptions = appWidgetManager.getAppWidgetOptions(appWidgetId);
            return resources.getConfiguration().orientation == 1 ? appWidgetOptions.getInt("appWidgetMinHeight") : appWidgetOptions.getInt("appWidgetMaxHeight");
        }

        @RequiresApi(31)
        @NotNull
        public final Pair<Float, Float> getWidgetSizeF(@NotNull Context context, int appWidgetId) {
            Intrinsics.checkNotNullParameter(context, "context");
            ArrayList parcelableArrayList = AppWidgetManager.getInstance(context).getAppWidgetOptions(appWidgetId).getParcelableArrayList("appWidgetSizes");
            SizeF sizeF = parcelableArrayList != null ? (SizeF) CollectionsKt.first((List) parcelableArrayList) : null;
            return sizeF != null ? new Pair<>(Float.valueOf(sizeF.getWidth()), Float.valueOf(sizeF.getHeight())) : new Pair<>(0, 0);
        }

        public final float getWidgetWidth(@NotNull Context context, int appWidgetId) {
            Intrinsics.checkNotNullParameter(context, "context");
            AppWidgetManager appWidgetManager = AppWidgetManager.getInstance(context);
            Resources resources = context.getResources();
            Bundle appWidgetOptions = appWidgetManager.getAppWidgetOptions(appWidgetId);
            return resources.getConfiguration().orientation == 1 ? appWidgetOptions.getInt("appWidgetMinWidth") : appWidgetOptions.getInt("appWidgetMaxWidth");
        }

        @RequiresApi(27)
        public final boolean isDarkWallpaperOneUi7x(@NotNull Context context) {
            Intrinsics.checkNotNullParameter(context, "context");
            WallpaperColors wallpaperColors = WallpaperManager.getInstance(context).getWallpaperColors(1);
            if (wallpaperColors != null) {
                return isDark1(wallpaperColors);
            }
            return false;
        }

        public final boolean isSDoc(@NotNull Context context, @Nullable String uuid) {
            Intrinsics.checkNotNullParameter(context, "context");
            MainListDocumentData mainListDocumentData = NotesDataRepositoryFactory.newInstance(context).createMainListDocumentDataRepository().get(String.valueOf(uuid));
            return mainListDocumentData != null && mainListDocumentData.isSDoc();
        }

        public final boolean isSupportSettingByQuickOption() {
            Logger.m8697d(WidgetUtils.TAG, "isSupportSettingByQuickOption : " + (DeviceInfo.isSemDevice() && Build.VERSION.SDK_INT > 27));
            return DeviceInfo.isSemDevice() && Build.VERSION.SDK_INT > 27;
        }

        @JvmStatic
        public final boolean isWidgetBgDarkThemeColor(@NotNull Context context, int color, boolean backgroundImage, boolean settingDarkTheme) {
            Intrinsics.checkNotNullParameter(context, "context");
            return color == ContextCompat.getColor(context, C11391R.color.widget_note_page_color_light) && settingDarkTheme && !backgroundImage;
        }

        @JvmStatic
        public final boolean isWidgetTitleDarkThemeColor(@NotNull Context context, int color, boolean backgroundImage, boolean settingDarkTheme) {
            Intrinsics.checkNotNullParameter(context, "context");
            int color2 = ContextCompat.getColor(context, C11391R.color.widget_note_page_color_dark);
            int color3 = ContextCompat.getColor(context, C11391R.color.widget_bg_color_black);
            int widgetBgThemeColor = getWidgetBgThemeColor(context, color, backgroundImage, settingDarkTheme);
            return widgetBgThemeColor == color2 || widgetBgThemeColor == color3;
        }

        @JvmStatic
        public final boolean needReverseColor(int widgetId) {
            return !BaseWidgetPreferenceManager.INSTANCE.isReverseTransparency(widgetId);
        }

        @NotNull
        public final String printWidgetOptions(@Nullable Context context, @Nullable Bundle bundle, int widgetId) {
            if (bundle == null) {
                bundle = AppWidgetManager.getInstance(context).getAppWidgetOptions(widgetId);
            }
            StringBuilder sb = new StringBuilder();
            Set<String> setKeySet = bundle != null ? bundle.keySet() : null;
            Intrinsics.checkNotNull(setKeySet);
            for (String str : setKeySet) {
                if (bundle.get(str) != null) {
                    sb.append(str);
                    sb.append(MarketingConstants.REFERRER_DELIMITER_U003D);
                    sb.append(String.valueOf(bundle.get(str)));
                    sb.append(SQLKeyword.COMMA);
                }
            }
            String string = sb.toString();
            Intrinsics.checkNotNullExpressionValue(string, "toString(...)");
            return string;
        }

        public final void removeCacheFiles(@NotNull Context context, @NotNull String uuid) {
            Intrinsics.checkNotNullParameter(context, "context");
            Intrinsics.checkNotNullParameter(uuid, "uuid");
            try {
                FileUtils.deleteFile(new File(getCacheUuidPath(context, uuid)));
            } catch (IOException e) {
                Logger.m8699e(WidgetUtils.TAG, "removeCacheFile. " + e.getMessage(), e);
            }
            AbstractC4539a.m3188B("removeCacheFile. ", uuid, WidgetUtils.TAG);
        }

        @Nullable
        public final String saveCaptureBitmap(@NotNull Context context, @Nullable Bitmap bitmap, @NotNull String uuid, int page, boolean isDarkMode) {
            Intrinsics.checkNotNullParameter(context, "context");
            Intrinsics.checkNotNullParameter(uuid, "uuid");
            Logger.m8697d(WidgetUtils.TAG, "saveCaptureBitmap# start");
            String cacheFilePath = getCacheFilePath(createCacheDir(context, uuid), page, isDarkMode);
            if (!ImageUtils.make(bitmap, new File(cacheFilePath), 100, Bitmap.CompressFormat.PNG)) {
                cacheFilePath = null;
            }
            Logger.m8697d(WidgetUtils.TAG, "saveCaptureBitmap# end");
            return cacheFilePath;
        }

        @Nullable
        public final String saveCaptureTextOnlyBitmap(@Nullable Bitmap bitmap, @Nullable String path) {
            Logger.m8697d(WidgetUtils.TAG, "saveCaptureBitmap# start");
            if (path != null && !ImageUtils.make(bitmap, new File(path), 100, Bitmap.CompressFormat.PNG)) {
                path = null;
            }
            Logger.m8697d(WidgetUtils.TAG, "saveCaptureBitmap# end");
            return path;
        }

        @JvmStatic
        public final void showWidgetAlreadyPinOnCoverToast(@NotNull Context context) {
            Intrinsics.checkNotNullParameter(context, "context");
            String string = context.getResources().getString(C11391R.string.widget_already_saved_on_cover_screen);
            Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
            ToastHandler.show(context, string, 1);
        }

        @JvmStatic
        public final void showWidgetAlreadyPinToast(@NotNull Context context) {
            Intrinsics.checkNotNullParameter(context, "context");
            String string = context.getResources().getString(C11391R.string.widget_already_saved);
            Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
            ToastHandler.show(context, string, 1);
        }

        @JvmOverloads
        public final void showWidgetMaximumToast(@NotNull Context context) {
            Intrinsics.checkNotNullParameter(context, "context");
            showWidgetMaximumToast$default(this, context, 0, 2, null);
        }

        private Companion() {
        }

        @JvmOverloads
        public final void showWidgetMaximumToast(@NotNull Context context, int max) {
            Intrinsics.checkNotNullParameter(context, "context");
            String string = context.getResources().getString(C11391R.string.widget_maximum_notification, Integer.valueOf(max));
            Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
            ToastHandler.show(context, string, 1);
        }

        @JvmStatic
        public final void showWidgetAlreadyPinToast(@NotNull Context context, @NotNull String msg) {
            Intrinsics.checkNotNullParameter(context, "context");
            Intrinsics.checkNotNullParameter(msg, "msg");
            ToastHandler.show(context, msg, 1);
        }
    }

    @JvmStatic
    public static final float dipToPixels(@NotNull Context context, float f) {
        return INSTANCE.dipToPixels(context, f);
    }

    @JvmStatic
    @Nullable
    public static final CharSequence getRecommendTitleText(@NotNull Context context, @NotNull MainListDocumentData mainListDocumentData) {
        return INSTANCE.getRecommendTitleText(context, mainListDocumentData);
    }

    @JvmStatic
    @NotNull
    public static final String getTitleTime(long j) {
        return INSTANCE.getTitleTime(j);
    }

    @JvmStatic
    public static final int getWidgetBgThemeColor(@NotNull Context context, int i, boolean z, boolean z2) {
        return INSTANCE.getWidgetBgThemeColor(context, i, z, z2);
    }

    public static final boolean isSupportSettingByQuickOption() {
        return INSTANCE.isSupportSettingByQuickOption();
    }

    @JvmStatic
    public static final boolean isWidgetBgDarkThemeColor(@NotNull Context context, int i, boolean z, boolean z2) {
        return INSTANCE.isWidgetBgDarkThemeColor(context, i, z, z2);
    }

    @JvmStatic
    public static final boolean isWidgetTitleDarkThemeColor(@NotNull Context context, int i, boolean z, boolean z2) {
        return INSTANCE.isWidgetTitleDarkThemeColor(context, i, z, z2);
    }

    @JvmStatic
    public static final boolean needReverseColor(int i) {
        return INSTANCE.needReverseColor(i);
    }

    @JvmStatic
    public static final void showWidgetAlreadyPinOnCoverToast(@NotNull Context context) {
        INSTANCE.showWidgetAlreadyPinOnCoverToast(context);
    }

    @JvmStatic
    public static final void showWidgetAlreadyPinToast(@NotNull Context context) {
        INSTANCE.showWidgetAlreadyPinToast(context);
    }

    @JvmStatic
    public static final void showWidgetAlreadyPinToast(@NotNull Context context, @NotNull String str) {
        INSTANCE.showWidgetAlreadyPinToast(context, str);
    }
}
