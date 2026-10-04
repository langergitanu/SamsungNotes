package androidx.compose.foundation.contextmenu;

import android.R;
import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Configuration;
import android.content.res.TypedArray;
import androidx.annotation.AttrRes;
import androidx.annotation.StyleRes;
import androidx.annotation.VisibleForTesting;
import androidx.collection.AbstractC0622a;
import androidx.compose.foundation.BackgroundKt;
import androidx.compose.foundation.ClickableKt;
import androidx.compose.foundation.ScrollKt;
import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.foundation.layout.BoxKt;
import androidx.compose.foundation.layout.BoxScopeInstance;
import androidx.compose.foundation.layout.ColumnKt;
import androidx.compose.foundation.layout.ColumnScope;
import androidx.compose.foundation.layout.ColumnScopeInstance;
import androidx.compose.foundation.layout.IntrinsicKt;
import androidx.compose.foundation.layout.IntrinsicSize;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.RowKt;
import androidx.compose.foundation.layout.RowScopeInstance;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.shape.RoundedCornerShapeKt;
import androidx.compose.foundation.text.BasicTextKt;
import androidx.compose.p109ui.Alignment;
import androidx.compose.p109ui.ComposedModifierKt;
import androidx.compose.p109ui.Modifier;
import androidx.compose.p109ui.draw.ShadowKt;
import androidx.compose.p109ui.graphics.Color;
import androidx.compose.p109ui.graphics.ColorKt;
import androidx.compose.p109ui.graphics.ColorProducer;
import androidx.compose.p109ui.layout.MeasurePolicy;
import androidx.compose.p109ui.node.ComposeUiNode;
import androidx.compose.p109ui.platform.AndroidCompositionLocals_androidKt;
import androidx.compose.p109ui.text.TextLayoutResult;
import androidx.compose.p109ui.text.TextStyle;
import androidx.compose.p109ui.window.AndroidPopup_androidKt;
import androidx.compose.p109ui.window.PopupPositionProvider;
import androidx.compose.p109ui.window.PopupProperties;
import androidx.compose.runtime.Composable;
import androidx.compose.runtime.ComposableInferredTarget;
import androidx.compose.runtime.ComposableTarget;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocalMap;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.Updater;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import org.apache.poi.java.awt.Event;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes.dex */
@Metadata(m13885d1 = {"\u0000\u0080\u0001\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\u001a=\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u00012\b\b\u0002\u0010\r\u001a\u00020\u000e2\u001c\u0010\u000f\u001a\u0018\u0012\u0004\u0012\u00020\u0011\u0012\u0004\u0012\u00020\u000b0\u0010¢\u0006\u0002\b\u0012¢\u0006\u0002\b\u0013H\u0001¢\u0006\u0002\u0010\u0014\u001ai\u0010\u0015\u001a\u00020\u000b2\u0006\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u00192\u0006\u0010\f\u001a\u00020\u00012\b\b\u0002\u0010\r\u001a\u00020\u000e2*\b\u0002\u0010\u001a\u001a$\u0012\u0013\u0012\u00110\u001b¢\u0006\f\b\u001c\u0012\b\b\u001d\u0012\u0004\b\b(\u001e\u0012\u0004\u0012\u00020\u000b\u0018\u00010\u0010¢\u0006\u0002\b\u00122\f\u0010\u001f\u001a\b\u0012\u0004\u0012\u00020\u000b0 H\u0001¢\u0006\u0002\u0010!\u001aN\u0010\"\u001a\u00020\u000b2\u0006\u0010#\u001a\u00020$2\f\u0010%\u001a\b\u0012\u0004\u0012\u00020\u000b0 2\b\b\u0002\u0010\r\u001a\u00020\u000e2\u0006\u0010\f\u001a\u00020\u00012\u0017\u0010&\u001a\u0013\u0012\u0004\u0012\u00020'\u0012\u0004\u0012\u00020\u000b0\u0010¢\u0006\u0002\b\u0013H\u0001¢\u0006\u0002\u0010(\u001aF\u0010\"\u001a\u00020\u000b2\u0006\u0010#\u001a\u00020$2\f\u0010%\u001a\b\u0012\u0004\u0012\u00020\u000b0 2\b\b\u0002\u0010\r\u001a\u00020\u000e2\u0017\u0010&\u001a\u0013\u0012\u0004\u0012\u00020'\u0012\u0004\u0012\u00020\u000b0\u0010¢\u0006\u0002\b\u0013H\u0001¢\u0006\u0002\u0010)\u001a!\u0010*\u001a\u00020\u00012\b\b\u0003\u0010+\u001a\u00020,2\b\b\u0003\u0010-\u001a\u00020,H\u0001¢\u0006\u0002\u0010.\u001a \u0010/\u001a\u00020\u001b*\u0004\u0018\u0001002\u0006\u00101\u001a\u00020\u001bH\u0002ø\u0001\u0000¢\u0006\u0004\b2\u00103\u001a \u00104\u001a\u00020\u001b*\u0004\u0018\u0001002\u0006\u00101\u001a\u00020\u001bH\u0002ø\u0001\u0000¢\u0006\u0004\b5\u00103\u001a2\u00106\u001a\u00020\u001b*\u0002072\b\b\u0001\u00108\u001a\u00020,2\b\b\u0001\u00109\u001a\u00020,2\u0006\u00101\u001a\u00020\u001bH\u0002ø\u0001\u0000¢\u0006\u0004\b:\u0010;\u001a\"\u0010<\u001a\u0004\u0018\u000100*\u0002072\b\b\u0001\u00108\u001a\u00020,2\b\b\u0001\u00109\u001a\u00020,H\u0002\"\u001c\u0010\u0000\u001a\u00020\u00018\u0000X\u0081\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u0002\u0010\u0003\u001a\u0004\b\u0004\u0010\u0005\"\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000\"\u000e\u0010\b\u001a\u00020\tX\u0082T¢\u0006\u0002\n\u0000\u0082\u0002\u0007\n\u0005\b¡\u001e0\u0001¨\u0006="}, m13886d2 = {"DefaultContextMenuColors", "Landroidx/compose/foundation/contextmenu/ContextMenuColors;", "getDefaultContextMenuColors$annotations", "()V", "getDefaultContextMenuColors", "()Landroidx/compose/foundation/contextmenu/ContextMenuColors;", "DefaultPopupProperties", "Landroidx/compose/ui/window/PopupProperties;", "DisabledAlpha", "", "ContextMenuColumn", "", "colors", "modifier", "Landroidx/compose/ui/Modifier;", "content", "Lkotlin/Function1;", "Landroidx/compose/foundation/layout/ColumnScope;", "Landroidx/compose/runtime/Composable;", "Lkotlin/ExtensionFunctionType;", "(Landroidx/compose/foundation/contextmenu/ContextMenuColors;Landroidx/compose/ui/Modifier;Lkotlin/jvm/functions/Function3;Landroidx/compose/runtime/Composer;II)V", "ContextMenuItem", "label", "", "enabled", "", "leadingIcon", "Landroidx/compose/ui/graphics/Color;", "Lkotlin/ParameterName;", "name", "iconColor", "onClick", "Lkotlin/Function0;", "(Ljava/lang/String;ZLandroidx/compose/foundation/contextmenu/ContextMenuColors;Landroidx/compose/ui/Modifier;Lkotlin/jvm/functions/Function3;Lkotlin/jvm/functions/Function0;Landroidx/compose/runtime/Composer;II)V", "ContextMenuPopup", "popupPositionProvider", "Landroidx/compose/ui/window/PopupPositionProvider;", "onDismiss", "contextMenuBuilderBlock", "Landroidx/compose/foundation/contextmenu/ContextMenuScope;", "(Landroidx/compose/ui/window/PopupPositionProvider;Lkotlin/jvm/functions/Function0;Landroidx/compose/ui/Modifier;Landroidx/compose/foundation/contextmenu/ContextMenuColors;Lkotlin/jvm/functions/Function1;Landroidx/compose/runtime/Composer;II)V", "(Landroidx/compose/ui/window/PopupPositionProvider;Lkotlin/jvm/functions/Function0;Landroidx/compose/ui/Modifier;Lkotlin/jvm/functions/Function1;Landroidx/compose/runtime/Composer;II)V", "computeContextMenuColors", "backgroundStyleId", "", "foregroundStyleId", "(IILandroidx/compose/runtime/Composer;II)Landroidx/compose/foundation/contextmenu/ContextMenuColors;", "disabledColor", "Landroid/content/res/ColorStateList;", "defaultColor", "disabledColor-4WTKRHQ", "(Landroid/content/res/ColorStateList;J)J", "enabledColor", "enabledColor-4WTKRHQ", "resolveColor", "Landroid/content/Context;", "resId", "attrId", "resolveColor-g2O1Hgs", "(Landroid/content/Context;IIJ)J", "resolveColorStateList", "foundation_release"}, m13887k = 2, m13888mv = {1, 8, 0}, m13890xi = 48)
@SourceDebugExtension({"SMAP\nContextMenuUi.android.kt\nKotlin\n*S Kotlin\n*F\n+ 1 ContextMenuUi.android.kt\nandroidx/compose/foundation/contextmenu/ContextMenuUi_androidKt\n+ 2 Column.kt\nandroidx/compose/foundation/layout/ColumnKt\n+ 3 Layout.kt\nandroidx/compose/ui/layout/LayoutKt\n+ 4 Composables.kt\nandroidx/compose/runtime/ComposablesKt\n+ 5 Composer.kt\nandroidx/compose/runtime/Updater\n+ 6 Composer.kt\nandroidx/compose/runtime/ComposerKt\n+ 7 Row.kt\nandroidx/compose/foundation/layout/RowKt\n+ 8 Box.kt\nandroidx/compose/foundation/layout/BoxKt\n+ 9 CompositionLocal.kt\nandroidx/compose/runtime/CompositionLocal\n*L\n1#1,415:1\n86#2:416\n83#2,6:417\n89#2:451\n93#2:455\n79#3,6:423\n86#3,4:438\n90#3,2:448\n94#3:454\n79#3,6:465\n86#3,4:480\n90#3,2:490\n79#3,6:501\n86#3,4:516\n90#3,2:526\n94#3:532\n94#3:536\n368#4,9:429\n377#4:450\n378#4,2:452\n368#4,9:471\n377#4:492\n368#4,9:507\n377#4:528\n378#4,2:530\n378#4,2:534\n4034#5,6:442\n4034#5,6:484\n4034#5,6:520\n1225#6,6:456\n1225#6,6:540\n99#7,3:462\n102#7:493\n106#7:537\n71#8:494\n68#8,6:495\n74#8:529\n78#8:533\n77#9:538\n77#9:539\n*S KotlinDebug\n*F\n+ 1 ContextMenuUi.android.kt\nandroidx/compose/foundation/contextmenu/ContextMenuUi_androidKt\n*L\n146#1:416\n146#1:417,6\n146#1:451\n146#1:455\n146#1:423,6\n146#1:438,4\n146#1:448,2\n146#1:454\n183#1:465,6\n183#1:480,4\n183#1:490,2\n205#1:501,6\n205#1:516,4\n205#1:526,2\n205#1:532\n183#1:536\n146#1:429,9\n146#1:450\n146#1:452,2\n183#1:471,9\n183#1:492\n205#1:507,9\n205#1:528\n205#1:530,2\n183#1:534,2\n146#1:442,6\n183#1:484,6\n205#1:520,6\n190#1:456,6\n357#1:540,6\n183#1:462,3\n183#1:493\n183#1:537\n205#1:494\n205#1:495,6\n205#1:529\n205#1:533\n356#1:538\n357#1:539\n*E\n"})
public final class ContextMenuUi_androidKt {

