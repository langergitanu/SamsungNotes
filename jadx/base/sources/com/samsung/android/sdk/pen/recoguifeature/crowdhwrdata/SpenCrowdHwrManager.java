package com.samsung.android.sdk.pen.recoguifeature.crowdhwrdata;

import android.content.Context;
import android.content.res.Configuration;
import android.view.MotionEvent;
import android.widget.Toast;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.samsung.android.sdk.pen.document.SpenNoteDoc;
import com.samsung.android.sdk.pen.document.SpenObjectBase;
import com.samsung.android.sdk.pen.document.SpenPageDoc;
import com.samsung.android.sdk.pen.document.changedInfo.SpenObjectChangedInfo;
import com.samsung.android.sdk.pen.engine.writingview.document.SpenWritingDocument;
import com.samsung.android.sdk.pen.engine.writingview.document.SpenWritingDocumentFactory;
import com.samsung.android.sdk.pen.recogengine.hwrsampler.SpenCrowdSource;
import com.samsung.android.sdk.pen.view.SpenDisplay;
import java.io.IOException;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes7.dex */
@Metadata(m13885d1 = {"\u0000l\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u000f\u0018\u0000 >2\u00020\u0001:\u0001>B\u0011\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0006\u0010\u001c\u001a\u00020\u001dJ\u000e\u0010\u001e\u001a\u00020\u001d2\u0006\u0010\u001f\u001a\u00020\u0016J\u0010\u0010 \u001a\u00020\u001a2\b\u0010!\u001a\u0004\u0018\u00010\"J.\u0010#\u001a\u00020\u001d2\u0006\u0010$\u001a\u00020\u001a2\u0006\u0010%\u001a\u00020\u00182\u0006\u0010&\u001a\u00020\u00182\u0006\u0010'\u001a\u00020\u00182\u0006\u0010(\u001a\u00020\u0018J\u0010\u0010)\u001a\u00020\u001d2\b\u0010*\u001a\u0004\u0018\u00010+J\u000e\u0010,\u001a\u00020\u001d2\u0006\u0010-\u001a\u00020\u0018J\u000e\u0010.\u001a\u00020\u001d2\u0006\u0010/\u001a\u000200J\u0006\u00101\u001a\u00020\u001dJ\u0006\u00102\u001a\u00020\u001dJ\u0006\u00103\u001a\u00020\u001dJ\u0006\u00104\u001a\u00020\u001dJ\u000e\u00105\u001a\u00020\u001d2\u0006\u00106\u001a\u00020\u0018J\b\u00107\u001a\u00020\u001dH\u0002J\b\u00108\u001a\u00020\u001dH\u0002J\b\u00109\u001a\u00020\u001dH\u0002J\b\u0010:\u001a\u000200H\u0002J\b\u0010;\u001a\u00020\u001dH\u0002J\b\u0010<\u001a\u00020\u001dH\u0002J\b\u0010=\u001a\u00020\u001dH\u0002R\u0010\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\f\u001a\u0004\u0018\u00010\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000e\u001a\u0004\u0018\u00010\u000fX\u0082\u000e¢\u0006\u0002\n\u0000R\"\u0010\u0012\u001a\u0004\u0018\u00010\u00112\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011@BX\u0086\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u0010\u0010\u0015\u001a\u0004\u0018\u00010\u0016X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\u0018X\u0082\u000e¢\u0006\u0002\n\u0000R\u0011\u0010\u0019\u001a\u00020\u001a8F¢\u0006\u0006\u001a\u0004\b\u0019\u0010\u001b¨\u0006?"}, m13886d2 = {"Lcom/samsung/android/sdk/pen/recoguifeature/crowdhwrdata/SpenCrowdHwrManager;", "", "context", "Landroid/content/Context;", "<init>", "(Landroid/content/Context;)V", "display", "Lcom/samsung/android/sdk/pen/view/SpenDisplay;", "mCrowdSource", "Lcom/samsung/android/sdk/pen/recogengine/hwrsampler/SpenCrowdSource;", "mCrowdDataHandler", "Lcom/samsung/android/sdk/pen/recoguifeature/crowdhwrdata/SpenCrowdDataHandler;", "mNoteDoc", "Lcom/samsung/android/sdk/pen/document/SpenNoteDoc;", "mPageDoc", "Lcom/samsung/android/sdk/pen/document/SpenPageDoc;", "value", "Lcom/samsung/android/sdk/pen/engine/writingview/document/SpenWritingDocument;", "writingDocument", "getWritingDocument", "()Lcom/samsung/android/sdk/pen/engine/writingview/document/SpenWritingDocument;", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "Lcom/samsung/android/sdk/pen/recoguifeature/crowdhwrdata/SpenCrowdHwrManagerListener;", "mTargetLabelLength", "", "isEmpty", "", "()Z", "close", "", "setCrowdHwrManagerListener", "_listener", "onTouchEvent", "event", "Landroid/view/MotionEvent;", "onLayout", "changed", "left", "top", "right", "bottom", "onConfigurationChanged", "newConfig", "Landroid/content/res/Configuration;", "setToolType", "toolType", "setAccountId", "accountId", "", "onNextSentenceClicked", "onSubmitClicked", "onClearAllClicked", "onUndoClicked", "setOrientation", "orientation", "createDocument", "saveData", "handleClearAllAction", "getNextSentence", "clearHandwriting", "handleUndoAction", "undoHandwriting", "Companion", "SDK_fullRelease"}, m13887k = 1, m13888mv = {2, 0, 0}, m13890xi = 48)
public final class SpenCrowdHwrManager {
    private static final int MAX_TARGET_LABEL_LENGTH_LANDSCAPE = 20;
    private static final int MAX_TARGET_LABEL_LENGTH_PORTRAIT = 15;

