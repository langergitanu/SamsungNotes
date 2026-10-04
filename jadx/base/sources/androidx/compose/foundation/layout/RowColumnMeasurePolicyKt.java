package androidx.compose.foundation.layout;

import androidx.collection.AbstractC0622a;
import androidx.compose.p109ui.layout.Measurable;
import androidx.compose.p109ui.layout.MeasureResult;
import androidx.compose.p109ui.layout.MeasureScope;
import androidx.compose.p109ui.layout.Placeable;
import com.samsung.android.scs.p140ai.sdkcommon.text.TextConst;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.CharCompanionObject;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.math.MathKt;
import kotlin.ranges.RangesKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes.dex */
@Metadata(m13885d1 = {"\u00008\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0015\n\u0002\b\u0003\u001a\u0085\u0001\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\n2\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\r0\f2\u000e\u0010\u000e\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00100\u000f2\u0006\u0010\u0011\u001a\u00020\u00042\u0006\u0010\u0012\u001a\u00020\u00042\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u00142\b\b\u0002\u0010\u0015\u001a\u00020\u0004H\u0000¢\u0006\u0002\u0010\u0016¨\u0006\u0017"}, m13886d2 = {"measure", "Landroidx/compose/ui/layout/MeasureResult;", "Landroidx/compose/foundation/layout/RowColumnMeasurePolicy;", "mainAxisMin", "", "crossAxisMin", "mainAxisMax", "crossAxisMax", "arrangementSpacingInt", "measureScope", "Landroidx/compose/ui/layout/MeasureScope;", "measurables", "", "Landroidx/compose/ui/layout/Measurable;", "placeables", "", "Landroidx/compose/ui/layout/Placeable;", TextConst.KEY_START_INDEX, TextConst.KEY_END_INDEX, "crossAxisOffset", "", "currentLineIndex", "(Landroidx/compose/foundation/layout/RowColumnMeasurePolicy;IIIIILandroidx/compose/ui/layout/MeasureScope;Ljava/util/List;[Landroidx/compose/ui/layout/Placeable;II[II)Landroidx/compose/ui/layout/MeasureResult;", "foundation-layout_release"}, m13887k = 2, m13888mv = {1, 8, 0}, m13890xi = 48)
@SourceDebugExtension({"SMAP\nRowColumnMeasurePolicy.kt\nKotlin\n*S Kotlin\n*F\n+ 1 RowColumnMeasurePolicy.kt\nandroidx/compose/foundation/layout/RowColumnMeasurePolicyKt\n+ 2 InlineClassHelper.jvm.kt\nandroidx/compose/ui/util/InlineClassHelper_jvmKt\n+ 3 RowColumnMeasurePolicy.jvm.kt\nandroidx/compose/foundation/layout/RowColumnMeasurePolicy_jvmKt\n+ 4 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,359:1\n26#2:360\n26#2:361\n26#2:363\n26#2:365\n24#3:362\n24#3:366\n1#4:364\n*S KotlinDebug\n*F\n+ 1 RowColumnMeasurePolicy.kt\nandroidx/compose/foundation/layout/RowColumnMeasurePolicyKt\n*L\n116#1:360\n168#1:361\n214#1:363\n225#1:365\n170#1:362\n244#1:366\n*E\n"})
public final class RowColumnMeasurePolicyKt {
    /* JADX WARN: Removed duplicated region for block: B:125:0x0287 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:75:0x0257 A[Catch: IllegalArgumentException -> 0x0263, TRY_LEAVE, TryCatch #0 {IllegalArgumentException -> 0x0263, blocks: (B:67:0x0244, B:75:0x0257), top: B:123:0x0244 }] */
    /* JADX WARN: Removed duplicated region for block: B:79:0x0281  */
    /* JADX WARN: Removed duplicated region for block: B:85:0x02aa  */
    @NotNull
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final MeasureResult measure(@NotNull RowColumnMeasurePolicy rowColumnMeasurePolicy, int i, int i2, int i4, int i5, int i6, @NotNull MeasureScope measureScope, @NotNull List<? extends Measurable> list, @NotNull Placeable[] placeableArr, int i7, int i8, @Nullable int[] iArr, int i9) {
        int i10;
        int i11;
        String str;
        float f;
        String str2;
        long j;
        String str3;
        String str4;
        long j2;
        String str5;
        String str6;
        String str7;
        int i12;
        int iCoerceIn;
        String str8;
        String str9;
        int i13;
        int i14;
        String str10;
        String str11;
        String str12;
        String str13;
        FlowLayoutData flowLayoutData;
        String str14;
        int i15;
        int i16;
        float f4;
        Integer num;
        long j3;
        long j5;
        float f5;
        int i17;
        char c;
        String str15;
        int iIntValue;
        int iIntValue2;
        int i18;
        int i19;
        int i20;
        int i21;
        int i22;
        int i23;
        int i24;
        RowColumnMeasurePolicy rowColumnMeasurePolicy2;
        int i25;
        FlowLayoutData flowLayoutData2;
        int i26 = i5;
        List<? extends Measurable> list2 = list;
        int i27 = i8;
        long j6 = i6;
        int i28 = i27 - i7;
        int[] iArr2 = new int[i28];
        int i29 = 0;
        int i30 = i7;
        int i31 = 0;
        int i32 = 0;
        int i33 = 0;
        int i34 = 0;
        int i35 = 0;
        float f6 = 0.0f;
        while (true) {
            Integer numValueOf = null;
            i10 = i32;
            if (i30 >= i27) {
                break;
            }
            float f7 = f6;
            Measurable measurable = list2.get(i30);
            RowColumnParentData rowColumnParentData = RowColumnImplKt.getRowColumnParentData(measurable);
            float weight = RowColumnImplKt.getWeight(rowColumnParentData);
            int i36 = (i33 != 0 || RowColumnImplKt.isRelative(rowColumnParentData)) ? 1 : i29;
            if (weight > 0.0f) {
                f6 = f7 + weight;
                i31++;
                i21 = i28;
                i22 = i30;
                i32 = i10;
            } else {
                if (i26 != Integer.MAX_VALUE && rowColumnParentData != null && (flowLayoutData2 = rowColumnParentData.getFlowLayoutData()) != null) {
                    numValueOf = Integer.valueOf(Math.round(flowLayoutData2.getFillCrossAxisFraction() * i26));
                }
                int i37 = i4 - i10;
                Placeable placeableMo19855measureBRTryo0 = placeableArr[i30];
                if (placeableMo19855measureBRTryo0 == null) {
                    i23 = i37;
                    i22 = i30;
                    i21 = i28;
                    i24 = i10;
                    rowColumnMeasurePolicy2 = rowColumnMeasurePolicy;
                    i25 = i31;
                    placeableMo19855measureBRTryo0 = measurable.mo19855measureBRTryo0(RowColumnMeasurePolicy.m15879createConstraintsxF2OJ5Q$default(rowColumnMeasurePolicy2, 0, numValueOf != null ? numValueOf.intValue() : i29, i4 != Integer.MAX_VALUE ? RangesKt.coerceAtLeast(i37, i29) : Integer.MAX_VALUE, numValueOf != null ? numValueOf.intValue() : i26, false, 16, null));
                } else {
                    i21 = i28;
                    i22 = i30;
                    i23 = i37;
                    i24 = i10;
                    rowColumnMeasurePolicy2 = rowColumnMeasurePolicy;
                    i25 = i31;
                }
                int iMainAxisSize = rowColumnMeasurePolicy2.mainAxisSize(placeableMo19855measureBRTryo0);
                int iCrossAxisSize = rowColumnMeasurePolicy2.crossAxisSize(placeableMo19855measureBRTryo0);
                iArr2[i22 - i7] = iMainAxisSize;
                int iMin = Math.min(i6, RangesKt.coerceAtLeast(i23 - iMainAxisSize, 0));
                int iMax = Math.max(i35, iCrossAxisSize);
                placeableArr[i22] = placeableMo19855measureBRTryo0;
                i32 = iMainAxisSize + iMin + i24;
                i35 = iMax;
                i34 = iMin;
                i31 = i25;
                f6 = f7;
            }
            i30 = i22 + 1;
            i26 = i5;
            i33 = i36;
            i28 = i21;
            i29 = 0;
        }
        int i38 = i28;
        float f8 = f6;
        int i39 = i10;
        RowColumnMeasurePolicy rowColumnMeasurePolicy3 = rowColumnMeasurePolicy;
        int i40 = i31;
        int i41 = i35;
        if (i40 != 0) {
            int i42 = i4 != Integer.MAX_VALUE ? i4 : i;
            long j7 = ((long) (i40 - 1)) * j6;
            int i43 = i33;
            long jCoerceAtLeast = RangesKt.coerceAtLeast(((long) (i42 - i39)) - j7, 0L);
            float f9 = jCoerceAtLeast / f8;
            int i44 = i7;
            long jRound = jCoerceAtLeast;
            i11 = i43;
            while (true) {
                str = "weightedSize ";
                f = f9;
                str2 = "remainingToTarget ";
                j = jCoerceAtLeast;
                str3 = "fixedSpace ";
                str4 = "weightChildrenCount ";
                j2 = j7;
                str5 = "arrangementSpacingPx ";
                str6 = "targetSpace ";
                str7 = "arrangementSpacingTotal ";
                if (i44 >= i27) {
                    break;
                }
                int i45 = i44;
                float weight2 = RowColumnImplKt.getWeight(RowColumnImplKt.getRowColumnParentData(list2.get(i44)));
                float f10 = f * weight2;
                try {
                    jRound -= (long) Math.round(f10);
                    i44 = i45 + 1;
                    list2 = list;
                    f9 = f;
                    jCoerceAtLeast = j;
                    j7 = j2;
                } catch (IllegalArgumentException e) {
                    StringBuilder sbM1173s = AbstractC0622a.m1173s(i4, i, "This log indicates a hard-to-reproduce Compose issue, modified with additional debugging details. Please help us by adding your experiences to the bug link provided. Thank you for helping us improve Compose. https://issuetracker.google.com/issues/297974033 mainAxisMax ", "mainAxisMin ", "targetSpace ");
                    sbM1173s.append(i42);
                    sbM1173s.append("arrangementSpacingPx ");
                    sbM1173s.append(j6);
                    AbstractC0622a.m1180z(sbM1173s, i40, i39, "weightChildrenCount ", "fixedSpace ");
                    AbstractC1038a.m1223x(sbM1173s, str7, j2, "remainingToTarget ");
                    sbM1173s.append(j);
                    sbM1173s.append("totalWeight ");
                    sbM1173s.append(f8);
                    sbM1173s.append("weightUnitSpace ");
                    sbM1173s.append(f);
                    sbM1173s.append("itemWeight ");
                    sbM1173s.append(weight2);
                    sbM1173s.append(str);
                    sbM1173s.append(f10);
                    throw new IllegalArgumentException(sbM1173s.toString()).initCause(e);
                }
            }
            int i46 = i7;
            int i47 = i41;
            int i48 = 0;
            while (true) {
                float f11 = f8;
                String str16 = str7;
                if (i46 >= i27) {
                    i12 = i39;
                    i41 = i47;
                    iCoerceIn = RangesKt.coerceIn((int) (((long) i48) + j2), 0, i4 - i12);
                    break;
                }
                if (placeableArr[i46] == null) {
                    i13 = i46;
                    Measurable measurable2 = list.get(i46);
                    RowColumnParentData rowColumnParentData2 = RowColumnImplKt.getRowColumnParentData(measurable2);
                    float weight3 = RowColumnImplKt.getWeight(rowColumnParentData2);
                    Integer numValueOf2 = (i5 == Integer.MAX_VALUE || rowColumnParentData2 == null || (flowLayoutData = rowColumnParentData2.getFlowLayoutData()) == null) ? null : Integer.valueOf(Math.round(i5 * flowLayoutData.getFillCrossAxisFraction()));
                    if (weight3 <= 0.0f) {
                        throw new IllegalStateException("All weights <= 0 should have placeables");
                    }
                    Integer num2 = numValueOf2;
                    int sign = MathKt.getSign(jRound);
                    String str17 = str5;
                    jRound -= (long) sign;
                    float f12 = f * weight3;
                    String str18 = str6;
                    int iMax2 = Math.max(0, Math.round(f12) + sign);
                    try {
                    } catch (IllegalArgumentException e2) {
                        e = e2;
                        str14 = str3;
                        str9 = str4;
                        i15 = sign;
                        i16 = i39;
                        str10 = str2;
                        str11 = str;
                        f4 = weight3;
                        num = num2;
                        j3 = j;
                        j5 = j2;
                        str12 = str17;
                        f5 = f12;
                        str13 = str18;
                        i17 = iMax2;
                    }
                    try {
                        if (RowColumnImplKt.getFill(rowColumnParentData2)) {
                            c = CharCompanionObject.MAX_VALUE;
                            int i49 = iMax2 != Integer.MAX_VALUE ? iMax2 : 0;
                            if (num2 == null) {
                                String str19 = str3;
                                i17 = iMax2;
                                iIntValue = num2.intValue();
                                str15 = str19;
                            } else {
                                str15 = str3;
                                i17 = iMax2;
                                iIntValue = 0;
                            }
                            if (num2 == null) {
                                try {
                                    iIntValue2 = num2.intValue();
                                } catch (IllegalArgumentException e3) {
                                    e = e3;
                                    str9 = str4;
                                    i15 = sign;
                                    i16 = i39;
                                    str14 = str15;
                                    str11 = str;
                                    f4 = weight3;
                                    num = num2;
                                    j3 = j;
                                    j5 = j2;
                                    str12 = str17;
                                    f5 = f12;
                                    str10 = str2;
                                    str13 = str18;
                                    StringBuilder sbM1173s2 = AbstractC0622a.m1173s(i4, i, "This log indicates a hard-to-reproduce Compose issue, modified with additional debugging details. Please help us by adding your experiences to the bug link provided. Thank you for helping us improve Compose. https://issuetracker.google.com/issues/300280216 mainAxisMax ", "mainAxisMin ", str13);
                                    sbM1173s2.append(i42);
                                    sbM1173s2.append(str12);
                                    sbM1173s2.append(j6);
                                    AbstractC0622a.m1180z(sbM1173s2, i40, i16, str9, str14);
                                    AbstractC1038a.m1223x(sbM1173s2, str16, j5, str10);
                                    sbM1173s2.append(j3);
                                    sbM1173s2.append("totalWeight ");
                                    sbM1173s2.append(f11);
                                    sbM1173s2.append("weightUnitSpace ");
                                    sbM1173s2.append(f);
                                    sbM1173s2.append("weight ");
                                    sbM1173s2.append(f4);
                                    sbM1173s2.append(str11);
                                    sbM1173s2.append(f5);
                                    sbM1173s2.append("crossAxisDesiredSize ");
                                    sbM1173s2.append(num);
                                    sbM1173s2.append("remainderUnit ");
                                    sbM1173s2.append(i15);
                                    sbM1173s2.append("childMainAxisSize ");
                                    sbM1173s2.append(i17);
                                    throw new IllegalArgumentException(sbM1173s2.toString()).initCause(e);
                                }
                            } else {
                                iIntValue2 = i5;
                            }
                            str9 = str4;
                            int i50 = iIntValue2;
                            str11 = str;
                            f4 = weight3;
                            num = num2;
                            j3 = j;
                            j5 = j2;
                            f5 = f12;
                            i15 = sign;
                            i16 = i39;
                            str14 = str15;
                            str12 = str17;
                            rowColumnMeasurePolicy3 = rowColumnMeasurePolicy;
                            str10 = str2;
                            str13 = str18;
                            Placeable placeableMo19855measureBRTryo02 = measurable2.mo19855measureBRTryo0(rowColumnMeasurePolicy3.mo15769createConstraintsxF2OJ5Q(i49, iIntValue, i17, i50, true));
                            int iMainAxisSize2 = rowColumnMeasurePolicy3.mainAxisSize(placeableMo19855measureBRTryo02);
                            int iCrossAxisSize2 = rowColumnMeasurePolicy3.crossAxisSize(placeableMo19855measureBRTryo02);
                            iArr2[i13 - i7] = iMainAxisSize2;
                            i48 += iMainAxisSize2;
                            int iMax3 = Math.max(i47, iCrossAxisSize2);
                            placeableArr[i13] = placeableMo19855measureBRTryo02;
                            i14 = i16;
                            str8 = str14;
                            j2 = j5;
                            j = j3;
                            i47 = iMax3;
                        } else {
                            c = CharCompanionObject.MAX_VALUE;
                        }
                        Placeable placeableMo19855measureBRTryo022 = measurable2.mo19855measureBRTryo0(rowColumnMeasurePolicy3.mo15769createConstraintsxF2OJ5Q(i49, iIntValue, i17, i50, true));
                        int iMainAxisSize22 = rowColumnMeasurePolicy3.mainAxisSize(placeableMo19855measureBRTryo022);
                        int iCrossAxisSize22 = rowColumnMeasurePolicy3.crossAxisSize(placeableMo19855measureBRTryo022);
                        iArr2[i13 - i7] = iMainAxisSize22;
                        i48 += iMainAxisSize22;
                        int iMax32 = Math.max(i47, iCrossAxisSize22);
                        placeableArr[i13] = placeableMo19855measureBRTryo022;
                        i14 = i16;
                        str8 = str14;
                        j2 = j5;
                        j = j3;
                        i47 = iMax32;
                    } catch (IllegalArgumentException e5) {
                        e = e5;
                        StringBuilder sbM1173s22 = AbstractC0622a.m1173s(i4, i, "This log indicates a hard-to-reproduce Compose issue, modified with additional debugging details. Please help us by adding your experiences to the bug link provided. Thank you for helping us improve Compose. https://issuetracker.google.com/issues/300280216 mainAxisMax ", "mainAxisMin ", str13);
                        sbM1173s22.append(i42);
                        sbM1173s22.append(str12);
                        sbM1173s22.append(j6);
                        AbstractC0622a.m1180z(sbM1173s22, i40, i16, str9, str14);
                        AbstractC1038a.m1223x(sbM1173s22, str16, j5, str10);
                        sbM1173s22.append(j3);
                        sbM1173s22.append("totalWeight ");
                        sbM1173s22.append(f11);
                        sbM1173s22.append("weightUnitSpace ");
                        sbM1173s22.append(f);
                        sbM1173s22.append("weight ");
                        sbM1173s22.append(f4);
                        sbM1173s22.append(str11);
                        sbM1173s22.append(f5);
                        sbM1173s22.append("crossAxisDesiredSize ");
                        sbM1173s22.append(num);
                        sbM1173s22.append("remainderUnit ");
                        sbM1173s22.append(i15);
                        sbM1173s22.append("childMainAxisSize ");
                        sbM1173s22.append(i17);
                        throw new IllegalArgumentException(sbM1173s22.toString()).initCause(e);
                    }
                    if (num2 == null) {
                    }
                    if (num2 == null) {
                    }
                    str9 = str4;
                    int i502 = iIntValue2;
                    str11 = str;
                    f4 = weight3;
                    num = num2;
                    j3 = j;
                    j5 = j2;
                    f5 = f12;
                    i15 = sign;
                    i16 = i39;
                    str14 = str15;
                    str12 = str17;
                    rowColumnMeasurePolicy3 = rowColumnMeasurePolicy;
                    str10 = str2;
                    str13 = str18;
                } else {
                    str8 = str3;
                    str9 = str4;
                    i13 = i46;
                    i14 = i39;
                    str10 = str2;
                    str11 = str;
                    str12 = str5;
                    str13 = str6;
                }
                f8 = f11;
                str7 = str16;
                int i51 = i14;
                i46 = i13 + 1;
                str5 = str12;
                i39 = i51;
                str6 = str13;
                str3 = str8;
                str2 = str10;
                str = str11;
                str4 = str9;
                i27 = i8;
            }
        } else {
            i12 = i39 - i34;
            i11 = i33;
            iCoerceIn = 0;
        }
        if (i11 != 0) {
            i18 = i8;
            int iMax4 = 0;
            int iMax5 = 0;
            for (int i52 = i7; i52 < i18; i52++) {
                Placeable placeable = placeableArr[i52];
                Intrinsics.checkNotNull(placeable);
                CrossAxisAlignment crossAxisAlignment = RowColumnImplKt.getCrossAxisAlignment(RowColumnImplKt.getRowColumnParentData(placeable));
                Integer numCalculateAlignmentLinePosition$foundation_layout_release = crossAxisAlignment != null ? crossAxisAlignment.calculateAlignmentLinePosition$foundation_layout_release(placeable) : null;
                if (numCalculateAlignmentLinePosition$foundation_layout_release != null) {
                    int iIntValue3 = numCalculateAlignmentLinePosition$foundation_layout_release.intValue();
                    int iCrossAxisSize3 = rowColumnMeasurePolicy3.crossAxisSize(placeable);
                    iMax4 = Math.max(iMax4, iIntValue3 != Integer.MIN_VALUE ? numCalculateAlignmentLinePosition$foundation_layout_release.intValue() : 0);
                    if (iIntValue3 == Integer.MIN_VALUE) {
                        iIntValue3 = iCrossAxisSize3;
                    }
                    iMax5 = Math.max(iMax5, iCrossAxisSize3 - iIntValue3);
                }
            }
            int i53 = iMax5;
            i20 = iMax4;
            i19 = i53;
        } else {
            i18 = i8;
            i19 = 0;
            i20 = 0;
        }
        int iMax6 = Math.max(RangesKt.coerceAtLeast(i12 + iCoerceIn, 0), i);
        int iMax7 = Math.max(i41, Math.max(i2, i19 + i20));
        int[] iArr3 = new int[i38];
        for (int i54 = 0; i54 < i38; i54++) {
            iArr3[i54] = 0;
        }
        rowColumnMeasurePolicy3.populateMainAxisPositions(iMax6, iArr2, iArr3, measureScope);
        return rowColumnMeasurePolicy3.placeHelper(placeableArr, measureScope, i20, iArr3, iMax6, iMax7, iArr, i9, i7, i18);
    }
}
