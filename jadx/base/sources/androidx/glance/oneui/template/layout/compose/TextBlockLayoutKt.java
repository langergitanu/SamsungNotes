package androidx.glance.oneui.template.layout.compose;

import android.content.Context;
import androidx.compose.foundation.BackgroundKt;
import androidx.compose.foundation.layout.AbstractC1038a;
import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.foundation.layout.BoxKt;
import androidx.compose.foundation.layout.BoxScopeInstance;
import androidx.compose.foundation.layout.ColumnScope;
import androidx.compose.foundation.layout.ColumnScopeInstance;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.RowScope;
import androidx.compose.foundation.layout.RowScopeInstance;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.layout.SpacerKt;
import androidx.compose.foundation.shape.RoundedCornerShapeKt;
import androidx.compose.p109ui.Alignment;
import androidx.compose.p109ui.Modifier;
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
import androidx.compose.p109ui.unit.DpRect;
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
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.glance.GlanceTheme;
import androidx.glance.color.DayNightColorProvidersKt;
import androidx.glance.oneui.common.AppWidgetSize;
import androidx.glance.oneui.template.C3094R;
import androidx.glance.oneui.template.CompositionLocalsKt;
import androidx.glance.oneui.template.CustomTypedTextData;
import androidx.glance.oneui.template.Orientation;
import androidx.glance.oneui.template.TextBlockItem;
import androidx.glance.oneui.template.TextType;
import androidx.glance.oneui.template.TypedTextData;
import androidx.glance.oneui.template.TypedTextListData;
import androidx.glance.oneui.template.color.ColorProvidersKt;
import androidx.glance.oneui.template.component.compose.TextKt;
import androidx.glance.oneui.template.layout.CombineLayoutDimensions;
import androidx.glance.oneui.template.layout.CommonDimensions;
import androidx.glance.oneui.template.layout.MultiTextBlockLayoutTextSizes;
import androidx.glance.oneui.template.layout.SingleTextBlockLayoutTextSizes;
import androidx.glance.oneui.template.layout.TextBlockLayoutDimensions;
import androidx.glance.oneui.template.layout.TextSize;
import androidx.glance.oneui.template.utils.ComposeModifierUtilsKt;
import androidx.glance.oneui.template.utils.ComposeUtilsKt;
import androidx.glance.text.TextAlign;
import androidx.glance.text.TextPercentData;
import androidx.glance.unit.ColorProvider;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.jvm.internal.SourceDebugExtension;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(m13885d1 = {"\u0000\\\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a!\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\u0001¢\u0006\u0002\u0010\u0006\u001aQ\u0010\u0007\u001a\u00020\u00012\u0006\u0010\b\u001a\u00020\t2\u0011\u0010\n\u001a\r\u0012\u0004\u0012\u00020\u00010\u000b¢\u0006\u0002\b\f2\b\u0010\r\u001a\u0004\u0018\u00010\t2\u0013\u0010\u000e\u001a\u000f\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u000b¢\u0006\u0002\b\f2\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\u0001¢\u0006\u0002\u0010\u000f\u001a9\u0010\u0010\u001a\u00020\u00012\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u00032\u0006\u0010\u0014\u001a\u00020\u00052\b\b\u0002\u0010\u0015\u001a\u00020\u00162\b\b\u0002\u0010\u0017\u001a\u00020\u0018H\u0001¢\u0006\u0002\u0010\u0019\u001a%\u0010\u001a\u001a\u00020\u00012\u0006\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u0013\u001a\u00020\u00032\u0006\u0010\u0014\u001a\u00020\u0005H\u0001¢\u0006\u0002\u0010\u001d\u001a8\u0010\u001e\u001a\u00020\u00012\f\u0010\u001f\u001a\b\u0012\u0004\u0012\u00020\u00120 2\u0006\u0010\u0013\u001a\u00020\u00032\u0006\u0010\u0014\u001a\u00020\u00052\u0006\u0010!\u001a\u00020\"H\u0003ø\u0001\u0000¢\u0006\u0004\b#\u0010$\u001a+\u0010%\u001a\u00020\u00012\f\u0010\u001f\u001a\b\u0012\u0004\u0012\u00020\u00120 2\u0006\u0010\u0013\u001a\u00020\u00032\u0006\u0010\u0014\u001a\u00020\u0005H\u0003¢\u0006\u0002\u0010&\u001a(\u0010'\u001a\u00020\u00012\u0006\u0010(\u001a\u00020\t2\u0011\u0010)\u001a\r\u0012\u0004\u0012\u00020\u00010\u000b¢\u0006\u0002\b\fH\u0003¢\u0006\u0002\u0010*\u001a\u0019\u0010+\u001a\u00020\u0005*\u00020\u00122\u0006\u0010\u0014\u001a\u00020\u0005H\u0003¢\u0006\u0002\u0010,\u001a#\u0010-\u001a\u00020.*\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u00032\b\b\u0002\u0010\u0017\u001a\u00020\u0018H\u0003¢\u0006\u0002\u0010/\u0082\u0002\u0007\n\u0005\b¡\u001e0\u0001¨\u00060"}, m13886d2 = {"ComposeDivider", "", "isVertical", "", "dividerColor", "Landroidx/glance/unit/ColorProvider;", "(ZLandroidx/glance/unit/ColorProvider;Landroidx/compose/runtime/Composer;II)V", "ComposeTextBlockLayout", "mainItem", "Landroidx/glance/oneui/template/TextBlockItem;", "mainContent", "Lkotlin/Function0;", "Landroidx/compose/runtime/Composable;", "subItem", "subContent", "(Landroidx/glance/oneui/template/TextBlockItem;Lkotlin/jvm/functions/Function2;Landroidx/glance/oneui/template/TextBlockItem;Lkotlin/jvm/functions/Function2;Landroidx/glance/unit/ColorProvider;Landroidx/compose/runtime/Composer;I)V", "ComposeTextBlockText", "textData", "Landroidx/glance/oneui/template/TypedTextData;", "fromSingleBlock", "defaultTextColor", "modifier", "Landroidx/compose/ui/Modifier;", "visibleTextCountInSmall", "", "(Landroidx/glance/oneui/template/TypedTextData;ZLandroidx/glance/unit/ColorProvider;Landroidx/compose/ui/Modifier;ILandroidx/compose/runtime/Composer;II)V", "ComposeTextBlockTextList", "textListData", "Landroidx/glance/oneui/template/TypedTextListData;", "(Landroidx/glance/oneui/template/TypedTextListData;ZLandroidx/glance/unit/ColorProvider;Landroidx/compose/runtime/Composer;I)V", "LayoutHorizontal", "textList", "", "defaultTextAlign", "Landroidx/glance/text/TextAlign;", "LayoutHorizontal-RTYL8B8", "(Ljava/util/List;ZLandroidx/glance/unit/ColorProvider;ILandroidx/compose/runtime/Composer;I)V", "LayoutVertical", "(Ljava/util/List;ZLandroidx/glance/unit/ColorProvider;Landroidx/compose/runtime/Composer;I)V", "TextBlockItemLayout", "item", "content", "(Landroidx/glance/oneui/template/TextBlockItem;Lkotlin/jvm/functions/Function2;Landroidx/compose/runtime/Composer;I)V", "getTextColor", "(Landroidx/glance/oneui/template/TypedTextData;Landroidx/glance/unit/ColorProvider;Landroidx/compose/runtime/Composer;I)Landroidx/glance/unit/ColorProvider;", "getTextSize", "Landroidx/glance/oneui/template/layout/TextSize;", "(Landroidx/glance/oneui/template/TypedTextData;ZILandroidx/compose/runtime/Composer;II)Landroidx/glance/oneui/template/layout/TextSize;", "glance-oneui-template_release"}, m13887k = 2, m13888mv = {1, 9, 0}, m13890xi = 48)
@SourceDebugExtension({"SMAP\nTextBlockLayout.kt\nKotlin\n*S Kotlin\n*F\n+ 1 TextBlockLayout.kt\nandroidx/glance/oneui/template/layout/compose/TextBlockLayoutKt\n+ 2 CompositionLocal.kt\nandroidx/compose/runtime/CompositionLocal\n+ 3 fake.kt\nkotlin/jvm/internal/FakeKt\n+ 4 Column.kt\nandroidx/compose/foundation/layout/ColumnKt\n+ 5 Layout.kt\nandroidx/compose/ui/layout/LayoutKt\n+ 6 Composables.kt\nandroidx/compose/runtime/ComposablesKt\n+ 7 Box.kt\nandroidx/compose/foundation/layout/BoxKt\n+ 8 Row.kt\nandroidx/compose/foundation/layout/RowKt\n+ 9 Dp.kt\nandroidx/compose/ui/unit/DpKt\n+ 10 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,702:1\n74#2:703\n76#2:712\n76#2:745\n74#2:776\n74#2:777\n76#2:785\n74#2:821\n76#2:829\n76#2:862\n74#2:893\n74#2:894\n76#2:902\n74#2:938\n76#2:946\n76#2:978\n74#2:1014\n76#2:1022\n74#2:1054\n76#2:1062\n76#2:1096\n76#2:1139\n76#2:1176\n74#2:1210\n76#2:1223\n76#2:1255\n76#2:1299\n76#2:1333\n76#2:1365\n76#2:1407\n1#3:704\n74#4,6:705\n80#4:737\n84#4:820\n74#4,6:1015\n80#4:1047\n84#4:1053\n74#4,6:1089\n80#4:1121\n84#4:1126\n75#5:711\n76#5,11:713\n75#5:744\n76#5,11:746\n89#5:774\n75#5:784\n76#5,11:786\n89#5:814\n89#5:819\n75#5:828\n76#5,11:830\n75#5:861\n76#5,11:863\n89#5:891\n75#5:901\n76#5,11:903\n89#5:931\n89#5:936\n75#5:945\n76#5,11:947\n75#5:977\n76#5,11:979\n89#5:1007\n89#5:1012\n75#5:1021\n76#5,11:1023\n89#5:1052\n75#5:1061\n76#5,11:1063\n75#5:1095\n76#5,11:1097\n89#5:1125\n89#5:1130\n75#5:1138\n76#5,11:1140\n89#5:1168\n75#5:1175\n76#5,11:1177\n89#5:1208\n75#5:1222\n76#5,11:1224\n75#5:1254\n76#5,11:1256\n89#5:1284\n89#5:1289\n75#5:1298\n76#5,11:1300\n75#5:1332\n76#5,11:1334\n75#5:1364\n76#5,11:1366\n89#5:1394\n89#5:1399\n75#5:1406\n76#5,11:1408\n89#5:1436\n89#5:1441\n460#6,13:724\n460#6,13:757\n473#6,3:771\n460#6,13:797\n473#6,3:811\n473#6,3:816\n460#6,13:841\n460#6,13:874\n473#6,3:888\n460#6,13:914\n473#6,3:928\n473#6,3:933\n460#6,13:958\n460#6,13:990\n473#6,3:1004\n473#6,3:1009\n460#6,13:1034\n473#6,3:1049\n460#6,13:1074\n460#6,13:1108\n473#6,3:1122\n473#6,3:1127\n460#6,13:1151\n473#6,3:1165\n460#6,13:1188\n473#6,3:1205\n460#6,13:1235\n460#6,13:1267\n473#6,3:1281\n473#6,3:1286\n460#6,13:1311\n460#6,13:1345\n460#6,13:1377\n473#6,3:1391\n473#6,3:1396\n460#6,13:1419\n473#6,3:1433\n473#6,3:1438\n67#7,6:738\n73#7:770\n77#7:775\n67#7,6:778\n73#7:810\n77#7:815\n67#7,6:855\n73#7:887\n77#7:892\n67#7,6:895\n73#7:927\n77#7:932\n67#7,6:939\n73#7:971\n68#7,5:972\n73#7:1003\n77#7:1008\n77#7:1013\n67#7,6:1216\n73#7:1248\n68#7,5:1249\n73#7:1280\n77#7:1285\n77#7:1290\n67#7,6:1292\n73#7:1324\n67#7,6:1326\n73#7:1358\n68#7,5:1359\n73#7:1390\n77#7:1395\n77#7:1400\n68#7,5:1401\n73#7:1432\n77#7:1437\n77#7:1442\n75#8,6:822\n81#8:854\n85#8:937\n75#8,6:1055\n81#8:1087\n85#8:1131\n75#8,6:1132\n81#8:1164\n85#8:1169\n76#8,5:1170\n81#8:1201\n85#8:1209\n154#9:1048\n154#9:1088\n154#9:1211\n154#9:1212\n154#9:1213\n154#9:1214\n154#9:1215\n154#9:1291\n154#9:1325\n1864#10,3:1202\n*S KotlinDebug\n*F\n+ 1 TextBlockLayout.kt\nandroidx/glance/oneui/template/layout/compose/TextBlockLayoutKt\n*L\n70#1:703\n81#1:712\n82#1:745\n87#1:776\n89#1:777\n94#1:785\n105#1:821\n125#1:829\n126#1:862\n132#1:893\n135#1:894\n140#1:902\n156#1:938\n157#1:946\n187#1:978\n211#1:1014\n343#1:1022\n426#1:1054\n434#1:1062\n452#1:1096\n491#1:1139\n560#1:1176\n660#1:1210\n224#1:1223\n261#1:1255\n279#1:1299\n284#1:1333\n303#1:1365\n323#1:1407\n81#1:705,6\n81#1:737\n81#1:820\n343#1:1015,6\n343#1:1047\n343#1:1053\n452#1:1089,6\n452#1:1121\n452#1:1126\n81#1:711\n81#1:713,11\n82#1:744\n82#1:746,11\n82#1:774\n94#1:784\n94#1:786,11\n94#1:814\n81#1:819\n125#1:828\n125#1:830,11\n126#1:861\n126#1:863,11\n126#1:891\n140#1:901\n140#1:903,11\n140#1:931\n125#1:936\n157#1:945\n157#1:947,11\n187#1:977\n187#1:979,11\n187#1:1007\n157#1:1012\n343#1:1021\n343#1:1023,11\n343#1:1052\n434#1:1061\n434#1:1063,11\n452#1:1095\n452#1:1097,11\n452#1:1125\n434#1:1130\n491#1:1138\n491#1:1140,11\n491#1:1168\n560#1:1175\n560#1:1177,11\n560#1:1208\n224#1:1222\n224#1:1224,11\n261#1:1254\n261#1:1256,11\n261#1:1284\n224#1:1289\n279#1:1298\n279#1:1300,11\n284#1:1332\n284#1:1334,11\n303#1:1364\n303#1:1366,11\n303#1:1394\n284#1:1399\n323#1:1406\n323#1:1408,11\n323#1:1436\n279#1:1441\n81#1:724,13\n82#1:757,13\n82#1:771,3\n94#1:797,13\n94#1:811,3\n81#1:816,3\n125#1:841,13\n126#1:874,13\n126#1:888,3\n140#1:914,13\n140#1:928,3\n125#1:933,3\n157#1:958,13\n187#1:990,13\n187#1:1004,3\n157#1:1009,3\n343#1:1034,13\n343#1:1049,3\n434#1:1074,13\n452#1:1108,13\n452#1:1122,3\n434#1:1127,3\n491#1:1151,13\n491#1:1165,3\n560#1:1188,13\n560#1:1205,3\n224#1:1235,13\n261#1:1267,13\n261#1:1281,3\n224#1:1286,3\n279#1:1311,13\n284#1:1345,13\n303#1:1377,13\n303#1:1391,3\n284#1:1396,3\n323#1:1419,13\n323#1:1433,3\n279#1:1438,3\n82#1:738,6\n82#1:770\n82#1:775\n94#1:778,6\n94#1:810\n94#1:815\n126#1:855,6\n126#1:887\n126#1:892\n140#1:895,6\n140#1:927\n140#1:932\n157#1:939,6\n157#1:971\n187#1:972,5\n187#1:1003\n187#1:1008\n157#1:1013\n224#1:1216,6\n224#1:1248\n261#1:1249,5\n261#1:1280\n261#1:1285\n224#1:1290\n279#1:1292,6\n279#1:1324\n284#1:1326,6\n284#1:1358\n303#1:1359,5\n303#1:1390\n303#1:1395\n284#1:1400\n323#1:1401,5\n323#1:1432\n323#1:1437\n279#1:1442\n125#1:822,6\n125#1:854\n125#1:937\n434#1:1055,6\n434#1:1087\n434#1:1131\n491#1:1132,6\n491#1:1164\n491#1:1169\n560#1:1170,5\n560#1:1201\n560#1:1209\n373#1:1048\n452#1:1088\n236#1:1211\n238#1:1212\n241#1:1213\n242#1:1214\n243#1:1215\n282#1:1291\n287#1:1325\n574#1:1202,3\n*E\n"})
public final class TextBlockLayoutKt {
    @ComposableTarget(applier = "androidx.compose.ui.UiComposable")
    @Composable
    public static final void ComposeDivider(final boolean z, @Nullable final ColorProvider colorProvider, @Nullable Composer composer, final int i, final int i2) {
        int i4;
        Modifier modifierM15409backgroundbw27NRU$default;
        Composer composerStartRestartGroup = composer.startRestartGroup(287422568);
        if ((i2 & 1) != 0) {
            i4 = i | 6;
        } else if ((i & 14) == 0) {
            i4 = (composerStartRestartGroup.changed(z) ? 4 : 2) | i;
        } else {
            i4 = i;
        }
        int i5 = i2 & 2;
        if (i5 != 0) {
            i4 |= 16;
        }
        if (i5 == 2 && (i4 & 91) == 18 && composerStartRestartGroup.getSkipping()) {
            composerStartRestartGroup.skipToGroupEnd();
        } else {
            if (i5 != 0) {
                colorProvider = null;
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(287422568, i4, -1, "androidx.glance.oneui.template.layout.compose.ComposeDivider (TextBlockLayout.kt:596)");
            }
            long jConvert = ComposeUtilsKt.convert(colorProvider == null ? DayNightColorProvidersKt.m21426ColorProviderOWjLjI(ColorKt.Color(637534208), ColorKt.Color(654311423)) : colorProvider, composerStartRestartGroup, 8);
            if (z) {
                composerStartRestartGroup.startReplaceableGroup(-1766572929);
                modifierM15409backgroundbw27NRU$default = BackgroundKt.m15409backgroundbw27NRU$default(SizeKt.fillMaxHeight$default(SizeKt.m15904width3ABfNKs(Modifier.INSTANCE, PrimitiveResources_androidKt.dimensionResource(C3094R.dimen.sesl_glance_list_item_divider_size, composerStartRestartGroup, 0)), 0.0f, 1, null), jConvert, null, 2, null);
                composerStartRestartGroup.endReplaceableGroup();
            } else {
                composerStartRestartGroup.startReplaceableGroup(-1766572738);
                modifierM15409backgroundbw27NRU$default = BackgroundKt.m15409backgroundbw27NRU$default(SizeKt.m15885height3ABfNKs(SizeKt.fillMaxWidth$default(Modifier.INSTANCE, 0.0f, 1, null), PrimitiveResources_androidKt.dimensionResource(C3094R.dimen.sesl_glance_list_item_divider_size, composerStartRestartGroup, 0)), jConvert, null, 2, null);
                composerStartRestartGroup.endReplaceableGroup();
            }
            SpacerKt.Spacer(modifierM15409backgroundbw27NRU$default, composerStartRestartGroup, 0);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.glance.oneui.template.layout.compose.TextBlockLayoutKt.ComposeDivider.1
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
                    TextBlockLayoutKt.ComposeDivider(z, colorProvider, composer2, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
                }
            });
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:32:0x01d1  */
    /* JADX WARN: Removed duplicated region for block: B:62:0x0339  */
    /* JADX WARN: Removed duplicated region for block: B:80:0x0498  */
    /* JADX WARN: Type inference failed for: r10v33 */
    /* JADX WARN: Type inference failed for: r10v34, types: [boolean, int] */
    /* JADX WARN: Type inference failed for: r10v42 */
    @Composable
    @ComposableInferredTarget(scheme = "[androidx.compose.ui.UiComposable[_][_]]")
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final void ComposeTextBlockLayout(@NotNull final TextBlockItem mainItem, @NotNull final Function2<? super Composer, ? super Integer, Unit> mainContent, @Nullable final TextBlockItem textBlockItem, @Nullable final Function2<? super Composer, ? super Integer, Unit> function2, @Nullable final ColorProvider colorProvider, @Nullable Composer composer, final int i) {
        int i2;
        boolean z;
        ?? r10;
        Intrinsics.checkNotNullParameter(mainItem, "mainItem");
        Intrinsics.checkNotNullParameter(mainContent, "mainContent");
        Composer composerStartRestartGroup = composer.startRestartGroup(1385236973);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(1385236973, i, -1, "androidx.glance.oneui.template.layout.compose.ComposeTextBlockLayout (TextBlockLayout.kt:68)");
        }
        int mask = ((AppWidgetSize) composerStartRestartGroup.consume(CompositionLocalsKt.getLocalWidgetSize())).getMask();
        AppWidgetSize.Companion companion = AppWidgetSize.INSTANCE;
        if (AppWidgetSize.m21550equalsimpl0(mask, companion.m21571getTinyrx25Pp4())) {
            composerStartRestartGroup.startReplaceableGroup(1527045493);
            mainItem.setMode$glance_oneui_template_release(0);
            TextBlockItemLayout(mainItem, mainContent, composerStartRestartGroup, (i & 112) | 8);
            composerStartRestartGroup.endReplaceableGroup();
        } else if (AppWidgetSize.m21550equalsimpl0(mask, companion.m21569getMediumrx25Pp4())) {
            composerStartRestartGroup.startReplaceableGroup(1527045686);
            if (textBlockItem == null || function2 == null) {
                composerStartRestartGroup.startReplaceableGroup(1527045743);
                TextBlockItemLayout(mainItem, mainContent, composerStartRestartGroup, (i & 112) | 8);
                composerStartRestartGroup.endReplaceableGroup();
            } else {
                composerStartRestartGroup.startReplaceableGroup(1527045823);
                Modifier.Companion companion2 = Modifier.INSTANCE;
                Modifier modifierFillMaxSize$default = SizeKt.fillMaxSize$default(companion2, 0.0f, 1, null);
                composerStartRestartGroup.startReplaceableGroup(-483455358);
                Arrangement.Vertical top = Arrangement.INSTANCE.getTop();
                Alignment.Companion companion3 = Alignment.INSTANCE;
                MeasurePolicy measurePolicyM1209j = AbstractC1038a.m1209j(companion3, top, composerStartRestartGroup, 0, -1323940314);
                Density density = (Density) composerStartRestartGroup.consume(androidx.compose.p109ui.platform.CompositionLocalsKt.getLocalDensity());
                LayoutDirection layoutDirection = (LayoutDirection) composerStartRestartGroup.consume(androidx.compose.p109ui.platform.CompositionLocalsKt.getLocalLayoutDirection());
                ViewConfiguration viewConfiguration = (ViewConfiguration) composerStartRestartGroup.consume(androidx.compose.p109ui.platform.CompositionLocalsKt.getLocalViewConfiguration());
                ComposeUiNode.Companion companion4 = ComposeUiNode.INSTANCE;
                Function0<ComposeUiNode> constructor = companion4.getConstructor();
                Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> function3MaterializerOf = LayoutKt.materializerOf(modifierFillMaxSize$default);
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
                Updater.m18025setimpl(composerM18018constructorimpl, layoutDirection, (Function2<? super T, ? super LayoutDirection, Unit>) AbstractC1038a.m1219t(companion4, composerM18018constructorimpl, measurePolicyM1209j, composerM18018constructorimpl, density));
                function3MaterializerOf.invoke(AbstractC1038a.m1206g(companion4, composerM18018constructorimpl, viewConfiguration, composerStartRestartGroup, composerStartRestartGroup), composerStartRestartGroup, 0);
                composerStartRestartGroup.startReplaceableGroup(2058660585);
                ColumnScopeInstance columnScopeInstance = ColumnScopeInstance.INSTANCE;
                Modifier modifierWeight$default = ColumnScope.weight$default(columnScopeInstance, SizeKt.fillMaxWidth$default(companion2, 0.0f, 1, null), 1.0f, false, 2, null);
                composerStartRestartGroup.startReplaceableGroup(733328855);
                MeasurePolicy measurePolicyM1210k = AbstractC1038a.m1210k(companion3, false, composerStartRestartGroup, 0, -1323940314);
                Density density2 = (Density) composerStartRestartGroup.consume(androidx.compose.p109ui.platform.CompositionLocalsKt.getLocalDensity());
                LayoutDirection layoutDirection2 = (LayoutDirection) composerStartRestartGroup.consume(androidx.compose.p109ui.platform.CompositionLocalsKt.getLocalLayoutDirection());
                ViewConfiguration viewConfiguration2 = (ViewConfiguration) composerStartRestartGroup.consume(androidx.compose.p109ui.platform.CompositionLocalsKt.getLocalViewConfiguration());
                Function0<ComposeUiNode> constructor2 = companion4.getConstructor();
                Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> function3MaterializerOf2 = LayoutKt.materializerOf(modifierWeight$default);
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
                Updater.m18025setimpl(composerM18018constructorimpl2, layoutDirection2, (Function2<? super T, ? super LayoutDirection, Unit>) AbstractC1038a.m1219t(companion4, composerM18018constructorimpl2, measurePolicyM1210k, composerM18018constructorimpl2, density2));
                function3MaterializerOf2.invoke(AbstractC1038a.m1206g(companion4, composerM18018constructorimpl2, viewConfiguration2, composerStartRestartGroup, composerStartRestartGroup), composerStartRestartGroup, 0);
                composerStartRestartGroup.startReplaceableGroup(2058660585);
                BoxScopeInstance boxScopeInstance = BoxScopeInstance.INSTANCE;
                TextBlockItemLayout(mainItem, mainContent, composerStartRestartGroup, (i & 112) | 8);
                composerStartRestartGroup.endReplaceableGroup();
                composerStartRestartGroup.endNode();
                composerStartRestartGroup.endReplaceableGroup();
                composerStartRestartGroup.endReplaceableGroup();
                composerStartRestartGroup.startReplaceableGroup(1708846409);
                if (mainItem.getApplyInverseColor() != textBlockItem.getApplyInverseColor()) {
                    GlanceTheme glanceTheme = GlanceTheme.INSTANCE;
                    int i4 = GlanceTheme.$stable;
                    if (ColorKt.m18579toArgb8_81llA(glanceTheme.getColors(composerStartRestartGroup, i4).getBackground().mo21422getColorvNxB06k((Context) composerStartRestartGroup.consume(AndroidCompositionLocals_androidKt.getLocalContext()))) == ColorKt.m18579toArgb8_81llA(glanceTheme.getColors(composerStartRestartGroup, i4).getInverseSurface().mo21422getColorvNxB06k((Context) composerStartRestartGroup.consume(AndroidCompositionLocals_androidKt.getLocalContext())))) {
                        r10 = 0;
                        ComposeDivider(false, colorProvider, composerStartRestartGroup, 70, 0);
                    } else {
                        r10 = 0;
                    }
                    composerStartRestartGroup.endReplaceableGroup();
                    Modifier modifierWeight$default2 = ColumnScope.weight$default(columnScopeInstance, SizeKt.fillMaxWidth$default(companion2, 0.0f, 1, null), 1.0f, false, 2, null);
                    composerStartRestartGroup.startReplaceableGroup(733328855);
                    MeasurePolicy measurePolicyM1210k2 = AbstractC1038a.m1210k(companion3, r10, composerStartRestartGroup, r10, -1323940314);
                    Density density3 = (Density) composerStartRestartGroup.consume(androidx.compose.p109ui.platform.CompositionLocalsKt.getLocalDensity());
                    LayoutDirection layoutDirection3 = (LayoutDirection) composerStartRestartGroup.consume(androidx.compose.p109ui.platform.CompositionLocalsKt.getLocalLayoutDirection());
                    ViewConfiguration viewConfiguration3 = (ViewConfiguration) composerStartRestartGroup.consume(androidx.compose.p109ui.platform.CompositionLocalsKt.getLocalViewConfiguration());
                    Function0<ComposeUiNode> constructor3 = companion4.getConstructor();
                    Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> function3MaterializerOf3 = LayoutKt.materializerOf(modifierWeight$default2);
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
                    TextBlockItemLayout(textBlockItem, function2, composerStartRestartGroup, ((i >> 6) & 112) | 8);
                    composerStartRestartGroup.endReplaceableGroup();
                    composerStartRestartGroup.endNode();
                    composerStartRestartGroup.endReplaceableGroup();
                    composerStartRestartGroup.endReplaceableGroup();
                    composerStartRestartGroup.endReplaceableGroup();
                    composerStartRestartGroup.endNode();
                    composerStartRestartGroup.endReplaceableGroup();
                    composerStartRestartGroup.endReplaceableGroup();
                    composerStartRestartGroup.endReplaceableGroup();
                }
            }
            composerStartRestartGroup.endReplaceableGroup();
        } else {
            composerStartRestartGroup.startReplaceableGroup(1527046762);
            if (textBlockItem == null || function2 == null) {
                composerStartRestartGroup.startReplaceableGroup(1527046819);
                TextBlockItemLayout(mainItem, mainContent, composerStartRestartGroup, (i & 112) | 8);
                composerStartRestartGroup.endReplaceableGroup();
            } else {
                composerStartRestartGroup.startReplaceableGroup(1527046899);
                if (AppWidgetSize.m21550equalsimpl0(((AppWidgetSize) composerStartRestartGroup.consume(CompositionLocalsKt.getLocalWidgetSize())).getMask(), companion.m21573getWideSmallrx25Pp4())) {
                    List<TypedTextData> items = mainItem.getTextList().getItems();
                    List<TypedTextData> items2 = textBlockItem.getTextList().getItems();
                    if (items.size() == 1) {
                        int textType = items.get(0).getTextType();
                        TextType.Companion companion5 = TextType.INSTANCE;
                        if (TextType.m21684equalsimpl0(textType, companion5.m21691getDisplaygxbDmow()) && items2.size() == 1 && TextType.m21684equalsimpl0(items2.get(0).getTextType(), companion5.m21693getLabelgxbDmow()) && TextAlign.m22003equalsimpl0(items2.get(0).getTextAlign(), TextAlign.INSTANCE.m22008getEndROrN78o())) {
                            composerStartRestartGroup.startReplaceableGroup(1527047510);
                            mainItem.setMode$glance_oneui_template_release(0);
                            TextBlockItemLayout(mainItem, ComposableLambdaKt.composableLambda(composerStartRestartGroup, 1747052917, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.glance.oneui.template.layout.compose.TextBlockLayoutKt.ComposeTextBlockLayout.4
                                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                {
                                    super(2);
                                }

                                @Override // kotlin.jvm.functions.Function2
                                public /* bridge */ /* synthetic */ Unit invoke(Composer composer2, Integer num) {
                                    invoke(composer2, num.intValue());
                                    return Unit.INSTANCE;
                                }

                                @ComposableTarget(applier = "androidx.glance.GlanceComposable")
                                @Composable
                                public final void invoke(@Nullable Composer composer2, int i5) {
                                    if ((i5 & 11) == 2 && composer2.getSkipping()) {
                                        composer2.skipToGroupEnd();
                                        return;
                                    }
                                    if (ComposerKt.isTraceInProgress()) {
                                        ComposerKt.traceEventStart(1747052917, i5, -1, "androidx.glance.oneui.template.layout.compose.ComposeTextBlockLayout.<anonymous> (TextBlockLayout.kt:116)");
                                    }
                                    TextBlockLayoutKt.m21811LayoutHorizontalRTYL8B8(CollectionsKt.listOf((Object[]) new TypedTextData[]{mainItem.getTextList().getItems().get(0), textBlockItem.getTextList().getItems().get(0)}), true, mainItem.getDefaultTextColor(composer2, 8), TextAlign.INSTANCE.m22011getStartROrN78o(), composer2, 560);
                                    if (ComposerKt.isTraceInProgress()) {
                                        ComposerKt.traceEventEnd();
                                    }
                                }
                            }), composerStartRestartGroup, 56);
                            composerStartRestartGroup.endReplaceableGroup();
                        } else {
                            composerStartRestartGroup.startReplaceableGroup(1527047967);
                            Modifier.Companion companion6 = Modifier.INSTANCE;
                            Modifier modifierFillMaxSize$default2 = SizeKt.fillMaxSize$default(companion6, 0.0f, 1, null);
                            composerStartRestartGroup.startReplaceableGroup(693286680);
                            Arrangement.Horizontal start = Arrangement.INSTANCE.getStart();
                            Alignment.Companion companion7 = Alignment.INSTANCE;
                            MeasurePolicy measurePolicyM1208i = AbstractC1038a.m1208i(companion7, start, composerStartRestartGroup, 0, -1323940314);
                            Density density4 = (Density) composerStartRestartGroup.consume(androidx.compose.p109ui.platform.CompositionLocalsKt.getLocalDensity());
                            LayoutDirection layoutDirection4 = (LayoutDirection) composerStartRestartGroup.consume(androidx.compose.p109ui.platform.CompositionLocalsKt.getLocalLayoutDirection());
                            ViewConfiguration viewConfiguration4 = (ViewConfiguration) composerStartRestartGroup.consume(androidx.compose.p109ui.platform.CompositionLocalsKt.getLocalViewConfiguration());
                            ComposeUiNode.Companion companion8 = ComposeUiNode.INSTANCE;
                            Function0<ComposeUiNode> constructor4 = companion8.getConstructor();
                            Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> function3MaterializerOf4 = LayoutKt.materializerOf(modifierFillMaxSize$default2);
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
                            Updater.m18025setimpl(composerM18018constructorimpl4, layoutDirection4, (Function2<? super T, ? super LayoutDirection, Unit>) AbstractC1038a.m1219t(companion8, composerM18018constructorimpl4, measurePolicyM1208i, composerM18018constructorimpl4, density4));
                            function3MaterializerOf4.invoke(AbstractC1038a.m1206g(companion8, composerM18018constructorimpl4, viewConfiguration4, composerStartRestartGroup, composerStartRestartGroup), composerStartRestartGroup, 0);
                            composerStartRestartGroup.startReplaceableGroup(2058660585);
                            RowScopeInstance rowScopeInstance = RowScopeInstance.INSTANCE;
                            Modifier modifierFillMaxHeight$default = SizeKt.fillMaxHeight$default(RowScope.weight$default(rowScopeInstance, companion6, 1.0f, false, 2, null), 0.0f, 1, null);
                            composerStartRestartGroup.startReplaceableGroup(733328855);
                            MeasurePolicy measurePolicyM1210k3 = AbstractC1038a.m1210k(companion7, false, composerStartRestartGroup, 0, -1323940314);
                            Density density5 = (Density) composerStartRestartGroup.consume(androidx.compose.p109ui.platform.CompositionLocalsKt.getLocalDensity());
                            LayoutDirection layoutDirection5 = (LayoutDirection) composerStartRestartGroup.consume(androidx.compose.p109ui.platform.CompositionLocalsKt.getLocalLayoutDirection());
                            ViewConfiguration viewConfiguration5 = (ViewConfiguration) composerStartRestartGroup.consume(androidx.compose.p109ui.platform.CompositionLocalsKt.getLocalViewConfiguration());
                            Function0<ComposeUiNode> constructor5 = companion8.getConstructor();
                            Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> function3MaterializerOf5 = LayoutKt.materializerOf(modifierFillMaxHeight$default);
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
                            Updater.m18025setimpl(composerM18018constructorimpl5, layoutDirection5, (Function2<? super T, ? super LayoutDirection, Unit>) AbstractC1038a.m1219t(companion8, composerM18018constructorimpl5, measurePolicyM1210k3, composerM18018constructorimpl5, density5));
                            function3MaterializerOf5.invoke(AbstractC1038a.m1206g(companion8, composerM18018constructorimpl5, viewConfiguration5, composerStartRestartGroup, composerStartRestartGroup), composerStartRestartGroup, 0);
                            composerStartRestartGroup.startReplaceableGroup(2058660585);
                            BoxScopeInstance boxScopeInstance2 = BoxScopeInstance.INSTANCE;
                            TextBlockItemLayout(mainItem, mainContent, composerStartRestartGroup, (i & 112) | 8);
                            composerStartRestartGroup.endReplaceableGroup();
                            composerStartRestartGroup.endNode();
                            composerStartRestartGroup.endReplaceableGroup();
                            composerStartRestartGroup.endReplaceableGroup();
                            composerStartRestartGroup.startReplaceableGroup(1708848571);
                            if (mainItem.getApplyInverseColor() != textBlockItem.getApplyInverseColor()) {
                                GlanceTheme glanceTheme2 = GlanceTheme.INSTANCE;
                                int i5 = GlanceTheme.$stable;
                                if (ColorKt.m18579toArgb8_81llA(glanceTheme2.getColors(composerStartRestartGroup, i5).getBackground().mo21422getColorvNxB06k((Context) composerStartRestartGroup.consume(AndroidCompositionLocals_androidKt.getLocalContext()))) == ColorKt.m18579toArgb8_81llA(glanceTheme2.getColors(composerStartRestartGroup, i5).getInverseSurface().mo21422getColorvNxB06k((Context) composerStartRestartGroup.consume(AndroidCompositionLocals_androidKt.getLocalContext())))) {
                                    i2 = 1;
                                    z = false;
                                    ComposeDivider(true, colorProvider, composerStartRestartGroup, 70, 0);
                                } else {
                                    i2 = 1;
                                    z = false;
                                }
                                composerStartRestartGroup.endReplaceableGroup();
                                boolean z2 = z;
                                Modifier modifierFillMaxHeight$default2 = SizeKt.fillMaxHeight$default(RowScope.weight$default(rowScopeInstance, companion6, 1.0f, false, 2, null), 0.0f, i2, null);
                                composerStartRestartGroup.startReplaceableGroup(733328855);
                                MeasurePolicy measurePolicyM1210k4 = AbstractC1038a.m1210k(companion7, z2, composerStartRestartGroup, z2 ? 1 : 0, -1323940314);
                                Density density6 = (Density) composerStartRestartGroup.consume(androidx.compose.p109ui.platform.CompositionLocalsKt.getLocalDensity());
                                LayoutDirection layoutDirection6 = (LayoutDirection) composerStartRestartGroup.consume(androidx.compose.p109ui.platform.CompositionLocalsKt.getLocalLayoutDirection());
                                ViewConfiguration viewConfiguration6 = (ViewConfiguration) composerStartRestartGroup.consume(androidx.compose.p109ui.platform.CompositionLocalsKt.getLocalViewConfiguration());
                                Function0<ComposeUiNode> constructor6 = companion8.getConstructor();
                                Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> function3MaterializerOf6 = LayoutKt.materializerOf(modifierFillMaxHeight$default2);
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
                                Updater.m18025setimpl(composerM18018constructorimpl6, layoutDirection6, (Function2<? super T, ? super LayoutDirection, Unit>) AbstractC1038a.m1219t(companion8, composerM18018constructorimpl6, measurePolicyM1210k4, composerM18018constructorimpl6, density6));
                                function3MaterializerOf6.invoke(AbstractC1038a.m1206g(companion8, composerM18018constructorimpl6, viewConfiguration6, composerStartRestartGroup, composerStartRestartGroup), composerStartRestartGroup, 0);
                                composerStartRestartGroup.startReplaceableGroup(2058660585);
                                TextBlockItemLayout(textBlockItem, function2, composerStartRestartGroup, ((i >> 6) & 112) | 8);
                                composerStartRestartGroup.endReplaceableGroup();
                                composerStartRestartGroup.endNode();
                                composerStartRestartGroup.endReplaceableGroup();
                                composerStartRestartGroup.endReplaceableGroup();
                                composerStartRestartGroup.endReplaceableGroup();
                                composerStartRestartGroup.endNode();
                                composerStartRestartGroup.endReplaceableGroup();
                                composerStartRestartGroup.endReplaceableGroup();
                                composerStartRestartGroup.endReplaceableGroup();
                            }
                        }
                        composerStartRestartGroup.endReplaceableGroup();
                    }
                }
            }
            composerStartRestartGroup.endReplaceableGroup();
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.glance.oneui.template.layout.compose.TextBlockLayoutKt.ComposeTextBlockLayout.6
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
                    TextBlockLayoutKt.ComposeTextBlockLayout(mainItem, mainContent, textBlockItem, function2, colorProvider, composer2, RecomposeScopeImplKt.updateChangedFlags(i | 1));
                }
            });
        }
    }

    @ComposableTarget(applier = "androidx.compose.ui.UiComposable")
    @Composable
    public static final void ComposeTextBlockText(@NotNull final TypedTextData textData, final boolean z, @NotNull final ColorProvider defaultTextColor, @Nullable Modifier modifier, int i, @Nullable Composer composer, final int i2, final int i4) {
        Intrinsics.checkNotNullParameter(textData, "textData");
        Intrinsics.checkNotNullParameter(defaultTextColor, "defaultTextColor");
        Composer composerStartRestartGroup = composer.startRestartGroup(-783069179);
        Modifier modifier2 = (i4 & 8) != 0 ? Modifier.INSTANCE : modifier;
        int i5 = (i4 & 16) != 0 ? 1 : i;
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-783069179, i2, -1, "androidx.glance.oneui.template.layout.compose.ComposeTextBlockText (TextBlockLayout.kt:657)");
        }
        if (AppWidgetSize.m21550equalsimpl0(((AppWidgetSize) composerStartRestartGroup.consume(CompositionLocalsKt.getLocalWidgetSize())).getMask(), AppWidgetSize.INSTANCE.m21571getTinyrx25Pp4())) {
            textData.m21678setTextAlignb1psNo$glance_oneui_template_release(TextAlign.INSTANCE.m22007getCenterROrN78o());
        }
        int i6 = i2 & 14;
        final int i7 = i5;
        final Modifier modifier3 = modifier2;
        TextKt.ComposeText(textData, getTextSize(textData, z, i5, composerStartRestartGroup, ((i2 >> 6) & 896) | (i2 & 126), 0), getTextColor(textData, defaultTextColor, composerStartRestartGroup, i6 | 64), modifier3, composerStartRestartGroup, (i2 & 7168) | i6 | 512 | (TextPercentData.$stable << 3), 0);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.glance.oneui.template.layout.compose.TextBlockLayoutKt.ComposeTextBlockText.2
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(2);
                }

                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Unit invoke(Composer composer2, Integer num) {
                    invoke(composer2, num.intValue());
                    return Unit.INSTANCE;
                }

                public final void invoke(@Nullable Composer composer2, int i8) {
                    TextBlockLayoutKt.ComposeTextBlockText(textData, z, defaultTextColor, modifier3, i7, composer2, RecomposeScopeImplKt.updateChangedFlags(i2 | 1), i4);
                }
            });
        }
    }

    @ComposableTarget(applier = "androidx.compose.ui.UiComposable")
    @Composable
    public static final void ComposeTextBlockTextList(@NotNull final TypedTextListData textListData, boolean z, @NotNull ColorProvider defaultTextColor, @Nullable Composer composer, final int i) {
        Composer composer2;
        final boolean z2;
        final ColorProvider colorProvider;
        Intrinsics.checkNotNullParameter(textListData, "textListData");
        Intrinsics.checkNotNullParameter(defaultTextColor, "defaultTextColor");
        Composer composerStartRestartGroup = composer.startRestartGroup(1209733891);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(1209733891, i, -1, "androidx.glance.oneui.template.layout.compose.ComposeTextBlockTextList (TextBlockLayout.kt:623)");
        }
        if (textListData.getItems().size() == 1) {
            composerStartRestartGroup.startReplaceableGroup(-1072350988);
            TypedTextData typedTextData = (TypedTextData) CollectionsKt.first((List) textListData.getItems());
            z2 = z;
            composer2 = composerStartRestartGroup;
            ComposeTextBlockText(typedTextData, z2, defaultTextColor, ComposeModifierUtilsKt.padding(SizeKt.wrapContentHeight$default(SizeKt.fillMaxWidth$default(Modifier.INSTANCE, 0.0f, 1, null), null, false, 3, null), TextBlockLayoutDimensions.INSTANCE.m21787textPadding58yVOK4(z2, typedTextData.getTextType(), null, null, null, 0, null, composerStartRestartGroup, ((i >> 3) & 14) | 12582912, 124)), 0, composer2, (i & 112) | 512, 16);
            composer2.endReplaceableGroup();
            colorProvider = defaultTextColor;
        } else {
            composer2 = composerStartRestartGroup;
            if (textListData.getOrientation() == Orientation.Horizontal) {
                composer2.startReplaceableGroup(-1072350460);
                colorProvider = defaultTextColor;
                z2 = z;
                m21811LayoutHorizontalRTYL8B8(textListData.getItems(), z2, colorProvider, textListData.getTextAlign(), composer2, (i & 112) | 520);
                composer2 = composer2;
                composer2.endReplaceableGroup();
            } else {
                z2 = z;
                colorProvider = defaultTextColor;
                composer2.startReplaceableGroup(-1072350284);
                LayoutVertical(textListData.getItems(), z2, colorProvider, composer2, (i & 112) | 520);
                composer2.endReplaceableGroup();
            }
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.glance.oneui.template.layout.compose.TextBlockLayoutKt.ComposeTextBlockTextList.2
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(2);
                }

                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Unit invoke(Composer composer3, Integer num) {
                    invoke(composer3, num.intValue());
                    return Unit.INSTANCE;
                }

                public final void invoke(@Nullable Composer composer3, int i2) {
                    TextBlockLayoutKt.ComposeTextBlockTextList(textListData, z2, colorProvider, composer3, RecomposeScopeImplKt.updateChangedFlags(i | 1));
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:30:0x0275  */
    /* JADX WARN: Removed duplicated region for block: B:35:0x0293  */
    /* JADX WARN: Removed duplicated region for block: B:64:0x0517  */
    @ComposableTarget(applier = "androidx.compose.ui.UiComposable")
    @Composable
    /* JADX INFO: renamed from: LayoutHorizontal-RTYL8B8, reason: not valid java name */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final void m21811LayoutHorizontalRTYL8B8(final List<? extends TypedTextData> list, final boolean z, final ColorProvider colorProvider, final int i, Composer composer, final int i2) {
        Composer composer2;
        List<? extends TypedTextData> list2 = list;
        Composer composerStartRestartGroup = composer.startRestartGroup(-1998922997);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-1998922997, i2, -1, "androidx.glance.oneui.template.layout.compose.LayoutHorizontal (TextBlockLayout.kt:424)");
        }
        int mask = ((AppWidgetSize) composerStartRestartGroup.consume(CompositionLocalsKt.getLocalWidgetSize())).getMask();
        AppWidgetSize.Companion companion = AppWidgetSize.INSTANCE;
        if (AppWidgetSize.m21546compareToL2j3NV4(mask, companion.m21569getMediumrx25Pp4()) >= 0 && list2.size() == 3) {
            int textType = list2.get(0).getTextType();
            TextType.Companion companion2 = TextType.INSTANCE;
            if (TextType.m21684equalsimpl0(textType, companion2.m21691getDisplaygxbDmow()) && TextType.m21684equalsimpl0(list2.get(1).getTextType(), companion2.m21693getLabelgxbDmow()) && TextType.m21684equalsimpl0(list2.get(2).getTextType(), companion2.m21693getLabelgxbDmow())) {
                composerStartRestartGroup.startReplaceableGroup(-582310554);
                Modifier.Companion companion3 = Modifier.INSTANCE;
                Modifier modifierWrapContentHeight$default = SizeKt.wrapContentHeight$default(SizeKt.fillMaxWidth$default(companion3, 0.0f, 1, null), null, false, 3, null);
                Alignment.Companion companion4 = Alignment.INSTANCE;
                Alignment.Vertical bottom = companion4.getBottom();
                composerStartRestartGroup.startReplaceableGroup(693286680);
                Arrangement arrangement = Arrangement.INSTANCE;
                MeasurePolicy measurePolicyM1207h = AbstractC1038a.m1207h(arrangement, bottom, composerStartRestartGroup, 48, -1323940314);
                Density density = (Density) composerStartRestartGroup.consume(androidx.compose.p109ui.platform.CompositionLocalsKt.getLocalDensity());
                LayoutDirection layoutDirection = (LayoutDirection) composerStartRestartGroup.consume(androidx.compose.p109ui.platform.CompositionLocalsKt.getLocalLayoutDirection());
                ViewConfiguration viewConfiguration = (ViewConfiguration) composerStartRestartGroup.consume(androidx.compose.p109ui.platform.CompositionLocalsKt.getLocalViewConfiguration());
                ComposeUiNode.Companion companion5 = ComposeUiNode.INSTANCE;
                Function0<ComposeUiNode> constructor = companion5.getConstructor();
                Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> function3MaterializerOf = LayoutKt.materializerOf(modifierWrapContentHeight$default);
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
                Updater.m18025setimpl(composerM18018constructorimpl, layoutDirection, (Function2<? super T, ? super LayoutDirection, Unit>) AbstractC1038a.m1219t(companion5, composerM18018constructorimpl, measurePolicyM1207h, composerM18018constructorimpl, density));
                function3MaterializerOf.invoke(AbstractC1038a.m1206g(companion5, composerM18018constructorimpl, viewConfiguration, composerStartRestartGroup, composerStartRestartGroup), composerStartRestartGroup, 0);
                composerStartRestartGroup.startReplaceableGroup(2058660585);
                RowScopeInstance rowScopeInstance = RowScopeInstance.INSTANCE;
                TypedTextData typedTextData = list2.get(0);
                TextBlockLayoutDimensions textBlockLayoutDimensions = TextBlockLayoutDimensions.INSTANCE;
                int iM21691getDisplaygxbDmow = companion2.m21691getDisplaygxbDmow();
                TextType textTypeM21680boximpl = TextType.m21680boximpl(companion2.m21693getLabelgxbDmow());
                Orientation orientation = Orientation.Horizontal;
                int i4 = (i2 >> 3) & 14;
                Modifier modifierPadding = ComposeModifierUtilsKt.padding(companion3, textBlockLayoutDimensions.m21787textPadding58yVOK4(z, iM21691getDisplaygxbDmow, textTypeM21680boximpl, null, null, 0, orientation, composerStartRestartGroup, i4 | 14156208, 56));
                int i5 = (i2 & 112) | 512;
                ComposeTextBlockText(typedTextData, z, colorProvider, modifierPadding, 0, composerStartRestartGroup, i5, 16);
                Modifier modifierM15858paddingqDBjuR0$default = PaddingKt.m15858paddingqDBjuR0$default(companion3, 0.0f, 0.0f, 0.0f, C2256Dp.m20968constructorimpl(8), 7, null);
                composerStartRestartGroup.startReplaceableGroup(-483455358);
                MeasurePolicy measurePolicyM1209j = AbstractC1038a.m1209j(companion4, arrangement.getTop(), composerStartRestartGroup, 0, -1323940314);
                Density density2 = (Density) composerStartRestartGroup.consume(androidx.compose.p109ui.platform.CompositionLocalsKt.getLocalDensity());
                LayoutDirection layoutDirection2 = (LayoutDirection) composerStartRestartGroup.consume(androidx.compose.p109ui.platform.CompositionLocalsKt.getLocalLayoutDirection());
                ViewConfiguration viewConfiguration2 = (ViewConfiguration) composerStartRestartGroup.consume(androidx.compose.p109ui.platform.CompositionLocalsKt.getLocalViewConfiguration());
                Function0<ComposeUiNode> constructor2 = companion5.getConstructor();
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
                Updater.m18025setimpl(composerM18018constructorimpl2, layoutDirection2, (Function2<? super T, ? super LayoutDirection, Unit>) AbstractC1038a.m1219t(companion5, composerM18018constructorimpl2, measurePolicyM1209j, composerM18018constructorimpl2, density2));
                function3MaterializerOf2.invoke(AbstractC1038a.m1206g(companion5, composerM18018constructorimpl2, viewConfiguration2, composerStartRestartGroup, composerStartRestartGroup), composerStartRestartGroup, 0);
                composerStartRestartGroup.startReplaceableGroup(2058660585);
                ColumnScopeInstance columnScopeInstance = ColumnScopeInstance.INSTANCE;
                composer2 = composerStartRestartGroup;
                ComposeTextBlockText(list2.get(1), z, colorProvider, ComposeModifierUtilsKt.padding(companion3, textBlockLayoutDimensions.m21787textPadding58yVOK4(z, companion2.m21693getLabelgxbDmow(), TextType.m21680boximpl(companion2.m21693getLabelgxbDmow()), TextType.m21680boximpl(companion2.m21691getDisplaygxbDmow()), null, 0, orientation, composer2, i4 | 14159280, 48)), 0, composerStartRestartGroup, i5, 16);
                ComposeTextBlockText(list2.get(2), z, colorProvider, ComposeModifierUtilsKt.padding(companion3, textBlockLayoutDimensions.m21787textPadding58yVOK4(z, companion2.m21693getLabelgxbDmow(), null, TextType.m21680boximpl(companion2.m21693getLabelgxbDmow()), TextType.m21680boximpl(companion2.m21691getDisplaygxbDmow()), 0, orientation, composer2, i4 | 14183472, 36)), 0, composerStartRestartGroup, i5, 16);
                composerStartRestartGroup.endReplaceableGroup();
                composerStartRestartGroup.endNode();
                composerStartRestartGroup.endReplaceableGroup();
                composerStartRestartGroup.endReplaceableGroup();
                composerStartRestartGroup.endReplaceableGroup();
                composerStartRestartGroup.endNode();
                composerStartRestartGroup.endReplaceableGroup();
                composerStartRestartGroup.endReplaceableGroup();
                composerStartRestartGroup.endReplaceableGroup();
            }
        } else if ((AppWidgetSize.m21550equalsimpl0(mask, companion.m21570getSmallrx25Pp4()) || AppWidgetSize.m21550equalsimpl0(mask, companion.m21573getWideSmallrx25Pp4())) && list2.size() == 2) {
            int textType2 = list2.get(0).getTextType();
            TextType.Companion companion6 = TextType.INSTANCE;
            if (TextType.m21684equalsimpl0(textType2, companion6.m21691getDisplaygxbDmow()) && TextType.m21684equalsimpl0(list2.get(1).getTextType(), companion6.m21690getDescriptiongxbDmow())) {
                composerStartRestartGroup.startReplaceableGroup(-582308122);
                Modifier.Companion companion7 = Modifier.INSTANCE;
                Modifier modifierWrapContentHeight$default2 = SizeKt.wrapContentHeight$default(SizeKt.fillMaxWidth$default(companion7, 0.0f, 1, null), null, false, 3, null);
                Alignment.Vertical centerVertically = Alignment.INSTANCE.getCenterVertically();
                composerStartRestartGroup.startReplaceableGroup(693286680);
                MeasurePolicy measurePolicyM1207h2 = AbstractC1038a.m1207h(Arrangement.INSTANCE, centerVertically, composerStartRestartGroup, 48, -1323940314);
                Density density3 = (Density) composerStartRestartGroup.consume(androidx.compose.p109ui.platform.CompositionLocalsKt.getLocalDensity());
                LayoutDirection layoutDirection3 = (LayoutDirection) composerStartRestartGroup.consume(androidx.compose.p109ui.platform.CompositionLocalsKt.getLocalLayoutDirection());
                ViewConfiguration viewConfiguration3 = (ViewConfiguration) composerStartRestartGroup.consume(androidx.compose.p109ui.platform.CompositionLocalsKt.getLocalViewConfiguration());
                ComposeUiNode.Companion companion8 = ComposeUiNode.INSTANCE;
                Function0<ComposeUiNode> constructor3 = companion8.getConstructor();
                Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> function3MaterializerOf3 = LayoutKt.materializerOf(modifierWrapContentHeight$default2);
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
                Updater.m18025setimpl(composerM18018constructorimpl3, layoutDirection3, (Function2<? super T, ? super LayoutDirection, Unit>) AbstractC1038a.m1219t(companion8, composerM18018constructorimpl3, measurePolicyM1207h2, composerM18018constructorimpl3, density3));
                function3MaterializerOf3.invoke(AbstractC1038a.m1206g(companion8, composerM18018constructorimpl3, viewConfiguration3, composerStartRestartGroup, composerStartRestartGroup), composerStartRestartGroup, 0);
                composerStartRestartGroup.startReplaceableGroup(2058660585);
                RowScopeInstance rowScopeInstance2 = RowScopeInstance.INSTANCE;
                TypedTextData typedTextData2 = list2.get(0);
                Modifier modifierM15408backgroundbw27NRU = BackgroundKt.m15408backgroundbw27NRU(SizeKt.m15899size3ABfNKs(companion7, PrimitiveResources_androidKt.dimensionResource(CombineLayoutDimensions.INSTANCE.getPrimaryContentResIds(composerStartRestartGroup, 6).getSize(), composerStartRestartGroup, 0)), ComposeUtilsKt.convert(GlanceTheme.INSTANCE.getColors(composerStartRestartGroup, GlanceTheme.$stable).getSurface(), composerStartRestartGroup, 8), RoundedCornerShapeKt.m16137RoundedCornerShape0680j_4(CommonDimensions.INSTANCE.m21773getDefaultCornerRadiusD9Ej5fM()));
                TextBlockLayoutDimensions textBlockLayoutDimensions2 = TextBlockLayoutDimensions.INSTANCE;
                int iM21691getDisplaygxbDmow2 = companion6.m21691getDisplaygxbDmow();
                TextType textTypeM21680boximpl2 = TextType.m21680boximpl(companion6.m21690getDescriptiongxbDmow());
                Orientation orientation2 = Orientation.Horizontal;
                int i6 = (i2 >> 3) & 14;
                composer2 = composerStartRestartGroup;
                int i7 = (i2 & 112) | 512;
                ComposeTextBlockText(typedTextData2, z, colorProvider, ComposeModifierUtilsKt.padding(modifierM15408backgroundbw27NRU, textBlockLayoutDimensions2.m21787textPadding58yVOK4(z, iM21691getDisplaygxbDmow2, textTypeM21680boximpl2, null, null, 0, orientation2, composer2, i6 | 14156208, 56)), 0, composerStartRestartGroup, i7, 16);
                ComposeTextBlockText(list2.get(1), z, colorProvider, ComposeModifierUtilsKt.padding(SizeKt.wrapContentHeight$default(RowScope.weight$default(rowScopeInstance2, companion7, 1.0f, false, 2, null), null, false, 3, null), textBlockLayoutDimensions2.m21787textPadding58yVOK4(z, companion6.m21690getDescriptiongxbDmow(), null, TextType.m21680boximpl(companion6.m21691getDisplaygxbDmow()), null, 0, orientation2, composer2, i6 | 14158896, 52)), 0, composerStartRestartGroup, i7, 16);
                composerStartRestartGroup.endReplaceableGroup();
                composerStartRestartGroup.endNode();
                composerStartRestartGroup.endReplaceableGroup();
                composerStartRestartGroup.endReplaceableGroup();
                composerStartRestartGroup.endReplaceableGroup();
            } else if (AppWidgetSize.m21550equalsimpl0(mask, companion.m21573getWideSmallrx25Pp4()) && list2.size() == 2) {
                int textType3 = list2.get(0).getTextType();
                TextType.Companion companion9 = TextType.INSTANCE;
                if (TextType.m21684equalsimpl0(textType3, companion9.m21691getDisplaygxbDmow()) && TextType.m21684equalsimpl0(list2.get(1).getTextType(), companion9.m21693getLabelgxbDmow()) && TextAlign.m22003equalsimpl0(list2.get(1).getTextAlign(), TextAlign.INSTANCE.m22008getEndROrN78o())) {
                    composerStartRestartGroup.startReplaceableGroup(-582306323);
                    ArrayList arrayList = new ArrayList();
                    ArrayList arrayList2 = new ArrayList();
                    composerStartRestartGroup.startReplaceableGroup(-582306215);
                    for (int i8 = 0; i8 < 2; i8++) {
                        Composer composer3 = composerStartRestartGroup;
                        composerStartRestartGroup = composer3;
                        arrayList.add(getTextSize(list2.get(i8), z, 0, composer3, i2 & 112, 2));
                        arrayList2.add(Color.m18515boximpl(ComposeUtilsKt.convert(getTextColor(list2.get(i8), colorProvider, composerStartRestartGroup, 64), composerStartRestartGroup, 8)));
                    }
                    composerStartRestartGroup.endReplaceableGroup();
                    TextBlockLayoutDimensions textBlockLayoutDimensions3 = TextBlockLayoutDimensions.INSTANCE;
                    TextType.Companion companion10 = TextType.INSTANCE;
                    int iM21691getDisplaygxbDmow3 = companion10.m21691getDisplaygxbDmow();
                    TextType textTypeM21680boximpl3 = TextType.m21680boximpl(companion10.m21693getLabelgxbDmow());
                    Orientation orientation3 = Orientation.Horizontal;
                    int i9 = (i2 >> 3) & 14;
                    Composer composer4 = composerStartRestartGroup;
                    TextKt.ComposeTextList(CollectionsKt.take(list2, 2), arrayList, arrayList2, CollectionsKt.listOf((Object[]) new DpRect[]{textBlockLayoutDimensions3.m21787textPadding58yVOK4(z, iM21691getDisplaygxbDmow3, textTypeM21680boximpl3, null, null, 0, orientation3, composer4, i9 | 14156208, 56), textBlockLayoutDimensions3.m21787textPadding58yVOK4(z, companion10.m21693getLabelgxbDmow(), null, TextType.m21680boximpl(companion10.m21691getDisplaygxbDmow()), null, TextAlign.INSTANCE.m22008getEndROrN78o(), orientation3, composer4, i9 | 14158896, 20)}), true, composer4, 25160, 0);
                    composer4.endReplaceableGroup();
                    composer2 = composer4;
                }
            } else {
                composerStartRestartGroup.startReplaceableGroup(-582305313);
                Modifier modifierWrapContentHeight$default3 = SizeKt.wrapContentHeight$default(SizeKt.fillMaxWidth$default(Modifier.INSTANCE, 0.0f, 1, null), null, false, 3, null);
                TextAlign.Companion companion11 = TextAlign.INSTANCE;
                Arrangement.Horizontal start = TextAlign.m22003equalsimpl0(i, companion11.m22011getStartROrN78o()) ? true : TextAlign.m22003equalsimpl0(i, companion11.m22009getLeftROrN78o()) ? Arrangement.INSTANCE.getStart() : TextAlign.m22003equalsimpl0(i, companion11.m22007getCenterROrN78o()) ? Arrangement.INSTANCE.getCenter() : Arrangement.INSTANCE.getEnd();
                composerStartRestartGroup.startReplaceableGroup(693286680);
                int i10 = 0;
                MeasurePolicy measurePolicyM1208i = AbstractC1038a.m1208i(Alignment.INSTANCE, start, composerStartRestartGroup, 0, -1323940314);
                Density density4 = (Density) composerStartRestartGroup.consume(androidx.compose.p109ui.platform.CompositionLocalsKt.getLocalDensity());
                LayoutDirection layoutDirection4 = (LayoutDirection) composerStartRestartGroup.consume(androidx.compose.p109ui.platform.CompositionLocalsKt.getLocalLayoutDirection());
                ViewConfiguration viewConfiguration4 = (ViewConfiguration) composerStartRestartGroup.consume(androidx.compose.p109ui.platform.CompositionLocalsKt.getLocalViewConfiguration());
                ComposeUiNode.Companion companion12 = ComposeUiNode.INSTANCE;
                Function0<ComposeUiNode> constructor4 = companion12.getConstructor();
                Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> function3MaterializerOf4 = LayoutKt.materializerOf(modifierWrapContentHeight$default3);
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
                Updater.m18025setimpl(composerM18018constructorimpl4, layoutDirection4, (Function2<? super T, ? super LayoutDirection, Unit>) AbstractC1038a.m1219t(companion12, composerM18018constructorimpl4, measurePolicyM1208i, composerM18018constructorimpl4, density4));
                function3MaterializerOf4.invoke(AbstractC1038a.m1206g(companion12, composerM18018constructorimpl4, viewConfiguration4, composerStartRestartGroup, composerStartRestartGroup), composerStartRestartGroup, 0);
                composerStartRestartGroup.startReplaceableGroup(2058660585);
                RowScopeInstance rowScopeInstance3 = RowScopeInstance.INSTANCE;
                ArrayList arrayList3 = new ArrayList();
                ArrayList arrayList4 = new ArrayList();
                ArrayList arrayList5 = new ArrayList();
                int size = list2.size() - 1;
                composerStartRestartGroup.startReplaceableGroup(-1986073884);
                for (Object obj : list2) {
                    int i11 = i10 + 1;
                    if (i10 < 0) {
                        CollectionsKt.throwIndexOverflow();
                    }
                    TypedTextData typedTextData3 = (TypedTextData) obj;
                    if (i10 == 0 || i10 == size) {
                        typedTextData3.m21678setTextAlignb1psNo$glance_oneui_template_release(i);
                    }
                    Composer composer5 = composerStartRestartGroup;
                    arrayList3.add(getTextSize(list2.get(i10), z, 0, composer5, i2 & 112, 2));
                    arrayList4.add(Color.m18515boximpl(ComposeUtilsKt.convert(getTextColor(list2.get(i10), colorProvider, composer5, 64), composer5, 8)));
                    int i12 = size;
                    arrayList5.add(TextBlockLayoutDimensions.INSTANCE.textPadding(list2, i10, i12, z, Orientation.Horizontal, composer5, ((i2 << 6) & 7168) | 221192, 0));
                    list2 = list;
                    size = i12;
                    i10 = i11;
                    composerStartRestartGroup = composer5;
                }
                composer2 = composerStartRestartGroup;
                composer2.endReplaceableGroup();
                TextKt.ComposeTextList(list, arrayList3, arrayList4, arrayList5, false, composer2, 4680, 16);
                composer2.endReplaceableGroup();
                composer2.endNode();
                composer2.endReplaceableGroup();
                composer2.endReplaceableGroup();
                composer2.endReplaceableGroup();
            }
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.glance.oneui.template.layout.compose.TextBlockLayoutKt$LayoutHorizontal$5
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                /* JADX WARN: Multi-variable type inference failed */
                {
                    super(2);
                }

                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Unit invoke(Composer composer6, Integer num) {
                    invoke(composer6, num.intValue());
                    return Unit.INSTANCE;
                }

                public final void invoke(@Nullable Composer composer6, int i13) {
                    TextBlockLayoutKt.m21811LayoutHorizontalRTYL8B8(list, z, colorProvider, i, composer6, RecomposeScopeImplKt.updateChangedFlags(i2 | 1));
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:38:0x01e8  */
    /* JADX WARN: Type inference failed for: r0v12, types: [T, androidx.compose.ui.Modifier] */
    @ComposableTarget(applier = "androidx.compose.ui.UiComposable")
    @Composable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final void LayoutVertical(List<? extends TypedTextData> list, final boolean z, final ColorProvider colorProvider, Composer composer, final int i) {
        int i2;
        Modifier modifier;
        List<? extends TypedTextData> list2;
        int i4;
        int i5;
        int i6;
        int i7;
        List<? extends TypedTextData> list3 = list;
        final boolean z2 = z;
        Composer composerStartRestartGroup = composer.startRestartGroup(-741219095);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-741219095, i, -1, "androidx.glance.oneui.template.layout.compose.LayoutVertical (TextBlockLayout.kt:209)");
        }
        int mask = ((AppWidgetSize) composerStartRestartGroup.consume(CompositionLocalsKt.getLocalWidgetSize())).getMask();
        int i8 = i & 112;
        int iVisibleTextCount = TextBlockLayoutDimensions.INSTANCE.visibleTextCount(list3.size(), z2, composerStartRestartGroup, i8 | 384);
        Modifier.Companion companion = Modifier.INSTANCE;
        int i9 = 0;
        Modifier modifierWrapContentHeight$default = SizeKt.wrapContentHeight$default(SizeKt.fillMaxWidth$default(companion, 0.0f, 1, null), null, false, 3, null);
        Modifier modifierWrapContentHeight$default2 = SizeKt.wrapContentHeight$default(SizeKt.fillMaxWidth$default(companion, 0.0f, 1, null), null, false, 3, null);
        composerStartRestartGroup.startReplaceableGroup(-483455358);
        MeasurePolicy measurePolicyM1209j = AbstractC1038a.m1209j(Alignment.INSTANCE, Arrangement.INSTANCE.getTop(), composerStartRestartGroup, 0, -1323940314);
        Density density = (Density) composerStartRestartGroup.consume(androidx.compose.p109ui.platform.CompositionLocalsKt.getLocalDensity());
        LayoutDirection layoutDirection = (LayoutDirection) composerStartRestartGroup.consume(androidx.compose.p109ui.platform.CompositionLocalsKt.getLocalLayoutDirection());
        ViewConfiguration viewConfiguration = (ViewConfiguration) composerStartRestartGroup.consume(androidx.compose.p109ui.platform.CompositionLocalsKt.getLocalViewConfiguration());
        ComposeUiNode.Companion companion2 = ComposeUiNode.INSTANCE;
        Function0<ComposeUiNode> constructor = companion2.getConstructor();
        Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> function3MaterializerOf = LayoutKt.materializerOf(modifierWrapContentHeight$default2);
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
        Updater.m18025setimpl(composerM18018constructorimpl, layoutDirection, (Function2<? super T, ? super LayoutDirection, Unit>) AbstractC1038a.m1219t(companion2, composerM18018constructorimpl, measurePolicyM1209j, composerM18018constructorimpl, density));
        AbstractC1038a.m1221v(0, function3MaterializerOf, AbstractC1038a.m1206g(companion2, composerM18018constructorimpl, viewConfiguration, composerStartRestartGroup, composerStartRestartGroup), composerStartRestartGroup, 2058660585);
        ColumnScopeInstance columnScopeInstance = ColumnScopeInstance.INSTANCE;
        int i10 = iVisibleTextCount - 1;
        composerStartRestartGroup.startReplaceableGroup(-1978385623);
        int i11 = 0;
        while (i11 < iVisibleTextCount) {
            final TypedTextData typedTextData = list3.get(i11);
            if (typedTextData instanceof CustomTypedTextData) {
                composerStartRestartGroup.startReplaceableGroup(-1718151869);
                CustomTypedTextData customTypedTextData = (CustomTypedTextData) typedTextData;
                customTypedTextData.CustomContent(customTypedTextData, composerStartRestartGroup, i9);
                i11++;
                composerStartRestartGroup.endReplaceableGroup();
            } else if (typedTextData instanceof TypedTextListData) {
                composerStartRestartGroup.startReplaceableGroup(-1718151732);
                Composer composer2 = composerStartRestartGroup;
                m21811LayoutHorizontalRTYL8B8(((TypedTextListData) typedTextData).getItems(), z2, colorProvider, typedTextData.getTextAlign(), composer2, i8 | 520);
                i11++;
                composer2.endReplaceableGroup();
                z2 = z;
                composerStartRestartGroup = composer2;
            } else {
                composerStartRestartGroup.startReplaceableGroup(-1718151437);
                final int i12 = iVisibleTextCount;
                TextBlockLayoutDimensions textBlockLayoutDimensions = TextBlockLayoutDimensions.INSTANCE;
                int i13 = i11;
                int numberToGroup = textBlockLayoutDimensions.getNumberToGroup(list3, i13, z, i12, composerStartRestartGroup, ((i << 3) & 896) | 24584);
                Composer composer3 = composerStartRestartGroup;
                if (numberToGroup > 0) {
                    composer3.startReplaceableGroup(-1718151303);
                    int i14 = mask;
                    z2 = z;
                    Modifier modifier2 = modifierWrapContentHeight$default;
                    LayoutVertical$TextGroup(i12, list, i14, z2, colorProvider, modifier2, i13, numberToGroup, composer3, 0);
                    i2 = i14;
                    composer3 = composer3;
                    i7 = i13 + numberToGroup;
                    composer3.endReplaceableGroup();
                    list2 = list;
                    i4 = i10;
                    i5 = i12;
                    modifier = modifier2;
                } else {
                    i2 = mask;
                    Modifier modifier3 = modifierWrapContentHeight$default;
                    composer3.startReplaceableGroup(-1718151195);
                    composer3.startReplaceableGroup(-1718151169);
                    int textType = typedTextData.getTextType();
                    TextType.Companion companion3 = TextType.INSTANCE;
                    if (TextType.m21684equalsimpl0(textType, companion3.m21689getBodygxbDmow()) && i13 > 0 && TextType.m21684equalsimpl0(list.get(i13 - 1).getTextType(), companion3.m21694getTitlegxbDmow()) && AppWidgetSize.m21546compareToL2j3NV4(i2, AppWidgetSize.INSTANCE.m21569getMediumrx25Pp4()) >= 0) {
                        SpacerKt.Spacer(SizeKt.m15885height3ABfNKs(Modifier.INSTANCE, C2256Dp.m20968constructorimpl(2)), composer3, 6);
                    }
                    composer3.endReplaceableGroup();
                    final Ref.ObjectRef objectRef = new Ref.ObjectRef();
                    int i15 = i10;
                    modifier = modifier3;
                    list2 = list;
                    i4 = i15;
                    objectRef.element = ComposeModifierUtilsKt.padding(modifier, textBlockLayoutDimensions.textPadding(list, i13, i15, z, null, composer3, ((i << 6) & 7168) | 196616, 16));
                    if (!z) {
                        AppWidgetSize.Companion companion4 = AppWidgetSize.INSTANCE;
                        if ((AppWidgetSize.m21550equalsimpl0(i2, companion4.m21570getSmallrx25Pp4()) || AppWidgetSize.m21550equalsimpl0(i2, companion4.m21573getWideSmallrx25Pp4())) && i13 == 2) {
                            composer3.startReplaceableGroup(-1718150112);
                            int i16 = C3094R.integer.sesl_glance_multi_textblock_small_3rd_text_visibility;
                            Function2<Composer, Integer, Unit> function2 = new Function2<Composer, Integer, Unit>() { // from class: androidx.glance.oneui.template.layout.compose.TextBlockLayoutKt$LayoutVertical$1$1
                                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                {
                                    super(2);
                                }

                                @Override // kotlin.jvm.functions.Function2
                                public /* bridge */ /* synthetic */ Unit invoke(Composer composer4, Integer num) {
                                    invoke(composer4, num.intValue());
                                    return Unit.INSTANCE;
                                }

                                @ComposableTarget(applier = "androidx.compose.ui.UiComposable")
                                @Composable
                                public final void invoke(@Nullable Composer composer4, int i17) {
                                    if ((i17 & 11) == 2 && composer4.getSkipping()) {
                                        composer4.skipToGroupEnd();
                                        return;
                                    }
                                    if (ComposerKt.isTraceInProgress()) {
                                        ComposerKt.traceEventStart(520598906, i17, -1, "androidx.glance.oneui.template.layout.compose.LayoutVertical.<anonymous>.<anonymous> (TextBlockLayout.kt:393)");
                                    }
                                    TextBlockLayoutKt.ComposeTextBlockText(typedTextData, z, colorProvider, objectRef.element, i12, composer4, 512, 0);
                                    if (ComposerKt.isTraceInProgress()) {
                                        ComposerKt.traceEventEnd();
                                    }
                                }
                            };
                            i5 = i12;
                            ComposeModifierUtilsKt.visibility(i16, ComposableLambdaKt.composableLambda(composer3, 520598906, true, function2), composer3, 48);
                            composer3.endReplaceableGroup();
                            z2 = z;
                            i6 = i13;
                        } else {
                            i5 = i12;
                            composer3.startReplaceableGroup(-1718149452);
                            i6 = i13;
                            ComposeTextBlockText(typedTextData, z, colorProvider, (Modifier) objectRef.element, i5, composer3, i8 | 512, 0);
                            z2 = z;
                            composer3 = composer3;
                            composer3.endReplaceableGroup();
                        }
                        i7 = i6 + 1;
                        composer3.endReplaceableGroup();
                    }
                }
                composer3.endReplaceableGroup();
                composerStartRestartGroup = composer3;
                list3 = list2;
                mask = i2;
                modifierWrapContentHeight$default = modifier;
                i10 = i4;
                i9 = 0;
                i11 = i7;
                iVisibleTextCount = i5;
            }
        }
        final List<? extends TypedTextData> list4 = list3;
        Composer composer4 = composerStartRestartGroup;
        composer4.endReplaceableGroup();
        composer4.endReplaceableGroup();
        composer4.endNode();
        composer4.endReplaceableGroup();
        composer4.endReplaceableGroup();
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composer4.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.glance.oneui.template.layout.compose.TextBlockLayoutKt.LayoutVertical.2
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                /* JADX WARN: Multi-variable type inference failed */
                {
                    super(2);
                }

                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Unit invoke(Composer composer5, Integer num) {
                    invoke(composer5, num.intValue());
                    return Unit.INSTANCE;
                }

                public final void invoke(@Nullable Composer composer5, int i17) {
                    TextBlockLayoutKt.LayoutVertical(list4, z2, colorProvider, composer5, RecomposeScopeImplKt.updateChangedFlags(i | 1));
                }
            });
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:30:0x00a7  */
    @ComposableTarget(applier = "androidx.compose.ui.UiComposable")
    @Composable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private static final void LayoutVertical$TextGroup(int i, List<? extends TypedTextData> list, int i2, boolean z, ColorProvider colorProvider, Modifier modifier, int i4, int i5, Composer composer, int i6) {
        float fM20968constructorimpl;
        int i7;
        composer.startReplaceableGroup(1746660505);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(1746660505, i6, -1, "androidx.glance.oneui.template.layout.compose.LayoutVertical.TextGroup (TextBlockLayout.kt:215)");
        }
        if (i4 + i5 > i) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            composer.endReplaceableGroup();
            return;
        }
        TypedTextData typedTextData = list.get(i4);
        TypedTextData typedTextData2 = list.get(i4 + 1);
        TypedTextData typedTextData3 = i5 == 3 ? list.get(i4 + 2) : null;
        if (typedTextData3 == null) {
            composer.startReplaceableGroup(-331481765);
            Modifier.Companion companion = Modifier.INSTANCE;
            Modifier modifierFillMaxWidth$default = SizeKt.fillMaxWidth$default(companion, 0.0f, 1, null);
            composer.startReplaceableGroup(-331481614);
            AppWidgetSize.Companion companion2 = AppWidgetSize.INSTANCE;
            if (AppWidgetSize.m21550equalsimpl0(i2, companion2.m21571getTinyrx25Pp4())) {
                int textType = typedTextData.getTextType();
                TextType.Companion companion3 = TextType.INSTANCE;
                if (TextType.m21684equalsimpl0(textType, companion3.m21691getDisplaygxbDmow())) {
                    i7 = 3;
                    if (typedTextData.getTextLength(composer, 0) <= 3) {
                        fM20968constructorimpl = C2256Dp.m20968constructorimpl(38);
                    }
                } else {
                    i7 = 3;
                }
                if (!TextType.m21684equalsimpl0(typedTextData2.getTextType(), companion3.m21691getDisplaygxbDmow()) || typedTextData2.getTextLength(composer, 0) > i7) {
                    fM20968constructorimpl = C2256Dp.m20968constructorimpl(29);
                }
            } else {
                if (AppWidgetSize.m21550equalsimpl0(i2, companion2.m21570getSmallrx25Pp4()) ? true : AppWidgetSize.m21550equalsimpl0(i2, companion2.m21573getWideSmallrx25Pp4())) {
                    fM20968constructorimpl = C2256Dp.m20968constructorimpl(42);
                } else if (AppWidgetSize.m21550equalsimpl0(i2, companion2.m21569getMediumrx25Pp4())) {
                    fM20968constructorimpl = C2256Dp.m20968constructorimpl(z ? 66 : 57);
                } else {
                    fM20968constructorimpl = C2256Dp.m20968constructorimpl(66);
                }
            }
            composer.endReplaceableGroup();
            Modifier modifierM15885height3ABfNKs = SizeKt.m15885height3ABfNKs(modifierFillMaxWidth$default, fM20968constructorimpl);
            composer.startReplaceableGroup(733328855);
            Alignment.Companion companion4 = Alignment.INSTANCE;
            MeasurePolicy measurePolicyM1210k = AbstractC1038a.m1210k(companion4, false, composer, 0, -1323940314);
            Density density = (Density) composer.consume(androidx.compose.p109ui.platform.CompositionLocalsKt.getLocalDensity());
            LayoutDirection layoutDirection = (LayoutDirection) composer.consume(androidx.compose.p109ui.platform.CompositionLocalsKt.getLocalLayoutDirection());
            ViewConfiguration viewConfiguration = (ViewConfiguration) composer.consume(androidx.compose.p109ui.platform.CompositionLocalsKt.getLocalViewConfiguration());
            ComposeUiNode.Companion companion5 = ComposeUiNode.INSTANCE;
            Function0<ComposeUiNode> constructor = companion5.getConstructor();
            Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> function3MaterializerOf = LayoutKt.materializerOf(modifierM15885height3ABfNKs);
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
            Updater.m18025setimpl(composerM18018constructorimpl, layoutDirection, (Function2<? super T, ? super LayoutDirection, Unit>) AbstractC1038a.m1219t(companion5, composerM18018constructorimpl, measurePolicyM1210k, composerM18018constructorimpl, density));
            function3MaterializerOf.invoke(AbstractC1038a.m1206g(companion5, composerM18018constructorimpl, viewConfiguration, composer, composer), composer, 0);
            composer.startReplaceableGroup(2058660585);
            BoxScopeInstance boxScopeInstance = BoxScopeInstance.INSTANCE;
            TextBlockLayoutDimensions textBlockLayoutDimensions = TextBlockLayoutDimensions.INSTANCE;
            int i8 = i - 1;
            int i9 = ((i6 << 3) & 112) | 196616;
            ComposeTextBlockText(typedTextData, z, colorProvider, ComposeModifierUtilsKt.padding(modifier, textBlockLayoutDimensions.textPadding(list, i4, i8, z, null, composer, i9, 16)), i, composer, 512, 0);
            Modifier modifierFillMaxSize$default = SizeKt.fillMaxSize$default(companion, 0.0f, 1, null);
            Alignment bottomStart = companion4.getBottomStart();
            composer.startReplaceableGroup(733328855);
            MeasurePolicy measurePolicyRememberBoxMeasurePolicy = BoxKt.rememberBoxMeasurePolicy(bottomStart, false, composer, 6);
            Density density2 = (Density) AbstractC1038a.m1211l(composer, -1323940314);
            LayoutDirection layoutDirection2 = (LayoutDirection) composer.consume(androidx.compose.p109ui.platform.CompositionLocalsKt.getLocalLayoutDirection());
            ViewConfiguration viewConfiguration2 = (ViewConfiguration) composer.consume(androidx.compose.p109ui.platform.CompositionLocalsKt.getLocalViewConfiguration());
            Function0<ComposeUiNode> constructor2 = companion5.getConstructor();
            Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> function3MaterializerOf2 = LayoutKt.materializerOf(modifierFillMaxSize$default);
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
            Updater.m18025setimpl(composerM18018constructorimpl2, layoutDirection2, (Function2<? super T, ? super LayoutDirection, Unit>) AbstractC1038a.m1219t(companion5, composerM18018constructorimpl2, measurePolicyRememberBoxMeasurePolicy, composerM18018constructorimpl2, density2));
            function3MaterializerOf2.invoke(AbstractC1038a.m1206g(companion5, composerM18018constructorimpl2, viewConfiguration2, composer, composer), composer, 0);
            composer.startReplaceableGroup(2058660585);
            ComposeTextBlockText(typedTextData2, z, colorProvider, ComposeModifierUtilsKt.padding(modifier, textBlockLayoutDimensions.textPadding(list, i4, i8, z, null, composer, i9, 16)), i, composer, 512, 0);
            composer.endReplaceableGroup();
            composer.endNode();
            composer.endReplaceableGroup();
            composer.endReplaceableGroup();
            composer.endReplaceableGroup();
            composer.endNode();
            composer.endReplaceableGroup();
            composer.endReplaceableGroup();
            composer.endReplaceableGroup();
        } else {
            composer.startReplaceableGroup(-331479407);
            Modifier.Companion companion6 = Modifier.INSTANCE;
            Modifier modifierFillMaxWidth$default2 = SizeKt.fillMaxWidth$default(companion6, 0.0f, 1, null);
            AppWidgetSize.Companion companion7 = AppWidgetSize.INSTANCE;
            Modifier modifierM15885height3ABfNKs2 = SizeKt.m15885height3ABfNKs(modifierFillMaxWidth$default2, C2256Dp.m20968constructorimpl(AppWidgetSize.m21546compareToL2j3NV4(i2, companion7.m21568getLargerx25Pp4()) < 0 ? 79 : 80));
            composer.startReplaceableGroup(733328855);
            Alignment.Companion companion8 = Alignment.INSTANCE;
            MeasurePolicy measurePolicyM1210k2 = AbstractC1038a.m1210k(companion8, false, composer, 0, -1323940314);
            Density density3 = (Density) composer.consume(androidx.compose.p109ui.platform.CompositionLocalsKt.getLocalDensity());
            LayoutDirection layoutDirection3 = (LayoutDirection) composer.consume(androidx.compose.p109ui.platform.CompositionLocalsKt.getLocalLayoutDirection());
            ViewConfiguration viewConfiguration3 = (ViewConfiguration) composer.consume(androidx.compose.p109ui.platform.CompositionLocalsKt.getLocalViewConfiguration());
            ComposeUiNode.Companion companion9 = ComposeUiNode.INSTANCE;
            Function0<ComposeUiNode> constructor3 = companion9.getConstructor();
            Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> function3MaterializerOf3 = LayoutKt.materializerOf(modifierM15885height3ABfNKs2);
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
            Updater.m18025setimpl(composerM18018constructorimpl3, layoutDirection3, (Function2<? super T, ? super LayoutDirection, Unit>) AbstractC1038a.m1219t(companion9, composerM18018constructorimpl3, measurePolicyM1210k2, composerM18018constructorimpl3, density3));
            function3MaterializerOf3.invoke(AbstractC1038a.m1206g(companion9, composerM18018constructorimpl3, viewConfiguration3, composer, composer), composer, 0);
            composer.startReplaceableGroup(2058660585);
            BoxScopeInstance boxScopeInstance2 = BoxScopeInstance.INSTANCE;
            Modifier modifierM15885height3ABfNKs3 = SizeKt.m15885height3ABfNKs(SizeKt.fillMaxWidth$default(companion6, 0.0f, 1, null), C2256Dp.m20968constructorimpl(AppWidgetSize.m21546compareToL2j3NV4(i2, companion7.m21568getLargerx25Pp4()) < 0 ? 66 : 69));
            composer.startReplaceableGroup(733328855);
            MeasurePolicy measurePolicyM1210k3 = AbstractC1038a.m1210k(companion8, false, composer, 0, -1323940314);
            Density density4 = (Density) composer.consume(androidx.compose.p109ui.platform.CompositionLocalsKt.getLocalDensity());
            LayoutDirection layoutDirection4 = (LayoutDirection) composer.consume(androidx.compose.p109ui.platform.CompositionLocalsKt.getLocalLayoutDirection());
            ViewConfiguration viewConfiguration4 = (ViewConfiguration) composer.consume(androidx.compose.p109ui.platform.CompositionLocalsKt.getLocalViewConfiguration());
            Function0<ComposeUiNode> constructor4 = companion9.getConstructor();
            Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> function3MaterializerOf4 = LayoutKt.materializerOf(modifierM15885height3ABfNKs3);
            if (composer.getApplier() == null) {
                ComposablesKt.invalidApplier();
            }
            composer.startReusableNode();
            if (composer.getInserting()) {
                composer.createNode(constructor4);
            } else {
                composer.useNode();
            }
            composer.disableReusing();
            Composer composerM18018constructorimpl4 = Updater.m18018constructorimpl(composer);
            Updater.m18025setimpl(composerM18018constructorimpl4, layoutDirection4, (Function2<? super T, ? super LayoutDirection, Unit>) AbstractC1038a.m1219t(companion9, composerM18018constructorimpl4, measurePolicyM1210k3, composerM18018constructorimpl4, density4));
            function3MaterializerOf4.invoke(AbstractC1038a.m1206g(companion9, composerM18018constructorimpl4, viewConfiguration4, composer, composer), composer, 0);
            composer.startReplaceableGroup(2058660585);
            TextBlockLayoutDimensions textBlockLayoutDimensions2 = TextBlockLayoutDimensions.INSTANCE;
            int i10 = i - 1;
            int i11 = ((i6 << 3) & 112) | 196616;
            TypedTextData typedTextData4 = typedTextData3;
            ComposeTextBlockText(typedTextData, z, colorProvider, ComposeModifierUtilsKt.padding(modifier, textBlockLayoutDimensions2.textPadding(list, i4, i10, z, null, composer, i11, 16)), i, composer, 512, 0);
            Modifier modifierFillMaxSize$default2 = SizeKt.fillMaxSize$default(companion6, 0.0f, 1, null);
            Alignment bottomStart2 = companion8.getBottomStart();
            composer.startReplaceableGroup(733328855);
            MeasurePolicy measurePolicyRememberBoxMeasurePolicy2 = BoxKt.rememberBoxMeasurePolicy(bottomStart2, false, composer, 6);
            Density density5 = (Density) AbstractC1038a.m1211l(composer, -1323940314);
            LayoutDirection layoutDirection5 = (LayoutDirection) composer.consume(androidx.compose.p109ui.platform.CompositionLocalsKt.getLocalLayoutDirection());
            ViewConfiguration viewConfiguration5 = (ViewConfiguration) composer.consume(androidx.compose.p109ui.platform.CompositionLocalsKt.getLocalViewConfiguration());
            Function0<ComposeUiNode> constructor5 = companion9.getConstructor();
            Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> function3MaterializerOf5 = LayoutKt.materializerOf(modifierFillMaxSize$default2);
            if (composer.getApplier() == null) {
                ComposablesKt.invalidApplier();
            }
            composer.startReusableNode();
            if (composer.getInserting()) {
                composer.createNode(constructor5);
            } else {
                composer.useNode();
            }
            composer.disableReusing();
            Composer composerM18018constructorimpl5 = Updater.m18018constructorimpl(composer);
            Updater.m18025setimpl(composerM18018constructorimpl5, layoutDirection5, (Function2<? super T, ? super LayoutDirection, Unit>) AbstractC1038a.m1219t(companion9, composerM18018constructorimpl5, measurePolicyRememberBoxMeasurePolicy2, composerM18018constructorimpl5, density5));
            function3MaterializerOf5.invoke(AbstractC1038a.m1206g(companion9, composerM18018constructorimpl5, viewConfiguration5, composer, composer), composer, 0);
            composer.startReplaceableGroup(2058660585);
            ComposeTextBlockText(typedTextData2, z, colorProvider, ComposeModifierUtilsKt.padding(modifier, textBlockLayoutDimensions2.textPadding(list, i4, i10, z, null, composer, i11, 16)), i, composer, 512, 0);
            composer.endReplaceableGroup();
            composer.endNode();
            composer.endReplaceableGroup();
            composer.endReplaceableGroup();
            composer.endReplaceableGroup();
            composer.endNode();
            composer.endReplaceableGroup();
            composer.endReplaceableGroup();
            Modifier modifierFillMaxSize$default3 = SizeKt.fillMaxSize$default(companion6, 0.0f, 1, null);
            Alignment bottomStart3 = companion8.getBottomStart();
            composer.startReplaceableGroup(733328855);
            MeasurePolicy measurePolicyRememberBoxMeasurePolicy3 = BoxKt.rememberBoxMeasurePolicy(bottomStart3, false, composer, 6);
            Density density6 = (Density) AbstractC1038a.m1211l(composer, -1323940314);
            LayoutDirection layoutDirection6 = (LayoutDirection) composer.consume(androidx.compose.p109ui.platform.CompositionLocalsKt.getLocalLayoutDirection());
            ViewConfiguration viewConfiguration6 = (ViewConfiguration) composer.consume(androidx.compose.p109ui.platform.CompositionLocalsKt.getLocalViewConfiguration());
            Function0<ComposeUiNode> constructor6 = companion9.getConstructor();
            Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> function3MaterializerOf6 = LayoutKt.materializerOf(modifierFillMaxSize$default3);
            if (composer.getApplier() == null) {
                ComposablesKt.invalidApplier();
            }
            composer.startReusableNode();
            if (composer.getInserting()) {
                composer.createNode(constructor6);
            } else {
                composer.useNode();
            }
            composer.disableReusing();
            Composer composerM18018constructorimpl6 = Updater.m18018constructorimpl(composer);
            Updater.m18025setimpl(composerM18018constructorimpl6, layoutDirection6, (Function2<? super T, ? super LayoutDirection, Unit>) AbstractC1038a.m1219t(companion9, composerM18018constructorimpl6, measurePolicyRememberBoxMeasurePolicy3, composerM18018constructorimpl6, density6));
            function3MaterializerOf6.invoke(AbstractC1038a.m1206g(companion9, composerM18018constructorimpl6, viewConfiguration6, composer, composer), composer, 0);
            composer.startReplaceableGroup(2058660585);
            ComposeTextBlockText(typedTextData4, z, colorProvider, ComposeModifierUtilsKt.padding(modifier, textBlockLayoutDimensions2.textPadding(list, i4, i10, z, null, composer, i11, 16)), i, composer, 512, 0);
            composer.endReplaceableGroup();
            composer.endNode();
            composer.endReplaceableGroup();
            composer.endReplaceableGroup();
            composer.endReplaceableGroup();
            composer.endNode();
            composer.endReplaceableGroup();
            composer.endReplaceableGroup();
            composer.endReplaceableGroup();
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        composer.endReplaceableGroup();
    }

    /* JADX INFO: Access modifiers changed from: private */
    @Composable
    @ComposableInferredTarget(scheme = "[androidx.glance.GlanceComposable[androidx.compose.ui.UiComposable]]")
    public static final void TextBlockItemLayout(final TextBlockItem textBlockItem, final Function2<? super Composer, ? super Integer, Unit> function2, Composer composer, final int i) {
        Modifier modifierPadding;
        Alignment topStart;
        Composer composerStartRestartGroup = composer.startRestartGroup(154086431);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(154086431, i, -1, "androidx.glance.oneui.template.layout.compose.TextBlockItemLayout (TextBlockLayout.kt:150)");
        }
        if (textBlockItem.getTextList().getItems().isEmpty()) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup != null) {
                scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.glance.oneui.template.layout.compose.TextBlockLayoutKt.TextBlockItemLayout.1
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
                        TextBlockLayoutKt.TextBlockItemLayout(textBlockItem, function2, composer2, RecomposeScopeImplKt.updateChangedFlags(i | 1));
                    }
                });
                return;
            }
            return;
        }
        int mask = ((AppWidgetSize) composerStartRestartGroup.consume(CompositionLocalsKt.getLocalWidgetSize())).getMask();
        Modifier.Companion companion = Modifier.INSTANCE;
        Modifier modifierFillMaxSize$default = SizeKt.fillMaxSize$default(companion, 0.0f, 1, null);
        composerStartRestartGroup.startReplaceableGroup(-1915320986);
        long jConvert = textBlockItem.getApplyInverseColor() ? ComposeUtilsKt.convert(GlanceTheme.INSTANCE.getColors(composerStartRestartGroup, GlanceTheme.$stable).getInverseSurface(), composerStartRestartGroup, 8) : Color.INSTANCE.m18560getTransparent0d7_KjU();
        composerStartRestartGroup.endReplaceableGroup();
        Modifier modifierM15409backgroundbw27NRU$default = BackgroundKt.m15409backgroundbw27NRU$default(modifierFillMaxSize$default, jConvert, null, 2, null);
        composerStartRestartGroup.startReplaceableGroup(733328855);
        Alignment.Companion companion2 = Alignment.INSTANCE;
        MeasurePolicy measurePolicyM1210k = AbstractC1038a.m1210k(companion2, false, composerStartRestartGroup, 0, -1323940314);
        Density density = (Density) composerStartRestartGroup.consume(androidx.compose.p109ui.platform.CompositionLocalsKt.getLocalDensity());
        LayoutDirection layoutDirection = (LayoutDirection) composerStartRestartGroup.consume(androidx.compose.p109ui.platform.CompositionLocalsKt.getLocalLayoutDirection());
        ViewConfiguration viewConfiguration = (ViewConfiguration) composerStartRestartGroup.consume(androidx.compose.p109ui.platform.CompositionLocalsKt.getLocalViewConfiguration());
        ComposeUiNode.Companion companion3 = ComposeUiNode.INSTANCE;
        Function0<ComposeUiNode> constructor = companion3.getConstructor();
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
        Updater.m18025setimpl(composerM18018constructorimpl, layoutDirection, (Function2<? super T, ? super LayoutDirection, Unit>) AbstractC1038a.m1219t(companion3, composerM18018constructorimpl, measurePolicyM1210k, composerM18018constructorimpl, density));
        function3MaterializerOf.invoke(AbstractC1038a.m1206g(companion3, composerM18018constructorimpl, viewConfiguration, composerStartRestartGroup, composerStartRestartGroup), composerStartRestartGroup, 0);
        composerStartRestartGroup.startReplaceableGroup(2058660585);
        BoxScopeInstance boxScopeInstance = BoxScopeInstance.INSTANCE;
        AppWidgetSize.Companion companion4 = AppWidgetSize.INSTANCE;
        if (!AppWidgetSize.m21550equalsimpl0(mask, companion4.m21569getMediumrx25Pp4()) || textBlockItem.getFromSingleBlock$glance_oneui_template_release()) {
            composerStartRestartGroup.startReplaceableGroup(1037866821);
            modifierPadding = ComposeModifierUtilsKt.padding(companion, TextBlockLayoutDimensions.INSTANCE.itemPadding(textBlockItem, composerStartRestartGroup, 56));
            composerStartRestartGroup.endReplaceableGroup();
        } else {
            composerStartRestartGroup.startReplaceableGroup(1037866180);
            modifierPadding = PaddingKt.m15853absolutePaddingqDBjuR0$default(PaddingKt.m15856paddingVpY3zN4$default(companion, PrimitiveResources_androidKt.dimensionResource(C3094R.dimen.sesl_glance_multi_textblock_medium_horizontal_padding, composerStartRestartGroup, 0), 0.0f, 2, null), 0.0f, PrimitiveResources_androidKt.dimensionResource(C3094R.dimen.sesl_glance_multi_textblock_medium_top_padding, composerStartRestartGroup, 0), 0.0f, 0.0f, 13, null);
            composerStartRestartGroup.endReplaceableGroup();
        }
        Modifier modifierFillMaxSize$default2 = SizeKt.fillMaxSize$default(modifierPadding, 0.0f, 1, null);
        composerStartRestartGroup.startReplaceableGroup(1037867022);
        if (AppWidgetSize.m21546compareToL2j3NV4(mask, companion4.m21569getMediumrx25Pp4()) < 0) {
            topStart = companion2.getCenterStart();
        } else {
            Alignment.Vertical verticalM21964convertr7CXYeA = ComposeUtilsKt.m21964convertr7CXYeA(textBlockItem.getContentAlign(), composerStartRestartGroup, 0);
            topStart = Intrinsics.areEqual(verticalM21964convertr7CXYeA, companion2.getTop()) ? companion2.getTopStart() : Intrinsics.areEqual(verticalM21964convertr7CXYeA, companion2.getBottom()) ? companion2.getBottomStart() : companion2.getCenterStart();
        }
        composerStartRestartGroup.endReplaceableGroup();
        composerStartRestartGroup.startReplaceableGroup(733328855);
        MeasurePolicy measurePolicyRememberBoxMeasurePolicy = BoxKt.rememberBoxMeasurePolicy(topStart, false, composerStartRestartGroup, 0);
        Density density2 = (Density) AbstractC1038a.m1211l(composerStartRestartGroup, -1323940314);
        LayoutDirection layoutDirection2 = (LayoutDirection) composerStartRestartGroup.consume(androidx.compose.p109ui.platform.CompositionLocalsKt.getLocalLayoutDirection());
        ViewConfiguration viewConfiguration2 = (ViewConfiguration) composerStartRestartGroup.consume(androidx.compose.p109ui.platform.CompositionLocalsKt.getLocalViewConfiguration());
        Function0<ComposeUiNode> constructor2 = companion3.getConstructor();
        Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> function3MaterializerOf2 = LayoutKt.materializerOf(modifierFillMaxSize$default2);
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
        Updater.m18025setimpl(composerM18018constructorimpl2, layoutDirection2, (Function2<? super T, ? super LayoutDirection, Unit>) AbstractC1038a.m1219t(companion3, composerM18018constructorimpl2, measurePolicyRememberBoxMeasurePolicy, composerM18018constructorimpl2, density2));
        function3MaterializerOf2.invoke(AbstractC1038a.m1206g(companion3, composerM18018constructorimpl2, viewConfiguration2, composerStartRestartGroup, composerStartRestartGroup), composerStartRestartGroup, 0);
        composerStartRestartGroup.startReplaceableGroup(2058660585);
        function2.invoke(composerStartRestartGroup, Integer.valueOf((i >> 3) & 14));
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
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup2 = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup2 != null) {
            scopeUpdateScopeEndRestartGroup2.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.glance.oneui.template.layout.compose.TextBlockLayoutKt.TextBlockItemLayout.3
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
                    TextBlockLayoutKt.TextBlockItemLayout(textBlockItem, function2, composer2, RecomposeScopeImplKt.updateChangedFlags(i | 1));
                }
            });
        }
    }

    @Composable
    private static final ColorProvider getTextColor(TypedTextData typedTextData, ColorProvider colorProvider, Composer composer, int i) {
        composer.startReplaceableGroup(1775795594);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(1775795594, i, -1, "androidx.glance.oneui.template.layout.compose.getTextColor (TextBlockLayout.kt:698)");
        }
        ColorProvider colorProviderOverride = ColorProvidersKt.override(colorProvider, typedTextData.getTextColor());
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        composer.endReplaceableGroup();
        return colorProviderOverride;
    }

    @Composable
    private static final TextSize getTextSize(TypedTextData typedTextData, boolean z, int i, Composer composer, int i2, int i4) {
        TextSize labelText;
        composer.startReplaceableGroup(-1263546493);
        if ((i4 & 2) != 0) {
            i = 1;
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-1263546493, i2, -1, "androidx.glance.oneui.template.layout.compose.getTextSize (TextBlockLayout.kt:675)");
        }
        int textType = typedTextData.getTextType();
        TextType.Companion companion = TextType.INSTANCE;
        if (TextType.m21684equalsimpl0(textType, companion.m21691getDisplaygxbDmow())) {
            composer.startReplaceableGroup(1067438164);
            if (z) {
                composer.startReplaceableGroup(1067438185);
                labelText = SingleTextBlockLayoutTextSizes.INSTANCE.displayText(typedTextData.getTextLength(composer, i2 & 14), i, composer, ((i2 >> 3) & 112) | 384);
                composer.endReplaceableGroup();
            } else {
                composer.startReplaceableGroup(1067438396);
                labelText = MultiTextBlockLayoutTextSizes.INSTANCE.getDisplayText(composer, 6);
                composer.endReplaceableGroup();
            }
            composer.endReplaceableGroup();
        } else if (TextType.m21684equalsimpl0(textType, companion.m21694getTitlegxbDmow())) {
            composer.startReplaceableGroup(1067438518);
            labelText = SingleTextBlockLayoutTextSizes.INSTANCE.getTitleText(composer, 6);
            composer.endReplaceableGroup();
        } else if (TextType.m21684equalsimpl0(textType, companion.m21689getBodygxbDmow())) {
            composer.startReplaceableGroup(1067438556);
            if (z) {
                composer.startReplaceableGroup(1067438608);
                labelText = SingleTextBlockLayoutTextSizes.INSTANCE.getBodyText(composer, 6);
                composer.endReplaceableGroup();
            } else {
                composer.startReplaceableGroup(1067438664);
                labelText = MultiTextBlockLayoutTextSizes.INSTANCE.getBodyText(composer, 6);
                composer.endReplaceableGroup();
            }
            composer.endReplaceableGroup();
        } else if (TextType.m21684equalsimpl0(textType, companion.m21690getDescriptiongxbDmow())) {
            composer.startReplaceableGroup(1067438727);
            labelText = SingleTextBlockLayoutTextSizes.INSTANCE.getDescriptionText(composer, 6);
            composer.endReplaceableGroup();
        } else {
            composer.startReplaceableGroup(1067438771);
            if (z) {
                composer.startReplaceableGroup(1067438823);
                labelText = SingleTextBlockLayoutTextSizes.INSTANCE.getLabelText(composer, 6);
                composer.endReplaceableGroup();
            } else {
                composer.startReplaceableGroup(1067438880);
                labelText = MultiTextBlockLayoutTextSizes.INSTANCE.getLabelText(composer, 6);
                composer.endReplaceableGroup();
            }
            composer.endReplaceableGroup();
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        composer.endReplaceableGroup();
        return labelText;
    }
}
