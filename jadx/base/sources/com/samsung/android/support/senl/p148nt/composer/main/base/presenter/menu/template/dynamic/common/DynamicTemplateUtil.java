package com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.template.dynamic.common;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.AssetManager;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.graphics.PointF;
import android.graphics.RectF;
import android.text.TextUtils;
import android.text.format.DateFormat;
import androidx.appcompat.widget.AbstractC0541b;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import androidx.constraintlayout.motion.widget.AbstractC2322a;
import com.samsung.android.sdk.pen.document.SpenObjectBase;
import com.samsung.android.sdk.pen.document.SpenObjectImage;
import com.samsung.android.sdk.pen.document.SpenObjectTextBox;
import com.samsung.android.sdk.pen.worddoc.SpenWPage;
import com.samsung.android.support.senl.p145cm.base.common.constants.Extension;
import com.samsung.android.support.senl.p145cm.base.framework.support.BaseUtils;
import com.samsung.android.support.senl.p148nt.base.common.constants.Constants;
import com.samsung.android.support.senl.p148nt.composer.C9086R;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.template.dynamic.common.Constant;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.template.dynamic.controller.image.ImageEffectUtil;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.template.dynamic.loader.Element;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.DayOfWeek;
import java.time.Instant;
import java.time.ZoneId;
import java.util.Collection;
import java.util.Date;
import java.util.Iterator;
import java.util.Locale;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.collections.MapsKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.jvm.internal.StringCompanionObject;
import kotlin.text.StringsKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(m13885d1 = {"\u0000\u0082\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010$\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\t\n\u0002\b\u0012\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0002\b\u0007\n\u0002\u0010\u0002\n\u0002\b\u000e\n\u0002\u0010\u001e\n\u0002\u0018\u0002\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u0005H\u0007J\u0010\u0010\r\u001a\u00020\u00052\u0006\u0010\u000e\u001a\u00020\u0005H\u0007J\u0010\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u0005H\u0007J\u0018\u0010\u0012\u001a\u00020\u00052\u0006\u0010\u0013\u001a\u00020\b2\u0006\u0010\u0014\u001a\u00020\bH\u0007J\u0010\u0010\u0015\u001a\u00020\u00102\u0006\u0010\u0016\u001a\u00020\u0017H\u0007J\u0010\u0010\u0018\u001a\u00020\u00102\u0006\u0010\u0016\u001a\u00020\u0017H\u0007J\u0018\u0010\u0019\u001a\u00020\u00052\u0006\u0010\u001a\u001a\u00020\u00052\u0006\u0010\u001b\u001a\u00020\u001cH\u0007J\u0018\u0010\u001d\u001a\u00020\u00052\u0006\u0010\u001a\u001a\u00020\u00052\u0006\u0010\u001b\u001a\u00020\u001cH\u0007J\u0018\u0010\u001e\u001a\u00020\u00052\u0006\u0010\u001a\u001a\u00020\u00052\u0006\u0010\u001b\u001a\u00020\u001cH\u0007J\u0010\u0010\u001f\u001a\u00020\u00102\u0006\u0010\u0016\u001a\u00020\u0017H\u0007J\u0012\u0010 \u001a\u00020\u00102\b\u0010\u0016\u001a\u0004\u0018\u00010\u0017H\u0007J\u0012\u0010!\u001a\u00020\u00102\b\u0010\u0016\u001a\u0004\u0018\u00010\u0017H\u0007J\u0012\u0010\"\u001a\u00020\u00102\b\u0010\u0016\u001a\u0004\u0018\u00010\u0017H\u0007J\u0012\u0010#\u001a\u00020\u00102\b\u0010\u0016\u001a\u0004\u0018\u00010\u0017H\u0007J\u0010\u0010$\u001a\u00020\u00102\u0006\u0010%\u001a\u00020\bH\u0007J\u0010\u0010&\u001a\u00020\u00102\u0006\u0010%\u001a\u00020\bH\u0007J\u0012\u0010'\u001a\u00020\u00102\b\u0010\u0016\u001a\u0004\u0018\u00010\u0017H\u0007J\u0012\u0010(\u001a\u00020\u00102\b\u0010\u0016\u001a\u0004\u0018\u00010\u0017H\u0007J\u0012\u0010)\u001a\u00020\u00102\b\u0010\u0016\u001a\u0004\u0018\u00010\u0017H\u0007J\u0010\u0010*\u001a\u00020\u00052\b\u0010\u0016\u001a\u0004\u0018\u00010\u0017J\u0010\u0010+\u001a\u00020\u00052\b\u0010\u0016\u001a\u0004\u0018\u00010\u0017J\u0010\u0010,\u001a\u00020\u00052\b\u0010\u0016\u001a\u0004\u0018\u00010\u0017J\u0012\u0010-\u001a\u00020\u00052\b\u0010\u0016\u001a\u0004\u0018\u00010\u0017H\u0002J(\u0010.\u001a\u00020/2\u0006\u00100\u001a\u0002012\u0006\u00102\u001a\u00020\b2\u0006\u00103\u001a\u00020\b2\u0006\u00104\u001a\u00020\u0010H\u0007J\u0010\u00105\u001a\u00020/2\u0006\u00106\u001a\u000207H\u0007J\u0018\u00108\u001a\u00020/2\u0006\u00106\u001a\u0002072\u0006\u00109\u001a\u00020/H\u0007J\u0018\u0010:\u001a\u00020\u00052\u0006\u00100\u001a\u0002012\u0006\u0010;\u001a\u00020\u0005H\u0007J&\u0010<\u001a\u00020=2\u0006\u0010>\u001a\u00020?2\u0006\u0010@\u001a\u00020A2\u0006\u0010B\u001a\u00020A2\u0006\u0010C\u001a\u00020AJ \u0010D\u001a\u00020E2\u0006\u0010F\u001a\u00020\b2\u0006\u0010G\u001a\u00020E2\u0006\u0010H\u001a\u00020EH\u0007J\u0012\u0010I\u001a\u00020\u00052\b\u0010\u0016\u001a\u0004\u0018\u00010\u0017H\u0007J\u0012\u0010J\u001a\u00020\u00102\b\u0010\u0016\u001a\u0004\u0018\u00010\u0017H\u0007J\u0012\u0010K\u001a\u00020\u001c2\b\u0010\u0016\u001a\u0004\u0018\u00010\u0017H\u0007J\u001a\u0010L\u001a\u00020M2\b\u0010\u0016\u001a\u0004\u0018\u00010\u00172\u0006\u0010\u001b\u001a\u00020\u001cH\u0007J\u0012\u0010N\u001a\u00020\b2\b\u0010\u0016\u001a\u0004\u0018\u00010\u0017H\u0007J\u0018\u0010O\u001a\u00020\u00052\u0006\u0010\u001b\u001a\u00020\u001c2\u0006\u0010P\u001a\u00020\u0005H\u0007J\u0010\u0010Q\u001a\u00020\u00052\u0006\u0010\u001b\u001a\u00020\u001cH\u0007J\u0010\u0010R\u001a\u00020\u00052\u0006\u0010\u001b\u001a\u00020\u001cH\u0007J\u0010\u0010S\u001a\u00020\b2\u0006\u0010T\u001a\u00020\u001cH\u0003J\u001a\u0010U\u001a\u00020\u001c2\b\u0010V\u001a\u0004\u0018\u00010\u00052\u0006\u0010P\u001a\u00020\u0005H\u0007J\u000e\u0010W\u001a\u00020\u00052\u0006\u0010X\u001a\u00020\u0005J\u000e\u0010Y\u001a\u00020\u00052\u0006\u0010X\u001a\u00020\u0005J\u0018\u0010Z\u001a\u00020\u00102\u000e\u0010[\u001a\n\u0012\u0004\u0012\u00020]\u0018\u00010\\H\u0007R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u001a\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\b0\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\t\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\b0\u0007X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006^"}, m13886d2 = {"Lcom/samsung/android/support/senl/nt/composer/main/base/presenter/menu/template/dynamic/common/DynamicTemplateUtil;", "", "<init>", "()V", "DAY_FORMAT", "", "textBoxMessagesForGenerateImage", "", "", "textBoxMessages", "getBackgroundType", "Lcom/samsung/android/support/senl/nt/composer/main/base/presenter/menu/template/dynamic/common/Constant$BackgroundType;", "src", "getExtension", "filePath", "isImageFile", "", "path", "getTemplatePath", "templateType", "templateIndex", "isDynamicTemplateObject", "objectBase", "Lcom/samsung/android/sdk/pen/document/SpenObjectBase;", "isDynamicTemplateGenerativeObject", "makeImageBoxImageId", "id", "timeInMillis", "", "makeImageBoxTextId", "makeObjectId", "hasAction", "isInsertImageActionObject", "isInsertGeneratedImageActionObject", "isRoundedMaskedImageObject", "isClippedMaskedImageObject", "isRoundedMaskType", "maskType", "isClippedMaskType", "isShowDatePickerActionObject", "isControllableObject", "isSelectableObject", "getInsertImageTargetObjectId", "getObjectId", "getGroupedObjectId", "getObjectAction", "getImageBoxDefaultData", "Landroid/graphics/Bitmap;", "context", "Landroid/content/Context;", "width", "height", "isGenerative", "getImageBoxDefaultImage", "objectImage", "Lcom/samsung/android/sdk/pen/document/SpenObjectImage;", "getImageBoxMaskedImage", "bitmap", "getXmlStringFromAssetFile", "templatePath", "convertElementRectToDocRect", "Landroid/graphics/RectF;", "element", "Lcom/samsung/android/support/senl/nt/composer/main/base/presenter/menu/template/dynamic/loader/Element;", "docPageSize", "Landroid/graphics/PointF;", "templatePageSize", TypedValues.Cycle.S_WAVE_OFFSET, "convertSizeToDocSize", "", "position", "baseSize", "realSize", "getDateTextBoxFormat", "hasDateTextBoxTimeInMillis", "getDateTextBoxTimeInMillis", "setDateTextBoxTimeInMillis", "", "getDayOfWeekTextBoxDisplayType", "convertTimeInMillisToDate", "format", "convertTimeInMillisToWeek", "convertTimeInMillisToWeekByTodayIsType", "getDayOfTheWeekValue", "milliSeconds", "convertStringToTimeInMillis", "value", "convertTextToGenerateImageMessage", "text", "convertTextToReservedMessage", "hasDynamicTemplatePage", "pages", "", "Lcom/samsung/android/sdk/pen/worddoc/SpenWPage;", "ntComposer_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
@SourceDebugExtension({"SMAP\nDynamicTemplateUtil.kt\nKotlin\n*S Kotlin\n*F\n+ 1 DynamicTemplateUtil.kt\ncom/samsung/android/support/senl/nt/composer/main/base/presenter/menu/template/dynamic/common/DynamicTemplateUtil\n+ 2 Color.kt\nandroidx/core/graphics/ColorKt\n+ 3 fake.kt\nkotlin/jvm/internal/FakeKt\n+ 4 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,453:1\n439#2:454\n1#3:455\n1869#4,2:456\n*S KotlinDebug\n*F\n+ 1 DynamicTemplateUtil.kt\ncom/samsung/android/support/senl/nt/composer/main/base/presenter/menu/template/dynamic/common/DynamicTemplateUtil\n*L\n51#1:454\n446#1:456,2\n*E\n"})
public final class DynamicTemplateUtil {

    @NotNull
    private static final String DAY_FORMAT = "EEEE";

    @NotNull
    public static final DynamicTemplateUtil INSTANCE = new DynamicTemplateUtil();

    @NotNull
    private static final Map<String, Integer> textBoxMessagesForGenerateImage = MapsKt.mapOf(new Pair("JournalAiMessage", Integer.valueOf(C9086R.string.dynamic_template_image_box_for_generative_text)));

    @NotNull
    private static final Map<String, Integer> textBoxMessages = MapsKt.mapOf(new Pair("JournalDailyNews", Integer.valueOf(C9086R.string.dynamic_template_journal_daily_news)));

    private DynamicTemplateUtil() {
    }

    @JvmStatic
    public static final float convertSizeToDocSize(int position, float baseSize, float realSize) {
        return (position * realSize) / baseSize;
    }

    @JvmStatic
    public static final long convertStringToTimeInMillis(@Nullable String value, @NotNull String format) throws ParseException {
        Intrinsics.checkNotNullParameter(format, "format");
        if (value == null) {
            return 0L;
        }
        Date date = new SimpleDateFormat(DateFormat.getBestDateTimePattern(Locale.getDefault(), format), Locale.getDefault()).parse(value);
        Long lValueOf = date != null ? Long.valueOf(date.getTime()) : null;
        if (lValueOf != null) {
            return lValueOf.longValue();
        }
        return 0L;
    }

    @JvmStatic
    @NotNull
    public static final String convertTimeInMillisToDate(long timeInMillis, @NotNull String format) {
        Intrinsics.checkNotNullParameter(format, "format");
        String str = new SimpleDateFormat(DateFormat.getBestDateTimePattern(Locale.getDefault(), format), Locale.getDefault()).format(Long.valueOf(timeInMillis));
        Intrinsics.checkNotNullExpressionValue(str, "format(...)");
        return str;
    }

    @JvmStatic
    @NotNull
    public static final String convertTimeInMillisToWeek(long timeInMillis) {
        String str = new SimpleDateFormat(DateFormat.getBestDateTimePattern(Locale.getDefault(), DAY_FORMAT), Intrinsics.areEqual(Locale.getDefault(), Locale.KOREA) ? Locale.ENGLISH : Locale.getDefault()).format(Long.valueOf(timeInMillis));
        Intrinsics.checkNotNullExpressionValue(str, "format(...)");
        String upperCase = str.toUpperCase(Locale.ROOT);
        Intrinsics.checkNotNullExpressionValue(upperCase, "toUpperCase(...)");
        return upperCase;
    }

    @JvmStatic
    @NotNull
    public static final String convertTimeInMillisToWeekByTodayIsType(long timeInMillis) {
        int dayOfTheWeekValue = getDayOfTheWeekValue(timeInMillis);
        Context context = BaseUtils.getContext();
        switch (dayOfTheWeekValue) {
            case 1:
                String string = context.getString(C9086R.string.dynamic_template_journal_6_monday);
                Intrinsics.checkNotNull(string);
                return string;
            case 2:
                String string2 = context.getString(C9086R.string.dynamic_template_journal_6_tuesday);
                Intrinsics.checkNotNull(string2);
                return string2;
            case 3:
                String string3 = context.getString(C9086R.string.dynamic_template_journal_6_wednesday);
                Intrinsics.checkNotNull(string3);
                return string3;
            case 4:
                String string4 = context.getString(C9086R.string.dynamic_template_journal_6_thursday);
                Intrinsics.checkNotNull(string4);
                return string4;
            case 5:
                String string5 = context.getString(C9086R.string.dynamic_template_journal_6_friday);
                Intrinsics.checkNotNull(string5);
                return string5;
            case 6:
                String string6 = context.getString(C9086R.string.dynamic_template_journal_6_saturday);
                Intrinsics.checkNotNull(string6);
                return string6;
            default:
                String string7 = context.getString(C9086R.string.dynamic_template_journal_6_sunday);
                Intrinsics.checkNotNull(string7);
                return string7;
        }
    }

    @JvmStatic
    @NotNull
    public static final Constant.BackgroundType getBackgroundType(@NotNull String src) {
        Intrinsics.checkNotNullParameter(src, "src");
        if (TextUtils.isEmpty(src)) {
            return Constant.BackgroundType.NONE;
        }
        try {
            Color.parseColor(src);
            return Constant.BackgroundType.COLOR;
        } catch (IllegalArgumentException unused) {
            String extension = getExtension(src);
            return Intrinsics.areEqual(extension, Constants.PDF_EXTENSION_WITH_DOT) ? Constant.BackgroundType.PDF : (StringsKt.m14162r(extension, ".jpg") || StringsKt.m14162r(extension, ".png")) ? Constant.BackgroundType.IMAGE : Constant.BackgroundType.NONE;
        }
    }

    @JvmStatic
    @NotNull
    public static final String getDateTextBoxFormat(@Nullable SpenObjectBase objectBase) {
        String extraDataString;
        return (objectBase == null || (extraDataString = objectBase.getExtraDataString(Constant.KEY_DATE_TEXT_BOX_FORMAT)) == null) ? Constant.VALUE_DEFAULT_DATE_TEXT_BOX_FORMAT : extraDataString;
    }

    @JvmStatic
    public static final long getDateTextBoxTimeInMillis(@Nullable SpenObjectBase objectBase) {
        String extraDataString = objectBase != null ? objectBase.getExtraDataString(Constant.KEY_DATE_TEXT_BOX_TIME_IN_MILLIS) : null;
        return extraDataString != null ? Long.parseLong(extraDataString) : System.currentTimeMillis();
    }

    @JvmStatic
    private static final int getDayOfTheWeekValue(long milliSeconds) {
        DayOfWeek dayOfWeek = Instant.ofEpochMilli(milliSeconds).atZone(ZoneId.systemDefault()).toLocalDate().getDayOfWeek();
        Intrinsics.checkNotNullExpressionValue(dayOfWeek, "getDayOfWeek(...)");
        return dayOfWeek.getValue();
    }

    @JvmStatic
    public static final int getDayOfWeekTextBoxDisplayType(@Nullable SpenObjectBase objectBase) {
        if (objectBase != null) {
            return objectBase.getExtraDataInt(Constant.KEY_DAY_OF_WEEK_TEXT_BOX_DISPLAY_TYPE);
        }
        return 0;
    }

    @JvmStatic
    @NotNull
    public static final String getExtension(@NotNull String filePath) {
        Intrinsics.checkNotNullParameter(filePath, "filePath");
        int iM14131E = StringsKt.m14131E(Extension.DOT, 0, 6, filePath);
        if (iM14131E <= 0) {
            return "";
        }
        String strSubstring = filePath.substring(iM14131E);
        Intrinsics.checkNotNullExpressionValue(strSubstring, "substring(...)");
        String lowerCase = strSubstring.toLowerCase(Locale.ROOT);
        Intrinsics.checkNotNullExpressionValue(lowerCase, "toLowerCase(...)");
        return lowerCase;
    }

    @JvmStatic
    @NotNull
    public static final Bitmap getImageBoxDefaultData(@NotNull Context context, int width, int height, boolean isGenerative) {
        Intrinsics.checkNotNullParameter(context, "context");
        if (isGenerative) {
            Bitmap bitmapDecodeResource = BitmapFactory.decodeResource(context.getResources(), C9086R.drawable.dynamic_template_image_box_for_generative_base_img);
            Intrinsics.checkNotNullExpressionValue(bitmapDecodeResource, "decodeResource(...)");
            return bitmapDecodeResource;
        }
        Bitmap bitmapCreateBitmap = Bitmap.createBitmap(width, height, Bitmap.Config.ARGB_8888, true);
        Intrinsics.checkNotNullExpressionValue(bitmapCreateBitmap, "createBitmap(...)");
        return bitmapCreateBitmap;
    }

    @JvmStatic
    @NotNull
    public static final Bitmap getImageBoxDefaultImage(@NotNull SpenObjectImage objectImage) {
        Intrinsics.checkNotNullParameter(objectImage, "objectImage");
        RectF rect = objectImage.getRect();
        return getImageBoxMaskedImage(objectImage, getImageBoxDefaultData(BaseUtils.getContext(), (int) rect.width(), (int) rect.height(), objectImage.getExtraDataInt(Constant.KEY_IS_DYNAMIC_TEMPLATE_GENERATIVE_OBJECT) == 1));
    }

    @JvmStatic
    @NotNull
    public static final Bitmap getImageBoxMaskedImage(@NotNull SpenObjectImage objectImage, @NotNull Bitmap bitmap) {
        Intrinsics.checkNotNullParameter(objectImage, "objectImage");
        Intrinsics.checkNotNullParameter(bitmap, "bitmap");
        return isClippedMaskedImageObject(objectImage) ? ImageEffectUtil.applyConnerCutEffect(bitmap, 788) : isRoundedMaskedImageObject(objectImage) ? ImageEffectUtil.applyRoundedEffect(bitmap, 788) : bitmap;
    }

    private final String getObjectAction(SpenObjectBase objectBase) {
        String extraDataString;
        return (objectBase == null || (extraDataString = objectBase.getExtraDataString(Constant.KEY_OBJECT_ACTION)) == null) ? "" : extraDataString;
    }

    @JvmStatic
    @SuppressLint({"DefaultLocale"})
    @NotNull
    public static final String getTemplatePath(int templateType, int templateIndex) {
        StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
        return AbstractC2322a.m1624n("template/dynamic_template_%03d_%03d.xml", new Object[]{Integer.valueOf(templateType), Integer.valueOf(templateIndex)}, 2, "format(...)");
    }

    @JvmStatic
    @NotNull
    public static final String getXmlStringFromAssetFile(@NotNull Context context, @NotNull String templatePath) throws Throwable {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(templatePath, "templatePath");
        AssetManager assets = context.getAssets();
        Intrinsics.checkNotNullExpressionValue(assets, "getAssets(...)");
        StringBuilder sb = new StringBuilder();
        BufferedReader bufferedReader = null;
        try {
            try {
                InputStream inputStreamOpen = assets.open(templatePath);
                Intrinsics.checkNotNullExpressionValue(inputStreamOpen, "open(...)");
                BufferedReader bufferedReader2 = new BufferedReader(new InputStreamReader(inputStreamOpen, "UTF-8"));
                while (true) {
                    try {
                        String line = bufferedReader2.readLine();
                        if (line != null) {
                            sb.append(line);
                            sb.append("\n");
                        } else {
                            try {
                                break;
                            } catch (IOException unused) {
                            }
                        }
                    } catch (IOException e) {
                        e = e;
                        bufferedReader = bufferedReader2;
                        e.printStackTrace();
                        if (bufferedReader != null) {
                            try {
                                bufferedReader.close();
                            } catch (IOException unused2) {
                            }
                        }
                        return "";
                    } catch (Throwable th) {
                        th = th;
                        bufferedReader = bufferedReader2;
                        if (bufferedReader != null) {
                            try {
                                bufferedReader.close();
                            } catch (IOException unused3) {
                            }
                        }
                        throw th;
                    }
                }
                bufferedReader2.close();
                String string = sb.toString();
                Intrinsics.checkNotNullExpressionValue(string, "toString(...)");
                return string;
            } catch (Throwable th2) {
                th = th2;
            }
        } catch (IOException e2) {
            e = e2;
        }
    }

    @JvmStatic
    public static final boolean hasAction(@NotNull SpenObjectBase objectBase) {
        Intrinsics.checkNotNullParameter(objectBase, "objectBase");
        return !TextUtils.isEmpty(INSTANCE.getObjectAction(objectBase));
    }

    @JvmStatic
    public static final boolean hasDateTextBoxTimeInMillis(@Nullable SpenObjectBase objectBase) {
        if (objectBase instanceof SpenObjectTextBox) {
            return ((SpenObjectTextBox) objectBase).hasExtraDataString(Constant.KEY_DATE_TEXT_BOX_TIME_IN_MILLIS);
        }
        return false;
    }

    @JvmStatic
    public static final boolean hasDynamicTemplatePage(@Nullable Collection<SpenWPage> pages) {
        if (pages == null) {
            return false;
        }
        Iterator<T> it = pages.iterator();
        while (it.hasNext()) {
            if (((SpenWPage) it.next()).getTemplateType() == 17) {
                return true;
            }
        }
        return false;
    }

    @JvmStatic
    public static final boolean isClippedMaskType(int maskType) {
        return maskType == 1;
    }

    @JvmStatic
    public static final boolean isClippedMaskedImageObject(@Nullable SpenObjectBase objectBase) {
        if (objectBase instanceof SpenObjectImage) {
            return isClippedMaskType(((SpenObjectImage) objectBase).getExtraDataInt(Constant.KEY_IMAGE_MASK_TYPE));
        }
        return false;
    }

    @JvmStatic
    public static final boolean isControllableObject(@Nullable SpenObjectBase objectBase) {
        if (isSelectableObject(objectBase)) {
            return !TextUtils.isEmpty(INSTANCE.getObjectId(objectBase));
        }
        return false;
    }

    @JvmStatic
    public static final boolean isDynamicTemplateGenerativeObject(@NotNull SpenObjectBase objectBase) {
        Intrinsics.checkNotNullParameter(objectBase, "objectBase");
        return objectBase.getExtraDataInt(Constant.KEY_IS_DYNAMIC_TEMPLATE_GENERATIVE_OBJECT) == 1;
    }

    @JvmStatic
    public static final boolean isDynamicTemplateObject(@NotNull SpenObjectBase objectBase) {
        Intrinsics.checkNotNullParameter(objectBase, "objectBase");
        return objectBase.getExtraDataInt(Constant.KEY_IS_DYNAMIC_TEMPLATE_OBJECT) == 1;
    }

    @JvmStatic
    public static final boolean isImageFile(@NotNull String path) {
        Intrinsics.checkNotNullParameter(path, "path");
        int iM14131E = StringsKt.m14131E(Extension.DOT, 0, 6, path);
        if (iM14131E > 0) {
            String strSubstring = path.substring(iM14131E);
            Intrinsics.checkNotNullExpressionValue(strSubstring, "substring(...)");
            String lowerCase = strSubstring.toLowerCase(Locale.ROOT);
            Intrinsics.checkNotNullExpressionValue(lowerCase, "toLowerCase(...)");
            if (Intrinsics.areEqual(lowerCase, "image/jpg")) {
                return true;
            }
        }
        return false;
    }

    @JvmStatic
    public static final boolean isInsertGeneratedImageActionObject(@Nullable SpenObjectBase objectBase) {
        if (isSelectableObject(objectBase)) {
            return Intrinsics.areEqual(INSTANCE.getObjectAction(objectBase), Constant.VALUE_OBJECT_ACTION_INSERT_GENERATED_IMAGE);
        }
        return false;
    }

    @JvmStatic
    public static final boolean isInsertImageActionObject(@Nullable SpenObjectBase objectBase) {
        if (isSelectableObject(objectBase)) {
            return Intrinsics.areEqual(INSTANCE.getObjectAction(objectBase), Constant.VALUE_OBJECT_ACTION_INSERT_IMAGE);
        }
        return false;
    }

    @JvmStatic
    public static final boolean isRoundedMaskType(int maskType) {
        return maskType == 2;
    }

    @JvmStatic
    public static final boolean isRoundedMaskedImageObject(@Nullable SpenObjectBase objectBase) {
        if (objectBase instanceof SpenObjectImage) {
            return isRoundedMaskType(((SpenObjectImage) objectBase).getExtraDataInt(Constant.KEY_IMAGE_MASK_TYPE));
        }
        return false;
    }

    @JvmStatic
    public static final boolean isSelectableObject(@Nullable SpenObjectBase objectBase) {
        if (objectBase != null && objectBase.getVisible()) {
            if (objectBase instanceof SpenObjectImage) {
                return ((SpenObjectImage) objectBase).getSelectable();
            }
            if (objectBase instanceof SpenObjectTextBox) {
                return !((SpenObjectTextBox) objectBase).getTextEditable();
            }
        }
        return false;
    }

    @JvmStatic
    public static final boolean isShowDatePickerActionObject(@Nullable SpenObjectBase objectBase) {
        if (isSelectableObject(objectBase)) {
            return Intrinsics.areEqual(INSTANCE.getObjectAction(objectBase), Constant.VALUE_OBJECT_ACTION_SHOW_DATE_PICKER_TEXT);
        }
        return false;
    }

    @JvmStatic
    @NotNull
    public static final String makeImageBoxImageId(@NotNull String id, long timeInMillis) {
        Intrinsics.checkNotNullParameter(id, "id");
        return AbstractC0541b.m756B(makeObjectId(id, timeInMillis), "_post_fix_id_image_target_image");
    }

    @JvmStatic
    @NotNull
    public static final String makeImageBoxTextId(@NotNull String id, long timeInMillis) {
        Intrinsics.checkNotNullParameter(id, "id");
        return AbstractC0541b.m756B(makeObjectId(id, timeInMillis), "_post_fix_id_image_guide_text");
    }

    @JvmStatic
    @NotNull
    public static final String makeObjectId(@NotNull String id, long timeInMillis) {
        Intrinsics.checkNotNullParameter(id, "id");
        if (TextUtils.isEmpty(id)) {
            return "";
        }
        return id + "_" + timeInMillis;
    }

    @JvmStatic
    public static final void setDateTextBoxTimeInMillis(@Nullable SpenObjectBase objectBase, long timeInMillis) {
        if (objectBase != null) {
            objectBase.setExtraDataString(Constant.KEY_DATE_TEXT_BOX_TIME_IN_MILLIS, String.valueOf(timeInMillis));
        }
    }

    @NotNull
    public final RectF convertElementRectToDocRect(@NotNull Element element, @NotNull PointF docPageSize, @NotNull PointF templatePageSize, @NotNull PointF offset) {
        Intrinsics.checkNotNullParameter(element, "element");
        Intrinsics.checkNotNullParameter(docPageSize, "docPageSize");
        Intrinsics.checkNotNullParameter(templatePageSize, "templatePageSize");
        Intrinsics.checkNotNullParameter(offset, "offset");
        float f = docPageSize.x;
        float f4 = docPageSize.y;
        float f5 = templatePageSize.x;
        float f6 = templatePageSize.y;
        float fConvertSizeToDocSize = convertSizeToDocSize(element.getLeft(), f5, f);
        float fConvertSizeToDocSize2 = convertSizeToDocSize(element.getTop(), f6, f4);
        RectF rectF = new RectF(fConvertSizeToDocSize, fConvertSizeToDocSize2, convertSizeToDocSize(element.getWidth(), f5, f) + fConvertSizeToDocSize, convertSizeToDocSize(element.getHeight(), f6, f4) + fConvertSizeToDocSize2);
        rectF.offset(offset.x, offset.y);
        return rectF;
    }

    @NotNull
    public final String convertTextToGenerateImageMessage(@NotNull String text) {
        Intrinsics.checkNotNullParameter(text, "text");
        Integer num = textBoxMessagesForGenerateImage.get(text);
        if (num == null) {
            String string = BaseUtils.getContext().getString(C9086R.string.composer_ctx_menu_generate_new_image);
            Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
            return string;
        }
        String string2 = BaseUtils.getContext().getString(num.intValue());
        Intrinsics.checkNotNullExpressionValue(string2, "getString(...)");
        return string2;
    }

    @NotNull
    public final String convertTextToReservedMessage(@NotNull String text) {
        Intrinsics.checkNotNullParameter(text, "text");
        Integer num = textBoxMessages.get(text);
        if (num == null) {
            return text;
        }
        String string = BaseUtils.getContext().getString(num.intValue());
        Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
        return string;
    }

    @NotNull
    public final String getGroupedObjectId(@Nullable SpenObjectBase objectBase) {
        String extraDataString;
        return (objectBase == null || (extraDataString = objectBase.getExtraDataString(Constant.KEY_GROUPED_OBJECT_ID)) == null) ? "" : extraDataString;
    }

    @NotNull
    public final String getInsertImageTargetObjectId(@Nullable SpenObjectBase objectBase) {
        return objectBase instanceof SpenObjectImage ? getObjectId(objectBase) : getGroupedObjectId(objectBase);
    }

    @NotNull
    public final String getObjectId(@Nullable SpenObjectBase objectBase) {
        String extraDataString;
        return (objectBase == null || (extraDataString = objectBase.getExtraDataString(Constant.KEY_OBJECT_ID)) == null) ? "" : extraDataString;
    }
}
