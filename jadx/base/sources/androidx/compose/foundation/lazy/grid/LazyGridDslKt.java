package androidx.compose.foundation.lazy.grid;

import androidx.compose.foundation.gestures.FlingBehavior;
import androidx.compose.foundation.gestures.ScrollableDefaults;
import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.PaddingValues;
import androidx.compose.p109ui.Modifier;
import androidx.compose.p109ui.unit.C2256Dp;
import androidx.compose.p109ui.unit.Constraints;
import androidx.compose.p109ui.unit.Density;
import androidx.compose.p109ui.unit.LayoutDirection;
import androidx.compose.runtime.Composable;
import androidx.compose.runtime.ComposableInferredTarget;
import androidx.compose.runtime.ComposableTarget;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import com.google.android.gms.drive.DriveFile;
import com.samsung.android.app.sdk.deepsky.textextraction.languagepack.LangPackConfigConstants;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.functions.Function4;
import kotlin.jvm.functions.Function5;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.SourceDebugExtension;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes.dex */
@Metadata(m13885d1 = {"\u0000\u0096\u0001\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010 \n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0011\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a~\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\t2\b\b\u0002\u0010\n\u001a\u00020\u000b2\b\b\u0002\u0010\f\u001a\u00020\r2\b\b\u0002\u0010\u000e\u001a\u00020\u000f2\b\b\u0002\u0010\u0010\u001a\u00020\u00112\b\b\u0002\u0010\u0012\u001a\u00020\u000b2\u0017\u0010\u0013\u001a\u0013\u0012\u0004\u0012\u00020\u0015\u0012\u0004\u0012\u00020\u00010\u0014¢\u0006\u0002\b\u0016H\u0007¢\u0006\u0002\u0010\u0017\u001a~\u0010\u0018\u001a\u00020\u00012\u0006\u0010\u0019\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\t2\b\b\u0002\u0010\n\u001a\u00020\u000b2\b\b\u0002\u0010\u000e\u001a\u00020\u000f2\b\b\u0002\u0010\f\u001a\u00020\r2\b\b\u0002\u0010\u0010\u001a\u00020\u00112\b\b\u0002\u0010\u0012\u001a\u00020\u000b2\u0017\u0010\u0013\u001a\u0013\u0012\u0004\u0012\u00020\u0015\u0012\u0004\u0012\u00020\u00010\u0014¢\u0006\u0002\b\u0016H\u0007¢\u0006\u0002\u0010\u001a\u001a&\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u001d0\u001c2\u0006\u0010\u001e\u001a\u00020\u001d2\u0006\u0010\u001f\u001a\u00020\u001d2\u0006\u0010 \u001a\u00020\u001dH\u0002\u001a%\u0010!\u001a\u00020\"2\u0006\u0010\u0019\u001a\u00020\u00032\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\b\u001a\u00020\tH\u0003¢\u0006\u0002\u0010#\u001a%\u0010$\u001a\u00020\"2\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\b\u001a\u00020\tH\u0003¢\u0006\u0002\u0010%\u001aÛ\u0001\u0010&\u001a\u00020\u0001\"\u0004\b\u0000\u0010'*\u00020\u00152\f\u0010&\u001a\b\u0012\u0004\u0012\u0002H'0(2%\b\n\u0010)\u001a\u001f\u0012\u0013\u0012\u0011H'¢\u0006\f\b*\u0012\b\b+\u0012\u0004\b\b(,\u0012\u0004\u0012\u00020-\u0018\u00010\u001420\b\n\u0010.\u001a*\u0012\u0004\u0012\u000200\u0012\u0013\u0012\u0011H'¢\u0006\f\b*\u0012\b\b+\u0012\u0004\b\b(,\u0012\u0004\u0012\u000201\u0018\u00010/¢\u0006\u0002\b\u00162%\b\n\u00102\u001a\u001f\u0012\u0013\u0012\u0011H'¢\u0006\f\b*\u0012\b\b+\u0012\u0004\b\b(,\u0012\u0006\u0012\u0004\u0018\u00010-0\u001423\b\u0004\u00103\u001a-\u0012\u0004\u0012\u000204\u0012\u0013\u0012\u0011H'¢\u0006\f\b*\u0012\b\b+\u0012\u0004\b\b(,\u0012\u0004\u0012\u00020\u00010/¢\u0006\u0002\b5¢\u0006\u0002\b\u0016H\u0086\b¢\u0006\u0002\u00106\u001aÛ\u0001\u0010&\u001a\u00020\u0001\"\u0004\b\u0000\u0010'*\u00020\u00152\f\u0010&\u001a\b\u0012\u0004\u0012\u0002H'0\u001c2%\b\n\u0010)\u001a\u001f\u0012\u0013\u0012\u0011H'¢\u0006\f\b*\u0012\b\b+\u0012\u0004\b\b(,\u0012\u0004\u0012\u00020-\u0018\u00010\u001420\b\n\u0010.\u001a*\u0012\u0004\u0012\u000200\u0012\u0013\u0012\u0011H'¢\u0006\f\b*\u0012\b\b+\u0012\u0004\b\b(,\u0012\u0004\u0012\u000201\u0018\u00010/¢\u0006\u0002\b\u00162%\b\n\u00102\u001a\u001f\u0012\u0013\u0012\u0011H'¢\u0006\f\b*\u0012\b\b+\u0012\u0004\b\b(,\u0012\u0006\u0012\u0004\u0018\u00010-0\u001423\b\u0004\u00103\u001a-\u0012\u0004\u0012\u000204\u0012\u0013\u0012\u0011H'¢\u0006\f\b*\u0012\b\b+\u0012\u0004\b\b(,\u0012\u0004\u0012\u00020\u00010/¢\u0006\u0002\b5¢\u0006\u0002\b\u0016H\u0086\b¢\u0006\u0002\u00107\u001a¯\u0002\u00108\u001a\u00020\u0001\"\u0004\b\u0000\u0010'*\u00020\u00152\f\u0010&\u001a\b\u0012\u0004\u0012\u0002H'0(2:\b\n\u0010)\u001a4\u0012\u0013\u0012\u00110\u001d¢\u0006\f\b*\u0012\b\b+\u0012\u0004\b\b(9\u0012\u0013\u0012\u0011H'¢\u0006\f\b*\u0012\b\b+\u0012\u0004\b\b(,\u0012\u0004\u0012\u00020-\u0018\u00010/2E\b\n\u0010.\u001a?\u0012\u0004\u0012\u000200\u0012\u0013\u0012\u00110\u001d¢\u0006\f\b*\u0012\b\b+\u0012\u0004\b\b(9\u0012\u0013\u0012\u0011H'¢\u0006\f\b*\u0012\b\b+\u0012\u0004\b\b(,\u0012\u0004\u0012\u000201\u0018\u00010:¢\u0006\u0002\b\u00162:\b\u0006\u00102\u001a4\u0012\u0013\u0012\u00110\u001d¢\u0006\f\b*\u0012\b\b+\u0012\u0004\b\b(9\u0012\u0013\u0012\u0011H'¢\u0006\f\b*\u0012\b\b+\u0012\u0004\b\b(,\u0012\u0006\u0012\u0004\u0018\u00010-0/2H\b\u0004\u00103\u001aB\u0012\u0004\u0012\u000204\u0012\u0013\u0012\u00110\u001d¢\u0006\f\b*\u0012\b\b+\u0012\u0004\b\b(9\u0012\u0013\u0012\u0011H'¢\u0006\f\b*\u0012\b\b+\u0012\u0004\b\b(,\u0012\u0004\u0012\u00020\u00010:¢\u0006\u0002\b5¢\u0006\u0002\b\u0016H\u0086\b¢\u0006\u0002\u0010;\u001a¯\u0002\u00108\u001a\u00020\u0001\"\u0004\b\u0000\u0010'*\u00020\u00152\f\u0010&\u001a\b\u0012\u0004\u0012\u0002H'0\u001c2:\b\n\u0010)\u001a4\u0012\u0013\u0012\u00110\u001d¢\u0006\f\b*\u0012\b\b+\u0012\u0004\b\b(9\u0012\u0013\u0012\u0011H'¢\u0006\f\b*\u0012\b\b+\u0012\u0004\b\b(,\u0012\u0004\u0012\u00020-\u0018\u00010/2E\b\n\u0010.\u001a?\u0012\u0004\u0012\u000200\u0012\u0013\u0012\u00110\u001d¢\u0006\f\b*\u0012\b\b+\u0012\u0004\b\b(9\u0012\u0013\u0012\u0011H'¢\u0006\f\b*\u0012\b\b+\u0012\u0004\b\b(,\u0012\u0004\u0012\u000201\u0018\u00010:¢\u0006\u0002\b\u00162:\b\u0006\u00102\u001a4\u0012\u0013\u0012\u00110\u001d¢\u0006\f\b*\u0012\b\b+\u0012\u0004\b\b(9\u0012\u0013\u0012\u0011H'¢\u0006\f\b*\u0012\b\b+\u0012\u0004\b\b(,\u0012\u0006\u0012\u0004\u0018\u00010-0/2H\b\u0004\u00103\u001aB\u0012\u0004\u0012\u000204\u0012\u0013\u0012\u00110\u001d¢\u0006\f\b*\u0012\b\b+\u0012\u0004\b\b(9\u0012\u0013\u0012\u0011H'¢\u0006\f\b*\u0012\b\b+\u0012\u0004\b\b(,\u0012\u0004\u0012\u00020\u00010:¢\u0006\u0002\b5¢\u0006\u0002\b\u0016H\u0086\b¢\u0006\u0002\u0010<¨\u0006="}, m13886d2 = {"LazyHorizontalGrid", "", "rows", "Landroidx/compose/foundation/lazy/grid/GridCells;", "modifier", "Landroidx/compose/ui/Modifier;", "state", "Landroidx/compose/foundation/lazy/grid/LazyGridState;", "contentPadding", "Landroidx/compose/foundation/layout/PaddingValues;", "reverseLayout", "", "horizontalArrangement", "Landroidx/compose/foundation/layout/Arrangement$Horizontal;", "verticalArrangement", "Landroidx/compose/foundation/layout/Arrangement$Vertical;", "flingBehavior", "Landroidx/compose/foundation/gestures/FlingBehavior;", "userScrollEnabled", "content", "Lkotlin/Function1;", "Landroidx/compose/foundation/lazy/grid/LazyGridScope;", "Lkotlin/ExtensionFunctionType;", "(Landroidx/compose/foundation/lazy/grid/GridCells;Landroidx/compose/ui/Modifier;Landroidx/compose/foundation/lazy/grid/LazyGridState;Landroidx/compose/foundation/layout/PaddingValues;ZLandroidx/compose/foundation/layout/Arrangement$Horizontal;Landroidx/compose/foundation/layout/Arrangement$Vertical;Landroidx/compose/foundation/gestures/FlingBehavior;ZLkotlin/jvm/functions/Function1;Landroidx/compose/runtime/Composer;II)V", "LazyVerticalGrid", "columns", "(Landroidx/compose/foundation/lazy/grid/GridCells;Landroidx/compose/ui/Modifier;Landroidx/compose/foundation/lazy/grid/LazyGridState;Landroidx/compose/foundation/layout/PaddingValues;ZLandroidx/compose/foundation/layout/Arrangement$Vertical;Landroidx/compose/foundation/layout/Arrangement$Horizontal;Landroidx/compose/foundation/gestures/FlingBehavior;ZLkotlin/jvm/functions/Function1;Landroidx/compose/runtime/Composer;II)V", "calculateCellsCrossAxisSizeImpl", "", "", "gridSize", "slotCount", "spacing", "rememberColumnWidthSums", "Landroidx/compose/foundation/lazy/grid/LazyGridSlotsProvider;", "(Landroidx/compose/foundation/lazy/grid/GridCells;Landroidx/compose/foundation/layout/Arrangement$Horizontal;Landroidx/compose/foundation/layout/PaddingValues;Landroidx/compose/runtime/Composer;I)Landroidx/compose/foundation/lazy/grid/LazyGridSlotsProvider;", "rememberRowHeightSums", "(Landroidx/compose/foundation/lazy/grid/GridCells;Landroidx/compose/foundation/layout/Arrangement$Vertical;Landroidx/compose/foundation/layout/PaddingValues;Landroidx/compose/runtime/Composer;I)Landroidx/compose/foundation/lazy/grid/LazyGridSlotsProvider;", "items", "T", "", "key", "Lkotlin/ParameterName;", "name", "item", "", "span", "Lkotlin/Function2;", "Landroidx/compose/foundation/lazy/grid/LazyGridItemSpanScope;", "Landroidx/compose/foundation/lazy/grid/GridItemSpan;", "contentType", "itemContent", "Landroidx/compose/foundation/lazy/grid/LazyGridItemScope;", "Landroidx/compose/runtime/Composable;", "(Landroidx/compose/foundation/lazy/grid/LazyGridScope;[Ljava/lang/Object;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function4;)V", "(Landroidx/compose/foundation/lazy/grid/LazyGridScope;Ljava/util/List;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function4;)V", "itemsIndexed", "index", "Lkotlin/Function3;", "(Landroidx/compose/foundation/lazy/grid/LazyGridScope;[Ljava/lang/Object;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function3;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function5;)V", "(Landroidx/compose/foundation/lazy/grid/LazyGridScope;Ljava/util/List;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function3;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function5;)V", "foundation_release"}, m13887k = 2, m13888mv = {1, 8, 0}, m13890xi = 48)
@SourceDebugExtension({"SMAP\nLazyGridDsl.kt\nKotlin\n*S Kotlin\n*F\n+ 1 LazyGridDsl.kt\nandroidx/compose/foundation/lazy/grid/LazyGridDslKt\n+ 2 Dp.kt\nandroidx/compose/ui/unit/DpKt\n+ 3 Composer.kt\nandroidx/compose/runtime/ComposerKt\n*L\n1#1,569:1\n149#2:570\n149#2:571\n1225#3,6:572\n1225#3,6:578\n*S KotlinDebug\n*F\n+ 1 LazyGridDsl.kt\nandroidx/compose/foundation/lazy/grid/LazyGridDslKt\n*L\n66#1:570\n119#1:571\n149#1:572,6\n182#1:578,6\n*E\n"})
public final class LazyGridDslKt {

