package kotlin.text;

import androidx.appcompat.widget.AbstractC0541b;
import com.samsung.android.scs.p140ai.sdkcommon.text.TextConst;
import io.netty.handler.codec.rtsp.RtspHeaders;
import java.util.Arrays;
import kotlin.ExperimentalStdlibApi;
import kotlin.KotlinNothingValueException;
import kotlin.Metadata;
import kotlin.SinceKotlin;
import kotlin.ULong;
import kotlin.UShort;
import kotlin.collections.AbstractList;
import kotlin.collections.ArraysKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.ranges.RangesKt;
import kotlin.text.HexFormat;
import org.jetbrains.annotations.NotNull;
import p001A.AbstractC0000a;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes9.dex */
@Metadata(m13885d1 = {"\u0000r\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0015\n\u0002\b\u0007\n\u0002\u0010\u0016\n\u0000\n\u0002\u0010\u0012\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u0019\n\u0002\b\u000b\n\u0002\u0010\t\n\u0002\b\u0006\n\u0002\u0010\u0005\n\u0002\b\t\n\u0002\u0010\n\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u000f\n\u0002\u0010\u0001\n\u0000\u001a\u0016\u0010\r\u001a\u00020\u0001*\u00020\u000e2\b\b\u0002\u0010\u000f\u001a\u00020\u0010H\u0007\u001a*\u0010\r\u001a\u00020\u0001*\u00020\u000e2\b\b\u0002\u0010\u0011\u001a\u00020\u00122\b\b\u0002\u0010\u0013\u001a\u00020\u00122\b\b\u0002\u0010\u000f\u001a\u00020\u0010H\u0007\u001a,\u0010\u0014\u001a\u00020\u0001*\u00020\u000e2\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u00122\u0006\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u0004H\u0003\u001a,\u0010\u0018\u001a\u00020\u0001*\u00020\u000e2\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u00122\u0006\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u0004H\u0003\u001a,\u0010\u0019\u001a\u00020\u0001*\u00020\u000e2\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u00122\u0006\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u0004H\u0003\u001a,\u0010\u001a\u001a\u00020\u0001*\u00020\u000e2\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u00122\u0006\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u0004H\u0003\u001a<\u0010\u001b\u001a\u00020\u0012*\u00020\u000e2\u0006\u0010\u001c\u001a\u00020\u00122\u0006\u0010\u001d\u001a\u00020\u00012\u0006\u0010\u001e\u001a\u00020\u00012\u0006\u0010\u0017\u001a\u00020\u00042\u0006\u0010\u001f\u001a\u00020 2\u0006\u0010!\u001a\u00020\u0012H\u0002\u001a,\u0010\u001b\u001a\u00020\u0012*\u00020\u000e2\u0006\u0010\u001c\u001a\u00020\u00122\u0006\u0010\u0017\u001a\u00020\u00042\u0006\u0010\u001f\u001a\u00020 2\u0006\u0010!\u001a\u00020\u0012H\u0002\u001a(\u0010\"\u001a\u00020\u00122\u0006\u0010#\u001a\u00020\u00122\u0006\u0010$\u001a\u00020\u00122\u0006\u0010%\u001a\u00020\u00122\u0006\u0010&\u001a\u00020\u0012H\u0002\u001a@\u0010\"\u001a\u00020\u00122\u0006\u0010#\u001a\u00020\u00122\u0006\u0010'\u001a\u00020\u00122\u0006\u0010(\u001a\u00020\u00122\u0006\u0010)\u001a\u00020\u00122\u0006\u0010$\u001a\u00020\u00122\u0006\u0010%\u001a\u00020\u00122\u0006\u0010&\u001a\u00020\u0012H\u0000\u001a\u0010\u0010*\u001a\u00020\u00122\u0006\u0010+\u001a\u00020,H\u0002\u001a\u0016\u0010-\u001a\u00020\u000e*\u00020\u00012\b\b\u0002\u0010\u000f\u001a\u00020\u0010H\u0007\u001a*\u0010-\u001a\u00020\u000e*\u00020\u00012\b\b\u0002\u0010\u0011\u001a\u00020\u00122\b\b\u0002\u0010\u0013\u001a\u00020\u00122\b\b\u0002\u0010\u000f\u001a\u00020\u0010H\u0003\u001a&\u0010.\u001a\u0004\u0018\u00010\u000e*\u00020\u00012\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u00122\u0006\u0010\u0015\u001a\u00020\u0016H\u0003\u001a&\u0010/\u001a\u0004\u0018\u00010\u000e*\u00020\u00012\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u00122\u0006\u0010\u0015\u001a\u00020\u0016H\u0003\u001a&\u00100\u001a\u0004\u0018\u00010\u000e*\u00020\u00012\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u00122\u0006\u0010\u0015\u001a\u00020\u0016H\u0003\u001a$\u00101\u001a\u00020\u000e*\u00020\u00012\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u00122\u0006\u0010\u0015\u001a\u00020\u0016H\u0003\u001a\u0014\u00102\u001a\u000203*\u00020\u00012\u0006\u0010\u001c\u001a\u00020\u0012H\u0002\u001a@\u00104\u001a\u00020\u00122\u0006\u00105\u001a\u00020\u00122\u0006\u0010'\u001a\u00020\u00122\u0006\u0010(\u001a\u00020\u00122\u0006\u0010)\u001a\u00020\u00122\u0006\u0010$\u001a\u00020\u00122\u0006\u0010%\u001a\u00020\u00122\u0006\u0010&\u001a\u00020\u0012H\u0000\u001a \u00106\u001a\u00020,2\u0006\u00107\u001a\u00020,2\u0006\u00108\u001a\u00020\u00122\u0006\u00109\u001a\u00020\u0012H\u0002\u001a \u0010:\u001a\u00020,2\u0006\u00106\u001a\u00020,2\u0006\u00107\u001a\u00020,2\u0006\u00109\u001a\u00020\u0012H\u0002\u001a\u001c\u0010;\u001a\u00020\u0012*\u00020\u00012\u0006\u0010\u001c\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u0012H\u0002\u001a\u0016\u0010\r\u001a\u00020\u0001*\u0002032\b\b\u0002\u0010\u000f\u001a\u00020\u0010H\u0007\u001a\u0016\u0010<\u001a\u000203*\u00020\u00012\b\b\u0002\u0010\u000f\u001a\u00020\u0010H\u0007\u001a*\u0010<\u001a\u000203*\u00020\u00012\b\b\u0002\u0010\u0011\u001a\u00020\u00122\b\b\u0002\u0010\u0013\u001a\u00020\u00122\b\b\u0002\u0010\u000f\u001a\u00020\u0010H\u0003\u001a\u0016\u0010\r\u001a\u00020\u0001*\u00020=2\b\b\u0002\u0010\u000f\u001a\u00020\u0010H\u0007\u001a\u0016\u0010>\u001a\u00020=*\u00020\u00012\b\b\u0002\u0010\u000f\u001a\u00020\u0010H\u0007\u001a*\u0010>\u001a\u00020=*\u00020\u00012\b\b\u0002\u0010\u0011\u001a\u00020\u00122\b\b\u0002\u0010\u0013\u001a\u00020\u00122\b\b\u0002\u0010\u000f\u001a\u00020\u0010H\u0003\u001a\u0016\u0010\r\u001a\u00020\u0001*\u00020\u00122\b\b\u0002\u0010\u000f\u001a\u00020\u0010H\u0007\u001a\u0016\u0010?\u001a\u00020\u0012*\u00020\u00012\b\b\u0002\u0010\u000f\u001a\u00020\u0010H\u0007\u001a*\u0010?\u001a\u00020\u0012*\u00020\u00012\b\b\u0002\u0010\u0011\u001a\u00020\u00122\b\b\u0002\u0010\u0013\u001a\u00020\u00122\b\b\u0002\u0010\u000f\u001a\u00020\u0010H\u0001\u001a\u0016\u0010\r\u001a\u00020\u0001*\u00020,2\b\b\u0002\u0010\u000f\u001a\u00020\u0010H\u0007\u001a\u0016\u0010@\u001a\u00020,*\u00020\u00012\b\b\u0002\u0010\u000f\u001a\u00020\u0010H\u0007\u001a*\u0010@\u001a\u00020,*\u00020\u00012\b\b\u0002\u0010\u0011\u001a\u00020\u00122\b\b\u0002\u0010\u0013\u001a\u00020\u00122\b\b\u0002\u0010\u000f\u001a\u00020\u0010H\u0001\u001a$\u0010A\u001a\u00020\u0001*\u00020,2\u0006\u0010B\u001a\u00020C2\u0006\u0010D\u001a\u00020\u00012\u0006\u0010E\u001a\u00020\u0012H\u0003\u001a\u001c\u0010F\u001a\u00020\u0012*\u00020\u00012\u0006\u0010\u001f\u001a\u00020 2\u0006\u0010!\u001a\u00020\u0012H\u0002\u001a,\u0010G\u001a\u00020\u0012*\u00020\u00012\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u00122\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010H\u001a\u00020\u0012H\u0003\u001a,\u0010I\u001a\u00020,*\u00020\u00012\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u00122\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010H\u001a\u00020\u0012H\u0003\u001a<\u0010J\u001a\u00020K*\u00020\u00012\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u00122\u0006\u0010L\u001a\u00020\u00012\u0006\u0010M\u001a\u00020\u00012\u0006\u0010N\u001a\u00020O2\u0006\u0010H\u001a\u00020\u0012H\u0002\u001a$\u0010P\u001a\u00020K*\u00020\u00012\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u00122\u0006\u0010H\u001a\u00020\u0012H\u0002\u001a\u001c\u0010Q\u001a\u00020K*\u00020\u00012\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u0012H\u0002\u001a\u001c\u0010R\u001a\u00020\u0012*\u00020\u00012\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u0012H\u0002\u001a\u001c\u0010S\u001a\u00020,*\u00020\u00012\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u0012H\u0002\u001a5\u0010T\u001a\u00020\u0012*\u00020\u00012\u0006\u0010\u001c\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u00122\u0006\u0010U\u001a\u00020\u00012\u0006\u0010N\u001a\u00020O2\u0006\u0010V\u001a\u00020\u0001H\u0082\b\u001a\u0015\u0010W\u001a\u00020\u0012*\u00020\u00012\u0006\u0010\u001c\u001a\u00020\u0012H\u0082\b\u001a\u0015\u0010X\u001a\u00020,*\u00020\u00012\u0006\u0010\u001c\u001a\u00020\u0012H\u0082\b\u001a,\u0010Y\u001a\u00020K*\u00020\u00012\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u00122\u0006\u0010Z\u001a\u00020\u00012\u0006\u0010[\u001a\u00020\u0012H\u0002\u001a,\u0010\\\u001a\u00020K*\u00020\u00012\u0006\u0010\u001c\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u00122\u0006\u0010U\u001a\u00020\u00012\u0006\u0010V\u001a\u00020\u0001H\u0002\u001a,\u0010]\u001a\u00020K*\u00020\u00012\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u00122\u0006\u0010L\u001a\u00020\u00012\u0006\u0010M\u001a\u00020\u0001H\u0002\u001a\u0014\u0010^\u001a\u00020_*\u00020\u00012\u0006\u0010\u001c\u001a\u00020\u0012H\u0002\"\u000e\u0010\u0000\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0002\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000\"\u001c\u0010\u0003\u001a\u00020\u00048\u0000X\u0081\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u0005\u0010\u0006\u001a\u0004\b\u0007\u0010\b\"\u000e\u0010\t\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000\"\u000e\u0010\n\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000\"\u000e\u0010\u000b\u001a\u00020\fX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006`"}, m13886d2 = {"LOWER_CASE_HEX_DIGITS", "", "UPPER_CASE_HEX_DIGITS", "BYTE_TO_LOWER_CASE_HEX_DIGITS", "", "getBYTE_TO_LOWER_CASE_HEX_DIGITS$annotations", "()V", "getBYTE_TO_LOWER_CASE_HEX_DIGITS", "()[I", "BYTE_TO_UPPER_CASE_HEX_DIGITS", "HEX_DIGITS_TO_DECIMAL", "HEX_DIGITS_TO_LONG_DECIMAL", "", "toHexString", "", "format", "Lkotlin/text/HexFormat;", TextConst.KEY_START_INDEX, "", TextConst.KEY_END_INDEX, "toHexStringNoLineAndGroupSeparator", "bytesFormat", "Lkotlin/text/HexFormat$BytesHexFormat;", "byteToDigits", "toHexStringShortByteSeparatorNoPrefixAndSuffix", "toHexStringNoLineAndGroupSeparatorSlowPath", "toHexStringSlowPath", "formatByteAt", "index", "bytePrefix", "byteSuffix", RtspHeaders.Values.DESTINATION, "", "destinationOffset", "formattedStringLength", "numberOfBytes", "byteSeparatorLength", "bytePrefixLength", "byteSuffixLength", "bytesPerLine", "bytesPerGroup", "groupSeparatorLength", "checkFormatLength", "formatLength", "", "hexToByteArray", "hexToByteArrayNoLineAndGroupSeparator", "hexToByteArrayShortByteSeparatorNoPrefixAndSuffix", "hexToByteArrayNoLineAndGroupSeparatorSlowPath", "hexToByteArraySlowPath", "parseByteAt", "", "parsedByteArrayMaxSize", "stringLength", "charsPerSet", "charsPerElement", "elementsPerSet", "elementSeparatorLength", "wholeElementsPerSet", "checkNewLineAt", "hexToByte", "", "hexToShort", "hexToInt", "hexToLong", "toHexStringImpl", "numberFormat", "Lkotlin/text/HexFormat$NumberHexFormat;", "digits", "bits", "toCharArrayIfNotEmpty", "hexToIntImpl", "typeHexLength", "hexToLongImpl", "checkPrefixSuffixNumberOfDigits", "", "prefix", "suffix", "ignoreCase", "", "checkNumberOfDigits", "checkZeroDigits", "parseInt", "parseLong", "checkContainsAt", "part", "partName", "decimalFromHexDigitAt", "longDecimalFromHexDigitAt", "throwInvalidNumberOfDigits", "specifier", "expected", "throwNotContainedAt", "throwInvalidPrefixSuffix", "throwInvalidDigitAt", "", "kotlin-stdlib"}, m13887k = 2, m13888mv = {2, 1, 0}, m13890xi = 48)
@SourceDebugExtension({"SMAP\nHexExtensions.kt\nKotlin\n*S Kotlin\n*F\n+ 1 HexExtensions.kt\nkotlin/text/HexExtensionsKt\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n+ 3 _Strings.kt\nkotlin/text/StringsKt___StringsKt\n*L\n1#1,1249:1\n1198#1,7:1251\n1198#1,7:1258\n1198#1,7:1265\n1198#1,7:1272\n1198#1,7:1279\n1198#1,7:1286\n1198#1,7:1293\n1198#1,7:1300\n1209#1,5:1307\n1209#1,5:1312\n1198#1,7:1317\n1198#1,7:1324\n1209#1,5:1331\n1218#1,5:1336\n1#2:1250\n1188#3,3:1341\n1188#3,3:1344\n1188#3,3:1347\n1188#3,3:1350\n*S KotlinDebug\n*F\n+ 1 HexExtensions.kt\nkotlin/text/HexExtensionsKt\n*L\n457#1:1251,7\n490#1:1258,7\n494#1:1265,7\n497#1:1272,7\n538#1:1279,7\n541#1:1286,7\n546#1:1293,7\n551#1:1300,7\n558#1:1307,5\n559#1:1312,5\n1153#1:1317,7\n1155#1:1324,7\n1183#1:1331,5\n1191#1:1336,5\n43#1:1341,3\n44#1:1344,3\n55#1:1347,3\n56#1:1350,3\n*E\n"})
public final class HexExtensionsKt {

