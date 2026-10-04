package com.samsung.android.vexfwk.param;

import com.samsung.android.support.senl.p148nt.app.common.FolderConstants;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes8.dex */
@Metadata(m13885d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u001e\u0018\u00002\u00020\u0001:\u0001(B\u0007\b\u0016¢\u0006\u0002\u0010\u0002BO\b\u0016\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\u0006\u0010\u0006\u001a\u00020\u0004\u0012\u0006\u0010\u0007\u001a\u00020\u0004\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\u000b\u0012\u0006\u0010\f\u001a\u00020\u0004\u0012\u0006\u0010\r\u001a\u00020\u0004\u0012\u0006\u0010\u000e\u001a\u00020\u0004¢\u0006\u0002\u0010\u000fR\u001a\u0010\u0007\u001a\u00020\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013R\u001a\u0010\f\u001a\u00020\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u0011\"\u0004\b\u0015\u0010\u0013R\u001a\u0010\u0003\u001a\u00020\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\u0011\"\u0004\b\u0017\u0010\u0013R\u001a\u0010\u0006\u001a\u00020\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0018\u0010\u0011\"\u0004\b\u0019\u0010\u0013R\u001a\u0010\b\u001a\u00020\tX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001a\u0010\u001b\"\u0004\b\u001c\u0010\u001dR\u001a\u0010\n\u001a\u00020\u000bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001e\u0010\u001f\"\u0004\b \u0010!R\u001a\u0010\u0005\u001a\u00020\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\"\u0010\u0011\"\u0004\b#\u0010\u0013R\u001a\u0010\u000e\u001a\u00020\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b$\u0010\u0011\"\u0004\b%\u0010\u0013R\u001a\u0010\r\u001a\u00020\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b&\u0010\u0011\"\u0004\b'\u0010\u0013¨\u0006)"}, m13886d2 = {"Lcom/samsung/android/vexfwk/param/VexFwkWineBoxInfo;", "", "()V", "left", "", "top", "right", "bottom", "score", "", "tag", "Lcom/samsung/android/vexfwk/param/VexFwkWineBoxInfo$Tag;", "height", "width", "trackId", "(IIIIFLcom/samsung/android/vexfwk/param/VexFwkWineBoxInfo$Tag;III)V", "getBottom", "()I", "setBottom", "(I)V", "getHeight", "setHeight", "getLeft", "setLeft", "getRight", "setRight", "getScore", "()F", "setScore", "(F)V", "getTag", "()Lcom/samsung/android/vexfwk/param/VexFwkWineBoxInfo$Tag;", "setTag", "(Lcom/samsung/android/vexfwk/param/VexFwkWineBoxInfo$Tag;)V", "getTop", "setTop", "getTrackId", "setTrackId", "getWidth", "setWidth", FolderConstants.Tag.DISPLAY_NAME, "vexfwk_sdk_release"}, m13887k = 1, m13888mv = {1, 9, 0}, m13890xi = 48)
public final class VexFwkWineBoxInfo {
    private int bottom;
    private int height;
    private int left;
    private int right;
    private float score;

    @NotNull
    private Tag tag;
    private int top;
    private int trackId;
    private int width;

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* JADX WARN: Unknown enum class pattern. Please report as an issue! */
    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\t\b\u0086\u0081\u0002\u0018\u0000 \u000b2\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\u000bB\u000f\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0006\u0010\u0007\u001a\u00020\u0003R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\bj\u0002\b\tj\u0002\b\n¨\u0006\f"}, m13886d2 = {"Lcom/samsung/android/vexfwk/param/VexFwkWineBoxInfo$Tag;", "", "mValue", "", "(Ljava/lang/String;II)V", "getMValue", "()I", "getValue", "WINE", "WINE_LABEL", "INVALID", "Companion", "vexfwk_sdk_release"}, m13887k = 1, m13888mv = {1, 9, 0}, m13890xi = 48)
    public static final class Tag {
        private static final /* synthetic */ EnumEntries $ENTRIES;
        private static final /* synthetic */ Tag[] $VALUES;

        /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
        @NotNull
        public static final Companion INSTANCE;
        private final int mValue;
        public static final Tag WINE = new Tag("WINE", 0, 0);
        public static final Tag WINE_LABEL = new Tag("WINE_LABEL", 1, 1);
        public static final Tag INVALID = new Tag("INVALID", 2, -1);

