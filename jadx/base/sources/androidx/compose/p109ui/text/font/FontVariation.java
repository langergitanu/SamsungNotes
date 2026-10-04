package androidx.compose.p109ui.text.font;

import androidx.collection.AbstractC0622a;
import androidx.compose.foundation.layout.AbstractC1038a;
import androidx.compose.p109ui.unit.Density;
import androidx.compose.p109ui.unit.TextUnit;
import androidx.compose.runtime.AbstractC1974b;
import androidx.compose.runtime.Immutable;
import androidx.compose.runtime.internal.StabilityInferred;
import com.samsung.android.support.senl.p148nt.base.common.constants.SettingsConstants;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.collections.CollectionsKt__MutableCollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.jvm.internal.SpreadBuilder;
import org.apache.commons.beanutils.PropertyUtils;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import p001A.AbstractC0000a;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes4.dex */
@StabilityInferred(parameters = 1)
@Metadata(m13885d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\bÇ\u0002\u0018\u00002\u00020\u0001:\u0005\u0003\u001d\u001e\u001f\tB\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0016\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bJ4\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000e2\u0012\u0010\u000f\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00040\u0010\"\u00020\u0004ø\u0001\u0000¢\u0006\u0004\b\u0011\u0010\u0012J\u000e\u0010\u0013\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0014J\u000e\u0010\u0015\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\bJ\u0018\u0010\u0016\u001a\u00020\u00042\u0006\u0010\u0017\u001a\u00020\u0018ø\u0001\u0000¢\u0006\u0004\b\u0019\u0010\u001aJ\u000e\u0010\u001b\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\bJ\u000e\u0010\u000b\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0014J\u000e\u0010\u001c\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\b\u0082\u0002\u0007\n\u0005\b¡\u001e0\u0001¨\u0006 "}, m13886d2 = {"Landroidx/compose/ui/text/font/FontVariation;", "", "()V", "Setting", "Landroidx/compose/ui/text/font/FontVariation$Setting;", "name", "", "value", "", "Settings", "Landroidx/compose/ui/text/font/FontVariation$Settings;", "weight", "Landroidx/compose/ui/text/font/FontWeight;", "style", "Landroidx/compose/ui/text/font/FontStyle;", SettingsConstants.EXTRA_FROM_NOTES_ASSIST_FOR_LAUNCH_FROM_SETTINGS, "", "Settings-6EWAqTQ", "(Landroidx/compose/ui/text/font/FontWeight;I[Landroidx/compose/ui/text/font/FontVariation$Setting;)Landroidx/compose/ui/text/font/FontVariation$Settings;", "grade", "", "italic", "opticalSizing", "textSize", "Landroidx/compose/ui/unit/TextUnit;", "opticalSizing--R2X_6o", "(J)Landroidx/compose/ui/text/font/FontVariation$Setting;", "slant", "width", "SettingFloat", "SettingInt", "SettingTextUnit", "ui-text_release"}, m13887k = 1, m13888mv = {1, 8, 0}, m13890xi = 48)
public final class FontVariation {
    public static final int $stable = 0;

