package com.google.android.play.core.internal;

import android.content.Context;
import android.os.LocaleList;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

/* JADX INFO: renamed from: com.google.android.play.core.internal.bx */
/* JADX INFO: loaded from: classes5.dex */
public final class C5202bx {

    /* JADX INFO: renamed from: a */
    private final Context f2969a;

    public C5202bx(Context context) {
        this.f2969a = context;
    }

    /* JADX INFO: renamed from: a */
    private static String m3971a(Locale locale) {
        String strConcat;
        String strValueOf = String.valueOf(locale.getLanguage());
        if (locale.getCountry().isEmpty()) {
            strConcat = "";
        } else {
            String strValueOf2 = String.valueOf(locale.getCountry());
            strConcat = strValueOf2.length() != 0 ? "_".concat(strValueOf2) : new String("_");
        }
        String strValueOf3 = String.valueOf(strConcat);
        return strValueOf3.length() != 0 ? strValueOf.concat(strValueOf3) : new String(strValueOf);
    }

    /* JADX INFO: renamed from: a */
    public final List<String> m3972a() {
        LocaleList locales = this.f2969a.getResources().getConfiguration().getLocales();
        ArrayList arrayList = new ArrayList(locales.size());
        for (int i = 0; i < locales.size(); i++) {
            arrayList.add(m3971a(locales.get(i)));
        }
        return arrayList;
    }
}
