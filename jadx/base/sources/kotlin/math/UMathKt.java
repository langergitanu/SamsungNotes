package kotlin.math;

import com.samsung.android.support.senl.document.memoconverter.core.SNBUtils.vml.vector.shape.elements.VElementFormulasCmd;
import kotlin.ExperimentalUnsignedTypes;
import kotlin.Metadata;
import kotlin.SinceKotlin;
import kotlin.WasExperimental;
import kotlin.comparisons.UComparisonsKt;
import kotlin.internal.InlineOnly;
import org.apache.xmlbeans.XmlOptions;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes9.dex */
@Metadata(m13885d1 = {"\u0000\u0012\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\u001a \u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00012\u0006\u0010\u0003\u001a\u00020\u0001H\u0087\b¢\u0006\u0004\b\u0004\u0010\u0005\u001a \u0010\u0000\u001a\u00020\u00062\u0006\u0010\u0002\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u0006H\u0087\b¢\u0006\u0004\b\u0007\u0010\b\u001a \u0010\t\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00012\u0006\u0010\u0003\u001a\u00020\u0001H\u0087\b¢\u0006\u0004\b\n\u0010\u0005\u001a \u0010\t\u001a\u00020\u00062\u0006\u0010\u0002\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u0006H\u0087\b¢\u0006\u0004\b\u000b\u0010\b¨\u0006\f"}, m13886d2 = {VElementFormulasCmd.FMIN, "Lkotlin/UInt;", "a", "b", "min-J1ME1BU", "(II)I", "Lkotlin/ULong;", "min-eb3DHEI", "(JJ)J", VElementFormulasCmd.FMAX, "max-J1ME1BU", "max-eb3DHEI", "kotlin-stdlib"}, m13887k = 2, m13888mv = {2, 1, 0}, m13890xi = 48)
public final class UMathKt {
    @SinceKotlin(version = XmlOptions.GENERATE_JAVA_15)
    @WasExperimental(markerClass = {ExperimentalUnsignedTypes.class})
    @InlineOnly
    /* JADX INFO: renamed from: max-J1ME1BU, reason: not valid java name */
    private static final int m23424maxJ1ME1BU(int i, int i2) {
        return UComparisonsKt.m23396maxOfJ1ME1BU(i, i2);
    }

    @SinceKotlin(version = XmlOptions.GENERATE_JAVA_15)
    @WasExperimental(markerClass = {ExperimentalUnsignedTypes.class})
    @InlineOnly
    /* JADX INFO: renamed from: max-eb3DHEI, reason: not valid java name */
    private static final long m23425maxeb3DHEI(long j, long j2) {
        return UComparisonsKt.m23404maxOfeb3DHEI(j, j2);
    }

    @SinceKotlin(version = XmlOptions.GENERATE_JAVA_15)
    @WasExperimental(markerClass = {ExperimentalUnsignedTypes.class})
    @InlineOnly
    /* JADX INFO: renamed from: min-J1ME1BU, reason: not valid java name */
    private static final int m23426minJ1ME1BU(int i, int i2) {
        return UComparisonsKt.m23408minOfJ1ME1BU(i, i2);
    }

    @SinceKotlin(version = XmlOptions.GENERATE_JAVA_15)
    @WasExperimental(markerClass = {ExperimentalUnsignedTypes.class})
    @InlineOnly
    /* JADX INFO: renamed from: min-eb3DHEI, reason: not valid java name */
    private static final long m23427mineb3DHEI(long j, long j2) {
        return UComparisonsKt.m23416minOfeb3DHEI(j, j2);
    }
}
