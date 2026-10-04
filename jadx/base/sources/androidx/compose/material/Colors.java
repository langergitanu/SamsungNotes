package androidx.compose.material;

import androidx.compose.p109ui.graphics.Color;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.SnapshotStateKt;
import androidx.compose.runtime.Stable;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import org.apache.commons.beanutils.PropertyUtils;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes.dex */
@Stable
@Metadata(m13885d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0010\u000b\n\u0002\b1\n\u0002\u0010\u000e\n\u0000\b\u0007\u0018\u00002\u00020\u0001Bp\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0003\u0012\u0006\u0010\u0007\u001a\u00020\u0003\u0012\u0006\u0010\b\u001a\u00020\u0003\u0012\u0006\u0010\t\u001a\u00020\u0003\u0012\u0006\u0010\n\u001a\u00020\u0003\u0012\u0006\u0010\u000b\u001a\u00020\u0003\u0012\u0006\u0010\f\u001a\u00020\u0003\u0012\u0006\u0010\r\u001a\u00020\u0003\u0012\u0006\u0010\u000e\u001a\u00020\u0003\u0012\u0006\u0010\u000f\u001a\u00020\u0010ø\u0001\u0000¢\u0006\u0002\u0010\u0011J\u0095\u0001\u0010>\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u00032\b\b\u0002\u0010\u0007\u001a\u00020\u00032\b\b\u0002\u0010\b\u001a\u00020\u00032\b\b\u0002\u0010\t\u001a\u00020\u00032\b\b\u0002\u0010\n\u001a\u00020\u00032\b\b\u0002\u0010\u000b\u001a\u00020\u00032\b\b\u0002\u0010\f\u001a\u00020\u00032\b\b\u0002\u0010\r\u001a\u00020\u00032\b\b\u0002\u0010\u000e\u001a\u00020\u00032\b\b\u0002\u0010\u000f\u001a\u00020\u0010ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b?\u0010@J\b\u0010A\u001a\u00020BH\u0016R4\u0010\u0007\u001a\u00020\u00032\u0006\u0010\u0012\u001a\u00020\u00038F@@X\u0086\u008e\u0002ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\u0012\n\u0004\b\u0017\u0010\u0018\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016R4\u0010\t\u001a\u00020\u00032\u0006\u0010\u0012\u001a\u00020\u00038F@@X\u0086\u008e\u0002ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\u0012\n\u0004\b\u001b\u0010\u0018\u001a\u0004\b\u0019\u0010\u0014\"\u0004\b\u001a\u0010\u0016R+\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0012\u001a\u00020\u00108F@@X\u0086\u008e\u0002¢\u0006\u0012\n\u0004\b\u001f\u0010\u0018\u001a\u0004\b\u000f\u0010\u001c\"\u0004\b\u001d\u0010\u001eR4\u0010\f\u001a\u00020\u00032\u0006\u0010\u0012\u001a\u00020\u00038F@@X\u0086\u008e\u0002ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\u0012\n\u0004\b\"\u0010\u0018\u001a\u0004\b \u0010\u0014\"\u0004\b!\u0010\u0016R4\u0010\u000e\u001a\u00020\u00032\u0006\u0010\u0012\u001a\u00020\u00038F@@X\u0086\u008e\u0002ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\u0012\n\u0004\b%\u0010\u0018\u001a\u0004\b#\u0010\u0014\"\u0004\b$\u0010\u0016R4\u0010\n\u001a\u00020\u00032\u0006\u0010\u0012\u001a\u00020\u00038F@@X\u0086\u008e\u0002ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\u0012\n\u0004\b(\u0010\u0018\u001a\u0004\b&\u0010\u0014\"\u0004\b'\u0010\u0016R4\u0010\u000b\u001a\u00020\u00032\u0006\u0010\u0012\u001a\u00020\u00038F@@X\u0086\u008e\u0002ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\u0012\n\u0004\b+\u0010\u0018\u001a\u0004\b)\u0010\u0014\"\u0004\b*\u0010\u0016R4\u0010\r\u001a\u00020\u00032\u0006\u0010\u0012\u001a\u00020\u00038F@@X\u0086\u008e\u0002ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\u0012\n\u0004\b.\u0010\u0018\u001a\u0004\b,\u0010\u0014\"\u0004\b-\u0010\u0016R4\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0012\u001a\u00020\u00038F@@X\u0086\u008e\u0002ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\u0012\n\u0004\b1\u0010\u0018\u001a\u0004\b/\u0010\u0014\"\u0004\b0\u0010\u0016R4\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0012\u001a\u00020\u00038F@@X\u0086\u008e\u0002ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\u0012\n\u0004\b4\u0010\u0018\u001a\u0004\b2\u0010\u0014\"\u0004\b3\u0010\u0016R4\u0010\u0005\u001a\u00020\u00032\u0006\u0010\u0012\u001a\u00020\u00038F@@X\u0086\u008e\u0002ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\u0012\n\u0004\b7\u0010\u0018\u001a\u0004\b5\u0010\u0014\"\u0004\b6\u0010\u0016R4\u0010\u0006\u001a\u00020\u00032\u0006\u0010\u0012\u001a\u00020\u00038F@@X\u0086\u008e\u0002ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\u0012\n\u0004\b:\u0010\u0018\u001a\u0004\b8\u0010\u0014\"\u0004\b9\u0010\u0016R4\u0010\b\u001a\u00020\u00032\u0006\u0010\u0012\u001a\u00020\u00038F@@X\u0086\u008e\u0002ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\u0012\n\u0004\b=\u0010\u0018\u001a\u0004\b;\u0010\u0014\"\u0004\b<\u0010\u0016\u0082\u0002\u000f\n\u0002\b\u0019\n\u0005\b¡\u001e0\u0001\n\u0002\b!¨\u0006C"}, m13886d2 = {"Landroidx/compose/material/Colors;", "", "primary", "Landroidx/compose/ui/graphics/Color;", "primaryVariant", "secondary", "secondaryVariant", "background", "surface", "error", "onPrimary", "onSecondary", "onBackground", "onSurface", "onError", "isLight", "", "(JJJJJJJJJJJJZLkotlin/jvm/internal/DefaultConstructorMarker;)V", "<set-?>", "getBackground-0d7_KjU", "()J", "setBackground-8_81llA$material_release", "(J)V", "background$delegate", "Landroidx/compose/runtime/MutableState;", "getError-0d7_KjU", "setError-8_81llA$material_release", "error$delegate", "()Z", "setLight$material_release", "(Z)V", "isLight$delegate", "getOnBackground-0d7_KjU", "setOnBackground-8_81llA$material_release", "onBackground$delegate", "getOnError-0d7_KjU", "setOnError-8_81llA$material_release", "onError$delegate", "getOnPrimary-0d7_KjU", "setOnPrimary-8_81llA$material_release", "onPrimary$delegate", "getOnSecondary-0d7_KjU", "setOnSecondary-8_81llA$material_release", "onSecondary$delegate", "getOnSurface-0d7_KjU", "setOnSurface-8_81llA$material_release", "onSurface$delegate", "getPrimary-0d7_KjU", "setPrimary-8_81llA$material_release", "primary$delegate", "getPrimaryVariant-0d7_KjU", "setPrimaryVariant-8_81llA$material_release", "primaryVariant$delegate", "getSecondary-0d7_KjU", "setSecondary-8_81llA$material_release", "secondary$delegate", "getSecondaryVariant-0d7_KjU", "setSecondaryVariant-8_81llA$material_release", "secondaryVariant$delegate", "getSurface-0d7_KjU", "setSurface-8_81llA$material_release", "surface$delegate", "copy", "copy-pvPzIIM", "(JJJJJJJJJJJJZ)Landroidx/compose/material/Colors;", "toString", "", "material_release"}, m13887k = 1, m13888mv = {1, 7, 1}, m13890xi = 48)
public final class Colors {

