package p198l0;

import android.util.Log;
import androidx.compose.foundation.layout.AbstractC1038a;
import com.samsung.android.app.notes.sync.converters.data.resource.object.internal.textstyle.WDocBulletParagraph$Type;
import com.samsung.android.support.senl.p148nt.data.common.utils.AbstractC11014a;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Iterator;
import opennlp.tools.parser.Parse;
import p186h1.C12020a;

/* JADX INFO: renamed from: l0.h */
/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes7.dex */
public final class C13499h extends AbstractC13493b {

    /* JADX INFO: renamed from: d */
    public int f9479d;

    /* JADX INFO: renamed from: e */
    public int f9480e;

    /* JADX INFO: renamed from: f */
    public boolean f9481f;

    /* JADX INFO: renamed from: g */
    public ArrayList f9482g;

    public C13499h() {
        super(5);
        this.f9479d = WDocBulletParagraph$Type.TYPE_NONE.ordinal();
        this.f9482g = new ArrayList();
    }

    @Override // p198l0.AbstractC13493b, p185h0.InterfaceC12016a
    /* JADX INFO: renamed from: a */
    public final String mo13615a() {
        return "bullet";
    }

    @Override // p198l0.AbstractC13493b
    /* JADX INFO: renamed from: f */
    public final int mo14263f(C12020a c12020a, int i) {
        int iMo14263f = super.mo14263f(c12020a, i) + i;
        this.f9479d = ((ByteBuffer) c12020a.f8772b).getInt(iMo14263f);
        int i2 = ((ByteBuffer) c12020a.f8772b).getInt(iMo14263f + 4);
        int i4 = iMo14263f + 8;
        int iM1200a = 0;
        if (this.f9479d == WDocBulletParagraph$Type.TYPE_DIGIT.ordinal() || this.f9479d == WDocBulletParagraph$Type.TYPE_CIRCLED_DIGIT.ordinal() || this.f9479d == WDocBulletParagraph$Type.TYPE_ALPHABET.ordinal() || this.f9479d == WDocBulletParagraph$Type.TYPE_ROMAN_NUMERAL.ordinal()) {
            this.f9480e = i2;
        } else if (this.f9479d == WDocBulletParagraph$Type.TYPE_CHECKER.ordinal()) {
            this.f9481f = i2 != 0;
        }
        int i5 = ((ByteBuffer) c12020a.f8772b).getInt(i4);
        int i6 = iMo14263f + 12;
        if (i5 > 0) {
            this.f9482g.clear();
            while (iM1200a < i5) {
                int i7 = ((ByteBuffer) c12020a.f8772b).getInt(i6);
                i6 += 4;
                iM1200a = AbstractC1038a.m1200a(i7, iM1200a, 1, this.f9482g);
            }
        }
        return i6 - i;
    }

    @Override // p198l0.AbstractC13493b
    /* JADX INFO: renamed from: g */
    public final void mo14264g(AbstractC13493b abstractC13493b) {
        super.mo14264g(abstractC13493b);
        if (abstractC13493b instanceof C13499h) {
            C13499h c13499h = (C13499h) abstractC13493b;
            this.f9479d = c13499h.f9479d;
            this.f9481f = c13499h.f9481f;
            this.f9480e = c13499h.f9480e;
            this.f9482g = c13499h.f9482g;
        }
    }

    @Override // p198l0.AbstractC13493b
    /* JADX INFO: renamed from: h */
    public final int mo14265h(C12020a c12020a, int i) {
        int i2;
        int iMo14265h = super.mo14265h(c12020a, i) + i;
        c12020a.m13649v(iMo14265h, this.f9479d);
        int i4 = iMo14265h + 4;
        if (this.f9479d == WDocBulletParagraph$Type.TYPE_DIGIT.ordinal() || this.f9479d == WDocBulletParagraph$Type.TYPE_CIRCLED_DIGIT.ordinal() || this.f9479d == WDocBulletParagraph$Type.TYPE_ALPHABET.ordinal() || this.f9479d == WDocBulletParagraph$Type.TYPE_ROMAN_NUMERAL.ordinal()) {
            i2 = this.f9480e;
        } else {
            i2 = 0;
            if (this.f9479d == WDocBulletParagraph$Type.TYPE_CHECKER.ordinal() && this.f9481f) {
                i2 = 1;
            }
        }
        c12020a.m13649v(i4, i2);
        c12020a.m13649v(iMo14265h + 8, this.f9482g.size());
        int i5 = iMo14265h + 12;
        Iterator it = this.f9482g.iterator();
        while (it.hasNext()) {
            c12020a.m13649v(i5, ((Integer) it.next()).intValue());
            i5 += 4;
        }
        return i5 - i;
    }

