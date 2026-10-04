package com.samsung.android.support.senl.p148nt.composer.main.screenoff.view.menubar.setting;

import android.view.MotionEvent;
import android.view.View;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.samsung.android.support.senl.p148nt.app.addons.AbstractC8014b;
import com.samsung.android.support.senl.p148nt.composer.main.base.model.composer.WritingToolManager;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.composer.listener.SpenPreTouchListenerImpl;
import com.samsung.android.support.senl.p148nt.composer.main.screenoff.model.statical.PenInfoModel;
import com.samsung.android.support.senl.p148nt.composer.main.screenoff.util.Constants;
import com.samsung.android.support.senl.p148nt.composer.main.screenoff.util.SOLogger;
import com.samsung.android.support.senl.p148nt.composer.main.screenoff.util.p164sa.SAManager;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import p072Q3.C0221a;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(m13885d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\f\n\u0002\u0010\u0007\n\u0002\b\u0005\u0018\u0000 +2\u00020\u0001:\u0002*+B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J(\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u00142\b\u0010\u0015\u001a\u0004\u0018\u00010\n2\u0006\u0010\u0016\u001a\u00020\f2\u0006\u0010\u0017\u001a\u00020\u000eJ\u000e\u0010\u0018\u001a\u00020\u00122\u0006\u0010\u0019\u001a\u00020\u001aJ\u0006\u0010\u001b\u001a\u00020\u0012J\b\u0010\u001c\u001a\u00020\u0012H\u0002J\u000e\u0010\u001d\u001a\u00020\u00122\u0006\u0010\u001e\u001a\u00020\u0006J\u000e\u0010\u001f\u001a\u00020\u00122\u0006\u0010 \u001a\u00020\u001aJ\u0006\u0010!\u001a\u00020\u0012J\u000e\u0010\"\u001a\u00020\u001a2\u0006\u0010\u001e\u001a\u00020\u0006J\u0010\u0010#\u001a\u00020\u00122\u0006\u0010$\u001a\u00020\u0006H\u0016J\u0018\u0010%\u001a\u00020\u00122\u0006\u0010&\u001a\u00020'2\u0006\u0010(\u001a\u00020\u0006H\u0016J\b\u0010)\u001a\u00020\u0012H\u0016R*\u0010\u0004\u001a\u001e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00070\u0005j\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0007`\bX\u0082.¢\u0006\u0002\n\u0000R\u0010\u0010\t\u001a\u0004\u0018\u00010\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000b\u001a\u0004\u0018\u00010\fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eX\u0082.¢\u0006\u0002\n\u0000R\u0010\u0010\u000f\u001a\u0004\u0018\u00010\u0010X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006,"}, m13886d2 = {"Lcom/samsung/android/support/senl/nt/composer/main/screenoff/view/menubar/setting/SettingViewManager;", "Lcom/samsung/android/support/senl/nt/composer/main/screenoff/view/menubar/setting/ISettingViewManager;", "<init>", "()V", "mSettingMap", "Ljava/util/HashMap;", "", "Lcom/samsung/android/support/senl/nt/composer/main/screenoff/view/menubar/setting/SettingLayout;", "Lkotlin/collections/HashMap;", "mMenuItemManager", "Lcom/samsung/android/support/senl/nt/composer/main/screenoff/view/menubar/setting/SettingViewManager$IMenuItemManager;", "mWritingToolManager", "Lcom/samsung/android/support/senl/nt/composer/main/base/model/composer/WritingToolManager;", "mSettingViewState", "Lcom/samsung/android/support/senl/nt/composer/main/screenoff/view/menubar/setting/SettingViewState;", "mPreTouchListener", "Lcom/samsung/android/support/senl/nt/composer/main/base/presenter/composer/listener/SpenPreTouchListenerImpl$PreTouchListener;", "init", "", "container", "Landroid/view/View;", "menuItemManager", "writingToolManager", "settingViewState", "onWindowFocusChanged", "hasFocus", "", "onDestroy", "makePreTouchListener", Constants.IntentExtraValue.SHOW, "type", "hide", "setState", com.samsung.android.support.senl.p148nt.base.common.constants.Constants.ARG_UPDATE, "isShownSettingViews", "onUpdatedPenColor", "color", "onUpdatedPenSize", "size", "", "sizeLevel", "onDeleteAllObject", "IMenuItemManager", "Companion", "ntComposer_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
public final class SettingViewManager implements ISettingViewManager {

    @NotNull
    private static final String TAG = SOLogger.createTag("SettingViewManager");

    @Nullable
    private IMenuItemManager mMenuItemManager;

    @Nullable
    private SpenPreTouchListenerImpl.PreTouchListener mPreTouchListener;
    private HashMap<Integer, SettingLayout> mSettingMap;
    private SettingViewState mSettingViewState;

    @Nullable
    private WritingToolManager mWritingToolManager;

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\u0012\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H&J\u0012\u0010\u0006\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H&J\u0010\u0010\u0007\u001a\u00020\u00032\u0006\u0010\b\u001a\u00020\tH&J\b\u0010\n\u001a\u00020\u0003H&¨\u0006\u000b"}, m13886d2 = {"Lcom/samsung/android/support/senl/nt/composer/main/screenoff/view/menubar/setting/SettingViewManager$IMenuItemManager;", "", "addPreTouchListener", "", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "Lcom/samsung/android/support/senl/nt/composer/main/base/presenter/composer/listener/SpenPreTouchListenerImpl$PreTouchListener;", "removePreTouchListener", "onUpdatedPenColor", "color", "", "onDeleteAllObject", "ntComposer_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
    public interface IMenuItemManager {
        void addPreTouchListener(@Nullable SpenPreTouchListenerImpl.PreTouchListener listener);

        void onDeleteAllObject();

        void onUpdatedPenColor(int color);

        void removePreTouchListener(@Nullable SpenPreTouchListenerImpl.PreTouchListener listener);
    }

    private final void makePreTouchListener() {
        this.mPreTouchListener = new C0221a(this, 5);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean makePreTouchListener$lambda$0(SettingViewManager settingViewManager, View view, MotionEvent motionEvent) {
        settingViewManager.hide(true);
        return false;
    }

    public final void hide(boolean setState) {
        HashMap<Integer, SettingLayout> map = this.mSettingMap;
        SettingViewState settingViewState = null;
        if (map == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mSettingMap");
            map = null;
        }
        SettingViewState settingViewState2 = this.mSettingViewState;
        if (settingViewState2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mSettingViewState");
            settingViewState2 = null;
        }
        SettingLayout settingLayout = map.get(Integer.valueOf(settingViewState2.getSettingViewKey()));
        if (settingLayout != null) {
            settingLayout.hide();
        }
        if (setState) {
            SettingViewState settingViewState3 = this.mSettingViewState;
            if (settingViewState3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mSettingViewState");
            } else {
                settingViewState = settingViewState3;
            }
            settingViewState.setSettingViewVisibility(8);
        }
        IMenuItemManager iMenuItemManager = this.mMenuItemManager;
        if (iMenuItemManager != null) {
            iMenuItemManager.removePreTouchListener(this.mPreTouchListener);
        }
    }

    public final void init(@NotNull View container, @Nullable IMenuItemManager menuItemManager, @NotNull WritingToolManager writingToolManager, @NotNull SettingViewState settingViewState) {
        Intrinsics.checkNotNullParameter(container, "container");
        Intrinsics.checkNotNullParameter(writingToolManager, "writingToolManager");
        Intrinsics.checkNotNullParameter(settingViewState, "settingViewState");
        this.mMenuItemManager = menuItemManager;
        this.mWritingToolManager = writingToolManager;
        this.mSettingViewState = settingViewState;
        this.mSettingMap = new HashMap<>();
        SettingPenColorLayout settingPenColorLayout = new SettingPenColorLayout(container);
        SettingPenSizeLayout settingPenSizeLayout = new SettingPenSizeLayout(container);
        SettingRemoverLayout settingRemoverLayout = new SettingRemoverLayout(container);
        HashMap<Integer, SettingLayout> map = this.mSettingMap;
        SettingViewState settingViewState2 = null;
        if (map == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mSettingMap");
            map = null;
        }
        map.put(1, settingPenColorLayout);
        HashMap<Integer, SettingLayout> map2 = this.mSettingMap;
        if (map2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mSettingMap");
            map2 = null;
        }
        map2.put(2, settingPenSizeLayout);
        HashMap<Integer, SettingLayout> map3 = this.mSettingMap;
        if (map3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mSettingMap");
            map3 = null;
        }
        map3.put(4, settingRemoverLayout);
        HashMap<Integer, SettingLayout> map4 = this.mSettingMap;
        if (map4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mSettingMap");
            map4 = null;
        }
        Iterator<Map.Entry<Integer, SettingLayout>> it = map4.entrySet().iterator();
        while (it.hasNext()) {
            SettingLayout value = it.next().getValue();
            value.setSettingViewManager(this);
            value.init();
            value.update(true);
        }
        writingToolManager.setPenSettingInfo(PenInfoModel.INSTANCE.getSpenSettingPenInfo());
        makePreTouchListener();
        SettingViewState settingViewState3 = this.mSettingViewState;
        if (settingViewState3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mSettingViewState");
            settingViewState3 = null;
        }
        if (settingViewState3.getSettingViewVisibility() == 0) {
            SettingViewState settingViewState4 = this.mSettingViewState;
            if (settingViewState4 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mSettingViewState");
            } else {
                settingViewState2 = settingViewState4;
            }
            show(settingViewState2.getSettingViewKey());
        }
    }

    public final boolean isShownSettingViews(int type) {
        HashMap<Integer, SettingLayout> map = this.mSettingMap;
        if (map == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mSettingMap");
            map = null;
        }
        for (Map.Entry<Integer, SettingLayout> entry : map.entrySet()) {
            int iIntValue = entry.getKey().intValue();
            SettingLayout value = entry.getValue();
            if (value != null && iIntValue == type) {
                return value.isVisible();
            }
        }
        return false;
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.screenoff.view.menubar.setting.ISettingViewManager
    public void onDeleteAllObject() {
        SOLogger.INSTANCE.SOLoggerD(TAG, "onDeleteAllObject");
        IMenuItemManager iMenuItemManager = this.mMenuItemManager;
        if (iMenuItemManager != null) {
            iMenuItemManager.onDeleteAllObject();
        }
        update();
        hide(true);
    }

    public final void onDestroy() {
        SOLogger.INSTANCE.SOLoggerD(TAG, "onDestroy");
        hide(false);
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.screenoff.view.menubar.setting.ISettingViewManager
    public void onUpdatedPenColor(int color) {
        SOLogger sOLogger = SOLogger.INSTANCE;
        String str = TAG;
        StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
        String str2 = String.format("#%06X", Arrays.copyOf(new Object[]{Integer.valueOf(16777215 & color)}, 1));
        Intrinsics.checkNotNullExpressionValue(str2, "format(...)");
        sOLogger.SOLoggerD(str, "onUpdatedPenColor color ".concat(str2));
        SAManager.INSTANCE.getINSTANCE().onPenColorChanged(color);
        PenInfoModel penInfoModel = PenInfoModel.INSTANCE;
        penInfoModel.setColor(color);
        WritingToolManager writingToolManager = this.mWritingToolManager;
        if (writingToolManager != null) {
            writingToolManager.setPenSettingInfo(penInfoModel.getSpenSettingPenInfo());
        }
        IMenuItemManager iMenuItemManager = this.mMenuItemManager;
        if (iMenuItemManager != null) {
            iMenuItemManager.onUpdatedPenColor(color);
        }
        update();
        hide(true);
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.screenoff.view.menubar.setting.ISettingViewManager
    public void onUpdatedPenSize(float size, int sizeLevel) {
        SOLogger.INSTANCE.SOLoggerD(TAG, "onUpdatedPenSize size/sizeLevel " + size + "/" + sizeLevel);
        SAManager.INSTANCE.getINSTANCE().onPenSizeChanged(sizeLevel);
        PenInfoModel penInfoModel = PenInfoModel.INSTANCE;
        penInfoModel.setSize(size, sizeLevel);
        WritingToolManager writingToolManager = this.mWritingToolManager;
        if (writingToolManager != null) {
            writingToolManager.setPenSettingInfo(penInfoModel.getSpenSettingPenInfo());
        }
        update();
        hide(true);
    }

    public final void onWindowFocusChanged(boolean hasFocus) {
        AbstractC8014b.m7211m("onWindowFocusChanged ", hasFocus, SOLogger.INSTANCE, TAG);
        if (hasFocus) {
            return;
        }
        hide(true);
    }

    public final void show(int type) {
        HashMap<Integer, SettingLayout> map = this.mSettingMap;
        SettingViewState settingViewState = null;
        if (map == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mSettingMap");
            map = null;
        }
        SettingLayout settingLayout = map.get(Integer.valueOf(type));
        if (settingLayout != null) {
            settingLayout.show();
        }
        SettingViewState settingViewState2 = this.mSettingViewState;
        if (settingViewState2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mSettingViewState");
            settingViewState2 = null;
        }
        settingViewState2.setSettingViewKey(type);
        SettingViewState settingViewState3 = this.mSettingViewState;
        if (settingViewState3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mSettingViewState");
        } else {
            settingViewState = settingViewState3;
        }
        settingViewState.setSettingViewVisibility(0);
        IMenuItemManager iMenuItemManager = this.mMenuItemManager;
        if (iMenuItemManager != null) {
            iMenuItemManager.addPreTouchListener(this.mPreTouchListener);
        }
    }

    public final void update() {
        HashMap<Integer, SettingLayout> map = this.mSettingMap;
        if (map == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mSettingMap");
            map = null;
        }
        Iterator<Map.Entry<Integer, SettingLayout>> it = map.entrySet().iterator();
        while (it.hasNext()) {
            SettingLayout value = it.next().getValue();
            if (value != null) {
                value.update(false);
            }
        }
    }
}
