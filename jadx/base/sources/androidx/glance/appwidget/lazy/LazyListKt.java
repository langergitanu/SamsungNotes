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
import androidx.constraintlayout.motion.widget.AbstractC2322a;
import androidx.glance.Applier;
import androidx.glance.ExperimentalGlanceApi;
import androidx.glance.GlanceModifier;
import androidx.glance.layout.Alignment;
import com.samsung.android.app.sdk.deepsky.textextraction.languagepack.LangPackConfigConstants;
import com.samsung.android.imagetranslation.common.LttEngineErrors;
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
@Metadata(m13885d1 = {"\u0000l\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u001aG\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\t2\u0017\u0010\n\u001a\u0013\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\u00030\u000b¢\u0006\u0002\b\rH\u0007ø\u0001\u0000¢\u0006\u0004\b\u000e\u0010\u000f\u001a?\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\t2\u0017\u0010\n\u001a\u0013\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\u00030\u000b¢\u0006\u0002\b\rH\u0007ø\u0001\u0000¢\u0006\u0004\b\u0010\u0010\u0011\u001a0\u0010\u0012\u001a\u00020\u00032\u0006\u0010\u0013\u001a\u00020\u00012\u0006\u0010\u0014\u001a\u00020\u00152\u0011\u0010\n\u001a\r\u0012\u0004\u0012\u00020\u00030\u0016¢\u0006\u0002\b\u0017H\u0003¢\u0006\u0002\u0010\u0018\u001a9\u0010\u0019\u001a\r\u0012\u0004\u0012\u00020\u00030\u0016¢\u0006\u0002\b\u00172\u0006\u0010\u0014\u001a\u00020\u00152\u0017\u0010\n\u001a\u0013\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\u00030\u000b¢\u0006\u0002\b\rH\u0002¢\u0006\u0002\u0010\u001a\u001a\u0083\u0001\u0010\u001b\u001a\u00020\u0003\"\u0004\b\u0000\u0010\u001c*\u00020\f2\f\u0010\u001b\u001a\b\u0012\u0004\u0012\u0002H\u001c0\u001d2#\b\n\u0010\u0013\u001a\u001d\u0012\u0013\u0012\u0011H\u001c¢\u0006\f\b\u001e\u0012\b\b\u001f\u0012\u0004\b\b( \u0012\u0004\u0012\u00020\u00010\u000b23\b\u0004\u0010!\u001a-\u0012\u0004\u0012\u00020#\u0012\u0013\u0012\u0011H\u001c¢\u0006\f\b\u001e\u0012\b\b\u001f\u0012\u0004\b\b( \u0012\u0004\u0012\u00020\u00030\"¢\u0006\u0002\b\u0017¢\u0006\u0002\b\rH\u0086\bø\u0001\u0001¢\u0006\u0002\u0010$\u001a\u0083\u0001\u0010\u001b\u001a\u00020\u0003\"\u0004\b\u0000\u0010\u001c*\u00020\f2\f\u0010\u001b\u001a\b\u0012\u0004\u0012\u0002H\u001c0%2#\b\u0006\u0010\u0013\u001a\u001d\u0012\u0013\u0012\u0011H\u001c¢\u0006\f\b\u001e\u0012\b\b\u001f\u0012\u0004\b\b( \u0012\u0004\u0012\u00020\u00010\u000b23\b\u0004\u0010!\u001a-\u0012\u0004\u0012\u00020#\u0012\u0013\u0012\u0011H\u001c¢\u0006\f\b\u001e\u0012\b\b\u001f\u0012\u0004\b\b( \u0012\u0004\u0012\u00020\u00030\"¢\u0006\u0002\b\u0017¢\u0006\u0002\b\rH\u0086\bø\u0001\u0001¢\u0006\u0002\u0010&\u001a\u00ad\u0001\u0010'\u001a\u00020\u0003\"\u0004\b\u0000\u0010\u001c*\u00020\f2\f\u0010\u001b\u001a\b\u0012\u0004\u0012\u0002H\u001c0\u001d28\b\n\u0010\u0013\u001a2\u0012\u0013\u0012\u00110(¢\u0006\f\b\u001e\u0012\b\b\u001f\u0012\u0004\b\b()\u0012\u0013\u0012\u0011H\u001c¢\u0006\f\b\u001e\u0012\b\b\u001f\u0012\u0004\b\b( \u0012\u0004\u0012\u00020\u00010\"2H\b\u0004\u0010!\u001aB\u0012\u0004\u0012\u00020#\u0012\u0013\u0012\u00110(¢\u0006\f\b\u001e\u0012\b\b\u001f\u0012\u0004\b\b()\u0012\u0013\u0012\u0011H\u001c¢\u0006\f\b\u001e\u0012\b\b\u001f\u0012\u0004\b\b( \u0012\u0004\u0012\u00020\u00030*¢\u0006\u0002\b\u0017¢\u0006\u0002\b\rH\u0086\bø\u0001\u0001¢\u0006\u0002\u0010+\u001a\u00ad\u0001\u0010'\u001a\u00020\u0003\"\u0004\b\u0000\u0010\u001c*\u00020\f2\f\u0010\u001b\u001a\b\u0012\u0004\u0012\u0002H\u001c0%28\b\u0006\u0010\u0013\u001a2\u0012\u0013\u0012\u00110(¢\u0006\f\b\u001e\u0012\b\b\u001f\u0012\u0004\b\b()\u0012\u0013\u0012\u0011H\u001c¢\u0006\f\b\u001e\u0012\b\b\u001f\u0012\u0004\b\b( \u0012\u0004\u0012\u00020\u00010\"2H\b\u0004\u0010!\u001aB\u0012\u0004\u0012\u00020#\u0012\u0013\u0012\u00110(¢\u0006\f\b\u001e\u0012\b\b\u001f\u0012\u0004\b\b()\u0012\u0013\u0012\u0011H\u001c¢\u0006\f\b\u001e\u0012\b\b\u001f\u0012\u0004\b\b( \u0012\u0004\u0012\u00020\u00030*¢\u0006\u0002\b\u0017¢\u0006\u0002\b\rH\u0086\bø\u0001\u0001¢\u0006\u0002\u0010,\"\u000e\u0010\u0000\u001a\u00020\u0001X\u0080T¢\u0006\u0002\n\u0000\u0082\u0002\u000e\n\u0005\b¡\u001e0\u0001\n\u0005\b\u009920\u0001¨\u0006-"}, m13886d2 = {"ReservedItemIdRangeEnd", "", "LazyColumn", "", "activityOptions", "Landroid/os/Bundle;", "modifier", "Landroidx/glance/GlanceModifier;", "horizontalAlignment", "Landroidx/glance/layout/Alignment$Horizontal;", "content", "Lkotlin/Function1;", "Landroidx/glance/appwidget/lazy/LazyListScope;", "Lkotlin/ExtensionFunctionType;", "LazyColumn-ca5uSD8", "(Landroid/os/Bundle;Landroidx/glance/GlanceModifier;ILkotlin/jvm/functions/Function1;Landroidx/compose/runtime/Composer;II)V", "LazyColumn-EiNPFjs", "(Landroidx/glance/GlanceModifier;ILkotlin/jvm/functions/Function1;Landroidx/compose/runtime/Composer;II)V", "LazyListItem", "itemId", "alignment", "Landroidx/glance/layout/Alignment;", "Lkotlin/Function0;", "Landroidx/compose/runtime/Composable;", "(JLandroidx/glance/layout/Alignment;Lkotlin/jvm/functions/Function2;Landroidx/compose/runtime/Composer;I)V", "applyListScope", "(Landroidx/glance/layout/Alignment;Lkotlin/jvm/functions/Function1;)Lkotlin/jvm/functions/Function2;", "items", "T", "", "Lkotlin/ParameterName;", "name", "item", "itemContent", "Lkotlin/Function2;", "Landroidx/glance/appwidget/lazy/LazyItemScope;", "(Landroidx/glance/appwidget/lazy/LazyListScope;[Ljava/lang/Object;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function4;)V", "", "(Landroidx/glance/appwidget/lazy/LazyListScope;Ljava/util/List;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function4;)V", "itemsIndexed", "", "index", "Lkotlin/Function3;", "(Landroidx/glance/appwidget/lazy/LazyListScope;[Ljava/lang/Object;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function5;)V", "(Landroidx/glance/appwidget/lazy/LazyListScope;Ljava/util/List;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function5;)V", "glance-appwidget_release"}, m13887k = 2, m13888mv = {1, 9, 0}, m13890xi = 48)
@SourceDebugExtension({"SMAP\nLazyList.kt\nKotlin\n*S Kotlin\n*F\n+ 1 LazyList.kt\nandroidx/glance/appwidget/lazy/LazyListKt\n+ 2 GlanceNode.kt\nandroidx/glance/GlanceNodeKt\n+ 3 Composables.kt\nandroidx/compose/runtime/ComposablesKt\n*L\n1#1,316:1\n43#2:317\n44#2:329\n43#2:330\n44#2:342\n43#2:343\n44#2:355\n325#3,11:318\n325#3,11:331\n325#3,11:344\n*S KotlinDebug\n*F\n+ 1 LazyList.kt\nandroidx/glance/appwidget/lazy/LazyListKt\n*L\n49#1:317\n49#1:329\n82#1:330\n82#1:342\n144#1:343\n144#1:355\n49#1:318,11\n82#1:331,11\n144#1:344,11\n*E\n"})
public final class LazyListKt {
    public static final long ReservedItemIdRangeEnd = -4611686018427387904L;

