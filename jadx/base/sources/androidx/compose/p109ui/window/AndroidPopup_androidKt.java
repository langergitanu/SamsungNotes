package androidx.compose.p109ui.window;

import android.graphics.Rect;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import androidx.collection.AbstractC0622a;
import androidx.compose.foundation.layout.AbstractC1038a;
import androidx.compose.p109ui.Alignment;
import androidx.compose.p109ui.ComposedModifierKt;
import androidx.compose.p109ui.Modifier;
import androidx.compose.p109ui.draw.AlphaKt;
import androidx.compose.p109ui.layout.LayoutCoordinates;
import androidx.compose.p109ui.layout.Measurable;
import androidx.compose.p109ui.layout.MeasurePolicy;
import androidx.compose.p109ui.layout.MeasureResult;
import androidx.compose.p109ui.layout.MeasureScope;
import androidx.compose.p109ui.layout.OnGloballyPositionedModifierKt;
import androidx.compose.p109ui.layout.OnRemeasuredModifierKt;
import androidx.compose.p109ui.layout.Placeable;
import androidx.compose.p109ui.node.ComposeUiNode;
import androidx.compose.p109ui.platform.AndroidCompositionLocals_androidKt;
import androidx.compose.p109ui.platform.CompositionLocalsKt;
import androidx.compose.p109ui.semantics.SemanticsModifierKt;
import androidx.compose.p109ui.semantics.SemanticsPropertiesKt;
import androidx.compose.p109ui.semantics.SemanticsPropertyReceiver;
import androidx.compose.p109ui.unit.Density;
import androidx.compose.p109ui.unit.IntOffsetKt;
import androidx.compose.p109ui.unit.IntRect;
import androidx.compose.p109ui.unit.IntSize;
import androidx.compose.p109ui.unit.LayoutDirection;
import androidx.compose.p109ui.window.AndroidPopup_androidKt;
import androidx.compose.runtime.Composable;
import androidx.compose.runtime.ComposableInferredTarget;
import androidx.compose.runtime.ComposableTarget;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionContext;
import androidx.compose.runtime.CompositionLocalKt;
import androidx.compose.runtime.CompositionLocalMap;
import androidx.compose.runtime.DisposableEffectResult;
import androidx.compose.runtime.DisposableEffectScope;
import androidx.compose.runtime.EffectsKt;
import androidx.compose.runtime.ProvidableCompositionLocal;
import androidx.compose.runtime.ProvidedValue;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.SnapshotStateKt;
import androidx.compose.runtime.State;
import androidx.compose.runtime.Updater;
import androidx.compose.runtime.internal.ComposableLambda;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.runtime.saveable.RememberSaveableKt;
import androidx.compose.runtime.saveable.Saver;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlinx.coroutines.CoroutineScope;
import org.apache.commons.text.lookup.StringLookupFactory;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.jetbrains.annotations.TestOnly;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(m13885d1 = {"\u0000l\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u001aU\u0010\u0007\u001a\u00020\b2\b\b\u0002\u0010\t\u001a\u00020\n2\b\b\u0002\u0010\u000b\u001a\u00020\f2\u0010\b\u0002\u0010\r\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u000e2\b\b\u0002\u0010\u000f\u001a\u00020\u00102\u0011\u0010\u0011\u001a\r\u0012\u0004\u0012\u00020\b0\u000e¢\u0006\u0002\b\u0012H\u0007ø\u0001\u0000¢\u0006\u0004\b\u0013\u0010\u0014\u001aD\u0010\u0007\u001a\u00020\b2\u0006\u0010\u0015\u001a\u00020\u00162\u0010\b\u0002\u0010\r\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u000e2\b\b\u0002\u0010\u000f\u001a\u00020\u00102\u0011\u0010\u0011\u001a\r\u0012\u0004\u0012\u00020\b0\u000e¢\u0006\u0002\b\u0012H\u0007¢\u0006\u0002\u0010\u0017\u001a(\u0010\u0018\u001a\u00020\b2\u0006\u0010\u0019\u001a\u00020\u00022\u0011\u0010\u0011\u001a\r\u0012\u0004\u0012\u00020\b0\u000e¢\u0006\u0002\b\u0012H\u0001¢\u0006\u0002\u0010\u001a\u001a+\u0010\u001b\u001a\u00020\b2\u0006\u0010\u001c\u001a\u00020\u001d2\u0013\b\b\u0010\u0011\u001a\r\u0012\u0004\u0012\u00020\b0\u000e¢\u0006\u0002\b\u0012H\u0083\b¢\u0006\u0002\u0010\u001e\u001a \u0010\u001f\u001a\u00020\u00062\u0006\u0010 \u001a\u00020!2\u0006\u0010\"\u001a\u00020#2\u0006\u0010$\u001a\u00020!H\u0002\u001a\u001c\u0010%\u001a\u00020!2\u0006\u0010&\u001a\u00020'2\n\b\u0002\u0010(\u001a\u0004\u0018\u00010\u0002H\u0007\u001a\u0014\u0010)\u001a\u00020\u0006*\u00020\u00102\u0006\u0010*\u001a\u00020!H\u0002\u001a\f\u0010+\u001a\u00020!*\u00020'H\u0000\u001a\f\u0010,\u001a\u00020-*\u00020.H\u0002\"\u001a\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0003\u0010\u0004\"\u000e\u0010\u0005\u001a\u00020\u0006X\u0082T¢\u0006\u0002\n\u0000\u0082\u0002\u0007\n\u0005\b¡\u001e0\u0001¨\u0006/²\u0006\u0015\u00100\u001a\r\u0012\u0004\u0012\u00020\b0\u000e¢\u0006\u0002\b\u0012X\u008a\u0084\u0002"}, m13886d2 = {"LocalPopupTestTag", "Landroidx/compose/runtime/ProvidableCompositionLocal;", "", "getLocalPopupTestTag", "()Landroidx/compose/runtime/ProvidableCompositionLocal;", "PopupPropertiesBaseFlags", "", "Popup", "", "alignment", "Landroidx/compose/ui/Alignment;", TypedValues.Cycle.S_WAVE_OFFSET, "Landroidx/compose/ui/unit/IntOffset;", "onDismissRequest", "Lkotlin/Function0;", StringLookupFactory.KEY_PROPERTIES, "Landroidx/compose/ui/window/PopupProperties;", "content", "Landroidx/compose/runtime/Composable;", "Popup-K5zGePQ", "(Landroidx/compose/ui/Alignment;JLkotlin/jvm/functions/Function0;Landroidx/compose/ui/window/PopupProperties;Lkotlin/jvm/functions/Function2;Landroidx/compose/runtime/Composer;II)V", "popupPositionProvider", "Landroidx/compose/ui/window/PopupPositionProvider;", "(Landroidx/compose/ui/window/PopupPositionProvider;Lkotlin/jvm/functions/Function0;Landroidx/compose/ui/window/PopupProperties;Lkotlin/jvm/functions/Function2;Landroidx/compose/runtime/Composer;II)V", "PopupTestTag", "tag", "(Ljava/lang/String;Lkotlin/jvm/functions/Function2;Landroidx/compose/runtime/Composer;I)V", "SimpleStack", "modifier", "Landroidx/compose/ui/Modifier;", "(Landroidx/compose/ui/Modifier;Lkotlin/jvm/functions/Function2;Landroidx/compose/runtime/Composer;I)V", "createFlags", "focusable", "", "securePolicy", "Landroidx/compose/ui/window/SecureFlagPolicy;", "clippingEnabled", "isPopupLayout", "view", "Landroid/view/View;", "testTag", "flagsWithSecureFlagInherited", "isParentFlagSecureEnabled", "isFlagSecureEnabled", "toIntBounds", "Landroidx/compose/ui/unit/IntRect;", "Landroid/graphics/Rect;", "ui_release", "currentContent"}, m13887k = 2, m13888mv = {1, 8, 0}, m13890xi = 48)
@SourceDebugExtension({"SMAP\nAndroidPopup.android.kt\nKotlin\n*S Kotlin\n*F\n+ 1 AndroidPopup.android.kt\nandroidx/compose/ui/window/AndroidPopup_androidKt\n+ 2 Composer.kt\nandroidx/compose/runtime/ComposerKt\n+ 3 CompositionLocal.kt\nandroidx/compose/runtime/CompositionLocal\n+ 4 Layout.kt\nandroidx/compose/ui/layout/LayoutKt\n+ 5 Composables.kt\nandroidx/compose/runtime/ComposablesKt\n+ 6 Composer.kt\nandroidx/compose/runtime/Updater\n+ 7 SnapshotState.kt\nandroidx/compose/runtime/SnapshotStateKt__SnapshotStateKt\n*L\n1#1,980:1\n1225#2,6:981\n1225#2,6:991\n1225#2,6:997\n1225#2,6:1003\n1225#2,6:1009\n1225#2,6:1015\n1225#2,6:1021\n1225#2,6:1027\n77#3:987\n77#3:988\n77#3:989\n77#3:990\n79#4,6:1033\n86#4,4:1048\n90#4,2:1058\n94#4:1063\n79#4,6:1064\n86#4,4:1079\n90#4,2:1089\n94#4:1094\n368#5,9:1039\n377#5,3:1060\n368#5,9:1070\n377#5,3:1091\n4034#6,6:1052\n4034#6,6:1083\n81#7:1095\n*S KotlinDebug\n*F\n+ 1 AndroidPopup.android.kt\nandroidx/compose/ui/window/AndroidPopup_androidKt\n*L\n270#1:981,6\n311#1:991,6\n339#1:997,6\n354#1:1003,6\n363#1:1009,6\n375#1:1015,6\n388#1:1021,6\n396#1:1027,6\n304#1:987\n305#1:988\n306#1:989\n307#1:990\n385#1:1033,6\n385#1:1048,4\n385#1:1058,2\n385#1:1063\n438#1:1064,6\n438#1:1079,4\n438#1:1089,2\n438#1:1094\n385#1:1039,9\n385#1:1060,3\n438#1:1070,9\n438#1:1091,3\n385#1:1052,6\n438#1:1083,6\n309#1:1095\n*E\n"})
public final class AndroidPopup_androidKt {

