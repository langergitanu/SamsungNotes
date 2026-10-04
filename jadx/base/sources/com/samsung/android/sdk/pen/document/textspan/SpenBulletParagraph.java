package com.samsung.android.sdk.pen.document.textspan;

import com.samsung.android.sdk.pen.SpenError;
import com.samsung.android.support.notes.bixby.bixby2.constants.Bixby2Constants;
import java.util.ArrayList;
import java.util.Iterator;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes7.dex */
@Metadata(m13885d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u000b\n\u0002\b\f\n\u0002\u0010\u0002\n\u0002\b\u0004\u0018\u0000 &2\u00020\u0001:\u0001&B\t\b\u0016¢\u0006\u0004\b\u0002\u0010\u0003B!\b\u0016\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\u0006\u0010\u0007\u001a\u00020\u0005¢\u0006\u0004\b\u0002\u0010\bB1\b\u0016\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\u0016\u0010\t\u001a\u0012\u0012\u0004\u0012\u00020\u00050\nj\b\u0012\u0004\u0012\u00020\u0005`\u000b¢\u0006\u0004\b\u0002\u0010\fJ\u0010\u0010\"\u001a\u00020#2\u0006\u0010$\u001a\u00020\u0016H\u0007J\u0010\u0010%\u001a\u00020\u00162\u0006\u0010\u0007\u001a\u00020\u0005H\u0002R$\u0010\r\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\u0005@FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R\u001a\u0010\u0012\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u000f\"\u0004\b\u0014\u0010\u0011R\u001a\u0010\u0015\u001a\u00020\u0016X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\u0017\"\u0004\b\u0018\u0010\u0019RD\u0010\u001a\u001a\u0012\u0012\u0004\u0012\u00020\u00050\nj\b\u0012\u0004\u0012\u00020\u0005`\u000b2\u0016\u0010\t\u001a\u0012\u0012\u0004\u0012\u00020\u00050\nj\b\u0012\u0004\u0012\u00020\u0005`\u000b@FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001b\u0010\u001c\"\u0004\b\u001d\u0010\u001eR\u001a\u0010\u001f\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b \u0010\u000f\"\u0004\b!\u0010\u0011¨\u0006'"}, m13886d2 = {"Lcom/samsung/android/sdk/pen/document/textspan/SpenBulletParagraph;", "Lcom/samsung/android/sdk/pen/document/textspan/SpenTextParagraphBase;", "<init>", "()V", "startPosition", "", "endPosition", "type", "(III)V", "typeList", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "(IILjava/util/ArrayList;)V", "bulletType", "getBulletType", "()I", "setBulletType", "(I)V", "bulletNumber", "getBulletNumber", "setBulletNumber", "isChecked", "", "()Z", "setChecked", "(Z)V", "bulletTypeList", "getBulletTypeList", "()Ljava/util/ArrayList;", "setBulletTypeList", "(Ljava/util/ArrayList;)V", "initialNumber", "getInitialNumber", "setInitialNumber", "Checkout", "", Bixby2Constants.BIXBY_PARAM_CHECK, "isSupportedBulletType", "Companion", "SDK_fullRelease"}, m13887k = 1, m13888mv = {2, 0, 0}, m13890xi = 48)
public final class SpenBulletParagraph extends SpenTextParagraphBase {
    public static final int TYPE_ALPHABET = 6;
    public static final int TYPE_ARROW = 1;
    public static final int TYPE_BLACK_SQUARE = 11;
    public static final int TYPE_CHECKER = 2;
    public static final int TYPE_CIRCLED_DIGIT = 5;
    public static final int TYPE_DIAMOND = 3;
    public static final int TYPE_DIGIT = 4;
    public static final int TYPE_NONE = 0;
    public static final int TYPE_ROMAN_NUMERAL = 7;
    public static final int TYPE_SOLID_CIRCLE = 8;
    public static final int TYPE_UPPERCASE_ALPHABET = 10;
    public static final int TYPE_WHITE_CIRCLE = 9;
    public static final int TYPE_WHITE_SQUARE = 12;
    private int bulletNumber;
    private int bulletType;

    @NotNull
    private ArrayList<Integer> bulletTypeList;
    private int initialNumber;
    private boolean isChecked;

    public SpenBulletParagraph() {
        super(5);
        this.bulletTypeList = new ArrayList<>();
        this.initialNumber = 1;
    }

    private final boolean isSupportedBulletType(int type) {
        if (type == 0 || type == 2 || type == 4) {
            return true;
        }
        switch (type) {
            case 6:
            case 7:
            case 8:
            case 9:
            case 10:
            case 11:
            case 12:
                return true;
            default:
                return false;
        }
    }

    @Deprecated(message = "Please use [isChecked] instead.")
    public final void Checkout(boolean check) {
        this.isChecked = check;
    }

    public final int getBulletNumber() {
        return this.bulletNumber;
    }

    public final int getBulletType() {
        return this.bulletType;
    }

    @NotNull
    public final ArrayList<Integer> getBulletTypeList() {
        return this.bulletTypeList;
    }

    public final int getInitialNumber() {
        return this.initialNumber;
    }

    /* JADX INFO: renamed from: isChecked, reason: from getter */
    public final boolean getIsChecked() {
        return this.isChecked;
    }

    public final void setBulletNumber(int i) {
        this.bulletNumber = i;
    }

    public final void setBulletType(int i) {
        if (!isSupportedBulletType(i)) {
            SpenError.ThrowUncheckedException(7);
        }
        this.bulletType = i;
    }

    public final void setBulletTypeList(@NotNull ArrayList<Integer> typeList) {
        Intrinsics.checkNotNullParameter(typeList, "typeList");
        Iterator<Integer> it = typeList.iterator();
        Intrinsics.checkNotNullExpressionValue(it, "iterator(...)");
        while (it.hasNext()) {
            if (!isSupportedBulletType(it.next().intValue())) {
                SpenError.ThrowUncheckedException(7);
            }
        }
        this.bulletTypeList.clear();
        this.bulletTypeList = typeList;
    }

    public final void setChecked(boolean z) {
        this.isChecked = z;
    }

    public final void setInitialNumber(int i) {
        this.initialNumber = i;
    }

    public SpenBulletParagraph(int i, int i2, int i4) {
        super(5, i, i2);
        this.bulletTypeList = new ArrayList<>();
        this.initialNumber = 1;
        setBulletType(i4);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SpenBulletParagraph(int i, int i2, @NotNull ArrayList<Integer> typeList) {
        super(5, i, i2);
        Intrinsics.checkNotNullParameter(typeList, "typeList");
        this.bulletTypeList = new ArrayList<>();
        this.initialNumber = 1;
        setBulletTypeList(typeList);
    }
}