    @NotNull
    private static final int[] BYTE_TO_LOWER_CASE_HEX_DIGITS;

    @NotNull
    private static final int[] BYTE_TO_UPPER_CASE_HEX_DIGITS;

    @NotNull
    private static final int[] HEX_DIGITS_TO_DECIMAL;

    @NotNull
    private static final long[] HEX_DIGITS_TO_LONG_DECIMAL;

    @NotNull
    private static final String LOWER_CASE_HEX_DIGITS = "0123456789abcdef";

    @NotNull
    private static final String UPPER_CASE_HEX_DIGITS = "0123456789ABCDEF";

    static {
        int[] iArr = new int[256];
        int i = 0;
        for (int i2 = 0; i2 < 256; i2++) {
            iArr[i2] = LOWER_CASE_HEX_DIGITS.charAt(i2 & 15) | (LOWER_CASE_HEX_DIGITS.charAt(i2 >> 4) << '\b');
        }
        BYTE_TO_LOWER_CASE_HEX_DIGITS = iArr;
        int[] iArr2 = new int[256];
        for (int i4 = 0; i4 < 256; i4++) {
            iArr2[i4] = "0123456789ABCDEF".charAt(i4 & 15) | ("0123456789ABCDEF".charAt(i4 >> 4) << '\b');
        }
        BYTE_TO_UPPER_CASE_HEX_DIGITS = iArr2;
        int[] iArr3 = new int[256];
        for (int i5 = 0; i5 < 256; i5++) {
            iArr3[i5] = -1;
        }
        int i6 = 0;
        int i7 = 0;
        while (i6 < LOWER_CASE_HEX_DIGITS.length()) {
            iArr3[LOWER_CASE_HEX_DIGITS.charAt(i6)] = i7;
            i6++;
            i7++;
        }
        int i8 = 0;
        int i9 = 0;
        while (i8 < "0123456789ABCDEF".length()) {
            iArr3["0123456789ABCDEF".charAt(i8)] = i9;
            i8++;
            i9++;
        }
        HEX_DIGITS_TO_DECIMAL = iArr3;
        long[] jArr = new long[256];
        for (int i10 = 0; i10 < 256; i10++) {
            jArr[i10] = -1;
        }
        int i11 = 0;
        int i12 = 0;
        while (i11 < LOWER_CASE_HEX_DIGITS.length()) {
            jArr[LOWER_CASE_HEX_DIGITS.charAt(i11)] = i12;
            i11++;
            i12++;
        }
        int i13 = 0;
        while (i < "0123456789ABCDEF".length()) {
            jArr["0123456789ABCDEF".charAt(i)] = i13;
            i++;
            i13++;
        }
        HEX_DIGITS_TO_LONG_DECIMAL = jArr;
    }

