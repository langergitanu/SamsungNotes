package p029G0;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.RectF;
import android.text.TextUtils;
import androidx.collection.AbstractC0622a;
import androidx.core.content.ContextCompat;
import com.samsung.android.app.notes.sync.coedit.sharecore.strategy.AbstractC6670b;
import com.samsung.android.sdk.composer.text.SpenBodyTextContext;
import com.samsung.android.sdk.pen.document.SpenObjectTextBox;
import com.samsung.android.sdk.pen.worddoc.SpenWNote;
import com.samsung.android.sdk.pen.worddoc.SpenWPage;
import com.samsung.android.support.notes.sync.C7943R;
import com.samsung.android.support.senl.p145cm.base.framework.support.BaseUtils;
import com.samsung.android.support.senl.p148nt.base.common.NoteCaptureControl;
import com.samsung.android.support.senl.p148nt.base.common.log.MSLogger;
import com.samsung.android.support.senl.p148nt.base.common.sdk.util.SpenSdkInitializer;
import com.samsung.android.support.senl.p148nt.base.common.util.ContextUtils;
import com.samsung.android.support.senl.p148nt.base.common.util.ImageUtils;
import com.samsung.android.support.senl.p148nt.model.documents.file.DocumentFileManager;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import p025F0.C0096k;

/* JADX INFO: renamed from: G0.a */
/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes7.dex */
public final class C0104a {

    /* JADX INFO: renamed from: a */
    public final Context f333a;

    /* JADX INFO: renamed from: b */
    public String f334b;

    /* JADX INFO: renamed from: c */
    public final String f335c;

    /* JADX INFO: renamed from: d */
    public ArrayList f336d;

    /* JADX INFO: renamed from: e */
    public C0096k f337e;

    /* JADX INFO: renamed from: f */
    public final String f338f;

    /* JADX INFO: renamed from: g */
    public final int f339g;

    /* JADX INFO: renamed from: h */
    public int f340h;

    /* JADX INFO: renamed from: i */
    public int f341i;

    /* JADX INFO: renamed from: j */
    public final float f342j;

    /* JADX INFO: renamed from: k */
    public final boolean f343k;

    /* JADX INFO: renamed from: l */
    public final int f344l;

    /* JADX INFO: renamed from: m */
    public int f345m;

    /* JADX INFO: renamed from: n */
    public ArrayList f346n;

    /* JADX INFO: renamed from: o */
    public boolean f347o;

    public C0104a(Context context, String str, String str2, int i) {
        this.f347o = false;
        this.f333a = context;
        this.f335c = str;
        this.f338f = str2;
        this.f339g = i;
        this.f342j = 0.5f;
        this.f343k = false;
        this.f344l = 10;
        this.f336d = new ArrayList();
        this.f346n = new ArrayList();
    }

    /* JADX INFO: renamed from: b */
    public static boolean m247b(SpenWNote spenWNote) {
        for (int i = 1; i <= 23; i++) {
            if (spenWNote.hasObject(i) || spenWNote.hasBodyObject(i)) {
                MSLogger.m8632d("CaptureNote", "note has Object : " + i);
                return false;
            }
        }
        return true;
    }

    /* JADX INFO: renamed from: a */
    public final String m248a() {
        if (TextUtils.isEmpty(this.f334b)) {
            this.f334b = "";
        }
        return this.f334b;
    }

    /* JADX INFO: renamed from: c */
    public final String m249c(String str, int i, int i2, int i4) {
        StringBuilder sb = new StringBuilder();
        sb.append(this.f338f);
        sb.append(File.separator);
        sb.append(str);
        sb.append("(");
        sb.append(i);
        AbstractC0622a.m1180z(sb, i2, i4, "_", "_");
        sb.append(").jpg");
        return sb.toString();
    }