    /* JADX INFO: renamed from: androidx.compose.foundation.lazy.grid.LazyGridDslKt$items$10 */
    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000\u0016\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u000b¢\u0006\u0004\b\u0006\u0010\u0007"}, m13886d2 = {"<anonymous>", "", "T", "Landroidx/compose/foundation/lazy/grid/LazyGridItemScope;", LangPackConfigConstants.LANGUAGE_CODE_IT, "", "invoke", "(Landroidx/compose/foundation/lazy/grid/LazyGridItemScope;ILandroidx/compose/runtime/Composer;I)V"}, m13887k = 3, m13888mv = {1, 8, 0}, m13890xi = 176)
    @SourceDebugExtension({"SMAP\nLazyGridDsl.kt\nKotlin\n*S Kotlin\n*F\n+ 1 LazyGridDsl.kt\nandroidx/compose/foundation/lazy/grid/LazyGridDslKt$items$10\n*L\n1#1,569:1\n*E\n"})
    public static final class C107810 extends Lambda implements Function4<LazyGridItemScope, Integer, Composer, Integer, Unit> {
        final /* synthetic */ Function4<LazyGridItemScope, T, Composer, Integer, Unit> $itemContent;
        final /* synthetic */ T[] $items;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        public C107810(Function4<? super LazyGridItemScope, ? super T, ? super Composer, ? super Integer, Unit> function4, T[] tArr) {
            super(4);
            this.$itemContent = function4;
            this.$items = tArr;
        }

        @Override // kotlin.jvm.functions.Function4
        public /* bridge */ /* synthetic */ Unit invoke(LazyGridItemScope lazyGridItemScope, Integer num, Composer composer, Integer num2) {
            invoke(lazyGridItemScope, num.intValue(), composer, num2.intValue());
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
        public final void invoke(@NotNull LazyGridItemScope lazyGridItemScope, int i, @Nullable Composer composer, int i2) {
            int i4;
            if ((i2 & 6) == 0) {
                i4 = (composer.changed(lazyGridItemScope) ? 4 : 2) | i2;
            } else {
                i4 = i2;
            }
            if ((i2 & 48) == 0) {
                i4 |= composer.changed(i) ? 32 : 16;
            }
            if ((i4 & 147) == 146 && composer.getSkipping()) {
                composer.skipToGroupEnd();
                return;
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(407562193, i4, -1, "androidx.compose.foundation.lazy.grid.items.<anonymous> (LazyGridDsl.kt:532)");
            }
            this.$itemContent.invoke(lazyGridItemScope, this.$items[i], composer, Integer.valueOf(i4 & 14));
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
    }

    /* JADX INFO: renamed from: androidx.compose.foundation.lazy.grid.LazyGridDslKt$items$2 */
    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u00022\u0006\u0010\u0003\u001a\u00020\u0004H\n¢\u0006\u0002\b\u0005"}, m13886d2 = {"<anonymous>", "", "T", "index", "", "invoke"}, m13887k = 3, m13888mv = {1, 8, 0}, m13890xi = 176)
    @SourceDebugExtension({"SMAP\nLazyGridDsl.kt\nKotlin\n*S Kotlin\n*F\n+ 1 LazyGridDsl.kt\nandroidx/compose/foundation/lazy/grid/LazyGridDslKt$items$2\n*L\n1#1,569:1\n*E\n"})
    public static final class C10792 extends Lambda implements Function1<Integer, Object> {
        final /* synthetic */ List<T> $items;
        final /* synthetic */ Function1<T, Object> $key;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        public C10792(Function1<? super T, ? extends Object> function1, List<? extends T> list) {
            super(1);
            this.$key = function1;
            this.$items = list;
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Object invoke(Integer num) {
            return invoke(num.intValue());
        }

        /* JADX WARN: Type inference incomplete: some casts might be missing */
        @NotNull
        public final Object invoke(int i) {
            return this.$key.invoke((T) this.$items.get(i));
        }
    }

    /* JADX INFO: renamed from: androidx.compose.foundation.lazy.grid.LazyGridDslKt$items$3 */
    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000\u0016\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\n¢\u0006\u0004\b\u0006\u0010\u0007"}, m13886d2 = {"<anonymous>", "Landroidx/compose/foundation/lazy/grid/GridItemSpan;", "T", "Landroidx/compose/foundation/lazy/grid/LazyGridItemSpanScope;", LangPackConfigConstants.LANGUAGE_CODE_IT, "", "invoke-_-orMbw", "(Landroidx/compose/foundation/lazy/grid/LazyGridItemSpanScope;I)J"}, m13887k = 3, m13888mv = {1, 8, 0}, m13890xi = 176)
    @SourceDebugExtension({"SMAP\nLazyGridDsl.kt\nKotlin\n*S Kotlin\n*F\n+ 1 LazyGridDsl.kt\nandroidx/compose/foundation/lazy/grid/LazyGridDslKt$items$3\n*L\n1#1,569:1\n*E\n"})
    public static final class C10803 extends Lambda implements Function2<LazyGridItemSpanScope, Integer, GridItemSpan> {
        final /* synthetic */ List<T> $items;
        final /* synthetic */ Function2<LazyGridItemSpanScope, T, GridItemSpan> $span;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        public C10803(Function2<? super LazyGridItemSpanScope, ? super T, GridItemSpan> function2, List<? extends T> list) {
            super(2);
            this.$span = function2;
            this.$items = list;
        }

        @Override // kotlin.jvm.functions.Function2
        public /* bridge */ /* synthetic */ GridItemSpan invoke(LazyGridItemSpanScope lazyGridItemSpanScope, Integer num) {
            return GridItemSpan.m15973boximpl(m15982invoke_orMbw(lazyGridItemSpanScope, num.intValue()));
        }

        /* JADX WARN: Type inference incomplete: some casts might be missing */
        /* JADX INFO: renamed from: invoke-_-orMbw, reason: not valid java name */
        public final long m15982invoke_orMbw(@NotNull LazyGridItemSpanScope lazyGridItemSpanScope, int i) {
            return this.$span.invoke(lazyGridItemSpanScope, (T) this.$items.get(i)).getPackedValue();
        }
    }

    /* JADX INFO: renamed from: androidx.compose.foundation.lazy.grid.LazyGridDslKt$items$4 */
    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\u0010\u0000\u001a\u0004\u0018\u00010\u0001\"\u0004\b\u0000\u0010\u00022\u0006\u0010\u0003\u001a\u00020\u0004H\n¢\u0006\u0002\b\u0005"}, m13886d2 = {"<anonymous>", "", "T", "index", "", "invoke"}, m13887k = 3, m13888mv = {1, 8, 0}, m13890xi = 176)
    @SourceDebugExtension({"SMAP\nLazyGridDsl.kt\nKotlin\n*S Kotlin\n*F\n+ 1 LazyGridDsl.kt\nandroidx/compose/foundation/lazy/grid/LazyGridDslKt$items$4\n*L\n1#1,569:1\n*E\n"})
    public static final class C10814 extends Lambda implements Function1<Integer, Object> {
        final /* synthetic */ Function1<T, Object> $contentType;
        final /* synthetic */ List<T> $items;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        public C10814(Function1<? super T, ? extends Object> function1, List<? extends T> list) {
            super(1);
            this.$contentType = function1;
            this.$items = list;
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Object invoke(Integer num) {
            return invoke(num.intValue());
        }

        /* JADX WARN: Type inference incomplete: some casts might be missing */
        @Nullable
        public final Object invoke(int i) {
            return this.$contentType.invoke((T) this.$items.get(i));
        }
    }

    /* JADX INFO: renamed from: androidx.compose.foundation.lazy.grid.LazyGridDslKt$items$5 */
    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000\u0016\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u000b¢\u0006\u0004\b\u0006\u0010\u0007"}, m13886d2 = {"<anonymous>", "", "T", "Landroidx/compose/foundation/lazy/grid/LazyGridItemScope;", LangPackConfigConstants.LANGUAGE_CODE_IT, "", "invoke", "(Landroidx/compose/foundation/lazy/grid/LazyGridItemScope;ILandroidx/compose/runtime/Composer;I)V"}, m13887k = 3, m13888mv = {1, 8, 0}, m13890xi = 176)
    @SourceDebugExtension({"SMAP\nLazyGridDsl.kt\nKotlin\n*S Kotlin\n*F\n+ 1 LazyGridDsl.kt\nandroidx/compose/foundation/lazy/grid/LazyGridDslKt$items$5\n*L\n1#1,569:1\n*E\n"})
    public static final class C10825 extends Lambda implements Function4<LazyGridItemScope, Integer, Composer, Integer, Unit> {
        final /* synthetic */ Function4<LazyGridItemScope, T, Composer, Integer, Unit> $itemContent;
        final /* synthetic */ List<T> $items;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        public C10825(Function4<? super LazyGridItemScope, ? super T, ? super Composer, ? super Integer, Unit> function4, List<? extends T> list) {
            super(4);
            this.$itemContent = function4;
            this.$items = list;
        }

