package com.samsung.android.support.senl.addons.base.model.pen;

import com.samsung.android.support.senl.addons.base.model.color.IExtendedColor;
import com.samsung.android.support.senl.addons.base.model.common.IBaseModel;
import kotlin.Metadata;
import org.apache.commons.beanutils.FluentPropertyBeanIntrospector;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes8.dex */
@Metadata(m13885d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\n\bf\u0018\u0000 \u001c2\u00020\u00012\u00020\u0002:\u0001\u001cJ\u001b\u0010\u0003\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u0007\u001a\u00020\bH¦\u0002J\u0019\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\bH¦\u0002J#\u0010\u0003\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\bH¦\u0002J\u0010\u0010\n\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\bH&J\b\u0010\u000b\u001a\u00020\bH&J\b\u0010\f\u001a\u00020\u0006H&J\n\u0010\r\u001a\u0004\u0018\u00010\u0006H&J\u0010\u0010\u000e\u001a\u00020\u00042\u0006\u0010\u000f\u001a\u00020\u0010H&J\b\u0010\u0011\u001a\u00020\u0010H&J\b\u0010\u0012\u001a\u00020\u0013H&J\b\u0010\u0014\u001a\u00020\bH&J\b\u0010\u0015\u001a\u00020\u0010H&J\b\u0010\u0016\u001a\u00020\u0013H&J\u0010\u0010\u0017\u001a\u00020\u00042\u0006\u0010\u0018\u001a\u00020\u0013H&J\u0010\u0010\u0019\u001a\u00020\u00042\u0006\u0010\u001a\u001a\u00020\u0010H&J\b\u0010\u001b\u001a\u00020\u0010H&¨\u0006\u001d"}, m13886d2 = {"Lcom/samsung/android/support/senl/addons/base/model/pen/IPenModel;", "Lcom/samsung/android/support/senl/addons/base/model/color/IExtendedColor;", "Lcom/samsung/android/support/senl/addons/base/model/common/IBaseModel;", FluentPropertyBeanIntrospector.DEFAULT_WRITE_METHOD_PREFIX, "", "type", "", "color", "", "size", "setPenSize", "getSize", "getPenName", "getPenClassName", "setSelected", "selected", "", "getSelected", "getPenSize", "", "getAlphaColor", "hasAlpha", "getAlpha", "setAlpha", "alphaValue", "setEnabled", "enable", "isEnabled", "Companion", "ntAddons_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
public interface IPenModel extends IExtendedColor, IBaseModel {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = Companion.$$INSTANCE;
    public static final int OBSV_PEN_MODEL_ENABLE_CHANGED = 303;
    public static final int OBSV_PEN_MODEL_SELECTION_CHANGED = 301;
    public static final int OBSV_PEN_MODEL_SIZE_CHANGED = 302;

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000e\u0010\u0004\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000¨\u0006\b"}, m13886d2 = {"Lcom/samsung/android/support/senl/addons/base/model/pen/IPenModel$Companion;", "", "<init>", "()V", "OBSV_PEN_MODEL_SELECTION_CHANGED", "", "OBSV_PEN_MODEL_SIZE_CHANGED", "OBSV_PEN_MODEL_ENABLE_CHANGED", "ntAddons_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
    public static final class Companion {
        static final /* synthetic */ Companion $$INSTANCE = new Companion();
        public static final int OBSV_PEN_MODEL_ENABLE_CHANGED = 303;
        public static final int OBSV_PEN_MODEL_SELECTION_CHANGED = 301;
        public static final int OBSV_PEN_MODEL_SIZE_CHANGED = 302;

        private Companion() {
        }
    }

    float getAlpha();

    int getAlphaColor();

    @Nullable
    String getPenClassName();

    @NotNull
    String getPenName();

    float getPenSize();

    boolean getSelected();

    int getSize();

    boolean hasAlpha();

    boolean isEnabled();

    void set(int color, int size);

    void set(@Nullable String type, int color);

    void set(@Nullable String type, int color, int size);

    void setAlpha(float alphaValue);

    void setEnabled(boolean enable);

    void setPenSize(int size);

    void setSelected(boolean selected);
}
