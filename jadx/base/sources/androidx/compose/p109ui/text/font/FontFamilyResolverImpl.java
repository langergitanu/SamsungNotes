package androidx.compose.p109ui.text.font;

import androidx.compose.p109ui.text.font.FontFamily;
import androidx.compose.p109ui.text.font.TypefaceResult;
import androidx.compose.runtime.State;
import androidx.compose.runtime.internal.StabilityInferred;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.SourceDebugExtension;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes4.dex */
@StabilityInferred(parameters = 0)
@Metadata(m13885d1 = {"\u0000b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0000\u0018\u00002\u00020\u0001B5\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007\u0012\b\b\u0002\u0010\b\u001a\u00020\t\u0012\b\b\u0002\u0010\n\u001a\u00020\u000b¢\u0006\u0002\u0010\fJ\u0016\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u0016H\u0096@¢\u0006\u0002\u0010\u0017J:\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u00100\u00192\b\u0010\u0015\u001a\u0004\u0018\u00010\u00162\u0006\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u001e\u001a\u00020\u001fH\u0016ø\u0001\u0000¢\u0006\u0004\b \u0010!J\u0016\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u00100\u00192\u0006\u0010\"\u001a\u00020\u000fH\u0002R\u001a\u0010\r\u001a\u000e\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\u00100\u000eX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0002\u001a\u00020\u0003X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000\u0082\u0002\u0007\n\u0005\b¡\u001e0\u0001¨\u0006#"}, m13886d2 = {"Landroidx/compose/ui/text/font/FontFamilyResolverImpl;", "Landroidx/compose/ui/text/font/FontFamily$Resolver;", "platformFontLoader", "Landroidx/compose/ui/text/font/PlatformFontLoader;", "platformResolveInterceptor", "Landroidx/compose/ui/text/font/PlatformResolveInterceptor;", "typefaceRequestCache", "Landroidx/compose/ui/text/font/TypefaceRequestCache;", "fontListFontFamilyTypefaceAdapter", "Landroidx/compose/ui/text/font/FontListFontFamilyTypefaceAdapter;", "platformFamilyTypefaceAdapter", "Landroidx/compose/ui/text/font/PlatformFontFamilyTypefaceAdapter;", "(Landroidx/compose/ui/text/font/PlatformFontLoader;Landroidx/compose/ui/text/font/PlatformResolveInterceptor;Landroidx/compose/ui/text/font/TypefaceRequestCache;Landroidx/compose/ui/text/font/FontListFontFamilyTypefaceAdapter;Landroidx/compose/ui/text/font/PlatformFontFamilyTypefaceAdapter;)V", "createDefaultTypeface", "Lkotlin/Function1;", "Landroidx/compose/ui/text/font/TypefaceRequest;", "", "getPlatformFontLoader$ui_text_release", "()Landroidx/compose/ui/text/font/PlatformFontLoader;", "preload", "", "fontFamily", "Landroidx/compose/ui/text/font/FontFamily;", "(Landroidx/compose/ui/text/font/FontFamily;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "resolve", "Landroidx/compose/runtime/State;", "fontWeight", "Landroidx/compose/ui/text/font/FontWeight;", "fontStyle", "Landroidx/compose/ui/text/font/FontStyle;", "fontSynthesis", "Landroidx/compose/ui/text/font/FontSynthesis;", "resolve-DPcqOEQ", "(Landroidx/compose/ui/text/font/FontFamily;Landroidx/compose/ui/text/font/FontWeight;II)Landroidx/compose/runtime/State;", "typefaceRequest", "ui-text_release"}, m13887k = 1, m13888mv = {1, 8, 0}, m13890xi = 48)
@SourceDebugExtension({"SMAP\nFontFamilyResolver.kt\nKotlin\n*S Kotlin\n*F\n+ 1 FontFamilyResolver.kt\nandroidx/compose/ui/text/font/FontFamilyResolverImpl\n+ 2 ListUtils.kt\nandroidx/compose/ui/util/ListUtilsKt\n*L\n1#1,256:1\n151#2,3:257\n33#2,4:260\n154#2,2:264\n38#2:266\n156#2:267\n*S KotlinDebug\n*F\n+ 1 FontFamilyResolver.kt\nandroidx/compose/ui/text/font/FontFamilyResolverImpl\n*L\n47#1:257,3\n47#1:260,4\n47#1:264,2\n47#1:266\n47#1:267\n*E\n"})
public final class FontFamilyResolverImpl implements FontFamily.Resolver {
    public static final int $stable = 8;

    @NotNull
    private final Function1<TypefaceRequest, Object> createDefaultTypeface;

    @NotNull
    private final FontListFontFamilyTypefaceAdapter fontListFontFamilyTypefaceAdapter;

    @NotNull
    private final PlatformFontFamilyTypefaceAdapter platformFamilyTypefaceAdapter;

    @NotNull
    private final PlatformFontLoader platformFontLoader;

    @NotNull
    private final PlatformResolveInterceptor platformResolveInterceptor;

    @NotNull
    private final TypefaceRequestCache typefaceRequestCache;

    /* JADX INFO: renamed from: androidx.compose.ui.text.font.FontFamilyResolverImpl$preload$1 */
    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13887k = 3, m13888mv = {1, 8, 0}, m13890xi = 48)
    @DebugMetadata(m14020c = "androidx.compose.ui.text.font.FontFamilyResolverImpl", m14021f = "FontFamilyResolver.kt", m14022i = {0, 0}, m14023l = {45}, m14024m = "preload", m14025n = {"this", "fontFamily"}, m14026s = {"L$0", "L$1"})
    public static final class C22411 extends ContinuationImpl {
        Object L$0;
        Object L$1;
        int label;
        /* synthetic */ Object result;

        public C22411(Continuation<? super C22411> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return FontFamilyResolverImpl.this.preload(null, this);
        }
    }

    public FontFamilyResolverImpl(@NotNull PlatformFontLoader platformFontLoader, @NotNull PlatformResolveInterceptor platformResolveInterceptor, @NotNull TypefaceRequestCache typefaceRequestCache, @NotNull FontListFontFamilyTypefaceAdapter fontListFontFamilyTypefaceAdapter, @NotNull PlatformFontFamilyTypefaceAdapter platformFontFamilyTypefaceAdapter) {
        this.platformFontLoader = platformFontLoader;
        this.platformResolveInterceptor = platformResolveInterceptor;
        this.typefaceRequestCache = typefaceRequestCache;
        this.fontListFontFamilyTypefaceAdapter = fontListFontFamilyTypefaceAdapter;
        this.platformFamilyTypefaceAdapter = platformFontFamilyTypefaceAdapter;
        this.createDefaultTypeface = new Function1<TypefaceRequest, Object>() { // from class: androidx.compose.ui.text.font.FontFamilyResolverImpl$createDefaultTypeface$1
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            @NotNull
            public final Object invoke(@NotNull TypefaceRequest typefaceRequest) {
                return this.this$0.resolve(TypefaceRequest.m20606copye1PVR60$default(typefaceRequest, null, null, 0, 0, null, 30, null)).getValue();
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final State<Object> resolve(final TypefaceRequest typefaceRequest) {
        return this.typefaceRequestCache.runCached(typefaceRequest, new Function1<Function1<? super TypefaceResult, ? extends Unit>, TypefaceResult>() { // from class: androidx.compose.ui.text.font.FontFamilyResolverImpl$resolve$result$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ TypefaceResult invoke(Function1<? super TypefaceResult, ? extends Unit> function1) {
                return invoke2((Function1<? super TypefaceResult, Unit>) function1);
            }

            @NotNull
            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final TypefaceResult invoke2(@NotNull Function1<? super TypefaceResult, Unit> function1) {
                TypefaceResult typefaceResultResolve = this.this$0.fontListFontFamilyTypefaceAdapter.resolve(typefaceRequest, this.this$0.getPlatformFontLoader(), function1, this.this$0.createDefaultTypeface);
                if (typefaceResultResolve != null) {
                    return typefaceResultResolve;
                }
                TypefaceResult typefaceResultResolve2 = this.this$0.platformFamilyTypefaceAdapter.resolve(typefaceRequest, this.this$0.getPlatformFontLoader(), function1, this.this$0.createDefaultTypeface);
                if (typefaceResultResolve2 != null) {
                    return typefaceResultResolve2;
                }
                throw new IllegalStateException("Could not load font");
            }
        });
    }

    @NotNull
    /* JADX INFO: renamed from: getPlatformFontLoader$ui_text_release, reason: from getter */
    public final PlatformFontLoader getPlatformFontLoader() {
        return this.platformFontLoader;
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    @Override // androidx.compose.ui.text.font.FontFamily.Resolver
    @Nullable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public Object preload(@NotNull FontFamily fontFamily, @NotNull Continuation<? super Unit> continuation) {
        C22411 c22411;
        FontFamilyResolverImpl fontFamilyResolverImpl;
        if (continuation instanceof C22411) {
            c22411 = (C22411) continuation;
            int i = c22411.label;
            if ((i & Integer.MIN_VALUE) != 0) {
                c22411.label = i - Integer.MIN_VALUE;
            } else {
                c22411 = new C22411(continuation);
            }
        }
        Object obj = c22411.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i2 = c22411.label;
        if (i2 == 0) {
            ResultKt.throwOnFailure(obj);
            if (!(fontFamily instanceof FontListFontFamily)) {
                return Unit.INSTANCE;
            }
            FontListFontFamilyTypefaceAdapter fontListFontFamilyTypefaceAdapter = this.fontListFontFamilyTypefaceAdapter;
            PlatformFontLoader platformFontLoader = this.platformFontLoader;
            c22411.L$0 = this;
            c22411.L$1 = fontFamily;
            c22411.label = 1;
            if (fontListFontFamilyTypefaceAdapter.preload(fontFamily, platformFontLoader, c22411) == coroutine_suspended) {
                return coroutine_suspended;
            }
            fontFamilyResolverImpl = this;
        } else {
            if (i2 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            fontFamily = (FontFamily) c22411.L$1;
            fontFamilyResolverImpl = (FontFamilyResolverImpl) c22411.L$0;
            ResultKt.throwOnFailure(obj);
        }
        List<Font> fonts = ((FontListFontFamily) fontFamily).getFonts();
        ArrayList arrayList = new ArrayList(fonts.size());
        int size = fonts.size();
        for (int i4 = 0; i4 < size; i4++) {
            Font font = fonts.get(i4);
            arrayList.add(new TypefaceRequest(fontFamilyResolverImpl.platformResolveInterceptor.interceptFontFamily(fontFamily), fontFamilyResolverImpl.platformResolveInterceptor.interceptFontWeight(font.getWeight()), fontFamilyResolverImpl.platformResolveInterceptor.m20590interceptFontStyleT2F_aPo(font.getStyle()), FontSynthesis.INSTANCE.m20582getAllGVVA2EU(), fontFamilyResolverImpl.platformFontLoader.getCacheKey(), null));
        }
        fontFamilyResolverImpl.typefaceRequestCache.preWarmCache(arrayList, new Function1<TypefaceRequest, TypefaceResult>() { // from class: androidx.compose.ui.text.font.FontFamilyResolverImpl.preload.2
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            @NotNull
            public final TypefaceResult invoke(@NotNull TypefaceRequest typefaceRequest) {
                TypefaceResult typefaceResultResolve = FontFamilyResolverImpl.this.fontListFontFamilyTypefaceAdapter.resolve(typefaceRequest, FontFamilyResolverImpl.this.getPlatformFontLoader(), new Function1<TypefaceResult.Immutable, Unit>() { // from class: androidx.compose.ui.text.font.FontFamilyResolverImpl.preload.2.1
                    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                    public final void invoke2(@NotNull TypefaceResult.Immutable immutable) {
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public /* bridge */ /* synthetic */ Unit invoke(TypefaceResult.Immutable immutable) {
                        invoke2(immutable);
                        return Unit.INSTANCE;
                    }
                }, FontFamilyResolverImpl.this.createDefaultTypeface);
                if (typefaceResultResolve != null) {
                    return typefaceResultResolve;
                }
                TypefaceResult typefaceResultResolve2 = FontFamilyResolverImpl.this.platformFamilyTypefaceAdapter.resolve(typefaceRequest, FontFamilyResolverImpl.this.getPlatformFontLoader(), new Function1<TypefaceResult.Immutable, Unit>() { // from class: androidx.compose.ui.text.font.FontFamilyResolverImpl.preload.2.2
                    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                    public final void invoke2(@NotNull TypefaceResult.Immutable immutable) {
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public /* bridge */ /* synthetic */ Unit invoke(TypefaceResult.Immutable immutable) {
                        invoke2(immutable);
                        return Unit.INSTANCE;
                    }
                }, FontFamilyResolverImpl.this.createDefaultTypeface);
                if (typefaceResultResolve2 != null) {
                    return typefaceResultResolve2;
                }
                throw new IllegalStateException("Could not load font");
            }
        });
        return Unit.INSTANCE;
    }

    @Override // androidx.compose.ui.text.font.FontFamily.Resolver
    @NotNull
    /* JADX INFO: renamed from: resolve-DPcqOEQ */
    public State<Object> mo20540resolveDPcqOEQ(@Nullable FontFamily fontFamily, @NotNull FontWeight fontWeight, int fontStyle, int fontSynthesis) {
        return resolve(new TypefaceRequest(this.platformResolveInterceptor.interceptFontFamily(fontFamily), this.platformResolveInterceptor.interceptFontWeight(fontWeight), this.platformResolveInterceptor.m20590interceptFontStyleT2F_aPo(fontStyle), this.platformResolveInterceptor.m20591interceptFontSynthesisMscr08Y(fontSynthesis), this.platformFontLoader.getCacheKey(), null));
    }

    public /* synthetic */ FontFamilyResolverImpl(PlatformFontLoader platformFontLoader, PlatformResolveInterceptor platformResolveInterceptor, TypefaceRequestCache typefaceRequestCache, FontListFontFamilyTypefaceAdapter fontListFontFamilyTypefaceAdapter, PlatformFontFamilyTypefaceAdapter platformFontFamilyTypefaceAdapter, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(platformFontLoader, (i & 2) != 0 ? PlatformResolveInterceptor.INSTANCE.getDefault$ui_text_release() : platformResolveInterceptor, (i & 4) != 0 ? FontFamilyResolverKt.getGlobalTypefaceRequestCache() : typefaceRequestCache, (i & 8) != 0 ? new FontListFontFamilyTypefaceAdapter(FontFamilyResolverKt.getGlobalAsyncTypefaceCache(), null, 2, null) : fontListFontFamilyTypefaceAdapter, (i & 16) != 0 ? new PlatformFontFamilyTypefaceAdapter() : platformFontFamilyTypefaceAdapter);
    }
}