    private static final long charsPerSet(long j, int i, int i2) {
        if (i <= 0) {
            throw new IllegalArgumentException("Failed requirement.");
        }
        long j2 = i;
        return ((j2 - 1) * ((long) i2)) + (j * j2);
    }

    private static final int checkContainsAt(String str, int i, int i2, String str2, boolean z, String str3) {
        if (str2.length() == 0) {
            return i;
        }
        int length = str2.length();
        for (int i4 = 0; i4 < length; i4++) {
            if (!CharsKt__CharKt.equals(str2.charAt(i4), str.charAt(i + i4), z)) {
                throwNotContainedAt(str, i, i2, str2, str3);
            }
        }
        return str2.length() + i;
    }

    private static final int checkFormatLength(long j) {
        if (0 <= j && j <= 2147483647L) {
            return (int) j;
        }
        throw new IllegalArgumentException("The resulting string length is too big: " + ((Object) ULong.m22435toStringimpl(ULong.m22389constructorimpl(j))));
    }

    private static final int checkNewLineAt(String str, int i, int i2) {
        if (str.charAt(i) == '\r') {
            int i4 = i + 1;
            return (i4 >= i2 || str.charAt(i4) != '\n') ? i4 : i + 2;
        }
        if (str.charAt(i) == '\n') {
            return i + 1;
        }
        StringBuilder sbM778t = AbstractC0541b.m778t(i, "Expected a new line at index ", ", but was ");
        sbM778t.append(str.charAt(i));
        throw new NumberFormatException(sbM778t.toString());
    }

    private static final void checkNumberOfDigits(String str, int i, int i2, int i4) {
        int i5 = i2 - i;
        if (i5 < 1) {
            throwInvalidNumberOfDigits(str, i, i2, "at least", 1);
        } else if (i5 > i4) {
            checkZeroDigits(str, i, (i5 + i) - i4);
        }
    }

    private static final void checkPrefixSuffixNumberOfDigits(String str, int i, int i2, String str2, String str3, boolean z, int i4) {
        if ((i2 - i) - str2.length() <= str3.length()) {
            throwInvalidPrefixSuffix(str, i, i2, str2, str3);
        }
        if (str2.length() != 0) {
            int length = str2.length();
            for (int i5 = 0; i5 < length; i5++) {
                if (!CharsKt__CharKt.equals(str2.charAt(i5), str.charAt(i + i5), z)) {
                    throwNotContainedAt(str, i, i2, str2, "prefix");
                }
            }
            i += str2.length();
        }
        int length2 = i2 - str3.length();
        if (str3.length() != 0) {
            int length3 = str3.length();
            for (int i6 = 0; i6 < length3; i6++) {
                if (!CharsKt__CharKt.equals(str3.charAt(i6), str.charAt(length2 + i6), z)) {
                    throwNotContainedAt(str, length2, i2, str3, "suffix");
                }
            }
        }
        checkNumberOfDigits(str, i, length2, i4);
    }

    private static final void checkZeroDigits(String str, int i, int i2) {
        while (i < i2) {
            if (str.charAt(i) != '0') {
                StringBuilder sbM778t = AbstractC0541b.m778t(i, "Expected the hexadecimal digit '0' at index ", ", but was '");
                sbM778t.append(str.charAt(i));
                sbM778t.append("'.\nThe result won't fit the type being parsed.");
                throw new NumberFormatException(sbM778t.toString());
            }
            i++;
        }
    }

    private static final int decimalFromHexDigitAt(String str, int i) {
        int i2;
        char cCharAt = str.charAt(i);
        if ((cCharAt >>> '\b') == 0 && (i2 = HEX_DIGITS_TO_DECIMAL[cCharAt]) >= 0) {
            return i2;
        }
        throwInvalidDigitAt(str, i);
        throw new KotlinNothingValueException();
    }

    private static final int formatByteAt(byte[] bArr, int i, String str, String str2, int[] iArr, char[] cArr, int i2) {
        return toCharArrayIfNotEmpty(str2, cArr, formatByteAt(bArr, i, iArr, cArr, toCharArrayIfNotEmpty(str, cArr, i2)));
    }

    private static final int formattedStringLength(int i, int i2, int i4, int i5) {
        if (i <= 0) {
            throw new IllegalArgumentException("Failed requirement.");
        }
        long j = i2;
        return checkFormatLength((((long) i) * (((((long) i4) + 2) + ((long) i5)) + j)) - j);
    }

    @NotNull
    public static final int[] getBYTE_TO_LOWER_CASE_HEX_DIGITS() {
        return BYTE_TO_LOWER_CASE_HEX_DIGITS;
    }

    @SinceKotlin(version = "1.9")
    @ExperimentalStdlibApi
    public static final byte hexToByte(@NotNull String str, @NotNull HexFormat format) {
        Intrinsics.checkNotNullParameter(str, "<this>");
        Intrinsics.checkNotNullParameter(format, "format");
        return hexToByte(str, 0, str.length(), format);
    }

    public static /* synthetic */ byte hexToByte$default(String str, HexFormat hexFormat, int i, Object obj) {
        if ((i & 1) != 0) {
            hexFormat = HexFormat.INSTANCE.getDefault();
        }
        return hexToByte(str, hexFormat);
    }

    @SinceKotlin(version = "1.9")
    @ExperimentalStdlibApi
    @NotNull
    public static final byte[] hexToByteArray(@NotNull String str, @NotNull HexFormat format) {
        Intrinsics.checkNotNullParameter(str, "<this>");
        Intrinsics.checkNotNullParameter(format, "format");
        return hexToByteArray(str, 0, str.length(), format);
    }