        @Override // kotlin.jvm.functions.Function4
        public /* bridge */ /* synthetic */ Unit invoke(LazyGridItemScope lazyGridItemScope, Integer num, Composer composer, Integer num2) {
            invoke(lazyGridItemScope, num.intValue(), composer, num2.intValue());
            return Unit.INSTANCE;
        }

        /* JADX WARN: Type inference incomplete: some casts might be missing */
        @Composable
        public final void invoke(@NotNull LazyGridItemScope lazyGridItemScope, int i, @Nullable Composer composer, int i2) {
            int i4;
            if ((i2 & 6) == 0) {
                i4 = (composer.changed(lazyGridItemScope) ? 4 : 2) | i2;
            } else {
                i4 = i2;
            }
            if ((i2 & 48) == 0) {
                i4 |= composer.changed(i) ? 32 : 16;
            }
            if ((i4 & 147) == 146 && composer.getSkipping()) {
                composer.skipToGroupEnd();
                return;
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(699646206, i4, -1, "androidx.compose.foundation.lazy.grid.items.<anonymous> (LazyGridDsl.kt:464)");
            }
            this.$itemContent.invoke(lazyGridItemScope, (T) this.$items.get(i), composer, Integer.valueOf(i4 & 14));
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
    }

    /* JADX INFO: renamed from: androidx.compose.foundation.lazy.grid.LazyGridDslKt$items$7 */
    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u00022\u0006\u0010\u0003\u001a\u00020\u0004H\n¢\u0006\u0002\b\u0005"}, m13886d2 = {"<anonymous>", "", "T", "index", "", "invoke"}, m13887k = 3, m13888mv = {1, 8, 0}, m13890xi = 176)
    @SourceDebugExtension({"SMAP\nLazyGridDsl.kt\nKotlin\n*S Kotlin\n*F\n+ 1 LazyGridDsl.kt\nandroidx/compose/foundation/lazy/grid/LazyGridDslKt$items$7\n*L\n1#1,569:1\n*E\n"})
    public static final class C10847 extends Lambda implements Function1<Integer, Object> {
        final /* synthetic */ T[] $items;
        final /* synthetic */ Function1<T, Object> $key;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        public C10847(Function1<? super T, ? extends Object> function1, T[] tArr) {
            super(1);
            this.$key = function1;
            this.$items = tArr;
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Object invoke(Integer num) {
            return invoke(num.intValue());
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
        public final Object invoke(int i) {
            return this.$key.invoke(this.$items[i]);
        }
    }

    /* JADX INFO: renamed from: androidx.compose.foundation.lazy.grid.LazyGridDslKt$items$8 */
    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000\u0016\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\n¢\u0006\u0004\b\u0006\u0010\u0007"}, m13886d2 = {"<anonymous>", "Landroidx/compose/foundation/lazy/grid/GridItemSpan;", "T", "Landroidx/compose/foundation/lazy/grid/LazyGridItemSpanScope;", LangPackConfigConstants.LANGUAGE_CODE_IT, "", "invoke-_-orMbw", "(Landroidx/compose/foundation/lazy/grid/LazyGridItemSpanScope;I)J"}, m13887k = 3, m13888mv = {1, 8, 0}, m13890xi = 176)
    @SourceDebugExtension({"SMAP\nLazyGridDsl.kt\nKotlin\n*S Kotlin\n*F\n+ 1 LazyGridDsl.kt\nandroidx/compose/foundation/lazy/grid/LazyGridDslKt$items$8\n*L\n1#1,569:1\n*E\n"})
    public static final class C10858 extends Lambda implements Function2<LazyGridItemSpanScope, Integer, GridItemSpan> {
        final /* synthetic */ T[] $items;
        final /* synthetic */ Function2<LazyGridItemSpanScope, T, GridItemSpan> $span;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        public C10858(Function2<? super LazyGridItemSpanScope, ? super T, GridItemSpan> function2, T[] tArr) {
            super(2);
            this.$span = function2;
            this.$items = tArr;
        }

        @Override // kotlin.jvm.functions.Function2
        public /* bridge */ /* synthetic */ GridItemSpan invoke(LazyGridItemSpanScope lazyGridItemSpanScope, Integer num) {
            return GridItemSpan.m15973boximpl(m15983invoke_orMbw(lazyGridItemSpanScope, num.intValue()));
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
        /* JADX INFO: renamed from: invoke-_-orMbw, reason: not valid java name */
        public final long m15983invoke_orMbw(@NotNull LazyGridItemSpanScope lazyGridItemSpanScope, int i) {
            return this.$span.invoke(lazyGridItemSpanScope, this.$items[i]).getPackedValue();
        }
    }

    /* JADX INFO: renamed from: androidx.compose.foundation.lazy.grid.LazyGridDslKt$items$9 */
    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\u0010\u0000\u001a\u0004\u0018\u00010\u0001\"\u0004\b\u0000\u0010\u00022\u0006\u0010\u0003\u001a\u00020\u0004H\n¢\u0006\u0002\b\u0005"}, m13886d2 = {"<anonymous>", "", "T", "index", "", "invoke"}, m13887k = 3, m13888mv = {1, 8, 0}, m13890xi = 176)
    @SourceDebugExtension({"SMAP\nLazyGridDsl.kt\nKotlin\n*S Kotlin\n*F\n+ 1 LazyGridDsl.kt\nandroidx/compose/foundation/lazy/grid/LazyGridDslKt$items$9\n*L\n1#1,569:1\n*E\n"})
    public static final class C10869 extends Lambda implements Function1<Integer, Object> {
        final /* synthetic */ Function1<T, Object> $contentType;
        final /* synthetic */ T[] $items;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        public C10869(Function1<? super T, ? extends Object> function1, T[] tArr) {
            super(1);
            this.$contentType = function1;
            this.$items = tArr;
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Object invoke(Integer num) {
            return invoke(num.intValue());
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
        @Nullable
        public final Object invoke(int i) {
            return this.$contentType.invoke(this.$items[i]);
        }
    }

    /* JADX INFO: renamed from: androidx.compose.foundation.lazy.grid.LazyGridDslKt$itemsIndexed$10 */
    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000\u0016\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u000b¢\u0006\u0004\b\u0006\u0010\u0007"}, m13886d2 = {"<anonymous>", "", "T", "Landroidx/compose/foundation/lazy/grid/LazyGridItemScope;", LangPackConfigConstants.LANGUAGE_CODE_IT, "", "invoke", "(Landroidx/compose/foundation/lazy/grid/LazyGridItemScope;ILandroidx/compose/runtime/Composer;I)V"}, m13887k = 3, m13888mv = {1, 8, 0}, m13890xi = 176)
    @SourceDebugExtension({"SMAP\nLazyGridDsl.kt\nKotlin\n*S Kotlin\n*F\n+ 1 LazyGridDsl.kt\nandroidx/compose/foundation/lazy/grid/LazyGridDslKt$itemsIndexed$10\n*L\n1#1,569:1\n*E\n"})
    public static final class C108810 extends Lambda implements Function4<LazyGridItemScope, Integer, Composer, Integer, Unit> {
        final /* synthetic */ Function5<LazyGridItemScope, Integer, T, Composer, Integer, Unit> $itemContent;
        final /* synthetic */ T[] $items;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        public C108810(Function5<? super LazyGridItemScope, ? super Integer, ? super T, ? super Composer, ? super Integer, Unit> function5, T[] tArr) {
            super(4);
            this.$itemContent = function5;
            this.$items = tArr;
        }

        @Override // kotlin.jvm.functions.Function4
        public /* bridge */ /* synthetic */ Unit invoke(LazyGridItemScope lazyGridItemScope, Integer num, Composer composer, Integer num2) {
            invoke(lazyGridItemScope, num.intValue(), composer, num2.intValue());
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
        public final void invoke(@NotNull LazyGridItemScope lazyGridItemScope, int i, @Nullable Composer composer, int i2) {
            int i4;
            if ((i2 & 6) == 0) {
                i4 = (composer.changed(lazyGridItemScope) ? 4 : 2) | i2;
            } else {
                i4 = i2;
            }
            if ((i2 & 48) == 0) {
                i4 |= composer.changed(i) ? 32 : 16;
            }
            if ((i4 & 147) == 146 && composer.getSkipping()) {
                composer.skipToGroupEnd();
                return;
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-911455938, i4, -1, "androidx.compose.foundation.lazy.grid.itemsIndexed.<anonymous> (LazyGridDsl.kt:566)");
            }
            this.$itemContent.invoke(lazyGridItemScope, Integer.valueOf(i), this.$items[i], composer, Integer.valueOf(i4 & 126));
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
    }

    /* JADX INFO: renamed from: androidx.compose.foundation.lazy.grid.LazyGridDslKt$itemsIndexed$2 */
    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u00022\u0006\u0010\u0003\u001a\u00020\u0004H\n¢\u0006\u0002\b\u0005"}, m13886d2 = {"<anonymous>", "", "T", "index", "", "invoke"}, m13887k = 3, m13888mv = {1, 8, 0}, m13890xi = 176)
    @SourceDebugExtension({"SMAP\nLazyGridDsl.kt\nKotlin\n*S Kotlin\n*F\n+ 1 LazyGridDsl.kt\nandroidx/compose/foundation/lazy/grid/LazyGridDslKt$itemsIndexed$2\n*L\n1#1,569:1\n*E\n"})
    public static final class C10892 extends Lambda implements Function1<Integer, Object> {
        final /* synthetic */ List<T> $items;
        final /* synthetic */ Function2<Integer, T, Object> $key;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        public C10892(Function2<? super Integer, ? super T, ? extends Object> function2, List<? extends T> list) {
            super(1);
            this.$key = function2;
            this.$items = list;
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Object invoke(Integer num) {
            return invoke(num.intValue());
        }

        /* JADX WARN: Type inference incomplete: some casts might be missing */
        @NotNull
        public final Object invoke(int i) {
            return this.$key.invoke(Integer.valueOf(i), (T) this.$items.get(i));
        }
    }

    /* JADX INFO: renamed from: androidx.compose.foundation.lazy.grid.LazyGridDslKt$itemsIndexed$3 */
    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000\u0016\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\n¢\u0006\u0004\b\u0006\u0010\u0007"}, m13886d2 = {"<anonymous>", "Landroidx/compose/foundation/lazy/grid/GridItemSpan;", "T", "Landroidx/compose/foundation/lazy/grid/LazyGridItemSpanScope;", LangPackConfigConstants.LANGUAGE_CODE_IT, "", "invoke-_-orMbw", "(Landroidx/compose/foundation/lazy/grid/LazyGridItemSpanScope;I)J"}, m13887k = 3, m13888mv = {1, 8, 0}, m13890xi = 176)
    @SourceDebugExtension({"SMAP\nLazyGridDsl.kt\nKotlin\n*S Kotlin\n*F\n+ 1 LazyGridDsl.kt\nandroidx/compose/foundation/lazy/grid/LazyGridDslKt$itemsIndexed$3\n*L\n1#1,569:1\n*E\n"})
    public static final class C10903 extends Lambda implements Function2<LazyGridItemSpanScope, Integer, GridItemSpan> {
        final /* synthetic */ List<T> $items;
        final /* synthetic */ Function3<LazyGridItemSpanScope, Integer, T, GridItemSpan> $span;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        public C10903(Function3<? super LazyGridItemSpanScope, ? super Integer, ? super T, GridItemSpan> function3, List<? extends T> list) {
            super(2);
            this.$span = function3;
            this.$items = list;
        }

        @Override // kotlin.jvm.functions.Function2
        public /* bridge */ /* synthetic */ GridItemSpan invoke(LazyGridItemSpanScope lazyGridItemSpanScope, Integer num) {
            return GridItemSpan.m15973boximpl(m15984invoke_orMbw(lazyGridItemSpanScope, num.intValue()));
        }

        /* JADX WARN: Type inference incomplete: some casts might be missing */
        /* JADX INFO: renamed from: invoke-_-orMbw, reason: not valid java name */
        public final long m15984invoke_orMbw(@NotNull LazyGridItemSpanScope lazyGridItemSpanScope, int i) {
            return this.$span.invoke(lazyGridItemSpanScope, Integer.valueOf(i), (T) this.$items.get(i)).getPackedValue();
        }
    }

    /* JADX INFO: renamed from: androidx.compose.foundation.lazy.grid.LazyGridDslKt$itemsIndexed$4 */
    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\u0010\u0000\u001a\u0004\u0018\u00010\u0001\"\u0004\b\u0000\u0010\u00022\u0006\u0010\u0003\u001a\u00020\u0004H\n¢\u0006\u0002\b\u0005"}, m13886d2 = {"<anonymous>", "", "T", "index", "", "invoke"}, m13887k = 3, m13888mv = {1, 8, 0}, m13890xi = 176)
    @SourceDebugExtension({"SMAP\nLazyGridDsl.kt\nKotlin\n*S Kotlin\n*F\n+ 1 LazyGridDsl.kt\nandroidx/compose/foundation/lazy/grid/LazyGridDslKt$itemsIndexed$4\n*L\n1#1,569:1\n*E\n"})
    public static final class C10914 extends Lambda implements Function1<Integer, Object> {
        final /* synthetic */ Function2<Integer, T, Object> $contentType;
        final /* synthetic */ List<T> $items;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        public C10914(Function2<? super Integer, ? super T, ? extends Object> function2, List<? extends T> list) {
            super(1);
            this.$contentType = function2;
            this.$items = list;
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Object invoke(Integer num) {
            return invoke(num.intValue());
        }

        /* JADX WARN: Type inference incomplete: some casts might be missing */
        @Nullable
        public final Object invoke(int i) {
            return this.$contentType.invoke(Integer.valueOf(i), (T) this.$items.get(i));
        }
    }

    /* JADX INFO: renamed from: androidx.compose.foundation.lazy.grid.LazyGridDslKt$itemsIndexed$5 */
    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000\u0016\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u000b¢\u0006\u0004\b\u0006\u0010\u0007"}, m13886d2 = {"<anonymous>", "", "T", "Landroidx/compose/foundation/lazy/grid/LazyGridItemScope;", LangPackConfigConstants.LANGUAGE_CODE_IT, "", "invoke", "(Landroidx/compose/foundation/lazy/grid/LazyGridItemScope;ILandroidx/compose/runtime/Composer;I)V"}, m13887k = 3, m13888mv = {1, 8, 0}, m13890xi = 176)
    @SourceDebugExtension({"SMAP\nLazyGridDsl.kt\nKotlin\n*S Kotlin\n*F\n+ 1 LazyGridDsl.kt\nandroidx/compose/foundation/lazy/grid/LazyGridDslKt$itemsIndexed$5\n*L\n1#1,569:1\n*E\n"})
    public static final class C10925 extends Lambda implements Function4<LazyGridItemScope, Integer, Composer, Integer, Unit> {
        final /* synthetic */ Function5<LazyGridItemScope, Integer, T, Composer, Integer, Unit> $itemContent;
        final /* synthetic */ List<T> $items;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        public C10925(Function5<? super LazyGridItemScope, ? super Integer, ? super T, ? super Composer, ? super Integer, Unit> function5, List<? extends T> list) {
            super(4);
            this.$itemContent = function5;
            this.$items = list;
        }

        @Override // kotlin.jvm.functions.Function4
        public /* bridge */ /* synthetic */ Unit invoke(LazyGridItemScope lazyGridItemScope, Integer num, Composer composer, Integer num2) {
            invoke(lazyGridItemScope, num.intValue(), composer, num2.intValue());
            return Unit.INSTANCE;
        }

        /* JADX WARN: Type inference incomplete: some casts might be missing */
        @Composable
        public final void invoke(@NotNull LazyGridItemScope lazyGridItemScope, int i, @Nullable Composer composer, int i2) {
            int i4;
            if ((i2 & 6) == 0) {
                i4 = (composer.changed(lazyGridItemScope) ? 4 : 2) | i2;
            } else {
                i4 = i2;
            }
            if ((i2 & 48) == 0) {
                i4 |= composer.changed(i) ? 32 : 16;
            }
            if ((i4 & 147) == 146 && composer.getSkipping()) {
                composer.skipToGroupEnd();
                return;
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1229287273, i4, -1, "androidx.compose.foundation.lazy.grid.itemsIndexed.<anonymous> (LazyGridDsl.kt:498)");
            }
            this.$itemContent.invoke(lazyGridItemScope, Integer.valueOf(i), (T) this.$items.get(i), composer, Integer.valueOf(i4 & 126));
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
    }

    /* JADX INFO: renamed from: androidx.compose.foundation.lazy.grid.LazyGridDslKt$itemsIndexed$7 */
    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u00022\u0006\u0010\u0003\u001a\u00020\u0004H\n¢\u0006\u0002\b\u0005"}, m13886d2 = {"<anonymous>", "", "T", "index", "", "invoke"}, m13887k = 3, m13888mv = {1, 8, 0}, m13890xi = 176)
    @SourceDebugExtension({"SMAP\nLazyGridDsl.kt\nKotlin\n*S Kotlin\n*F\n+ 1 LazyGridDsl.kt\nandroidx/compose/foundation/lazy/grid/LazyGridDslKt$itemsIndexed$7\n*L\n1#1,569:1\n*E\n"})
    public static final class C10947 extends Lambda implements Function1<Integer, Object> {
        final /* synthetic */ T[] $items;
        final /* synthetic */ Function2<Integer, T, Object> $key;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        public C10947(Function2<? super Integer, ? super T, ? extends Object> function2, T[] tArr) {
            super(1);
            this.$key = function2;
            this.$items = tArr;
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Object invoke(Integer num) {
            return invoke(num.intValue());
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
        public final Object invoke(int i) {
            return this.$key.invoke(Integer.valueOf(i), this.$items[i]);
        }
    }

    /* JADX INFO: renamed from: androidx.compose.foundation.lazy.grid.LazyGridDslKt$itemsIndexed$8 */
    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000\u0016\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\n¢\u0006\u0004\b\u0006\u0010\u0007"}, m13886d2 = {"<anonymous>", "Landroidx/compose/foundation/lazy/grid/GridItemSpan;", "T", "Landroidx/compose/foundation/lazy/grid/LazyGridItemSpanScope;", LangPackConfigConstants.LANGUAGE_CODE_IT, "", "invoke-_-orMbw", "(Landroidx/compose/foundation/lazy/grid/LazyGridItemSpanScope;I)J"}, m13887k = 3, m13888mv = {1, 8, 0}, m13890xi = 176)
    @SourceDebugExtension({"SMAP\nLazyGridDsl.kt\nKotlin\n*S Kotlin\n*F\n+ 1 LazyGridDsl.kt\nandroidx/compose/foundation/lazy/grid/LazyGridDslKt$itemsIndexed$8\n*L\n1#1,569:1\n*E\n"})
    public static final class C10958 extends Lambda implements Function2<LazyGridItemSpanScope, Integer, GridItemSpan> {
        final /* synthetic */ T[] $items;
        final /* synthetic */ Function3<LazyGridItemSpanScope, Integer, T, GridItemSpan> $span;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        public C10958(Function3<? super LazyGridItemSpanScope, ? super Integer, ? super T, GridItemSpan> function3, T[] tArr) {
            super(2);
            this.$span = function3;
            this.$items = tArr;
        }

        @Override // kotlin.jvm.functions.Function2
        public /* bridge */ /* synthetic */ GridItemSpan invoke(LazyGridItemSpanScope lazyGridItemSpanScope, Integer num) {
            return GridItemSpan.m15973boximpl(m15985invoke_orMbw(lazyGridItemSpanScope, num.intValue()));
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
        /* JADX INFO: renamed from: invoke-_-orMbw, reason: not valid java name */
        public final long m15985invoke_orMbw(@NotNull LazyGridItemSpanScope lazyGridItemSpanScope, int i) {
            return this.$span.invoke(lazyGridItemSpanScope, Integer.valueOf(i), this.$items[i]).getPackedValue();
        }
    }

    /* JADX INFO: renamed from: androidx.compose.foundation.lazy.grid.LazyGridDslKt$itemsIndexed$9 */
    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\u0010\u0000\u001a\u0004\u0018\u00010\u0001\"\u0004\b\u0000\u0010\u00022\u0006\u0010\u0003\u001a\u00020\u0004H\n¢\u0006\u0002\b\u0005"}, m13886d2 = {"<anonymous>", "", "T", "index", "", "invoke"}, m13887k = 3, m13888mv = {1, 8, 0}, m13890xi = 176)
    @SourceDebugExtension({"SMAP\nLazyGridDsl.kt\nKotlin\n*S Kotlin\n*F\n+ 1 LazyGridDsl.kt\nandroidx/compose/foundation/lazy/grid/LazyGridDslKt$itemsIndexed$9\n*L\n1#1,569:1\n*E\n"})
    public static final class C10969 extends Lambda implements Function1<Integer, Object> {
        final /* synthetic */ Function2<Integer, T, Object> $contentType;
        final /* synthetic */ T[] $items;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        public C10969(Function2<? super Integer, ? super T, ? extends Object> function2, T[] tArr) {
            super(1);
            this.$contentType = function2;
            this.$items = tArr;
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Object invoke(Integer num) {
            return invoke(num.intValue());
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
        @Nullable
        public final Object invoke(int i) {
            return this.$contentType.invoke(Integer.valueOf(i), this.$items[i]);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:102:0x0117  */
    /* JADX WARN: Removed duplicated region for block: B:104:0x011c  */
    /* JADX WARN: Removed duplicated region for block: B:113:0x013b  */
    /* JADX WARN: Removed duplicated region for block: B:117:0x0153  */
    /* JADX WARN: Removed duplicated region for block: B:133:0x0188  */
    /* JADX WARN: Removed duplicated region for block: B:134:0x018a  */
    /* JADX WARN: Removed duplicated region for block: B:137:0x0194  */
    /* JADX WARN: Removed duplicated region for block: B:139:0x019e  */
    /* JADX WARN: Removed duplicated region for block: B:142:0x01ab  */
    /* JADX WARN: Removed duplicated region for block: B:145:0x01b0  */
    /* JADX WARN: Removed duplicated region for block: B:151:0x01c2  */
    /* JADX WARN: Removed duplicated region for block: B:154:0x01cd  */
    /* JADX WARN: Removed duplicated region for block: B:155:0x01d7  */
    /* JADX WARN: Removed duplicated region for block: B:157:0x01db  */
    /* JADX WARN: Removed duplicated region for block: B:158:0x01e3  */
    /* JADX WARN: Removed duplicated region for block: B:161:0x01f3  */
    /* JADX WARN: Removed duplicated region for block: B:164:0x0249  */
    /* JADX WARN: Removed duplicated region for block: B:168:0x0260  */
    /* JADX WARN: Removed duplicated region for block: B:170:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:26:0x0045  */
    /* JADX WARN: Removed duplicated region for block: B:34:0x005a  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x0060  */
    /* JADX WARN: Removed duplicated region for block: B:39:0x0065  */
    /* JADX WARN: Removed duplicated region for block: B:48:0x007b  */
    /* JADX WARN: Removed duplicated region for block: B:50:0x0080  */
    /* JADX WARN: Removed duplicated region for block: B:59:0x0098  */
    /* JADX WARN: Removed duplicated region for block: B:67:0x00ad  */
    /* JADX WARN: Removed duplicated region for block: B:70:0x00b5  */
    /* JADX WARN: Removed duplicated region for block: B:71:0x00bc  */
    /* JADX WARN: Removed duplicated region for block: B:80:0x00d7  */
    /* JADX WARN: Removed duplicated region for block: B:88:0x00ed  */
    /* JADX WARN: Removed duplicated region for block: B:91:0x00f5  */
    /* JADX WARN: Removed duplicated region for block: B:93:0x00fc  */
    @ComposableTarget(applier = "androidx.compose.ui.UiComposable")
    @Composable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final void LazyHorizontalGrid(@NotNull final GridCells gridCells, @Nullable Modifier modifier, @Nullable LazyGridState lazyGridState, @Nullable PaddingValues paddingValues, boolean z, @Nullable Arrangement.Horizontal horizontal, @Nullable Arrangement.Vertical vertical, @Nullable FlingBehavior flingBehavior, boolean z2, @NotNull final Function1<? super LazyGridScope, Unit> function1, @Nullable Composer composer, final int i, final int i2) {
        int i4;
        Modifier modifier2;
        LazyGridState lazyGridStateRememberLazyGridState;
        int i5;
        PaddingValues paddingValuesM15847PaddingValues0680j_4;
        int i6;
        boolean z3;
        Arrangement.Horizontal start;
        int i7;
        int i8;
        Arrangement.Vertical top;
        int i9;
        int i10;
        FlingBehavior flingBehavior2;
        boolean z4;
        FlingBehavior flingBehavior3;
        boolean z5;
        Composer composer2;
        final Modifier modifier3;
        final LazyGridState lazyGridState2;
        final PaddingValues paddingValues2;
        final boolean z6;
        final FlingBehavior flingBehavior4;
        final boolean z7;
        final Arrangement.Vertical vertical2;
        final Arrangement.Horizontal horizontal2;
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup;
        Composer composerStartRestartGroup = composer.startRestartGroup(2123608858);
        if ((i2 & 1) != 0) {
            i4 = i | 6;
        } else if ((i & 6) == 0) {
            i4 = (composerStartRestartGroup.changed(gridCells) ? 4 : 2) | i;
        } else {
            i4 = i;
        }
        int i11 = i2 & 2;
        if (i11 != 0) {
            i4 |= 48;
        } else {
            if ((i & 48) == 0) {
                modifier2 = modifier;
                i4 |= composerStartRestartGroup.changed(modifier2) ? 32 : 16;
            }
            if ((i & 384) != 0) {
                if ((i2 & 4) == 0) {
                    lazyGridStateRememberLazyGridState = lazyGridState;
                    int i12 = composerStartRestartGroup.changed(lazyGridStateRememberLazyGridState) ? 256 : 128;
                    i4 |= i12;
                } else {
                    lazyGridStateRememberLazyGridState = lazyGridState;
                }
                i4 |= i12;
            } else {
                lazyGridStateRememberLazyGridState = lazyGridState;
            }
            i5 = i2 & 8;
            if (i5 == 0) {
                i4 |= 3072;
            } else {
                if ((i & 3072) == 0) {
                    paddingValuesM15847PaddingValues0680j_4 = paddingValues;
                    i4 |= composerStartRestartGroup.changed(paddingValuesM15847PaddingValues0680j_4) ? 2048 : 1024;
                }
                i6 = i2 & 16;
                if (i6 != 0) {
                    i4 |= 24576;
                } else {
                    if ((i & 24576) == 0) {
                        z3 = z;
                        i4 |= composerStartRestartGroup.changed(z3) ? 16384 : 8192;
                    }
                    if ((i & 196608) != 0) {
                        if ((i2 & 32) == 0) {
                            start = horizontal;
                            int i13 = composerStartRestartGroup.changed(start) ? 131072 : 65536;
                            i4 |= i13;
                        } else {
                            start = horizontal;
                        }
                        i4 |= i13;
                    } else {
                        start = horizontal;
                    }
                    i7 = i2 & 64;
                    if (i7 == 0) {
                        i4 |= 1572864;
                        i8 = 196608;
                        top = vertical;
                    } else {
                        i8 = 196608;
                        top = vertical;
                        if ((i & 1572864) == 0) {
                            i4 |= composerStartRestartGroup.changed(top) ? 1048576 : 524288;
                        }
                    }
                    if ((i & 12582912) == 0) {
                        i4 |= ((i2 & 128) == 0 && composerStartRestartGroup.changed(flingBehavior)) ? 8388608 : 4194304;
                    }
                    i9 = i2 & 256;
                    if (i9 == 0) {
                        i4 |= 100663296;
                    } else {
                        if ((i & 100663296) == 0) {
                            i10 = i9;
                            i4 |= composerStartRestartGroup.changed(z2) ? 67108864 : 33554432;
                        }
                        if ((i2 & 512) == 0) {
                            if ((i & DriveFile.MODE_READ_WRITE) == 0) {
                                i4 |= composerStartRestartGroup.changedInstance(function1) ? 536870912 : 268435456;
                            }
                            if ((i4 & 306783379) == 306783378 || !composerStartRestartGroup.getSkipping()) {
                                composerStartRestartGroup.startDefaults();
                                if ((i & 1) != 0 || composerStartRestartGroup.getDefaultsInvalid()) {
                                    if (i11 != 0) {
                                        modifier2 = Modifier.INSTANCE;
                                    }
                                    if ((i2 & 4) != 0) {
                                        i4 &= -897;
                                        lazyGridStateRememberLazyGridState = LazyGridStateKt.rememberLazyGridState(0, 0, composerStartRestartGroup, 0, 3);
                                    }
                                    if (i5 != 0) {
                                        paddingValuesM15847PaddingValues0680j_4 = PaddingKt.m15847PaddingValues0680j_4(C2256Dp.m20968constructorimpl(0));
                                    }
                                    boolean z8 = i6 == 0 ? z3 : false;
                                    if ((i2 & 32) != 0) {
                                        Arrangement arrangement = Arrangement.INSTANCE;
                                        i4 &= -458753;
                                        start = !z8 ? arrangement.getStart() : arrangement.getEnd();
                                    }
                                    if (i7 != 0) {
                                        top = Arrangement.INSTANCE.getTop();
                                    }
                                    if ((i2 & 128) == 0) {
                                        flingBehavior2 = ScrollableDefaults.INSTANCE.flingBehavior(composerStartRestartGroup, 6);
                                        i4 &= -29360129;
                                    } else {
                                        flingBehavior2 = flingBehavior;
                                    }
                                    if (i10 == 0) {
                                        flingBehavior3 = flingBehavior2;
                                        z5 = z8;
                                        z4 = true;
                                    } else {
                                        z4 = z2;
                                        flingBehavior3 = flingBehavior2;
                                        z5 = z8;
                                    }
                                } else {
                                    composerStartRestartGroup.skipToGroupEnd();
                                    if ((i2 & 4) != 0) {
                                        i4 &= -897;
                                    }
                                    if ((i2 & 32) != 0) {
                                        i4 &= -458753;
                                    }
                                    if ((i2 & 128) != 0) {
                                        i4 &= -29360129;
                                    }
                                    flingBehavior3 = flingBehavior;
                                    z4 = z2;
                                    z5 = z3;
                                }
                                Arrangement.Vertical vertical3 = top;
                                Arrangement.Horizontal horizontal3 = start;
                                Modifier modifier4 = modifier2;
                                LazyGridState lazyGridState3 = lazyGridStateRememberLazyGridState;
                                composerStartRestartGroup.endDefaults();
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventStart(2123608858, i4, -1, "androidx.compose.foundation.lazy.grid.LazyHorizontalGrid (LazyGridDsl.kt:126)");
                                }
                                int i14 = i4 >> 3;
                                composer2 = composerStartRestartGroup;
                                PaddingValues paddingValues3 = paddingValuesM15847PaddingValues0680j_4;
                                LazyGridKt.LazyGrid(modifier4, lazyGridState3, rememberRowHeightSums(gridCells, vertical3, paddingValuesM15847PaddingValues0680j_4, composerStartRestartGroup, (i4 & 14) | ((i4 >> 15) & 112) | (i14 & 896)), paddingValues3, z5, false, flingBehavior3, z4, vertical3, horizontal3, function1, composer2, (i14 & 14) | i8 | (i14 & 112) | (i4 & 7168) | (57344 & i4) | (3670016 & i14) | (i14 & 29360128) | ((i4 << 6) & 234881024) | ((i4 << 12) & 1879048192), (i4 >> 27) & 14, 0);
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventEnd();
                                }
                                modifier3 = modifier4;
                                lazyGridState2 = lazyGridState3;
                                paddingValues2 = paddingValues3;
                                z6 = z5;
                                flingBehavior4 = flingBehavior3;
                                z7 = z4;
                                vertical2 = vertical3;
                                horizontal2 = horizontal3;
                            } else {
                                composerStartRestartGroup.skipToGroupEnd();
                                z7 = z2;
                                composer2 = composerStartRestartGroup;
                                modifier3 = modifier2;
                                lazyGridState2 = lazyGridStateRememberLazyGridState;
                                paddingValues2 = paddingValuesM15847PaddingValues0680j_4;
                                z6 = z3;
                                vertical2 = top;
                                horizontal2 = start;
                                flingBehavior4 = flingBehavior;
                            }
                            scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                            if (scopeUpdateScopeEndRestartGroup == null) {
                                scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.foundation.lazy.grid.LazyGridDslKt.LazyHorizontalGrid.1
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

                                    public final void invoke(@Nullable Composer composer3, int i15) {
                                        LazyGridDslKt.LazyHorizontalGrid(gridCells, modifier3, lazyGridState2, paddingValues2, z6, horizontal2, vertical2, flingBehavior4, z7, function1, composer3, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
                                    }
                                });
                                return;
                            }
                            return;
                        }
                        i4 |= DriveFile.MODE_READ_WRITE;
                        if ((i4 & 306783379) == 306783378) {
                            composerStartRestartGroup.startDefaults();
                            if ((i & 1) != 0) {
                                if (i11 != 0) {
                                }
                                if ((i2 & 4) != 0) {
                                }
                                if (i5 != 0) {
                                }
                                if (i6 == 0) {
                                }
                                if ((i2 & 32) != 0) {
                                }
                                if (i7 != 0) {
                                }
                                if ((i2 & 128) == 0) {
                                }
                                if (i10 == 0) {
                                }
                                Arrangement.Vertical vertical32 = top;
                                Arrangement.Horizontal horizontal32 = start;
                                Modifier modifier42 = modifier2;
                                LazyGridState lazyGridState32 = lazyGridStateRememberLazyGridState;
                                composerStartRestartGroup.endDefaults();
                                if (ComposerKt.isTraceInProgress()) {
                                }
                                int i142 = i4 >> 3;
                                composer2 = composerStartRestartGroup;
                                PaddingValues paddingValues32 = paddingValuesM15847PaddingValues0680j_4;
                                LazyGridKt.LazyGrid(modifier42, lazyGridState32, rememberRowHeightSums(gridCells, vertical32, paddingValuesM15847PaddingValues0680j_4, composerStartRestartGroup, (i4 & 14) | ((i4 >> 15) & 112) | (i142 & 896)), paddingValues32, z5, false, flingBehavior3, z4, vertical32, horizontal32, function1, composer2, (i142 & 14) | i8 | (i142 & 112) | (i4 & 7168) | (57344 & i4) | (3670016 & i142) | (i142 & 29360128) | ((i4 << 6) & 234881024) | ((i4 << 12) & 1879048192), (i4 >> 27) & 14, 0);
                                if (ComposerKt.isTraceInProgress()) {
                                }
                                modifier3 = modifier42;
                                lazyGridState2 = lazyGridState32;
                                paddingValues2 = paddingValues32;
                                z6 = z5;
                                flingBehavior4 = flingBehavior3;
                                z7 = z4;
                                vertical2 = vertical32;
                                horizontal2 = horizontal32;
                            }
                        }
                        scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                        if (scopeUpdateScopeEndRestartGroup == null) {
                        }
                    }
                    i10 = i9;
                    if ((i2 & 512) == 0) {
                    }
                    if ((i4 & 306783379) == 306783378) {
                    }
                    scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                    if (scopeUpdateScopeEndRestartGroup == null) {
                    }
                }
                z3 = z;
                if ((i & 196608) != 0) {
                }
                i7 = i2 & 64;
                if (i7 == 0) {
                }
                if ((i & 12582912) == 0) {
                }
                i9 = i2 & 256;
                if (i9 == 0) {
                }
                i10 = i9;
                if ((i2 & 512) == 0) {
                }
                if ((i4 & 306783379) == 306783378) {
                }
                scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup == null) {
                }
            }
            paddingValuesM15847PaddingValues0680j_4 = paddingValues;
            i6 = i2 & 16;
            if (i6 != 0) {
            }
            z3 = z;
            if ((i & 196608) != 0) {
            }
            i7 = i2 & 64;
            if (i7 == 0) {
            }
            if ((i & 12582912) == 0) {
            }
            i9 = i2 & 256;
            if (i9 == 0) {
            }
            i10 = i9;
            if ((i2 & 512) == 0) {
            }
            if ((i4 & 306783379) == 306783378) {
            }
            scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup == null) {
            }
        }
        modifier2 = modifier;
        if ((i & 384) != 0) {
        }
        i5 = i2 & 8;
        if (i5 == 0) {
        }
        paddingValuesM15847PaddingValues0680j_4 = paddingValues;
        i6 = i2 & 16;
        if (i6 != 0) {
        }
        z3 = z;
        if ((i & 196608) != 0) {
        }
        i7 = i2 & 64;
        if (i7 == 0) {
        }
        if ((i & 12582912) == 0) {
        }
        i9 = i2 & 256;
        if (i9 == 0) {
        }
        i10 = i9;
        if ((i2 & 512) == 0) {
        }
        if ((i4 & 306783379) == 306783378) {
        }
        scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup == null) {
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:102:0x0117  */
    /* JADX WARN: Removed duplicated region for block: B:104:0x011c  */
    /* JADX WARN: Removed duplicated region for block: B:113:0x013b  */
    /* JADX WARN: Removed duplicated region for block: B:117:0x0153  */
    /* JADX WARN: Removed duplicated region for block: B:133:0x0188  */
    /* JADX WARN: Removed duplicated region for block: B:134:0x018a  */
    /* JADX WARN: Removed duplicated region for block: B:137:0x0194  */
    /* JADX WARN: Removed duplicated region for block: B:139:0x019e  */
    /* JADX WARN: Removed duplicated region for block: B:142:0x01ab  */
    /* JADX WARN: Removed duplicated region for block: B:145:0x01b0  */
    /* JADX WARN: Removed duplicated region for block: B:151:0x01c2  */
    /* JADX WARN: Removed duplicated region for block: B:154:0x01cd  */
    /* JADX WARN: Removed duplicated region for block: B:155:0x01d7  */
    /* JADX WARN: Removed duplicated region for block: B:157:0x01db  */
    /* JADX WARN: Removed duplicated region for block: B:158:0x01e3  */
    /* JADX WARN: Removed duplicated region for block: B:161:0x01f3  */
    /* JADX WARN: Removed duplicated region for block: B:164:0x0247  */
    /* JADX WARN: Removed duplicated region for block: B:168:0x025e  */
    /* JADX WARN: Removed duplicated region for block: B:170:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:26:0x0045  */
    /* JADX WARN: Removed duplicated region for block: B:34:0x005a  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x0060  */
    /* JADX WARN: Removed duplicated region for block: B:39:0x0065  */
    /* JADX WARN: Removed duplicated region for block: B:48:0x007b  */
    /* JADX WARN: Removed duplicated region for block: B:50:0x0080  */
    /* JADX WARN: Removed duplicated region for block: B:59:0x0098  */
    /* JADX WARN: Removed duplicated region for block: B:67:0x00ad  */
    /* JADX WARN: Removed duplicated region for block: B:70:0x00b5  */
    /* JADX WARN: Removed duplicated region for block: B:71:0x00bc  */
    /* JADX WARN: Removed duplicated region for block: B:80:0x00d7  */
    /* JADX WARN: Removed duplicated region for block: B:88:0x00ed  */
    /* JADX WARN: Removed duplicated region for block: B:91:0x00f5  */
    /* JADX WARN: Removed duplicated region for block: B:93:0x00fc  */
    @ComposableTarget(applier = "androidx.compose.ui.UiComposable")
    @Composable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final void LazyVerticalGrid(@NotNull final GridCells gridCells, @Nullable Modifier modifier, @Nullable LazyGridState lazyGridState, @Nullable PaddingValues paddingValues, boolean z, @Nullable Arrangement.Vertical vertical, @Nullable Arrangement.Horizontal horizontal, @Nullable FlingBehavior flingBehavior, boolean z2, @NotNull final Function1<? super LazyGridScope, Unit> function1, @Nullable Composer composer, final int i, final int i2) {
        int i4;
        Modifier modifier2;
        LazyGridState lazyGridStateRememberLazyGridState;
        int i5;
        PaddingValues paddingValuesM15847PaddingValues0680j_4;
        int i6;
        boolean z3;
        Arrangement.Vertical top;
        int i7;
        int i8;
        Arrangement.Horizontal start;
        int i9;
        int i10;
        FlingBehavior flingBehavior2;
        boolean z4;
        FlingBehavior flingBehavior3;
        boolean z5;
        Composer composer2;
        final Modifier modifier3;
        final LazyGridState lazyGridState2;
        final PaddingValues paddingValues2;
        final boolean z6;
        final FlingBehavior flingBehavior4;
        final boolean z7;
        final Arrangement.Vertical vertical2;
        final Arrangement.Horizontal horizontal2;
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup;
        Composer composerStartRestartGroup = composer.startRestartGroup(1485410512);
        if ((i2 & 1) != 0) {
            i4 = i | 6;
        } else if ((i & 6) == 0) {
            i4 = (composerStartRestartGroup.changed(gridCells) ? 4 : 2) | i;
        } else {
            i4 = i;
        }
        int i11 = i2 & 2;
        if (i11 != 0) {
            i4 |= 48;
        } else {
            if ((i & 48) == 0) {
                modifier2 = modifier;
                i4 |= composerStartRestartGroup.changed(modifier2) ? 32 : 16;
            }
            if ((i & 384) != 0) {
                if ((i2 & 4) == 0) {
                    lazyGridStateRememberLazyGridState = lazyGridState;
                    int i12 = composerStartRestartGroup.changed(lazyGridStateRememberLazyGridState) ? 256 : 128;
                    i4 |= i12;
                } else {
                    lazyGridStateRememberLazyGridState = lazyGridState;
                }
                i4 |= i12;
            } else {
                lazyGridStateRememberLazyGridState = lazyGridState;
            }
            i5 = i2 & 8;
            if (i5 == 0) {
                i4 |= 3072;
            } else {
                if ((i & 3072) == 0) {
                    paddingValuesM15847PaddingValues0680j_4 = paddingValues;
                    i4 |= composerStartRestartGroup.changed(paddingValuesM15847PaddingValues0680j_4) ? 2048 : 1024;
                }
                i6 = i2 & 16;
                if (i6 != 0) {
                    i4 |= 24576;
                } else {
                    if ((i & 24576) == 0) {
                        z3 = z;
                        i4 |= composerStartRestartGroup.changed(z3) ? 16384 : 8192;
                    }
                    if ((i & 196608) != 0) {
                        if ((i2 & 32) == 0) {
                            top = vertical;
                            int i13 = composerStartRestartGroup.changed(top) ? 131072 : 65536;
                            i4 |= i13;
                        } else {
                            top = vertical;
                        }
                        i4 |= i13;
                    } else {
                        top = vertical;
                    }
                    i7 = i2 & 64;
                    if (i7 == 0) {
                        i4 |= 1572864;
                        i8 = 196608;
                        start = horizontal;
                    } else {
                        i8 = 196608;
                        start = horizontal;
                        if ((i & 1572864) == 0) {
                            i4 |= composerStartRestartGroup.changed(start) ? 1048576 : 524288;
                        }
                    }
                    if ((i & 12582912) == 0) {
                        i4 |= ((i2 & 128) == 0 && composerStartRestartGroup.changed(flingBehavior)) ? 8388608 : 4194304;
                    }
                    i9 = i2 & 256;
                    if (i9 == 0) {
                        i4 |= 100663296;
                    } else {
                        if ((i & 100663296) == 0) {
                            i10 = i9;
                            i4 |= composerStartRestartGroup.changed(z2) ? 67108864 : 33554432;
                        }
                        if ((i2 & 512) == 0) {
                            if ((i & DriveFile.MODE_READ_WRITE) == 0) {
                                i4 |= composerStartRestartGroup.changedInstance(function1) ? 536870912 : 268435456;
                            }
                            if ((i4 & 306783379) == 306783378 || !composerStartRestartGroup.getSkipping()) {
                                composerStartRestartGroup.startDefaults();
                                if ((i & 1) != 0 || composerStartRestartGroup.getDefaultsInvalid()) {
                                    if (i11 != 0) {
                                        modifier2 = Modifier.INSTANCE;
                                    }
                                    if ((i2 & 4) != 0) {
                                        i4 &= -897;
                                        lazyGridStateRememberLazyGridState = LazyGridStateKt.rememberLazyGridState(0, 0, composerStartRestartGroup, 0, 3);
                                    }
                                    if (i5 != 0) {
                                        paddingValuesM15847PaddingValues0680j_4 = PaddingKt.m15847PaddingValues0680j_4(C2256Dp.m20968constructorimpl(0));
                                    }
                                    boolean z8 = i6 == 0 ? z3 : false;
                                    if ((i2 & 32) != 0) {
                                        Arrangement arrangement = Arrangement.INSTANCE;
                                        i4 &= -458753;
                                        top = !z8 ? arrangement.getTop() : arrangement.getBottom();
                                    }
                                    if (i7 != 0) {
                                        start = Arrangement.INSTANCE.getStart();
                                    }
                                    if ((i2 & 128) == 0) {
                                        flingBehavior2 = ScrollableDefaults.INSTANCE.flingBehavior(composerStartRestartGroup, 6);
                                        i4 &= -29360129;
                                    } else {
                                        flingBehavior2 = flingBehavior;
                                    }
                                    if (i10 == 0) {
                                        flingBehavior3 = flingBehavior2;
                                        z5 = z8;
                                        z4 = true;
                                    } else {
                                        z4 = z2;
                                        flingBehavior3 = flingBehavior2;
                                        z5 = z8;
                                    }
                                } else {
                                    composerStartRestartGroup.skipToGroupEnd();
                                    if ((i2 & 4) != 0) {
                                        i4 &= -897;
                                    }
                                    if ((i2 & 32) != 0) {
                                        i4 &= -458753;
                                    }
                                    if ((i2 & 128) != 0) {
                                        i4 &= -29360129;
                                    }
                                    flingBehavior3 = flingBehavior;
                                    z4 = z2;
                                    z5 = z3;
                                }
                                Arrangement.Horizontal horizontal3 = start;
                                Arrangement.Vertical vertical3 = top;
                                Modifier modifier4 = modifier2;
                                LazyGridState lazyGridState3 = lazyGridStateRememberLazyGridState;
                                composerStartRestartGroup.endDefaults();
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventStart(1485410512, i4, -1, "androidx.compose.foundation.lazy.grid.LazyVerticalGrid (LazyGridDsl.kt:73)");
                                }
                                int i14 = i4 >> 3;
                                LazyGridSlotsProvider lazyGridSlotsProviderRememberColumnWidthSums = rememberColumnWidthSums(gridCells, horizontal3, paddingValuesM15847PaddingValues0680j_4, composerStartRestartGroup, (i4 & 14) | ((i4 >> 15) & 112) | (i14 & 896));
                                int i15 = (i14 & 14) | i8 | (i14 & 112) | (i4 & 7168) | (57344 & i4) | (3670016 & i14) | (i14 & 29360128);
                                int i16 = i4 << 9;
                                composer2 = composerStartRestartGroup;
                                PaddingValues paddingValues3 = paddingValuesM15847PaddingValues0680j_4;
                                LazyGridKt.LazyGrid(modifier4, lazyGridState3, lazyGridSlotsProviderRememberColumnWidthSums, paddingValues3, z5, true, flingBehavior3, z4, vertical3, horizontal3, function1, composer2, i15 | (234881024 & i16) | (i16 & 1879048192), (i4 >> 27) & 14, 0);
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventEnd();
                                }
                                modifier3 = modifier4;
                                lazyGridState2 = lazyGridState3;
                                paddingValues2 = paddingValues3;
                                z6 = z5;
                                flingBehavior4 = flingBehavior3;
                                z7 = z4;
                                vertical2 = vertical3;
                                horizontal2 = horizontal3;
                            } else {
                                composerStartRestartGroup.skipToGroupEnd();
                                z7 = z2;
                                composer2 = composerStartRestartGroup;
                                modifier3 = modifier2;
                                lazyGridState2 = lazyGridStateRememberLazyGridState;
                                paddingValues2 = paddingValuesM15847PaddingValues0680j_4;
                                z6 = z3;
                                horizontal2 = start;
                                vertical2 = top;
                                flingBehavior4 = flingBehavior;
                            }
                            scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                            if (scopeUpdateScopeEndRestartGroup == null) {
                                scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.foundation.lazy.grid.LazyGridDslKt.LazyVerticalGrid.1
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

                                    public final void invoke(@Nullable Composer composer3, int i17) {
                                        LazyGridDslKt.LazyVerticalGrid(gridCells, modifier3, lazyGridState2, paddingValues2, z6, vertical2, horizontal2, flingBehavior4, z7, function1, composer3, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
                                    }
                                });
                                return;
                            }
                            return;
                        }
                        i4 |= DriveFile.MODE_READ_WRITE;
                        if ((i4 & 306783379) == 306783378) {
                            composerStartRestartGroup.startDefaults();
                            if ((i & 1) != 0) {
                                if (i11 != 0) {
                                }
                                if ((i2 & 4) != 0) {
                                }
                                if (i5 != 0) {
                                }
                                if (i6 == 0) {
                                }
                                if ((i2 & 32) != 0) {
                                }
                                if (i7 != 0) {
                                }
                                if ((i2 & 128) == 0) {
                                }
                                if (i10 == 0) {
                                }
                                Arrangement.Horizontal horizontal32 = start;
                                Arrangement.Vertical vertical32 = top;
                                Modifier modifier42 = modifier2;
                                LazyGridState lazyGridState32 = lazyGridStateRememberLazyGridState;
                                composerStartRestartGroup.endDefaults();
                                if (ComposerKt.isTraceInProgress()) {
                                }
                                int i142 = i4 >> 3;
                                LazyGridSlotsProvider lazyGridSlotsProviderRememberColumnWidthSums2 = rememberColumnWidthSums(gridCells, horizontal32, paddingValuesM15847PaddingValues0680j_4, composerStartRestartGroup, (i4 & 14) | ((i4 >> 15) & 112) | (i142 & 896));
                                int i152 = (i142 & 14) | i8 | (i142 & 112) | (i4 & 7168) | (57344 & i4) | (3670016 & i142) | (i142 & 29360128);
                                int i162 = i4 << 9;
                                composer2 = composerStartRestartGroup;
                                PaddingValues paddingValues32 = paddingValuesM15847PaddingValues0680j_4;
                                LazyGridKt.LazyGrid(modifier42, lazyGridState32, lazyGridSlotsProviderRememberColumnWidthSums2, paddingValues32, z5, true, flingBehavior3, z4, vertical32, horizontal32, function1, composer2, i152 | (234881024 & i162) | (i162 & 1879048192), (i4 >> 27) & 14, 0);
                                if (ComposerKt.isTraceInProgress()) {
                                }
                                modifier3 = modifier42;
                                lazyGridState2 = lazyGridState32;
                                paddingValues2 = paddingValues32;
                                z6 = z5;
                                flingBehavior4 = flingBehavior3;
                                z7 = z4;
                                vertical2 = vertical32;
                                horizontal2 = horizontal32;
                            }
                        }
                        scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                        if (scopeUpdateScopeEndRestartGroup == null) {
                        }
                    }
                    i10 = i9;
                    if ((i2 & 512) == 0) {
                    }
                    if ((i4 & 306783379) == 306783378) {
                    }
                    scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                    if (scopeUpdateScopeEndRestartGroup == null) {
                    }
                }
                z3 = z;
                if ((i & 196608) != 0) {
                }
                i7 = i2 & 64;
                if (i7 == 0) {
                }
                if ((i & 12582912) == 0) {
                }
                i9 = i2 & 256;
                if (i9 == 0) {
                }
                i10 = i9;
                if ((i2 & 512) == 0) {
                }
                if ((i4 & 306783379) == 306783378) {
                }
                scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup == null) {
                }
            }
            paddingValuesM15847PaddingValues0680j_4 = paddingValues;
            i6 = i2 & 16;
            if (i6 != 0) {
            }
            z3 = z;
            if ((i & 196608) != 0) {
            }
            i7 = i2 & 64;
            if (i7 == 0) {
            }
            if ((i & 12582912) == 0) {
            }
            i9 = i2 & 256;
            if (i9 == 0) {
            }
            i10 = i9;
            if ((i2 & 512) == 0) {
            }
            if ((i4 & 306783379) == 306783378) {
            }
            scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup == null) {
            }
        }
        modifier2 = modifier;
        if ((i & 384) != 0) {
        }
        i5 = i2 & 8;
        if (i5 == 0) {
        }
        paddingValuesM15847PaddingValues0680j_4 = paddingValues;
        i6 = i2 & 16;
        if (i6 != 0) {
        }
        z3 = z;
        if ((i & 196608) != 0) {
        }
        i7 = i2 & 64;
        if (i7 == 0) {
        }
        if ((i & 12582912) == 0) {
        }
        i9 = i2 & 256;
        if (i9 == 0) {
        }
        i10 = i9;
        if ((i2 & 512) == 0) {
        }
        if ((i4 & 306783379) == 306783378) {
        }
        scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup == null) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final List<Integer> calculateCellsCrossAxisSizeImpl(int i, int i2, int i4) {
        int i5 = i - ((i2 - 1) * i4);
        int i6 = i5 / i2;
        int i7 = i5 % i2;
        ArrayList arrayList = new ArrayList(i2);
        int i8 = 0;
        while (i8 < i2) {
            arrayList.add(Integer.valueOf((i8 < i7 ? 1 : 0) + i6));
            i8++;
        }
        return arrayList;
    }

