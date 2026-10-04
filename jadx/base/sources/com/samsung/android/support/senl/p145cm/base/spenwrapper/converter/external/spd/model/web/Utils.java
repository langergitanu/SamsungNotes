package com.samsung.android.support.senl.p145cm.base.spenwrapper.converter.external.spd.model.web;

import android.util.Patterns;
import com.samsung.android.support.senl.p145cm.base.framework.support.LoggerBase;
import com.samsung.android.support.senl.p148nt.data.common.constants.SearchConstants;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import kotlin.Metadata;
import kotlin.collections.AbstractC12991c;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.text.Regex;
import kotlin.text.StringsKt;
import org.apache.commons.lang3.StringUtils;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import p001A.AbstractC0000a;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes9.dex */
@Metadata(m13885d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010 \n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J$\u0010\r\u001a\u00020\u00052\b\u0010\u000e\u001a\u0004\u0018\u00010\u00052\b\u0010\u000f\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0010\u001a\u00020\u0007H\u0007J*\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00050\u00122\b\u0010\u000e\u001a\u0004\u0018\u00010\u00052\b\u0010\u000f\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0010\u001a\u00020\u0007H\u0007J,\u0010\u0013\u001a\u0012\u0012\u0004\u0012\u00020\u00050\u0014j\b\u0012\u0004\u0012\u00020\u0005`\u00152\b\u0010\u0016\u001a\u0004\u0018\u00010\u00052\b\b\u0002\u0010\u0017\u001a\u00020\u0007H\u0007J\u0010\u0010\u0018\u001a\u00020\u00052\u0006\u0010\u000e\u001a\u00020\u0005H\u0007R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0007X\u0086T¢\u0006\u0002\n\u0000R\u0011\u0010\t\u001a\u00020\n¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\f¨\u0006\u0019"}, m13886d2 = {"Lcom/samsung/android/support/senl/cm/base/spenwrapper/converter/external/spd/model/web/Utils;", "", "<init>", "()V", SearchConstants.TargetContents.TAG, "", "ALL", "", "FIRST", "WEB_URL", "Ljava/util/regex/Pattern;", "getWEB_URL", "()Ljava/util/regex/Pattern;", "pregMatch", "content", "pattern", "index", "pregMatchAll", "", "matches", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "text", "results", "extendedTrim", "cmBase_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
@SourceDebugExtension({"SMAP\nUtils.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Utils.kt\ncom/samsung/android/support/senl/cm/base/spenwrapper/converter/external/spd/model/web/Utils\n+ 2 ArraysJVM.kt\nkotlin/collections/ArraysKt__ArraysJVMKt\n+ 3 Strings.kt\nkotlin/text/StringsKt__StringsKt\n*L\n1#1,85:1\n37#2:86\n36#2,3:87\n108#3:90\n80#3,22:91\n*S KotlinDebug\n*F\n+ 1 Utils.kt\ncom/samsung/android/support/senl/cm/base/spenwrapper/converter/external/spd/model/web/Utils\n*L\n60#1:86\n60#1:87,3\n83#1:90\n83#1:91,22\n*E\n"})
public final class Utils {
    public static final int ALL = 0;
    public static final int FIRST = 1;

    @NotNull
    public static final Utils INSTANCE = new Utils();

    @NotNull
    private static final String TAG = "SPDToSDocXConverter$Utils";

    @NotNull
    private static final Pattern WEB_URL;

    static {
        Pattern patternCompile = Pattern.compile("(((http|https|Http|Https):\\/\\/(?:(?:[a-zA-Z0-9\\$\\-\\_\\.\\+\\!\\*\\'\\(\\)\\,\\;\\?\\&\\=]|(?:\\%[a-fA-F0-9]{2})){1,64}(?:\\:(?:[a-zA-Z0-9\\$\\-\\_\\.\\+\\!\\*\\'\\(\\)\\,\\;\\?\\&\\=]|(?:\\%[a-fA-F0-9]{2})){1,25})?\\@)?)(?:" + Patterns.DOMAIN_NAME + ")(?:\\:\\d{1,5})?)(\\/(?:(?:[a-zA-Z0-9 -\ud7ff豈-﷏ﷰ-\uffef\\;\\/\\?\\:\\@\\&\\=\\#\\~\\$\\-\\.\\+\\!\\*\\'\\(\\)\\,\\_])|(?:\\%[a-fA-F0-9]{2}))*)?(?:\\b|$)(\\/)?");
        Intrinsics.checkNotNullExpressionValue(patternCompile, "compile(...)");
        WEB_URL = patternCompile;
    }

    private Utils() {
    }

    @JvmStatic
    @NotNull
    public static final String extendedTrim(@NotNull String content) {
        Intrinsics.checkNotNullParameter(content, "content");
        String strM14139M = StringsKt.m14139M(StringsKt.m14139M(new Regex("\\s+").replace(content, " "), "\n", " "), StringUtils.f9761CR, " ");
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
        return strM14139M.subSequence(i, length + 1).toString();
    }

    @JvmStatic
    @JvmOverloads
    @NotNull
    public static final ArrayList<String> matches(@Nullable String str) {
        return matches$default(str, 0, 2, null);
    }

    public static /* synthetic */ ArrayList matches$default(String str, int i, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            i = 0;
        }
        return matches(str, i);
    }

    @JvmStatic
    @NotNull
    public static final String pregMatch(@Nullable String content, @Nullable String pattern, int index) {
        String strGroup;
        Matcher matcher = Pattern.compile(String.valueOf(pattern)).matcher(String.valueOf(content));
        String str = "";
        if (matcher.find() && (strGroup = matcher.group(index)) != null) {
            str = strGroup;
        }
        return extendedTrim(str);
    }

    @JvmStatic
    @NotNull
    public static final List<String> pregMatchAll(@Nullable String content, @Nullable String pattern, int index) {
        ArrayList arrayList = new ArrayList();
        Matcher matcher = Pattern.compile(String.valueOf(pattern)).matcher(String.valueOf(content));
        while (matcher.find()) {
            String strGroup = matcher.group(index);
            if (strGroup == null) {
                strGroup = "";
            }
            arrayList.add(extendedTrim(strGroup));
        }
        return arrayList;
    }

    @NotNull
    public final Pattern getWEB_URL() {
        return WEB_URL;
    }

    @JvmStatic
    @JvmOverloads
    @NotNull
    public static final ArrayList<String> matches(@Nullable String text, int results) {
        ArrayList<String> arrayList = new ArrayList<>();
        for (String str : (String[]) AbstractC12991c.m13999t(0, " ", String.valueOf(text)).toArray(new String[0])) {
            try {
                arrayList.add(new URL(str).toString());
            } catch (Exception e) {
                AbstractC0000a.m23t("matches error", e.getMessage(), LoggerBase.INSTANCE, TAG);
            }
            if (results == 1 && !arrayList.isEmpty()) {
                break;
            }
        }
        return arrayList;
    }
}