    @NotNull
    private static final String TAG = "SpenCrowdHwrManager";

    @Nullable
    private Context context;

    @NotNull
    private SpenDisplay display;

    @Nullable
    private SpenCrowdHwrManagerListener listener;

    @NotNull
    private SpenCrowdDataHandler mCrowdDataHandler;

    @NotNull
    private SpenCrowdSource mCrowdSource;

    @Nullable
    private SpenNoteDoc mNoteDoc;

    @Nullable
    private SpenPageDoc mPageDoc;
    private int mTargetLabelLength;

    @Nullable
    private SpenWritingDocument writingDocument;

    public SpenCrowdHwrManager(@Nullable Context context) {
        this.context = context;
        this.display = new SpenDisplay(this.context);
        this.mCrowdSource = new SpenCrowdSource(this.context);
        this.mCrowdDataHandler = new SpenCrowdDataHandler(this.context);
        createDocument();
    }

    private final void clearHandwriting() {
        this.mCrowdDataHandler.clearData();
        SpenPageDoc spenPageDoc = this.mPageDoc;
        if (spenPageDoc != null) {
            spenPageDoc.removeAllObject();
        }
        SpenPageDoc spenPageDoc2 = this.mPageDoc;
        if (spenPageDoc2 != null) {
            spenPageDoc2.clearHistory();
        }
        SpenCrowdHwrManagerListener spenCrowdHwrManagerListener = this.listener;
        if (spenCrowdHwrManagerListener != null) {
            spenCrowdHwrManagerListener.onHandwritingUpdated(isEmpty());
        }
    }

