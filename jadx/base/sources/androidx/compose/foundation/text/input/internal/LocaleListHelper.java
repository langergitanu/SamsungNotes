package androidx.compose.foundation.text.input.internal;

import android.view.inputmethod.EditorInfo;
import androidx.annotation.DoNotInline;
import androidx.annotation.RequiresApi;
import androidx.compose.p109ui.text.intl.Locale;
import androidx.compose.p109ui.text.intl.LocaleList;
import androidx.compose.runtime.internal.StabilityInferred;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes.dex */
@StabilityInferred(parameters = 1)
@Metadata(m13885d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bÁ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0018\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0007¨\u0006\t"}, m13886d2 = {"Landroidx/compose/foundation/text/input/internal/LocaleListHelper;", "", "()V", "setHintLocales", "", "editorInfo", "Landroid/view/inputmethod/EditorInfo;", "localeList", "Landroidx/compose/ui/text/intl/LocaleList;", "foundation_release"}, m13887k = 1, m13888mv = {1, 8, 0}, m13890xi = 48)
@RequiresApi(24)
@SourceDebugExtension({"SMAP\nEditorInfo.android.kt\nKotlin\n*S Kotlin\n*F\n+ 1 EditorInfo.android.kt\nandroidx/compose/foundation/text/input/internal/LocaleListHelper\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n+ 3 ArraysJVM.kt\nkotlin/collections/ArraysKt__ArraysJVMKt\n*L\n1#1,221:1\n1549#2:222\n1620#2,3:223\n37#3,2:226\n*S KotlinDebug\n*F\n+ 1 EditorInfo.android.kt\nandroidx/compose/foundation/text/input/internal/LocaleListHelper\n*L\n193#1:222\n193#1:223,3\n193#1:226,2\n*E\n"})
public final class LocaleListHelper {
    public static final int $stable = 0;

    @NotNull
    public static final LocaleListHelper INSTANCE = new LocaleListHelper();

    private LocaleListHelper() {
    }

    @DoNotInline
    @RequiresApi(24)
    public final void setHintLocales(@NotNull EditorInfo editorInfo, @NotNull LocaleList localeList) {
        if (Intrinsics.areEqual(localeList, LocaleList.INSTANCE.getEmpty())) {
            editorInfo.hintLocales = null;
            return;
        }
        ArrayList arrayList = new ArrayList(CollectionsKt.m13952k(localeList));
        Iterator<Locale> it = localeList.iterator();
        while (it.hasNext()) {
            arrayList.add(it.next().getPlatformLocale());
        }
        java.util.Locale[] localeArr = (java.util.Locale[]) arrayList.toArray(new java.util.Locale[0]);
        editorInfo.hintLocales = new android.os.LocaleList((java.util.Locale[]) Arrays.copyOf(localeArr, localeArr.length));
    }
}
