package androidx.compose.p109ui.text.android;

import androidx.constraintlayout.core.motion.utils.TypedValues;
import com.samsung.android.support.senl.p148nt.data.database.core.schema.DBSchema;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(m13885d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0007\b\u0002\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J(\u0010\u000b\u001a\u00020\b2\u0006\u0010\f\u001a\u00020\u00062\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0010\u001a\u00020\u000eH\u0002J\u000e\u0010\u0011\u001a\u00020\b2\u0006\u0010\f\u001a\u00020\u0006J\u000e\u0010\u0012\u001a\u00020\b2\u0006\u0010\f\u001a\u00020\u0006J\u000e\u0010\u0013\u001a\u00020\b2\u0006\u0010\f\u001a\u00020\u0006J\u000e\u0010\u0014\u001a\u00020\b2\u0006\u0010\f\u001a\u00020\u0006R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n¨\u0006\u0015"}, m13886d2 = {"Landroidx/compose/ui/text/android/HorizontalPositionCache;", "", DBSchema.DocumentThumbnail.LAYOUT, "Landroidx/compose/ui/text/android/TextLayout;", "(Landroidx/compose/ui/text/android/TextLayout;)V", "cachedKey", "", "cachedValue", "", "getLayout", "()Landroidx/compose/ui/text/android/TextLayout;", "get", TypedValues.Cycle.S_WAVE_OFFSET, "upstream", "", "cache", "primary", "getPrimaryDownstream", "getPrimaryUpstream", "getSecondaryDownstream", "getSecondaryUpstream", "ui-text_release"}, m13887k = 1, m13888mv = {1, 8, 0}, m13890xi = 48)
final class HorizontalPositionCache {
    private int cachedKey = -1;
    private float cachedValue;

    @NotNull
    private final TextLayout layout;

    public HorizontalPositionCache(@NotNull TextLayout textLayout) {
        this.layout = textLayout;
    }

    /* JADX WARN: Removed duplicated region for block: B:8:0x001f  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private final float get(int offset, boolean upstream, boolean cache, boolean primary) {
        boolean z;
        int i = 1;
        if (upstream) {
            int lineForOffset = LayoutCompat_androidKt.getLineForOffset(this.layout.getLayout(), offset, upstream);
            z = offset == this.layout.getLineStart(lineForOffset) || offset == this.layout.getLineEnd(lineForOffset);
        }
        int i2 = offset * 4;
        if (!primary) {
            i = z ? 2 : 3;
        } else if (z) {
            i = 0;
        }
        int i4 = i2 + i;
        if (this.cachedKey == i4) {
            return this.cachedValue;
        }
        float primaryHorizontal = primary ? this.layout.getPrimaryHorizontal(offset, upstream) : this.layout.getSecondaryHorizontal(offset, upstream);
        if (cache) {
            this.cachedKey = i4;
            this.cachedValue = primaryHorizontal;
        }
        return primaryHorizontal;
    }

    @NotNull
    public final TextLayout getLayout() {
        return this.layout;
    }

    public final float getPrimaryDownstream(int offset) {
        return get(offset, false, false, true);
    }

    public final float getPrimaryUpstream(int offset) {
        return get(offset, true, true, true);
    }

    public final float getSecondaryDownstream(int offset) {
        return get(offset, false, false, false);
    }

    public final float getSecondaryUpstream(int offset) {
        return get(offset, true, true, false);
    }
}
