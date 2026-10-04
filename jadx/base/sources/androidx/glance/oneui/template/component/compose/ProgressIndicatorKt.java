package androidx.glance.oneui.template.component.compose;

import android.content.Context;
import android.content.res.ColorStateList;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;
import androidx.annotation.FloatRange;
import androidx.compose.foundation.BackgroundKt;
import androidx.compose.foundation.layout.AbstractC1038a;
import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.foundation.layout.BoxKt;
import androidx.compose.foundation.layout.BoxScopeInstance;
import androidx.compose.foundation.layout.ColumnKt;
import androidx.compose.foundation.layout.ColumnScope;
import androidx.compose.foundation.layout.ColumnScopeInstance;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.RowScope;
import androidx.compose.foundation.layout.RowScopeInstance;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.layout.SpacerKt;
import androidx.compose.p109ui.Alignment;
import androidx.compose.p109ui.Modifier;
import androidx.compose.p109ui.draw.ClipKt;
import androidx.compose.p109ui.graphics.Color;
import androidx.compose.p109ui.graphics.ColorKt;
import androidx.compose.p109ui.layout.LayoutKt;
import androidx.compose.p109ui.layout.MeasurePolicy;
import androidx.compose.p109ui.node.ComposeUiNode;
import androidx.compose.p109ui.platform.AndroidCompositionLocals_androidKt;
import androidx.compose.p109ui.platform.ViewConfiguration;
import androidx.compose.p109ui.res.PrimitiveResources_androidKt;
import androidx.compose.p109ui.unit.C2256Dp;
import androidx.compose.p109ui.unit.Density;
import androidx.compose.p109ui.unit.DpKt;
import androidx.compose.p109ui.unit.DpSize;
import androidx.compose.p109ui.unit.LayoutDirection;
import androidx.compose.p109ui.viewinterop.AndroidView_androidKt;
import androidx.compose.runtime.Composable;
import androidx.compose.runtime.ComposableTarget;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocalKt;
import androidx.compose.runtime.ProvidedValue;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.SkippableUpdater;
import androidx.compose.runtime.Updater;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.glance.AbstractC2821a;
import androidx.glance.GlanceTheme;
import androidx.glance.appwidget.C2902R;
import androidx.glance.appwidget.ContentScale;
import androidx.glance.appwidget.percent.PercentSizeUtils;
import androidx.glance.color.ColorProviders;
import androidx.glance.oneui.common.AppWidgetSize;
import androidx.glance.oneui.common.AppWidgetStyle;
import androidx.glance.oneui.template.ArcProgressData;
import androidx.glance.oneui.template.C3094R;
import androidx.glance.oneui.template.CircularProgressData;
import androidx.glance.oneui.template.CompositionLocalsKt;
import androidx.glance.oneui.template.CustomArcProgressData;
import androidx.glance.oneui.template.CustomLinearProgressData;
import androidx.glance.oneui.template.ImageData;
import androidx.glance.oneui.template.ImageType;
import androidx.glance.oneui.template.LinearProgressData;
import androidx.glance.oneui.template.ProgressType;
import androidx.glance.oneui.template.TextData;
import androidx.glance.oneui.template.TextType;
import androidx.glance.oneui.template.color.ColorProvidersKt;
import androidx.glance.oneui.template.layout.CommonDimensions;
import androidx.glance.oneui.template.layout.TextSize;
import androidx.glance.oneui.template.layout.compose.LinearGraphLayoutKt;
import androidx.glance.oneui.template.size.GraphTemplatePercent;
import androidx.glance.oneui.template.utils.ComposeModifierUtilsKt;
import androidx.glance.oneui.template.utils.ComposeUtilsKt;
import androidx.glance.oneui.template.utils.ResourceUtilsKt;
import androidx.glance.oneui.template.utils.SmoothRoundedCornerShape;
import androidx.glance.text.ComplexUnit;
import androidx.glance.text.FontWeight;
import androidx.glance.text.TextPercentData;
import androidx.glance.unit.ColorProvider;
import com.samsung.android.support.senl.p148nt.base.common.constants.Constants;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.jvm.internal.SourceDebugExtension;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(m13885d1 = {"\u0000^\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\u001a3\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\tH\u0003¢\u0006\u0002\u0010\n\u001a5\u0010\u000b\u001a\u00020\u00012\b\b\u0002\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\tH\u0001¢\u0006\u0002\u0010\n\u001a\u001f\u0010\f\u001a\u00020\u00012\b\b\u0002\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\rH\u0001¢\u0006\u0002\u0010\u000e\u001a\"\u0010\f\u001a\u00020\u00012\u0006\u0010\u0004\u001a\u00020\r2\u0006\u0010\u000f\u001a\u00020\u0010H\u0001ø\u0001\u0000¢\u0006\u0004\b\u0011\u0010\u0012\u001a\u001f\u0010\f\u001a\u00020\u00012\u0006\u0010\u0004\u001a\u00020\r2\b\b\u0002\u0010\u0013\u001a\u00020\u0007H\u0001¢\u0006\u0002\u0010\u0014\u001a\u001d\u0010\u0015\u001a\u00020\u00012\u0006\u0010\u0004\u001a\u00020\r2\u0006\u0010\u0002\u001a\u00020\u0003H\u0003¢\u0006\u0002\u0010\u0016\u001aH\u0010\u0017\u001a\u00020\u00012\b\b\u0001\u0010\u0018\u001a\u00020\u00192\b\b\u0002\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u001b2\u0006\u0010\u001d\u001a\u00020\u001e2\b\b\u0002\u0010\u001f\u001a\u00020 H\u0001ø\u0001\u0000¢\u0006\u0004\b!\u0010\"\u001a\u0016\u0010#\u001a\u00020$*\u00020\u001bH\u0002ø\u0001\u0000¢\u0006\u0004\b%\u0010&\u001a.\u0010'\u001a\u00020\u0001*\u00020(2\u0006\u0010)\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u001bH\u0002ø\u0001\u0000¢\u0006\u0004\b*\u0010+\u0082\u0002\u0007\n\u0005\b¡\u001e0\u0001¨\u0006,"}, m13886d2 = {"CircularProgressIndicator", "", "modifier", "Landroidx/compose/ui/Modifier;", "data", "Landroidx/glance/oneui/template/CircularProgressData;", "gridPosition", "", "textData", "Landroidx/glance/oneui/template/TextData;", "(Landroidx/compose/ui/Modifier;Landroidx/glance/oneui/template/CircularProgressData;ILandroidx/glance/oneui/template/TextData;Landroidx/compose/runtime/Composer;II)V", "ComposeCircularProgressIndicator", "ComposeLinearProgressIndicator", "Landroidx/glance/oneui/template/LinearProgressData;", "(Landroidx/compose/ui/Modifier;Landroidx/glance/oneui/template/LinearProgressData;Landroidx/compose/runtime/Composer;II)V", "size", "Landroidx/compose/ui/unit/Dp;", "ComposeLinearProgressIndicator-ziNgDLE", "(Landroidx/glance/oneui/template/LinearProgressData;FLandroidx/compose/runtime/Composer;I)V", "sizeResId", "(Landroidx/glance/oneui/template/LinearProgressData;ILandroidx/compose/runtime/Composer;II)V", "LinearProgressIndicator", "(Landroidx/glance/oneui/template/LinearProgressData;Landroidx/compose/ui/Modifier;Landroidx/compose/runtime/Composer;I)V", "ProgressIndicator", "progress", "", "color", "Landroidx/compose/ui/graphics/Color;", "backgroundColor", "type", "Landroidx/glance/oneui/template/ProgressType;", "contentScale", "Landroidx/glance/appwidget/ContentScale;", "ProgressIndicator-Y0xEhic", "(FLandroidx/compose/ui/Modifier;JJLandroidx/glance/oneui/template/ProgressType;Landroidx/glance/appwidget/ContentScale;Landroidx/compose/runtime/Composer;II)V", "toColorStateList", "Landroid/content/res/ColorStateList;", "toColorStateList-8_81llA", "(J)Landroid/content/res/ColorStateList;", Constants.ARG_UPDATE, "Landroid/widget/ProgressBar;", "value", "update-0YGnOg8", "(Landroid/widget/ProgressBar;FJJ)V", "glance-oneui-template_release"}, m13887k = 2, m13888mv = {1, 9, 0}, m13890xi = 48)
@SourceDebugExtension({"SMAP\nProgressIndicator.kt\nKotlin\n*S Kotlin\n*F\n+ 1 ProgressIndicator.kt\nandroidx/glance/oneui/template/component/compose/ProgressIndicatorKt\n+ 2 CompositionLocal.kt\nandroidx/compose/runtime/CompositionLocal\n+ 3 Dp.kt\nandroidx/compose/ui/unit/DpKt\n+ 4 Box.kt\nandroidx/compose/foundation/layout/BoxKt\n+ 5 Layout.kt\nandroidx/compose/ui/layout/LayoutKt\n+ 6 Composables.kt\nandroidx/compose/runtime/ComposablesKt\n+ 7 Row.kt\nandroidx/compose/foundation/layout/RowKt\n+ 8 fake.kt\nkotlin/jvm/internal/FakeKt\n+ 9 Column.kt\nandroidx/compose/foundation/layout/ColumnKt\n+ 10 Dp.kt\nandroidx/compose/ui/unit/Dp\n+ 11 Composer.kt\nandroidx/compose/runtime/ComposerKt\n*L\n1#1,517:1\n74#2:518\n76#2:528\n74#2:554\n76#2:562\n76#2:595\n76#2:641\n74#2:667\n74#2:668\n74#2:670\n74#2:684\n74#2:685\n76#2:692\n76#2:724\n76#2:757\n76#2:789\n76#2:843\n76#2:872\n76#2:904\n76#2:937\n76#2:969\n74#2:1035\n76#2:1042\n76#2:1080\n74#2:1111\n74#2:1112\n76#2:1119\n76#2:1157\n74#2:1184\n76#2:1196\n74#2:1222\n74#2:1223\n154#3:519\n154#3:520\n154#3:555\n154#3:631\n154#3:632\n154#3:633\n154#3:669\n154#3:672\n154#3:673\n174#3:1011\n174#3:1012\n154#3:1183\n67#4,6:521\n73#4:553\n68#4,5:556\n73#4:587\n67#4,6:588\n73#4:620\n77#4:625\n77#4:630\n77#4:683\n68#4,5:686\n73#4:717\n68#4,5:718\n73#4:749\n68#4,5:783\n73#4:814\n77#4:820\n77#4:830\n77#4:835\n67#4,6:836\n73#4:868\n68#4,5:898\n73#4:929\n68#4,5:963\n73#4:994\n77#4:1000\n77#4:1010\n77#4:1022\n68#4,5:1036\n73#4:1067\n77#4:1072\n67#4,6:1073\n73#4:1105\n77#4:1110\n68#4,5:1113\n73#4:1144\n77#4:1150\n68#4,5:1151\n73#4:1182\n77#4:1189\n75#5:527\n76#5,11:529\n75#5:561\n76#5,11:563\n75#5:594\n76#5,11:596\n89#5:624\n89#5:629\n75#5:640\n76#5,11:642\n89#5:677\n89#5:682\n75#5:691\n76#5,11:693\n75#5:723\n76#5,11:725\n75#5:756\n76#5,11:758\n75#5:788\n76#5,11:790\n89#5:819\n89#5:824\n89#5:829\n89#5:834\n75#5:842\n76#5,11:844\n75#5:871\n76#5,11:873\n75#5:903\n76#5,11:905\n75#5:936\n76#5,11:938\n75#5:968\n76#5,11:970\n89#5:999\n89#5:1004\n89#5:1009\n89#5:1016\n89#5:1021\n75#5:1041\n76#5,11:1043\n89#5:1071\n75#5:1079\n76#5,11:1081\n89#5:1109\n75#5:1118\n76#5,11:1120\n89#5:1149\n75#5:1156\n76#5,11:1158\n89#5:1188\n75#5:1195\n76#5,11:1197\n89#5:1228\n460#6,13:540\n460#6,13:574\n460#6,13:607\n473#6,3:621\n473#6,3:626\n460#6,13:653\n473#6,3:674\n473#6,3:679\n460#6,13:704\n460#6,13:736\n460#6,13:769\n460#6,13:801\n473#6,3:816\n473#6,3:821\n473#6,3:826\n473#6,3:831\n460#6,13:855\n460#6,13:884\n460#6,13:916\n460#6,13:949\n460#6,13:981\n473#6,3:996\n473#6,3:1001\n473#6,3:1006\n473#6,3:1013\n473#6,3:1018\n460#6,13:1054\n473#6,3:1068\n460#6,13:1092\n473#6,3:1106\n460#6,13:1131\n473#6,3:1146\n460#6,13:1169\n473#6,3:1185\n460#6,13:1208\n473#6,3:1225\n75#7,6:634\n81#7:666\n85#7:678\n1#8:671\n74#9,6:750\n80#9:782\n84#9:825\n78#9,2:869\n80#9:897\n74#9,6:930\n80#9:962\n84#9:1005\n84#9:1017\n75#9,5:1190\n80#9:1221\n84#9:1229\n75#10:815\n75#10:995\n81#10:1145\n88#10:1224\n1116#11,6:1023\n1116#11,6:1029\n*S KotlinDebug\n*F\n+ 1 ProgressIndicator.kt\nandroidx/glance/oneui/template/component/compose/ProgressIndicatorKt\n*L\n82#1:518\n98#1:528\n99#1:554\n101#1:562\n105#1:595\n147#1:641\n164#1:667\n171#1:668\n176#1:670\n223#1:684\n224#1:685\n344#1:692\n353#1:724\n355#1:757\n358#1:789\n378#1:843\n379#1:872\n384#1:904\n386#1:937\n389#1:969\n232#1:1035\n256#1:1042\n270#1:1080\n281#1:1111\n282#1:1112\n283#1:1119\n295#1:1157\n301#1:1184\n314#1:1196\n318#1:1222\n319#1:1223\n82#1:519\n89#1:520\n102#1:555\n153#1:631\n155#1:632\n157#1:633\n172#1:669\n178#1:672\n187#1:673\n406#1:1011\n412#1:1012\n297#1:1183\n98#1:521,6\n98#1:553\n101#1:556,5\n101#1:587\n105#1:588,6\n105#1:620\n105#1:625\n101#1:630\n98#1:683\n344#1:686,5\n344#1:717\n353#1:718,5\n353#1:749\n358#1:783,5\n358#1:814\n358#1:820\n353#1:830\n344#1:835\n378#1:836,6\n378#1:868\n384#1:898,5\n384#1:929\n389#1:963,5\n389#1:994\n389#1:1000\n384#1:1010\n378#1:1022\n256#1:1036,5\n256#1:1067\n256#1:1072\n270#1:1073,6\n270#1:1105\n270#1:1110\n283#1:1113,5\n283#1:1144\n283#1:1150\n295#1:1151,5\n295#1:1182\n295#1:1189\n98#1:527\n98#1:529,11\n101#1:561\n101#1:563,11\n105#1:594\n105#1:596,11\n105#1:624\n101#1:629\n147#1:640\n147#1:642,11\n147#1:677\n98#1:682\n344#1:691\n344#1:693,11\n353#1:723\n353#1:725,11\n355#1:756\n355#1:758,11\n358#1:788\n358#1:790,11\n358#1:819\n355#1:824\n353#1:829\n344#1:834\n378#1:842\n378#1:844,11\n379#1:871\n379#1:873,11\n384#1:903\n384#1:905,11\n386#1:936\n386#1:938,11\n389#1:968\n389#1:970,11\n389#1:999\n386#1:1004\n384#1:1009\n379#1:1016\n378#1:1021\n256#1:1041\n256#1:1043,11\n256#1:1071\n270#1:1079\n270#1:1081,11\n270#1:1109\n283#1:1118\n283#1:1120,11\n283#1:1149\n295#1:1156\n295#1:1158,11\n295#1:1188\n314#1:1195\n314#1:1197,11\n314#1:1228\n98#1:540,13\n101#1:574,13\n105#1:607,13\n105#1:621,3\n101#1:626,3\n147#1:653,13\n147#1:674,3\n98#1:679,3\n344#1:704,13\n353#1:736,13\n355#1:769,13\n358#1:801,13\n358#1:816,3\n355#1:821,3\n353#1:826,3\n344#1:831,3\n378#1:855,13\n379#1:884,13\n384#1:916,13\n386#1:949,13\n389#1:981,13\n389#1:996,3\n386#1:1001,3\n384#1:1006,3\n379#1:1013,3\n378#1:1018,3\n256#1:1054,13\n256#1:1068,3\n270#1:1092,13\n270#1:1106,3\n283#1:1131,13\n283#1:1146,3\n295#1:1169,13\n295#1:1185,3\n314#1:1208,13\n314#1:1225,3\n147#1:634,6\n147#1:666\n147#1:678\n355#1:750,6\n355#1:782\n355#1:825\n379#1:869,2\n379#1:897\n386#1:930,6\n386#1:962\n386#1:1005\n379#1:1017\n314#1:1190,5\n314#1:1221\n314#1:1229\n363#1:815\n395#1:995\n286#1:1145\n319#1:1224\n495#1:1023,6\n499#1:1029,6\n*E\n"})
public final class ProgressIndicatorKt {

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13887k = 3, m13888mv = {1, 9, 0}, m13890xi = 48)
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;
        public static final /* synthetic */ int[] $EnumSwitchMapping$1;

        static {
            int[] iArr = new int[ContentScale.values().length];
            try {
                iArr[ContentScale.Small.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[ContentScale.Medium.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            $EnumSwitchMapping$0 = iArr;
            int[] iArr2 = new int[ProgressType.values().length];
            try {
                iArr2[ProgressType.Linear.ordinal()] = 1;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                iArr2[ProgressType.Circular.ordinal()] = 2;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                iArr2[ProgressType.Arc.ordinal()] = 3;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                iArr2[ProgressType.Stacked.ordinal()] = 4;
            } catch (NoSuchFieldError unused6) {
            }
            $EnumSwitchMapping$1 = iArr2;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    @ComposableTarget(applier = "androidx.glance.GlanceComposable")
    @Composable
    public static final void CircularProgressIndicator(final Modifier modifier, final CircularProgressData circularProgressData, int i, TextData textData, Composer composer, final int i2, final int i4) {
        int i5;
        TextData textData2;
        Composer composer2;
        Composer composerStartRestartGroup = composer.startRestartGroup(-1914085864);
        int i6 = (i4 & 4) != 0 ? 0 : i;
        TextData textData3 = (i4 & 8) != 0 ? null : textData;
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-1914085864, i2, -1, "androidx.glance.oneui.template.component.compose.CircularProgressIndicator (ProgressIndicator.kt:221)");
        }
        Context context = (Context) composerStartRestartGroup.consume(AndroidCompositionLocals_androidKt.getLocalContext());
        int mask = ((AppWidgetSize) composerStartRestartGroup.consume(CompositionLocalsKt.getLocalWidgetSize())).getMask();
        Ref.LongRef longRef = new Ref.LongRef();
        Ref.LongRef longRef2 = new Ref.LongRef();
        Pair<Color, Color> pairCircularProgressIndicator$initColor = CircularProgressIndicator$initColor(circularProgressData, composerStartRestartGroup, 0);
        longRef.element = pairCircularProgressIndicator$initColor.getFirst().m18535unboximpl();
        longRef2.element = pairCircularProgressIndicator$initColor.getSecond().m18535unboximpl();
        AppWidgetSize.Companion companion = AppWidgetSize.INSTANCE;
        ContentScale contentScale = AppWidgetSize.m21550equalsimpl0(mask, companion.m21568getLargerx25Pp4()) ? ContentScale.Large : AppWidgetSize.m21550equalsimpl0(mask, companion.m21569getMediumrx25Pp4()) ? ContentScale.Medium : ContentScale.Small;
        if (circularProgressData instanceof ArcProgressData) {
            composerStartRestartGroup.startReplaceableGroup(1953348697);
            if (AppWidgetSize.m21546compareToL2j3NV4(mask, companion.m21568getLargerx25Pp4()) < 0) {
                composerStartRestartGroup.startReplaceableGroup(1953348745);
                Alignment.Companion companion2 = Alignment.INSTANCE;
                Alignment center = companion2.getCenter();
                composerStartRestartGroup.startReplaceableGroup(733328855);
                MeasurePolicy measurePolicyRememberBoxMeasurePolicy = BoxKt.rememberBoxMeasurePolicy(center, false, composerStartRestartGroup, 6);
                Density density = (Density) AbstractC1038a.m1211l(composerStartRestartGroup, -1323940314);
                LayoutDirection layoutDirection = (LayoutDirection) composerStartRestartGroup.consume(androidx.compose.p109ui.platform.CompositionLocalsKt.getLocalLayoutDirection());
                ViewConfiguration viewConfiguration = (ViewConfiguration) composerStartRestartGroup.consume(androidx.compose.p109ui.platform.CompositionLocalsKt.getLocalViewConfiguration());
                ComposeUiNode.Companion companion3 = ComposeUiNode.INSTANCE;
                Function0<ComposeUiNode> constructor = companion3.getConstructor();
                Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> function3MaterializerOf = LayoutKt.materializerOf(modifier);
                if (composerStartRestartGroup.getApplier() == null) {
                    ComposablesKt.invalidApplier();
                }
                composerStartRestartGroup.startReusableNode();
                if (composerStartRestartGroup.getInserting()) {
                    composerStartRestartGroup.createNode(constructor);
                } else {
                    composerStartRestartGroup.useNode();
                }
                composerStartRestartGroup.disableReusing();
                Composer composerM18018constructorimpl = Updater.m18018constructorimpl(composerStartRestartGroup);
                Updater.m18025setimpl(composerM18018constructorimpl, layoutDirection, (Function2<? super T, ? super LayoutDirection, Unit>) AbstractC1038a.m1219t(companion3, composerM18018constructorimpl, measurePolicyRememberBoxMeasurePolicy, composerM18018constructorimpl, density));
                function3MaterializerOf.invoke(AbstractC1038a.m1206g(companion3, composerM18018constructorimpl, viewConfiguration, composerStartRestartGroup, composerStartRestartGroup), composerStartRestartGroup, 0);
                composerStartRestartGroup.startReplaceableGroup(2058660585);
                BoxScopeInstance boxScopeInstance = BoxScopeInstance.INSTANCE;
                Pair<Float, Float> pairM21943getGraphSizeR2GYfMI = GraphTemplatePercent.Graph.INSTANCE.m21943getGraphSizeR2GYfMI(mask, composerStartRestartGroup, 48);
                TextData textData4 = textData3;
                i5 = i6;
                long jM21383getMinDpSizeFromPercentDataM_xkUdw = PercentSizeUtils.INSTANCE.m21383getMinDpSizeFromPercentDataM_xkUdw(pairM21943getGraphSizeR2GYfMI.getFirst().floatValue(), pairM21943getGraphSizeR2GYfMI.getSecond().floatValue(), 0.0f, 0.0f, 0.0f, composerStartRestartGroup, PercentSizeUtils.$stable << 15, 28);
                Modifier.Companion companion4 = Modifier.INSTANCE;
                Modifier modifierM15900size6HolHcs = SizeKt.m15900size6HolHcs(companion4, jM21383getMinDpSizeFromPercentDataM_xkUdw);
                Alignment center2 = companion2.getCenter();
                composerStartRestartGroup.startReplaceableGroup(733328855);
                MeasurePolicy measurePolicyRememberBoxMeasurePolicy2 = BoxKt.rememberBoxMeasurePolicy(center2, false, composerStartRestartGroup, 6);
                Density density2 = (Density) AbstractC1038a.m1211l(composerStartRestartGroup, -1323940314);
                LayoutDirection layoutDirection2 = (LayoutDirection) composerStartRestartGroup.consume(androidx.compose.p109ui.platform.CompositionLocalsKt.getLocalLayoutDirection());
                ViewConfiguration viewConfiguration2 = (ViewConfiguration) composerStartRestartGroup.consume(androidx.compose.p109ui.platform.CompositionLocalsKt.getLocalViewConfiguration());
                Function0<ComposeUiNode> constructor2 = companion3.getConstructor();
                Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> function3MaterializerOf2 = LayoutKt.materializerOf(modifierM15900size6HolHcs);
                if (composerStartRestartGroup.getApplier() == null) {
                    ComposablesKt.invalidApplier();
                }
                composerStartRestartGroup.startReusableNode();
                if (composerStartRestartGroup.getInserting()) {
                    composerStartRestartGroup.createNode(constructor2);
                } else {
                    composerStartRestartGroup.useNode();
                }
                composerStartRestartGroup.disableReusing();
                Composer composerM18018constructorimpl2 = Updater.m18018constructorimpl(composerStartRestartGroup);
                Updater.m18025setimpl(composerM18018constructorimpl2, layoutDirection2, (Function2<? super T, ? super LayoutDirection, Unit>) AbstractC1038a.m1219t(companion3, composerM18018constructorimpl2, measurePolicyRememberBoxMeasurePolicy2, composerM18018constructorimpl2, density2));
                function3MaterializerOf2.invoke(AbstractC1038a.m1206g(companion3, composerM18018constructorimpl2, viewConfiguration2, composerStartRestartGroup, composerStartRestartGroup), composerStartRestartGroup, 0);
                composerStartRestartGroup.startReplaceableGroup(2058660585);
                CircularProgressIndicator$ArcProgress(longRef, longRef2, contentScale, SizeKt.m15900size6HolHcs(companion4, DpSize.m21071timesGh9hcWk(jM21383getMinDpSizeFromPercentDataM_xkUdw, 0.8f)), (ArcProgressData) circularProgressData, composerStartRestartGroup, 64);
                composer2 = composerStartRestartGroup;
                Modifier modifierFillMaxSize$default = SizeKt.fillMaxSize$default(companion4, 0.0f, 1, null);
                composer2.startReplaceableGroup(-483455358);
                MeasurePolicy measurePolicyM1209j = AbstractC1038a.m1209j(companion2, Arrangement.INSTANCE.getTop(), composer2, 0, -1323940314);
                Density density3 = (Density) composer2.consume(androidx.compose.p109ui.platform.CompositionLocalsKt.getLocalDensity());
                LayoutDirection layoutDirection3 = (LayoutDirection) composer2.consume(androidx.compose.p109ui.platform.CompositionLocalsKt.getLocalLayoutDirection());
                ViewConfiguration viewConfiguration3 = (ViewConfiguration) composer2.consume(androidx.compose.p109ui.platform.CompositionLocalsKt.getLocalViewConfiguration());
                Function0<ComposeUiNode> constructor3 = companion3.getConstructor();
                Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> function3MaterializerOf3 = LayoutKt.materializerOf(modifierFillMaxSize$default);
                if (composer2.getApplier() == null) {
                    ComposablesKt.invalidApplier();
                }
                composer2.startReusableNode();
                if (composer2.getInserting()) {
                    composer2.createNode(constructor3);
                } else {
                    composer2.useNode();
                }
                composer2.disableReusing();
                Composer composerM18018constructorimpl3 = Updater.m18018constructorimpl(composer2);
                Updater.m18025setimpl(composerM18018constructorimpl3, layoutDirection3, (Function2<? super T, ? super LayoutDirection, Unit>) AbstractC1038a.m1219t(companion3, composerM18018constructorimpl3, measurePolicyM1209j, composerM18018constructorimpl3, density3));
                function3MaterializerOf3.invoke(AbstractC1038a.m1206g(companion3, composerM18018constructorimpl3, viewConfiguration3, composer2, composer2), composer2, 0);
                composer2.startReplaceableGroup(2058660585);
                ColumnScopeInstance columnScopeInstance = ColumnScopeInstance.INSTANCE;
                SpacerKt.Spacer(ColumnScope.weight$default(columnScopeInstance, SizeKt.fillMaxWidth$default(companion4, 0.0f, 1, null), 1.0f, false, 2, null), composer2, 0);
                CircularProgressIndicator$ArcIcon(ColumnScope.weight$default(columnScopeInstance, SizeKt.fillMaxWidth$default(companion4, 0.0f, 1, null), 1.0f, false, 2, null), circularProgressData.getIcon(), composer2, 64);
                Modifier modifierWeight$default = ColumnScope.weight$default(columnScopeInstance, SizeKt.fillMaxWidth$default(companion4, 0.0f, 1, null), 1.0f, false, 2, null);
                Alignment center3 = companion2.getCenter();
                composer2.startReplaceableGroup(733328855);
                MeasurePolicy measurePolicyRememberBoxMeasurePolicy3 = BoxKt.rememberBoxMeasurePolicy(center3, false, composer2, 6);
                Density density4 = (Density) AbstractC1038a.m1211l(composer2, -1323940314);
                LayoutDirection layoutDirection4 = (LayoutDirection) composer2.consume(androidx.compose.p109ui.platform.CompositionLocalsKt.getLocalLayoutDirection());
                ViewConfiguration viewConfiguration4 = (ViewConfiguration) composer2.consume(androidx.compose.p109ui.platform.CompositionLocalsKt.getLocalViewConfiguration());
                Function0<ComposeUiNode> constructor4 = companion3.getConstructor();
                Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> function3MaterializerOf4 = LayoutKt.materializerOf(modifierWeight$default);
                if (composer2.getApplier() == null) {
                    ComposablesKt.invalidApplier();
                }
                composer2.startReusableNode();
                if (composer2.getInserting()) {
                    composer2.createNode(constructor4);
                } else {
                    composer2.useNode();
                }
                composer2.disableReusing();
                Composer composerM18018constructorimpl4 = Updater.m18018constructorimpl(composer2);
                Updater.m18025setimpl(composerM18018constructorimpl4, layoutDirection4, (Function2<? super T, ? super LayoutDirection, Unit>) AbstractC1038a.m1219t(companion3, composerM18018constructorimpl4, measurePolicyRememberBoxMeasurePolicy3, composerM18018constructorimpl4, density4));
                function3MaterializerOf4.invoke(AbstractC1038a.m1206g(companion3, composerM18018constructorimpl4, viewConfiguration4, composer2, composer2), composer2, 0);
                composer2.startReplaceableGroup(2058660585);
                CompositionLocalKt.CompositionLocalProvider(CompositionLocalsKt.getLocalAreaSize().provides(DpSize.m21054boximpl(DpKt.m20990DpSizeYgX7TsA(DpSize.m21066getWidthD9Ej5fM(jM21383getMinDpSizeFromPercentDataM_xkUdw), C2256Dp.m20968constructorimpl(DpSize.m21064getHeightD9Ej5fM(jM21383getMinDpSizeFromPercentDataM_xkUdw) / 3)))), ComposableLambdaKt.composableLambda(composer2, -1855436902, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.glance.oneui.template.component.compose.ProgressIndicatorKt$CircularProgressIndicator$2$1$1$1$1
                    {
                        super(2);
                    }

                    @Override // kotlin.jvm.functions.Function2
                    public /* bridge */ /* synthetic */ Unit invoke(Composer composer3, Integer num) {
                        invoke(composer3, num.intValue());
                        return Unit.INSTANCE;
                    }

                    @ComposableTarget(applier = "androidx.compose.ui.UiComposable")
                    @Composable
                    public final void invoke(@Nullable Composer composer3, int i7) {
                        if ((i7 & 11) == 2 && composer3.getSkipping()) {
                            composer3.skipToGroupEnd();
                            return;
                        }
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(-1855436902, i7, -1, "androidx.glance.oneui.template.component.compose.CircularProgressIndicator.<anonymous>.<anonymous>.<anonymous>.<anonymous>.<anonymous> (ProgressIndicator.kt:364)");
                        }
                        ProgressIndicatorKt.CircularProgressIndicator$BottomTextArea((ArcProgressData) circularProgressData, composer3, 8);
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                    }
                }), composer2, ProvidedValue.$stable | 48);
                composer2.endReplaceableGroup();
                composer2.endNode();
                composer2.endReplaceableGroup();
                composer2.endReplaceableGroup();
                composer2.endReplaceableGroup();
                composer2.endNode();
                composer2.endReplaceableGroup();
                composer2.endReplaceableGroup();
                composer2.endReplaceableGroup();
                composer2.endNode();
                composer2.endReplaceableGroup();
                composer2.endReplaceableGroup();
                composer2.endReplaceableGroup();
                composer2.endNode();
                composer2.endReplaceableGroup();
                composer2.endReplaceableGroup();
                composer2.endReplaceableGroup();
                textData2 = textData4;
            } else {
                i5 = i6;
                TextData textData5 = textData3;
                composerStartRestartGroup.startReplaceableGroup(1953350165);
                Pair<Float, Float> pairM21943getGraphSizeR2GYfMI2 = GraphTemplatePercent.Graph.INSTANCE.m21943getGraphSizeR2GYfMI(mask, composerStartRestartGroup, 48);
                long jM21383getMinDpSizeFromPercentDataM_xkUdw2 = PercentSizeUtils.INSTANCE.m21383getMinDpSizeFromPercentDataM_xkUdw(pairM21943getGraphSizeR2GYfMI2.getFirst().floatValue(), pairM21943getGraphSizeR2GYfMI2.getSecond().floatValue(), 0.0f, 0.0f, 0.0f, composerStartRestartGroup, PercentSizeUtils.$stable << 15, 28);
                Modifier modifierM21958paddings2pLCVw = ComposeModifierUtilsKt.m21958paddings2pLCVw(modifier, 0.005f, 0.0f, 0.005f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, composerStartRestartGroup, (i2 & 14) | 3120, 250);
                composerStartRestartGroup.startReplaceableGroup(733328855);
                Alignment.Companion companion5 = Alignment.INSTANCE;
                MeasurePolicy measurePolicyM1210k = AbstractC1038a.m1210k(companion5, false, composerStartRestartGroup, 0, -1323940314);
                Density density5 = (Density) composerStartRestartGroup.consume(androidx.compose.p109ui.platform.CompositionLocalsKt.getLocalDensity());
                LayoutDirection layoutDirection5 = (LayoutDirection) composerStartRestartGroup.consume(androidx.compose.p109ui.platform.CompositionLocalsKt.getLocalLayoutDirection());
                ViewConfiguration viewConfiguration5 = (ViewConfiguration) composerStartRestartGroup.consume(androidx.compose.p109ui.platform.CompositionLocalsKt.getLocalViewConfiguration());
                ComposeUiNode.Companion companion6 = ComposeUiNode.INSTANCE;
                Function0<ComposeUiNode> constructor5 = companion6.getConstructor();
                Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> function3MaterializerOf5 = LayoutKt.materializerOf(modifierM21958paddings2pLCVw);
                if (composerStartRestartGroup.getApplier() == null) {
                    ComposablesKt.invalidApplier();
                }
                composerStartRestartGroup.startReusableNode();
                if (composerStartRestartGroup.getInserting()) {
                    composerStartRestartGroup.createNode(constructor5);
                } else {
                    composerStartRestartGroup.useNode();
                }
                composerStartRestartGroup.disableReusing();
                Composer composerM18018constructorimpl5 = Updater.m18018constructorimpl(composerStartRestartGroup);
                Updater.m18025setimpl(composerM18018constructorimpl5, layoutDirection5, (Function2<? super T, ? super LayoutDirection, Unit>) AbstractC1038a.m1219t(companion6, composerM18018constructorimpl5, measurePolicyM1210k, composerM18018constructorimpl5, density5));
                function3MaterializerOf5.invoke(AbstractC1038a.m1206g(companion6, composerM18018constructorimpl5, viewConfiguration5, composerStartRestartGroup, composerStartRestartGroup), composerStartRestartGroup, 0);
                composerStartRestartGroup.startReplaceableGroup(2058660585);
                BoxScopeInstance boxScopeInstance2 = BoxScopeInstance.INSTANCE;
                Modifier.Companion companion7 = Modifier.INSTANCE;
                Modifier modifierFillMaxSize$default2 = SizeKt.fillMaxSize$default(companion7, 0.0f, 1, null);
                Alignment.Horizontal centerHorizontally = companion5.getCenterHorizontally();
                Arrangement arrangement = Arrangement.INSTANCE;
                Arrangement.HorizontalOrVertical center4 = arrangement.getCenter();
                composerStartRestartGroup.startReplaceableGroup(-483455358);
                MeasurePolicy measurePolicyColumnMeasurePolicy = ColumnKt.columnMeasurePolicy(center4, centerHorizontally, composerStartRestartGroup, 54);
                Density density6 = (Density) AbstractC1038a.m1211l(composerStartRestartGroup, -1323940314);
                LayoutDirection layoutDirection6 = (LayoutDirection) composerStartRestartGroup.consume(androidx.compose.p109ui.platform.CompositionLocalsKt.getLocalLayoutDirection());
                ViewConfiguration viewConfiguration6 = (ViewConfiguration) composerStartRestartGroup.consume(androidx.compose.p109ui.platform.CompositionLocalsKt.getLocalViewConfiguration());
                Function0<ComposeUiNode> constructor6 = companion6.getConstructor();
                Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> function3MaterializerOf6 = LayoutKt.materializerOf(modifierFillMaxSize$default2);
                if (composerStartRestartGroup.getApplier() == null) {
                    ComposablesKt.invalidApplier();
                }
                composerStartRestartGroup.startReusableNode();
                if (composerStartRestartGroup.getInserting()) {
                    composerStartRestartGroup.createNode(constructor6);
                } else {
                    composerStartRestartGroup.useNode();
                }
                composerStartRestartGroup.disableReusing();
                Composer composerM18018constructorimpl6 = Updater.m18018constructorimpl(composerStartRestartGroup);
                Updater.m18025setimpl(composerM18018constructorimpl6, layoutDirection6, (Function2<? super T, ? super LayoutDirection, Unit>) AbstractC1038a.m1219t(companion6, composerM18018constructorimpl6, measurePolicyColumnMeasurePolicy, composerM18018constructorimpl6, density6));
                function3MaterializerOf6.invoke(AbstractC1038a.m1206g(companion6, composerM18018constructorimpl6, viewConfiguration6, composerStartRestartGroup, composerStartRestartGroup), composerStartRestartGroup, 0);
                composerStartRestartGroup.startReplaceableGroup(2058660585);
                ColumnScopeInstance columnScopeInstance2 = ColumnScopeInstance.INSTANCE;
                Modifier modifierM15900size6HolHcs2 = SizeKt.m15900size6HolHcs(companion7, jM21383getMinDpSizeFromPercentDataM_xkUdw2);
                Alignment center5 = companion5.getCenter();
                composerStartRestartGroup.startReplaceableGroup(733328855);
                MeasurePolicy measurePolicyRememberBoxMeasurePolicy4 = BoxKt.rememberBoxMeasurePolicy(center5, false, composerStartRestartGroup, 6);
                Density density7 = (Density) AbstractC1038a.m1211l(composerStartRestartGroup, -1323940314);
                LayoutDirection layoutDirection7 = (LayoutDirection) composerStartRestartGroup.consume(androidx.compose.p109ui.platform.CompositionLocalsKt.getLocalLayoutDirection());
                ViewConfiguration viewConfiguration7 = (ViewConfiguration) composerStartRestartGroup.consume(androidx.compose.p109ui.platform.CompositionLocalsKt.getLocalViewConfiguration());
                Function0<ComposeUiNode> constructor7 = companion6.getConstructor();
                Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> function3MaterializerOf7 = LayoutKt.materializerOf(modifierM15900size6HolHcs2);
                if (composerStartRestartGroup.getApplier() == null) {
                    ComposablesKt.invalidApplier();
                }
                composerStartRestartGroup.startReusableNode();
                if (composerStartRestartGroup.getInserting()) {
                    composerStartRestartGroup.createNode(constructor7);
                } else {
                    composerStartRestartGroup.useNode();
                }
                composerStartRestartGroup.disableReusing();
                Composer composerM18018constructorimpl7 = Updater.m18018constructorimpl(composerStartRestartGroup);
                Updater.m18025setimpl(composerM18018constructorimpl7, layoutDirection7, (Function2<? super T, ? super LayoutDirection, Unit>) AbstractC1038a.m1219t(companion6, composerM18018constructorimpl7, measurePolicyRememberBoxMeasurePolicy4, composerM18018constructorimpl7, density7));
                function3MaterializerOf7.invoke(AbstractC1038a.m1206g(companion6, composerM18018constructorimpl7, viewConfiguration7, composerStartRestartGroup, composerStartRestartGroup), composerStartRestartGroup, 0);
                composerStartRestartGroup.startReplaceableGroup(2058660585);
                CircularProgressIndicator$ArcProgress(longRef, longRef2, contentScale, SizeKt.m15900size6HolHcs(companion7, DpSize.m21071timesGh9hcWk(jM21383getMinDpSizeFromPercentDataM_xkUdw2, 0.8f)), (ArcProgressData) circularProgressData, composerStartRestartGroup, 64);
                composer2 = composerStartRestartGroup;
                Modifier modifierFillMaxSize$default3 = SizeKt.fillMaxSize$default(companion7, 0.0f, 1, null);
                composer2.startReplaceableGroup(-483455358);
                MeasurePolicy measurePolicyM1209j2 = AbstractC1038a.m1209j(companion5, arrangement.getTop(), composer2, 0, -1323940314);
                Density density8 = (Density) composer2.consume(androidx.compose.p109ui.platform.CompositionLocalsKt.getLocalDensity());
                LayoutDirection layoutDirection8 = (LayoutDirection) composer2.consume(androidx.compose.p109ui.platform.CompositionLocalsKt.getLocalLayoutDirection());
                ViewConfiguration viewConfiguration8 = (ViewConfiguration) composer2.consume(androidx.compose.p109ui.platform.CompositionLocalsKt.getLocalViewConfiguration());
                Function0<ComposeUiNode> constructor8 = companion6.getConstructor();
                Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> function3MaterializerOf8 = LayoutKt.materializerOf(modifierFillMaxSize$default3);
                if (composer2.getApplier() == null) {
                    ComposablesKt.invalidApplier();
                }
                composer2.startReusableNode();
                if (composer2.getInserting()) {
                    composer2.createNode(constructor8);
                } else {
                    composer2.useNode();
                }
                composer2.disableReusing();
                Composer composerM18018constructorimpl8 = Updater.m18018constructorimpl(composer2);
                Updater.m18025setimpl(composerM18018constructorimpl8, layoutDirection8, (Function2<? super T, ? super LayoutDirection, Unit>) AbstractC1038a.m1219t(companion6, composerM18018constructorimpl8, measurePolicyM1209j2, composerM18018constructorimpl8, density8));
                function3MaterializerOf8.invoke(AbstractC1038a.m1206g(companion6, composerM18018constructorimpl8, viewConfiguration8, composer2, composer2), composer2, 0);
                composer2.startReplaceableGroup(2058660585);
                SpacerKt.Spacer(ColumnScope.weight$default(columnScopeInstance2, SizeKt.fillMaxWidth$default(companion7, 0.0f, 1, null), 1.0f, false, 2, null), composer2, 0);
                CircularProgressIndicator$ArcIcon(ColumnScope.weight$default(columnScopeInstance2, SizeKt.fillMaxWidth$default(companion7, 0.0f, 1, null), 1.0f, false, 2, null), circularProgressData.getIcon(), composer2, 64);
                Modifier modifierWeight$default2 = ColumnScope.weight$default(columnScopeInstance2, SizeKt.fillMaxWidth$default(companion7, 0.0f, 1, null), 1.0f, false, 2, null);
                Alignment center6 = companion5.getCenter();
                composer2.startReplaceableGroup(733328855);
                MeasurePolicy measurePolicyRememberBoxMeasurePolicy5 = BoxKt.rememberBoxMeasurePolicy(center6, false, composer2, 6);
                Density density9 = (Density) AbstractC1038a.m1211l(composer2, -1323940314);
                LayoutDirection layoutDirection9 = (LayoutDirection) composer2.consume(androidx.compose.p109ui.platform.CompositionLocalsKt.getLocalLayoutDirection());
                ViewConfiguration viewConfiguration9 = (ViewConfiguration) composer2.consume(androidx.compose.p109ui.platform.CompositionLocalsKt.getLocalViewConfiguration());
                Function0<ComposeUiNode> constructor9 = companion6.getConstructor();
                Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> function3MaterializerOf9 = LayoutKt.materializerOf(modifierWeight$default2);
                if (composer2.getApplier() == null) {
                    ComposablesKt.invalidApplier();
                }
                composer2.startReusableNode();
                if (composer2.getInserting()) {
                    composer2.createNode(constructor9);
                } else {
                    composer2.useNode();
                }
                composer2.disableReusing();
                Composer composerM18018constructorimpl9 = Updater.m18018constructorimpl(composer2);
                Updater.m18025setimpl(composerM18018constructorimpl9, layoutDirection9, (Function2<? super T, ? super LayoutDirection, Unit>) AbstractC1038a.m1219t(companion6, composerM18018constructorimpl9, measurePolicyRememberBoxMeasurePolicy5, composerM18018constructorimpl9, density9));
                function3MaterializerOf9.invoke(AbstractC1038a.m1206g(companion6, composerM18018constructorimpl9, viewConfiguration9, composer2, composer2), composer2, 0);
                composer2.startReplaceableGroup(2058660585);
                CompositionLocalKt.CompositionLocalProvider(CompositionLocalsKt.getLocalAreaSize().provides(DpSize.m21054boximpl(DpKt.m20990DpSizeYgX7TsA(DpSize.m21066getWidthD9Ej5fM(jM21383getMinDpSizeFromPercentDataM_xkUdw2), C2256Dp.m20968constructorimpl(DpSize.m21064getHeightD9Ej5fM(jM21383getMinDpSizeFromPercentDataM_xkUdw2) / 3)))), ComposableLambdaKt.composableLambda(composer2, 136968251, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.glance.oneui.template.component.compose.ProgressIndicatorKt$CircularProgressIndicator$3$1$1$1$1$1
                    {
                        super(2);
                    }

                    @Override // kotlin.jvm.functions.Function2
                    public /* bridge */ /* synthetic */ Unit invoke(Composer composer3, Integer num) {
                        invoke(composer3, num.intValue());
                        return Unit.INSTANCE;
                    }

                    @ComposableTarget(applier = "androidx.compose.ui.UiComposable")
                    @Composable
                    public final void invoke(@Nullable Composer composer3, int i7) {
                        if ((i7 & 11) == 2 && composer3.getSkipping()) {
                            composer3.skipToGroupEnd();
                            return;
                        }
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(136968251, i7, -1, "androidx.glance.oneui.template.component.compose.CircularProgressIndicator.<anonymous>.<anonymous>.<anonymous>.<anonymous>.<anonymous>.<anonymous> (ProgressIndicator.kt:396)");
                        }
                        ProgressIndicatorKt.CircularProgressIndicator$BottomTextArea((ArcProgressData) circularProgressData, composer3, 8);
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                    }
                }), composer2, ProvidedValue.$stable | 48);
                composer2.endReplaceableGroup();
                composer2.endNode();
                composer2.endReplaceableGroup();
                composer2.endReplaceableGroup();
                composer2.endReplaceableGroup();
                composer2.endNode();
                composer2.endReplaceableGroup();
                composer2.endReplaceableGroup();
                composer2.endReplaceableGroup();
                composer2.endNode();
                composer2.endReplaceableGroup();
                composer2.endReplaceableGroup();
                composer2.startReplaceableGroup(-2090618023);
                textData2 = textData5;
                if (textData2 != null) {
                    CircularProgressIndicator$ArcLabelText(SizeKt.m15885height3ABfNKs(SizeKt.fillMaxWidth$default(companion7, 0.0f, 1, null), textData2.getMaxLines() == 1 ? C2256Dp.m20968constructorimpl(ResourceUtilsKt.getFloat(context, C3094R.dimen.sesl_glance_grid_item_text_view_height)) : C2256Dp.m20968constructorimpl(ResourceUtilsKt.getFloat(context, C3094R.dimen.sesl_glance_grid_item_text_view_height_over_2_line))), textData2, composer2, 64, 0);
                    Unit unit = Unit.INSTANCE;
                }
                composer2.endReplaceableGroup();
                composer2.endReplaceableGroup();
                composer2.endNode();
                composer2.endReplaceableGroup();
                composer2.endReplaceableGroup();
                composer2.endReplaceableGroup();
                composer2.endNode();
                composer2.endReplaceableGroup();
                composer2.endReplaceableGroup();
                composer2.endReplaceableGroup();
            }
            composer2.endReplaceableGroup();
        } else {
            i5 = i6;
            textData2 = textData3;
            composerStartRestartGroup.startReplaceableGroup(1953352687);
            m21723ProgressIndicatorY0xEhic(circularProgressData.getValue(), SizeKt.fillMaxSize$default(Modifier.INSTANCE, 0.0f, 1, null), longRef.element, longRef2.element, ProgressType.Circular, contentScale, composerStartRestartGroup, 24624, 0);
            composer2 = composerStartRestartGroup;
            ImageKt.m21721ComposeImagerAjV9yQ(circularProgressData.getIcon(), PrimitiveResources_androidKt.dimensionResource(AppWidgetSize.m21546compareToL2j3NV4(mask, companion.m21569getMediumrx25Pp4()) < 0 ? C3094R.dimen.sesl_glance_circular_progress_small_icon_size : AppWidgetSize.m21550equalsimpl0(mask, companion.m21569getMediumrx25Pp4()) ? C3094R.dimen.sesl_glance_circular_progress_medium_icon_size : C3094R.dimen.sesl_glance_circular_progress_large_icon_size, composer2, 0), circularProgressData.getIcon().getImageType() != ImageType.AppIcon, composer2, 8);
            composer2.endReplaceableGroup();
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            final TextData textData6 = textData2;
            final int i7 = i5;
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.glance.oneui.template.component.compose.ProgressIndicatorKt.CircularProgressIndicator.4
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(2);
                }

                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Unit invoke(Composer composer3, Integer num) {
                    invoke(composer3, num.intValue());
                    return Unit.INSTANCE;
                }

                public final void invoke(@Nullable Composer composer3, int i8) {
                    ProgressIndicatorKt.CircularProgressIndicator(modifier, circularProgressData, i7, textData6, composer3, RecomposeScopeImplKt.updateChangedFlags(i2 | 1), i4);
                }
            });
        }
    }

    @ComposableTarget(applier = "androidx.compose.ui.UiComposable")
    @Composable
    private static final void CircularProgressIndicator$ArcIcon(Modifier modifier, ImageData imageData, Composer composer, int i) {
        composer.startReplaceableGroup(608331637);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(608331637, i, -1, "androidx.glance.oneui.template.component.compose.CircularProgressIndicator.ArcIcon (ProgressIndicator.kt:268)");
        }
        composer.startReplaceableGroup(733328855);
        MeasurePolicy measurePolicyM1210k = AbstractC1038a.m1210k(Alignment.INSTANCE, false, composer, 0, -1323940314);
        Density density = (Density) composer.consume(androidx.compose.p109ui.platform.CompositionLocalsKt.getLocalDensity());
        LayoutDirection layoutDirection = (LayoutDirection) composer.consume(androidx.compose.p109ui.platform.CompositionLocalsKt.getLocalLayoutDirection());
        ViewConfiguration viewConfiguration = (ViewConfiguration) composer.consume(androidx.compose.p109ui.platform.CompositionLocalsKt.getLocalViewConfiguration());
        ComposeUiNode.Companion companion = ComposeUiNode.INSTANCE;
        Function0<ComposeUiNode> constructor = companion.getConstructor();
        Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> function3MaterializerOf = LayoutKt.materializerOf(modifier);
        if (composer.getApplier() == null) {
            ComposablesKt.invalidApplier();
        }
        composer.startReusableNode();
        if (composer.getInserting()) {
            composer.createNode(constructor);
        } else {
            composer.useNode();
        }
        composer.disableReusing();
        Composer composerM18018constructorimpl = Updater.m18018constructorimpl(composer);
        Updater.m18025setimpl(composerM18018constructorimpl, layoutDirection, (Function2<? super T, ? super LayoutDirection, Unit>) AbstractC1038a.m1219t(companion, composerM18018constructorimpl, measurePolicyM1210k, composerM18018constructorimpl, density));
        AbstractC1038a.m1221v(0, function3MaterializerOf, AbstractC1038a.m1206g(companion, composerM18018constructorimpl, viewConfiguration, composer, composer), composer, 2058660585);
        BoxScopeInstance boxScopeInstance = BoxScopeInstance.INSTANCE;
        ImageKt.ComposeImage(imageData, SizeKt.fillMaxSize$default(Modifier.INSTANCE, 0.0f, 1, null), null, imageData.getImageType() != ImageType.AppIcon, composer, 56, 4);
        if (AbstractC2821a.m2209D(composer)) {
            ComposerKt.traceEventEnd();
        }
        composer.endReplaceableGroup();
    }

    @ComposableTarget(applier = "androidx.compose.ui.UiComposable")
    @Composable
    private static final void CircularProgressIndicator$ArcLabelText(Modifier modifier, TextData textData, Composer composer, int i, int i2) {
        composer.startReplaceableGroup(452239963);
        Modifier modifier2 = (i2 & 1) != 0 ? Modifier.INSTANCE : modifier;
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(452239963, i, -1, "androidx.glance.oneui.template.component.compose.CircularProgressIndicator.ArcLabelText (ProgressIndicator.kt:293)");
        }
        Alignment topCenter = Alignment.INSTANCE.getTopCenter();
        composer.startReplaceableGroup(733328855);
        MeasurePolicy measurePolicyRememberBoxMeasurePolicy = BoxKt.rememberBoxMeasurePolicy(topCenter, false, composer, 6);
        Density density = (Density) AbstractC1038a.m1211l(composer, -1323940314);
        LayoutDirection layoutDirection = (LayoutDirection) composer.consume(androidx.compose.p109ui.platform.CompositionLocalsKt.getLocalLayoutDirection());
        ViewConfiguration viewConfiguration = (ViewConfiguration) composer.consume(androidx.compose.p109ui.platform.CompositionLocalsKt.getLocalViewConfiguration());
        ComposeUiNode.Companion companion = ComposeUiNode.INSTANCE;
        Function0<ComposeUiNode> constructor = companion.getConstructor();
        Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> function3MaterializerOf = LayoutKt.materializerOf(modifier2);
        if (composer.getApplier() == null) {
            ComposablesKt.invalidApplier();
        }
        composer.startReusableNode();
        if (composer.getInserting()) {
            composer.createNode(constructor);
        } else {
            composer.useNode();
        }
        composer.disableReusing();
        Composer composerM18018constructorimpl = Updater.m18018constructorimpl(composer);
        Updater.m18025setimpl(composerM18018constructorimpl, layoutDirection, (Function2<? super T, ? super LayoutDirection, Unit>) AbstractC1038a.m1219t(companion, composerM18018constructorimpl, measurePolicyRememberBoxMeasurePolicy, composerM18018constructorimpl, density));
        AbstractC1038a.m1221v(0, function3MaterializerOf, AbstractC1038a.m1206g(companion, composerM18018constructorimpl, viewConfiguration, composer, composer), composer, 2058660585);
        BoxScopeInstance boxScopeInstance = BoxScopeInstance.INSTANCE;
        TextKt.ComposeText(textData, new TextSize((Context) composer.consume(AndroidCompositionLocals_androidKt.getLocalContext()), C3094R.dimen.sesl_glance_grid_item_text_size, ComplexUnit.f1613DP, FontWeight.INSTANCE.m21998getNormalWjrlUT0(), 0.0f, 16, (DefaultConstructorMarker) null), GlanceTheme.INSTANCE.getColors(composer, GlanceTheme.$stable).getOnBackground(), PaddingKt.m15856paddingVpY3zN4$default(Modifier.INSTANCE, C2256Dp.m20968constructorimpl(1), 0.0f, 2, null), composer, (TextPercentData.$stable << 3) | 3592, 0);
        if (AbstractC2821a.m2209D(composer)) {
            ComposerKt.traceEventEnd();
        }
        composer.endReplaceableGroup();
    }

    @ComposableTarget(applier = "androidx.compose.ui.UiComposable")
    @Composable
    private static final void CircularProgressIndicator$ArcProgress(Ref.LongRef longRef, Ref.LongRef longRef2, ContentScale contentScale, Modifier modifier, ArcProgressData arcProgressData, Composer composer, int i) {
        composer.startReplaceableGroup(955000069);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(955000069, i, -1, "androidx.glance.oneui.template.component.compose.CircularProgressIndicator.ArcProgress (ProgressIndicator.kt:254)");
        }
        Alignment center = Alignment.INSTANCE.getCenter();
        composer.startReplaceableGroup(733328855);
        MeasurePolicy measurePolicyRememberBoxMeasurePolicy = BoxKt.rememberBoxMeasurePolicy(center, false, composer, 6);
        Density density = (Density) AbstractC1038a.m1211l(composer, -1323940314);
        LayoutDirection layoutDirection = (LayoutDirection) composer.consume(androidx.compose.p109ui.platform.CompositionLocalsKt.getLocalLayoutDirection());
        ViewConfiguration viewConfiguration = (ViewConfiguration) composer.consume(androidx.compose.p109ui.platform.CompositionLocalsKt.getLocalViewConfiguration());
        ComposeUiNode.Companion companion = ComposeUiNode.INSTANCE;
        Function0<ComposeUiNode> constructor = companion.getConstructor();
        Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> function3MaterializerOf = LayoutKt.materializerOf(modifier);
        if (composer.getApplier() == null) {
            ComposablesKt.invalidApplier();
        }
        composer.startReusableNode();
        if (composer.getInserting()) {
            composer.createNode(constructor);
        } else {
            composer.useNode();
        }
        composer.disableReusing();
        Composer composerM18018constructorimpl = Updater.m18018constructorimpl(composer);
        Updater.m18025setimpl(composerM18018constructorimpl, layoutDirection, (Function2<? super T, ? super LayoutDirection, Unit>) AbstractC1038a.m1219t(companion, composerM18018constructorimpl, measurePolicyRememberBoxMeasurePolicy, composerM18018constructorimpl, density));
        AbstractC1038a.m1221v(0, function3MaterializerOf, AbstractC1038a.m1206g(companion, composerM18018constructorimpl, viewConfiguration, composer, composer), composer, 2058660585);
        BoxScopeInstance boxScopeInstance = BoxScopeInstance.INSTANCE;
        m21723ProgressIndicatorY0xEhic(arcProgressData.getValue(), modifier, longRef.element, longRef2.element, ProgressType.Arc, contentScale, composer, ((i << 3) & 112) | 24576, 0);
        if (AbstractC2821a.m2209D(composer)) {
            ComposerKt.traceEventEnd();
        }
        composer.endReplaceableGroup();
    }

    /* JADX INFO: Access modifiers changed from: private */
    @ComposableTarget(applier = "androidx.compose.ui.UiComposable")
    @Composable
    public static final void CircularProgressIndicator$ArcTitleText(Modifier modifier, TextData textData, Alignment alignment, Composer composer, int i, int i2) {
        composer.startReplaceableGroup(1534074070);
        if ((i2 & 1) != 0) {
            modifier = Modifier.INSTANCE;
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(1534074070, i, -1, "androidx.glance.oneui.template.component.compose.CircularProgressIndicator.ArcTitleText (ProgressIndicator.kt:279)");
        }
        float fM21064getHeightD9Ej5fM = DpSize.m21064getHeightD9Ej5fM(((DpSize) composer.consume(androidx.glance.CompositionLocalsKt.getLocalSize())).getPackedValue());
        float fM21064getHeightD9Ej5fM2 = DpSize.m21064getHeightD9Ej5fM(((DpSize) composer.consume(CompositionLocalsKt.getLocalAreaSize())).getPackedValue());
        composer.startReplaceableGroup(733328855);
        MeasurePolicy measurePolicyRememberBoxMeasurePolicy = BoxKt.rememberBoxMeasurePolicy(alignment, false, composer, ((((i >> 3) & 112) | (i & 14)) >> 3) & 14);
        Density density = (Density) AbstractC1038a.m1211l(composer, -1323940314);
        LayoutDirection layoutDirection = (LayoutDirection) composer.consume(androidx.compose.p109ui.platform.CompositionLocalsKt.getLocalLayoutDirection());
        ViewConfiguration viewConfiguration = (ViewConfiguration) composer.consume(androidx.compose.p109ui.platform.CompositionLocalsKt.getLocalViewConfiguration());
        ComposeUiNode.Companion companion = ComposeUiNode.INSTANCE;
        Function0<ComposeUiNode> constructor = companion.getConstructor();
        Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> function3MaterializerOf = LayoutKt.materializerOf(modifier);
        if (composer.getApplier() == null) {
            ComposablesKt.invalidApplier();
        }
        composer.startReusableNode();
        if (composer.getInserting()) {
            composer.createNode(constructor);
        } else {
            composer.useNode();
        }
        composer.disableReusing();
        Composer composerM18018constructorimpl = Updater.m18018constructorimpl(composer);
        Updater.m18025setimpl(composerM18018constructorimpl, layoutDirection, (Function2<? super T, ? super LayoutDirection, Unit>) AbstractC1038a.m1219t(companion, composerM18018constructorimpl, measurePolicyRememberBoxMeasurePolicy, composerM18018constructorimpl, density));
        AbstractC1038a.m1221v(0, function3MaterializerOf, AbstractC1038a.m1206g(companion, composerM18018constructorimpl, viewConfiguration, composer, composer), composer, 2058660585);
        BoxScopeInstance boxScopeInstance = BoxScopeInstance.INSTANCE;
        TextKt.m21728ComposeText2T94tj4(null, textData, new TextPercentData(0.0f, 0.0f, 0.0f, fM21064getHeightD9Ej5fM2 / fM21064getHeightD9Ej5fM, null, false, 55, null), FontWeight.INSTANCE.m21999getSemiBoldWjrlUT0(), GlanceTheme.INSTANCE.getColors(composer, GlanceTheme.$stable).getOnBackground(), composer, (TextPercentData.$stable << 6) | 32832, 1);
        if (AbstractC2821a.m2209D(composer)) {
            ComposerKt.traceEventEnd();
        }
        composer.endReplaceableGroup();
    }

    /* JADX INFO: Access modifiers changed from: private */
    @ComposableTarget(applier = "androidx.compose.ui.UiComposable")
    @Composable
    public static final void CircularProgressIndicator$BottomTextArea(final ArcProgressData arcProgressData, Composer composer, int i) {
        composer.startReplaceableGroup(457291534);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(457291534, i, -1, "androidx.glance.oneui.template.component.compose.CircularProgressIndicator.BottomTextArea (ProgressIndicator.kt:311)");
        }
        Modifier modifierFillMaxSize$default = SizeKt.fillMaxSize$default(Modifier.INSTANCE, 0.0f, 1, null);
        Arrangement.Vertical top = Arrangement.INSTANCE.getTop();
        composer.startReplaceableGroup(-483455358);
        MeasurePolicy measurePolicyM1209j = AbstractC1038a.m1209j(Alignment.INSTANCE, top, composer, 6, -1323940314);
        Density density = (Density) composer.consume(androidx.compose.p109ui.platform.CompositionLocalsKt.getLocalDensity());
        LayoutDirection layoutDirection = (LayoutDirection) composer.consume(androidx.compose.p109ui.platform.CompositionLocalsKt.getLocalLayoutDirection());
        ViewConfiguration viewConfiguration = (ViewConfiguration) composer.consume(androidx.compose.p109ui.platform.CompositionLocalsKt.getLocalViewConfiguration());
        ComposeUiNode.Companion companion = ComposeUiNode.INSTANCE;
        Function0<ComposeUiNode> constructor = companion.getConstructor();
        Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> function3MaterializerOf = LayoutKt.materializerOf(modifierFillMaxSize$default);
        if (composer.getApplier() == null) {
            ComposablesKt.invalidApplier();
        }
        composer.startReusableNode();
        if (composer.getInserting()) {
            composer.createNode(constructor);
        } else {
            composer.useNode();
        }
        composer.disableReusing();
        Composer composerM18018constructorimpl = Updater.m18018constructorimpl(composer);
        Updater.m18025setimpl(composerM18018constructorimpl, layoutDirection, (Function2<? super T, ? super LayoutDirection, Unit>) AbstractC1038a.m1219t(companion, composerM18018constructorimpl, measurePolicyM1209j, composerM18018constructorimpl, density));
        AbstractC1038a.m1221v(0, function3MaterializerOf, AbstractC1038a.m1206g(companion, composerM18018constructorimpl, viewConfiguration, composer, composer), composer, 2058660585);
        ColumnScopeInstance columnScopeInstance = ColumnScopeInstance.INSTANCE;
        final float f = 0.85f;
        CompositionLocalKt.CompositionLocalProvider(CompositionLocalsKt.getLocalAreaSize().provides(DpSize.m21054boximpl(DpKt.m20990DpSizeYgX7TsA(DpSize.m21066getWidthD9Ej5fM(((DpSize) composer.consume(CompositionLocalsKt.getLocalAreaSize())).getPackedValue()), C2256Dp.m20968constructorimpl(DpSize.m21064getHeightD9Ej5fM(((DpSize) composer.consume(CompositionLocalsKt.getLocalAreaSize())).getPackedValue()) * 0.85f)))), ComposableLambdaKt.composableLambda(composer, 1097810712, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.glance.oneui.template.component.compose.ProgressIndicatorKt$CircularProgressIndicator$BottomTextArea$1$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(2);
            }

            @Override // kotlin.jvm.functions.Function2
            public /* bridge */ /* synthetic */ Unit invoke(Composer composer2, Integer num) {
                invoke(composer2, num.intValue());
                return Unit.INSTANCE;
            }

            @ComposableTarget(applier = "androidx.compose.ui.UiComposable")
            @Composable
            public final void invoke(@Nullable Composer composer2, int i2) {
                if ((i2 & 11) == 2 && composer2.getSkipping()) {
                    composer2.skipToGroupEnd();
                    return;
                }
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(1097810712, i2, -1, "androidx.glance.oneui.template.component.compose.CircularProgressIndicator.BottomTextArea.<anonymous>.<anonymous> (ProgressIndicator.kt:321)");
                }
                Modifier.Companion companion2 = Modifier.INSTANCE;
                Modifier modifierM15885height3ABfNKs = SizeKt.m15885height3ABfNKs(SizeKt.fillMaxWidth$default(companion2, 0.0f, 1, null), C2256Dp.m20968constructorimpl(DpSize.m21064getHeightD9Ej5fM(((DpSize) composer2.consume(CompositionLocalsKt.getLocalAreaSize())).getPackedValue()) * f));
                Alignment.Companion companion3 = Alignment.INSTANCE;
                Alignment center = companion3.getCenter();
                ArcProgressData arcProgressData2 = arcProgressData;
                composer2.startReplaceableGroup(733328855);
                MeasurePolicy measurePolicyRememberBoxMeasurePolicy = BoxKt.rememberBoxMeasurePolicy(center, false, composer2, 6);
                Density density2 = (Density) AbstractC1038a.m1211l(composer2, -1323940314);
                LayoutDirection layoutDirection2 = (LayoutDirection) composer2.consume(androidx.compose.p109ui.platform.CompositionLocalsKt.getLocalLayoutDirection());
                ViewConfiguration viewConfiguration2 = (ViewConfiguration) composer2.consume(androidx.compose.p109ui.platform.CompositionLocalsKt.getLocalViewConfiguration());
                ComposeUiNode.Companion companion4 = ComposeUiNode.INSTANCE;
                Function0<ComposeUiNode> constructor2 = companion4.getConstructor();
                Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> function3MaterializerOf2 = LayoutKt.materializerOf(modifierM15885height3ABfNKs);
                if (composer2.getApplier() == null) {
                    ComposablesKt.invalidApplier();
                }
                composer2.startReusableNode();
                if (composer2.getInserting()) {
                    composer2.createNode(constructor2);
                } else {
                    composer2.useNode();
                }
                composer2.disableReusing();
                Composer composerM18018constructorimpl2 = Updater.m18018constructorimpl(composer2);
                Updater.m18025setimpl(composerM18018constructorimpl2, layoutDirection2, (Function2<? super T, ? super LayoutDirection, Unit>) AbstractC1038a.m1219t(companion4, composerM18018constructorimpl2, measurePolicyRememberBoxMeasurePolicy, composerM18018constructorimpl2, density2));
                AbstractC1038a.m1221v(0, function3MaterializerOf2, AbstractC1038a.m1206g(companion4, composerM18018constructorimpl2, viewConfiguration2, composer2, composer2), composer2, 2058660585);
                BoxScopeInstance boxScopeInstance = BoxScopeInstance.INSTANCE;
                if (arcProgressData2 instanceof CustomArcProgressData) {
                    composer2.startReplaceableGroup(890252342);
                    CustomArcProgressData customArcProgressData = (CustomArcProgressData) arcProgressData2;
                    customArcProgressData.CustomContent(customArcProgressData, composer2, 0);
                    composer2.endReplaceableGroup();
                } else {
                    composer2.startReplaceableGroup(890252420);
                    ProgressIndicatorKt.CircularProgressIndicator$ArcTitleText(SizeKt.fillMaxSize$default(companion2, 0.0f, 1, null), arcProgressData2.getText(), companion3.getTopCenter(), composer2, 454, 0);
                    composer2.endReplaceableGroup();
                }
                if (AbstractC2821a.m2209D(composer2)) {
                    ComposerKt.traceEventEnd();
                }
            }
        }), composer, ProvidedValue.$stable | 48);
        composer.endReplaceableGroup();
        composer.endNode();
        composer.endReplaceableGroup();
        composer.endReplaceableGroup();
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        composer.endReplaceableGroup();
    }

    @ComposableTarget(applier = "androidx.glance.GlanceComposable")
    @Composable
    private static final Pair<Color, Color> CircularProgressIndicator$initColor(CircularProgressData circularProgressData, Composer composer, int i) {
        Pair<Color, Color> pair;
        composer.startReplaceableGroup(1283817639);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(1283817639, i, -1, "androidx.glance.oneui.template.component.compose.CircularProgressIndicator.initColor (ProgressIndicator.kt:229)");
        }
        ColorProviders colors = GlanceTheme.INSTANCE.getColors(composer, GlanceTheme.$stable);
        if (AppWidgetStyle.m21578equalsimpl0(((AppWidgetStyle) composer.consume(CompositionLocalsKt.getLocalWidgetStyle())).getMask(), AppWidgetStyle.INSTANCE.m21586getColorfulWOdBnnM())) {
            composer.startReplaceableGroup(-1961867257);
            pair = new Pair<>(Color.m18515boximpl(ComposeUtilsKt.convert(ColorProvidersKt.override(colors.getPrimary(), circularProgressData.getProgressColor()), composer, 8)), Color.m18515boximpl(ComposeUtilsKt.convert(ColorProvidersKt.override(colors.getPrimaryContainer(), circularProgressData.getBackgroundColor()), composer, 8)));
            composer.endReplaceableGroup();
        } else {
            composer.startReplaceableGroup(-1961867045);
            pair = new Pair<>(Color.m18515boximpl(ComposeUtilsKt.convert(colors.getOnPrimary(), composer, 8)), Color.m18515boximpl(ComposeUtilsKt.convert(colors.getPrimary(), composer, 8)));
            composer.endReplaceableGroup();
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        composer.endReplaceableGroup();
        return pair;
    }

    @ComposableTarget(applier = "androidx.glance.GlanceComposable")
    @Composable
    public static final void ComposeCircularProgressIndicator(@Nullable Modifier modifier, @NotNull final CircularProgressData data, int i, @Nullable TextData textData, @Nullable Composer composer, final int i2, final int i4) {
        Intrinsics.checkNotNullParameter(data, "data");
        Composer composerStartRestartGroup = composer.startRestartGroup(760972462);
        if ((i4 & 1) != 0) {
            modifier = Modifier.INSTANCE;
        }
        final Modifier modifier2 = modifier;
        if ((i4 & 4) != 0) {
            i = 0;
        }
        final int i5 = i;
        TextData textData2 = (i4 & 8) != 0 ? null : textData;
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(760972462, i2, -1, "androidx.glance.oneui.template.component.compose.ComposeCircularProgressIndicator (ProgressIndicator.kt:206)");
        }
        CircularProgressIndicator(modifier2, data, i5, textData2, composerStartRestartGroup, (i2 & 14) | 4160 | (i2 & 896), 0);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            final TextData textData3 = textData2;
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.glance.oneui.template.component.compose.ProgressIndicatorKt.ComposeCircularProgressIndicator.1
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(2);
                }

                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Unit invoke(Composer composer2, Integer num) {
                    invoke(composer2, num.intValue());
                    return Unit.INSTANCE;
                }

                public final void invoke(@Nullable Composer composer2, int i6) {
                    ProgressIndicatorKt.ComposeCircularProgressIndicator(modifier2, data, i5, textData3, composer2, RecomposeScopeImplKt.updateChangedFlags(i2 | 1), i4);
                }
            });
        }
    }

    @ComposableTarget(applier = "androidx.compose.ui.UiComposable")
    @Composable
    public static final void ComposeLinearProgressIndicator(@Nullable final Modifier modifier, @NotNull final LinearProgressData data, @Nullable Composer composer, final int i, final int i2) {
        Intrinsics.checkNotNullParameter(data, "data");
        Composer composerStartRestartGroup = composer.startRestartGroup(1344443826);
        if ((i2 & 1) != 0) {
            modifier = Modifier.INSTANCE;
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(1344443826, i, -1, "androidx.glance.oneui.template.component.compose.ComposeLinearProgressIndicator (ProgressIndicator.kt:69)");
        }
        LinearProgressIndicator(data, modifier, composerStartRestartGroup, ((i << 3) & 112) | 8);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.glance.oneui.template.component.compose.ProgressIndicatorKt.ComposeLinearProgressIndicator.1
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(2);
                }

                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Unit invoke(Composer composer2, Integer num) {
                    invoke(composer2, num.intValue());
                    return Unit.INSTANCE;
                }

                public final void invoke(@Nullable Composer composer2, int i4) {
                    ProgressIndicatorKt.ComposeLinearProgressIndicator(modifier, data, composer2, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
                }
            });
        }
    }

    @ComposableTarget(applier = "androidx.compose.ui.UiComposable")
    @Composable
    /* JADX INFO: renamed from: ComposeLinearProgressIndicator-ziNgDLE, reason: not valid java name */
    public static final void m21722ComposeLinearProgressIndicatorziNgDLE(@NotNull final LinearProgressData data, final float f, @Nullable Composer composer, final int i) {
        Intrinsics.checkNotNullParameter(data, "data");
        Composer composerStartRestartGroup = composer.startRestartGroup(148705213);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(148705213, i, -1, "androidx.glance.oneui.template.component.compose.ComposeLinearProgressIndicator (ProgressIndicator.kt:87)");
        }
        if (C2256Dp.m20967compareTo0680j_4(f, C2256Dp.m20968constructorimpl(0)) > 0) {
            composerStartRestartGroup.startReplaceableGroup(519954591);
            LinearProgressIndicator(data, SizeKt.m15885height3ABfNKs(SizeKt.fillMaxWidth$default(Modifier.INSTANCE, 0.0f, 1, null), f), composerStartRestartGroup, 8);
            composerStartRestartGroup.endReplaceableGroup();
        } else {
            composerStartRestartGroup.startReplaceableGroup(519954680);
            ComposeLinearProgressIndicator(data, 0, composerStartRestartGroup, 56, 0);
            composerStartRestartGroup.endReplaceableGroup();
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.glance.oneui.template.component.compose.ProgressIndicatorKt.ComposeLinearProgressIndicator.3
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(2);
                }

                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Unit invoke(Composer composer2, Integer num) {
                    invoke(composer2, num.intValue());
                    return Unit.INSTANCE;
                }

                public final void invoke(@Nullable Composer composer2, int i2) {
                    ProgressIndicatorKt.m21722ComposeLinearProgressIndicatorziNgDLE(data, f, composer2, RecomposeScopeImplKt.updateChangedFlags(i | 1));
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    @ComposableTarget(applier = "androidx.compose.ui.UiComposable")
    @Composable
    public static final void LinearProgressIndicator(final LinearProgressData linearProgressData, final Modifier modifier, Composer composer, final int i) {
        Alignment.Companion companion;
        float f;
        ComposeUiNode.Companion companion2;
        long jConvert;
        long jConvert2;
        Object obj;
        TextData mainText;
        Composer composerStartRestartGroup = composer.startRestartGroup(1075516190);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(1075516190, i, -1, "androidx.glance.oneui.template.component.compose.LinearProgressIndicator (ProgressIndicator.kt:96)");
        }
        composerStartRestartGroup.startReplaceableGroup(733328855);
        Alignment.Companion companion3 = Alignment.INSTANCE;
        MeasurePolicy measurePolicyM1210k = AbstractC1038a.m1210k(companion3, false, composerStartRestartGroup, 0, -1323940314);
        Density density = (Density) composerStartRestartGroup.consume(androidx.compose.p109ui.platform.CompositionLocalsKt.getLocalDensity());
        LayoutDirection layoutDirection = (LayoutDirection) composerStartRestartGroup.consume(androidx.compose.p109ui.platform.CompositionLocalsKt.getLocalLayoutDirection());
        ViewConfiguration viewConfiguration = (ViewConfiguration) composerStartRestartGroup.consume(androidx.compose.p109ui.platform.CompositionLocalsKt.getLocalViewConfiguration());
        ComposeUiNode.Companion companion4 = ComposeUiNode.INSTANCE;
        Function0<ComposeUiNode> constructor = companion4.getConstructor();
        Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> function3MaterializerOf = LayoutKt.materializerOf(modifier);
        if (composerStartRestartGroup.getApplier() == null) {
            ComposablesKt.invalidApplier();
        }
        composerStartRestartGroup.startReusableNode();
        if (composerStartRestartGroup.getInserting()) {
            composerStartRestartGroup.createNode(constructor);
        } else {
            composerStartRestartGroup.useNode();
        }
        composerStartRestartGroup.disableReusing();
        Composer composerM18018constructorimpl = Updater.m18018constructorimpl(composerStartRestartGroup);
        Updater.m18025setimpl(composerM18018constructorimpl, layoutDirection, (Function2<? super T, ? super LayoutDirection, Unit>) AbstractC1038a.m1219t(companion4, composerM18018constructorimpl, measurePolicyM1210k, composerM18018constructorimpl, density));
        function3MaterializerOf.invoke(AbstractC1038a.m1206g(companion4, composerM18018constructorimpl, viewConfiguration, composerStartRestartGroup, composerStartRestartGroup), composerStartRestartGroup, 0);
        composerStartRestartGroup.startReplaceableGroup(2058660585);
        BoxScopeInstance boxScopeInstance = BoxScopeInstance.INSTANCE;
        int mask = ((AppWidgetStyle) composerStartRestartGroup.consume(CompositionLocalsKt.getLocalWidgetStyle())).getMask();
        AppWidgetStyle.Companion companion5 = AppWidgetStyle.INSTANCE;
        if (AppWidgetStyle.m21578equalsimpl0(mask, companion5.m21586getColorfulWOdBnnM())) {
            composerStartRestartGroup.startReplaceableGroup(1298611399);
            Modifier.Companion companion6 = Modifier.INSTANCE;
            float f4 = 1;
            Modifier modifierM15858paddingqDBjuR0$default = PaddingKt.m15858paddingqDBjuR0$default(SizeKt.fillMaxSize$default(companion6, 0.0f, 1, null), C2256Dp.m20968constructorimpl(f4), 0.0f, C2256Dp.m20968constructorimpl(f4), 0.0f, 10, null);
            Alignment center = companion3.getCenter();
            composerStartRestartGroup.startReplaceableGroup(733328855);
            MeasurePolicy measurePolicyRememberBoxMeasurePolicy = BoxKt.rememberBoxMeasurePolicy(center, false, composerStartRestartGroup, 6);
            Density density2 = (Density) AbstractC1038a.m1211l(composerStartRestartGroup, -1323940314);
            LayoutDirection layoutDirection2 = (LayoutDirection) composerStartRestartGroup.consume(androidx.compose.p109ui.platform.CompositionLocalsKt.getLocalLayoutDirection());
            ViewConfiguration viewConfiguration2 = (ViewConfiguration) composerStartRestartGroup.consume(androidx.compose.p109ui.platform.CompositionLocalsKt.getLocalViewConfiguration());
            Function0<ComposeUiNode> constructor2 = companion4.getConstructor();
            Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> function3MaterializerOf2 = LayoutKt.materializerOf(modifierM15858paddingqDBjuR0$default);
            if (composerStartRestartGroup.getApplier() == null) {
                ComposablesKt.invalidApplier();
            }
            composerStartRestartGroup.startReusableNode();
            if (composerStartRestartGroup.getInserting()) {
                composerStartRestartGroup.createNode(constructor2);
            } else {
                composerStartRestartGroup.useNode();
            }
            composerStartRestartGroup.disableReusing();
            Composer composerM18018constructorimpl2 = Updater.m18018constructorimpl(composerStartRestartGroup);
            Updater.m18025setimpl(composerM18018constructorimpl2, layoutDirection2, (Function2<? super T, ? super LayoutDirection, Unit>) AbstractC1038a.m1219t(companion4, composerM18018constructorimpl2, measurePolicyRememberBoxMeasurePolicy, composerM18018constructorimpl2, density2));
            function3MaterializerOf2.invoke(AbstractC1038a.m1206g(companion4, composerM18018constructorimpl2, viewConfiguration2, composerStartRestartGroup, composerStartRestartGroup), composerStartRestartGroup, 0);
            composerStartRestartGroup.startReplaceableGroup(2058660585);
            Modifier modifierFillMaxSize$default = SizeKt.fillMaxSize$default(companion6, 0.0f, 1, null);
            GlanceTheme glanceTheme = GlanceTheme.INSTANCE;
            int i2 = GlanceTheme.$stable;
            long jConvert3 = ComposeUtilsKt.convert(ColorProvidersKt.override(glanceTheme.getColors(composerStartRestartGroup, i2).getPrimaryContainer(), linearProgressData.getBackgroundColor()), composerStartRestartGroup, 8);
            CommonDimensions commonDimensions = CommonDimensions.INSTANCE;
            Modifier modifierM15408backgroundbw27NRU = BackgroundKt.m15408backgroundbw27NRU(modifierFillMaxSize$default, jConvert3, new SmoothRoundedCornerShape(commonDimensions.m21773getDefaultCornerRadiusD9Ej5fM(), null));
            composerStartRestartGroup.startReplaceableGroup(733328855);
            MeasurePolicy measurePolicyM1210k2 = AbstractC1038a.m1210k(companion3, false, composerStartRestartGroup, 0, -1323940314);
            Density density3 = (Density) composerStartRestartGroup.consume(androidx.compose.p109ui.platform.CompositionLocalsKt.getLocalDensity());
            LayoutDirection layoutDirection3 = (LayoutDirection) composerStartRestartGroup.consume(androidx.compose.p109ui.platform.CompositionLocalsKt.getLocalLayoutDirection());
            ViewConfiguration viewConfiguration3 = (ViewConfiguration) composerStartRestartGroup.consume(androidx.compose.p109ui.platform.CompositionLocalsKt.getLocalViewConfiguration());
            Function0<ComposeUiNode> constructor3 = companion4.getConstructor();
            Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> function3MaterializerOf3 = LayoutKt.materializerOf(modifierM15408backgroundbw27NRU);
            if (composerStartRestartGroup.getApplier() == null) {
                ComposablesKt.invalidApplier();
            }
            composerStartRestartGroup.startReusableNode();
            if (composerStartRestartGroup.getInserting()) {
                composerStartRestartGroup.createNode(constructor3);
            } else {
                composerStartRestartGroup.useNode();
            }
            composerStartRestartGroup.disableReusing();
            Composer composerM18018constructorimpl3 = Updater.m18018constructorimpl(composerStartRestartGroup);
            Updater.m18025setimpl(composerM18018constructorimpl3, layoutDirection3, (Function2<? super T, ? super LayoutDirection, Unit>) AbstractC1038a.m1219t(companion4, composerM18018constructorimpl3, measurePolicyM1210k2, composerM18018constructorimpl3, density3));
            function3MaterializerOf3.invoke(AbstractC1038a.m1206g(companion4, composerM18018constructorimpl3, viewConfiguration3, composerStartRestartGroup, composerStartRestartGroup), composerStartRestartGroup, 0);
            composerStartRestartGroup.startReplaceableGroup(2058660585);
            composerStartRestartGroup.endReplaceableGroup();
            composerStartRestartGroup.endNode();
            composerStartRestartGroup.endReplaceableGroup();
            composerStartRestartGroup.endReplaceableGroup();
            composerStartRestartGroup.endReplaceableGroup();
            composerStartRestartGroup.endNode();
            composerStartRestartGroup.endReplaceableGroup();
            composerStartRestartGroup.endReplaceableGroup();
            companion2 = companion4;
            companion = companion3;
            f = 0.0f;
            m21723ProgressIndicatorY0xEhic(linearProgressData.getValue(), ClipKt.clip(SizeKt.fillMaxSize$default(companion6, 0.0f, 1, null), new SmoothRoundedCornerShape(commonDimensions.m21773getDefaultCornerRadiusD9Ej5fM(), null)), ComposeUtilsKt.convert(ColorProvidersKt.override(glanceTheme.getColors(composerStartRestartGroup, i2).getPrimary(), linearProgressData.getProgressColor()), composerStartRestartGroup, 8), Color.INSTANCE.m18560getTransparent0d7_KjU(), ProgressType.Linear, null, composerStartRestartGroup, 27648, 32);
            composerStartRestartGroup.endReplaceableGroup();
            obj = null;
        } else {
            companion = companion3;
            f = 0.0f;
            companion2 = companion4;
            composerStartRestartGroup.startReplaceableGroup(1298612454);
            if (linearProgressData.getIcon() == null && linearProgressData.getMainText() == null && linearProgressData.getSubText() == null) {
                composerStartRestartGroup.startReplaceableGroup(1298612786);
                GlanceTheme glanceTheme2 = GlanceTheme.INSTANCE;
                int i4 = GlanceTheme.$stable;
                jConvert = ComposeUtilsKt.convert(glanceTheme2.getColors(composerStartRestartGroup, i4).getOnPrimary(), composerStartRestartGroup, 8);
                jConvert2 = ComposeUtilsKt.convert(glanceTheme2.getColors(composerStartRestartGroup, i4).getPrimary(), composerStartRestartGroup, 8);
                composerStartRestartGroup.endReplaceableGroup();
            } else {
                composerStartRestartGroup.startReplaceableGroup(1298612616);
                GlanceTheme glanceTheme3 = GlanceTheme.INSTANCE;
                int i5 = GlanceTheme.$stable;
                jConvert = ComposeUtilsKt.convert(glanceTheme3.getColors(composerStartRestartGroup, i5).getPrimary(), composerStartRestartGroup, 8);
                jConvert2 = ComposeUtilsKt.convert(glanceTheme3.getColors(composerStartRestartGroup, i5).getPrimaryContainer(), composerStartRestartGroup, 8);
                composerStartRestartGroup.endReplaceableGroup();
            }
            obj = null;
            m21723ProgressIndicatorY0xEhic(linearProgressData.getValue(), ClipKt.clip(SizeKt.fillMaxSize$default(Modifier.INSTANCE, 0.0f, 1, null), new SmoothRoundedCornerShape(CommonDimensions.INSTANCE.m21773getDefaultCornerRadiusD9Ej5fM(), null)), jConvert, jConvert2, ProgressType.Linear, null, composerStartRestartGroup, 24576, 32);
            composerStartRestartGroup.endReplaceableGroup();
        }
        if (linearProgressData instanceof CustomLinearProgressData) {
            composerStartRestartGroup.startReplaceableGroup(1298613305);
            CustomLinearProgressData customLinearProgressData = (CustomLinearProgressData) linearProgressData;
            customLinearProgressData.CustomContent(customLinearProgressData, composerStartRestartGroup, 0);
            composerStartRestartGroup.endReplaceableGroup();
        } else {
            composerStartRestartGroup.startReplaceableGroup(1298613359);
            Modifier.Companion companion7 = Modifier.INSTANCE;
            Modifier modifierM15858paddingqDBjuR0$default2 = PaddingKt.m15858paddingqDBjuR0$default(SizeKt.fillMaxSize$default(companion7, f, 1, obj), linearProgressData.getIcon() != null ? C2256Dp.m20968constructorimpl(5) : C2256Dp.m20968constructorimpl(10), 0.0f, C2256Dp.m20968constructorimpl(10), 0.0f, 10, null);
            Alignment.Vertical centerVertically = companion.getCenterVertically();
            composerStartRestartGroup.startReplaceableGroup(693286680);
            MeasurePolicy measurePolicyM1207h = AbstractC1038a.m1207h(Arrangement.INSTANCE, centerVertically, composerStartRestartGroup, 48, -1323940314);
            Density density4 = (Density) composerStartRestartGroup.consume(androidx.compose.p109ui.platform.CompositionLocalsKt.getLocalDensity());
            LayoutDirection layoutDirection4 = (LayoutDirection) composerStartRestartGroup.consume(androidx.compose.p109ui.platform.CompositionLocalsKt.getLocalLayoutDirection());
            ViewConfiguration viewConfiguration4 = (ViewConfiguration) composerStartRestartGroup.consume(androidx.compose.p109ui.platform.CompositionLocalsKt.getLocalViewConfiguration());
            Function0<ComposeUiNode> constructor4 = companion2.getConstructor();
            Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> function3MaterializerOf4 = LayoutKt.materializerOf(modifierM15858paddingqDBjuR0$default2);
            if (composerStartRestartGroup.getApplier() == null) {
                ComposablesKt.invalidApplier();
            }
            composerStartRestartGroup.startReusableNode();
            if (composerStartRestartGroup.getInserting()) {
                composerStartRestartGroup.createNode(constructor4);
            } else {
                composerStartRestartGroup.useNode();
            }
            composerStartRestartGroup.disableReusing();
            Composer composerM18018constructorimpl4 = Updater.m18018constructorimpl(composerStartRestartGroup);
            ComposeUiNode.Companion companion8 = companion2;
            Updater.m18025setimpl(composerM18018constructorimpl4, layoutDirection4, (Function2<? super T, ? super LayoutDirection, Unit>) AbstractC1038a.m1219t(companion8, composerM18018constructorimpl4, measurePolicyM1207h, composerM18018constructorimpl4, density4));
            function3MaterializerOf4.invoke(AbstractC1038a.m1206g(companion8, composerM18018constructorimpl4, viewConfiguration4, composerStartRestartGroup, composerStartRestartGroup), composerStartRestartGroup, 0);
            composerStartRestartGroup.startReplaceableGroup(2058660585);
            RowScopeInstance rowScopeInstance = RowScopeInstance.INSTANCE;
            ImageData icon = linearProgressData.getIcon();
            composerStartRestartGroup.startReplaceableGroup(812871350);
            if (icon != null) {
                composerStartRestartGroup.startReplaceableGroup(812871449);
                if (AppWidgetStyle.m21578equalsimpl0(((AppWidgetStyle) composerStartRestartGroup.consume(CompositionLocalsKt.getLocalWidgetStyle())).getMask(), companion5.m21586getColorfulWOdBnnM())) {
                    ColorProvider imageTintColor = icon.getImageTintColor();
                    if (imageTintColor == null) {
                        imageTintColor = GlanceTheme.INSTANCE.getColors(composerStartRestartGroup, GlanceTheme.$stable).getOnPrimary();
                    }
                    icon.setImageTintColor$glance_oneui_template_release(imageTintColor);
                }
                composerStartRestartGroup.endReplaceableGroup();
                ImageKt.m21721ComposeImagerAjV9yQ(icon, AppWidgetSize.m21546compareToL2j3NV4(((AppWidgetSize) composerStartRestartGroup.consume(CompositionLocalsKt.getLocalWidgetSize())).getMask(), AppWidgetSize.INSTANCE.m21569getMediumrx25Pp4()) >= 0 ? CommonDimensions.INSTANCE.m21774getDefaultIconSizeD9Ej5fM() : C2256Dp.m20968constructorimpl(14), icon.getImageType() != ImageType.AppIcon, composerStartRestartGroup, 8);
                Unit unit = Unit.INSTANCE;
            }
            composerStartRestartGroup.endReplaceableGroup();
            composerStartRestartGroup.startReplaceableGroup(812872070);
            if (AppWidgetSize.m21546compareToL2j3NV4(((AppWidgetSize) composerStartRestartGroup.consume(CompositionLocalsKt.getLocalWidgetSize())).getMask(), AppWidgetSize.INSTANCE.m21568getLargerx25Pp4()) >= 0 && (mainText = linearProgressData.getMainText()) != null) {
                ImageData icon2 = linearProgressData.getIcon();
                composerStartRestartGroup.startReplaceableGroup(812872200);
                if (icon2 != null) {
                    SpacerKt.Spacer(SizeKt.m15904width3ABfNKs(companion7, C2256Dp.m20968constructorimpl(6)), composerStartRestartGroup, 6);
                    Unit unit2 = Unit.INSTANCE;
                }
                composerStartRestartGroup.endReplaceableGroup();
                LinearGraphLayoutKt.m21800ComposeGraphTextlL68QWg(mainText, TextType.INSTANCE.m21689getBodygxbDmow(), GlanceTheme.INSTANCE.getColors(composerStartRestartGroup, GlanceTheme.$stable).getOnPrimaryContainer(), null, composerStartRestartGroup, 568, 8);
                Unit unit3 = Unit.INSTANCE;
            }
            composerStartRestartGroup.endReplaceableGroup();
            SpacerKt.Spacer(PaddingKt.m15858paddingqDBjuR0$default(SizeKt.m15885height3ABfNKs(RowScope.weight$default(rowScopeInstance, companion7, 1.0f, false, 2, null), C2256Dp.m20968constructorimpl(1)), 0.0f, 0.0f, C2256Dp.m20968constructorimpl(8), 0.0f, 11, null), composerStartRestartGroup, 0);
            TextData subText = linearProgressData.getSubText();
            composerStartRestartGroup.startReplaceableGroup(1298615193);
            if (subText != null) {
                LinearGraphLayoutKt.m21800ComposeGraphTextlL68QWg(subText, TextType.INSTANCE.m21693getLabelgxbDmow(), GlanceTheme.INSTANCE.getColors(composerStartRestartGroup, GlanceTheme.$stable).getOnPrimaryContainer(), null, composerStartRestartGroup, 568, 8);
                Unit unit4 = Unit.INSTANCE;
            }
            composerStartRestartGroup.endReplaceableGroup();
            composerStartRestartGroup.endReplaceableGroup();
            composerStartRestartGroup.endNode();
            composerStartRestartGroup.endReplaceableGroup();
            composerStartRestartGroup.endReplaceableGroup();
            composerStartRestartGroup.endReplaceableGroup();
        }
        if (AbstractC2821a.m2209D(composerStartRestartGroup)) {
            ComposerKt.traceEventEnd();
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.glance.oneui.template.component.compose.ProgressIndicatorKt.LinearProgressIndicator.2
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(2);
                }

                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Unit invoke(Composer composer2, Integer num) {
                    invoke(composer2, num.intValue());
                    return Unit.INSTANCE;
                }

                public final void invoke(@Nullable Composer composer2, int i6) {
                    ProgressIndicatorKt.LinearProgressIndicator(linearProgressData, modifier, composer2, RecomposeScopeImplKt.updateChangedFlags(i | 1));
                }
            });
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:104:0x0129  */
    /* JADX WARN: Removed duplicated region for block: B:109:0x0152  */
    /* JADX WARN: Removed duplicated region for block: B:116:0x018a  */
    /* JADX WARN: Removed duplicated region for block: B:119:0x01aa  */
    /* JADX WARN: Removed duplicated region for block: B:123:0x01b4  */
    /* JADX WARN: Removed duplicated region for block: B:125:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:26:0x004f  */
    /* JADX WARN: Removed duplicated region for block: B:27:0x0052  */
    /* JADX WARN: Removed duplicated region for block: B:36:0x0066  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x0069  */
    /* JADX WARN: Removed duplicated region for block: B:46:0x007d  */
    /* JADX WARN: Removed duplicated region for block: B:47:0x0080  */
    /* JADX WARN: Removed duplicated region for block: B:56:0x0096  */
    /* JADX WARN: Removed duplicated region for block: B:58:0x009c  */
    /* JADX WARN: Removed duplicated region for block: B:67:0x00ba  */
    /* JADX WARN: Removed duplicated region for block: B:71:0x00c9  */
    /* JADX WARN: Removed duplicated region for block: B:72:0x00cb  */
    /* JADX WARN: Removed duplicated region for block: B:73:0x00ce  */
    /* JADX WARN: Removed duplicated region for block: B:75:0x00d1  */
    /* JADX WARN: Removed duplicated region for block: B:76:0x00d4  */
    /* JADX WARN: Removed duplicated region for block: B:79:0x00db  */
    /* JADX WARN: Removed duplicated region for block: B:82:0x00ec  */
    @ComposableTarget(applier = "androidx.compose.ui.UiComposable")
    @Composable
    /* JADX INFO: renamed from: ProgressIndicator-Y0xEhic, reason: not valid java name */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final void m21723ProgressIndicatorY0xEhic(@FloatRange(from = 0.0d, m705to = 1.0d) final float f, @Nullable Modifier modifier, final long j, final long j2, @NotNull final ProgressType type, @Nullable ContentScale contentScale, @Nullable Composer composer, final int i, final int i2) {
        int i4;
        Modifier modifier2;
        int i5;
        ContentScale contentScale2;
        int i6;
        int i7;
        boolean zChanged;
        Object objRememberedValue;
        int i8;
        boolean zChanged2;
        Object objRememberedValue2;
        Composer composer2;
        final Modifier modifier3;
        final ContentScale contentScale3;
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup;
        final float f4 = f;
        Intrinsics.checkNotNullParameter(type, "type");
        Composer composerStartRestartGroup = composer.startRestartGroup(1111196323);
        if ((i2 & 1) != 0) {
            i4 = i | 6;
        } else if ((i & 14) == 0) {
            i4 = (composerStartRestartGroup.changed(f4) ? 4 : 2) | i;
        } else {
            i4 = i;
        }
        int i9 = i2 & 2;
        if (i9 != 0) {
            i4 |= 48;
        } else {
            if ((i & 112) == 0) {
                modifier2 = modifier;
                i4 |= composerStartRestartGroup.changed(modifier2) ? 32 : 16;
            }
            if ((i2 & 4) == 0) {
                i4 |= 384;
            } else if ((i & 896) == 0) {
                i4 |= composerStartRestartGroup.changed(j) ? 256 : 128;
            }
            if ((i2 & 8) == 0) {
                i4 |= 3072;
            } else if ((i & 7168) == 0) {
                i4 |= composerStartRestartGroup.changed(j2) ? 2048 : 1024;
            }
            if ((i2 & 16) == 0) {
                i4 |= 24576;
            } else if ((57344 & i) == 0) {
                i4 |= composerStartRestartGroup.changed(type) ? 16384 : 8192;
            }
            i5 = i2 & 32;
            if (i5 != 0) {
                if ((458752 & i) == 0) {
                    contentScale2 = contentScale;
                    i4 |= composerStartRestartGroup.changed(contentScale2) ? 131072 : 65536;
                }
                if ((i4 & 374491) == 74898 && composerStartRestartGroup.getSkipping()) {
                    composerStartRestartGroup.skipToGroupEnd();
                    composer2 = composerStartRestartGroup;
                    modifier3 = modifier2;
                    contentScale3 = contentScale2;
                } else {
                    Modifier modifier4 = i9 == 0 ? Modifier.INSTANCE : modifier2;
                    ContentScale contentScale4 = i5 == 0 ? ContentScale.Medium : contentScale2;
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(1111196323, i4, -1, "androidx.glance.oneui.template.component.compose.ProgressIndicator (ProgressIndicator.kt:457)");
                    }
                    i6 = WhenMappings.$EnumSwitchMapping$1[type.ordinal()];
                    if (i6 != 1) {
                        i7 = C2902R.layout.glance_linear_progress_indicator_determinate;
                    } else if (i6 == 2) {
                        int i10 = WhenMappings.$EnumSwitchMapping$0[contentScale4.ordinal()];
                        i7 = i10 != 1 ? i10 != 2 ? C2902R.layout.glance_circular_progress_indicator_large : C2902R.layout.glance_circular_progress_indicator_medium : C2902R.layout.glance_circular_progress_indicator_small;
                    } else if (i6 == 3) {
                        int i11 = WhenMappings.$EnumSwitchMapping$0[contentScale4.ordinal()];
                        i7 = (i11 == 1 || i11 != 2) ? C2902R.layout.glance_arc_progress_indicator_small : C2902R.layout.glance_arc_progress_indicator_small;
                    } else {
                        if (i6 != 4) {
                            throw new NoWhenBranchMatchedException();
                        }
                        i7 = C2902R.layout.glance_stacked_progress_indicator;
                    }
                    composerStartRestartGroup.startReplaceableGroup(409163654);
                    zChanged = composerStartRestartGroup.changed(i7) | composerStartRestartGroup.changed(f4) | composerStartRestartGroup.changed(j) | composerStartRestartGroup.changed(j2);
                    objRememberedValue = composerStartRestartGroup.rememberedValue();
                    if (!zChanged || objRememberedValue == Composer.INSTANCE.getEmpty()) {
                        final int i12 = i7;
                        i8 = i4;
                        Function1<Context, ProgressBar> function1 = new Function1<Context, ProgressBar>() { // from class: androidx.glance.oneui.template.component.compose.ProgressIndicatorKt$ProgressIndicator$1$1
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            {
                                super(1);
                            }

                            @Override // kotlin.jvm.functions.Function1
                            @NotNull
                            public final ProgressBar invoke(@NotNull Context context) {
                                Intrinsics.checkNotNullParameter(context, "context");
                                View viewInflate = LayoutInflater.from(context).inflate(i12, (ViewGroup) null);
                                Intrinsics.checkNotNull(viewInflate, "null cannot be cast to non-null type android.widget.ProgressBar");
                                ProgressBar progressBar = (ProgressBar) viewInflate;
                                ProgressIndicatorKt.m21726update0YGnOg8(progressBar, f, j, j2);
                                return progressBar;
                            }
                        };
                        f4 = f;
                        composerStartRestartGroup.updateRememberedValue(function1);
                        objRememberedValue = function1;
                    } else {
                        i8 = i4;
                    }
                    Function1 function12 = (Function1) objRememberedValue;
                    composerStartRestartGroup.endReplaceableGroup();
                    composerStartRestartGroup.startReplaceableGroup(409163866);
                    zChanged2 = composerStartRestartGroup.changed(f4) | composerStartRestartGroup.changed(j) | composerStartRestartGroup.changed(j2);
                    objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                    if (!zChanged2 || objRememberedValue2 == Composer.INSTANCE.getEmpty()) {
                        Function1<ProgressBar, Unit> function13 = new Function1<ProgressBar, Unit>() { // from class: androidx.glance.oneui.template.component.compose.ProgressIndicatorKt$ProgressIndicator$2$1
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            {
                                super(1);
                            }

                            @Override // kotlin.jvm.functions.Function1
                            public /* bridge */ /* synthetic */ Unit invoke(ProgressBar progressBar) {
                                invoke2(progressBar);
                                return Unit.INSTANCE;
                            }

                            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                            public final void invoke2(@NotNull ProgressBar progressBar) {
                                Intrinsics.checkNotNullParameter(progressBar, "progressBar");
                                ProgressIndicatorKt.m21726update0YGnOg8(progressBar, f4, j, j2);
                                progressBar.invalidate();
                            }
                        };
                        composerStartRestartGroup.updateRememberedValue(function13);
                        objRememberedValue2 = function13;
                    }
                    composerStartRestartGroup.endReplaceableGroup();
                    composer2 = composerStartRestartGroup;
                    modifier3 = modifier4;
                    AndroidView_androidKt.AndroidView(function12, modifier3, (Function1) objRememberedValue2, composer2, i8 & 112, 0);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    contentScale3 = contentScale4;
                }
                scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup != null) {
                    scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.glance.oneui.template.component.compose.ProgressIndicatorKt$ProgressIndicator$3
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        {
                            super(2);
                        }

                        @Override // kotlin.jvm.functions.Function2
                        public /* bridge */ /* synthetic */ Unit invoke(Composer composer3, Integer num) {
                            invoke(composer3, num.intValue());
                            return Unit.INSTANCE;
                        }

                        public final void invoke(@Nullable Composer composer3, int i13) {
                            ProgressIndicatorKt.m21723ProgressIndicatorY0xEhic(f, modifier3, j, j2, type, contentScale3, composer3, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
                        }
                    });
                    return;
                }
                return;
            }
            i4 |= 196608;
            contentScale2 = contentScale;
            if ((i4 & 374491) == 74898) {
                if (i9 == 0) {
                }
                if (i5 == 0) {
                }
                if (ComposerKt.isTraceInProgress()) {
                }
                i6 = WhenMappings.$EnumSwitchMapping$1[type.ordinal()];
                if (i6 != 1) {
                }
                composerStartRestartGroup.startReplaceableGroup(409163654);
                zChanged = composerStartRestartGroup.changed(i7) | composerStartRestartGroup.changed(f4) | composerStartRestartGroup.changed(j) | composerStartRestartGroup.changed(j2);
                objRememberedValue = composerStartRestartGroup.rememberedValue();
                if (zChanged) {
                    final int i122 = i7;
                    i8 = i4;
                    Function1<Context, ProgressBar> function14 = new Function1<Context, ProgressBar>() { // from class: androidx.glance.oneui.template.component.compose.ProgressIndicatorKt$ProgressIndicator$1$1
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        {
                            super(1);
                        }

                        @Override // kotlin.jvm.functions.Function1
                        @NotNull
                        public final ProgressBar invoke(@NotNull Context context) {
                            Intrinsics.checkNotNullParameter(context, "context");
                            View viewInflate = LayoutInflater.from(context).inflate(i122, (ViewGroup) null);
                            Intrinsics.checkNotNull(viewInflate, "null cannot be cast to non-null type android.widget.ProgressBar");
                            ProgressBar progressBar = (ProgressBar) viewInflate;
                            ProgressIndicatorKt.m21726update0YGnOg8(progressBar, f, j, j2);
                            return progressBar;
                        }
                    };
                    f4 = f;
                    composerStartRestartGroup.updateRememberedValue(function14);
                    objRememberedValue = function14;
                    Function1 function122 = (Function1) objRememberedValue;
                    composerStartRestartGroup.endReplaceableGroup();
                    composerStartRestartGroup.startReplaceableGroup(409163866);
                    zChanged2 = composerStartRestartGroup.changed(f4) | composerStartRestartGroup.changed(j) | composerStartRestartGroup.changed(j2);
                    objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                    if (!zChanged2) {
                        Function1<ProgressBar, Unit> function132 = new Function1<ProgressBar, Unit>() { // from class: androidx.glance.oneui.template.component.compose.ProgressIndicatorKt$ProgressIndicator$2$1
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            {
                                super(1);
                            }

                            @Override // kotlin.jvm.functions.Function1
                            public /* bridge */ /* synthetic */ Unit invoke(ProgressBar progressBar) {
                                invoke2(progressBar);
                                return Unit.INSTANCE;
                            }

                            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                            public final void invoke2(@NotNull ProgressBar progressBar) {
                                Intrinsics.checkNotNullParameter(progressBar, "progressBar");
                                ProgressIndicatorKt.m21726update0YGnOg8(progressBar, f4, j, j2);
                                progressBar.invalidate();
                            }
                        };
                        composerStartRestartGroup.updateRememberedValue(function132);
                        objRememberedValue2 = function132;
                        composerStartRestartGroup.endReplaceableGroup();
                        composer2 = composerStartRestartGroup;
                        modifier3 = modifier4;
                        AndroidView_androidKt.AndroidView(function122, modifier3, (Function1) objRememberedValue2, composer2, i8 & 112, 0);
                        if (ComposerKt.isTraceInProgress()) {
                        }
                        contentScale3 = contentScale4;
                    }
                }
            }
            scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup != null) {
            }
        }
        modifier2 = modifier;
        if ((i2 & 4) == 0) {
        }
        if ((i2 & 8) == 0) {
        }
        if ((i2 & 16) == 0) {
        }
        i5 = i2 & 32;
        if (i5 != 0) {
        }
        contentScale2 = contentScale;
        if ((i4 & 374491) == 74898) {
        }
        scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
        }
    }

    /* JADX INFO: renamed from: toColorStateList-8_81llA, reason: not valid java name */
    private static final ColorStateList m21725toColorStateList8_81llA(long j) {
        return new ColorStateList(new int[][]{new int[0]}, new int[]{ColorKt.m18579toArgb8_81llA(j)});
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: update-0YGnOg8, reason: not valid java name */
    public static final void m21726update0YGnOg8(ProgressBar progressBar, float f, long j, long j2) {
        progressBar.setProgress((int) (f * 100));
        progressBar.setProgressTintList(m21725toColorStateList8_81llA(j));
        progressBar.setProgressBackgroundTintList(m21725toColorStateList8_81llA(j2));
    }

    @ComposableTarget(applier = "androidx.compose.ui.UiComposable")
    @Composable
    public static final void ComposeLinearProgressIndicator(@NotNull final LinearProgressData data, final int i, @Nullable Composer composer, final int i2, final int i4) {
        Intrinsics.checkNotNullParameter(data, "data");
        Composer composerStartRestartGroup = composer.startRestartGroup(-1754649666);
        if ((i4 & 2) != 0) {
            i = 0;
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-1754649666, i2, -1, "androidx.glance.oneui.template.component.compose.ComposeLinearProgressIndicator (ProgressIndicator.kt:74)");
        }
        if (i != 0) {
            composerStartRestartGroup.startReplaceableGroup(519954160);
            LinearProgressIndicator(data, SizeKt.m15885height3ABfNKs(SizeKt.fillMaxWidth$default(Modifier.INSTANCE, 0.0f, 1, null), PrimitiveResources_androidKt.dimensionResource(i, composerStartRestartGroup, (i2 >> 3) & 14)), composerStartRestartGroup, 8);
            composerStartRestartGroup.endReplaceableGroup();
        } else {
            composerStartRestartGroup.startReplaceableGroup(519954273);
            LinearProgressIndicator(data, SizeKt.m15885height3ABfNKs(SizeKt.fillMaxWidth$default(Modifier.INSTANCE, 0.0f, 1, null), C2256Dp.m20968constructorimpl(AppWidgetSize.m21546compareToL2j3NV4(((AppWidgetSize) composerStartRestartGroup.consume(CompositionLocalsKt.getLocalWidgetSize())).getMask(), AppWidgetSize.INSTANCE.m21569getMediumrx25Pp4()) < 0 ? 20 : 26)), composerStartRestartGroup, 8);
            composerStartRestartGroup.endReplaceableGroup();
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.glance.oneui.template.component.compose.ProgressIndicatorKt.ComposeLinearProgressIndicator.2
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(2);
                }

                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Unit invoke(Composer composer2, Integer num) {
                    invoke(composer2, num.intValue());
                    return Unit.INSTANCE;
                }

                public final void invoke(@Nullable Composer composer2, int i5) {
                    ProgressIndicatorKt.ComposeLinearProgressIndicator(data, i, composer2, RecomposeScopeImplKt.updateChangedFlags(i2 | 1), i4);
                }
            });
        }
    }
}
