package p033H0;

import android.text.TextUtils;
import android.util.Log;
import androidx.constraintlayout.motion.widget.AbstractC2322a;
import com.microsoft.identity.client.IAccount;
import com.samsung.android.app.notes.sync.coedit.controllers.InterfaceC6665a;
import com.samsung.android.app.notes.sync.microsoft.graph.http.NoteHttpTask;
import com.samsung.android.app.notes.sync.network.InterfaceC6846k;
import com.samsung.android.app.notes.sync.p135db.C6742k;
import com.samsung.android.app.notes.sync.saccount.samsungaccountclient.C6878e;
import com.samsung.android.app.notes.sync.saccount.samsungaccountclient.C6880g;
import com.samsung.android.sdk.mobileservice.social.group.GroupMember;
import com.samsung.android.sdk.mobileservice.social.group.result.GroupMemberResult;
import com.samsung.android.support.senl.p148nt.base.common.log.Debugger;
import com.samsung.android.support.senl.p148nt.base.common.log.MSLogger;
import com.samsung.android.support.senl.p148nt.base.common.sync.EncryptUtil;
import com.samsung.android.support.senl.p148nt.base.common.sync.IAuthInfoReqListener;
import com.samsung.android.support.senl.p148nt.base.common.util.Base64Utils;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.concurrent.CompletableFuture;
import p003A1.C0012a;
import p037I0.C0124c;
import p037I0.InterfaceC0122a;
import p037I0.InterfaceC0123b;
import p042J1.C0145c;
import p075S.AbstractC0254f;
import p086V.C0322h;
import p185h0.InterfaceC12016a;
import p198l0.AbstractC13493b;
import p198l0.AbstractC13495d;
import p198l0.C13492a;
import p198l0.C13494c;
import p198l0.C13496e;
import p198l0.C13499h;
import p198l0.C13507p;
import p198l0.C13509r;
import p198l0.C13510s;
import p198l0.C13511t;
import p198l0.C13512u;
import p198l0.C13513v;
import p201m0.C13522c;
import p201m0.C13524e;
import p234q1.C14433b;

/* JADX INFO: renamed from: H0.b */
/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes7.dex */
public final class C0112b implements InterfaceC0122a, InterfaceC6665a, InterfaceC6846k {

    /* JADX INFO: renamed from: c */
    public static C0112b f361c;

    /* JADX INFO: renamed from: a */
    public Object f362a;

    /* JADX INFO: renamed from: b */
    public Object f363b;

    public /* synthetic */ C0112b(Object obj, Object obj2) {
        this.f363b = obj;
        this.f362a = obj2;
    }

