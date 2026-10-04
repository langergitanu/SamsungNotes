package androidx.glance.oneui.template.layout.compose;

import android.content.Context;
import androidx.compose.foundation.BackgroundKt;
import androidx.compose.foundation.layout.AbstractC1038a;
import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.foundation.layout.BoxKt;
import androidx.compose.foundation.layout.BoxScopeInstance;
import androidx.compose.foundation.layout.ColumnScopeInstance;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.RowScope;
import androidx.compose.foundation.layout.RowScopeInstance;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.layout.SpacerKt;
import androidx.compose.foundation.lazy.LazyDslKt;
import androidx.compose.foundation.lazy.LazyItemScope;
import androidx.compose.foundation.lazy.LazyListScope;
import androidx.compose.foundation.shape.RoundedCornerShapeKt;
import androidx.compose.p109ui.Alignment;
import androidx.compose.p109ui.Modifier;
import androidx.compose.p109ui.layout.LayoutKt;
import androidx.compose.p109ui.layout.MeasurePolicy;
import androidx.compose.p109ui.node.ComposeUiNode;
import androidx.compose.p109ui.platform.AndroidCompositionLocals_androidKt;
import androidx.compose.p109ui.platform.ViewConfiguration;
import androidx.compose.p109ui.res.PrimitiveResources_androidKt;
import androidx.compose.p109ui.unit.C2256Dp;
import androidx.compose.p109ui.unit.Density;
import androidx.compose.p109ui.unit.LayoutDirection;
import androidx.compose.runtime.Composable;
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
import androidx.glance.oneui.common.AppWidgetHostType;
import androidx.glance.oneui.common.AppWidgetSize;
import androidx.glance.oneui.template.C3094R;
import androidx.glance.oneui.template.CheckBoxListItem;
import androidx.glance.oneui.template.CompositionLocalsKt;
import androidx.glance.oneui.template.CustomCheckBoxListItem;
import androidx.glance.oneui.template.CustomLeadingContentData;
import androidx.glance.oneui.template.CustomListItem;
import androidx.glance.oneui.template.ImageType;
import androidx.glance.oneui.template.ImageWithBackgroundData;
import androidx.glance.oneui.template.LeadingContentData;
import androidx.glance.oneui.template.ListData;
import androidx.glance.oneui.template.ListItem;
import androidx.glance.oneui.template.ListItemCategory;
import androidx.glance.oneui.template.ProgressListItem;
import androidx.glance.oneui.template.TextData;
import androidx.glance.oneui.template.TextType;
import androidx.glance.oneui.template.TypedTextData;
import androidx.glance.oneui.template.color.ColorProvidersKt;
import androidx.glance.oneui.template.component.compose.ImageKt;
import androidx.glance.oneui.template.component.compose.ProgressIndicatorKt;
import androidx.glance.oneui.template.component.compose.TextKt;
import androidx.glance.oneui.template.layout.CommonDimensions;
import androidx.glance.oneui.template.layout.ListLayoutDimensions;
import androidx.glance.oneui.template.layout.ListLayoutTextSizes;
import androidx.glance.oneui.template.layout.TextSize;
import androidx.glance.oneui.template.utils.ComposeModifierUtilsKt;
import androidx.glance.oneui.template.utils.ComposeUtilsKt;
import androidx.glance.oneui.template.utils.ResourceUtilsKt;
import androidx.glance.text.TextAlign;
import androidx.glance.text.TextPercentData;
import androidx.glance.unit.ColorProvider;
import com.sun.imageio.plugins.jpeg.JPEG;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.functions.Function4;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(m13885d1 = {"\u0000P\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u001aQ\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\f2\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u000fH\u0003¢\u0006\u0002\u0010\u0010\u001aV\u0010\u0011\u001a\u00020\u00012\u0006\u0010\u0012\u001a\u00020\u00132\b\b\u0002\u0010\u0014\u001a\u00020\f2\b\b\u0002\u0010\u0015\u001a\u00020\f2\b\b\u0002\u0010\u0016\u001a\u00020\u00172\b\b\u0002\u0010\u0018\u001a\u00020\u00172\b\b\u0002\u0010\u0019\u001a\u00020\f2\b\b\u0002\u0010\u001a\u001a\u00020\fH\u0001ø\u0001\u0000¢\u0006\u0004\b\u001b\u0010\u001c\u001a>\u0010\u001d\u001a\u00020\u00012\u0006\u0010\u001e\u001a\u00020\u001f2\u0006\u0010 \u001a\u00020!2\u0006\u0010\"\u001a\u00020\u000f2\b\b\u0002\u0010\t\u001a\u00020\n2\b\b\u0002\u0010#\u001a\u00020\u0005H\u0001ø\u0001\u0000¢\u0006\u0004\b$\u0010%\u0082\u0002\u0007\n\u0005\b¡\u001e0\u0001¨\u0006&"}, m13886d2 = {"ComposeListItem", "", "item", "Landroidx/glance/oneui/template/ListItem;", "index", "", "visibleItemCount", "listAlignment", "Landroidx/compose/ui/Alignment$Vertical;", "modifier", "Landroidx/compose/ui/Modifier;", "hasPaddingStart", "", "hasPaddingEnd", "dividerColor", "Landroidx/glance/unit/ColorProvider;", "(Landroidx/glance/oneui/template/ListItem;IILandroidx/compose/ui/Alignment$Vertical;Landroidx/compose/ui/Modifier;ZZLandroidx/glance/unit/ColorProvider;Landroidx/compose/runtime/Composer;II)V", "ComposeListLayout", "data", "Landroidx/glance/oneui/template/ListData;", "fillMaxWidth", "fillMaxHeight", "listPaddingTop", "Landroidx/compose/ui/unit/Dp;", "listPaddingBottom", "hasItemPaddingStart", "hasItemPaddingEnd", "ComposeListLayout-YlGCr2M", "(Landroidx/glance/oneui/template/ListData;ZZFFZZLandroidx/compose/runtime/Composer;II)V", "ComposeListText", "textData", "Landroidx/glance/oneui/template/TextData;", "textType", "Landroidx/glance/oneui/template/TextType;", "textColor", "visibleItemCountInSmall", "ComposeListText-e4lg5Cc", "(Landroidx/glance/oneui/template/TextData;ILandroidx/glance/unit/ColorProvider;Landroidx/compose/ui/Modifier;ILandroidx/compose/runtime/Composer;II)V", "glance-oneui-template_release"}, m13887k = 2, m13888mv = {1, 9, 0}, m13890xi = 48)
@SourceDebugExtension({"SMAP\nListLayout.kt\nKotlin\n*S Kotlin\n*F\n+ 1 ListLayout.kt\nandroidx/glance/oneui/template/layout/compose/ListLayoutKt\n+ 2 Dp.kt\nandroidx/compose/ui/unit/DpKt\n+ 3 CompositionLocal.kt\nandroidx/compose/runtime/CompositionLocal\n+ 4 Box.kt\nandroidx/compose/foundation/layout/BoxKt\n+ 5 Layout.kt\nandroidx/compose/ui/layout/LayoutKt\n+ 6 Composables.kt\nandroidx/compose/runtime/ComposablesKt\n+ 7 Row.kt\nandroidx/compose/foundation/layout/RowKt\n+ 8 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n+ 9 Column.kt\nandroidx/compose/foundation/layout/ColumnKt\n+ 10 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,571:1\n154#2:572\n154#2:573\n174#2:736\n154#2:738\n154#2:739\n154#2:740\n154#2:741\n154#2:808\n154#2:814\n154#2:820\n154#2:821\n174#2:824\n154#2:858\n174#2:859\n154#2:860\n154#2:861\n154#2:862\n154#2:967\n154#2:968\n154#2:969\n174#2:970\n154#2:971\n174#2:972\n174#2:973\n154#2:974\n164#2:1008\n174#2:1024\n174#2:1025\n154#2:1069\n154#2:1070\n154#2:1071\n154#2:1072\n154#2:1073\n154#2:1140\n74#3:574\n76#3:581\n74#3:607\n76#3:615\n76#3:650\n76#3:694\n74#3:733\n74#3:734\n74#3:735\n74#3:737\n76#3:749\n76#3:782\n74#3:823\n76#3:832\n76#3:870\n76#3:903\n76#3:936\n76#3:982\n76#3:1033\n76#3:1081\n76#3:1114\n76#3:1147\n68#4,5:575\n73#4:606\n67#4,6:643\n73#4:675\n77#4:680\n77#4:732\n67#4,6:775\n73#4:807\n77#4:813\n67#4,6:863\n73#4:895\n67#4,6:929\n73#4:961\n77#4:966\n77#4:1023\n67#4,6:1026\n73#4:1058\n77#4:1063\n67#4,6:1074\n73#4:1106\n68#4,5:1141\n73#4:1172\n77#4:1177\n77#4:1187\n75#5:580\n76#5,11:582\n75#5:614\n76#5,11:616\n75#5:649\n76#5,11:651\n89#5:679\n89#5:685\n75#5:693\n76#5,11:695\n89#5:726\n89#5:731\n75#5:748\n76#5,11:750\n75#5:781\n76#5,11:783\n89#5:812\n89#5:818\n75#5:831\n76#5,11:833\n75#5:869\n76#5,11:871\n75#5:902\n76#5,11:904\n75#5:935\n76#5,11:937\n89#5:965\n75#5:981\n76#5,11:983\n89#5:1012\n89#5:1017\n89#5:1022\n75#5:1032\n76#5,11:1034\n89#5:1062\n89#5:1067\n75#5:1080\n76#5,11:1082\n75#5:1113\n76#5,11:1115\n75#5:1146\n76#5,11:1148\n89#5:1176\n89#5:1181\n89#5:1186\n460#6,13:593\n460#6,13:627\n460#6,13:662\n473#6,3:676\n473#6,3:682\n460#6,13:706\n473#6,3:723\n473#6,3:728\n460#6,13:761\n460#6,13:794\n473#6,3:809\n473#6,3:815\n460#6,13:844\n460#6,13:882\n460#6,13:915\n460#6,13:948\n473#6,3:962\n460#6,13:994\n473#6,3:1009\n473#6,3:1014\n473#6,3:1019\n460#6,13:1045\n473#6,3:1059\n473#6,3:1064\n460#6,13:1093\n460#6,13:1126\n460#6,13:1159\n473#6,3:1173\n473#6,3:1178\n473#6,3:1183\n75#7,6:608\n81#7:640\n85#7:686\n75#7,6:896\n81#7:928\n85#7:1018\n75#7,6:1107\n81#7:1139\n85#7:1182\n1864#8,2:641\n1866#8:681\n1864#8,3:720\n74#9,6:687\n80#9:719\n84#9:727\n74#9,6:742\n80#9:774\n84#9:819\n74#9,6:825\n80#9:857\n74#9,6:975\n80#9:1007\n84#9:1013\n84#9:1068\n1#10:822\n*S KotlinDebug\n*F\n+ 1 ListLayout.kt\nandroidx/glance/oneui/template/layout/compose/ListLayoutKt\n*L\n68#1:572\n69#1:573\n187#1:736\n198#1:738\n199#1:739\n203#1:740\n204#1:741\n212#1:808\n234#1:814\n254#1:820\n261#1:821\n277#1:824\n292#1:858\n299#1:859\n304#1:860\n323#1:861\n325#1:862\n377#1:967\n379#1:968\n381#1:969\n403#1:970\n404#1:971\n414#1:972\n421#1:973\n422#1:974\n436#1:1008\n463#1:1024\n470#1:1025\n488#1:1069\n489#1:1070\n493#1:1071\n495#1:1072\n498#1:1073\n518#1:1140\n77#1:574\n93#1:581\n133#1:607\n136#1:615\n138#1:650\n152#1:694\n181#1:733\n184#1:734\n186#1:735\n189#1:737\n195#1:749\n208#1:782\n272#1:823\n285#1:832\n286#1:870\n329#1:903\n341#1:936\n391#1:982\n477#1:1033\n483#1:1081\n502#1:1114\n514#1:1147\n93#1:575,5\n93#1:606\n138#1:643,6\n138#1:675\n138#1:680\n93#1:732\n208#1:775,6\n208#1:807\n208#1:813\n286#1:863,6\n286#1:895\n341#1:929,6\n341#1:961\n341#1:966\n286#1:1023\n477#1:1026,6\n477#1:1058\n477#1:1063\n483#1:1074,6\n483#1:1106\n514#1:1141,5\n514#1:1172\n514#1:1177\n483#1:1187\n93#1:580\n93#1:582,11\n136#1:614\n136#1:616,11\n138#1:649\n138#1:651,11\n138#1:679\n136#1:685\n152#1:693\n152#1:695,11\n152#1:726\n93#1:731\n195#1:748\n195#1:750,11\n208#1:781\n208#1:783,11\n208#1:812\n195#1:818\n285#1:831\n285#1:833,11\n286#1:869\n286#1:871,11\n329#1:902\n329#1:904,11\n341#1:935\n341#1:937,11\n341#1:965\n391#1:981\n391#1:983,11\n391#1:1012\n329#1:1017\n286#1:1022\n477#1:1032\n477#1:1034,11\n477#1:1062\n285#1:1067\n483#1:1080\n483#1:1082,11\n502#1:1113\n502#1:1115,11\n514#1:1146\n514#1:1148,11\n514#1:1176\n502#1:1181\n483#1:1186\n93#1:593,13\n136#1:627,13\n138#1:662,13\n138#1:676,3\n136#1:682,3\n152#1:706,13\n152#1:723,3\n93#1:728,3\n195#1:761,13\n208#1:794,13\n208#1:809,3\n195#1:815,3\n285#1:844,13\n286#1:882,13\n329#1:915,13\n341#1:948,13\n341#1:962,3\n391#1:994,13\n391#1:1009,3\n329#1:1014,3\n286#1:1019,3\n477#1:1045,13\n477#1:1059,3\n285#1:1064,3\n483#1:1093,13\n502#1:1126,13\n514#1:1159,13\n514#1:1173,3\n502#1:1178,3\n483#1:1183,3\n136#1:608,6\n136#1:640\n136#1:686\n329#1:896,6\n329#1:928\n329#1:1018\n502#1:1107,6\n502#1:1139\n502#1:1182\n137#1:641,2\n137#1:681\n153#1:720,3\n152#1:687,6\n152#1:719\n152#1:727\n195#1:742,6\n195#1:774\n195#1:819\n285#1:825,6\n285#1:857\n391#1:975,6\n391#1:1007\n391#1:1013\n285#1:1068\n*E\n"})
public final class ListLayoutKt {
    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:19:0x0074  */
    /* JADX WARN: Removed duplicated region for block: B:20:0x007f  */
    /* JADX WARN: Removed duplicated region for block: B:23:0x0097  */
    /* JADX WARN: Removed duplicated region for block: B:25:0x00ad  */
    /* JADX WARN: Removed duplicated region for block: B:31:0x00e6  */
    /* JADX WARN: Removed duplicated region for block: B:34:0x00ef  */
    /* JADX WARN: Removed duplicated region for block: B:36:? A[RETURN, SYNTHETIC] */
    @ComposableTarget(applier = "androidx.compose.ui.UiComposable")
    @Composable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final void ComposeListItem(final ListItem listItem, final int i, final int i2, final Alignment.Vertical vertical, final Modifier modifier, final boolean z, final boolean z2, ColorProvider colorProvider, Composer composer, int i4, final int i5) {
        int i6;
        int i7;
        final ColorProvider colorProvider2;
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup;
        Composer composerStartRestartGroup = composer.startRestartGroup(1692186530);
        ColorProvider colorProvider3 = (i5 & 128) != 0 ? null : colorProvider;
        if (ComposerKt.isTraceInProgress()) {
            i6 = i4;
            ComposerKt.traceEventStart(1692186530, i6, -1, "androidx.glance.oneui.template.layout.compose.ComposeListItem (ListLayout.kt:179)");
        } else {
            i6 = i4;
        }
        int mask = ((AppWidgetSize) composerStartRestartGroup.consume(CompositionLocalsKt.getLocalWidgetSize())).getMask();
        boolean z3 = true;
        if (i2 > 1) {
            i7 = i;
            if (i7 >= i2 - 1) {
            }
            boolean z4 = z3;
            Modifier modifierContentDescription = ComposeModifierUtilsKt.contentDescription(modifier, listItem.getContentDescription());
            float fM20968constructorimpl = !AppWidgetHostType.m21524equalsimpl0(((AppWidgetHostType) composerStartRestartGroup.consume(CompositionLocalsKt.getLocalHostType())).getMask(), AppWidgetHostType.INSTANCE.m21535getHomemn_SBp8()) ? C2256Dp.m20968constructorimpl(ResourceUtilsKt.getFloat((Context) composerStartRestartGroup.consume(AndroidCompositionLocals_androidKt.getLocalContext()), C3094R.dimen.sesl_glance_list_progress_item_start_padding_over_medium)) : CommonDimensions.INSTANCE.m21775getLayoutHorizontalPaddingD9Ej5fM();
            int mask2 = ((AppWidgetHostType) composerStartRestartGroup.consume(CompositionLocalsKt.getLocalHostType())).getMask();
            if (!(listItem instanceof ProgressListItem)) {
                composerStartRestartGroup.startReplaceableGroup(1418205478);
                ComposeListItem$ProgressListItem(listItem, mask, i7, z, fM20968constructorimpl, z2, modifierContentDescription, z4, mask2, composerStartRestartGroup, 0);
                composerStartRestartGroup.endReplaceableGroup();
            } else {
                if (!(listItem instanceof ListItemCategory)) {
                    composerStartRestartGroup.startReplaceableGroup(1418205559);
                    colorProvider2 = colorProvider3;
                    ComposeListItem$DefaultListItem(listItem, mask, z, z2, z4, vertical, i2, modifierContentDescription, colorProvider2, composerStartRestartGroup, 0);
                    composerStartRestartGroup.endReplaceableGroup();
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                    if (scopeUpdateScopeEndRestartGroup != null) {
                        final int i8 = i6;
                        scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.glance.oneui.template.layout.compose.ListLayoutKt.ComposeListItem.1
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            {
                                super(2);
                            }

                            @Override // kotlin.jvm.functions.Function2
                            public /* bridge */ /* synthetic */ Unit invoke(Composer composer2, Integer num) {
                                invoke(composer2, num.intValue());
                                return Unit.INSTANCE;
                            }

                            public final void invoke(@Nullable Composer composer2, int i9) {
                                ListLayoutKt.ComposeListItem(listItem, i, i2, vertical, modifier, z, z2, colorProvider2, composer2, RecomposeScopeImplKt.updateChangedFlags(i8 | 1), i5);
                            }
                        });
                        return;
                    }
                    return;
                }
                composerStartRestartGroup.startReplaceableGroup(1418205528);
                ComposeListItem$CategoryText(listItem, modifier, z, i, z2, composerStartRestartGroup, 0);
                composerStartRestartGroup.endReplaceableGroup();
            }
            colorProvider2 = colorProvider3;
            if (ComposerKt.isTraceInProgress()) {
            }
            scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup != null) {
            }
        } else {
            i7 = i;
        }
        z3 = false;
        boolean z42 = z3;
        Modifier modifierContentDescription2 = ComposeModifierUtilsKt.contentDescription(modifier, listItem.getContentDescription());
        if (!AppWidgetHostType.m21524equalsimpl0(((AppWidgetHostType) composerStartRestartGroup.consume(CompositionLocalsKt.getLocalHostType())).getMask(), AppWidgetHostType.INSTANCE.m21535getHomemn_SBp8())) {
        }
        int mask22 = ((AppWidgetHostType) composerStartRestartGroup.consume(CompositionLocalsKt.getLocalHostType())).getMask();
        if (!(listItem instanceof ProgressListItem)) {
        }
        colorProvider2 = colorProvider3;
        if (ComposerKt.isTraceInProgress()) {
        }
        scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
        }
    }

    @ComposableTarget(applier = "androidx.glance.GlanceComposable")
    @Composable
    private static final void ComposeListItem$CategoryText(ListItem listItem, Modifier modifier, boolean z, int i, boolean z2, Composer composer, int i2) {
        Composer composer2;
        composer.startReplaceableGroup(-1907426445);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-1907426445, i2, -1, "androidx.glance.oneui.template.layout.compose.ComposeListItem.CategoryText (ListLayout.kt:242)");
        }
        if (listItem instanceof ListItemCategory) {
            Modifier modifierM15857paddingqDBjuR0 = PaddingKt.m15857paddingqDBjuR0(modifier, z ? ListLayoutDimensions.INSTANCE.m21780getDefaultItemHorizontalPaddingD9Ej5fM() : CommonDimensions.INSTANCE.m21779getTextAdditionalPaddingD9Ej5fM(), C2256Dp.m20968constructorimpl(i != 0 ? 10 : 0), z2 ? ListLayoutDimensions.INSTANCE.m21780getDefaultItemHorizontalPaddingD9Ej5fM() : CommonDimensions.INSTANCE.m21779getTextAdditionalPaddingD9Ej5fM(), C2256Dp.m20968constructorimpl(6));
            TypedTextData mainText = listItem.getMainText();
            mainText.m21678setTextAlignb1psNo$glance_oneui_template_release(TextAlign.INSTANCE.m22011getStartROrN78o());
            composer2 = composer;
            m21805ComposeListTexte4lg5Cc(mainText, TextType.INSTANCE.m21694getTitlegxbDmow(), GlanceTheme.INSTANCE.getColors(composer, GlanceTheme.$stable).getOnBackground(), modifierM15857paddingqDBjuR0, 0, composer2, 560, 16);
        } else {
            composer2 = composer;
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        composer2.endReplaceableGroup();
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:155:0x05d9  */
    /* JADX WARN: Removed duplicated region for block: B:157:0x05dd  */
    /* JADX WARN: Removed duplicated region for block: B:162:0x05fc  */
    /* JADX WARN: Removed duplicated region for block: B:166:0x0658  */
    /* JADX WARN: Removed duplicated region for block: B:169:0x0664  */
    /* JADX WARN: Removed duplicated region for block: B:170:0x0668  */
    /* JADX WARN: Type inference failed for: r11v19 */
    /* JADX WARN: Type inference failed for: r11v20, types: [boolean, int] */
    /* JADX WARN: Type inference failed for: r11v44 */
    /* JADX WARN: Type inference failed for: r2v25 */
    /* JADX WARN: Type inference failed for: r2v26, types: [boolean, int] */
    /* JADX WARN: Type inference failed for: r2v77 */
    /* JADX WARN: Type inference failed for: r8v18 */
    /* JADX WARN: Type inference failed for: r8v4 */
    /* JADX WARN: Type inference failed for: r8v5, types: [boolean, int] */
    @ComposableTarget(applier = "androidx.compose.ui.UiComposable")
    @Composable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private static final void ComposeListItem$DefaultListItem(ListItem listItem, int i, boolean z, boolean z2, boolean z3, Alignment.Vertical vertical, int i2, Modifier modifier, ColorProvider colorProvider, Composer composer, int i4) {
        ?? r8;
        float fM20968constructorimpl;
        ?? r2;
        float fM20968constructorimpl2;
        Modifier.Companion companion;
        Arrangement arrangement;
        Alignment.Companion companion2;
        ComposeUiNode.Companion companion3;
        int i5;
        ?? r11;
        float f;
        Modifier.Companion companion4;
        int i6;
        float fM20968constructorimpl3;
        ComposeUiNode.Companion companion5;
        Alignment.Companion companion6;
        Integer num;
        float f4;
        Alignment.Vertical vertical2;
        int i7;
        Modifier modifierM15858paddingqDBjuR0$default;
        Modifier.Companion companion7;
        Alignment.Companion companion8;
        boolean z4;
        Composer composer2 = composer;
        composer2.startReplaceableGroup(1110164872);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(1110164872, i4, -1, "androidx.glance.oneui.template.layout.compose.ComposeListItem.DefaultListItem (ListLayout.kt:270)");
        }
        Context context = (Context) composer2.consume(AndroidCompositionLocals_androidKt.getLocalContext());
        float fM20968constructorimpl4 = C2256Dp.m20968constructorimpl(ResourceUtilsKt.getFloat(context, listItem.getSubText() != null ? C3094R.dimen.sesl_glance_list_default_item_medium_height_with_2_line : C3094R.dimen.sesl_glance_list_default_item_medium_height_with_1_line));
        Modifier modifierWrapContentHeight$default = listItem.getMainText().getMaxLines() >= 3 ? SizeKt.wrapContentHeight$default(Modifier.INSTANCE, null, false, 3, null) : SizeKt.m15885height3ABfNKs(Modifier.INSTANCE, fM20968constructorimpl4);
        TypedTextData mainText = listItem.getMainText();
        int textType = mainText.getTextType();
        TextType.Companion companion9 = TextType.INSTANCE;
        if (TextType.m21684equalsimpl0(textType, companion9.m21691getDisplaygxbDmow())) {
            composer2.startReplaceableGroup(1230814081);
            Modifier.Companion companion10 = Modifier.INSTANCE;
            Modifier modifierWrapContentHeight$default2 = SizeKt.wrapContentHeight$default(SizeKt.m15887heightInVpY3zN4$default(companion10, fM20968constructorimpl4, 0.0f, 2, null), null, false, 3, null);
            float fM21775getLayoutHorizontalPaddingD9Ej5fM = z ? CommonDimensions.INSTANCE.m21775getLayoutHorizontalPaddingD9Ej5fM() : C2256Dp.m20968constructorimpl(0);
            float fM21775getLayoutHorizontalPaddingD9Ej5fM2 = z2 ? CommonDimensions.INSTANCE.m21775getLayoutHorizontalPaddingD9Ej5fM() : C2256Dp.m20968constructorimpl(0);
            if (z3) {
                fM20968constructorimpl = Intrinsics.areEqual(vertical, Alignment.INSTANCE.getCenterVertically()) ? C2256Dp.m20968constructorimpl(6) : C2256Dp.m20968constructorimpl(3);
                r8 = 0;
            } else {
                r8 = 0;
                fM20968constructorimpl = C2256Dp.m20968constructorimpl(0);
            }
            Modifier modifierM15858paddingqDBjuR0$default2 = PaddingKt.m15858paddingqDBjuR0$default(modifierWrapContentHeight$default2, fM21775getLayoutHorizontalPaddingD9Ej5fM, 0.0f, fM21775getLayoutHorizontalPaddingD9Ej5fM2, fM20968constructorimpl, 2, null);
            composer2.startReplaceableGroup(733328855);
            Alignment.Companion companion11 = Alignment.INSTANCE;
            MeasurePolicy measurePolicyM1210k = AbstractC1038a.m1210k(companion11, r8, composer2, r8, -1323940314);
            Density density = (Density) composer2.consume(androidx.compose.p109ui.platform.CompositionLocalsKt.getLocalDensity());
            LayoutDirection layoutDirection = (LayoutDirection) composer2.consume(androidx.compose.p109ui.platform.CompositionLocalsKt.getLocalLayoutDirection());
            ViewConfiguration viewConfiguration = (ViewConfiguration) composer2.consume(androidx.compose.p109ui.platform.CompositionLocalsKt.getLocalViewConfiguration());
            ComposeUiNode.Companion companion12 = ComposeUiNode.INSTANCE;
            Function0<ComposeUiNode> constructor = companion12.getConstructor();
            Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> function3MaterializerOf = LayoutKt.materializerOf(modifierM15858paddingqDBjuR0$default2);
            if (composer2.getApplier() == null) {
                ComposablesKt.invalidApplier();
            }
            composer2.startReusableNode();
            if (composer2.getInserting()) {
                composer2.createNode(constructor);
            } else {
                composer2.useNode();
            }
            composer2.disableReusing();
            Composer composerM18018constructorimpl = Updater.m18018constructorimpl(composer2);
            Updater.m18025setimpl(composerM18018constructorimpl, layoutDirection, (Function2<? super T, ? super LayoutDirection, Unit>) AbstractC1038a.m1219t(companion12, composerM18018constructorimpl, measurePolicyM1210k, composerM18018constructorimpl, density));
            function3MaterializerOf.invoke(AbstractC1038a.m1206g(companion12, composerM18018constructorimpl, viewConfiguration, composer2, composer2), composer2, 0);
            composer2.startReplaceableGroup(2058660585);
            BoxScopeInstance boxScopeInstance = BoxScopeInstance.INSTANCE;
            Alignment.Vertical bottom = companion11.getBottom();
            composer2.startReplaceableGroup(693286680);
            MeasurePolicy measurePolicyM1207h = AbstractC1038a.m1207h(Arrangement.INSTANCE, bottom, composer2, 48, -1323940314);
            Density density2 = (Density) composer2.consume(androidx.compose.p109ui.platform.CompositionLocalsKt.getLocalDensity());
            LayoutDirection layoutDirection2 = (LayoutDirection) composer2.consume(androidx.compose.p109ui.platform.CompositionLocalsKt.getLocalLayoutDirection());
            ViewConfiguration viewConfiguration2 = (ViewConfiguration) composer2.consume(androidx.compose.p109ui.platform.CompositionLocalsKt.getLocalViewConfiguration());
            Function0<ComposeUiNode> constructor2 = companion12.getConstructor();
            Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> function3MaterializerOf2 = LayoutKt.materializerOf(modifier);
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
            Updater.m18025setimpl(composerM18018constructorimpl2, layoutDirection2, (Function2<? super T, ? super LayoutDirection, Unit>) AbstractC1038a.m1219t(companion12, composerM18018constructorimpl2, measurePolicyM1207h, composerM18018constructorimpl2, density2));
            function3MaterializerOf2.invoke(AbstractC1038a.m1206g(companion12, composerM18018constructorimpl2, viewConfiguration2, composer2, composer2), composer2, 0);
            composer2.startReplaceableGroup(2058660585);
            RowScopeInstance rowScopeInstance = RowScopeInstance.INSTANCE;
            if (listItem instanceof CustomCheckBoxListItem) {
                composer2.startReplaceableGroup(1501781423);
                CustomCheckBoxListItem customCheckBoxListItem = (CustomCheckBoxListItem) listItem;
                customCheckBoxListItem.CustomContent(customCheckBoxListItem, composer2, 0);
                composer2.endReplaceableGroup();
            } else if (listItem instanceof CustomListItem) {
                composer2.startReplaceableGroup(1501781497);
                CustomListItem customListItem = (CustomListItem) listItem;
                customListItem.CustomContent(customListItem, composer2, 0);
                composer2.endReplaceableGroup();
            } else {
                composer2.startReplaceableGroup(1501781553);
                int iM21691getDisplaygxbDmow = companion9.m21691getDisplaygxbDmow();
                GlanceTheme glanceTheme = GlanceTheme.INSTANCE;
                int i8 = GlanceTheme.$stable;
                m21805ComposeListTexte4lg5Cc(mainText, iM21691getDisplaygxbDmow, ColorProvidersKt.override(glanceTheme.getColors(composer2, i8).getOnBackground(), mainText.getTextColor()), null, 0, composer2, 560, 24);
                TypedTextData subText = listItem.getSubText();
                if (subText != null) {
                    Modifier modifierM15858paddingqDBjuR0$default3 = PaddingKt.m15858paddingqDBjuR0$default(SizeKt.fillMaxHeight$default(RowScope.weight$default(rowScopeInstance, companion10, 1.0f, false, 2, null), 0.0f, 1, null), 0.0f, 0.0f, 0.0f, C2256Dp.m20968constructorimpl(2), 7, null);
                    Alignment bottomStart = companion11.getBottomStart();
                    composer2.startReplaceableGroup(733328855);
                    MeasurePolicy measurePolicyRememberBoxMeasurePolicy = BoxKt.rememberBoxMeasurePolicy(bottomStart, false, composer2, 6);
                    Density density3 = (Density) AbstractC1038a.m1211l(composer2, -1323940314);
                    LayoutDirection layoutDirection3 = (LayoutDirection) composer2.consume(androidx.compose.p109ui.platform.CompositionLocalsKt.getLocalLayoutDirection());
                    ViewConfiguration viewConfiguration3 = (ViewConfiguration) composer2.consume(androidx.compose.p109ui.platform.CompositionLocalsKt.getLocalViewConfiguration());
                    Function0<ComposeUiNode> constructor3 = companion12.getConstructor();
                    Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> function3MaterializerOf3 = LayoutKt.materializerOf(modifierM15858paddingqDBjuR0$default3);
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
                    Updater.m18025setimpl(composerM18018constructorimpl3, layoutDirection3, (Function2<? super T, ? super LayoutDirection, Unit>) AbstractC1038a.m1219t(companion12, composerM18018constructorimpl3, measurePolicyRememberBoxMeasurePolicy, composerM18018constructorimpl3, density3));
                    function3MaterializerOf3.invoke(AbstractC1038a.m1206g(companion12, composerM18018constructorimpl3, viewConfiguration3, composer2, composer2), composer2, 0);
                    composer2.startReplaceableGroup(2058660585);
                    m21805ComposeListTexte4lg5Cc(subText, companion9.m21693getLabelgxbDmow(), ColorProvidersKt.override(glanceTheme.getColors(composer2, i8).getOnSurfaceVariant(), subText.getTextColor()), null, 0, composer2, 560, 24);
                    composer.endReplaceableGroup();
                    composer.endNode();
                    composer.endReplaceableGroup();
                    composer.endReplaceableGroup();
                    Unit unit = Unit.INSTANCE;
                }
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
            composer.endReplaceableGroup();
        } else {
            composer2.startReplaceableGroup(1230802380);
            boolean z5 = AppWidgetSize.m21546compareToL2j3NV4(i, AppWidgetSize.INSTANCE.m21569getMediumrx25Pp4()) >= 0;
            boolean z6 = listItem.getLeadingContentData() != null;
            composer2.startReplaceableGroup(-483455358);
            Arrangement arrangement2 = Arrangement.INSTANCE;
            Arrangement.Vertical top = arrangement2.getTop();
            Alignment.Companion companion13 = Alignment.INSTANCE;
            MeasurePolicy measurePolicyM1209j = AbstractC1038a.m1209j(companion13, top, composer2, 0, -1323940314);
            Density density4 = (Density) composer2.consume(androidx.compose.p109ui.platform.CompositionLocalsKt.getLocalDensity());
            LayoutDirection layoutDirection4 = (LayoutDirection) composer2.consume(androidx.compose.p109ui.platform.CompositionLocalsKt.getLocalLayoutDirection());
            ViewConfiguration viewConfiguration4 = (ViewConfiguration) composer2.consume(androidx.compose.p109ui.platform.CompositionLocalsKt.getLocalViewConfiguration());
            ComposeUiNode.Companion companion14 = ComposeUiNode.INSTANCE;
            Function0<ComposeUiNode> constructor4 = companion14.getConstructor();
            Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> function3MaterializerOf4 = LayoutKt.materializerOf(modifierWrapContentHeight$default);
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
            Updater.m18025setimpl(composerM18018constructorimpl4, layoutDirection4, (Function2<? super T, ? super LayoutDirection, Unit>) AbstractC1038a.m1219t(companion14, composerM18018constructorimpl4, measurePolicyM1209j, composerM18018constructorimpl4, density4));
            function3MaterializerOf4.invoke(AbstractC1038a.m1206g(companion14, composerM18018constructorimpl4, viewConfiguration4, composer2, composer2), composer2, 0);
            composer2.startReplaceableGroup(2058660585);
            ColumnScopeInstance columnScopeInstance = ColumnScopeInstance.INSTANCE;
            Modifier.Companion companion15 = Modifier.INSTANCE;
            float fM20968constructorimpl5 = z ? z5 ? z6 ? C2256Dp.m20968constructorimpl(14) : C2256Dp.m20968constructorimpl(ResourceUtilsKt.getFloat(context, C3094R.dimen.sesl_glance_list_item_start_padding_over_medium)) : ListLayoutDimensions.INSTANCE.m21781getSmallItemHorizontalPaddingD9Ej5fM() : z6 ? C2256Dp.m20968constructorimpl(0) : CommonDimensions.INSTANCE.m21779getTextAdditionalPaddingD9Ej5fM();
            float fM21780getDefaultItemHorizontalPaddingD9Ej5fM = z2 ? z5 ? ListLayoutDimensions.INSTANCE.m21780getDefaultItemHorizontalPaddingD9Ej5fM() : ListLayoutDimensions.INSTANCE.m21781getSmallItemHorizontalPaddingD9Ej5fM() : CommonDimensions.INSTANCE.m21779getTextAdditionalPaddingD9Ej5fM();
            if (z3 && !z5 && i2 == 2) {
                fM20968constructorimpl2 = C2256Dp.m20968constructorimpl(2);
                r2 = 0;
            } else {
                r2 = 0;
                fM20968constructorimpl2 = C2256Dp.m20968constructorimpl(0);
            }
            Modifier modifierM15858paddingqDBjuR0$default4 = PaddingKt.m15858paddingqDBjuR0$default(companion15, fM20968constructorimpl5, 0.0f, fM21780getDefaultItemHorizontalPaddingD9Ej5fM, fM20968constructorimpl2, 2, null);
            composer2.startReplaceableGroup(733328855);
            MeasurePolicy measurePolicyM1210k2 = AbstractC1038a.m1210k(companion13, r2, composer2, r2, -1323940314);
            Density density5 = (Density) composer2.consume(androidx.compose.p109ui.platform.CompositionLocalsKt.getLocalDensity());
            LayoutDirection layoutDirection5 = (LayoutDirection) composer2.consume(androidx.compose.p109ui.platform.CompositionLocalsKt.getLocalLayoutDirection());
            ViewConfiguration viewConfiguration5 = (ViewConfiguration) composer2.consume(androidx.compose.p109ui.platform.CompositionLocalsKt.getLocalViewConfiguration());
            Function0<ComposeUiNode> constructor5 = companion14.getConstructor();
            Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> function3MaterializerOf5 = LayoutKt.materializerOf(modifierM15858paddingqDBjuR0$default4);
            if (composer2.getApplier() == null) {
                ComposablesKt.invalidApplier();
            }
            composer2.startReusableNode();
            if (composer2.getInserting()) {
                composer2.createNode(constructor5);
            } else {
                composer2.useNode();
            }
            composer2.disableReusing();
            Composer composerM18018constructorimpl5 = Updater.m18018constructorimpl(composer2);
            Updater.m18025setimpl(composerM18018constructorimpl5, layoutDirection5, (Function2<? super T, ? super LayoutDirection, Unit>) AbstractC1038a.m1219t(companion14, composerM18018constructorimpl5, measurePolicyM1210k2, composerM18018constructorimpl5, density5));
            function3MaterializerOf5.invoke(AbstractC1038a.m1206g(companion14, composerM18018constructorimpl5, viewConfiguration5, composer2, composer2), composer2, 0);
            composer2.startReplaceableGroup(2058660585);
            BoxScopeInstance boxScopeInstance2 = BoxScopeInstance.INSTANCE;
            Alignment.Vertical centerVertically = companion13.getCenterVertically();
            composer2.startReplaceableGroup(693286680);
            MeasurePolicy measurePolicyM1207h2 = AbstractC1038a.m1207h(arrangement2, centerVertically, composer2, 48, -1323940314);
            Density density6 = (Density) composer2.consume(androidx.compose.p109ui.platform.CompositionLocalsKt.getLocalDensity());
            LayoutDirection layoutDirection6 = (LayoutDirection) composer2.consume(androidx.compose.p109ui.platform.CompositionLocalsKt.getLocalLayoutDirection());
            ViewConfiguration viewConfiguration6 = (ViewConfiguration) composer2.consume(androidx.compose.p109ui.platform.CompositionLocalsKt.getLocalViewConfiguration());
            Function0<ComposeUiNode> constructor6 = companion14.getConstructor();
            Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> function3MaterializerOf6 = LayoutKt.materializerOf(modifier);
            if (composer2.getApplier() == null) {
                ComposablesKt.invalidApplier();
            }
            composer2.startReusableNode();
            if (composer2.getInserting()) {
                composer2.createNode(constructor6);
            } else {
                composer2.useNode();
            }
            composer2.disableReusing();
            Composer composerM18018constructorimpl6 = Updater.m18018constructorimpl(composer2);
            Updater.m18025setimpl(composerM18018constructorimpl6, layoutDirection6, (Function2<? super T, ? super LayoutDirection, Unit>) AbstractC1038a.m1219t(companion14, composerM18018constructorimpl6, measurePolicyM1207h2, composerM18018constructorimpl6, density6));
            function3MaterializerOf6.invoke(AbstractC1038a.m1206g(companion14, composerM18018constructorimpl6, viewConfiguration6, composer2, composer2), composer2, 0);
            composer2.startReplaceableGroup(2058660585);
            RowScopeInstance rowScopeInstance2 = RowScopeInstance.INSTANCE;
            composer2.startReplaceableGroup(-1230985549);
            if (z6) {
                float fM21774getDefaultIconSizeD9Ej5fM = z5 ? CommonDimensions.INSTANCE.m21774getDefaultIconSizeD9Ej5fM() : CommonDimensions.INSTANCE.m21778getSmallIconSizeD9Ej5fM();
                if (listItem.getLeadingContentData() instanceof CustomLeadingContentData) {
                    composer2.startReplaceableGroup(-1230985144);
                    Modifier modifierM15899size3ABfNKs = SizeKt.m15899size3ABfNKs(companion15, fM21774getDefaultIconSizeD9Ej5fM);
                    composer2.startReplaceableGroup(733328855);
                    MeasurePolicy measurePolicyM1210k3 = AbstractC1038a.m1210k(companion13, false, composer2, 0, -1323940314);
                    Density density7 = (Density) composer2.consume(androidx.compose.p109ui.platform.CompositionLocalsKt.getLocalDensity());
                    LayoutDirection layoutDirection7 = (LayoutDirection) composer2.consume(androidx.compose.p109ui.platform.CompositionLocalsKt.getLocalLayoutDirection());
                    ViewConfiguration viewConfiguration7 = (ViewConfiguration) composer2.consume(androidx.compose.p109ui.platform.CompositionLocalsKt.getLocalViewConfiguration());
                    Function0<ComposeUiNode> constructor7 = companion14.getConstructor();
                    Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> function3MaterializerOf7 = LayoutKt.materializerOf(modifierM15899size3ABfNKs);
                    if (composer2.getApplier() == null) {
                        ComposablesKt.invalidApplier();
                    }
                    composer2.startReusableNode();
                    if (composer2.getInserting()) {
                        composer2.createNode(constructor7);
                    } else {
                        composer2.useNode();
                    }
                    composer2.disableReusing();
                    Composer composerM18018constructorimpl7 = Updater.m18018constructorimpl(composer2);
                    Updater.m18025setimpl(composerM18018constructorimpl7, layoutDirection7, (Function2<? super T, ? super LayoutDirection, Unit>) AbstractC1038a.m1219t(companion14, composerM18018constructorimpl7, measurePolicyM1210k3, composerM18018constructorimpl7, density7));
                    function3MaterializerOf7.invoke(AbstractC1038a.m1206g(companion14, composerM18018constructorimpl7, viewConfiguration7, composer2, composer2), composer2, 0);
                    composer2.startReplaceableGroup(2058660585);
                    ((CustomLeadingContentData) listItem.getLeadingContentData()).LeadingContent(composer2, 0);
                    composer2.endReplaceableGroup();
                    composer2.endNode();
                    composer2.endReplaceableGroup();
                    composer2.endReplaceableGroup();
                    composer2.endReplaceableGroup();
                    companion7 = companion15;
                    arrangement = arrangement2;
                    companion2 = companion13;
                    companion3 = companion14;
                    i5 = -1323940314;
                    f = 0.0f;
                } else {
                    composer2.startReplaceableGroup(-1230984917);
                    LeadingContentData leadingContentData = listItem.getLeadingContentData();
                    ImageWithBackgroundData icon = leadingContentData != null ? leadingContentData.getIcon() : null;
                    if (icon == null) {
                        companion7 = companion15;
                        arrangement = arrangement2;
                        companion2 = companion13;
                        companion3 = companion14;
                        i5 = -1323940314;
                        f = 0.0f;
                    } else {
                        if (listItem instanceof CheckBoxListItem) {
                            composer2.startReplaceableGroup(-1552076579);
                            composer2.startReplaceableGroup(-1552076409);
                            icon.setImageTintColor$glance_oneui_template_release(GlanceTheme.INSTANCE.getColors(composer2, GlanceTheme.$stable).getOnBackground());
                            composer2.endReplaceableGroup();
                            ImageKt.m21721ComposeImagerAjV9yQ(icon, fM21774getDefaultIconSizeD9Ej5fM, false, composer2, 392);
                            composer2.endReplaceableGroup();
                            companion7 = companion15;
                            arrangement = arrangement2;
                            companion2 = companion13;
                            companion3 = companion14;
                            i5 = -1323940314;
                            f = 0.0f;
                        } else {
                            composer2.startReplaceableGroup(-1552075948);
                            companion7 = companion15;
                            Modifier modifierM15408backgroundbw27NRU = BackgroundKt.m15408backgroundbw27NRU(SizeKt.m15899size3ABfNKs(companion15, fM21774getDefaultIconSizeD9Ej5fM), ComposeUtilsKt.convert(ColorProvidersKt.override(GlanceTheme.INSTANCE.getColors(composer2, GlanceTheme.$stable).getSurface(), icon.getBackgroundColor()), composer2, 8), RoundedCornerShapeKt.m16137RoundedCornerShape0680j_4(CommonDimensions.INSTANCE.m21773getDefaultCornerRadiusD9Ej5fM()));
                            if (icon.getImageType() != ImageType.AppIcon) {
                                companion8 = companion13;
                                z4 = true;
                            } else {
                                companion8 = companion13;
                                z4 = false;
                            }
                            arrangement = arrangement2;
                            companion2 = companion8;
                            companion3 = companion14;
                            i5 = -1323940314;
                            f = 0.0f;
                            ImageKt.ComposeImage(icon, modifierM15408backgroundbw27NRU, null, z4, composer, 8, 4);
                            composer2 = composer;
                            composer2.endReplaceableGroup();
                        }
                        Unit unit2 = Unit.INSTANCE;
                    }
                    composer2.endReplaceableGroup();
                }
                companion = companion7;
                r11 = 0;
                SpacerKt.Spacer(SizeKt.m15904width3ABfNKs(companion, z5 ? C2256Dp.m20968constructorimpl(8) : i2 < 3 ? C2256Dp.m20968constructorimpl(4) : C2256Dp.m20968constructorimpl(3)), composer2, 0);
            } else {
                companion = companion15;
                arrangement = arrangement2;
                companion2 = companion13;
                companion3 = companion14;
                i5 = -1323940314;
                r11 = 0;
                f = 0.0f;
            }
            composer2.endReplaceableGroup();
            if (listItem instanceof CustomCheckBoxListItem) {
                composer2.startReplaceableGroup(-1230982317);
                CustomCheckBoxListItem customCheckBoxListItem2 = (CustomCheckBoxListItem) listItem;
                customCheckBoxListItem2.CustomContent(customCheckBoxListItem2, composer2, r11);
                composer2.endReplaceableGroup();
            } else if (listItem instanceof CustomListItem) {
                composer2.startReplaceableGroup(-1230982239);
                CustomListItem customListItem2 = (CustomListItem) listItem;
                customListItem2.CustomContent(customListItem2, composer2, r11);
                composer2.endReplaceableGroup();
            } else {
                composer2.startReplaceableGroup(-1230982179);
                Modifier.Companion companion16 = companion;
                companion4 = companion16;
                Modifier modifierWrapContentHeight$default3 = SizeKt.wrapContentHeight$default(RowScope.weight$default(rowScopeInstance2, companion16, 1.0f, false, 2, null), null, r11, 3, null);
                float fM20968constructorimpl6 = z5 ? C2256Dp.m20968constructorimpl(ResourceUtilsKt.getFloat(context, C3094R.dimen.sesl_glance_list_item_top_padding)) : C2256Dp.m20968constructorimpl((float) r11);
                if (z5) {
                    fM20968constructorimpl3 = listItem.getSubText() != null ? C2256Dp.m20968constructorimpl(ResourceUtilsKt.getFloat(context, C3094R.dimen.sesl_glance_list_item_bottom_padding_with_sub_text)) : C2256Dp.m20968constructorimpl(ResourceUtilsKt.getFloat(context, C3094R.dimen.sesl_glance_list_item_bottom_padding));
                    i6 = 0;
                } else {
                    i6 = 0;
                    fM20968constructorimpl3 = C2256Dp.m20968constructorimpl(0);
                }
                Modifier modifierM15858paddingqDBjuR0$default5 = PaddingKt.m15858paddingqDBjuR0$default(modifierWrapContentHeight$default3, 0.0f, fM20968constructorimpl6, 0.0f, fM20968constructorimpl3, 5, null);
                composer2.startReplaceableGroup(-483455358);
                MeasurePolicy measurePolicyM1209j2 = AbstractC1038a.m1209j(companion2, arrangement.getTop(), composer2, i6, i5);
                Density density8 = (Density) composer2.consume(androidx.compose.p109ui.platform.CompositionLocalsKt.getLocalDensity());
                LayoutDirection layoutDirection8 = (LayoutDirection) composer2.consume(androidx.compose.p109ui.platform.CompositionLocalsKt.getLocalLayoutDirection());
                ViewConfiguration viewConfiguration8 = (ViewConfiguration) composer2.consume(androidx.compose.p109ui.platform.CompositionLocalsKt.getLocalViewConfiguration());
                Function0<ComposeUiNode> constructor8 = companion3.getConstructor();
                Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> function3MaterializerOf8 = LayoutKt.materializerOf(modifierM15858paddingqDBjuR0$default5);
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
                Updater.m18025setimpl(composerM18018constructorimpl8, layoutDirection8, (Function2<? super T, ? super LayoutDirection, Unit>) AbstractC1038a.m1219t(companion3, composerM18018constructorimpl8, measurePolicyM1209j2, composerM18018constructorimpl8, density8));
                function3MaterializerOf8.invoke(AbstractC1038a.m1206g(companion3, composerM18018constructorimpl8, viewConfiguration8, composer2, composer2), composer2, 0);
                composer2.startReplaceableGroup(2058660585);
                int iM21689getBodygxbDmow = companion9.m21689getBodygxbDmow();
                GlanceTheme glanceTheme2 = GlanceTheme.INSTANCE;
                int i9 = GlanceTheme.$stable;
                companion5 = companion3;
                companion6 = companion2;
                num = 0;
                f4 = f;
                vertical2 = null;
                i7 = 1;
                m21805ComposeListTexte4lg5Cc(mainText, iM21689getBodygxbDmow, ColorProvidersKt.override(glanceTheme2.getColors(composer2, i9).getOnBackground(), mainText.getTextColor()), null, i2, composer2, 560, 8);
                TypedTextData subText2 = listItem.getSubText();
                composer2.startReplaceableGroup(-1230979045);
                if (subText2 != null) {
                    SpacerKt.Spacer(SizeKt.m15885height3ABfNKs(companion4, C2256Dp.m20968constructorimpl((float) (z6 ? 0.8d : 0.71d))), composer2, 0);
                    m21805ComposeListTexte4lg5Cc(listItem.getSubText(), companion9.m21690getDescriptiongxbDmow(), ColorProvidersKt.override(glanceTheme2.getColors(composer2, i9).getOnSurfaceVariant(), listItem.getSubText().getTextColor()), null, 0, composer, 560, 24);
                    composer2 = composer;
                    Unit unit3 = Unit.INSTANCE;
                }
                composer2.endReplaceableGroup();
                composer2.endReplaceableGroup();
                composer2.endNode();
                composer2.endReplaceableGroup();
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
                composer2.startReplaceableGroup(1230812560);
                if (z5 && z3) {
                    float f5 = ResourceUtilsKt.getFloat(context, C3094R.dimen.sesl_glance_list_default_item_icon_start_padding);
                    if (z || !z2) {
                        modifierM15858paddingqDBjuR0$default = companion4;
                        if (!z) {
                            modifierM15858paddingqDBjuR0$default = PaddingKt.m15858paddingqDBjuR0$default(modifierM15858paddingqDBjuR0$default, z6 ? C2256Dp.m20968constructorimpl(f5) : CommonDimensions.INSTANCE.m21775getLayoutHorizontalPaddingD9Ej5fM(), 0.0f, 0.0f, 0.0f, 14, null);
                        } else if (z2) {
                            modifierM15858paddingqDBjuR0$default = PaddingKt.m15858paddingqDBjuR0$default(modifierM15858paddingqDBjuR0$default, 0.0f, 0.0f, CommonDimensions.INSTANCE.m21775getLayoutHorizontalPaddingD9Ej5fM(), 0.0f, 11, null);
                        }
                    } else {
                        modifierM15858paddingqDBjuR0$default = PaddingKt.m15858paddingqDBjuR0$default(companion4, z6 ? C2256Dp.m20968constructorimpl(f5) : CommonDimensions.INSTANCE.m21775getLayoutHorizontalPaddingD9Ej5fM(), 0.0f, CommonDimensions.INSTANCE.m21775getLayoutHorizontalPaddingD9Ej5fM(), 0.0f, 10, null);
                    }
                    Modifier modifierWrapContentHeight$default4 = SizeKt.wrapContentHeight$default(SizeKt.fillMaxWidth$default(modifierM15858paddingqDBjuR0$default, f4, i7, vertical2), vertical2, false, 3, vertical2);
                    composer2.startReplaceableGroup(733328855);
                    MeasurePolicy measurePolicyM1210k4 = AbstractC1038a.m1210k(companion6, false, composer2, 0, -1323940314);
                    Density density9 = (Density) composer2.consume(androidx.compose.p109ui.platform.CompositionLocalsKt.getLocalDensity());
                    LayoutDirection layoutDirection9 = (LayoutDirection) composer2.consume(androidx.compose.p109ui.platform.CompositionLocalsKt.getLocalLayoutDirection());
                    ViewConfiguration viewConfiguration9 = (ViewConfiguration) composer2.consume(androidx.compose.p109ui.platform.CompositionLocalsKt.getLocalViewConfiguration());
                    Function0<ComposeUiNode> constructor9 = companion5.getConstructor();
                    Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> function3MaterializerOf9 = LayoutKt.materializerOf(modifierWrapContentHeight$default4);
                    if (composer2.getApplier() == null) {
                        ComposablesKt.invalidApplier();
                    }
                    composer2.startReusableNode();
                    if (composer2.getInserting()) {
                        composer2.useNode();
                    } else {
                        composer2.createNode(constructor9);
                    }
                    composer2.disableReusing();
                    Composer composerM18018constructorimpl9 = Updater.m18018constructorimpl(composer2);
                    ComposeUiNode.Companion companion17 = companion5;
                    Updater.m18025setimpl(composerM18018constructorimpl9, layoutDirection9, (Function2<? super T, ? super LayoutDirection, Unit>) AbstractC1038a.m1219t(companion17, composerM18018constructorimpl9, measurePolicyM1210k4, composerM18018constructorimpl9, density9));
                    function3MaterializerOf9.invoke(AbstractC1038a.m1206g(companion17, composerM18018constructorimpl9, viewConfiguration9, composer2, composer2), composer2, num);
                    composer2.startReplaceableGroup(2058660585);
                    TextBlockLayoutKt.ComposeDivider(false, colorProvider, composer2, 70, 0);
                    composer2.endReplaceableGroup();
                    composer2.endNode();
                    composer2.endReplaceableGroup();
                    composer2.endReplaceableGroup();
                }
                composer2.endReplaceableGroup();
                composer2.endReplaceableGroup();
                composer2.endNode();
                composer2.endReplaceableGroup();
                composer2.endReplaceableGroup();
                composer2.endReplaceableGroup();
            }
            companion5 = companion3;
            companion4 = companion;
            companion6 = companion2;
            num = 0;
            f4 = f;
            i7 = 1;
            vertical2 = null;
            composer2.endReplaceableGroup();
            composer2.endNode();
            composer2.endReplaceableGroup();
            composer2.endReplaceableGroup();
            composer2.endReplaceableGroup();
            composer2.endNode();
            composer2.endReplaceableGroup();
            composer2.endReplaceableGroup();
            composer2.startReplaceableGroup(1230812560);
            if (z5) {
                float f52 = ResourceUtilsKt.getFloat(context, C3094R.dimen.sesl_glance_list_default_item_icon_start_padding);
                if (z) {
                    modifierM15858paddingqDBjuR0$default = companion4;
                    if (!z) {
                    }
                    Modifier modifierWrapContentHeight$default42 = SizeKt.wrapContentHeight$default(SizeKt.fillMaxWidth$default(modifierM15858paddingqDBjuR0$default, f4, i7, vertical2), vertical2, false, 3, vertical2);
                    composer2.startReplaceableGroup(733328855);
                    MeasurePolicy measurePolicyM1210k42 = AbstractC1038a.m1210k(companion6, false, composer2, 0, -1323940314);
                    Density density92 = (Density) composer2.consume(androidx.compose.p109ui.platform.CompositionLocalsKt.getLocalDensity());
                    LayoutDirection layoutDirection92 = (LayoutDirection) composer2.consume(androidx.compose.p109ui.platform.CompositionLocalsKt.getLocalLayoutDirection());
                    ViewConfiguration viewConfiguration92 = (ViewConfiguration) composer2.consume(androidx.compose.p109ui.platform.CompositionLocalsKt.getLocalViewConfiguration());
                    Function0<ComposeUiNode> constructor92 = companion5.getConstructor();
                    Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> function3MaterializerOf92 = LayoutKt.materializerOf(modifierWrapContentHeight$default42);
                    if (composer2.getApplier() == null) {
                    }
                    composer2.startReusableNode();
                    if (composer2.getInserting()) {
                    }
                    composer2.disableReusing();
                    Composer composerM18018constructorimpl92 = Updater.m18018constructorimpl(composer2);
                    ComposeUiNode.Companion companion172 = companion5;
                    Updater.m18025setimpl(composerM18018constructorimpl92, layoutDirection92, (Function2<? super T, ? super LayoutDirection, Unit>) AbstractC1038a.m1219t(companion172, composerM18018constructorimpl92, measurePolicyM1210k42, composerM18018constructorimpl92, density92));
                    function3MaterializerOf92.invoke(AbstractC1038a.m1206g(companion172, composerM18018constructorimpl92, viewConfiguration92, composer2, composer2), composer2, num);
                    composer2.startReplaceableGroup(2058660585);
                    TextBlockLayoutKt.ComposeDivider(false, colorProvider, composer2, 70, 0);
                    composer2.endReplaceableGroup();
                    composer2.endNode();
                    composer2.endReplaceableGroup();
                    composer2.endReplaceableGroup();
                }
            }
            composer2.endReplaceableGroup();
            composer2.endReplaceableGroup();
            composer2.endNode();
            composer2.endReplaceableGroup();
            composer2.endReplaceableGroup();
            composer2.endReplaceableGroup();
        }
        Unit unit4 = Unit.INSTANCE;
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        composer.endReplaceableGroup();
    }

    @ComposableTarget(applier = "androidx.compose.ui.UiComposable")
    @Composable
    private static final void ComposeListItem$ProgressListItem(ListItem listItem, int i, int i2, boolean z, float f, boolean z2, Modifier modifier, boolean z3, int i4, Composer composer, int i5) {
        Modifier modifierM15858paddingqDBjuR0$default;
        composer.startReplaceableGroup(1045997440);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(1045997440, i5, -1, "androidx.glance.oneui.template.layout.compose.ComposeListItem.ProgressListItem (ListLayout.kt:191)");
        }
        if (listItem instanceof ProgressListItem) {
            AppWidgetSize.Companion companion = AppWidgetSize.INSTANCE;
            boolean zM21550equalsimpl0 = AppWidgetSize.m21550equalsimpl0(i, companion.m21573getWideSmallrx25Pp4());
            if (zM21550equalsimpl0) {
                modifierM15858paddingqDBjuR0$default = PaddingKt.m15858paddingqDBjuR0$default(Modifier.INSTANCE, i2 == 0 ? CommonDimensions.INSTANCE.m21775getLayoutHorizontalPaddingD9Ej5fM() : C2256Dp.m20968constructorimpl(3), 0.0f, i2 == 0 ? C2256Dp.m20968constructorimpl(3) : CommonDimensions.INSTANCE.m21775getLayoutHorizontalPaddingD9Ej5fM(), 0.0f, 10, null);
            } else {
                modifierM15858paddingqDBjuR0$default = PaddingKt.m15858paddingqDBjuR0$default(Modifier.INSTANCE, z ? f : C2256Dp.m20968constructorimpl(0), 0.0f, z2 ? f : C2256Dp.m20968constructorimpl(0), 0.0f, 10, null);
            }
            composer.startReplaceableGroup(-483455358);
            Arrangement.Vertical top = Arrangement.INSTANCE.getTop();
            Alignment.Companion companion2 = Alignment.INSTANCE;
            MeasurePolicy measurePolicyM1209j = AbstractC1038a.m1209j(companion2, top, composer, 0, -1323940314);
            Density density = (Density) composer.consume(androidx.compose.p109ui.platform.CompositionLocalsKt.getLocalDensity());
            LayoutDirection layoutDirection = (LayoutDirection) composer.consume(androidx.compose.p109ui.platform.CompositionLocalsKt.getLocalLayoutDirection());
            ViewConfiguration viewConfiguration = (ViewConfiguration) composer.consume(androidx.compose.p109ui.platform.CompositionLocalsKt.getLocalViewConfiguration());
            ComposeUiNode.Companion companion3 = ComposeUiNode.INSTANCE;
            Function0<ComposeUiNode> constructor = companion3.getConstructor();
            Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> function3MaterializerOf = LayoutKt.materializerOf(modifierM15858paddingqDBjuR0$default);
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
            Updater.m18025setimpl(composerM18018constructorimpl, layoutDirection, (Function2<? super T, ? super LayoutDirection, Unit>) AbstractC1038a.m1219t(companion3, composerM18018constructorimpl, measurePolicyM1209j, composerM18018constructorimpl, density));
            function3MaterializerOf.invoke(AbstractC1038a.m1206g(companion3, composerM18018constructorimpl, viewConfiguration, composer, composer), composer, 0);
            composer.startReplaceableGroup(2058660585);
            ColumnScopeInstance columnScopeInstance = ColumnScopeInstance.INSTANCE;
            composer.startReplaceableGroup(733328855);
            MeasurePolicy measurePolicyM1210k = AbstractC1038a.m1210k(companion2, false, composer, 0, -1323940314);
            Density density2 = (Density) composer.consume(androidx.compose.p109ui.platform.CompositionLocalsKt.getLocalDensity());
            LayoutDirection layoutDirection2 = (LayoutDirection) composer.consume(androidx.compose.p109ui.platform.CompositionLocalsKt.getLocalLayoutDirection());
            ViewConfiguration viewConfiguration2 = (ViewConfiguration) composer.consume(androidx.compose.p109ui.platform.CompositionLocalsKt.getLocalViewConfiguration());
            Function0<ComposeUiNode> constructor2 = companion3.getConstructor();
            Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> function3MaterializerOf2 = LayoutKt.materializerOf(modifier);
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
            Updater.m18025setimpl(composerM18018constructorimpl2, layoutDirection2, (Function2<? super T, ? super LayoutDirection, Unit>) AbstractC1038a.m1219t(companion3, composerM18018constructorimpl2, measurePolicyM1210k, composerM18018constructorimpl2, density2));
            function3MaterializerOf2.invoke(AbstractC1038a.m1206g(companion3, composerM18018constructorimpl2, viewConfiguration2, composer, composer), composer, 0);
            composer.startReplaceableGroup(2058660585);
            BoxScopeInstance boxScopeInstance = BoxScopeInstance.INSTANCE;
            if (AppWidgetSize.m21550equalsimpl0(i, companion.m21570getSmallrx25Pp4())) {
                composer.startReplaceableGroup(-85885741);
                ProgressIndicatorKt.ComposeLinearProgressIndicator(((ProgressListItem) listItem).getProgress(), 0, composer, 8, 2);
                composer.endReplaceableGroup();
            } else if (AppWidgetSize.m21550equalsimpl0(i, companion.m21573getWideSmallrx25Pp4())) {
                composer.startReplaceableGroup(-85885616);
                ProgressIndicatorKt.m21722ComposeLinearProgressIndicatorziNgDLE(((ProgressListItem) listItem).getProgress(), C2256Dp.m20968constructorimpl(26), composer, 56);
                composer.endReplaceableGroup();
            } else {
                composer.startReplaceableGroup(-85885503);
                ProgressIndicatorKt.ComposeLinearProgressIndicator(((ProgressListItem) listItem).getProgress(), AppWidgetHostType.m21524equalsimpl0(i4, AppWidgetHostType.INSTANCE.m21535getHomemn_SBp8()) ? C3094R.dimen.sesl_glance_list_progress_item_medium_height : C3094R.dimen.sesl_glance_list_progress_item_medium_height_at_monotone, composer, 8, 0);
                composer.endReplaceableGroup();
            }
            composer.endReplaceableGroup();
            composer.endNode();
            composer.endReplaceableGroup();
            composer.endReplaceableGroup();
            composer.startReplaceableGroup(-162690352);
            if (z3 && !zM21550equalsimpl0) {
                composer.startReplaceableGroup(-152774070);
                Modifier modifierM15885height3ABfNKs = (AppWidgetSize.m21546compareToL2j3NV4(i, companion.m21569getMediumrx25Pp4()) < 0 || !AppWidgetHostType.m21524equalsimpl0(i4, AppWidgetHostType.INSTANCE.m21535getHomemn_SBp8())) ? SizeKt.m15885height3ABfNKs(Modifier.INSTANCE, C2256Dp.m20968constructorimpl(4)) : SizeKt.m15885height3ABfNKs(Modifier.INSTANCE, PrimitiveResources_androidKt.dimensionResource(C3094R.dimen.sesl_glance_list_progress_item_medium_vertical_margin, composer, 0));
                composer.endReplaceableGroup();
                SpacerKt.Spacer(modifierM15885height3ABfNKs, composer, 0);
            }
            composer.endReplaceableGroup();
            composer.endReplaceableGroup();
            composer.endNode();
            composer.endReplaceableGroup();
            composer.endReplaceableGroup();
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        composer.endReplaceableGroup();
    }

    @ComposableTarget(applier = "androidx.compose.ui.UiComposable")
    @Composable
    /* JADX INFO: renamed from: ComposeListLayout-YlGCr2M, reason: not valid java name */
    public static final void m21804ComposeListLayoutYlGCr2M(@NotNull final ListData data, boolean z, boolean z2, float f, float f4, boolean z3, boolean z4, @Nullable Composer composer, final int i, final int i2) {
        float f5;
        float f6;
        Modifier modifierFillMaxHeight$default;
        Alignment centerStart;
        final boolean z5;
        final boolean z6;
        Intrinsics.checkNotNullParameter(data, "data");
        Composer composerStartRestartGroup = composer.startRestartGroup(1042301867);
        boolean z7 = (i2 & 2) != 0 ? true : z;
        boolean z8 = (i2 & 4) != 0 ? true : z2;
        float fM20968constructorimpl = (i2 & 8) != 0 ? C2256Dp.m20968constructorimpl(0) : f;
        float fM20968constructorimpl2 = (i2 & 16) != 0 ? C2256Dp.m20968constructorimpl(0) : f4;
        boolean z9 = (i2 & 32) != 0 ? true : z3;
        boolean z10 = (i2 & 64) != 0 ? true : z4;
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(1042301867, i, -1, "androidx.glance.oneui.template.layout.compose.ComposeListLayout (ListLayout.kt:71)");
        }
        if (data.getItems().isEmpty()) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup != null) {
                final boolean z11 = z7;
                final boolean z12 = z8;
                final float f7 = fM20968constructorimpl;
                final float f8 = fM20968constructorimpl2;
                final boolean z13 = z9;
                final boolean z14 = z10;
                scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.glance.oneui.template.layout.compose.ListLayoutKt$ComposeListLayout$1
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
                        ListLayoutKt.m21804ComposeListLayoutYlGCr2M(data, z11, z12, f7, f8, z13, z14, composer2, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
                    }
                });
                return;
            }
            return;
        }
        final boolean z15 = z7;
        final boolean z16 = z8;
        float f9 = fM20968constructorimpl;
        float f10 = fM20968constructorimpl2;
        final boolean z17 = z9;
        final boolean z18 = z10;
        int mask = ((AppWidgetSize) composerStartRestartGroup.consume(CompositionLocalsKt.getLocalWidgetSize())).getMask();
        AppWidgetSize.Companion companion = AppWidgetSize.INSTANCE;
        boolean z19 = AppWidgetSize.m21546compareToL2j3NV4(mask, companion.m21569getMediumrx25Pp4()) >= 0;
        if (z19) {
            modifierFillMaxHeight$default = PaddingKt.m15858paddingqDBjuR0$default(Modifier.INSTANCE, 0.0f, f9, 0.0f, f10, 5, null);
            f5 = f9;
            f6 = f10;
        } else {
            f5 = f9;
            f6 = f10;
            modifierFillMaxHeight$default = Modifier.INSTANCE;
        }
        if (z15) {
            modifierFillMaxHeight$default = SizeKt.fillMaxWidth$default(modifierFillMaxHeight$default, 0.0f, 1, null);
        }
        if (z16) {
            modifierFillMaxHeight$default = SizeKt.fillMaxHeight$default(modifierFillMaxHeight$default, 0.0f, 1, null);
        }
        final Alignment.Vertical verticalM21964convertr7CXYeA = ComposeUtilsKt.m21964convertr7CXYeA(data.getContentAlign(), composerStartRestartGroup, 0);
        if (!z19) {
            centerStart = Alignment.INSTANCE.getCenterStart();
        } else if (z16) {
            Alignment.Companion companion2 = Alignment.INSTANCE;
            centerStart = Intrinsics.areEqual(verticalM21964convertr7CXYeA, companion2.getTop()) ? companion2.getTopStart() : Intrinsics.areEqual(verticalM21964convertr7CXYeA, companion2.getCenterVertically()) ? companion2.getCenterStart() : companion2.getBottomStart();
        } else {
            centerStart = Alignment.INSTANCE.getTopStart();
        }
        composerStartRestartGroup.startReplaceableGroup(733328855);
        MeasurePolicy measurePolicyRememberBoxMeasurePolicy = BoxKt.rememberBoxMeasurePolicy(centerStart, false, composerStartRestartGroup, 0);
        Density density = (Density) AbstractC1038a.m1211l(composerStartRestartGroup, -1323940314);
        LayoutDirection layoutDirection = (LayoutDirection) composerStartRestartGroup.consume(androidx.compose.p109ui.platform.CompositionLocalsKt.getLocalLayoutDirection());
        ViewConfiguration viewConfiguration = (ViewConfiguration) composerStartRestartGroup.consume(androidx.compose.p109ui.platform.CompositionLocalsKt.getLocalViewConfiguration());
        ComposeUiNode.Companion companion3 = ComposeUiNode.INSTANCE;
        Function0<ComposeUiNode> constructor = companion3.getConstructor();
        Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> function3MaterializerOf = LayoutKt.materializerOf(modifierFillMaxHeight$default);
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
        final int iM21782getVisibleItemCountvA4zNRs = ListLayoutDimensions.INSTANCE.m21782getVisibleItemCountvA4zNRs(data.getItems(), data.getContentAlign(), composerStartRestartGroup, 392);
        int i4 = 3;
        Modifier modifierWrapContentHeight$default = z15 ? SizeKt.wrapContentHeight$default(SizeKt.fillMaxWidth$default(Modifier.INSTANCE, 0.0f, 1, null), null, false, 3, null) : Modifier.INSTANCE;
        composerStartRestartGroup.startReplaceableGroup(-792101920);
        if (z19) {
            composerStartRestartGroup.startReplaceableGroup(-1485320809);
            final Modifier modifier = modifierWrapContentHeight$default;
            LazyDslKt.LazyColumn(modifier, null, null, false, null, null, null, false, new Function1<LazyListScope, Unit>() { // from class: androidx.glance.oneui.template.layout.compose.ListLayoutKt$ComposeListLayout$2$1
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(LazyListScope lazyListScope) {
                    invoke2(lazyListScope);
                    return Unit.INSTANCE;
                }

                /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(@NotNull LazyListScope LazyColumn) {
                    Intrinsics.checkNotNullParameter(LazyColumn, "$this$LazyColumn");
                    final List listTake = CollectionsKt.take(data.getItems(), iM21782getVisibleItemCountvA4zNRs);
                    final int i5 = iM21782getVisibleItemCountvA4zNRs;
                    final Alignment.Vertical vertical = verticalM21964convertr7CXYeA;
                    final Modifier modifier2 = modifier;
                    final boolean z20 = z17;
                    final boolean z21 = z18;
                    final ListData listData = data;
                    LazyColumn.items(listTake.size(), null, new Function1<Integer, Object>() { // from class: androidx.glance.oneui.template.layout.compose.ListLayoutKt$ComposeListLayout$2$1$invoke$$inlined$itemsIndexed$default$2
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        {
                            super(1);
                        }

                        @Override // kotlin.jvm.functions.Function1
                        public /* bridge */ /* synthetic */ Object invoke(Integer num) {
                            return invoke(num.intValue());
                        }

                        @Nullable
                        public final Object invoke(int i6) {
                            listTake.get(i6);
                            return null;
                        }
                    }, ComposableLambdaKt.composableLambdaInstance(-1091073711, true, new Function4<LazyItemScope, Integer, Composer, Integer, Unit>() { // from class: androidx.glance.oneui.template.layout.compose.ListLayoutKt$ComposeListLayout$2$1$invoke$$inlined$itemsIndexed$default$3
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        {
                            super(4);
                        }

                        @Override // kotlin.jvm.functions.Function4
                        public /* bridge */ /* synthetic */ Unit invoke(LazyItemScope lazyItemScope, Integer num, Composer composer2, Integer num2) {
                            invoke(lazyItemScope, num.intValue(), composer2, num2.intValue());
                            return Unit.INSTANCE;
                        }

                        @Composable
                        public final void invoke(@NotNull LazyItemScope items, int i6, @Nullable Composer composer2, int i7) {
                            int i8;
                            Intrinsics.checkNotNullParameter(items, "$this$items");
                            if ((i7 & 14) == 0) {
                                i8 = (composer2.changed(items) ? 4 : 2) | i7;
                            } else {
                                i8 = i7;
                            }
                            if ((i7 & 112) == 0) {
                                i8 |= composer2.changed(i6) ? 32 : 16;
                            }
                            if ((i8 & 731) == 146 && composer2.getSkipping()) {
                                composer2.skipToGroupEnd();
                                return;
                            }
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventStart(-1091073711, i8, -1, "androidx.compose.foundation.lazy.itemsIndexed.<anonymous> (LazyDsl.kt:179)");
                            }
                            ListLayoutKt.ComposeListItem((ListItem) listTake.get(i6), i6, i5, vertical, modifier2, z20, z21, listData.getDividerColor(), composer2, (i8 & 112) | 16777224, 0);
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventEnd();
                            }
                        }
                    }));
                }
            }, composerStartRestartGroup, 0, JPEG.COM);
            composerStartRestartGroup = composerStartRestartGroup;
            composerStartRestartGroup.endReplaceableGroup();
            z5 = z17;
            z6 = z18;
        } else {
            int i5 = iM21782getVisibleItemCountvA4zNRs;
            boolean z20 = z17;
            boolean z21 = z18;
            Modifier modifier2 = modifierWrapContentHeight$default;
            composerStartRestartGroup.startReplaceableGroup(-1485320247);
            boolean z22 = AppWidgetSize.m21550equalsimpl0(((AppWidgetSize) composerStartRestartGroup.consume(CompositionLocalsKt.getLocalWidgetSize())).getMask(), companion.m21573getWideSmallrx25Pp4()) && (CollectionsKt.first((List) data.getItems()) instanceof ProgressListItem);
            composerStartRestartGroup.endReplaceableGroup();
            if (z22) {
                composerStartRestartGroup.startReplaceableGroup(-1485320128);
                Modifier modifierFillMaxSize$default = SizeKt.fillMaxSize$default(Modifier.INSTANCE, 0.0f, 1, null);
                Alignment.Vertical centerVertically = Alignment.INSTANCE.getCenterVertically();
                composerStartRestartGroup.startReplaceableGroup(693286680);
                MeasurePolicy measurePolicyM1207h = AbstractC1038a.m1207h(Arrangement.INSTANCE, centerVertically, composerStartRestartGroup, 48, -1323940314);
                Density density2 = (Density) composerStartRestartGroup.consume(androidx.compose.p109ui.platform.CompositionLocalsKt.getLocalDensity());
                LayoutDirection layoutDirection2 = (LayoutDirection) composerStartRestartGroup.consume(androidx.compose.p109ui.platform.CompositionLocalsKt.getLocalLayoutDirection());
                ViewConfiguration viewConfiguration2 = (ViewConfiguration) composerStartRestartGroup.consume(androidx.compose.p109ui.platform.CompositionLocalsKt.getLocalViewConfiguration());
                Function0<ComposeUiNode> constructor2 = companion3.getConstructor();
                Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> function3MaterializerOf2 = LayoutKt.materializerOf(modifierFillMaxSize$default);
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
                Updater.m18025setimpl(composerM18018constructorimpl2, layoutDirection2, (Function2<? super T, ? super LayoutDirection, Unit>) AbstractC1038a.m1219t(companion3, composerM18018constructorimpl2, measurePolicyM1207h, composerM18018constructorimpl2, density2));
                function3MaterializerOf2.invoke(AbstractC1038a.m1206g(companion3, composerM18018constructorimpl2, viewConfiguration2, composerStartRestartGroup, composerStartRestartGroup), composerStartRestartGroup, 0);
                composerStartRestartGroup.startReplaceableGroup(2058660585);
                RowScopeInstance rowScopeInstance = RowScopeInstance.INSTANCE;
                composerStartRestartGroup.startReplaceableGroup(-1485319975);
                int i6 = 0;
                for (Object obj : CollectionsKt.take(data.getItems(), i5)) {
                    int i7 = i6 + 1;
                    if (i6 < 0) {
                        CollectionsKt.throwIndexOverflow();
                    }
                    ListItem listItem = (ListItem) obj;
                    Modifier.Companion companion4 = Modifier.INSTANCE;
                    Modifier modifierWrapContentHeight$default2 = SizeKt.wrapContentHeight$default(RowScope.weight$default(rowScopeInstance, companion4, 1.0f, false, 2, null), null, false, i4, null);
                    composerStartRestartGroup.startReplaceableGroup(733328855);
                    Alignment.Companion companion5 = Alignment.INSTANCE;
                    MeasurePolicy measurePolicyM1210k = AbstractC1038a.m1210k(companion5, false, composerStartRestartGroup, 0, -1323940314);
                    Density density3 = (Density) composerStartRestartGroup.consume(androidx.compose.p109ui.platform.CompositionLocalsKt.getLocalDensity());
                    LayoutDirection layoutDirection3 = (LayoutDirection) composerStartRestartGroup.consume(androidx.compose.p109ui.platform.CompositionLocalsKt.getLocalLayoutDirection());
                    ViewConfiguration viewConfiguration3 = (ViewConfiguration) composerStartRestartGroup.consume(androidx.compose.p109ui.platform.CompositionLocalsKt.getLocalViewConfiguration());
                    ComposeUiNode.Companion companion6 = ComposeUiNode.INSTANCE;
                    Function0<ComposeUiNode> constructor3 = companion6.getConstructor();
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
                    Updater.m18025setimpl(composerM18018constructorimpl3, layoutDirection3, (Function2<? super T, ? super LayoutDirection, Unit>) AbstractC1038a.m1219t(companion6, composerM18018constructorimpl3, measurePolicyM1210k, composerM18018constructorimpl3, density3));
                    function3MaterializerOf3.invoke(AbstractC1038a.m1206g(companion6, composerM18018constructorimpl3, viewConfiguration3, composerStartRestartGroup, composerStartRestartGroup), composerStartRestartGroup, 0);
                    composerStartRestartGroup.startReplaceableGroup(2058660585);
                    BoxScopeInstance boxScopeInstance2 = BoxScopeInstance.INSTANCE;
                    int i8 = i5;
                    boolean z23 = z20;
                    boolean z24 = z21;
                    ComposeListItem(listItem, i6, i8, companion5.getCenterVertically(), SizeKt.wrapContentHeight$default(SizeKt.fillMaxWidth$default(companion4, 0.0f, 1, null), null, false, 3, null), z23, z24, null, composerStartRestartGroup, (i & 458752) | 27656 | (i & 3670016), 128);
                    i5 = i8;
                    composerStartRestartGroup.endReplaceableGroup();
                    composerStartRestartGroup.endNode();
                    composerStartRestartGroup.endReplaceableGroup();
                    composerStartRestartGroup.endReplaceableGroup();
                    z21 = z24;
                    i4 = 3;
                    i6 = i7;
                    z20 = z23;
                }
                composerStartRestartGroup.endReplaceableGroup();
                composerStartRestartGroup.endReplaceableGroup();
                composerStartRestartGroup.endNode();
                composerStartRestartGroup.endReplaceableGroup();
                composerStartRestartGroup.endReplaceableGroup();
                composerStartRestartGroup.endReplaceableGroup();
                z5 = z20;
                z6 = z21;
            } else {
                composerStartRestartGroup.startReplaceableGroup(-1485319400);
                composerStartRestartGroup.startReplaceableGroup(-483455358);
                MeasurePolicy measurePolicyM1209j = AbstractC1038a.m1209j(Alignment.INSTANCE, Arrangement.INSTANCE.getTop(), composerStartRestartGroup, 0, -1323940314);
                Density density4 = (Density) composerStartRestartGroup.consume(androidx.compose.p109ui.platform.CompositionLocalsKt.getLocalDensity());
                LayoutDirection layoutDirection4 = (LayoutDirection) composerStartRestartGroup.consume(androidx.compose.p109ui.platform.CompositionLocalsKt.getLocalLayoutDirection());
                ViewConfiguration viewConfiguration4 = (ViewConfiguration) composerStartRestartGroup.consume(androidx.compose.p109ui.platform.CompositionLocalsKt.getLocalViewConfiguration());
                Function0<ComposeUiNode> constructor4 = companion3.getConstructor();
                Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> function3MaterializerOf4 = LayoutKt.materializerOf(modifier2);
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
                Updater.m18025setimpl(composerM18018constructorimpl4, layoutDirection4, (Function2<? super T, ? super LayoutDirection, Unit>) AbstractC1038a.m1219t(companion3, composerM18018constructorimpl4, measurePolicyM1209j, composerM18018constructorimpl4, density4));
                function3MaterializerOf4.invoke(AbstractC1038a.m1206g(companion3, composerM18018constructorimpl4, viewConfiguration4, composerStartRestartGroup, composerStartRestartGroup), composerStartRestartGroup, 0);
                composerStartRestartGroup.startReplaceableGroup(2058660585);
                ColumnScopeInstance columnScopeInstance = ColumnScopeInstance.INSTANCE;
                composerStartRestartGroup.startReplaceableGroup(-1485319310);
                int i9 = 0;
                for (Object obj2 : CollectionsKt.take(data.getItems(), i5)) {
                    int i10 = i9 + 1;
                    if (i9 < 0) {
                        CollectionsKt.throwIndexOverflow();
                    }
                    int i11 = i5;
                    ComposeListItem((ListItem) obj2, i9, i11, verticalM21964convertr7CXYeA, modifier2, z20, z21, data.getDividerColor(), composerStartRestartGroup, (i & 3670016) | 16777224 | (i & 458752), 0);
                    i5 = i11;
                    i9 = i10;
                }
                z5 = z20;
                z6 = z21;
                composerStartRestartGroup.endReplaceableGroup();
                composerStartRestartGroup.endReplaceableGroup();
                composerStartRestartGroup.endNode();
                composerStartRestartGroup.endReplaceableGroup();
                composerStartRestartGroup.endReplaceableGroup();
                composerStartRestartGroup.endReplaceableGroup();
            }
        }
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
            final float f11 = f5;
            final float f12 = f6;
            scopeUpdateScopeEndRestartGroup2.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.glance.oneui.template.layout.compose.ListLayoutKt$ComposeListLayout$3
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(2);
                }

                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Unit invoke(Composer composer2, Integer num) {
                    invoke(composer2, num.intValue());
                    return Unit.INSTANCE;
                }

                public final void invoke(@Nullable Composer composer2, int i12) {
                    ListLayoutKt.m21804ComposeListLayoutYlGCr2M(data, z15, z16, f11, f12, z5, z6, composer2, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
                }
            });
        }
    }

    @ComposableTarget(applier = "androidx.compose.ui.UiComposable")
    @Composable
    /* JADX INFO: renamed from: ComposeListText-e4lg5Cc, reason: not valid java name */
    public static final void m21805ComposeListTexte4lg5Cc(@NotNull final TextData textData, final int i, @NotNull final ColorProvider textColor, @Nullable Modifier modifier, int i2, @Nullable Composer composer, final int i4, final int i5) {
        TextSize labelText;
        Intrinsics.checkNotNullParameter(textData, "textData");
        Intrinsics.checkNotNullParameter(textColor, "textColor");
        Composer composerStartRestartGroup = composer.startRestartGroup(448665170);
        Modifier modifier2 = (i5 & 8) != 0 ? Modifier.INSTANCE : modifier;
        final int i6 = (i5 & 16) != 0 ? 2 : i2;
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(448665170, i4, -1, "androidx.glance.oneui.template.layout.compose.ComposeListText (ListLayout.kt:555)");
        }
        TextType.Companion companion = TextType.INSTANCE;
        if (TextType.m21684equalsimpl0(i, companion.m21691getDisplaygxbDmow())) {
            composerStartRestartGroup.startReplaceableGroup(1427936371);
            labelText = ListLayoutTextSizes.INSTANCE.getDisplayText(composerStartRestartGroup, 6);
            composerStartRestartGroup.endReplaceableGroup();
        } else if (TextType.m21684equalsimpl0(i, companion.m21694getTitlegxbDmow())) {
            composerStartRestartGroup.startReplaceableGroup(1427936437);
            labelText = ListLayoutTextSizes.INSTANCE.getTitleText(composerStartRestartGroup, 6);
            composerStartRestartGroup.endReplaceableGroup();
        } else if (TextType.m21684equalsimpl0(i, companion.m21689getBodygxbDmow())) {
            composerStartRestartGroup.startReplaceableGroup(1427936500);
            labelText = ListLayoutTextSizes.INSTANCE.bodyText(i6, composerStartRestartGroup, ((i4 >> 12) & 14) | 48, 0);
            composerStartRestartGroup.endReplaceableGroup();
        } else if (TextType.m21684equalsimpl0(i, companion.m21690getDescriptiongxbDmow())) {
            composerStartRestartGroup.startReplaceableGroup(1427936594);
            labelText = ListLayoutTextSizes.INSTANCE.getDescriptionText(composerStartRestartGroup, 6);
            composerStartRestartGroup.endReplaceableGroup();
        } else {
            composerStartRestartGroup.startReplaceableGroup(1427936654);
            labelText = ListLayoutTextSizes.INSTANCE.getLabelText(composerStartRestartGroup, 6);
            composerStartRestartGroup.endReplaceableGroup();
        }
        TextKt.ComposeText(textData, labelText, textColor, modifier2, composerStartRestartGroup, (TextPercentData.$stable << 3) | 520 | (i4 & 7168), 0);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            final Modifier modifier3 = modifier2;
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.glance.oneui.template.layout.compose.ListLayoutKt$ComposeListText$1
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(2);
                }

                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Unit invoke(Composer composer2, Integer num) {
                    invoke(composer2, num.intValue());
                    return Unit.INSTANCE;
                }

                public final void invoke(@Nullable Composer composer2, int i7) {
                    ListLayoutKt.m21805ComposeListTexte4lg5Cc(textData, i, textColor, modifier3, i6, composer2, RecomposeScopeImplKt.updateChangedFlags(i4 | 1), i5);
                }
            });
        }
    }
}