    public static /* synthetic */ byte[] hexToByteArray$default(String str, HexFormat hexFormat, int i, Object obj) {
        if ((i & 1) != 0) {
            hexFormat = HexFormat.INSTANCE.getDefault();
        }
        return hexToByteArray(str, hexFormat);
    }

    @ExperimentalStdlibApi
    private static final byte[] hexToByteArrayNoLineAndGroupSeparator(String str, int i, int i2, HexFormat.BytesHexFormat bytesHexFormat) {
        return bytesHexFormat.getShortByteSeparatorNoPrefixAndSuffix() ? hexToByteArrayShortByteSeparatorNoPrefixAndSuffix(str, i, i2, bytesHexFormat) : hexToByteArrayNoLineAndGroupSeparatorSlowPath(str, i, i2, bytesHexFormat);
    }

    @ExperimentalStdlibApi
    private static final byte[] hexToByteArrayNoLineAndGroupSeparatorSlowPath(String str, int i, int i2, HexFormat.BytesHexFormat bytesHexFormat) {
        String bytePrefix = bytesHexFormat.getBytePrefix();
        String byteSuffix = bytesHexFormat.getByteSuffix();
        String byteSeparator = bytesHexFormat.getByteSeparator();
        long length = byteSeparator.length();
        long length2 = ((long) bytePrefix.length()) + 2 + ((long) byteSuffix.length()) + length;
        long j = i2 - i;
        int i4 = (int) ((j + length) / length2);
        if ((((long) i4) * length2) - length != j) {
            return null;
        }
        boolean ignoreCase$kotlin_stdlib = bytesHexFormat.getIgnoreCase();
        byte[] bArr = new byte[i4];
        if (bytePrefix.length() != 0) {
            int length3 = bytePrefix.length();
            for (int i5 = 0; i5 < length3; i5++) {
                if (!CharsKt__CharKt.equals(bytePrefix.charAt(i5), str.charAt(i + i5), ignoreCase$kotlin_stdlib)) {
                    throwNotContainedAt(str, i, i2, bytePrefix, "byte prefix");
                }
            }
            i += bytePrefix.length();
        }
        String strM757C = AbstractC0541b.m757C(byteSuffix, byteSeparator, bytePrefix);
        int i6 = i4 - 1;
        for (int i7 = 0; i7 < i6; i7++) {
            bArr[i7] = parseByteAt(str, i);
            i += 2;
            if (strM757C.length() != 0) {
                int length4 = strM757C.length();
                for (int i8 = 0; i8 < length4; i8++) {
                    if (!CharsKt__CharKt.equals(strM757C.charAt(i8), str.charAt(i + i8), ignoreCase$kotlin_stdlib)) {
                        throwNotContainedAt(str, i, i2, strM757C, "byte suffix + byte separator + byte prefix");
                    }
                }
                i = strM757C.length() + i;
            }
        }
        bArr[i6] = parseByteAt(str, i);
        int i9 = i + 2;
        if (byteSuffix.length() == 0) {
            return bArr;
        }
        int length5 = byteSuffix.length();
        for (int i10 = 0; i10 < length5; i10++) {
            if (!CharsKt__CharKt.equals(byteSuffix.charAt(i10), str.charAt(i9 + i10), ignoreCase$kotlin_stdlib)) {
                throwNotContainedAt(str, i9, i2, byteSuffix, "byte suffix");
            }
        }
        return bArr;
    }

    @ExperimentalStdlibApi
    private static final byte[] hexToByteArrayShortByteSeparatorNoPrefixAndSuffix(String str, int i, int i2, HexFormat.BytesHexFormat bytesHexFormat) {
        int length = bytesHexFormat.getByteSeparator().length();
        if (length > 1) {
            throw new IllegalArgumentException("Failed requirement.");
        }
        int i4 = i2 - i;
        int i5 = 2;
        if (length == 0) {
            if ((i4 & 1) != 0) {
                return null;
            }
            int i6 = i4 >> 1;
            byte[] bArr = new byte[i6];
            int i7 = 0;
            for (int i8 = 0; i8 < i6; i8++) {
                bArr[i8] = parseByteAt(str, i7);
                i7 += 2;
            }
            return bArr;
        }
        if (i4 % 3 != 2) {
            return null;
        }
        int i9 = (i4 / 3) + 1;
        byte[] bArr2 = new byte[i9];
        char cCharAt = bytesHexFormat.getByteSeparator().charAt(0);
        bArr2[0] = parseByteAt(str, 0);
        for (int i10 = 1; i10 < i9; i10++) {
            if (str.charAt(i5) != cCharAt) {
                String byteSeparator = bytesHexFormat.getByteSeparator();
                boolean ignoreCase$kotlin_stdlib = bytesHexFormat.getIgnoreCase();
                if (byteSeparator.length() != 0) {
                    int length2 = byteSeparator.length();
                    for (int i11 = 0; i11 < length2; i11++) {
                        if (!CharsKt__CharKt.equals(byteSeparator.charAt(i11), str.charAt(i5 + i11), ignoreCase$kotlin_stdlib)) {
                            throwNotContainedAt(str, i5, i2, byteSeparator, "byte separator");
                        }
                    }
                    byteSeparator.length();
                }
            }
            bArr2[i10] = parseByteAt(str, i5 + 1);
            i5 += 3;
        }
        return bArr2;
    }

    /* JADX WARN: Removed duplicated region for block: B:33:0x00cb  */
    /* JADX WARN: Removed duplicated region for block: B:42:0x00f7  */
    /* JADX WARN: Removed duplicated region for block: B:45:0x010d  */
    /* JADX WARN: Removed duplicated region for block: B:46:0x0110  */
    @ExperimentalStdlibApi
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private static final byte[] hexToByteArraySlowPath(String str, int i, int i2, HexFormat.BytesHexFormat bytesHexFormat) {
        int i4;
        int i5;
        int i6;
        int bytesPerLine = bytesHexFormat.getBytesPerLine();
        int bytesPerGroup = bytesHexFormat.getBytesPerGroup();
        String bytePrefix = bytesHexFormat.getBytePrefix();
        String byteSuffix = bytesHexFormat.getByteSuffix();
        String byteSeparator = bytesHexFormat.getByteSeparator();
        String groupSeparator = bytesHexFormat.getGroupSeparator();
        boolean ignoreCase$kotlin_stdlib = bytesHexFormat.getIgnoreCase();
        int i7 = parsedByteArrayMaxSize(i2 - i, bytesPerLine, bytesPerGroup, groupSeparator.length(), byteSeparator.length(), bytePrefix.length(), byteSuffix.length());
        byte[] bArr = new byte[i7];
        int length = i;
        int i8 = 0;
        int i9 = 0;
        int i10 = 0;
        while (length < i2) {
            if (i9 == bytesPerLine) {
                length = checkNewLineAt(str, length, i2);
                i4 = bytesPerLine;
                i5 = bytesPerGroup;
                i9 = 0;
            } else if (i10 != bytesPerGroup) {
                i4 = bytesPerLine;
                i5 = bytesPerGroup;
                if (i10 != 0 && byteSeparator.length() != 0) {
                    int length2 = byteSeparator.length();
                    int i11 = 0;
                    while (i11 < length2) {
                        int i12 = length2;
                        if (!CharsKt__CharKt.equals(byteSeparator.charAt(i11), str.charAt(length + i11), ignoreCase$kotlin_stdlib)) {
                            throwNotContainedAt(str, length, i2, byteSeparator, "byte separator");
                        }
                        i11++;
                        length2 = i12;
                    }
                    length += byteSeparator.length();
                }
                i9++;
                i10++;
                if (bytePrefix.length() != 0) {
                    int length3 = bytePrefix.length();
                    int i13 = 0;
                    while (i13 < length3) {
                        int i14 = length3;
                        if (!CharsKt__CharKt.equals(bytePrefix.charAt(i13), str.charAt(length + i13), ignoreCase$kotlin_stdlib)) {
                            throwNotContainedAt(str, length, i2, bytePrefix, "byte prefix");
                        }
                        i13++;
                        length3 = i14;
                    }
                    length += bytePrefix.length();
                }
                if (i2 - 2 < length) {
                    throwInvalidNumberOfDigits(str, length, i2, "exactly", 2);
                }
                int i15 = i8 + 1;
                bArr[i8] = parseByteAt(str, length);
                length += 2;
                if (byteSuffix.length() != 0) {
                    i6 = i15;
                } else {
                    int length4 = byteSuffix.length();
                    int i16 = 0;
                    while (i16 < length4) {
                        int i17 = i15;
                        if (!CharsKt__CharKt.equals(byteSuffix.charAt(i16), str.charAt(length + i16), ignoreCase$kotlin_stdlib)) {
                            throwNotContainedAt(str, length, i2, byteSuffix, "byte suffix");
                        }
                        i16++;
                        i15 = i17;
                    }
                    i6 = i15;
                    length = byteSuffix.length() + length;
                }
                i8 = i6;
                bytesPerLine = i4;
                bytesPerGroup = i5;
            } else if (groupSeparator.length() == 0) {
                i4 = bytesPerLine;
                i5 = bytesPerGroup;
            } else {
                int length5 = groupSeparator.length();
                int i18 = 0;
                while (i18 < length5) {
                    int i19 = bytesPerLine;
                    int i20 = bytesPerGroup;
                    if (!CharsKt__CharKt.equals(groupSeparator.charAt(i18), str.charAt(length + i18), ignoreCase$kotlin_stdlib)) {
                        throwNotContainedAt(str, length, i2, groupSeparator, "group separator");
                    }
                    i18++;
                    bytesPerLine = i19;
                    bytesPerGroup = i20;
                }
                i4 = bytesPerLine;
                i5 = bytesPerGroup;
                length += groupSeparator.length();
            }
            i10 = 0;
            i9++;
            i10++;
            if (bytePrefix.length() != 0) {
            }
            if (i2 - 2 < length) {
            }
            int i152 = i8 + 1;
            bArr[i8] = parseByteAt(str, length);
            length += 2;
            if (byteSuffix.length() != 0) {
            }
            i8 = i6;
            bytesPerLine = i4;
            bytesPerGroup = i5;
        }
        if (i8 == i7) {
            return bArr;
        }
        byte[] bArrCopyOf = Arrays.copyOf(bArr, i8);
        Intrinsics.checkNotNullExpressionValue(bArrCopyOf, "copyOf(...)");
        return bArrCopyOf;
    }