    /* JADX WARN: Removed duplicated region for block: B:136:0x0321  */
    /* JADX WARN: Removed duplicated region for block: B:157:0x033b A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:165:0x0274 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:168:0x0101 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:180:? A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:37:0x00f5  */
    /* JADX WARN: Removed duplicated region for block: B:70:0x01b1  */
    /* JADX WARN: Removed duplicated region for block: B:92:0x025d  */
    /* JADX WARN: Removed duplicated region for block: B:93:0x025e  */
    /* JADX WARN: Removed duplicated region for block: B:98:0x027e  */
    /* JADX INFO: renamed from: d */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final List m250d() throws Throwable {
        Throwable th;
        NoteCaptureControl noteCaptureControl;
        String str;
        String str2;
        String str3;
        String str4;
        StringBuilder sb;
        SpenWNote.PageMode pageMode;
        float f;
        String str5;
        String str6;
        String str7;
        int width;
        Context context;
        SpenWPage spenWPage;
        ArrayList<SpenWPage> arrayList;
        Bitmap bitmapCapturePage;
        int i;
        String str8 = "Failed to close capturePage : ";
        Context context2 = this.f333a;
        StringBuilder sb2 = new StringBuilder("perform. path : ");
        String str9 = this.f335c;
        sb2.append(str9);
        MSLogger.m8632d("CaptureNote", sb2.toString());
        String str10 = null;
        this.f345m = 0;
        ArrayList arrayList2 = new ArrayList();
        this.f346n = arrayList2;
        arrayList2.add(0);
        this.f336d = new ArrayList();
        SpenSdkInitializer.initialize(BaseUtils.getApplicationContext());
        SpenWNote spenWNoteOpen = null;
        try {
            try {
                noteCaptureControl = new NoteCaptureControl(context2);
                try {
                    try {
                        spenWNoteOpen = DocumentFileManager.getInstance().open(this.f333a, this.f335c, this.f339g, 3000, false, false, false);
                        SpenWNote.PageMode pageMode2 = spenWNoteOpen.getPageMode();
                        this.f347o = pageMode2 == SpenWNote.PageMode.SINGLE;
                        this.f334b = spenWNoteOpen.getTitle().getText();
                        try {
                            this.f341i = (ContextUtils.isNightMode(context2) && spenWNoteOpen.getPage(0).getBackgroundColor() == ContextCompat.getColor(context2, C7943R.color.background_color_white) && spenWNoteOpen.isBackgroundColorInverted()) ? 1 : 0;
                            int backgroundColor = spenWNoteOpen.getPage(0).getBackgroundColor();
                            SpenObjectTextBox bodyText = spenWNoteOpen.getBodyText();
                            if (this.f343k || !m247b(spenWNoteOpen)) {
                                ArrayList<SpenWPage> pageList = spenWNoteOpen.getPageList();
                                int pageCount = spenWNoteOpen.getPageCount();
                                pageMode = SpenWNote.PageMode.SINGLE;
                                if (pageMode2 != pageMode) {
                                    pageCount--;
                                }
                                f = 1.0f;
                                int i2 = this.f344l;
                                str5 = "Failed to close capturePage : ";
                                float f4 = this.f342j;
                                try {
                                    try {
                                        if (pageMode2 != pageMode) {
                                            try {
                                                SpenWPage spenWPage2 = pageList.get(0);
                                                width = spenWPage2.getWidth();
                                                int height = spenWPage2.getHeight();
                                                noteCaptureControl.setWNote(spenWNoteOpen);
                                                noteCaptureControl.setContents(spenWPage2, bodyText, 0);
                                                noteCaptureControl.setColorTheme(this.f341i);
                                                float f5 = height;
                                                float f6 = width;
                                                float f7 = 1.414f * f6;
                                                str7 = str9;
                                                str6 = "CaptureNote";
                                                int iFloor = (int) Math.floor(f5 / f7);
                                                if (i2 >= iFloor) {
                                                    i2 = iFloor;
                                                }
                                                int i4 = 0;
                                                while (i4 < i2) {
                                                    float f8 = i4 * f7;
                                                    if (f8 < 0.0f) {
                                                        f8 = 0.0f;
                                                    }
                                                    int i5 = i4 + 1;
                                                    int i6 = i2;
                                                    float f9 = i5 * f7;
                                                    if (f9 > f5) {
                                                        f9 = f5;
                                                    }
                                                    float f10 = f5;
                                                    Bitmap bitmapCaptureRect = noteCaptureControl.captureRect(new RectF(0.0f, f8, f6, f9));
                                                    int i7 = (int) f9;
                                                    String strM249c = m249c(spenWPage2.getId(), i4, width, height);
                                                    if (ImageUtils.makeJpg(bitmapCaptureRect, strM249c, 50, true)) {
                                                        this.f336d.add(strM249c);
                                                        this.f345m = i7;
                                                        this.f346n.add(Integer.valueOf(i7));
                                                    }
                                                    i2 = i6;
                                                    i4 = i5;
                                                    f5 = f10;
                                                }
                                            } catch (RuntimeException e) {
                                                e = e;
                                                str7 = str9;
                                                str6 = "CaptureNote";
                                                str4 = str6;
                                                MSLogger.m8633e(str4, "Runtime Exception occurred. Failed. " + e.getMessage());
                                                throw e;
                                            } catch (Exception e2) {
                                                e = e2;
                                                str7 = str9;
                                                str6 = "CaptureNote";
                                                str = str5;
                                                str2 = str7;
                                                str3 = str6;
                                                MSLogger.m8633e(str3, "Failed. " + e.getMessage());
                                                if (spenWNoteOpen != null && !spenWNoteOpen.isClosed()) {
                                                    try {
                                                        DocumentFileManager.getInstance().close(str2, spenWNoteOpen, true);
                                                    } catch (Exception e3) {
                                                        AbstractC6670b.m4753n(e3, new StringBuilder("Failed to close note : "), str3);
                                                    }
                                                }
                                                if (noteCaptureControl != null) {
                                                    try {
                                                        noteCaptureControl.close();
                                                    } catch (Exception e5) {
                                                        e = e5;
                                                        sb = new StringBuilder(str);
                                                        AbstractC6670b.m4753n(e, sb, str3);
                                                    }
                                                }
                                            } catch (Throwable th2) {
                                                th = th2;
                                                th = th;
                                                str9 = str5;
                                                str8 = str9;
                                                str10 = "CaptureNote";
                                                if (spenWNoteOpen != null) {
                                                }
                                                if (noteCaptureControl == null) {
                                                }
                                            }
                                        } else {
                                            str7 = str9;
                                            str6 = "CaptureNote";
                                            if (i2 < pageCount) {
                                                pageCount = i2;
                                            }
                                            int i8 = 100;
                                            int i9 = 0;
                                            while (i9 < pageCount) {
                                                SpenWPage spenWPage3 = pageList.get(i9);
                                                int width2 = spenWPage3.getWidth();
                                                int height2 = spenWPage3.getHeight();
                                                noteCaptureControl.setWNote(spenWNoteOpen);
                                                noteCaptureControl.setContents(spenWPage3, bodyText, i9);
                                                noteCaptureControl.setColorTheme(this.f341i);
                                                if (i9 == pageCount - 1) {
                                                    SpenBodyTextContext spenBodyTextContext = new SpenBodyTextContext(context2);
                                                    spenBodyTextContext.setDocument(spenWNoteOpen);
                                                    spenBodyTextContext.measureTextToPage(i9);
                                                    new RectF();
                                                    context = context2;
                                                    RectF measuredFitRect = spenBodyTextContext.getMeasuredFitRect(i9);
                                                    spenBodyTextContext.close();
                                                    float fMax = Math.max(spenWPage3.getDrawnRectOfAllObject().bottom, measuredFitRect.bottom);
                                                    if (fMax <= 1.0f || fMax > height2) {
                                                        fMax = height2;
                                                    }
                                                    i = (int) (fMax * f4);
                                                    spenWPage = spenWPage3;
                                                    arrayList = pageList;
                                                    bitmapCapturePage = Bitmap.createBitmap(noteCaptureControl.capturePage(f4), 0, 0, (int) (width2 * f4), i);
                                                } else {
                                                    context = context2;
                                                    spenWPage = spenWPage3;
                                                    arrayList = pageList;
                                                    bitmapCapturePage = noteCaptureControl.capturePage(f4);
                                                    i = (int) (height2 * f4);
                                                }
                                                String strM249c2 = m249c(spenWPage.getId(), i9, width2, height2);
                                                if (ImageUtils.makeJpg(bitmapCapturePage, strM249c2, 50, true)) {
                                                    this.f336d.add(strM249c2);
                                                    int i10 = this.f345m + i;
                                                    this.f345m = i10;
                                                    this.f346n.add(Integer.valueOf(i10));
                                                }
                                                i9++;
                                                i8 = width2;
                                                context2 = context;
                                                pageList = arrayList;
                                            }
                                            width = i8;
                                        }
                                        float f11 = width;
                                    } catch (Throwable th3) {
                                        th = th3;
                                    }
                                    try {
                                        if (pageMode2 == SpenWNote.PageMode.SINGLE) {
                                            f = f4;
                                        }
                                        this.f340h = (int) (f11 * f);
                                        C0096k c0096k = new C0096k(bodyText);
                                        this.f337e = c0096k;
                                        c0096k.f317b = backgroundColor;
                                        if (spenWNoteOpen.isClosed()) {
                                            str3 = str6;
                                            noteCaptureControl.close();
                                        } else {
                                            try {
                                                DocumentFileManager.getInstance().close(str7, spenWNoteOpen, true);
                                                str3 = str6;
                                            } catch (Exception e6) {
                                                str3 = str6;
                                                AbstractC6670b.m4753n(e6, new StringBuilder("Failed to close note : "), str3);
                                            }
                                            try {
                                                noteCaptureControl.close();
                                            } catch (Exception e7) {
                                                e = e7;
                                                sb = new StringBuilder(str5);
                                                AbstractC6670b.m4753n(e, sb, str3);
                                            }
                                        }
                                    } catch (Throwable th4) {
                                        th = th4;
                                        str9 = str5;
                                        str8 = str7;
                                        str10 = str6;
                                        th = th;
                                        if (spenWNoteOpen != null) {
                                            try {
                                                DocumentFileManager.getInstance().close(str8, spenWNoteOpen, true);
                                            } catch (Exception e8) {
                                                AbstractC6670b.m4753n(e8, new StringBuilder("Failed to close note : "), str10);
                                            }
                                        }
                                        if (noteCaptureControl == null) {
                                        }
                                    }
                                } catch (RuntimeException e9) {
                                    e = e9;
                                } catch (Exception e10) {
                                    e = e10;
                                }
                            } else {
                                int pageCount2 = spenWNoteOpen.getPageCount();
                                for (int i11 = 0; i11 < pageCount2; i11++) {
                                    SpenWPage page = spenWNoteOpen.getPage(i11);
                                    if (page != null && page.hasPDF()) {
                                        ArrayList<SpenWPage> pageList2 = spenWNoteOpen.getPageList();
                                        int pageCount3 = spenWNoteOpen.getPageCount();
                                        pageMode = SpenWNote.PageMode.SINGLE;
                                        if (pageMode2 != pageMode) {
                                        }
                                        f = 1.0f;
                                        int i22 = this.f344l;
                                        str5 = "Failed to close capturePage : ";
                                        float f42 = this.f342j;
                                        if (pageMode2 != pageMode) {
                                        }
                                        float f112 = width;
                                        if (pageMode2 == SpenWNote.PageMode.SINGLE) {
                                        }
                                        this.f340h = (int) (f112 * f);
                                        C0096k c0096k2 = new C0096k(bodyText);
                                        this.f337e = c0096k2;
                                        c0096k2.f317b = backgroundColor;
                                        if (spenWNoteOpen.isClosed()) {
                                        }
                                    }
                                }
                                MSLogger.m8632d("CaptureNote", "Note has only text.");
                                C0096k c0096k3 = new C0096k(bodyText);
                                this.f337e = c0096k3;
                                c0096k3.f317b = backgroundColor;
                                str5 = "Failed to close capturePage : ";
                                str7 = str9;
                                str6 = "CaptureNote";
                                if (spenWNoteOpen.isClosed()) {
                                }
                            }
                        } catch (Throwable th5) {
                            th = th5;
                            str9 = "Failed to close capturePage : ";
                            str8 = str9;
                            str10 = "CaptureNote";
                            th = th;
                            if (spenWNoteOpen != null && !spenWNoteOpen.isClosed()) {
                                DocumentFileManager.getInstance().close(str8, spenWNoteOpen, true);
                            }
                            if (noteCaptureControl == null) {
                                throw th;
                            }
                            try {
                                noteCaptureControl.close();
                                throw th;
                            } catch (Exception e11) {
                                AbstractC6670b.m4753n(e11, new StringBuilder(str9), str10);
                                throw th;
                            }
                        }
                    } catch (Throwable th6) {
                        th = th6;
                    }
                } catch (RuntimeException e12) {
                    e = e12;
                    str4 = "CaptureNote";
                } catch (Exception e13) {
                    e = e13;
                    str = "Failed to close capturePage : ";
                    str2 = str9;
                    str3 = "CaptureNote";
                }
            } catch (Throwable th7) {
                th = th7;
            }
        } catch (RuntimeException e14) {
            e = e14;
            str4 = "CaptureNote";
        } catch (Exception e15) {
            e = e15;
            str = "Failed to close capturePage : ";
            str2 = str9;
            str3 = "CaptureNote";
            noteCaptureControl = null;
        } catch (Throwable th8) {
            str9 = "Failed to close capturePage : ";
            str8 = str9;
            str10 = "CaptureNote";
            th = th8;
            noteCaptureControl = null;
        }
        return this.f336d;
    }

    public C0104a(Context context, String str, String str2, int i, int i2, boolean z) {
        this.f347o = false;
        this.f333a = context;
        this.f335c = str;
        this.f338f = str2;
        this.f339g = i;
        this.f342j = 1.0f;
        this.f343k = z;
        this.f344l = i2;
        this.f336d = new ArrayList();
        this.f346n = new ArrayList();
    }
}
