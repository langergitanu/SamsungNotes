package p038I1;

import com.samsung.android.app.notes.sync.constants.DocTypeConstants;

/* JADX INFO: renamed from: I1.a */
/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes7.dex */
public abstract /* synthetic */ class AbstractC0125a {

    /* JADX INFO: renamed from: a */
    public static final /* synthetic */ int[] f388a;

    static {
        int[] iArr = new int[DocTypeConstants.values().length];
        f388a = iArr;
        try {
            iArr[DocTypeConstants.MEMO_SCLOUD.ordinal()] = 1;
        } catch (NoSuchFieldError unused) {
        }
        try {
            f388a[DocTypeConstants.MEMO_LOCAL.ordinal()] = 2;
        } catch (NoSuchFieldError unused2) {
        }
        try {
            f388a[DocTypeConstants.MEMO_GOOGLEDRIVE.ordinal()] = 3;
        } catch (NoSuchFieldError unused3) {
        }
        try {
            f388a[DocTypeConstants.SNOTE_SCLOUD.ordinal()] = 4;
        } catch (NoSuchFieldError unused4) {
        }
        try {
            f388a[DocTypeConstants.SNOTE_LOCAL.ordinal()] = 5;
        } catch (NoSuchFieldError unused5) {
        }
        try {
            f388a[DocTypeConstants.SNOTE_GOOGLEDRIVE.ordinal()] = 6;
        } catch (NoSuchFieldError unused6) {
        }
        try {
            f388a[DocTypeConstants.SCRAPBOOK_SCLOUD.ordinal()] = 7;
        } catch (NoSuchFieldError unused7) {
        }
        try {
            f388a[DocTypeConstants.SDOC.ordinal()] = 8;
        } catch (NoSuchFieldError unused8) {
        }
    }
}
