package androidx.compose.p109ui.text.font;

import android.content.Context;
import android.graphics.Typeface;
import androidx.compose.p109ui.text.font.AndroidFont;
import androidx.compose.p109ui.text.font.FontLoadingStrategy;
import androidx.compose.runtime.internal.StabilityInferred;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.jvm.internal.SourceDebugExtension;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes4.dex */
@StabilityInferred(parameters = 0)
@Metadata(m13885d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0000\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0018\u0010\n\u001a\u0004\u0018\u00010\u000b2\u0006\u0010\f\u001a\u00020\rH\u0096@¢\u0006\u0002\u0010\u000eJ\u0012\u0010\u000f\u001a\u0004\u0018\u00010\u000b2\u0006\u0010\f\u001a\u00020\rH\u0016R\u0016\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0016\u0010\u0002\u001a\n \t*\u0004\u0018\u00010\u00030\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0010"}, m13886d2 = {"Landroidx/compose/ui/text/font/AndroidFontLoader;", "Landroidx/compose/ui/text/font/PlatformFontLoader;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "cacheKey", "", "getCacheKey", "()Ljava/lang/Object;", "kotlin.jvm.PlatformType", "awaitLoad", "Landroid/graphics/Typeface;", "font", "Landroidx/compose/ui/text/font/Font;", "(Landroidx/compose/ui/text/font/Font;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "loadBlocking", "ui-text_release"}, m13887k = 1, m13888mv = {1, 8, 0}, m13890xi = 48)
@SourceDebugExtension({"SMAP\nAndroidFontLoader.android.kt\nKotlin\n*S Kotlin\n*F\n+ 1 AndroidFontLoader.android.kt\nandroidx/compose/ui/text/font/AndroidFontLoader\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,86:1\n1#2:87\n*E\n"})
public final class AndroidFontLoader implements PlatformFontLoader {
    public static final int $stable = 8;

    @Nullable
    private final Object cacheKey;
    private final Context context;

    /* JADX INFO: renamed from: androidx.compose.ui.text.font.AndroidFontLoader$awaitLoad$1 */
    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13887k = 3, m13888mv = {1, 8, 0}, m13890xi = 48)
    @DebugMetadata(m14020c = "androidx.compose.ui.text.font.AndroidFontLoader", m14021f = "AndroidFontLoader.android.kt", m14022i = {1, 1}, m14023l = {57, 58}, m14024m = "awaitLoad", m14025n = {"this", "font"}, m14026s = {"L$0", "L$1"})
    public static final class C22381 extends ContinuationImpl {
        Object L$0;
        Object L$1;
        int label;
        /* synthetic */ Object result;

        public C22381(Continuation<? super C22381> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return AndroidFontLoader.this.awaitLoad(null, this);
        }
    }

    public AndroidFontLoader(@NotNull Context context) {
        this.context = context.getApplicationContext();
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    @Override // androidx.compose.p109ui.text.font.PlatformFontLoader
    @Nullable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public Object awaitLoad(@NotNull Font font, @NotNull Continuation<? super Typeface> continuation) {
        C22381 c22381;
        AndroidFontLoader androidFontLoader;
        if (continuation instanceof C22381) {
            c22381 = (C22381) continuation;
            int i = c22381.label;
            if ((i & Integer.MIN_VALUE) != 0) {
                c22381.label = i - Integer.MIN_VALUE;
            } else {
                c22381 = new C22381(continuation);
            }
        }
        Object objLoadAsync = c22381.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i2 = c22381.label;
        if (i2 == 0) {
            ResultKt.throwOnFailure(objLoadAsync);
            if (font instanceof AndroidFont) {
                AndroidFont androidFont = (AndroidFont) font;
                AndroidFont.TypefaceLoader typefaceLoader = androidFont.getTypefaceLoader();
                Context context = this.context;
                c22381.label = 1;
                Object objAwaitLoad = typefaceLoader.awaitLoad(context, androidFont, c22381);
                if (objAwaitLoad != coroutine_suspended) {
                    return objAwaitLoad;
                }
            } else {
                if (!(font instanceof ResourceFont)) {
                    throw new IllegalArgumentException("Unknown font type: " + font);
                }
                Context context2 = this.context;
                c22381.L$0 = this;
                c22381.L$1 = font;
                c22381.label = 2;
                objLoadAsync = AndroidFontLoader_androidKt.loadAsync((ResourceFont) font, context2, c22381);
                if (objLoadAsync != coroutine_suspended) {
                    androidFontLoader = this;
                }
            }
            return coroutine_suspended;
        }
        if (i2 == 1) {
            ResultKt.throwOnFailure(objLoadAsync);
            return objLoadAsync;
        }
        if (i2 != 2) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        font = (Font) c22381.L$1;
        androidFontLoader = (AndroidFontLoader) c22381.L$0;
        ResultKt.throwOnFailure(objLoadAsync);
        return PlatformTypefaces_androidKt.setFontVariationSettings((Typeface) objLoadAsync, ((ResourceFont) font).getVariationSettings(), androidFontLoader.context);
    }

    @Override // androidx.compose.p109ui.text.font.PlatformFontLoader
    @Nullable
    public Object getCacheKey() {
        return this.cacheKey;
    }

    @Override // androidx.compose.p109ui.text.font.PlatformFontLoader
    @Nullable
    public Typeface loadBlocking(@NotNull Font font) {
        Object objM22215constructorimpl;
        Typeface typefaceLoad;
        if (font instanceof AndroidFont) {
            AndroidFont androidFont = (AndroidFont) font;
            return androidFont.getTypefaceLoader().loadBlocking(this.context, androidFont);
        }
        if (!(font instanceof ResourceFont)) {
            return null;
        }
        int loadingStrategy = font.getLoadingStrategy();
        FontLoadingStrategy.Companion companion = FontLoadingStrategy.INSTANCE;
        if (FontLoadingStrategy.m20552equalsimpl0(loadingStrategy, companion.m20557getBlockingPKNRLFQ())) {
            typefaceLoad = AndroidFontLoader_androidKt.load((ResourceFont) font, this.context);
        } else {
            if (!FontLoadingStrategy.m20552equalsimpl0(loadingStrategy, companion.m20558getOptionalLocalPKNRLFQ())) {
                if (FontLoadingStrategy.m20552equalsimpl0(loadingStrategy, companion.m20556getAsyncPKNRLFQ())) {
                    throw new UnsupportedOperationException("Unsupported Async font load path");
                }
                throw new IllegalArgumentException("Unknown loading type " + ((Object) FontLoadingStrategy.m20554toStringimpl(font.getLoadingStrategy())));
            }
            try {
                Result.Companion companion2 = Result.INSTANCE;
                objM22215constructorimpl = Result.m22215constructorimpl(AndroidFontLoader_androidKt.load((ResourceFont) font, this.context));
            } catch (Throwable th) {
                Result.Companion companion3 = Result.INSTANCE;
                objM22215constructorimpl = Result.m22215constructorimpl(ResultKt.createFailure(th));
            }
            typefaceLoad = (Typeface) (Result.m22221isFailureimpl(objM22215constructorimpl) ? null : objM22215constructorimpl);
        }
        return PlatformTypefaces_androidKt.setFontVariationSettings(typefaceLoad, ((ResourceFont) font).getVariationSettings(), this.context);
    }
}
