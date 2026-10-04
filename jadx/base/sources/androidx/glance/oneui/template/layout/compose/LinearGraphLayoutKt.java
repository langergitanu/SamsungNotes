package androidx.glance.oneui.template.layout.compose;

import android.content.Context;
import androidx.compose.foundation.BackgroundKt;
import androidx.compose.foundation.layout.AbstractC1038a;
import androidx.compose.foundation.layout.Arrangement;
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
import androidx.compose.p109ui.unit.DpSize;
import androidx.compose.p109ui.unit.LayoutDirection;
import androidx.compose.runtime.Composable;
import androidx.compose.runtime.ComposableInferredTarget;
import androidx.compose.runtime.ComposableTarget;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.SkippableUpdater;
import androidx.compose.runtime.Updater;
import androidx.glance.AbstractC2821a;
import androidx.glance.CompositionLocalsKt;
import androidx.glance.GlanceTheme;
import androidx.glance.appwidget.util.FontUtils;
import androidx.glance.oneui.common.AppWidgetSize;
import androidx.glance.oneui.common.AppWidgetStyle;
import androidx.glance.oneui.common.GlanceLog;
import androidx.glance.oneui.template.LinearGraph;
import androidx.glance.oneui.template.LinearGraphData;
import androidx.glance.oneui.template.LinearProgressData;
import androidx.glance.oneui.template.ProgressType;
import androidx.glance.oneui.template.StackedGraphData;
import androidx.glance.oneui.template.TextData;
import androidx.glance.oneui.template.TextType;
import androidx.glance.oneui.template.TitleBarData;
import androidx.glance.oneui.template.TypedTextData;
import androidx.glance.oneui.template.TypedTextListData;
import androidx.glance.oneui.template.color.ColorProvidersKt;
import androidx.glance.oneui.template.component.compose.ProgressIndicatorKt;
import androidx.glance.oneui.template.component.compose.TextKt;
import androidx.glance.oneui.template.component.compose.TitleBarKt;
import androidx.glance.oneui.template.layout.CommonDimensions;
import androidx.glance.oneui.template.layout.GraphLayoutTextSizes;
import androidx.glance.oneui.template.layout.TextSize;
import androidx.glance.oneui.template.size.GraphTemplatePercent;
import androidx.glance.oneui.template.utils.ComposeModifierUtilsKt;
import androidx.glance.oneui.template.utils.ComposeUtilsKt;
import androidx.glance.oneui.template.utils.SmoothRoundedCornerShape;
import androidx.glance.text.FontWeight;
import androidx.glance.text.TextPercentData;
import androidx.glance.unit.ColorProvider;
import java.math.BigDecimal;
import java.util.Comparator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.comparisons.ComparisonsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import org.apache.poi.util.Units;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import p001A.AbstractC0000a;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(m13885d1 = {"\u0000j\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a4\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\tH\u0001ø\u0001\u0000¢\u0006\u0004\b\n\u0010\u000b\u001a'\u0010\f\u001a\u00020\u00012\b\b\u0002\u0010\b\u001a\u00020\t2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u0010H\u0001¢\u0006\u0002\u0010\u0011\u001as\u0010\u0012\u001a\u00020\u00012\u0006\u0010\u0013\u001a\u00020\u00142\u0013\u0010\u0015\u001a\u000f\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u0016¢\u0006\u0002\b\u00172\u0013\u0010\u0018\u001a\u000f\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u0016¢\u0006\u0002\b\u00172\u0013\u0010\u0019\u001a\u000f\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u0016¢\u0006\u0002\b\u00172\b\u0010\u001a\u001a\u0004\u0018\u00010\u001b2\u0013\u0010\u001c\u001a\u000f\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u0016¢\u0006\u0002\b\u0017H\u0001¢\u0006\u0002\u0010\u001d\u001a\u001f\u0010\u001e\u001a\u00020\u00012\b\b\u0002\u0010\b\u001a\u00020\t2\u0006\u0010\u0013\u001a\u00020\u001fH\u0001¢\u0006\u0002\u0010 \u001a\u001f\u0010\u001e\u001a\u00020\u00012\u0006\u0010\u0013\u001a\u00020\u001f2\b\b\u0002\u0010!\u001a\u00020\"H\u0007¢\u0006\u0002\u0010#\u001a}\u0010$\u001a\u00020\u00012\b\b\u0002\u0010\b\u001a\u00020\t2\u0006\u0010\u0013\u001a\u00020\u00142\b\u0010\u001a\u001a\u0004\u0018\u00010\u001b2\u0013\u0010\u0015\u001a\u000f\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u0016¢\u0006\u0002\b\u00172\u0013\u0010\u001c\u001a\u000f\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u0016¢\u0006\u0002\b\u00172\u0013\u0010\u0018\u001a\u000f\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u0016¢\u0006\u0002\b\u00172\u0013\u0010\u0019\u001a\u000f\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u0016¢\u0006\u0002\b\u0017H\u0003¢\u0006\u0002\u0010%\u001a4\u0010&\u001a\u00020\u00012\b\b\u0002\u0010\b\u001a\u00020\t2\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010'\u001a\u00020(H\u0003ø\u0001\u0000¢\u0006\u0004\b)\u0010*\u001aS\u0010+\u001a\u00020\u00012\b\b\u0002\u0010\b\u001a\u00020\t2\u0006\u0010\u0013\u001a\u00020\u00142\b\u0010\u001a\u001a\u0004\u0018\u00010\u001b2\u0013\u0010\u0015\u001a\u000f\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u0016¢\u0006\u0002\b\u00172\u0013\u0010\u001c\u001a\u000f\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u0016¢\u0006\u0002\b\u0017H\u0003¢\u0006\u0002\u0010,\u001a4\u0010-\u001a\u00020\u00012\b\b\u0002\u0010\b\u001a\u00020\t2\u0006\u0010\u0013\u001a\u00020\u00142\u0013\u0010\u0015\u001a\u000f\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u0016¢\u0006\u0002\b\u0017H\u0003¢\u0006\u0002\u0010.\u001a\u001f\u0010/\u001a\u00020\u00012\b\b\u0002\u0010\b\u001a\u00020\t2\u0006\u0010\u0013\u001a\u00020\u001fH\u0003¢\u0006\u0002\u0010 \u001as\u00100\u001a\u00020\u00012\u0006\u0010\u0013\u001a\u00020\u00142\u0013\u0010\u0015\u001a\u000f\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u0016¢\u0006\u0002\b\u00172\u0013\u0010\u0018\u001a\u000f\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u0016¢\u0006\u0002\b\u00172\u0013\u0010\u0019\u001a\u000f\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u0016¢\u0006\u0002\b\u00172\b\u0010\u001a\u001a\u0004\u0018\u00010\u001b2\u0013\u0010\u001c\u001a\u000f\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u0016¢\u0006\u0002\b\u0017H\u0003¢\u0006\u0002\u0010\u001d\u001a*\u00101\u001a\u00020\u00012\u0006\u0010\u0013\u001a\u00020\u00142\u0013\u0010\u0015\u001a\u000f\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u0016¢\u0006\u0002\b\u0017H\u0003¢\u0006\u0002\u00102\u001a\u0019\u00103\u001a\u00020\u0007*\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u0007H\u0003¢\u0006\u0002\u00104\u001a\u001e\u00105\u001a\u000206*\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0003ø\u0001\u0000¢\u0006\u0004\b7\u00108\u0082\u0002\u0007\n\u0005\b¡\u001e0\u0001¨\u00069"}, m13886d2 = {"ComposeGraphText", "", "textData", "Landroidx/glance/oneui/template/TextData;", "textType", "Landroidx/glance/oneui/template/TextType;", "defaultTextColor", "Landroidx/glance/unit/ColorProvider;", "modifier", "Landroidx/compose/ui/Modifier;", "ComposeGraphText-lL68QWg", "(Landroidx/glance/oneui/template/TextData;ILandroidx/glance/unit/ColorProvider;Landroidx/compose/ui/Modifier;Landroidx/compose/runtime/Composer;II)V", "ComposeGraphTextList", "textListData", "Landroidx/glance/oneui/template/TypedTextListData;", "isVertical", "", "(Landroidx/compose/ui/Modifier;Landroidx/glance/oneui/template/TypedTextListData;ZLandroidx/compose/runtime/Composer;II)V", "ComposeLinearGraphLayout", "data", "Landroidx/glance/oneui/template/LinearGraphData;", "headlineContent", "Lkotlin/Function0;", "Landroidx/compose/runtime/Composable;", "descriptionContent", "detailGraphContent", "titleBar", "Landroidx/glance/oneui/template/TitleBarData;", "subtitleContent", "(Landroidx/glance/oneui/template/LinearGraphData;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Landroidx/glance/oneui/template/TitleBarData;Lkotlin/jvm/functions/Function2;Landroidx/compose/runtime/Composer;I)V", "ComposeStackedGraph", "Landroidx/glance/oneui/template/StackedGraphData;", "(Landroidx/compose/ui/Modifier;Landroidx/glance/oneui/template/StackedGraphData;Landroidx/compose/runtime/Composer;II)V", "linearGraphSizeResId", "", "(Landroidx/glance/oneui/template/StackedGraphData;ILandroidx/compose/runtime/Composer;II)V", "LargeLayoutContent", "(Landroidx/compose/ui/Modifier;Landroidx/glance/oneui/template/LinearGraphData;Landroidx/glance/oneui/template/TitleBarData;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Landroidx/compose/runtime/Composer;II)V", "LinearGraphText", "textSize", "Landroidx/compose/ui/unit/Dp;", "LinearGraphText--jt2gSs", "(Landroidx/compose/ui/Modifier;Landroidx/glance/oneui/template/TextData;Landroidx/glance/unit/ColorProvider;FLandroidx/compose/runtime/Composer;II)V", "MediumLayoutContent", "(Landroidx/compose/ui/Modifier;Landroidx/glance/oneui/template/LinearGraphData;Landroidx/glance/oneui/template/TitleBarData;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Landroidx/compose/runtime/Composer;II)V", "SmallLayoutContent", "(Landroidx/compose/ui/Modifier;Landroidx/glance/oneui/template/LinearGraphData;Lkotlin/jvm/functions/Function2;Landroidx/compose/runtime/Composer;II)V", "StackedGraph", "WidgetLayoutMediumAndLarge", "WidgetLayoutSmall", "(Landroidx/glance/oneui/template/LinearGraphData;Lkotlin/jvm/functions/Function2;Landroidx/compose/runtime/Composer;I)V", "getTextColor", "(Landroidx/glance/oneui/template/TextData;Landroidx/glance/unit/ColorProvider;Landroidx/compose/runtime/Composer;I)Landroidx/glance/unit/ColorProvider;", "getTextSize", "Landroidx/glance/oneui/template/layout/TextSize;", "getTextSize-DLfFjGE", "(Landroidx/glance/oneui/template/TextData;ILandroidx/compose/runtime/Composer;I)Landroidx/glance/oneui/template/layout/TextSize;", "glance-oneui-template_release"}, m13887k = 2, m13888mv = {1, 9, 0}, m13890xi = 48)
@SourceDebugExtension({"SMAP\nLinearGraphLayout.kt\nKotlin\n*S Kotlin\n*F\n+ 1 LinearGraphLayout.kt\nandroidx/glance/oneui/template/layout/compose/LinearGraphLayoutKt\n+ 2 CompositionLocal.kt\nandroidx/compose/runtime/CompositionLocal\n+ 3 Column.kt\nandroidx/compose/foundation/layout/ColumnKt\n+ 4 Layout.kt\nandroidx/compose/ui/layout/LayoutKt\n+ 5 Composables.kt\nandroidx/compose/runtime/ComposablesKt\n+ 6 Dp.kt\nandroidx/compose/ui/unit/DpKt\n+ 7 Row.kt\nandroidx/compose/foundation/layout/RowKt\n+ 8 fake.kt\nkotlin/jvm/internal/FakeKt\n+ 9 Box.kt\nandroidx/compose/foundation/layout/BoxKt\n+ 10 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n+ 11 Dp.kt\nandroidx/compose/ui/unit/Dp\n*L\n1#1,534:1\n74#2:535\n76#2:539\n74#2:573\n76#2:579\n76#2:612\n76#2:657\n76#2:690\n76#2:727\n74#2:765\n76#2:773\n76#2:806\n74#2:832\n74#2:841\n74#2:848\n74#2:849\n74#2:850\n76#2:858\n76#2:896\n76#2:935\n76#2:970\n76#2:1013\n76#2:1046\n76#2:1084\n78#3,2:536\n80#3:564\n84#3:572\n78#3,2:576\n80#3:604\n84#3:649\n74#3,6:650\n80#3:682\n75#3,5:721\n80#3:752\n84#3:758\n84#3:763\n74#3,6:851\n80#3:883\n84#3:888\n74#3,6:1006\n80#3:1038\n84#3:1119\n75#4:538\n76#4,11:540\n89#4:571\n75#4:578\n76#4,11:580\n75#4:611\n76#4,11:613\n89#4:642\n89#4:648\n75#4:656\n76#4,11:658\n75#4:689\n76#4,11:691\n89#4:719\n75#4:726\n76#4,11:728\n89#4:757\n89#4:762\n75#4:772\n76#4,11:774\n75#4:805\n76#4,11:807\n89#4:836\n89#4:846\n75#4:857\n76#4,11:859\n89#4:887\n75#4:895\n76#4,11:897\n89#4:926\n75#4:934\n76#4,11:936\n75#4:969\n76#4,11:971\n89#4:999\n89#4:1004\n75#4:1012\n76#4,11:1014\n75#4:1045\n76#4,11:1047\n89#4:1075\n75#4:1083\n76#4,11:1085\n89#4:1113\n89#4:1118\n460#5,13:551\n473#5,3:568\n460#5,13:591\n460#5,13:624\n473#5,3:639\n473#5,3:645\n460#5,13:669\n460#5,13:702\n473#5,3:716\n460#5,13:739\n473#5,3:754\n473#5,3:759\n460#5,13:785\n460#5,13:818\n473#5,3:833\n473#5,3:843\n460#5,13:870\n473#5,3:884\n460#5,13:908\n473#5,3:923\n460#5,13:947\n460#5,13:982\n473#5,3:996\n473#5,3:1001\n460#5,13:1025\n460#5,13:1058\n473#5,3:1072\n460#5,13:1096\n473#5,3:1110\n473#5,3:1115\n154#6:565\n154#6:566\n154#6:567\n154#6:574\n154#6:575\n154#6:644\n154#6:753\n154#6:764\n154#6:922\n154#6:961\n154#6:962\n75#7,6:605\n81#7:637\n85#7:643\n75#7,6:683\n81#7:715\n85#7:720\n75#7,6:889\n81#7:921\n85#7:927\n75#7,6:928\n81#7:960\n85#7:1005\n75#7,6:1039\n81#7:1071\n85#7:1076\n75#7,6:1077\n81#7:1109\n85#7:1114\n1#8:638\n67#9,6:766\n73#9:798\n67#9,6:799\n73#9:831\n77#9:837\n77#9:847\n67#9,6:963\n73#9:995\n77#9:1000\n1054#10:838\n1864#10,2:839\n1866#10:842\n88#11:1120\n*S KotlinDebug\n*F\n+ 1 LinearGraphLayout.kt\nandroidx/glance/oneui/template/layout/compose/LinearGraphLayoutKt\n*L\n69#1:535\n100#1:539\n142#1:573\n179#1:579\n184#1:612\n266#1:657\n268#1:690\n272#1:727\n329#1:765\n325#1:773\n345#1:806\n351#1:832\n388#1:841\n414#1:848\n415#1:849\n416#1:850\n441#1:858\n461#1:896\n233#1:935\n244#1:970\n254#1:1013\n255#1:1046\n256#1:1084\n100#1:536,2\n100#1:564\n100#1:572\n179#1:576,2\n179#1:604\n179#1:649\n266#1:650,6\n266#1:682\n272#1:721,5\n272#1:752\n272#1:758\n266#1:763\n441#1:851,6\n441#1:883\n441#1:888\n254#1:1006,6\n254#1:1038\n254#1:1119\n100#1:538\n100#1:540,11\n100#1:571\n179#1:578\n179#1:580,11\n184#1:611\n184#1:613,11\n184#1:642\n179#1:648\n266#1:656\n266#1:658,11\n268#1:689\n268#1:691,11\n268#1:719\n272#1:726\n272#1:728,11\n272#1:757\n266#1:762\n325#1:772\n325#1:774,11\n345#1:805\n345#1:807,11\n345#1:836\n325#1:846\n441#1:857\n441#1:859,11\n441#1:887\n461#1:895\n461#1:897,11\n461#1:926\n233#1:934\n233#1:936,11\n244#1:969\n244#1:971,11\n244#1:999\n233#1:1004\n254#1:1012\n254#1:1014,11\n255#1:1045\n255#1:1047,11\n255#1:1075\n256#1:1083\n256#1:1085,11\n256#1:1113\n254#1:1118\n100#1:551,13\n100#1:568,3\n179#1:591,13\n184#1:624,13\n184#1:639,3\n179#1:645,3\n266#1:669,13\n268#1:702,13\n268#1:716,3\n272#1:739,13\n272#1:754,3\n266#1:759,3\n325#1:785,13\n345#1:818,13\n345#1:833,3\n325#1:843,3\n441#1:870,13\n441#1:884,3\n461#1:908,13\n461#1:923,3\n233#1:947,13\n244#1:982,13\n244#1:996,3\n233#1:1001,3\n254#1:1025,13\n255#1:1058,13\n255#1:1072,3\n256#1:1096,13\n256#1:1110,3\n254#1:1115,3\n105#1:565\n115#1:566\n129#1:567\n146#1:574\n156#1:575\n197#1:644\n289#1:753\n318#1:764\n473#1:922\n243#1:961\n244#1:962\n184#1:605,6\n184#1:637\n184#1:643\n268#1:683,6\n268#1:715\n268#1:720\n461#1:889,6\n461#1:921\n461#1:927\n233#1:928,6\n233#1:960\n233#1:1005\n255#1:1039,6\n255#1:1071\n255#1:1076\n256#1:1077,6\n256#1:1109\n256#1:1114\n325#1:766,6\n325#1:798\n345#1:799,6\n345#1:831\n345#1:837\n325#1:847\n244#1:963,6\n244#1:995\n244#1:1000\n381#1:838\n383#1:839,2\n383#1:842\n429#1:1120\n*E\n"})
public final class LinearGraphLayoutKt {
    @ComposableTarget(applier = "androidx.compose.ui.UiComposable")
    @Composable
    /* JADX INFO: renamed from: ComposeGraphText-lL68QWg, reason: not valid java name */
    public static final void m21800ComposeGraphTextlL68QWg(@NotNull final TextData textData, final int i, @NotNull final ColorProvider defaultTextColor, @Nullable Modifier modifier, @Nullable Composer composer, final int i2, final int i4) {
        Intrinsics.checkNotNullParameter(textData, "textData");
        Intrinsics.checkNotNullParameter(defaultTextColor, "defaultTextColor");
        Composer composerStartRestartGroup = composer.startRestartGroup(1832960492);
        Modifier modifier2 = (i4 & 8) != 0 ? Modifier.INSTANCE : modifier;
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(1832960492, i2, -1, "androidx.glance.oneui.template.layout.compose.ComposeGraphText (LinearGraphLayout.kt:509)");
        }
        TextKt.ComposeText(textData, m21803getTextSizeDLfFjGE(textData, i, composerStartRestartGroup, (i2 & 112) | 8), getTextColor(textData, defaultTextColor, composerStartRestartGroup, 72), modifier2, composerStartRestartGroup, (TextPercentData.$stable << 3) | 520 | (i2 & 7168), 0);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            final Modifier modifier3 = modifier2;
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.glance.oneui.template.layout.compose.LinearGraphLayoutKt$ComposeGraphText$1
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
                    LinearGraphLayoutKt.m21800ComposeGraphTextlL68QWg(textData, i, defaultTextColor, modifier3, composer2, RecomposeScopeImplKt.updateChangedFlags(i2 | 1), i4);
                }
            });
        }
    }

    @ComposableTarget(applier = "androidx.glance.GlanceComposable")
    @Composable
    public static final void ComposeGraphTextList(@Nullable Modifier modifier, @NotNull final TypedTextListData textListData, final boolean z, @Nullable Composer composer, final int i, final int i2) {
        int i4;
        Modifier modifierM21958paddings2pLCVw;
        Intrinsics.checkNotNullParameter(textListData, "textListData");
        Composer composerStartRestartGroup = composer.startRestartGroup(747119523);
        final Modifier modifier2 = (i2 & 1) != 0 ? Modifier.INSTANCE : modifier;
        if (ComposerKt.isTraceInProgress()) {
            i4 = i;
            ComposerKt.traceEventStart(747119523, i4, -1, "androidx.glance.oneui.template.layout.compose.ComposeGraphTextList (LinearGraphLayout.kt:408)");
        } else {
            i4 = i;
        }
        List<TypedTextData> items = textListData.getItems();
        if (items.isEmpty()) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup != null) {
                final int i5 = i4;
                scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.glance.oneui.template.layout.compose.LinearGraphLayoutKt.ComposeGraphTextList.1
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
                        LinearGraphLayoutKt.ComposeGraphTextList(modifier2, textListData, z, composer2, RecomposeScopeImplKt.updateChangedFlags(i5 | 1), i2);
                    }
                });
                return;
            }
            return;
        }
        final Modifier modifier3 = modifier2;
        Context context = (Context) composerStartRestartGroup.consume(AndroidCompositionLocals_androidKt.getLocalContext());
        long packedValue = ((DpSize) composerStartRestartGroup.consume(CompositionLocalsKt.getLocalSize())).getPackedValue();
        int mask = ((AppWidgetSize) composerStartRestartGroup.consume(androidx.glance.oneui.template.CompositionLocalsKt.getLocalWidgetSize())).getMask();
        ColorProvider onBackground = GlanceTheme.INSTANCE.getColors(composerStartRestartGroup, GlanceTheme.$stable).getOnBackground();
        if (z) {
            composerStartRestartGroup.startReplaceableGroup(-996845255);
            composerStartRestartGroup.startReplaceableGroup(-483455358);
            MeasurePolicy measurePolicyM1209j = AbstractC1038a.m1209j(Alignment.INSTANCE, Arrangement.INSTANCE.getTop(), composerStartRestartGroup, 0, -1323940314);
            Density density = (Density) composerStartRestartGroup.consume(androidx.compose.p109ui.platform.CompositionLocalsKt.getLocalDensity());
            LayoutDirection layoutDirection = (LayoutDirection) composerStartRestartGroup.consume(androidx.compose.p109ui.platform.CompositionLocalsKt.getLocalLayoutDirection());
            ViewConfiguration viewConfiguration = (ViewConfiguration) composerStartRestartGroup.consume(androidx.compose.p109ui.platform.CompositionLocalsKt.getLocalViewConfiguration());
            ComposeUiNode.Companion companion = ComposeUiNode.INSTANCE;
            Function0<ComposeUiNode> constructor = companion.getConstructor();
            Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> function3MaterializerOf = LayoutKt.materializerOf(modifier3);
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
            Updater.m18025setimpl(composerM18018constructorimpl, layoutDirection, (Function2<? super T, ? super LayoutDirection, Unit>) AbstractC1038a.m1219t(companion, composerM18018constructorimpl, measurePolicyM1209j, composerM18018constructorimpl, density));
            function3MaterializerOf.invoke(AbstractC1038a.m1206g(companion, composerM18018constructorimpl, viewConfiguration, composerStartRestartGroup, composerStartRestartGroup), composerStartRestartGroup, 0);
            composerStartRestartGroup.startReplaceableGroup(2058660585);
            ColumnScopeInstance columnScopeInstance = ColumnScopeInstance.INSTANCE;
            TypedTextData typedTextData = items.get(0);
            float fComposeGraphTextList$getTextSize = ComposeGraphTextList$getTextSize(mask, packedValue, context, typedTextData);
            m21801LinearGraphTextjt2gSs(null, typedTextData, onBackground, fComposeGraphTextList$getTextSize, composerStartRestartGroup, 512, 1);
            composerStartRestartGroup.startReplaceableGroup(-996844945);
            if (items.size() > 1) {
                TypedTextData typedTextData2 = items.get(1);
                ComposeGraphTextList$getTextSize(mask, packedValue, context, typedTextData2);
                m21801LinearGraphTextjt2gSs(null, typedTextData2, onBackground, fComposeGraphTextList$getTextSize, composerStartRestartGroup, 512, 1);
            }
            composerStartRestartGroup.endReplaceableGroup();
            composerStartRestartGroup.endReplaceableGroup();
            composerStartRestartGroup.endNode();
            composerStartRestartGroup.endReplaceableGroup();
            composerStartRestartGroup.endReplaceableGroup();
            composerStartRestartGroup.endReplaceableGroup();
        } else {
            composerStartRestartGroup.startReplaceableGroup(-996844574);
            composerStartRestartGroup.startReplaceableGroup(693286680);
            MeasurePolicy measurePolicyM1208i = AbstractC1038a.m1208i(Alignment.INSTANCE, Arrangement.INSTANCE.getStart(), composerStartRestartGroup, 0, -1323940314);
            Density density2 = (Density) composerStartRestartGroup.consume(androidx.compose.p109ui.platform.CompositionLocalsKt.getLocalDensity());
            LayoutDirection layoutDirection2 = (LayoutDirection) composerStartRestartGroup.consume(androidx.compose.p109ui.platform.CompositionLocalsKt.getLocalLayoutDirection());
            ViewConfiguration viewConfiguration2 = (ViewConfiguration) composerStartRestartGroup.consume(androidx.compose.p109ui.platform.CompositionLocalsKt.getLocalViewConfiguration());
            ComposeUiNode.Companion companion2 = ComposeUiNode.INSTANCE;
            Function0<ComposeUiNode> constructor2 = companion2.getConstructor();
            Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> function3MaterializerOf2 = LayoutKt.materializerOf(modifier3);
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
            Updater.m18025setimpl(composerM18018constructorimpl2, layoutDirection2, (Function2<? super T, ? super LayoutDirection, Unit>) AbstractC1038a.m1219t(companion2, composerM18018constructorimpl2, measurePolicyM1208i, composerM18018constructorimpl2, density2));
            function3MaterializerOf2.invoke(AbstractC1038a.m1206g(companion2, composerM18018constructorimpl2, viewConfiguration2, composerStartRestartGroup, composerStartRestartGroup), composerStartRestartGroup, 0);
            composerStartRestartGroup.startReplaceableGroup(2058660585);
            RowScopeInstance rowScopeInstance = RowScopeInstance.INSTANCE;
            TypedTextData typedTextData3 = items.get(0);
            m21801LinearGraphTextjt2gSs(null, typedTextData3, onBackground, ComposeGraphTextList$getTextSize(mask, packedValue, context, typedTextData3), composerStartRestartGroup, 512, 1);
            composerStartRestartGroup.startReplaceableGroup(-996844267);
            if (items.size() > 1) {
                TypedTextData typedTextData4 = items.get(1);
                float fComposeGraphTextList$getTextSize2 = ComposeGraphTextList$getTextSize(mask, packedValue, context, typedTextData4);
                composerStartRestartGroup.startReplaceableGroup(1519946193);
                if (AppWidgetSize.m21546compareToL2j3NV4(mask, AppWidgetSize.INSTANCE.m21568getLargerx25Pp4()) >= 0) {
                    SpacerKt.Spacer(SizeKt.m15899size3ABfNKs(Modifier.INSTANCE, C2256Dp.m20968constructorimpl(2)), composerStartRestartGroup, 6);
                }
                composerStartRestartGroup.endReplaceableGroup();
                composerStartRestartGroup.startReplaceableGroup(1519946399);
                if (TextType.m21684equalsimpl0(typedTextData3.getTextType(), TextType.INSTANCE.m21693getLabelgxbDmow())) {
                    modifierM21958paddings2pLCVw = ComposeModifierUtilsKt.m21958paddings2pLCVw(Modifier.INSTANCE, 0.0f, 0.0f, 0.0f, 0.05f, 0.0f, 0.0f, 0.0f, 0.0f, composerStartRestartGroup, 24582, 247);
                    composerStartRestartGroup = composerStartRestartGroup;
                } else {
                    modifierM21958paddings2pLCVw = Modifier.INSTANCE;
                }
                composerStartRestartGroup.endReplaceableGroup();
                m21801LinearGraphTextjt2gSs(modifierM21958paddings2pLCVw, typedTextData4, onBackground, fComposeGraphTextList$getTextSize2, composerStartRestartGroup, 512, 0);
            }
            composerStartRestartGroup.endReplaceableGroup();
            composerStartRestartGroup.endReplaceableGroup();
            composerStartRestartGroup.endNode();
            composerStartRestartGroup.endReplaceableGroup();
            composerStartRestartGroup.endReplaceableGroup();
            composerStartRestartGroup.endReplaceableGroup();
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup2 = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup2 != null) {
            scopeUpdateScopeEndRestartGroup2.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.glance.oneui.template.layout.compose.LinearGraphLayoutKt.ComposeGraphTextList.4
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
                    LinearGraphLayoutKt.ComposeGraphTextList(modifier3, textListData, z, composer2, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
                }
            });
        }
    }

    private static final float ComposeGraphTextList$getTextSize(int i, long j, Context context, TypedTextData typedTextData) {
        GraphTemplatePercent.LinearGraphText linearGraphText = GraphTemplatePercent.LinearGraphText.INSTANCE;
        float fM21948getTextViewSizetZlUyYw = linearGraphText.m21948getTextViewSizetZlUyYw(i, typedTextData.getTextType(), typedTextData.getMaxLines());
        Pair<Float, Float> pairM21947getMinMaxTextSizetEsvO4U = linearGraphText.m21947getMinMaxTextSizetEsvO4U(i, typedTextData.getTextType());
        float fM21066getWidthD9Ej5fM = DpSize.m21066getWidthD9Ej5fM(j);
        float fM20968constructorimpl = C2256Dp.m20968constructorimpl(DpSize.m21064getHeightD9Ej5fM(j) * fM21948getTextViewSizetZlUyYw);
        FontUtils fontUtils = FontUtils.INSTANCE;
        String text = typedTextData.getText();
        if (text == null) {
            text = "";
        }
        return FontUtils.m21405autoTextSizeByDpYusz2Y$default(fontUtils, context, text, fM21066getWidthD9Ej5fM, fM20968constructorimpl, pairM21947getMinMaxTextSizetEsvO4U.getFirst().floatValue(), pairM21947getMinMaxTextSizetEsvO4U.getSecond().floatValue(), null, 0, false, 0, 960, null);
    }

    @Composable
    @ComposableInferredTarget(scheme = "[androidx.compose.ui.UiComposable[androidx.compose.ui.UiComposable][androidx.compose.ui.UiComposable][androidx.compose.ui.UiComposable][androidx.compose.ui.UiComposable]]")
    public static final void ComposeLinearGraphLayout(@NotNull final LinearGraphData data, @Nullable final Function2<? super Composer, ? super Integer, Unit> function2, @Nullable final Function2<? super Composer, ? super Integer, Unit> function22, @Nullable final Function2<? super Composer, ? super Integer, Unit> function23, @Nullable final TitleBarData titleBarData, @Nullable final Function2<? super Composer, ? super Integer, Unit> function24, @Nullable Composer composer, final int i) {
        Intrinsics.checkNotNullParameter(data, "data");
        Composer composerStartRestartGroup = composer.startRestartGroup(-413924643);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-413924643, i, -1, "androidx.glance.oneui.template.layout.compose.ComposeLinearGraphLayout (LinearGraphLayout.kt:67)");
        }
        if (AppWidgetSize.m21546compareToL2j3NV4(((AppWidgetSize) composerStartRestartGroup.consume(androidx.glance.oneui.template.CompositionLocalsKt.getLocalWidgetSize())).getMask(), AppWidgetSize.INSTANCE.m21569getMediumrx25Pp4()) < 0) {
            composerStartRestartGroup.startReplaceableGroup(-269387936);
            WidgetLayoutSmall(data, function2, composerStartRestartGroup, (i & 112) | 8);
            composerStartRestartGroup.endReplaceableGroup();
        } else {
            composerStartRestartGroup.startReplaceableGroup(-269387874);
            WidgetLayoutMediumAndLarge(data, function2, function22, function23, titleBarData, function24, composerStartRestartGroup, 32776 | (i & 112) | (i & 896) | (i & 7168) | (458752 & i));
            composerStartRestartGroup.endReplaceableGroup();
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.glance.oneui.template.layout.compose.LinearGraphLayoutKt.ComposeLinearGraphLayout.1
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                /* JADX WARN: Multi-variable type inference failed */
                {
                    super(2);
                }

                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Unit invoke(Composer composer2, Integer num) {
                    invoke(composer2, num.intValue());
                    return Unit.INSTANCE;
                }

                public final void invoke(@Nullable Composer composer2, int i2) {
                    LinearGraphLayoutKt.ComposeLinearGraphLayout(data, function2, function22, function23, titleBarData, function24, composer2, RecomposeScopeImplKt.updateChangedFlags(i | 1));
                }
            });
        }
    }

    @ComposableTarget(applier = "androidx.glance.GlanceComposable")
    @Composable
    public static final void ComposeStackedGraph(@Nullable final Modifier modifier, @NotNull final StackedGraphData data, @Nullable Composer composer, final int i, final int i2) {
        Intrinsics.checkNotNullParameter(data, "data");
        Composer composerStartRestartGroup = composer.startRestartGroup(-97695757);
        if ((i2 & 1) != 0) {
            modifier = Modifier.INSTANCE;
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-97695757, i, -1, "androidx.glance.oneui.template.layout.compose.ComposeStackedGraph (LinearGraphLayout.kt:307)");
        }
        StackedGraph(modifier, data, composerStartRestartGroup, (i & 14) | 64, 0);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.glance.oneui.template.layout.compose.LinearGraphLayoutKt.ComposeStackedGraph.1
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
                    LinearGraphLayoutKt.ComposeStackedGraph(modifier, data, composer2, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    @Composable
    @ComposableInferredTarget(scheme = "[androidx.compose.ui.UiComposable[androidx.compose.ui.UiComposable][androidx.compose.ui.UiComposable][androidx.compose.ui.UiComposable][androidx.compose.ui.UiComposable]]")
    public static final void LargeLayoutContent(Modifier modifier, final LinearGraphData linearGraphData, final TitleBarData titleBarData, final Function2<? super Composer, ? super Integer, Unit> function2, final Function2<? super Composer, ? super Integer, Unit> function22, final Function2<? super Composer, ? super Integer, Unit> function23, final Function2<? super Composer, ? super Integer, Unit> function24, Composer composer, final int i, final int i2) {
        int i4;
        Object obj;
        int i5;
        Composer composerStartRestartGroup = composer.startRestartGroup(-1421343841);
        Modifier modifier2 = (i2 & 1) != 0 ? Modifier.INSTANCE : modifier;
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-1421343841, i, -1, "androidx.glance.oneui.template.layout.compose.LargeLayoutContent (LinearGraphLayout.kt:222)");
        }
        float fM21946getGraphSizeL2j3NV4 = GraphTemplatePercent.LinearGraph.INSTANCE.m21946getGraphSizeL2j3NV4(AppWidgetSize.INSTANCE.m21568getLargerx25Pp4());
        Alignment.Companion companion = Alignment.INSTANCE;
        Alignment.Horizontal centerHorizontally = companion.getCenterHorizontally();
        composerStartRestartGroup.startReplaceableGroup(-483455358);
        Arrangement arrangement = Arrangement.INSTANCE;
        MeasurePolicy measurePolicyColumnMeasurePolicy = ColumnKt.columnMeasurePolicy(arrangement.getTop(), centerHorizontally, composerStartRestartGroup, 48);
        composerStartRestartGroup.startReplaceableGroup(-1323940314);
        Density density = (Density) composerStartRestartGroup.consume(androidx.compose.p109ui.platform.CompositionLocalsKt.getLocalDensity());
        LayoutDirection layoutDirection = (LayoutDirection) composerStartRestartGroup.consume(androidx.compose.p109ui.platform.CompositionLocalsKt.getLocalLayoutDirection());
        ViewConfiguration viewConfiguration = (ViewConfiguration) composerStartRestartGroup.consume(androidx.compose.p109ui.platform.CompositionLocalsKt.getLocalViewConfiguration());
        ComposeUiNode.Companion companion2 = ComposeUiNode.INSTANCE;
        Function0<ComposeUiNode> constructor = companion2.getConstructor();
        Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> function3MaterializerOf = LayoutKt.materializerOf(modifier2);
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
        Updater.m18025setimpl(composerM18018constructorimpl, layoutDirection, (Function2<? super T, ? super LayoutDirection, Unit>) AbstractC1038a.m1219t(companion2, composerM18018constructorimpl, measurePolicyColumnMeasurePolicy, composerM18018constructorimpl, density));
        function3MaterializerOf.invoke(AbstractC1038a.m1206g(companion2, composerM18018constructorimpl, viewConfiguration, composerStartRestartGroup, composerStartRestartGroup), composerStartRestartGroup, 0);
        composerStartRestartGroup.startReplaceableGroup(2058660585);
        ColumnScopeInstance columnScopeInstance = ColumnScopeInstance.INSTANCE;
        composerStartRestartGroup.startReplaceableGroup(-2065736836);
        if (titleBarData != null && function23 != null) {
            Modifier modifierWrapContentHeight$default = SizeKt.wrapContentHeight$default(SizeKt.fillMaxWidth$default(Modifier.INSTANCE, 0.0f, 1, null), null, false, 3, null);
            composerStartRestartGroup.startReplaceableGroup(693286680);
            MeasurePolicy measurePolicyM1208i = AbstractC1038a.m1208i(companion, arrangement.getStart(), composerStartRestartGroup, 0, -1323940314);
            Density density2 = (Density) composerStartRestartGroup.consume(androidx.compose.p109ui.platform.CompositionLocalsKt.getLocalDensity());
            LayoutDirection layoutDirection2 = (LayoutDirection) composerStartRestartGroup.consume(androidx.compose.p109ui.platform.CompositionLocalsKt.getLocalLayoutDirection());
            ViewConfiguration viewConfiguration2 = (ViewConfiguration) composerStartRestartGroup.consume(androidx.compose.p109ui.platform.CompositionLocalsKt.getLocalViewConfiguration());
            Function0<ComposeUiNode> constructor2 = companion2.getConstructor();
            Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> function3MaterializerOf2 = LayoutKt.materializerOf(modifierWrapContentHeight$default);
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
            Updater.m18025setimpl(composerM18018constructorimpl2, layoutDirection2, (Function2<? super T, ? super LayoutDirection, Unit>) AbstractC1038a.m1219t(companion2, composerM18018constructorimpl2, measurePolicyM1208i, composerM18018constructorimpl2, density2));
            function3MaterializerOf2.invoke(AbstractC1038a.m1206g(companion2, composerM18018constructorimpl2, viewConfiguration2, composerStartRestartGroup, composerStartRestartGroup), composerStartRestartGroup, 0);
            composerStartRestartGroup.startReplaceableGroup(2058660585);
            RowScopeInstance rowScopeInstance = RowScopeInstance.INSTANCE;
            TitleBarKt.ComposeContent(titleBarData, function22, ComposableSingletons$LinearGraphLayoutKt.INSTANCE.m21791getLambda2$glance_oneui_template_release(), composerStartRestartGroup, ((i >> 9) & 112) | 392);
            composerStartRestartGroup.endReplaceableGroup();
            composerStartRestartGroup.endNode();
            composerStartRestartGroup.endReplaceableGroup();
            composerStartRestartGroup.endReplaceableGroup();
        }
        composerStartRestartGroup.endReplaceableGroup();
        Modifier.Companion companion3 = Modifier.INSTANCE;
        Modifier modifierFillMaxSize$default = SizeKt.fillMaxSize$default(SizeKt.fillMaxWidth$default(companion3, 0.0f, 1, null), 0.0f, 1, null);
        Arrangement.Vertical bottom = arrangement.getBottom();
        composerStartRestartGroup.startReplaceableGroup(-483455358);
        MeasurePolicy measurePolicyM1209j = AbstractC1038a.m1209j(companion, bottom, composerStartRestartGroup, 6, -1323940314);
        Density density3 = (Density) composerStartRestartGroup.consume(androidx.compose.p109ui.platform.CompositionLocalsKt.getLocalDensity());
        LayoutDirection layoutDirection3 = (LayoutDirection) composerStartRestartGroup.consume(androidx.compose.p109ui.platform.CompositionLocalsKt.getLocalLayoutDirection());
        ViewConfiguration viewConfiguration3 = (ViewConfiguration) composerStartRestartGroup.consume(androidx.compose.p109ui.platform.CompositionLocalsKt.getLocalViewConfiguration());
        Function0<ComposeUiNode> constructor3 = companion2.getConstructor();
        Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> function3MaterializerOf3 = LayoutKt.materializerOf(modifierFillMaxSize$default);
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
        Updater.m18025setimpl(composerM18018constructorimpl3, layoutDirection3, (Function2<? super T, ? super LayoutDirection, Unit>) AbstractC1038a.m1219t(companion2, composerM18018constructorimpl3, measurePolicyM1209j, composerM18018constructorimpl3, density3));
        function3MaterializerOf3.invoke(AbstractC1038a.m1206g(companion2, composerM18018constructorimpl3, viewConfiguration3, composerStartRestartGroup, composerStartRestartGroup), composerStartRestartGroup, 0);
        composerStartRestartGroup.startReplaceableGroup(2058660585);
        if (function24 != null) {
            composerStartRestartGroup.startReplaceableGroup(578042669);
            obj = null;
            i5 = 1;
            i4 = 6;
            LargeLayoutContent$DetailGraphContent(linearGraphData, ColumnScope.weight$default(columnScopeInstance, SizeKt.fillMaxWidth$default(companion3, 0.0f, 1, null), 1.0f, false, 2, null), function24, function2, composerStartRestartGroup, ((i >> 15) & 112) | ((i >> 3) & 896), 0);
            composerStartRestartGroup.endReplaceableGroup();
        } else {
            i4 = 6;
            obj = null;
            i5 = 1;
            composerStartRestartGroup.startReplaceableGroup(578042908);
            LargeLayoutContent$DescriptionGraphContent(linearGraphData, ColumnScope.weight$default(columnScopeInstance, SizeKt.fillMaxWidth$default(companion3, 0.0f, 1, null), 1.0f, false, 2, null), function23, function2, composerStartRestartGroup, ((i >> 12) & 112) | ((i >> 3) & 896), 0);
            composerStartRestartGroup.endReplaceableGroup();
        }
        SpacerKt.Spacer(SizeKt.m15899size3ABfNKs(companion3, C2256Dp.m20968constructorimpl(4)), composerStartRestartGroup, i4);
        LinearGraph linearGraph = linearGraphData.getLinearGraph();
        if (linearGraph instanceof StackedGraphData) {
            composerStartRestartGroup.startReplaceableGroup(578043300);
            ComposeStackedGraph(ComposeModifierUtilsKt.height(SizeKt.fillMaxWidth$default(companion3, 0.0f, i5, obj), fM21946getGraphSizeL2j3NV4, composerStartRestartGroup, i4), (StackedGraphData) linearGraphData.getLinearGraph(), composerStartRestartGroup, 64, 0);
            composerStartRestartGroup.endReplaceableGroup();
        } else if (linearGraph instanceof LinearProgressData) {
            composerStartRestartGroup.startReplaceableGroup(578043550);
            ProgressIndicatorKt.ComposeLinearProgressIndicator(ComposeModifierUtilsKt.height(SizeKt.fillMaxWidth$default(companion3, 0.0f, i5, obj), fM21946getGraphSizeL2j3NV4, composerStartRestartGroup, i4), (LinearProgressData) linearGraphData.getLinearGraph(), composerStartRestartGroup, 64, 0);
            composerStartRestartGroup.endReplaceableGroup();
        } else {
            composerStartRestartGroup.startReplaceableGroup(578043762);
            composerStartRestartGroup.endReplaceableGroup();
        }
        composerStartRestartGroup.endReplaceableGroup();
        composerStartRestartGroup.endNode();
        composerStartRestartGroup.endReplaceableGroup();
        composerStartRestartGroup.endReplaceableGroup();
        composerStartRestartGroup.endReplaceableGroup();
        composerStartRestartGroup.endNode();
        composerStartRestartGroup.endReplaceableGroup();
        composerStartRestartGroup.endReplaceableGroup();
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            final Modifier modifier3 = modifier2;
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.glance.oneui.template.layout.compose.LinearGraphLayoutKt.LargeLayoutContent.2
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                /* JADX WARN: Multi-variable type inference failed */
                {
                    super(2);
                }

                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Unit invoke(Composer composer2, Integer num) {
                    invoke(composer2, num.intValue());
                    return Unit.INSTANCE;
                }

                public final void invoke(@Nullable Composer composer2, int i6) {
                    LinearGraphLayoutKt.LargeLayoutContent(modifier3, linearGraphData, titleBarData, function2, function22, function23, function24, composer2, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
                }
            });
        }
    }

    @Composable
    @ComposableInferredTarget(scheme = "[androidx.compose.ui.UiComposable[androidx.compose.ui.UiComposable][androidx.compose.ui.UiComposable]]")
    private static final void LargeLayoutContent$DescriptionGraphContent(LinearGraphData linearGraphData, Modifier modifier, Function2<? super Composer, ? super Integer, Unit> function2, Function2<? super Composer, ? super Integer, Unit> function22, Composer composer, int i, int i2) {
        composer.startReplaceableGroup(-1086032321);
        Modifier modifier2 = (i2 & 1) != 0 ? Modifier.INSTANCE : modifier;
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-1086032321, i, -1, "androidx.glance.oneui.template.layout.compose.LargeLayoutContent.DescriptionGraphContent (LinearGraphLayout.kt:252)");
        }
        composer.startReplaceableGroup(-483455358);
        Arrangement arrangement = Arrangement.INSTANCE;
        Arrangement.Vertical top = arrangement.getTop();
        Alignment.Companion companion = Alignment.INSTANCE;
        MeasurePolicy measurePolicyM1209j = AbstractC1038a.m1209j(companion, top, composer, 0, -1323940314);
        Density density = (Density) composer.consume(androidx.compose.p109ui.platform.CompositionLocalsKt.getLocalDensity());
        LayoutDirection layoutDirection = (LayoutDirection) composer.consume(androidx.compose.p109ui.platform.CompositionLocalsKt.getLocalLayoutDirection());
        ViewConfiguration viewConfiguration = (ViewConfiguration) composer.consume(androidx.compose.p109ui.platform.CompositionLocalsKt.getLocalViewConfiguration());
        ComposeUiNode.Companion companion2 = ComposeUiNode.INSTANCE;
        Function0<ComposeUiNode> constructor = companion2.getConstructor();
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
        Updater.m18025setimpl(composerM18018constructorimpl, layoutDirection, (Function2<? super T, ? super LayoutDirection, Unit>) AbstractC1038a.m1219t(companion2, composerM18018constructorimpl, measurePolicyM1209j, composerM18018constructorimpl, density));
        function3MaterializerOf.invoke(AbstractC1038a.m1206g(companion2, composerM18018constructorimpl, viewConfiguration, composer, composer), composer, 0);
        composer.startReplaceableGroup(2058660585);
        ColumnScopeInstance columnScopeInstance = ColumnScopeInstance.INSTANCE;
        Modifier.Companion companion3 = Modifier.INSTANCE;
        Modifier modifierWeight$default = ColumnScope.weight$default(columnScopeInstance, SizeKt.fillMaxWidth$default(companion3, 0.0f, 1, null), 1.0f, false, 2, null);
        composer.startReplaceableGroup(693286680);
        MeasurePolicy measurePolicyM1208i = AbstractC1038a.m1208i(companion, arrangement.getStart(), composer, 0, -1323940314);
        Density density2 = (Density) composer.consume(androidx.compose.p109ui.platform.CompositionLocalsKt.getLocalDensity());
        LayoutDirection layoutDirection2 = (LayoutDirection) composer.consume(androidx.compose.p109ui.platform.CompositionLocalsKt.getLocalLayoutDirection());
        ViewConfiguration viewConfiguration2 = (ViewConfiguration) composer.consume(androidx.compose.p109ui.platform.CompositionLocalsKt.getLocalViewConfiguration());
        Function0<ComposeUiNode> constructor2 = companion2.getConstructor();
        Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> function3MaterializerOf2 = LayoutKt.materializerOf(modifierWeight$default);
        if (composer.getApplier() == null) {
            ComposablesKt.invalidApplier();
        }
        composer.startReusableNode();
        if (composer.getInserting()) {
            composer.createNode(constructor2);
        } else {
            composer.useNode();
        }
        composer.disableReusing();
        Composer composerM18018constructorimpl2 = Updater.m18018constructorimpl(composer);
        Updater.m18025setimpl(composerM18018constructorimpl2, layoutDirection2, (Function2<? super T, ? super LayoutDirection, Unit>) AbstractC1038a.m1219t(companion2, composerM18018constructorimpl2, measurePolicyM1208i, composerM18018constructorimpl2, density2));
        function3MaterializerOf2.invoke(AbstractC1038a.m1206g(companion2, composerM18018constructorimpl2, viewConfiguration2, composer, composer), composer, 0);
        composer.startReplaceableGroup(2058660585);
        RowScopeInstance rowScopeInstance = RowScopeInstance.INSTANCE;
        composer.startReplaceableGroup(-1388444647);
        if (function2 != null) {
            function2.invoke(composer, 0);
        }
        composer.endReplaceableGroup();
        composer.endReplaceableGroup();
        composer.endNode();
        composer.endReplaceableGroup();
        composer.endReplaceableGroup();
        Modifier modifierWrapContentHeight$default = SizeKt.wrapContentHeight$default(SizeKt.fillMaxWidth$default(companion3, 0.0f, 1, null), null, false, 3, null);
        composer.startReplaceableGroup(693286680);
        MeasurePolicy measurePolicyM1208i2 = AbstractC1038a.m1208i(companion, arrangement.getStart(), composer, 0, -1323940314);
        Density density3 = (Density) composer.consume(androidx.compose.p109ui.platform.CompositionLocalsKt.getLocalDensity());
        LayoutDirection layoutDirection3 = (LayoutDirection) composer.consume(androidx.compose.p109ui.platform.CompositionLocalsKt.getLocalLayoutDirection());
        ViewConfiguration viewConfiguration3 = (ViewConfiguration) composer.consume(androidx.compose.p109ui.platform.CompositionLocalsKt.getLocalViewConfiguration());
        Function0<ComposeUiNode> constructor3 = companion2.getConstructor();
        Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> function3MaterializerOf3 = LayoutKt.materializerOf(modifierWrapContentHeight$default);
        if (composer.getApplier() == null) {
            ComposablesKt.invalidApplier();
        }
        composer.startReusableNode();
        if (composer.getInserting()) {
            composer.createNode(constructor3);
        } else {
            composer.useNode();
        }
        composer.disableReusing();
        Composer composerM18018constructorimpl3 = Updater.m18018constructorimpl(composer);
        Updater.m18025setimpl(composerM18018constructorimpl3, layoutDirection3, (Function2<? super T, ? super LayoutDirection, Unit>) AbstractC1038a.m1219t(companion2, composerM18018constructorimpl3, measurePolicyM1208i2, composerM18018constructorimpl3, density3));
        function3MaterializerOf3.invoke(AbstractC1038a.m1206g(companion2, composerM18018constructorimpl3, viewConfiguration3, composer, composer), composer, 0);
        composer.startReplaceableGroup(2058660585);
        if (function22 != null) {
            composer.startReplaceableGroup(-696602560);
            AbstractC1038a.m1198C(composer, (i >> 6) & 14, function22);
        } else {
            composer.startReplaceableGroup(-696602504);
            ComposeGraphTextList(null, linearGraphData.getTextList(), false, composer, 448, 1);
            composer.endReplaceableGroup();
        }
        composer.endReplaceableGroup();
        composer.endNode();
        composer.endReplaceableGroup();
        composer.endReplaceableGroup();
        composer.endReplaceableGroup();
        composer.endNode();
        composer.endReplaceableGroup();
        composer.endReplaceableGroup();
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        composer.endReplaceableGroup();
    }

    @Composable
    @ComposableInferredTarget(scheme = "[androidx.compose.ui.UiComposable[androidx.compose.ui.UiComposable][androidx.compose.ui.UiComposable]]")
    private static final void LargeLayoutContent$DetailGraphContent(LinearGraphData linearGraphData, Modifier modifier, Function2<? super Composer, ? super Integer, Unit> function2, Function2<? super Composer, ? super Integer, Unit> function22, Composer composer, int i, int i2) {
        composer.startReplaceableGroup(-606733904);
        Modifier modifier2 = (i2 & 1) != 0 ? Modifier.INSTANCE : modifier;
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-606733904, i, -1, "androidx.glance.oneui.template.layout.compose.LargeLayoutContent.DetailGraphContent (LinearGraphLayout.kt:231)");
        }
        Alignment.Companion companion = Alignment.INSTANCE;
        Alignment.Vertical bottom = companion.getBottom();
        composer.startReplaceableGroup(693286680);
        MeasurePolicy measurePolicyM1207h = AbstractC1038a.m1207h(Arrangement.INSTANCE, bottom, composer, 48, -1323940314);
        Density density = (Density) composer.consume(androidx.compose.p109ui.platform.CompositionLocalsKt.getLocalDensity());
        LayoutDirection layoutDirection = (LayoutDirection) composer.consume(androidx.compose.p109ui.platform.CompositionLocalsKt.getLocalLayoutDirection());
        ViewConfiguration viewConfiguration = (ViewConfiguration) composer.consume(androidx.compose.p109ui.platform.CompositionLocalsKt.getLocalViewConfiguration());
        ComposeUiNode.Companion companion2 = ComposeUiNode.INSTANCE;
        Function0<ComposeUiNode> constructor = companion2.getConstructor();
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
        Updater.m18025setimpl(composerM18018constructorimpl, layoutDirection, (Function2<? super T, ? super LayoutDirection, Unit>) AbstractC1038a.m1219t(companion2, composerM18018constructorimpl, measurePolicyM1207h, composerM18018constructorimpl, density));
        function3MaterializerOf.invoke(AbstractC1038a.m1206g(companion2, composerM18018constructorimpl, viewConfiguration, composer, composer), composer, 0);
        composer.startReplaceableGroup(2058660585);
        RowScopeInstance rowScopeInstance = RowScopeInstance.INSTANCE;
        if (function22 != null) {
            composer.startReplaceableGroup(-488818210);
            AbstractC1038a.m1198C(composer, (i >> 6) & 14, function22);
        } else {
            composer.startReplaceableGroup(-488818162);
            ComposeGraphTextList(RowScope.weight$default(rowScopeInstance, SizeKt.wrapContentHeight$default(Modifier.INSTANCE, null, false, 3, null), 1.0f, false, 2, null), linearGraphData.getTextList(), true, composer, 448, 0);
            composer.endReplaceableGroup();
        }
        Modifier.Companion companion3 = Modifier.INSTANCE;
        SpacerKt.Spacer(SizeKt.m15899size3ABfNKs(companion3, C2256Dp.m20968constructorimpl(6)), composer, 6);
        Modifier modifierM15885height3ABfNKs = SizeKt.m15885height3ABfNKs(SizeKt.m15904width3ABfNKs(companion3, C2256Dp.m20968constructorimpl(150)), C2256Dp.m20968constructorimpl(62));
        composer.startReplaceableGroup(733328855);
        MeasurePolicy measurePolicyM1210k = AbstractC1038a.m1210k(companion, false, composer, 0, -1323940314);
        Density density2 = (Density) composer.consume(androidx.compose.p109ui.platform.CompositionLocalsKt.getLocalDensity());
        LayoutDirection layoutDirection2 = (LayoutDirection) composer.consume(androidx.compose.p109ui.platform.CompositionLocalsKt.getLocalLayoutDirection());
        ViewConfiguration viewConfiguration2 = (ViewConfiguration) composer.consume(androidx.compose.p109ui.platform.CompositionLocalsKt.getLocalViewConfiguration());
        Function0<ComposeUiNode> constructor2 = companion2.getConstructor();
        Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> function3MaterializerOf2 = LayoutKt.materializerOf(modifierM15885height3ABfNKs);
        if (composer.getApplier() == null) {
            ComposablesKt.invalidApplier();
        }
        composer.startReusableNode();
        if (composer.getInserting()) {
            composer.createNode(constructor2);
        } else {
            composer.useNode();
        }
        composer.disableReusing();
        Composer composerM18018constructorimpl2 = Updater.m18018constructorimpl(composer);
        Updater.m18025setimpl(composerM18018constructorimpl2, layoutDirection2, (Function2<? super T, ? super LayoutDirection, Unit>) AbstractC1038a.m1219t(companion2, composerM18018constructorimpl2, measurePolicyM1210k, composerM18018constructorimpl2, density2));
        function3MaterializerOf2.invoke(AbstractC1038a.m1206g(companion2, composerM18018constructorimpl2, viewConfiguration2, composer, composer), composer, 0);
        composer.startReplaceableGroup(2058660585);
        BoxScopeInstance boxScopeInstance = BoxScopeInstance.INSTANCE;
        function2.invoke(composer, Integer.valueOf((i >> 3) & 14));
        composer.endReplaceableGroup();
        composer.endNode();
        composer.endReplaceableGroup();
        composer.endReplaceableGroup();
        composer.endReplaceableGroup();
        composer.endNode();
        composer.endReplaceableGroup();
        composer.endReplaceableGroup();
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        composer.endReplaceableGroup();
    }

    /* JADX INFO: Access modifiers changed from: private */
    @ComposableTarget(applier = "androidx.compose.ui.UiComposable")
    @Composable
    /* JADX INFO: renamed from: LinearGraphText--jt2gSs, reason: not valid java name */
    public static final void m21801LinearGraphTextjt2gSs(Modifier modifier, final TextData textData, final ColorProvider colorProvider, final float f, Composer composer, final int i, final int i2) {
        Composer composerStartRestartGroup = composer.startRestartGroup(41767000);
        if ((i2 & 1) != 0) {
            modifier = Modifier.INSTANCE;
        }
        final Modifier modifier2 = modifier;
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(41767000, i, -1, "androidx.glance.oneui.template.layout.compose.LinearGraphText (LinearGraphLayout.kt:493)");
        }
        TextKt.m21730ComposeTextFbLeKfk(textData, f, FontWeight.INSTANCE.m21999getSemiBoldWjrlUT0(), ColorProvidersKt.override(colorProvider, textData.getTextColor()), modifier2, composerStartRestartGroup, ((i >> 6) & 112) | 4104 | ((i << 12) & 57344), 0);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.glance.oneui.template.layout.compose.LinearGraphLayoutKt$LinearGraphText$1
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
                    LinearGraphLayoutKt.m21801LinearGraphTextjt2gSs(modifier2, textData, colorProvider, f, composer2, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    @Composable
    @ComposableInferredTarget(scheme = "[androidx.compose.ui.UiComposable[androidx.compose.ui.UiComposable][androidx.compose.ui.UiComposable]]")
    public static final void MediumLayoutContent(Modifier modifier, final LinearGraphData linearGraphData, final TitleBarData titleBarData, final Function2<? super Composer, ? super Integer, Unit> function2, Function2<? super Composer, ? super Integer, Unit> function22, Composer composer, final int i, final int i2) {
        Function2<? super Composer, ? super Integer, Unit> function23;
        Object obj;
        Composer composerStartRestartGroup = composer.startRestartGroup(-255437171);
        Modifier modifier2 = (i2 & 1) != 0 ? Modifier.INSTANCE : modifier;
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-255437171, i, -1, "androidx.glance.oneui.template.layout.compose.MediumLayoutContent (LinearGraphLayout.kt:174)");
        }
        float fM21946getGraphSizeL2j3NV4 = GraphTemplatePercent.LinearGraph.INSTANCE.m21946getGraphSizeL2j3NV4(AppWidgetSize.INSTANCE.m21569getMediumrx25Pp4());
        Arrangement arrangement = Arrangement.INSTANCE;
        Arrangement.Vertical bottom = arrangement.getBottom();
        Alignment.Companion companion = Alignment.INSTANCE;
        Alignment.Horizontal centerHorizontally = companion.getCenterHorizontally();
        composerStartRestartGroup.startReplaceableGroup(-483455358);
        MeasurePolicy measurePolicyColumnMeasurePolicy = ColumnKt.columnMeasurePolicy(bottom, centerHorizontally, composerStartRestartGroup, 54);
        Density density = (Density) AbstractC1038a.m1211l(composerStartRestartGroup, -1323940314);
        LayoutDirection layoutDirection = (LayoutDirection) composerStartRestartGroup.consume(androidx.compose.p109ui.platform.CompositionLocalsKt.getLocalLayoutDirection());
        ViewConfiguration viewConfiguration = (ViewConfiguration) composerStartRestartGroup.consume(androidx.compose.p109ui.platform.CompositionLocalsKt.getLocalViewConfiguration());
        ComposeUiNode.Companion companion2 = ComposeUiNode.INSTANCE;
        Function0<ComposeUiNode> constructor = companion2.getConstructor();
        Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> function3MaterializerOf = LayoutKt.materializerOf(modifier2);
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
        Updater.m18025setimpl(composerM18018constructorimpl, layoutDirection, (Function2<? super T, ? super LayoutDirection, Unit>) AbstractC1038a.m1219t(companion2, composerM18018constructorimpl, measurePolicyColumnMeasurePolicy, composerM18018constructorimpl, density));
        function3MaterializerOf.invoke(AbstractC1038a.m1206g(companion2, composerM18018constructorimpl, viewConfiguration, composerStartRestartGroup, composerStartRestartGroup), composerStartRestartGroup, 0);
        composerStartRestartGroup.startReplaceableGroup(2058660585);
        ColumnScopeInstance columnScopeInstance = ColumnScopeInstance.INSTANCE;
        Modifier.Companion companion3 = Modifier.INSTANCE;
        Modifier modifierWrapContentHeight$default = SizeKt.wrapContentHeight$default(SizeKt.fillMaxWidth$default(companion3, 0.0f, 1, null), null, false, 3, null);
        composerStartRestartGroup.startReplaceableGroup(693286680);
        MeasurePolicy measurePolicyM1208i = AbstractC1038a.m1208i(companion, arrangement.getStart(), composerStartRestartGroup, 0, -1323940314);
        Density density2 = (Density) composerStartRestartGroup.consume(androidx.compose.p109ui.platform.CompositionLocalsKt.getLocalDensity());
        LayoutDirection layoutDirection2 = (LayoutDirection) composerStartRestartGroup.consume(androidx.compose.p109ui.platform.CompositionLocalsKt.getLocalLayoutDirection());
        ViewConfiguration viewConfiguration2 = (ViewConfiguration) composerStartRestartGroup.consume(androidx.compose.p109ui.platform.CompositionLocalsKt.getLocalViewConfiguration());
        Function0<ComposeUiNode> constructor2 = companion2.getConstructor();
        Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> function3MaterializerOf2 = LayoutKt.materializerOf(modifierWrapContentHeight$default);
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
        Updater.m18025setimpl(composerM18018constructorimpl2, layoutDirection2, (Function2<? super T, ? super LayoutDirection, Unit>) AbstractC1038a.m1219t(companion2, composerM18018constructorimpl2, measurePolicyM1208i, composerM18018constructorimpl2, density2));
        function3MaterializerOf2.invoke(AbstractC1038a.m1206g(companion2, composerM18018constructorimpl2, viewConfiguration2, composerStartRestartGroup, composerStartRestartGroup), composerStartRestartGroup, 0);
        composerStartRestartGroup.startReplaceableGroup(2058660585);
        RowScopeInstance rowScopeInstance = RowScopeInstance.INSTANCE;
        composerStartRestartGroup.startReplaceableGroup(-359752559);
        if (titleBarData == null) {
            function23 = function22;
        } else {
            function23 = function22;
            TitleBarKt.ComposeContent(titleBarData, function23, ComposableSingletons$LinearGraphLayoutKt.INSTANCE.m21790getLambda1$glance_oneui_template_release(), composerStartRestartGroup, ((i >> 9) & 112) | 392);
        }
        composerStartRestartGroup.endReplaceableGroup();
        composerStartRestartGroup.endReplaceableGroup();
        composerStartRestartGroup.endNode();
        composerStartRestartGroup.endReplaceableGroup();
        composerStartRestartGroup.endReplaceableGroup();
        SpacerKt.Spacer(ColumnScope.weight$default(columnScopeInstance, companion3, 1.0f, false, 2, null), composerStartRestartGroup, 0);
        if (function2 != null) {
            composerStartRestartGroup.startReplaceableGroup(-359752420);
            AbstractC1038a.m1198C(composerStartRestartGroup, (i >> 9) & 14, function2);
            obj = null;
        } else {
            composerStartRestartGroup.startReplaceableGroup(-359752373);
            obj = null;
            ComposeGraphTextList(SizeKt.wrapContentHeight$default(SizeKt.fillMaxWidth$default(companion3, 0.0f, 1, null), null, false, 3, null), linearGraphData.getTextList(), true, composerStartRestartGroup, 454, 0);
            composerStartRestartGroup.endReplaceableGroup();
        }
        SpacerKt.Spacer(SizeKt.m15899size3ABfNKs(companion3, C2256Dp.m20968constructorimpl(4)), composerStartRestartGroup, 6);
        LinearGraph linearGraph = linearGraphData.getLinearGraph();
        if (linearGraph instanceof StackedGraphData) {
            composerStartRestartGroup.startReplaceableGroup(-359752028);
            ComposeStackedGraph(ComposeModifierUtilsKt.height(SizeKt.fillMaxWidth$default(companion3, 0.0f, 1, obj), fM21946getGraphSizeL2j3NV4, composerStartRestartGroup, 6), (StackedGraphData) linearGraphData.getLinearGraph(), composerStartRestartGroup, 64, 0);
            composerStartRestartGroup.endReplaceableGroup();
        } else if (linearGraph instanceof LinearProgressData) {
            composerStartRestartGroup.startReplaceableGroup(-359751798);
            ProgressIndicatorKt.ComposeLinearProgressIndicator(ComposeModifierUtilsKt.height(SizeKt.fillMaxWidth$default(companion3, 0.0f, 1, obj), fM21946getGraphSizeL2j3NV4, composerStartRestartGroup, 6), (LinearProgressData) linearGraphData.getLinearGraph(), composerStartRestartGroup, 64, 0);
            composerStartRestartGroup.endReplaceableGroup();
        } else {
            composerStartRestartGroup.startReplaceableGroup(-359751602);
            composerStartRestartGroup.endReplaceableGroup();
        }
        if (AbstractC2821a.m2209D(composerStartRestartGroup)) {
            ComposerKt.traceEventEnd();
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            final Modifier modifier3 = modifier2;
            final Function2<? super Composer, ? super Integer, Unit> function24 = function23;
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.glance.oneui.template.layout.compose.LinearGraphLayoutKt.MediumLayoutContent.2
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                /* JADX WARN: Multi-variable type inference failed */
                {
                    super(2);
                }

                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Unit invoke(Composer composer2, Integer num) {
                    invoke(composer2, num.intValue());
                    return Unit.INSTANCE;
                }

                public final void invoke(@Nullable Composer composer2, int i4) {
                    LinearGraphLayoutKt.MediumLayoutContent(modifier3, linearGraphData, titleBarData, function2, function24, composer2, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    @Composable
    @ComposableInferredTarget(scheme = "[androidx.compose.ui.UiComposable[androidx.compose.ui.UiComposable]]")
    public static final void SmallLayoutContent(Modifier modifier, final LinearGraphData linearGraphData, final Function2<? super Composer, ? super Integer, Unit> function2, Composer composer, final int i, final int i2) {
        float f;
        Composer composerStartRestartGroup = composer.startRestartGroup(280418368);
        final Modifier modifier2 = (i2 & 1) != 0 ? Modifier.INSTANCE : modifier;
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(280418368, i, -1, "androidx.glance.oneui.template.layout.compose.SmallLayoutContent (LinearGraphLayout.kt:96)");
        }
        float fM21946getGraphSizeL2j3NV4 = GraphTemplatePercent.LinearGraph.INSTANCE.m21946getGraphSizeL2j3NV4(AppWidgetSize.INSTANCE.m21570getSmallrx25Pp4());
        Alignment.Horizontal centerHorizontally = Alignment.INSTANCE.getCenterHorizontally();
        Arrangement.HorizontalOrVertical center = Arrangement.INSTANCE.getCenter();
        composerStartRestartGroup.startReplaceableGroup(-483455358);
        MeasurePolicy measurePolicyColumnMeasurePolicy = ColumnKt.columnMeasurePolicy(center, centerHorizontally, composerStartRestartGroup, 54);
        Density density = (Density) AbstractC1038a.m1211l(composerStartRestartGroup, -1323940314);
        LayoutDirection layoutDirection = (LayoutDirection) composerStartRestartGroup.consume(androidx.compose.p109ui.platform.CompositionLocalsKt.getLocalLayoutDirection());
        ViewConfiguration viewConfiguration = (ViewConfiguration) composerStartRestartGroup.consume(androidx.compose.p109ui.platform.CompositionLocalsKt.getLocalViewConfiguration());
        ComposeUiNode.Companion companion = ComposeUiNode.INSTANCE;
        Function0<ComposeUiNode> constructor = companion.getConstructor();
        Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> function3MaterializerOf = LayoutKt.materializerOf(modifier2);
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
        Updater.m18025setimpl(composerM18018constructorimpl, layoutDirection, (Function2<? super T, ? super LayoutDirection, Unit>) AbstractC1038a.m1219t(companion, composerM18018constructorimpl, measurePolicyColumnMeasurePolicy, composerM18018constructorimpl, density));
        AbstractC1038a.m1221v(0, function3MaterializerOf, AbstractC1038a.m1206g(companion, composerM18018constructorimpl, viewConfiguration, composerStartRestartGroup, composerStartRestartGroup), composerStartRestartGroup, 2058660585);
        ColumnScopeInstance columnScopeInstance = ColumnScopeInstance.INSTANCE;
        Modifier.Companion companion2 = Modifier.INSTANCE;
        float f4 = 1;
        SpacerKt.Spacer(ColumnScope.weight$default(columnScopeInstance, SizeKt.m15904width3ABfNKs(companion2, C2256Dp.m20968constructorimpl(f4)), 1.0f, false, 2, null), composerStartRestartGroup, 0);
        if (function2 != null) {
            composerStartRestartGroup.startReplaceableGroup(-1504495476);
            AbstractC1038a.m1198C(composerStartRestartGroup, (i >> 6) & 14, function2);
            f = f4;
        } else {
            composerStartRestartGroup.startReplaceableGroup(-1504495429);
            f = f4;
            ComposeGraphTextList(SizeKt.wrapContentHeight$default(SizeKt.fillMaxWidth$default(companion2, 0.0f, 1, null), null, false, 3, null), linearGraphData.getTextList(), false, composerStartRestartGroup, 454, 0);
            composerStartRestartGroup.endReplaceableGroup();
        }
        SpacerKt.Spacer(SizeKt.m15899size3ABfNKs(companion2, C2256Dp.m20968constructorimpl(2)), composerStartRestartGroup, 6);
        LinearGraph linearGraph = linearGraphData.getLinearGraph();
        if (linearGraph instanceof StackedGraphData) {
            composerStartRestartGroup.startReplaceableGroup(-1504495083);
            ComposeStackedGraph(ComposeModifierUtilsKt.height(SizeKt.fillMaxWidth$default(companion2, 0.0f, 1, null), fM21946getGraphSizeL2j3NV4, composerStartRestartGroup, 6), (StackedGraphData) linearGraphData.getLinearGraph(), composerStartRestartGroup, 64, 0);
            composerStartRestartGroup.endReplaceableGroup();
        } else if (linearGraph instanceof LinearProgressData) {
            composerStartRestartGroup.startReplaceableGroup(-1504494853);
            ProgressIndicatorKt.ComposeLinearProgressIndicator(ComposeModifierUtilsKt.height(SizeKt.fillMaxWidth$default(companion2, 0.0f, 1, null), fM21946getGraphSizeL2j3NV4, composerStartRestartGroup, 6), (LinearProgressData) linearGraphData.getLinearGraph(), composerStartRestartGroup, 64, 0);
            composerStartRestartGroup.endReplaceableGroup();
        } else {
            composerStartRestartGroup.startReplaceableGroup(-1504494657);
            composerStartRestartGroup.endReplaceableGroup();
        }
        SpacerKt.Spacer(ColumnScope.weight$default(columnScopeInstance, SizeKt.m15904width3ABfNKs(companion2, C2256Dp.m20968constructorimpl(f)), 2.0f, false, 2, null), composerStartRestartGroup, 0);
        composerStartRestartGroup.endReplaceableGroup();
        composerStartRestartGroup.endNode();
        composerStartRestartGroup.endReplaceableGroup();
        composerStartRestartGroup.endReplaceableGroup();
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.glance.oneui.template.layout.compose.LinearGraphLayoutKt.SmallLayoutContent.2
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                /* JADX WARN: Multi-variable type inference failed */
                {
                    super(2);
                }

                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Unit invoke(Composer composer2, Integer num) {
                    invoke(composer2, num.intValue());
                    return Unit.INSTANCE;
                }

                public final void invoke(@Nullable Composer composer2, int i4) {
                    LinearGraphLayoutKt.SmallLayoutContent(modifier2, linearGraphData, function2, composer2, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Type inference failed for: r2v0 */
    /* JADX WARN: Type inference failed for: r2v15 */
    /* JADX WARN: Type inference failed for: r2v6, types: [boolean, int] */
    @ComposableTarget(applier = "androidx.glance.GlanceComposable")
    @Composable
    public static final void StackedGraph(Modifier modifier, final StackedGraphData stackedGraphData, Composer composer, final int i, final int i2) {
        Modifier modifier2;
        BigDecimal bigDecimal;
        Integer num;
        List<StackedGraphData.StackedGraphValue> list;
        List list2;
        int i4;
        float f;
        int i5;
        int i6;
        int i7;
        boolean z;
        int iIntValue;
        long jColor;
        ?? r2 = 0;
        Integer num2 = 0;
        Composer composerStartRestartGroup = composer.startRestartGroup(26505545);
        Modifier modifier3 = (i2 & 1) != 0 ? Modifier.INSTANCE : modifier;
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(26505545, i, -1, "androidx.glance.oneui.template.layout.compose.StackedGraph (LinearGraphLayout.kt:323)");
        }
        Alignment.Vertical vertical = null;
        Modifier modifierClip = ClipKt.clip(modifier3, new SmoothRoundedCornerShape(CommonDimensions.INSTANCE.m21773getDefaultCornerRadiusD9Ej5fM(), null));
        composerStartRestartGroup.startReplaceableGroup(709369200);
        long jConvert = AppWidgetStyle.m21578equalsimpl0(((AppWidgetStyle) composerStartRestartGroup.consume(androidx.glance.oneui.template.CompositionLocalsKt.getLocalWidgetStyle())).getMask(), AppWidgetStyle.INSTANCE.m21586getColorfulWOdBnnM()) ? ComposeUtilsKt.convert(ColorProvidersKt.override(GlanceTheme.INSTANCE.getColors(composerStartRestartGroup, GlanceTheme.$stable).getBackground(), stackedGraphData.getBackgroundColor()), composerStartRestartGroup, 8) : Color.INSTANCE.m18560getTransparent0d7_KjU();
        composerStartRestartGroup.endReplaceableGroup();
        Modifier modifierM15409backgroundbw27NRU$default = BackgroundKt.m15409backgroundbw27NRU$default(modifierClip, jConvert, null, 2, null);
        int i8 = 733328855;
        composerStartRestartGroup.startReplaceableGroup(733328855);
        int i9 = -1323940314;
        MeasurePolicy measurePolicyM1210k = AbstractC1038a.m1210k(Alignment.INSTANCE, false, composerStartRestartGroup, 0, -1323940314);
        Density density = (Density) composerStartRestartGroup.consume(androidx.compose.p109ui.platform.CompositionLocalsKt.getLocalDensity());
        LayoutDirection layoutDirection = (LayoutDirection) composerStartRestartGroup.consume(androidx.compose.p109ui.platform.CompositionLocalsKt.getLocalLayoutDirection());
        ViewConfiguration viewConfiguration = (ViewConfiguration) composerStartRestartGroup.consume(androidx.compose.p109ui.platform.CompositionLocalsKt.getLocalViewConfiguration());
        ComposeUiNode.Companion companion = ComposeUiNode.INSTANCE;
        Function0<ComposeUiNode> constructor = companion.getConstructor();
        Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> function3MaterializerOf = LayoutKt.materializerOf(modifierM15409backgroundbw27NRU$default);
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
        Updater.m18025setimpl(composerM18018constructorimpl, layoutDirection, (Function2<? super T, ? super LayoutDirection, Unit>) AbstractC1038a.m1219t(companion, composerM18018constructorimpl, measurePolicyM1210k, composerM18018constructorimpl, density));
        function3MaterializerOf.invoke(AbstractC1038a.m1206g(companion, composerM18018constructorimpl, viewConfiguration, composerStartRestartGroup, composerStartRestartGroup), composerStartRestartGroup, num2);
        composerStartRestartGroup.startReplaceableGroup(2058660585);
        BoxScopeInstance boxScopeInstance = BoxScopeInstance.INSTANCE;
        float f4 = 0.0f;
        int i10 = 1;
        if (stackedGraphData.getStacked()) {
            composerStartRestartGroup.startReplaceableGroup(-910964056);
            List<StackedGraphData.StackedGraphValue> values = stackedGraphData.getValues();
            List listReversed = CollectionsKt.reversed(ColorProvidersKt.getMonotoneGraphColorArray());
            BigDecimal bigDecimal2 = new BigDecimal("1.0");
            int size = values.size() - 1;
            int size2 = values.size() / 10;
            if (size2 >= 0) {
                int i11 = 0;
                int i12 = size;
                BigDecimal bigDecimal3 = bigDecimal2;
                while (true) {
                    Modifier modifierWrapContentHeight$default = SizeKt.wrapContentHeight$default(SizeKt.fillMaxWidth$default(Modifier.INSTANCE, f4, i10, vertical), vertical, r2, 3, vertical);
                    composerStartRestartGroup.startReplaceableGroup(i8);
                    MeasurePolicy measurePolicyM1210k2 = AbstractC1038a.m1210k(Alignment.INSTANCE, r2, composerStartRestartGroup, r2, i9);
                    Density density2 = (Density) composerStartRestartGroup.consume(androidx.compose.p109ui.platform.CompositionLocalsKt.getLocalDensity());
                    LayoutDirection layoutDirection2 = (LayoutDirection) composerStartRestartGroup.consume(androidx.compose.p109ui.platform.CompositionLocalsKt.getLocalLayoutDirection());
                    ViewConfiguration viewConfiguration2 = (ViewConfiguration) composerStartRestartGroup.consume(androidx.compose.p109ui.platform.CompositionLocalsKt.getLocalViewConfiguration());
                    ComposeUiNode.Companion companion2 = ComposeUiNode.INSTANCE;
                    Function0<ComposeUiNode> constructor2 = companion2.getConstructor();
                    Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> function3MaterializerOf2 = LayoutKt.materializerOf(modifierWrapContentHeight$default);
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
                    Updater.m18025setimpl(composerM18018constructorimpl2, layoutDirection2, (Function2<? super T, ? super LayoutDirection, Unit>) AbstractC1038a.m1219t(companion2, composerM18018constructorimpl2, measurePolicyM1210k2, composerM18018constructorimpl2, density2));
                    function3MaterializerOf2.invoke(AbstractC1038a.m1206g(companion2, composerM18018constructorimpl2, viewConfiguration2, composerStartRestartGroup, composerStartRestartGroup), composerStartRestartGroup, num2);
                    composerStartRestartGroup.startReplaceableGroup(2058660585);
                    BoxScopeInstance boxScopeInstance2 = BoxScopeInstance.INSTANCE;
                    composerStartRestartGroup.startReplaceableGroup(-910963553);
                    BigDecimal bigDecimalSubtract = bigDecimal3;
                    int i13 = i12;
                    while (true) {
                        if (i13 < 0) {
                            num = num2;
                            modifier2 = modifier3;
                            list = values;
                            list2 = listReversed;
                            i4 = size2;
                            f = 0.0f;
                            i5 = 733328855;
                            i6 = -1323940314;
                            i7 = i13;
                            bigDecimal3 = bigDecimalSubtract;
                            break;
                        }
                        Modifier modifier4 = modifier3;
                        float fFloatValue = bigDecimalSubtract.floatValue();
                        Modifier modifierFillMaxSize$default = SizeKt.fillMaxSize$default(Modifier.INSTANCE, 0.0f, 1, null);
                        if (AppWidgetStyle.m21578equalsimpl0(((AppWidgetStyle) composerStartRestartGroup.consume(androidx.glance.oneui.template.CompositionLocalsKt.getLocalWidgetStyle())).getMask(), AppWidgetStyle.INSTANCE.m21586getColorfulWOdBnnM())) {
                            jColor = values.get(i13).m21672getColor0d7_KjU();
                            z = true;
                        } else {
                            if (i13 < listReversed.size()) {
                                iIntValue = ((Number) listReversed.get(i13)).intValue();
                                z = true;
                            } else {
                                z = true;
                                iIntValue = ((Number) AbstractC0000a.m10g(listReversed, 1)).intValue();
                            }
                            jColor = ColorKt.Color(iIntValue);
                        }
                        list2 = listReversed;
                        int i14 = i13;
                        f = 0.0f;
                        i4 = size2;
                        i5 = 733328855;
                        i6 = -1323940314;
                        long j = jColor;
                        num = num2;
                        modifier2 = modifier4;
                        list = values;
                        ProgressIndicatorKt.m21723ProgressIndicatorY0xEhic(fFloatValue, modifierFillMaxSize$default, j, Color.INSTANCE.m18560getTransparent0d7_KjU(), ProgressType.Stacked, null, composerStartRestartGroup, 27696, 32);
                        bigDecimalSubtract = bigDecimalSubtract.subtract(new BigDecimal(String.valueOf(list.get(i14).getValue())));
                        Intrinsics.checkNotNullExpressionValue(bigDecimalSubtract, "subtract(...)");
                        i13 = i14 - 1;
                        if (i13 % 10 == 9) {
                            bigDecimal3 = bigDecimalSubtract;
                            i7 = i13;
                            break;
                        } else {
                            size2 = i4;
                            values = list;
                            num2 = num;
                            modifier3 = modifier2;
                            listReversed = list2;
                        }
                    }
                    composerStartRestartGroup.endReplaceableGroup();
                    composerStartRestartGroup.endReplaceableGroup();
                    composerStartRestartGroup.endNode();
                    composerStartRestartGroup.endReplaceableGroup();
                    composerStartRestartGroup.endReplaceableGroup();
                    int i15 = i11;
                    if (i15 == i4) {
                        break;
                    }
                    i11 = i15 + 1;
                    size2 = i4;
                    f4 = f;
                    values = list;
                    num2 = num;
                    modifier3 = modifier2;
                    i8 = i5;
                    i9 = i6;
                    listReversed = list2;
                    r2 = 0;
                    vertical = null;
                    i10 = 1;
                    i12 = i7;
                }
                bigDecimal = bigDecimal3;
            } else {
                modifier2 = modifier3;
                bigDecimal = bigDecimal2;
            }
            if (bigDecimal.compareTo(BigDecimal.ZERO) != 0) {
                GlanceLog.INSTANCE.m2305w("StackedGraph", "GraphTemplate: The rest of the section is " + bigDecimal + ", the sum is not 1.0!!");
            }
            composerStartRestartGroup.endReplaceableGroup();
        } else {
            modifier2 = modifier3;
            composerStartRestartGroup.startReplaceableGroup(-910962139);
            List listSortedWith = CollectionsKt.sortedWith(stackedGraphData.getValues(), new Comparator() { // from class: androidx.glance.oneui.template.layout.compose.LinearGraphLayoutKt$StackedGraph$lambda$16$$inlined$sortedByDescending$1
                /* JADX WARN: Multi-variable type inference failed */
                @Override // java.util.Comparator
                public final int compare(T t, T t2) {
                    return ComparisonsKt.compareValues(Float.valueOf(((StackedGraphData.StackedGraphValue) t2).getValue()), Float.valueOf(((StackedGraphData.StackedGraphValue) t).getValue()));
                }
            });
            List<Integer> monotoneGraphColorArray = ColorProvidersKt.getMonotoneGraphColorArray();
            int i16 = 0;
            for (Object obj : listSortedWith) {
                int i17 = i16 + 1;
                if (i16 < 0) {
                    CollectionsKt.throwIndexOverflow();
                }
                StackedGraphData.StackedGraphValue stackedGraphValue = (StackedGraphData.StackedGraphValue) obj;
                ProgressIndicatorKt.m21723ProgressIndicatorY0xEhic(stackedGraphValue.getValue(), SizeKt.fillMaxSize$default(Modifier.INSTANCE, 0.0f, 1, null), AppWidgetStyle.m21578equalsimpl0(((AppWidgetStyle) composerStartRestartGroup.consume(androidx.glance.oneui.template.CompositionLocalsKt.getLocalWidgetStyle())).getMask(), AppWidgetStyle.INSTANCE.m21586getColorfulWOdBnnM()) ? stackedGraphValue.m21672getColor0d7_KjU() : ColorKt.Color(i16 < monotoneGraphColorArray.size() ? monotoneGraphColorArray.get(i16).intValue() : ((Number) AbstractC0000a.m10g(monotoneGraphColorArray, 1)).intValue()), Color.INSTANCE.m18560getTransparent0d7_KjU(), ProgressType.Stacked, null, composerStartRestartGroup, 27696, 32);
                i16 = i17;
            }
            composerStartRestartGroup.endReplaceableGroup();
        }
        if (AbstractC2821a.m2209D(composerStartRestartGroup)) {
            ComposerKt.traceEventEnd();
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            final Modifier modifier5 = modifier2;
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.glance.oneui.template.layout.compose.LinearGraphLayoutKt.StackedGraph.2
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(2);
                }

                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Unit invoke(Composer composer2, Integer num3) {
                    invoke(composer2, num3.intValue());
                    return Unit.INSTANCE;
                }

                public final void invoke(@Nullable Composer composer2, int i18) {
                    LinearGraphLayoutKt.StackedGraph(modifier5, stackedGraphData, composer2, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    @Composable
    @ComposableInferredTarget(scheme = "[androidx.compose.ui.UiComposable[androidx.compose.ui.UiComposable][androidx.compose.ui.UiComposable][androidx.compose.ui.UiComposable][androidx.compose.ui.UiComposable]]")
    public static final void WidgetLayoutMediumAndLarge(final LinearGraphData linearGraphData, final Function2<? super Composer, ? super Integer, Unit> function2, final Function2<? super Composer, ? super Integer, Unit> function22, final Function2<? super Composer, ? super Integer, Unit> function23, final TitleBarData titleBarData, final Function2<? super Composer, ? super Integer, Unit> function24, Composer composer, final int i) {
        Composer composerStartRestartGroup = composer.startRestartGroup(1246944515);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(1246944515, i, -1, "androidx.glance.oneui.template.layout.compose.WidgetLayoutMediumAndLarge (LinearGraphLayout.kt:140)");
        }
        if (AppWidgetSize.m21550equalsimpl0(((AppWidgetSize) composerStartRestartGroup.consume(androidx.glance.oneui.template.CompositionLocalsKt.getLocalWidgetSize())).getMask(), AppWidgetSize.INSTANCE.m21569getMediumrx25Pp4())) {
            composerStartRestartGroup.startReplaceableGroup(598538387);
            float f = 14;
            MediumLayoutContent(SizeKt.fillMaxSize$default(PaddingKt.m15857paddingqDBjuR0(Modifier.INSTANCE, C2256Dp.m20968constructorimpl(f), C2256Dp.m20968constructorimpl(0), C2256Dp.m20968constructorimpl(f), C2256Dp.m20968constructorimpl(f)), 0.0f, 1, null), linearGraphData, titleBarData, function2, function24, composerStartRestartGroup, ((i << 6) & 7168) | Units.MASTER_DPI | (57344 & (i >> 3)), 0);
            composerStartRestartGroup.endReplaceableGroup();
        } else {
            composerStartRestartGroup.startReplaceableGroup(598538739);
            float f4 = 14;
            int i2 = i << 9;
            LargeLayoutContent(SizeKt.fillMaxSize$default(PaddingKt.m15857paddingqDBjuR0(Modifier.INSTANCE, C2256Dp.m20968constructorimpl(f4), C2256Dp.m20968constructorimpl(16), C2256Dp.m20968constructorimpl(f4), C2256Dp.m20968constructorimpl(f4)), 0.0f, 1, null), linearGraphData, titleBarData, function2, function24, function22, function23, composerStartRestartGroup, ((i << 6) & 7168) | Units.MASTER_DPI | (57344 & (i >> 3)) | (458752 & i2) | (i2 & 3670016), 0);
            composerStartRestartGroup = composerStartRestartGroup;
            composerStartRestartGroup.endReplaceableGroup();
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.glance.oneui.template.layout.compose.LinearGraphLayoutKt.WidgetLayoutMediumAndLarge.1
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                /* JADX WARN: Multi-variable type inference failed */
                {
                    super(2);
                }

                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Unit invoke(Composer composer2, Integer num) {
                    invoke(composer2, num.intValue());
                    return Unit.INSTANCE;
                }

                public final void invoke(@Nullable Composer composer2, int i4) {
                    LinearGraphLayoutKt.WidgetLayoutMediumAndLarge(linearGraphData, function2, function22, function23, titleBarData, function24, composer2, RecomposeScopeImplKt.updateChangedFlags(i | 1));
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    @Composable
    @ComposableInferredTarget(scheme = "[androidx.compose.ui.UiComposable[androidx.compose.ui.UiComposable]]")
    public static final void WidgetLayoutSmall(final LinearGraphData linearGraphData, final Function2<? super Composer, ? super Integer, Unit> function2, Composer composer, final int i) {
        Composer composerStartRestartGroup = composer.startRestartGroup(1418952282);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(1418952282, i, -1, "androidx.glance.oneui.template.layout.compose.WidgetLayoutSmall (LinearGraphLayout.kt:83)");
        }
        SmallLayoutContent(SizeKt.fillMaxSize$default(ComposeModifierUtilsKt.m21956padding6PoWaU8(Modifier.INSTANCE, 0.105f, 0.0f, 0.0f, 0.0f, composerStartRestartGroup, 438, 12), 0.0f, 1, null), linearGraphData, function2, composerStartRestartGroup, ((i << 3) & 896) | 64, 0);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.glance.oneui.template.layout.compose.LinearGraphLayoutKt.WidgetLayoutSmall.1
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                /* JADX WARN: Multi-variable type inference failed */
                {
                    super(2);
                }

                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Unit invoke(Composer composer2, Integer num) {
                    invoke(composer2, num.intValue());
                    return Unit.INSTANCE;
                }

                public final void invoke(@Nullable Composer composer2, int i2) {
                    LinearGraphLayoutKt.WidgetLayoutSmall(linearGraphData, function2, composer2, RecomposeScopeImplKt.updateChangedFlags(i | 1));
                }
            });
        }
    }

    @Composable
    private static final ColorProvider getTextColor(TextData textData, ColorProvider colorProvider, Composer composer, int i) {
        composer.startReplaceableGroup(-1059318833);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-1059318833, i, -1, "androidx.glance.oneui.template.layout.compose.getTextColor (LinearGraphLayout.kt:530)");
        }
        ColorProvider colorProviderOverride = ColorProvidersKt.override(colorProvider, textData.getTextColor());
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        composer.endReplaceableGroup();
        return colorProviderOverride;
    }

    @Composable
    /* JADX INFO: renamed from: getTextSize-DLfFjGE, reason: not valid java name */
    private static final TextSize m21803getTextSizeDLfFjGE(TextData textData, int i, Composer composer, int i2) {
        TextSize labelText;
        composer.startReplaceableGroup(-2099203310);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-2099203310, i2, -1, "androidx.glance.oneui.template.layout.compose.getTextSize (LinearGraphLayout.kt:519)");
        }
        TextType.Companion companion = TextType.INSTANCE;
        if (TextType.m21684equalsimpl0(i, companion.m21691getDisplaygxbDmow())) {
            composer.startReplaceableGroup(1067429884);
            labelText = GraphLayoutTextSizes.INSTANCE.getDisplayText(composer, 6);
            composer.endReplaceableGroup();
        } else if (TextType.m21684equalsimpl0(i, companion.m21694getTitlegxbDmow())) {
            composer.startReplaceableGroup(1067429943);
            labelText = GraphLayoutTextSizes.INSTANCE.getTitleText(composer, 6);
            composer.endReplaceableGroup();
        } else if (TextType.m21684equalsimpl0(i, companion.m21689getBodygxbDmow())) {
            composer.startReplaceableGroup(1067429999);
            labelText = GraphLayoutTextSizes.INSTANCE.getBodyText(composer, 6);
            composer.endReplaceableGroup();
        } else if (TextType.m21684equalsimpl0(i, companion.m21690getDescriptiongxbDmow())) {
            composer.startReplaceableGroup(1067430061);
            labelText = GraphLayoutTextSizes.INSTANCE.getDescriptionText(composer, 6);
            composer.endReplaceableGroup();
        } else {
            composer.startReplaceableGroup(1067430114);
            labelText = GraphLayoutTextSizes.INSTANCE.getLabelText(composer, 6);
            composer.endReplaceableGroup();
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        composer.endReplaceableGroup();
        return labelText;
    }

    @ComposableTarget(applier = "androidx.glance.GlanceComposable")
    @Composable
    public static final void ComposeStackedGraph(@NotNull final StackedGraphData data, final int i, @Nullable Composer composer, final int i2, final int i4) {
        Modifier modifierM15885height3ABfNKs;
        Intrinsics.checkNotNullParameter(data, "data");
        Composer composerStartRestartGroup = composer.startRestartGroup(1200594635);
        if ((i4 & 2) != 0) {
            i = 0;
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(1200594635, i2, -1, "androidx.glance.oneui.template.layout.compose.ComposeStackedGraph (LinearGraphLayout.kt:312)");
        }
        composerStartRestartGroup.startReplaceableGroup(-439658915);
        if (i != 0) {
            modifierM15885height3ABfNKs = SizeKt.m15885height3ABfNKs(SizeKt.fillMaxWidth$default(Modifier.INSTANCE, 0.0f, 1, null), PrimitiveResources_androidKt.dimensionResource(i, composerStartRestartGroup, (i2 >> 3) & 14));
        } else {
            modifierM15885height3ABfNKs = SizeKt.m15885height3ABfNKs(SizeKt.fillMaxWidth$default(Modifier.INSTANCE, 0.0f, 1, null), C2256Dp.m20968constructorimpl(26));
        }
        composerStartRestartGroup.endReplaceableGroup();
        StackedGraph(modifierM15885height3ABfNKs, data, composerStartRestartGroup, 64, 0);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.glance.oneui.template.layout.compose.LinearGraphLayoutKt.ComposeStackedGraph.2
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
                    LinearGraphLayoutKt.ComposeStackedGraph(data, i, composer2, RecomposeScopeImplKt.updateChangedFlags(i2 | 1), i4);
                }
            });
        }
    }
}
