package androidx.compose.foundation.text.input.internal;

import android.view.inputmethod.DeleteGesture;
import android.view.inputmethod.DeleteRangeGesture;
import android.view.inputmethod.InsertGesture;
import android.view.inputmethod.JoinOrSplitGesture;
import android.view.inputmethod.RemoveSpaceGesture;
import android.view.inputmethod.SelectGesture;
import android.view.inputmethod.SelectRangeGesture;

/* JADX INFO: renamed from: androidx.compose.foundation.text.input.internal.d */
/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes.dex */
public abstract /* synthetic */ class AbstractC1346d {
    /* JADX INFO: renamed from: A */
    public static /* bridge */ /* synthetic */ boolean m1235A(Object obj) {
        return obj instanceof RemoveSpaceGesture;
    }

    /* JADX INFO: renamed from: B */
    public static /* bridge */ /* synthetic */ Class m1236B() {
        return InsertGesture.class;
    }

    /* JADX INFO: renamed from: C */
    public static /* bridge */ /* synthetic */ boolean m1237C(Object obj) {
        return obj instanceof JoinOrSplitGesture;
    }

    /* JADX INFO: renamed from: D */
    public static /* bridge */ /* synthetic */ Class m1238D() {
        return RemoveSpaceGesture.class;
    }

    /* JADX INFO: renamed from: h */
    public static /* bridge */ /* synthetic */ DeleteGesture m1246h(Object obj) {
        return (DeleteGesture) obj;
    }

    /* JADX INFO: renamed from: i */
    public static /* bridge */ /* synthetic */ DeleteRangeGesture m1247i(Object obj) {
        return (DeleteRangeGesture) obj;
    }

    /* JADX INFO: renamed from: j */
    public static /* bridge */ /* synthetic */ InsertGesture m1248j(Object obj) {
        return (InsertGesture) obj;
    }

    /* JADX INFO: renamed from: k */
    public static /* bridge */ /* synthetic */ JoinOrSplitGesture m1249k(Object obj) {
        return (JoinOrSplitGesture) obj;
    }

    /* JADX INFO: renamed from: l */
    public static /* bridge */ /* synthetic */ RemoveSpaceGesture m1250l(Object obj) {
        return (RemoveSpaceGesture) obj;
    }

    /* JADX INFO: renamed from: m */
    public static /* bridge */ /* synthetic */ SelectRangeGesture m1251m(Object obj) {
        return (SelectRangeGesture) obj;
    }

    /* JADX INFO: renamed from: n */
    public static /* bridge */ /* synthetic */ Class m1252n() {
        return SelectGesture.class;
    }

    /* JADX INFO: renamed from: r */
    public static /* bridge */ /* synthetic */ boolean m1256r(Object obj) {
        return obj instanceof DeleteGesture;
    }

    /* JADX INFO: renamed from: t */
    public static /* bridge */ /* synthetic */ Class m1258t() {
        return SelectRangeGesture.class;
    }

    /* JADX INFO: renamed from: u */
    public static /* bridge */ /* synthetic */ boolean m1259u(Object obj) {
        return obj instanceof SelectRangeGesture;
    }

    /* JADX INFO: renamed from: v */
    public static /* bridge */ /* synthetic */ Class m1260v() {
        return DeleteRangeGesture.class;
    }

    /* JADX INFO: renamed from: w */
    public static /* bridge */ /* synthetic */ boolean m1261w(Object obj) {
        return obj instanceof DeleteRangeGesture;
    }

    /* JADX INFO: renamed from: x */
    public static /* bridge */ /* synthetic */ Class m1262x() {
        return DeleteGesture.class;
    }

    /* JADX INFO: renamed from: y */
    public static /* bridge */ /* synthetic */ boolean m1263y(Object obj) {
        return obj instanceof InsertGesture;
    }

    /* JADX INFO: renamed from: z */
    public static /* bridge */ /* synthetic */ Class m1264z() {
        return JoinOrSplitGesture.class;
    }
}