    @NotNull
    private static final ProvidableCompositionLocal<String> LocalPopupTestTag = CompositionLocalKt.compositionLocalOf$default(null, new Function0<String>() { // from class: androidx.compose.ui.window.AndroidPopup_androidKt$LocalPopupTestTag$1
        @Override // kotlin.jvm.functions.Function0
        @NotNull
        public final String invoke() {
            return "DEFAULT_TEST_TAG";
        }
    }, 1, null);
    private static final int PopupPropertiesBaseFlags = 262144;

    /* JADX INFO: renamed from: androidx.compose.ui.window.AndroidPopup_androidKt$SimpleStack$1 */
    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000\u001e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u00042\u0006\u0010\u0006\u001a\u00020\u0007H\n¢\u0006\u0004\b\b\u0010\t"}, m13886d2 = {"<anonymous>", "Landroidx/compose/ui/layout/MeasureResult;", "Landroidx/compose/ui/layout/MeasureScope;", "measurables", "", "Landroidx/compose/ui/layout/Measurable;", "constraints", "Landroidx/compose/ui/unit/Constraints;", "measure-3p2s80s", "(Landroidx/compose/ui/layout/MeasureScope;Ljava/util/List;J)Landroidx/compose/ui/layout/MeasureResult;"}, m13887k = 3, m13888mv = {1, 8, 0}, m13890xi = 48)
    @SourceDebugExtension({"SMAP\nAndroidPopup.android.kt\nKotlin\n*S Kotlin\n*F\n+ 1 AndroidPopup.android.kt\nandroidx/compose/ui/window/AndroidPopup_androidKt$SimpleStack$1\n+ 2 ListUtils.kt\nandroidx/compose/ui/util/ListUtilsKt\n*L\n1#1,980:1\n151#2,3:981\n33#2,4:984\n154#2,2:988\n38#2:990\n156#2:991\n*S KotlinDebug\n*F\n+ 1 AndroidPopup.android.kt\nandroidx/compose/ui/window/AndroidPopup_androidKt$SimpleStack$1\n*L\n448#1:981,3\n448#1:984,4\n448#1:988,2\n448#1:990\n448#1:991\n*E\n"})
    public static final class C22791 implements MeasurePolicy {
        public static final C22791 INSTANCE = new C22791();