    @SinceKotlin(version = "1.9")
    @ExperimentalStdlibApi
    public static final int hexToInt(@NotNull String str, @NotNull HexFormat format) {
        Intrinsics.checkNotNullParameter(str, "<this>");
        Intrinsics.checkNotNullParameter(format, "format");
        return hexToInt(str, 0, str.length(), format);
    }

    public static /* synthetic */ int hexToInt$default(String str, HexFormat hexFormat, int i, Object obj) {
        if ((i & 1) != 0) {
            hexFormat = HexFormat.INSTANCE.getDefault();
        }
        return hexToInt(str, hexFormat);
    }

    @ExperimentalStdlibApi
    private static final int hexToIntImpl(String str, int i, int i2, HexFormat hexFormat, int i4) {
        AbstractList.INSTANCE.checkBoundsIndexes$kotlin_stdlib(i, i2, str.length());
        HexFormat.NumberHexFormat number = hexFormat.getNumber();
        if (number.getIsDigitsOnly()) {
            checkNumberOfDigits(str, i, i2, i4);
            return parseInt(str, i, i2);
        }
        String prefix = number.getPrefix();
        String suffix = number.getSuffix();
        checkPrefixSuffixNumberOfDigits(str, i, i2, prefix, suffix, number.getIgnoreCase(), i4);
        return parseInt(str, prefix.length() + i, i2 - suffix.length());
    }

    @SinceKotlin(version = "1.9")
    @ExperimentalStdlibApi
    public static final long hexToLong(@NotNull String str, @NotNull HexFormat format) {
        Intrinsics.checkNotNullParameter(str, "<this>");
        Intrinsics.checkNotNullParameter(format, "format");
        return hexToLong(str, 0, str.length(), format);
    }

    public static /* synthetic */ long hexToLong$default(String str, HexFormat hexFormat, int i, Object obj) {
        if ((i & 1) != 0) {
            hexFormat = HexFormat.INSTANCE.getDefault();
        }
        return hexToLong(str, hexFormat);
    }

    @ExperimentalStdlibApi
    private static final long hexToLongImpl(String str, int i, int i2, HexFormat hexFormat, int i4) {
        AbstractList.INSTANCE.checkBoundsIndexes$kotlin_stdlib(i, i2, str.length());
        HexFormat.NumberHexFormat number = hexFormat.getNumber();
        if (number.getIsDigitsOnly()) {
            checkNumberOfDigits(str, i, i2, i4);
            return parseLong(str, i, i2);
        }
        String prefix = number.getPrefix();
        String suffix = number.getSuffix();
        checkPrefixSuffixNumberOfDigits(str, i, i2, prefix, suffix, number.getIgnoreCase(), i4);
        return parseLong(str, prefix.length() + i, i2 - suffix.length());
    }

    @SinceKotlin(version = "1.9")
    @ExperimentalStdlibApi
    public static final short hexToShort(@NotNull String str, @NotNull HexFormat format) {
        Intrinsics.checkNotNullParameter(str, "<this>");
        Intrinsics.checkNotNullParameter(format, "format");
        return hexToShort(str, 0, str.length(), format);
    }

    public static /* synthetic */ short hexToShort$default(String str, HexFormat hexFormat, int i, Object obj) {
        if ((i & 1) != 0) {
            hexFormat = HexFormat.INSTANCE.getDefault();
        }
        return hexToShort(str, hexFormat);
    }

    private static final long longDecimalFromHexDigitAt(String str, int i) {
        char cCharAt = str.charAt(i);
        if ((cCharAt >>> '\b') == 0) {
            long j = HEX_DIGITS_TO_LONG_DECIMAL[cCharAt];
            if (j >= 0) {
                return j;
            }
        }
        throwInvalidDigitAt(str, i);
        throw new KotlinNothingValueException();
    }

    private static final byte parseByteAt(String str, int i) {
        int[] iArr;
        int i2;
        int i4;
        char cCharAt = str.charAt(i);
        if ((cCharAt >>> '\b') != 0 || (i2 = (iArr = HEX_DIGITS_TO_DECIMAL)[cCharAt]) < 0) {
            throwInvalidDigitAt(str, i);
            throw new KotlinNothingValueException();
        }
        int i5 = i + 1;
        char cCharAt2 = str.charAt(i5);
        if ((cCharAt2 >>> '\b') == 0 && (i4 = iArr[cCharAt2]) >= 0) {
            return (byte) ((i2 << 4) | i4);
        }
        throwInvalidDigitAt(str, i5);
        throw new KotlinNothingValueException();
    }

    private static final int parseInt(String str, int i, int i2) {
        int i4;
        int i5 = 0;
        while (i < i2) {
            int i6 = i5 << 4;
            char cCharAt = str.charAt(i);
            if ((cCharAt >>> '\b') != 0 || (i4 = HEX_DIGITS_TO_DECIMAL[cCharAt]) < 0) {
                throwInvalidDigitAt(str, i);
                throw new KotlinNothingValueException();
            }
            i5 = i6 | i4;
            i++;
        }
        return i5;
    }

    private static final long parseLong(String str, int i, int i2) {
        long j = 0;
        while (i < i2) {
            long j2 = j << 4;
            char cCharAt = str.charAt(i);
            if ((cCharAt >>> '\b') == 0) {
                long j3 = HEX_DIGITS_TO_LONG_DECIMAL[cCharAt];
                if (j3 >= 0) {
                    j = j2 | j3;
                    i++;
                }
            }
            throwInvalidDigitAt(str, i);
            throw new KotlinNothingValueException();
        }
        return j;
    }