    /* JADX INFO: renamed from: androidx.glance.appwidget.lazy.LazyListKt$LazyListItem$1 */
    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13887k = 3, m13888mv = {1, 9, 0}, m13890xi = 48)
    public /* synthetic */ class C29401 extends FunctionReferenceImpl implements Function0<EmittableLazyListItem> {
        public static final C29401 INSTANCE = new C29401();

        public C29401() {
            super(0, EmittableLazyListItem.class, "<init>", "<init>()V", 0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlin.jvm.functions.Function0
        @NotNull
        public final EmittableLazyListItem invoke() {
            return new EmittableLazyListItem();
        }
    }

    /* JADX INFO: renamed from: androidx.glance.appwidget.lazy.LazyListKt$items$2 */
    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000\u0012\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u00022\u0006\u0010\u0003\u001a\u00020\u0004H\n¢\u0006\u0004\b\u0005\u0010\u0006"}, m13886d2 = {"<anonymous>", "", "T", "index", "", "invoke", "(I)Ljava/lang/Long;"}, m13887k = 3, m13888mv = {1, 9, 0}, m13890xi = 176)
    @SourceDebugExtension({"SMAP\nLazyList.kt\nKotlin\n*S Kotlin\n*F\n+ 1 LazyList.kt\nandroidx/glance/appwidget/lazy/LazyListKt$items$2\n*L\n1#1,316:1\n*E\n"})
    public static final class C29452 extends Lambda implements Function1<Integer, Long> {
        final /* synthetic */ Function1<T, Long> $itemId;
        final /* synthetic */ List<T> $items;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        public C29452(Function1<? super T, Long> function1, List<? extends T> list) {
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

    /* JADX INFO: renamed from: androidx.glance.appwidget.lazy.LazyListKt$items$3 */
    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000\u0016\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u000b¢\u0006\u0004\b\u0006\u0010\u0007"}, m13886d2 = {"<anonymous>", "", "T", "Landroidx/glance/appwidget/lazy/LazyItemScope;", LangPackConfigConstants.LANGUAGE_CODE_IT, "", "invoke", "(Landroidx/glance/appwidget/lazy/LazyItemScope;ILandroidx/compose/runtime/Composer;I)V"}, m13887k = 3, m13888mv = {1, 9, 0}, m13890xi = 176)
    @SourceDebugExtension({"SMAP\nLazyList.kt\nKotlin\n*S Kotlin\n*F\n+ 1 LazyList.kt\nandroidx/glance/appwidget/lazy/LazyListKt$items$3\n*L\n1#1,316:1\n*E\n"})
    public static final class C29463 extends Lambda implements Function4<LazyItemScope, Integer, Composer, Integer, Unit> {
        final /* synthetic */ Function4<LazyItemScope, T, Composer, Integer, Unit> $itemContent;
        final /* synthetic */ List<T> $items;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        public C29463(Function4<? super LazyItemScope, ? super T, ? super Composer, ? super Integer, Unit> function4, List<? extends T> list) {
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
                ComposerKt.traceEventStart(33490014, i4, -1, "androidx.glance.appwidget.lazy.items.<anonymous> (LazyList.kt:222)");
            }
            this.$itemContent.invoke(items, (T) this.$items.get(i), composer, Integer.valueOf(i4 & 14));
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
    }

    /* JADX INFO: renamed from: androidx.glance.appwidget.lazy.LazyListKt$items$5 */
    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000\u0012\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u00022\u0006\u0010\u0003\u001a\u00020\u0004H\n¢\u0006\u0004\b\u0005\u0010\u0006"}, m13886d2 = {"<anonymous>", "", "T", "index", "", "invoke", "(I)Ljava/lang/Long;"}, m13887k = 3, m13888mv = {1, 9, 0}, m13890xi = 176)
    @SourceDebugExtension({"SMAP\nLazyList.kt\nKotlin\n*S Kotlin\n*F\n+ 1 LazyList.kt\nandroidx/glance/appwidget/lazy/LazyListKt$items$5\n*L\n1#1,316:1\n*E\n"})
    public static final class C29485 extends Lambda implements Function1<Integer, Long> {
        final /* synthetic */ Function1<T, Long> $itemId;
        final /* synthetic */ T[] $items;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        public C29485(Function1<? super T, Long> function1, T[] tArr) {
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

    /* JADX INFO: renamed from: androidx.glance.appwidget.lazy.LazyListKt$items$6 */
    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000\u0016\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u000b¢\u0006\u0004\b\u0006\u0010\u0007"}, m13886d2 = {"<anonymous>", "", "T", "Landroidx/glance/appwidget/lazy/LazyItemScope;", LangPackConfigConstants.LANGUAGE_CODE_IT, "", "invoke", "(Landroidx/glance/appwidget/lazy/LazyItemScope;ILandroidx/compose/runtime/Composer;I)V"}, m13887k = 3, m13888mv = {1, 9, 0}, m13890xi = 176)
    @SourceDebugExtension({"SMAP\nLazyList.kt\nKotlin\n*S Kotlin\n*F\n+ 1 LazyList.kt\nandroidx/glance/appwidget/lazy/LazyListKt$items$6\n*L\n1#1,316:1\n*E\n"})
    public static final class C29496 extends Lambda implements Function4<LazyItemScope, Integer, Composer, Integer, Unit> {
        final /* synthetic */ Function4<LazyItemScope, T, Composer, Integer, Unit> $itemContent;
        final /* synthetic */ T[] $items;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        public C29496(Function4<? super LazyItemScope, ? super T, ? super Composer, ? super Integer, Unit> function4, T[] tArr) {
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
                ComposerKt.traceEventStart(663369809, i4, -1, "androidx.glance.appwidget.lazy.items.<anonymous> (LazyList.kt:259)");
            }
            this.$itemContent.invoke(items, this.$items[i], composer, Integer.valueOf(i4 & 14));
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
    }

    /* JADX INFO: renamed from: androidx.glance.appwidget.lazy.LazyListKt$itemsIndexed$2 */
    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000\u0012\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u00022\u0006\u0010\u0003\u001a\u00020\u0004H\n¢\u0006\u0004\b\u0005\u0010\u0006"}, m13886d2 = {"<anonymous>", "", "T", "index", "", "invoke", "(I)Ljava/lang/Long;"}, m13887k = 3, m13888mv = {1, 9, 0}, m13890xi = 176)
    @SourceDebugExtension({"SMAP\nLazyList.kt\nKotlin\n*S Kotlin\n*F\n+ 1 LazyList.kt\nandroidx/glance/appwidget/lazy/LazyListKt$itemsIndexed$2\n*L\n1#1,316:1\n*E\n"})
    public static final class C29512 extends Lambda implements Function1<Integer, Long> {
        final /* synthetic */ Function2<Integer, T, Long> $itemId;
        final /* synthetic */ List<T> $items;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        public C29512(Function2<? super Integer, ? super T, Long> function2, List<? extends T> list) {
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

    /* JADX INFO: renamed from: androidx.glance.appwidget.lazy.LazyListKt$itemsIndexed$3 */
    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000\u0016\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u000b¢\u0006\u0004\b\u0006\u0010\u0007"}, m13886d2 = {"<anonymous>", "", "T", "Landroidx/glance/appwidget/lazy/LazyItemScope;", LangPackConfigConstants.LANGUAGE_CODE_IT, "", "invoke", "(Landroidx/glance/appwidget/lazy/LazyItemScope;ILandroidx/compose/runtime/Composer;I)V"}, m13887k = 3, m13888mv = {1, 9, 0}, m13890xi = 176)
    @SourceDebugExtension({"SMAP\nLazyList.kt\nKotlin\n*S Kotlin\n*F\n+ 1 LazyList.kt\nandroidx/glance/appwidget/lazy/LazyListKt$itemsIndexed$3\n*L\n1#1,316:1\n*E\n"})
    public static final class C29523 extends Lambda implements Function4<LazyItemScope, Integer, Composer, Integer, Unit> {
        final /* synthetic */ Function5<LazyItemScope, Integer, T, Composer, Integer, Unit> $itemContent;
        final /* synthetic */ List<T> $items;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        public C29523(Function5<? super LazyItemScope, ? super Integer, ? super T, ? super Composer, ? super Integer, Unit> function5, List<? extends T> list) {
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
                ComposerKt.traceEventStart(-1405343893, i4, -1, "androidx.glance.appwidget.lazy.itemsIndexed.<anonymous> (LazyList.kt:241)");
            }
            this.$itemContent.invoke(items, Integer.valueOf(i), (T) this.$items.get(i), composer, Integer.valueOf(i4 & 126));
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
    }

    /* JADX INFO: renamed from: androidx.glance.appwidget.lazy.LazyListKt$itemsIndexed$5 */
    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000\u0012\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u00022\u0006\u0010\u0003\u001a\u00020\u0004H\n¢\u0006\u0004\b\u0005\u0010\u0006"}, m13886d2 = {"<anonymous>", "", "T", "index", "", "invoke", "(I)Ljava/lang/Long;"}, m13887k = 3, m13888mv = {1, 9, 0}, m13890xi = 176)
    @SourceDebugExtension({"SMAP\nLazyList.kt\nKotlin\n*S Kotlin\n*F\n+ 1 LazyList.kt\nandroidx/glance/appwidget/lazy/LazyListKt$itemsIndexed$5\n*L\n1#1,316:1\n*E\n"})
    public static final class C29545 extends Lambda implements Function1<Integer, Long> {
        final /* synthetic */ Function2<Integer, T, Long> $itemId;
        final /* synthetic */ T[] $items;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        public C29545(Function2<? super Integer, ? super T, Long> function2, T[] tArr) {
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

    /* JADX INFO: renamed from: androidx.glance.appwidget.lazy.LazyListKt$itemsIndexed$6 */
    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000\u0016\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u000b¢\u0006\u0004\b\u0006\u0010\u0007"}, m13886d2 = {"<anonymous>", "", "T", "Landroidx/glance/appwidget/lazy/LazyItemScope;", LangPackConfigConstants.LANGUAGE_CODE_IT, "", "invoke", "(Landroidx/glance/appwidget/lazy/LazyItemScope;ILandroidx/compose/runtime/Composer;I)V"}, m13887k = 3, m13888mv = {1, 9, 0}, m13890xi = 176)
    @SourceDebugExtension({"SMAP\nLazyList.kt\nKotlin\n*S Kotlin\n*F\n+ 1 LazyList.kt\nandroidx/glance/appwidget/lazy/LazyListKt$itemsIndexed$6\n*L\n1#1,316:1\n*E\n"})
    public static final class C29556 extends Lambda implements Function4<LazyItemScope, Integer, Composer, Integer, Unit> {
        final /* synthetic */ Function5<LazyItemScope, Integer, T, Composer, Integer, Unit> $itemContent;
        final /* synthetic */ T[] $items;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        public C29556(Function5<? super LazyItemScope, ? super Integer, ? super T, ? super Composer, ? super Integer, Unit> function5, T[] tArr) {
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
                ComposerKt.traceEventStart(-331010528, i4, -1, "androidx.glance.appwidget.lazy.itemsIndexed.<anonymous> (LazyList.kt:277)");
            }
            this.$itemContent.invoke(items, Integer.valueOf(i), this.$items[i], composer, Integer.valueOf(i4 & 126));
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:54:0x0092  */
    /* JADX WARN: Removed duplicated region for block: B:57:0x00b8  */
    /* JADX WARN: Removed duplicated region for block: B:60:0x00c4  */
    /* JADX WARN: Removed duplicated region for block: B:61:0x00c8  */
    /* JADX WARN: Removed duplicated region for block: B:64:0x00f4  */
    @Composable
    /* JADX INFO: renamed from: LazyColumn-EiNPFjs, reason: not valid java name */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final void m21344LazyColumnEiNPFjs(@Nullable GlanceModifier glanceModifier, int i, @NotNull final Function1<? super LazyListScope, Unit> content, @Nullable Composer composer, final int i2, final int i4) {
        int i5;
        Intrinsics.checkNotNullParameter(content, "content");
        Composer composerStartRestartGroup = composer.startRestartGroup(1060451148);
        int i6 = i4 & 1;
        if (i6 != 0) {
            i5 = i2 | 6;
        } else if ((i2 & 14) == 0) {
            i5 = (composerStartRestartGroup.changed(glanceModifier) ? 4 : 2) | i2;
        } else {
            i5 = i2;
        }
        if ((i2 & 112) == 0) {
            i5 |= ((i4 & 2) == 0 && composerStartRestartGroup.changed(i)) ? 32 : 16;
        }
        if ((i4 & 4) != 0) {
            i5 |= 384;
        } else if ((i2 & 896) == 0) {
            i5 |= composerStartRestartGroup.changedInstance(content) ? 256 : 128;
        }
        if ((i5 & 731) == 146 && composerStartRestartGroup.getSkipping()) {
            composerStartRestartGroup.skipToGroupEnd();
        } else {
            composerStartRestartGroup.startDefaults();
            if ((i2 & 1) == 0 || composerStartRestartGroup.getDefaultsInvalid()) {
                if (i6 != 0) {
                    glanceModifier = GlanceModifier.INSTANCE;
                }
                if ((i4 & 2) != 0) {
                    i = Alignment.INSTANCE.m21433getStartPGIyAqw();
                    i5 &= LttEngineErrors.ERROR_INPAINTING_OCR_BLOCK_TABULAR;
                }
                composerStartRestartGroup.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(1060451148, i5, -1, "androidx.glance.appwidget.lazy.LazyColumn (LazyList.kt:47)");
                }
                LazyListKt$LazyColumn$1 lazyListKt$LazyColumn$1 = LazyListKt$LazyColumn$1.INSTANCE;
                Function2<Composer, Integer, Unit> function2ApplyListScope = applyListScope(new Alignment(i, Alignment.Vertical.INSTANCE.m21453getCenterVerticallymnfRV0w(), null), content);
                if (!(AbstractC2322a.m1613c(578571862, composerStartRestartGroup, -548224868) instanceof Applier)) {
                    ComposablesKt.invalidApplier();
                }
                composerStartRestartGroup.startNode();
                if (composerStartRestartGroup.getInserting()) {
                    composerStartRestartGroup.useNode();
                } else {
                    composerStartRestartGroup.createNode(lazyListKt$LazyColumn$1);
                }
                Composer composerM18018constructorimpl = Updater.m18018constructorimpl(composerStartRestartGroup);
                Updater.m18025setimpl(composerM18018constructorimpl, glanceModifier, new Function2<EmittableLazyColumn, GlanceModifier, Unit>() { // from class: androidx.glance.appwidget.lazy.LazyListKt$LazyColumn$2$1
                    @Override // kotlin.jvm.functions.Function2
                    public /* bridge */ /* synthetic */ Unit invoke(EmittableLazyColumn emittableLazyColumn, GlanceModifier glanceModifier2) {
                        invoke2(emittableLazyColumn, glanceModifier2);
                        return Unit.INSTANCE;
                    }

                    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                    public final void invoke2(@NotNull EmittableLazyColumn set, @NotNull GlanceModifier it) {
                        Intrinsics.checkNotNullParameter(set, "$this$set");
                        Intrinsics.checkNotNullParameter(it, "it");
                        set.setModifier(it);
                    }
                });
                Updater.m18025setimpl(composerM18018constructorimpl, Alignment.Horizontal.m21435boximpl(i), new Function2<EmittableLazyColumn, Alignment.Horizontal, Unit>() { // from class: androidx.glance.appwidget.lazy.LazyListKt$LazyColumn$2$2
                    @Override // kotlin.jvm.functions.Function2
                    public /* bridge */ /* synthetic */ Unit invoke(EmittableLazyColumn emittableLazyColumn, Alignment.Horizontal horizontal) {
                        m21346invokeh_Kf0XE(emittableLazyColumn, horizontal.getValue());
                        return Unit.INSTANCE;
                    }

                    /* JADX INFO: renamed from: invoke-h_Kf0XE, reason: not valid java name */
                    public final void m21346invokeh_Kf0XE(@NotNull EmittableLazyColumn set, int i7) {
                        Intrinsics.checkNotNullParameter(set, "$this$set");
                        set.m21340setHorizontalAlignmentuMT220(i7);
                    }
                });
                function2ApplyListScope.invoke(composerStartRestartGroup, 0);
                composerStartRestartGroup.endNode();
                composerStartRestartGroup.endReplaceableGroup();
                composerStartRestartGroup.endReplaceableGroup();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
            } else {
                composerStartRestartGroup.skipToGroupEnd();
                if ((i4 & 2) != 0) {
                    i5 &= LttEngineErrors.ERROR_INPAINTING_OCR_BLOCK_TABULAR;
                }
                composerStartRestartGroup.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                }
                LazyListKt$LazyColumn$1 lazyListKt$LazyColumn$12 = LazyListKt$LazyColumn$1.INSTANCE;
                Function2<Composer, Integer, Unit> function2ApplyListScope2 = applyListScope(new Alignment(i, Alignment.Vertical.INSTANCE.m21453getCenterVerticallymnfRV0w(), null), content);
                if (!(AbstractC2322a.m1613c(578571862, composerStartRestartGroup, -548224868) instanceof Applier)) {
                }
                composerStartRestartGroup.startNode();
                if (composerStartRestartGroup.getInserting()) {
                }
                Composer composerM18018constructorimpl2 = Updater.m18018constructorimpl(composerStartRestartGroup);
                Updater.m18025setimpl(composerM18018constructorimpl2, glanceModifier, new Function2<EmittableLazyColumn, GlanceModifier, Unit>() { // from class: androidx.glance.appwidget.lazy.LazyListKt$LazyColumn$2$1
                    @Override // kotlin.jvm.functions.Function2
                    public /* bridge */ /* synthetic */ Unit invoke(EmittableLazyColumn emittableLazyColumn, GlanceModifier glanceModifier2) {
                        invoke2(emittableLazyColumn, glanceModifier2);
                        return Unit.INSTANCE;
                    }

                    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                    public final void invoke2(@NotNull EmittableLazyColumn set, @NotNull GlanceModifier it) {
                        Intrinsics.checkNotNullParameter(set, "$this$set");
                        Intrinsics.checkNotNullParameter(it, "it");
                        set.setModifier(it);
                    }
                });
                Updater.m18025setimpl(composerM18018constructorimpl2, Alignment.Horizontal.m21435boximpl(i), new Function2<EmittableLazyColumn, Alignment.Horizontal, Unit>() { // from class: androidx.glance.appwidget.lazy.LazyListKt$LazyColumn$2$2
                    @Override // kotlin.jvm.functions.Function2
                    public /* bridge */ /* synthetic */ Unit invoke(EmittableLazyColumn emittableLazyColumn, Alignment.Horizontal horizontal) {
                        m21346invokeh_Kf0XE(emittableLazyColumn, horizontal.getValue());
                        return Unit.INSTANCE;
                    }

                    /* JADX INFO: renamed from: invoke-h_Kf0XE, reason: not valid java name */
                    public final void m21346invokeh_Kf0XE(@NotNull EmittableLazyColumn set, int i7) {
                        Intrinsics.checkNotNullParameter(set, "$this$set");
                        set.m21340setHorizontalAlignmentuMT220(i7);
                    }
                });
                function2ApplyListScope2.invoke(composerStartRestartGroup, 0);
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
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.glance.appwidget.lazy.LazyListKt$LazyColumn$3
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
                    LazyListKt.m21344LazyColumnEiNPFjs(glanceModifier2, i7, content, composer2, RecomposeScopeImplKt.updateChangedFlags(i2 | 1), i4);
                }
            });
        }
    }

    @Composable
    @ExperimentalGlanceApi
    /* JADX INFO: renamed from: LazyColumn-ca5uSD8, reason: not valid java name */
    public static final void m21345LazyColumnca5uSD8(@NotNull final Bundle activityOptions, @Nullable GlanceModifier glanceModifier, int i, @NotNull final Function1<? super LazyListScope, Unit> content, @Nullable Composer composer, final int i2, final int i4) {
        int i5;
        Intrinsics.checkNotNullParameter(activityOptions, "activityOptions");
        Intrinsics.checkNotNullParameter(content, "content");
        Composer composerStartRestartGroup = composer.startRestartGroup(828768758);
        if ((i4 & 2) != 0) {
            glanceModifier = GlanceModifier.INSTANCE;
        }
        final GlanceModifier glanceModifier2 = glanceModifier;
        if ((i4 & 4) != 0) {
            i = Alignment.INSTANCE.m21433getStartPGIyAqw();
            i5 = i2 & (-897);
        } else {
            i5 = i2;
        }
        final int i6 = i;
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(828768758, i5, -1, "androidx.glance.appwidget.lazy.LazyColumn (LazyList.kt:80)");
        }
        LazyListKt$LazyColumn$4 lazyListKt$LazyColumn$4 = LazyListKt$LazyColumn$4.INSTANCE;
        Function2<Composer, Integer, Unit> function2ApplyListScope = applyListScope(new Alignment(i6, Alignment.Vertical.INSTANCE.m21453getCenterVerticallymnfRV0w(), null), content);
        if (!(AbstractC2322a.m1613c(578571862, composerStartRestartGroup, -548224868) instanceof Applier)) {
            ComposablesKt.invalidApplier();
        }
        composerStartRestartGroup.startNode();
        if (composerStartRestartGroup.getInserting()) {
            composerStartRestartGroup.createNode(lazyListKt$LazyColumn$4);
        } else {
            composerStartRestartGroup.useNode();
        }
        Composer composerM18018constructorimpl = Updater.m18018constructorimpl(composerStartRestartGroup);
        Updater.m18025setimpl(composerM18018constructorimpl, glanceModifier2, new Function2<EmittableLazyColumn, GlanceModifier, Unit>() { // from class: androidx.glance.appwidget.lazy.LazyListKt$LazyColumn$5$1
            @Override // kotlin.jvm.functions.Function2
            public /* bridge */ /* synthetic */ Unit invoke(EmittableLazyColumn emittableLazyColumn, GlanceModifier glanceModifier3) {
                invoke2(emittableLazyColumn, glanceModifier3);
                return Unit.INSTANCE;
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(@NotNull EmittableLazyColumn set, @NotNull GlanceModifier it) {
                Intrinsics.checkNotNullParameter(set, "$this$set");
                Intrinsics.checkNotNullParameter(it, "it");
                set.setModifier(it);
            }
        });
        Updater.m18025setimpl(composerM18018constructorimpl, Alignment.Horizontal.m21435boximpl(i6), new Function2<EmittableLazyColumn, Alignment.Horizontal, Unit>() { // from class: androidx.glance.appwidget.lazy.LazyListKt$LazyColumn$5$2
            @Override // kotlin.jvm.functions.Function2
            public /* bridge */ /* synthetic */ Unit invoke(EmittableLazyColumn emittableLazyColumn, Alignment.Horizontal horizontal) {
                m21347invokeh_Kf0XE(emittableLazyColumn, horizontal.getValue());
                return Unit.INSTANCE;
            }

            /* JADX INFO: renamed from: invoke-h_Kf0XE, reason: not valid java name */
            public final void m21347invokeh_Kf0XE(@NotNull EmittableLazyColumn set, int i7) {
                Intrinsics.checkNotNullParameter(set, "$this$set");
                set.m21340setHorizontalAlignmentuMT220(i7);
            }
        });
        Updater.m18025setimpl(composerM18018constructorimpl, activityOptions, new Function2<EmittableLazyColumn, Bundle, Unit>() { // from class: androidx.glance.appwidget.lazy.LazyListKt$LazyColumn$5$3
            @Override // kotlin.jvm.functions.Function2
            public /* bridge */ /* synthetic */ Unit invoke(EmittableLazyColumn emittableLazyColumn, Bundle bundle) {
                invoke2(emittableLazyColumn, bundle);
                return Unit.INSTANCE;
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(@NotNull EmittableLazyColumn set, @NotNull Bundle it) {
                Intrinsics.checkNotNullParameter(set, "$this$set");
                Intrinsics.checkNotNullParameter(it, "it");
                set.setActivityOptions(it);
            }
        });
        function2ApplyListScope.invoke(composerStartRestartGroup, 0);
        composerStartRestartGroup.endNode();
        composerStartRestartGroup.endReplaceableGroup();
        composerStartRestartGroup.endReplaceableGroup();
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.glance.appwidget.lazy.LazyListKt$LazyColumn$6
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
                    LazyListKt.m21345LazyColumnca5uSD8(activityOptions, glanceModifier2, i6, content, composer2, RecomposeScopeImplKt.updateChangedFlags(i2 | 1), i4);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    @Composable
    @ComposableInferredTarget(scheme = "[0[0]]")
    public static final void LazyListItem(final long j, final Alignment alignment, final Function2<? super Composer, ? super Integer, Unit> function2, Composer composer, final int i) {
        int i2;
        Composer composerStartRestartGroup = composer.startRestartGroup(-2015416678);
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
                ComposerKt.traceEventStart(-2015416678, i2, -1, "androidx.glance.appwidget.lazy.LazyListItem (LazyList.kt:139)");
            }
            composerStartRestartGroup.startMovableGroup(-1488189951, Long.valueOf(j));
            C29401 c29401 = C29401.INSTANCE;
            composerStartRestartGroup.startReplaceableGroup(578571862);
            int i4 = i2 & 896;
            composerStartRestartGroup.startReplaceableGroup(-548224868);
            if (!(composerStartRestartGroup.getApplier() instanceof Applier)) {
                ComposablesKt.invalidApplier();
            }
            composerStartRestartGroup.startNode();
            if (composerStartRestartGroup.getInserting()) {
                composerStartRestartGroup.createNode(c29401);
            } else {
                composerStartRestartGroup.useNode();
            }
            Composer composerM18018constructorimpl = Updater.m18018constructorimpl(composerStartRestartGroup);
            Updater.m18025setimpl(composerM18018constructorimpl, Long.valueOf(j), new Function2<EmittableLazyListItem, Long, Unit>() { // from class: androidx.glance.appwidget.lazy.LazyListKt$LazyListItem$2$1
                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Unit invoke(EmittableLazyListItem emittableLazyListItem, Long l) {
                    invoke(emittableLazyListItem, l.longValue());
                    return Unit.INSTANCE;
                }

                public final void invoke(@NotNull EmittableLazyListItem set, long j2) {
                    Intrinsics.checkNotNullParameter(set, "$this$set");
                    set.setItemId(j2);
                }
            });
            Updater.m18025setimpl(composerM18018constructorimpl, alignment, new Function2<EmittableLazyListItem, Alignment, Unit>() { // from class: androidx.glance.appwidget.lazy.LazyListKt$LazyListItem$2$2
                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Unit invoke(EmittableLazyListItem emittableLazyListItem, Alignment alignment2) {
                    invoke2(emittableLazyListItem, alignment2);
                    return Unit.INSTANCE;
                }

                /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(@NotNull EmittableLazyListItem set, @NotNull Alignment it) {
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
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.glance.appwidget.lazy.LazyListKt.LazyListItem.3
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
                    LazyListKt.LazyListItem(j, alignment, function2, composer2, RecomposeScopeImplKt.updateChangedFlags(i | 1));
                }
            });
        }
    }

    private static final Function2<Composer, Integer, Unit> applyListScope(final Alignment alignment, Function1<? super LazyListScope, Unit> function1) {
        final ArrayList arrayList = new ArrayList();
        function1.invoke(new LazyListScope() { // from class: androidx.glance.appwidget.lazy.LazyListKt$applyListScope$listScopeImpl$1
            @Override // androidx.glance.appwidget.lazy.LazyListScope
            @ComposableInferredTarget(scheme = "[0[0]]")
            public void item(long itemId, @NotNull Function3<? super LazyItemScope, ? super Composer, ? super Integer, Unit> content) {
                Intrinsics.checkNotNullParameter(content, "content");
                if (itemId != Long.MIN_VALUE && itemId <= LazyListKt.ReservedItemIdRangeEnd) {
                    throw new IllegalArgumentException("You may not specify item ids less than -4611686018427387904 in a Glance\nwidget. These are reserved.");
                }
                arrayList.add(TuplesKt.m13893to(Long.valueOf(itemId), content));
            }

            @Override // androidx.glance.appwidget.lazy.LazyListScope
            @ComposableInferredTarget(scheme = "[0[0]]")
            public void items(int count, @NotNull Function1<? super Integer, Long> itemId, @NotNull final Function4<? super LazyItemScope, ? super Integer, ? super Composer, ? super Integer, Unit> itemContent) {
                Intrinsics.checkNotNullParameter(itemId, "itemId");
                Intrinsics.checkNotNullParameter(itemContent, "itemContent");
                for (final int i = 0; i < count; i++) {
                    item(itemId.invoke(Integer.valueOf(i)).longValue(), ComposableLambdaKt.composableLambdaInstance(19676320, true, new Function3<LazyItemScope, Composer, Integer, Unit>() { // from class: androidx.glance.appwidget.lazy.LazyListKt$applyListScope$listScopeImpl$1$items$1$1
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
                                ComposerKt.traceEventStart(19676320, i2, -1, "androidx.glance.appwidget.lazy.applyListScope.<no name provided>.items.<anonymous>.<anonymous> (LazyList.kt:117)");
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
        return ComposableLambdaKt.composableLambdaInstance(1748368075, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.glance.appwidget.lazy.LazyListKt.applyListScope.1
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
                    ComposerKt.traceEventStart(1748368075, i, -1, "androidx.glance.appwidget.lazy.applyListScope.<anonymous> (LazyList.kt:123)");
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
                    LazyListKt.LazyListItem(jLongValue, alignment2, ComposableLambdaKt.composableLambda(composer, -163738694, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.glance.appwidget.lazy.LazyListKt$applyListScope$1$1$2
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
                                ComposerKt.traceEventStart(-163738694, i5, -1, "androidx.glance.appwidget.lazy.applyListScope.<anonymous>.<anonymous>.<anonymous> (LazyList.kt:128)");
                            }
                            function3.invoke(new LazyItemScope() { // from class: androidx.glance.appwidget.lazy.LazyListKt$applyListScope$1$1$2.1
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
    public static final <T> void items(@NotNull LazyListScope lazyListScope, @NotNull List<? extends T> items, @NotNull Function1<? super T, Long> itemId, @NotNull Function4<? super LazyItemScope, ? super T, ? super Composer, ? super Integer, Unit> itemContent) {
        Intrinsics.checkNotNullParameter(lazyListScope, "<this>");
        Intrinsics.checkNotNullParameter(items, "items");
        Intrinsics.checkNotNullParameter(itemId, "itemId");
        Intrinsics.checkNotNullParameter(itemContent, "itemContent");
        lazyListScope.items(items.size(), new C29452(itemId, items), ComposableLambdaKt.composableLambdaInstance(33490014, true, new C29463(itemContent, items)));
    }

    public static /* synthetic */ void items$default(LazyListScope lazyListScope, List items, Function1 itemId, Function4 itemContent, int i, Object obj) {
        if ((i & 2) != 0) {
            itemId = new Function1() { // from class: androidx.glance.appwidget.lazy.LazyListKt.items.1
                @Override // kotlin.jvm.functions.Function1
                @NotNull
                public final Long invoke(Object obj2) {
                    return Long.MIN_VALUE;
                }
            };
        }
        Intrinsics.checkNotNullParameter(lazyListScope, "<this>");
        Intrinsics.checkNotNullParameter(items, "items");
        Intrinsics.checkNotNullParameter(itemId, "itemId");
        Intrinsics.checkNotNullParameter(itemContent, "itemContent");
        lazyListScope.items(items.size(), new C29452(itemId, items), ComposableLambdaKt.composableLambdaInstance(33490014, true, new C29463(itemContent, items)));
    }

    @ComposableInferredTarget(scheme = "[0[0]]")
    public static final <T> void itemsIndexed(@NotNull LazyListScope lazyListScope, @NotNull List<? extends T> items, @NotNull Function2<? super Integer, ? super T, Long> itemId, @NotNull Function5<? super LazyItemScope, ? super Integer, ? super T, ? super Composer, ? super Integer, Unit> itemContent) {
        Intrinsics.checkNotNullParameter(lazyListScope, "<this>");
        Intrinsics.checkNotNullParameter(items, "items");
        Intrinsics.checkNotNullParameter(itemId, "itemId");
        Intrinsics.checkNotNullParameter(itemContent, "itemContent");
        lazyListScope.items(items.size(), new C29512(itemId, items), ComposableLambdaKt.composableLambdaInstance(-1405343893, true, new C29523(itemContent, items)));
    }

    public static /* synthetic */ void itemsIndexed$default(LazyListScope lazyListScope, List items, Function2 itemId, Function5 itemContent, int i, Object obj) {
        if ((i & 2) != 0) {
            itemId = new Function2() { // from class: androidx.glance.appwidget.lazy.LazyListKt.itemsIndexed.1
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
        Intrinsics.checkNotNullParameter(lazyListScope, "<this>");
        Intrinsics.checkNotNullParameter(items, "items");
        Intrinsics.checkNotNullParameter(itemId, "itemId");
        Intrinsics.checkNotNullParameter(itemContent, "itemContent");
        lazyListScope.items(items.size(), new C29512(itemId, items), ComposableLambdaKt.composableLambdaInstance(-1405343893, true, new C29523(itemContent, items)));
    }

    @ComposableInferredTarget(scheme = "[0[0]]")
    public static final <T> void items(@NotNull LazyListScope lazyListScope, @NotNull T[] items, @NotNull Function1<? super T, Long> itemId, @NotNull Function4<? super LazyItemScope, ? super T, ? super Composer, ? super Integer, Unit> itemContent) {
        Intrinsics.checkNotNullParameter(lazyListScope, "<this>");
        Intrinsics.checkNotNullParameter(items, "items");
        Intrinsics.checkNotNullParameter(itemId, "itemId");
        Intrinsics.checkNotNullParameter(itemContent, "itemContent");
        lazyListScope.items(items.length, new C29485(itemId, items), ComposableLambdaKt.composableLambdaInstance(663369809, true, new C29496(itemContent, items)));
    }

    @ComposableInferredTarget(scheme = "[0[0]]")
    public static final <T> void itemsIndexed(@NotNull LazyListScope lazyListScope, @NotNull T[] items, @NotNull Function2<? super Integer, ? super T, Long> itemId, @NotNull Function5<? super LazyItemScope, ? super Integer, ? super T, ? super Composer, ? super Integer, Unit> itemContent) {
        Intrinsics.checkNotNullParameter(lazyListScope, "<this>");
        Intrinsics.checkNotNullParameter(items, "items");
        Intrinsics.checkNotNullParameter(itemId, "itemId");
        Intrinsics.checkNotNullParameter(itemContent, "itemContent");
        lazyListScope.items(items.length, new C29545(itemId, items), ComposableLambdaKt.composableLambdaInstance(-331010528, true, new C29556(itemContent, items)));
    }

    public static /* synthetic */ void items$default(LazyListScope lazyListScope, Object[] items, Function1 itemId, Function4 itemContent, int i, Object obj) {
        if ((i & 2) != 0) {
            itemId = new Function1() { // from class: androidx.glance.appwidget.lazy.LazyListKt.items.4
                @Override // kotlin.jvm.functions.Function1
                @NotNull
                public final Long invoke(Object obj2) {
                    return Long.MIN_VALUE;
                }
            };
        }
        Intrinsics.checkNotNullParameter(lazyListScope, "<this>");
        Intrinsics.checkNotNullParameter(items, "items");
        Intrinsics.checkNotNullParameter(itemId, "itemId");
        Intrinsics.checkNotNullParameter(itemContent, "itemContent");
        lazyListScope.items(items.length, new C29485(itemId, items), ComposableLambdaKt.composableLambdaInstance(663369809, true, new C29496(itemContent, items)));
    }

    public static /* synthetic */ void itemsIndexed$default(LazyListScope lazyListScope, Object[] items, Function2 itemId, Function5 itemContent, int i, Object obj) {
        if ((i & 2) != 0) {
            itemId = new Function2() { // from class: androidx.glance.appwidget.lazy.LazyListKt.itemsIndexed.4
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
        Intrinsics.checkNotNullParameter(lazyListScope, "<this>");
        Intrinsics.checkNotNullParameter(items, "items");
        Intrinsics.checkNotNullParameter(itemId, "itemId");
        Intrinsics.checkNotNullParameter(itemContent, "itemContent");
        lazyListScope.items(items.length, new C29545(itemId, items), ComposableLambdaKt.composableLambdaInstance(-331010528, true, new C29556(itemContent, items)));
    }
}
