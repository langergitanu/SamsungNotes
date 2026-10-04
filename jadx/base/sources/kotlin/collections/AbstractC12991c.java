package kotlin.collections;

import android.app.Activity;
import com.microsoft.identity.common.java.logging.LogSession;
import com.samsung.android.support.senl.p148nt.base.composer.shortcut.Shortcut;
import com.samsung.android.support.senl.p148nt.stt.common.Logger;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.ListIterator;
import kotlin.KotlinNothingValueException;
import kotlin.UByte;
import kotlin.UByteArray;
import kotlin.UInt;
import kotlin.UIntArray;
import kotlin.ULong;
import kotlin.ULongArray;
import kotlin.UShort;
import kotlin.UShortArray;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.IntRange;
import kotlin.reflect.jvm.internal.impl.name.FqName;
import kotlin.reflect.jvm.internal.impl.name.Name;
import kotlin.reflect.jvm.internal.impl.types.model.SimpleTypeMarker;
import kotlin.sequences.Sequence;
import kotlin.text.Regex;
import kotlinx.coroutines.flow.FlowKt;
import org.apache.poi.javax.xml.namespace.QName;
import org.apache.xmlbeans.QNameSet;
import org.apache.xmlbeans.impl.values.TypeStore;
import org.conscrypt.OpenSSLProvider;

