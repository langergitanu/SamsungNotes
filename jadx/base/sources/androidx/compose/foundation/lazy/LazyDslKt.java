package androidx.compose.foundation.lazy;

import androidx.compose.foundation.gestures.FlingBehavior;
import androidx.compose.foundation.gestures.ScrollableDefaults;
import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.PaddingValues;
import androidx.compose.p109ui.Alignment;
import androidx.compose.p109ui.Modifier;
import androidx.compose.p109ui.unit.C2256Dp;
import androidx.compose.runtime.Composable;
import androidx.compose.runtime.ComposableInferredTarget;
import androidx.compose.runtime.ComposableTarget;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import com.samsung.android.app.sdk.deepsky.textextraction.languagepack.LangPackConfigConstants;
import com.samsung.android.imagetranslation.common.LttEngineErrors;
import java.util.List;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function4;
import kotlin.jvm.functions.Function5;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.SourceDebugExtension;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes.dex */
@Metadata(m13885d1 = {"\u0000\u008c\u0001\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0011\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u001al\u0010\u0000\u001a\u00020\u00012\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\t2\b\b\u0002\u0010\n\u001a\u00020\u000b2\b\b\u0002\u0010\f\u001a\u00020\r2\b\b\u0002\u0010\u000e\u001a\u00020\u000f2\u0017\u0010\u0010\u001a\u0013\u0012\u0004\u0012\u00020\u0012\u0012\u0004\u0012\u00020\u00010\u0011¢\u0006\u0002\b\u0013H\u0007¢\u0006\u0002\u0010\u0014\u001av\u0010\u0000\u001a\u00020\u00012\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\t2\b\b\u0002\u0010\n\u001a\u00020\u000b2\b\b\u0002\u0010\f\u001a\u00020\r2\b\b\u0002\u0010\u000e\u001a\u00020\u000f2\b\b\u0002\u0010\u0015\u001a\u00020\t2\u0017\u0010\u0010\u001a\u0013\u0012\u0004\u0012\u00020\u0012\u0012\u0004\u0012\u00020\u00010\u0011¢\u0006\u0002\b\u0013H\u0007¢\u0006\u0002\u0010\u0016\u001al\u0010\u0017\u001a\u00020\u00012\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\t2\b\b\u0002\u0010\u0018\u001a\u00020\u00192\b\b\u0002\u0010\u001a\u001a\u00020\u001b2\b\b\u0002\u0010\u000e\u001a\u00020\u000f2\u0017\u0010\u0010\u001a\u0013\u0012\u0004\u0012\u00020\u0012\u0012\u0004\u0012\u00020\u00010\u0011¢\u0006\u0002\b\u0013H\u0007¢\u0006\u0002\u0010\u001c\u001av\u0010\u0017\u001a\u00020\u00012\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\t2\b\b\u0002\u0010\u0018\u001a\u00020\u00192\b\b\u0002\u0010\u001a\u001a\u00020\u001b2\b\b\u0002\u0010\u000e\u001a\u00020\u000f2\b\b\u0002\u0010\u0015\u001a\u00020\t2\u0017\u0010\u0010\u001a\u0013\u0012\u0004\u0012\u00020\u0012\u0012\u0004\u0012\u00020\u00010\u0011¢\u0006\u0002\b\u0013H\u0007¢\u0006\u0002\u0010\u001d\u001a©\u0001\u0010\u001e\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u001f*\u00020\u00122\f\u0010\u001e\u001a\b\u0012\u0004\u0012\u0002H\u001f0 2%\b\n\u0010!\u001a\u001f\u0012\u0013\u0012\u0011H\u001f¢\u0006\f\b\"\u0012\b\b#\u0012\u0004\b\b($\u0012\u0004\u0012\u00020%\u0018\u00010\u00112%\b\n\u0010&\u001a\u001f\u0012\u0013\u0012\u0011H\u001f¢\u0006\f\b\"\u0012\b\b#\u0012\u0004\b\b($\u0012\u0006\u0012\u0004\u0018\u00010%0\u001123\b\u0004\u0010'\u001a-\u0012\u0004\u0012\u00020)\u0012\u0013\u0012\u0011H\u001f¢\u0006\f\b\"\u0012\b\b#\u0012\u0004\b\b($\u0012\u0004\u0012\u00020\u00010(¢\u0006\u0002\b*¢\u0006\u0002\b\u0013H\u0086\b¢\u0006\u0002\u0010+\u001a\u0082\u0001\u0010\u001e\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u001f*\u00020\u00122\f\u0010\u001e\u001a\b\u0012\u0004\u0012\u0002H\u001f0 2%\b\n\u0010!\u001a\u001f\u0012\u0013\u0012\u0011H\u001f¢\u0006\f\b\"\u0012\b\b#\u0012\u0004\b\b($\u0012\u0004\u0012\u00020%\u0018\u00010\u001123\b\u0004\u0010'\u001a-\u0012\u0004\u0012\u00020)\u0012\u0013\u0012\u0011H\u001f¢\u0006\f\b\"\u0012\b\b#\u0012\u0004\b\b($\u0012\u0004\u0012\u00020\u00010(¢\u0006\u0002\b*¢\u0006\u0002\b\u0013H\u0087\b¢\u0006\u0002\u0010,\u001a©\u0001\u0010\u001e\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u001f*\u00020\u00122\f\u0010\u001e\u001a\b\u0012\u0004\u0012\u0002H\u001f0-2%\b\n\u0010!\u001a\u001f\u0012\u0013\u0012\u0011H\u001f¢\u0006\f\b\"\u0012\b\b#\u0012\u0004\b\b($\u0012\u0004\u0012\u00020%\u0018\u00010\u00112%\b\n\u0010&\u001a\u001f\u0012\u0013\u0012\u0011H\u001f¢\u0006\f\b\"\u0012\b\b#\u0012\u0004\b\b($\u0012\u0006\u0012\u0004\u0018\u00010%0\u001123\b\u0004\u0010'\u001a-\u0012\u0004\u0012\u00020)\u0012\u0013\u0012\u0011H\u001f¢\u0006\f\b\"\u0012\b\b#\u0012\u0004\b\b($\u0012\u0004\u0012\u00020\u00010(¢\u0006\u0002\b*¢\u0006\u0002\b\u0013H\u0086\b¢\u0006\u0002\u0010.\u001a\u0082\u0001\u0010\u001e\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u001f*\u00020\u00122\f\u0010\u001e\u001a\b\u0012\u0004\u0012\u0002H\u001f0-2%\b\n\u0010!\u001a\u001f\u0012\u0013\u0012\u0011H\u001f¢\u0006\f\b\"\u0012\b\b#\u0012\u0004\b\b($\u0012\u0004\u0012\u00020%\u0018\u00010\u001123\b\u0004\u0010'\u001a-\u0012\u0004\u0012\u00020)\u0012\u0013\u0012\u0011H\u001f¢\u0006\f\b\"\u0012\b\b#\u0012\u0004\b\b($\u0012\u0004\u0012\u00020\u00010(¢\u0006\u0002\b*¢\u0006\u0002\b\u0013H\u0087\b¢\u0006\u0002\u0010/\u001aè\u0001\u00100\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u001f*\u00020\u00122\f\u0010\u001e\u001a\b\u0012\u0004\u0012\u0002H\u001f0 2:\b\n\u0010!\u001a4\u0012\u0013\u0012\u001101¢\u0006\f\b\"\u0012\b\b#\u0012\u0004\b\b(2\u0012\u0013\u0012\u0011H\u001f¢\u0006\f\b\"\u0012\b\b#\u0012\u0004\b\b($\u0012\u0004\u0012\u00020%\u0018\u00010(2:\b\u0006\u0010&\u001a4\u0012\u0013\u0012\u001101¢\u0006\f\b\"\u0012\b\b#\u0012\u0004\b\b(2\u0012\u0013\u0012\u0011H\u001f¢\u0006\f\b\"\u0012\b\b#\u0012\u0004\b\b($\u0012\u0006\u0012\u0004\u0018\u00010%0(2H\b\u0004\u0010'\u001aB\u0012\u0004\u0012\u00020)\u0012\u0013\u0012\u001101¢\u0006\f\b\"\u0012\b\b#\u0012\u0004\b\b(2\u0012\u0013\u0012\u0011H\u001f¢\u0006\f\b\"\u0012\b\b#\u0012\u0004\b\b($\u0012\u0004\u0012\u00020\u000103¢\u0006\u0002\b*¢\u0006\u0002\b\u0013H\u0086\b¢\u0006\u0002\u00104\u001a¬\u0001\u00100\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u001f*\u00020\u00122\f\u0010\u001e\u001a\b\u0012\u0004\u0012\u0002H\u001f0 2:\b\n\u0010!\u001a4\u0012\u0013\u0012\u001101¢\u0006\f\b\"\u0012\b\b#\u0012\u0004\b\b(2\u0012\u0013\u0012\u0011H\u001f¢\u0006\f\b\"\u0012\b\b#\u0012\u0004\b\b($\u0012\u0004\u0012\u00020%\u0018\u00010(2H\b\u0004\u0010'\u001aB\u0012\u0004\u0012\u00020)\u0012\u0013\u0012\u001101¢\u0006\f\b\"\u0012\b\b#\u0012\u0004\b\b(2\u0012\u0013\u0012\u0011H\u001f¢\u0006\f\b\"\u0012\b\b#\u0012\u0004\b\b($\u0012\u0004\u0012\u00020\u000103¢\u0006\u0002\b*¢\u0006\u0002\b\u0013H\u0087\b¢\u0006\u0002\u00105\u001aè\u0001\u00100\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u001f*\u00020\u00122\f\u0010\u001e\u001a\b\u0012\u0004\u0012\u0002H\u001f0-2:\b\n\u0010!\u001a4\u0012\u0013\u0012\u001101¢\u0006\f\b\"\u0012\b\b#\u0012\u0004\b\b(2\u0012\u0013\u0012\u0011H\u001f¢\u0006\f\b\"\u0012\b\b#\u0012\u0004\b\b($\u0012\u0004\u0012\u00020%\u0018\u00010(2:\b\u0006\u0010&\u001a4\u0012\u0013\u0012\u001101¢\u0006\f\b\"\u0012\b\b#\u0012\u0004\b\b(2\u0012\u0013\u0012\u0011H\u001f¢\u0006\f\b\"\u0012\b\b#\u0012\u0004\b\b($\u0012\u0006\u0012\u0004\u0018\u00010%0(2H\b\u0004\u0010'\u001aB\u0012\u0004\u0012\u00020)\u0012\u0013\u0012\u001101¢\u0006\f\b\"\u0012\b\b#\u0012\u0004\b\b(2\u0012\u0013\u0012\u0011H\u001f¢\u0006\f\b\"\u0012\b\b#\u0012\u0004\b\b($\u0012\u0004\u0012\u00020\u000103¢\u0006\u0002\b*¢\u0006\u0002\b\u0013H\u0086\b¢\u0006\u0002\u00106\u001a¬\u0001\u00100\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u001f*\u00020\u00122\f\u0010\u001e\u001a\b\u0012\u0004\u0012\u0002H\u001f0-2:\b\n\u0010!\u001a4\u0012\u0013\u0012\u001101¢\u0006\f\b\"\u0012\b\b#\u0012\u0004\b\b(2\u0012\u0013\u0012\u0011H\u001f¢\u0006\f\b\"\u0012\b\b#\u0012\u0004\b\b($\u0012\u0004\u0012\u00020%\u0018\u00010(2H\b\u0004\u0010'\u001aB\u0012\u0004\u0012\u00020)\u0012\u0013\u0012\u001101¢\u0006\f\b\"\u0012\b\b#\u0012\u0004\b\b(2\u0012\u0013\u0012\u0011H\u001f¢\u0006\f\b\"\u0012\b\b#\u0012\u0004\b\b($\u0012\u0004\u0012\u00020\u000103¢\u0006\u0002\b*¢\u0006\u0002\b\u0013H\u0087\b¢\u0006\u0002\u00107¨\u00068"}, m13886d2 = {"LazyColumn", "", "modifier", "Landroidx/compose/ui/Modifier;", "state", "Landroidx/compose/foundation/lazy/LazyListState;", "contentPadding", "Landroidx/compose/foundation/layout/PaddingValues;", "reverseLayout", "", "verticalArrangement", "Landroidx/compose/foundation/layout/Arrangement$Vertical;", "horizontalAlignment", "Landroidx/compose/ui/Alignment$Horizontal;", "flingBehavior", "Landroidx/compose/foundation/gestures/FlingBehavior;", "content", "Lkotlin/Function1;", "Landroidx/compose/foundation/lazy/LazyListScope;", "Lkotlin/ExtensionFunctionType;", "(Landroidx/compose/ui/Modifier;Landroidx/compose/foundation/lazy/LazyListState;Landroidx/compose/foundation/layout/PaddingValues;ZLandroidx/compose/foundation/layout/Arrangement$Vertical;Landroidx/compose/ui/Alignment$Horizontal;Landroidx/compose/foundation/gestures/FlingBehavior;Lkotlin/jvm/functions/Function1;Landroidx/compose/runtime/Composer;II)V", "userScrollEnabled", "(Landroidx/compose/ui/Modifier;Landroidx/compose/foundation/lazy/LazyListState;Landroidx/compose/foundation/layout/PaddingValues;ZLandroidx/compose/foundation/layout/Arrangement$Vertical;Landroidx/compose/ui/Alignment$Horizontal;Landroidx/compose/foundation/gestures/FlingBehavior;ZLkotlin/jvm/functions/Function1;Landroidx/compose/runtime/Composer;II)V", "LazyRow", "horizontalArrangement", "Landroidx/compose/foundation/layout/Arrangement$Horizontal;", "verticalAlignment", "Landroidx/compose/ui/Alignment$Vertical;", "(Landroidx/compose/ui/Modifier;Landroidx/compose/foundation/lazy/LazyListState;Landroidx/compose/foundation/layout/PaddingValues;ZLandroidx/compose/foundation/layout/Arrangement$Horizontal;Landroidx/compose/ui/Alignment$Vertical;Landroidx/compose/foundation/gestures/FlingBehavior;Lkotlin/jvm/functions/Function1;Landroidx/compose/runtime/Composer;II)V", "(Landroidx/compose/ui/Modifier;Landroidx/compose/foundation/lazy/LazyListState;Landroidx/compose/foundation/layout/PaddingValues;ZLandroidx/compose/foundation/layout/Arrangement$Horizontal;Landroidx/compose/ui/Alignment$Vertical;Landroidx/compose/foundation/gestures/FlingBehavior;ZLkotlin/jvm/functions/Function1;Landroidx/compose/runtime/Composer;II)V", "items", "T", "", "key", "Lkotlin/ParameterName;", "name", "item", "", "contentType", "itemContent", "Lkotlin/Function2;", "Landroidx/compose/foundation/lazy/LazyItemScope;", "Landroidx/compose/runtime/Composable;", "(Landroidx/compose/foundation/lazy/LazyListScope;[Ljava/lang/Object;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function4;)V", "(Landroidx/compose/foundation/lazy/LazyListScope;[Ljava/lang/Object;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function4;)V", "", "(Landroidx/compose/foundation/lazy/LazyListScope;Ljava/util/List;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function4;)V", "(Landroidx/compose/foundation/lazy/LazyListScope;Ljava/util/List;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function4;)V", "itemsIndexed", "", "index", "Lkotlin/Function3;", "(Landroidx/compose/foundation/lazy/LazyListScope;[Ljava/lang/Object;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function5;)V", "(Landroidx/compose/foundation/lazy/LazyListScope;[Ljava/lang/Object;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function5;)V", "(Landroidx/compose/foundation/lazy/LazyListScope;Ljava/util/List;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function5;)V", "(Landroidx/compose/foundation/lazy/LazyListScope;Ljava/util/List;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function5;)V", "foundation_release"}, m13887k = 2, m13888mv = {1, 8, 0}, m13890xi = 48)
@SourceDebugExtension({"SMAP\nLazyDsl.kt\nKotlin\n*S Kotlin\n*F\n+ 1 LazyDsl.kt\nandroidx/compose/foundation/lazy/LazyDslKt\n+ 2 Dp.kt\nandroidx/compose/ui/unit/DpKt\n*L\n1#1,433:1\n143#1,12:434\n179#1,12:446\n215#1,12:458\n251#1,12:470\n149#2:482\n149#2:483\n149#2:484\n149#2:485\n*S KotlinDebug\n*F\n+ 1 LazyDsl.kt\nandroidx/compose/foundation/lazy/LazyDslKt\n*L\n161#1:434,12\n197#1:446,12\n233#1:458,12\n269#1:470,12\n303#1:482\n359#1:483\n387#1:484\n413#1:485\n*E\n"})
public final class LazyDslKt {

