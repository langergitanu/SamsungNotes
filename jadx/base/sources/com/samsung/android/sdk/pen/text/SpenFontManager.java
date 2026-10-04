package com.samsung.android.sdk.pen.text;

import android.content.Context;
import android.os.Build;
import android.os.LocaleList;
import android.text.TextUtils;
import com.samsung.android.feature.SemCscFeature;
import com.samsung.android.spen.libwrapper.TypefaceWrapper;
import com.samsung.android.spen.libwrapper.utils.PlatformException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.ListIterator;
import kotlin.Metadata;
import kotlin.collections.AbstractC12991c;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.text.StringsKt;
import kotlin.text.StringsKt__StringsJVMKt;
import org.apache.xmlbeans.XmlErrorCodes;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(m13885d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\u0012\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0012\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\rH\u0007J\u0012\u0010\u000e\u001a\u0004\u0018\u00010\u00052\u0006\u0010\f\u001a\u00020\rH\u0002J\b\u0010\u000f\u001a\u00020\u0010H\u0007J\u0010\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u0005H\u0002J\u001c\u0010\u0012\u001a\u00020\u000b2\b\u0010\u0013\u001a\u0004\u0018\u00010\u00052\b\u0010\u0014\u001a\u0004\u0018\u00010\u0015H\u0007J\u0013\u0010\u0016\u001a\u00020\u000b2\b\u0010\u0017\u001a\u0004\u0018\u00010\u0005H\u0083 J-\u0010\u0018\u001a\u00020\u00102\u001a\u0010\u0019\u001a\u0016\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u001aj\n\u0012\u0004\u0012\u00020\u0005\u0018\u0001`\u001b2\u0006\u0010\u001c\u001a\u00020\u001dH\u0083 J%\u0010\u001e\u001a\u00020\u000b2\b\u0010\u0013\u001a\u0004\u0018\u00010\u00052\b\u0010\u0014\u001a\u0004\u0018\u00010\u00152\u0006\u0010\u001f\u001a\u00020\u001dH\u0083 R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000¨\u0006 "}, m13886d2 = {"Lcom/samsung/android/sdk/pen/text/SpenFontManager;", "", "<init>", "()V", "LOG_TAG", "", "LOCALES_SPLITTER", "OVERRIDE_TB", "OVERRIDE_TB_FONT_PATH", "SYSTEM_DEFAULT_FONT_PATH", "setSystemFontPath", "", "context", "Landroid/content/Context;", "getSystemFontPath", "setLocaleList", "", XmlErrorCodes.LIST, "setCustomFallbackFont", "language", "buffer", "", "Native_setSystemFontPath", "systemFontPath", "Native_setLocaleList", "localeList", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "length", "", "Native_setCustomFallbackFont", "bufferLength", "SDK_fullRelease"}, m13887k = 1, m13888mv = {2, 0, 0}, m13890xi = 48)
@SourceDebugExtension({"SMAP\nSpenFontManager.kt\nKotlin\n*S Kotlin\n*F\n+ 1 SpenFontManager.kt\ncom/samsung/android/sdk/pen/text/SpenFontManager\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n+ 3 ArraysJVM.kt\nkotlin/collections/ArraysKt__ArraysJVMKt\n*L\n1#1,97:1\n731#2,9:98\n37#3,2:107\n*S KotlinDebug\n*F\n+ 1 SpenFontManager.kt\ncom/samsung/android/sdk/pen/text/SpenFontManager\n*L\n78#1:98,9\n79#1:107,2\n*E\n"})
public final class SpenFontManager {

    @NotNull
    public static final SpenFontManager INSTANCE = new SpenFontManager();

    @NotNull
    private static final String LOCALES_SPLITTER = ",";

    @NotNull
    private static final String LOG_TAG = "SpenFontManager";

    @NotNull
    private static final String OVERRIDE_TB = "ThomBrowne";

    @NotNull
    private static final String OVERRIDE_TB_FONT_PATH = "/system/fonts/ArialNarrow-Regular.ttf";

    @NotNull
    private static final String SYSTEM_DEFAULT_FONT_PATH = "default";

    private SpenFontManager() {
    }

    @JvmStatic
    private static final native boolean Native_setCustomFallbackFont(String language, byte[] buffer, int bufferLength);

    @JvmStatic
    private static final native void Native_setLocaleList(ArrayList<String> localeList, int length);

    @JvmStatic
    private static final native boolean Native_setSystemFontPath(String systemFontPath);

    private final String getSystemFontPath(Context context) {
        try {
            String fontPathOfCurrentFontStyle = TypefaceWrapper.create(context).getFontPathOfCurrentFontStyle(context, 1);
            if (Build.VERSION.SDK_INT > 28 && StringsKt__StringsJVMKt.equals(fontPathOfCurrentFontStyle, "default", true)) {
                String string = SemCscFeature.getInstance().getString("CscFeature_SetupWizard_ConfigStepSequenceType");
                if (!TextUtils.isEmpty(string)) {
                    Intrinsics.checkNotNull(string);
                    if (StringsKt.m14162r(string, OVERRIDE_TB)) {
                        return OVERRIDE_TB_FONT_PATH;
                    }
                }
            }
            return fontPathOfCurrentFontStyle;
        } catch (PlatformException e) {
            e.printStackTrace();
            return null;
        }
    }

    @JvmStatic
    public static final boolean setCustomFallbackFont(@Nullable String language, @Nullable byte[] buffer) {
        return Native_setCustomFallbackFont(language, buffer, buffer != null ? buffer.length : 0);
    }

    private final void setLocaleList(String list) {
        List listEmptyList;
        List listM13999t = AbstractC12991c.m13999t(0, ",", list);
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
        String[] strArr = (String[]) listEmptyList.toArray(new String[0]);
        ArrayList arrayList = new ArrayList(CollectionsKt.listOf(Arrays.copyOf(strArr, strArr.length)));
        Native_setLocaleList(arrayList, arrayList.size());
    }

    @JvmStatic
    public static final boolean setSystemFontPath(@Nullable Context context) {
        String systemFontPath;
        if (context == null || (systemFontPath = INSTANCE.getSystemFontPath(context)) == null) {
            return false;
        }
        return Native_setSystemFontPath(systemFontPath);
    }

    @JvmStatic
    public static final void setLocaleList() {
        StringBuilder sb = new StringBuilder("");
        LocaleList localeList = LocaleList.getDefault();
        Intrinsics.checkNotNullExpressionValue(localeList, "getDefault(...)");
        int size = localeList.size();
        for (int i = 0; i < size; i++) {
            if (i > 0) {
                sb.append(",");
            }
            sb.append(localeList.get(i).toLanguageTag());
        }
        String string = sb.toString();
        Intrinsics.checkNotNullExpressionValue(string, "toString(...)");
        if (string.length() > 0) {
            SpenFontManager spenFontManager = INSTANCE;
            String string2 = sb.toString();
            Intrinsics.checkNotNullExpressionValue(string2, "toString(...)");
            spenFontManager.setLocaleList(string2);
        }
    }
}