    /* JADX INFO: renamed from: background$delegate, reason: from kotlin metadata */
    @NotNull
    private final MutableState background;

    /* JADX INFO: renamed from: error$delegate, reason: from kotlin metadata */
    @NotNull
    private final MutableState error;

    /* JADX INFO: renamed from: isLight$delegate, reason: from kotlin metadata */
    @NotNull
    private final MutableState isLight;

    /* JADX INFO: renamed from: onBackground$delegate, reason: from kotlin metadata */
    @NotNull
    private final MutableState onBackground;

    /* JADX INFO: renamed from: onError$delegate, reason: from kotlin metadata */
    @NotNull
    private final MutableState onError;

    /* JADX INFO: renamed from: onPrimary$delegate, reason: from kotlin metadata */
    @NotNull
    private final MutableState onPrimary;

    /* JADX INFO: renamed from: onSecondary$delegate, reason: from kotlin metadata */
    @NotNull
    private final MutableState onSecondary;

    /* JADX INFO: renamed from: onSurface$delegate, reason: from kotlin metadata */
    @NotNull
    private final MutableState onSurface;

    /* JADX INFO: renamed from: primary$delegate, reason: from kotlin metadata */
    @NotNull
    private final MutableState primary;

    /* JADX INFO: renamed from: primaryVariant$delegate, reason: from kotlin metadata */
    @NotNull
    private final MutableState primaryVariant;