        /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
        @Metadata(m13885d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\u0010\u000e\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0007J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0007H\u0007¨\u0006\b"}, m13886d2 = {"Lcom/samsung/android/vexfwk/param/VexFwkWineBoxInfo$Tag$Companion;", "", "()V", "toTag", "Lcom/samsung/android/vexfwk/param/VexFwkWineBoxInfo$Tag;", "x", "", "", "vexfwk_sdk_release"}, m13887k = 1, m13888mv = {1, 9, 0}, m13890xi = 48)
        public static final class Companion {
            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            @JvmStatic
            @NotNull
            public final Tag toTag(@NotNull String x) {
                Intrinsics.checkNotNullParameter(x, "x");
                return Intrinsics.areEqual(x, "Wine") ? Tag.WINE : Intrinsics.areEqual(x, "wine_label") ? Tag.WINE_LABEL : Tag.INVALID;
            }

            private Companion() {
            }

            @JvmStatic
            @NotNull
            public final Tag toTag(int x) {
                if (x == 0) {
                    return Tag.WINE;
                }
                if (x != 1) {
                    return Tag.INVALID;
                }
                return Tag.WINE_LABEL;
            }
        }

        private static final /* synthetic */ Tag[] $values() {
            return new Tag[]{WINE, WINE_LABEL, INVALID};
        }

        static {
            Tag[] tagArr$values = $values();
            $VALUES = tagArr$values;
            $ENTRIES = EnumEntriesKt.enumEntries(tagArr$values);
            INSTANCE = new Companion(null);
        }

        private Tag(String str, int i, int i2) {
            this.mValue = i2;
        }

        @NotNull
        public static EnumEntries<Tag> getEntries() {
            return $ENTRIES;
        }

        @JvmStatic
        @NotNull
        public static final Tag toTag(int i) {
            return INSTANCE.toTag(i);
        }

        public static Tag valueOf(String str) {
            return (Tag) Enum.valueOf(Tag.class, str);
        }

        public static Tag[] values() {
            return (Tag[]) $VALUES.clone();
        }

        public final int getMValue() {
            return this.mValue;
        }

        public final int getValue() {
            return this.mValue;
        }

        @JvmStatic
        @NotNull
        public static final Tag toTag(@NotNull String str) {
            return INSTANCE.toTag(str);
        }
    }

    public VexFwkWineBoxInfo() {
        this.tag = Tag.INVALID;
    }

    public final int getBottom() {
        return this.bottom;
    }

    public final int getHeight() {
        return this.height;
    }

    public final int getLeft() {
        return this.left;
    }

    public final int getRight() {
        return this.right;
    }

    public final float getScore() {
        return this.score;
    }

    @NotNull
    public final Tag getTag() {
        return this.tag;
    }

    public final int getTop() {
        return this.top;
    }

    public final int getTrackId() {
        return this.trackId;
    }

    public final int getWidth() {
        return this.width;
    }

    public final void setBottom(int i) {
        this.bottom = i;
    }

    public final void setHeight(int i) {
        this.height = i;
    }

    public final void setLeft(int i) {
        this.left = i;
    }

    public final void setRight(int i) {
        this.right = i;
    }

    public final void setScore(float f) {
        this.score = f;
    }

    public final void setTag(@NotNull Tag tag) {
        Intrinsics.checkNotNullParameter(tag, "<set-?>");
        this.tag = tag;
    }

    public final void setTop(int i) {
        this.top = i;
    }

    public final void setTrackId(int i) {
        this.trackId = i;
    }

    public final void setWidth(int i) {
        this.width = i;
    }

    public VexFwkWineBoxInfo(int i, int i2, int i4, int i5, float f, @NotNull Tag tag, int i6, int i7, int i8) {
        Intrinsics.checkNotNullParameter(tag, "tag");
        Tag.Companion companion = Tag.INSTANCE;
        this.left = i;
        this.top = i2;
        this.right = i4;
        this.bottom = i5;
        this.score = f;
        this.tag = tag;
        this.height = i6;
        this.width = i7;
        this.trackId = i8;
    }
}
