package com.samsung.android.support.senl.p148nt.composer.main.base.util;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes3.dex */
public enum ComposerRequestCode {
    None,
    Camera,
    Gallery,
    PDFChooser,
    CategoryChooser,
    LockDocument,
    UpdateDocumentLockPassword,
    ShareVia,
    Export,
    BrushDrawing,
    AudioAddByMyFiles,
    ConvertSpeechToText,
    AudioADD,
    TextAddByMyFiles,
    TextADD,
    HashTag,
    ChangeNoteStyle,
    DocumentScan,
    AddPageTemplate,
    InAppCollaborationFTU,
    ImageEditor,
    StartCoedit,
    LeaveCoedit,
    ProcessText,
    SettingContextMenu,
    CompareConflict,
    AddPDFText,
    AddImageText,
    AddCameraImageText,
    CoverEditor,
    CoreTranslator,
    DownloadLanguage,
    WritingToolkit,
    DrawingToolkit,
    ImageStyleChanger,
    SearchVoice,
    SearchVoiceSvi,
    SearchVoiceSTT,
    SearchVoiceSTTSvi;

    public static ComposerRequestCode get(int i) {
        for (ComposerRequestCode composerRequestCode : values()) {
            if (composerRequestCode.getId() == i) {
                return composerRequestCode;
            }
        }
        return None;
    }

    public int getId() {
        return ordinal() + 4000;
    }
}
