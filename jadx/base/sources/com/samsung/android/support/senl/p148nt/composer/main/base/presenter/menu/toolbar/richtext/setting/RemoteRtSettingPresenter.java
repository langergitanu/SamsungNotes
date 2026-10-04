package com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.toolbar.richtext.setting;

import com.google.android.gms.common.data.AbstractC4539a;
import com.samsung.android.support.senl.p148nt.app.addons.AbstractC8014b;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.toolbar.remotefunction.RemoteConstant;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.toolbar.remotefunction.RemoteFunctionContract;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.toolbar.richtext.RtToolbarContract;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.toolbar.richtext.setting.RtSettingContract;
import com.samsung.android.support.senl.p148nt.composer.main.base.util.Logger;
import java.lang.reflect.Field;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes3.dex */
public class RemoteRtSettingPresenter extends RtSettingPresenter implements RemoteFunctionContract.TargetClassContract {
    private static final String TAG = Logger.createTag("RemoteRtSettingPresenter");
    private final String mClassName;
    private ColorData mColor;
    private final RemoteFunctionContract.PresenterContract mRemoteFunctionPresenter;
    protected RtSettingContract.ISettingView mSettingView;
    private RtSettingPresenter mSuperClass;

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static class ColorData {
        int backgroundColor;
        int fontBgColor;
        int fontColor;
        boolean isDarkTheme;

        public /* synthetic */ ColorData(int i) {
            this();
        }

        private ColorData() {
            this.fontColor = -1;
            this.fontBgColor = -1;
            this.backgroundColor = -1;
        }
    }

    public RemoteRtSettingPresenter(RtSettingPresenter rtSettingPresenter, RemoteFunctionContract.PresenterContract presenterContract) {
        this.mClassName = "RemoteRtSettingPresenter";
        int i = 0;
        this.mColor = new ColorData(i);
        Field[] declaredFields = rtSettingPresenter.getClass().getDeclaredFields();
        int length = declaredFields.length;
        while (i < length) {
            Field field = declaredFields[i];
            try {
                field.setAccessible(true);
                field.set(this, field.get(rtSettingPresenter));
            } catch (IllegalAccessException e) {
                Logger.m11000e(TAG, "construct error " + e.getMessage());
            }
            i++;
        }
        this.mSettingView = new RtSettingContract.NullSettingView();
        this.mRemoteFunctionPresenter = presenterContract;
        this.mSuperClass = rtSettingPresenter;
    }

    private void updateRtState() {
        RtToolbarContract.IPresenter iPresenter = this.mRtPresenter;
        iPresenter.updateState(iPresenter.getLastRtState());
    }

    public RtSettingPresenter getSuperClass() {
        return this.mSuperClass;
    }

    @Override // com.samsung.android.support.senl.nt.composer.main.base.presenter.menu.toolbar.remotefunction.RemoteFunctionContract.TargetClassContract
    @RemoteConstant.RemoteSenderType(2)
    @RemoteConstant.RemoteReceiverFunctionName("toolbarSynchronization")
    @RemoteConstant.RemoteFunctionName("init")
    public void init() {
        Logger.m11003i(TAG, "init");
        this.mRemoteFunctionPresenter.remoteFunctionSync(this.mClassName, "init", new Object[0]);
    }