    @Override // p198l0.AbstractC13493b
    /* JADX INFO: renamed from: i */
    public final int mo14266i() {
        return (this.f9482g.size() * 4) + 24;
    }

    @Override // p198l0.AbstractC13493b, com.samsung.android.support.senl.cm.base.common.util.VariableComparator.Comparison
    public final boolean isSame(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof C13499h)) {
            return false;
        }
        C13499h c13499h = (C13499h) obj;
        if (!super.isSame(obj)) {
            Log.i("WCon_BulletParagraph", " !! equals() - NE - super check");
            return false;
        }
        if (this.f9479d != c13499h.f9479d) {
            StringBuilder sb = new StringBuilder(" !! equals() - NE - mBulletType[");
            sb.append(this.f9479d);
            sb.append(" - ");
            AbstractC11014a.m12329n(c13499h.f9479d, "]", "WCon_BulletParagraph", sb);
            return false;
        }
        if (this.f9480e != c13499h.f9480e) {
            StringBuilder sb2 = new StringBuilder(" !! equals() - NE - mNumber[");
            sb2.append(this.f9480e);
            sb2.append(" - ");
            AbstractC11014a.m12329n(c13499h.f9480e, "]", "WCon_BulletParagraph", sb2);
            return false;
        }
        if (this.f9481f != c13499h.f9481f) {
            StringBuilder sb3 = new StringBuilder(" !! equals() - NE - isChecked[");
            sb3.append(this.f9481f);
            sb3.append(" - ");
            AbstractC11014a.m12339x(sb3, "]", "WCon_BulletParagraph", c13499h.f9481f);
            return false;
        }
        if (this.f9482g == c13499h.f9482g) {
            return true;
        }
        Log.i("WCon_BulletParagraph", " !! equals() - NE - mBulletTypeList[" + this.f9482g.toString() + " - " + c13499h.f9482g.toString() + "]");
        return false;
    }

    @Override // p198l0.AbstractC13493b
    /* JADX INFO: renamed from: j */
    public final String mo14267j() {
        StringBuilder sb = new StringBuilder();
        sb.append(this.f9479d);
        sb.append(',');
        if (this.f9479d == WDocBulletParagraph$Type.TYPE_CHECKER.ordinal()) {
            sb.append(this.f9481f);
        } else {
            sb.append(this.f9480e);
        }
        if (this.f9482g.size() > 0) {
            sb.append(",{");
            for (int i = 0; i < this.f9482g.size(); i++) {
                sb.append(this.f9482g.get(i));
                if (i != this.f9482g.size() - 1) {
                    sb.append(',');
                }
            }
            sb.append("}");
        }
        return sb.toString();
    }

    @Override // p198l0.AbstractC13493b
    /* JADX INFO: renamed from: k */
    public final boolean mo14268k(String str) {
        String strTrim;
        String strTrim2;
        if (str.split(",", -1).length < 2) {
            Log.e("WCon_BulletParagraph", "setProperty - fail : ".concat(str));
            return false;
        }
        try {
            int iIndexOf = str.indexOf(44);
            if (iIndexOf == -1) {
                Log.e("WCon_BulletParagraph", "setProperty - fail, missing first comma: ".concat(str));
                return false;
            }
            this.f9479d = Integer.parseInt(str.substring(0, iIndexOf).trim());
            int i = iIndexOf + 1;
            int iIndexOf2 = str.indexOf(44, i);
            if (iIndexOf2 == -1) {
                strTrim = str.substring(i).trim();
                strTrim2 = null;
            } else {
                strTrim = str.substring(i, iIndexOf2).trim();
                strTrim2 = str.substring(iIndexOf2 + 1).trim();
            }
            if (this.f9479d == WDocBulletParagraph$Type.TYPE_CHECKER.ordinal()) {
                this.f9481f = Boolean.parseBoolean(strTrim);
            } else {
                this.f9480e = Integer.parseInt(strTrim);
            }
            this.f9482g.clear();
            if (strTrim2 != null && strTrim2.startsWith(Parse.BRACKET_LCB) && strTrim2.endsWith("}")) {
                String strSubstring = strTrim2.substring(1, strTrim2.length() - 1);
                if (!strSubstring.isEmpty()) {
                    for (String str2 : strSubstring.split(",")) {
                        this.f9482g.add(Integer.valueOf(Integer.parseInt(str2.trim())));
                    }
                }
            }
            return true;
        } catch (Exception e) {
            Log.e("WCon_BulletParagraph", "setProperty - Failed to parse property string: ".concat(str), e);
            return false;
        }
    }
}
