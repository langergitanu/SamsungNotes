package androidx.glance.oneui.common.sizepolicy;

import android.util.SizeF;
import androidx.glance.oneui.common.AppWidgetSize;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function0;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(m13885d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u000b\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0016\b \u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J%\u0010 \u001a\u00020\u00112\u0006\u0010!\u001a\u00020\u00042\u0006\u0010\"\u001a\u00020\u0004H\u0000ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b#\u0010$J&\u0010%\u001a\u000e\u0012\u0004\u0012\u00020\u0013\u0012\u0004\u0012\u00020\u00130\u00122\u0006\u0010&\u001a\u00020\u0011H\u0000ø\u0001\u0001¢\u0006\u0004\b'\u0010(R\u0012\u0010\u0003\u001a\u00020\u0004X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0005\u0010\u0006R\u0012\u0010\u0007\u001a\u00020\u0004X¦\u0004¢\u0006\u0006\u001a\u0004\b\b\u0010\u0006R\u0012\u0010\t\u001a\u00020\u0004X¦\u0004¢\u0006\u0006\u001a\u0004\b\n\u0010\u0006R\u0012\u0010\u000b\u001a\u00020\u0004X¦\u0004¢\u0006\u0006\u001a\u0004\b\f\u0010\u0006R\u0012\u0010\r\u001a\u00020\u0004X¦\u0004¢\u0006\u0006\u001a\u0004\b\u000e\u0010\u0006R3\u0010\u000f\u001a\u001a\u0012\u0004\u0012\u00020\u0011\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0013\u0012\u0004\u0012\u00020\u00130\u00120\u00108BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0016\u0010\u0017\u001a\u0004\b\u0014\u0010\u0015R\u0012\u0010\u0018\u001a\u00020\u0004X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0019\u0010\u0006R\u0012\u0010\u001a\u001a\u00020\u0004X¦\u0004¢\u0006\u0006\u001a\u0004\b\u001b\u0010\u0006R\u0012\u0010\u001c\u001a\u00020\u0004X¦\u0004¢\u0006\u0006\u001a\u0004\b\u001d\u0010\u0006R\u0012\u0010\u001e\u001a\u00020\u0004X¦\u0004¢\u0006\u0006\u001a\u0004\b\u001f\u0010\u0006\u0082\u0002\u000b\n\u0002\b!\n\u0005\b¡\u001e0\u0001¨\u0006)"}, m13886d2 = {"Landroidx/glance/oneui/common/sizepolicy/SizePolicy;", "", "()V", "heightLevel0", "", "getHeightLevel0", "()F", "heightLevel1", "getHeightLevel1", "heightLevel2", "getHeightLevel2", "heightLevel3", "getHeightLevel3", "heightLevel4", "getHeightLevel4", "sizeDpRangeMap", "", "Landroidx/glance/oneui/common/AppWidgetSize;", "Lkotlin/Pair;", "Landroid/util/SizeF;", "getSizeDpRangeMap", "()Ljava/util/Map;", "sizeDpRangeMap$delegate", "Lkotlin/Lazy;", "widthLevel0", "getWidthLevel0", "widthLevel1", "getWidthLevel1", "widthLevel2", "getWidthLevel2", "widthLevel3", "getWidthLevel3", "convertDpToSize", "width", "height", "convertDpToSize-MIcY41U$glance_oneui_common_release", "(FF)I", "convertSizeToDp", "size", "convertSizeToDp-L2j3NV4$glance_oneui_common_release", "(I)Lkotlin/Pair;", "glance-oneui-common_release"}, m13887k = 1, m13888mv = {1, 9, 0}, m13890xi = 48)
public abstract class SizePolicy {