    @ComposableInferredTarget(scheme = "[0[0]]")
    public static final <T> void items(@NotNull LazyGridScope lazyGridScope, @NotNull List<? extends T> list, @Nullable Function1<? super T, ? extends Object> function1, @Nullable Function2<? super LazyGridItemSpanScope, ? super T, GridItemSpan> function2, @NotNull Function1<? super T, ? extends Object> function12, @NotNull Function4<? super LazyGridItemScope, ? super T, ? super Composer, ? super Integer, Unit> function4) {
        lazyGridScope.items(list.size(), function1 != null ? new C10792(function1, list) : null, function2 != null ? new C10803(function2, list) : null, new C10814(function12, list), ComposableLambdaKt.composableLambdaInstance(699646206, true, new C10825(function4, list)));
    }

    public static /* synthetic */ void items$default(LazyGridScope lazyGridScope, List list, Function1 function1, Function2 function2, Function1 function12, Function4 function4, int i, Object obj) {
        if ((i & 2) != 0) {
            function1 = null;
        }
        if ((i & 4) != 0) {
            function2 = null;
        }
        if ((i & 8) != 0) {
            function12 = new Function1() { // from class: androidx.compose.foundation.lazy.grid.LazyGridDslKt.items.1
                @Override // kotlin.jvm.functions.Function1
                @Nullable
                public final Void invoke(Object obj2) {
                    return null;
                }
            };
        }
        lazyGridScope.items(list.size(), function1 != null ? new C10792(function1, list) : null, function2 != null ? new C10803(function2, list) : null, new C10814(function12, list), ComposableLambdaKt.composableLambdaInstance(699646206, true, new C10825(function4, list)));
    }

