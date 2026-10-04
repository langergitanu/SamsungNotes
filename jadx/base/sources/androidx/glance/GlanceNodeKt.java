package androidx.glance;

import androidx.annotation.RestrictTo;
import androidx.compose.runtime.Composable;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.Updater;
import com.samsung.android.support.senl.p148nt.base.common.constants.Constants;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import org.apache.poi.java.awt.Event;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes4.dex */
@GlanceComposable
@Metadata(m13885d1 = {"\u00004\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u001aO\u0010\u0000\u001a\u00020\u0001\"\b\b\u0000\u0010\u0002*\u00020\u00032\u000e\b\b\u0010\u0004\u001a\b\u0012\u0004\u0012\u0002H\u00020\u00052\"\u0010\u0006\u001a\u001e\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00020\b\u0012\u0004\u0012\u00020\u00010\u0007¢\u0006\u0002\b\t¢\u0006\u0002\b\nH\u0087\bø\u0001\u0000¢\u0006\u0002\u0010\u000b\u001ag\u0010\u0000\u001a\u00020\u0001\"\b\b\u0000\u0010\u0002*\u00020\u00032\u000e\b\b\u0010\u0004\u001a\b\u0012\u0004\u0012\u0002H\u00020\u00052\"\u0010\u0006\u001a\u001e\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00020\b\u0012\u0004\u0012\u00020\u00010\u0007¢\u0006\u0002\b\t¢\u0006\u0002\b\n2\u0016\u0010\f\u001a\u0012\u0012\u0004\u0012\u00020\u00010\u0005¢\u0006\u0002\b\r¢\u0006\u0002\b\u000eH\u0087\bø\u0001\u0000¢\u0006\u0002\u0010\u000f\u0082\u0002\u0007\n\u0005\b\u009920\u0001¨\u0006\u0010"}, m13886d2 = {"GlanceNode", "", "T", "Landroidx/glance/Emittable;", "factory", "Lkotlin/Function0;", Constants.ARG_UPDATE, "Lkotlin/Function1;", "Landroidx/compose/runtime/Updater;", "Landroidx/compose/runtime/DisallowComposableCalls;", "Lkotlin/ExtensionFunctionType;", "(Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function1;Landroidx/compose/runtime/Composer;I)V", "content", "Landroidx/compose/runtime/Composable;", "Landroidx/glance/GlanceComposable;", "(Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function2;Landroidx/compose/runtime/Composer;I)V", "glance_release"}, m13887k = 2, m13888mv = {1, 9, 0}, m13890xi = 48)
@SourceDebugExtension({"SMAP\nGlanceNode.kt\nKotlin\n*S Kotlin\n*F\n+ 1 GlanceNode.kt\nandroidx/glance/GlanceNodeKt\n+ 2 Composables.kt\nandroidx/compose/runtime/ComposablesKt\n*L\n1#1,45:1\n251#2,10:46\n325#2,11:56\n*S KotlinDebug\n*F\n+ 1 GlanceNode.kt\nandroidx/glance/GlanceNodeKt\n*L\n33#1:46,10\n43#1:56,11\n*E\n"})
public final class GlanceNodeKt {
    @Composable
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public static final <T extends Emittable> void GlanceNode(@NotNull Function0<? extends T> factory, @NotNull Function1<? super Updater<T>, Unit> update, @Nullable Composer composer, int i) {
        Intrinsics.checkNotNullParameter(factory, "factory");
        Intrinsics.checkNotNullParameter(update, "update");
        composer.startReplaceableGroup(-1115894518);
        composer.startReplaceableGroup(1886828752);
        if (!(composer.getApplier() instanceof Applier)) {
            ComposablesKt.invalidApplier();
        }
        composer.startNode();
        if (composer.getInserting()) {
            composer.createNode(new GlanceNodeKt$GlanceNode$$inlined$ComposeNode$1(factory));
        } else {
            composer.useNode();
        }
        update.invoke(Updater.m18017boximpl(Updater.m18018constructorimpl(composer)));
        composer.endNode();
        composer.endReplaceableGroup();
        composer.endReplaceableGroup();
    }

    @Composable
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public static final <T extends Emittable> void GlanceNode(@NotNull Function0<? extends T> factory, @NotNull Function1<? super Updater<T>, Unit> update, @NotNull Function2<? super Composer, ? super Integer, Unit> content, @Nullable Composer composer, int i) {
        Intrinsics.checkNotNullParameter(factory, "factory");
        Intrinsics.checkNotNullParameter(update, "update");
        Intrinsics.checkNotNullParameter(content, "content");
        composer.startReplaceableGroup(578571862);
        int i2 = i & Event.CAPS_LOCK;
        composer.startReplaceableGroup(-548224868);
        if (!(composer.getApplier() instanceof Applier)) {
            ComposablesKt.invalidApplier();
        }
        composer.startNode();
        if (composer.getInserting()) {
            composer.createNode(factory);
        } else {
            composer.useNode();
        }
        update.invoke(Updater.m18017boximpl(Updater.m18018constructorimpl(composer)));
        content.invoke(composer, Integer.valueOf((i2 >> 6) & 14));
        composer.endNode();
        composer.endReplaceableGroup();
        composer.endReplaceableGroup();
    }
}
