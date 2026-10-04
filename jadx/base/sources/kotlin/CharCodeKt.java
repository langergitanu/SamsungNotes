package kotlin;

import kotlin.internal.InlineOnly;
import kotlin.internal.IntrinsicConstEvaluation;
import org.apache.xmlbeans.XmlOptions;
import p001A.AbstractC0000a;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes9.dex */
@Metadata(m13885d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\f\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\u001a\u0011\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\u0087\b\"\u001f\u0010\u0002\u001a\u00020\u0003*\u00020\u00018Æ\u0002X\u0087\u0004¢\u0006\f\u0012\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007¨\u0006\b"}, m13886d2 = {"Char", "", "code", "", "getCode$annotations", "(C)V", "getCode", "(C)I", "kotlin-stdlib"}, m13887k = 2, m13888mv = {2, 1, 0}, m13890xi = 48)
public final class CharCodeKt {
    @SinceKotlin(version = XmlOptions.GENERATE_JAVA_15)
    @WasExperimental(markerClass = {ExperimentalStdlibApi.class})
    @InlineOnly
    private static final char Char(int i) {
        if (i < 0 || i > 65535) {
            throw new IllegalArgumentException(AbstractC0000a.m11h(i, "Invalid Char code: "));
        }
        return (char) i;
    }

    private static final int getCode(char c) {
        return c;
    }

    @SinceKotlin(version = XmlOptions.GENERATE_JAVA_15)
    @InlineOnly
    @IntrinsicConstEvaluation
    @WasExperimental(markerClass = {ExperimentalStdlibApi.class})
    public static /* synthetic */ void getCode$annotations(char c) {
    }
}