    @NotNull
    private static final ContextMenuColors DefaultContextMenuColors;

    @NotNull
    private static final PopupProperties DefaultPopupProperties = new PopupProperties(true, false, false, false, 14, (DefaultConstructorMarker) null);
    private static final float DisabledAlpha = 0.38f;

    static {
        Color.Companion companion = Color.INSTANCE;
        DefaultContextMenuColors = new ContextMenuColors(companion.m18562getWhite0d7_KjU(), companion.m18551getBlack0d7_KjU(), companion.m18551getBlack0d7_KjU(), Color.m18524copywmQWz5c$default(companion.m18551getBlack0d7_KjU(), 0.38f, 0.0f, 0.0f, 0.0f, 14, null), Color.m18524copywmQWz5c$default(companion.m18551getBlack0d7_KjU(), 0.38f, 0.0f, 0.0f, 0.0f, 14, null), null);
    }

    /* JADX WARN: Removed duplicated region for block: B:26:0x004a  */
    /* JADX WARN: Removed duplicated region for block: B:27:0x004d  */
    /* JADX WARN: Removed duplicated region for block: B:40:0x006f  */
    /* JADX WARN: Removed duplicated region for block: B:41:0x0071  */
    /* JADX WARN: Removed duplicated region for block: B:44:0x007a  */
    /* JADX WARN: Removed duplicated region for block: B:47:0x00f6  */
    /* JADX WARN: Removed duplicated region for block: B:50:0x0102  */
    /* JADX WARN: Removed duplicated region for block: B:51:0x0106  */
    /* JADX WARN: Removed duplicated region for block: B:56:0x0125  */
    /* JADX WARN: Removed duplicated region for block: B:59:0x0147  */
    /* JADX WARN: Removed duplicated region for block: B:62:0x0150  */
    /* JADX WARN: Removed duplicated region for block: B:64:? A[RETURN, SYNTHETIC] */
    @Composable
    @VisibleForTesting
    @ComposableInferredTarget(scheme = "[androidx.compose.ui.UiComposable[androidx.compose.ui.UiComposable]]")
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final void ContextMenuColumn(@NotNull ContextMenuColors contextMenuColors, @Nullable Modifier modifier, @NotNull final Function3<? super ColumnScope, ? super Composer, ? super Integer, Unit> function3, @Nullable Composer composer, final int i, final int i2) {
        ContextMenuColors contextMenuColors2;
        int i4;
        Modifier modifier2;
        int currentCompositeKeyHash;
        Composer composerM18018constructorimpl;
        Function2 function2M1177w;
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup;
        Composer composerStartRestartGroup = composer.startRestartGroup(-921259293);
        if ((i2 & 1) != 0) {
            i4 = i | 6;
            contextMenuColors2 = contextMenuColors;
        } else if ((i & 6) == 0) {
            contextMenuColors2 = contextMenuColors;
            i4 = (composerStartRestartGroup.changed(contextMenuColors2) ? 4 : 2) | i;
        } else {
            contextMenuColors2 = contextMenuColors;
            i4 = i;
        }
        int i5 = i2 & 2;
        if (i5 == 0) {
            if ((i & 48) == 0) {
                modifier2 = modifier;
                i4 |= composerStartRestartGroup.changed(modifier2) ? 32 : 16;
            }
            if ((i2 & 4) == 0) {
                i4 |= 384;
            } else if ((i & 384) == 0) {
                i4 |= composerStartRestartGroup.changedInstance(function3) ? 256 : 128;
            }
            if ((i4 & 147) == 146 || !composerStartRestartGroup.getSkipping()) {
                if (i5 != 0) {
                    modifier2 = Modifier.INSTANCE;
                }
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(-921259293, i4, -1, "androidx.compose.foundation.contextmenu.ContextMenuColumn (ContextMenuUi.android.kt:144)");
                }
                ContextMenuSpec contextMenuSpec = ContextMenuSpec.INSTANCE;
                Modifier modifierVerticalScroll$default = ScrollKt.verticalScroll$default(PaddingKt.m15856paddingVpY3zN4$default(IntrinsicKt.width(BackgroundKt.m15409backgroundbw27NRU$default(ShadowKt.m18189shadows4CzXII$default(modifier2, contextMenuSpec.m15529getMenuContainerElevationD9Ej5fM(), RoundedCornerShapeKt.m16137RoundedCornerShape0680j_4(contextMenuSpec.m15521getCornerRadiusD9Ej5fM()), false, 0L, 0L, 28, null), contextMenuColors2.getBackgroundColor(), null, 2, null), IntrinsicSize.Max), 0.0f, contextMenuSpec.m15530getVerticalPaddingD9Ej5fM(), 1, null), ScrollKt.rememberScrollState(0, composerStartRestartGroup, 0, 1), false, null, false, 14, null);
                int i6 = (i4 << 3) & 7168;
                MeasurePolicy measurePolicyColumnMeasurePolicy = ColumnKt.columnMeasurePolicy(Arrangement.INSTANCE.getTop(), Alignment.INSTANCE.getStart(), composerStartRestartGroup, 0);
                currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(composerStartRestartGroup, 0);
                CompositionLocalMap currentCompositionLocalMap = composerStartRestartGroup.getCurrentCompositionLocalMap();
                Modifier modifierMaterializeModifier = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifierVerticalScroll$default);
                ComposeUiNode.Companion companion = ComposeUiNode.INSTANCE;
                Function0<ComposeUiNode> constructor = companion.getConstructor();
                if (composerStartRestartGroup.getApplier() == null) {
                    ComposablesKt.invalidApplier();
                }
                composerStartRestartGroup.startReusableNode();
                if (composerStartRestartGroup.getInserting()) {
                    composerStartRestartGroup.useNode();
                } else {
                    composerStartRestartGroup.createNode(constructor);
                }
                composerM18018constructorimpl = Updater.m18018constructorimpl(composerStartRestartGroup);
                function2M1177w = AbstractC0622a.m1177w(companion, composerM18018constructorimpl, measurePolicyColumnMeasurePolicy, composerM18018constructorimpl, currentCompositionLocalMap);
                if (!composerM18018constructorimpl.getInserting() || !Intrinsics.areEqual(composerM18018constructorimpl.rememberedValue(), Integer.valueOf(currentCompositeKeyHash))) {
                    AbstractC0622a.m1178x(currentCompositeKeyHash, function2M1177w, composerM18018constructorimpl, currentCompositeKeyHash);
                }
                Updater.m18025setimpl(composerM18018constructorimpl, modifierMaterializeModifier, companion.getSetModifier());
                function3.invoke(ColumnScopeInstance.INSTANCE, composerStartRestartGroup, Integer.valueOf(((i6 >> 6) & 112) | 6));
                composerStartRestartGroup.endNode();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
            } else {
                composerStartRestartGroup.skipToGroupEnd();
            }
            scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup == null) {
                final ContextMenuColors contextMenuColors3 = contextMenuColors2;
                final Modifier modifier3 = modifier2;
                scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.foundation.contextmenu.ContextMenuUi_androidKt.ContextMenuColumn.1
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

                    public final void invoke(@Nullable Composer composer2, int i7) {
                        ContextMenuUi_androidKt.ContextMenuColumn(contextMenuColors3, modifier3, function3, composer2, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
                    }
                });
                return;
            }
            return;
        }
        i4 |= 48;
        modifier2 = modifier;
        if ((i2 & 4) == 0) {
        }
        if ((i4 & 147) == 146) {
            if (i5 != 0) {
            }
            if (ComposerKt.isTraceInProgress()) {
            }
            ContextMenuSpec contextMenuSpec2 = ContextMenuSpec.INSTANCE;
            Modifier modifierVerticalScroll$default2 = ScrollKt.verticalScroll$default(PaddingKt.m15856paddingVpY3zN4$default(IntrinsicKt.width(BackgroundKt.m15409backgroundbw27NRU$default(ShadowKt.m18189shadows4CzXII$default(modifier2, contextMenuSpec2.m15529getMenuContainerElevationD9Ej5fM(), RoundedCornerShapeKt.m16137RoundedCornerShape0680j_4(contextMenuSpec2.m15521getCornerRadiusD9Ej5fM()), false, 0L, 0L, 28, null), contextMenuColors2.getBackgroundColor(), null, 2, null), IntrinsicSize.Max), 0.0f, contextMenuSpec2.m15530getVerticalPaddingD9Ej5fM(), 1, null), ScrollKt.rememberScrollState(0, composerStartRestartGroup, 0, 1), false, null, false, 14, null);
            int i62 = (i4 << 3) & 7168;
            MeasurePolicy measurePolicyColumnMeasurePolicy2 = ColumnKt.columnMeasurePolicy(Arrangement.INSTANCE.getTop(), Alignment.INSTANCE.getStart(), composerStartRestartGroup, 0);
            currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(composerStartRestartGroup, 0);
            CompositionLocalMap currentCompositionLocalMap2 = composerStartRestartGroup.getCurrentCompositionLocalMap();
            Modifier modifierMaterializeModifier2 = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifierVerticalScroll$default2);
            ComposeUiNode.Companion companion2 = ComposeUiNode.INSTANCE;
            Function0<ComposeUiNode> constructor2 = companion2.getConstructor();
            if (composerStartRestartGroup.getApplier() == null) {
            }
            composerStartRestartGroup.startReusableNode();
            if (composerStartRestartGroup.getInserting()) {
            }
            composerM18018constructorimpl = Updater.m18018constructorimpl(composerStartRestartGroup);
            function2M1177w = AbstractC0622a.m1177w(companion2, composerM18018constructorimpl, measurePolicyColumnMeasurePolicy2, composerM18018constructorimpl, currentCompositionLocalMap2);
            if (!composerM18018constructorimpl.getInserting()) {
                AbstractC0622a.m1178x(currentCompositeKeyHash, function2M1177w, composerM18018constructorimpl, currentCompositeKeyHash);
                Updater.m18025setimpl(composerM18018constructorimpl, modifierMaterializeModifier2, companion2.getSetModifier());
                function3.invoke(ColumnScopeInstance.INSTANCE, composerStartRestartGroup, Integer.valueOf(((i62 >> 6) & 112) | 6));
                composerStartRestartGroup.endNode();
                if (ComposerKt.isTraceInProgress()) {
                }
            }
        }
        scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup == null) {
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:100:0x017f  */
    /* JADX WARN: Removed duplicated region for block: B:105:0x019e  */
    /* JADX WARN: Removed duplicated region for block: B:108:0x01ac  */
    /* JADX WARN: Removed duplicated region for block: B:110:0x01b7  */
    /* JADX WARN: Removed duplicated region for block: B:128:0x024f  */
    /* JADX WARN: Removed duplicated region for block: B:129:0x0254  */
    /* JADX WARN: Removed duplicated region for block: B:132:0x0288  */
    /* JADX WARN: Removed duplicated region for block: B:136:0x0293  */
    /* JADX WARN: Removed duplicated region for block: B:138:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:46:0x007f  */
    /* JADX WARN: Removed duplicated region for block: B:48:0x0084  */
    /* JADX WARN: Removed duplicated region for block: B:57:0x009e  */
    /* JADX WARN: Removed duplicated region for block: B:59:0x00a2  */
    /* JADX WARN: Removed duplicated region for block: B:68:0x00bb  */
    /* JADX WARN: Removed duplicated region for block: B:72:0x00cb  */
    /* JADX WARN: Removed duplicated region for block: B:73:0x00cd  */
    /* JADX WARN: Removed duplicated region for block: B:74:0x00d0  */
    /* JADX WARN: Removed duplicated region for block: B:76:0x00d3  */
    /* JADX WARN: Removed duplicated region for block: B:77:0x00d5  */
    /* JADX WARN: Removed duplicated region for block: B:80:0x00dc  */
    /* JADX WARN: Removed duplicated region for block: B:83:0x00f7  */
    /* JADX WARN: Removed duplicated region for block: B:84:0x00f9  */
    /* JADX WARN: Removed duplicated region for block: B:87:0x00ff  */
    /* JADX WARN: Removed duplicated region for block: B:88:0x0101  */
    /* JADX WARN: Removed duplicated region for block: B:93:0x0111  */
    /* JADX WARN: Removed duplicated region for block: B:96:0x016f  */
    /* JADX WARN: Removed duplicated region for block: B:99:0x017b  */
    @SuppressLint({"ComposableLambdaParameterPosition"})
    @VisibleForTesting
    @ComposableInferredTarget(scheme = "[androidx.compose.ui.UiComposable[androidx.compose.ui.UiComposable]]")
    @Composable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final void ContextMenuItem(@NotNull final String str, final boolean z, @NotNull final ContextMenuColors contextMenuColors, @Nullable Modifier modifier, @Nullable Function3<? super Color, ? super Composer, ? super Integer, Unit> function3, @NotNull final Function0<Unit> function0, @Nullable Composer composer, final int i, final int i2) {
        String str2;
        int i4;
        ContextMenuColors contextMenuColors2;
        Modifier modifier2;
        int i5;
        Function3<? super Color, ? super Composer, ? super Integer, Unit> function32;
        int i6;
        Function3<? super Color, ? super Composer, ? super Integer, Unit> function33;
        boolean z2;
        Object objRememberedValue;
        int currentCompositeKeyHash;
        Composer composerM18018constructorimpl;
        Function2 function2M1177w;
        Composer composer2;
        final Modifier modifier3;
        final Function3<? super Color, ? super Composer, ? super Integer, Unit> function34;
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup;
        Composer composerStartRestartGroup = composer.startRestartGroup(791018367);
        if ((i2 & 1) != 0) {
            i4 = i | 6;
            str2 = str;
        } else if ((i & 6) == 0) {
            str2 = str;
            i4 = (composerStartRestartGroup.changed(str2) ? 4 : 2) | i;
        } else {
            str2 = str;
            i4 = i;
        }
        if ((i2 & 2) != 0) {
            i4 |= 48;
        } else if ((i & 48) == 0) {
            i4 |= composerStartRestartGroup.changed(z) ? 32 : 16;
        }
        if ((i2 & 4) != 0) {
            i4 |= 384;
            contextMenuColors2 = contextMenuColors;
        } else {
            contextMenuColors2 = contextMenuColors;
            if ((i & 384) == 0) {
                i4 |= composerStartRestartGroup.changed(contextMenuColors2) ? 256 : 128;
            }
        }
        int i7 = i2 & 8;
        if (i7 != 0) {
            i4 |= 3072;
        } else {
            if ((i & 3072) == 0) {
                modifier2 = modifier;
                i4 |= composerStartRestartGroup.changed(modifier2) ? 2048 : 1024;
            }
            i5 = i2 & 16;
            if (i5 != 0) {
                if ((i & 24576) == 0) {
                    function32 = function3;
                    i4 |= composerStartRestartGroup.changedInstance(function32) ? 16384 : 8192;
                }
                if ((i2 & 32) != 0) {
                    i4 |= 196608;
                } else if ((i & 196608) == 0) {
                    i4 |= composerStartRestartGroup.changedInstance(function0) ? 131072 : 65536;
                }
                i6 = i4;
                if ((74899 & i6) == 74898 && composerStartRestartGroup.getSkipping()) {
                    composerStartRestartGroup.skipToGroupEnd();
                    modifier3 = modifier2;
                    composer2 = composerStartRestartGroup;
                    function34 = function32;
                } else {
                    Modifier modifier4 = i7 == 0 ? Modifier.INSTANCE : modifier2;
                    function33 = i5 == 0 ? null : function32;
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(791018367, i6, -1, "androidx.compose.foundation.contextmenu.ContextMenuItem (ContextMenuUi.android.kt:181)");
                    }
                    ContextMenuSpec contextMenuSpec = ContextMenuSpec.INSTANCE;
                    Alignment.Vertical labelVerticalTextAlignment = contextMenuSpec.getLabelVerticalTextAlignment();
                    Arrangement.HorizontalOrVertical horizontalOrVerticalM15734spacedBy0680j_4 = Arrangement.INSTANCE.m15734spacedBy0680j_4(contextMenuSpec.m15523getHorizontalPaddingD9Ej5fM());
                    z2 = ((i6 & 112) != 32) | ((458752 & i6) != 131072);
                    objRememberedValue = composerStartRestartGroup.rememberedValue();
                    if (!z2 || objRememberedValue == Composer.INSTANCE.getEmpty()) {
                        objRememberedValue = new Function0<Unit>() { // from class: androidx.compose.foundation.contextmenu.ContextMenuUi_androidKt$ContextMenuItem$1$1
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            {
                                super(0);
                            }

                            @Override // kotlin.jvm.functions.Function0
                            public /* bridge */ /* synthetic */ Unit invoke() {
                                invoke2();
                                return Unit.INSTANCE;
                            }

                            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                            public final void invoke2() {
                                if (z) {
                                    function0.invoke();
                                }
                            }
                        };
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                    }
                    Modifier modifier5 = modifier4;
                    Modifier modifierM15856paddingVpY3zN4$default = PaddingKt.m15856paddingVpY3zN4$default(SizeKt.m15902sizeInqDBjuR0(SizeKt.fillMaxWidth$default(ClickableKt.m15442clickableXHw0xAI$default(modifier5, z, str2, null, (Function0) objRememberedValue, 4, null), 0.0f, 1, null), contextMenuSpec.m15520getContainerWidthMinD9Ej5fM(), contextMenuSpec.m15528getListItemHeightD9Ej5fM(), contextMenuSpec.m15519getContainerWidthMaxD9Ej5fM(), contextMenuSpec.m15528getListItemHeightD9Ej5fM()), contextMenuSpec.m15523getHorizontalPaddingD9Ej5fM(), 0.0f, 2, null);
                    MeasurePolicy measurePolicyRowMeasurePolicy = RowKt.rowMeasurePolicy(horizontalOrVerticalM15734spacedBy0680j_4, labelVerticalTextAlignment, composerStartRestartGroup, 54);
                    currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(composerStartRestartGroup, 0);
                    CompositionLocalMap currentCompositionLocalMap = composerStartRestartGroup.getCurrentCompositionLocalMap();
                    Modifier modifierMaterializeModifier = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifierM15856paddingVpY3zN4$default);
                    ComposeUiNode.Companion companion = ComposeUiNode.INSTANCE;
                    Function0<ComposeUiNode> constructor = companion.getConstructor();
                    if (composerStartRestartGroup.getApplier() == null) {
                        ComposablesKt.invalidApplier();
                    }
                    composerStartRestartGroup.startReusableNode();
                    if (composerStartRestartGroup.getInserting()) {
                        composerStartRestartGroup.useNode();
                    } else {
                        composerStartRestartGroup.createNode(constructor);
                    }
                    composerM18018constructorimpl = Updater.m18018constructorimpl(composerStartRestartGroup);
                    function2M1177w = AbstractC0622a.m1177w(companion, composerM18018constructorimpl, measurePolicyRowMeasurePolicy, composerM18018constructorimpl, currentCompositionLocalMap);
                    if (!composerM18018constructorimpl.getInserting() || !Intrinsics.areEqual(composerM18018constructorimpl.rememberedValue(), Integer.valueOf(currentCompositeKeyHash))) {
                        AbstractC0622a.m1178x(currentCompositeKeyHash, function2M1177w, composerM18018constructorimpl, currentCompositeKeyHash);
                    }
                    Updater.m18025setimpl(composerM18018constructorimpl, modifierMaterializeModifier, companion.getSetModifier());
                    RowScopeInstance rowScopeInstance = RowScopeInstance.INSTANCE;
                    if (function33 != null) {
                        composerStartRestartGroup.startReplaceGroup(554568909);
                    } else {
                        composerStartRestartGroup.startReplaceGroup(554568910);
                        Modifier modifierM15895requiredSizeInqDBjuR0$default = SizeKt.m15895requiredSizeInqDBjuR0$default(Modifier.INSTANCE, contextMenuSpec.m15524getIconSizeD9Ej5fM(), 0.0f, contextMenuSpec.m15524getIconSizeD9Ej5fM(), contextMenuSpec.m15524getIconSizeD9Ej5fM(), 2, null);
                        MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy = BoxKt.maybeCachedBoxMeasurePolicy(Alignment.INSTANCE.getTopStart(), false);
                        int currentCompositeKeyHash2 = ComposablesKt.getCurrentCompositeKeyHash(composerStartRestartGroup, 0);
                        CompositionLocalMap currentCompositionLocalMap2 = composerStartRestartGroup.getCurrentCompositionLocalMap();
                        Modifier modifierMaterializeModifier2 = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifierM15895requiredSizeInqDBjuR0$default);
                        Function0<ComposeUiNode> constructor2 = companion.getConstructor();
                        if (composerStartRestartGroup.getApplier() == null) {
                            ComposablesKt.invalidApplier();
                        }
                        composerStartRestartGroup.startReusableNode();
                        if (composerStartRestartGroup.getInserting()) {
                            composerStartRestartGroup.createNode(constructor2);
                        } else {
                            composerStartRestartGroup.useNode();
                        }
                        Composer composerM18018constructorimpl2 = Updater.m18018constructorimpl(composerStartRestartGroup);
                        Function2 function2M1177w2 = AbstractC0622a.m1177w(companion, composerM18018constructorimpl2, measurePolicyMaybeCachedBoxMeasurePolicy, composerM18018constructorimpl2, currentCompositionLocalMap2);
                        if (composerM18018constructorimpl2.getInserting() || !Intrinsics.areEqual(composerM18018constructorimpl2.rememberedValue(), Integer.valueOf(currentCompositeKeyHash2))) {
                            AbstractC0622a.m1178x(currentCompositeKeyHash2, function2M1177w2, composerM18018constructorimpl2, currentCompositeKeyHash2);
                        }
                        Updater.m18025setimpl(composerM18018constructorimpl2, modifierMaterializeModifier2, companion.getSetModifier());
                        BoxScopeInstance boxScopeInstance = BoxScopeInstance.INSTANCE;
                        function33.invoke(Color.m18515boximpl(z ? contextMenuColors2.getIconColor() : contextMenuColors2.getDisabledIconColor()), composerStartRestartGroup, 0);
                        composerStartRestartGroup.endNode();
                    }
                    composerStartRestartGroup.endReplaceGroup();
                    TextStyle textStyleM15531textStyle8_81llA = contextMenuSpec.m15531textStyle8_81llA(!z ? contextMenuColors2.getTextColor() : contextMenuColors2.getDisabledTextColor());
                    Function3<? super Color, ? super Composer, ? super Integer, Unit> function35 = function33;
                    composer2 = composerStartRestartGroup;
                    BasicTextKt.m16149BasicTextVhcvRP8(str, rowScopeInstance.weight(Modifier.INSTANCE, 1.0f, true), textStyleM15531textStyle8_81llA, (Function1<? super TextLayoutResult, Unit>) null, 0, false, 1, 0, (ColorProducer) null, composer2, (i6 & 14) | 1572864, 440);
                    composer2.endNode();
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    modifier3 = modifier5;
                    function34 = function35;
                }
                scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup != null) {
                    scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.foundation.contextmenu.ContextMenuUi_androidKt.ContextMenuItem.3
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        /* JADX WARN: Multi-variable type inference failed */
                        {
                            super(2);
                        }

                        @Override // kotlin.jvm.functions.Function2
                        public /* bridge */ /* synthetic */ Unit invoke(Composer composer3, Integer num) {
                            invoke(composer3, num.intValue());
                            return Unit.INSTANCE;
                        }

                        public final void invoke(@Nullable Composer composer3, int i8) {
                            ContextMenuUi_androidKt.ContextMenuItem(str, z, contextMenuColors, modifier3, function34, function0, composer3, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
                        }
                    });
                    return;
                }
                return;
            }
            i4 |= 24576;
            function32 = function3;
            if ((i2 & 32) != 0) {
            }
            i6 = i4;
            if ((74899 & i6) == 74898) {
                if (i7 == 0) {
                }
                if (i5 == 0) {
                }
                if (ComposerKt.isTraceInProgress()) {
                }
                ContextMenuSpec contextMenuSpec2 = ContextMenuSpec.INSTANCE;
                Alignment.Vertical labelVerticalTextAlignment2 = contextMenuSpec2.getLabelVerticalTextAlignment();
                Arrangement.HorizontalOrVertical horizontalOrVerticalM15734spacedBy0680j_42 = Arrangement.INSTANCE.m15734spacedBy0680j_4(contextMenuSpec2.m15523getHorizontalPaddingD9Ej5fM());
                z2 = ((i6 & 112) != 32) | ((458752 & i6) != 131072);
                objRememberedValue = composerStartRestartGroup.rememberedValue();
                if (!z2) {
                    objRememberedValue = new Function0<Unit>() { // from class: androidx.compose.foundation.contextmenu.ContextMenuUi_androidKt$ContextMenuItem$1$1
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        {
                            super(0);
                        }

                        @Override // kotlin.jvm.functions.Function0
                        public /* bridge */ /* synthetic */ Unit invoke() {
                            invoke2();
                            return Unit.INSTANCE;
                        }

                        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                        public final void invoke2() {
                            if (z) {
                                function0.invoke();
                            }
                        }
                    };
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                    Modifier modifier52 = modifier4;
                    Modifier modifierM15856paddingVpY3zN4$default2 = PaddingKt.m15856paddingVpY3zN4$default(SizeKt.m15902sizeInqDBjuR0(SizeKt.fillMaxWidth$default(ClickableKt.m15442clickableXHw0xAI$default(modifier52, z, str2, null, (Function0) objRememberedValue, 4, null), 0.0f, 1, null), contextMenuSpec2.m15520getContainerWidthMinD9Ej5fM(), contextMenuSpec2.m15528getListItemHeightD9Ej5fM(), contextMenuSpec2.m15519getContainerWidthMaxD9Ej5fM(), contextMenuSpec2.m15528getListItemHeightD9Ej5fM()), contextMenuSpec2.m15523getHorizontalPaddingD9Ej5fM(), 0.0f, 2, null);
                    MeasurePolicy measurePolicyRowMeasurePolicy2 = RowKt.rowMeasurePolicy(horizontalOrVerticalM15734spacedBy0680j_42, labelVerticalTextAlignment2, composerStartRestartGroup, 54);
                    currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(composerStartRestartGroup, 0);
                    CompositionLocalMap currentCompositionLocalMap3 = composerStartRestartGroup.getCurrentCompositionLocalMap();
                    Modifier modifierMaterializeModifier3 = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifierM15856paddingVpY3zN4$default2);
                    ComposeUiNode.Companion companion2 = ComposeUiNode.INSTANCE;
                    Function0<ComposeUiNode> constructor3 = companion2.getConstructor();
                    if (composerStartRestartGroup.getApplier() == null) {
                    }
                    composerStartRestartGroup.startReusableNode();
                    if (composerStartRestartGroup.getInserting()) {
                    }
                    composerM18018constructorimpl = Updater.m18018constructorimpl(composerStartRestartGroup);
                    function2M1177w = AbstractC0622a.m1177w(companion2, composerM18018constructorimpl, measurePolicyRowMeasurePolicy2, composerM18018constructorimpl, currentCompositionLocalMap3);
                    if (!composerM18018constructorimpl.getInserting()) {
                        AbstractC0622a.m1178x(currentCompositeKeyHash, function2M1177w, composerM18018constructorimpl, currentCompositeKeyHash);
                        Updater.m18025setimpl(composerM18018constructorimpl, modifierMaterializeModifier3, companion2.getSetModifier());
                        RowScopeInstance rowScopeInstance2 = RowScopeInstance.INSTANCE;
                        if (function33 != null) {
                        }
                        composerStartRestartGroup.endReplaceGroup();
                        TextStyle textStyleM15531textStyle8_81llA2 = contextMenuSpec2.m15531textStyle8_81llA(!z ? contextMenuColors2.getTextColor() : contextMenuColors2.getDisabledTextColor());
                        Function3<? super Color, ? super Composer, ? super Integer, Unit> function352 = function33;
                        composer2 = composerStartRestartGroup;
                        BasicTextKt.m16149BasicTextVhcvRP8(str, rowScopeInstance2.weight(Modifier.INSTANCE, 1.0f, true), textStyleM15531textStyle8_81llA2, (Function1<? super TextLayoutResult, Unit>) null, 0, false, 1, 0, (ColorProducer) null, composer2, (i6 & 14) | 1572864, 440);
                        composer2.endNode();
                        if (ComposerKt.isTraceInProgress()) {
                        }
                        modifier3 = modifier52;
                        function34 = function352;
                    }
                }
            }
            scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup != null) {
            }
        }
        modifier2 = modifier;
        i5 = i2 & 16;
        if (i5 != 0) {
        }
        function32 = function3;
        if ((i2 & 32) != 0) {
        }
        i6 = i4;
        if ((74899 & i6) == 74898) {
        }
        scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
        }
    }

    @ComposableTarget(applier = "androidx.compose.ui.UiComposable")
    @Composable
    public static final void ContextMenuPopup(@NotNull PopupPositionProvider popupPositionProvider, @NotNull Function0<Unit> function0, @Nullable Modifier modifier, @NotNull Function1<? super ContextMenuScope, Unit> function1, @Nullable Composer composer, final int i, final int i2) {
        int i4;
        final PopupPositionProvider popupPositionProvider2;
        final Function0<Unit> function02;
        final Function1<? super ContextMenuScope, Unit> function12;
        final Modifier modifier2;
        Composer composerStartRestartGroup = composer.startRestartGroup(712057293);
        if ((i2 & 1) != 0) {
            i4 = i | 6;
        } else if ((i & 6) == 0) {
            i4 = (composerStartRestartGroup.changed(popupPositionProvider) ? 4 : 2) | i;
        } else {
            i4 = i;
        }
        if ((i2 & 2) != 0) {
            i4 |= 48;
        } else if ((i & 48) == 0) {
            i4 |= composerStartRestartGroup.changedInstance(function0) ? 32 : 16;
        }
        int i5 = i2 & 4;
        if (i5 != 0) {
            i4 |= 384;
        } else if ((i & 384) == 0) {
            i4 |= composerStartRestartGroup.changed(modifier) ? 256 : 128;
        }
        if ((i2 & 8) != 0) {
            i4 |= 3072;
        } else if ((i & 3072) == 0) {
            i4 |= composerStartRestartGroup.changedInstance(function1) ? 2048 : 1024;
        }
        if ((i4 & 1171) == 1170 && composerStartRestartGroup.getSkipping()) {
            composerStartRestartGroup.skipToGroupEnd();
            function12 = function1;
            modifier2 = modifier;
            function02 = function0;
            popupPositionProvider2 = popupPositionProvider;
        } else {
            if (i5 != 0) {
                modifier = Modifier.INSTANCE;
            }
            Modifier modifier3 = modifier;
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(712057293, i4, -1, "androidx.compose.foundation.contextmenu.ContextMenuPopup (ContextMenuUi.android.kt:103)");
            }
            ContextMenuPopup(popupPositionProvider, function0, modifier3, computeContextMenuColors(0, 0, composerStartRestartGroup, 0, 3), function1, composerStartRestartGroup, (i4 & Event.CAPS_LOCK) | ((i4 << 3) & 57344), 0);
            popupPositionProvider2 = popupPositionProvider;
            function02 = function0;
            function12 = function1;
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            modifier2 = modifier3;
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.foundation.contextmenu.ContextMenuUi_androidKt.ContextMenuPopup.1
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
                    ContextMenuUi_androidKt.ContextMenuPopup(popupPositionProvider2, function02, modifier2, function12, composer2, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
                }
            });
        }
    }

    @Composable
    @VisibleForTesting
    @NotNull
    public static final ContextMenuColors computeContextMenuColors(@StyleRes int i, @StyleRes int i2, @Nullable Composer composer, int i4, int i5) {
        int i6 = (i5 & 1) != 0 ? R.style.Widget.PopupMenu : i;
        int i7 = (i5 & 2) != 0 ? R.style.TextAppearance.Widget.PopupMenu.Large : i2;
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(1689505294, i4, -1, "androidx.compose.foundation.contextmenu.computeContextMenuColors (ContextMenuUi.android.kt:354)");
        }
        Context context = (Context) composer.consume(AndroidCompositionLocals_androidKt.getLocalContext());
        boolean zChanged = composer.changed((Configuration) composer.consume(AndroidCompositionLocals_androidKt.getLocalConfiguration())) | composer.changed(context);
        Object objRememberedValue = composer.rememberedValue();
        if (zChanged || objRememberedValue == Composer.INSTANCE.getEmpty()) {
            ContextMenuColors contextMenuColors = DefaultContextMenuColors;
            long jM15535resolveColorg2O1Hgs = m15535resolveColorg2O1Hgs(context, i6, R.attr.colorBackground, contextMenuColors.getBackgroundColor());
            ColorStateList colorStateListResolveColorStateList = resolveColorStateList(context, i7, R.attr.textColorPrimary);
            long jM15534enabledColor4WTKRHQ = m15534enabledColor4WTKRHQ(colorStateListResolveColorStateList, contextMenuColors.getTextColor());
            long jM15533disabledColor4WTKRHQ = m15533disabledColor4WTKRHQ(colorStateListResolveColorStateList, contextMenuColors.getDisabledTextColor());
            Object contextMenuColors2 = new ContextMenuColors(jM15535resolveColorg2O1Hgs, jM15534enabledColor4WTKRHQ, jM15534enabledColor4WTKRHQ, jM15533disabledColor4WTKRHQ, jM15533disabledColor4WTKRHQ, null);
            composer.updateRememberedValue(contextMenuColors2);
            objRememberedValue = contextMenuColors2;
        }
        ContextMenuColors contextMenuColors3 = (ContextMenuColors) objRememberedValue;
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        return contextMenuColors3;
    }

    /* JADX INFO: renamed from: disabledColor-4WTKRHQ, reason: not valid java name */
    private static final long m15533disabledColor4WTKRHQ(ColorStateList colorStateList, long j) {
        int iM18579toArgb8_81llA = ColorKt.m18579toArgb8_81llA(j);
        Integer numValueOf = colorStateList != null ? Integer.valueOf(colorStateList.getColorForState(new int[]{-16842910}, iM18579toArgb8_81llA)) : null;
        return (numValueOf == null || numValueOf.intValue() == iM18579toArgb8_81llA) ? j : ColorKt.Color(numValueOf.intValue());
    }

    /* JADX INFO: renamed from: enabledColor-4WTKRHQ, reason: not valid java name */
    private static final long m15534enabledColor4WTKRHQ(ColorStateList colorStateList, long j) {
        int iM18579toArgb8_81llA = ColorKt.m18579toArgb8_81llA(j);
        Integer numValueOf = colorStateList != null ? Integer.valueOf(colorStateList.getColorForState(new int[]{R.attr.state_enabled}, iM18579toArgb8_81llA)) : null;
        return (numValueOf == null || numValueOf.intValue() == iM18579toArgb8_81llA) ? j : ColorKt.Color(numValueOf.intValue());
    }

    @NotNull
    public static final ContextMenuColors getDefaultContextMenuColors() {
        return DefaultContextMenuColors;
    }

    /* JADX INFO: renamed from: resolveColor-g2O1Hgs, reason: not valid java name */
    private static final long m15535resolveColorg2O1Hgs(Context context, @StyleRes int i, @AttrRes int i2, long j) {
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(i, new int[]{i2});
        int iM18579toArgb8_81llA = ColorKt.m18579toArgb8_81llA(j);
        int color = typedArrayObtainStyledAttributes.getColor(0, iM18579toArgb8_81llA);
        typedArrayObtainStyledAttributes.recycle();
        return color == iM18579toArgb8_81llA ? j : ColorKt.Color(color);
    }

    private static final ColorStateList resolveColorStateList(Context context, @StyleRes int i, @AttrRes int i2) {
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(i, new int[]{i2});
        ColorStateList colorStateList = typedArrayObtainStyledAttributes.getColorStateList(0);
        typedArrayObtainStyledAttributes.recycle();
        return colorStateList;
    }

    /* JADX WARN: Removed duplicated region for block: B:36:0x005c  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x005f  */
    /* JADX WARN: Removed duplicated region for block: B:46:0x0073  */
    /* JADX WARN: Removed duplicated region for block: B:47:0x0076  */
    /* JADX WARN: Removed duplicated region for block: B:60:0x0097  */
    /* JADX WARN: Removed duplicated region for block: B:61:0x0099  */
    /* JADX WARN: Removed duplicated region for block: B:62:0x009c  */
    /* JADX WARN: Removed duplicated region for block: B:65:0x00a3  */
    /* JADX WARN: Removed duplicated region for block: B:68:0x00ce  */
    /* JADX WARN: Removed duplicated region for block: B:72:0x00d8  */
    /* JADX WARN: Removed duplicated region for block: B:74:? A[RETURN, SYNTHETIC] */
    @ComposableTarget(applier = "androidx.compose.ui.UiComposable")
    @Composable
    @VisibleForTesting
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final void ContextMenuPopup(@NotNull final PopupPositionProvider popupPositionProvider, @NotNull final Function0<Unit> function0, @Nullable Modifier modifier, @NotNull final ContextMenuColors contextMenuColors, @NotNull final Function1<? super ContextMenuScope, Unit> function1, @Nullable Composer composer, final int i, final int i2) {
        int i4;
        final Modifier modifier2;
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup;
        Composer composerStartRestartGroup = composer.startRestartGroup(1447189339);
        if ((i2 & 1) != 0) {
            i4 = i | 6;
        } else if ((i & 6) == 0) {
            i4 = (composerStartRestartGroup.changed(popupPositionProvider) ? 4 : 2) | i;
        } else {
            i4 = i;
        }
        if ((i2 & 2) != 0) {
            i4 |= 48;
        } else if ((i & 48) == 0) {
            i4 |= composerStartRestartGroup.changedInstance(function0) ? 32 : 16;
        }
        int i5 = i2 & 4;
        if (i5 == 0) {
            if ((i & 384) == 0) {
                modifier2 = modifier;
                i4 |= composerStartRestartGroup.changed(modifier2) ? 256 : 128;
            }
            if ((i2 & 8) == 0) {
                i4 |= 3072;
            } else if ((i & 3072) == 0) {
                i4 |= composerStartRestartGroup.changed(contextMenuColors) ? 2048 : 1024;
            }
            if ((i2 & 16) == 0) {
                i4 |= 24576;
            } else if ((i & 24576) == 0) {
                i4 |= composerStartRestartGroup.changedInstance(function1) ? 16384 : 8192;
            }
            if ((i4 & 9363) != 9362 && composerStartRestartGroup.getSkipping()) {
                composerStartRestartGroup.skipToGroupEnd();
            } else {
                final Modifier modifier3 = i5 == 0 ? Modifier.INSTANCE : modifier2;
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(1447189339, i4, -1, "androidx.compose.foundation.contextmenu.ContextMenuPopup (ContextMenuUi.android.kt:121)");
                }
                AndroidPopup_androidKt.Popup(popupPositionProvider, function0, DefaultPopupProperties, ComposableLambdaKt.rememberComposableLambda(795909757, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.foundation.contextmenu.ContextMenuUi_androidKt.ContextMenuPopup.2
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

                    @ComposableTarget(applier = "androidx.compose.ui.UiComposable")
                    @Composable
                    public final void invoke(@Nullable Composer composer2, int i6) {
                        if ((i6 & 3) == 2 && composer2.getSkipping()) {
                            composer2.skipToGroupEnd();
                            return;
                        }
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(795909757, i6, -1, "androidx.compose.foundation.contextmenu.ContextMenuPopup.<anonymous> (ContextMenuUi.android.kt:127)");
                        }
                        final ContextMenuColors contextMenuColors2 = contextMenuColors;
                        Modifier modifier4 = modifier3;
                        final Function1<ContextMenuScope, Unit> function12 = function1;
                        ContextMenuUi_androidKt.ContextMenuColumn(contextMenuColors2, modifier4, ComposableLambdaKt.rememberComposableLambda(1156688164, true, new Function3<ColumnScope, Composer, Integer, Unit>() { // from class: androidx.compose.foundation.contextmenu.ContextMenuUi_androidKt.ContextMenuPopup.2.1
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            /* JADX WARN: Multi-variable type inference failed */
                            {
                                super(3);
                            }

                            @Override // kotlin.jvm.functions.Function3
                            public /* bridge */ /* synthetic */ Unit invoke(ColumnScope columnScope, Composer composer3, Integer num) {
                                invoke(columnScope, composer3, num.intValue());
                                return Unit.INSTANCE;
                            }

                            @ComposableTarget(applier = "androidx.compose.ui.UiComposable")
                            @Composable
                            public final void invoke(@NotNull ColumnScope columnScope, @Nullable Composer composer3, int i7) {
                                if ((i7 & 17) == 16 && composer3.getSkipping()) {
                                    composer3.skipToGroupEnd();
                                    return;
                                }
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventStart(1156688164, i7, -1, "androidx.compose.foundation.contextmenu.ContextMenuPopup.<anonymous>.<anonymous> (ContextMenuUi.android.kt:128)");
                                }
                                Object objRememberedValue = composer3.rememberedValue();
                                if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                                    objRememberedValue = new ContextMenuScope();
                                    composer3.updateRememberedValue(objRememberedValue);
                                }
                                ContextMenuScope contextMenuScope = (ContextMenuScope) objRememberedValue;
                                Function1<ContextMenuScope, Unit> function13 = function12;
                                ContextMenuColors contextMenuColors3 = contextMenuColors2;
                                contextMenuScope.clear$foundation_release();
                                function13.invoke(contextMenuScope);
                                contextMenuScope.Content$foundation_release(contextMenuColors3, composer3, 0);
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventEnd();
                                }
                            }
                        }, composer2, 54), composer2, 384, 0);
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                    }
                }, composerStartRestartGroup, 54), composerStartRestartGroup, (i4 & 14) | 3456 | (i4 & 112), 0);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                modifier2 = modifier3;
            }
            scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup == null) {
                scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.foundation.contextmenu.ContextMenuUi_androidKt.ContextMenuPopup.3
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
                        ContextMenuUi_androidKt.ContextMenuPopup(popupPositionProvider, function0, modifier2, contextMenuColors, function1, composer2, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
                    }
                });
                return;
            }
            return;
        }
        i4 |= 384;
        modifier2 = modifier;
        if ((i2 & 8) == 0) {
        }
        if ((i2 & 16) == 0) {
        }
        if ((i4 & 9363) != 9362) {
            if (i5 == 0) {
            }
            if (ComposerKt.isTraceInProgress()) {
            }
            AndroidPopup_androidKt.Popup(popupPositionProvider, function0, DefaultPopupProperties, ComposableLambdaKt.rememberComposableLambda(795909757, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.foundation.contextmenu.ContextMenuUi_androidKt.ContextMenuPopup.2
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

                @ComposableTarget(applier = "androidx.compose.ui.UiComposable")
                @Composable
                public final void invoke(@Nullable Composer composer2, int i6) {
                    if ((i6 & 3) == 2 && composer2.getSkipping()) {
                        composer2.skipToGroupEnd();
                        return;
                    }
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(795909757, i6, -1, "androidx.compose.foundation.contextmenu.ContextMenuPopup.<anonymous> (ContextMenuUi.android.kt:127)");
                    }
                    final ContextMenuColors contextMenuColors2 = contextMenuColors;
                    Modifier modifier4 = modifier3;
                    final Function1<? super ContextMenuScope, Unit> function12 = function1;
                    ContextMenuUi_androidKt.ContextMenuColumn(contextMenuColors2, modifier4, ComposableLambdaKt.rememberComposableLambda(1156688164, true, new Function3<ColumnScope, Composer, Integer, Unit>() { // from class: androidx.compose.foundation.contextmenu.ContextMenuUi_androidKt.ContextMenuPopup.2.1
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        /* JADX WARN: Multi-variable type inference failed */
                        {
                            super(3);
                        }

                        @Override // kotlin.jvm.functions.Function3
                        public /* bridge */ /* synthetic */ Unit invoke(ColumnScope columnScope, Composer composer3, Integer num) {
                            invoke(columnScope, composer3, num.intValue());
                            return Unit.INSTANCE;
                        }

                        @ComposableTarget(applier = "androidx.compose.ui.UiComposable")
                        @Composable
                        public final void invoke(@NotNull ColumnScope columnScope, @Nullable Composer composer3, int i7) {
                            if ((i7 & 17) == 16 && composer3.getSkipping()) {
                                composer3.skipToGroupEnd();
                                return;
                            }
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventStart(1156688164, i7, -1, "androidx.compose.foundation.contextmenu.ContextMenuPopup.<anonymous>.<anonymous> (ContextMenuUi.android.kt:128)");
                            }
                            Object objRememberedValue = composer3.rememberedValue();
                            if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                                objRememberedValue = new ContextMenuScope();
                                composer3.updateRememberedValue(objRememberedValue);
                            }
                            ContextMenuScope contextMenuScope = (ContextMenuScope) objRememberedValue;
                            Function1<ContextMenuScope, Unit> function13 = function12;
                            ContextMenuColors contextMenuColors3 = contextMenuColors2;
                            contextMenuScope.clear$foundation_release();
                            function13.invoke(contextMenuScope);
                            contextMenuScope.Content$foundation_release(contextMenuColors3, composer3, 0);
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventEnd();
                            }
                        }
                    }, composer2, 54), composer2, 384, 0);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                }
            }, composerStartRestartGroup, 54), composerStartRestartGroup, (i4 & 14) | 3456 | (i4 & 112), 0);
            if (ComposerKt.isTraceInProgress()) {
            }
            modifier2 = modifier3;
        }
        scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup == null) {
        }
    }

    @VisibleForTesting
    public static /* synthetic */ void getDefaultContextMenuColors$annotations() {
    }
}
