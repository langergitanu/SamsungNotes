package androidx.glance.appwidget;

import androidx.compose.runtime.internal.StabilityInferred;
import androidx.glance.GlanceModifier;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes4.dex */
@StabilityInferred(parameters = 1)
@Metadata(m13885d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\u0080\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0002\u0010\u0006J\t\u0010\u000b\u001a\u00020\u0003HÆ\u0003J\u000b\u0010\f\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u001f\u0010\r\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005HÆ\u0001J\u0013\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0005HÖ\u0003J\t\u0010\u0011\u001a\u00020\u0003HÖ\u0001J\t\u0010\u0012\u001a\u00020\u0013HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n¨\u0006\u0014"}, m13886d2 = {"Landroidx/glance/appwidget/KeyedTagModifier;", "Landroidx/glance/GlanceModifier$Element;", "key", "", "tag", "", "(ILjava/lang/Object;)V", "getKey", "()I", "getTag", "()Ljava/lang/Object;", "component1", "component2", "copy", "equals", "", "other", "hashCode", "toString", "", "glance-appwidget_release"}, m13887k = 1, m13888mv = {1, 9, 0}, m13890xi = 48)
public final /* data */ class KeyedTagModifier implements GlanceModifier.Element {
    public static final int $stable = 0;
    private final int key;

    @Nullable
    private final Object tag;

    public KeyedTagModifier(int i, @Nullable Object obj) {
        this.key = i;
        this.tag = obj;
    }

    public static /* synthetic */ KeyedTagModifier copy$default(KeyedTagModifier keyedTagModifier, int i, Object obj, int i2, Object obj2) {
        if ((i2 & 1) != 0) {
            i = keyedTagModifier.key;
        }
        if ((i2 & 2) != 0) {
            obj = keyedTagModifier.tag;
        }
        return keyedTagModifier.copy(i, obj);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final int getKey() {
        return this.key;
    }

    @Nullable
    /* JADX INFO: renamed from: component2, reason: from getter */
    public final Object getTag() {
        return this.tag;
    }

    @NotNull
    public final KeyedTagModifier copy(int key, @Nullable Object tag) {
        return new KeyedTagModifier(key, tag);
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof KeyedTagModifier)) {
            return false;
        }
        KeyedTagModifier keyedTagModifier = (KeyedTagModifier) other;
        return this.key == keyedTagModifier.key && Intrinsics.areEqual(this.tag, keyedTagModifier.tag);
    }

    public final int getKey() {
        return this.key;
    }

    @Nullable
    public final Object getTag() {
        return this.tag;
    }

    public int hashCode() {
        int iHashCode = Integer.hashCode(this.key) * 31;
        Object obj = this.tag;
        return iHashCode + (obj == null ? 0 : obj.hashCode());
    }

    @NotNull
    public String toString() {
        return "KeyedTagModifier(key=" + this.key + ", tag=" + this.tag + ")";
    }
}
