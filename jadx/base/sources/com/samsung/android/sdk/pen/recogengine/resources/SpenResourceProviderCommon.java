package com.samsung.android.sdk.pen.recogengine.resources;

import android.util.Log;
import androidx.collection.AbstractC0622a;
import com.samsung.android.app.notes.sync.coedit.sharecore.strategy.AbstractC6670b;
import com.samsung.android.support.senl.p145cm.base.common.constants.Extension;
import com.samsung.android.support.senl.p148nt.composer.main.base.model.menu.toolbar.directwrite.constants.DirectWriteConstant;
import com.samsung.android.support.senl.p148nt.data.common.constants.SearchConstants;
import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.ArrayIteratorKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.text.StringsKt;
import org.apache.xmlbeans.XmlErrorCodes;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes7.dex */
@Metadata(m13885d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0012\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0011\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\b\b\b\u0000\u0018\u0000 \u001e2\u00020\u0001:\u0001\u001eB\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0012\u0010\u0006\u001a\u0004\u0018\u00010\u00072\b\u0010\b\u001a\u0004\u0018\u00010\tJ%\u0010\n\u001a\u00020\u00052\b\u0010\u000b\u001a\u0004\u0018\u00010\u00052\u000e\u0010\f\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\r¢\u0006\u0002\u0010\u000eJ!\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00050\r2\u000e\u0010\f\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\r¢\u0006\u0002\u0010\u0010J%\u0010\u0011\u001a\u00020\u00122\b\u0010\u0013\u001a\u0004\u0018\u00010\u00052\u000e\u0010\f\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\r¢\u0006\u0002\u0010\u0014J%\u0010\u0015\u001a\u00020\u00052\b\u0010\u0013\u001a\u0004\u0018\u00010\u00052\u000e\u0010\f\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\r¢\u0006\u0002\u0010\u000eJ#\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00050\u00172\u000e\u0010\u0018\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\rH\u0002¢\u0006\u0002\u0010\u0019J\u001e\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u00050\u00172\u000e\u0010\u001b\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u0017H\u0002J\"\u0010\u001c\u001a\u00020\u00052\b\u0010\u0013\u001a\u0004\u0018\u00010\u00052\u000e\u0010\u001d\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u0017H\u0002R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082D¢\u0006\u0002\n\u0000¨\u0006\u001f"}, m13886d2 = {"Lcom/samsung/android/sdk/pen/recogengine/resources/SpenResourceProviderCommon;", "", "<init>", "()V", SearchConstants.TargetContents.TAG, "", "getResourceBuffer", "", "inStream", "Ljava/io/InputStream;", "getSecondaryLanguage", "locale", "hwrdbFilenames", "", "(Ljava/lang/String;[Ljava/lang/String;)Ljava/lang/String;", "getSupportedLanguages", "([Ljava/lang/String;)[Ljava/lang/String;", "isSupportedLanguage", "", "language", "(Ljava/lang/String;[Ljava/lang/String;)Z", "getDefaultLocale", "getLanguageListFromFilenames", "", "filenames", "([Ljava/lang/String;)Ljava/util/List;", "getSupportedListWithLanguageCodeOnly", XmlErrorCodes.LIST, "getDefaultLocaleFromExistingList", "existLanguages", "Companion", "SDK_fullRelease"}, m13887k = 1, m13888mv = {2, 0, 0}, m13890xi = 48)
@SourceDebugExtension({"SMAP\nSpenResourceProviderCommon.kt\nKotlin\n*S Kotlin\n*F\n+ 1 SpenResourceProviderCommon.kt\ncom/samsung/android/sdk/pen/recogengine/resources/SpenResourceProviderCommon\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n+ 3 ArraysJVM.kt\nkotlin/collections/ArraysKt__ArraysJVMKt\n*L\n1#1,177:1\n1#2:178\n37#3,2:179\n*S KotlinDebug\n*F\n+ 1 SpenResourceProviderCommon.kt\ncom/samsung/android/sdk/pen/recogengine/resources/SpenResourceProviderCommon\n*L\n72#1:179,2\n*E\n"})
public final class SpenResourceProviderCommon {

    @NotNull
    public static final String HWRDB_DOCUMENT_DEFAULT_ROOT_DIR = "hwrdb_document";

    @NotNull
    public static final String HWRDB_DOCUMENT_LS_DBNAME = "ls_model.bin";

    @NotNull
    public static final String HWRDB_DOCUMENT_MAIN_DBNAME = "model.bin";

    @NotNull
    public static final String HWRDB_MATH_DBNAME = "hme_model.dat";

    @NotNull
    public static final String HWRDB_MATH_DEFAULT_ROOT_DIR = "hwrdb_math";

    @NotNull
    public static final String HWRDB_TEXT_DEFAULT_ROOT_DIR = "hwrdb";

    @NotNull
    private final String TAG = "SpenResourceProviderCommon";

    private final String getDefaultLocaleFromExistingList(String language, List<String> existLanguages) {
        List<String> list;
        String str = this.TAG;
        SpenResourceID spenResourceID = SpenResourceID.INSTANCE;
        Log.d(str, "getDefaultLocaleFromExistingList : input language code = [" + spenResourceID.getLanguageID(language) + "]");
        if (language == null || language.length() == 0) {
            return "";
        }
        if (Intrinsics.areEqual("ar", language) || (list = existLanguages) == null || list.isEmpty() || language.length() != 2) {
            return language;
        }
        List<String> priorityLocaleList = spenResourceID.getPriorityLocaleList(language);
        Log.d(this.TAG, "getDefaultLocaleFromExistingList : priority locale list = " + spenResourceID.getLanguageIDs(priorityLocaleList));
        if (!priorityLocaleList.isEmpty()) {
            Log.d(this.TAG, "getDefaultLocaleFromExistingList: existing languages = " + spenResourceID.getLanguageIDs(existLanguages));
            for (String str2 : priorityLocaleList) {
                if (existLanguages.contains(str2)) {
                    String str3 = this.TAG;
                    SpenResourceID spenResourceID2 = SpenResourceID.INSTANCE;
                    Log.d(str3, AbstractC0622a.m1164j(spenResourceID2.getLanguageID(str2), spenResourceID2.getLanguageID(language), "getDefaultLocaleFromExistingList : return locale [", "] for input language code [", "]"));
                    return str2;
                }
            }
        }
        SpenResourceID spenResourceID3 = SpenResourceID.INSTANCE;
        String defaultLanguageCode = spenResourceID3.getDefaultLanguageCode(language);
        Log.d(this.TAG, AbstractC0622a.m1164j(spenResourceID3.getLanguageID(defaultLanguageCode), spenResourceID3.getLanguageID(language), "getDefaultLocaleFromExistingList : return primary locale [", "] for input language code [", "]"));
        return defaultLanguageCode;
    }

    private final List<String> getLanguageListFromFilenames(String[] filenames) {
        ArrayList arrayList = new ArrayList();
        if (filenames == null || filenames.length == 0) {
            Log.e(this.TAG, "getLanguageListFromFilenames : filenames array is wrong!");
            return arrayList;
        }
        Iterator it = ArrayIteratorKt.iterator(filenames);
        while (it.hasNext()) {
            String str = (String) it.next();
            String strSubstring = str.substring(StringsKt.m14129C("_", 0, 6, str) + 1, StringsKt.m14131E(Extension.DOT, 0, 6, str));
            Intrinsics.checkNotNullExpressionValue(strSubstring, "this as java.lang.String…ing(startIndex, endIndex)");
            arrayList.add(strSubstring);
        }
        return arrayList;
    }

    private final List<String> getSupportedListWithLanguageCodeOnly(List<String> list) {
        ArrayList arrayList = new ArrayList();
        List<String> list2 = list;
        if (list2 != null && !list2.isEmpty()) {
            Log.d(this.TAG, "raw supported languages = " + SpenResourceID.INSTANCE.getLanguageIDs(list));
            for (String str : list) {
                if (Intrinsics.areEqual("sr_Latn_RS", str)) {
                    str = "sr_RS";
                }
                String languageCodeFrom = SpenResourceID.INSTANCE.getLanguageCodeFrom(str);
                if (!arrayList.contains(str)) {
                    arrayList.add(str);
                }
                if (!arrayList.contains(languageCodeFrom)) {
                    arrayList.add(languageCodeFrom);
                }
            }
        }
        return arrayList;
    }

    @NotNull
    public final String getDefaultLocale(@Nullable String language, @Nullable String[] hwrdbFilenames) {
        String defaultLocaleFromExistingList = getDefaultLocaleFromExistingList(language, getLanguageListFromFilenames(hwrdbFilenames));
        Log.d(this.TAG, "getDefaultLocale : " + language + " -> " + defaultLocaleFromExistingList);
        return defaultLocaleFromExistingList;
    }

    @Nullable
    public final byte[] getResourceBuffer(@Nullable InputStream inStream) throws Throwable {
        byte[] bArr;
        BufferedInputStream bufferedInputStream = null;
        byte[] bArr2 = null;
        if (inStream == null) {
            Log.e(this.TAG, "getResourceBuffer : input stream is null!");
            return null;
        }
        try {
            BufferedInputStream bufferedInputStream2 = new BufferedInputStream(inStream);
            try {
                int iAvailable = bufferedInputStream2.available();
                Log.d(this.TAG, "getResourceBuffer : bufferSize = " + iAvailable);
                bArr = new byte[iAvailable];
                try {
                    byte[] bArr3 = new byte[8192];
                    int i = 0;
                    while (true) {
                        int i2 = bufferedInputStream2.read(bArr3);
                        if (i2 == -1) {
                            break;
                        }
                        System.arraycopy(bArr3, 0, bArr, i, i2);
                        i += i2;
                        Log.e(this.TAG, "getResourceBuffer : cannot get buffer : " + e.getMessage());
                        e.printStackTrace();
                        return bArr2;
                    }
                    if (i != iAvailable) {
                        Log.e(this.TAG, "getResourceBuffer : TotalByte = " + i + " and BufferSize = " + iAvailable + " is different!");
                    } else {
                        bArr2 = bArr;
                    }
                    try {
                        bufferedInputStream2.close();
                        return bArr2;
                    } catch (IOException e) {
                        e = e;
                    }
                } catch (Throwable th) {
                    th = th;
                    bufferedInputStream = bufferedInputStream2;
                    if (bufferedInputStream != null) {
                        try {
                            bufferedInputStream.close();
                        } catch (IOException e2) {
                            e = e2;
                            bArr2 = bArr;
                        }
                    }
                    throw th;
                }
            } catch (Throwable th2) {
                th = th2;
                bArr = null;
            }
        } catch (Throwable th3) {
            th = th3;
            bArr = null;
        }
    }

    @NotNull
    public final String getSecondaryLanguage(@Nullable String locale, @Nullable String[] hwrdbFilenames) {
        String[] secondaryLanguages = SpenResourceID.INSTANCE.getSecondaryLanguages(locale);
        if (secondaryLanguages == null || secondaryLanguages.length != 2) {
            return "";
        }
        List<String> languageListFromFilenames = getLanguageListFromFilenames(hwrdbFilenames);
        boolean zContains = !languageListFromFilenames.isEmpty() ? languageListFromFilenames.contains(DirectWriteConstant.DEFAULT_RECOGNITION_LANGUAGE) : false;
        AbstractC6670b.m4759t("getSecondaryLanguage : isSupportEnUS = ", this.TAG, zContains);
        return zContains ? secondaryLanguages[0] : secondaryLanguages[1];
    }

    @NotNull
    public final String[] getSupportedLanguages(@Nullable String[] hwrdbFilenames) {
        List<String> supportedListWithLanguageCodeOnly = getSupportedListWithLanguageCodeOnly(getLanguageListFromFilenames(hwrdbFilenames));
        if (supportedListWithLanguageCodeOnly.isEmpty()) {
            Log.e(this.TAG, "language list size is 0!");
            return new String[0];
        }
        String[] strArr = (String[]) supportedListWithLanguageCodeOnly.toArray(new String[0]);
        Log.d(this.TAG, "supported languages = " + SpenResourceID.INSTANCE.getLanguageIDs(strArr));
        return strArr;
    }

    public final boolean isSupportedLanguage(@Nullable String language, @Nullable String[] hwrdbFilenames) {
        return CollectionsKt.contains(getSupportedListWithLanguageCodeOnly(getLanguageListFromFilenames(hwrdbFilenames)), language);
    }
}
