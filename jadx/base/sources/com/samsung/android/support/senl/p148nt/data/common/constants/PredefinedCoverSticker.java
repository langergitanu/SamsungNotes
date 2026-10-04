package com.samsung.android.support.senl.p148nt.data.common.constants;

import com.samsung.android.support.senl.p148nt.data.common.constants.CoverStickerConstants;

/* JADX WARN: Enum visitor error
jadx.core.utils.exceptions.JadxRuntimeException: Can't remove SSA var: r0v0 com.samsung.android.support.senl.nt.data.common.constants.PredefinedCoverSticker, still in use, count: 1, list:
  (r0v0 com.samsung.android.support.senl.nt.data.common.constants.PredefinedCoverSticker) from 0x00b0: FILLED_NEW_ARRAY 
  (r0v0 com.samsung.android.support.senl.nt.data.common.constants.PredefinedCoverSticker)
  (r1v1 com.samsung.android.support.senl.nt.data.common.constants.PredefinedCoverSticker)
  (r2v2 com.samsung.android.support.senl.nt.data.common.constants.PredefinedCoverSticker)
  (r3v3 com.samsung.android.support.senl.nt.data.common.constants.PredefinedCoverSticker)
  (r4v3 com.samsung.android.support.senl.nt.data.common.constants.PredefinedCoverSticker)
  (r5v4 com.samsung.android.support.senl.nt.data.common.constants.PredefinedCoverSticker)
  (r6v4 com.samsung.android.support.senl.nt.data.common.constants.PredefinedCoverSticker)
  (r7v4 com.samsung.android.support.senl.nt.data.common.constants.PredefinedCoverSticker)
  (r8v4 com.samsung.android.support.senl.nt.data.common.constants.PredefinedCoverSticker)
  (r9v4 com.samsung.android.support.senl.nt.data.common.constants.PredefinedCoverSticker)
  (r10v4 com.samsung.android.support.senl.nt.data.common.constants.PredefinedCoverSticker)
  (r11v4 com.samsung.android.support.senl.nt.data.common.constants.PredefinedCoverSticker)
 A[WRAPPED] (LINE:177) elemType: com.samsung.android.support.senl.nt.data.common.constants.PredefinedCoverSticker
	at jadx.core.utils.InsnRemover.removeSsaVar(InsnRemover.java:162)
	at jadx.core.utils.InsnRemover.unbindResult(InsnRemover.java:127)
	at jadx.core.utils.InsnRemover.lambda$unbindInsns$1(InsnRemover.java:99)
	at java.base/java.util.ArrayList.forEach(ArrayList.java:1596)
	at jadx.core.utils.InsnRemover.unbindInsns(InsnRemover.java:98)
	at jadx.core.utils.InsnRemover.removeAllAndUnbind(InsnRemover.java:252)
	at jadx.core.dex.visitors.EnumVisitor.convertToEnum(EnumVisitor.java:180)
	at jadx.core.dex.visitors.EnumVisitor.visit(EnumVisitor.java:100)
 */
/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes3.dex */
public final class PredefinedCoverSticker {
    NONE(CoverStickerConstants.Category.NONE.UUID, CoverStickerConstants.Category.NONE.NAME),
    TODO(CoverStickerConstants.Category.TODO.UUID, CoverStickerConstants.Category.TODO.NAME),
    WORK(CoverStickerConstants.Category.WORK.UUID, "Meeting"),
    STUDY(CoverStickerConstants.Category.STUDY.UUID, CoverStickerConstants.Category.STUDY.NAME),
    INFORMATION(CoverStickerConstants.Category.INFORMATION.UUID, CoverStickerConstants.Category.INFORMATION.NAME),
    SHOPPING(CoverStickerConstants.Category.SHOPPING.UUID, CoverStickerConstants.Category.SHOPPING.NAME),
    PLANNER(CoverStickerConstants.Category.PLANNER.UUID, "Schedule"),
    TRAVEL(CoverStickerConstants.Category.TRAVEL.UUID, CoverStickerConstants.Category.TRAVEL.NAME),
    DIARY(CoverStickerConstants.Category.DIARY.UUID, CoverStickerConstants.Category.DIARY.NAME),
    WORKOUT(CoverStickerConstants.Category.WORKOUT.UUID, CoverStickerConstants.Category.WORKOUT.NAME),
    CASHBOOK(CoverStickerConstants.Category.CASHBOOK.UUID, CoverStickerConstants.Category.CASHBOOK.NAME),
    RECIPE(CoverStickerConstants.Category.RECIPE.UUID, CoverStickerConstants.Category.RECIPE.NAME);

    public static final PredefinedCoverSticker[] DEFAULT_STICKERS = {new PredefinedCoverSticker(CoverStickerConstants.Category.NONE.UUID, CoverStickerConstants.Category.NONE.NAME), new PredefinedCoverSticker(CoverStickerConstants.Category.TODO.UUID, CoverStickerConstants.Category.TODO.NAME), new PredefinedCoverSticker(CoverStickerConstants.Category.WORK.UUID, "Meeting"), new PredefinedCoverSticker(CoverStickerConstants.Category.STUDY.UUID, CoverStickerConstants.Category.STUDY.NAME), new PredefinedCoverSticker(CoverStickerConstants.Category.INFORMATION.UUID, CoverStickerConstants.Category.INFORMATION.NAME), new PredefinedCoverSticker(CoverStickerConstants.Category.SHOPPING.UUID, CoverStickerConstants.Category.SHOPPING.NAME), new PredefinedCoverSticker(CoverStickerConstants.Category.PLANNER.UUID, "Schedule"), new PredefinedCoverSticker(CoverStickerConstants.Category.TRAVEL.UUID, CoverStickerConstants.Category.TRAVEL.NAME), new PredefinedCoverSticker(CoverStickerConstants.Category.DIARY.UUID, CoverStickerConstants.Category.DIARY.NAME), new PredefinedCoverSticker(CoverStickerConstants.Category.WORKOUT.UUID, CoverStickerConstants.Category.WORKOUT.NAME), new PredefinedCoverSticker(CoverStickerConstants.Category.CASHBOOK.UUID, CoverStickerConstants.Category.CASHBOOK.NAME), new PredefinedCoverSticker(CoverStickerConstants.Category.RECIPE.UUID, CoverStickerConstants.Category.RECIPE.NAME)};
    private final String mName;
    private final String mUuid;

    static {
    }

    private PredefinedCoverSticker(String str, String str2) {
        this.mUuid = str;
        this.mName = str2;
    }

    public static PredefinedCoverSticker valueOf(String str) {
        return (PredefinedCoverSticker) Enum.valueOf(PredefinedCoverSticker.class, str);
    }

    public static PredefinedCoverSticker[] values() {
        return (PredefinedCoverSticker[]) $VALUES.clone();
    }

    public String getName() {
        return this.mName;
    }

    public String getUuid() {
        return this.mUuid;
    }
}