    /* JADX INFO: renamed from: androidx.compose.foundation.lazy.LazyDslKt$items$1 */
    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0001\n\u0002\b\u0004\u0010\u0000\u001a\u0004\u0018\u00010\u0001\"\u0004\b\u0000\u0010\u00022\u0006\u0010\u0003\u001a\u0002H\u0002H\n¢\u0006\u0004\b\u0004\u0010\u0005"}, m13886d2 = {"<anonymous>", "", "T", LangPackConfigConstants.LANGUAGE_CODE_IT, "invoke", "(Ljava/lang/Object;)Ljava/lang/Void;"}, m13887k = 3, m13888mv = {1, 8, 0}, m13890xi = 176)
    @SourceDebugExtension({"SMAP\nLazyDsl.kt\nKotlin\n*S Kotlin\n*F\n+ 1 LazyDsl.kt\nandroidx/compose/foundation/lazy/LazyDslKt$items$1\n*L\n1#1,433:1\n*E\n"})
    public static final class C10431 extends Lambda implements Function1 {
        public static final C10431 INSTANCE = new C10431();

        public C10431() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        @Nullable
        public final Void invoke(Object obj) {
            return null;
        }
    }

    /* JADX INFO: renamed from: androidx.compose.foundation.lazy.LazyDslKt$items$2 */
    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u00022\u0006\u0010\u0003\u001a\u00020\u0004H\n¢\u0006\u0002\b\u0005"}, m13886d2 = {"<anonymous>", "", "T", "index", "", "invoke"}, m13887k = 3, m13888mv = {1, 8, 0}, m13890xi = 176)
    @SourceDebugExtension({"SMAP\nLazyDsl.kt\nKotlin\n*S Kotlin\n*F\n+ 1 LazyDsl.kt\nandroidx/compose/foundation/lazy/LazyDslKt$items$2\n*L\n1#1,433:1\n*E\n"})
    public static final class C10442 extends Lambda implements Function1<Integer, Object> {
        final /* synthetic */ List<T> $items;
        final /* synthetic */ Function1<T, Object> $key;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        public C10442(Function1<? super T, ? extends Object> function1, List<? extends T> list) {
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

    /* JADX INFO: renamed from: androidx.compose.foundation.lazy.LazyDslKt$items$3 */
    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\u0010\u0000\u001a\u0004\u0018\u00010\u0001\"\u0004\b\u0000\u0010\u00022\u0006\u0010\u0003\u001a\u00020\u0004H\n¢\u0006\u0002\b\u0005"}, m13886d2 = {"<anonymous>", "", "T", "index", "", "invoke"}, m13887k = 3, m13888mv = {1, 8, 0}, m13890xi = 176)
    @SourceDebugExtension({"SMAP\nLazyDsl.kt\nKotlin\n*S Kotlin\n*F\n+ 1 LazyDsl.kt\nandroidx/compose/foundation/lazy/LazyDslKt$items$3\n*L\n1#1,433:1\n*E\n"})
    public static final class C10453 extends Lambda implements Function1<Integer, Object> {
        final /* synthetic */ Function1<T, Object> $contentType;
        final /* synthetic */ List<T> $items;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        public C10453(Function1<? super T, ? extends Object> function1, List<? extends T> list) {
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

    /* JADX INFO: renamed from: androidx.compose.foundation.lazy.LazyDslKt$items$4 */
    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000\u0016\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u000b¢\u0006\u0004\b\u0006\u0010\u0007"}, m13886d2 = {"<anonymous>", "", "T", "Landroidx/compose/foundation/lazy/LazyItemScope;", LangPackConfigConstants.LANGUAGE_CODE_IT, "", "invoke", "(Landroidx/compose/foundation/lazy/LazyItemScope;ILandroidx/compose/runtime/Composer;I)V"}, m13887k = 3, m13888mv = {1, 8, 0}, m13890xi = 176)
    @SourceDebugExtension({"SMAP\nLazyDsl.kt\nKotlin\n*S Kotlin\n*F\n+ 1 LazyDsl.kt\nandroidx/compose/foundation/lazy/LazyDslKt$items$4\n*L\n1#1,433:1\n*E\n"})
    public static final class C10464 extends Lambda implements Function4<LazyItemScope, Integer, Composer, Integer, Unit> {
        final /* synthetic */ Function4<LazyItemScope, T, Composer, Integer, Unit> $itemContent;
        final /* synthetic */ List<T> $items;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        public C10464(Function4<? super LazyItemScope, ? super T, ? super Composer, ? super Integer, Unit> function4, List<? extends T> list) {
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
        public final void invoke(@NotNull LazyItemScope lazyItemScope, int i, @Nullable Composer composer, int i2) {
            int i4;
            if ((i2 & 6) == 0) {
                i4 = (composer.changed(lazyItemScope) ? 4 : 2) | i2;
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
                ComposerKt.traceEventStart(-632812321, i4, -1, "androidx.compose.foundation.lazy.items.<anonymous> (LazyDsl.kt:152)");
            }
            this.$itemContent.invoke(lazyItemScope, (T) this.$items.get(i), composer, Integer.valueOf(i4 & 14));
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
    }

    /* JADX INFO: renamed from: androidx.compose.foundation.lazy.LazyDslKt$items$5 */
    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0001\n\u0002\b\u0004\u0010\u0000\u001a\u0004\u0018\u00010\u0001\"\u0004\b\u0000\u0010\u00022\u0006\u0010\u0003\u001a\u0002H\u0002H\n¢\u0006\u0004\b\u0004\u0010\u0005"}, m13886d2 = {"<anonymous>", "", "T", LangPackConfigConstants.LANGUAGE_CODE_IT, "invoke", "(Ljava/lang/Object;)Ljava/lang/Void;"}, m13887k = 3, m13888mv = {1, 8, 0}, m13890xi = 176)
    @SourceDebugExtension({"SMAP\nLazyDsl.kt\nKotlin\n*S Kotlin\n*F\n+ 1 LazyDsl.kt\nandroidx/compose/foundation/lazy/LazyDslKt$items$5\n*L\n1#1,433:1\n*E\n"})
    public static final class C10475 extends Lambda implements Function1 {
        public static final C10475 INSTANCE = new C10475();

        public C10475() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        @Nullable
        public final Void invoke(Object obj) {
            return null;
        }
    }

    /* JADX INFO: renamed from: androidx.compose.foundation.lazy.LazyDslKt$items$6 */
    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u00022\u0006\u0010\u0003\u001a\u00020\u0004H\n¢\u0006\u0002\b\u0005"}, m13886d2 = {"<anonymous>", "", "T", "index", "", "invoke"}, m13887k = 3, m13888mv = {1, 8, 0}, m13890xi = 176)
    @SourceDebugExtension({"SMAP\nLazyDsl.kt\nKotlin\n*S Kotlin\n*F\n+ 1 LazyDsl.kt\nandroidx/compose/foundation/lazy/LazyDslKt$items$6\n*L\n1#1,433:1\n*E\n"})
    public static final class C10486 extends Lambda implements Function1<Integer, Object> {
        final /* synthetic */ T[] $items;
        final /* synthetic */ Function1<T, Object> $key;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        public C10486(Function1<? super T, ? extends Object> function1, T[] tArr) {
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

    /* JADX INFO: renamed from: androidx.compose.foundation.lazy.LazyDslKt$items$7 */
    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\u0010\u0000\u001a\u0004\u0018\u00010\u0001\"\u0004\b\u0000\u0010\u00022\u0006\u0010\u0003\u001a\u00020\u0004H\n¢\u0006\u0002\b\u0005"}, m13886d2 = {"<anonymous>", "", "T", "index", "", "invoke"}, m13887k = 3, m13888mv = {1, 8, 0}, m13890xi = 176)
    @SourceDebugExtension({"SMAP\nLazyDsl.kt\nKotlin\n*S Kotlin\n*F\n+ 1 LazyDsl.kt\nandroidx/compose/foundation/lazy/LazyDslKt$items$7\n*L\n1#1,433:1\n*E\n"})
    public static final class C10497 extends Lambda implements Function1<Integer, Object> {
        final /* synthetic */ Function1<T, Object> $contentType;
        final /* synthetic */ T[] $items;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        public C10497(Function1<? super T, ? extends Object> function1, T[] tArr) {
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

    /* JADX INFO: renamed from: androidx.compose.foundation.lazy.LazyDslKt$items$8 */
    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000\u0016\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u000b¢\u0006\u0004\b\u0006\u0010\u0007"}, m13886d2 = {"<anonymous>", "", "T", "Landroidx/compose/foundation/lazy/LazyItemScope;", LangPackConfigConstants.LANGUAGE_CODE_IT, "", "invoke", "(Landroidx/compose/foundation/lazy/LazyItemScope;ILandroidx/compose/runtime/Composer;I)V"}, m13887k = 3, m13888mv = {1, 8, 0}, m13890xi = 176)
    @SourceDebugExtension({"SMAP\nLazyDsl.kt\nKotlin\n*S Kotlin\n*F\n+ 1 LazyDsl.kt\nandroidx/compose/foundation/lazy/LazyDslKt$items$8\n*L\n1#1,433:1\n*E\n"})
    public static final class C10508 extends Lambda implements Function4<LazyItemScope, Integer, Composer, Integer, Unit> {
        final /* synthetic */ Function4<LazyItemScope, T, Composer, Integer, Unit> $itemContent;
        final /* synthetic */ T[] $items;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        public C10508(Function4<? super LazyItemScope, ? super T, ? super Composer, ? super Integer, Unit> function4, T[] tArr) {
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
        public final void invoke(@NotNull LazyItemScope lazyItemScope, int i, @Nullable Composer composer, int i2) {
            int i4;
            if ((i2 & 6) == 0) {
                i4 = (composer.changed(lazyItemScope) ? 4 : 2) | i2;
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
                ComposerKt.traceEventStart(-1043393750, i4, -1, "androidx.compose.foundation.lazy.items.<anonymous> (LazyDsl.kt:224)");
            }
            this.$itemContent.invoke(lazyItemScope, this.$items[i], composer, Integer.valueOf(i4 & 14));
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
    }

    /* JADX INFO: renamed from: androidx.compose.foundation.lazy.LazyDslKt$itemsIndexed$2 */
    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u00022\u0006\u0010\u0003\u001a\u00020\u0004H\n¢\u0006\u0002\b\u0005"}, m13886d2 = {"<anonymous>", "", "T", "index", "", "invoke"}, m13887k = 3, m13888mv = {1, 8, 0}, m13890xi = 176)
    @SourceDebugExtension({"SMAP\nLazyDsl.kt\nKotlin\n*S Kotlin\n*F\n+ 1 LazyDsl.kt\nandroidx/compose/foundation/lazy/LazyDslKt$itemsIndexed$2\n*L\n1#1,433:1\n*E\n"})
    public static final class C10522 extends Lambda implements Function1<Integer, Object> {
        final /* synthetic */ List<T> $items;
        final /* synthetic */ Function2<Integer, T, Object> $key;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        public C10522(Function2<? super Integer, ? super T, ? extends Object> function2, List<? extends T> list) {
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

    /* JADX INFO: renamed from: androidx.compose.foundation.lazy.LazyDslKt$itemsIndexed$3 */
    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\u0010\u0000\u001a\u0004\u0018\u00010\u0001\"\u0004\b\u0000\u0010\u00022\u0006\u0010\u0003\u001a\u00020\u0004H\n¢\u0006\u0002\b\u0005"}, m13886d2 = {"<anonymous>", "", "T", "index", "", "invoke"}, m13887k = 3, m13888mv = {1, 8, 0}, m13890xi = 176)
    @SourceDebugExtension({"SMAP\nLazyDsl.kt\nKotlin\n*S Kotlin\n*F\n+ 1 LazyDsl.kt\nandroidx/compose/foundation/lazy/LazyDslKt$itemsIndexed$3\n*L\n1#1,433:1\n*E\n"})
    public static final class C10533 extends Lambda implements Function1<Integer, Object> {
        final /* synthetic */ Function2<Integer, T, Object> $contentType;
        final /* synthetic */ List<T> $items;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        public C10533(Function2<? super Integer, ? super T, ? extends Object> function2, List<? extends T> list) {
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

    /* JADX INFO: renamed from: androidx.compose.foundation.lazy.LazyDslKt$itemsIndexed$4 */
    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000\u0016\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u000b¢\u0006\u0004\b\u0006\u0010\u0007"}, m13886d2 = {"<anonymous>", "", "T", "Landroidx/compose/foundation/lazy/LazyItemScope;", LangPackConfigConstants.LANGUAGE_CODE_IT, "", "invoke", "(Landroidx/compose/foundation/lazy/LazyItemScope;ILandroidx/compose/runtime/Composer;I)V"}, m13887k = 3, m13888mv = {1, 8, 0}, m13890xi = 176)
    @SourceDebugExtension({"SMAP\nLazyDsl.kt\nKotlin\n*S Kotlin\n*F\n+ 1 LazyDsl.kt\nandroidx/compose/foundation/lazy/LazyDslKt$itemsIndexed$4\n*L\n1#1,433:1\n*E\n"})
    public static final class C10544 extends Lambda implements Function4<LazyItemScope, Integer, Composer, Integer, Unit> {
        final /* synthetic */ Function5<LazyItemScope, Integer, T, Composer, Integer, Unit> $itemContent;
        final /* synthetic */ List<T> $items;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        public C10544(Function5<? super LazyItemScope, ? super Integer, ? super T, ? super Composer, ? super Integer, Unit> function5, List<? extends T> list) {
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
        public final void invoke(@NotNull LazyItemScope lazyItemScope, int i, @Nullable Composer composer, int i2) {
            int i4;
            if ((i2 & 6) == 0) {
                i4 = (composer.changed(lazyItemScope) ? 4 : 2) | i2;
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
                ComposerKt.traceEventStart(-1091073711, i4, -1, "androidx.compose.foundation.lazy.itemsIndexed.<anonymous> (LazyDsl.kt:188)");
            }
            this.$itemContent.invoke(lazyItemScope, Integer.valueOf(i), (T) this.$items.get(i), composer, Integer.valueOf(i4 & 126));
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
    }

    /* JADX INFO: renamed from: androidx.compose.foundation.lazy.LazyDslKt$itemsIndexed$6 */
    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u00022\u0006\u0010\u0003\u001a\u00020\u0004H\n¢\u0006\u0002\b\u0005"}, m13886d2 = {"<anonymous>", "", "T", "index", "", "invoke"}, m13887k = 3, m13888mv = {1, 8, 0}, m13890xi = 176)
    @SourceDebugExtension({"SMAP\nLazyDsl.kt\nKotlin\n*S Kotlin\n*F\n+ 1 LazyDsl.kt\nandroidx/compose/foundation/lazy/LazyDslKt$itemsIndexed$6\n*L\n1#1,433:1\n*E\n"})
    public static final class C10566 extends Lambda implements Function1<Integer, Object> {
        final /* synthetic */ T[] $items;
        final /* synthetic */ Function2<Integer, T, Object> $key;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        public C10566(Function2<? super Integer, ? super T, ? extends Object> function2, T[] tArr) {
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

    /* JADX INFO: renamed from: androidx.compose.foundation.lazy.LazyDslKt$itemsIndexed$7 */
    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\u0010\u0000\u001a\u0004\u0018\u00010\u0001\"\u0004\b\u0000\u0010\u00022\u0006\u0010\u0003\u001a\u00020\u0004H\n¢\u0006\u0002\b\u0005"}, m13886d2 = {"<anonymous>", "", "T", "index", "", "invoke"}, m13887k = 3, m13888mv = {1, 8, 0}, m13890xi = 176)
    @SourceDebugExtension({"SMAP\nLazyDsl.kt\nKotlin\n*S Kotlin\n*F\n+ 1 LazyDsl.kt\nandroidx/compose/foundation/lazy/LazyDslKt$itemsIndexed$7\n*L\n1#1,433:1\n*E\n"})
    public static final class C10577 extends Lambda implements Function1<Integer, Object> {
        final /* synthetic */ Function2<Integer, T, Object> $contentType;
        final /* synthetic */ T[] $items;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        public C10577(Function2<? super Integer, ? super T, ? extends Object> function2, T[] tArr) {
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

    /* JADX INFO: renamed from: androidx.compose.foundation.lazy.LazyDslKt$itemsIndexed$8 */
    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000\u0016\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u000b¢\u0006\u0004\b\u0006\u0010\u0007"}, m13886d2 = {"<anonymous>", "", "T", "Landroidx/compose/foundation/lazy/LazyItemScope;", LangPackConfigConstants.LANGUAGE_CODE_IT, "", "invoke", "(Landroidx/compose/foundation/lazy/LazyItemScope;ILandroidx/compose/runtime/Composer;I)V"}, m13887k = 3, m13888mv = {1, 8, 0}, m13890xi = 176)
    @SourceDebugExtension({"SMAP\nLazyDsl.kt\nKotlin\n*S Kotlin\n*F\n+ 1 LazyDsl.kt\nandroidx/compose/foundation/lazy/LazyDslKt$itemsIndexed$8\n*L\n1#1,433:1\n*E\n"})
    public static final class C10588 extends Lambda implements Function4<LazyItemScope, Integer, Composer, Integer, Unit> {
        final /* synthetic */ Function5<LazyItemScope, Integer, T, Composer, Integer, Unit> $itemContent;
        final /* synthetic */ T[] $items;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        public C10588(Function5<? super LazyItemScope, ? super Integer, ? super T, ? super Composer, ? super Integer, Unit> function5, T[] tArr) {
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
        public final void invoke(@NotNull LazyItemScope lazyItemScope, int i, @Nullable Composer composer, int i2) {
            int i4;
            if ((i2 & 6) == 0) {
                i4 = (composer.changed(lazyItemScope) ? 4 : 2) | i2;
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
                ComposerKt.traceEventStart(1600639390, i4, -1, "androidx.compose.foundation.lazy.itemsIndexed.<anonymous> (LazyDsl.kt:260)");
            }
            this.$itemContent.invoke(lazyItemScope, Integer.valueOf(i), this.$items[i], composer, Integer.valueOf(i4 & 126));
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:103:0x011b  */
    /* JADX WARN: Removed duplicated region for block: B:107:0x0132  */
    /* JADX WARN: Removed duplicated region for block: B:123:0x0168  */
    /* JADX WARN: Removed duplicated region for block: B:124:0x016a  */
    /* JADX WARN: Removed duplicated region for block: B:125:0x016d  */
    /* JADX WARN: Removed duplicated region for block: B:128:0x0175  */
    /* JADX WARN: Removed duplicated region for block: B:130:0x017f  */
    /* JADX WARN: Removed duplicated region for block: B:132:0x018b  */
    /* JADX WARN: Removed duplicated region for block: B:135:0x0190  */
    /* JADX WARN: Removed duplicated region for block: B:141:0x01a2  */
    /* JADX WARN: Removed duplicated region for block: B:144:0x01ad  */
    /* JADX WARN: Removed duplicated region for block: B:146:0x01ba  */
    /* JADX WARN: Removed duplicated region for block: B:148:0x01c6  */
    /* JADX WARN: Removed duplicated region for block: B:151:0x01d2  */
    /* JADX WARN: Removed duplicated region for block: B:154:0x021c  */
    /* JADX WARN: Removed duplicated region for block: B:158:0x0231  */
    /* JADX WARN: Removed duplicated region for block: B:160:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:37:0x0065  */
    /* JADX WARN: Removed duplicated region for block: B:39:0x006a  */
    /* JADX WARN: Removed duplicated region for block: B:48:0x0080  */
    /* JADX WARN: Removed duplicated region for block: B:56:0x0095  */
    /* JADX WARN: Removed duplicated region for block: B:59:0x009d  */
    /* JADX WARN: Removed duplicated region for block: B:61:0x00a1  */
    /* JADX WARN: Removed duplicated region for block: B:70:0x00b7  */
    /* JADX WARN: Removed duplicated region for block: B:78:0x00cd  */
    /* JADX WARN: Removed duplicated region for block: B:81:0x00d5  */
    /* JADX WARN: Removed duplicated region for block: B:83:0x00dc  */
    /* JADX WARN: Removed duplicated region for block: B:92:0x00f7  */
    /* JADX WARN: Removed duplicated region for block: B:94:0x00fc  */
    @ComposableTarget(applier = "androidx.compose.ui.UiComposable")
    @Composable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final void LazyColumn(@Nullable Modifier modifier, @Nullable LazyListState lazyListState, @Nullable PaddingValues paddingValues, boolean z, @Nullable Arrangement.Vertical vertical, @Nullable Alignment.Horizontal horizontal, @Nullable FlingBehavior flingBehavior, boolean z2, @NotNull final Function1<? super LazyListScope, Unit> function1, @Nullable Composer composer, final int i, final int i2) {
        Modifier modifier2;
        int i4;
        LazyListState lazyListState2;
        PaddingValues paddingValuesM15847PaddingValues0680j_4;
        int i5;
        boolean z3;
        Arrangement.Vertical top;
        int i6;
        Alignment.Horizontal start;
        FlingBehavior flingBehavior2;
        int i7;
        int i8;
        boolean z4;
        LazyListState lazyListState3;
        Arrangement.Vertical vertical2;
        Alignment.Horizontal horizontal2;
        FlingBehavior flingBehavior3;
        Modifier modifier3;
        Composer composer2;
        final Modifier modifier4;
        final LazyListState lazyListState4;
        final PaddingValues paddingValues2;
        final boolean z5;
        final FlingBehavior flingBehavior4;
        final boolean z6;
        final Alignment.Horizontal horizontal3;
        final Arrangement.Vertical vertical3;
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup;
        Composer composerStartRestartGroup = composer.startRestartGroup(-740714857);
        int i9 = i2 & 1;
        if (i9 != 0) {
            i4 = i | 6;
            modifier2 = modifier;
        } else if ((i & 6) == 0) {
            modifier2 = modifier;
            i4 = (composerStartRestartGroup.changed(modifier2) ? 4 : 2) | i;
        } else {
            modifier2 = modifier;
            i4 = i;
        }
        if ((i & 48) == 0) {
            if ((i2 & 2) == 0) {
                lazyListState2 = lazyListState;
                int i10 = composerStartRestartGroup.changed(lazyListState2) ? 32 : 16;
                i4 |= i10;
            } else {
                lazyListState2 = lazyListState;
            }
            i4 |= i10;
        } else {
            lazyListState2 = lazyListState;
        }
        int i11 = i2 & 4;
        if (i11 != 0) {
            i4 |= 384;
        } else {
            if ((i & 384) == 0) {
                paddingValuesM15847PaddingValues0680j_4 = paddingValues;
                i4 |= composerStartRestartGroup.changed(paddingValuesM15847PaddingValues0680j_4) ? 256 : 128;
            }
            i5 = i2 & 8;
            if (i5 == 0) {
                i4 |= 3072;
            } else {
                if ((i & 3072) == 0) {
                    z3 = z;
                    i4 |= composerStartRestartGroup.changed(z3) ? 2048 : 1024;
                }
                if ((i & 24576) == 0) {
                    if ((i2 & 16) == 0) {
                        top = vertical;
                        int i12 = composerStartRestartGroup.changed(top) ? 16384 : 8192;
                        i4 |= i12;
                    } else {
                        top = vertical;
                    }
                    i4 |= i12;
                } else {
                    top = vertical;
                }
                i6 = i2 & 32;
                if (i6 != 0) {
                    i4 |= 196608;
                } else {
                    if ((196608 & i) == 0) {
                        start = horizontal;
                        i4 |= composerStartRestartGroup.changed(start) ? 131072 : 65536;
                    }
                    if ((1572864 & i) != 0) {
                        if ((i2 & 64) == 0) {
                            flingBehavior2 = flingBehavior;
                            int i13 = composerStartRestartGroup.changed(flingBehavior2) ? 1048576 : 524288;
                            i4 |= i13;
                        } else {
                            flingBehavior2 = flingBehavior;
                        }
                        i4 |= i13;
                    } else {
                        flingBehavior2 = flingBehavior;
                    }
                    i7 = i2 & 128;
                    if (i7 == 0) {
                        i4 |= 12582912;
                    } else {
                        if ((i & 12582912) == 0) {
                            i8 = i7;
                            i4 |= composerStartRestartGroup.changed(z2) ? 8388608 : 4194304;
                        }
                        if ((i2 & 256) == 0) {
                            if ((i & 100663296) == 0) {
                                i4 |= composerStartRestartGroup.changedInstance(function1) ? 67108864 : 33554432;
                            }
                            if ((i4 & 38347923) == 38347922 || !composerStartRestartGroup.getSkipping()) {
                                composerStartRestartGroup.startDefaults();
                                if ((i & 1) != 0 || composerStartRestartGroup.getDefaultsInvalid()) {
                                    Modifier modifier5 = i9 == 0 ? Modifier.INSTANCE : modifier2;
                                    if ((i2 & 2) != 0) {
                                        LazyListState lazyListStateRememberLazyListState = LazyListStateKt.rememberLazyListState(0, 0, composerStartRestartGroup, 0, 3);
                                        i4 &= LttEngineErrors.ERROR_INPAINTING_OCR_BLOCK_TABULAR;
                                        lazyListState2 = lazyListStateRememberLazyListState;
                                    }
                                    if (i11 != 0) {
                                        paddingValuesM15847PaddingValues0680j_4 = PaddingKt.m15847PaddingValues0680j_4(C2256Dp.m20968constructorimpl(0));
                                    }
                                    if (i5 != 0) {
                                        z3 = false;
                                    }
                                    if ((i2 & 16) != 0) {
                                        Arrangement arrangement = Arrangement.INSTANCE;
                                        i4 &= -57345;
                                        top = !z3 ? arrangement.getTop() : arrangement.getBottom();
                                    }
                                    if (i6 != 0) {
                                        start = Alignment.INSTANCE.getStart();
                                    }
                                    if ((i2 & 64) != 0) {
                                        flingBehavior2 = ScrollableDefaults.INSTANCE.flingBehavior(composerStartRestartGroup, 6);
                                        i4 &= -3670017;
                                    }
                                    z4 = i8 == 0 ? true : z2;
                                    lazyListState3 = lazyListState2;
                                    vertical2 = top;
                                    horizontal2 = start;
                                    flingBehavior3 = flingBehavior2;
                                    modifier3 = modifier5;
                                } else {
                                    composerStartRestartGroup.skipToGroupEnd();
                                    if ((i2 & 2) != 0) {
                                        i4 &= LttEngineErrors.ERROR_INPAINTING_OCR_BLOCK_TABULAR;
                                    }
                                    if ((i2 & 16) != 0) {
                                        i4 &= -57345;
                                    }
                                    if ((i2 & 64) != 0) {
                                        i4 &= -3670017;
                                    }
                                    z4 = z2;
                                    lazyListState3 = lazyListState2;
                                    vertical2 = top;
                                    horizontal2 = start;
                                    flingBehavior3 = flingBehavior2;
                                    modifier3 = modifier2;
                                }
                                PaddingValues paddingValues3 = paddingValuesM15847PaddingValues0680j_4;
                                boolean z7 = z3;
                                composerStartRestartGroup.endDefaults();
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventStart(-740714857, i4, -1, "androidx.compose.foundation.lazy.LazyColumn (LazyDsl.kt:366)");
                                }
                                int i14 = i4 >> 3;
                                composer2 = composerStartRestartGroup;
                                LazyListKt.LazyList(modifier3, lazyListState3, paddingValues3, z7, true, flingBehavior3, z4, 0, horizontal2, vertical2, null, null, function1, composer2, (i4 & 14) | 24576 | (i4 & 112) | (i4 & 896) | (i4 & 7168) | (458752 & i14) | (i14 & 3670016) | ((i4 << 9) & 234881024) | ((i4 << 15) & 1879048192), (i4 >> 18) & 896, 3200);
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventEnd();
                                }
                                modifier4 = modifier3;
                                lazyListState4 = lazyListState3;
                                paddingValues2 = paddingValues3;
                                z5 = z7;
                                flingBehavior4 = flingBehavior3;
                                z6 = z4;
                                horizontal3 = horizontal2;
                                vertical3 = vertical2;
                            } else {
                                composerStartRestartGroup.skipToGroupEnd();
                                z6 = z2;
                                composer2 = composerStartRestartGroup;
                                modifier4 = modifier2;
                                lazyListState4 = lazyListState2;
                                paddingValues2 = paddingValuesM15847PaddingValues0680j_4;
                                z5 = z3;
                                vertical3 = top;
                                horizontal3 = start;
                                flingBehavior4 = flingBehavior2;
                            }
                            scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                            if (scopeUpdateScopeEndRestartGroup == null) {
                                scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.foundation.lazy.LazyDslKt.LazyColumn.1
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
                                        LazyDslKt.LazyColumn(modifier4, lazyListState4, paddingValues2, z5, vertical3, horizontal3, flingBehavior4, z6, function1, composer3, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
                                    }
                                });
                                return;
                            }
                            return;
                        }
                        i4 |= 100663296;
                        if ((i4 & 38347923) == 38347922) {
                            composerStartRestartGroup.startDefaults();
                            if ((i & 1) != 0) {
                                if (i9 == 0) {
                                }
                                if ((i2 & 2) != 0) {
                                }
                                if (i11 != 0) {
                                }
                                if (i5 != 0) {
                                }
                                if ((i2 & 16) != 0) {
                                }
                                if (i6 != 0) {
                                }
                                if ((i2 & 64) != 0) {
                                }
                                if (i8 == 0) {
                                }
                                lazyListState3 = lazyListState2;
                                vertical2 = top;
                                horizontal2 = start;
                                flingBehavior3 = flingBehavior2;
                                modifier3 = modifier5;
                                PaddingValues paddingValues32 = paddingValuesM15847PaddingValues0680j_4;
                                boolean z72 = z3;
                                composerStartRestartGroup.endDefaults();
                                if (ComposerKt.isTraceInProgress()) {
                                }
                                int i142 = i4 >> 3;
                                composer2 = composerStartRestartGroup;
                                LazyListKt.LazyList(modifier3, lazyListState3, paddingValues32, z72, true, flingBehavior3, z4, 0, horizontal2, vertical2, null, null, function1, composer2, (i4 & 14) | 24576 | (i4 & 112) | (i4 & 896) | (i4 & 7168) | (458752 & i142) | (i142 & 3670016) | ((i4 << 9) & 234881024) | ((i4 << 15) & 1879048192), (i4 >> 18) & 896, 3200);
                                if (ComposerKt.isTraceInProgress()) {
                                }
                                modifier4 = modifier3;
                                lazyListState4 = lazyListState3;
                                paddingValues2 = paddingValues32;
                                z5 = z72;
                                flingBehavior4 = flingBehavior3;
                                z6 = z4;
                                horizontal3 = horizontal2;
                                vertical3 = vertical2;
                            }
                        }
                        scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                        if (scopeUpdateScopeEndRestartGroup == null) {
                        }
                    }
                    i8 = i7;
                    if ((i2 & 256) == 0) {
                    }
                    if ((i4 & 38347923) == 38347922) {
                    }
                    scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                    if (scopeUpdateScopeEndRestartGroup == null) {
                    }
                }
                start = horizontal;
                if ((1572864 & i) != 0) {
                }
                i7 = i2 & 128;
                if (i7 == 0) {
                }
                i8 = i7;
                if ((i2 & 256) == 0) {
                }
                if ((i4 & 38347923) == 38347922) {
                }
                scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup == null) {
                }
            }
            z3 = z;
            if ((i & 24576) == 0) {
            }
            i6 = i2 & 32;
            if (i6 != 0) {
            }
            start = horizontal;
            if ((1572864 & i) != 0) {
            }
            i7 = i2 & 128;
            if (i7 == 0) {
            }
            i8 = i7;
            if ((i2 & 256) == 0) {
            }
            if ((i4 & 38347923) == 38347922) {
            }
            scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup == null) {
            }
        }
        paddingValuesM15847PaddingValues0680j_4 = paddingValues;
        i5 = i2 & 8;
        if (i5 == 0) {
        }
        z3 = z;
        if ((i & 24576) == 0) {
        }
        i6 = i2 & 32;
        if (i6 != 0) {
        }
        start = horizontal;
        if ((1572864 & i) != 0) {
        }
        i7 = i2 & 128;
        if (i7 == 0) {
        }
        i8 = i7;
        if ((i2 & 256) == 0) {
        }
        if ((i4 & 38347923) == 38347922) {
        }
        scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup == null) {
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:103:0x011b  */
    /* JADX WARN: Removed duplicated region for block: B:107:0x0132  */
    /* JADX WARN: Removed duplicated region for block: B:123:0x0168  */
    /* JADX WARN: Removed duplicated region for block: B:124:0x016a  */
    /* JADX WARN: Removed duplicated region for block: B:125:0x016d  */
    /* JADX WARN: Removed duplicated region for block: B:128:0x0175  */
    /* JADX WARN: Removed duplicated region for block: B:130:0x017f  */
    /* JADX WARN: Removed duplicated region for block: B:132:0x018b  */
    /* JADX WARN: Removed duplicated region for block: B:135:0x0190  */
    /* JADX WARN: Removed duplicated region for block: B:141:0x01a2  */
    /* JADX WARN: Removed duplicated region for block: B:144:0x01ad  */
    /* JADX WARN: Removed duplicated region for block: B:146:0x01ba  */
    /* JADX WARN: Removed duplicated region for block: B:148:0x01c6  */
    /* JADX WARN: Removed duplicated region for block: B:151:0x01d2  */
    /* JADX WARN: Removed duplicated region for block: B:154:0x0219  */
    /* JADX WARN: Removed duplicated region for block: B:158:0x022e  */
    /* JADX WARN: Removed duplicated region for block: B:160:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:37:0x0065  */
    /* JADX WARN: Removed duplicated region for block: B:39:0x006a  */
    /* JADX WARN: Removed duplicated region for block: B:48:0x0080  */
    /* JADX WARN: Removed duplicated region for block: B:56:0x0095  */
    /* JADX WARN: Removed duplicated region for block: B:59:0x009d  */
    /* JADX WARN: Removed duplicated region for block: B:61:0x00a1  */
    /* JADX WARN: Removed duplicated region for block: B:70:0x00b7  */
    /* JADX WARN: Removed duplicated region for block: B:78:0x00cd  */
    /* JADX WARN: Removed duplicated region for block: B:81:0x00d5  */
    /* JADX WARN: Removed duplicated region for block: B:83:0x00dc  */
    /* JADX WARN: Removed duplicated region for block: B:92:0x00f7  */
    /* JADX WARN: Removed duplicated region for block: B:94:0x00fc  */
    @ComposableTarget(applier = "androidx.compose.ui.UiComposable")
    @Composable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final void LazyRow(@Nullable Modifier modifier, @Nullable LazyListState lazyListState, @Nullable PaddingValues paddingValues, boolean z, @Nullable Arrangement.Horizontal horizontal, @Nullable Alignment.Vertical vertical, @Nullable FlingBehavior flingBehavior, boolean z2, @NotNull final Function1<? super LazyListScope, Unit> function1, @Nullable Composer composer, final int i, final int i2) {
        Modifier modifier2;
        int i4;
        LazyListState lazyListState2;
        PaddingValues paddingValuesM15847PaddingValues0680j_4;
        int i5;
        boolean z3;
        Arrangement.Horizontal start;
        int i6;
        Alignment.Vertical top;
        FlingBehavior flingBehavior2;
        int i7;
        int i8;
        boolean z4;
        LazyListState lazyListState3;
        Arrangement.Horizontal horizontal2;
        Alignment.Vertical vertical2;
        FlingBehavior flingBehavior3;
        Modifier modifier3;
        Composer composer2;
        final Modifier modifier4;
        final LazyListState lazyListState4;
        final PaddingValues paddingValues2;
        final boolean z5;
        final FlingBehavior flingBehavior4;
        final boolean z6;
        final Alignment.Vertical vertical3;
        final Arrangement.Horizontal horizontal3;
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup;
        Composer composerStartRestartGroup = composer.startRestartGroup(-1724297413);
        int i9 = i2 & 1;
        if (i9 != 0) {
            i4 = i | 6;
            modifier2 = modifier;
        } else if ((i & 6) == 0) {
            modifier2 = modifier;
            i4 = (composerStartRestartGroup.changed(modifier2) ? 4 : 2) | i;
        } else {
            modifier2 = modifier;
            i4 = i;
        }
        if ((i & 48) == 0) {
            if ((i2 & 2) == 0) {
                lazyListState2 = lazyListState;
                int i10 = composerStartRestartGroup.changed(lazyListState2) ? 32 : 16;
                i4 |= i10;
            } else {
                lazyListState2 = lazyListState;
            }
            i4 |= i10;
        } else {
            lazyListState2 = lazyListState;
        }
        int i11 = i2 & 4;
        if (i11 != 0) {
            i4 |= 384;
        } else {
            if ((i & 384) == 0) {
                paddingValuesM15847PaddingValues0680j_4 = paddingValues;
                i4 |= composerStartRestartGroup.changed(paddingValuesM15847PaddingValues0680j_4) ? 256 : 128;
            }
            i5 = i2 & 8;
            if (i5 == 0) {
                i4 |= 3072;
            } else {
                if ((i & 3072) == 0) {
                    z3 = z;
                    i4 |= composerStartRestartGroup.changed(z3) ? 2048 : 1024;
                }
                if ((i & 24576) == 0) {
                    if ((i2 & 16) == 0) {
                        start = horizontal;
                        int i12 = composerStartRestartGroup.changed(start) ? 16384 : 8192;
                        i4 |= i12;
                    } else {
                        start = horizontal;
                    }
                    i4 |= i12;
                } else {
                    start = horizontal;
                }
                i6 = i2 & 32;
                if (i6 != 0) {
                    i4 |= 196608;
                } else {
                    if ((196608 & i) == 0) {
                        top = vertical;
                        i4 |= composerStartRestartGroup.changed(top) ? 131072 : 65536;
                    }
                    if ((1572864 & i) != 0) {
                        if ((i2 & 64) == 0) {
                            flingBehavior2 = flingBehavior;
                            int i13 = composerStartRestartGroup.changed(flingBehavior2) ? 1048576 : 524288;
                            i4 |= i13;
                        } else {
                            flingBehavior2 = flingBehavior;
                        }
                        i4 |= i13;
                    } else {
                        flingBehavior2 = flingBehavior;
                    }
                    i7 = i2 & 128;
                    if (i7 == 0) {
                        i4 |= 12582912;
                    } else {
                        if ((i & 12582912) == 0) {
                            i8 = i7;
                            i4 |= composerStartRestartGroup.changed(z2) ? 8388608 : 4194304;
                        }
                        if ((i2 & 256) == 0) {
                            if ((i & 100663296) == 0) {
                                i4 |= composerStartRestartGroup.changedInstance(function1) ? 67108864 : 33554432;
                            }
                            if ((i4 & 38347923) == 38347922 || !composerStartRestartGroup.getSkipping()) {
                                composerStartRestartGroup.startDefaults();
                                if ((i & 1) != 0 || composerStartRestartGroup.getDefaultsInvalid()) {
                                    Modifier modifier5 = i9 == 0 ? Modifier.INSTANCE : modifier2;
                                    if ((i2 & 2) != 0) {
                                        LazyListState lazyListStateRememberLazyListState = LazyListStateKt.rememberLazyListState(0, 0, composerStartRestartGroup, 0, 3);
                                        i4 &= LttEngineErrors.ERROR_INPAINTING_OCR_BLOCK_TABULAR;
                                        lazyListState2 = lazyListStateRememberLazyListState;
                                    }
                                    if (i11 != 0) {
                                        paddingValuesM15847PaddingValues0680j_4 = PaddingKt.m15847PaddingValues0680j_4(C2256Dp.m20968constructorimpl(0));
                                    }
                                    if (i5 != 0) {
                                        z3 = false;
                                    }
                                    if ((i2 & 16) != 0) {
                                        Arrangement arrangement = Arrangement.INSTANCE;
                                        i4 &= -57345;
                                        start = !z3 ? arrangement.getStart() : arrangement.getEnd();
                                    }
                                    if (i6 != 0) {
                                        top = Alignment.INSTANCE.getTop();
                                    }
                                    if ((i2 & 64) != 0) {
                                        flingBehavior2 = ScrollableDefaults.INSTANCE.flingBehavior(composerStartRestartGroup, 6);
                                        i4 &= -3670017;
                                    }
                                    z4 = i8 == 0 ? true : z2;
                                    lazyListState3 = lazyListState2;
                                    horizontal2 = start;
                                    vertical2 = top;
                                    flingBehavior3 = flingBehavior2;
                                    modifier3 = modifier5;
                                } else {
                                    composerStartRestartGroup.skipToGroupEnd();
                                    if ((i2 & 2) != 0) {
                                        i4 &= LttEngineErrors.ERROR_INPAINTING_OCR_BLOCK_TABULAR;
                                    }
                                    if ((i2 & 16) != 0) {
                                        i4 &= -57345;
                                    }
                                    if ((i2 & 64) != 0) {
                                        i4 &= -3670017;
                                    }
                                    z4 = z2;
                                    lazyListState3 = lazyListState2;
                                    horizontal2 = start;
                                    vertical2 = top;
                                    flingBehavior3 = flingBehavior2;
                                    modifier3 = modifier2;
                                }
                                PaddingValues paddingValues3 = paddingValuesM15847PaddingValues0680j_4;
                                boolean z7 = z3;
                                composerStartRestartGroup.endDefaults();
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventStart(-1724297413, i4, -1, "androidx.compose.foundation.lazy.LazyRow (LazyDsl.kt:310)");
                                }
                                int i14 = i4 >> 3;
                                composer2 = composerStartRestartGroup;
                                LazyListKt.LazyList(modifier3, lazyListState3, paddingValues3, z7, false, flingBehavior3, z4, 0, null, null, vertical2, horizontal2, function1, composer2, (i4 & 14) | 24576 | (i4 & 112) | (i4 & 896) | (i4 & 7168) | (458752 & i14) | (i14 & 3670016), ((i4 >> 15) & 14) | ((i4 >> 9) & 112) | ((i4 >> 18) & 896), 896);
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventEnd();
                                }
                                modifier4 = modifier3;
                                lazyListState4 = lazyListState3;
                                paddingValues2 = paddingValues3;
                                z5 = z7;
                                flingBehavior4 = flingBehavior3;
                                z6 = z4;
                                vertical3 = vertical2;
                                horizontal3 = horizontal2;
                            } else {
                                composerStartRestartGroup.skipToGroupEnd();
                                z6 = z2;
                                composer2 = composerStartRestartGroup;
                                modifier4 = modifier2;
                                lazyListState4 = lazyListState2;
                                paddingValues2 = paddingValuesM15847PaddingValues0680j_4;
                                z5 = z3;
                                horizontal3 = start;
                                vertical3 = top;
                                flingBehavior4 = flingBehavior2;
                            }
                            scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                            if (scopeUpdateScopeEndRestartGroup == null) {
                                scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.foundation.lazy.LazyDslKt.LazyRow.1
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
                                        LazyDslKt.LazyRow(modifier4, lazyListState4, paddingValues2, z5, horizontal3, vertical3, flingBehavior4, z6, function1, composer3, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
                                    }
                                });
                                return;
                            }
                            return;
                        }
                        i4 |= 100663296;
                        if ((i4 & 38347923) == 38347922) {
                            composerStartRestartGroup.startDefaults();
                            if ((i & 1) != 0) {
                                if (i9 == 0) {
                                }
                                if ((i2 & 2) != 0) {
                                }
                                if (i11 != 0) {
                                }
                                if (i5 != 0) {
                                }
                                if ((i2 & 16) != 0) {
                                }
                                if (i6 != 0) {
                                }
                                if ((i2 & 64) != 0) {
                                }
                                if (i8 == 0) {
                                }
                                lazyListState3 = lazyListState2;
                                horizontal2 = start;
                                vertical2 = top;
                                flingBehavior3 = flingBehavior2;
                                modifier3 = modifier5;
                                PaddingValues paddingValues32 = paddingValuesM15847PaddingValues0680j_4;
                                boolean z72 = z3;
                                composerStartRestartGroup.endDefaults();
                                if (ComposerKt.isTraceInProgress()) {
                                }
                                int i142 = i4 >> 3;
                                composer2 = composerStartRestartGroup;
                                LazyListKt.LazyList(modifier3, lazyListState3, paddingValues32, z72, false, flingBehavior3, z4, 0, null, null, vertical2, horizontal2, function1, composer2, (i4 & 14) | 24576 | (i4 & 112) | (i4 & 896) | (i4 & 7168) | (458752 & i142) | (i142 & 3670016), ((i4 >> 15) & 14) | ((i4 >> 9) & 112) | ((i4 >> 18) & 896), 896);
                                if (ComposerKt.isTraceInProgress()) {
                                }
                                modifier4 = modifier3;
                                lazyListState4 = lazyListState3;
                                paddingValues2 = paddingValues32;
                                z5 = z72;
                                flingBehavior4 = flingBehavior3;
                                z6 = z4;
                                vertical3 = vertical2;
                                horizontal3 = horizontal2;
                            }
                        }
                        scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                        if (scopeUpdateScopeEndRestartGroup == null) {
                        }
                    }
                    i8 = i7;
                    if ((i2 & 256) == 0) {
                    }
                    if ((i4 & 38347923) == 38347922) {
                    }
                    scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                    if (scopeUpdateScopeEndRestartGroup == null) {
                    }
                }
                top = vertical;
                if ((1572864 & i) != 0) {
                }
                i7 = i2 & 128;
                if (i7 == 0) {
                }
                i8 = i7;
                if ((i2 & 256) == 0) {
                }
                if ((i4 & 38347923) == 38347922) {
                }
                scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup == null) {
                }
            }
            z3 = z;
            if ((i & 24576) == 0) {
            }
            i6 = i2 & 32;
            if (i6 != 0) {
            }
            top = vertical;
            if ((1572864 & i) != 0) {
            }
            i7 = i2 & 128;
            if (i7 == 0) {
            }
            i8 = i7;
            if ((i2 & 256) == 0) {
            }
            if ((i4 & 38347923) == 38347922) {
            }
            scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup == null) {
            }
        }
        paddingValuesM15847PaddingValues0680j_4 = paddingValues;
        i5 = i2 & 8;
        if (i5 == 0) {
        }
        z3 = z;
        if ((i & 24576) == 0) {
        }
        i6 = i2 & 32;
        if (i6 != 0) {
        }
        top = vertical;
        if ((1572864 & i) != 0) {
        }
        i7 = i2 & 128;
        if (i7 == 0) {
        }
        i8 = i7;
        if ((i2 & 256) == 0) {
        }
        if ((i4 & 38347923) == 38347922) {
        }
        scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup == null) {
        }
    }

    @ComposableInferredTarget(scheme = "[0[0]]")
    public static final <T> void items(@NotNull LazyListScope lazyListScope, @NotNull List<? extends T> list, @Nullable Function1<? super T, ? extends Object> function1, @NotNull Function1<? super T, ? extends Object> function12, @NotNull Function4<? super LazyItemScope, ? super T, ? super Composer, ? super Integer, Unit> function4) {
        lazyListScope.items(list.size(), function1 != null ? new C10442(function1, list) : null, new C10453(function12, list), ComposableLambdaKt.composableLambdaInstance(-632812321, true, new C10464(function4, list)));
    }

    public static /* synthetic */ void items$default(LazyListScope lazyListScope, List list, Function1 function1, Function1 function12, Function4 function4, int i, Object obj) {
        if ((i & 2) != 0) {
            function1 = null;
        }
        if ((i & 4) != 0) {
            function12 = C10431.INSTANCE;
        }
        lazyListScope.items(list.size(), function1 != null ? new C10442(function1, list) : null, new C10453(function12, list), ComposableLambdaKt.composableLambdaInstance(-632812321, true, new C10464(function4, list)));
    }

    @ComposableInferredTarget(scheme = "[0[0]]")
    public static final <T> void itemsIndexed(@NotNull LazyListScope lazyListScope, @NotNull List<? extends T> list, @Nullable Function2<? super Integer, ? super T, ? extends Object> function2, @NotNull Function2<? super Integer, ? super T, ? extends Object> function22, @NotNull Function5<? super LazyItemScope, ? super Integer, ? super T, ? super Composer, ? super Integer, Unit> function5) {
        lazyListScope.items(list.size(), function2 != null ? new C10522(function2, list) : null, new C10533(function22, list), ComposableLambdaKt.composableLambdaInstance(-1091073711, true, new C10544(function5, list)));
    }

    public static /* synthetic */ void itemsIndexed$default(LazyListScope lazyListScope, List list, Function2 function2, Function2 function22, Function5 function5, int i, Object obj) {
        if ((i & 2) != 0) {
            function2 = null;
        }
        if ((i & 4) != 0) {
            function22 = new Function2() { // from class: androidx.compose.foundation.lazy.LazyDslKt.itemsIndexed.1
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
        lazyListScope.items(list.size(), function2 != null ? new C10522(function2, list) : null, new C10533(function22, list), ComposableLambdaKt.composableLambdaInstance(-1091073711, true, new C10544(function5, list)));
    }

    @ComposableInferredTarget(scheme = "[0[0]]")
    public static final <T> void items(@NotNull LazyListScope lazyListScope, @NotNull T[] tArr, @Nullable Function1<? super T, ? extends Object> function1, @NotNull Function1<? super T, ? extends Object> function12, @NotNull Function4<? super LazyItemScope, ? super T, ? super Composer, ? super Integer, Unit> function4) {
        lazyListScope.items(tArr.length, function1 != null ? new C10486(function1, tArr) : null, new C10497(function12, tArr), ComposableLambdaKt.composableLambdaInstance(-1043393750, true, new C10508(function4, tArr)));
    }

    @ComposableInferredTarget(scheme = "[0[0]]")
    public static final <T> void itemsIndexed(@NotNull LazyListScope lazyListScope, @NotNull T[] tArr, @Nullable Function2<? super Integer, ? super T, ? extends Object> function2, @NotNull Function2<? super Integer, ? super T, ? extends Object> function22, @NotNull Function5<? super LazyItemScope, ? super Integer, ? super T, ? super Composer, ? super Integer, Unit> function5) {
        lazyListScope.items(tArr.length, function2 != null ? new C10566(function2, tArr) : null, new C10577(function22, tArr), ComposableLambdaKt.composableLambdaInstance(1600639390, true, new C10588(function5, tArr)));
    }

    public static /* synthetic */ void items$default(LazyListScope lazyListScope, Object[] objArr, Function1 function1, Function1 function12, Function4 function4, int i, Object obj) {
        if ((i & 2) != 0) {
            function1 = null;
        }
        if ((i & 4) != 0) {
            function12 = C10475.INSTANCE;
        }
        lazyListScope.items(objArr.length, function1 != null ? new C10486(function1, objArr) : null, new C10497(function12, objArr), ComposableLambdaKt.composableLambdaInstance(-1043393750, true, new C10508(function4, objArr)));
    }

    public static /* synthetic */ void itemsIndexed$default(LazyListScope lazyListScope, Object[] objArr, Function2 function2, Function2 function22, Function5 function5, int i, Object obj) {
        if ((i & 2) != 0) {
            function2 = null;
        }
        if ((i & 4) != 0) {
            function22 = new Function2() { // from class: androidx.compose.foundation.lazy.LazyDslKt.itemsIndexed.5
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
        lazyListScope.items(objArr.length, function2 != null ? new C10566(function2, objArr) : null, new C10577(function22, objArr), ComposableLambdaKt.composableLambdaInstance(1600639390, true, new C10588(function5, objArr)));
    }

    public static /* synthetic */ void items$default(LazyListScope lazyListScope, List list, Function1 function1, Function4 function4, int i, Object obj) {
        if ((i & 2) != 0) {
            function1 = null;
        }
        lazyListScope.items(list.size(), function1 != null ? new C10442(function1, list) : null, new C10453(C10431.INSTANCE, list), ComposableLambdaKt.composableLambdaInstance(-632812321, true, new C10464(function4, list)));
    }

    public static /* synthetic */ void itemsIndexed$default(LazyListScope lazyListScope, List list, Function2 function2, Function5 function5, int i, Object obj) {
        if ((i & 2) != 0) {
            function2 = null;
        }
        lazyListScope.items(list.size(), function2 != null ? new C10522(function2, list) : null, new LazyDslKt$itemsIndexed$$inlined$itemsIndexed$default$1(list), ComposableLambdaKt.composableLambdaInstance(-1091073711, true, new C10544(function5, list)));
    }

    public static /* synthetic */ void itemsIndexed$default(LazyListScope lazyListScope, Object[] objArr, Function2 function2, Function5 function5, int i, Object obj) {
        if ((i & 2) != 0) {
            function2 = null;
        }
        lazyListScope.items(objArr.length, function2 != null ? new C10566(function2, objArr) : null, new LazyDslKt$itemsIndexed$$inlined$itemsIndexed$default$2(objArr), ComposableLambdaKt.composableLambdaInstance(1600639390, true, new C10588(function5, objArr)));
    }

    /* JADX WARN: Removed duplicated region for block: B:112:0x0148  */
    /* JADX WARN: Removed duplicated region for block: B:113:0x014a  */
    /* JADX WARN: Removed duplicated region for block: B:114:0x014d  */
    /* JADX WARN: Removed duplicated region for block: B:117:0x0155  */
    /* JADX WARN: Removed duplicated region for block: B:119:0x015e  */
    /* JADX WARN: Removed duplicated region for block: B:121:0x016a  */
    /* JADX WARN: Removed duplicated region for block: B:124:0x016f  */
    /* JADX WARN: Removed duplicated region for block: B:130:0x0182  */
    /* JADX WARN: Removed duplicated region for block: B:133:0x018d  */
    /* JADX WARN: Removed duplicated region for block: B:134:0x01a7  */
    /* JADX WARN: Removed duplicated region for block: B:137:0x01bf  */
    /* JADX WARN: Removed duplicated region for block: B:140:0x01f6  */
    /* JADX WARN: Removed duplicated region for block: B:144:0x0208  */
    /* JADX WARN: Removed duplicated region for block: B:146:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:37:0x0065  */
    /* JADX WARN: Removed duplicated region for block: B:39:0x006a  */
    /* JADX WARN: Removed duplicated region for block: B:48:0x0080  */
    /* JADX WARN: Removed duplicated region for block: B:56:0x0095  */
    /* JADX WARN: Removed duplicated region for block: B:59:0x009d  */
    /* JADX WARN: Removed duplicated region for block: B:61:0x00a1  */
    /* JADX WARN: Removed duplicated region for block: B:70:0x00b7  */
    /* JADX WARN: Removed duplicated region for block: B:78:0x00cd  */
    /* JADX WARN: Removed duplicated region for block: B:81:0x00d5  */
    /* JADX WARN: Removed duplicated region for block: B:83:0x00da  */
    /* JADX WARN: Removed duplicated region for block: B:92:0x00f9  */
    /* JADX WARN: Removed duplicated region for block: B:96:0x010e  */
    @ComposableTarget(applier = "androidx.compose.ui.UiComposable")
    @Deprecated(level = DeprecationLevel.HIDDEN, message = "Use the non deprecated overload")
    @Composable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final /* synthetic */ void LazyColumn(Modifier modifier, LazyListState lazyListState, PaddingValues paddingValues, boolean z, Arrangement.Vertical vertical, Alignment.Horizontal horizontal, FlingBehavior flingBehavior, final Function1 function1, Composer composer, final int i, final int i2) {
        Modifier modifier2;
        int i4;
        LazyListState lazyListState2;
        PaddingValues paddingValuesM15847PaddingValues0680j_4;
        int i5;
        boolean z2;
        Arrangement.Vertical top;
        int i6;
        Alignment.Horizontal start;
        FlingBehavior flingBehavior2;
        PaddingValues paddingValues2;
        Alignment.Horizontal horizontal2;
        int i7;
        int i8;
        boolean z3;
        FlingBehavior flingBehavior3;
        Modifier modifier3;
        Arrangement.Vertical vertical2;
        LazyListState lazyListState3;
        Composer composer2;
        final Modifier modifier4;
        final LazyListState lazyListState4;
        final PaddingValues paddingValues3;
        final boolean z4;
        final Arrangement.Vertical vertical3;
        final Alignment.Horizontal horizontal3;
        final FlingBehavior flingBehavior4;
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup;
        Composer composerStartRestartGroup = composer.startRestartGroup(-563353797);
        int i9 = i2 & 1;
        if (i9 != 0) {
            i4 = i | 6;
            modifier2 = modifier;
        } else if ((i & 6) == 0) {
            modifier2 = modifier;
            i4 = (composerStartRestartGroup.changed(modifier2) ? 4 : 2) | i;
        } else {
            modifier2 = modifier;
            i4 = i;
        }
        if ((i & 48) == 0) {
            if ((i2 & 2) == 0) {
                lazyListState2 = lazyListState;
                int i10 = composerStartRestartGroup.changed(lazyListState2) ? 32 : 16;
                i4 |= i10;
            } else {
                lazyListState2 = lazyListState;
            }
            i4 |= i10;
        } else {
            lazyListState2 = lazyListState;
        }
        int i11 = i2 & 4;
        if (i11 != 0) {
            i4 |= 384;
        } else {
            if ((i & 384) == 0) {
                paddingValuesM15847PaddingValues0680j_4 = paddingValues;
                i4 |= composerStartRestartGroup.changed(paddingValuesM15847PaddingValues0680j_4) ? 256 : 128;
            }
            i5 = i2 & 8;
            if (i5 == 0) {
                i4 |= 3072;
            } else {
                if ((i & 3072) == 0) {
                    z2 = z;
                    i4 |= composerStartRestartGroup.changed(z2) ? 2048 : 1024;
                }
                if ((i & 24576) == 0) {
                    if ((i2 & 16) == 0) {
                        top = vertical;
                        int i12 = composerStartRestartGroup.changed(top) ? 16384 : 8192;
                        i4 |= i12;
                    } else {
                        top = vertical;
                    }
                    i4 |= i12;
                } else {
                    top = vertical;
                }
                i6 = i2 & 32;
                if (i6 != 0) {
                    i4 |= 196608;
                } else {
                    if ((196608 & i) == 0) {
                        start = horizontal;
                        i4 |= composerStartRestartGroup.changed(start) ? 131072 : 65536;
                    }
                    if ((1572864 & i) != 0) {
                        if ((i2 & 64) == 0) {
                            flingBehavior2 = flingBehavior;
                            int i13 = composerStartRestartGroup.changed(flingBehavior2) ? 1048576 : 524288;
                            i4 |= i13;
                        } else {
                            flingBehavior2 = flingBehavior;
                        }
                        i4 |= i13;
                    } else {
                        flingBehavior2 = flingBehavior;
                    }
                    if ((i2 & 128) != 0) {
                        if ((i & 12582912) == 0) {
                            i4 |= composerStartRestartGroup.changedInstance(function1) ? 8388608 : 4194304;
                        }
                        if ((i4 & 4793491) == 4793490 && composerStartRestartGroup.getSkipping()) {
                            composerStartRestartGroup.skipToGroupEnd();
                            composer2 = composerStartRestartGroup;
                            modifier4 = modifier2;
                            lazyListState4 = lazyListState2;
                            paddingValues3 = paddingValuesM15847PaddingValues0680j_4;
                            z4 = z2;
                            vertical3 = top;
                            horizontal3 = start;
                            flingBehavior4 = flingBehavior2;
                        } else {
                            composerStartRestartGroup.startDefaults();
                            if ((i & 1) == 0 && !composerStartRestartGroup.getDefaultsInvalid()) {
                                composerStartRestartGroup.skipToGroupEnd();
                                if ((i2 & 2) != 0) {
                                    i4 &= LttEngineErrors.ERROR_INPAINTING_OCR_BLOCK_TABULAR;
                                }
                                if ((i2 & 16) != 0) {
                                    i4 &= -57345;
                                }
                                if ((i2 & 64) != 0) {
                                    i4 &= -3670017;
                                }
                                paddingValues2 = paddingValuesM15847PaddingValues0680j_4;
                                horizontal2 = start;
                                i7 = 12582912;
                                z3 = z2;
                                flingBehavior3 = flingBehavior2;
                                modifier3 = modifier2;
                                vertical2 = top;
                                i8 = -563353797;
                            } else {
                                Modifier modifier5 = i9 == 0 ? Modifier.INSTANCE : modifier2;
                                if ((i2 & 2) != 0) {
                                    LazyListState lazyListStateRememberLazyListState = LazyListStateKt.rememberLazyListState(0, 0, composerStartRestartGroup, 0, 3);
                                    i4 &= LttEngineErrors.ERROR_INPAINTING_OCR_BLOCK_TABULAR;
                                    lazyListState2 = lazyListStateRememberLazyListState;
                                }
                                if (i11 != 0) {
                                    paddingValuesM15847PaddingValues0680j_4 = PaddingKt.m15847PaddingValues0680j_4(C2256Dp.m20968constructorimpl(0));
                                }
                                if (i5 != 0) {
                                    z2 = false;
                                }
                                if ((i2 & 16) != 0) {
                                    Arrangement arrangement = Arrangement.INSTANCE;
                                    top = !z2 ? arrangement.getTop() : arrangement.getBottom();
                                    i4 &= -57345;
                                }
                                if (i6 != 0) {
                                    start = Alignment.INSTANCE.getStart();
                                }
                                if ((i2 & 64) == 0) {
                                    i4 &= -3670017;
                                    flingBehavior3 = ScrollableDefaults.INSTANCE.flingBehavior(composerStartRestartGroup, 6);
                                    i7 = 12582912;
                                    paddingValues2 = paddingValuesM15847PaddingValues0680j_4;
                                    vertical2 = top;
                                    horizontal2 = start;
                                    i8 = -563353797;
                                    lazyListState3 = lazyListState2;
                                    z3 = z2;
                                    modifier3 = modifier5;
                                    composerStartRestartGroup.endDefaults();
                                    if (ComposerKt.isTraceInProgress()) {
                                        ComposerKt.traceEventStart(i8, i4, -1, "androidx.compose.foundation.lazy.LazyColumn (LazyDsl.kt:393)");
                                    }
                                    composer2 = composerStartRestartGroup;
                                    LazyColumn(modifier3, lazyListState3, paddingValues2, z3, vertical2, horizontal2, flingBehavior3, true, function1, composer2, i7 | (i4 & 14) | (i4 & 112) | (i4 & 896) | (i4 & 7168) | (57344 & i4) | (458752 & i4) | (3670016 & i4) | ((i4 << 3) & 234881024), 0);
                                    if (ComposerKt.isTraceInProgress()) {
                                        ComposerKt.traceEventEnd();
                                    }
                                    modifier4 = modifier3;
                                    lazyListState4 = lazyListState3;
                                    paddingValues3 = paddingValues2;
                                    z4 = z3;
                                    vertical3 = vertical2;
                                    horizontal3 = horizontal2;
                                    flingBehavior4 = flingBehavior3;
                                } else {
                                    paddingValues2 = paddingValuesM15847PaddingValues0680j_4;
                                    horizontal2 = start;
                                    i7 = 12582912;
                                    i8 = -563353797;
                                    z3 = z2;
                                    flingBehavior3 = flingBehavior2;
                                    modifier3 = modifier5;
                                    vertical2 = top;
                                }
                            }
                            lazyListState3 = lazyListState2;
                            composerStartRestartGroup.endDefaults();
                            if (ComposerKt.isTraceInProgress()) {
                            }
                            composer2 = composerStartRestartGroup;
                            LazyColumn(modifier3, lazyListState3, paddingValues2, z3, vertical2, horizontal2, flingBehavior3, true, function1, composer2, i7 | (i4 & 14) | (i4 & 112) | (i4 & 896) | (i4 & 7168) | (57344 & i4) | (458752 & i4) | (3670016 & i4) | ((i4 << 3) & 234881024), 0);
                            if (ComposerKt.isTraceInProgress()) {
                            }
                            modifier4 = modifier3;
                            lazyListState4 = lazyListState3;
                            paddingValues3 = paddingValues2;
                            z4 = z3;
                            vertical3 = vertical2;
                            horizontal3 = horizontal2;
                            flingBehavior4 = flingBehavior3;
                        }
                        scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                        if (scopeUpdateScopeEndRestartGroup != null) {
                            scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.foundation.lazy.LazyDslKt.LazyColumn.2
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

                                public final void invoke(@Nullable Composer composer3, int i14) {
                                    LazyDslKt.LazyColumn(modifier4, lazyListState4, paddingValues3, z4, vertical3, horizontal3, flingBehavior4, function1, composer3, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
                                }
                            });
                            return;
                        }
                        return;
                    }
                    i4 |= 12582912;
                    if ((i4 & 4793491) == 4793490) {
                        composerStartRestartGroup.startDefaults();
                        if ((i & 1) == 0) {
                            Modifier modifier52 = i9 == 0 ? Modifier.INSTANCE : modifier2;
                            if ((i2 & 2) != 0) {
                            }
                            if (i11 != 0) {
                            }
                            if (i5 != 0) {
                            }
                            if ((i2 & 16) != 0) {
                            }
                            if (i6 != 0) {
                            }
                            if ((i2 & 64) == 0) {
                            }
                        }
                    }
                    scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                    if (scopeUpdateScopeEndRestartGroup != null) {
                    }
                }
                start = horizontal;
                if ((1572864 & i) != 0) {
                }
                if ((i2 & 128) != 0) {
                }
                if ((i4 & 4793491) == 4793490) {
                }
                scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup != null) {
                }
            }
            z2 = z;
            if ((i & 24576) == 0) {
            }
            i6 = i2 & 32;
            if (i6 != 0) {
            }
            start = horizontal;
            if ((1572864 & i) != 0) {
            }
            if ((i2 & 128) != 0) {
            }
            if ((i4 & 4793491) == 4793490) {
            }
            scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup != null) {
            }
        }
        paddingValuesM15847PaddingValues0680j_4 = paddingValues;
        i5 = i2 & 8;
        if (i5 == 0) {
        }
        z2 = z;
        if ((i & 24576) == 0) {
        }
        i6 = i2 & 32;
        if (i6 != 0) {
        }
        start = horizontal;
        if ((1572864 & i) != 0) {
        }
        if ((i2 & 128) != 0) {
        }
        if ((i4 & 4793491) == 4793490) {
        }
        scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:112:0x0148  */
    /* JADX WARN: Removed duplicated region for block: B:113:0x014a  */
    /* JADX WARN: Removed duplicated region for block: B:114:0x014d  */
    /* JADX WARN: Removed duplicated region for block: B:117:0x0155  */
    /* JADX WARN: Removed duplicated region for block: B:119:0x015e  */
    /* JADX WARN: Removed duplicated region for block: B:121:0x016a  */
    /* JADX WARN: Removed duplicated region for block: B:124:0x016f  */
    /* JADX WARN: Removed duplicated region for block: B:130:0x0182  */
    /* JADX WARN: Removed duplicated region for block: B:133:0x018d  */
    /* JADX WARN: Removed duplicated region for block: B:134:0x01a7  */
    /* JADX WARN: Removed duplicated region for block: B:137:0x01bf  */
    /* JADX WARN: Removed duplicated region for block: B:140:0x01f6  */
    /* JADX WARN: Removed duplicated region for block: B:144:0x0208  */
    /* JADX WARN: Removed duplicated region for block: B:146:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:37:0x0065  */
    /* JADX WARN: Removed duplicated region for block: B:39:0x006a  */
    /* JADX WARN: Removed duplicated region for block: B:48:0x0080  */
    /* JADX WARN: Removed duplicated region for block: B:56:0x0095  */
    /* JADX WARN: Removed duplicated region for block: B:59:0x009d  */
    /* JADX WARN: Removed duplicated region for block: B:61:0x00a1  */
    /* JADX WARN: Removed duplicated region for block: B:70:0x00b7  */
    /* JADX WARN: Removed duplicated region for block: B:78:0x00cd  */
    /* JADX WARN: Removed duplicated region for block: B:81:0x00d5  */
    /* JADX WARN: Removed duplicated region for block: B:83:0x00da  */
    /* JADX WARN: Removed duplicated region for block: B:92:0x00f9  */
    /* JADX WARN: Removed duplicated region for block: B:96:0x010e  */
    @ComposableTarget(applier = "androidx.compose.ui.UiComposable")
    @Deprecated(level = DeprecationLevel.HIDDEN, message = "Use the non deprecated overload")
    @Composable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final /* synthetic */ void LazyRow(Modifier modifier, LazyListState lazyListState, PaddingValues paddingValues, boolean z, Arrangement.Horizontal horizontal, Alignment.Vertical vertical, FlingBehavior flingBehavior, final Function1 function1, Composer composer, final int i, final int i2) {
        Modifier modifier2;
        int i4;
        LazyListState lazyListState2;
        PaddingValues paddingValuesM15847PaddingValues0680j_4;
        int i5;
        boolean z2;
        Arrangement.Horizontal start;
        int i6;
        Alignment.Vertical top;
        FlingBehavior flingBehavior2;
        PaddingValues paddingValues2;
        Alignment.Vertical vertical2;
        int i7;
        int i8;
        boolean z3;
        FlingBehavior flingBehavior3;
        Modifier modifier3;
        Arrangement.Horizontal horizontal2;
        LazyListState lazyListState3;
        Composer composer2;
        final Modifier modifier4;
        final LazyListState lazyListState4;
        final PaddingValues paddingValues3;
        final boolean z4;
        final Arrangement.Horizontal horizontal3;
        final Alignment.Vertical vertical3;
        final FlingBehavior flingBehavior4;
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup;
        Composer composerStartRestartGroup = composer.startRestartGroup(407929823);
        int i9 = i2 & 1;
        if (i9 != 0) {
            i4 = i | 6;
            modifier2 = modifier;
        } else if ((i & 6) == 0) {
            modifier2 = modifier;
            i4 = (composerStartRestartGroup.changed(modifier2) ? 4 : 2) | i;
        } else {
            modifier2 = modifier;
            i4 = i;
        }
        if ((i & 48) == 0) {
            if ((i2 & 2) == 0) {
                lazyListState2 = lazyListState;
                int i10 = composerStartRestartGroup.changed(lazyListState2) ? 32 : 16;
                i4 |= i10;
            } else {
                lazyListState2 = lazyListState;
            }
            i4 |= i10;
        } else {
            lazyListState2 = lazyListState;
        }
        int i11 = i2 & 4;
        if (i11 != 0) {
            i4 |= 384;
        } else {
            if ((i & 384) == 0) {
                paddingValuesM15847PaddingValues0680j_4 = paddingValues;
                i4 |= composerStartRestartGroup.changed(paddingValuesM15847PaddingValues0680j_4) ? 256 : 128;
            }
            i5 = i2 & 8;
            if (i5 == 0) {
                i4 |= 3072;
            } else {
                if ((i & 3072) == 0) {
                    z2 = z;
                    i4 |= composerStartRestartGroup.changed(z2) ? 2048 : 1024;
                }
                if ((i & 24576) == 0) {
                    if ((i2 & 16) == 0) {
                        start = horizontal;
                        int i12 = composerStartRestartGroup.changed(start) ? 16384 : 8192;
                        i4 |= i12;
                    } else {
                        start = horizontal;
                    }
                    i4 |= i12;
                } else {
                    start = horizontal;
                }
                i6 = i2 & 32;
                if (i6 != 0) {
                    i4 |= 196608;
                } else {
                    if ((196608 & i) == 0) {
                        top = vertical;
                        i4 |= composerStartRestartGroup.changed(top) ? 131072 : 65536;
                    }
                    if ((1572864 & i) != 0) {
                        if ((i2 & 64) == 0) {
                            flingBehavior2 = flingBehavior;
                            int i13 = composerStartRestartGroup.changed(flingBehavior2) ? 1048576 : 524288;
                            i4 |= i13;
                        } else {
                            flingBehavior2 = flingBehavior;
                        }
                        i4 |= i13;
                    } else {
                        flingBehavior2 = flingBehavior;
                    }
                    if ((i2 & 128) != 0) {
                        if ((i & 12582912) == 0) {
                            i4 |= composerStartRestartGroup.changedInstance(function1) ? 8388608 : 4194304;
                        }
                        if ((i4 & 4793491) == 4793490 && composerStartRestartGroup.getSkipping()) {
                            composerStartRestartGroup.skipToGroupEnd();
                            composer2 = composerStartRestartGroup;
                            modifier4 = modifier2;
                            lazyListState4 = lazyListState2;
                            paddingValues3 = paddingValuesM15847PaddingValues0680j_4;
                            z4 = z2;
                            horizontal3 = start;
                            vertical3 = top;
                            flingBehavior4 = flingBehavior2;
                        } else {
                            composerStartRestartGroup.startDefaults();
                            if ((i & 1) == 0 && !composerStartRestartGroup.getDefaultsInvalid()) {
                                composerStartRestartGroup.skipToGroupEnd();
                                if ((i2 & 2) != 0) {
                                    i4 &= LttEngineErrors.ERROR_INPAINTING_OCR_BLOCK_TABULAR;
                                }
                                if ((i2 & 16) != 0) {
                                    i4 &= -57345;
                                }
                                if ((i2 & 64) != 0) {
                                    i4 &= -3670017;
                                }
                                paddingValues2 = paddingValuesM15847PaddingValues0680j_4;
                                vertical2 = top;
                                i7 = 12582912;
                                z3 = z2;
                                flingBehavior3 = flingBehavior2;
                                modifier3 = modifier2;
                                horizontal2 = start;
                                i8 = 407929823;
                            } else {
                                Modifier modifier5 = i9 == 0 ? Modifier.INSTANCE : modifier2;
                                if ((i2 & 2) != 0) {
                                    LazyListState lazyListStateRememberLazyListState = LazyListStateKt.rememberLazyListState(0, 0, composerStartRestartGroup, 0, 3);
                                    i4 &= LttEngineErrors.ERROR_INPAINTING_OCR_BLOCK_TABULAR;
                                    lazyListState2 = lazyListStateRememberLazyListState;
                                }
                                if (i11 != 0) {
                                    paddingValuesM15847PaddingValues0680j_4 = PaddingKt.m15847PaddingValues0680j_4(C2256Dp.m20968constructorimpl(0));
                                }
                                if (i5 != 0) {
                                    z2 = false;
                                }
                                if ((i2 & 16) != 0) {
                                    Arrangement arrangement = Arrangement.INSTANCE;
                                    start = !z2 ? arrangement.getStart() : arrangement.getEnd();
                                    i4 &= -57345;
                                }
                                if (i6 != 0) {
                                    top = Alignment.INSTANCE.getTop();
                                }
                                if ((i2 & 64) == 0) {
                                    i4 &= -3670017;
                                    flingBehavior3 = ScrollableDefaults.INSTANCE.flingBehavior(composerStartRestartGroup, 6);
                                    i7 = 12582912;
                                    paddingValues2 = paddingValuesM15847PaddingValues0680j_4;
                                    horizontal2 = start;
                                    vertical2 = top;
                                    i8 = 407929823;
                                    lazyListState3 = lazyListState2;
                                    z3 = z2;
                                    modifier3 = modifier5;
                                    composerStartRestartGroup.endDefaults();
                                    if (ComposerKt.isTraceInProgress()) {
                                        ComposerKt.traceEventStart(i8, i4, -1, "androidx.compose.foundation.lazy.LazyRow (LazyDsl.kt:419)");
                                    }
                                    composer2 = composerStartRestartGroup;
                                    LazyRow(modifier3, lazyListState3, paddingValues2, z3, horizontal2, vertical2, flingBehavior3, true, function1, composer2, i7 | (i4 & 14) | (i4 & 112) | (i4 & 896) | (i4 & 7168) | (57344 & i4) | (458752 & i4) | (3670016 & i4) | ((i4 << 3) & 234881024), 0);
                                    if (ComposerKt.isTraceInProgress()) {
                                        ComposerKt.traceEventEnd();
                                    }
                                    modifier4 = modifier3;
                                    lazyListState4 = lazyListState3;
                                    paddingValues3 = paddingValues2;
                                    z4 = z3;
                                    horizontal3 = horizontal2;
                                    vertical3 = vertical2;
                                    flingBehavior4 = flingBehavior3;
                                } else {
                                    paddingValues2 = paddingValuesM15847PaddingValues0680j_4;
                                    vertical2 = top;
                                    i7 = 12582912;
                                    i8 = 407929823;
                                    z3 = z2;
                                    flingBehavior3 = flingBehavior2;
                                    modifier3 = modifier5;
                                    horizontal2 = start;
                                }
                            }
                            lazyListState3 = lazyListState2;
                            composerStartRestartGroup.endDefaults();
                            if (ComposerKt.isTraceInProgress()) {
                            }
                            composer2 = composerStartRestartGroup;
                            LazyRow(modifier3, lazyListState3, paddingValues2, z3, horizontal2, vertical2, flingBehavior3, true, function1, composer2, i7 | (i4 & 14) | (i4 & 112) | (i4 & 896) | (i4 & 7168) | (57344 & i4) | (458752 & i4) | (3670016 & i4) | ((i4 << 3) & 234881024), 0);
                            if (ComposerKt.isTraceInProgress()) {
                            }
                            modifier4 = modifier3;
                            lazyListState4 = lazyListState3;
                            paddingValues3 = paddingValues2;
                            z4 = z3;
                            horizontal3 = horizontal2;
                            vertical3 = vertical2;
                            flingBehavior4 = flingBehavior3;
                        }
                        scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                        if (scopeUpdateScopeEndRestartGroup != null) {
                            scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.foundation.lazy.LazyDslKt.LazyRow.2
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

                                public final void invoke(@Nullable Composer composer3, int i14) {
                                    LazyDslKt.LazyRow(modifier4, lazyListState4, paddingValues3, z4, horizontal3, vertical3, flingBehavior4, function1, composer3, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
                                }
                            });
                            return;
                        }
                        return;
                    }
                    i4 |= 12582912;
                    if ((i4 & 4793491) == 4793490) {
                        composerStartRestartGroup.startDefaults();
                        if ((i & 1) == 0) {
                            Modifier modifier52 = i9 == 0 ? Modifier.INSTANCE : modifier2;
                            if ((i2 & 2) != 0) {
                            }
                            if (i11 != 0) {
                            }
                            if (i5 != 0) {
                            }
                            if ((i2 & 16) != 0) {
                            }
                            if (i6 != 0) {
                            }
                            if ((i2 & 64) == 0) {
                            }
                        }
                    }
                    scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                    if (scopeUpdateScopeEndRestartGroup != null) {
                    }
                }
                top = vertical;
                if ((1572864 & i) != 0) {
                }
                if ((i2 & 128) != 0) {
                }
                if ((i4 & 4793491) == 4793490) {
                }
                scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup != null) {
                }
            }
            z2 = z;
            if ((i & 24576) == 0) {
            }
            i6 = i2 & 32;
            if (i6 != 0) {
            }
            top = vertical;
            if ((1572864 & i) != 0) {
            }
            if ((i2 & 128) != 0) {
            }
            if ((i4 & 4793491) == 4793490) {
            }
            scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup != null) {
            }
        }
        paddingValuesM15847PaddingValues0680j_4 = paddingValues;
        i5 = i2 & 8;
        if (i5 == 0) {
        }
        z2 = z;
        if ((i & 24576) == 0) {
        }
        i6 = i2 & 32;
        if (i6 != 0) {
        }
        top = vertical;
        if ((1572864 & i) != 0) {
        }
        if ((i2 & 128) != 0) {
        }
        if ((i4 & 4793491) == 4793490) {
        }
        scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
        }
    }

    public static /* synthetic */ void items$default(LazyListScope lazyListScope, Object[] objArr, Function1 function1, Function4 function4, int i, Object obj) {
        if ((i & 2) != 0) {
            function1 = null;
        }
        lazyListScope.items(objArr.length, function1 != null ? new C10486(function1, objArr) : null, new C10497(C10475.INSTANCE, objArr), ComposableLambdaKt.composableLambdaInstance(-1043393750, true, new C10508(function4, objArr)));
    }
}
