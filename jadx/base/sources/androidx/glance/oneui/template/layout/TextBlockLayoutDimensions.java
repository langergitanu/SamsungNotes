package androidx.glance.oneui.template.layout;

import android.annotation.SuppressLint;
import android.content.Context;
import androidx.compose.p109ui.platform.AndroidCompositionLocals_androidKt;
import androidx.compose.p109ui.unit.C2256Dp;
import androidx.compose.p109ui.unit.DpRect;
import androidx.compose.runtime.Composable;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.internal.StabilityInferred;
import androidx.glance.layout.Alignment;
import androidx.glance.oneui.common.AppWidgetSize;
import androidx.glance.oneui.template.C3094R;
import androidx.glance.oneui.template.CompositionLocalsKt;
import androidx.glance.oneui.template.Orientation;
import androidx.glance.oneui.template.TemplateCompositor;
import androidx.glance.oneui.template.TextBlockItem;
import androidx.glance.oneui.template.TextType;
import androidx.glance.oneui.template.TypedTextData;
import androidx.glance.text.TextAlign;
import com.microsoft.identity.common.java.WarningType;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes4.dex */
@StabilityInferred(parameters = 1)
@Metadata(m13885d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\bÀ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J3\u0010\u0003\u001a\u00020\u00042\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u00062\u0006\u0010\b\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\u0004H\u0007¢\u0006\u0002\u0010\fJ\u0015\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u0010H\u0007¢\u0006\u0002\u0010\u0011JZ\u0010\u0012\u001a\u00020\u000e2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u0013\u001a\u00020\u00142\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\u00142\n\b\u0002\u0010\u0016\u001a\u0004\u0018\u00010\u00142\n\b\u0002\u0010\u0017\u001a\u0004\u0018\u00010\u00142\b\b\u0002\u0010\u0018\u001a\u00020\u00192\b\b\u0002\u0010\u001a\u001a\u00020\u001bH\u0007ø\u0001\u0000¢\u0006\u0004\b\u001c\u0010\u001dJ=\u0010\u0012\u001a\u00020\u000e2\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u00062\u0006\u0010\b\u001a\u00020\u00042\u0006\u0010\u001e\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\n2\b\b\u0002\u0010\u001a\u001a\u00020\u001bH\u0007¢\u0006\u0002\u0010\u001fJ\u001d\u0010 \u001a\u00020\u00042\u0006\u0010!\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\nH\u0007¢\u0006\u0002\u0010\"\u0082\u0002\u0007\n\u0005\b¡\u001e0\u0001¨\u0006#"}, m13886d2 = {"Landroidx/glance/oneui/template/layout/TextBlockLayoutDimensions;", "", "()V", "getNumberToGroup", "", "texts", "", "Landroidx/glance/oneui/template/TypedTextData;", "i", "fromSingleBlock", "", "visibleCount", "(Ljava/util/List;IZILandroidx/compose/runtime/Composer;I)I", "itemPadding", "Landroidx/compose/ui/unit/DpRect;", "item", "Landroidx/glance/oneui/template/TextBlockItem;", "(Landroidx/glance/oneui/template/TextBlockItem;Landroidx/compose/runtime/Composer;I)Landroidx/compose/ui/unit/DpRect;", "textPadding", "currTextType", "Landroidx/glance/oneui/template/TextType;", "nextTextType", "prevTextType", "prevPrevTextType", "currTextAlign", "Landroidx/glance/text/TextAlign;", "orientation", "Landroidx/glance/oneui/template/Orientation;", "textPadding-58yVOK4", "(ZILandroidx/glance/oneui/template/TextType;Landroidx/glance/oneui/template/TextType;Landroidx/glance/oneui/template/TextType;ILandroidx/glance/oneui/template/Orientation;Landroidx/compose/runtime/Composer;II)Landroidx/compose/ui/unit/DpRect;", "lastIndex", "(Ljava/util/List;IIZLandroidx/glance/oneui/template/Orientation;Landroidx/compose/runtime/Composer;II)Landroidx/compose/ui/unit/DpRect;", "visibleTextCount", "totalCount", "(IZLandroidx/compose/runtime/Composer;I)I", "glance-oneui-template_release"}, m13887k = 1, m13888mv = {1, 9, 0}, m13890xi = 48)
@SourceDebugExtension({"SMAP\nLayoutDimensions.kt\nKotlin\n*S Kotlin\n*F\n+ 1 LayoutDimensions.kt\nandroidx/glance/oneui/template/layout/TextBlockLayoutDimensions\n+ 2 CompositionLocal.kt\nandroidx/compose/runtime/CompositionLocal\n+ 3 Dp.kt\nandroidx/compose/ui/unit/DpKt\n*L\n1#1,729:1\n74#2:730\n74#2:731\n74#2:739\n74#2:740\n74#2:741\n74#2:753\n74#2:786\n154#3:732\n154#3:733\n154#3:734\n154#3:735\n154#3:736\n154#3:737\n154#3:738\n174#3:742\n174#3:743\n154#3:744\n154#3:745\n154#3:746\n154#3:747\n154#3:748\n154#3:749\n154#3:750\n154#3:751\n154#3:752\n154#3:754\n154#3:755\n154#3:756\n154#3:757\n154#3:758\n154#3:759\n154#3:760\n154#3:761\n154#3:762\n154#3:763\n154#3:764\n154#3:765\n154#3:766\n154#3:767\n154#3:768\n154#3:769\n154#3:770\n154#3:771\n154#3:772\n154#3:773\n154#3:774\n154#3:775\n154#3:776\n154#3:777\n154#3:778\n154#3:779\n154#3:780\n154#3:781\n154#3:782\n154#3:783\n154#3:784\n154#3:785\n*S KotlinDebug\n*F\n+ 1 LayoutDimensions.kt\nandroidx/glance/oneui/template/layout/TextBlockLayoutDimensions\n*L\n396#1:730\n410#1:731\n428#1:739\n429#1:740\n430#1:741\n511#1:753\n656#1:786\n412#1:732\n415#1:733\n416#1:734\n420#1:735\n421#1:736\n423#1:737\n424#1:738\n435#1:742\n436#1:743\n440#1:744\n448#1:745\n450#1:746\n453#1:747\n458#1:748\n465#1:749\n469#1:750\n471#1:751\n475#1:752\n513#1:754\n521#1:755\n523#1:756\n532#1:757\n540#1:758\n546#1:759\n550#1:760\n552#1:761\n553#1:762\n554#1:763\n559#1:764\n563#1:765\n567#1:766\n573#1:767\n574#1:768\n576#1:769\n583#1:770\n584#1:771\n588#1:772\n590#1:773\n591#1:774\n592#1:775\n596#1:776\n597#1:777\n601#1:778\n605#1:779\n606#1:780\n608#1:781\n618#1:782\n623#1:783\n625#1:784\n627#1:785\n*E\n"})
public final class TextBlockLayoutDimensions {
    public static final int $stable = 0;