    private final void createDocument() {
        try {
            SpenNoteDoc spenNoteDoc = this.mNoteDoc;
            if (spenNoteDoc != null) {
                spenNoteDoc.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        this.mNoteDoc = null;
        try {
            Context context = this.context;
            SpenDisplay spenDisplay = this.display;
            this.mNoteDoc = new SpenNoteDoc(context, spenDisplay.widthPixels, spenDisplay.heightPixels);
        } catch (IOException e2) {
            Toast.makeText(this.context, "Cannot create new NoteDoc", 0).show();
            e2.printStackTrace();
        } catch (Exception e3) {
            e3.printStackTrace();
        }
        SpenNoteDoc spenNoteDoc2 = this.mNoteDoc;
        SpenPageDoc spenPageDocAppendPage = spenNoteDoc2 != null ? spenNoteDoc2.appendPage() : null;
        this.mPageDoc = spenPageDocAppendPage;
        if (spenPageDocAppendPage != null) {
            spenPageDocAppendPage.removeAllObject();
        }
        SpenPageDoc spenPageDoc = this.mPageDoc;
        if (spenPageDoc != null) {
            spenPageDoc.registerObjectListener(new SpenPageDoc.ObjectListener() { // from class: com.samsung.android.sdk.pen.recoguifeature.crowdhwrdata.SpenCrowdHwrManager.createDocument.1
                @Override // com.samsung.android.sdk.pen.document.SpenPageDoc.ObjectListener
                public void onObjectAdded(SpenPageDoc page, ArrayList<SpenObjectBase> objectList, int type) {
                    SpenCrowdHwrManagerListener spenCrowdHwrManagerListener = SpenCrowdHwrManager.this.listener;
                    if (spenCrowdHwrManagerListener != null) {
                        spenCrowdHwrManagerListener.onHandwritingUpdated(SpenCrowdHwrManager.this.isEmpty());
                    }
                }

                @Override // com.samsung.android.sdk.pen.document.SpenPageDoc.ObjectListener
                public void onObjectChanged(SpenPageDoc page, SpenObjectChangedInfo changedInfo, int type) {
                }

                @Override // com.samsung.android.sdk.pen.document.SpenPageDoc.ObjectListener
                public void onObjectRemoved(SpenPageDoc page, ArrayList<SpenObjectBase> objectList, int type) {
                }
            });
        }
        this.writingDocument = SpenWritingDocumentFactory.createDocument(this.mPageDoc);
    }

    private final String getNextSentence() {
        return this.mCrowdSource.generateRandomTargetLabel(this.mTargetLabelLength);
    }

    private final void handleClearAllAction() {
        clearHandwriting();
    }

    private final void handleUndoAction() {
        undoHandwriting();
        this.mCrowdDataHandler.undo();
    }

    private final void saveData() {
        String sentence;
        SpenCrowdDataHandler spenCrowdDataHandler = this.mCrowdDataHandler;
        SpenCrowdHwrManagerListener spenCrowdHwrManagerListener = this.listener;
        if (spenCrowdHwrManagerListener == null || (sentence = spenCrowdHwrManagerListener.getSentence()) == null) {
            sentence = "";
        }
        spenCrowdDataHandler.setSentence(sentence);
        this.mCrowdDataHandler.saveData();
    }

    private final void undoHandwriting() {
        SpenPageDoc spenPageDoc;
        SpenPageDoc spenPageDoc2 = this.mPageDoc;
        if (spenPageDoc2 == null || !spenPageDoc2.isUndoable() || (spenPageDoc = this.mPageDoc) == null) {
            return;
        }
        spenPageDoc.undo();
    }

    public final void close() {
        SpenWritingDocument spenWritingDocument = this.writingDocument;
        if (spenWritingDocument != null) {
            spenWritingDocument.close();
        }
        this.writingDocument = null;
        try {
            SpenNoteDoc spenNoteDoc = this.mNoteDoc;
            if (spenNoteDoc != null) {
                spenNoteDoc.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        this.mNoteDoc = null;
        this.mCrowdDataHandler.close();
    }

    @Nullable
    public final SpenWritingDocument getWritingDocument() {
        return this.writingDocument;
    }

    public final boolean isEmpty() {
        ArrayList<SpenObjectBase> objectList;
        SpenPageDoc spenPageDoc = this.mPageDoc;
        return (spenPageDoc == null || (objectList = spenPageDoc.getObjectList()) == null || !objectList.isEmpty()) ? false : true;
    }

    public final void onClearAllClicked() {
        handleClearAllAction();
        SpenCrowdHwrManagerListener spenCrowdHwrManagerListener = this.listener;
        if (spenCrowdHwrManagerListener != null) {
            spenCrowdHwrManagerListener.onClearAll();
        }
    }

    public final void onConfigurationChanged(@Nullable Configuration newConfig) {
        if (newConfig != null) {
            setOrientation(newConfig.orientation);
            SpenCrowdHwrManagerListener spenCrowdHwrManagerListener = this.listener;
            if (spenCrowdHwrManagerListener != null) {
                spenCrowdHwrManagerListener.onSentenceChanged(getNextSentence());
            }
        }
    }

    public final void onLayout(boolean changed, int left, int top, int right, int bottom) {
        if (changed) {
            clearHandwriting();
        }
    }

    public final void onNextSentenceClicked() {
        saveData();
        clearHandwriting();
        SpenCrowdHwrManagerListener spenCrowdHwrManagerListener = this.listener;
        if (spenCrowdHwrManagerListener != null) {
            spenCrowdHwrManagerListener.onSentenceChanged(getNextSentence());
        }
    }

    public final void onSubmitClicked() {
        saveData();
        clearHandwriting();
        SpenCrowdHwrManagerListener spenCrowdHwrManagerListener = this.listener;
        if (spenCrowdHwrManagerListener != null) {
            spenCrowdHwrManagerListener.onSubmitted(this.mCrowdDataHandler.getData());
        }
    }

    public final boolean onTouchEvent(@Nullable MotionEvent event) {
        if (event == null) {
            return false;
        }
        this.mCrowdDataHandler.addTouchEvent(event);
        return false;
    }

    public final void onUndoClicked() {
        handleUndoAction();
        SpenCrowdHwrManagerListener spenCrowdHwrManagerListener = this.listener;
        if (spenCrowdHwrManagerListener != null) {
            spenCrowdHwrManagerListener.onUndo();
        }
        SpenCrowdHwrManagerListener spenCrowdHwrManagerListener2 = this.listener;
        if (spenCrowdHwrManagerListener2 != null) {
            spenCrowdHwrManagerListener2.onHandwritingUpdated(isEmpty());
        }
    }

    public final void setAccountId(@NotNull String accountId) {
        Intrinsics.checkNotNullParameter(accountId, "accountId");
        this.mCrowdDataHandler.setAccountId(accountId);
    }

    public final void setCrowdHwrManagerListener(@NotNull SpenCrowdHwrManagerListener _listener) {
        Intrinsics.checkNotNullParameter(_listener, "_listener");
        this.listener = _listener;
        if (_listener != null) {
            _listener.onSentenceChanged(getNextSentence());
        }
    }

    public final void setOrientation(int orientation) {
        if (orientation == 1) {
            this.mTargetLabelLength = 15;
        } else {
            if (orientation != 2) {
                return;
            }
            this.mTargetLabelLength = 20;
        }
    }

    public final void setToolType(int toolType) {
        this.mCrowdDataHandler.setToolType(toolType);
    }
}
