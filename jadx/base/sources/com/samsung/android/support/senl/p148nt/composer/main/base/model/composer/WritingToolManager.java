package com.samsung.android.support.senl.p148nt.composer.main.base.model.composer;

import android.content.SharedPreferences;
import android.graphics.PointF;
import android.graphics.RectF;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.collection.AbstractC0622a;
import com.samsung.android.sdk.composer.writing.ISpenNoteWritingViewManager;
import com.samsung.android.sdk.pen.SpenSettingRemoverInfo;
import com.samsung.android.sdk.pen.SpenSettingSelectionInfo;
import com.samsung.android.sdk.pen.SpenSettingUIChangeStyleInfo;
import com.samsung.android.sdk.pen.SpenSettingUIPenInfo;
import com.samsung.android.sdk.pen.base.SpenObjectFindType;
import com.samsung.android.sdk.pen.document.SpenObjectBase;
import com.samsung.android.sdk.pen.engine.SpenColorPickerListener;
import com.samsung.android.sdk.pen.engine.SpenRecentColorListener;
import com.samsung.android.sdk.pen.engine.SpenRemoverListener;
import com.samsung.android.sdk.pen.recoguifeature.alignment.ISPenAlignmentManager;
import com.samsung.android.sdk.pen.recoguifeature.converttotext.ISpenConvertToTextManager;
import com.samsung.android.sdk.pen.recoguifeature.converttotext.SpenAutoFormatListener;
import com.samsung.android.sdk.pen.recoguifeature.hwrbeautifier.SPenHwrBeautifierManager;
import com.samsung.android.sdk.pen.recoguifeature.math.SpenMathManager;
import com.samsung.android.sdk.pen.recoguifeature.spentotext.ISPenSTTManager;
import com.samsung.android.sdk.pen.worddoc.SpenWNote;
import com.samsung.android.support.senl.p145cm.base.framework.content.SharedPreferencesCompat;
import com.samsung.android.support.senl.p148nt.app.addons.AbstractC8014b;
import com.samsung.android.support.senl.p148nt.base.common.ApplicationManager;
import com.samsung.android.support.senl.p148nt.base.common.constants.SettingsConstants;
import com.samsung.android.support.senl.p148nt.base.common.p151ai.common.Features;
import com.samsung.android.support.senl.p148nt.base.composer.common.ComposerSpenUtils;
import com.samsung.android.support.senl.p148nt.base.extension.stickymemo.composer.control.ToolShareControl;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.common.LanguageUtil;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.p155ai.drawing.common.AiDrawingUtil;
import com.samsung.android.support.senl.p148nt.composer.main.base.util.FeatureInfo;
import com.samsung.android.support.senl.p148nt.composer.main.base.util.Logger;
import com.samsung.android.support.senl.p148nt.composer.main.common.presenter.keyguard.KeyguardPresenter;
import com.samsung.android.support.senl.p148nt.model.collector.recognition.extractor.TextRecognitionLanguage;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes3.dex */
public class WritingToolManager {
    public static final int ACTION_AUTO_CLEAN_UP = 19;
    public static final int ACTION_CHANGESTYLE = 13;
    public static final int ACTION_GESTURE = 1;
    public static final int ACTION_HIGHLIGHTER = 3;
    public static final int ACTION_LASER_PEN = 18;
    public static final int ACTION_MATH = 15;
    public static final int ACTION_NONE = 0;
    public static final int ACTION_RECOGNITION = 12;
    public static final int ACTION_SELECTION = 10;
    public static final int ACTION_SPEN_TO_TEXT = 16;
    public static final int ACTION_STRAIGHT_HIGHLIGHTER = 4;
    public static final int ACTION_STROKE = 2;
    public static final int ACTION_STROKE_REMOVER = 8;
    public static final int ACTION_TYPE_COLOR_PICKER = 9;
    private static final String TAG = Logger.createTag("WritingToolManager");
    public static final int TOOL_ERASER = 4;
    public static final int TOOL_FINGER = 1;
    public static final int TOOL_MOUSE = 3;
    public static final int TOOL_PEN_BUTTTON = 6;
    public static final int TOOL_SPEN = 2;
    public static final int TOOL_UNKNOWN = 0;
    private ConvertToTextCancelListener mConvertToTextCancelListener;
    private boolean mInit;
    private final KeyguardPresenter mKeyguardPresenter;
    private int mLastAction;
    private SPenHwrBeautifierManager mSPenHwrBeautifierManager;
    private SpenMathManager mSPenMathManager;
    private ISPenAlignmentManager mSpenAlignmentManager;
    private ISpenConvertToTextManager mSpenConvertToTextManager;
    private ISpenNoteWritingViewManager mSpenNoteWritingViewManager;
    private ISPenSTTManager mSpenSTTManager;
    private ToolShareControl mToolShareControl;
    private SpenWNote mWNote;
    private final ArrayList<BeautifierLanguageListener> mBeautifierLanguageListenerList = new ArrayList<>();
    private final ArrayList<CTTLanguageListener> mCTTLanguageListener = new ArrayList<>();
    private boolean mIsSupportedSpenDisplay = false;
    private boolean mIsNotDexModeOrStandAloneMode = false;
    private boolean mIsOnAutoCleanUp = false;
    private boolean mIsEnableAiDrawing = false;

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public interface BeautifierLanguageListener {
        void onLanguageChanged(String str);
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public interface CTTLanguageListener {
        void onLanguageChanged();

        void onPreLanguageChanged(CharSequence charSequence);
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public interface ConvertToTextCancelListener {
        void onCTTClosed();
    }

    public WritingToolManager(@NonNull KeyguardPresenter keyguardPresenter) {
        this.mKeyguardPresenter = keyguardPresenter;
    }

    private String isOX(boolean z) {
        return z ? "O" : "X";
    }

    public void addBeautifierLanguageListener(BeautifierLanguageListener beautifierLanguageListener) {
        this.mBeautifierLanguageListenerList.add(beautifierLanguageListener);
    }

    public void addCTTLanguageListener(CTTLanguageListener cTTLanguageListener) {
        this.mCTTLanguageListener.add(cTTLanguageListener);
    }

    public void applySpenAlignmentLanguage() {
        String string;
        if (this.mInit) {
            if (FeatureInfo.isBeautifierFeatureEnabled()) {
                string = getBeautifierLanguage();
                Logger.m11003i(TAG, "applySpenAlignmentLanguage use Beautifier language");
            } else {
                string = SharedPreferencesCompat.getInstance("Settings").getString(SettingsConstants.SETTINGS_HANDWRITING_RECOGNITION_LANGUAGE, null);
            }
            if (TextUtils.isEmpty(string)) {
                Logger.m11003i(TAG, "applySpenAlignmentLanguage# currentLanguage is null");
            } else {
                AbstractC8014b.m7197C("applySpenAlignmentLanguage# ", string, TAG);
                this.mSpenAlignmentManager.updateLanguage(string);
            }
        }
    }

    public boolean cancel() {
        if (!this.mInit) {
            return false;
        }
        Logger.m11003i(TAG, "cancel");
        return this.mSpenAlignmentManager.cancel();
    }

    public boolean cancelConvertToText() {
        return cancelConvertToText(true);
    }

    public void clearControl() {
        cancelConvertToText();
        cancel();
    }

    public void clearSelection() {
        if (this.mInit) {
            this.mWNote.selectObject((SpenObjectBase) null);
        }
    }

    public void commitHistory() {
        SpenWNote spenWNote = this.mWNote;
        if (spenWNote != null) {
            spenWNote.commitHistory();
        }
    }

    public boolean confirm() {
        if (!this.mInit) {
            return false;
        }
        Logger.m11003i(TAG, "confirm");
        return this.mSpenAlignmentManager.confirm();
    }

    public boolean executeAlignment() {
        if (!this.mInit) {
            return false;
        }
        applySpenAlignmentLanguage();
        Logger.m11003i(TAG, "executeAlignment");
        return this.mSpenAlignmentManager.executeAlignment();
    }

    public boolean executeAutoFormatAnalyze() {
        if (this.mInit) {
            return this.mSpenConvertToTextManager.executeAutoFormatAnalyze();
        }
        return false;
    }

    public boolean executeAutoFormatExtractText() {
        if (this.mInit) {
            return this.mSpenConvertToTextManager.executeAutoFormatExtractText();
        }
        return false;
    }

    public boolean executeAutoFormatRecognize(ArrayList<RectF> arrayList) {
        if (this.mInit) {
            return this.mSpenConvertToTextManager.executeAutoFormatRecognize(arrayList);
        }
        return false;
    }

    public boolean executeCleanUp() {
        if (!this.mInit) {
            return false;
        }
        applySpenAlignmentLanguage();
        Logger.m11003i(TAG, "executeCleanUp");
        return this.mSpenAlignmentManager.executeCleanUp();
    }

    public boolean executeConvertToText(String str) {
        if (!this.mInit) {
            return false;
        }
        this.mSpenConvertToTextManager.updateLanguage(str);
        return this.mSpenConvertToTextManager.executeConvertToText();
    }

    public boolean executeExtractMath() {
        if (this.mInit) {
            return this.mSpenConvertToTextManager.executeAutoFormat();
        }
        return false;
    }

    public boolean executeExtractText(String str) {
        if (!this.mInit) {
            return false;
        }
        this.mSpenConvertToTextManager.updateLanguage(str);
        return this.mSpenConvertToTextManager.executeExtractText();
    }

    public boolean executeSelectionAlignment() {
        if (!this.mInit) {
            return false;
        }
        applySpenAlignmentLanguage();
        return this.mSpenAlignmentManager.executeSelectionAlignment();
    }

    public boolean executeSelectionCleanUp() {
        if (!this.mInit) {
            return false;
        }
        Logger.m11003i(TAG, "executeSelectionCleanUp");
        return this.mSpenAlignmentManager.executeSelectionCleanUp();
    }

    public String getBeautifierLanguage() {
        try {
            return LanguageUtil.getCleanUpHandwritingLanguage(ApplicationManager.getInstance().getAppContext());
        } catch (TextRecognitionLanguage.SupportedLanguageException e) {
            Logger.m11000e(TAG, "startHwSelection# " + e.getMessage());
            return null;
        }
    }

    @NonNull
    public KeyguardPresenter getKeyguardPresenter() {
        return this.mKeyguardPresenter;
    }

    public int getPageCount() {
        SpenWNote spenWNote = this.mWNote;
        if (spenWNote != null) {
            return spenWNote.getPageCount();
        }
        return -1;
    }

    @NonNull
    public List<SpenObjectBase> getSelectedStrokeList() {
        ArrayList arrayList = new ArrayList();
        ArrayList<SpenObjectBase> selectedObject = this.mWNote.getSelectedObject();
        if (selectedObject != null) {
            for (SpenObjectBase spenObjectBase : selectedObject) {
                if (spenObjectBase.getType() == 1 || spenObjectBase.getType() == 7 || spenObjectBase.getType() == 8) {
                    arrayList.add(spenObjectBase);
                }
            }
        }
        return arrayList;
    }

    public int getToolTypeAction(int i) {
        if (this.mInit) {
            return this.mSpenNoteWritingViewManager.getToolTypeAction(i);
        }
        return 0;
    }

    public int getWNoteHeight() {
        SpenWNote spenWNote = this.mWNote;
        if (spenWNote != null) {
            return spenWNote.getHeight();
        }
        return 0;
    }

    public int getWNoteWidth() {
        SpenWNote spenWNote = this.mWNote;
        if (spenWNote != null) {
            return spenWNote.getWidth();
        }
        return 0;
    }

    public void initDone() {
        this.mInit = true;
    }

    public boolean isAlignmentRunning() {
        if (this.mInit) {
            return this.mSpenAlignmentManager.isRunning();
        }
        return false;
    }

    public boolean isBeautifierSupportedLanguage() {
        return SPenHwrBeautifierManager.getBeautifierSupportedLanguages(ApplicationManager.getInstance().getAppContext()).contains(getBeautifierLanguage());
    }

    public boolean isEditing() {
        if (this.mInit) {
            return this.mSpenConvertToTextManager.isEditing();
        }
        return false;
    }

    public boolean isFloatingViewShown() {
        if (this.mInit) {
            return this.mSpenConvertToTextManager.isFloatingViewShown();
        }
        return false;
    }

    public boolean isSinglePageMode() {
        SpenWNote spenWNote = this.mWNote;
        return spenWNote != null && spenWNote.getPageMode() == SpenWNote.PageMode.SINGLE;
    }

    public boolean isSpenOnlyMode() {
        if (!ComposerSpenUtils.canUseSpen(this.mIsSupportedSpenDisplay, this.mIsNotDexModeOrStandAloneMode)) {
            return false;
        }
        boolean z = SharedPreferencesCompat.getInstance("Settings").getBoolean("settings_spen_only_mode", true);
        AbstractC8014b.m7220v("isSpenOnlyMode# ", TAG, z);
        return z;
    }

    public boolean isSupportedSpenDisplay() {
        return this.mIsSupportedSpenDisplay;
    }

    public void release() {
        this.mInit = false;
        if (this.mSpenNoteWritingViewManager != null) {
            Logger.m11003i(TAG, "set Listener null");
            this.mSpenNoteWritingViewManager.setColorPickerListener(null);
            this.mSpenNoteWritingViewManager.setRecentColorListener(null);
            this.mSpenNoteWritingViewManager.setRemoverListener(null);
            this.mSpenNoteWritingViewManager.close();
            this.mSpenNoteWritingViewManager = null;
        }
        ISpenConvertToTextManager iSpenConvertToTextManager = this.mSpenConvertToTextManager;
        if (iSpenConvertToTextManager != null) {
            iSpenConvertToTextManager.setAutoFormatListener(null);
            this.mSpenConvertToTextManager = null;
        }
        SpenMathManager spenMathManager = this.mSPenMathManager;
        if (spenMathManager != null) {
            spenMathManager.close();
        }
        this.mSpenAlignmentManager = null;
        this.mSpenSTTManager.setListener(null);
        this.mSpenSTTManager = null;
    }

    public void removeBeautifierLanguageListener(BeautifierLanguageListener beautifierLanguageListener) {
        this.mBeautifierLanguageListenerList.remove(beautifierLanguageListener);
    }

    public void removeCTTLanguageListener(CTTLanguageListener cTTLanguageListener) {
        this.mCTTLanguageListener.remove(cTTLanguageListener);
    }

    public void requestSPenToTextAction(int i) {
        if (this.mInit) {
            AbstractC8014b.m7217s(i, "requestDirectWritingAction ", TAG);
            this.mSpenSTTManager.requestSPenToTextAction(i);
        }
    }

    public boolean restoreAutoFormatAnalyze(ArrayList<RectF> arrayList) {
        if (this.mInit) {
            return this.mSpenConvertToTextManager.executeAutoFormatAnalyze(arrayList, true);
        }
        return false;
    }

    public void restoreAutoFormatRecognize(ArrayList<RectF> arrayList) {
        if (this.mInit) {
            this.mSpenConvertToTextManager.executeAutoFormatRecognize(arrayList, true);
        }
    }

    public void selectMaximumForText() {
        if (this.mInit) {
            this.mSpenConvertToTextManager.maxAutoFormatAnalyze();
        }
    }

    public void selectNextPageForText() {
        if (this.mInit) {
            this.mSpenConvertToTextManager.nextAutoFormatAnalyze();
        }
    }

    public void setAlignmentOptions(boolean z, boolean z2, boolean z3, boolean z4) {
        if (this.mInit) {
            boolean z5 = false;
            if (!FeatureInfo.isBeautifierFeatureEnabled()) {
                this.mSpenAlignmentManager.setBeautificationOptions(false, false, false);
                return;
            }
            boolean zIsBeautifierSupportedLanguage = isBeautifierSupportedLanguage();
            boolean z6 = z2 && zIsBeautifierSupportedLanguage;
            boolean z7 = z3 && zIsBeautifierSupportedLanguage;
            if (z4 && zIsBeautifierSupportedLanguage) {
                z5 = true;
            }
            applySpenAlignmentLanguage();
            Logger.m11003i(TAG, "Beautification#setAlignmentOptions# " + isOX(z) + " " + isOX(z6) + " " + isOX(z7) + " " + isOX(z5));
            this.mSpenAlignmentManager.setBeautificationOptions(z5, z6, z7, z);
        }
    }

    public void setAssistanceOptions(boolean z, boolean z2) {
        if (this.mInit) {
            if (!FeatureInfo.isHandwritingHelpEnabled(ApplicationManager.getInstance().getAppContext())) {
                Logger.m11003i(TAG, "setAssistanceOptions# Assistance Not Supported");
                return;
            }
            boolean zIsBeautifierSupportedLanguage = isBeautifierSupportedLanguage();
            boolean z3 = z && zIsBeautifierSupportedLanguage;
            boolean z4 = z2 && zIsBeautifierSupportedLanguage;
            if (z3 || z4) {
                setBeautifierLanguage(getBeautifierLanguage(), false);
            }
            Logger.m11003i(TAG, "Beautification#setAssistanceOptions# " + isOX(z3) + " " + isOX(z4) + " isSupportedLanguage " + zIsBeautifierSupportedLanguage);
            this.mSPenHwrBeautifierManager.setAutoCleanUpOptions(z4, z3, false);
            boolean z5 = z4 || z3;
            boolean z6 = this.mIsOnAutoCleanUp;
            if (!z6 && z5) {
                this.mIsOnAutoCleanUp = true;
                setToolTypeAction(2, 19);
            } else if (z6 && !z5) {
                this.mIsOnAutoCleanUp = false;
                setToolTypeAction(2, this.mLastAction);
            }
            this.mSPenHwrBeautifierManager.setAutoCleanUpEnabled(this.mIsOnAutoCleanUp);
        }
    }

    public void setAutoFormatListener(SpenAutoFormatListener spenAutoFormatListener) {
        if (this.mInit) {
            this.mSpenConvertToTextManager.setAutoFormatListener(spenAutoFormatListener);
        }
    }

    public void setBeautifierLanguage(String str, boolean z) {
        LanguageUtil.setCleanUpHandwritingLanguage(str);
        if (this.mInit) {
            AbstractC8014b.m7196B("setBeautifierLanguage# ", str, TAG);
            this.mSPenHwrBeautifierManager.updateLanguage(str);
            if (z) {
                Iterator<BeautifierLanguageListener> it = this.mBeautifierLanguageListenerList.iterator();
                while (it.hasNext()) {
                    it.next().onLanguageChanged(str);
                }
            }
        }
    }

    public void setChangeStyleSettingInfo(SpenSettingUIChangeStyleInfo spenSettingUIChangeStyleInfo) {
        if (this.mInit) {
            ToolShareControl toolShareControl = this.mToolShareControl;
            if (toolShareControl != null) {
                toolShareControl.setChangeStyleSettingInfo(spenSettingUIChangeStyleInfo);
            }
            this.mSpenNoteWritingViewManager.setChangeStyleSettingInfo(spenSettingUIChangeStyleInfo);
        }
    }

    public void setColorPickerListener(SpenColorPickerListener spenColorPickerListener) {
        Logger.m11003i(TAG, "setColorPickerListener");
        if (this.mInit) {
            this.mSpenNoteWritingViewManager.setColorPickerListener(spenColorPickerListener);
        }
    }

    public void setConnectedSelection() {
        if (this.mWNote.isClosed() || this.mSpenNoteWritingViewManager == null) {
            return;
        }
        if (Features.isCreativeStudioSupported()) {
            this.mSpenNoteWritingViewManager.setSelectionObjectType(133);
        } else if (AiDrawingUtil.isDrawingToolkitUsed()) {
            this.mSpenNoteWritingViewManager.setSelectionObjectType(129);
        } else {
            this.mSpenNoteWritingViewManager.setSelectionObjectType(193);
        }
        this.mSpenNoteWritingViewManager.setConnectedSelection(true);
    }

    public void setConnectedSelectionAsDefault() {
        ISpenNoteWritingViewManager iSpenNoteWritingViewManager;
        if (this.mWNote.isClosed() || (iSpenNoteWritingViewManager = this.mSpenNoteWritingViewManager) == null) {
            return;
        }
        iSpenNoteWritingViewManager.setSelectionObjectType(SpenObjectFindType.ALL);
        this.mSpenNoteWritingViewManager.setConnectedSelection(false);
    }

    public void setConvertToTextCancelListener(ConvertToTextCancelListener convertToTextCancelListener) {
        this.mConvertToTextCancelListener = convertToTextCancelListener;
    }

    public void setDoc(SpenWNote spenWNote) {
        this.mWNote = spenWNote;
    }

    public void setEnableAiDrawing(boolean z) {
        if (this.mInit) {
            this.mIsEnableAiDrawing = z;
            int toolTypeAction = z ? getToolTypeAction(2) : 1;
            setToolTypeAction(0, toolTypeAction);
            setToolTypeAction(1, toolTypeAction);
        }
    }

    public void setFocusSelectedObjects(boolean z) {
        if (this.mInit) {
            this.mSpenNoteWritingViewManager.setFocusSelectedObjects(z);
        }
    }

    public void setInputFormEnabled() {
        if (isSpenOnlyMode()) {
            this.mSpenNoteWritingViewManager.setToolTypeAction(1, 1);
            this.mSpenNoteWritingViewManager.setToolTypeAction(0, 1);
        }
    }

    public void setLastPenInfo(SpenSettingUIPenInfo spenSettingUIPenInfo) {
        SpenWNote spenWNote = this.mWNote;
        if (spenWNote == null || spenWNote.isClosed()) {
            return;
        }
        this.mWNote.setLastPenInfo(spenSettingUIPenInfo);
    }

    public WritingToolManager setManager(ISpenNoteWritingViewManager iSpenNoteWritingViewManager) {
        this.mSpenNoteWritingViewManager = iSpenNoteWritingViewManager;
        return this;
    }

    public void setNotDexModeOrStandAloneMode(boolean z) {
        this.mIsNotDexModeOrStandAloneMode = z;
    }

    public void setPenSettingInfo(SpenSettingUIPenInfo spenSettingUIPenInfo) {
        if (this.mInit) {
            ToolShareControl toolShareControl = this.mToolShareControl;
            if (toolShareControl != null) {
                toolShareControl.setPenSettingInfo(spenSettingUIPenInfo);
            }
            this.mSpenNoteWritingViewManager.setPenSettingInfo(spenSettingUIPenInfo);
        }
    }

    public void setRecentColorListener(SpenRecentColorListener spenRecentColorListener) {
        Logger.m11003i(TAG, "setRecentColorListener " + spenRecentColorListener);
        if (this.mInit) {
            this.mSpenNoteWritingViewManager.setRecentColorListener(spenRecentColorListener);
        }
    }

    public void setRemoverListener(SpenRemoverListener spenRemoverListener) {
        Logger.m11003i(TAG, "setRemoverListener");
        if (this.mInit) {
            this.mSpenNoteWritingViewManager.setRemoverListener(spenRemoverListener);
        }
    }

    public void setRemoverSettingInfo(SpenSettingRemoverInfo spenSettingRemoverInfo) {
        if (this.mInit) {
            ToolShareControl toolShareControl = this.mToolShareControl;
            if (toolShareControl != null) {
                toolShareControl.setRemoverSettingInfo(spenSettingRemoverInfo);
            }
            this.mSpenNoteWritingViewManager.setRemoverSettingInfo(spenSettingRemoverInfo);
        }
    }

    public void setSPenToTextEnable(boolean z) {
        if (this.mInit) {
            this.mSpenSTTManager.setEnabled(z);
        }
    }

    public void setSPenToTextTargetMode(int i) {
        if (this.mInit) {
            this.mSpenSTTManager.setTargetMode(i);
        }
    }

    public void setSPenToTextTextColor(int i, int i2) {
        if (this.mInit) {
            this.mSpenSTTManager.setTextColor(i, i2);
        }
    }

    public void setSelectionPenStyleAsDefault() {
        ISpenNoteWritingViewManager iSpenNoteWritingViewManager;
        if (this.mWNote.isClosed() || (iSpenNoteWritingViewManager = this.mSpenNoteWritingViewManager) == null) {
            return;
        }
        iSpenNoteWritingViewManager.setSelectionPenStyleAsDefault();
    }

    public void setSelectionPenStyleAsGradient() {
        if (this.mWNote.isClosed() || this.mSpenNoteWritingViewManager == null) {
            return;
        }
        ArrayList<Integer> arrayList = new ArrayList<>();
        arrayList.add(-859964763);
        arrayList.add(-863443229);
        arrayList.add(-868317701);
        this.mSpenNoteWritingViewManager.setSelectionPenStyle(45.0f, arrayList, true);
    }

    public void setSelectionSettingInfo(@NonNull SpenSettingSelectionInfo spenSettingSelectionInfo) {
        if (this.mInit) {
            ToolShareControl toolShareControl = this.mToolShareControl;
            if (toolShareControl != null) {
                toolShareControl.setSelectionSettingInfo(spenSettingSelectionInfo);
            }
            this.mSpenNoteWritingViewManager.setSelectionType(spenSettingSelectionInfo.type);
            this.mSpenNoteWritingViewManager.setIntersectSelection(spenSettingSelectionInfo.includePartiallySelected);
        }
    }

    public void setSpenOnlyMode(boolean z) {
        AbstractC8014b.m7220v("setSpenOnlyMode# ", TAG, z);
        if (ComposerSpenUtils.canUseSpen(this.mIsSupportedSpenDisplay, this.mIsNotDexModeOrStandAloneMode)) {
            SharedPreferences.Editor editorEdit = SharedPreferencesCompat.getInstance("Settings").edit();
            editorEdit.putBoolean("settings_spen_only_mode", z);
            editorEdit.apply();
            if (getToolTypeAction(2) == 16) {
                return;
            }
            int toolTypeAction = z ? 1 : getToolTypeAction(2);
            setToolTypeAction(0, toolTypeAction);
            setToolTypeAction(1, toolTypeAction);
        }
    }

    public void setSupportedSpenDisplay(boolean z) {
        this.mIsSupportedSpenDisplay = z;
    }

    public void setToolShareControl(ToolShareControl toolShareControl) {
        this.mToolShareControl = toolShareControl;
    }

    public void setToolTypeAction(int i, int i2) {
        if (this.mInit) {
            if (i == 2 && i2 != 19 && i2 != 9) {
                this.mLastAction = i2;
            }
            String str = TAG;
            StringBuilder sbM1173s = AbstractC0622a.m1173s(i, i2, "setToolTypeAction# type = ", " / action = ", " / mIsOnAutoCleanUp = ");
            sbM1173s.append(this.mIsOnAutoCleanUp);
            sbM1173s.append(" / mIsEnableAiDrawing = ");
            AbstractC8014b.m7222x(sbM1173s, this.mIsEnableAiDrawing, str);
            if (this.mIsOnAutoCleanUp && i2 == 2) {
                i2 = 19;
            }
            setToolTypeActionWrap(i, i2);
            if (i != 2) {
                if (i == 6) {
                    setToolTypeActionWrap(4, i2);
                    return;
                }
                return;
            }
            setToolTypeActionWrap(3, i2);
            if (i2 == 16 || (ComposerSpenUtils.canUseSpen(this.mIsSupportedSpenDisplay, this.mIsNotDexModeOrStandAloneMode) && isSpenOnlyMode() && !this.mIsEnableAiDrawing)) {
                setToolTypeActionWrap(1, 1);
                setToolTypeActionWrap(0, 1);
            } else {
                setToolTypeActionWrap(1, i2);
                setToolTypeActionWrap(0, i2);
            }
        }
    }

    public void setToolTypeActionWrap(int i, int i2) {
        ToolShareControl toolShareControl = this.mToolShareControl;
        if (toolShareControl != null) {
            toolShareControl.setToolTypeAction(i, i2);
        }
        this.mSpenNoteWritingViewManager.setToolTypeAction(i, i2);
    }

    public void updateLanguage(CharSequence charSequence) {
        if (this.mInit) {
            Iterator<CTTLanguageListener> it = this.mCTTLanguageListener.iterator();
            while (it.hasNext()) {
                it.next().onPreLanguageChanged(charSequence);
            }
            this.mSpenConvertToTextManager.updateLanguage(charSequence);
            Iterator<CTTLanguageListener> it2 = this.mCTTLanguageListener.iterator();
            while (it2.hasNext()) {
                it2.next().onLanguageChanged();
            }
        }
    }

    public void updateSTTRecognitionLanguage(CharSequence charSequence) {
        if (this.mInit) {
            this.mSpenSTTManager.updateRecognitionLanguage(charSequence);
        }
    }

    public boolean cancelConvertToText(boolean z) {
        ConvertToTextCancelListener convertToTextCancelListener;
        if (!this.mInit) {
            return false;
        }
        boolean zCancelConvertToText = this.mSpenConvertToTextManager.cancelConvertToText();
        if (z && zCancelConvertToText && (convertToTextCancelListener = this.mConvertToTextCancelListener) != null) {
            convertToTextCancelListener.onCTTClosed();
        }
        return zCancelConvertToText;
    }

    public WritingToolManager setManager(ISpenConvertToTextManager iSpenConvertToTextManager) {
        this.mSpenConvertToTextManager = iSpenConvertToTextManager;
        return this;
    }

    public WritingToolManager setManager(ISPenAlignmentManager iSPenAlignmentManager) {
        this.mSpenAlignmentManager = iSPenAlignmentManager;
        return this;
    }

    public boolean executeConvertToText(PointF pointF, String str) {
        if (!this.mInit) {
            return false;
        }
        this.mSpenConvertToTextManager.updateLanguage(str);
        return this.mSpenConvertToTextManager.executeConvertToTextFromPoint(pointF);
    }

    public WritingToolManager setManager(ISPenSTTManager iSPenSTTManager) {
        this.mSpenSTTManager = iSPenSTTManager;
        return this;
    }

    public void executeCleanUp(ArrayList<RectF> arrayList) {
        if (this.mInit) {
            this.mSpenAlignmentManager.executeCleanUp(arrayList);
        }
    }

    public WritingToolManager setManager(SPenHwrBeautifierManager sPenHwrBeautifierManager) {
        this.mSPenHwrBeautifierManager = sPenHwrBeautifierManager;
        return this;
    }

    public WritingToolManager setManager(SpenMathManager spenMathManager) {
        this.mSPenMathManager = spenMathManager;
        return this;
    }
}
