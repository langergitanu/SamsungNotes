package com.samsung.android.support.senl.addons.brush.model.color;

import com.samsung.android.support.notes.bixby.bixby2.constants.Bixby2Constants;
import com.samsung.android.support.senl.addons.base.model.color.IExtendedColor;
import com.samsung.android.support.senl.addons.base.model.common.IBaseModel;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes8.dex */
@Metadata(m13885d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0014\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0006\bf\u0018\u0000 \u00142\u00020\u00012\u00020\u0002:\u0001\u0014J\b\u0010\u0003\u001a\u00020\u0004H&J\b\u0010\u0005\u001a\u00020\u0006H&J\b\u0010\u0007\u001a\u00020\u0004H&J\n\u0010\b\u001a\u0004\u0018\u00010\tH&J\u0010\u0010\n\u001a\u00020\u000b2\u0006\u0010\n\u001a\u00020\u000bH&J\b\u0010\f\u001a\u00020\u000bH&J\b\u0010\r\u001a\u00020\u000bH&J\u0010\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u000bH&J\u0012\u0010\u0011\u001a\u00020\u000f2\b\u0010\u0012\u001a\u0004\u0018\u00010\u0006H&J\u0010\u0010\u0011\u001a\u00020\u000f2\u0006\u0010\u0013\u001a\u00020\u0004H&¨\u0006\u0015"}, m13886d2 = {"Lcom/samsung/android/support/senl/addons/brush/model/color/IMenuColorModel;", "Lcom/samsung/android/support/senl/addons/base/model/common/IBaseModel;", "Lcom/samsung/android/support/senl/addons/base/model/color/IExtendedColor;", "getColor", "", "getHSV", "", "getPosition", "getDescription", "", Bixby2Constants.BIXBY_PARAM_SELECT, "", "isSelected", "isEnabled", "setEnabled", "", "enabled", "setColor", "hsv", "color", "Companion", "ntAddons_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
public interface IMenuColorModel extends IBaseModel, IExtendedColor {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = Companion.$$INSTANCE;
    public static final int OBSV_MENU_COLOR_SELECTION_CHANGE = 20001;

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000e\u0010\u0004\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000¨\u0006\u0006"}, m13886d2 = {"Lcom/samsung/android/support/senl/addons/brush/model/color/IMenuColorModel$Companion;", "", "<init>", "()V", "OBSV_MENU_COLOR_SELECTION_CHANGE", "", "ntAddons_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
    public static final class Companion {
        static final /* synthetic */ Companion $$INSTANCE = new Companion();
        public static final int OBSV_MENU_COLOR_SELECTION_CHANGE = 20001;

        private Companion() {
        }
    }

    @Override // com.samsung.android.support.senl.addons.base.model.color.IBaseColorModel
    int getColor();

    @Nullable
    String getDescription();

    @Override // com.samsung.android.support.senl.addons.base.model.color.IExtendedColor
    @NotNull
    float[] getHSV();

    @Override // com.samsung.android.support.senl.addons.base.model.color.IBaseColorModel
    int getPosition();

    boolean isEnabled();

    boolean isSelected();

    boolean select(boolean select);

    @Override // com.samsung.android.support.senl.addons.base.model.color.IBaseColorModel
    void setColor(int color);

    @Override // com.samsung.android.support.senl.addons.base.model.color.IExtendedColor
    void setColor(@Nullable float[] hsv);

    void setEnabled(boolean enabled);
}