    @NotNull
    public static final FontVariation INSTANCE = new FontVariation();

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Immutable
    @Metadata(m13885d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\bw\u0018\u00002\u00020\u0001J\u0012\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\rH&R\u0012\u0010\u0002\u001a\u00020\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0004\u0010\u0005R\u0012\u0010\u0006\u001a\u00020\u0007X¦\u0004¢\u0006\u0006\u001a\u0004\b\b\u0010\t\u0082\u0001\u0003\u000e\u000f\u0010ø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001¨\u0006\u0011À\u0006\u0001"}, m13886d2 = {"Landroidx/compose/ui/text/font/FontVariation$Setting;", "", "axisName", "", "getAxisName", "()Ljava/lang/String;", "needsDensity", "", "getNeedsDensity", "()Z", "toVariationValue", "", "density", "Landroidx/compose/ui/unit/Density;", "Landroidx/compose/ui/text/font/FontVariation$SettingFloat;", "Landroidx/compose/ui/text/font/FontVariation$SettingInt;", "Landroidx/compose/ui/text/font/FontVariation$SettingTextUnit;", "ui-text_release"}, m13887k = 1, m13888mv = {1, 8, 0}, m13890xi = 48)
    public interface Setting {
        @NotNull
        String getAxisName();

        boolean getNeedsDensity();

        float toVariationValue(@Nullable Density density);
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Immutable
    @Metadata(m13885d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\u0013\u0010\u000f\u001a\u00020\n2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011H\u0096\u0002J\b\u0010\u0012\u001a\u00020\u0013H\u0016J\b\u0010\u0014\u001a\u00020\u0003H\u0016J\u0012\u0010\u0015\u001a\u00020\u00052\b\u0010\u0016\u001a\u0004\u0018\u00010\u0017H\u0016R\u0014\u0010\u0002\u001a\u00020\u0003X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0014\u0010\t\u001a\u00020\nX\u0096D¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000e¨\u0006\u0018"}, m13886d2 = {"Landroidx/compose/ui/text/font/FontVariation$SettingFloat;", "Landroidx/compose/ui/text/font/FontVariation$Setting;", "axisName", "", "value", "", "(Ljava/lang/String;F)V", "getAxisName", "()Ljava/lang/String;", "needsDensity", "", "getNeedsDensity", "()Z", "getValue", "()F", "equals", "other", "", "hashCode", "", "toString", "toVariationValue", "density", "Landroidx/compose/ui/unit/Density;", "ui-text_release"}, m13887k = 1, m13888mv = {1, 8, 0}, m13890xi = 48)
    public static final class SettingFloat implements Setting {

        @NotNull
        private final String axisName;
        private final boolean needsDensity;
        private final float value;

        public SettingFloat(@NotNull String str, float f) {
            this.axisName = str;
            this.value = f;
        }

        public boolean equals(@Nullable Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof SettingFloat)) {
                return false;
            }
            SettingFloat settingFloat = (SettingFloat) other;
            return Intrinsics.areEqual(getAxisName(), settingFloat.getAxisName()) && this.value == settingFloat.value;
        }

        @Override // androidx.compose.ui.text.font.FontVariation.Setting
        @NotNull
        public String getAxisName() {
            return this.axisName;
        }

        @Override // androidx.compose.ui.text.font.FontVariation.Setting
        public boolean getNeedsDensity() {
            return this.needsDensity;
        }

        public final float getValue() {
            return this.value;
        }

        public int hashCode() {
            return Float.hashCode(this.value) + (getAxisName().hashCode() * 31);
        }

        @NotNull
        public String toString() {
            StringBuilder sb = new StringBuilder("FontVariation.Setting(axisName='");
            sb.append(getAxisName());
            sb.append("', value=");
            return AbstractC0622a.m1171q(sb, this.value, PropertyUtils.MAPPED_DELIM2);
        }

        @Override // androidx.compose.ui.text.font.FontVariation.Setting
        public float toVariationValue(@Nullable Density density) {
            return this.value;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Immutable
    @Metadata(m13885d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\u0013\u0010\u000f\u001a\u00020\n2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011H\u0096\u0002J\b\u0010\u0012\u001a\u00020\u0005H\u0016J\b\u0010\u0013\u001a\u00020\u0003H\u0016J\u0012\u0010\u0014\u001a\u00020\u00152\b\u0010\u0016\u001a\u0004\u0018\u00010\u0017H\u0016R\u0014\u0010\u0002\u001a\u00020\u0003X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0014\u0010\t\u001a\u00020\nX\u0096D¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000e¨\u0006\u0018"}, m13886d2 = {"Landroidx/compose/ui/text/font/FontVariation$SettingInt;", "Landroidx/compose/ui/text/font/FontVariation$Setting;", "axisName", "", "value", "", "(Ljava/lang/String;I)V", "getAxisName", "()Ljava/lang/String;", "needsDensity", "", "getNeedsDensity", "()Z", "getValue", "()I", "equals", "other", "", "hashCode", "toString", "toVariationValue", "", "density", "Landroidx/compose/ui/unit/Density;", "ui-text_release"}, m13887k = 1, m13888mv = {1, 8, 0}, m13890xi = 48)
    public static final class SettingInt implements Setting {

        @NotNull
        private final String axisName;
        private final boolean needsDensity;
        private final int value;

        public SettingInt(@NotNull String str, int i) {
            this.axisName = str;
            this.value = i;
        }

        public boolean equals(@Nullable Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof SettingInt)) {
                return false;
            }
            SettingInt settingInt = (SettingInt) other;
            return Intrinsics.areEqual(getAxisName(), settingInt.getAxisName()) && this.value == settingInt.value;
        }

        @Override // androidx.compose.ui.text.font.FontVariation.Setting
        @NotNull
        public String getAxisName() {
            return this.axisName;
        }

        @Override // androidx.compose.ui.text.font.FontVariation.Setting
        public boolean getNeedsDensity() {
            return this.needsDensity;
        }

        public final int getValue() {
            return this.value;
        }

        public int hashCode() {
            return (getAxisName().hashCode() * 31) + this.value;
        }

        @NotNull
        public String toString() {
            StringBuilder sb = new StringBuilder("FontVariation.Setting(axisName='");
            sb.append(getAxisName());
            sb.append("', value=");
            return AbstractC0000a.m13j(sb, this.value, PropertyUtils.MAPPED_DELIM2);
        }

        @Override // androidx.compose.ui.text.font.FontVariation.Setting
        public float toVariationValue(@Nullable Density density) {
            return this.value;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\u0013\u0010\u0010\u001a\u00020\n2\b\u0010\u0011\u001a\u0004\u0018\u00010\u0012H\u0096\u0002J\b\u0010\u0013\u001a\u00020\u0014H\u0016J\b\u0010\u0015\u001a\u00020\u0003H\u0016J\u0012\u0010\u0016\u001a\u00020\u00172\b\u0010\u0018\u001a\u0004\u0018\u00010\u0019H\u0016R\u0014\u0010\u0002\u001a\u00020\u0003X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0014\u0010\t\u001a\u00020\nX\u0096D¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0019\u0010\u0004\u001a\u00020\u0005ø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u0010\u000f\u001a\u0004\b\r\u0010\u000e\u0082\u0002\u000b\n\u0005\b¡\u001e0\u0001\n\u0002\b!¨\u0006\u001a"}, m13886d2 = {"Landroidx/compose/ui/text/font/FontVariation$SettingTextUnit;", "Landroidx/compose/ui/text/font/FontVariation$Setting;", "axisName", "", "value", "Landroidx/compose/ui/unit/TextUnit;", "(Ljava/lang/String;JLkotlin/jvm/internal/DefaultConstructorMarker;)V", "getAxisName", "()Ljava/lang/String;", "needsDensity", "", "getNeedsDensity", "()Z", "getValue-XSAIIZE", "()J", "J", "equals", "other", "", "hashCode", "", "toString", "toVariationValue", "", "density", "Landroidx/compose/ui/unit/Density;", "ui-text_release"}, m13887k = 1, m13888mv = {1, 8, 0}, m13890xi = 48)
    @Immutable
    @SourceDebugExtension({"SMAP\nFontVariation.kt\nKotlin\n*S Kotlin\n*F\n+ 1 FontVariation.kt\nandroidx/compose/ui/text/font/FontVariation$SettingTextUnit\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,373:1\n1#2:374\n*E\n"})
    public static final class SettingTextUnit implements Setting {

        @NotNull
        private final String axisName;
        private final boolean needsDensity;
        private final long value;

        public /* synthetic */ SettingTextUnit(String str, long j, DefaultConstructorMarker defaultConstructorMarker) {
            this(str, j);
        }

        public boolean equals(@Nullable Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof SettingTextUnit)) {
                return false;
            }
            SettingTextUnit settingTextUnit = (SettingTextUnit) other;
            return Intrinsics.areEqual(getAxisName(), settingTextUnit.getAxisName()) && TextUnit.m21158equalsimpl0(this.value, settingTextUnit.value);
        }

        @Override // androidx.compose.ui.text.font.FontVariation.Setting
        @NotNull
        public String getAxisName() {
            return this.axisName;
        }

        @Override // androidx.compose.ui.text.font.FontVariation.Setting
        public boolean getNeedsDensity() {
            return this.needsDensity;
        }

        /* JADX INFO: renamed from: getValue-XSAIIZE, reason: not valid java name and from getter */
        public final long getValue() {
            return this.value;
        }

        public int hashCode() {
            return TextUnit.m21162hashCodeimpl(this.value) + (getAxisName().hashCode() * 31);
        }

        @NotNull
        public String toString() {
            return "FontVariation.Setting(axisName='" + getAxisName() + "', value=" + ((Object) TextUnit.m21168toStringimpl(this.value)) + PropertyUtils.MAPPED_DELIM2;
        }

        @Override // androidx.compose.ui.text.font.FontVariation.Setting
        public float toVariationValue(@Nullable Density density) {
            if (density == null) {
                throw new IllegalArgumentException("density must not be null");
            }
            return density.getFontScale() * TextUnit.m21161getValueimpl(this.value);
        }

        private SettingTextUnit(String str, long j) {
            this.axisName = str;
            this.value = j;
            this.needsDensity = true;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b\u0005\n\u0002\u0010\b\n\u0000\b\u0007\u0018\u00002\u00020\u0001B\u0019\u0012\u0012\u0010\u0002\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00040\u0003\"\u00020\u0004¢\u0006\u0002\u0010\u0005J\u0013\u0010\r\u001a\u00020\u00072\b\u0010\u000e\u001a\u0004\u0018\u00010\u0001H\u0096\u0002J\b\u0010\u000f\u001a\u00020\u0010H\u0016R\u0014\u0010\u0006\u001a\u00020\u0007X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0017\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\n¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\f¨\u0006\u0011"}, m13886d2 = {"Landroidx/compose/ui/text/font/FontVariation$Settings;", "", SettingsConstants.EXTRA_FROM_NOTES_ASSIST_FOR_LAUNCH_FROM_SETTINGS, "", "Landroidx/compose/ui/text/font/FontVariation$Setting;", "([Landroidx/compose/ui/text/font/FontVariation$Setting;)V", "needsDensity", "", "getNeedsDensity$ui_text_release", "()Z", "", "getSettings", "()Ljava/util/List;", "equals", "other", "hashCode", "", "ui-text_release"}, m13887k = 1, m13888mv = {1, 8, 0}, m13890xi = 48)
    @Immutable
    @SourceDebugExtension({"SMAP\nFontVariation.kt\nKotlin\n*S Kotlin\n*F\n+ 1 FontVariation.kt\nandroidx/compose/ui/text/font/FontVariation$Settings\n+ 2 _Arrays.kt\nkotlin/collections/ArraysKt___ArraysKt\n+ 3 Maps.kt\nkotlin/collections/MapsKt__MapsKt\n+ 4 _Maps.kt\nkotlin/collections/MapsKt___MapsKt\n+ 5 ListUtils.kt\nandroidx/compose/ui/util/ListUtilsKt\n*L\n1#1,373:1\n10783#2:374\n11008#2,3:375\n11011#2,3:385\n361#3,7:378\n76#4:388\n96#4,5:389\n101#5,2:394\n33#5,6:396\n103#5:402\n*S KotlinDebug\n*F\n+ 1 FontVariation.kt\nandroidx/compose/ui/text/font/FontVariation$Settings\n*L\n52#1:374\n52#1:375,3\n52#1:385,3\n52#1:378,7\n53#1:388\n53#1:389,5\n60#1:394,2\n60#1:396,6\n60#1:402\n*E\n"})
    public static final class Settings {
        public static final int $stable = 0;
        private final boolean needsDensity;

        @NotNull
        private final List<Setting> settings;

        public Settings(@NotNull Setting... settingArr) {
            LinkedHashMap linkedHashMap = new LinkedHashMap();
            boolean z = false;
            for (Setting setting : settingArr) {
                String axisName = setting.getAxisName();
                Object arrayList = linkedHashMap.get(axisName);
                if (arrayList == null) {
                    arrayList = new ArrayList();
                    linkedHashMap.put(axisName, arrayList);
                }
                ((List) arrayList).add(setting);
            }
            ArrayList arrayList2 = new ArrayList();
            for (Map.Entry entry : linkedHashMap.entrySet()) {
                String str = (String) entry.getKey();
                List list = (List) entry.getValue();
                if (list.size() != 1) {
                    throw new IllegalArgumentException(AbstractC1038a.m1213n(PropertyUtils.INDEXED_DELIM2, CollectionsKt.m13955n(list, null, null, null, null, 63), AbstractC0000a.m15l("'", str, "' must be unique. Actual [ [")).toString());
                }
                CollectionsKt__MutableCollectionsKt.addAll(arrayList2, list);
            }
            ArrayList arrayList3 = new ArrayList(arrayList2);
            this.settings = arrayList3;
            int size = arrayList3.size();
            int i = 0;
            while (true) {
                if (i >= size) {
                    break;
                }
                if (((Setting) arrayList3.get(i)).getNeedsDensity()) {
                    z = true;
                    break;
                }
                i++;
            }
            this.needsDensity = z;
        }

        public boolean equals(@Nullable Object other) {
            if (this == other) {
                return true;
            }
            return (other instanceof Settings) && Intrinsics.areEqual(this.settings, ((Settings) other).settings);
        }

        /* JADX INFO: renamed from: getNeedsDensity$ui_text_release, reason: from getter */
        public final boolean getNeedsDensity() {
            return this.needsDensity;
        }

        @NotNull
        public final List<Setting> getSettings() {
            return this.settings;
        }

        public int hashCode() {
            return this.settings.hashCode();
        }
    }

    private FontVariation() {
    }

    @NotNull
    public final Setting Setting(@NotNull String name, float value) {
        if (name.length() == 4) {
            return new SettingFloat(name, value);
        }
        throw new IllegalArgumentException(AbstractC1974b.m1315h('\'', "Name must be exactly four characters. Actual: '", name).toString());
    }

    @NotNull
    /* JADX INFO: renamed from: Settings-6EWAqTQ, reason: not valid java name */
    public final Settings m20587Settings6EWAqTQ(@NotNull FontWeight weight, int style, @NotNull Setting... settings) {
        SpreadBuilder spreadBuilder = new SpreadBuilder(3);
        spreadBuilder.add(weight(weight.getWeight()));
        spreadBuilder.add(italic(style));
        spreadBuilder.addSpread(settings);
        return new Settings((Setting[]) spreadBuilder.toArray(new Setting[spreadBuilder.size()]));
    }

    @NotNull
    public final Setting grade(int value) {
        if (-1000 > value || value >= 1001) {
            throw new IllegalArgumentException("'GRAD' must be in -1000..1000");
        }
        return new SettingInt("GRAD", value);
    }

    @NotNull
    public final Setting italic(float value) {
        if (0.0f > value || value > 1.0f) {
            throw new IllegalArgumentException(AbstractC0622a.m1166l("'ital' must be in 0.0f..1.0f. Actual: ", value).toString());
        }
        return new SettingFloat("ital", value);
    }

    @NotNull
    /* JADX INFO: renamed from: opticalSizing--R2X_6o, reason: not valid java name */
    public final Setting m20588opticalSizingR2X_6o(long textSize) {
        if (TextUnit.m21164isSpimpl(textSize)) {
            return new SettingTextUnit("opsz", textSize, null);
        }
        throw new IllegalArgumentException("'opsz' must be provided in sp units");
    }

    @NotNull
    public final Setting slant(float value) {
        if (-90.0f > value || value > 90.0f) {
            throw new IllegalArgumentException(AbstractC0622a.m1166l("'slnt' must be in -90f..90f. Actual: ", value).toString());
        }
        return new SettingFloat("slnt", value);
    }

    @NotNull
    public final Setting weight(int value) {
        if (1 > value || value >= 1001) {
            throw new IllegalArgumentException(AbstractC0000a.m11h(value, "'wght' value must be in [1, 1000]. Actual: ").toString());
        }
        return new SettingInt("wght", value);
    }

    @NotNull
    public final Setting width(float value) {
        if (value > 0.0f) {
            return new SettingFloat("wdth", value);
        }
        throw new IllegalArgumentException(AbstractC0622a.m1166l("'wdth' must be strictly > 0.0f. Actual: ", value).toString());
    }
}
