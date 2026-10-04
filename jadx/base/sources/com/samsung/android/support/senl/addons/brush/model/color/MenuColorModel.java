package com.samsung.android.support.senl.addons.brush.model.color;

import androidx.appcompat.widget.AbstractC0541b;
import androidx.glance.AbstractC2821a;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.samsung.android.sdk.smp.common.constants.MarketingConstants;
import com.samsung.android.support.notes.bixby.bixby2.constants.Bixby2Constants;
import com.samsung.android.support.senl.addons.base.model.color.ColorModel;
import com.samsung.android.support.senl.addons.base.model.color.IExtendedColor;
import com.samsung.android.support.senl.addons.base.utils.Logger;
import com.samsung.android.support.senl.p145cm.base.framework.support.ColorCompat;
import com.samsung.android.support.senl.p148nt.data.common.constants.SearchConstants;
import com.samsung.android.support.senl.p148nt.data.database.core.query.sqlbuilder.SQLKeyword;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes8.dex */
@Metadata(m13885d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\u0014\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\r\u0018\u0000 #2\u00020\u00012\u00020\u0002:\u0002#$B#\b\u0016\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\u0006\u0010\u0007\u001a\u00020\u0004¢\u0006\u0004\b\b\u0010\tB-\b\u0016\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\b\u0010\n\u001a\u0004\u0018\u00010\u000b\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\u0006\u0010\u0007\u001a\u00020\u0004¢\u0006\u0004\b\b\u0010\fB+\b\u0012\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\u0006\u0010\u0007\u001a\u00020\u0004\u0012\u0006\u0010\r\u001a\u00020\u000e¢\u0006\u0004\b\b\u0010\u000fB5\b\u0012\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\b\u0010\n\u001a\u0004\u0018\u00010\u000b\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\u0006\u0010\u0007\u001a\u00020\u0004\u0012\u0006\u0010\r\u001a\u00020\u000e¢\u0006\u0004\b\b\u0010\u0010J\u000e\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u0016J\u0010\u0010\u001a\u001a\u00020\u000e2\u0006\u0010\u001a\u001a\u00020\u000eH\u0016J\u0010\u0010\u001b\u001a\u00020\u00182\u0006\u0010\u001c\u001a\u00020\u000eH\u0016J\b\u0010\u001d\u001a\u00020\u000eH\u0016J\b\u0010\u001e\u001a\u00020\u0018H\u0002J\n\u0010\u001f\u001a\u0004\u0018\u00010\u0006H\u0016J\b\u0010 \u001a\u00020\u0004H\u0016J\b\u0010!\u001a\u00020\u000eH\u0016J\u000e\u0010\"\u001a\u00020\u00182\u0006\u0010\u0005\u001a\u00020\u0006R\u0010\u0010\u0011\u001a\u0004\u0018\u00010\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0012\u001a\u0004\u0018\u00010\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u000eX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u000eX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0015\u001a\u0004\u0018\u00010\u0016X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006%"}, m13886d2 = {"Lcom/samsung/android/support/senl/addons/brush/model/color/MenuColorModel;", "Lcom/samsung/android/support/senl/addons/base/model/color/ColorModel;", "Lcom/samsung/android/support/senl/addons/brush/model/color/IMenuColorModel;", "color", "", "name", "", "index", "<init>", "(ILjava/lang/String;I)V", "hsvColor", "", "(I[FLjava/lang/String;I)V", "selected", "", "(ILjava/lang/String;IZ)V", "(I[FLjava/lang/String;IZ)V", "mName", "mDescription", "mSelected", "mIsEnabled", "mListener", "Lcom/samsung/android/support/senl/addons/brush/model/color/MenuColorModel$OnSelectionListener;", "setSelectionListener", "", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, Bixby2Constants.BIXBY_PARAM_SELECT, "setEnabled", "enabled", "isSelected", "setDescription", "getDescription", "getColor", "isEnabled", "setName", "Companion", "OnSelectionListener", "ntAddons_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
public final class MenuColorModel extends ColorModel implements IMenuColorModel {

    @Nullable
    private String mDescription;
    private boolean mIsEnabled;

    @Nullable
    private OnSelectionListener mListener;

    @Nullable
    private String mName;
    private boolean mSelected;

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    @NotNull
    private static final String TAG = Logger.createBrushTag("MenuColorModel");

    @NotNull
    private static String POSTFIX_DESCRIPTION_SELECTED = "";

    @NotNull
    private static String PREFIX_COLOR = "";

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\t\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u0006\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR\u001a\u0010\u000b\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\b\"\u0004\b\r\u0010\n¨\u0006\u000e"}, m13886d2 = {"Lcom/samsung/android/support/senl/addons/brush/model/color/MenuColorModel$Companion;", "", "<init>", "()V", SearchConstants.TargetContents.TAG, "", "POSTFIX_DESCRIPTION_SELECTED", "getPOSTFIX_DESCRIPTION_SELECTED", "()Ljava/lang/String;", "setPOSTFIX_DESCRIPTION_SELECTED", "(Ljava/lang/String;)V", "PREFIX_COLOR", "getPREFIX_COLOR", "setPREFIX_COLOR", "ntAddons_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @NotNull
        public final String getPOSTFIX_DESCRIPTION_SELECTED() {
            return MenuColorModel.POSTFIX_DESCRIPTION_SELECTED;
        }

        @NotNull
        public final String getPREFIX_COLOR() {
            return MenuColorModel.PREFIX_COLOR;
        }

        public final void setPOSTFIX_DESCRIPTION_SELECTED(@NotNull String str) {
            Intrinsics.checkNotNullParameter(str, "<set-?>");
            MenuColorModel.POSTFIX_DESCRIPTION_SELECTED = str;
        }

        public final void setPREFIX_COLOR(@NotNull String str) {
            Intrinsics.checkNotNullParameter(str, "<set-?>");
            MenuColorModel.PREFIX_COLOR = str;
        }

        private Companion() {
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\u0018\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H&¨\u0006\b"}, m13886d2 = {"Lcom/samsung/android/support/senl/addons/brush/model/color/MenuColorModel$OnSelectionListener;", "", "onSelected", "", "index", "", "color", "Lcom/samsung/android/support/senl/addons/base/model/color/IExtendedColor;", "ntAddons_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
    public interface OnSelectionListener {
        void onSelected(int index, @NotNull IExtendedColor color);
    }

    public MenuColorModel(int i, @Nullable String str, int i2) {
        this(i, str, i2, false);
    }

    private final void setDescription() {
        String strM2221l;
        if (this.mIsEnabled) {
            strM2221l = AbstractC2821a.m2221l(this.mSelected ? AbstractC0541b.m756B(POSTFIX_DESCRIPTION_SELECTED, SQLKeyword.COMMA) : "", PREFIX_COLOR, SQLKeyword.COMMA, this.mName);
        } else {
            strM2221l = null;
        }
        this.mDescription = strM2221l;
    }

    @Override // com.samsung.android.support.senl.addons.base.model.color.AbsBaseColorModel, com.samsung.android.support.senl.addons.base.model.color.IBaseColorModel
    /* JADX INFO: renamed from: getColor */
    public int getMColor() {
        return this.mIsEnabled ? super.getMColor() : MarketingConstants.PopupConst.DEFAULT_COLOR_LINE;
    }

    @Override // com.samsung.android.support.senl.addons.brush.model.color.IMenuColorModel
    @Nullable
    /* JADX INFO: renamed from: getDescription, reason: from getter */
    public String getMDescription() {
        return this.mDescription;
    }

    @Override // com.samsung.android.support.senl.addons.brush.model.color.IMenuColorModel
    /* JADX INFO: renamed from: isEnabled, reason: from getter */
    public boolean getMIsEnabled() {
        return this.mIsEnabled;
    }

    @Override // com.samsung.android.support.senl.addons.brush.model.color.IMenuColorModel
    /* JADX INFO: renamed from: isSelected, reason: from getter */
    public boolean getMSelected() {
        return this.mSelected;
    }

    @Override // com.samsung.android.support.senl.addons.brush.model.color.IMenuColorModel
    public boolean select(boolean select) {
        boolean z = false;
        if (this.mIsEnabled) {
            if (this.mSelected != select) {
                this.mSelected = select;
                setDescription();
                String str = TAG;
                boolean z2 = this.mSelected;
                String str2 = this.mName;
                int mColor = getMColor();
                int iHSVToColor = ColorCompat.HSVToColor(getMHSV());
                String hexString = Integer.toHexString(hashCode());
                StringBuilder sb = new StringBuilder("select : ");
                sb.append(z2);
                sb.append(" / ");
                sb.append(str2);
                sb.append(" - ");
                AbstractC2821a.m2235z(sb, mColor, iHSVToColor, SQLKeyword.COMMA, "/");
                sb.append(hexString);
                Logger.m7100d(str, sb.toString());
                notifyChanged(20001);
                z = true;
            }
            if (select) {
                OnSelectionListener onSelectionListener = this.mListener;
                if (onSelectionListener != null) {
                    Intrinsics.checkNotNull(onSelectionListener);
                    onSelectionListener.onSelected(getMPosition(), this);
                }
                notifyChanged(201);
            }
        }
        return z;
    }

    @Override // com.samsung.android.support.senl.addons.brush.model.color.IMenuColorModel
    public void setEnabled(boolean enabled) {
        this.mIsEnabled = enabled;
        setDescription();
    }

    public final void setName(@NotNull String name) {
        Intrinsics.checkNotNullParameter(name, "name");
        this.mName = name;
        setDescription();
    }

    public final void setSelectionListener(@NotNull OnSelectionListener listener) {
        Intrinsics.checkNotNullParameter(listener, "listener");
        this.mListener = listener;
    }

    public MenuColorModel(int i, @Nullable float[] fArr, @Nullable String str, int i2) {
        this(i, fArr, str, i2, false);
    }

    private MenuColorModel(int i, String str, int i2, boolean z) {
        super(i, i2);
        this.mIsEnabled = true;
        this.mName = str;
        this.mSelected = z;
        setDescription();
    }

    private MenuColorModel(int i, float[] fArr, String str, int i2, boolean z) {
        super(i, fArr, i2);
        this.mIsEnabled = true;
        this.mName = str;
        this.mSelected = z;
        setDescription();
    }
}
