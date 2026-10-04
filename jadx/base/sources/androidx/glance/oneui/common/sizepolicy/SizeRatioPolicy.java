package androidx.glance.oneui.common.sizepolicy;

import android.util.Size;
import android.util.SizeF;
import androidx.collection.AbstractC0622a;
import androidx.glance.oneui.common.AppWidgetSize;
import androidx.glance.oneui.common.GlanceLog;
import com.samsung.android.support.senl.p148nt.data.common.utils.AbstractC11014a;
import com.samsung.android.support.senl.p148nt.data.database.core.query.sqlbuilder.SQLKeyword;
import java.util.Iterator;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(m13885d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u000b\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0000\b&\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J+\u0010\u001d\u001a\u00020\u00112\u0006\u0010\u001e\u001a\u00020\u00042\u0006\u0010\u001f\u001a\u00020\u00042\u0006\u0010 \u001a\u00020!ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\"\u0010#J,\u0010$\u001a\u000e\u0012\u0004\u0012\u00020&\u0012\u0004\u0012\u00020&0%2\u0006\u0010'\u001a\u00020\u00112\u0006\u0010 \u001a\u00020!ø\u0001\u0001¢\u0006\u0004\b(\u0010)J\b\u0010*\u001a\u00020+H\u0016R\u0012\u0010\u0003\u001a\u00020\u0004X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0005\u0010\u0006R\u0012\u0010\u0007\u001a\u00020\u0004X¦\u0004¢\u0006\u0006\u001a\u0004\b\b\u0010\u0006R\u0012\u0010\t\u001a\u00020\u0004X¦\u0004¢\u0006\u0006\u001a\u0004\b\n\u0010\u0006R\u0012\u0010\u000b\u001a\u00020\u0004X¦\u0004¢\u0006\u0006\u001a\u0004\b\f\u0010\u0006R\u0012\u0010\r\u001a\u00020\u0004X¦\u0004¢\u0006\u0006\u001a\u0004\b\u000e\u0010\u0006R \u0010\u000f\u001a\u000e\u0012\u0004\u0012\u00020\u0011\u0012\u0004\u0012\u00020\u00120\u00108BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u0013\u0010\u0014R\u0012\u0010\u0015\u001a\u00020\u0004X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0016\u0010\u0006R\u0012\u0010\u0017\u001a\u00020\u0004X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0018\u0010\u0006R\u0012\u0010\u0019\u001a\u00020\u0004X¦\u0004¢\u0006\u0006\u001a\u0004\b\u001a\u0010\u0006R\u0012\u0010\u001b\u001a\u00020\u0004X¦\u0004¢\u0006\u0006\u001a\u0004\b\u001c\u0010\u0006\u0082\u0002\u000b\n\u0002\b!\n\u0005\b¡\u001e0\u0001¨\u0006,"}, m13886d2 = {"Landroidx/glance/oneui/common/sizepolicy/SizeRatioPolicy;", "", "()V", "hRatioLevel0", "", "getHRatioLevel0", "()F", "hRatioLevel1", "getHRatioLevel1", "hRatioLevel2", "getHRatioLevel2", "hRatioLevel3", "getHRatioLevel3", "hRatioLevel4", "getHRatioLevel4", "sizeRatioMap", "", "Landroidx/glance/oneui/common/AppWidgetSize;", "Landroidx/glance/oneui/common/sizepolicy/AppWidgetSizeRatio;", "getSizeRatioMap", "()Ljava/util/Map;", "wRatioLevel0", "getWRatioLevel0", "wRatioLevel1", "getWRatioLevel1", "wRatioLevel2", "getWRatioLevel2", "wRatioLevel3", "getWRatioLevel3", "convertDpToSize", "width", "height", "screenSize", "Landroid/util/Size;", "convertDpToSize-Kiq_Kzg", "(FFLandroid/util/Size;)I", "convertSizeToDp", "Lkotlin/Pair;", "Landroid/util/SizeF;", "size", "convertSizeToDp-h91vINI", "(ILandroid/util/Size;)Lkotlin/Pair;", "toString", "", "glance-oneui-common_release"}, m13887k = 1, m13888mv = {1, 9, 0}, m13890xi = 48)
@SourceDebugExtension({"SMAP\nSizeRatioPolicy.kt\nKotlin\n*S Kotlin\n*F\n+ 1 SizeRatioPolicy.kt\nandroidx/glance/oneui/common/sizepolicy/SizeRatioPolicy\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,132:1\n288#2,2:133\n*S KotlinDebug\n*F\n+ 1 SizeRatioPolicy.kt\nandroidx/glance/oneui/common/sizepolicy/SizeRatioPolicy\n*L\n104#1:133,2\n*E\n"})
public abstract class SizeRatioPolicy {
    private final Map<AppWidgetSize, AppWidgetSizeRatio> getSizeRatioMap() {
        AppWidgetSize.Companion companion = AppWidgetSize.INSTANCE;
        return MapsKt.mapOf(TuplesKt.m13893to(AppWidgetSize.m21545boximpl(companion.m21571getTinyrx25Pp4()), new AppWidgetSizeRatio(new SizeF(getWRatioLevel0(), getHRatioLevel0()), new SizeF(getWRatioLevel1(), getHRatioLevel1()))), TuplesKt.m13893to(AppWidgetSize.m21545boximpl(companion.m21570getSmallrx25Pp4()), new AppWidgetSizeRatio(new SizeF(SizeRatioPolicyKt.increase(getWRatioLevel1()), getHRatioLevel0()), new SizeF(getWRatioLevel2(), getHRatioLevel1()))), TuplesKt.m13893to(AppWidgetSize.m21545boximpl(companion.m21573getWideSmallrx25Pp4()), new AppWidgetSizeRatio(new SizeF(SizeRatioPolicyKt.increase(getWRatioLevel2()), getHRatioLevel0()), new SizeF(getWRatioLevel3(), getHRatioLevel1()))), TuplesKt.m13893to(AppWidgetSize.m21545boximpl(companion.m21569getMediumrx25Pp4()), new AppWidgetSizeRatio(new SizeF(SizeRatioPolicyKt.increase(getWRatioLevel1()), SizeRatioPolicyKt.increase(getHRatioLevel1())), new SizeF(getWRatioLevel2(), getHRatioLevel2()))), TuplesKt.m13893to(AppWidgetSize.m21545boximpl(companion.m21568getLargerx25Pp4()), new AppWidgetSizeRatio(new SizeF(SizeRatioPolicyKt.increase(getWRatioLevel2()), SizeRatioPolicyKt.increase(getHRatioLevel1())), new SizeF(getWRatioLevel3(), getHRatioLevel2()))), TuplesKt.m13893to(AppWidgetSize.m21545boximpl(companion.m21566getExtraLargerx25Pp4()), new AppWidgetSizeRatio(new SizeF(SizeRatioPolicyKt.increase(getWRatioLevel2()), SizeRatioPolicyKt.increase(getHRatioLevel2())), new SizeF(getWRatioLevel3(), getHRatioLevel3()))), TuplesKt.m13893to(AppWidgetSize.m21545boximpl(companion.m21567getExtraLargeLongrx25Pp4()), new AppWidgetSizeRatio(new SizeF(SizeRatioPolicyKt.increase(getWRatioLevel2()), SizeRatioPolicyKt.increase(getHRatioLevel3())), new SizeF(getWRatioLevel3(), getHRatioLevel4()))));
    }

