package p194k0;

import android.text.TextUtils;
import android.util.Log;
import androidx.glance.AbstractC2821a;
import com.google.android.gms.common.data.AbstractC4539a;
import com.samsung.android.support.senl.p148nt.data.common.utils.AbstractC11014a;
import java.util.ArrayList;
import java.util.Iterator;
import p079T.AbstractC0299q;
import p185h0.InterfaceC12017b;
import p186h1.C12020a;
import p198l0.AbstractC13493b;
import p198l0.AbstractC13495d;
import p198l0.C13492a;
import p198l0.C13494c;

/* JADX INFO: renamed from: k0.r */
/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes7.dex */
public final class C12960r implements InterfaceC12017b {

    /* JADX INFO: renamed from: a */
    public String f9243a;

    /* JADX INFO: renamed from: e */
    public float f9247e;

    /* JADX INFO: renamed from: f */
    public float f9248f;

    /* JADX INFO: renamed from: g */
    public float f9249g;

    /* JADX INFO: renamed from: h */
    public float f9250h;

    /* JADX INFO: renamed from: i */
    public byte f9251i;

    /* JADX INFO: renamed from: b */
    public ArrayList f9244b = new ArrayList();

    /* JADX INFO: renamed from: c */
    public ArrayList f9245c = new ArrayList();

    /* JADX INFO: renamed from: d */
    public ArrayList f9246d = new ArrayList();

    /* JADX INFO: renamed from: j */
    public ArrayList f9252j = new ArrayList();

    /* JADX INFO: renamed from: a */
    public final void m13854a(C12020a c12020a, int i, int i2) {
        int iM3193c;
        String str = this.f9243a;
        if (str != null) {
            c12020a.m13649v(i, str.length());
            int i4 = i + 4;
            c12020a.m13626E(i4, this.f9243a);
            iM3193c = AbstractC4539a.m3193c(2, i4, this.f9243a);
        } else {
            c12020a.m13649v(i, 0);
            iM3193c = i + 4;
        }
        int iMo14272i = iM3193c + 4;
        int i5 = 0;
        for (AbstractC13495d abstractC13495d : this.f9244b) {
            int i6 = abstractC13495d.f9471a;
            if (i6 != 15 && i6 != 16 && i6 != 18) {
                c12020a.m13647t(iMo14272i, abstractC13495d.mo14273j());
                int i7 = iMo14272i + 2;
                iMo14272i += (abstractC13495d.mo14272i(c12020a, i7) + i7) - iMo14272i;
                i5++;
            }
        }
        c12020a.m13649v(iM3193c, i5);
        int i8 = (iMo14272i - iM3193c) + iM3193c;
        int iMo14265h = i8 + 4;
        int i9 = 0;
        for (AbstractC13493b abstractC13493b : this.f9245c) {
            c12020a.m13647t(iMo14265h, abstractC13493b.mo14266i());
            int i10 = iMo14265h + 2;
            iMo14265h += (abstractC13493b.mo14265h(c12020a, i10) + i10) - iMo14265h;
            i9++;
        }
        c12020a.m13649v(i8, i9);
        int i11 = (iMo14265h - i8) + i8;
        c12020a.m13648u(this.f9247e, i11);
        c12020a.m13648u(this.f9248f, i11 + 4);
        c12020a.m13648u(this.f9249g, i11 + 8);
        c12020a.m13648u(this.f9250h, i11 + 12);
        c12020a.m13646s(i11 + 16, this.f9251i);
        c12020a.m13647t(i11 + 17, this.f9252j.size());
        int i12 = i11 + 19;
        for (C13494c c13494c : this.f9252j) {
            c12020a.m13649v(i12, c13494c.f9469a);
            c12020a.m13649v(i12 + 4, c13494c.f9470b);
            i12 += 8;
        }
        if (i2 >= 2035) {
            boolean zIsEmpty = this.f9246d.isEmpty();
            c12020a.m13649v(i12, !zIsEmpty ? 1 : 0);
            c12020a.m13649v(i12 + 4, 0);
            int i13 = i12 + 8;
            if (zIsEmpty) {
                return;
            }
            c12020a.m13649v(i13, this.f9246d.size());
            int i14 = i12 + 12;
            for (C13492a c13492a : this.f9246d) {
                c12020a.m13649v(i14, c13492a.f9460a.mo13814n() + 20);
                int i15 = i14 + 4;
                int iMo13814n = c13492a.f9460a.mo13814n();
                c12020a.m13649v(i15, iMo13814n);
                c12020a.m13649v(i14 + 8, c13492a.f9460a.f8990a);
                int i16 = i14 + 12;
                c13492a.f9460a.mo13813m(c12020a, i16);
                int i17 = i16 + iMo13814n;
                c12020a.m13649v(i17, c13492a.f9462c);
                c12020a.m13649v(i17 + 4, c13492a.f9464e);
                c12020a.m13649v(i17 + 8, c13492a.f9465f);
                i14 = ((i17 + 12) - i15) + i15;
            }
        }
    }

