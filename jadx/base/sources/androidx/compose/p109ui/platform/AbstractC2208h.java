package androidx.compose.p109ui.platform;

import android.app.Person;
import android.os.Parcelable;
import android.text.PrecomputedText;
import android.text.TextPaint;

/* JADX INFO: renamed from: androidx.compose.ui.platform.h */
/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes.dex */
public abstract /* synthetic */ class AbstractC2208h {
    /* JADX INFO: renamed from: f */
    public static /* bridge */ /* synthetic */ Person m1538f(Parcelable parcelable) {
        return (Person) parcelable;
    }

    /* JADX INFO: renamed from: g */
    public static /* bridge */ /* synthetic */ Person m1539g(Object obj) {
        return (Person) obj;
    }

    /* JADX INFO: renamed from: n */
    public static /* synthetic */ PrecomputedText.Params.Builder m1546n(TextPaint textPaint) {
        return new PrecomputedText.Params.Builder(textPaint);
    }

    /* JADX INFO: renamed from: q */
    public static /* bridge */ /* synthetic */ PrecomputedText m1549q(Object obj) {
        return (PrecomputedText) obj;
    }

    /* JADX INFO: renamed from: z */
    public static /* bridge */ /* synthetic */ boolean m1558z(Object obj) {
        return obj instanceof PrecomputedText;
    }
}