    @NotNull
    public static final TextBlockLayoutDimensions INSTANCE = new TextBlockLayoutDimensions();

    private TextBlockLayoutDimensions() {
    }

    /* JADX WARN: Removed duplicated region for block: B:25:0x007d  */
    /* JADX WARN: Removed duplicated region for block: B:46:0x00e0  */
    @Composable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final int getNumberToGroup(@NotNull List<? extends TypedTextData> texts, int i, boolean z, int i2, @Nullable Composer composer, int i4) {
        Intrinsics.checkNotNullParameter(texts, "texts");
        composer.startReplaceableGroup(-192487477);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-192487477, i4, -1, "androidx.glance.oneui.template.layout.TextBlockLayoutDimensions.getNumberToGroup (LayoutDimensions.kt:644)");
        }
        int i5 = i + 1;
        TypedTextData typedTextData = i5 < i2 ? texts.get(i5) : null;
        int i6 = 0;
        if (typedTextData == null) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            composer.endReplaceableGroup();
            return 0;
        }
        int textType = texts.get(i).getTextType();
        int textType2 = typedTextData.getTextType();
        int i7 = i + 2;
        TypedTextData typedTextData2 = i7 < i2 ? texts.get(i7) : null;
        int mask = ((AppWidgetSize) composer.consume(CompositionLocalsKt.getLocalWidgetSize())).getMask();
        AppWidgetSize.Companion companion = AppWidgetSize.INSTANCE;
        if (AppWidgetSize.m21550equalsimpl0(mask, companion.m21571getTinyrx25Pp4())) {
            TextType.Companion companion2 = TextType.INSTANCE;
            if (TextType.m21684equalsimpl0(textType, companion2.m21691getDisplaygxbDmow()) || TextType.m21684equalsimpl0(textType2, companion2.m21691getDisplaygxbDmow())) {
                i6 = 2;
            }
        } else {
            if (AppWidgetSize.m21550equalsimpl0(mask, companion.m21570getSmallrx25Pp4()) ? true : AppWidgetSize.m21550equalsimpl0(mask, companion.m21573getWideSmallrx25Pp4())) {
                if (z) {
                    TextType.Companion companion3 = TextType.INSTANCE;
                    if (TextType.m21684equalsimpl0(textType, companion3.m21691getDisplaygxbDmow()) || TextType.m21684equalsimpl0(textType2, companion3.m21691getDisplaygxbDmow())) {
                    }
                }
            } else if (AppWidgetSize.m21550equalsimpl0(mask, companion.m21569getMediumrx25Pp4())) {
                if (typedTextData2 != null) {
                    TextType.Companion companion4 = TextType.INSTANCE;
                    if (TextType.m21684equalsimpl0(textType, companion4.m21693getLabelgxbDmow()) && TextType.m21684equalsimpl0(textType2, companion4.m21691getDisplaygxbDmow()) && TextType.m21684equalsimpl0(typedTextData2.getTextType(), companion4.m21693getLabelgxbDmow())) {
                        i6 = 3;
                    } else if (TextType.m21684equalsimpl0(textType, companion4.m21691getDisplaygxbDmow()) && TextType.m21684equalsimpl0(textType2, companion4.m21693getLabelgxbDmow())) {
                    }
                } else {
                    TextType.Companion companion5 = TextType.INSTANCE;
                    if ((TextType.m21684equalsimpl0(textType, companion5.m21691getDisplaygxbDmow()) && TextType.m21684equalsimpl0(textType2, companion5.m21693getLabelgxbDmow())) || (TextType.m21684equalsimpl0(textType, companion5.m21693getLabelgxbDmow()) && TextType.m21684equalsimpl0(textType2, companion5.m21691getDisplaygxbDmow()))) {
                    }
                }
            } else if (z) {
                if (typedTextData2 != null) {
                    TextType.Companion companion6 = TextType.INSTANCE;
                    if (!TextType.m21684equalsimpl0(textType, companion6.m21693getLabelgxbDmow()) || !TextType.m21684equalsimpl0(textType2, companion6.m21691getDisplaygxbDmow()) || !TextType.m21684equalsimpl0(typedTextData2.getTextType(), companion6.m21693getLabelgxbDmow())) {
                        if (TextType.m21684equalsimpl0(textType, companion6.m21691getDisplaygxbDmow()) && TextType.m21684equalsimpl0(textType2, companion6.m21693getLabelgxbDmow())) {
                        }
                    }
                } else {
                    TextType.Companion companion7 = TextType.INSTANCE;
                    if ((TextType.m21684equalsimpl0(textType, companion7.m21691getDisplaygxbDmow()) && TextType.m21684equalsimpl0(textType2, companion7.m21693getLabelgxbDmow())) || (TextType.m21684equalsimpl0(textType, companion7.m21693getLabelgxbDmow()) && TextType.m21684equalsimpl0(textType2, companion7.m21691getDisplaygxbDmow()))) {
                    }
                }
            } else if (typedTextData2 != null) {
                TextType.Companion companion8 = TextType.INSTANCE;
                if (TextType.m21684equalsimpl0(textType, companion8.m21693getLabelgxbDmow()) && TextType.m21684equalsimpl0(textType2, companion8.m21691getDisplaygxbDmow()) && TextType.m21684equalsimpl0(typedTextData2.getTextType(), companion8.m21689getBodygxbDmow())) {
                }
            }
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        composer.endReplaceableGroup();
        return i6;
    }

    /* JADX WARN: Removed duplicated region for block: B:24:0x00f8  */
    /* JADX WARN: Removed duplicated region for block: B:27:0x010c  */
    @Composable
    @SuppressLint({WarningType.NewApi})
    @NotNull
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final DpRect itemPadding(@NotNull TextBlockItem item, @Nullable Composer composer, int i) {
        float f;
        float fM20968constructorimpl;
        DpRect dpRect;
        DpRect dpRect2;
        Context context;
        Intrinsics.checkNotNullParameter(item, "item");
        composer.startReplaceableGroup(252965896);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(252965896, i, -1, "androidx.glance.oneui.template.layout.TextBlockLayoutDimensions.itemPadding (LayoutDimensions.kt:408)");
        }
        int mask = ((AppWidgetSize) composer.consume(CompositionLocalsKt.getLocalWidgetSize())).getMask();
        AppWidgetSize.Companion companion = AppWidgetSize.INSTANCE;
        if (AppWidgetSize.m21550equalsimpl0(mask, companion.m21571getTinyrx25Pp4())) {
            float f4 = 0;
            dpRect2 = new DpRect(C2256Dp.m20968constructorimpl(f4), C2256Dp.m20968constructorimpl(f4), C2256Dp.m20968constructorimpl(f4), C2256Dp.m20968constructorimpl(f4), null);
        } else {
            List<TypedTextData> items = item.getTextList().getItems();
            float f5 = 0;
            float fM20968constructorimpl2 = C2256Dp.m20968constructorimpl(f5);
            float fM20968constructorimpl3 = C2256Dp.m20968constructorimpl(f5);
            composer.startReplaceableGroup(1128454857);
            if (item.getMode() == 0) {
                f = fM20968constructorimpl2;
                fM20968constructorimpl = fM20968constructorimpl3;
                composer.endReplaceableGroup();
                if (AppWidgetSize.m21546compareToL2j3NV4(mask, companion.m21569getMediumrx25Pp4()) < 0) {
                    dpRect = new DpRect(f, C2256Dp.m20968constructorimpl(f5), fM20968constructorimpl, C2256Dp.m20968constructorimpl(f5), null);
                } else {
                    int contentAlign = item.getContentAlign();
                    Alignment.Vertical.Companion companion2 = Alignment.Vertical.INSTANCE;
                    if (Alignment.Vertical.m21448equalsimpl0(contentAlign, companion2.m21454getTopmnfRV0w())) {
                        dpRect = new DpRect(f, TextType.m21684equalsimpl0(items.get(0).getTextType(), TextType.INSTANCE.m21691getDisplaygxbDmow()) ? C2256Dp.m20968constructorimpl(6) : C2256Dp.m20968constructorimpl(14), fM20968constructorimpl, C2256Dp.m20968constructorimpl(f5), null);
                    } else {
                        if (Alignment.Vertical.m21448equalsimpl0(contentAlign, companion2.m21452getBottommnfRV0w())) {
                            float fM20968constructorimpl4 = C2256Dp.m20968constructorimpl(f5);
                            float fM20968constructorimpl5 = ((item.getTextList().getOrientation() == Orientation.Horizontal && TextType.m21684equalsimpl0(items.get(0).getTextType(), TextType.INSTANCE.m21691getDisplaygxbDmow())) || TextType.m21684equalsimpl0(items.get(visibleTextCount(items.size(), false, composer, ((i << 3) & 896) | 48) - 1).getTextType(), TextType.INSTANCE.m21691getDisplaygxbDmow())) ? C2256Dp.m20968constructorimpl(6) : C2256Dp.m20968constructorimpl(14);
                            dpRect = new DpRect(f, fM20968constructorimpl4, fM20968constructorimpl, fM20968constructorimpl5, null);
                        } else {
                            dpRect = new DpRect(f, C2256Dp.m20968constructorimpl(f5), fM20968constructorimpl, C2256Dp.m20968constructorimpl(f5), null);
                        }
                        dpRect2 = dpRect;
                    }
                }
                dpRect2 = dpRect;
            } else if (AppWidgetSize.m21546compareToL2j3NV4(mask, companion.m21569getMediumrx25Pp4()) < 0) {
                if (item.getMode() == 1) {
                    fM20968constructorimpl2 = C2256Dp.m20968constructorimpl(8);
                    fM20968constructorimpl3 = C2256Dp.m20968constructorimpl(4);
                } else {
                    fM20968constructorimpl2 = C2256Dp.m20968constructorimpl(4);
                    fM20968constructorimpl3 = C2256Dp.m20968constructorimpl(8);
                }
                f = fM20968constructorimpl2;
                fM20968constructorimpl = fM20968constructorimpl3;
                composer.endReplaceableGroup();
                if (AppWidgetSize.m21546compareToL2j3NV4(mask, companion.m21569getMediumrx25Pp4()) < 0) {
                }
                dpRect2 = dpRect;
            } else {
                if (Intrinsics.areEqual(composer.consume(CompositionLocalsKt.getLocalCompositor()), TemplateCompositor.INSTANCE.getGlance())) {
                    composer.startReplaceableGroup(1128455405);
                    context = (Context) composer.consume(androidx.glance.CompositionLocalsKt.getLocalContext());
                    composer.endReplaceableGroup();
                } else {
                    composer.startReplaceableGroup(1128455484);
                    context = (Context) composer.consume(AndroidCompositionLocals_androidKt.getLocalContext());
                    composer.endReplaceableGroup();
                }
                float f6 = context.getResources().getFloat(C3094R.dimen.sesl_glance_textblock_item_padding_dual_large_size);
                float fM20968constructorimpl6 = C2256Dp.m20968constructorimpl(f6);
                fM20968constructorimpl = C2256Dp.m20968constructorimpl(f6);
                f = fM20968constructorimpl6;
                composer.endReplaceableGroup();
                if (AppWidgetSize.m21546compareToL2j3NV4(mask, companion.m21569getMediumrx25Pp4()) < 0) {
                }
                dpRect2 = dpRect;
            }
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        composer.endReplaceableGroup();
        return dpRect2;
    }

    @Composable
    @NotNull
    public final DpRect textPadding(@NotNull List<? extends TypedTextData> texts, int i, int i2, boolean z, @Nullable Orientation orientation, @Nullable Composer composer, int i4, int i5) {
        Intrinsics.checkNotNullParameter(texts, "texts");
        composer.startReplaceableGroup(-463625533);
        Orientation orientation2 = (i5 & 16) != 0 ? Orientation.Vertical : orientation;
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-463625533, i4, -1, "androidx.glance.oneui.template.layout.TextBlockLayoutDimensions.textPadding (LayoutDimensions.kt:488)");
        }
        int i6 = i4 << 6;
        DpRect dpRectM21787textPadding58yVOK4 = m21787textPadding58yVOK4(z, texts.get(i).getTextType(), i < i2 ? TextType.m21680boximpl(texts.get(i + 1).getTextType()) : null, i > 0 ? TextType.m21680boximpl(texts.get(i - 1).getTextType()) : null, i > 1 ? TextType.m21680boximpl(texts.get(i - 2).getTextType()) : null, texts.get(i).getTextAlign(), orientation2, composer, ((i4 >> 9) & 14) | (3670016 & i6) | (i6 & 29360128), 0);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        composer.endReplaceableGroup();
        return dpRectM21787textPadding58yVOK4;
    }

    /* JADX WARN: Removed duplicated region for block: B:109:0x0328  */
    /* JADX WARN: Removed duplicated region for block: B:142:0x03e9  */
    /* JADX WARN: Removed duplicated region for block: B:47:0x00f0  */
    /* JADX WARN: Removed duplicated region for block: B:68:0x0180  */
    /* JADX WARN: Removed duplicated region for block: B:79:0x01f6  */
    @Composable
    @NotNull
    /* JADX INFO: renamed from: textPadding-58yVOK4, reason: not valid java name */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final DpRect m21787textPadding58yVOK4(boolean z, int i, @Nullable TextType textType, @Nullable TextType textType2, @Nullable TextType textType3, int i2, @Nullable Orientation orientation, @Nullable Composer composer, int i4, int i5) {
        DpRect dpRect;
        composer.startReplaceableGroup(-244975917);
        TextType textType4 = (i5 & 4) != 0 ? null : textType;
        TextType textType5 = (i5 & 8) != 0 ? null : textType2;
        TextType textType6 = (i5 & 16) == 0 ? textType3 : null;
        int iM22011getStartROrN78o = (i5 & 32) != 0 ? TextAlign.INSTANCE.m22011getStartROrN78o() : i2;
        Orientation orientation2 = (i5 & 64) != 0 ? Orientation.Vertical : orientation;
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-244975917, i4, -1, "androidx.glance.oneui.template.layout.TextBlockLayoutDimensions.textPadding (LayoutDimensions.kt:509)");
        }
        int mask = ((AppWidgetSize) composer.consume(CompositionLocalsKt.getLocalWidgetSize())).getMask();
        AppWidgetSize.Companion companion = AppWidgetSize.INSTANCE;
        if (AppWidgetSize.m21550equalsimpl0(mask, companion.m21571getTinyrx25Pp4())) {
            float f = 5;
            float f4 = 0;
            dpRect = new DpRect(C2256Dp.m20968constructorimpl(f), C2256Dp.m20968constructorimpl(f4), C2256Dp.m20968constructorimpl(f), C2256Dp.m20968constructorimpl(f4), null);
        } else {
            if (AppWidgetSize.m21550equalsimpl0(mask, companion.m21570getSmallrx25Pp4()) ? true : AppWidgetSize.m21550equalsimpl0(mask, companion.m21573getWideSmallrx25Pp4())) {
                if (orientation2 != Orientation.Vertical && z) {
                    TextType.Companion companion2 = TextType.INSTANCE;
                    if (TextType.m21684equalsimpl0(i, companion2.m21691getDisplaygxbDmow())) {
                        if ((textType4 == null ? false : TextType.m21684equalsimpl0(textType4.getValue(), companion2.m21690getDescriptiongxbDmow())) && textType5 == null) {
                            float f5 = 0;
                            dpRect = new DpRect(C2256Dp.m20968constructorimpl(7), C2256Dp.m20968constructorimpl(f5), C2256Dp.m20968constructorimpl(6), C2256Dp.m20968constructorimpl(f5), null);
                        } else {
                            if ((textType5 == null ? false : TextType.m21684equalsimpl0(textType5.getValue(), companion2.m21691getDisplaygxbDmow())) && TextType.m21684equalsimpl0(i, companion2.m21690getDescriptiongxbDmow()) && textType4 == null) {
                                float f6 = 0;
                                dpRect = new DpRect(C2256Dp.m20968constructorimpl(f6), C2256Dp.m20968constructorimpl(f6), C2256Dp.m20968constructorimpl(12), C2256Dp.m20968constructorimpl(f6), null);
                            } else if (TextType.m21684equalsimpl0(i, companion2.m21691getDisplaygxbDmow())) {
                                if (textType4 == null ? false : TextType.m21684equalsimpl0(textType4.getValue(), companion2.m21693getLabelgxbDmow())) {
                                    float f7 = 0;
                                    dpRect = new DpRect(textType5 == null ? C2256Dp.m20968constructorimpl(16) : C2256Dp.m20968constructorimpl(4), C2256Dp.m20968constructorimpl(f7), C2256Dp.m20968constructorimpl(f7), C2256Dp.m20968constructorimpl(f7), null);
                                } else if (TextType.m21684equalsimpl0(i, companion2.m21693getLabelgxbDmow())) {
                                    if (!(textType5 == null ? false : TextType.m21684equalsimpl0(textType5.getValue(), companion2.m21691getDisplaygxbDmow()))) {
                                        float f8 = 0;
                                        dpRect = new DpRect(C2256Dp.m20968constructorimpl(f8), C2256Dp.m20968constructorimpl(f8), C2256Dp.m20968constructorimpl(f8), C2256Dp.m20968constructorimpl(f8), null);
                                    } else if (TextAlign.m22003equalsimpl0(iM22011getStartROrN78o, TextAlign.INSTANCE.m22008getEndROrN78o())) {
                                        float f9 = 0;
                                        dpRect = new DpRect(C2256Dp.m20968constructorimpl(6), C2256Dp.m20968constructorimpl(f9), C2256Dp.m20968constructorimpl(16), C2256Dp.m20968constructorimpl(f9), null);
                                    } else {
                                        float f10 = 0;
                                        dpRect = new DpRect(C2256Dp.m20968constructorimpl(2), C2256Dp.m20968constructorimpl(f10), C2256Dp.m20968constructorimpl(f10), C2256Dp.m20968constructorimpl(f10), null);
                                    }
                                }
                            }
                        }
                    }
                } else if (z) {
                    float f11 = 16;
                    float f12 = 0;
                    dpRect = new DpRect(C2256Dp.m20968constructorimpl(f11), C2256Dp.m20968constructorimpl(f12), C2256Dp.m20968constructorimpl(f11), C2256Dp.m20968constructorimpl(f12), null);
                } else {
                    float f13 = 0;
                    dpRect = new DpRect(C2256Dp.m20968constructorimpl(f13), C2256Dp.m20968constructorimpl(f13), C2256Dp.m20968constructorimpl(f13), C2256Dp.m20968constructorimpl(f13), null);
                }
            } else if (orientation2 != Orientation.Vertical) {
                TextType.Companion companion3 = TextType.INSTANCE;
                if (TextType.m21684equalsimpl0(i, companion3.m21691getDisplaygxbDmow())) {
                    if (textType4 == null ? false : TextType.m21684equalsimpl0(textType4.getValue(), companion3.m21693getLabelgxbDmow())) {
                        float f14 = 0;
                        dpRect = new DpRect(textType5 == null ? (z && TextAlign.m22003equalsimpl0(iM22011getStartROrN78o, TextAlign.INSTANCE.m22011getStartROrN78o())) ? C2256Dp.m20968constructorimpl(15) : C2256Dp.m20968constructorimpl(0) : C2256Dp.m20968constructorimpl(6), C2256Dp.m20968constructorimpl(f14), C2256Dp.m20968constructorimpl(f14), C2256Dp.m20968constructorimpl(f14), null);
                    } else {
                        if ((textType5 == null ? false : TextType.m21684equalsimpl0(textType5.getValue(), companion3.m21691getDisplaygxbDmow())) && TextType.m21684equalsimpl0(i, companion3.m21693getLabelgxbDmow())) {
                            float f15 = 0;
                            dpRect = new DpRect(C2256Dp.m20968constructorimpl(4), C2256Dp.m20968constructorimpl(f15), textType4 != null ? TextType.m21684equalsimpl0(textType4.getValue(), companion3.m21693getLabelgxbDmow()) : false ? C2256Dp.m20968constructorimpl(16) : (z && TextAlign.m22003equalsimpl0(iM22011getStartROrN78o, TextAlign.INSTANCE.m22008getEndROrN78o())) ? C2256Dp.m20968constructorimpl(16) : C2256Dp.m20968constructorimpl(f15), C2256Dp.m20968constructorimpl(f15), null);
                        } else if (z) {
                            if (textType6 == null ? false : TextType.m21684equalsimpl0(textType6.getValue(), companion3.m21691getDisplaygxbDmow())) {
                                if ((textType5 == null ? false : TextType.m21684equalsimpl0(textType5.getValue(), companion3.m21693getLabelgxbDmow())) && TextType.m21684equalsimpl0(i, companion3.m21693getLabelgxbDmow())) {
                                    float f16 = 0;
                                    dpRect = new DpRect(C2256Dp.m20968constructorimpl(4), C2256Dp.m20968constructorimpl(f16), C2256Dp.m20968constructorimpl(16), C2256Dp.m20968constructorimpl(f16), null);
                                } else if (z && textType5 == null) {
                                    float f17 = TextType.m21684equalsimpl0(i, companion3.m21691getDisplaygxbDmow()) ? 15 : 16;
                                    float f18 = 0;
                                    dpRect = new DpRect(C2256Dp.m20968constructorimpl(f17), C2256Dp.m20968constructorimpl(f18), C2256Dp.m20968constructorimpl(f18), C2256Dp.m20968constructorimpl(f18), null);
                                } else if (z && textType4 == null) {
                                    float f19 = 0;
                                    dpRect = new DpRect(C2256Dp.m20968constructorimpl(f19), C2256Dp.m20968constructorimpl(f19), C2256Dp.m20968constructorimpl(TextType.m21684equalsimpl0(i, companion3.m21691getDisplaygxbDmow()) ? 15 : 16), C2256Dp.m20968constructorimpl(f19), null);
                                } else {
                                    float f20 = 0;
                                    dpRect = new DpRect(C2256Dp.m20968constructorimpl(f20), C2256Dp.m20968constructorimpl(f20), C2256Dp.m20968constructorimpl(f20), C2256Dp.m20968constructorimpl(f20), null);
                                }
                            }
                        }
                    }
                }
            } else if (z) {
                float fM20968constructorimpl = C2256Dp.m20968constructorimpl(TextType.m21684equalsimpl0(i, TextType.INSTANCE.m21691getDisplaygxbDmow()) ? 15 : 16);
                float f21 = 0;
                dpRect = new DpRect(fM20968constructorimpl, C2256Dp.m20968constructorimpl(f21), fM20968constructorimpl, C2256Dp.m20968constructorimpl(f21), null);
            } else {
                float f22 = 0;
                dpRect = new DpRect(C2256Dp.m20968constructorimpl(f22), C2256Dp.m20968constructorimpl(f22), C2256Dp.m20968constructorimpl(f22), C2256Dp.m20968constructorimpl(f22), null);
            }
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        composer.endReplaceableGroup();
        return dpRect;
    }

    /* JADX WARN: Removed duplicated region for block: B:16:0x0048  */
    @Composable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final int visibleTextCount(int i, boolean z, @Nullable Composer composer, int i2) {
        composer.startReplaceableGroup(-859611649);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-859611649, i2, -1, "androidx.glance.oneui.template.layout.TextBlockLayoutDimensions.visibleTextCount (LayoutDimensions.kt:393)");
        }
        int mask = ((AppWidgetSize) composer.consume(CompositionLocalsKt.getLocalWidgetSize())).getMask();
        AppWidgetSize.Companion companion = AppWidgetSize.INSTANCE;
        int i4 = 2;
        if (!AppWidgetSize.m21550equalsimpl0(mask, companion.m21571getTinyrx25Pp4())) {
            if (AppWidgetSize.m21550equalsimpl0(mask, companion.m21570getSmallrx25Pp4()) ? true : AppWidgetSize.m21550equalsimpl0(mask, companion.m21573getWideSmallrx25Pp4())) {
                if (!z) {
                    i4 = 3;
                }
            } else if (!AppWidgetSize.m21550equalsimpl0(mask, companion.m21569getMediumrx25Pp4())) {
                i4 = 4;
            } else if (z) {
            }
        }
        int iMin = Math.min(i4, i);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        composer.endReplaceableGroup();
        return iMin;
    }
}
