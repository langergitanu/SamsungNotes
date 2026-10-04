package p013C2;

import android.app.appsearch.observer.ObserverCallback;
import android.app.appsearch.observer.ObserverSpec;
import android.window.OnBackInvokedCallback;
import android.window.OnBackInvokedDispatcher;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.nio.charset.StandardCharsets;

/* JADX INFO: renamed from: C2.a */
/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes9.dex */
public abstract /* synthetic */ class AbstractC0053a {
    /* JADX INFO: renamed from: b */
    public static /* bridge */ /* synthetic */ ObserverCallback m110b(Object obj) {
        return (ObserverCallback) obj;
    }

    /* JADX INFO: renamed from: c */
    public static /* synthetic */ ObserverSpec.Builder m111c() {
        return new ObserverSpec.Builder();
    }

    /* JADX INFO: renamed from: f */
    public static /* bridge */ /* synthetic */ OnBackInvokedCallback m114f(Object obj) {
        return (OnBackInvokedCallback) obj;
    }

    /* JADX INFO: renamed from: j */
    public static /* bridge */ /* synthetic */ OnBackInvokedDispatcher m118j(Object obj) {
        return (OnBackInvokedDispatcher) obj;
    }

    /* JADX INFO: renamed from: k */
    public static /* synthetic */ FileReader m119k(String str) {
        return new FileReader(str, StandardCharsets.UTF_8);
    }

    /* JADX INFO: renamed from: l */
    public static /* synthetic */ FileWriter m120l(File file) {
        return new FileWriter(file, StandardCharsets.UTF_8);
    }

    /* JADX INFO: renamed from: m */
    public static /* synthetic */ FileWriter m121m(String str) {
        return new FileWriter(str, StandardCharsets.UTF_8);
    }
}