    @RemoteConstant.RemoteFunctionName("receiveSyncPaletteInfo")
    public void receiveSyncPaletteInfo(List<Integer> list, int i, boolean z) {
        this.mSettingView.createPalette(list, i, z);
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.toolbar.richtext.setting.RtSettingPresenter
    @RemoteConstant.RemoteSenderType(4)
    @RemoteConstant.RemoteFunctionName("setEnableMenus")
    public void setEnableMenus(boolean z, List<Integer> list) {
        super.setEnableMenus(z, list);
        this.mRemoteFunctionPresenter.remoteFunctionSync(this.mClassName, "setEnableMenus", Boolean.valueOf(z), list);
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.toolbar.richtext.setting.RtSettingPresenter
    @RemoteConstant.RemoteSenderType(6)
    @RemoteConstant.RemoteFunctionName("setPaletteList")
    public void setPaletteList(List<Integer> list) {
        if (this.mRemoteFunctionPresenter.getRemoteType() == 4) {
            super.setPaletteList(list);
        } else {
            this.mSettingView.onPaletteListChanged(list);
        }
        this.mRemoteFunctionPresenter.remoteFunctionSync(this.mClassName, "setPaletteList", list);
    }

    public void setSettingView(RtSettingContract.ISettingView iSettingView) {
        this.mSettingView = iSettingView;
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.toolbar.richtext.setting.RtSettingPresenter
    @RemoteConstant.RemoteSenderType(2)
    @RemoteConstant.RemoteFunctionName("setTextBgColor")
    public void setTextBgColor(int i) {
        AbstractC8014b.m7217s(i, "setTextBgColor ", TAG);
        super.setTextBgColor(i);
        if (this.mRemoteFunctionPresenter.getRemoteType() == 4 && this.mRemoteFunctionPresenter.isRemotedFunctionCall()) {
            this.mColor.fontBgColor = i;
            updateRtState();
        }
        this.mRemoteFunctionPresenter.remoteFunctionSync(this.mClassName, "setTextBgColor", Integer.valueOf(i));
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.toolbar.richtext.setting.RtSettingPresenter
    @RemoteConstant.RemoteSenderType(2)
    @RemoteConstant.RemoteFunctionName("setTextColor")
    public void setTextColor(int i) {
        AbstractC8014b.m7217s(i, "setTextColor ", TAG);
        super.setTextColor(i);
        if (this.mRemoteFunctionPresenter.getRemoteType() == 4 && this.mRemoteFunctionPresenter.isRemotedFunctionCall()) {
            this.mColor.fontColor = i;
            updateRtState();
        }
        this.mRemoteFunctionPresenter.remoteFunctionSync(this.mClassName, "setTextColor", Integer.valueOf(i));
    }

    @RemoteConstant.RemoteSenderType(4)
    @RemoteConstant.RemoteReceiverFunctionName("receiveSyncPaletteInfo")
    @RemoteConstant.RemoteFunctionName("syncPaletteInfo")
    public void syncPaletteInfo() {
        this.mRemoteFunctionPresenter.remoteFunctionSync(this.mClassName, "syncPaletteInfo", getPaletteList(), Integer.valueOf(getBackgroundColor()), Boolean.valueOf(getIsViewDarkTheme()));
    }

    @RemoteConstant.RemoteFunctionName("toolbarSynchronization")
    public void toolbarSynchronization() {
        syncPaletteInfo();
        this.mRemoteFunctionPresenter.remoteFunctionCall(this.mClassName, "updateFontColor", Integer.valueOf(getFontColor()));
        this.mRemoteFunctionPresenter.remoteFunctionCall(this.mClassName, "updateFontBgColor", Integer.valueOf(getFontBgColor()));
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.toolbar.richtext.setting.RtSettingPresenter
    @RemoteConstant.RemoteSenderType(4)
    @RemoteConstant.RemoteFunctionName("updateBackgroundColor")
    public void updateBackgroundColor(int i) {
        AbstractC8014b.m7217s(i, "updateBackgroundColor ", TAG);
        this.mSettingView.updateBackgroundColor(i);
        ColorData colorData = this.mColor;
        if (colorData.backgroundColor != i) {
            colorData.backgroundColor = i;
            this.mRemoteFunctionPresenter.remoteFunctionSync(this.mClassName, "updateBackgroundColor", Integer.valueOf(i));
        }
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.toolbar.richtext.setting.RtSettingPresenter
    @RemoteConstant.RemoteSenderType(4)
    @RemoteConstant.RemoteFunctionName("updateFontBgColor")
    public void updateFontBgColor(int i) {
        RtToolbarContract.IPresenter iPresenter = this.mRtPresenter;
        if (iPresenter != null && iPresenter.isDirectWriteRecognizing()) {
            AbstractC8014b.m7217s(i, "skip font BG color while DW Recognizing", TAG);
            return;
        }
        AbstractC8014b.m7217s(i, "updateFontBgColor ", TAG);
        this.mSettingView.updateFontBgColor(i);
        ColorData colorData = this.mColor;
        if (colorData.fontBgColor != i) {
            colorData.fontBgColor = i;
            this.mRemoteFunctionPresenter.remoteFunctionSync(this.mClassName, "updateFontBgColor", Integer.valueOf(i));
        }
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.toolbar.richtext.setting.RtSettingPresenter
    @RemoteConstant.RemoteSenderType(4)
    @RemoteConstant.RemoteFunctionName("updateFontColor")
    public void updateFontColor(int i) {
        RtToolbarContract.IPresenter iPresenter = this.mRtPresenter;
        if (iPresenter != null && iPresenter.isDirectWriteRecognizing()) {
            AbstractC8014b.m7217s(i, "skip font color while DW Recognizing", TAG);
            return;
        }
        AbstractC8014b.m7217s(i, "updateFontColor ", TAG);
        this.mSettingView.updateFontColor(i);
        ColorData colorData = this.mColor;
        if (colorData.fontColor != i) {
            colorData.fontColor = i;
            this.mRemoteFunctionPresenter.remoteFunctionSync(this.mClassName, "updateFontColor", Integer.valueOf(i));
        }
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.toolbar.richtext.setting.RtSettingPresenter
    @RemoteConstant.RemoteSenderType(4)
    @RemoteConstant.RemoteFunctionName("updateViewTheme")
    public void updateViewTheme(boolean z) {
        AbstractC8014b.m7222x(AbstractC4539a.m3200j("updateViewTheme ", " / ", z), this.mColor.isDarkTheme, TAG);
        this.mSettingView.updateViewTheme(z);
        ColorData colorData = this.mColor;
        if (colorData.isDarkTheme != z) {
            colorData.isDarkTheme = z;
            this.mRemoteFunctionPresenter.remoteFunctionSync(this.mClassName, "updateViewTheme", Boolean.valueOf(z));
        }
    }

    public RemoteRtSettingPresenter(RemoteFunctionContract.PresenterContract presenterContract) {
        this.mClassName = "RemoteRtSettingPresenter";
        this.mColor = new ColorData(0);
        this.mSettingView = new RtSettingContract.NullSettingView();
        this.mRemoteFunctionPresenter = presenterContract;
    }
}
