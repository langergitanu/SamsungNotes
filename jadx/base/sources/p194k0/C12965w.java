package p194k0;

import android.text.TextUtils;
import android.util.Log;
import androidx.glance.AbstractC2821a;
import com.google.android.gms.common.data.AbstractC4539a;
import com.samsung.android.sdk.pen.worddoc.SpenWNote;
import com.samsung.android.support.senl.p148nt.data.common.utils.AbstractC11014a;
import java.io.IOException;
import java.io.RandomAccessFile;
import p079T.AbstractC0299q;
import p182g0.C11998h;
import p185h0.InterfaceC12017b;

/* JADX INFO: renamed from: k0.w */
/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes7.dex */
public final class C12965w implements InterfaceC12017b {

    /* JADX INFO: renamed from: a */
    public String f9270a;

    /* JADX INFO: renamed from: b */
    public int f9271b;

    /* JADX INFO: renamed from: c */
    public String f9272c;

    /* JADX INFO: renamed from: d */
    public long f9273d;

    /* JADX INFO: renamed from: e */
    public int f9274e;

    /* JADX INFO: renamed from: g */
    public int f9276g;

    /* JADX INFO: renamed from: h */
    public float f9277h;

    /* JADX INFO: renamed from: m */
    public int f9282m;

    /* JADX INFO: renamed from: n */
    public long f9283n;

    /* JADX INFO: renamed from: o */
    public int f9284o;

    /* JADX INFO: renamed from: f */
    public String f9275f = "";

    /* JADX INFO: renamed from: i */
    public String f9278i = "";

    /* JADX INFO: renamed from: j */
    public int f9279j = -1;

    /* JADX INFO: renamed from: k */
    public int f9280k = -1;

    /* JADX INFO: renamed from: l */
    public String f9281l = "";

    /* JADX INFO: renamed from: p */
    public int f9285p = 0;

    /* JADX INFO: renamed from: q */
    public int f9286q = 0;

    /* JADX INFO: renamed from: r */
    public int f9287r = 0;

    /* JADX INFO: renamed from: s */
    public String f9288s = "";

    /* JADX INFO: renamed from: t */
    public long f9289t = 0;

    /* JADX INFO: renamed from: u */
    public long f9290u = 0;

    /* JADX INFO: renamed from: v */
    public long f9291v = 0;

    /* JADX INFO: renamed from: w */
    public String f9292w = "";

    /* JADX INFO: renamed from: x */
    public int f9293x = SpenWNote.TextDirection.TEXT_DIRECTION_DEFAULT.ordinal();

    /* JADX INFO: renamed from: y */
    public int f9294y = SpenWNote.BackgroundTheme.THEME_DEFAULT.ordinal();

    /* JADX INFO: renamed from: z */
    public long f9295z = -1;

    /* JADX INFO: renamed from: A */
    public int f9267A = 3;

    /* JADX INFO: renamed from: B */
    public int f9268B = 0;

    /* JADX INFO: renamed from: C */
    public String f9269C = "";

    /* JADX INFO: renamed from: a */
    public final void m13868a(C11998h c11998h) {
        this.f9271b = c11998h.f8650H;
        this.f9272c = c11998h.f8677e;
        this.f9273d = c11998h.f8704x;
        this.f9276g = c11998h.f8706z;
        this.f9277h = c11998h.f8643A;
        String str = c11998h.f8679f;
        if (str != null) {
            this.f9278i = str;
        } else {
            this.f9278i = "";
        }
        this.f9279j = c11998h.f8683h;
        this.f9280k = c11998h.f8685i;
        String str2 = c11998h.f8681g;
        if (str2 != null) {
            this.f9281l = str2;
        } else {
            this.f9281l = "";
        }
        this.f9282m = c11998h.f8651I;
        this.f9283n = c11998h.f8702v;
        if (c11998h.f8647E == SpenWNote.Orientation.LANDSCAPE.ordinal()) {
            this.f9274e |= 2;
        }
        this.f9286q = c11998h.f8646D;
        this.f9287r = c11998h.f8648F;
        this.f9288s = c11998h.f8649G;
        this.f9289t = c11998h.f8663U;
        this.f9290u = c11998h.f8664V;
        this.f9291v = c11998h.f8666X;
        this.f9292w = c11998h.f8668Z;
        this.f9293x = c11998h.f8670a0;
        this.f9294y = c11998h.f8672b0;
        this.f9295z = c11998h.f8667Y;
        this.f9267A = c11998h.f8647E;
        this.f9268B = 0;
        this.f9269C = c11998h.f8678e0;
    }

