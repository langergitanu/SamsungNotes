package com.samsung.android.support.senl.p145cm.base.spenwrapper.converter.common;

import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.toolbar.remotefunction.RemoteConstant;
import java.io.File;
import java.util.List;
import java.util.ListIterator;
import java.util.Locale;
import kotlin.Metadata;
import kotlin.collections.AbstractC12991c;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes9.dex */
@Metadata(m13885d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0007¨\u0006\b"}, m13886d2 = {"Lcom/samsung/android/support/senl/cm/base/spenwrapper/converter/common/ConvertUtils;", "Lcom/samsung/android/support/senl/cm/base/spenwrapper/converter/common/IConvertType;", "<init>", "()V", "getConverterType", "", "input", "", "cmBase_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
@SourceDebugExtension({"SMAP\nConvertUtils.kt\nKotlin\n*S Kotlin\n*F\n+ 1 ConvertUtils.kt\ncom/samsung/android/support/senl/cm/base/spenwrapper/converter/common/ConvertUtils\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n+ 3 ArraysJVM.kt\nkotlin/collections/ArraysKt__ArraysJVMKt\n*L\n1#1,29:1\n739#2,9:30\n37#3:39\n36#3,3:40\n*S KotlinDebug\n*F\n+ 1 ConvertUtils.kt\ncom/samsung/android/support/senl/cm/base/spenwrapper/converter/common/ConvertUtils\n*L\n15#1:30,9\n16#1:39\n16#1:40,3\n*E\n"})
public final class ConvertUtils implements IConvertType {

    @NotNull
    public static final ConvertUtils INSTANCE = new ConvertUtils();

    private ConvertUtils() {
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    /* JADX WARN: Removed duplicated region for block: B:53:0x00c5 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:56:0x00ce A[RETURN] */
    @JvmStatic
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final int getConverterType(@NotNull String input) {
        List listEmptyList;
        Intrinsics.checkNotNullParameter(input, "input");
        if (!new File(input).isDirectory()) {
            List listM13999t = AbstractC12991c.m13999t(0, RemoteConstant.VERSION_DIVIDE, input);
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
            String str = strArr[strArr.length - 1];
            Locale locale = Locale.getDefault();
            Intrinsics.checkNotNullExpressionValue(locale, "getDefault(...)");
            String lowerCase = str.toLowerCase(locale);
            Intrinsics.checkNotNullExpressionValue(lowerCase, "toLowerCase(...)");
            switch (lowerCase.hashCode()) {
                case -898010811:
                    return !lowerCase.equals("snbbak") ? 0 : 2;
                case -896104187:
                    if (lowerCase.equals("spdbak")) {
                        return 1;
                    }
                    break;
                case 113683:
                    if (lowerCase.equals("scc")) {
                        return 3;
                    }
                    break;
                case 114023:
                    if (lowerCase.equals("snb")) {
                        return 2;
                    }
                    break;
                case 114087:
                    if (!lowerCase.equals("spd")) {
                    }
                    break;
                case 118807:
                    if (lowerCase.equals("xml")) {
                        return 6;
                    }
                    break;
                case 3271912:
                    if (lowerCase.equals("json")) {
                        return 7;
                    }
                    break;
                case 3347770:
                    if (lowerCase.equals("memo")) {
                        return 5;
                    }
                    break;
                case 3525605:
                    if (lowerCase.equals("sdoc")) {
                        return 8;
                    }
                    break;
            }
        } else {
            return 4;
        }
    }
}
