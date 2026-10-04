package kotlin;

import kotlin.internal.InlineOnly;
import org.apache.xmlbeans.XmlOptions;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes9.dex */
@Metadata(m13885d1 = {"\u0000 \n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0005\n\u0000\n\u0002\u0010\n\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\u001a\u0012\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u0087\b¢\u0006\u0002\u0010\u0003\u001a\u0012\u0010\u0000\u001a\u00020\u0001*\u00020\u0004H\u0087\b¢\u0006\u0002\u0010\u0005\u001a\u0012\u0010\u0000\u001a\u00020\u0001*\u00020\u0006H\u0087\b¢\u0006\u0002\u0010\u0007\u001a\u0012\u0010\u0000\u001a\u00020\u0001*\u00020\bH\u0087\b¢\u0006\u0002\u0010\t¨\u0006\n"}, m13886d2 = {"toUShort", "Lkotlin/UShort;", "", "(B)S", "", "(S)S", "", "(I)S", "", "(J)S", "kotlin-stdlib"}, m13887k = 2, m13888mv = {2, 1, 0}, m13890xi = 48)
public final class UShortKt {
    @SinceKotlin(version = XmlOptions.GENERATE_JAVA_15)
    @WasExperimental(markerClass = {ExperimentalUnsignedTypes.class})
    @InlineOnly
    private static final short toUShort(byte b) {
        return UShort.m22496constructorimpl(b);
    }

    @SinceKotlin(version = XmlOptions.GENERATE_JAVA_15)
    @WasExperimental(markerClass = {ExperimentalUnsignedTypes.class})
    @InlineOnly
    private static final short toUShort(short s) {
        return UShort.m22496constructorimpl(s);
    }

    @SinceKotlin(version = XmlOptions.GENERATE_JAVA_15)
    @WasExperimental(markerClass = {ExperimentalUnsignedTypes.class})
    @InlineOnly
    private static final short toUShort(int i) {
        return UShort.m22496constructorimpl((short) i);
    }

    @SinceKotlin(version = XmlOptions.GENERATE_JAVA_15)
    @WasExperimental(markerClass = {ExperimentalUnsignedTypes.class})
    @InlineOnly
    private static final short toUShort(long j) {
        return UShort.m22496constructorimpl((short) j);
    }
}