    @ComposableInferredTarget(scheme = "[0[0]]")
    public static final <T> void itemsIndexed(@NotNull LazyGridScope lazyGridScope, @NotNull List<? extends T> list, @Nullable Function2<? super Integer, ? super T, ? extends Object> function2, @Nullable Function3<? super LazyGridItemSpanScope, ? super Integer, ? super T, GridItemSpan> function3, @NotNull Function2<? super Integer, ? super T, ? extends Object> function22, @NotNull Function5<? super LazyGridItemScope, ? super Integer, ? super T, ? super Composer, ? super Integer, Unit> function5) {
        lazyGridScope.items(list.size(), function2 != null ? new C10892(function2, list) : null, function3 != null ? new C10903(function3, list) : null, new C10914(function22, list), ComposableLambdaKt.composableLambdaInstance(1229287273, true, new C10925(function5, list)));
    }

    public static /* synthetic */ void itemsIndexed$default(LazyGridScope lazyGridScope, List list, Function2 function2, Function3 function3, Function2 function22, Function5 function5, int i, Object obj) {
        if ((i & 2) != 0) {
            function2 = null;
        }
        if ((i & 4) != 0) {
            function3 = null;
        }
        if ((i & 8) != 0) {
            function22 = new Function2() { // from class: androidx.compose.foundation.lazy.grid.LazyGridDslKt.itemsIndexed.1
                @Nullable
                public final Void invoke(int i2, Object obj2) {
                    return null;
                }

                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Object invoke(Object obj2, Object obj3) {
                    return invoke(((Number) obj2).intValue(), obj3);
                }
            };
        }
        lazyGridScope.items(list.size(), function2 != null ? new C10892(function2, list) : null, function3 != null ? new C10903(function3, list) : null, new C10914(function22, list), ComposableLambdaKt.composableLambdaInstance(1229287273, true, new C10925(function5, list)));
    }

