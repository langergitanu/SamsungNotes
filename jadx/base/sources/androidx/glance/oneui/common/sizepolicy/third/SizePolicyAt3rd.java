package androidx.glance.oneui.common.sizepolicy.third;

import androidx.glance.oneui.common.sizepolicy.SizePolicy;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(m13885d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b0\u0018\u00002\u00020\u0001:\u0002\u0003\u0004B\u0007\b\u0004¢\u0006\u0002\u0010\u0002\u0082\u0001\u0002\u0005\u0006¨\u0006\u0007"}, m13886d2 = {"Landroidx/glance/oneui/common/sizepolicy/third/SizePolicyAt3rd;", "Landroidx/glance/oneui/common/sizepolicy/SizePolicy;", "()V", "LandscapePolicy", "PortraitPolicy", "Landroidx/glance/oneui/common/sizepolicy/third/SizePolicyAt3rd$LandscapePolicy;", "Landroidx/glance/oneui/common/sizepolicy/third/SizePolicyAt3rd$PortraitPolicy;", "glance-oneui-common_release"}, m13887k = 1, m13888mv = {1, 9, 0}, m13890xi = 48)
public abstract class SizePolicyAt3rd extends SizePolicy {

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0013\bÀ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u0014\u0010\u0003\u001a\u00020\u0004X\u0096D¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0007\u001a\u00020\u0004X\u0096D¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\u0006R\u0014\u0010\t\u001a\u00020\u0004X\u0096D¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u0006R\u0014\u0010\u000b\u001a\u00020\u0004X\u0096D¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\u0006R\u0014\u0010\r\u001a\u00020\u0004X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u0006R\u0014\u0010\u000f\u001a\u00020\u0004X\u0096D¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0006R\u0014\u0010\u0011\u001a\u00020\u0004X\u0096D¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0006R\u0014\u0010\u0013\u001a\u00020\u0004X\u0096D¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0006R\u0014\u0010\u0015\u001a\u00020\u0004X\u0096D¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0006¨\u0006\u0017"}, m13886d2 = {"Landroidx/glance/oneui/common/sizepolicy/third/SizePolicyAt3rd$LandscapePolicy;", "Landroidx/glance/oneui/common/sizepolicy/third/SizePolicyAt3rd;", "()V", "heightLevel0", "", "getHeightLevel0", "()F", "heightLevel1", "getHeightLevel1", "heightLevel2", "getHeightLevel2", "heightLevel3", "getHeightLevel3", "heightLevel4", "getHeightLevel4", "widthLevel0", "getWidthLevel0", "widthLevel1", "getWidthLevel1", "widthLevel2", "getWidthLevel2", "widthLevel3", "getWidthLevel3", "glance-oneui-common_release"}, m13887k = 1, m13888mv = {1, 9, 0}, m13890xi = 48)
    public static final class LandscapePolicy extends SizePolicyAt3rd {

        @NotNull
        public static final LandscapePolicy INSTANCE;
        private static final float heightLevel0;
        private static final float heightLevel1;
        private static final float heightLevel2;
        private static final float heightLevel3;
        private static final float heightLevel4;
        private static final float widthLevel0;
        private static final float widthLevel1;
        private static final float widthLevel2;
        private static final float widthLevel3;

        static {
            LandscapePolicy landscapePolicy = new LandscapePolicy();
            INSTANCE = landscapePolicy;
            widthLevel0 = Float.MIN_VALUE;
            widthLevel1 = 109.0f;
            widthLevel2 = 345.0f;
            widthLevel3 = Float.MAX_VALUE;
            heightLevel0 = Float.MIN_VALUE;
            heightLevel1 = 120.0f;
            heightLevel2 = 241.0f;
            heightLevel3 = Float.MAX_VALUE;
            heightLevel4 = landscapePolicy.getHeightLevel3();
        }

        private LandscapePolicy() {
            super(null);
        }

        @Override // androidx.glance.oneui.common.sizepolicy.SizePolicy
        public float getHeightLevel0() {
            return heightLevel0;
        }

        @Override // androidx.glance.oneui.common.sizepolicy.SizePolicy
        public float getHeightLevel1() {
            return heightLevel1;
        }

        @Override // androidx.glance.oneui.common.sizepolicy.SizePolicy
        public float getHeightLevel2() {
            return heightLevel2;
        }

        @Override // androidx.glance.oneui.common.sizepolicy.SizePolicy
        public float getHeightLevel3() {
            return heightLevel3;
        }

        @Override // androidx.glance.oneui.common.sizepolicy.SizePolicy
        public float getHeightLevel4() {
            return heightLevel4;
        }

        @Override // androidx.glance.oneui.common.sizepolicy.SizePolicy
        public float getWidthLevel0() {
            return widthLevel0;
        }

        @Override // androidx.glance.oneui.common.sizepolicy.SizePolicy
        public float getWidthLevel1() {
            return widthLevel1;
        }

        @Override // androidx.glance.oneui.common.sizepolicy.SizePolicy
        public float getWidthLevel2() {
            return widthLevel2;
        }

        @Override // androidx.glance.oneui.common.sizepolicy.SizePolicy
        public float getWidthLevel3() {
            return widthLevel3;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0013\bÀ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u0014\u0010\u0003\u001a\u00020\u0004X\u0096D¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0007\u001a\u00020\u0004X\u0096D¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\u0006R\u0014\u0010\t\u001a\u00020\u0004X\u0096D¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u0006R\u0014\u0010\u000b\u001a\u00020\u0004X\u0096D¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\u0006R\u0014\u0010\r\u001a\u00020\u0004X\u0096D¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u0006R\u0014\u0010\u000f\u001a\u00020\u0004X\u0096D¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0006R\u0014\u0010\u0011\u001a\u00020\u0004X\u0096D¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0006R\u0014\u0010\u0013\u001a\u00020\u0004X\u0096D¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0006R\u0014\u0010\u0015\u001a\u00020\u0004X\u0096D¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0006¨\u0006\u0017"}, m13886d2 = {"Landroidx/glance/oneui/common/sizepolicy/third/SizePolicyAt3rd$PortraitPolicy;", "Landroidx/glance/oneui/common/sizepolicy/third/SizePolicyAt3rd;", "()V", "heightLevel0", "", "getHeightLevel0", "()F", "heightLevel1", "getHeightLevel1", "heightLevel2", "getHeightLevel2", "heightLevel3", "getHeightLevel3", "heightLevel4", "getHeightLevel4", "widthLevel0", "getWidthLevel0", "widthLevel1", "getWidthLevel1", "widthLevel2", "getWidthLevel2", "widthLevel3", "getWidthLevel3", "glance-oneui-common_release"}, m13887k = 1, m13888mv = {1, 9, 0}, m13890xi = 48)
    public static final class PortraitPolicy extends SizePolicyAt3rd {

        @NotNull
        public static final PortraitPolicy INSTANCE = new PortraitPolicy();
        private static final float widthLevel0 = Float.MIN_VALUE;
        private static final float widthLevel1 = 118.0f;
        private static final float widthLevel2 = 268.0f;
        private static final float widthLevel3 = Float.MAX_VALUE;
        private static final float heightLevel0 = Float.MIN_VALUE;
        private static final float heightLevel1 = 131.0f;
        private static final float heightLevel2 = 354.0f;
        private static final float heightLevel3 = 600.0f;
        private static final float heightLevel4 = Float.MAX_VALUE;

        private PortraitPolicy() {
            super(null);
        }

        @Override // androidx.glance.oneui.common.sizepolicy.SizePolicy
        public float getHeightLevel0() {
            return heightLevel0;
        }

        @Override // androidx.glance.oneui.common.sizepolicy.SizePolicy
        public float getHeightLevel1() {
            return heightLevel1;
        }

        @Override // androidx.glance.oneui.common.sizepolicy.SizePolicy
        public float getHeightLevel2() {
            return heightLevel2;
        }

        @Override // androidx.glance.oneui.common.sizepolicy.SizePolicy
        public float getHeightLevel3() {
            return heightLevel3;
        }

        @Override // androidx.glance.oneui.common.sizepolicy.SizePolicy
        public float getHeightLevel4() {
            return heightLevel4;
        }

        @Override // androidx.glance.oneui.common.sizepolicy.SizePolicy
        public float getWidthLevel0() {
            return widthLevel0;
        }

        @Override // androidx.glance.oneui.common.sizepolicy.SizePolicy
        public float getWidthLevel1() {
            return widthLevel1;
        }

        @Override // androidx.glance.oneui.common.sizepolicy.SizePolicy
        public float getWidthLevel2() {
            return widthLevel2;
        }

        @Override // androidx.glance.oneui.common.sizepolicy.SizePolicy
        public float getWidthLevel3() {
            return widthLevel3;
        }
    }

    public /* synthetic */ SizePolicyAt3rd(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }

    private SizePolicyAt3rd() {
    }
}
