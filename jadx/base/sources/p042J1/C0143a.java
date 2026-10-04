package p042J1;

import android.content.Context;
import android.content.res.Configuration;
import com.samsung.android.support.notes.sync.C7943R;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Locale;

/* JADX INFO: renamed from: J1.a */
/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes7.dex */
public final class C0143a {

    /* JADX INFO: renamed from: c */
    public static C0143a f396c;

    /* JADX INFO: renamed from: a */
    public ArrayList f397a;

    /* JADX INFO: renamed from: b */
    public ArrayList f398b;

    static {
        new HashMap();
    }

    /* JADX INFO: renamed from: a */
    public static C0143a m292a(Context context) {
        if (f396c == null) {
            C0143a c0143a = new C0143a();
            c0143a.f397a = null;
            c0143a.f398b = null;
            c0143a.f397a = new ArrayList();
            c0143a.f398b = new ArrayList();
            Locale[] availableLocales = Locale.getAvailableLocales();
            Configuration configuration = new Configuration(context.getResources().getConfiguration());
            for (Locale locale : availableLocales) {
                configuration.setLocale(locale);
                String string = context.createConfigurationContext(configuration).getResources().getString(C7943R.string.uncategorised);
                if (!c0143a.f397a.contains(string)) {
                    c0143a.f397a.add(string);
                }
                String string2 = context.createConfigurationContext(configuration).getResources().getString(C7943R.string.string_screen_off_memo);
                if (!c0143a.f398b.contains(string2)) {
                    c0143a.f398b.add(string2);
                }
            }
            f396c = c0143a;
        }
        return f396c;
    }
}