    /* JADX INFO: renamed from: secondary$delegate, reason: from kotlin metadata */
    @NotNull
    private final MutableState secondary;

    /* JADX INFO: renamed from: secondaryVariant$delegate, reason: from kotlin metadata */
    @NotNull
    private final MutableState secondaryVariant;

    /* JADX INFO: renamed from: surface$delegate, reason: from kotlin metadata */
    @NotNull
    private final MutableState surface;

    public /* synthetic */ Colors(long j, long j2, long j3, long j5, long j6, long j7, long j8, long j9, long j10, long j11, long j12, long j13, boolean z, DefaultConstructorMarker defaultConstructorMarker) {
        this(j, j2, j3, j5, j6, j7, j8, j9, j10, j11, j12, j13, z);
    }

    @NotNull
    /* JADX INFO: renamed from: copy-pvPzIIM, reason: not valid java name */
    public final Colors m16668copypvPzIIM(long primary, long primaryVariant, long secondary, long secondaryVariant, long background, long surface, long error, long onPrimary, long onSecondary, long onBackground, long onSurface, long onError, boolean isLight) {
        return new Colors(primary, primaryVariant, secondary, secondaryVariant, background, surface, error, onPrimary, onSecondary, onBackground, onSurface, onError, isLight, null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX INFO: renamed from: getBackground-0d7_KjU, reason: not valid java name */
    public final long m16669getBackground0d7_KjU() {
        return ((Color) this.background.getValue()).m18535unboximpl();
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX INFO: renamed from: getError-0d7_KjU, reason: not valid java name */
    public final long m16670getError0d7_KjU() {
        return ((Color) this.error.getValue()).m18535unboximpl();
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX INFO: renamed from: getOnBackground-0d7_KjU, reason: not valid java name */
    public final long m16671getOnBackground0d7_KjU() {
        return ((Color) this.onBackground.getValue()).m18535unboximpl();
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX INFO: renamed from: getOnError-0d7_KjU, reason: not valid java name */
    public final long m16672getOnError0d7_KjU() {
        return ((Color) this.onError.getValue()).m18535unboximpl();
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX INFO: renamed from: getOnPrimary-0d7_KjU, reason: not valid java name */
    public final long m16673getOnPrimary0d7_KjU() {
        return ((Color) this.onPrimary.getValue()).m18535unboximpl();
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX INFO: renamed from: getOnSecondary-0d7_KjU, reason: not valid java name */
    public final long m16674getOnSecondary0d7_KjU() {
        return ((Color) this.onSecondary.getValue()).m18535unboximpl();
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX INFO: renamed from: getOnSurface-0d7_KjU, reason: not valid java name */
    public final long m16675getOnSurface0d7_KjU() {
        return ((Color) this.onSurface.getValue()).m18535unboximpl();
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX INFO: renamed from: getPrimary-0d7_KjU, reason: not valid java name */
    public final long m16676getPrimary0d7_KjU() {
        return ((Color) this.primary.getValue()).m18535unboximpl();
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX INFO: renamed from: getPrimaryVariant-0d7_KjU, reason: not valid java name */
    public final long m16677getPrimaryVariant0d7_KjU() {
        return ((Color) this.primaryVariant.getValue()).m18535unboximpl();
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX INFO: renamed from: getSecondary-0d7_KjU, reason: not valid java name */
    public final long m16678getSecondary0d7_KjU() {
        return ((Color) this.secondary.getValue()).m18535unboximpl();
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX INFO: renamed from: getSecondaryVariant-0d7_KjU, reason: not valid java name */
    public final long m16679getSecondaryVariant0d7_KjU() {
        return ((Color) this.secondaryVariant.getValue()).m18535unboximpl();
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX INFO: renamed from: getSurface-0d7_KjU, reason: not valid java name */
    public final long m16680getSurface0d7_KjU() {
        return ((Color) this.surface.getValue()).m18535unboximpl();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final boolean isLight() {
        return ((Boolean) this.isLight.getValue()).booleanValue();
    }

    /* JADX INFO: renamed from: setBackground-8_81llA$material_release, reason: not valid java name */
    public final void m16681setBackground8_81llA$material_release(long j) {
        this.background.setValue(Color.m18515boximpl(j));
    }

    /* JADX INFO: renamed from: setError-8_81llA$material_release, reason: not valid java name */
    public final void m16682setError8_81llA$material_release(long j) {
        this.error.setValue(Color.m18515boximpl(j));
    }

    public final void setLight$material_release(boolean z) {
        this.isLight.setValue(Boolean.valueOf(z));
    }

    /* JADX INFO: renamed from: setOnBackground-8_81llA$material_release, reason: not valid java name */
    public final void m16683setOnBackground8_81llA$material_release(long j) {
        this.onBackground.setValue(Color.m18515boximpl(j));
    }

    /* JADX INFO: renamed from: setOnError-8_81llA$material_release, reason: not valid java name */
    public final void m16684setOnError8_81llA$material_release(long j) {
        this.onError.setValue(Color.m18515boximpl(j));
    }

    /* JADX INFO: renamed from: setOnPrimary-8_81llA$material_release, reason: not valid java name */
    public final void m16685setOnPrimary8_81llA$material_release(long j) {
        this.onPrimary.setValue(Color.m18515boximpl(j));
    }

    /* JADX INFO: renamed from: setOnSecondary-8_81llA$material_release, reason: not valid java name */
    public final void m16686setOnSecondary8_81llA$material_release(long j) {
        this.onSecondary.setValue(Color.m18515boximpl(j));
    }

    /* JADX INFO: renamed from: setOnSurface-8_81llA$material_release, reason: not valid java name */
    public final void m16687setOnSurface8_81llA$material_release(long j) {
        this.onSurface.setValue(Color.m18515boximpl(j));
    }

    /* JADX INFO: renamed from: setPrimary-8_81llA$material_release, reason: not valid java name */
    public final void m16688setPrimary8_81llA$material_release(long j) {
        this.primary.setValue(Color.m18515boximpl(j));
    }

    /* JADX INFO: renamed from: setPrimaryVariant-8_81llA$material_release, reason: not valid java name */
    public final void m16689setPrimaryVariant8_81llA$material_release(long j) {
        this.primaryVariant.setValue(Color.m18515boximpl(j));
    }

    /* JADX INFO: renamed from: setSecondary-8_81llA$material_release, reason: not valid java name */
    public final void m16690setSecondary8_81llA$material_release(long j) {
        this.secondary.setValue(Color.m18515boximpl(j));
    }

    /* JADX INFO: renamed from: setSecondaryVariant-8_81llA$material_release, reason: not valid java name */
    public final void m16691setSecondaryVariant8_81llA$material_release(long j) {
        this.secondaryVariant.setValue(Color.m18515boximpl(j));
    }

    /* JADX INFO: renamed from: setSurface-8_81llA$material_release, reason: not valid java name */
    public final void m16692setSurface8_81llA$material_release(long j) {
        this.surface.setValue(Color.m18515boximpl(j));
    }

    @NotNull
    public String toString() {
        return "Colors(primary=" + ((Object) Color.m18533toStringimpl(m16676getPrimary0d7_KjU())) + ", primaryVariant=" + ((Object) Color.m18533toStringimpl(m16677getPrimaryVariant0d7_KjU())) + ", secondary=" + ((Object) Color.m18533toStringimpl(m16678getSecondary0d7_KjU())) + ", secondaryVariant=" + ((Object) Color.m18533toStringimpl(m16679getSecondaryVariant0d7_KjU())) + ", background=" + ((Object) Color.m18533toStringimpl(m16669getBackground0d7_KjU())) + ", surface=" + ((Object) Color.m18533toStringimpl(m16680getSurface0d7_KjU())) + ", error=" + ((Object) Color.m18533toStringimpl(m16670getError0d7_KjU())) + ", onPrimary=" + ((Object) Color.m18533toStringimpl(m16673getOnPrimary0d7_KjU())) + ", onSecondary=" + ((Object) Color.m18533toStringimpl(m16674getOnSecondary0d7_KjU())) + ", onBackground=" + ((Object) Color.m18533toStringimpl(m16671getOnBackground0d7_KjU())) + ", onSurface=" + ((Object) Color.m18533toStringimpl(m16675getOnSurface0d7_KjU())) + ", onError=" + ((Object) Color.m18533toStringimpl(m16672getOnError0d7_KjU())) + ", isLight=" + isLight() + PropertyUtils.MAPPED_DELIM2;
    }

    private Colors(long j, long j2, long j3, long j5, long j6, long j7, long j8, long j9, long j10, long j11, long j12, long j13, boolean z) {
        this.primary = SnapshotStateKt.mutableStateOf(Color.m18515boximpl(j), SnapshotStateKt.structuralEqualityPolicy());
        this.primaryVariant = SnapshotStateKt.mutableStateOf(Color.m18515boximpl(j2), SnapshotStateKt.structuralEqualityPolicy());
        this.secondary = SnapshotStateKt.mutableStateOf(Color.m18515boximpl(j3), SnapshotStateKt.structuralEqualityPolicy());
        this.secondaryVariant = SnapshotStateKt.mutableStateOf(Color.m18515boximpl(j5), SnapshotStateKt.structuralEqualityPolicy());
        this.background = SnapshotStateKt.mutableStateOf(Color.m18515boximpl(j6), SnapshotStateKt.structuralEqualityPolicy());
        this.surface = SnapshotStateKt.mutableStateOf(Color.m18515boximpl(j7), SnapshotStateKt.structuralEqualityPolicy());
        this.error = SnapshotStateKt.mutableStateOf(Color.m18515boximpl(j8), SnapshotStateKt.structuralEqualityPolicy());
        this.onPrimary = SnapshotStateKt.mutableStateOf(Color.m18515boximpl(j9), SnapshotStateKt.structuralEqualityPolicy());
        this.onSecondary = SnapshotStateKt.mutableStateOf(Color.m18515boximpl(j10), SnapshotStateKt.structuralEqualityPolicy());
        this.onBackground = SnapshotStateKt.mutableStateOf(Color.m18515boximpl(j11), SnapshotStateKt.structuralEqualityPolicy());
        this.onSurface = SnapshotStateKt.mutableStateOf(Color.m18515boximpl(j12), SnapshotStateKt.structuralEqualityPolicy());
        this.onError = SnapshotStateKt.mutableStateOf(Color.m18515boximpl(j13), SnapshotStateKt.structuralEqualityPolicy());
        this.isLight = SnapshotStateKt.mutableStateOf(Boolean.valueOf(z), SnapshotStateKt.structuralEqualityPolicy());
    }
}
