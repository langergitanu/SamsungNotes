package androidx.glance.appwidget.lazy;

import android.os.Bundle;
import androidx.compose.runtime.Composable;
import androidx.compose.runtime.ComposableInferredTarget;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.Updater;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.glance.Applier;
import androidx.glance.ExperimentalGlanceApi;
import androidx.glance.GlanceModifier;
import androidx.glance.layout.Alignment;
import com.samsung.android.app.sdk.deepsky.textextraction.languagepack.LangPackConfigConstants;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.functions.Function4;
import kotlin.jvm.functions.Function5;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.SourceDebugExtension;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(m13885d1 = {"\u0000r\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u001aO\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\t2\u0017\u0010\n\u001a\u0013\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\u00010\u000b¢\u0006\u0002\b\rH\u0007ø\u0001\u0000¢\u0006\u0004\b\u000e\u0010\u000f\u001aG\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\t2\u0017\u0010\n\u001a\u0013\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\u00010\u000b¢\u0006\u0002\b\rH\u0007ø\u0001\u0000¢\u0006\u0004\b\u0010\u0010\u0011\u001a0\u0010\u0012\u001a\u00020\u00012\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u00162\u0011\u0010\n\u001a\r\u0012\u0004\u0012\u00020\u00010\u0017¢\u0006\u0002\b\u0018H\u0003¢\u0006\u0002\u0010\u0019\u001a9\u0010\u001a\u001a\r\u0012\u0004\u0012\u00020\u00010\u0017¢\u0006\u0002\b\u00182\u0006\u0010\u0015\u001a\u00020\u00162\u0017\u0010\n\u001a\u0013\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\u00010\u000b¢\u0006\u0002\b\rH\u0000¢\u0006\u0002\u0010\u001b\u001a\u0083\u0001\u0010\u001c\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u001d*\u00020\f2\f\u0010\u001c\u001a\b\u0012\u0004\u0012\u0002H\u001d0\u001e2#\b\n\u0010\u0013\u001a\u001d\u0012\u0013\u0012\u0011H\u001d¢\u0006\f\b\u001f\u0012\b\b \u0012\u0004\b\b(!\u0012\u0004\u0012\u00020\u00140\u000b23\b\u0004\u0010\"\u001a-\u0012\u0004\u0012\u00020$\u0012\u0013\u0012\u0011H\u001d¢\u0006\f\b\u001f\u0012\b\b \u0012\u0004\b\b(!\u0012\u0004\u0012\u00020\u00010#¢\u0006\u0002\b\u0018¢\u0006\u0002\b\rH\u0086\bø\u0001\u0001¢\u0006\u0002\u0010%\u001a\u0083\u0001\u0010\u001c\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u001d*\u00020\f2\f\u0010\u001c\u001a\b\u0012\u0004\u0012\u0002H\u001d0&2#\b\u0006\u0010\u0013\u001a\u001d\u0012\u0013\u0012\u0011H\u001d¢\u0006\f\b\u001f\u0012\b\b \u0012\u0004\b\b(!\u0012\u0004\u0012\u00020\u00140\u000b23\b\u0004\u0010\"\u001a-\u0012\u0004\u0012\u00020$\u0012\u0013\u0012\u0011H\u001d¢\u0006\f\b\u001f\u0012\b\b \u0012\u0004\b\b(!\u0012\u0004\u0012\u00020\u00010#¢\u0006\u0002\b\u0018¢\u0006\u0002\b\rH\u0086\bø\u0001\u0001¢\u0006\u0002\u0010'\u001a\u00ad\u0001\u0010(\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u001d*\u00020\f2\f\u0010\u001c\u001a\b\u0012\u0004\u0012\u0002H\u001d0\u001e28\b\n\u0010\u0013\u001a2\u0012\u0013\u0012\u00110)¢\u0006\f\b\u001f\u0012\b\b \u0012\u0004\b\b(*\u0012\u0013\u0012\u0011H\u001d¢\u0006\f\b\u001f\u0012\b\b \u0012\u0004\b\b(!\u0012\u0004\u0012\u00020\u00140#2H\b\u0004\u0010\"\u001aB\u0012\u0004\u0012\u00020$\u0012\u0013\u0012\u00110)¢\u0006\f\b\u001f\u0012\b\b \u0012\u0004\b\b(*\u0012\u0013\u0012\u0011H\u001d¢\u0006\f\b\u001f\u0012\b\b \u0012\u0004\b\b(!\u0012\u0004\u0012\u00020\u00010+¢\u0006\u0002\b\u0018¢\u0006\u0002\b\rH\u0086\bø\u0001\u0001¢\u0006\u0002\u0010,\u001a\u00ad\u0001\u0010(\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u001d*\u00020\f2\f\u0010\u001c\u001a\b\u0012\u0004\u0012\u0002H\u001d0&28\b\u0006\u0010\u0013\u001a2\u0012\u0013\u0012\u00110)¢\u0006\f\b\u001f\u0012\b\b \u0012\u0004\b\b(*\u0012\u0013\u0012\u0011H\u001d¢\u0006\f\b\u001f\u0012\b\b \u0012\u0004\b\b(!\u0012\u0004\u0012\u00020\u00140#2H\b\u0004\u0010\"\u001aB\u0012\u0004\u0012\u00020$\u0012\u0013\u0012\u00110)¢\u0006\f\b\u001f\u0012\b\b \u0012\u0004\b\b(*\u0012\u0013\u0012\u0011H\u001d¢\u0006\f\b\u001f\u0012\b\b \u0012\u0004\b\b(!\u0012\u0004\u0012\u00020\u00010+¢\u0006\u0002\b\u0018¢\u0006\u0002\b\rH\u0086\bø\u0001\u0001¢\u0006\u0002\u0010-\u0082\u0002\u000e\n\u0005\b¡\u001e0\u0001\n\u0005\b\u009920\u0001¨\u0006."}, m13886d2 = {"LazyVerticalGrid", "", "gridCells", "Landroidx/glance/appwidget/lazy/GridCells;", "activityOptions", "Landroid/os/Bundle;", "modifier", "Landroidx/glance/GlanceModifier;", "horizontalAlignment", "Landroidx/glance/layout/Alignment$Horizontal;", "content", "Lkotlin/Function1;", "Landroidx/glance/appwidget/lazy/LazyVerticalGridScope;", "Lkotlin/ExtensionFunctionType;", "LazyVerticalGrid-tdtSkkI", "(Landroidx/glance/appwidget/lazy/GridCells;Landroid/os/Bundle;Landroidx/glance/GlanceModifier;ILkotlin/jvm/functions/Function1;Landroidx/compose/runtime/Composer;II)V", "LazyVerticalGrid-ca5uSD8", "(Landroidx/glance/appwidget/lazy/GridCells;Landroidx/glance/GlanceModifier;ILkotlin/jvm/functions/Function1;Landroidx/compose/runtime/Composer;II)V", "LazyVerticalGridItem", "itemId", "", "alignment", "Landroidx/glance/layout/Alignment;", "Lkotlin/Function0;", "Landroidx/compose/runtime/Composable;", "(JLandroidx/glance/layout/Alignment;Lkotlin/jvm/functions/Function2;Landroidx/compose/runtime/Composer;I)V", "applyVerticalGridScope", "(Landroidx/glance/layout/Alignment;Lkotlin/jvm/functions/Function1;)Lkotlin/jvm/functions/Function2;", "items", "T", "", "Lkotlin/ParameterName;", "name", "item", "itemContent", "Lkotlin/Function2;", "Landroidx/glance/appwidget/lazy/LazyItemScope;", "(Landroidx/glance/appwidget/lazy/LazyVerticalGridScope;[Ljava/lang/Object;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function4;)V", "", "(Landroidx/glance/appwidget/lazy/LazyVerticalGridScope;Ljava/util/List;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function4;)V", "itemsIndexed", "", "index", "Lkotlin/Function3;", "(Landroidx/glance/appwidget/lazy/LazyVerticalGridScope;[Ljava/lang/Object;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function5;)V", "(Landroidx/glance/appwidget/lazy/LazyVerticalGridScope;Ljava/util/List;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function5;)V", "glance-appwidget_release"}, m13887k = 2, m13888mv = {1, 9, 0}, m13890xi = 48)
@SourceDebugExtension({"SMAP\nLazyVerticalGrid.kt\nKotlin\n*S Kotlin\n*F\n+ 1 LazyVerticalGrid.kt\nandroidx/glance/appwidget/lazy/LazyVerticalGridKt\n+ 2 GlanceNode.kt\nandroidx/glance/GlanceNodeKt\n+ 3 Composables.kt\nandroidx/compose/runtime/ComposablesKt\n*L\n1#1,379:1\n43#2:380\n44#2:392\n43#2:393\n44#2:405\n43#2:406\n44#2:418\n325#3,11:381\n325#3,11:394\n325#3,11:407\n*S KotlinDebug\n*F\n+ 1 LazyVerticalGrid.kt\nandroidx/glance/appwidget/lazy/LazyVerticalGridKt\n*L\n51#1:380\n51#1:392\n87#1:393\n87#1:405\n153#1:406\n153#1:418\n51#1:381,11\n87#1:394,11\n153#1:407,11\n*E\n"})
public final class LazyVerticalGridKt {

