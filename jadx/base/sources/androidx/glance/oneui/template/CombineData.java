package androidx.glance.oneui.template;

import androidx.compose.runtime.internal.StabilityInferred;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes4.dex */
@StabilityInferred(parameters = 0)
@Metadata(m13885d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\b\u0007\u0018\u00002\u00020\u0001B)\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\u0002\u0010\bR\u0016\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0016\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0016\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000e¨\u0006\u000f"}, m13886d2 = {"Landroidx/glance/oneui/template/CombineData;", "", "primaryContentData", "Landroidx/glance/oneui/template/PrimaryContentData;", "secondaryContentData", "Landroidx/glance/oneui/template/SecondaryContentData;", "tertiaryContentData", "Landroidx/glance/oneui/template/TertiaryContentData;", "(Landroidx/glance/oneui/template/PrimaryContentData;Landroidx/glance/oneui/template/SecondaryContentData;Landroidx/glance/oneui/template/TertiaryContentData;)V", "getPrimaryContentData$glance_oneui_template_release", "()Landroidx/glance/oneui/template/PrimaryContentData;", "getSecondaryContentData$glance_oneui_template_release", "()Landroidx/glance/oneui/template/SecondaryContentData;", "getTertiaryContentData$glance_oneui_template_release", "()Landroidx/glance/oneui/template/TertiaryContentData;", "glance-oneui-template_release"}, m13887k = 1, m13888mv = {1, 9, 0}, m13890xi = 48)
public final class CombineData {
    public static final int $stable = 8;

    @Nullable
    private final PrimaryContentData primaryContentData;

    @Nullable
    private final SecondaryContentData secondaryContentData;

    @Nullable
    private final TertiaryContentData tertiaryContentData;

    public CombineData() {
        this(null, null, null, 7, null);
    }

    @Nullable
    /* JADX INFO: renamed from: getPrimaryContentData$glance_oneui_template_release, reason: from getter */
    public final PrimaryContentData getPrimaryContentData() {
        return this.primaryContentData;
    }

    @Nullable
    /* JADX INFO: renamed from: getSecondaryContentData$glance_oneui_template_release, reason: from getter */
    public final SecondaryContentData getSecondaryContentData() {
        return this.secondaryContentData;
    }

    @Nullable
    /* JADX INFO: renamed from: getTertiaryContentData$glance_oneui_template_release, reason: from getter */
    public final TertiaryContentData getTertiaryContentData() {
        return this.tertiaryContentData;
    }

    public CombineData(@Nullable PrimaryContentData primaryContentData, @Nullable SecondaryContentData secondaryContentData, @Nullable TertiaryContentData tertiaryContentData) {
        this.primaryContentData = primaryContentData;
        this.secondaryContentData = secondaryContentData;
        this.tertiaryContentData = tertiaryContentData;
    }

    public /* synthetic */ CombineData(PrimaryContentData primaryContentData, SecondaryContentData secondaryContentData, TertiaryContentData tertiaryContentData, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : primaryContentData, (i & 2) != 0 ? null : secondaryContentData, (i & 4) != 0 ? null : tertiaryContentData);
    }
}