    /* JADX INFO: renamed from: sizeDpRangeMap$delegate, reason: from kotlin metadata */
    @NotNull
    private final Lazy sizeDpRangeMap = LazyKt.lazy(new Function0<Map<AppWidgetSize, ? extends Pair<? extends SizeF, ? extends SizeF>>>() { // from class: androidx.glance.oneui.common.sizepolicy.SizePolicy$sizeDpRangeMap$2
        {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        @NotNull
        public final Map<AppWidgetSize, ? extends Pair<? extends SizeF, ? extends SizeF>> invoke() {
            AppWidgetSize.Companion companion = AppWidgetSize.INSTANCE;
            return MapsKt.mapOf(TuplesKt.m13893to(AppWidgetSize.m21545boximpl(companion.m21571getTinyrx25Pp4()), new Pair(new SizeF(this.this$0.getWidthLevel0(), this.this$0.getHeightLevel0()), new SizeF(this.this$0.getWidthLevel1() - 1.0f, this.this$0.getHeightLevel1() - 1.0f))), TuplesKt.m13893to(AppWidgetSize.m21545boximpl(companion.m21570getSmallrx25Pp4()), new Pair(new SizeF(this.this$0.getWidthLevel1(), this.this$0.getHeightLevel0()), new SizeF(this.this$0.getWidthLevel2() - 1.0f, this.this$0.getHeightLevel1() - 1.0f))), TuplesKt.m13893to(AppWidgetSize.m21545boximpl(companion.m21569getMediumrx25Pp4()), new Pair(new SizeF(this.this$0.getWidthLevel1(), this.this$0.getHeightLevel1()), new SizeF(this.this$0.getWidthLevel2() - 1.0f, this.this$0.getHeightLevel2() - 1.0f))), TuplesKt.m13893to(AppWidgetSize.m21545boximpl(companion.m21573getWideSmallrx25Pp4()), new Pair(new SizeF(this.this$0.getWidthLevel2(), this.this$0.getHeightLevel0()), new SizeF(this.this$0.getWidthLevel3(), this.this$0.getHeightLevel1() - 1.0f))), TuplesKt.m13893to(AppWidgetSize.m21545boximpl(companion.m21568getLargerx25Pp4()), new Pair(new SizeF(this.this$0.getWidthLevel2(), this.this$0.getHeightLevel1()), new SizeF(this.this$0.getWidthLevel3(), this.this$0.getHeightLevel2() - 1.0f))), TuplesKt.m13893to(AppWidgetSize.m21545boximpl(companion.m21566getExtraLargerx25Pp4()), new Pair(new SizeF(this.this$0.getWidthLevel2(), this.this$0.getHeightLevel2()), new SizeF(this.this$0.getWidthLevel3(), this.this$0.getHeightLevel3() - 1.0f))), TuplesKt.m13893to(AppWidgetSize.m21545boximpl(companion.m21567getExtraLargeLongrx25Pp4()), new Pair(new SizeF(this.this$0.getWidthLevel2(), this.this$0.getHeightLevel3()), new SizeF(this.this$0.getWidthLevel3(), this.this$0.getHeightLevel4()))));
        }
    });

    private final Map<AppWidgetSize, Pair<SizeF, SizeF>> getSizeDpRangeMap() {
        return (Map) this.sizeDpRangeMap.getValue();
    }

    /* JADX INFO: renamed from: convertDpToSize-MIcY41U$glance_oneui_common_release, reason: not valid java name */
    public final int m21621convertDpToSizeMIcY41U$glance_oneui_common_release(float width, float height) {
        return width >= getWidthLevel2() ? height >= getHeightLevel3() ? AppWidgetSize.INSTANCE.m21567getExtraLargeLongrx25Pp4() : height >= getHeightLevel2() ? AppWidgetSize.INSTANCE.m21566getExtraLargerx25Pp4() : height >= getHeightLevel1() ? AppWidgetSize.INSTANCE.m21568getLargerx25Pp4() : AppWidgetSize.INSTANCE.m21573getWideSmallrx25Pp4() : width >= getWidthLevel1() ? height >= getHeightLevel1() ? AppWidgetSize.INSTANCE.m21569getMediumrx25Pp4() : AppWidgetSize.INSTANCE.m21570getSmallrx25Pp4() : AppWidgetSize.INSTANCE.m21571getTinyrx25Pp4();
    }

    @NotNull
    /* JADX INFO: renamed from: convertSizeToDp-L2j3NV4$glance_oneui_common_release, reason: not valid java name */
    public final Pair<SizeF, SizeF> m21622convertSizeToDpL2j3NV4$glance_oneui_common_release(int size) {
        Pair<SizeF, SizeF> pair = getSizeDpRangeMap().get(AppWidgetSize.m21545boximpl(size));
        return pair == null ? new Pair<>(new SizeF(0.0f, 0.0f), new SizeF(0.0f, 0.0f)) : pair;
    }

    public abstract float getHeightLevel0();

    public abstract float getHeightLevel1();

    public abstract float getHeightLevel2();

    public abstract float getHeightLevel3();

    public abstract float getHeightLevel4();

    public abstract float getWidthLevel0();

    public abstract float getWidthLevel1();

    public abstract float getWidthLevel2();

    public abstract float getWidthLevel3();
}