    /* JADX INFO: renamed from: androidx.glance.appwidget.lazy.LazyVerticalGridKt$LazyVerticalGridItem$1 */
    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13887k = 3, m13888mv = {1, 9, 0}, m13890xi = 48)
    public /* synthetic */ class C29571 extends FunctionReferenceImpl implements Function0<EmittableLazyVerticalGridListItem> {
        public static final C29571 INSTANCE = new C29571();

        public C29571() {
            super(0, EmittableLazyVerticalGridListItem.class, "<init>", "<init>()V", 0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlin.jvm.functions.Function0
        @NotNull
        public final EmittableLazyVerticalGridListItem invoke() {
            return new EmittableLazyVerticalGridListItem();
        }
    }

    /* JADX INFO: renamed from: androidx.glance.appwidget.lazy.LazyVerticalGridKt$items$2 */
    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000\u0012\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u00022\u0006\u0010\u0003\u001a\u00020\u0004H\n¢\u0006\u0004\b\u0005\u0010\u0006"}, m13886d2 = {"<anonymous>", "", "T", "index", "", "invoke", "(I)Ljava/lang/Long;"}, m13887k = 3, m13888mv = {1, 9, 0}, m13890xi = 176)
    @SourceDebugExtension({"SMAP\nLazyVerticalGrid.kt\nKotlin\n*S Kotlin\n*F\n+ 1 LazyVerticalGrid.kt\nandroidx/glance/appwidget/lazy/LazyVerticalGridKt$items$2\n*L\n1#1,379:1\n*E\n"})
    public static final class C29632 extends Lambda implements Function1<Integer, Long> {
        final /* synthetic */ Function1<T, Long> $itemId;
        final /* synthetic */ List<T> $items;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        public C29632(Function1<? super T, Long> function1, List<? extends T> list) {
            super(1);
            this.$itemId = function1;
            this.$items = list;
        }

        /* JADX WARN: Type inference incomplete: some casts might be missing */
        @NotNull
        public final Long invoke(int i) {
            return this.$itemId.invoke((T) this.$items.get(i));
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Long invoke(Integer num) {
            return invoke(num.intValue());
        }
    }

    /* JADX INFO: renamed from: androidx.glance.appwidget.lazy.LazyVerticalGridKt$items$3 */
    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000\u0016\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u000b¢\u0006\u0004\b\u0006\u0010\u0007"}, m13886d2 = {"<anonymous>", "", "T", "Landroidx/glance/appwidget/lazy/LazyItemScope;", LangPackConfigConstants.LANGUAGE_CODE_IT, "", "invoke", "(Landroidx/glance/appwidget/lazy/LazyItemScope;ILandroidx/compose/runtime/Composer;I)V"}, m13887k = 3, m13888mv = {1, 9, 0}, m13890xi = 176)
    @SourceDebugExtension({"SMAP\nLazyVerticalGrid.kt\nKotlin\n*S Kotlin\n*F\n+ 1 LazyVerticalGrid.kt\nandroidx/glance/appwidget/lazy/LazyVerticalGridKt$items$3\n*L\n1#1,379:1\n*E\n"})
    public static final class C29643 extends Lambda implements Function4<LazyItemScope, Integer, Composer, Integer, Unit> {
        final /* synthetic */ Function4<LazyItemScope, T, Composer, Integer, Unit> $itemContent;
        final /* synthetic */ List<T> $items;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        public C29643(Function4<? super LazyItemScope, ? super T, ? super Composer, ? super Integer, Unit> function4, List<? extends T> list) {
            super(4);
            this.$itemContent = function4;
            this.$items = list;
        }

        @Override // kotlin.jvm.functions.Function4
        public /* bridge */ /* synthetic */ Unit invoke(LazyItemScope lazyItemScope, Integer num, Composer composer, Integer num2) {
            invoke(lazyItemScope, num.intValue(), composer, num2.intValue());
            return Unit.INSTANCE;
        }

        /* JADX WARN: Type inference incomplete: some casts might be missing */
        @Composable
        public final void invoke(@NotNull LazyItemScope items, int i, @Nullable Composer composer, int i2) {
            int i4;
            Intrinsics.checkNotNullParameter(items, "$this$items");
            if ((i2 & 14) == 0) {
                i4 = (composer.changed(items) ? 4 : 2) | i2;
            } else {
                i4 = i2;
            }
            if ((i2 & 112) == 0) {
                i4 |= composer.changed(i) ? 32 : 16;
            }
            if ((i4 & 731) == 146 && composer.getSkipping()) {
                composer.skipToGroupEnd();
                return;
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-693260830, i4, -1, "androidx.glance.appwidget.lazy.items.<anonymous> (LazyVerticalGrid.kt:216)");
            }
            this.$itemContent.invoke(items, (T) this.$items.get(i), composer, Integer.valueOf(i4 & 14));
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
    }

    /* JADX INFO: renamed from: androidx.glance.appwidget.lazy.LazyVerticalGridKt$items$5 */
    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000\u0012\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u00022\u0006\u0010\u0003\u001a\u00020\u0004H\n¢\u0006\u0004\b\u0005\u0010\u0006"}, m13886d2 = {"<anonymous>", "", "T", "index", "", "invoke", "(I)Ljava/lang/Long;"}, m13887k = 3, m13888mv = {1, 9, 0}, m13890xi = 176)
    @SourceDebugExtension({"SMAP\nLazyVerticalGrid.kt\nKotlin\n*S Kotlin\n*F\n+ 1 LazyVerticalGrid.kt\nandroidx/glance/appwidget/lazy/LazyVerticalGridKt$items$5\n*L\n1#1,379:1\n*E\n"})
    public static final class C29665 extends Lambda implements Function1<Integer, Long> {
        final /* synthetic */ Function1<T, Long> $itemId;
        final /* synthetic */ T[] $items;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        public C29665(Function1<? super T, Long> function1, T[] tArr) {
            super(1);
            this.$itemId = function1;
            this.$items = tArr;
        }

        /* JADX WARN: Type inference fix 'apply assigned field type' failed
        java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$UnknownArg
        	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:593)
        	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
        	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
         */
        @NotNull
        public final Long invoke(int i) {
            return this.$itemId.invoke(this.$items[i]);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Long invoke(Integer num) {
            return invoke(num.intValue());
        }
    }

    /* JADX INFO: renamed from: androidx.glance.appwidget.lazy.LazyVerticalGridKt$items$6 */
    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000\u0016\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u000b¢\u0006\u0004\b\u0006\u0010\u0007"}, m13886d2 = {"<anonymous>", "", "T", "Landroidx/glance/appwidget/lazy/LazyItemScope;", LangPackConfigConstants.LANGUAGE_CODE_IT, "", "invoke", "(Landroidx/glance/appwidget/lazy/LazyItemScope;ILandroidx/compose/runtime/Composer;I)V"}, m13887k = 3, m13888mv = {1, 9, 0}, m13890xi = 176)
    @SourceDebugExtension({"SMAP\nLazyVerticalGrid.kt\nKotlin\n*S Kotlin\n*F\n+ 1 LazyVerticalGrid.kt\nandroidx/glance/appwidget/lazy/LazyVerticalGridKt$items$6\n*L\n1#1,379:1\n*E\n"})
    public static final class C29676 extends Lambda implements Function4<LazyItemScope, Integer, Composer, Integer, Unit> {
        final /* synthetic */ Function4<LazyItemScope, T, Composer, Integer, Unit> $itemContent;
        final /* synthetic */ T[] $items;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        public C29676(Function4<? super LazyItemScope, ? super T, ? super Composer, ? super Integer, Unit> function4, T[] tArr) {
            super(4);
            this.$itemContent = function4;
            this.$items = tArr;
        }

        @Override // kotlin.jvm.functions.Function4
        public /* bridge */ /* synthetic */ Unit invoke(LazyItemScope lazyItemScope, Integer num, Composer composer, Integer num2) {
            invoke(lazyItemScope, num.intValue(), composer, num2.intValue());
            return Unit.INSTANCE;
        }

        /* JADX WARN: Type inference fix 'apply assigned field type' failed
        java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$UnknownArg
        	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:593)
        	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
        	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
         */
        @Composable
        public final void invoke(@NotNull LazyItemScope items, int i, @Nullable Composer composer, int i2) {
            int i4;
            Intrinsics.checkNotNullParameter(items, "$this$items");
            if ((i2 & 14) == 0) {
                i4 = (composer.changed(items) ? 4 : 2) | i2;
            } else {
                i4 = i2;
            }
            if ((i2 & 112) == 0) {
                i4 |= composer.changed(i) ? 32 : 16;
            }
            if ((i4 & 731) == 146 && composer.getSkipping()) {
                composer.skipToGroupEnd();
                return;
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(315415057, i4, -1, "androidx.glance.appwidget.lazy.items.<anonymous> (LazyVerticalGrid.kt:253)");
            }
            this.$itemContent.invoke(items, this.$items[i], composer, Integer.valueOf(i4 & 14));
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
    }

    /* JADX INFO: renamed from: androidx.glance.appwidget.lazy.LazyVerticalGridKt$itemsIndexed$2 */
    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000\u0012\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u00022\u0006\u0010\u0003\u001a\u00020\u0004H\n¢\u0006\u0004\b\u0005\u0010\u0006"}, m13886d2 = {"<anonymous>", "", "T", "index", "", "invoke", "(I)Ljava/lang/Long;"}, m13887k = 3, m13888mv = {1, 9, 0}, m13890xi = 176)
    @SourceDebugExtension({"SMAP\nLazyVerticalGrid.kt\nKotlin\n*S Kotlin\n*F\n+ 1 LazyVerticalGrid.kt\nandroidx/glance/appwidget/lazy/LazyVerticalGridKt$itemsIndexed$2\n*L\n1#1,379:1\n*E\n"})
    public static final class C29692 extends Lambda implements Function1<Integer, Long> {
        final /* synthetic */ Function2<Integer, T, Long> $itemId;
        final /* synthetic */ List<T> $items;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        public C29692(Function2<? super Integer, ? super T, Long> function2, List<? extends T> list) {
            super(1);
            this.$itemId = function2;
            this.$items = list;
        }

        /* JADX WARN: Type inference incomplete: some casts might be missing */
        @NotNull
        public final Long invoke(int i) {
            return this.$itemId.invoke(Integer.valueOf(i), (T) this.$items.get(i));
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Long invoke(Integer num) {
            return invoke(num.intValue());
        }
    }

    /* JADX INFO: renamed from: androidx.glance.appwidget.lazy.LazyVerticalGridKt$itemsIndexed$3 */
    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000\u0016\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u000b¢\u0006\u0004\b\u0006\u0010\u0007"}, m13886d2 = {"<anonymous>", "", "T", "Landroidx/glance/appwidget/lazy/LazyItemScope;", LangPackConfigConstants.LANGUAGE_CODE_IT, "", "invoke", "(Landroidx/glance/appwidget/lazy/LazyItemScope;ILandroidx/compose/runtime/Composer;I)V"}, m13887k = 3, m13888mv = {1, 9, 0}, m13890xi = 176)
    @SourceDebugExtension({"SMAP\nLazyVerticalGrid.kt\nKotlin\n*S Kotlin\n*F\n+ 1 LazyVerticalGrid.kt\nandroidx/glance/appwidget/lazy/LazyVerticalGridKt$itemsIndexed$3\n*L\n1#1,379:1\n*E\n"})
    public static final class C29703 extends Lambda implements Function4<LazyItemScope, Integer, Composer, Integer, Unit> {
        final /* synthetic */ Function5<LazyItemScope, Integer, T, Composer, Integer, Unit> $itemContent;
        final /* synthetic */ List<T> $items;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        public C29703(Function5<? super LazyItemScope, ? super Integer, ? super T, ? super Composer, ? super Integer, Unit> function5, List<? extends T> list) {
            super(4);
            this.$itemContent = function5;
            this.$items = list;
        }

        @Override // kotlin.jvm.functions.Function4
        public /* bridge */ /* synthetic */ Unit invoke(LazyItemScope lazyItemScope, Integer num, Composer composer, Integer num2) {
            invoke(lazyItemScope, num.intValue(), composer, num2.intValue());
            return Unit.INSTANCE;
        }

        /* JADX WARN: Type inference incomplete: some casts might be missing */
        @Composable
        public final void invoke(@NotNull LazyItemScope items, int i, @Nullable Composer composer, int i2) {
            int i4;
            Intrinsics.checkNotNullParameter(items, "$this$items");
            if ((i2 & 14) == 0) {
                i4 = (composer.changed(items) ? 4 : 2) | i2;
            } else {
                i4 = i2;
            }
            if ((i2 & 112) == 0) {
                i4 |= composer.changed(i) ? 32 : 16;
            }
            if ((i4 & 731) == 146 && composer.getSkipping()) {
                composer.skipToGroupEnd();
                return;
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-2105063253, i4, -1, "androidx.glance.appwidget.lazy.itemsIndexed.<anonymous> (LazyVerticalGrid.kt:235)");
            }
            this.$itemContent.invoke(items, Integer.valueOf(i), (T) this.$items.get(i), composer, Integer.valueOf(i4 & 126));
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
    }

    /* JADX INFO: renamed from: androidx.glance.appwidget.lazy.LazyVerticalGridKt$itemsIndexed$5 */
    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000\u0012\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u00022\u0006\u0010\u0003\u001a\u00020\u0004H\n¢\u0006\u0004\b\u0005\u0010\u0006"}, m13886d2 = {"<anonymous>", "", "T", "index", "", "invoke", "(I)Ljava/lang/Long;"}, m13887k = 3, m13888mv = {1, 9, 0}, m13890xi = 176)
    @SourceDebugExtension({"SMAP\nLazyVerticalGrid.kt\nKotlin\n*S Kotlin\n*F\n+ 1 LazyVerticalGrid.kt\nandroidx/glance/appwidget/lazy/LazyVerticalGridKt$itemsIndexed$5\n*L\n1#1,379:1\n*E\n"})
    public static final class C29725 extends Lambda implements Function1<Integer, Long> {
        final /* synthetic */ Function2<Integer, T, Long> $itemId;
        final /* synthetic */ T[] $items;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        public C29725(Function2<? super Integer, ? super T, Long> function2, T[] tArr) {
            super(1);
            this.$itemId = function2;
            this.$items = tArr;
        }

        /* JADX WARN: Type inference fix 'apply assigned field type' failed
        java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$UnknownArg
        	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:593)
        	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
        	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
         */
        @NotNull
        public final Long invoke(int i) {
            return this.$itemId.invoke(Integer.valueOf(i), this.$items[i]);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Long invoke(Integer num) {
            return invoke(num.intValue());
        }
    }

    /* JADX INFO: renamed from: androidx.glance.appwidget.lazy.LazyVerticalGridKt$itemsIndexed$6 */
    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000\u0016\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u000b¢\u0006\u0004\b\u0006\u0010\u0007"}, m13886d2 = {"<anonymous>", "", "T", "Landroidx/glance/appwidget/lazy/LazyItemScope;", LangPackConfigConstants.LANGUAGE_CODE_IT, "", "invoke", "(Landroidx/glance/appwidget/lazy/LazyItemScope;ILandroidx/compose/runtime/Composer;I)V"}, m13887k = 3, m13888mv = {1, 9, 0}, m13890xi = 176)
    @SourceDebugExtension({"SMAP\nLazyVerticalGrid.kt\nKotlin\n*S Kotlin\n*F\n+ 1 LazyVerticalGrid.kt\nandroidx/glance/appwidget/lazy/LazyVerticalGridKt$itemsIndexed$6\n*L\n1#1,379:1\n*E\n"})
    public static final class C29736 extends Lambda implements Function4<LazyItemScope, Integer, Composer, Integer, Unit> {
        final /* synthetic */ Function5<LazyItemScope, Integer, T, Composer, Integer, Unit> $itemContent;
        final /* synthetic */ T[] $items;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        public C29736(Function5<? super LazyItemScope, ? super Integer, ? super T, ? super Composer, ? super Integer, Unit> function5, T[] tArr) {
            super(4);
            this.$itemContent = function5;
            this.$items = tArr;
        }

        @Override // kotlin.jvm.functions.Function4
        public /* bridge */ /* synthetic */ Unit invoke(LazyItemScope lazyItemScope, Integer num, Composer composer, Integer num2) {
            invoke(lazyItemScope, num.intValue(), composer, num2.intValue());
            return Unit.INSTANCE;
        }

        /* JADX WARN: Type inference fix 'apply assigned field type' failed
        java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$UnknownArg
        	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:593)
        	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
        	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
         */
        @Composable
        public final void invoke(@NotNull LazyItemScope items, int i, @Nullable Composer composer, int i2) {
            int i4;
            Intrinsics.checkNotNullParameter(items, "$this$items");
            if ((i2 & 14) == 0) {
                i4 = (composer.changed(items) ? 4 : 2) | i2;
            } else {
                i4 = i2;
            }
            if ((i2 & 112) == 0) {
                i4 |= composer.changed(i) ? 32 : 16;
            }
            if ((i4 & 731) == 146 && composer.getSkipping()) {
                composer.skipToGroupEnd();
                return;
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1310895196, i4, -1, "androidx.glance.appwidget.lazy.itemsIndexed.<anonymous> (LazyVerticalGrid.kt:273)");
            }
            this.$itemContent.invoke(items, Integer.valueOf(i), this.$items[i], composer, Integer.valueOf(i4 & 126));
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:64:0x00ae  */
    /* JADX WARN: Removed duplicated region for block: B:67:0x00da  */
    /* JADX WARN: Removed duplicated region for block: B:70:0x00e6  */
    /* JADX WARN: Removed duplicated region for block: B:71:0x00ea  */
    /* JADX WARN: Removed duplicated region for block: B:74:0x011b  */
    @Composable
    /* JADX INFO: renamed from: LazyVerticalGrid-ca5uSD8, reason: not valid java name */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final void m21348LazyVerticalGridca5uSD8(@NotNull final GridCells gridCells, @Nullable GlanceModifier glanceModifier, int i, @NotNull final Function1<? super LazyVerticalGridScope, Unit> content, @Nullable Composer composer, final int i2, final int i4) {
        int i5;
        Intrinsics.checkNotNullParameter(gridCells, "gridCells");
        Intrinsics.checkNotNullParameter(content, "content");
        Composer composerStartRestartGroup = composer.startRestartGroup(-2047392247);
        if ((i4 & 1) != 0) {
            i5 = i2 | 6;
        } else if ((i2 & 14) == 0) {
            i5 = (composerStartRestartGroup.changed(gridCells) ? 4 : 2) | i2;
        } else {
            i5 = i2;
        }
        int i6 = i4 & 2;
        if (i6 != 0) {
            i5 |= 48;
        } else if ((i2 & 112) == 0) {
            i5 |= composerStartRestartGroup.changed(glanceModifier) ? 32 : 16;
        }
        if ((i2 & 896) == 0) {
            i5 |= ((i4 & 4) == 0 && composerStartRestartGroup.changed(i)) ? 256 : 128;
        }
        if ((i4 & 8) != 0) {
            i5 |= 3072;
        } else if ((i2 & 7168) == 0) {
            i5 |= composerStartRestartGroup.changedInstance(content) ? 2048 : 1024;
        }
        if ((i5 & 5851) == 1170 && composerStartRestartGroup.getSkipping()) {
            composerStartRestartGroup.skipToGroupEnd();
        } else {
            composerStartRestartGroup.startDefaults();
            if ((i2 & 1) == 0 || composerStartRestartGroup.getDefaultsInvalid()) {
                if (i6 != 0) {
                    glanceModifier = GlanceModifier.INSTANCE;
                }
                if ((i4 & 4) != 0) {
                    i = Alignment.INSTANCE.m21433getStartPGIyAqw();
                    i5 &= -897;
                }
                composerStartRestartGroup.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(-2047392247, i5, -1, "androidx.glance.appwidget.lazy.LazyVerticalGrid (LazyVerticalGrid.kt:49)");
                }
                LazyVerticalGridKt$LazyVerticalGrid$1 lazyVerticalGridKt$LazyVerticalGrid$1 = LazyVerticalGridKt$LazyVerticalGrid$1.INSTANCE;
                Function2<Composer, Integer, Unit> function2ApplyVerticalGridScope = applyVerticalGridScope(new Alignment(i, Alignment.Vertical.INSTANCE.m21453getCenterVerticallymnfRV0w(), null), content);
                composerStartRestartGroup.startReplaceableGroup(578571862);
                composerStartRestartGroup.startReplaceableGroup(-548224868);
                if (!(composerStartRestartGroup.getApplier() instanceof Applier)) {
                    ComposablesKt.invalidApplier();
                }
                composerStartRestartGroup.startNode();
                if (composerStartRestartGroup.getInserting()) {
                    composerStartRestartGroup.useNode();
                } else {
                    composerStartRestartGroup.createNode(lazyVerticalGridKt$LazyVerticalGrid$1);
                }
                Composer composerM18018constructorimpl = Updater.m18018constructorimpl(composerStartRestartGroup);
                Updater.m18025setimpl(composerM18018constructorimpl, gridCells, new Function2<EmittableLazyVerticalGrid, GridCells, Unit>() { // from class: androidx.glance.appwidget.lazy.LazyVerticalGridKt$LazyVerticalGrid$2$1
                    @Override // kotlin.jvm.functions.Function2
                    public /* bridge */ /* synthetic */ Unit invoke(EmittableLazyVerticalGrid emittableLazyVerticalGrid, GridCells gridCells2) {
                        invoke2(emittableLazyVerticalGrid, gridCells2);
                        return Unit.INSTANCE;
                    }

                    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                    public final void invoke2(@NotNull EmittableLazyVerticalGrid set, @NotNull GridCells it) {
                        Intrinsics.checkNotNullParameter(set, "$this$set");
                        Intrinsics.checkNotNullParameter(it, "it");
                        set.setGridCells(it);
                    }
                });
                Updater.m18025setimpl(composerM18018constructorimpl, glanceModifier, new Function2<EmittableLazyVerticalGrid, GlanceModifier, Unit>() { // from class: androidx.glance.appwidget.lazy.LazyVerticalGridKt$LazyVerticalGrid$2$2
                    @Override // kotlin.jvm.functions.Function2
                    public /* bridge */ /* synthetic */ Unit invoke(EmittableLazyVerticalGrid emittableLazyVerticalGrid, GlanceModifier glanceModifier2) {
                        invoke2(emittableLazyVerticalGrid, glanceModifier2);
                        return Unit.INSTANCE;
                    }

                    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                    public final void invoke2(@NotNull EmittableLazyVerticalGrid set, @NotNull GlanceModifier it) {
                        Intrinsics.checkNotNullParameter(set, "$this$set");
                        Intrinsics.checkNotNullParameter(it, "it");
                        set.setModifier(it);
                    }
                });
                Updater.m18025setimpl(composerM18018constructorimpl, Alignment.Horizontal.m21435boximpl(i), new Function2<EmittableLazyVerticalGrid, Alignment.Horizontal, Unit>() { // from class: androidx.glance.appwidget.lazy.LazyVerticalGridKt$LazyVerticalGrid$2$3
                    @Override // kotlin.jvm.functions.Function2
                    public /* bridge */ /* synthetic */ Unit invoke(EmittableLazyVerticalGrid emittableLazyVerticalGrid, Alignment.Horizontal horizontal) {
                        m21350invokeh_Kf0XE(emittableLazyVerticalGrid, horizontal.getValue());
                        return Unit.INSTANCE;
                    }

                    /* JADX INFO: renamed from: invoke-h_Kf0XE, reason: not valid java name */
                    public final void m21350invokeh_Kf0XE(@NotNull EmittableLazyVerticalGrid set, int i7) {
                        Intrinsics.checkNotNullParameter(set, "$this$set");
                        set.m21342setHorizontalAlignmentuMT220(i7);
                    }
                });
                function2ApplyVerticalGridScope.invoke(composerStartRestartGroup, 0);
                composerStartRestartGroup.endNode();
                composerStartRestartGroup.endReplaceableGroup();
                composerStartRestartGroup.endReplaceableGroup();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
            } else {
                composerStartRestartGroup.skipToGroupEnd();
                if ((i4 & 4) != 0) {
                    i5 &= -897;
                }
                composerStartRestartGroup.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                }
                LazyVerticalGridKt$LazyVerticalGrid$1 lazyVerticalGridKt$LazyVerticalGrid$12 = LazyVerticalGridKt$LazyVerticalGrid$1.INSTANCE;
                Function2<Composer, Integer, Unit> function2ApplyVerticalGridScope2 = applyVerticalGridScope(new Alignment(i, Alignment.Vertical.INSTANCE.m21453getCenterVerticallymnfRV0w(), null), content);
                composerStartRestartGroup.startReplaceableGroup(578571862);
                composerStartRestartGroup.startReplaceableGroup(-548224868);
                if (!(composerStartRestartGroup.getApplier() instanceof Applier)) {
                }
                composerStartRestartGroup.startNode();
                if (composerStartRestartGroup.getInserting()) {
                }
                Composer composerM18018constructorimpl2 = Updater.m18018constructorimpl(composerStartRestartGroup);
                Updater.m18025setimpl(composerM18018constructorimpl2, gridCells, new Function2<EmittableLazyVerticalGrid, GridCells, Unit>() { // from class: androidx.glance.appwidget.lazy.LazyVerticalGridKt$LazyVerticalGrid$2$1
                    @Override // kotlin.jvm.functions.Function2
                    public /* bridge */ /* synthetic */ Unit invoke(EmittableLazyVerticalGrid emittableLazyVerticalGrid, GridCells gridCells2) {
                        invoke2(emittableLazyVerticalGrid, gridCells2);
                        return Unit.INSTANCE;
                    }

                    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                    public final void invoke2(@NotNull EmittableLazyVerticalGrid set, @NotNull GridCells it) {
                        Intrinsics.checkNotNullParameter(set, "$this$set");
                        Intrinsics.checkNotNullParameter(it, "it");
                        set.setGridCells(it);
                    }
                });
                Updater.m18025setimpl(composerM18018constructorimpl2, glanceModifier, new Function2<EmittableLazyVerticalGrid, GlanceModifier, Unit>() { // from class: androidx.glance.appwidget.lazy.LazyVerticalGridKt$LazyVerticalGrid$2$2
                    @Override // kotlin.jvm.functions.Function2
                    public /* bridge */ /* synthetic */ Unit invoke(EmittableLazyVerticalGrid emittableLazyVerticalGrid, GlanceModifier glanceModifier2) {
                        invoke2(emittableLazyVerticalGrid, glanceModifier2);
                        return Unit.INSTANCE;
                    }

                    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                    public final void invoke2(@NotNull EmittableLazyVerticalGrid set, @NotNull GlanceModifier it) {
                        Intrinsics.checkNotNullParameter(set, "$this$set");
                        Intrinsics.checkNotNullParameter(it, "it");
                        set.setModifier(it);
                    }
                });
                Updater.m18025setimpl(composerM18018constructorimpl2, Alignment.Horizontal.m21435boximpl(i), new Function2<EmittableLazyVerticalGrid, Alignment.Horizontal, Unit>() { // from class: androidx.glance.appwidget.lazy.LazyVerticalGridKt$LazyVerticalGrid$2$3
                    @Override // kotlin.jvm.functions.Function2
                    public /* bridge */ /* synthetic */ Unit invoke(EmittableLazyVerticalGrid emittableLazyVerticalGrid, Alignment.Horizontal horizontal) {
                        m21350invokeh_Kf0XE(emittableLazyVerticalGrid, horizontal.getValue());
                        return Unit.INSTANCE;
                    }

                    /* JADX INFO: renamed from: invoke-h_Kf0XE, reason: not valid java name */
                    public final void m21350invokeh_Kf0XE(@NotNull EmittableLazyVerticalGrid set, int i7) {
                        Intrinsics.checkNotNullParameter(set, "$this$set");
                        set.m21342setHorizontalAlignmentuMT220(i7);
                    }
                });
                function2ApplyVerticalGridScope2.invoke(composerStartRestartGroup, 0);
                composerStartRestartGroup.endNode();
                composerStartRestartGroup.endReplaceableGroup();
                composerStartRestartGroup.endReplaceableGroup();
                if (ComposerKt.isTraceInProgress()) {
                }
            }
        }
        final GlanceModifier glanceModifier2 = glanceModifier;
        final int i7 = i;
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.glance.appwidget.lazy.LazyVerticalGridKt$LazyVerticalGrid$3
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

                public final void invoke(@Nullable Composer composer2, int i8) {
                    LazyVerticalGridKt.m21348LazyVerticalGridca5uSD8(gridCells, glanceModifier2, i7, content, composer2, RecomposeScopeImplKt.updateChangedFlags(i2 | 1), i4);
                }
            });
        }
    }

    @Composable
    @ExperimentalGlanceApi
    /* JADX INFO: renamed from: LazyVerticalGrid-tdtSkkI, reason: not valid java name */
    public static final void m21349LazyVerticalGridtdtSkkI(@NotNull final GridCells gridCells, @NotNull final Bundle activityOptions, @Nullable GlanceModifier glanceModifier, int i, @NotNull final Function1<? super LazyVerticalGridScope, Unit> content, @Nullable Composer composer, int i2, final int i4) {
        final int i5;
        int i6;
        Intrinsics.checkNotNullParameter(gridCells, "gridCells");
        Intrinsics.checkNotNullParameter(activityOptions, "activityOptions");
        Intrinsics.checkNotNullParameter(content, "content");
        Composer composerStartRestartGroup = composer.startRestartGroup(2103725789);
        if ((i4 & 4) != 0) {
            glanceModifier = GlanceModifier.INSTANCE;
        }
        final GlanceModifier glanceModifier2 = glanceModifier;
        if ((i4 & 8) != 0) {
            i = Alignment.INSTANCE.m21433getStartPGIyAqw();
            i5 = i2;
            i6 = i5 & (-7169);
        } else {
            i5 = i2;
            i6 = i5;
        }
        final int i7 = i;
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(2103725789, i6, -1, "androidx.glance.appwidget.lazy.LazyVerticalGrid (LazyVerticalGrid.kt:85)");
        }
        LazyVerticalGridKt$LazyVerticalGrid$4 lazyVerticalGridKt$LazyVerticalGrid$4 = LazyVerticalGridKt$LazyVerticalGrid$4.INSTANCE;
        Function2<Composer, Integer, Unit> function2ApplyVerticalGridScope = applyVerticalGridScope(new Alignment(i7, Alignment.Vertical.INSTANCE.m21453getCenterVerticallymnfRV0w(), null), content);
        composerStartRestartGroup.startReplaceableGroup(578571862);
        composerStartRestartGroup.startReplaceableGroup(-548224868);
        if (!(composerStartRestartGroup.getApplier() instanceof Applier)) {
            ComposablesKt.invalidApplier();
        }
        composerStartRestartGroup.startNode();
        if (composerStartRestartGroup.getInserting()) {
            composerStartRestartGroup.createNode(lazyVerticalGridKt$LazyVerticalGrid$4);
        } else {
            composerStartRestartGroup.useNode();
        }
        Composer composerM18018constructorimpl = Updater.m18018constructorimpl(composerStartRestartGroup);
        Updater.m18025setimpl(composerM18018constructorimpl, gridCells, new Function2<EmittableLazyVerticalGrid, GridCells, Unit>() { // from class: androidx.glance.appwidget.lazy.LazyVerticalGridKt$LazyVerticalGrid$5$1
            @Override // kotlin.jvm.functions.Function2
            public /* bridge */ /* synthetic */ Unit invoke(EmittableLazyVerticalGrid emittableLazyVerticalGrid, GridCells gridCells2) {
                invoke2(emittableLazyVerticalGrid, gridCells2);
                return Unit.INSTANCE;
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(@NotNull EmittableLazyVerticalGrid set, @NotNull GridCells it) {
                Intrinsics.checkNotNullParameter(set, "$this$set");
                Intrinsics.checkNotNullParameter(it, "it");
                set.setGridCells(it);
            }
        });
        Updater.m18025setimpl(composerM18018constructorimpl, glanceModifier2, new Function2<EmittableLazyVerticalGrid, GlanceModifier, Unit>() { // from class: androidx.glance.appwidget.lazy.LazyVerticalGridKt$LazyVerticalGrid$5$2
            @Override // kotlin.jvm.functions.Function2
            public /* bridge */ /* synthetic */ Unit invoke(EmittableLazyVerticalGrid emittableLazyVerticalGrid, GlanceModifier glanceModifier3) {
                invoke2(emittableLazyVerticalGrid, glanceModifier3);
                return Unit.INSTANCE;
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(@NotNull EmittableLazyVerticalGrid set, @NotNull GlanceModifier it) {
                Intrinsics.checkNotNullParameter(set, "$this$set");
                Intrinsics.checkNotNullParameter(it, "it");
                set.setModifier(it);
            }
        });
        Updater.m18025setimpl(composerM18018constructorimpl, Alignment.Horizontal.m21435boximpl(i7), new Function2<EmittableLazyVerticalGrid, Alignment.Horizontal, Unit>() { // from class: androidx.glance.appwidget.lazy.LazyVerticalGridKt$LazyVerticalGrid$5$3
            @Override // kotlin.jvm.functions.Function2
            public /* bridge */ /* synthetic */ Unit invoke(EmittableLazyVerticalGrid emittableLazyVerticalGrid, Alignment.Horizontal horizontal) {
                m21351invokeh_Kf0XE(emittableLazyVerticalGrid, horizontal.getValue());
                return Unit.INSTANCE;
            }

            /* JADX INFO: renamed from: invoke-h_Kf0XE, reason: not valid java name */
            public final void m21351invokeh_Kf0XE(@NotNull EmittableLazyVerticalGrid set, int i8) {
                Intrinsics.checkNotNullParameter(set, "$this$set");
                set.m21342setHorizontalAlignmentuMT220(i8);
            }
        });
        Updater.m18025setimpl(composerM18018constructorimpl, activityOptions, new Function2<EmittableLazyVerticalGrid, Bundle, Unit>() { // from class: androidx.glance.appwidget.lazy.LazyVerticalGridKt$LazyVerticalGrid$5$4
            @Override // kotlin.jvm.functions.Function2
            public /* bridge */ /* synthetic */ Unit invoke(EmittableLazyVerticalGrid emittableLazyVerticalGrid, Bundle bundle) {
                invoke2(emittableLazyVerticalGrid, bundle);
                return Unit.INSTANCE;
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(@NotNull EmittableLazyVerticalGrid set, @NotNull Bundle it) {
                Intrinsics.checkNotNullParameter(set, "$this$set");
                Intrinsics.checkNotNullParameter(it, "it");
                set.setActivityOptions(it);
            }
        });
        function2ApplyVerticalGridScope.invoke(composerStartRestartGroup, 0);
        composerStartRestartGroup.endNode();
        composerStartRestartGroup.endReplaceableGroup();
        composerStartRestartGroup.endReplaceableGroup();
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.glance.appwidget.lazy.LazyVerticalGridKt$LazyVerticalGrid$6
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

                public final void invoke(@Nullable Composer composer2, int i8) {
                    LazyVerticalGridKt.m21349LazyVerticalGridtdtSkkI(gridCells, activityOptions, glanceModifier2, i7, content, composer2, RecomposeScopeImplKt.updateChangedFlags(i5 | 1), i4);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    @Composable
    @ComposableInferredTarget(scheme = "[0[0]]")
    public static final void LazyVerticalGridItem(final long j, final Alignment alignment, final Function2<? super Composer, ? super Integer, Unit> function2, Composer composer, final int i) {
        int i2;
        Composer composerStartRestartGroup = composer.startRestartGroup(982284890);
        if ((i & 14) == 0) {
            i2 = (composerStartRestartGroup.changed(j) ? 4 : 2) | i;
        } else {
            i2 = i;
        }
        if ((i & 112) == 0) {
            i2 |= composerStartRestartGroup.changed(alignment) ? 32 : 16;
        }
        if ((i & 896) == 0) {
            i2 |= composerStartRestartGroup.changedInstance(function2) ? 256 : 128;
        }
        if ((i2 & 731) == 146 && composerStartRestartGroup.getSkipping()) {
            composerStartRestartGroup.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(982284890, i2, -1, "androidx.glance.appwidget.lazy.LazyVerticalGridItem (LazyVerticalGrid.kt:148)");
            }
            composerStartRestartGroup.startMovableGroup(-250207488, Long.valueOf(j));
            C29571 c29571 = C29571.INSTANCE;
            composerStartRestartGroup.startReplaceableGroup(578571862);
            int i4 = i2 & 896;
            composerStartRestartGroup.startReplaceableGroup(-548224868);
            if (!(composerStartRestartGroup.getApplier() instanceof Applier)) {
                ComposablesKt.invalidApplier();
            }
            composerStartRestartGroup.startNode();
            if (composerStartRestartGroup.getInserting()) {
                composerStartRestartGroup.createNode(c29571);
            } else {
                composerStartRestartGroup.useNode();
            }
            Composer composerM18018constructorimpl = Updater.m18018constructorimpl(composerStartRestartGroup);
            Updater.m18025setimpl(composerM18018constructorimpl, Long.valueOf(j), new Function2<EmittableLazyVerticalGridListItem, Long, Unit>() { // from class: androidx.glance.appwidget.lazy.LazyVerticalGridKt$LazyVerticalGridItem$2$1
                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Unit invoke(EmittableLazyVerticalGridListItem emittableLazyVerticalGridListItem, Long l) {
                    invoke(emittableLazyVerticalGridListItem, l.longValue());
                    return Unit.INSTANCE;
                }

                public final void invoke(@NotNull EmittableLazyVerticalGridListItem set, long j2) {
                    Intrinsics.checkNotNullParameter(set, "$this$set");
                    set.setItemId(j2);
                }
            });
            Updater.m18025setimpl(composerM18018constructorimpl, alignment, new Function2<EmittableLazyVerticalGridListItem, Alignment, Unit>() { // from class: androidx.glance.appwidget.lazy.LazyVerticalGridKt$LazyVerticalGridItem$2$2
                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Unit invoke(EmittableLazyVerticalGridListItem emittableLazyVerticalGridListItem, Alignment alignment2) {
                    invoke2(emittableLazyVerticalGridListItem, alignment2);
                    return Unit.INSTANCE;
                }

                /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(@NotNull EmittableLazyVerticalGridListItem set, @NotNull Alignment it) {
                    Intrinsics.checkNotNullParameter(set, "$this$set");
                    Intrinsics.checkNotNullParameter(it, "it");
                    set.setAlignment(it);
                }
            });
            function2.invoke(composerStartRestartGroup, Integer.valueOf((i4 >> 6) & 14));
            composerStartRestartGroup.endNode();
            composerStartRestartGroup.endReplaceableGroup();
            composerStartRestartGroup.endReplaceableGroup();
            composerStartRestartGroup.endMovableGroup();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.glance.appwidget.lazy.LazyVerticalGridKt.LazyVerticalGridItem.3
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

                public final void invoke(@Nullable Composer composer2, int i5) {
                    LazyVerticalGridKt.LazyVerticalGridItem(j, alignment, function2, composer2, RecomposeScopeImplKt.updateChangedFlags(i | 1));
                }
            });
        }
    }

    @NotNull
    public static final Function2<Composer, Integer, Unit> applyVerticalGridScope(@NotNull final Alignment alignment, @NotNull Function1<? super LazyVerticalGridScope, Unit> content) {
        Intrinsics.checkNotNullParameter(alignment, "alignment");
        Intrinsics.checkNotNullParameter(content, "content");
        final ArrayList arrayList = new ArrayList();
        content.invoke(new LazyVerticalGridScope() { // from class: androidx.glance.appwidget.lazy.LazyVerticalGridKt$applyVerticalGridScope$listScopeImpl$1
            @Override // androidx.glance.appwidget.lazy.LazyVerticalGridScope
            @ComposableInferredTarget(scheme = "[0[0]]")
            public void item(long itemId, @NotNull Function3<? super LazyItemScope, ? super Composer, ? super Integer, Unit> content2) {
                Intrinsics.checkNotNullParameter(content2, "content");
                if (itemId != Long.MIN_VALUE && itemId <= LazyListKt.ReservedItemIdRangeEnd) {
                    throw new IllegalArgumentException("You may not specify item ids less than -4611686018427387904 in a Glance\nwidget. These are reserved.");
                }
                arrayList.add(TuplesKt.m13893to(Long.valueOf(itemId), content2));
            }

            @Override // androidx.glance.appwidget.lazy.LazyVerticalGridScope
            @ComposableInferredTarget(scheme = "[0[0]]")
            public void items(int count, @NotNull Function1<? super Integer, Long> itemId, @NotNull final Function4<? super LazyItemScope, ? super Integer, ? super Composer, ? super Integer, Unit> itemContent) {
                Intrinsics.checkNotNullParameter(itemId, "itemId");
                Intrinsics.checkNotNullParameter(itemContent, "itemContent");
                for (final int i = 0; i < count; i++) {
                    item(itemId.invoke(Integer.valueOf(i)).longValue(), ComposableLambdaKt.composableLambdaInstance(104469668, true, new Function3<LazyItemScope, Composer, Integer, Unit>() { // from class: androidx.glance.appwidget.lazy.LazyVerticalGridKt$applyVerticalGridScope$listScopeImpl$1$items$1$1
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        /* JADX WARN: Multi-variable type inference failed */
                        {
                            super(3);
                        }

                        @Override // kotlin.jvm.functions.Function3
                        public /* bridge */ /* synthetic */ Unit invoke(LazyItemScope lazyItemScope, Composer composer, Integer num) {
                            invoke(lazyItemScope, composer, num.intValue());
                            return Unit.INSTANCE;
                        }

                        @Composable
                        public final void invoke(@NotNull LazyItemScope item, @Nullable Composer composer, int i2) {
                            Intrinsics.checkNotNullParameter(item, "$this$item");
                            if ((i2 & 14) == 0) {
                                i2 |= composer.changed(item) ? 4 : 2;
                            }
                            if ((i2 & 91) == 18 && composer.getSkipping()) {
                                composer.skipToGroupEnd();
                                return;
                            }
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventStart(104469668, i2, -1, "androidx.glance.appwidget.lazy.applyVerticalGridScope.<no name provided>.items.<anonymous>.<anonymous> (LazyVerticalGrid.kt:124)");
                            }
                            itemContent.invoke(item, Integer.valueOf(i), composer, Integer.valueOf(i2 & 14));
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventEnd();
                            }
                        }
                    }));
                }
            }
        });
        return ComposableLambdaKt.composableLambdaInstance(-628089649, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.glance.appwidget.lazy.LazyVerticalGridKt.applyVerticalGridScope.1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(2);
            }

            @Override // kotlin.jvm.functions.Function2
            public /* bridge */ /* synthetic */ Unit invoke(Composer composer, Integer num) {
                invoke(composer, num.intValue());
                return Unit.INSTANCE;
            }

            @Composable
            public final void invoke(@Nullable Composer composer, int i) {
                if ((i & 11) == 2 && composer.getSkipping()) {
                    composer.skipToGroupEnd();
                    return;
                }
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(-628089649, i, -1, "androidx.glance.appwidget.lazy.applyVerticalGridScope.<anonymous> (LazyVerticalGrid.kt:130)");
                }
                List<Pair<Long, Function3<LazyItemScope, Composer, Integer, Unit>>> list = arrayList;
                Alignment alignment2 = alignment;
                int i2 = 0;
                for (Object obj : list) {
                    int i4 = i2 + 1;
                    if (i2 < 0) {
                        CollectionsKt.throwIndexOverflow();
                    }
                    Pair pair = (Pair) obj;
                    Long l = (Long) pair.component1();
                    final Function3 function3 = (Function3) pair.component2();
                    if (l != null && l.longValue() == Long.MIN_VALUE) {
                        l = null;
                    }
                    long jLongValue = l != null ? l.longValue() : LazyListKt.ReservedItemIdRangeEnd - ((long) i2);
                    if (jLongValue == Long.MIN_VALUE) {
                        throw new IllegalStateException("Implicit list item ids exhausted.");
                    }
                    LazyVerticalGridKt.LazyVerticalGridItem(jLongValue, alignment2, ComposableLambdaKt.composableLambda(composer, -1015790400, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.glance.appwidget.lazy.LazyVerticalGridKt$applyVerticalGridScope$1$1$2
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

                        @Composable
                        public final void invoke(@Nullable Composer composer2, int i5) {
                            if ((i5 & 11) == 2 && composer2.getSkipping()) {
                                composer2.skipToGroupEnd();
                                return;
                            }
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventStart(-1015790400, i5, -1, "androidx.glance.appwidget.lazy.applyVerticalGridScope.<anonymous>.<anonymous>.<anonymous> (LazyVerticalGrid.kt:137)");
                            }
                            function3.invoke(new LazyItemScope() { // from class: androidx.glance.appwidget.lazy.LazyVerticalGridKt$applyVerticalGridScope$1$1$2.1
                            }, composer2, 0);
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventEnd();
                            }
                        }
                    }), composer, (Alignment.$stable << 3) | 384);
                    i2 = i4;
                }
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
            }
        });
    }

    @ComposableInferredTarget(scheme = "[0[0]]")
    public static final <T> void items(@NotNull LazyVerticalGridScope lazyVerticalGridScope, @NotNull List<? extends T> items, @NotNull Function1<? super T, Long> itemId, @NotNull Function4<? super LazyItemScope, ? super T, ? super Composer, ? super Integer, Unit> itemContent) {
        Intrinsics.checkNotNullParameter(lazyVerticalGridScope, "<this>");
        Intrinsics.checkNotNullParameter(items, "items");
        Intrinsics.checkNotNullParameter(itemId, "itemId");
        Intrinsics.checkNotNullParameter(itemContent, "itemContent");
        lazyVerticalGridScope.items(items.size(), new C29632(itemId, items), ComposableLambdaKt.composableLambdaInstance(-693260830, true, new C29643(itemContent, items)));
    }

    public static /* synthetic */ void items$default(LazyVerticalGridScope lazyVerticalGridScope, List items, Function1 itemId, Function4 itemContent, int i, Object obj) {
        if ((i & 2) != 0) {
            itemId = new Function1() { // from class: androidx.glance.appwidget.lazy.LazyVerticalGridKt.items.1
                @Override // kotlin.jvm.functions.Function1
                @NotNull
                public final Long invoke(Object obj2) {
                    return Long.MIN_VALUE;
                }
            };
        }
        Intrinsics.checkNotNullParameter(lazyVerticalGridScope, "<this>");
        Intrinsics.checkNotNullParameter(items, "items");
        Intrinsics.checkNotNullParameter(itemId, "itemId");
        Intrinsics.checkNotNullParameter(itemContent, "itemContent");
        lazyVerticalGridScope.items(items.size(), new C29632(itemId, items), ComposableLambdaKt.composableLambdaInstance(-693260830, true, new C29643(itemContent, items)));
    }

    @ComposableInferredTarget(scheme = "[0[0]]")
    public static final <T> void itemsIndexed(@NotNull LazyVerticalGridScope lazyVerticalGridScope, @NotNull List<? extends T> items, @NotNull Function2<? super Integer, ? super T, Long> itemId, @NotNull Function5<? super LazyItemScope, ? super Integer, ? super T, ? super Composer, ? super Integer, Unit> itemContent) {
        Intrinsics.checkNotNullParameter(lazyVerticalGridScope, "<this>");
        Intrinsics.checkNotNullParameter(items, "items");
        Intrinsics.checkNotNullParameter(itemId, "itemId");
        Intrinsics.checkNotNullParameter(itemContent, "itemContent");
        lazyVerticalGridScope.items(items.size(), new C29692(itemId, items), ComposableLambdaKt.composableLambdaInstance(-2105063253, true, new C29703(itemContent, items)));
    }

    public static /* synthetic */ void itemsIndexed$default(LazyVerticalGridScope lazyVerticalGridScope, List items, Function2 itemId, Function5 itemContent, int i, Object obj) {
        if ((i & 2) != 0) {
            itemId = new Function2() { // from class: androidx.glance.appwidget.lazy.LazyVerticalGridKt.itemsIndexed.1
                @NotNull
                public final Long invoke(int i2, Object obj2) {
                    return Long.MIN_VALUE;
                }

                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Object invoke(Object obj2, Object obj3) {
                    return invoke(((Number) obj2).intValue(), obj3);
                }
            };
        }
        Intrinsics.checkNotNullParameter(lazyVerticalGridScope, "<this>");
        Intrinsics.checkNotNullParameter(items, "items");
        Intrinsics.checkNotNullParameter(itemId, "itemId");
        Intrinsics.checkNotNullParameter(itemContent, "itemContent");
        lazyVerticalGridScope.items(items.size(), new C29692(itemId, items), ComposableLambdaKt.composableLambdaInstance(-2105063253, true, new C29703(itemContent, items)));
    }

    @ComposableInferredTarget(scheme = "[0[0]]")
    public static final <T> void items(@NotNull LazyVerticalGridScope lazyVerticalGridScope, @NotNull T[] items, @NotNull Function1<? super T, Long> itemId, @NotNull Function4<? super LazyItemScope, ? super T, ? super Composer, ? super Integer, Unit> itemContent) {
        Intrinsics.checkNotNullParameter(lazyVerticalGridScope, "<this>");
        Intrinsics.checkNotNullParameter(items, "items");
        Intrinsics.checkNotNullParameter(itemId, "itemId");
        Intrinsics.checkNotNullParameter(itemContent, "itemContent");
        lazyVerticalGridScope.items(items.length, new C29665(itemId, items), ComposableLambdaKt.composableLambdaInstance(315415057, true, new C29676(itemContent, items)));
    }

    @ComposableInferredTarget(scheme = "[0[0]]")
    public static final <T> void itemsIndexed(@NotNull LazyVerticalGridScope lazyVerticalGridScope, @NotNull T[] items, @NotNull Function2<? super Integer, ? super T, Long> itemId, @NotNull Function5<? super LazyItemScope, ? super Integer, ? super T, ? super Composer, ? super Integer, Unit> itemContent) {
        Intrinsics.checkNotNullParameter(lazyVerticalGridScope, "<this>");
        Intrinsics.checkNotNullParameter(items, "items");
        Intrinsics.checkNotNullParameter(itemId, "itemId");
        Intrinsics.checkNotNullParameter(itemContent, "itemContent");
        lazyVerticalGridScope.items(items.length, new C29725(itemId, items), ComposableLambdaKt.composableLambdaInstance(-1310895196, true, new C29736(itemContent, items)));
    }

    public static /* synthetic */ void items$default(LazyVerticalGridScope lazyVerticalGridScope, Object[] items, Function1 itemId, Function4 itemContent, int i, Object obj) {
        if ((i & 2) != 0) {
            itemId = new Function1() { // from class: androidx.glance.appwidget.lazy.LazyVerticalGridKt.items.4
                @Override // kotlin.jvm.functions.Function1
                @NotNull
                public final Long invoke(Object obj2) {
                    return Long.MIN_VALUE;
                }
            };
        }
        Intrinsics.checkNotNullParameter(lazyVerticalGridScope, "<this>");
        Intrinsics.checkNotNullParameter(items, "items");
        Intrinsics.checkNotNullParameter(itemId, "itemId");
        Intrinsics.checkNotNullParameter(itemContent, "itemContent");
        lazyVerticalGridScope.items(items.length, new C29665(itemId, items), ComposableLambdaKt.composableLambdaInstance(315415057, true, new C29676(itemContent, items)));
    }

    public static /* synthetic */ void itemsIndexed$default(LazyVerticalGridScope lazyVerticalGridScope, Object[] items, Function2 itemId, Function5 itemContent, int i, Object obj) {
        if ((i & 2) != 0) {
            itemId = new Function2() { // from class: androidx.glance.appwidget.lazy.LazyVerticalGridKt.itemsIndexed.4
                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Object invoke(Object obj2, Object obj3) {
                    return invoke(((Number) obj2).intValue(), obj3);
                }

                @NotNull
                public final Long invoke(int i2, Object obj2) {
                    return Long.MIN_VALUE;
                }
            };
        }
        Intrinsics.checkNotNullParameter(lazyVerticalGridScope, "<this>");
        Intrinsics.checkNotNullParameter(items, "items");
        Intrinsics.checkNotNullParameter(itemId, "itemId");
        Intrinsics.checkNotNullParameter(itemContent, "itemContent");
        lazyVerticalGridScope.items(items.length, new C29725(itemId, items), ComposableLambdaKt.composableLambdaInstance(-1310895196, true, new C29736(itemContent, items)));
    }
}
