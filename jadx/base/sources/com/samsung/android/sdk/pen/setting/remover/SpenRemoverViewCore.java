package com.samsung.android.sdk.pen.setting.remover;

import android.content.Context;
import android.util.Log;
import android.view.View;
import androidx.constraintlayout.motion.widget.AbstractC2322a;
import com.google.android.gms.common.data.AbstractC4539a;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.samsung.android.sdk.pen.SpenSettingRemoverInfo;
import com.samsung.android.sdk.pen.setting.colorpalette.ViewOnClickListenerC7538b;
import com.samsung.android.sdk.pen.setting.common.SpenShowButtonShapeText;
import com.samsung.android.sdk.pen.setting.common.SpenTouchDelegate;
import com.samsung.android.sdk.pen.setting.common.SpenVoiceAssistantAsButton;
import com.samsung.android.sdk.pen.setting.remover.SpenEraseAllControl;
import com.samsung.android.sdk.pen.setting.remover.SpenRemoverPreviewControl;
import com.samsung.android.sdk.pen.setting.util.SpenSettingUtilText;
import com.samsung.android.sdk.smp.common.constants.MarketingConstants;
import com.samsung.android.spen.C7932R;
import com.samsung.android.support.senl.p148nt.data.database.core.query.sqlbuilder.SQLKeyword;
import java.util.Arrays;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import p001A.AbstractC0000a;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(m13885d1 = {"\u0000~\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0011\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0007\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\b\b\u0000\u0018\u0000 L2\u00020\u0001:\u0005LMNOPB\u001f\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005¢\u0006\u0004\b\u0007\u0010\bJ\u0006\u0010\u0017\u001a\u00020\u0018J\u0018\u0010\u0019\u001a\u00020\u00052\b\u0010\u001a\u001a\u0004\u0018\u00010\u000b2\u0006\u0010\u001b\u001a\u00020\u0005J\u0016\u0010.\u001a\u00020\u00182\u0006\u0010/\u001a\u0002002\u0006\u00101\u001a\u00020\u0005J\u000e\u00102\u001a\u00020\u00182\u0006\u00103\u001a\u00020\u0005J\u0006\u00104\u001a\u00020\u0018J\u0006\u00105\u001a\u00020\u0018J\u0006\u00106\u001a\u00020\u0018J\u0006\u00107\u001a\u00020\u0018J\u0010\u00108\u001a\u00020\u00182\b\u00109\u001a\u0004\u0018\u00010\u0010J\u0018\u0010:\u001a\u00020\u00182\b\u0010;\u001a\u0004\u0018\u00010+2\u0006\u0010<\u001a\u00020=J\u0010\u0010>\u001a\u00020\u00182\b\u00109\u001a\u0004\u0018\u00010\u0014J\u0010\u0010?\u001a\u00020\u00182\b\u00109\u001a\u0004\u0018\u00010\u0016J+\u0010@\u001a\u00020\u00182\u0006\u00103\u001a\u00020\u00052\u0016\u0010A\u001a\f\u0012\b\b\u0001\u0012\u0004\u0018\u00010B0$\"\u0004\u0018\u00010B¢\u0006\u0002\u0010CJ\u000e\u0010D\u001a\u00020\u00182\u0006\u0010E\u001a\u00020\u0005J\u001a\u0010F\u001a\u00020\u00182\b\u0010G\u001a\u0004\u0018\u00010+2\u0006\u0010H\u001a\u00020IH\u0002J\u0016\u0010J\u001a\u00020\u00052\u0006\u0010K\u001a\u00020I2\u0006\u00101\u001a\u00020\u0005R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u000e¢\u0006\u0002\n\u0000R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0004\u0010\tR\u000e\u0010\u0006\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\n\u001a\u0004\u0018\u00010\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000f\u001a\u0004\u0018\u00010\u0010X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0011\u001a\u0004\u0018\u00010\u0012X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0013\u001a\u0004\u0018\u00010\u0014X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0015\u001a\u0004\u0018\u00010\u0016X\u0082\u000e¢\u0006\u0002\n\u0000R$\u0010\u001e\u001a\u00020\u001d2\u0006\u0010\u001c\u001a\u00020\u001d8F@FX\u0086\u000e¢\u0006\f\u001a\u0004\b\u001f\u0010 \"\u0004\b!\u0010\"R4\u0010%\u001a\n\u0012\u0004\u0012\u00020\u001d\u0018\u00010$2\u000e\u0010#\u001a\n\u0012\u0004\u0012\u00020\u001d\u0018\u00010$8F@FX\u0086\u000e¢\u0006\f\u001a\u0004\b&\u0010'\"\u0004\b(\u0010)R\u0011\u0010*\u001a\u00020+8F¢\u0006\u0006\u001a\u0004\b,\u0010-¨\u0006Q"}, m13886d2 = {"Lcom/samsung/android/sdk/pen/setting/remover/SpenRemoverViewCore;", "", "mContext", "Landroid/content/Context;", "isSupportHighlighterOnly", "", "mIsSupportRemoverType", "<init>", "(Landroid/content/Context;ZZ)V", "()Z", "mRemoverLayout", "Lcom/samsung/android/sdk/pen/setting/remover/SpenRemoverLayout;", "mIsRemoverLayoutOwner", "mPreviewControl", "Lcom/samsung/android/sdk/pen/setting/remover/SpenRemoverPreviewControl;", "mPreviewVisibilityChangedListener", "Lcom/samsung/android/sdk/pen/setting/remover/SpenRemoverViewCore$PreviewVisibilityChangedListener;", "mEraseAllControl", "Lcom/samsung/android/sdk/pen/setting/remover/SpenEraseAllControl;", "mEraseAllListener", "Lcom/samsung/android/sdk/pen/setting/remover/SpenRemoverViewCore$EraseAllListener;", "mCustomMenuListener", "Lcom/samsung/android/sdk/pen/setting/remover/SpenRemoverViewCore$CustomMenuListener;", "close", "", "initRemoverLayout", "removerLayout", "isLayoutOwner", "settingCutterInfo", "Lcom/samsung/android/sdk/pen/SpenSettingRemoverInfo;", "info", "getInfo", "()Lcom/samsung/android/sdk/pen/SpenSettingRemoverInfo;", "setInfo", "(Lcom/samsung/android/sdk/pen/SpenSettingRemoverInfo;)V", "value", "", "removerInfoList", "getRemoverInfoList", "()[Lcom/samsung/android/sdk/pen/SpenSettingRemoverInfo;", "setRemoverInfoList", "([Lcom/samsung/android/sdk/pen/SpenSettingRemoverInfo;)V", "preview", "Landroid/view/View;", "getPreview", "()Landroid/view/View;", "updatePreview", "size", "", "animation", "setPreviewVisibility", "isVisible", "showPreviewForAWhile", "hidePreview", "startPreview", "stopPreview", "setPreviewVisibilityChangedListener", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "initClearAll", "clearAllButton", "clearAllText", "Lcom/samsung/android/sdk/pen/setting/common/SpenShowButtonShapeText;", "setEraseAllListener", "setCustomMenuListener", "setPageMenu", "menuList", "", "(Z[Ljava/lang/String;)V", "hideEraseAllOption", "needAnimation", "setButtonDescription", MarketingConstants.BUTTON, "stringID", "", "setVisibilitySupportHighlighterOnly", "visibility", "Companion", "EraseType", "EraseAllListener", "CustomMenuListener", "PreviewVisibilityChangedListener", "SDK_fullRelease"}, m13887k = 1, m13888mv = {2, 0, 0}, m13890xi = 48)
@SourceDebugExtension({"SMAP\nSpenRemoverViewCore.kt\nKotlin\n*S Kotlin\n*F\n+ 1 SpenRemoverViewCore.kt\ncom/samsung/android/sdk/pen/setting/remover/SpenRemoverViewCore\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,189:1\n1#2:190\n*E\n"})
public final class SpenRemoverViewCore {

