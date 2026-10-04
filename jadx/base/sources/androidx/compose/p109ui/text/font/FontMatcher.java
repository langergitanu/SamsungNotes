package androidx.compose.p109ui.text.font;

import androidx.compose.p109ui.text.font.FontWeight;
import androidx.compose.runtime.internal.StabilityInferred;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes4.dex */
@StabilityInferred(parameters = 1)
@Metadata(m13885d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0000\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J.\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u00042\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bø\u0001\u0000¢\u0006\u0004\b\f\u0010\rJ.\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u00042\u0006\u0010\u0006\u001a\u00020\u000e2\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bø\u0001\u0000¢\u0006\u0004\b\f\u0010\u000fJ4\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u00042\f\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00050\u00042\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bø\u0001\u0000¢\u0006\u0004\b\f\u0010\u0011JF\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004*\b\u0012\u0004\u0012\u00020\u00050\u00042\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\u0013\u001a\u00020\u00142\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\t2\n\b\u0002\u0010\u0016\u001a\u0004\u0018\u00010\tH\u0080\b¢\u0006\u0002\b\u0017\u0082\u0002\u0007\n\u0005\b¡\u001e0\u0001¨\u0006\u0018"}, m13886d2 = {"Landroidx/compose/ui/text/font/FontMatcher;", "", "()V", "matchFont", "", "Landroidx/compose/ui/text/font/Font;", "fontFamily", "Landroidx/compose/ui/text/font/FontFamily;", "fontWeight", "Landroidx/compose/ui/text/font/FontWeight;", "fontStyle", "Landroidx/compose/ui/text/font/FontStyle;", "matchFont-RetOiIg", "(Landroidx/compose/ui/text/font/FontFamily;Landroidx/compose/ui/text/font/FontWeight;I)Ljava/util/List;", "Landroidx/compose/ui/text/font/FontListFontFamily;", "(Landroidx/compose/ui/text/font/FontListFontFamily;Landroidx/compose/ui/text/font/FontWeight;I)Ljava/util/List;", "fontList", "(Ljava/util/List;Landroidx/compose/ui/text/font/FontWeight;I)Ljava/util/List;", "filterByClosestWeight", "preferBelow", "", "minSearchRange", "maxSearchRange", "filterByClosestWeight$ui_text_release", "ui-text_release"}, m13887k = 1, m13888mv = {1, 8, 0}, m13890xi = 48)
@SourceDebugExtension({"SMAP\nFontMatcher.kt\nKotlin\n*S Kotlin\n*F\n+ 1 FontMatcher.kt\nandroidx/compose/ui/text/font/FontMatcher\n+ 2 ListUtils.kt\nandroidx/compose/ui/util/ListUtilsKt\n+ 3 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,166:1\n102#1,34:190\n102#1,34:235\n108#1,28:280\n108#1,28:319\n235#2,3:167\n33#2,4:170\n238#2,2:174\n38#2:176\n240#2:177\n235#2,3:178\n33#2,4:181\n238#2,2:185\n38#2:187\n240#2:188\n235#2,3:224\n33#2,4:227\n238#2,2:231\n38#2:233\n240#2:234\n235#2,3:269\n33#2,4:272\n238#2,2:276\n38#2:278\n240#2:279\n235#2,3:308\n33#2,4:311\n238#2,2:315\n38#2:317\n240#2:318\n235#2,3:347\n33#2,4:350\n238#2,2:354\n38#2:356\n240#2:357\n235#2,3:358\n33#2,4:361\n238#2,2:365\n38#2:367\n240#2:368\n235#2,3:369\n33#2,4:372\n238#2,2:376\n38#2:378\n240#2:379\n1#3:189\n*S KotlinDebug\n*F\n+ 1 FontMatcher.kt\nandroidx/compose/ui/text/font/FontMatcher\n*L\n65#1:190,34\n71#1:235,34\n80#1:280,28\n87#1:319,28\n49#1:167,3\n49#1:170,4\n49#1:174,2\n49#1:176\n49#1:177\n57#1:178,3\n57#1:181,4\n57#1:185,2\n57#1:187\n57#1:188\n65#1:224,3\n65#1:227,4\n65#1:231,2\n65#1:233\n65#1:234\n71#1:269,3\n71#1:272,4\n71#1:276,2\n71#1:278\n71#1:279\n80#1:308,3\n80#1:311,4\n80#1:315,2\n80#1:317\n80#1:318\n87#1:347,3\n87#1:350,4\n87#1:354,2\n87#1:356\n87#1:357\n135#1:358,3\n135#1:361,4\n135#1:365,2\n135#1:367\n135#1:368\n135#1:369,3\n135#1:372,4\n135#1:376,2\n135#1:378\n135#1:379\n*E\n"})
public final class FontMatcher {
    public static final int $stable = 0;

    public static /* synthetic */ List filterByClosestWeight$ui_text_release$default(FontMatcher fontMatcher, List list, FontWeight fontWeight, boolean z, FontWeight fontWeight2, FontWeight fontWeight3, int i, Object obj) {
        FontWeight fontWeight4 = null;
        if ((i & 4) != 0) {
            fontWeight2 = null;
        }
        if ((i & 8) != 0) {
            fontWeight3 = null;
        }
        int size = list.size();
        int i2 = 0;
        FontWeight fontWeight5 = null;
        while (true) {
            if (i2 >= size) {
                break;
            }
            FontWeight weight = ((Font) list.get(i2)).getWeight();
            if ((fontWeight2 == null || weight.compareTo(fontWeight2) >= 0) && (fontWeight3 == null || weight.compareTo(fontWeight3) <= 0)) {
                if (weight.compareTo(fontWeight) >= 0) {
                    if (weight.compareTo(fontWeight) <= 0) {
                        fontWeight4 = weight;
                        fontWeight5 = fontWeight4;
                        break;
                    }
                    if (fontWeight5 == null || weight.compareTo(fontWeight5) < 0) {
                        fontWeight5 = weight;
                    }
                } else if (fontWeight4 == null || weight.compareTo(fontWeight4) > 0) {
                    fontWeight4 = weight;
                }
            }
            i2++;
        }
        if (!z ? fontWeight5 != null : fontWeight4 == null) {
            fontWeight4 = fontWeight5;
        }
        ArrayList arrayList = new ArrayList(list.size());
        int size2 = list.size();
        for (int i4 = 0; i4 < size2; i4++) {
            Object obj2 = list.get(i4);
            if (Intrinsics.areEqual(((Font) obj2).getWeight(), fontWeight4)) {
                arrayList.add(obj2);
            }
        }
        return arrayList;
    }

    @NotNull
    public final List<Font> filterByClosestWeight$ui_text_release(@NotNull List<? extends Font> list, @NotNull FontWeight fontWeight, boolean z, @Nullable FontWeight fontWeight2, @Nullable FontWeight fontWeight3) {
        int size = list.size();
        FontWeight fontWeight4 = null;
        FontWeight fontWeight5 = null;
        int i = 0;
        while (true) {
            if (i >= size) {
                break;
            }
            FontWeight weight = list.get(i).getWeight();
            if ((fontWeight2 == null || weight.compareTo(fontWeight2) >= 0) && (fontWeight3 == null || weight.compareTo(fontWeight3) <= 0)) {
                if (weight.compareTo(fontWeight) >= 0) {
                    if (weight.compareTo(fontWeight) <= 0) {
                        fontWeight4 = weight;
                        fontWeight5 = fontWeight4;
                        break;
                    }
                    if (fontWeight5 == null || weight.compareTo(fontWeight5) < 0) {
                        fontWeight5 = weight;
                    }
                } else if (fontWeight4 == null || weight.compareTo(fontWeight4) > 0) {
                    fontWeight4 = weight;
                }
            }
            i++;
        }
        if (!z ? fontWeight5 != null : fontWeight4 == null) {
            fontWeight4 = fontWeight5;
        }
        ArrayList arrayList = new ArrayList(list.size());
        int size2 = list.size();
        for (int i2 = 0; i2 < size2; i2++) {
            Font font = list.get(i2);
            if (Intrinsics.areEqual(font.getWeight(), fontWeight4)) {
                arrayList.add(font);
            }
        }
        return arrayList;
    }

    @NotNull
    /* JADX INFO: renamed from: matchFont-RetOiIg, reason: not valid java name */
    public final List<Font> m20559matchFontRetOiIg(@NotNull FontFamily fontFamily, @NotNull FontWeight fontWeight, int fontStyle) {
        if (fontFamily instanceof FontListFontFamily) {
            return m20560matchFontRetOiIg((FontListFontFamily) fontFamily, fontWeight, fontStyle);
        }
        throw new IllegalArgumentException("Only FontFamily instances that presents a list of Fonts can be used");
    }

    @NotNull
    /* JADX INFO: renamed from: matchFont-RetOiIg, reason: not valid java name */
    public final List<Font> m20560matchFontRetOiIg(@NotNull FontListFontFamily fontFamily, @NotNull FontWeight fontWeight, int fontStyle) {
        return m20561matchFontRetOiIg(fontFamily.getFonts(), fontWeight, fontStyle);
    }

    @NotNull
    /* JADX INFO: renamed from: matchFont-RetOiIg, reason: not valid java name */
    public final List<Font> m20561matchFontRetOiIg(@NotNull List<? extends Font> fontList, @NotNull FontWeight fontWeight, int fontStyle) {
        ArrayList arrayList = new ArrayList(fontList.size());
        int size = fontList.size();
        int i = 0;
        for (int i2 = 0; i2 < size; i2++) {
            Font font = fontList.get(i2);
            Font font2 = font;
            if (Intrinsics.areEqual(font2.getWeight(), fontWeight) && FontStyle.m20565equalsimpl0(font2.getStyle(), fontStyle)) {
                arrayList.add(font);
            }
        }
        if (!arrayList.isEmpty()) {
            return arrayList;
        }
        ArrayList arrayList2 = new ArrayList(fontList.size());
        int size2 = fontList.size();
        for (int i4 = 0; i4 < size2; i4++) {
            Font font3 = fontList.get(i4);
            if (FontStyle.m20565equalsimpl0(font3.getStyle(), fontStyle)) {
                arrayList2.add(font3);
            }
        }
        if (!arrayList2.isEmpty()) {
            fontList = arrayList2;
        }
        List<? extends Font> list = fontList;
        FontWeight.Companion companion = FontWeight.INSTANCE;
        FontWeight fontWeight2 = null;
        if (fontWeight.compareTo(companion.getW400()) < 0) {
            int size3 = list.size();
            FontWeight fontWeight3 = null;
            int i5 = 0;
            while (true) {
                if (i5 >= size3) {
                    break;
                }
                FontWeight weight = list.get(i5).getWeight();
                if (weight.compareTo(fontWeight) < 0) {
                    if (fontWeight2 == null || weight.compareTo(fontWeight2) > 0) {
                        fontWeight2 = weight;
                    }
                } else {
                    if (weight.compareTo(fontWeight) <= 0) {
                        fontWeight3 = weight;
                        fontWeight2 = fontWeight3;
                        break;
                    }
                    if (fontWeight3 == null || weight.compareTo(fontWeight3) < 0) {
                        fontWeight3 = weight;
                    }
                }
                i5++;
            }
            if (fontWeight2 != null) {
                fontWeight3 = fontWeight2;
            }
            ArrayList arrayList3 = new ArrayList(list.size());
            int size4 = list.size();
            while (i < size4) {
                Font font4 = list.get(i);
                if (Intrinsics.areEqual(font4.getWeight(), fontWeight3)) {
                    arrayList3.add(font4);
                }
                i++;
            }
            return arrayList3;
        }
        if (fontWeight.compareTo(companion.getW500()) > 0) {
            int size5 = list.size();
            FontWeight fontWeight4 = null;
            int i6 = 0;
            while (true) {
                if (i6 >= size5) {
                    break;
                }
                FontWeight weight2 = list.get(i6).getWeight();
                if (weight2.compareTo(fontWeight) < 0) {
                    if (fontWeight2 == null || weight2.compareTo(fontWeight2) > 0) {
                        fontWeight2 = weight2;
                    }
                } else {
                    if (weight2.compareTo(fontWeight) <= 0) {
                        fontWeight4 = weight2;
                        fontWeight2 = fontWeight4;
                        break;
                    }
                    if (fontWeight4 == null || weight2.compareTo(fontWeight4) < 0) {
                        fontWeight4 = weight2;
                    }
                }
                i6++;
            }
            if (fontWeight4 == null) {
                fontWeight4 = fontWeight2;
            }
            ArrayList arrayList4 = new ArrayList(list.size());
            int size6 = list.size();
            while (i < size6) {
                Font font5 = list.get(i);
                if (Intrinsics.areEqual(font5.getWeight(), fontWeight4)) {
                    arrayList4.add(font5);
                }
                i++;
            }
            return arrayList4;
        }
        FontWeight w500 = companion.getW500();
        int size7 = list.size();
        FontWeight fontWeight5 = null;
        FontWeight fontWeight6 = null;
        int i7 = 0;
        while (true) {
            if (i7 >= size7) {
                break;
            }
            FontWeight weight3 = list.get(i7).getWeight();
            if (w500 == null || weight3.compareTo(w500) <= 0) {
                if (weight3.compareTo(fontWeight) < 0) {
                    if (fontWeight5 == null || weight3.compareTo(fontWeight5) > 0) {
                        fontWeight5 = weight3;
                    }
                } else {
                    if (weight3.compareTo(fontWeight) <= 0) {
                        fontWeight5 = weight3;
                        fontWeight6 = fontWeight5;
                        break;
                    }
                    if (fontWeight6 == null || weight3.compareTo(fontWeight6) < 0) {
                        fontWeight6 = weight3;
                    }
                }
            }
            i7++;
        }
        if (fontWeight6 != null) {
            fontWeight5 = fontWeight6;
        }
        ArrayList arrayList5 = new ArrayList(list.size());
        int size8 = list.size();
        for (int i8 = 0; i8 < size8; i8++) {
            Font font6 = list.get(i8);
            if (Intrinsics.areEqual(font6.getWeight(), fontWeight5)) {
                arrayList5.add(font6);
            }
        }
        if (!arrayList5.isEmpty()) {
            return arrayList5;
        }
        FontWeight w5002 = FontWeight.INSTANCE.getW500();
        int size9 = list.size();
        FontWeight fontWeight7 = null;
        int i9 = 0;
        while (true) {
            if (i9 >= size9) {
                break;
            }
            FontWeight weight4 = list.get(i9).getWeight();
            if (w5002 == null || weight4.compareTo(w5002) >= 0) {
                if (weight4.compareTo(fontWeight) < 0) {
                    if (fontWeight2 == null || weight4.compareTo(fontWeight2) > 0) {
                        fontWeight2 = weight4;
                    }
                } else {
                    if (weight4.compareTo(fontWeight) <= 0) {
                        fontWeight2 = weight4;
                        fontWeight7 = fontWeight2;
                        break;
                    }
                    if (fontWeight7 == null || weight4.compareTo(fontWeight7) < 0) {
                        fontWeight7 = weight4;
                    }
                }
            }
            i9++;
        }
        if (fontWeight7 != null) {
            fontWeight2 = fontWeight7;
        }
        ArrayList arrayList6 = new ArrayList(list.size());
        int size10 = list.size();
        while (i < size10) {
            Font font7 = list.get(i);
            if (Intrinsics.areEqual(font7.getWeight(), fontWeight2)) {
                arrayList6.add(font7);
            }
            i++;
        }
        return arrayList6;
    }
}