    /* JADX INFO: renamed from: convertDpToSize-Kiq_Kzg, reason: not valid java name */
    public final int m21623convertDpToSizeKiq_Kzg(float width, float height, @NotNull Size screenSize) {
        Object next;
        Intrinsics.checkNotNullParameter(screenSize, "screenSize");
        Iterator it = MapsKt.toList(getSizeRatioMap()).iterator();
        while (true) {
            if (!it.hasNext()) {
                next = null;
                break;
            }
            next = it.next();
            if (((AppWidgetSizeRatio) ((Pair) next).getSecond()).checkFitInSizeRange(width, height, screenSize)) {
                break;
            }
        }
        Pair pair = (Pair) next;
        int mask = pair != null ? ((AppWidgetSize) pair.getFirst()).getMask() : AppWidgetSize.INSTANCE.m21572getUnknownrx25Pp4();
        GlanceLog.Companion companion = GlanceLog.INSTANCE;
        String strM21559toStringimpl = AppWidgetSize.m21559toStringimpl(mask);
        StringBuilder sbM1176v = AbstractC0622a.m1176v("convertDpToSize : ", width, SQLKeyword.COMMA, height, SQLKeyword.COMMA);
        sbM1176v.append(strM21559toStringimpl);
        sbM1176v.append(" / ");
        sbM1176v.append(this);
        companion.m2301i("GWT:SizePolicy", sbM1176v.toString());
        return mask;
    }

    @NotNull
    /* JADX INFO: renamed from: convertSizeToDp-h91vINI, reason: not valid java name */
    public final Pair<SizeF, SizeF> m21624convertSizeToDph91vINI(int size, @NotNull Size screenSize) {
        Pair<SizeF, SizeF> dp;
        Intrinsics.checkNotNullParameter(screenSize, "screenSize");
        AppWidgetSizeRatio appWidgetSizeRatio = getSizeRatioMap().get(AppWidgetSize.m21545boximpl(size));
        if (appWidgetSizeRatio == null || (dp = appWidgetSizeRatio.toDp(screenSize)) == null) {
            return new Pair<>(new SizeF(0.0f, 0.0f), new SizeF(0.0f, 0.0f));
        }
        GlanceLog.INSTANCE.m2301i("GWT:SizePolicy", "convertSizeToDp : " + AppWidgetSize.m21559toStringimpl(size) + SQLKeyword.COMMA + dp);
        return dp;
    }

    public abstract float getHRatioLevel0();

    public abstract float getHRatioLevel1();

    public abstract float getHRatioLevel2();

    public abstract float getHRatioLevel3();

    public abstract float getHRatioLevel4();

    public abstract float getWRatioLevel0();

    public abstract float getWRatioLevel1();

    public abstract float getWRatioLevel2();

    public abstract float getWRatioLevel3();

    @NotNull
    public String toString() {
        float wRatioLevel0 = getWRatioLevel0();
        float wRatioLevel1 = getWRatioLevel1();
        float wRatioLevel2 = getWRatioLevel2();
        float wRatioLevel3 = getWRatioLevel3();
        float hRatioLevel0 = getHRatioLevel0();
        float hRatioLevel1 = getHRatioLevel1();
        float hRatioLevel2 = getHRatioLevel2();
        float hRatioLevel3 = getHRatioLevel3();
        float hRatioLevel4 = getHRatioLevel4();
        StringBuilder sbM1176v = AbstractC0622a.m1176v("widthLevel0=", wRatioLevel0, ",widthLevel1=", wRatioLevel1, "widthLevel2=");
        AbstractC11014a.m12337v(sbM1176v, wRatioLevel2, ",widthLevel3=", wRatioLevel3, "heightLevel0=");
        AbstractC11014a.m12337v(sbM1176v, hRatioLevel0, ",heightLevel1=", hRatioLevel1, "heightLevel2=");
        AbstractC11014a.m12337v(sbM1176v, hRatioLevel2, ",heightLevel3=", hRatioLevel3, ",heightLevel4=");
        sbM1176v.append(hRatioLevel4);
        return sbM1176v.toString();
    }
}
