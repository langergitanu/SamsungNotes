package com.samsung.android.support.senl.p148nt.base.common.displaydata;

import android.content.Context;
import android.content.res.Resources;
import android.text.TextUtils;
import android.text.format.DateFormat;
import android.text.format.DateUtils;
import androidx.appcompat.widget.AbstractC0541b;
import com.google.android.gms.common.data.AbstractC4539a;
import com.nimbusds.jose.HeaderParameterNames;
import com.samsung.android.scs.p140ai.sdkcommon.text.TextConst;
import com.samsung.android.sdk.pen.document.SpenObjectShape;
import com.samsung.android.sdk.pen.document.textspan.SpenBulletParagraph;
import com.samsung.android.sdk.pen.document.textspan.SpenIndentLevelParagraph;
import com.samsung.android.sdk.pen.document.textspan.SpenTextParagraphBase;
import com.samsung.android.support.senl.document.memoconverter.core.SNBUtils.vml.vector.shape.pathdata.VPathDataCmd;
import com.samsung.android.support.senl.p145cm.base.common.util.LocaleUtils;
import com.samsung.android.support.senl.p145cm.base.framework.content.SharedPreferencesCompat;
import com.samsung.android.support.senl.p145cm.base.framework.support.BaseUtils;
import com.samsung.android.support.senl.p148nt.base.C8875R;
import com.samsung.android.support.senl.p148nt.base.common.constants.Constants;
import com.samsung.android.support.senl.p148nt.base.common.util.ModelFeature;
import com.samsung.android.support.senl.p148nt.data.common.constants.SearchConstants;
import com.samsung.android.support.senl.p148nt.data.database.core.schema.DBSchema;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Locale;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import p001A.AbstractC0000a;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes2.dex */
@Metadata(m13885d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u000e\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0014\n\u0002\u0018\u0002\n\u0002\b\u0004\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\u0012\u001a\u00020\u00052\u0006\u0010\u0013\u001a\u00020\bH\u0007J\u0010\u0010\u0014\u001a\u00020\u00052\u0006\u0010\u0015\u001a\u00020\u0005H\u0007J\u0018\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\b2\u0006\u0010\u0019\u001a\u00020\u0017H\u0007J\u0018\u0010\u001a\u001a\u00020\u00172\u0006\u0010\u001b\u001a\u00020\u00172\u0006\u0010\u001c\u001a\u00020\bH\u0007J\u001a\u0010\u001d\u001a\u00020\u00052\b\u0010\u001e\u001a\u0004\u0018\u00010\u001f2\u0006\u0010 \u001a\u00020!H\u0007J\u000e\u0010\"\u001a\u00020\u00052\u0006\u0010 \u001a\u00020!J\u0010\u0010#\u001a\u00020\u00172\u0006\u0010 \u001a\u00020!H\u0002J\u0010\u0010$\u001a\u00020\u00052\u0006\u0010%\u001a\u00020\u0005H\u0002J\u0010\u0010-\u001a\u00020\u00172\u0006\u0010'\u001a\u00020\bH\u0007J\u0010\u0010.\u001a\u00020\u00172\u0006\u0010'\u001a\u00020\bH\u0007J\u0010\u0010/\u001a\u00020\u00172\u0006\u0010'\u001a\u00020\bH\u0007J\u0018\u00100\u001a\u00020\u00052\u0006\u0010\u0013\u001a\u00020\b2\u0006\u00101\u001a\u00020\u0017H\u0007J\u0010\u00102\u001a\u00020\u00052\u0006\u0010\u0013\u001a\u00020\bH\u0007J\u0010\u00103\u001a\u00020\u00052\u0006\u00104\u001a\u00020\bH\u0007J\u0010\u00105\u001a\u0002062\u0006\u00107\u001a\u000206H\u0007J\u0018\u00108\u001a\u00020\b2\u0006\u0010\u0013\u001a\u00020\b2\u0006\u00109\u001a\u00020\bH\u0002R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\bX\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\bX\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\bX\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\bX\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\bX\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\bX\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\bX\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\bX\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\bX\u0086T¢\u0006\u0002\n\u0000R*\u0010'\u001a\u00020\b2\u0006\u0010&\u001a\u00020\b8F@FX\u0087\u000e¢\u0006\u0012\u0012\u0004\b(\u0010\u0003\u001a\u0004\b)\u0010*\"\u0004\b+\u0010,¨\u0006:"}, m13886d2 = {"Lcom/samsung/android/support/senl/nt/base/common/displaydata/ContentUtils;", "", "<init>", "()V", SearchConstants.TargetContents.TAG, "", "HASH_SYMBOL", "DARK_MODE_INVERSE_BACKGROUND_ON", "", "NUMBER_OF_BULLET_TYPES", "DIGIT", "UPPERCASE_ALPHABET", "ALPHABET", "ROMAN_NUMERAL", "SOLID_CIRCLE", "WHITE_CIRCLE", "BLACK_SQUARE", "WHITE_SQUARE", "convertToArabicNumber", TextConst.KEY_PARAM_NUMBER, "convertTagText", "hashtagName", "hasBackgroundColorNotes", "", "backgroundColor", "isSdoc", "supportInvertedBGColor", "hasBackgroundColor", DBSchema.Document.BACKGROUND_COLOR_INVERTED, "getDate", "context", "Landroid/content/Context;", "milliSeconds", "", "getDateFormat", "isThisYear", "changeTimeAccordingToLocale", "time", "viewBy", "viewMode", "getViewMode$annotations", "getViewMode", "()I", "setViewMode", "(I)V", "isGridViewMode", "isSimpleViewMode", "isListViewMode", "convertAlphabet", "uppercase", "convertRomanNumeral", "convertBulletChar", "bulletType", "convertBulletTypeBasedOnIndentLevel", "Lcom/samsung/android/sdk/pen/document/SpenObjectShape;", "bodyTextBox", "bulletTypeBasedOnIndentLevel", "index", "ntBase_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
@SourceDebugExtension({"SMAP\nContentUtils.kt\nKotlin\n*S Kotlin\n*F\n+ 1 ContentUtils.kt\ncom/samsung/android/support/senl/nt/base/common/displaydata/ContentUtils\n+ 2 Locale.kt\nandroidx/core/text/LocaleKt\n*L\n1#1,249:1\n28#2:250\n*S KotlinDebug\n*F\n+ 1 ContentUtils.kt\ncom/samsung/android/support/senl/nt/base/common/displaydata/ContentUtils\n*L\n97#1:250\n*E\n"})
public final class ContentUtils {
    public static final int ALPHABET = 2;
    public static final int BLACK_SQUARE = 2;
    public static final int DARK_MODE_INVERSE_BACKGROUND_ON = 1;
    public static final int DIGIT = 0;

    @NotNull
    public static final String HASH_SYMBOL = "#";

    @NotNull
    public static final ContentUtils INSTANCE = new ContentUtils();
    public static final int NUMBER_OF_BULLET_TYPES = 4;
    public static final int ROMAN_NUMERAL = 3;
    public static final int SOLID_CIRCLE = 0;

    @NotNull
    private static final String TAG = "ContentUtils";
    public static final int UPPERCASE_ALPHABET = 1;
    public static final int WHITE_CIRCLE = 1;
    public static final int WHITE_SQUARE = 3;

    private ContentUtils() {
    }

    private final int bulletTypeBasedOnIndentLevel(int number, int index) {
        if (number != 0) {
            if (index == 0) {
                return 4;
            }
            if (index == 1) {
                return 10;
            }
            if (index == 2) {
                return 6;
            }
            if (index == 3) {
                return 7;
            }
            throw new IllegalArgumentException(AbstractC0000a.m11h(index, "Invalid index for ordered bullet type: "));
        }
        if (index == 0) {
            return 8;
        }
        if (index == 1) {
            return 9;
        }
        if (index == 2) {
            return 11;
        }
        if (index == 3) {
            return 12;
        }
        throw new IllegalArgumentException(AbstractC0000a.m11h(index, "Invalid index for unordered bullet type: "));
    }

    private final String changeTimeAccordingToLocale(String time) {
        Locale locale = Locale.getDefault();
        Intrinsics.checkNotNullExpressionValue(locale, "getDefault(...)");
        return 1 == TextUtils.getLayoutDirectionFromLocale(locale) ? AbstractC0541b.m773o("\u202a", time, "\u202c") : time;
    }

    @JvmStatic
    @NotNull
    public static final String convertAlphabet(int number, boolean uppercase) {
        int i = uppercase ? 65 : 97;
        StringBuilder sb = new StringBuilder();
        while (number > 0) {
            int i2 = number - 1;
            sb.insert(0, (char) ((i2 % 26) + i));
            number = i2 / 26;
        }
        String string = sb.toString();
        Intrinsics.checkNotNullExpressionValue(string, "toString(...)");
        return string;
    }

    @JvmStatic
    @NotNull
    public static final String convertBulletChar(int bulletType) {
        switch (bulletType) {
            case 8:
                return "•";
            case 9:
                return "◦";
            case 10:
            default:
                return "";
            case 11:
                return "▪";
            case 12:
                return "▫";
        }
    }

    @JvmStatic
    @NotNull
    public static final SpenObjectShape convertBulletTypeBasedOnIndentLevel(@NotNull SpenObjectShape bodyTextBox) {
        Intrinsics.checkNotNullParameter(bodyTextBox, "bodyTextBox");
        ArrayList<SpenTextParagraphBase> textParagraph = bodyTextBox.getTextParagraph();
        if (textParagraph != null && !textParagraph.isEmpty()) {
            ArrayList<SpenTextParagraphBase> textParagraph2 = bodyTextBox.getTextParagraph();
            Intrinsics.checkNotNull(textParagraph2);
            int size = textParagraph2.size();
            SpenIndentLevelParagraph spenIndentLevelParagraph = null;
            for (int i = 0; i < size; i++) {
                SpenTextParagraphBase spenTextParagraphBase = textParagraph2.get(i);
                Intrinsics.checkNotNullExpressionValue(spenTextParagraphBase, "get(...)");
                SpenTextParagraphBase spenTextParagraphBase2 = spenTextParagraphBase;
                if (spenTextParagraphBase2 instanceof SpenIndentLevelParagraph) {
                    spenIndentLevelParagraph = (SpenIndentLevelParagraph) spenTextParagraphBase2;
                } else if (spenTextParagraphBase2 instanceof SpenBulletParagraph) {
                    SpenBulletParagraph spenBulletParagraph = (SpenBulletParagraph) spenTextParagraphBase2;
                    if (spenBulletParagraph.getBulletType() != 2 && spenIndentLevelParagraph != null && spenIndentLevelParagraph.getIndentLevel() != 0 && spenIndentLevelParagraph.getStart() == spenTextParagraphBase2.getStart() && spenIndentLevelParagraph.getEnd() == spenTextParagraphBase2.getEnd()) {
                        spenBulletParagraph.setBulletType(INSTANCE.bulletTypeBasedOnIndentLevel(spenBulletParagraph.getBulletNumber(), spenIndentLevelParagraph.getIndentLevel() % 4));
                    }
                }
            }
            bodyTextBox.setTextParagraph(textParagraph2);
        }
        return bodyTextBox;
    }

    @JvmStatic
    @NotNull
    public static final String convertRomanNumeral(int number) {
        StringBuilder sb = new StringBuilder();
        int i = number;
        for (Pair pair : CollectionsKt.listOf((Object[]) new Pair[]{TuplesKt.m13893to(1000, "m"), TuplesKt.m13893to(900, "cm"), TuplesKt.m13893to(500, "d"), TuplesKt.m13893to(400, "cd"), TuplesKt.m13893to(100, "c"), TuplesKt.m13893to(90, "xc"), TuplesKt.m13893to(50, "l"), TuplesKt.m13893to(40, "xl"), TuplesKt.m13893to(10, "x"), TuplesKt.m13893to(9, "ix"), TuplesKt.m13893to(5, VPathDataCmd.RCurveTo), TuplesKt.m13893to(4, HeaderParameterNames.INITIALIZATION_VECTOR), TuplesKt.m13893to(1, "i")})) {
            int iIntValue = ((Number) pair.component1()).intValue();
            String str = (String) pair.component2();
            while (i >= iIntValue) {
                sb.append(str);
                i -= iIntValue;
            }
        }
        String string = sb.toString();
        Intrinsics.checkNotNullExpressionValue(string, "toString(...)");
        return string;
    }

    @JvmStatic
    @NotNull
    public static final String convertTagText(@NotNull String hashtagName) {
        Intrinsics.checkNotNullParameter(hashtagName, "hashtagName");
        return "# " + hashtagName;
    }

    @JvmStatic
    @NotNull
    public static final String convertToArabicNumber(int number) {
        return LocaleUtils.convertToArabicNumber(number);
    }

    @JvmStatic
    @NotNull
    public static final String getDate(@Nullable Context context, long milliSeconds) {
        if (!DateUtils.isToday(milliSeconds)) {
            return INSTANCE.getDateFormat(milliSeconds);
        }
        String str = DateFormat.getTimeFormat(context).format(Long.valueOf(milliSeconds));
        ContentUtils contentUtils = INSTANCE;
        Intrinsics.checkNotNull(str);
        return contentUtils.changeTimeAccordingToLocale(str);
    }

    public static final int getViewMode() {
        int i = SharedPreferencesCompat.INSTANCE.getInstance(Constants.APP_LAUNCH_PREFERENCE).getInt("view_mode", -1);
        if (i != -1) {
            if (i != 5) {
                return i;
            }
            return 2;
        }
        if (ModelFeature.getFeature().getIsDefaultViewModeSimpleList()) {
            return 3;
        }
        if (ModelFeature.getFeature().getIsDefaultViewModeGridSmall()) {
            return 4;
        }
        return ModelFeature.getFeature().needNoThumbnailSimpleList() ? 6 : 2;
    }

    @JvmStatic
    public static /* synthetic */ void getViewMode$annotations() {
    }

    @JvmStatic
    public static final boolean hasBackgroundColorNotes(int backgroundColor, boolean isSdoc) {
        Resources resources;
        if (isSdoc && (backgroundColor == -1 || backgroundColor == 0)) {
            return false;
        }
        Context applicationContext = BaseUtils.getApplicationContext();
        return (applicationContext == null || (resources = applicationContext.getResources()) == null || backgroundColor != resources.getColor(C8875R.color.base_background_color_white, null)) && backgroundColor != 0;
    }

    @JvmStatic
    public static final boolean isGridViewMode(int viewMode) {
        return 2 == viewMode || 4 == viewMode;
    }

    @JvmStatic
    public static final boolean isListViewMode(int viewMode) {
        return 1 == viewMode;
    }

    @JvmStatic
    public static final boolean isSimpleViewMode(int viewMode) {
        return 3 == viewMode || 6 == viewMode;
    }

    private final boolean isThisYear(long milliSeconds) {
        Calendar calendar = Calendar.getInstance();
        Calendar calendar2 = Calendar.getInstance();
        calendar2.setTimeInMillis(milliSeconds);
        return calendar.get(1) == calendar2.get(1);
    }

    public static final void setViewMode(int i) {
        AbstractC4539a.m3212v(i, "setViewMode : ", TAG);
        SharedPreferencesCompat.INSTANCE.getInstance(Constants.APP_LAUNCH_PREFERENCE).putInt("view_mode", i);
    }

    @JvmStatic
    public static final boolean supportInvertedBGColor(boolean hasBackgroundColor, int backgroundColorInverted) {
        return !hasBackgroundColor && backgroundColorInverted == 1;
    }

    @NotNull
    public final String getDateFormat(long milliSeconds) {
        String str = new SimpleDateFormat(DateFormat.getBestDateTimePattern(Locale.getDefault(), isThisYear(milliSeconds) ? "MMMd" : "yyyyMMMd"), Locale.getDefault()).format(Long.valueOf(milliSeconds));
        Intrinsics.checkNotNullExpressionValue(str, "format(...)");
        return str;
    }
}
