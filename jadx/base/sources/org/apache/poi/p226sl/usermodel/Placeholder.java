package org.apache.poi.p226sl.usermodel;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes10.dex */
public enum Placeholder {
    NONE(0, 0, 0, 0, 0),
    TITLE(13, 1, 1, 1, 1),
    BODY(14, 2, 12, 6, 2),
    CENTERED_TITLE(15, 3, 3, 3, 3),
    SUBTITLE(16, 4, 4, 4, 4),
    DATETIME(7, 7, 7, 7, 5),
    SLIDE_NUMBER(8, 8, 8, 8, 6),
    FOOTER(9, 9, 9, 9, 7),
    HEADER(10, 10, 10, 10, 8),
    CONTENT(19, 19, 19, 19, 9),
    CHART(20, 20, 20, 20, 10),
    TABLE(21, 21, 21, 21, 11),
    CLIP_ART(22, 22, 22, 22, 12),
    DGM(23, 23, 23, 23, 13),
    MEDIA(24, 24, 24, 24, 14),
    SLIDE_IMAGE(11, 11, 11, 5, 15),
    PICTURE(26, 26, 26, 26, 16),
    VERTICAL_OBJECT(25, 25, 25, 25, -2),
    VERTICAL_TEXT_TITLE(17, 17, 17, 17, -2),
    VERTICAL_TEXT_BODY(18, 18, 18, 18, -2);

    public final int nativeNotesId;
    public final int nativeNotesMasterId;
    public final int nativeSlideId;
    public final int nativeSlideMasterId;
    public final int ooxmlId;

    Placeholder(int i, int i2, int i4, int i5, int i6) {
        this.nativeSlideId = i;
        this.nativeSlideMasterId = i2;
        this.nativeNotesId = i4;
        this.nativeNotesMasterId = i5;
        this.ooxmlId = i6;
    }

    private static Placeholder lookupNative(int i, int i2) {
        for (Placeholder placeholder : values()) {
            if ((i2 == 0 && placeholder.nativeSlideId == i) || ((i2 == 1 && placeholder.nativeSlideMasterId == i) || ((i2 == 2 && placeholder.nativeNotesId == i) || (i2 == 3 && placeholder.nativeNotesMasterId == i)))) {
                return placeholder;
            }
        }
        return null;
    }

    public static Placeholder lookupNativeNotes(int i) {
        return lookupNative(i, 2);
    }

    public static Placeholder lookupNativeNotesMaster(int i) {
        return lookupNative(i, 3);
    }

    public static Placeholder lookupNativeSlide(int i) {
        return lookupNative(i, 0);
    }

    public static Placeholder lookupNativeSlideMaster(int i) {
        return lookupNative(i, 1);
    }

    public static Placeholder lookupOoxml(int i) {
        for (Placeholder placeholder : values()) {
            if (placeholder.ooxmlId == i) {
                return placeholder;
            }
        }
        return null;
    }
}