    /* JADX INFO: renamed from: b */
    public final void m13869b(RandomAccessFile randomAccessFile) throws IOException {
        AbstractC0299q.m636j0(randomAccessFile, (this.f9269C.length() * 2) + 4 + (this.f9292w.length() * 2) + 2 + (this.f9288s.length() * 2) + 2 + (this.f9281l.length() * 2) + 2 + (this.f9278i.length() * 2) + 2 + (this.f9275f.length() * 2) + 2 + AbstractC4539a.m3193c(2, 18, this.f9272c) + 8 + 8 + 20 + 32 + 24 + 22);
        AbstractC0299q.m632h0(randomAccessFile, this.f9271b);
        AbstractC0299q.m640l0(randomAccessFile, this.f9272c);
        AbstractC0299q.m634i0(randomAccessFile, this.f9273d);
        AbstractC0299q.m632h0(randomAccessFile, this.f9274e);
        AbstractC0299q.m640l0(randomAccessFile, this.f9275f);
        AbstractC0299q.m632h0(randomAccessFile, this.f9276g);
        AbstractC0299q.m630g0(randomAccessFile, this.f9277h);
        AbstractC0299q.m640l0(randomAccessFile, this.f9278i);
        AbstractC0299q.m632h0(randomAccessFile, this.f9279j);
        AbstractC0299q.m632h0(randomAccessFile, this.f9280k);
        AbstractC0299q.m640l0(randomAccessFile, this.f9281l);
        AbstractC0299q.m632h0(randomAccessFile, this.f9282m);
        AbstractC0299q.m634i0(randomAccessFile, this.f9283n);
        AbstractC0299q.m632h0(randomAccessFile, this.f9284o);
        AbstractC0299q.m636j0(randomAccessFile, this.f9286q);
        AbstractC0299q.m636j0(randomAccessFile, this.f9287r);
        AbstractC0299q.m640l0(randomAccessFile, this.f9288s);
        AbstractC0299q.m632h0(randomAccessFile, 0);
        AbstractC0299q.m632h0(randomAccessFile, 0);
        AbstractC0299q.m634i0(randomAccessFile, this.f9289t);
        AbstractC0299q.m634i0(randomAccessFile, this.f9290u);
        AbstractC0299q.m634i0(randomAccessFile, this.f9291v);
        AbstractC0299q.m640l0(randomAccessFile, this.f9292w);
        AbstractC0299q.m632h0(randomAccessFile, this.f9293x);
        AbstractC0299q.m632h0(randomAccessFile, this.f9294y);
        AbstractC0299q.m634i0(randomAccessFile, this.f9295z);
        AbstractC0299q.m632h0(randomAccessFile, this.f9267A);
        AbstractC0299q.m632h0(randomAccessFile, this.f9268B);
        AbstractC0299q.m642m0(randomAccessFile, this.f9269C);
        AbstractC0299q.m638k0(randomAccessFile, "Document for S-Pen SDK");
    }

