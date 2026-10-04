package kotlin.text;

import kotlin.Metadata;

/* JADX INFO: loaded from: classes9.dex */
@Metadata(m13885d1 = {"kotlin/text/StringsKt__AppendableKt", "kotlin/text/StringsKt__IndentKt", "kotlin/text/StringsKt__RegexExtensionsJVMKt", "kotlin/text/StringsKt__RegexExtensionsKt", "kotlin/text/StringsKt__StringBuilderJVMKt", "kotlin/text/StringsKt__StringBuilderKt", "kotlin/text/StringsKt__StringNumberConversionsJVMKt", "kotlin/text/StringsKt__StringNumberConversionsKt", "kotlin/text/StringsKt__StringsJVMKt", "kotlin/text/StringsKt__StringsKt", "kotlin/text/StringsKt___StringsJvmKt", "kotlin/text/StringsKt___StringsKt"}, m13887k = 4, m13888mv = {2, 1, 0}, m13890xi = 49)
public final class StringsKt extends StringsKt___StringsKt {
    private StringsKt() {
    }

    /* JADX INFO: renamed from: B */
    public static /* bridge */ /* synthetic */ int m14128B(CharSequence charSequence, char c, int i, int i2) {
        return StringsKt__StringsKt.indexOf$default(charSequence, c, i, false, i2, (Object) null);
    }

    /* JADX INFO: renamed from: C */
    public static /* bridge */ /* synthetic */ int m14129C(String str, int i, int i2, CharSequence charSequence) {
        return StringsKt__StringsKt.indexOf$default(charSequence, str, i, false, i2, (Object) null);
    }

    /* JADX INFO: renamed from: D */
    public static /* bridge */ /* synthetic */ int m14130D(CharSequence charSequence, char c) {
        return StringsKt__StringsKt.lastIndexOf$default(charSequence, c, 0, false, 6, (Object) null);
    }

    /* JADX INFO: renamed from: E */
    public static /* bridge */ /* synthetic */ int m14131E(String str, int i, int i2, CharSequence charSequence) {
        return StringsKt__StringsKt.lastIndexOf$default(charSequence, str, i, false, i2, (Object) null);
    }

    /* JADX INFO: renamed from: M */
    public static /* bridge */ /* synthetic */ String m14139M(String str, String str2, String str3) {
        return StringsKt__StringsJVMKt.replace$default(str, str2, str3, false, 4, (Object) null);
    }

    /* JADX INFO: renamed from: S */
    public static /* bridge */ /* synthetic */ boolean m14145S(String str, String str2) {
        return StringsKt__StringsJVMKt.startsWith$default(str, str2, false, 2, null);
    }

    /* JADX INFO: renamed from: U */
    public static /* bridge */ /* synthetic */ String m14147U(String str, String str2) {
        return StringsKt__StringsKt.substringAfter$default(str, str2, (String) null, 2, (Object) null);
    }

    /* JADX INFO: renamed from: b0 */
    public static /* bridge */ /* synthetic */ String m14154b0(String str, String str2) {
        return StringsKt__StringsKt.substringBeforeLast$default(str, str2, (String) null, 2, (Object) null);
    }

    /* JADX INFO: renamed from: r */
    public static /* bridge */ /* synthetic */ boolean m14162r(CharSequence charSequence, String str) {
        return StringsKt__StringsKt.contains$default(charSequence, (CharSequence) str, false, 2, (Object) null);
    }

    /* JADX INFO: renamed from: w */
    public static /* bridge */ /* synthetic */ boolean m14167w(String str, String str2) {
        return StringsKt__StringsJVMKt.endsWith$default(str, str2, false, 2, null);
    }

    /* JADX INFO: renamed from: y */
    public static /* bridge */ /* synthetic */ boolean m14169y(String str, String str2) {
        return StringsKt__StringsJVMKt.equals$default(str, str2, false, 2, null);
    }
}
