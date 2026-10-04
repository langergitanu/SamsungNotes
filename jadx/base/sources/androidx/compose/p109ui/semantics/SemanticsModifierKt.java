package androidx.compose.p109ui.semantics;

import androidx.compose.p109ui.Modifier;
import androidx.compose.p109ui.platform.InspectorInfo;
import androidx.compose.p109ui.platform.ValueElementSequence;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.ranges.RangesKt;
import org.apache.commons.text.lookup.StringLookupFactory;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes.dex */
@Metadata(m13885d1 = {"\u0000>\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\u001a\b\u0010\u0003\u001a\u00020\u0004H\u0000\u001a\u0014\u0010\u0005\u001a\u00020\u0006*\u00020\u00072\u0006\u0010\b\u001a\u00020\tH\u0002\u001a#\u0010\n\u001a\u00020\u000b*\u00020\u000b2\u0017\u0010\f\u001a\u0013\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020\u00060\r¢\u0006\u0002\b\u000f\u001a-\u0010\u0010\u001a\u00020\u000b*\u00020\u000b2\b\b\u0002\u0010\u0011\u001a\u00020\u00122\u0017\u0010\f\u001a\u0013\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020\u00060\r¢\u0006\u0002\b\u000f\"\u0012\u0010\u0000\u001a\u00060\u0001j\u0002`\u0002X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0013"}, m13886d2 = {"lastIdentifier", "Ljava/util/concurrent/atomic/AtomicInteger;", "Landroidx/compose/ui/platform/AtomicInt;", "generateSemanticsId", "", "addSemanticsPropertiesFrom", "", "Landroidx/compose/ui/platform/InspectorInfo;", "semanticsConfiguration", "Landroidx/compose/ui/semantics/SemanticsConfiguration;", "clearAndSetSemantics", "Landroidx/compose/ui/Modifier;", StringLookupFactory.KEY_PROPERTIES, "Lkotlin/Function1;", "Landroidx/compose/ui/semantics/SemanticsPropertyReceiver;", "Lkotlin/ExtensionFunctionType;", "semantics", "mergeDescendants", "", "ui_release"}, m13887k = 2, m13888mv = {1, 8, 0}, m13890xi = 48)
@SourceDebugExtension({"SMAP\nSemanticsModifier.kt\nKotlin\n*S Kotlin\n*F\n+ 1 SemanticsModifier.kt\nandroidx/compose/ui/semantics/SemanticsModifierKt\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,195:1\n1179#2,2:196\n1253#2,4:198\n*S KotlinDebug\n*F\n+ 1 SemanticsModifier.kt\nandroidx/compose/ui/semantics/SemanticsModifierKt\n*L\n191#1:196,2\n191#1:198,4\n*E\n"})
public final class SemanticsModifierKt {

    @NotNull
    private static AtomicInteger lastIdentifier = new AtomicInteger(0);

    /* JADX INFO: Access modifiers changed from: private */
    public static final void addSemanticsPropertiesFrom(InspectorInfo inspectorInfo, SemanticsConfiguration semanticsConfiguration) {
        ValueElementSequence properties = inspectorInfo.getProperties();
        LinkedHashMap linkedHashMap = new LinkedHashMap(RangesKt.coerceAtLeast(MapsKt.mapCapacity(CollectionsKt.m13952k(semanticsConfiguration)), 16));
        for (Map.Entry<? extends SemanticsPropertyKey<?>, ? extends Object> entry : semanticsConfiguration) {
            SemanticsPropertyKey<?> key = entry.getKey();
            Pair pairM13893to = TuplesKt.m13893to(key.getName(), entry.getValue());
            linkedHashMap.put(pairM13893to.getFirst(), pairM13893to.getSecond());
        }
        properties.set(StringLookupFactory.KEY_PROPERTIES, linkedHashMap);
    }

    @NotNull
    public static final Modifier clearAndSetSemantics(@NotNull Modifier modifier, @NotNull Function1<? super SemanticsPropertyReceiver, Unit> function1) {
        return modifier.then(new ClearAndSetSemanticsElement(function1));
    }

    public static final int generateSemanticsId() {
        return lastIdentifier.addAndGet(1);
    }

    @NotNull
    public static final Modifier semantics(@NotNull Modifier modifier, boolean z, @NotNull Function1<? super SemanticsPropertyReceiver, Unit> function1) {
        return modifier.then(new AppendedSemanticsElement(z, function1));
    }

    public static /* synthetic */ Modifier semantics$default(Modifier modifier, boolean z, Function1 function1, int i, Object obj) {
        if ((i & 1) != 0) {
            z = false;
        }
        return semantics(modifier, z, function1);
    }
}