    @NotNull
    private static final String TAG = "SpenRemoverViewCore";
    private final boolean isSupportHighlighterOnly;

    @NotNull
    private Context mContext;

    @Nullable
    private CustomMenuListener mCustomMenuListener;

    @Nullable
    private SpenEraseAllControl mEraseAllControl;

    @Nullable
    private EraseAllListener mEraseAllListener;
    private boolean mIsRemoverLayoutOwner;
    private final boolean mIsSupportRemoverType;

    @NotNull
    private SpenRemoverPreviewControl mPreviewControl;

    @Nullable
    private PreviewVisibilityChangedListener mPreviewVisibilityChangedListener;

    @Nullable
    private SpenRemoverLayout mRemoverLayout;

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\u0012\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H&J\u0012\u0010\u0006\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H&¨\u0006\u0007"}, m13886d2 = {"Lcom/samsung/android/sdk/pen/setting/remover/SpenRemoverViewCore$CustomMenuListener;", "", "onCrateMenu", "", "view", "Landroid/view/View;", "onPrepareMenuPosition", "SDK_fullRelease"}, m13887k = 1, m13888mv = {2, 0, 0}, m13890xi = 48)
    public interface CustomMenuListener {
        void onCrateMenu(@Nullable View view);

        void onPrepareMenuPosition(@Nullable View view);
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\bf\u0018\u00002\u00020\u0001J\u0018\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H&¨\u0006\b"}, m13886d2 = {"Lcom/samsung/android/sdk/pen/setting/remover/SpenRemoverViewCore$EraseAllListener;", "", "onEraseAll", "", "type", "Lcom/samsung/android/sdk/pen/setting/remover/SpenRemoverViewCore$EraseType;", "index", "", "SDK_fullRelease"}, m13887k = 1, m13888mv = {2, 0, 0}, m13890xi = 48)
    public interface EraseAllListener {
        void onEraseAll(@NotNull EraseType type, int index);
    }

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* JADX WARN: Unknown enum class pattern. Please report as an issue! */
    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, m13886d2 = {"Lcom/samsung/android/sdk/pen/setting/remover/SpenRemoverViewCore$EraseType;", "", "<init>", "(Ljava/lang/String;I)V", "DEFAULT", "CUSTOM_DEFINE", "SDK_fullRelease"}, m13887k = 1, m13888mv = {2, 0, 0}, m13890xi = 48)
    public static final class EraseType {
        private static final /* synthetic */ EnumEntries $ENTRIES;
        private static final /* synthetic */ EraseType[] $VALUES;
        public static final EraseType DEFAULT = new EraseType("DEFAULT", 0);
        public static final EraseType CUSTOM_DEFINE = new EraseType("CUSTOM_DEFINE", 1);