    /* JADX INFO: renamed from: b */
    public final int m13855b(int i) {
        String str = this.f9243a;
        int iMo13814n = 4;
        int iM3193c = str != null ? AbstractC4539a.m3193c(2, 4, str) : 4;
        int iMo14273j = 4;
        for (AbstractC13495d abstractC13495d : this.f9244b) {
            if (abstractC13495d != null) {
                int i2 = abstractC13495d.f9471a;
                if (i2 == 15 || i2 == 16 || i2 == 18) {
                    Log.w("WCon_TextCommon", "GetBinarySize - skip type = " + i2);
                } else {
                    iMo14273j = abstractC13495d.mo14273j() + 2 + iMo14273j;
                }
            }
        }
        int i4 = iM3193c + iMo14273j;
        int iMo14266i = 4;
        for (AbstractC13493b abstractC13493b : this.f9245c) {
            if (abstractC13493b != null) {
                iMo14266i += abstractC13493b.mo14266i() + 2;
            }
        }
        int size = (this.f9252j.size() * 8) + i4 + iMo14266i + 19;
        if (i < 2035) {
            return size;
        }
        int i5 = size + 8;
        if (this.f9246d.isEmpty()) {
            return i5;
        }
        Iterator it = this.f9246d.iterator();
        while (it.hasNext()) {
            iMo13814n = iMo13814n + 4 + ((C13492a) it.next()).f9460a.mo13814n() + 20;
        }
        return i5 + iMo13814n;
    }

    @Override // com.samsung.android.support.senl.cm.base.common.util.VariableComparator.Comparison
    public final boolean isSame(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof C12960r)) {
            return false;
        }
        C12960r c12960r = (C12960r) obj;
        if (!TextUtils.equals(this.f9243a, c12960r.f9243a) && ((this.f9243a != null || TextUtils.equals(c12960r.f9243a, "")) && (TextUtils.equals(this.f9243a, "") || c12960r.f9243a != null))) {
            StringBuilder sb = new StringBuilder(" !! equals() - NE - text[");
            sb.append(this.f9243a);
            sb.append(" - ");
            AbstractC4539a.m3209s(sb, c12960r.f9243a, "]", "WCon_TextCommon");
            return false;
        }
        if (this.f9247e != c12960r.f9247e) {
            StringBuilder sb2 = new StringBuilder(" !! equals() - NE - leftMargin[");
            sb2.append(this.f9247e);
            sb2.append(" - ");
            AbstractC2821a.m2234y(sb2, c12960r.f9247e, "]", "WCon_TextCommon");
            return false;
        }
        if (this.f9248f != c12960r.f9248f) {
            StringBuilder sb3 = new StringBuilder(" !! equals() - NE - topMargin[");
            sb3.append(this.f9248f);
            sb3.append(" - ");
            AbstractC2821a.m2234y(sb3, c12960r.f9248f, "]", "WCon_TextCommon");
            return false;
        }
        if (this.f9249g != c12960r.f9249g) {
            StringBuilder sb4 = new StringBuilder(" !! equals() - NE - rightMargin[");
            sb4.append(this.f9249g);
            sb4.append(" - ");
            AbstractC2821a.m2234y(sb4, c12960r.f9249g, "]", "WCon_TextCommon");
            return false;
        }
        if (this.f9250h != c12960r.f9250h) {
            StringBuilder sb5 = new StringBuilder(" !! equals() - NE - mFileId[");
            sb5.append(this.f9250h);
            sb5.append(" - ");
            AbstractC2821a.m2234y(sb5, c12960r.f9250h, "]", "WCon_TextCommon");
            return false;
        }
        if (this.f9251i != c12960r.f9251i) {
            StringBuilder sb6 = new StringBuilder(" !! equals() - NE - textGravity[");
            sb6.append((int) this.f9251i);
            sb6.append(" - ");
            AbstractC11014a.m12329n(c12960r.f9251i, "]", "WCon_TextCommon", sb6);
            return false;
        }
        if (AbstractC0299q.m631h(this.f9252j, c12960r.f9252j)) {
            return true;
        }
        Log.i("WCon_TextCommon", " !! equals() - NE - mObjectList[" + this.f9252j + " - " + c12960r.f9252j + "]");
        return false;
    }
}