    public static final int parsedByteArrayMaxSize(int i, int i2, int i4, int i5, int i6, int i7, int i8) {
        long jCharsPerSet;
        if (i <= 0) {
            throw new IllegalArgumentException("Failed requirement.");
        }
        long j = ((long) i7) + 2 + ((long) i8);
        long jCharsPerSet2 = charsPerSet(j, i4, i6);
        if (i2 <= i4) {
            jCharsPerSet = charsPerSet(j, i2, i6);
        } else {
            jCharsPerSet = charsPerSet(jCharsPerSet2, i2 / i4, i5);
            int i9 = i2 % i4;
            if (i9 != 0) {
                jCharsPerSet = jCharsPerSet + ((long) i5) + charsPerSet(j, i9, i6);
            }
        }
        long j2 = i;
        long jWholeElementsPerSet = wholeElementsPerSet(j2, jCharsPerSet, 1);
        long j3 = j2 - ((jCharsPerSet + 1) * jWholeElementsPerSet);
        long jWholeElementsPerSet2 = wholeElementsPerSet(j3, jCharsPerSet2, i5);
        long j5 = j3 - ((jCharsPerSet2 + ((long) i5)) * jWholeElementsPerSet2);
        long jWholeElementsPerSet3 = wholeElementsPerSet(j5, j, i6);
        return (int) ((jWholeElementsPerSet2 * ((long) i4)) + (jWholeElementsPerSet * ((long) i2)) + jWholeElementsPerSet3 + ((long) (j5 - ((j + ((long) i6)) * jWholeElementsPerSet3) > 0 ? 1 : 0)));
    }

    private static final Void throwInvalidDigitAt(String str, int i) {
        StringBuilder sbM778t = AbstractC0541b.m778t(i, "Expected a hexadecimal digit at index ", ", but was ");
        sbM778t.append(str.charAt(i));
        throw new NumberFormatException(sbM778t.toString());
    }

    private static final void throwInvalidNumberOfDigits(String str, int i, int i2, String str2, int i4) {
        Intrinsics.checkNotNull(str, "null cannot be cast to non-null type java.lang.String");
        String strSubstring = str.substring(i, i2);
        Intrinsics.checkNotNullExpressionValue(strSubstring, "substring(...)");
        throw new NumberFormatException("Expected " + str2 + ' ' + i4 + " hexadecimal digits at index " + i + ", but was \"" + strSubstring + "\" of length " + (i2 - i));
    }

    private static final void throwInvalidPrefixSuffix(String str, int i, int i2, String str2, String str3) {
        Intrinsics.checkNotNull(str, "null cannot be cast to non-null type java.lang.String");
        String strSubstring = str.substring(i, i2);
        Intrinsics.checkNotNullExpressionValue(strSubstring, "substring(...)");
        StringBuilder sbM16m = AbstractC0000a.m16m("Expected a hexadecimal number with prefix \"", str2, "\" and suffix \"", str3, "\", but was ");
        sbM16m.append(strSubstring);
        throw new NumberFormatException(sbM16m.toString());
    }

    private static final void throwNotContainedAt(String str, int i, int i2, String str2, String str3) {
        int iCoerceAtMost = RangesKt.coerceAtMost(str2.length() + i, i2);
        Intrinsics.checkNotNull(str, "null cannot be cast to non-null type java.lang.String");
        String strSubstring = str.substring(i, iCoerceAtMost);
        Intrinsics.checkNotNullExpressionValue(strSubstring, "substring(...)");
        StringBuilder sbM16m = AbstractC0000a.m16m("Expected ", str3, " \"", str2, "\" at index ");
        sbM16m.append(i);
        sbM16m.append(", but was ");
        sbM16m.append(strSubstring);
        throw new NumberFormatException(sbM16m.toString());
    }

    private static final int toCharArrayIfNotEmpty(String str, char[] cArr, int i) {
        int length = str.length();
        if (length != 0) {
            if (length != 1) {
                int length2 = str.length();
                Intrinsics.checkNotNull(str, "null cannot be cast to non-null type java.lang.String");
                str.getChars(0, length2, cArr, i);
            } else {
                cArr[i] = str.charAt(0);
            }
        }
        return str.length() + i;
    }

    @SinceKotlin(version = "1.9")
    @ExperimentalStdlibApi
    @NotNull
    public static final String toHexString(@NotNull byte[] bArr, @NotNull HexFormat format) {
        Intrinsics.checkNotNullParameter(bArr, "<this>");
        Intrinsics.checkNotNullParameter(format, "format");
        return toHexString(bArr, 0, bArr.length, format);
    }

    public static /* synthetic */ String toHexString$default(byte[] bArr, HexFormat hexFormat, int i, Object obj) {
        if ((i & 1) != 0) {
            hexFormat = HexFormat.INSTANCE.getDefault();
        }
        return toHexString(bArr, hexFormat);
    }

    @ExperimentalStdlibApi
    private static final String toHexStringImpl(long j, HexFormat.NumberHexFormat numberHexFormat, String str, int i) {
        if ((i & 3) != 0) {
            throw new IllegalArgumentException("Failed requirement.");
        }
        int i2 = i >> 2;
        int minLength = numberHexFormat.getMinLength();
        int iCoerceAtLeast = RangesKt.coerceAtLeast(minLength - i2, 0);
        String prefix = numberHexFormat.getPrefix();
        String suffix = numberHexFormat.getSuffix();
        boolean removeLeadingZeros = numberHexFormat.getRemoveLeadingZeros();
        int iCheckFormatLength = checkFormatLength(((long) prefix.length()) + ((long) iCoerceAtLeast) + ((long) i2) + ((long) suffix.length()));
        char[] cArr = new char[iCheckFormatLength];
        int charArrayIfNotEmpty = toCharArrayIfNotEmpty(prefix, cArr, 0);
        if (iCoerceAtLeast > 0) {
            int i4 = iCoerceAtLeast + charArrayIfNotEmpty;
            ArraysKt.fill(cArr, str.charAt(0), charArrayIfNotEmpty, i4);
            charArrayIfNotEmpty = i4;
        }
        int i5 = i;
        for (int i6 = 0; i6 < i2; i6++) {
            i5 -= 4;
            int i7 = (int) ((j >> i5) & 15);
            removeLeadingZeros = removeLeadingZeros && i7 == 0 && (i5 >> 2) >= minLength;
            if (!removeLeadingZeros) {
                cArr[charArrayIfNotEmpty] = str.charAt(i7);
                charArrayIfNotEmpty++;
            }
        }
        int charArrayIfNotEmpty2 = toCharArrayIfNotEmpty(suffix, cArr, charArrayIfNotEmpty);
        return charArrayIfNotEmpty2 == iCheckFormatLength ? StringsKt__StringsJVMKt.concatToString(cArr) : StringsKt__StringsJVMKt.concatToString$default(cArr, 0, charArrayIfNotEmpty2, 1, null);
    }

    @ExperimentalStdlibApi
    private static final String toHexStringNoLineAndGroupSeparator(byte[] bArr, int i, int i2, HexFormat.BytesHexFormat bytesHexFormat, int[] iArr) {
        return bytesHexFormat.getShortByteSeparatorNoPrefixAndSuffix() ? toHexStringShortByteSeparatorNoPrefixAndSuffix(bArr, i, i2, bytesHexFormat, iArr) : toHexStringNoLineAndGroupSeparatorSlowPath(bArr, i, i2, bytesHexFormat, iArr);
    }

    @ExperimentalStdlibApi
    private static final String toHexStringNoLineAndGroupSeparatorSlowPath(byte[] bArr, int i, int i2, HexFormat.BytesHexFormat bytesHexFormat, int[] iArr) {
        String bytePrefix = bytesHexFormat.getBytePrefix();
        String byteSuffix = bytesHexFormat.getByteSuffix();
        String byteSeparator = bytesHexFormat.getByteSeparator();
        char[] cArr = new char[formattedStringLength(i2 - i, byteSeparator.length(), bytePrefix.length(), byteSuffix.length())];
        int byteAt = formatByteAt(bArr, i, bytePrefix, byteSuffix, iArr, cArr, 0);
        for (int i4 = i + 1; i4 < i2; i4++) {
            byteAt = formatByteAt(bArr, i4, bytePrefix, byteSuffix, iArr, cArr, toCharArrayIfNotEmpty(byteSeparator, cArr, byteAt));
        }
        return StringsKt__StringsJVMKt.concatToString(cArr);
    }