/* JADX INFO: renamed from: kotlin.collections.c */
/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes9.dex */
public abstract /* synthetic */ class AbstractC12991c {
    /* JADX INFO: renamed from: A */
    public static void m13977A(String str, String str2, List list) {
        list.add(str + str2);
    }

    /* JADX INFO: renamed from: B */
    public static void m13978B(StringBuilder sb, String str, String str2, List list) {
        sb.append(str);
        sb.append(str2);
        list.add(sb.toString());
    }

    /* JADX INFO: renamed from: C */
    public static void m13979C(StringBuilder sb, String str, String str2, OpenSSLProvider openSSLProvider, String str3) {
        sb.append(str);
        sb.append(str2);
        openSSLProvider.put(str3, sb.toString());
    }

    /* JADX INFO: renamed from: a */
    public static int m13980a(int i, int i2, TypeStore typeStore, QName qName, int i4, int i5) {
        typeStore.remove_element(qName, i - i2);
        return i4 + i5;
    }

    /* JADX INFO: renamed from: b */
    public static int m13981b(int i, int i2, TypeStore typeStore, QNameSet qNameSet, int i4, int i5) {
        typeStore.remove_element(qNameSet, i - i2);
        return i4 + i5;
    }

    /* JADX INFO: renamed from: c */
    public static int m13982c(int i, IntRange intRange) {
        return intRange.getEndInclusive().intValue() + i;
    }

    /* JADX INFO: renamed from: d */
    public static int m13983d(CharSequence charSequence, String str, Function1 function1, String str2) {
        Intrinsics.checkNotNullParameter(charSequence, str);
        Intrinsics.checkNotNullParameter(function1, str2);
        return charSequence.length();
    }

    /* JADX INFO: renamed from: e */
    public static int m13984e(UInt uInt, int i) {
        return UInt.m22310constructorimpl(uInt.getData() + i);
    }

    /* JADX INFO: renamed from: f */
    public static Object m13985f(CharSequence charSequence, int i, Function1 function1) {
        return function1.invoke(Character.valueOf(charSequence.charAt(i)));
    }

    /* JADX INFO: renamed from: g */
    public static Object m13986g(byte[] bArr, int i, Function1 function1) {
        return function1.invoke(UByte.m22227boximpl(UByteArray.m22291getw2LRezQ(bArr, i)));
    }

    /* JADX INFO: renamed from: h */
    public static Object m13987h(int[] iArr, int i, Function1 function1) {
        return function1.invoke(UInt.m22304boximpl(UIntArray.m22370getpVg5ArA(iArr, i)));
    }

    /* JADX INFO: renamed from: i */
    public static Object m13988i(long[] jArr, int i, Function1 function1) {
        return function1.invoke(ULong.m22383boximpl(ULongArray.m22449getsVKNKU(jArr, i)));
    }

    /* JADX INFO: renamed from: j */
    public static Object m13989j(short[] sArr, int i, Function1 function1) {
        return function1.invoke(UShort.m22490boximpl(UShortArray.m22554getMh2AYeg(sArr, i)));
    }

    /* JADX INFO: renamed from: k */
    public static String m13990k(String str, String str2, String str3) {
        StringBuffer stringBuffer = new StringBuffer(str);
        stringBuffer.append(str2);
        stringBuffer.append(str3);
        return stringBuffer.toString();
    }

    /* JADX INFO: renamed from: l */
    public static String m13991l(String str, String str2, String str3, String str4) {
        Intrinsics.checkNotNullExpressionValue(str, str2);
        return str3 + str4;
    }

    /* JADX INFO: renamed from: m */
    public static StringBuilder m13992m(String str, SimpleTypeMarker simpleTypeMarker, String str2) {
        StringBuilder sb = new StringBuilder(str);
        sb.append(simpleTypeMarker);
        sb.append(str2);
        return sb;
    }

    /* JADX INFO: renamed from: n */
    public static StringBuilder m13993n(OpenSSLProvider openSSLProvider, String str, String str2, String str3, String str4) {
        openSSLProvider.put(str, str2);
        openSSLProvider.put(str3, str4);
        return new StringBuilder();
    }

    /* JADX INFO: renamed from: o */
    public static Throwable m13994o(ClassNotFoundException classNotFoundException) {
        return new NoClassDefFoundError().initCause(classNotFoundException);
    }

    /* JADX INFO: renamed from: p */
    public static ArrayList m13995p(LinkedHashMap linkedHashMap, Object obj) {
        ArrayList arrayList = new ArrayList();
        linkedHashMap.put(obj, arrayList);
        return arrayList;
    }

    /* JADX INFO: renamed from: q */
    public static HashMap m13996q(String str, String str2, String str3, String str4) {
        HashMap map = new HashMap();
        map.put(str, str2);
        map.put(str3, str4);
        return map;
    }

    /* JADX INFO: renamed from: r */
    public static Iterator m13997r(Iterable iterable, String str, Function1 function1, String str2) {
        Intrinsics.checkNotNullParameter(iterable, str);
        Intrinsics.checkNotNullParameter(function1, str2);
        return iterable.iterator();
    }

    /* JADX INFO: renamed from: s */
    public static Iterator m13998s(Sequence sequence, String str, Function1 function1, String str2) {
        Intrinsics.checkNotNullParameter(sequence, str);
        Intrinsics.checkNotNullParameter(function1, str2);
        return sequence.iterator();
    }

    /* JADX INFO: renamed from: t */
    public static List m13999t(int i, String str, String str2) {
        return new Regex(str).split(str2, i);
    }

    /* JADX INFO: renamed from: u */
    public static List m14000u(ListIterator listIterator, int i, Iterable iterable) {
        return CollectionsKt.take(iterable, listIterator.nextIndex() + i);
    }

    /* JADX INFO: renamed from: v */
    public static KotlinNothingValueException m14001v() {
        FlowKt.noImpl();
        return new KotlinNothingValueException();
    }

    /* JADX INFO: renamed from: w */
    public static FqName m14002w(String str, FqName fqName, String str2) {
        FqName fqNameChild = fqName.child(Name.identifier(str));
        Intrinsics.checkNotNullExpressionValue(fqNameChild, str2);
        return fqNameChild;
    }

    /* JADX INFO: renamed from: x */
    public static void m14003x(Activity activity, int i, Shortcut shortcut, List list) {
        list.add(shortcut.makeKeyboardShortcutInfo(activity.getString(i)));
    }

    /* JADX INFO: renamed from: y */
    public static void m14004y(String str, String str2, LogSession.Companion companion, String str3, String str4) {
        companion.logMethodCall(str3, str4, str + str2);
    }

    /* JADX INFO: renamed from: z */
    public static void m14005z(String str, String str2, String str3) {
        Logger.m12711e(str3, str + str2);
    }
}
