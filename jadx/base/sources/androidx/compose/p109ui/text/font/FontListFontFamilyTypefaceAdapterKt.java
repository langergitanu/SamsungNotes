package androidx.compose.p109ui.text.font;

import androidx.compose.p109ui.text.font.AsyncTypefaceCache;
import androidx.compose.p109ui.text.font.FontLoadingStrategy;
import java.util.List;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.SourceDebugExtension;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(m13885d1 = {"\u0000,\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u001aR\u0010\u0000\u001a\u0016\u0012\f\u0012\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0002\u0012\u0004\u0012\u00020\u00040\u0001*\b\u0012\u0004\u0012\u00020\u00030\u00022\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0012\u0010\u000b\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00040\fH\u0002¨\u0006\r"}, m13886d2 = {"firstImmediatelyAvailable", "Lkotlin/Pair;", "", "Landroidx/compose/ui/text/font/Font;", "", "typefaceRequest", "Landroidx/compose/ui/text/font/TypefaceRequest;", "asyncTypefaceCache", "Landroidx/compose/ui/text/font/AsyncTypefaceCache;", "platformFontLoader", "Landroidx/compose/ui/text/font/PlatformFontLoader;", "createDefaultTypeface", "Lkotlin/Function1;", "ui-text_release"}, m13887k = 2, m13888mv = {1, 8, 0}, m13890xi = 48)
@SourceDebugExtension({"SMAP\nFontListFontFamilyTypefaceAdapter.kt\nKotlin\n*S Kotlin\n*F\n+ 1 FontListFontFamilyTypefaceAdapter.kt\nandroidx/compose/ui/text/font/FontListFontFamilyTypefaceAdapterKt\n+ 2 FontListFontFamilyTypefaceAdapter.kt\nandroidx/compose/ui/text/font/AsyncTypefaceCache\n+ 3 Synchronization.jvm.kt\nandroidx/compose/ui/text/platform/Synchronization_jvmKt\n+ 4 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,432:1\n420#2:433\n421#2,9:435\n420#2:444\n421#2,7:446\n428#2,2:454\n26#3:434\n26#3:445\n1#4:453\n*S KotlinDebug\n*F\n+ 1 FontListFontFamilyTypefaceAdapter.kt\nandroidx/compose/ui/text/font/FontListFontFamilyTypefaceAdapterKt\n*L\n189#1:433\n189#1:435,9\n205#1:444\n205#1:446,7\n205#1:454,2\n189#1:434\n205#1:445\n*E\n"})
public final class FontListFontFamilyTypefaceAdapterKt {
    /* JADX INFO: Access modifiers changed from: private */
    public static final Pair<List<Font>, Object> firstImmediatelyAvailable(List<? extends Font> list, TypefaceRequest typefaceRequest, AsyncTypefaceCache asyncTypefaceCache, PlatformFontLoader platformFontLoader, Function1<? super TypefaceRequest, ? extends Object> function1) {
        Object objM20529unboximpl;
        Object objM22215constructorimpl;
        Object objM20529unboximpl2;
        int size = list.size();
        List listMutableListOf = null;
        for (int i = 0; i < size; i++) {
            Font font = list.get(i);
            int loadingStrategy = font.getLoadingStrategy();
            FontLoadingStrategy.Companion companion = FontLoadingStrategy.INSTANCE;
            if (FontLoadingStrategy.m20552equalsimpl0(loadingStrategy, companion.m20557getBlockingPKNRLFQ())) {
                synchronized (asyncTypefaceCache.cacheLock) {
                    try {
                        AsyncTypefaceCache.Key key = new AsyncTypefaceCache.Key(font, platformFontLoader.getCacheKey());
                        AsyncTypefaceCache.AsyncTypefaceResult asyncTypefaceResult = (AsyncTypefaceCache.AsyncTypefaceResult) asyncTypefaceCache.resultCache.get(key);
                        if (asyncTypefaceResult == null) {
                            asyncTypefaceResult = (AsyncTypefaceCache.AsyncTypefaceResult) asyncTypefaceCache.permanentCache.get(key);
                        }
                        if (asyncTypefaceResult != null) {
                            objM20529unboximpl = asyncTypefaceResult.m20529unboximpl();
                        } else {
                            Unit unit = Unit.INSTANCE;
                            try {
                                Object objLoadBlocking = platformFontLoader.loadBlocking(font);
                                AsyncTypefaceCache.put$default(asyncTypefaceCache, font, platformFontLoader, objLoadBlocking, false, 8, null);
                                objM20529unboximpl = objLoadBlocking;
                            } catch (Exception e) {
                                throw new IllegalStateException("Unable to load font " + font, e);
                            }
                        }
                    } catch (Throwable th) {
                        throw th;
                    }
                }
                if (objM20529unboximpl != null) {
                    return TuplesKt.m13893to(listMutableListOf, FontSynthesis_androidKt.m20586synthesizeTypefaceFxwP2eA(typefaceRequest.m20611getFontSynthesisGVVA2EU(), objM20529unboximpl, font, typefaceRequest.getFontWeight(), typefaceRequest.m20610getFontStyle_LCdwA()));
                }
                throw new IllegalStateException("Unable to load font " + font);
            }
            if (FontLoadingStrategy.m20552equalsimpl0(loadingStrategy, companion.m20558getOptionalLocalPKNRLFQ())) {
                synchronized (asyncTypefaceCache.cacheLock) {
                    try {
                        AsyncTypefaceCache.Key key2 = new AsyncTypefaceCache.Key(font, platformFontLoader.getCacheKey());
                        AsyncTypefaceCache.AsyncTypefaceResult asyncTypefaceResult2 = (AsyncTypefaceCache.AsyncTypefaceResult) asyncTypefaceCache.resultCache.get(key2);
                        if (asyncTypefaceResult2 == null) {
                            asyncTypefaceResult2 = (AsyncTypefaceCache.AsyncTypefaceResult) asyncTypefaceCache.permanentCache.get(key2);
                        }
                        if (asyncTypefaceResult2 != null) {
                            objM20529unboximpl2 = asyncTypefaceResult2.m20529unboximpl();
                        } else {
                            Unit unit2 = Unit.INSTANCE;
                            try {
                                Result.Companion companion2 = Result.INSTANCE;
                                objM22215constructorimpl = Result.m22215constructorimpl(platformFontLoader.loadBlocking(font));
                            } catch (Throwable th2) {
                                Result.Companion companion3 = Result.INSTANCE;
                                objM22215constructorimpl = Result.m22215constructorimpl(ResultKt.createFailure(th2));
                            }
                            Object obj = Result.m22221isFailureimpl(objM22215constructorimpl) ? null : objM22215constructorimpl;
                            AsyncTypefaceCache.put$default(asyncTypefaceCache, font, platformFontLoader, obj, false, 8, null);
                            objM20529unboximpl2 = obj;
                        }
                    } catch (Throwable th3) {
                        throw th3;
                    }
                }
                if (objM20529unboximpl2 != null) {
                    return TuplesKt.m13893to(listMutableListOf, FontSynthesis_androidKt.m20586synthesizeTypefaceFxwP2eA(typefaceRequest.m20611getFontSynthesisGVVA2EU(), objM20529unboximpl2, font, typefaceRequest.getFontWeight(), typefaceRequest.m20610getFontStyle_LCdwA()));
                }
            } else {
                if (!FontLoadingStrategy.m20552equalsimpl0(loadingStrategy, companion.m20556getAsyncPKNRLFQ())) {
                    throw new IllegalStateException("Unknown font type " + font);
                }
                AsyncTypefaceCache.AsyncTypefaceResult asyncTypefaceResultM20521get1ASDuI8 = asyncTypefaceCache.m20521get1ASDuI8(font, platformFontLoader);
                if (asyncTypefaceResultM20521get1ASDuI8 != null) {
                    if (!AsyncTypefaceCache.AsyncTypefaceResult.m20527isPermanentFailureimpl(asyncTypefaceResultM20521get1ASDuI8.m20529unboximpl()) && asyncTypefaceResultM20521get1ASDuI8.m20529unboximpl() != null) {
                        return TuplesKt.m13893to(listMutableListOf, FontSynthesis_androidKt.m20586synthesizeTypefaceFxwP2eA(typefaceRequest.m20611getFontSynthesisGVVA2EU(), asyncTypefaceResultM20521get1ASDuI8.m20529unboximpl(), font, typefaceRequest.getFontWeight(), typefaceRequest.m20610getFontStyle_LCdwA()));
                    }
                } else if (listMutableListOf == null) {
                    listMutableListOf = CollectionsKt.mutableListOf(font);
                } else {
                    listMutableListOf.add(font);
                }
            }
        }
        return TuplesKt.m13893to(listMutableListOf, function1.invoke(typefaceRequest));
    }
}