    @Override // com.samsung.android.support.senl.cm.base.common.util.VariableComparator.Comparison
    public final boolean isSame(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof C12965w)) {
            return false;
        }
        C12965w c12965w = (C12965w) obj;
        if (this.f9271b != c12965w.f9271b) {
            StringBuilder sb = new StringBuilder(" !! equals() - NE - mFormatVersion[");
            sb.append(this.f9271b);
            sb.append(" - ");
            AbstractC11014a.m12329n(c12965w.f9271b, "]", "WCon_WDocEndTag", sb);
            return false;
        }
        if (!TextUtils.equals(this.f9272c, c12965w.f9272c)) {
            StringBuilder sb2 = new StringBuilder(" !! equals() - NE - mNoteId[");
            sb2.append(this.f9272c);
            sb2.append(" - ");
            AbstractC4539a.m3209s(sb2, c12965w.f9272c, "]", "WCon_WDocEndTag");
            return false;
        }
        if (this.f9273d != c12965w.f9273d) {
            Log.i("WCon_WDocEndTag", " !! equals() - NE - mModifiedTime[" + this.f9273d + " - " + c12965w.f9273d + "]");
            return false;
        }
        if (this.f9274e != c12965w.f9274e) {
            StringBuilder sb3 = new StringBuilder(" !! equals() - NE - mPropertyFlag[");
            sb3.append(this.f9274e);
            sb3.append(" - ");
            AbstractC11014a.m12329n(c12965w.f9274e, "]", "WCon_WDocEndTag", sb3);
            return false;
        }
        if (!TextUtils.equals(this.f9275f, c12965w.f9275f)) {
            StringBuilder sb4 = new StringBuilder(" !! equals() - NE - mCoverImage[");
            sb4.append(this.f9275f);
            sb4.append(" - ");
            AbstractC4539a.m3209s(sb4, c12965w.f9275f, "]", "WCon_WDocEndTag");
            return false;
        }
        if (this.f9276g != c12965w.f9276g) {
            StringBuilder sb5 = new StringBuilder(" !! equals() - NE - mNoteWidth[");
            sb5.append(this.f9276g);
            sb5.append(" - ");
            AbstractC11014a.m12329n(c12965w.f9276g, "]", "WCon_WDocEndTag", sb5);
            return false;
        }
        if (this.f9277h != c12965w.f9277h) {
            StringBuilder sb6 = new StringBuilder(" !! equals() - NE - mNoteHeight[");
            sb6.append(this.f9277h);
            sb6.append(" - ");
            AbstractC2821a.m2234y(sb6, c12965w.f9277h, "]", "WCon_WDocEndTag");
            return false;
        }
        if (!TextUtils.equals(this.f9281l, c12965w.f9281l)) {
            StringBuilder sb7 = new StringBuilder(" !! equals() - NE - mAppPatchName[");
            sb7.append(this.f9281l);
            sb7.append(" - ");
            AbstractC4539a.m3209s(sb7, c12965w.f9281l, "]", "WCon_WDocEndTag");
            return false;
        }
        if (this.f9282m != c12965w.f9282m) {
            StringBuilder sb8 = new StringBuilder(" !! equals() - NE - mMinFormatVersion[");
            sb8.append(this.f9282m);
            sb8.append(" - ");
            AbstractC11014a.m12329n(c12965w.f9282m, "]", "WCon_WDocEndTag", sb8);
            return false;
        }
        if (this.f9283n != c12965w.f9283n) {
            Log.i("WCon_WDocEndTag", " !! equals() - NE - mCreationTime[" + this.f9283n + " - " + c12965w.f9283n + "]");
            return false;
        }
        if (this.f9284o != c12965w.f9284o) {
            StringBuilder sb9 = new StringBuilder(" !! equals() - NE - mLastViewedPageIndex[");
            sb9.append(this.f9284o);
            sb9.append(" - ");
            AbstractC11014a.m12329n(c12965w.f9284o, "]", "WCon_WDocEndTag", sb9);
            return false;
        }
        if (this.f9285p != c12965w.f9285p) {
            StringBuilder sb10 = new StringBuilder(" !! equals() - NE - mOrientation[");
            sb10.append(this.f9285p);
            sb10.append(" - ");
            AbstractC11014a.m12329n(c12965w.f9285p, "]", "WCon_WDocEndTag", sb10);
            return false;
        }
        if (this.f9286q != c12965w.f9286q) {
            StringBuilder sb11 = new StringBuilder(" !! equals() - NE - mPageMode[");
            sb11.append(this.f9286q);
            sb11.append(" - ");
            AbstractC11014a.m12329n(c12965w.f9286q, "]", "WCon_WDocEndTag", sb11);
            return false;
        }
        if (this.f9287r != c12965w.f9287r) {
            StringBuilder sb12 = new StringBuilder(" !! equals() - NE - mDocumentType[");
            sb12.append(this.f9287r);
            sb12.append(" - ");
            AbstractC11014a.m12329n(c12965w.f9287r, "]", "WCon_WDocEndTag", sb12);
            return false;
        }
        if (!TextUtils.equals(this.f9288s, c12965w.f9288s)) {
            StringBuilder sb13 = new StringBuilder(" !! equals() - NE - mOwnerId[");
            sb13.append(this.f9288s);
            sb13.append(" - ");
            AbstractC4539a.m3209s(sb13, c12965w.f9288s, "]", "WCon_WDocEndTag");
            return false;
        }
        if (this.f9289t != c12965w.f9289t) {
            Log.i("WCon_WDocEndTag", " !! equals() - NE - mDisplayCreatedTime[" + this.f9289t + " - " + c12965w.f9289t + "]");
            return false;
        }
        if (this.f9290u != c12965w.f9290u) {
            Log.i("WCon_WDocEndTag", " !! equals() - NE - mDisplayModifiedTime[" + this.f9290u + " - " + c12965w.f9290u + "]");
            return false;
        }
        if (this.f9291v != c12965w.f9291v) {
            Log.i("WCon_WDocEndTag", " !! equals() - NE - mlastRecognizedDataModifiedTime[" + this.f9291v + " - " + c12965w.f9291v + "]");
            return false;
        }
        if (!TextUtils.equals(this.f9292w, c12965w.f9292w)) {
            StringBuilder sb14 = new StringBuilder(" !! equals() - NE - mFixedFont[");
            sb14.append(this.f9292w);
            sb14.append(" - ");
            AbstractC4539a.m3209s(sb14, c12965w.f9292w, "]", "WCon_WDocEndTag");
            return false;
        }
        if (this.f9293x != c12965w.f9293x) {
            StringBuilder sb15 = new StringBuilder(" !! equals() - NE - mFixedTextDirection[");
            sb15.append(this.f9293x);
            sb15.append(" - ");
            AbstractC11014a.m12329n(c12965w.f9293x, "]", "WCon_WDocEndTag", sb15);
            return false;
        }
        if (this.f9294y != c12965w.f9294y) {
            StringBuilder sb16 = new StringBuilder(" !! equals() - NE - mFixedBackgroundTheme[");
            sb16.append(this.f9294y);
            sb16.append(" - ");
            AbstractC11014a.m12329n(c12965w.f9294y, "]", "WCon_WDocEndTag", sb16);
            return false;
        }
        if (this.f9295z != c12965w.f9295z) {
            Log.i("WCon_WDocEndTag", " !! equals() - NE - mServerCheckPoint[" + this.f9295z + " - " + c12965w.f9295z + "]");
            return false;
        }
        if (this.f9267A != c12965w.f9267A) {
            StringBuilder sb17 = new StringBuilder(" !! equals() - NE - mNewOrientation[");
            sb17.append(this.f9267A);
            sb17.append(" - ");
            AbstractC11014a.m12329n(c12965w.f9267A, "]", "WCon_WDocEndTag", sb17);
            return false;
        }
        if (this.f9268B != c12965w.f9268B) {
            StringBuilder sb18 = new StringBuilder(" !! equals() - NE - mMinUnknownVersion[");
            sb18.append(this.f9268B);
            sb18.append(" - ");
            AbstractC11014a.m12329n(c12965w.f9268B, "]", "WCon_WDocEndTag", sb18);
        }
        if (TextUtils.equals(this.f9269C, c12965w.f9269C)) {
            return true;
        }
        StringBuilder sb19 = new StringBuilder(" !! equals() - NE - mAppCustomData[");
        sb19.append(this.f9269C);
        sb19.append(" - ");
        AbstractC4539a.m3209s(sb19, c12965w.f9269C, "]", "WCon_WDocEndTag");
        return false;
    }
}