    @ExperimentalStdlibApi
    private static final String toHexStringShortByteSeparatorNoPrefixAndSuffix(byte[] bArr, int i, int i2, HexFormat.BytesHexFormat bytesHexFormat, int[] iArr) {
        int length = bytesHexFormat.getByteSeparator().length();
        if (length > 1) {
            throw new IllegalArgumentException("Failed requirement.");
        }
        int i4 = i2 - i;
        int byteAt = 0;
        if (length == 0) {
            char[] cArr = new char[checkFormatLength(((long) i4) * 2)];
            while (i < i2) {
                byteAt = formatByteAt(bArr, i, iArr, cArr, byteAt);
                i++;
            }
            return StringsKt__StringsJVMKt.concatToString(cArr);
        }
        char[] cArr2 = new char[checkFormatLength((((long) i4) * 3) - 1)];
        char cCharAt = bytesHexFormat.getByteSeparator().charAt(0);
        int byteAt2 = formatByteAt(bArr, i, iArr, cArr2, 0);
        for (int i5 = i + 1; i5 < i2; i5++) {
            cArr2[byteAt2] = cCharAt;
            byteAt2 = formatByteAt(bArr, i5, iArr, cArr2, byteAt2 + 1);
        }
        return StringsKt__StringsJVMKt.concatToString(cArr2);
    }

    @ExperimentalStdlibApi
    private static final String toHexStringSlowPath(byte[] bArr, int i, int i2, HexFormat.BytesHexFormat bytesHexFormat, int[] iArr) {
        int i4;
        int i5;
        int bytesPerLine = bytesHexFormat.getBytesPerLine();
        int bytesPerGroup = bytesHexFormat.getBytesPerGroup();
        String bytePrefix = bytesHexFormat.getBytePrefix();
        String byteSuffix = bytesHexFormat.getByteSuffix();
        String byteSeparator = bytesHexFormat.getByteSeparator();
        String groupSeparator = bytesHexFormat.getGroupSeparator();
        int i6 = formattedStringLength(i2 - i, bytesPerLine, bytesPerGroup, groupSeparator.length(), byteSeparator.length(), bytePrefix.length(), byteSuffix.length());
        char[] cArr = new char[i6];
        int i7 = i;
        int charArrayIfNotEmpty = 0;
        int i8 = 0;
        int i9 = 0;
        while (i7 < i2) {
            if (i8 == bytesPerLine) {
                cArr[charArrayIfNotEmpty] = '\n';
                charArrayIfNotEmpty++;
                i4 = 0;
                i5 = 0;
            } else if (i9 == bytesPerGroup) {
                charArrayIfNotEmpty = toCharArrayIfNotEmpty(groupSeparator, cArr, charArrayIfNotEmpty);
                i4 = i8;
                i5 = 0;
            } else {
                i4 = i8;
                i5 = i9;
            }
            if (i5 != 0) {
                charArrayIfNotEmpty = toCharArrayIfNotEmpty(byteSeparator, cArr, charArrayIfNotEmpty);
            }
            String str = bytePrefix;
            int byteAt = formatByteAt(bArr, i7, str, byteSuffix, iArr, cArr, charArrayIfNotEmpty);
            i7++;
            i9 = i5 + 1;
            charArrayIfNotEmpty = byteAt;
            bytePrefix = str;
            i8 = i4 + 1;
        }
        if (charArrayIfNotEmpty == i6) {
            return StringsKt__StringsJVMKt.concatToString(cArr);
        }
        throw new IllegalStateException("Check failed.");
    }

    private static final long wholeElementsPerSet(long j, long j2, int i) {
        if (j <= 0 || j2 <= 0) {
            return 0L;
        }
        long j3 = i;
        return (j + j3) / (j2 + j3);
    }

    @ExperimentalStdlibApi
    private static final byte hexToByte(String str, int i, int i2, HexFormat hexFormat) {
        return (byte) hexToIntImpl(str, i, i2, hexFormat, 2);
    }

    @ExperimentalStdlibApi
    private static final byte[] hexToByteArray(String str, int i, int i2, HexFormat hexFormat) {
        byte[] bArrHexToByteArrayNoLineAndGroupSeparator;
        AbstractList.INSTANCE.checkBoundsIndexes$kotlin_stdlib(i, i2, str.length());
        if (i == i2) {
            return new byte[0];
        }
        HexFormat.BytesHexFormat bytes = hexFormat.getBytes();
        return (!bytes.getNoLineAndGroupSeparator() || (bArrHexToByteArrayNoLineAndGroupSeparator = hexToByteArrayNoLineAndGroupSeparator(str, i, i2, bytes)) == null) ? hexToByteArraySlowPath(str, i, i2, bytes) : bArrHexToByteArrayNoLineAndGroupSeparator;
    }

    @ExperimentalStdlibApi
    public static final int hexToInt(@NotNull String str, int i, int i2, @NotNull HexFormat format) {
        Intrinsics.checkNotNullParameter(str, "<this>");
        Intrinsics.checkNotNullParameter(format, "format");
        return hexToIntImpl(str, i, i2, format, 8);
    }

    @ExperimentalStdlibApi
    public static final long hexToLong(@NotNull String str, int i, int i2, @NotNull HexFormat format) {
        Intrinsics.checkNotNullParameter(str, "<this>");
        Intrinsics.checkNotNullParameter(format, "format");
        return hexToLongImpl(str, i, i2, format, 16);
    }

    @ExperimentalStdlibApi
    private static final short hexToShort(String str, int i, int i2, HexFormat hexFormat) {
        return (short) hexToIntImpl(str, i, i2, hexFormat, 4);
    }

    @SinceKotlin(version = "1.9")
    @ExperimentalStdlibApi
    @NotNull
    public static final String toHexString(@NotNull byte[] bArr, int i, int i2, @NotNull HexFormat format) {
        Intrinsics.checkNotNullParameter(bArr, "<this>");
        Intrinsics.checkNotNullParameter(format, "format");
        AbstractList.INSTANCE.checkBoundsIndexes$kotlin_stdlib(i, i2, bArr.length);
        if (i == i2) {
            return "";
        }
        int[] iArr = format.getUpperCase() ? BYTE_TO_UPPER_CASE_HEX_DIGITS : BYTE_TO_LOWER_CASE_HEX_DIGITS;
        HexFormat.BytesHexFormat bytes = format.getBytes();
        return bytes.getNoLineAndGroupSeparator() ? toHexStringNoLineAndGroupSeparator(bArr, i, i2, bytes, iArr) : toHexStringSlowPath(bArr, i, i2, bytes, iArr);
    }

    public static final int formattedStringLength(int i, int i2, int i4, int i5, int i6, int i7, int i8) {
        if (i > 0) {
            int i9 = i - 1;
            int i10 = i9 / i2;
            int i11 = (i2 - 1) / i4;
            int i12 = i % i2;
            if (i12 != 0) {
                i2 = i12;
            }
            int i13 = (i11 * i10) + ((i2 - 1) / i4);
            return checkFormatLength(((((long) i7) + 2 + ((long) i8)) * ((long) i)) + (((long) ((i9 - i10) - i13)) * ((long) i6)) + (((long) i13) * ((long) i5)) + ((long) i10));
        }
        throw new IllegalArgumentException("Failed requirement.");
    }

    public static /* synthetic */ byte hexToByte$default(String str, int i, int i2, HexFormat hexFormat, int i4, Object obj) {
        if ((i4 & 1) != 0) {
            i = 0;
        }
        if ((i4 & 2) != 0) {
            i2 = str.length();
        }
        if ((i4 & 4) != 0) {
            hexFormat = HexFormat.INSTANCE.getDefault();
        }
        return hexToByte(str, i, i2, hexFormat);
    }

    public static /* synthetic */ byte[] hexToByteArray$default(String str, int i, int i2, HexFormat hexFormat, int i4, Object obj) {
        if ((i4 & 1) != 0) {
            i = 0;
        }
        if ((i4 & 2) != 0) {
            i2 = str.length();
        }
        if ((i4 & 4) != 0) {
            hexFormat = HexFormat.INSTANCE.getDefault();
        }
        return hexToByteArray(str, i, i2, hexFormat);
    }