        private static final /* synthetic */ EraseType[] $values() {
            return new EraseType[]{DEFAULT, CUSTOM_DEFINE};
        }

        static {
            EraseType[] eraseTypeArr$values = $values();
            $VALUES = eraseTypeArr$values;
            $ENTRIES = EnumEntriesKt.enumEntries(eraseTypeArr$values);
        }

        private EraseType(String str, int i) {
        }

        @NotNull
        public static EnumEntries<EraseType> getEntries() {
            return $ENTRIES;
        }

        public static EraseType valueOf(String str) {
            return (EraseType) Enum.valueOf(EraseType.class, str);
        }

        public static EraseType[] values() {
            return (EraseType[]) $VALUES.clone();
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001¨\u0006\u0002"}, m13886d2 = {"Lcom/samsung/android/sdk/pen/setting/remover/SpenRemoverViewCore$PreviewVisibilityChangedListener;", "Lcom/samsung/android/sdk/pen/setting/remover/SpenRemoverPreviewControl$PreviewVisibilityChangedListener;", "SDK_fullRelease"}, m13887k = 1, m13888mv = {2, 0, 0}, m13890xi = 48)
    public interface PreviewVisibilityChangedListener extends SpenRemoverPreviewControl.PreviewVisibilityChangedListener {
    }

    public SpenRemoverViewCore(@NotNull Context mContext, boolean z, boolean z2) {
        Intrinsics.checkNotNullParameter(mContext, "mContext");
        this.mContext = mContext;
        this.isSupportHighlighterOnly = z;
        this.mIsSupportRemoverType = z2;
        SpenRemoverPreviewControl spenRemoverPreviewControl = new SpenRemoverPreviewControl(this.mContext);
        this.mPreviewControl = spenRemoverPreviewControl;
        spenRemoverPreviewControl.setPreviewVisibilityChangedListener(new SpenRemoverPreviewControl.PreviewVisibilityChangedListener() { // from class: com.samsung.android.sdk.pen.setting.remover.SpenRemoverViewCore.1
            @Override // com.samsung.android.sdk.pen.setting.remover.SpenRemoverPreviewControl.PreviewVisibilityChangedListener
            public void onPreviewVisibilityChanged(int visibility) {
                PreviewVisibilityChangedListener previewVisibilityChangedListener = SpenRemoverViewCore.this.mPreviewVisibilityChangedListener;
                if (previewVisibilityChangedListener != null) {
                    previewVisibilityChangedListener.onPreviewVisibilityChanged(visibility);
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void initClearAll$lambda$3(SpenRemoverViewCore spenRemoverViewCore, View view) {
        SpenEraseAllControl spenEraseAllControl = spenRemoverViewCore.mEraseAllControl;
        if (spenEraseAllControl != null) {
            spenEraseAllControl.doAction();
        }
    }

    private final void setButtonDescription(View button, int stringID) {
        if (button == null || stringID == 0) {
            return;
        }
        button.setContentDescription(this.mContext.getResources().getString(stringID) + SQLKeyword.COMMA + this.mContext.getResources().getString(C7932R.string.pen_string_button));
    }

    public final void close() {
        SpenRemoverLayout spenRemoverLayout;
        this.mPreviewControl.close();
        if (this.mIsRemoverLayoutOwner && (spenRemoverLayout = this.mRemoverLayout) != null) {
            spenRemoverLayout.close();
        }
        this.mRemoverLayout = null;
        SpenEraseAllControl spenEraseAllControl = this.mEraseAllControl;
        if (spenEraseAllControl != null) {
            spenEraseAllControl.close();
        }
        this.mEraseAllControl = null;
    }

    @NotNull
    public final SpenSettingRemoverInfo getInfo() {
        SpenRemoverLayout spenRemoverLayout = this.mRemoverLayout;
        return spenRemoverLayout != null ? new SpenSettingRemoverInfo(spenRemoverLayout.getInfo()) : new SpenSettingRemoverInfo();
    }

    @NotNull
    public final View getPreview() {
        return this.mPreviewControl.getPreview();
    }

    @Nullable
    public final SpenSettingRemoverInfo[] getRemoverInfoList() {
        SpenRemoverLayout spenRemoverLayout = this.mRemoverLayout;
        if (spenRemoverLayout == null || spenRemoverLayout == null) {
            return null;
        }
        return spenRemoverLayout.getRemoverInfoList();
    }

    public final void hideEraseAllOption(boolean needAnimation) {
        SpenEraseAllControl spenEraseAllControl = this.mEraseAllControl;
        if (spenEraseAllControl != null) {
            spenEraseAllControl.hideEraseAllOption(needAnimation);
        }
    }

    public final void hidePreview() {
        this.mPreviewControl.hidePreview();
    }

    public final void initClearAll(@Nullable View clearAllButton, @NotNull SpenShowButtonShapeText clearAllText) {
        Intrinsics.checkNotNullParameter(clearAllText, "clearAllText");
        if (clearAllButton == null) {
            return;
        }
        clearAllText.setOnClickListener(new ViewOnClickListenerC7538b(this, 19));
        SpenTouchDelegate.setDelegateToParent(clearAllButton, clearAllText);
        clearAllText.setAccessibilityDelegate(new SpenVoiceAssistantAsButton());
        SpenSettingUtilText.setDefaultButtonTextStyle(this.mContext, clearAllText);
        SpenSettingUtilText.applyUpToLargeLevel(this.mContext, 18.0f, clearAllText);
        clearAllText.setButtonShapeEnabled(true);
        clearAllButton.setVisibility(0);
        SpenEraseAllControl spenEraseAllControl = new SpenEraseAllControl(this.mContext);
        this.mEraseAllControl = spenEraseAllControl;
        spenEraseAllControl.setEraseAllListener(new SpenEraseAllControl.EraseAllListener() { // from class: com.samsung.android.sdk.pen.setting.remover.SpenRemoverViewCore.initClearAll.2
            @Override // com.samsung.android.sdk.pen.setting.remover.SpenEraseAllControl.EraseAllListener
            public void onEraseAll(SpenEraseAllControl.EraseType type, int index) {
                Intrinsics.checkNotNullParameter(type, "type");
                EraseType eraseType = type == SpenEraseAllControl.EraseType.CUSTOM_DEFINE ? EraseType.CUSTOM_DEFINE : EraseType.DEFAULT;
                EraseAllListener eraseAllListener = SpenRemoverViewCore.this.mEraseAllListener;
                if (eraseAllListener != null) {
                    eraseAllListener.onEraseAll(eraseType, index);
                }
            }
        });
        SpenEraseAllControl spenEraseAllControl2 = this.mEraseAllControl;
        if (spenEraseAllControl2 != null) {
            spenEraseAllControl2.setCustomMenuListener(new SpenEraseAllControl.CustomMenuListener() { // from class: com.samsung.android.sdk.pen.setting.remover.SpenRemoverViewCore.initClearAll.3
                @Override // com.samsung.android.sdk.pen.setting.remover.SpenEraseAllControl.CustomMenuListener
                public void onCrateMenu(View view) {
                    CustomMenuListener customMenuListener = SpenRemoverViewCore.this.mCustomMenuListener;
                    if (customMenuListener != null) {
                        customMenuListener.onCrateMenu(view);
                    }
                }

                @Override // com.samsung.android.sdk.pen.setting.remover.SpenEraseAllControl.CustomMenuListener
                public void onPrepareMenuPosition(View view) {
                    CustomMenuListener customMenuListener = SpenRemoverViewCore.this.mCustomMenuListener;
                    if (customMenuListener != null) {
                        customMenuListener.onPrepareMenuPosition(view);
                    }
                }
            });
        }
    }

    public final boolean initRemoverLayout(@Nullable SpenRemoverLayout removerLayout, boolean isLayoutOwner) {
        if (removerLayout == null) {
            return false;
        }
        this.mIsRemoverLayoutOwner = isLayoutOwner;
        this.mRemoverLayout = removerLayout;
        SpenRemoverLayout.setSupportHighlighterOnly$default(removerLayout, this.isSupportHighlighterOnly, false, 2, null);
        SpenRemoverLayout spenRemoverLayout = this.mRemoverLayout;
        if (spenRemoverLayout == null) {
            return true;
        }
        spenRemoverLayout.setSupportRemoverType(this.mIsSupportRemoverType);
        return true;
    }

    /* JADX INFO: renamed from: isSupportHighlighterOnly, reason: from getter */
    public final boolean getIsSupportHighlighterOnly() {
        return this.isSupportHighlighterOnly;
    }

    public final void setCustomMenuListener(@Nullable CustomMenuListener listener) {
        this.mCustomMenuListener = listener;
    }

    public final void setEraseAllListener(@Nullable EraseAllListener listener) {
        this.mEraseAllListener = listener;
    }

    public final void setInfo(@NotNull SpenSettingRemoverInfo settingCutterInfo) {
        Intrinsics.checkNotNullParameter(settingCutterInfo, "settingCutterInfo");
        if (this.mRemoverLayout == null) {
            return;
        }
        int i = settingCutterInfo.type;
        float f = settingCutterInfo.size;
        AbstractC0000a.m26w(AbstractC2322a.m1628r("setInfo() type=", i, " size=", f, " target="), TAG, settingCutterInfo.target);
        if (!this.isSupportHighlighterOnly) {
            settingCutterInfo.target = 0;
        }
        SpenRemoverLayout spenRemoverLayout = this.mRemoverLayout;
        if (spenRemoverLayout != null) {
            spenRemoverLayout.setInfo(settingCutterInfo);
        }
    }

    public final void setPageMenu(boolean isVisible, @NotNull String... menuList) {
        Intrinsics.checkNotNullParameter(menuList, "menuList");
        AbstractC4539a.m3208r("setPageMenu() isVisible=", TAG, isVisible);
        SpenEraseAllControl spenEraseAllControl = this.mEraseAllControl;
        if (spenEraseAllControl == null) {
            Log.i(TAG, "this function should be called after setting listener");
        } else if (spenEraseAllControl != null) {
            spenEraseAllControl.setCustomMenu(isVisible, (String[]) Arrays.copyOf(menuList, menuList.length));
        }
    }

    public final void setPreviewVisibility(boolean isVisible) {
        this.mPreviewControl.setPreviewVisibility(isVisible);
    }

    public final void setPreviewVisibilityChangedListener(@Nullable PreviewVisibilityChangedListener listener) {
        this.mPreviewVisibilityChangedListener = listener;
    }

    public final void setRemoverInfoList(@Nullable SpenSettingRemoverInfo[] spenSettingRemoverInfoArr) {
        SpenRemoverLayout spenRemoverLayout = this.mRemoverLayout;
        if (spenRemoverLayout != null) {
            spenRemoverLayout.setRemoverInfoList(spenSettingRemoverInfoArr);
        }
    }

    public final boolean setVisibilitySupportHighlighterOnly(int visibility, boolean animation) {
        SpenRemoverLayout spenRemoverLayout;
        if (!this.isSupportHighlighterOnly || (spenRemoverLayout = this.mRemoverLayout) == null) {
            return false;
        }
        Intrinsics.checkNotNull(spenRemoverLayout);
        return spenRemoverLayout.setSupportHighlighterOnly(visibility == 0, animation);
    }

    public final void showPreviewForAWhile() {
        SpenRemoverLayout spenRemoverLayout = this.mRemoverLayout;
        SpenSettingRemoverInfo info = spenRemoverLayout != null ? spenRemoverLayout.getInfo() : null;
        if (info != null) {
            this.mPreviewControl.showPreviewForAWhile(info.size);
        }
    }

    public final void startPreview() {
        SpenRemoverLayout spenRemoverLayout = this.mRemoverLayout;
        SpenSettingRemoverInfo info = spenRemoverLayout != null ? spenRemoverLayout.getInfo() : null;
        if (info != null) {
            this.mPreviewControl.startPreview(info.size);
        }
    }

    public final void stopPreview() {
        this.mPreviewControl.stopPreview();
    }

    public final void updatePreview(float size, boolean animation) {
        this.mPreviewControl.updatePreview(size, animation);
    }
}