        @Override // androidx.compose.p109ui.layout.MeasurePolicy
        @NotNull
        /* JADX INFO: renamed from: measure-3p2s80s */
        public final MeasureResult mo15214measure3p2s80s(@NotNull MeasureScope measureScope, @NotNull List<? extends Measurable> list, long j) {
            int i;
            int i2;
            int size = list.size();
            if (size == 0) {
                return MeasureScope.layout$default(measureScope, 0, 0, null, new Function1<Placeable.PlacementScope, Unit>() { // from class: androidx.compose.ui.window.AndroidPopup_androidKt.SimpleStack.1.1
                    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                    public final void invoke2(@NotNull Placeable.PlacementScope placementScope) {
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public /* bridge */ /* synthetic */ Unit invoke(Placeable.PlacementScope placementScope) {
                        invoke2(placementScope);
                        return Unit.INSTANCE;
                    }
                }, 4, null);
            }
            int i4 = 0;
            if (size == 1) {
                final Placeable placeableMo19855measureBRTryo0 = list.get(0).mo19855measureBRTryo0(j);
                return MeasureScope.layout$default(measureScope, placeableMo19855measureBRTryo0.getWidth(), placeableMo19855measureBRTryo0.getHeight(), null, new Function1<Placeable.PlacementScope, Unit>() { // from class: androidx.compose.ui.window.AndroidPopup_androidKt.SimpleStack.1.2
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public /* bridge */ /* synthetic */ Unit invoke(Placeable.PlacementScope placementScope) {
                        invoke2(placementScope);
                        return Unit.INSTANCE;
                    }

                    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                    public final void invoke2(@NotNull Placeable.PlacementScope placementScope) {
                        Placeable.PlacementScope.placeRelative$default(placementScope, placeableMo19855measureBRTryo0, 0, 0, 0.0f, 4, null);
                    }
                }, 4, null);
            }
            final ArrayList arrayList = new ArrayList(list.size());
            int size2 = list.size();
            for (int i5 = 0; i5 < size2; i5++) {
                arrayList.add(list.get(i5).mo19855measureBRTryo0(j));
            }
            int lastIndex = CollectionsKt.getLastIndex(arrayList);
            if (lastIndex >= 0) {
                int iMax = 0;
                int iMax2 = 0;
                while (true) {
                    Placeable placeable = (Placeable) arrayList.get(i4);
                    iMax = Math.max(iMax, placeable.getWidth());
                    iMax2 = Math.max(iMax2, placeable.getHeight());
                    if (i4 == lastIndex) {
                        break;
                    }
                    i4++;
                }
                i = iMax;
                i2 = iMax2;
            } else {
                i = 0;
                i2 = 0;
            }
            return MeasureScope.layout$default(measureScope, i, i2, null, new Function1<Placeable.PlacementScope, Unit>() { // from class: androidx.compose.ui.window.AndroidPopup_androidKt.SimpleStack.1.3
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                /* JADX WARN: Multi-variable type inference failed */
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(Placeable.PlacementScope placementScope) {
                    invoke2(placementScope);
                    return Unit.INSTANCE;
                }

                /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(@NotNull Placeable.PlacementScope placementScope) {
                    int lastIndex2 = CollectionsKt.getLastIndex(arrayList);
                    if (lastIndex2 < 0) {
                        return;
                    }
                    int i6 = 0;
                    while (true) {
                        Placeable.PlacementScope placementScope2 = placementScope;
                        Placeable.PlacementScope.placeRelative$default(placementScope2, arrayList.get(i6), 0, 0, 0.0f, 4, null);
                        if (i6 == lastIndex2) {
                            return;
                        }
                        i6++;
                        placementScope = placementScope2;
                    }
                }
            }, 4, null);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:100:0x01f0  */
    /* JADX WARN: Removed duplicated region for block: B:105:0x020d  */
    /* JADX WARN: Removed duplicated region for block: B:110:0x022e  */
    /* JADX WARN: Removed duplicated region for block: B:115:0x0251  */
    /* JADX WARN: Removed duplicated region for block: B:118:0x0274  */
    /* JADX WARN: Removed duplicated region for block: B:121:0x0280  */
    /* JADX WARN: Removed duplicated region for block: B:122:0x0284  */
    /* JADX WARN: Removed duplicated region for block: B:127:0x02a3  */
    /* JADX WARN: Removed duplicated region for block: B:130:0x02b6  */
    /* JADX WARN: Removed duplicated region for block: B:134:0x02c3  */
    /* JADX WARN: Removed duplicated region for block: B:136:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:26:0x0045  */
    /* JADX WARN: Removed duplicated region for block: B:28:0x004a  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x0060  */
    /* JADX WARN: Removed duplicated region for block: B:39:0x0064  */
    /* JADX WARN: Removed duplicated region for block: B:48:0x007b  */
    /* JADX WARN: Removed duplicated region for block: B:52:0x008a  */
    /* JADX WARN: Removed duplicated region for block: B:54:0x008d  */
    /* JADX WARN: Removed duplicated region for block: B:55:0x0090  */
    /* JADX WARN: Removed duplicated region for block: B:57:0x0094  */
    /* JADX WARN: Removed duplicated region for block: B:58:0x00a6  */
    /* JADX WARN: Removed duplicated region for block: B:61:0x00ae  */
    /* JADX WARN: Removed duplicated region for block: B:64:0x0119  */
    /* JADX WARN: Removed duplicated region for block: B:65:0x0149  */
    /* JADX WARN: Removed duplicated region for block: B:68:0x015c  */
    /* JADX WARN: Removed duplicated region for block: B:69:0x015e  */
    /* JADX WARN: Removed duplicated region for block: B:72:0x0166  */
    /* JADX WARN: Removed duplicated region for block: B:73:0x0168  */
    /* JADX WARN: Removed duplicated region for block: B:78:0x0182  */
    /* JADX WARN: Removed duplicated region for block: B:81:0x01a0  */
    /* JADX WARN: Removed duplicated region for block: B:82:0x01a2  */
    /* JADX WARN: Removed duplicated region for block: B:85:0x01a8  */
    /* JADX WARN: Removed duplicated region for block: B:86:0x01aa  */
    /* JADX WARN: Removed duplicated region for block: B:91:0x01c2  */
    /* JADX WARN: Removed duplicated region for block: B:95:0x01e2  */
    @Composable
    @ComposableInferredTarget(scheme = "[androidx.compose.ui.UiComposable[androidx.compose.ui.UiComposable]]")
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final void Popup(@NotNull PopupPositionProvider popupPositionProvider, @Nullable Function0<Unit> function0, @Nullable PopupProperties popupProperties, @NotNull final Function2<? super Composer, ? super Integer, Unit> function2, @Nullable Composer composer, final int i, final int i2) {
        int i4;
        Function0<Unit> function02;
        int i5;
        PopupProperties popupProperties2;
        int i6;
        final Function0<Unit> function03;
        final PopupProperties popupProperties3;
        Object objRememberedValue;
        Composer.Companion companion;
        Composer composer2;
        int i7;
        LayoutDirection layoutDirection;
        String str;
        boolean z;
        final PopupLayout popupLayout;
        final LayoutDirection layoutDirection2;
        boolean zChangedInstance;
        Object objRememberedValue2;
        boolean zChangedInstance2;
        Object objRememberedValue3;
        int i8;
        boolean z2;
        Object objRememberedValue4;
        boolean zChangedInstance3;
        Object objRememberedValue5;
        boolean zChangedInstance4;
        Object objRememberedValue6;
        boolean zChangedInstance5;
        Object objRememberedValue7;
        int currentCompositeKeyHash;
        Composer composerM18018constructorimpl;
        Function2 function2M1177w;
        final Function0<Unit> function04;
        final PopupProperties popupProperties4;
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup;
        final PopupPositionProvider popupPositionProvider2 = popupPositionProvider;
        Composer composerStartRestartGroup = composer.startRestartGroup(-830247068);
        if ((i2 & 1) != 0) {
            i4 = i | 6;
        } else if ((i & 6) == 0) {
            i4 = (composerStartRestartGroup.changed(popupPositionProvider2) ? 4 : 2) | i;
        } else {
            i4 = i;
        }
        int i9 = i2 & 2;
        if (i9 != 0) {
            i4 |= 48;
        } else {
            if ((i & 48) == 0) {
                function02 = function0;
                i4 |= composerStartRestartGroup.changedInstance(function02) ? 32 : 16;
            }
            i5 = i2 & 4;
            if (i5 != 0) {
                if ((i & 384) == 0) {
                    popupProperties2 = popupProperties;
                    i4 |= composerStartRestartGroup.changed(popupProperties2) ? 256 : 128;
                }
                if ((i2 & 8) != 0) {
                    i4 |= 3072;
                } else if ((i & 3072) == 0) {
                    i4 |= composerStartRestartGroup.changedInstance(function2) ? 2048 : 1024;
                }
                i6 = i4;
                if ((i6 & 1171) == 1170 && composerStartRestartGroup.getSkipping()) {
                    composerStartRestartGroup.skipToGroupEnd();
                    function04 = function02;
                    composer2 = composerStartRestartGroup;
                    popupProperties4 = popupProperties2;
                } else {
                    function03 = i9 == 0 ? null : function02;
                    popupProperties3 = i5 == 0 ? new PopupProperties(false, false, false, false, 15, (DefaultConstructorMarker) null) : popupProperties2;
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(-830247068, i6, -1, "androidx.compose.ui.window.Popup (AndroidPopup.android.kt:302)");
                    }
                    View view = (View) composerStartRestartGroup.consume(AndroidCompositionLocals_androidKt.getLocalView());
                    Density density = (Density) composerStartRestartGroup.consume(CompositionLocalsKt.getLocalDensity());
                    String str2 = (String) composerStartRestartGroup.consume(LocalPopupTestTag);
                    LayoutDirection layoutDirection3 = (LayoutDirection) composerStartRestartGroup.consume(CompositionLocalsKt.getLocalLayoutDirection());
                    CompositionContext compositionContextRememberCompositionContext = ComposablesKt.rememberCompositionContext(composerStartRestartGroup, 0);
                    final State stateRememberUpdatedState = SnapshotStateKt.rememberUpdatedState(function2, composerStartRestartGroup, (i6 >> 9) & 14);
                    UUID uuid = (UUID) RememberSaveableKt.m18111rememberSaveable(new Object[0], (Saver) null, (String) null, (Function0) new Function0<UUID>() { // from class: androidx.compose.ui.window.AndroidPopup_androidKt$Popup$popupId$1
                        @Override // kotlin.jvm.functions.Function0
                        public final UUID invoke() {
                            return UUID.randomUUID();
                        }
                    }, composerStartRestartGroup, 3072, 6);
                    objRememberedValue = composerStartRestartGroup.rememberedValue();
                    companion = Composer.INSTANCE;
                    if (objRememberedValue != companion.getEmpty()) {
                        i7 = i6;
                        composer2 = composerStartRestartGroup;
                        layoutDirection = layoutDirection3;
                        z = true;
                        str = str2;
                        final PopupLayout popupLayout2 = new PopupLayout(function03, popupProperties3, str, view, density, popupPositionProvider2, uuid, null, 128, null);
                        popupPositionProvider2 = popupPositionProvider2;
                        popupLayout2.setContent(compositionContextRememberCompositionContext, ComposableLambdaKt.composableLambdaInstance(1302892335, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.ui.window.AndroidPopup_androidKt$Popup$popupLayout$1$1$1
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

                            @ComposableTarget(applier = "androidx.compose.ui.UiComposable")
                            @Composable
                            public final void invoke(@Nullable Composer composer3, int i10) {
                                if ((i10 & 3) == 2 && composer3.getSkipping()) {
                                    composer3.skipToGroupEnd();
                                    return;
                                }
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventStart(1302892335, i10, -1, "androidx.compose.ui.window.Popup.<anonymous>.<anonymous>.<anonymous> (AndroidPopup.android.kt:321)");
                                }
                                Modifier modifierSemantics$default = SemanticsModifierKt.semantics$default(Modifier.INSTANCE, false, new Function1<SemanticsPropertyReceiver, Unit>() { // from class: androidx.compose.ui.window.AndroidPopup_androidKt$Popup$popupLayout$1$1$1.1
                                    @Override // kotlin.jvm.functions.Function1
                                    public /* bridge */ /* synthetic */ Unit invoke(SemanticsPropertyReceiver semanticsPropertyReceiver) {
                                        invoke2(semanticsPropertyReceiver);
                                        return Unit.INSTANCE;
                                    }

                                    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                                    public final void invoke2(@NotNull SemanticsPropertyReceiver semanticsPropertyReceiver) {
                                        SemanticsPropertiesKt.popup(semanticsPropertyReceiver);
                                    }
                                }, 1, null);
                                boolean zChangedInstance6 = composer3.changedInstance(popupLayout2);
                                final PopupLayout popupLayout3 = popupLayout2;
                                Object objRememberedValue8 = composer3.rememberedValue();
                                if (zChangedInstance6 || objRememberedValue8 == Composer.INSTANCE.getEmpty()) {
                                    objRememberedValue8 = new Function1<IntSize, Unit>() { // from class: androidx.compose.ui.window.AndroidPopup_androidKt$Popup$popupLayout$1$1$1$2$1
                                        {
                                            super(1);
                                        }

                                        @Override // kotlin.jvm.functions.Function1
                                        public /* bridge */ /* synthetic */ Unit invoke(IntSize intSize) {
                                            m21224invokeozmzZPI(intSize.getPackedValue());
                                            return Unit.INSTANCE;
                                        }

                                        /* JADX INFO: renamed from: invoke-ozmzZPI, reason: not valid java name */
                                        public final void m21224invokeozmzZPI(long j) {
                                            popupLayout3.m21228setPopupContentSizefhxjrPA(IntSize.m21130boximpl(j));
                                            popupLayout3.updatePosition();
                                        }
                                    };
                                    composer3.updateRememberedValue(objRememberedValue8);
                                }
                                Modifier modifierAlpha = AlphaKt.alpha(OnRemeasuredModifierKt.onSizeChanged(modifierSemantics$default, (Function1) objRememberedValue8), popupLayout2.getCanCalculatePosition() ? 1.0f : 0.0f);
                                final State<Function2<Composer, Integer, Unit>> state = stateRememberUpdatedState;
                                ComposableLambda composableLambdaRememberComposableLambda = ComposableLambdaKt.rememberComposableLambda(606497925, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.ui.window.AndroidPopup_androidKt$Popup$popupLayout$1$1$1.3
                                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                    /* JADX WARN: Multi-variable type inference failed */
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
                                    public final void invoke(@Nullable Composer composer4, int i11) {
                                        if ((i11 & 3) == 2 && composer4.getSkipping()) {
                                            composer4.skipToGroupEnd();
                                            return;
                                        }
                                        if (ComposerKt.isTraceInProgress()) {
                                            ComposerKt.traceEventStart(606497925, i11, -1, "androidx.compose.ui.window.Popup.<anonymous>.<anonymous>.<anonymous>.<anonymous> (AndroidPopup.android.kt:332)");
                                        }
                                        if (AbstractC1038a.m1196A(composer4, 0, AndroidPopup_androidKt.Popup$lambda$1(state))) {
                                            ComposerKt.traceEventEnd();
                                        }
                                    }
                                }, composer3, 54);
                                AndroidPopup_androidKt.C22791 c22791 = AndroidPopup_androidKt.C22791.INSTANCE;
                                int currentCompositeKeyHash2 = ComposablesKt.getCurrentCompositeKeyHash(composer3, 0);
                                CompositionLocalMap currentCompositionLocalMap = composer3.getCurrentCompositionLocalMap();
                                Modifier modifierMaterializeModifier = ComposedModifierKt.materializeModifier(composer3, modifierAlpha);
                                ComposeUiNode.Companion companion2 = ComposeUiNode.INSTANCE;
                                Function0<ComposeUiNode> constructor = companion2.getConstructor();
                                if (composer3.getApplier() == null) {
                                    ComposablesKt.invalidApplier();
                                }
                                composer3.startReusableNode();
                                if (composer3.getInserting()) {
                                    composer3.createNode(constructor);
                                } else {
                                    composer3.useNode();
                                }
                                Composer composerM18018constructorimpl2 = Updater.m18018constructorimpl(composer3);
                                Updater.m18025setimpl(composerM18018constructorimpl2, c22791, companion2.getSetMeasurePolicy());
                                Updater.m18025setimpl(composerM18018constructorimpl2, currentCompositionLocalMap, companion2.getSetResolvedCompositionLocals());
                                Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash = companion2.getSetCompositeKeyHash();
                                if (composerM18018constructorimpl2.getInserting() || !Intrinsics.areEqual(composerM18018constructorimpl2.rememberedValue(), Integer.valueOf(currentCompositeKeyHash2))) {
                                    AbstractC0622a.m1178x(currentCompositeKeyHash2, setCompositeKeyHash, composerM18018constructorimpl2, currentCompositeKeyHash2);
                                }
                                Updater.m18025setimpl(composerM18018constructorimpl2, modifierMaterializeModifier, companion2.getSetModifier());
                                composableLambdaRememberComposableLambda.invoke(composer3, 6);
                                composer3.endNode();
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventEnd();
                                }
                            }
                        }));
                        composer2.updateRememberedValue(popupLayout2);
                        objRememberedValue = popupLayout2;
                    } else {
                        composer2 = composerStartRestartGroup;
                        i7 = i6;
                        layoutDirection = layoutDirection3;
                        str = str2;
                        z = true;
                    }
                    popupLayout = (PopupLayout) objRememberedValue;
                    int i10 = i7 & 112;
                    int i11 = i7 & 896;
                    layoutDirection2 = layoutDirection;
                    zChangedInstance = composer2.changedInstance(popupLayout) | (i10 != 32 ? z : false) | (i11 != 256 ? z : false) | composer2.changed(str) | composer2.changed(layoutDirection2);
                    objRememberedValue2 = composer2.rememberedValue();
                    if (!zChangedInstance || objRememberedValue2 == companion.getEmpty()) {
                        final String str3 = str;
                        objRememberedValue2 = new Function1<DisposableEffectScope, DisposableEffectResult>() { // from class: androidx.compose.ui.window.AndroidPopup_androidKt$Popup$2$1
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            {
                                super(1);
                            }

                            @Override // kotlin.jvm.functions.Function1
                            @NotNull
                            public final DisposableEffectResult invoke(@NotNull DisposableEffectScope disposableEffectScope) {
                                popupLayout.show();
                                popupLayout.updateParameters(function03, popupProperties3, str3, layoutDirection2);
                                final PopupLayout popupLayout3 = popupLayout;
                                return new DisposableEffectResult() { // from class: androidx.compose.ui.window.AndroidPopup_androidKt$Popup$2$1$invoke$$inlined$onDispose$1
                                    @Override // androidx.compose.runtime.DisposableEffectResult
                                    public void dispose() {
                                        popupLayout3.disposeComposition();
                                        popupLayout3.dismiss();
                                    }
                                };
                            }
                        };
                        composer2.updateRememberedValue(objRememberedValue2);
                    }
                    EffectsKt.DisposableEffect(popupLayout, (Function1<? super DisposableEffectScope, ? extends DisposableEffectResult>) objRememberedValue2, composer2, 0);
                    zChangedInstance2 = composer2.changedInstance(popupLayout) | (i10 != 32 ? z : false) | (i11 != 256 ? z : false) | composer2.changed(str) | composer2.changed(layoutDirection2);
                    objRememberedValue3 = composer2.rememberedValue();
                    if (!zChangedInstance2 || objRememberedValue3 == companion.getEmpty()) {
                        final String str4 = str;
                        objRememberedValue3 = new Function0<Unit>() { // from class: androidx.compose.ui.window.AndroidPopup_androidKt$Popup$3$1
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
                                popupLayout.updateParameters(function03, popupProperties3, str4, layoutDirection2);
                            }
                        };
                        composer2.updateRememberedValue(objRememberedValue3);
                    }
                    EffectsKt.SideEffect((Function0) objRememberedValue3, composer2, 0);
                    boolean zChangedInstance6 = composer2.changedInstance(popupLayout);
                    i8 = i7 & 14;
                    if (i8 != 4) {
                        z = false;
                    }
                    z2 = zChangedInstance6 | z;
                    objRememberedValue4 = composer2.rememberedValue();
                    if (!z2 || objRememberedValue4 == companion.getEmpty()) {
                        objRememberedValue4 = new Function1<DisposableEffectScope, DisposableEffectResult>() { // from class: androidx.compose.ui.window.AndroidPopup_androidKt$Popup$4$1
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            {
                                super(1);
                            }

                            @Override // kotlin.jvm.functions.Function1
                            @NotNull
                            public final DisposableEffectResult invoke(@NotNull DisposableEffectScope disposableEffectScope) {
                                popupLayout.setPositionProvider(popupPositionProvider2);
                                popupLayout.updatePosition();
                                return new DisposableEffectResult() { // from class: androidx.compose.ui.window.AndroidPopup_androidKt$Popup$4$1$invoke$$inlined$onDispose$1
                                    @Override // androidx.compose.runtime.DisposableEffectResult
                                    public void dispose() {
                                    }
                                };
                            }
                        };
                        composer2.updateRememberedValue(objRememberedValue4);
                    }
                    EffectsKt.DisposableEffect(popupPositionProvider2, (Function1<? super DisposableEffectScope, ? extends DisposableEffectResult>) objRememberedValue4, composer2, i8);
                    zChangedInstance3 = composer2.changedInstance(popupLayout);
                    objRememberedValue5 = composer2.rememberedValue();
                    if (!zChangedInstance3 || objRememberedValue5 == companion.getEmpty()) {
                        objRememberedValue5 = new AndroidPopup_androidKt$Popup$5$1(popupLayout, null);
                        composer2.updateRememberedValue(objRememberedValue5);
                    }
                    EffectsKt.LaunchedEffect(popupLayout, (Function2<? super CoroutineScope, ? super Continuation<? super Unit>, ? extends Object>) objRememberedValue5, composer2, 0);
                    Modifier.Companion companion2 = Modifier.INSTANCE;
                    zChangedInstance4 = composer2.changedInstance(popupLayout);
                    objRememberedValue6 = composer2.rememberedValue();
                    if (!zChangedInstance4 || objRememberedValue6 == companion.getEmpty()) {
                        objRememberedValue6 = new Function1<LayoutCoordinates, Unit>() { // from class: androidx.compose.ui.window.AndroidPopup_androidKt$Popup$7$1
                            {
                                super(1);
                            }

                            @Override // kotlin.jvm.functions.Function1
                            public /* bridge */ /* synthetic */ Unit invoke(LayoutCoordinates layoutCoordinates) {
                                invoke2(layoutCoordinates);
                                return Unit.INSTANCE;
                            }

                            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                            public final void invoke2(@NotNull LayoutCoordinates layoutCoordinates) {
                                LayoutCoordinates parentLayoutCoordinates = layoutCoordinates.getParentLayoutCoordinates();
                                Intrinsics.checkNotNull(parentLayoutCoordinates);
                                popupLayout.updateParentLayoutCoordinates(parentLayoutCoordinates);
                            }
                        };
                        composer2.updateRememberedValue(objRememberedValue6);
                    }
                    Modifier modifierOnGloballyPositioned = OnGloballyPositionedModifierKt.onGloballyPositioned(companion2, (Function1) objRememberedValue6);
                    zChangedInstance5 = composer2.changedInstance(popupLayout) | composer2.changed(layoutDirection2);
                    objRememberedValue7 = composer2.rememberedValue();
                    if (!zChangedInstance5 || objRememberedValue7 == companion.getEmpty()) {
                        objRememberedValue7 = new MeasurePolicy() { // from class: androidx.compose.ui.window.AndroidPopup_androidKt$Popup$8$1
                            @Override // androidx.compose.p109ui.layout.MeasurePolicy
                            @NotNull
                            /* JADX INFO: renamed from: measure-3p2s80s */
                            public final MeasureResult mo15214measure3p2s80s(@NotNull MeasureScope measureScope, @NotNull List<? extends Measurable> list, long j) {
                                popupLayout.setParentLayoutDirection(layoutDirection2);
                                return MeasureScope.layout$default(measureScope, 0, 0, null, new Function1<Placeable.PlacementScope, Unit>() { // from class: androidx.compose.ui.window.AndroidPopup_androidKt$Popup$8$1.1
                                    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                                    public final void invoke2(@NotNull Placeable.PlacementScope placementScope) {
                                    }

                                    @Override // kotlin.jvm.functions.Function1
                                    public /* bridge */ /* synthetic */ Unit invoke(Placeable.PlacementScope placementScope) {
                                        invoke2(placementScope);
                                        return Unit.INSTANCE;
                                    }
                                }, 4, null);
                            }
                        };
                        composer2.updateRememberedValue(objRememberedValue7);
                    }
                    MeasurePolicy measurePolicy = (MeasurePolicy) objRememberedValue7;
                    currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(composer2, 0);
                    CompositionLocalMap currentCompositionLocalMap = composer2.getCurrentCompositionLocalMap();
                    Modifier modifierMaterializeModifier = ComposedModifierKt.materializeModifier(composer2, modifierOnGloballyPositioned);
                    ComposeUiNode.Companion companion3 = ComposeUiNode.INSTANCE;
                    Function0<ComposeUiNode> constructor = companion3.getConstructor();
                    if (composer2.getApplier() == null) {
                        ComposablesKt.invalidApplier();
                    }
                    composer2.startReusableNode();
                    if (composer2.getInserting()) {
                        composer2.useNode();
                    } else {
                        composer2.createNode(constructor);
                    }
                    composerM18018constructorimpl = Updater.m18018constructorimpl(composer2);
                    function2M1177w = AbstractC0622a.m1177w(companion3, composerM18018constructorimpl, measurePolicy, composerM18018constructorimpl, currentCompositionLocalMap);
                    if (!composerM18018constructorimpl.getInserting() || !Intrinsics.areEqual(composerM18018constructorimpl.rememberedValue(), Integer.valueOf(currentCompositeKeyHash))) {
                        AbstractC0622a.m1178x(currentCompositeKeyHash, function2M1177w, composerM18018constructorimpl, currentCompositeKeyHash);
                    }
                    Updater.m18025setimpl(composerM18018constructorimpl, modifierMaterializeModifier, companion3.getSetModifier());
                    composer2.endNode();
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    function04 = function03;
                    popupProperties4 = popupProperties3;
                }
                scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup != null) {
                    scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.ui.window.AndroidPopup_androidKt.Popup.9
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

                        public final void invoke(@Nullable Composer composer3, int i12) {
                            AndroidPopup_androidKt.Popup(popupPositionProvider2, function04, popupProperties4, function2, composer3, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
                        }
                    });
                    return;
                }
                return;
            }
            i4 |= 384;
            popupProperties2 = popupProperties;
            if ((i2 & 8) != 0) {
            }
            i6 = i4;
            if ((i6 & 1171) == 1170) {
                if (i9 == 0) {
                }
                if (i5 == 0) {
                }
                if (ComposerKt.isTraceInProgress()) {
                }
                View view2 = (View) composerStartRestartGroup.consume(AndroidCompositionLocals_androidKt.getLocalView());
                Density density2 = (Density) composerStartRestartGroup.consume(CompositionLocalsKt.getLocalDensity());
                String str22 = (String) composerStartRestartGroup.consume(LocalPopupTestTag);
                LayoutDirection layoutDirection32 = (LayoutDirection) composerStartRestartGroup.consume(CompositionLocalsKt.getLocalLayoutDirection());
                CompositionContext compositionContextRememberCompositionContext2 = ComposablesKt.rememberCompositionContext(composerStartRestartGroup, 0);
                final State<? extends Function2<? super Composer, ? super Integer, Unit>> stateRememberUpdatedState2 = SnapshotStateKt.rememberUpdatedState(function2, composerStartRestartGroup, (i6 >> 9) & 14);
                UUID uuid2 = (UUID) RememberSaveableKt.m18111rememberSaveable(new Object[0], (Saver) null, (String) null, (Function0) new Function0<UUID>() { // from class: androidx.compose.ui.window.AndroidPopup_androidKt$Popup$popupId$1
                    @Override // kotlin.jvm.functions.Function0
                    public final UUID invoke() {
                        return UUID.randomUUID();
                    }
                }, composerStartRestartGroup, 3072, 6);
                objRememberedValue = composerStartRestartGroup.rememberedValue();
                companion = Composer.INSTANCE;
                if (objRememberedValue != companion.getEmpty()) {
                }
                popupLayout = (PopupLayout) objRememberedValue;
                int i102 = i7 & 112;
                int i112 = i7 & 896;
                layoutDirection2 = layoutDirection;
                zChangedInstance = composer2.changedInstance(popupLayout) | (i102 != 32 ? z : false) | (i112 != 256 ? z : false) | composer2.changed(str) | composer2.changed(layoutDirection2);
                objRememberedValue2 = composer2.rememberedValue();
                if (!zChangedInstance) {
                    final String str32 = str;
                    objRememberedValue2 = new Function1<DisposableEffectScope, DisposableEffectResult>() { // from class: androidx.compose.ui.window.AndroidPopup_androidKt$Popup$2$1
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        {
                            super(1);
                        }

                        @Override // kotlin.jvm.functions.Function1
                        @NotNull
                        public final DisposableEffectResult invoke(@NotNull DisposableEffectScope disposableEffectScope) {
                            popupLayout.show();
                            popupLayout.updateParameters(function03, popupProperties3, str32, layoutDirection2);
                            final PopupLayout popupLayout3 = popupLayout;
                            return new DisposableEffectResult() { // from class: androidx.compose.ui.window.AndroidPopup_androidKt$Popup$2$1$invoke$$inlined$onDispose$1
                                @Override // androidx.compose.runtime.DisposableEffectResult
                                public void dispose() {
                                    popupLayout3.disposeComposition();
                                    popupLayout3.dismiss();
                                }
                            };
                        }
                    };
                    composer2.updateRememberedValue(objRememberedValue2);
                    EffectsKt.DisposableEffect(popupLayout, (Function1<? super DisposableEffectScope, ? extends DisposableEffectResult>) objRememberedValue2, composer2, 0);
                    zChangedInstance2 = composer2.changedInstance(popupLayout) | (i102 != 32 ? z : false) | (i112 != 256 ? z : false) | composer2.changed(str) | composer2.changed(layoutDirection2);
                    objRememberedValue3 = composer2.rememberedValue();
                    if (!zChangedInstance2) {
                        final String str42 = str;
                        objRememberedValue3 = new Function0<Unit>() { // from class: androidx.compose.ui.window.AndroidPopup_androidKt$Popup$3$1
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
                                popupLayout.updateParameters(function03, popupProperties3, str42, layoutDirection2);
                            }
                        };
                        composer2.updateRememberedValue(objRememberedValue3);
                        EffectsKt.SideEffect((Function0) objRememberedValue3, composer2, 0);
                        boolean zChangedInstance62 = composer2.changedInstance(popupLayout);
                        i8 = i7 & 14;
                        if (i8 != 4) {
                        }
                        z2 = zChangedInstance62 | z;
                        objRememberedValue4 = composer2.rememberedValue();
                        if (!z2) {
                            objRememberedValue4 = new Function1<DisposableEffectScope, DisposableEffectResult>() { // from class: androidx.compose.ui.window.AndroidPopup_androidKt$Popup$4$1
                                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                {
                                    super(1);
                                }

                                @Override // kotlin.jvm.functions.Function1
                                @NotNull
                                public final DisposableEffectResult invoke(@NotNull DisposableEffectScope disposableEffectScope) {
                                    popupLayout.setPositionProvider(popupPositionProvider2);
                                    popupLayout.updatePosition();
                                    return new DisposableEffectResult() { // from class: androidx.compose.ui.window.AndroidPopup_androidKt$Popup$4$1$invoke$$inlined$onDispose$1
                                        @Override // androidx.compose.runtime.DisposableEffectResult
                                        public void dispose() {
                                        }
                                    };
                                }
                            };
                            composer2.updateRememberedValue(objRememberedValue4);
                            EffectsKt.DisposableEffect(popupPositionProvider2, (Function1<? super DisposableEffectScope, ? extends DisposableEffectResult>) objRememberedValue4, composer2, i8);
                            zChangedInstance3 = composer2.changedInstance(popupLayout);
                            objRememberedValue5 = composer2.rememberedValue();
                            if (!zChangedInstance3) {
                                objRememberedValue5 = new AndroidPopup_androidKt$Popup$5$1(popupLayout, null);
                                composer2.updateRememberedValue(objRememberedValue5);
                                EffectsKt.LaunchedEffect(popupLayout, (Function2<? super CoroutineScope, ? super Continuation<? super Unit>, ? extends Object>) objRememberedValue5, composer2, 0);
                                Modifier.Companion companion22 = Modifier.INSTANCE;
                                zChangedInstance4 = composer2.changedInstance(popupLayout);
                                objRememberedValue6 = composer2.rememberedValue();
                                if (!zChangedInstance4) {
                                    objRememberedValue6 = new Function1<LayoutCoordinates, Unit>() { // from class: androidx.compose.ui.window.AndroidPopup_androidKt$Popup$7$1
                                        {
                                            super(1);
                                        }

                                        @Override // kotlin.jvm.functions.Function1
                                        public /* bridge */ /* synthetic */ Unit invoke(LayoutCoordinates layoutCoordinates) {
                                            invoke2(layoutCoordinates);
                                            return Unit.INSTANCE;
                                        }

                                        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                                        public final void invoke2(@NotNull LayoutCoordinates layoutCoordinates) {
                                            LayoutCoordinates parentLayoutCoordinates = layoutCoordinates.getParentLayoutCoordinates();
                                            Intrinsics.checkNotNull(parentLayoutCoordinates);
                                            popupLayout.updateParentLayoutCoordinates(parentLayoutCoordinates);
                                        }
                                    };
                                    composer2.updateRememberedValue(objRememberedValue6);
                                    Modifier modifierOnGloballyPositioned2 = OnGloballyPositionedModifierKt.onGloballyPositioned(companion22, (Function1) objRememberedValue6);
                                    zChangedInstance5 = composer2.changedInstance(popupLayout) | composer2.changed(layoutDirection2);
                                    objRememberedValue7 = composer2.rememberedValue();
                                    if (!zChangedInstance5) {
                                        objRememberedValue7 = new MeasurePolicy() { // from class: androidx.compose.ui.window.AndroidPopup_androidKt$Popup$8$1
                                            @Override // androidx.compose.p109ui.layout.MeasurePolicy
                                            @NotNull
                                            /* JADX INFO: renamed from: measure-3p2s80s */
                                            public final MeasureResult mo15214measure3p2s80s(@NotNull MeasureScope measureScope, @NotNull List<? extends Measurable> list, long j) {
                                                popupLayout.setParentLayoutDirection(layoutDirection2);
                                                return MeasureScope.layout$default(measureScope, 0, 0, null, new Function1<Placeable.PlacementScope, Unit>() { // from class: androidx.compose.ui.window.AndroidPopup_androidKt$Popup$8$1.1
                                                    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                                                    public final void invoke2(@NotNull Placeable.PlacementScope placementScope) {
                                                    }

                                                    @Override // kotlin.jvm.functions.Function1
                                                    public /* bridge */ /* synthetic */ Unit invoke(Placeable.PlacementScope placementScope) {
                                                        invoke2(placementScope);
                                                        return Unit.INSTANCE;
                                                    }
                                                }, 4, null);
                                            }
                                        };
                                        composer2.updateRememberedValue(objRememberedValue7);
                                        MeasurePolicy measurePolicy2 = (MeasurePolicy) objRememberedValue7;
                                        currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(composer2, 0);
                                        CompositionLocalMap currentCompositionLocalMap2 = composer2.getCurrentCompositionLocalMap();
                                        Modifier modifierMaterializeModifier2 = ComposedModifierKt.materializeModifier(composer2, modifierOnGloballyPositioned2);
                                        ComposeUiNode.Companion companion32 = ComposeUiNode.INSTANCE;
                                        Function0<ComposeUiNode> constructor2 = companion32.getConstructor();
                                        if (composer2.getApplier() == null) {
                                        }
                                        composer2.startReusableNode();
                                        if (composer2.getInserting()) {
                                        }
                                        composerM18018constructorimpl = Updater.m18018constructorimpl(composer2);
                                        function2M1177w = AbstractC0622a.m1177w(companion32, composerM18018constructorimpl, measurePolicy2, composerM18018constructorimpl, currentCompositionLocalMap2);
                                        if (!composerM18018constructorimpl.getInserting()) {
                                            AbstractC0622a.m1178x(currentCompositeKeyHash, function2M1177w, composerM18018constructorimpl, currentCompositeKeyHash);
                                            Updater.m18025setimpl(composerM18018constructorimpl, modifierMaterializeModifier2, companion32.getSetModifier());
                                            composer2.endNode();
                                            if (ComposerKt.isTraceInProgress()) {
                                            }
                                            function04 = function03;
                                            popupProperties4 = popupProperties3;
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
            scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup != null) {
            }
        }
        function02 = function0;
        i5 = i2 & 4;
        if (i5 != 0) {
        }
        popupProperties2 = popupProperties;
        if ((i2 & 8) != 0) {
        }
        i6 = i4;
        if ((i6 & 1171) == 1170) {
        }
        scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Function2<Composer, Integer, Unit> Popup$lambda$1(State<? extends Function2<? super Composer, ? super Integer, Unit>> state) {
        return (Function2) state.getValue();
    }

    /* JADX WARN: Removed duplicated region for block: B:100:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:26:0x0048  */
    /* JADX WARN: Removed duplicated region for block: B:28:0x004d  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x0063  */
    /* JADX WARN: Removed duplicated region for block: B:39:0x0068  */
    /* JADX WARN: Removed duplicated region for block: B:48:0x007e  */
    /* JADX WARN: Removed duplicated region for block: B:50:0x0083  */
    /* JADX WARN: Removed duplicated region for block: B:59:0x009c  */
    /* JADX WARN: Removed duplicated region for block: B:63:0x00ac  */
    /* JADX WARN: Removed duplicated region for block: B:64:0x00ae  */
    /* JADX WARN: Removed duplicated region for block: B:65:0x00b5  */
    /* JADX WARN: Removed duplicated region for block: B:68:0x00b9  */
    /* JADX WARN: Removed duplicated region for block: B:69:0x00be  */
    /* JADX WARN: Removed duplicated region for block: B:72:0x00c2  */
    /* JADX WARN: Removed duplicated region for block: B:73:0x00c4  */
    /* JADX WARN: Removed duplicated region for block: B:75:0x00c7  */
    /* JADX WARN: Removed duplicated region for block: B:76:0x00db  */
    /* JADX WARN: Removed duplicated region for block: B:79:0x00e2  */
    /* JADX WARN: Removed duplicated region for block: B:82:0x00ee  */
    /* JADX WARN: Removed duplicated region for block: B:83:0x00f0  */
    /* JADX WARN: Removed duplicated region for block: B:86:0x00f7  */
    /* JADX WARN: Removed duplicated region for block: B:91:0x0107  */
    /* JADX WARN: Removed duplicated region for block: B:94:0x0121  */
    /* JADX WARN: Removed duplicated region for block: B:98:0x012d  */
    @Composable
    @ComposableInferredTarget(scheme = "[androidx.compose.ui.UiComposable[androidx.compose.ui.UiComposable]]")
    /* JADX INFO: renamed from: Popup-K5zGePQ, reason: not valid java name */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final void m21223PopupK5zGePQ(@Nullable Alignment alignment, long j, @Nullable Function0<Unit> function0, @Nullable PopupProperties popupProperties, @NotNull final Function2<? super Composer, ? super Integer, Unit> function2, @Nullable Composer composer, final int i, final int i2) {
        Alignment alignment2;
        int i4;
        long j2;
        int i5;
        Function0<Unit> function02;
        int i6;
        PopupProperties popupProperties2;
        Function2<? super Composer, ? super Integer, Unit> function22;
        final Alignment topStart;
        long jIntOffset;
        DefaultConstructorMarker defaultConstructorMarker;
        boolean z;
        Object objRememberedValue;
        final long j3;
        final Function0<Unit> function03;
        final PopupProperties popupProperties3;
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup;
        Composer composerStartRestartGroup = composer.startRestartGroup(295309329);
        int i7 = i2 & 1;
        if (i7 != 0) {
            i4 = i | 6;
            alignment2 = alignment;
        } else if ((i & 6) == 0) {
            alignment2 = alignment;
            i4 = (composerStartRestartGroup.changed(alignment2) ? 4 : 2) | i;
        } else {
            alignment2 = alignment;
            i4 = i;
        }
        int i8 = i2 & 2;
        if (i8 != 0) {
            i4 |= 48;
        } else {
            if ((i & 48) == 0) {
                j2 = j;
                i4 |= composerStartRestartGroup.changed(j2) ? 32 : 16;
            }
            i5 = i2 & 4;
            if (i5 == 0) {
                i4 |= 384;
            } else {
                if ((i & 384) == 0) {
                    function02 = function0;
                    i4 |= composerStartRestartGroup.changedInstance(function02) ? 256 : 128;
                }
                i6 = i2 & 8;
                if (i6 != 0) {
                    i4 |= 3072;
                } else {
                    if ((i & 3072) == 0) {
                        popupProperties2 = popupProperties;
                        i4 |= composerStartRestartGroup.changed(popupProperties2) ? 2048 : 1024;
                    }
                    if ((i2 & 16) != 0) {
                        if ((i & 24576) == 0) {
                            function22 = function2;
                            i4 |= composerStartRestartGroup.changedInstance(function22) ? 16384 : 8192;
                        }
                        if ((i4 & 9363) == 9362 && composerStartRestartGroup.getSkipping()) {
                            composerStartRestartGroup.skipToGroupEnd();
                            topStart = alignment2;
                            j3 = j2;
                            function03 = function02;
                            popupProperties3 = popupProperties2;
                        } else {
                            topStart = i7 == 0 ? Alignment.INSTANCE.getTopStart() : alignment2;
                            jIntOffset = i8 == 0 ? IntOffsetKt.IntOffset(0, 0) : j2;
                            defaultConstructorMarker = null;
                            Function0<Unit> function04 = i5 == 0 ? null : function02;
                            PopupProperties popupProperties4 = i6 == 0 ? new PopupProperties(false, false, false, false, 15, (DefaultConstructorMarker) null) : popupProperties2;
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventStart(295309329, i4, -1, "androidx.compose.ui.window.Popup (AndroidPopup.android.kt:268)");
                            }
                            z = ((i4 & 14) != 4) | ((i4 & 112) == 32);
                            objRememberedValue = composerStartRestartGroup.rememberedValue();
                            if (!z || objRememberedValue == Composer.INSTANCE.getEmpty()) {
                                objRememberedValue = new AlignmentOffsetPositionProvider(topStart, jIntOffset, defaultConstructorMarker);
                                composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                            }
                            Popup((AlignmentOffsetPositionProvider) objRememberedValue, function04, popupProperties4, function22, composerStartRestartGroup, (i4 >> 3) & 8176, 0);
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventEnd();
                            }
                            j3 = jIntOffset;
                            function03 = function04;
                            popupProperties3 = popupProperties4;
                        }
                        scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                        if (scopeUpdateScopeEndRestartGroup != null) {
                            scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.ui.window.AndroidPopup_androidKt.Popup.1
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

                                public final void invoke(@Nullable Composer composer2, int i9) {
                                    AndroidPopup_androidKt.m21223PopupK5zGePQ(topStart, j3, function03, popupProperties3, function2, composer2, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
                                }
                            });
                            return;
                        }
                        return;
                    }
                    i4 |= 24576;
                    function22 = function2;
                    if ((i4 & 9363) == 9362) {
                        if (i7 == 0) {
                        }
                        if (i8 == 0) {
                        }
                        defaultConstructorMarker = null;
                        if (i5 == 0) {
                        }
                        if (i6 == 0) {
                        }
                        if (ComposerKt.isTraceInProgress()) {
                        }
                        z = ((i4 & 14) != 4) | ((i4 & 112) == 32);
                        objRememberedValue = composerStartRestartGroup.rememberedValue();
                        if (!z) {
                            objRememberedValue = new AlignmentOffsetPositionProvider(topStart, jIntOffset, defaultConstructorMarker);
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                            Popup((AlignmentOffsetPositionProvider) objRememberedValue, function04, popupProperties4, function22, composerStartRestartGroup, (i4 >> 3) & 8176, 0);
                            if (ComposerKt.isTraceInProgress()) {
                            }
                            j3 = jIntOffset;
                            function03 = function04;
                            popupProperties3 = popupProperties4;
                        }
                    }
                    scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                    if (scopeUpdateScopeEndRestartGroup != null) {
                    }
                }
                popupProperties2 = popupProperties;
                if ((i2 & 16) != 0) {
                }
                function22 = function2;
                if ((i4 & 9363) == 9362) {
                }
                scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup != null) {
                }
            }
            function02 = function0;
            i6 = i2 & 8;
            if (i6 != 0) {
            }
            popupProperties2 = popupProperties;
            if ((i2 & 16) != 0) {
            }
            function22 = function2;
            if ((i4 & 9363) == 9362) {
            }
            scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup != null) {
            }
        }
        j2 = j;
        i5 = i2 & 4;
        if (i5 == 0) {
        }
        function02 = function0;
        i6 = i2 & 8;
        if (i6 != 0) {
        }
        popupProperties2 = popupProperties;
        if ((i2 & 16) != 0) {
        }
        function22 = function2;
        if ((i4 & 9363) == 9362) {
        }
        scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
        }
    }

    @Composable
    @ComposableInferredTarget(scheme = "[0[0]]")
    public static final void PopupTestTag(@NotNull final String str, @NotNull final Function2<? super Composer, ? super Integer, Unit> function2, @Nullable Composer composer, final int i) {
        int i2;
        Composer composerStartRestartGroup = composer.startRestartGroup(-498879600);
        if ((i & 6) == 0) {
            i2 = (composerStartRestartGroup.changed(str) ? 4 : 2) | i;
        } else {
            i2 = i;
        }
        if ((i & 48) == 0) {
            i2 |= composerStartRestartGroup.changedInstance(function2) ? 32 : 16;
        }
        if ((i2 & 19) == 18 && composerStartRestartGroup.getSkipping()) {
            composerStartRestartGroup.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-498879600, i2, -1, "androidx.compose.ui.window.PopupTestTag (AndroidPopup.android.kt:428)");
            }
            CompositionLocalKt.CompositionLocalProvider(LocalPopupTestTag.provides(str), function2, composerStartRestartGroup, (i2 & 112) | ProvidedValue.$stable);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.ui.window.AndroidPopup_androidKt.PopupTestTag.1
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
                    AndroidPopup_androidKt.PopupTestTag(str, function2, composer2, RecomposeScopeImplKt.updateChangedFlags(i | 1));
                }
            });
        }
    }

    @Composable
    @ComposableInferredTarget(scheme = "[androidx.compose.ui.UiComposable[androidx.compose.ui.UiComposable]]")
    private static final void SimpleStack(Modifier modifier, Function2<? super Composer, ? super Integer, Unit> function2, Composer composer, int i) {
        C22791 c22791 = C22791.INSTANCE;
        int i2 = ((i << 3) & 112) | ((i >> 3) & 14) | 384;
        int currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(composer, 0);
        CompositionLocalMap currentCompositionLocalMap = composer.getCurrentCompositionLocalMap();
        Modifier modifierMaterializeModifier = ComposedModifierKt.materializeModifier(composer, modifier);
        ComposeUiNode.Companion companion = ComposeUiNode.INSTANCE;
        Function0<ComposeUiNode> constructor = companion.getConstructor();
        int i4 = ((i2 << 6) & 896) | 6;
        if (composer.getApplier() == null) {
            ComposablesKt.invalidApplier();
        }
        composer.startReusableNode();
        if (composer.getInserting()) {
            composer.createNode(constructor);
        } else {
            composer.useNode();
        }
        Composer composerM18018constructorimpl = Updater.m18018constructorimpl(composer);
        Updater.m18025setimpl(composerM18018constructorimpl, c22791, companion.getSetMeasurePolicy());
        Updater.m18025setimpl(composerM18018constructorimpl, currentCompositionLocalMap, companion.getSetResolvedCompositionLocals());
        Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash = companion.getSetCompositeKeyHash();
        if (composerM18018constructorimpl.getInserting() || !Intrinsics.areEqual(composerM18018constructorimpl.rememberedValue(), Integer.valueOf(currentCompositeKeyHash))) {
            AbstractC0622a.m1178x(currentCompositeKeyHash, setCompositeKeyHash, composerM18018constructorimpl, currentCompositeKeyHash);
        }
        Updater.m18025setimpl(composerM18018constructorimpl, modifierMaterializeModifier, companion.getSetModifier());
        function2.invoke(composer, Integer.valueOf((i4 >> 6) & 14));
        composer.endNode();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final int createFlags(boolean z, SecureFlagPolicy secureFlagPolicy, boolean z2) {
        int i = !z ? 262152 : 262144;
        if (secureFlagPolicy == SecureFlagPolicy.SecureOn) {
            i |= 8192;
        }
        return !z2 ? i | 512 : i;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final int flagsWithSecureFlagInherited(PopupProperties popupProperties, boolean z) {
        return (popupProperties.getInheritSecurePolicy() && z) ? popupProperties.getFlags() | 8192 : (!popupProperties.getInheritSecurePolicy() || z) ? popupProperties.getFlags() : popupProperties.getFlags() & (-8193);
    }

    @NotNull
    public static final ProvidableCompositionLocal<String> getLocalPopupTestTag() {
        return LocalPopupTestTag;
    }

    public static final boolean isFlagSecureEnabled(@NotNull View view) {
        ViewGroup.LayoutParams layoutParams = view.getRootView().getLayoutParams();
        WindowManager.LayoutParams layoutParams2 = layoutParams instanceof WindowManager.LayoutParams ? (WindowManager.LayoutParams) layoutParams : null;
        return (layoutParams2 == null || (layoutParams2.flags & 8192) == 0) ? false : true;
    }

    @TestOnly
    public static final boolean isPopupLayout(@NotNull View view, @Nullable String str) {
        if (view instanceof PopupLayout) {
            return str == null || Intrinsics.areEqual(str, ((PopupLayout) view).getTestTag());
        }
        return false;
    }

    public static /* synthetic */ boolean isPopupLayout$default(View view, String str, int i, Object obj) {
        if ((i & 2) != 0) {
            str = null;
        }
        return isPopupLayout(view, str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final IntRect toIntBounds(Rect rect) {
        return new IntRect(rect.left, rect.top, rect.right, rect.bottom);
    }
}