    @Composable
    private static final LazyGridSlotsProvider rememberColumnWidthSums(final GridCells gridCells, final Arrangement.Horizontal horizontal, final PaddingValues paddingValues, Composer composer, int i) {
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(1632454918, i, -1, "androidx.compose.foundation.lazy.grid.rememberColumnWidthSums (LazyGridDsl.kt:148)");
        }
        boolean z = ((((i & 14) ^ 6) > 4 && composer.changed(gridCells)) || (i & 6) == 4) | ((((i & 112) ^ 48) > 32 && composer.changed(horizontal)) || (i & 48) == 32) | ((((i & 896) ^ 384) > 256 && composer.changed(paddingValues)) || (i & 384) == 256);
        Object objRememberedValue = composer.rememberedValue();
        if (z || objRememberedValue == Composer.INSTANCE.getEmpty()) {
            objRememberedValue = new GridSlotCache(new Function2<Density, Constraints, LazyGridSlots>() { // from class: androidx.compose.foundation.lazy.grid.LazyGridDslKt$rememberColumnWidthSums$1$1
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(2);
                }

                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ LazyGridSlots invoke(Density density, Constraints constraints) {
                    return m15986invoke0kLqBqw(density, constraints.getValue());
                }

                @NotNull
                /* JADX INFO: renamed from: invoke-0kLqBqw, reason: not valid java name */
                public final LazyGridSlots m15986invoke0kLqBqw(@NotNull Density density, long j) {
                    if (Constraints.m20921getMaxWidthimpl(j) == Integer.MAX_VALUE) {
                        throw new IllegalArgumentException("LazyVerticalGrid's width should be bound by parent.");
                    }
                    PaddingValues paddingValues2 = paddingValues;
                    LayoutDirection layoutDirection = LayoutDirection.Ltr;
                    int iM20921getMaxWidthimpl = Constraints.m20921getMaxWidthimpl(j) - density.mo15540roundToPx0680j_4(C2256Dp.m20968constructorimpl(PaddingKt.calculateEndPadding(paddingValues, layoutDirection) + PaddingKt.calculateStartPadding(paddingValues2, layoutDirection)));
                    GridCells gridCells2 = gridCells;
                    Arrangement.Horizontal horizontal2 = horizontal;
                    int[] intArray = CollectionsKt.toIntArray(gridCells2.calculateCrossAxisCellSizes(density, iM20921getMaxWidthimpl, density.mo15540roundToPx0680j_4(horizontal2.getSpacing())));
                    int[] iArr = new int[intArray.length];
                    horizontal2.arrange(density, iM20921getMaxWidthimpl, intArray, layoutDirection, iArr);
                    return new LazyGridSlots(intArray, iArr);
                }
            });
            composer.updateRememberedValue(objRememberedValue);
        }
        LazyGridSlotsProvider lazyGridSlotsProvider = (LazyGridSlotsProvider) objRememberedValue;
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        return lazyGridSlotsProvider;
    }

