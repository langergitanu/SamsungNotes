package com.samsung.android.support.senl.p148nt.base.composer.html.logic;

import com.samsung.android.scs.p140ai.sdkcommon.text.TextConst;
import com.samsung.android.sdk.pen.document.SpenObjectTextBox;
import com.samsung.android.sdk.pen.document.textspan.SpenBulletParagraph;
import com.samsung.android.support.senl.p148nt.base.composer.html.common.HtmlConstants;
import com.samsung.android.support.senl.p148nt.data.common.constants.CoverStickerConstants;
import com.samsung.android.support.senl.p148nt.data.common.constants.ExternalDataConstants;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes2.dex */
@Metadata(m13885d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b0\u0018\u00002\u00020\u0001:\u0004\f\r\u000e\u000fB\t\b\u0004¢\u0006\u0004\b\u0002\u0010\u0003J&\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\u000b\u001a\u00020\u0005\u0082\u0001\u0004\u0010\u0011\u0012\u0013¨\u0006\u0014"}, m13886d2 = {"Lcom/samsung/android/support/senl/nt/base/composer/html/logic/ListStyle;", "", "<init>", "()V", "setParagraph", "", ExternalDataConstants.Column.TEXT_BOX, "Lcom/samsung/android/sdk/pen/document/SpenObjectTextBox;", "start", "", "end", "setSpacing", CoverStickerConstants.Category.NONE.NAME, "BULLET", "NUMBERED", "CHECKBOX", "Lcom/samsung/android/support/senl/nt/base/composer/html/logic/ListStyle$BULLET;", "Lcom/samsung/android/support/senl/nt/base/composer/html/logic/ListStyle$CHECKBOX;", "Lcom/samsung/android/support/senl/nt/base/composer/html/logic/ListStyle$NONE;", "Lcom/samsung/android/support/senl/nt/base/composer/html/logic/ListStyle$NUMBERED;", "ntBase_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
public abstract class ListStyle {

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\bÆ\n\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0013\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007HÖ\u0003J\t\u0010\b\u001a\u00020\tHÖ\u0001J\t\u0010\n\u001a\u00020\u000bHÖ\u0001¨\u0006\f"}, m13886d2 = {"Lcom/samsung/android/support/senl/nt/base/composer/html/logic/ListStyle$BULLET;", "Lcom/samsung/android/support/senl/nt/base/composer/html/logic/ListStyle;", "<init>", "()V", "equals", "", "other", "", "hashCode", "", "toString", "", "ntBase_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
    public static final /* data */ class BULLET extends ListStyle {

        @NotNull
        public static final BULLET INSTANCE = new BULLET();

        private BULLET() {
            super(null);
        }

        public boolean equals(@Nullable Object other) {
            return this == other || (other instanceof BULLET);
        }

        public int hashCode() {
            return 1043372630;
        }

        @NotNull
        public String toString() {
            return "BULLET";
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\t\u0010\b\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\t\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\n\u001a\u00020\u00032\b\u0010\u000b\u001a\u0004\u0018\u00010\fHÖ\u0003J\t\u0010\r\u001a\u00020\u000eHÖ\u0001J\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0011"}, m13886d2 = {"Lcom/samsung/android/support/senl/nt/base/composer/html/logic/ListStyle$CHECKBOX;", "Lcom/samsung/android/support/senl/nt/base/composer/html/logic/ListStyle;", "checked", "", "<init>", "(Z)V", "getChecked", "()Z", "component1", "copy", "equals", "other", "", "hashCode", "", "toString", "", "ntBase_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
    public static final /* data */ class CHECKBOX extends ListStyle {
        private final boolean checked;

        public CHECKBOX(boolean z) {
            super(null);
            this.checked = z;
        }

        public static /* synthetic */ CHECKBOX copy$default(CHECKBOX checkbox, boolean z, int i, Object obj) {
            if ((i & 1) != 0) {
                z = checkbox.checked;
            }
            return checkbox.copy(z);
        }

        /* JADX INFO: renamed from: component1, reason: from getter */
        public final boolean getChecked() {
            return this.checked;
        }

        @NotNull
        public final CHECKBOX copy(boolean checked) {
            return new CHECKBOX(checked);
        }

        public boolean equals(@Nullable Object other) {
            if (this == other) {
                return true;
            }
            return (other instanceof CHECKBOX) && this.checked == ((CHECKBOX) other).checked;
        }

        public final boolean getChecked() {
            return this.checked;
        }

        public int hashCode() {
            return Boolean.hashCode(this.checked);
        }

        @NotNull
        public String toString() {
            return "CHECKBOX(checked=" + this.checked + ")";
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\bÆ\n\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0013\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007HÖ\u0003J\t\u0010\b\u001a\u00020\tHÖ\u0001J\t\u0010\n\u001a\u00020\u000bHÖ\u0001¨\u0006\f"}, m13886d2 = {"Lcom/samsung/android/support/senl/nt/base/composer/html/logic/ListStyle$NONE;", "Lcom/samsung/android/support/senl/nt/base/composer/html/logic/ListStyle;", "<init>", "()V", "equals", "", "other", "", "hashCode", "", "toString", "", "ntBase_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
    public static final /* data */ class NONE extends ListStyle {

        @NotNull
        public static final NONE INSTANCE = new NONE();

        private NONE() {
            super(null);
        }

        public boolean equals(@Nullable Object other) {
            return this == other || (other instanceof NONE);
        }

        public int hashCode() {
            return -861131380;
        }

        @NotNull
        public String toString() {
            return CoverStickerConstants.Category.NONE.NAME;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u000b\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\u0019\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\t\u0010\f\u001a\u00020\u0003HÆ\u0003J\t\u0010\r\u001a\u00020\u0005HÆ\u0003J\u001d\u0010\u000e\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u000f\u001a\u00020\u00052\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011HÖ\u0003J\t\u0010\u0012\u001a\u00020\u0003HÖ\u0001J\t\u0010\u0013\u001a\u00020\u0014HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\u0015"}, m13886d2 = {"Lcom/samsung/android/support/senl/nt/base/composer/html/logic/ListStyle$NUMBERED;", "Lcom/samsung/android/support/senl/nt/base/composer/html/logic/ListStyle;", TextConst.KEY_PARAM_NUMBER, "", "fixed", "", "<init>", "(IZ)V", "getNumber", "()I", "getFixed", "()Z", "component1", "component2", "copy", "equals", "other", "", "hashCode", "toString", "", "ntBase_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
    public static final /* data */ class NUMBERED extends ListStyle {
        private final boolean fixed;
        private final int number;

        public NUMBERED(int i, boolean z) {
            super(null);
            this.number = i;
            this.fixed = z;
        }

        public static /* synthetic */ NUMBERED copy$default(NUMBERED numbered, int i, boolean z, int i2, Object obj) {
            if ((i2 & 1) != 0) {
                i = numbered.number;
            }
            if ((i2 & 2) != 0) {
                z = numbered.fixed;
            }
            return numbered.copy(i, z);
        }

        /* JADX INFO: renamed from: component1, reason: from getter */
        public final int getNumber() {
            return this.number;
        }

        /* JADX INFO: renamed from: component2, reason: from getter */
        public final boolean getFixed() {
            return this.fixed;
        }

        @NotNull
        public final NUMBERED copy(int number, boolean fixed) {
            return new NUMBERED(number, fixed);
        }

        public boolean equals(@Nullable Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof NUMBERED)) {
                return false;
            }
            NUMBERED numbered = (NUMBERED) other;
            return this.number == numbered.number && this.fixed == numbered.fixed;
        }

        public final boolean getFixed() {
            return this.fixed;
        }

        public final int getNumber() {
            return this.number;
        }

        public int hashCode() {
            return Boolean.hashCode(this.fixed) + (Integer.hashCode(this.number) * 31);
        }

        @NotNull
        public String toString() {
            return "NUMBERED(number=" + this.number + ", fixed=" + this.fixed + ")";
        }

        public /* synthetic */ NUMBERED(int i, boolean z, int i2, DefaultConstructorMarker defaultConstructorMarker) {
            this(i, (i2 & 2) != 0 ? false : z);
        }
    }

    public /* synthetic */ ListStyle(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }

    public final boolean setParagraph(@NotNull SpenObjectTextBox textBox, int start, int end, boolean setSpacing) {
        Intrinsics.checkNotNullParameter(textBox, "textBox");
        if (Intrinsics.areEqual(this, NONE.INSTANCE)) {
            return false;
        }
        if (this instanceof CHECKBOX) {
            SpenBulletParagraph spenBulletParagraph = new SpenBulletParagraph(start, 1, 2);
            spenBulletParagraph.setChecked(((CHECKBOX) this).getChecked());
            textBox.appendTextParagraph(spenBulletParagraph);
        } else if (this instanceof NUMBERED) {
            SpenBulletParagraph spenBulletParagraph2 = new SpenBulletParagraph(start, 1, 4);
            NUMBERED numbered = (NUMBERED) this;
            if (numbered.getFixed()) {
                spenBulletParagraph2.setInitialNumber(numbered.getNumber());
            }
            textBox.appendTextParagraph(spenBulletParagraph2);
        } else {
            textBox.appendTextParagraph(new SpenBulletParagraph(start, 1, 8));
        }
        if (setSpacing) {
            HtmlConstants htmlConstants = HtmlConstants.INSTANCE;
            htmlConstants.getLIST_STYLE().setTopMargin(textBox, 0, 1);
            htmlConstants.getLIST_STYLE().setBottomMargin(textBox, end - 1, end);
        }
        return true;
    }

    private ListStyle() {
    }
}
