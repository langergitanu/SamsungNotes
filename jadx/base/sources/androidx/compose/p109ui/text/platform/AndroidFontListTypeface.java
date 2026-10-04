package androidx.compose.p109ui.text.platform;

import android.content.Context;
import android.graphics.Typeface;
import androidx.compose.p109ui.text.font.Font;
import androidx.compose.p109ui.text.font.FontFamily;
import androidx.compose.p109ui.text.font.FontListFontFamily;
import androidx.compose.p109ui.text.font.FontLoadingStrategy;
import androidx.compose.p109ui.text.font.FontMatcher;
import androidx.compose.p109ui.text.font.FontStyle;
import androidx.compose.p109ui.text.font.FontSynthesis_androidKt;
import androidx.compose.p109ui.text.font.FontWeight;
import androidx.compose.p109ui.util.ListUtilsKt;
import androidx.compose.runtime.internal.StabilityInferred;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes4.dex */
@StabilityInferred(parameters = 0)
@Metadata(m13885d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0001\u0018\u0000 \u001f2\u00020\u0001:\u0001\u001fB=\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u001c\b\u0002\u0010\u0006\u001a\u0016\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\n0\b\u0018\u00010\u0007\u0012\b\b\u0002\u0010\u000b\u001a\u00020\f¢\u0006\u0002\u0010\rJ*\u0010\u0018\u001a\u00020\u00172\u0006\u0010\u0019\u001a\u00020\t2\u0006\u0010\u001a\u001a\u00020\n2\u0006\u0010\u001b\u001a\u00020\u001cH\u0016ø\u0001\u0000¢\u0006\u0004\b\u001d\u0010\u001eR\u0014\u0010\u0002\u001a\u00020\u000eX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0013\u0010\u000b\u001a\u00020\f¢\u0006\n\n\u0002\b\u0013\u001a\u0004\b\u0011\u0010\u0012R\u001a\u0010\u0014\u001a\u000e\u0012\u0004\u0012\u00020\u0016\u0012\u0004\u0012\u00020\u00170\u0015X\u0082\u0004¢\u0006\u0002\n\u0000\u0082\u0002\u0007\n\u0005\b¡\u001e0\u0001¨\u0006 "}, m13886d2 = {"Landroidx/compose/ui/text/platform/AndroidFontListTypeface;", "Landroidx/compose/ui/text/platform/AndroidTypeface;", "fontFamily", "Landroidx/compose/ui/text/font/FontListFontFamily;", "context", "Landroid/content/Context;", "necessaryStyles", "", "Lkotlin/Pair;", "Landroidx/compose/ui/text/font/FontWeight;", "Landroidx/compose/ui/text/font/FontStyle;", "fontMatcher", "Landroidx/compose/ui/text/font/FontMatcher;", "(Landroidx/compose/ui/text/font/FontListFontFamily;Landroid/content/Context;Ljava/util/List;Landroidx/compose/ui/text/font/FontMatcher;)V", "Landroidx/compose/ui/text/font/FontFamily;", "getFontFamily", "()Landroidx/compose/ui/text/font/FontFamily;", "getFontMatcher", "()Landroidx/compose/ui/text/font/FontMatcher;", "fontMatcher$1", "loadedTypefaces", "", "Landroidx/compose/ui/text/font/Font;", "Landroid/graphics/Typeface;", "getNativeTypeface", "fontWeight", "fontStyle", "synthesis", "Landroidx/compose/ui/text/font/FontSynthesis;", "getNativeTypeface-PYhJU0U", "(Landroidx/compose/ui/text/font/FontWeight;II)Landroid/graphics/Typeface;", "Companion", "ui-text_release"}, m13887k = 1, m13888mv = {1, 8, 0}, m13890xi = 48)
@Deprecated(message = "This is not supported after downloadable fonts.")
@SourceDebugExtension({"SMAP\nAndroidFontListTypeface.android.kt\nKotlin\n*S Kotlin\n*F\n+ 1 AndroidFontListTypeface.android.kt\nandroidx/compose/ui/text/platform/AndroidFontListTypeface\n+ 2 ListUtils.kt\nandroidx/compose/ui/util/ListUtilsKt\n+ 3 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,174:1\n235#2,3:175\n33#2,4:178\n238#2,2:182\n38#2:184\n240#2:185\n151#2,3:186\n33#2,4:189\n154#2,2:193\n38#2:195\n156#2:196\n461#2,4:197\n33#2,4:201\n465#2,3:205\n38#2:208\n468#2:209\n33#2,6:211\n1#3:210\n*S KotlinDebug\n*F\n+ 1 AndroidFontListTypeface.android.kt\nandroidx/compose/ui/text/platform/AndroidFontListTypeface\n*L\n66#1:175,3\n66#1:178,4\n66#1:182,2\n66#1:184\n66#1:185\n69#1:186,3\n69#1:189,4\n69#1:193,2\n69#1:195\n69#1:196\n71#1:197,4\n71#1:201,4\n71#1:205,3\n71#1:208\n71#1:209\n76#1:211,6\n*E\n"})
public final class AndroidFontListTypeface implements AndroidTypeface {

    @NotNull
    private final FontFamily fontFamily;

    /* JADX INFO: renamed from: fontMatcher$1, reason: from kotlin metadata */
    @NotNull
    private final FontMatcher fontMatcher;

    @NotNull
    private final Map<Font, Typeface> loadedTypefaces;

    @NotNull
    private static final Companion Companion = new Companion(null);
    public static final int $stable = 8;

    @NotNull
    private static final FontMatcher fontMatcher = new FontMatcher();

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0082\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, m13886d2 = {"Landroidx/compose/ui/text/platform/AndroidFontListTypeface$Companion;", "", "()V", "fontMatcher", "Landroidx/compose/ui/text/font/FontMatcher;", "getFontMatcher", "()Landroidx/compose/ui/text/font/FontMatcher;", "ui-text_release"}, m13887k = 1, m13888mv = {1, 8, 0}, m13890xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @NotNull
        public final FontMatcher getFontMatcher() {
            return AndroidFontListTypeface.fontMatcher;
        }

        private Companion() {
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:20:0x00a3  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public AndroidFontListTypeface(@NotNull FontListFontFamily fontListFontFamily, @NotNull Context context, @Nullable List<Pair<FontWeight, FontStyle>> list, @NotNull FontMatcher fontMatcher2) {
        ArrayList arrayList;
        this.fontMatcher = fontMatcher2;
        List<Font> fonts = fontListFontFamily.getFonts();
        ArrayList arrayList2 = new ArrayList(fonts.size());
        int size = fonts.size();
        for (int i = 0; i < size; i++) {
            Font font = fonts.get(i);
            if (FontLoadingStrategy.m20552equalsimpl0(font.getLoadingStrategy(), FontLoadingStrategy.INSTANCE.m20557getBlockingPKNRLFQ())) {
                arrayList2.add(font);
            }
        }
        if (list != null) {
            ArrayList arrayList3 = new ArrayList(list.size());
            int size2 = list.size();
            for (int i2 = 0; i2 < size2; i2++) {
                Pair<FontWeight, FontStyle> pair = list.get(i2);
                arrayList3.add((Font) CollectionsKt.firstOrNull((List) this.fontMatcher.m20561matchFontRetOiIg(arrayList2, pair.component1(), pair.component2().m20568unboximpl())));
            }
            List listFastFilterNotNull = ListUtilsKt.fastFilterNotNull(arrayList3);
            if (listFastFilterNotNull != null) {
                HashSet hashSet = new HashSet(listFastFilterNotNull.size());
                arrayList = new ArrayList(listFastFilterNotNull.size());
                int size3 = listFastFilterNotNull.size();
                for (int i4 = 0; i4 < size3; i4++) {
                    Object obj = listFastFilterNotNull.get(i4);
                    if (hashSet.add((Font) obj)) {
                        arrayList.add(obj);
                    }
                }
            } else {
                arrayList = null;
            }
        }
        arrayList2 = arrayList != null ? arrayList : arrayList2;
        if (arrayList2.isEmpty()) {
            throw new IllegalStateException("Could not match font");
        }
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        int size4 = arrayList2.size();
        for (int i5 = 0; i5 < size4; i5++) {
            Font font2 = (Font) arrayList2.get(i5);
            try {
                linkedHashMap.put(font2, AndroidTypefaceCache.INSTANCE.getOrCreate(context, font2));
            } catch (Exception unused) {
                throw new IllegalStateException("Cannot create Typeface from " + font2);
            }
        }
        this.loadedTypefaces = linkedHashMap;
        this.fontFamily = fontListFontFamily;
    }

    @Override // androidx.compose.p109ui.text.font.Typeface
    @NotNull
    public FontFamily getFontFamily() {
        return this.fontFamily;
    }

    @NotNull
    public final FontMatcher getFontMatcher() {
        return this.fontMatcher;
    }

    @Override // androidx.compose.p109ui.text.platform.AndroidTypeface
    @NotNull
    /* JADX INFO: renamed from: getNativeTypeface-PYhJU0U */
    public Typeface mo20705getNativeTypefacePYhJU0U(@NotNull FontWeight fontWeight, int fontStyle, int synthesis) {
        Font font = (Font) CollectionsKt.firstOrNull((List) this.fontMatcher.m20561matchFontRetOiIg(new ArrayList(this.loadedTypefaces.keySet()), fontWeight, fontStyle));
        if (font == null) {
            throw new IllegalStateException("Could not load font");
        }
        Typeface typeface = this.loadedTypefaces.get(font);
        if (typeface == null) {
            throw new IllegalStateException("Could not load typeface");
        }
        Object objM20586synthesizeTypefaceFxwP2eA = FontSynthesis_androidKt.m20586synthesizeTypefaceFxwP2eA(synthesis, typeface, font, fontWeight, fontStyle);
        Intrinsics.checkNotNull(objM20586synthesizeTypefaceFxwP2eA, "null cannot be cast to non-null type android.graphics.Typeface");
        return (Typeface) objM20586synthesizeTypefaceFxwP2eA;
    }

    public /* synthetic */ AndroidFontListTypeface(FontListFontFamily fontListFontFamily, Context context, List list, FontMatcher fontMatcher2, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(fontListFontFamily, context, (i & 4) != 0 ? null : list, (i & 8) != 0 ? fontMatcher : fontMatcher2);
    }
}
