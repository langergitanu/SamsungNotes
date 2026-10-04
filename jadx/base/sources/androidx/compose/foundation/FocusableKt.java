package androidx.compose.foundation;

import androidx.compose.foundation.interaction.MutableInteractionSource;
import androidx.compose.p109ui.Modifier;
import androidx.compose.p109ui.focus.FocusModifierKt;
import androidx.compose.p109ui.focus.FocusProperties;
import androidx.compose.p109ui.focus.FocusPropertiesKt;
import androidx.compose.p109ui.node.ModifierNodeElement;
import androidx.compose.p109ui.platform.InspectableModifier;
import androidx.compose.p109ui.platform.InspectableValueKt;
import androidx.compose.p109ui.platform.InspectorInfo;
import androidx.compose.runtime.Stable;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.SourceDebugExtension;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes.dex */
@Metadata(m13885d1 = {"\u0000%\n\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002*\u0001\u0001\u001a\f\u0010\u0005\u001a\u00020\u0006*\u00020\u0006H\u0007\u001a\"\u0010\u0007\u001a\u00020\u0006*\u00020\u00062\b\b\u0002\u0010\b\u001a\u00020\t2\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u000bH\u0007\u001a\u001e\u0010\f\u001a\u00020\u0006*\u00020\u00062\u0006\u0010\b\u001a\u00020\t2\b\u0010\n\u001a\u0004\u0018\u00010\u000bH\u0000\"\u0010\u0010\u0000\u001a\u00020\u0001X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0002\"\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\r"}, m13886d2 = {"FocusableInNonTouchModeElement", "androidx/compose/foundation/FocusableKt$FocusableInNonTouchModeElement$1", "Landroidx/compose/foundation/FocusableKt$FocusableInNonTouchModeElement$1;", "focusGroupInspectorInfo", "Landroidx/compose/ui/platform/InspectableModifier;", "focusGroup", "Landroidx/compose/ui/Modifier;", "focusable", "enabled", "", "interactionSource", "Landroidx/compose/foundation/interaction/MutableInteractionSource;", "focusableInNonTouchMode", "foundation_release"}, m13887k = 2, m13888mv = {1, 8, 0}, m13890xi = 48)
@SourceDebugExtension({"SMAP\nFocusable.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Focusable.kt\nandroidx/compose/foundation/FocusableKt\n+ 2 InspectableValue.kt\nandroidx/compose/ui/platform/InspectableValueKt\n*L\n1#1,357:1\n135#2:358\n*S KotlinDebug\n*F\n+ 1 Focusable.kt\nandroidx/compose/foundation/FocusableKt\n*L\n111#1:358\n*E\n"})
public final class FocusableKt {

    @NotNull
    private static final FocusableKt$FocusableInNonTouchModeElement$1 FocusableInNonTouchModeElement;

    @NotNull
    private static final InspectableModifier focusGroupInspectorInfo;

    /* JADX WARN: Type inference failed for: r0v1, types: [androidx.compose.foundation.FocusableKt$FocusableInNonTouchModeElement$1] */
    static {
        focusGroupInspectorInfo = new InspectableModifier(InspectableValueKt.isDebugInspectorInfoEnabled() ? new Function1<InspectorInfo, Unit>() { // from class: androidx.compose.foundation.FocusableKt$special$$inlined$debugInspectorInfo$1
            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(InspectorInfo inspectorInfo) {
                invoke2(inspectorInfo);
                return Unit.INSTANCE;
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(@NotNull InspectorInfo inspectorInfo) {
                inspectorInfo.setName("focusGroup");
            }
        } : InspectableValueKt.getNoInspectorInfo());
        FocusableInNonTouchModeElement = new ModifierNodeElement<FocusableInNonTouchMode>() { // from class: androidx.compose.foundation.FocusableKt$FocusableInNonTouchModeElement$1
            @Override // androidx.compose.p109ui.node.ModifierNodeElement
            public boolean equals(@Nullable Object other) {
                return this == other;
            }

            @Override // androidx.compose.p109ui.node.ModifierNodeElement
            public int hashCode() {
                return Focusable_androidKt.identityHashCode(this);
            }

            @Override // androidx.compose.p109ui.node.ModifierNodeElement
            public void inspectableProperties(@NotNull InspectorInfo inspectorInfo) {
                inspectorInfo.setName("focusableInNonTouchMode");
            }

            @Override // androidx.compose.p109ui.node.ModifierNodeElement
            public void update(@NotNull FocusableInNonTouchMode node) {
            }

            @Override // androidx.compose.p109ui.node.ModifierNodeElement
            @NotNull
            /* JADX INFO: renamed from: create */
            public FocusableInNonTouchMode getNode() {
                return new FocusableInNonTouchMode();
            }
        };
    }

    @Stable
    @NotNull
    public static final Modifier focusGroup(@NotNull Modifier modifier) {
        return FocusModifierKt.focusTarget(FocusPropertiesKt.focusProperties(modifier.then(focusGroupInspectorInfo), new Function1<FocusProperties, Unit>() { // from class: androidx.compose.foundation.FocusableKt.focusGroup.1
            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(FocusProperties focusProperties) {
                invoke2(focusProperties);
                return Unit.INSTANCE;
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(@NotNull FocusProperties focusProperties) {
                focusProperties.setCanFocus(false);
            }
        }));
    }

    @Stable
    @NotNull
    public static final Modifier focusable(@NotNull Modifier modifier, boolean z, @Nullable MutableInteractionSource mutableInteractionSource) {
        return modifier.then(z ? new FocusableElement(mutableInteractionSource) : Modifier.INSTANCE);
    }

    public static /* synthetic */ Modifier focusable$default(Modifier modifier, boolean z, MutableInteractionSource mutableInteractionSource, int i, Object obj) {
        if ((i & 1) != 0) {
            z = true;
        }
        if ((i & 2) != 0) {
            mutableInteractionSource = null;
        }
        return focusable(modifier, z, mutableInteractionSource);
    }

    @NotNull
    public static final Modifier focusableInNonTouchMode(@NotNull Modifier modifier, boolean z, @Nullable MutableInteractionSource mutableInteractionSource) {
        return focusable(modifier.then(z ? FocusableInNonTouchModeElement : Modifier.INSTANCE), z, mutableInteractionSource);
    }
}
