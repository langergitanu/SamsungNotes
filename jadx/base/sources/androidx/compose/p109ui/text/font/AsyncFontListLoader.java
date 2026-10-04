package androidx.compose.p109ui.text.font;

import androidx.compose.p109ui.text.font.TypefaceResult;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.SnapshotStateKt__SnapshotStateKt;
import androidx.compose.runtime.State;
import androidx.compose.runtime.internal.StabilityInferred;
import java.util.List;
import java.util.concurrent.CancellationException;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlinx.coroutines.CoroutineExceptionHandler;
import kotlinx.coroutines.JobKt;
import kotlinx.coroutines.TimeoutKt;
import kotlinx.coroutines.YieldKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes4.dex */
@StabilityInferred(parameters = 1)
@Metadata(m13885d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0012\b\u0000\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001BG\u0012\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004\u0012\u0006\u0010\u0006\u001a\u00020\u0002\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\u0006\u0010\t\u001a\u00020\n\u0012\u0012\u0010\u000b\u001a\u000e\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\u000e0\f\u0012\u0006\u0010\u000f\u001a\u00020\u0010¢\u0006\u0002\u0010\u0011J\u000e\u0010 \u001a\u00020\u000eH\u0086@¢\u0006\u0002\u0010!J\u0016\u0010\"\u001a\u0004\u0018\u00010\u0002*\u00020\u0005H\u0080@¢\u0006\u0004\b#\u0010$R\u000e\u0010\t\u001a\u00020\nX\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u0012\u001a\u00020\u0013X\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017R\u0014\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u000b\u001a\u000e\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\u000e0\fX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0010X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u0004¢\u0006\u0002\n\u0000R+\u0010\u0019\u001a\u00020\u00022\u0006\u0010\u0018\u001a\u00020\u00028V@RX\u0096\u008e\u0002¢\u0006\u0012\n\u0004\b\u001e\u0010\u001f\u001a\u0004\b\u001a\u0010\u001b\"\u0004\b\u001c\u0010\u001d¨\u0006%"}, m13886d2 = {"Landroidx/compose/ui/text/font/AsyncFontListLoader;", "Landroidx/compose/runtime/State;", "", "fontList", "", "Landroidx/compose/ui/text/font/Font;", "initialType", "typefaceRequest", "Landroidx/compose/ui/text/font/TypefaceRequest;", "asyncTypefaceCache", "Landroidx/compose/ui/text/font/AsyncTypefaceCache;", "onCompletion", "Lkotlin/Function1;", "Landroidx/compose/ui/text/font/TypefaceResult$Immutable;", "", "platformFontLoader", "Landroidx/compose/ui/text/font/PlatformFontLoader;", "(Ljava/util/List;Ljava/lang/Object;Landroidx/compose/ui/text/font/TypefaceRequest;Landroidx/compose/ui/text/font/AsyncTypefaceCache;Lkotlin/jvm/functions/Function1;Landroidx/compose/ui/text/font/PlatformFontLoader;)V", "cacheable", "", "getCacheable$ui_text_release", "()Z", "setCacheable$ui_text_release", "(Z)V", "<set-?>", "value", "getValue", "()Ljava/lang/Object;", "setValue", "(Ljava/lang/Object;)V", "value$delegate", "Landroidx/compose/runtime/MutableState;", "load", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "loadWithTimeoutOrNull", "loadWithTimeoutOrNull$ui_text_release", "(Landroidx/compose/ui/text/font/Font;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "ui-text_release"}, m13887k = 1, m13888mv = {1, 8, 0}, m13890xi = 48)
@SourceDebugExtension({"SMAP\nFontListFontFamilyTypefaceAdapter.kt\nKotlin\n*S Kotlin\n*F\n+ 1 FontListFontFamilyTypefaceAdapter.kt\nandroidx/compose/ui/text/font/AsyncFontListLoader\n+ 2 SnapshotState.kt\nandroidx/compose/runtime/SnapshotStateKt__SnapshotStateKt\n+ 3 ListUtils.kt\nandroidx/compose/ui/util/ListUtilsKt\n*L\n1#1,432:1\n81#2:433\n107#2,2:434\n33#3,6:436\n*S KotlinDebug\n*F\n+ 1 FontListFontFamilyTypefaceAdapter.kt\nandroidx/compose/ui/text/font/AsyncFontListLoader\n*L\n256#1:433\n256#1:434,2\n263#1:436,6\n*E\n"})
public final class AsyncFontListLoader implements State<Object> {
    public static final int $stable = 0;

    @NotNull
    private final AsyncTypefaceCache asyncTypefaceCache;
    private boolean cacheable = true;

    @NotNull
    private final List<Font> fontList;

    @NotNull
    private final Function1<TypefaceResult.Immutable, Unit> onCompletion;

    @NotNull
    private final PlatformFontLoader platformFontLoader;

    @NotNull
    private final TypefaceRequest typefaceRequest;

    /* JADX INFO: renamed from: value$delegate, reason: from kotlin metadata */
    @NotNull
    private final MutableState value;

    /* JADX INFO: renamed from: androidx.compose.ui.text.font.AsyncFontListLoader$load$1 */
    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13887k = 3, m13888mv = {1, 8, 0}, m13890xi = 48)
    @DebugMetadata(m14020c = "androidx.compose.ui.text.font.AsyncFontListLoader", m14021f = "FontListFontFamilyTypefaceAdapter.kt", m14022i = {0, 0, 0, 0, 1, 1, 1}, m14023l = {272, 285}, m14024m = "load", m14025n = {"this", "$this$fastForEach$iv", "font", "index$iv", "this", "$this$fastForEach$iv", "index$iv"}, m14026s = {"L$0", "L$1", "L$2", "I$0", "L$0", "L$1", "I$0"})
    public static final class C22391 extends ContinuationImpl {
        int I$0;
        int I$1;
        Object L$0;
        Object L$1;
        Object L$2;
        int label;
        /* synthetic */ Object result;

        public C22391(Continuation<? super C22391> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return AsyncFontListLoader.this.load(this);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public AsyncFontListLoader(@NotNull List<? extends Font> list, @NotNull Object obj, @NotNull TypefaceRequest typefaceRequest, @NotNull AsyncTypefaceCache asyncTypefaceCache, @NotNull Function1<? super TypefaceResult.Immutable, Unit> function1, @NotNull PlatformFontLoader platformFontLoader) {
        this.fontList = list;
        this.typefaceRequest = typefaceRequest;
        this.asyncTypefaceCache = asyncTypefaceCache;
        this.onCompletion = function1;
        this.platformFontLoader = platformFontLoader;
        this.value = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(obj, null, 2, null);
    }

    private void setValue(Object obj) {
        this.value.setValue(obj);
    }

    /* JADX INFO: renamed from: getCacheable$ui_text_release, reason: from getter */
    public final boolean getCacheable() {
        return this.cacheable;
    }

    @Override // androidx.compose.runtime.State
    @NotNull
    public Object getValue() {
        return this.value.getValue();
    }

    /* JADX WARN: Removed duplicated region for block: B:35:0x00b1 A[Catch: all -> 0x0063, TRY_ENTER, TRY_LEAVE, TryCatch #1 {all -> 0x0063, blocks: (B:35:0x00b1, B:38:0x00e5, B:20:0x005a), top: B:54:0x005a }] */
    /* JADX WARN: Removed duplicated region for block: B:38:0x00e5 A[Catch: all -> 0x0063, TRY_ENTER, TRY_LEAVE, TryCatch #1 {all -> 0x0063, blocks: (B:35:0x00b1, B:38:0x00e5, B:20:0x005a), top: B:54:0x005a }] */
    /* JADX WARN: Removed duplicated region for block: B:46:0x0105  */
    /* JADX WARN: Removed duplicated region for block: B:56:0x0075 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0017  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:29:0x008a -> B:45:0x0102). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:41:0x00f8 -> B:42:0x00f9). Please report as a decompilation issue!!! */
    @Nullable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object load(@NotNull Continuation<? super Unit> continuation) throws Throwable {
        C22391 c22391;
        AsyncFontListLoader asyncFontListLoader;
        List<Font> list;
        int size;
        C22391 c223912;
        int i;
        AsyncFontListLoader asyncFontListLoader2;
        AsyncFontListLoader asyncFontListLoader3;
        Font font;
        List<Font> list2;
        int i2;
        if (continuation instanceof C22391) {
            c22391 = (C22391) continuation;
            int i4 = c22391.label;
            if ((i4 & Integer.MIN_VALUE) != 0) {
                c22391.label = i4 - Integer.MIN_VALUE;
            } else {
                c22391 = new C22391(continuation);
            }
        }
        Object obj = c22391.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i5 = c22391.label;
        if (i5 == 0) {
            ResultKt.throwOnFailure(obj);
            try {
                list = this.fontList;
                size = list.size();
                c223912 = c22391;
                i = 0;
                asyncFontListLoader2 = this;
                if (i < size) {
                }
            } catch (Throwable th) {
                th = th;
                asyncFontListLoader = this;
            }
        } else if (i5 == 1) {
            size = c22391.I$1;
            i2 = c22391.I$0;
            Font font2 = (Font) c22391.L$2;
            List<Font> list3 = (List) c22391.L$1;
            asyncFontListLoader3 = (AsyncFontListLoader) c22391.L$0;
            try {
                ResultKt.throwOnFailure(obj);
                font = font2;
                list2 = list3;
                if (obj == null) {
                }
            } catch (Throwable th2) {
                th = th2;
                asyncFontListLoader = asyncFontListLoader3;
            }
        } else {
            if (i5 != 2) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            size = c22391.I$1;
            i2 = c22391.I$0;
            list2 = (List) c22391.L$1;
            asyncFontListLoader = (AsyncFontListLoader) c22391.L$0;
            try {
                ResultKt.throwOnFailure(obj);
                c223912 = c22391;
                i = i2;
                list = list2;
                asyncFontListLoader2 = asyncFontListLoader;
                i++;
                if (i < size) {
                    try {
                        Font font3 = list.get(i);
                        if (FontLoadingStrategy.m20552equalsimpl0(font3.getLoadingStrategy(), FontLoadingStrategy.INSTANCE.m20556getAsyncPKNRLFQ())) {
                            AsyncTypefaceCache asyncTypefaceCache = asyncFontListLoader2.asyncTypefaceCache;
                            PlatformFontLoader platformFontLoader = asyncFontListLoader2.platformFontLoader;
                            AsyncFontListLoader$load$2$typeface$1 asyncFontListLoader$load$2$typeface$1 = new AsyncFontListLoader$load$2$typeface$1(asyncFontListLoader2, font3, null);
                            c223912.L$0 = asyncFontListLoader2;
                            c223912.L$1 = list;
                            c223912.L$2 = font3;
                            c223912.I$0 = i;
                            c223912.I$1 = size;
                            c223912.label = 1;
                            Object objRunCached = asyncTypefaceCache.runCached(font3, platformFontLoader, false, asyncFontListLoader$load$2$typeface$1, c223912);
                            if (objRunCached != coroutine_suspended) {
                                asyncFontListLoader3 = asyncFontListLoader2;
                                font = font3;
                                c22391 = c223912;
                                list2 = list;
                                obj = objRunCached;
                                i2 = i;
                                if (obj == null) {
                                    asyncFontListLoader3.setValue(FontSynthesis_androidKt.m20586synthesizeTypefaceFxwP2eA(asyncFontListLoader3.typefaceRequest.m20611getFontSynthesisGVVA2EU(), obj, font, asyncFontListLoader3.typefaceRequest.getFontWeight(), asyncFontListLoader3.typefaceRequest.m20610getFontStyle_LCdwA()));
                                    Unit unit = Unit.INSTANCE;
                                    boolean zIsActive = JobKt.isActive(c22391.get$context());
                                    asyncFontListLoader3.cacheable = false;
                                    asyncFontListLoader3.onCompletion.invoke(new TypefaceResult.Immutable(asyncFontListLoader3.getValue(), zIsActive));
                                    return unit;
                                }
                                c22391.L$0 = asyncFontListLoader3;
                                c22391.L$1 = list2;
                                c22391.L$2 = null;
                                c22391.I$0 = i2;
                                c22391.I$1 = size;
                                c22391.label = 2;
                                if (YieldKt.yield(c22391) != coroutine_suspended) {
                                    asyncFontListLoader = asyncFontListLoader3;
                                    c223912 = c22391;
                                    i = i2;
                                    list = list2;
                                    asyncFontListLoader2 = asyncFontListLoader;
                                }
                            }
                            return coroutine_suspended;
                        }
                        i++;
                        if (i < size) {
                            boolean zIsActive2 = JobKt.isActive(c223912.get$context());
                            asyncFontListLoader2.cacheable = false;
                            asyncFontListLoader2.onCompletion.invoke(new TypefaceResult.Immutable(asyncFontListLoader2.getValue(), zIsActive2));
                            return Unit.INSTANCE;
                        }
                    } catch (Throwable th3) {
                        th = th3;
                        asyncFontListLoader = asyncFontListLoader2;
                        c22391 = c223912;
                    }
                }
            } catch (Throwable th4) {
                th = th4;
            }
        }
        boolean zIsActive3 = JobKt.isActive(c22391.get$context());
        asyncFontListLoader.cacheable = false;
        asyncFontListLoader.onCompletion.invoke(new TypefaceResult.Immutable(asyncFontListLoader.getValue(), zIsActive3));
        throw th;
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    @Nullable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object loadWithTimeoutOrNull$ui_text_release(@NotNull Font font, @NotNull Continuation<Object> continuation) {
        AsyncFontListLoader$loadWithTimeoutOrNull$1 asyncFontListLoader$loadWithTimeoutOrNull$1;
        if (continuation instanceof AsyncFontListLoader$loadWithTimeoutOrNull$1) {
            asyncFontListLoader$loadWithTimeoutOrNull$1 = (AsyncFontListLoader$loadWithTimeoutOrNull$1) continuation;
            int i = asyncFontListLoader$loadWithTimeoutOrNull$1.label;
            if ((i & Integer.MIN_VALUE) != 0) {
                asyncFontListLoader$loadWithTimeoutOrNull$1.label = i - Integer.MIN_VALUE;
            } else {
                asyncFontListLoader$loadWithTimeoutOrNull$1 = new AsyncFontListLoader$loadWithTimeoutOrNull$1(this, continuation);
            }
        }
        Object obj = asyncFontListLoader$loadWithTimeoutOrNull$1.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i2 = asyncFontListLoader$loadWithTimeoutOrNull$1.label;
        try {
            if (i2 != 0) {
                if (i2 != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
                return obj;
            }
            ResultKt.throwOnFailure(obj);
            AsyncFontListLoader$loadWithTimeoutOrNull$2 asyncFontListLoader$loadWithTimeoutOrNull$2 = new AsyncFontListLoader$loadWithTimeoutOrNull$2(this, font, null);
            asyncFontListLoader$loadWithTimeoutOrNull$1.L$0 = font;
            asyncFontListLoader$loadWithTimeoutOrNull$1.label = 1;
            Object objWithTimeoutOrNull = TimeoutKt.withTimeoutOrNull(15000L, asyncFontListLoader$loadWithTimeoutOrNull$2, asyncFontListLoader$loadWithTimeoutOrNull$1);
            return objWithTimeoutOrNull == coroutine_suspended ? coroutine_suspended : objWithTimeoutOrNull;
        } catch (CancellationException e) {
            if (!JobKt.isActive(asyncFontListLoader$loadWithTimeoutOrNull$1.get$context())) {
                throw e;
            }
            return null;
        } catch (Exception e2) {
            CoroutineExceptionHandler coroutineExceptionHandler = (CoroutineExceptionHandler) asyncFontListLoader$loadWithTimeoutOrNull$1.get$context().get(CoroutineExceptionHandler.INSTANCE);
            if (coroutineExceptionHandler != null) {
                coroutineExceptionHandler.handleException(asyncFontListLoader$loadWithTimeoutOrNull$1.get$context(), new IllegalStateException("Unable to load font " + font, e2));
            }
            return null;
        }
    }

    public final void setCacheable$ui_text_release(boolean z) {
        this.cacheable = z;
    }
}