    public static /* synthetic */ int hexToInt$default(String str, int i, int i2, HexFormat hexFormat, int i4, Object obj) {
        if ((i4 & 1) != 0) {
            i = 0;
        }
        if ((i4 & 2) != 0) {
            i2 = str.length();
        }
        if ((i4 & 4) != 0) {
            hexFormat = HexFormat.INSTANCE.getDefault();
        }
        return hexToInt(str, i, i2, hexFormat);
    }

    public static /* synthetic */ long hexToLong$default(String str, int i, int i2, HexFormat hexFormat, int i4, Object obj) {
        if ((i4 & 1) != 0) {
            i = 0;
        }
        if ((i4 & 2) != 0) {
            i2 = str.length();
        }
        if ((i4 & 4) != 0) {
            hexFormat = HexFormat.INSTANCE.getDefault();
        }
        return hexToLong(str, i, i2, hexFormat);
    }

    public static /* synthetic */ short hexToShort$default(String str, int i, int i2, HexFormat hexFormat, int i4, Object obj) {
        if ((i4 & 1) != 0) {
            i = 0;
        }
        if ((i4 & 2) != 0) {
            i2 = str.length();
        }
        if ((i4 & 4) != 0) {
            hexFormat = HexFormat.INSTANCE.getDefault();
        }
        return hexToShort(str, i, i2, hexFormat);
    }

    public static /* synthetic */ String toHexString$default(byte[] bArr, int i, int i2, HexFormat hexFormat, int i4, Object obj) {
        if ((i4 & 1) != 0) {
            i = 0;
        }
        if ((i4 & 2) != 0) {
            i2 = bArr.length;
        }
        if ((i4 & 4) != 0) {
            hexFormat = HexFormat.INSTANCE.getDefault();
        }
        return toHexString(bArr, i, i2, hexFormat);
    }

    private static final int formatByteAt(byte[] bArr, int i, int[] iArr, char[] cArr, int i2) {
        int i4 = iArr[bArr[i] & 255];
        cArr[i2] = (char) (i4 >> 8);
        cArr[i2 + 1] = (char) (i4 & 255);
        return i2 + 2;
    }

    public static /* synthetic */ String toHexString$default(byte b, HexFormat hexFormat, int i, Object obj) {
        if ((i & 1) != 0) {
            hexFormat = HexFormat.INSTANCE.getDefault();
        }
        return toHexString(b, hexFormat);
    }

    public static /* synthetic */ String toHexString$default(short s, HexFormat hexFormat, int i, Object obj) {
        if ((i & 1) != 0) {
            hexFormat = HexFormat.INSTANCE.getDefault();
        }
        return toHexString(s, hexFormat);
    }

    @SinceKotlin(version = "1.9")
    @ExperimentalStdlibApi
    @NotNull
    public static final String toHexString(byte b, @NotNull HexFormat format) {
        Intrinsics.checkNotNullParameter(format, "format");
        String str = format.getUpperCase() ? "0123456789ABCDEF" : LOWER_CASE_HEX_DIGITS;
        HexFormat.NumberHexFormat number = format.getNumber();
        if (number.getIsDigitsOnlyAndNoPadding()) {
            char[] cArr = {str.charAt((b >> 4) & 15), str.charAt(b & 15)};
            if (number.getRemoveLeadingZeros()) {
                return StringsKt__StringsJVMKt.concatToString$default(cArr, RangesKt.coerceAtMost((Integer.numberOfLeadingZeros(b & 255) - 24) >> 2, 1), 0, 2, null);
            }
            return StringsKt__StringsJVMKt.concatToString(cArr);
        }
        return toHexStringImpl(b, number, str, 8);
    }

    public static /* synthetic */ String toHexString$default(int i, HexFormat hexFormat, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            hexFormat = HexFormat.INSTANCE.getDefault();
        }
        return toHexString(i, hexFormat);
    }

    public static /* synthetic */ String toHexString$default(long j, HexFormat hexFormat, int i, Object obj) {
        if ((i & 1) != 0) {
            hexFormat = HexFormat.INSTANCE.getDefault();
        }
        return toHexString(j, hexFormat);
    }

    @SinceKotlin(version = "1.9")
    @ExperimentalStdlibApi
    @NotNull
    public static final String toHexString(short s, @NotNull HexFormat format) {
        Intrinsics.checkNotNullParameter(format, "format");
        String str = format.getUpperCase() ? "0123456789ABCDEF" : LOWER_CASE_HEX_DIGITS;
        HexFormat.NumberHexFormat number = format.getNumber();
        if (number.getIsDigitsOnlyAndNoPadding()) {
            char[] cArr = {str.charAt((s >> 12) & 15), str.charAt((s >> 8) & 15), str.charAt((s >> 4) & 15), str.charAt(s & 15)};
            if (number.getRemoveLeadingZeros()) {
                return StringsKt__StringsJVMKt.concatToString$default(cArr, RangesKt.coerceAtMost((Integer.numberOfLeadingZeros(s & UShort.MAX_VALUE) - 16) >> 2, 3), 0, 2, null);
            }
            return StringsKt__StringsJVMKt.concatToString(cArr);
        }
        return toHexStringImpl(s, number, str, 16);
    }

    @ExperimentalStdlibApi
    public static /* synthetic */ void getBYTE_TO_LOWER_CASE_HEX_DIGITS$annotations() {
    }

    @SinceKotlin(version = "1.9")
    @ExperimentalStdlibApi
    @NotNull
    public static final String toHexString(int i, @NotNull HexFormat format) {
        Intrinsics.checkNotNullParameter(format, "format");
        String str = format.getUpperCase() ? "0123456789ABCDEF" : LOWER_CASE_HEX_DIGITS;
        HexFormat.NumberHexFormat number = format.getNumber();
        if (number.getIsDigitsOnlyAndNoPadding()) {
            char[] cArr = {str.charAt((i >> 28) & 15), str.charAt((i >> 24) & 15), str.charAt((i >> 20) & 15), str.charAt((i >> 16) & 15), str.charAt((i >> 12) & 15), str.charAt((i >> 8) & 15), str.charAt((i >> 4) & 15), str.charAt(i & 15)};
            if (number.getRemoveLeadingZeros()) {
                return StringsKt__StringsJVMKt.concatToString$default(cArr, RangesKt.coerceAtMost(Integer.numberOfLeadingZeros(i) >> 2, 7), 0, 2, null);
            }
            return StringsKt__StringsJVMKt.concatToString(cArr);
        }
        return toHexStringImpl(i, number, str, 32);
    }

    @SinceKotlin(version = "1.9")
    @ExperimentalStdlibApi
    @NotNull
    public static final String toHexString(long j, @NotNull HexFormat format) {
        Intrinsics.checkNotNullParameter(format, "format");
        String str = format.getUpperCase() ? "0123456789ABCDEF" : LOWER_CASE_HEX_DIGITS;
        HexFormat.NumberHexFormat number = format.getNumber();
        if (number.getIsDigitsOnlyAndNoPadding()) {
            char[] cArr = {str.charAt((int) ((j >> 60) & 15)), str.charAt((int) ((j >> 56) & 15)), str.charAt((int) ((j >> 52) & 15)), str.charAt((int) ((j >> 48) & 15)), str.charAt((int) ((j >> 44) & 15)), str.charAt((int) ((j >> 40) & 15)), str.charAt((int) ((j >> 36) & 15)), str.charAt((int) ((j >> 32) & 15)), str.charAt((int) ((j >> 28) & 15)), str.charAt((int) ((j >> 24) & 15)), str.charAt((int) ((j >> 20) & 15)), str.charAt((int) ((j >> 16) & 15)), str.charAt((int) ((j >> 12) & 15)), str.charAt((int) ((j >> 8) & 15)), str.charAt((int) ((j >> 4) & 15)), str.charAt((int) (j & 15))};
            if (number.getRemoveLeadingZeros()) {
                return StringsKt__StringsJVMKt.concatToString$default(cArr, RangesKt.coerceAtMost(Long.numberOfLeadingZeros(j) >> 2, 15), 0, 2, null);
            }
            return StringsKt__StringsJVMKt.concatToString(cArr);
        }
        return toHexStringImpl(j, number, str, 64);
    }
}