    @Composable
    private static final LazyGridSlotsProvider rememberRowHeightSums(final GridCells gridCells, final Arrangement.Vertical vertical, final PaddingValues paddingValues, Composer composer, int i) {
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-741512409, i, -1, "androidx.compose.foundation.lazy.grid.rememberRowHeightSums (LazyGridDsl.kt:181)");
        }
        boolean z = ((((i & 14) ^ 6) > 4 && composer.changed(gridCells)) || (i & 6) == 4) | ((((i & 112) ^ 48) > 32 && composer.changed(vertical)) || (i & 48) == 32) | ((((i & 896) ^ 384) > 256 && composer.changed(paddingValues)) || (i & 384) == 256);
        Object objRememberedValue = composer.rememberedValue();
        if (z || objRememberedValue == Composer.INSTANCE.getEmpty()) {
            objRememberedValue = new GridSlotCache(new Function2<Density, Constraints, LazyGridSlots>() { // from class: androidx.compose.foundation.lazy.grid.LazyGridDslKt$rememberRowHeightSums$1$1
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(2);
                }

                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ LazyGridSlots invoke(Density density, Constraints constraints) {
                    return m15987invoke0kLqBqw(density, constraints.getValue());
                }

                @NotNull
                /* JADX INFO: renamed from: invoke-0kLqBqw, reason: not valid java name */
                public final LazyGridSlots m15987invoke0kLqBqw(@NotNull Density density, long j) {
                    if (Constraints.m20920getMaxHeightimpl(j) == Integer.MAX_VALUE) {
                        throw new IllegalArgumentException("LazyHorizontalGrid's height should be bound by parent.");
                    }
                    int iM20920getMaxHeightimpl = Constraints.m20920getMaxHeightimpl(j) - density.mo15540roundToPx0680j_4(C2256Dp.m20968constructorimpl(paddingValues.getBottom() + paddingValues.getTop()));
                    GridCells gridCells2 = gridCells;
                    Arrangement.Vertical vertical2 = vertical;
                    int[] intArray = CollectionsKt.toIntArray(gridCells2.calculateCrossAxisCellSizes(density, iM20920getMaxHeightimpl, density.mo15540roundToPx0680j_4(vertical2.getSpacing())));
                    int[] iArr = new int[intArray.length];
                    vertical2.arrange(density, iM20920getMaxHeightimpl, intArray, iArr);
                    return new LazyGridSlots(intArray, iArr);
                }
            });
            composer.updateRememberedValue(objRememberedValue);
        }
        LazyGridSlotsProvider lazyGridSlotsProvider = (LazyGridSlotsProvider) objRememberedValue;
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        return lazyGridSlotsProvider;
    }

    @ComposableInferredTarget(scheme = "[0[0]]")
    public static final <T> void items(@NotNull LazyGridScope lazyGridScope, @NotNull T[] tArr, @Nullable Function1<? super T, ? extends Object> function1, @Nullable Function2<? super LazyGridItemSpanScope, ? super T, GridItemSpan> function2, @NotNull Function1<? super T, ? extends Object> function12, @NotNull Function4<? super LazyGridItemScope, ? super T, ? super Composer, ? super Integer, Unit> function4) {
        lazyGridScope.items(tArr.length, function1 != null ? new C10847(function1, tArr) : null, function2 != null ? new C10858(function2, tArr) : null, new C10869(function12, tArr), ComposableLambdaKt.composableLambdaInstance(407562193, true, new C107810(function4, tArr)));
    }

    @ComposableInferredTarget(scheme = "[0[0]]")
    public static final <T> void itemsIndexed(@NotNull LazyGridScope lazyGridScope, @NotNull T[] tArr, @Nullable Function2<? super Integer, ? super T, ? extends Object> function2, @Nullable Function3<? super LazyGridItemSpanScope, ? super Integer, ? super T, GridItemSpan> function3, @NotNull Function2<? super Integer, ? super T, ? extends Object> function22, @NotNull Function5<? super LazyGridItemScope, ? super Integer, ? super T, ? super Composer, ? super Integer, Unit> function5) {
        lazyGridScope.items(tArr.length, function2 != null ? new C10947(function2, tArr) : null, function3 != null ? new C10958(function3, tArr) : null, new C10969(function22, tArr), ComposableLambdaKt.composableLambdaInstance(-911455938, true, new C108810(function5, tArr)));
    }

    public static /* synthetic */ void items$default(LazyGridScope lazyGridScope, Object[] objArr, Function1 function1, Function2 function2, Function1 function12, Function4 function4, int i, Object obj) {
        if ((i & 2) != 0) {
            function1 = null;
        }
        if ((i & 4) != 0) {
            function2 = null;
        }
        if ((i & 8) != 0) {
            function12 = new Function1() { // from class: androidx.compose.foundation.lazy.grid.LazyGridDslKt.items.6
                @Override // kotlin.jvm.functions.Function1
                @Nullable
                public final Void invoke(Object obj2) {
                    return null;
                }
            };
        }
        lazyGridScope.items(objArr.length, function1 != null ? new C10847(function1, objArr) : null, function2 != null ? new C10858(function2, objArr) : null, new C10869(function12, objArr), ComposableLambdaKt.composableLambdaInstance(407562193, true, new C107810(function4, objArr)));
    }

    public static /* synthetic */ void itemsIndexed$default(LazyGridScope lazyGridScope, Object[] objArr, Function2 function2, Function3 function3, Function2 function22, Function5 function5, int i, Object obj) {
        if ((i & 2) != 0) {
            function2 = null;
        }
        if ((i & 4) != 0) {
            function3 = null;
        }
        if ((i & 8) != 0) {
            function22 = new Function2() { // from class: androidx.compose.foundation.lazy.grid.LazyGridDslKt.itemsIndexed.6
                @Nullable
                public final Void invoke(int i2, Object obj2) {
                    return null;
                }

                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Object invoke(Object obj2, Object obj3) {
                    return invoke(((Number) obj2).intValue(), obj3);
                }
            };
        }
        lazyGridScope.items(objArr.length, function2 != null ? new C10947(function2, objArr) : null, function3 != null ? new C10958(function3, objArr) : null, new C10969(function22, objArr), ComposableLambdaKt.composableLambdaInstance(-911455938, true, new C108810(function5, objArr)));
    }
}