    /* JADX INFO: renamed from: c */
    public static String m257c(ArrayList arrayList) {
        StringBuilder sb = new StringBuilder();
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            InterfaceC12016a interfaceC12016a = (InterfaceC12016a) it.next();
            sb.append(' ');
            sb.append(interfaceC12016a.mo13618d());
        }
        return sb.toString();
    }

    /* JADX INFO: renamed from: d */
    public static String m258d(ArrayList arrayList) {
        StringBuilder sb = new StringBuilder();
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            InterfaceC12016a interfaceC12016a = (InterfaceC12016a) it.next();
            sb.append(' ');
            sb.append(interfaceC12016a.mo13619e());
            if (interfaceC12016a.end() - interfaceC12016a.start() < 0) {
                sb.append(' ');
                sb.append(interfaceC12016a.mo13618d());
            }
        }
        return sb.toString();
    }

    /* JADX INFO: renamed from: e */
    public static ArrayList m259e(int i, ArrayList arrayList) {
        ArrayList arrayList2 = new ArrayList();
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            InterfaceC12016a interfaceC12016a = (InterfaceC12016a) it.next();
            interfaceC12016a.getClass();
            if (interfaceC12016a.end() < i) {
                it.remove();
            } else {
                if (interfaceC12016a.end() > i) {
                    break;
                }
                arrayList2.add(interfaceC12016a);
                it.remove();
            }
        }
        return arrayList2;
    }

    /* JADX INFO: renamed from: f */
    public static ArrayList m260f(int i, ArrayList arrayList) {
        ArrayList arrayList2 = new ArrayList();
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            InterfaceC12016a interfaceC12016a = (InterfaceC12016a) it.next();
            if (interfaceC12016a.start() < i) {
                if (i == 0) {
                    arrayList2.add(interfaceC12016a);
                }
                it.remove();
            } else {
                if (interfaceC12016a.start() > i) {
                    break;
                }
                arrayList2.add(interfaceC12016a);
                it.remove();
            }
        }
        return arrayList2;
    }

    /* JADX INFO: renamed from: h */
    public static synchronized C0112b m261h() {
        try {
            if (f361c == null) {
                C0112b c0112b = new C0112b();
                c0112b.f362a = null;
                c0112b.f363b = null;
                f361c = c0112b;
            }
        } catch (Throwable th) {
            throw th;
        }
        return f361c;
    }

    /* JADX INFO: renamed from: i */
    public static void m262i(InterfaceC0123b interfaceC0123b) {
        MSLogger.m8632d("GraphHttpHelper", "getUser");
        new NoteHttpTask("https://graph.microsoft.com/v1.0/me", "GET", "application/json", null, new C14433b(interfaceC0123b, 4)).execute(new Void[0]);
    }

    /* JADX INFO: renamed from: n */
    public static void m263n(ArrayList arrayList, StringBuilder sb, StringBuilder sb2, StringBuilder sb3, boolean z) {
        try {
            if (arrayList.isEmpty()) {
                return;
            }
            if (sb.length() > 0) {
                if (sb2.length() > 0) {
                    sb2.insert(0, "<?a");
                    sb2.append("?>");
                    sb3.append((CharSequence) sb2);
                    sb2.delete(0, sb2.length());
                }
                sb3.append(Base64Utils.encodeBase64(sb.toString()));
                sb.delete(0, sb.length());
            }
            if (z) {
                sb2.append(m258d(arrayList));
            } else {
                sb2.append(m257c(arrayList));
            }
        } catch (Exception unused) {
            Log.d("WConverter_WRichTextParser", "fail encoding base64 : " + sb.toString());
            throw new IllegalArgumentException("fail encoding base64!!");
        }
    }

    @Override // com.samsung.android.app.notes.sync.network.InterfaceC6846k
    /* JADX INFO: renamed from: a */
    public void mo264a(int i) {
        C0012a c0012a = (C0012a) ((C14433b) this.f362a).f10228b;
        if (i == 0) {
            C0322h.m670a().f829o.deleteCategorySync(c0012a.f262e, (String) this.f363b);
            if (c0012a.f79t) {
                return;
            }
            c0012a.f79t = true;
        }
    }

    /* JADX INFO: renamed from: b */
    public boolean m265b() {
        String str = (String) this.f363b;
        if (str == null) {
            return false;
        }
        try {
            this.f362a = AbstractC0254f.m538d(str);
        } catch (Exception e) {
            Debugger.m8607d("SesCoeditGroupUserNameCache", "cacheGroupMemberInfo() : " + e.toString());
        }
        return ((GroupMemberResult) this.f362a) != null;
    }

    @Override // p037I0.InterfaceC0122a
    /* JADX INFO: renamed from: g */
    public void mo252g(C0124c c0124c) {
        MSLogger.m8632d("UpdateNote", "result updateNoteExtension");
        C6742k.m4840c((C6742k) this.f363b, (CompletableFuture) this.f362a, "finished update Note Extension.");
    }

    /* JADX INFO: renamed from: j */
    public String m266j(String str) {
        GroupMember next;
        List<GroupMember> groupMembers;
        GroupMemberResult groupMemberResult = (GroupMemberResult) this.f362a;
        if (groupMemberResult == null || (groupMembers = groupMemberResult.getGroupMembers()) == null) {
            next = null;
        } else {
            Iterator<GroupMember> it = groupMembers.iterator();
            while (it.hasNext()) {
                next = it.next();
                if (str.equals(next.getId())) {
                    break;
                }
            }
            next = null;
        }
        if (next != null) {
            return next.getName();
        }
        Debugger.m8609e("SesCoeditGroupUserNameCache", "getUserNameByOwnerGuid() : mResult does not contain ownerId");
        return null;
    }

    /* JADX WARN: Code restructure failed: missing block: B:191:0x0435, code lost:
    
        r3.f9520a = new java.lang.String(r1);
     */
    /* JADX WARN: Code restructure failed: missing block: B:192:0x043c, code lost:
    
        return;
     */
    /* JADX WARN: Removed duplicated region for block: B:106:0x0249  */
    /* JADX INFO: renamed from: k */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void m267k(String str) {
        C13524e c13524e;
        StringBuffer stringBuffer;
        C13524e c13524e2;
        ArrayList arrayList;
        StringBuffer stringBuffer2;
        String str2;
        ArrayList<C13522c> arrayList2;
        C13524e c13524e3;
        ArrayList arrayList3;
        ArrayList arrayList4;
        String str3;
        InterfaceC12016a interfaceC12016a;
        C13524e c13524e4;
        InterfaceC12016a c13492a;
        String strSubstring;
        int i;
        C13524e c13524e5 = (C13524e) this.f363b;
        ArrayList arrayList5 = (ArrayList) this.f362a;
        StringBuffer stringBuffer3 = new StringBuffer(str);
        StringBuffer stringBuffer4 = new StringBuffer();
        int length = stringBuffer3.length();
        int i2 = 0;
        while (true) {
            if (i2 >= length) {
                c13524e = c13524e5;
                stringBuffer = stringBuffer4;
                break;
            }
            int iIndexOf = stringBuffer3.indexOf("<?a", i2);
            if (iIndexOf != -1) {
                String strSubstring2 = stringBuffer3.substring(i2, iIndexOf);
                if (!TextUtils.isEmpty(strSubstring2)) {
                    stringBuffer4.append(Base64Utils.decodeBase64(strSubstring2));
                    i2 = iIndexOf;
                }
                int iIndexOf2 = stringBuffer3.indexOf("?>", i2);
                if (iIndexOf2 == -1) {
                    Log.e("WConverter_WRichTextParser", "Wrong format!! : " + ((Object) stringBuffer3));
                    Log.e("WConverter_WRichTextParser", "Wrong format total XML : " + str);
                    throw new IllegalArgumentException("Wrong format!!");
                }
                int i4 = iIndexOf2 + 2;
                String strSubstring3 = stringBuffer3.substring(i2, i4);
                String str4 = "lineSpacing";
                StringBuffer stringBuffer5 = stringBuffer4;
                int i5 = length;
                if (strSubstring3 == null || strSubstring3.isEmpty()) {
                    c13524e2 = c13524e5;
                    arrayList = arrayList5;
                    stringBuffer2 = stringBuffer3;
                    str2 = strSubstring3;
                    Log.e("WConverter_WRichTextParser", "parseAnnotation - empty xmlStr");
                } else {
                    int i6 = 1;
                    StringBuilder sb = new StringBuilder(strSubstring3);
                    c13524e2 = c13524e5;
                    stringBuffer2 = stringBuffer3;
                    str2 = strSubstring3;
                    if (sb.substring(0, 3).compareTo("<?a") != 0) {
                        Log.e("WConverter_WRichTextParser", "parseAnnotation - Invalid Tag Start");
                        arrayList = arrayList5;
                    } else {
                        sb.delete(0, 3);
                        if (sb.substring(sb.length() - 2, sb.length()).compareTo("?>") != 0) {
                            Log.e("WConverter_WRichTextParser", "parseAnnotation - Invalid Tag End");
                            arrayList = arrayList5;
                            arrayList2 = null;
                        } else {
                            sb.delete(sb.length() - 2, sb.length());
                            arrayList2 = new ArrayList();
                            while (sb.length() > 0) {
                                int iIndexOf3 = sb.indexOf(" '");
                                int i7 = iIndexOf3 + 2;
                                int iIndexOf4 = sb.indexOf("'", i7);
                                StringBuilder sb2 = new StringBuilder(sb.substring(i7, iIndexOf4));
                                int iIndexOf5 = sb2.indexOf("/");
                                ArrayList arrayList6 = arrayList2;
                                ArrayList arrayList7 = arrayList5;
                                String strSubstring4 = sb2.substring(0, iIndexOf5);
                                String strSubstring5 = sb2.substring(iIndexOf5 + 1, sb2.length());
                                sb.delete(iIndexOf3, iIndexOf4 + 1);
                                if (sb.indexOf("='") == 0) {
                                    int iIndexOf6 = sb.indexOf("='");
                                    int i8 = iIndexOf6 + 2;
                                    int iIndexOf7 = sb.indexOf("'", i8);
                                    strSubstring = sb.substring(i8, iIndexOf7);
                                    sb.delete(iIndexOf6, iIndexOf7 + 1);
                                    i = 0;
                                } else {
                                    strSubstring = null;
                                    i = i6;
                                }
                                C13522c c13522c = new C13522c();
                                c13522c.f9513a = strSubstring4;
                                c13522c.f9514b = strSubstring5;
                                c13522c.f9515c = strSubstring;
                                c13522c.f9516d = -9999;
                                c13522c.f9517e = i;
                                if (strSubstring4 != null && !strSubstring4.isEmpty()) {
                                    if (strSubstring4.compareTo("span") == 0) {
                                        c13522c.f9516d = 0;
                                    } else if (strSubstring4.compareTo("paragraph") == 0) {
                                        c13522c.f9516d = i6;
                                    } else if (strSubstring4.compareTo("sectionData") == 0) {
                                        c13522c.f9516d = 3;
                                    } else if (strSubstring4.compareTo("objectSpan") == 0) {
                                        c13522c.f9516d = 4;
                                    } else {
                                        Log.e("WConverter_WRichTextParser", "Wrong annotation type : " + c13522c);
                                    }
                                }
                                int i9 = c13522c.f9516d;
                                if (i9 != 0 ? i9 != 1 ? !(i9 == 3 || i9 == 4) : !(strSubstring5.compareTo("alignment") == 0 || strSubstring5.compareTo("bullet") == 0 || strSubstring5.compareTo("indentLevel") == 0 || strSubstring5.compareTo("lineSpacing") == 0 || strSubstring5.compareTo("parsingState") == 0 || strSubstring5.compareTo("spacingAfter") == 0 || strSubstring5.compareTo("spacingBefore") == 0 || strSubstring5.compareTo("predefinedStyle") == 0) : !(strSubstring5.compareTo("foregroundColor") == 0 || strSubstring5.compareTo("fontSize") == 0 || strSubstring5.compareTo("fontName") == 0 || strSubstring5.compareTo("bold") == 0 || strSubstring5.compareTo("italic") == 0 || strSubstring5.compareTo("underline") == 0 || strSubstring5.compareTo("hyperText") == 0 || strSubstring5.compareTo("backgroundColor") == 0 || strSubstring5.compareTo("timeStamp") == 0 || strSubstring5.compareTo("strikethrough") == 0)) {
                                    arrayList2 = arrayList6;
                                } else {
                                    arrayList2 = arrayList6;
                                    arrayList2.add(c13522c);
                                }
                                arrayList5 = arrayList7;
                                i6 = 1;
                            }
                            arrayList = arrayList5;
                        }
                        if (arrayList2 != null || arrayList2.isEmpty()) {
                            c13524e3 = c13524e2;
                            arrayList3 = arrayList;
                            AbstractC2322a.m1636z("Invalid Annotation!! : ", str2, "WConverter_WRichTextParser");
                        } else {
                            for (C13522c c13522c2 : arrayList2) {
                                int i10 = c13522c2.f9517e;
                                String str5 = c13522c2.f9514b;
                                if (i10 == 0) {
                                    int i11 = c13522c2.f9516d;
                                    if (i11 == 0) {
                                        c13492a = AbstractC13495d.m14269h(str5);
                                    } else if (i11 == 1) {
                                        c13492a = str5.equals("alignment") ? new C13496e() : str5.equals("bullet") ? new C13499h() : str5.equals("indentLevel") ? new C13507p() : str5.equals(str4) ? new C13509r() : str5.equals("parsingState") ? new C13510s() : str5.equals("spacingBefore") ? new C13513v() : str5.equals("spacingAfter") ? new C13512u() : str5.equals("predefinedStyle") ? new C13511t() : null;
                                    } else if (i11 == 3) {
                                        c13492a = new C13494c();
                                    } else {
                                        if (i11 != 4) {
                                            Log.e("WConverter_WRichTextParser", "Wrong Annotater Type!! : " + c13522c2);
                                            throw new IllegalArgumentException("Wrong Annotater Type!!");
                                        }
                                        c13492a = new C13492a();
                                    }
                                    c13492a.start(stringBuffer5.length());
                                    c13492a.mo13617c(c13522c2.f9515c);
                                    arrayList4 = arrayList;
                                    arrayList4.add(c13492a);
                                    str3 = str4;
                                    c13524e4 = c13524e2;
                                } else {
                                    arrayList4 = arrayList;
                                    int length2 = stringBuffer5.length() - 1;
                                    ListIterator listIterator = arrayList4.listIterator(arrayList4.size());
                                    while (true) {
                                        if (!listIterator.hasPrevious()) {
                                            str3 = str4;
                                            interfaceC12016a = null;
                                            break;
                                        }
                                        interfaceC12016a = (InterfaceC12016a) listIterator.previous();
                                        str3 = str4;
                                        if (interfaceC12016a.mo13615a().compareTo(str5) == 0) {
                                            interfaceC12016a.end(length2);
                                            if (length2 < 0) {
                                                interfaceC12016a.start(length2);
                                            }
                                            listIterator.remove();
                                        } else {
                                            str4 = str3;
                                        }
                                    }
                                    if (interfaceC12016a == null) {
                                        Log.e("WConverter_WRichTextParser", "Wrong endAnnotater result!! : " + c13522c2);
                                        throw new IllegalArgumentException("Wrong tag parse result!!");
                                    }
                                    int i12 = c13522c2.f9516d;
                                    if (i12 == 0) {
                                        interfaceC12016a.end(interfaceC12016a.end());
                                        c13524e4 = c13524e2;
                                        c13524e4.f9521b.add((AbstractC13495d) interfaceC12016a);
                                    } else {
                                        c13524e4 = c13524e2;
                                        if (i12 == 1) {
                                            c13524e4.f9522c.add((AbstractC13493b) interfaceC12016a);
                                        } else {
                                            if (i12 == 3) {
                                                c13524e4.f9523d.add((C13494c) interfaceC12016a);
                                            } else {
                                                if (i12 != 4) {
                                                    Log.e("WConverter_WRichTextParser", "Wrong annotationType!! : " + c13522c2);
                                                    throw new IllegalArgumentException("Wrong annotationType!!");
                                                }
                                                c13524e4.f9524e.add((C13492a) interfaceC12016a);
                                            }
                                            c13524e2 = c13524e4;
                                            arrayList = arrayList4;
                                            str4 = str3;
                                        }
                                    }
                                }
                                c13524e2 = c13524e4;
                                arrayList = arrayList4;
                                str4 = str3;
                            }
                            c13524e3 = c13524e2;
                            arrayList3 = arrayList;
                        }
                        c13524e5 = c13524e3;
                        arrayList5 = arrayList3;
                        i2 = i4;
                        stringBuffer4 = stringBuffer5;
                        length = i5;
                        stringBuffer3 = stringBuffer2;
                    }
                }
                arrayList2 = null;
                if (arrayList2 != null) {
                    c13524e3 = c13524e2;
                    arrayList3 = arrayList;
                    AbstractC2322a.m1636z("Invalid Annotation!! : ", str2, "WConverter_WRichTextParser");
                }
                c13524e5 = c13524e3;
                arrayList5 = arrayList3;
                i2 = i4;
                stringBuffer4 = stringBuffer5;
                length = i5;
                stringBuffer3 = stringBuffer2;
            } else {
                c13524e = c13524e5;
                StringBuffer stringBuffer6 = stringBuffer3;
                StringBuffer stringBuffer7 = stringBuffer4;
                if (length > i2) {
                    String strDecodeBase64 = Base64Utils.decodeBase64(stringBuffer6.substring(i2));
                    stringBuffer = stringBuffer7;
                    stringBuffer.append(strDecodeBase64);
                } else {
                    stringBuffer = stringBuffer7;
                }
            }
        }
    }

    /* JADX INFO: renamed from: l */
    public void m268l(IAuthInfoReqListener iAuthInfoReqListener) {
        synchronized (((ArrayList) this.f362a)) {
            try {
                Iterator it = ((ArrayList) this.f362a).iterator();
                while (it.hasNext()) {
                    if (((IAuthInfoReqListener) it.next()) == iAuthInfoReqListener) {
                        Debugger.m8615i("SamsungAccountAuthController", "[SA] request() : Listener exists, # = " + ((ArrayList) this.f362a).size());
                        return;
                    }
                }
                ((ArrayList) this.f362a).add(iAuthInfoReqListener);
                if (((ArrayList) this.f362a).size() == 1) {
                    Debugger.m8615i("SamsungAccountAuthController", "[SA] request() : start requestAuthInfo");
                    ((C6880g) this.f363b).m5078d(new C6878e(this, 1));
                } else {
                    Debugger.m8615i("SamsungAccountAuthController", "[SA] request() : add listener, # = " + ((ArrayList) this.f362a).size());
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    /* JADX INFO: renamed from: m */
    public void m269m(String str, IAccount iAccount) {
        if (iAccount != null) {
            MSLogger.m8632d("GraphHttpHelper", "set account id");
            this.f362a = iAccount;
            C0145c.m310R("GRAPH_PREFERENCE", "account_id", iAccount.getId());
        }
        MSLogger.m8632d("GraphHttpHelper", "setAccessToken.");
        this.f363b = str;
        C0145c.m310R("GRAPH_PREFERENCE", "access_token", new EncryptUtil().encrypt(str));
    }

    public C0112b(String str) {
        this.f362a = null;
        this.f363b = str;
    }
}
