package com.samsung.android.app.notes.reflect;

import android.content.Context;
import android.text.TextUtils;
import androidx.appcompat.widget.AbstractC0541b;
import com.samsung.android.app.notes.sync.p135db.AbstractC6740i;
import com.samsung.android.sdk.composer.document.sdoc.SpenSDocFile;
import com.samsung.android.sdk.composer.document.sdoc.exception.SpenSDocUnsupportedFileException;
import com.samsung.android.sdk.composer.document.sdoc.exception.SpenSDocUnsupportedVersionException;
import com.samsung.android.sdk.pen.worddoc.SpenWNote;
import com.samsung.android.support.senl.document.contract.DocumentDataContract;
import com.samsung.android.support.senl.document.contract.DocumentSaveParamBuilder;
import com.samsung.android.support.senl.p145cm.base.spenwrapper.converter.sdoc.SDocXConverterWrapper;
import com.samsung.android.support.senl.p148nt.base.common.util.FileUtils;
import com.samsung.android.support.senl.p148nt.base.framework.support.Logger;
import com.samsung.android.support.senl.p148nt.data.common.constants.PredefinedCategory;
import com.samsung.android.support.senl.p148nt.data.database.core.document.entity.NotesDocumentEntity;
import com.samsung.android.support.senl.p148nt.data.repository.NotesDataRepositoryFactory;
import com.samsung.android.support.senl.p148nt.data.resolver.lock.DocumentLockResolver;
import com.samsung.android.support.senl.p148nt.model.document.save.DocumentPostSaveOperation;
import com.samsung.android.support.senl.p148nt.model.documents.file.DocumentFileManager;
import com.samsung.android.support.senl.p148nt.model.documents.file.DocumentFileUtil;
import com.samsung.android.support.senl.p148nt.model.folder.FolderManager;
import com.samsung.android.support.senl.p148nt.model.utils.DocumentWriteResolver;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import p006B.C0017a;
import p087V0.CallableC0323a;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes7.dex */
public class DocumentDataContractImpl implements DocumentDataContract {
    private static final String TAG = "DocumentDataContractImpl";

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ Boolean lambda$saveDoc$0(String str) {
        return Boolean.valueOf(FileUtils.deleteFile(str));
    }

    @Override // com.samsung.android.support.senl.document.contract.DocumentDataContract
    public String addCategory(Context context, String str) {
        return (String) FolderManager.getInstance().executeOperation(new CallableC0323a(str, 1));
    }

    @Override // com.samsung.android.support.senl.document.contract.DocumentDataContract
    public void deleteSDoc(Context context, String str, boolean z) {
        DocumentWriteResolver.delete(context, str, z ? 1 : 2, TAG);
    }

    @Override // com.samsung.android.support.senl.document.contract.DocumentDataContract
    public String getCategoryUUID(Context context, String str, boolean z) {
        return AbstractC6740i.m4838a(str, z);
    }

    @Override // com.samsung.android.support.senl.document.contract.DocumentDataContract
    public ArrayList<String> getNoteFilePathList(Context context, boolean z) {
        ArrayList<String> arrayList = new ArrayList<>();
        List<String> allPathList = z ? NotesDataRepositoryFactory.newInstance(context).createDocumentDataRepository().getAllPathList() : NotesDataRepositoryFactory.newInstance(context).createDocumentDataRepository().getPathList(0);
        if (allPathList != null) {
            for (String str : allPathList) {
                if (str.endsWith(".sdocx")) {
                    arrayList.add(str);
                }
            }
        }
        return arrayList;
    }

    @Override // com.samsung.android.support.senl.document.contract.DocumentDataContract
    public String getSDocUUID(Context context, String str) {
        String strSubstring = str.substring(0, str.lastIndexOf(".sdoc"));
        return NotesDataRepositoryFactory.newInstance(context).createDocumentDataRepository().getUuid(strSubstring + ".sdocx");
    }

    @Override // com.samsung.android.support.senl.document.contract.DocumentDataContract
    public boolean isExistingNote(Context context, String str) {
        return !TextUtils.isEmpty(NotesDataRepositoryFactory.newInstance(context).createDocumentDataRepository().getPath(str));
    }

    @Override // com.samsung.android.support.senl.document.contract.DocumentDataContract
    public boolean saveDoc(Context context, DocumentSaveParamBuilder documentSaveParamBuilder) throws Throwable {
        String str;
        boolean z;
        boolean z2;
        Throwable th;
        SpenWNote spenWNote;
        SpenWNote spenWNote2;
        Logger.m8697d(TAG, "SaveDoc");
        if (!(documentSaveParamBuilder instanceof DocumentSaveParamBuilderImpl)) {
            return false;
        }
        DocumentSaveParamBuilderImpl documentSaveParamBuilderImpl = (DocumentSaveParamBuilderImpl) documentSaveParamBuilder;
        documentSaveParamBuilderImpl.setImported();
        NotesDocumentEntity notesDocumentEntityBuild = documentSaveParamBuilderImpl.build();
        String categoryUuid = notesDocumentEntityBuild.getCategoryUuid();
        if ("1".equals(categoryUuid)) {
            notesDocumentEntityBuild.setCategoryUuid(PredefinedCategory.UNCATEGORIZED.getUuid());
        } else if ("2".equals(categoryUuid)) {
            notesDocumentEntityBuild.setCategoryUuid(PredefinedCategory.SCREEN_OFF_MEMO.getUuid());
        } else if ("coedit:///".equals(categoryUuid)) {
            notesDocumentEntityBuild.setCategoryUuid(PredefinedCategory.COEDIT_NOTES.getUuid());
        } else if (TextUtils.isEmpty(categoryUuid) || FolderManager.getInstance().getCategoryEntity(categoryUuid) == null) {
            notesDocumentEntityBuild.setCategoryUuid(PredefinedCategory.UNCATEGORIZED.getUuid());
        }
        if (notesDocumentEntityBuild.getTimeSaveParam().getCreatedTime(0L).longValue() == 0) {
            try {
                notesDocumentEntityBuild.getTimeSaveParam().setCreatedTime(Long.valueOf(SpenSDocFile.getCreatedTime(notesDocumentEntityBuild.getFilePath())));
            } catch (SpenSDocUnsupportedFileException | SpenSDocUnsupportedVersionException | IOException unused) {
                Logger.m8697d(TAG, "can not read createdTime");
            }
        }
        if (notesDocumentEntityBuild.getTimeSaveParam().getLastModifiedTime(0L).longValue() == 0) {
            try {
                notesDocumentEntityBuild.getTimeSaveParam().setLastModifiedTime(Long.valueOf(SpenSDocFile.getModifiedTime(notesDocumentEntityBuild.getFilePath())));
            } catch (SpenSDocUnsupportedFileException | SpenSDocUnsupportedVersionException | IOException unused2) {
                Logger.m8697d(TAG, "can not read modifiedTime");
            }
        }
        SDocXConverterWrapper sDocXConverterWrapper = new SDocXConverterWrapper(context);
        String filePath = notesDocumentEntityBuild.getFilePath();
        String strSubstring = filePath.substring(0, filePath.lastIndexOf(".sdoc"));
        String strM756B = AbstractC0541b.m756B(strSubstring, ".sdocx");
        SpenWNote spenWNoteOpen = null;
        try {
            try {
                z2 = false;
                z = true;
            } catch (IOException e) {
                e = e;
                z = true;
                z2 = false;
                spenWNote2 = null;
                str = strM756B;
            } catch (Throwable th2) {
                th = th2;
                str = strM756B;
                z = true;
                spenWNote = null;
            }
            try {
                spenWNoteOpen = DocumentFileManager.getInstance().open(context, strM756B, SpenWNote.PageMode.SINGLE, SpenWNote.Orientation.PORTRAIT, DocumentFileUtil.getSize(DocumentFileUtil.DocumentFileSizeType.Document, 0, false).getWidth(), false);
                try {
                    if (documentSaveParamBuilderImpl.getSpenSDoc() == null) {
                        sDocXConverterWrapper.convert(context, filePath, spenWNoteOpen);
                    } else {
                        sDocXConverterWrapper.convert(documentSaveParamBuilderImpl.getSpenSDoc(), spenWNoteOpen);
                    }
                    DocumentFileManager.getInstance().saveAsDirectory(spenWNoteOpen, strM756B);
                    strM756B = strM756B;
                } catch (IOException e2) {
                    e = e2;
                    str = strM756B;
                } catch (Throwable th3) {
                    th = th3;
                    str = strM756B;
                }
            } catch (IOException e3) {
                e = e3;
                str = strM756B;
                spenWNote2 = null;
                spenWNoteOpen = spenWNote2;
                Logger.m8698e(TAG, "convert, e : " + e.getMessage());
                try {
                    DocumentFileManager.getInstance().close(str, spenWNoteOpen, z);
                } catch (IOException e5) {
                    Logger.m8698e(TAG, "convert, e when close : " + e5.getMessage());
                }
                try {
                    DocumentFileManager.getInstance().delete(filePath, new C0017a(filePath, 0));
                } catch (IOException e6) {
                    Logger.m8698e(TAG, "convert, failed to delete old doc: " + e6.getMessage());
                }
                return z2;
            } catch (Throwable th4) {
                th = th4;
                str = strM756B;
                spenWNote = null;
                th = th;
                spenWNoteOpen = spenWNote;
                try {
                    DocumentFileManager.getInstance().close(str, spenWNoteOpen, z);
                } catch (IOException e7) {
                    Logger.m8698e(TAG, "convert, e when close : " + e7.getMessage());
                }
                try {
                    DocumentFileManager.getInstance().delete(filePath, new C0017a(filePath, 0));
                    throw th;
                } catch (IOException e8) {
                    Logger.m8698e(TAG, "convert, failed to delete old doc: " + e8.getMessage());
                    throw th;
                }
            }
            try {
                str = strM756B;
                try {
                    try {
                        boolean zSave = DocumentWriteResolver.save(context, documentSaveParamBuilderImpl.isNew(), strSubstring + ".sdocx", notesDocumentEntityBuild, spenWNoteOpen, (String) null, true, 2048, TAG);
                        if (zSave) {
                            try {
                                new DocumentPostSaveOperation(context, documentSaveParamBuilderImpl.isNew(), notesDocumentEntityBuild, null).setStrategy(8).run();
                            } catch (IOException e9) {
                                e = e9;
                                z2 = zSave;
                                Logger.m8698e(TAG, "convert, e : " + e.getMessage());
                                DocumentFileManager.getInstance().close(str, spenWNoteOpen, z);
                                DocumentFileManager.getInstance().delete(filePath, new C0017a(filePath, 0));
                                return z2;
                            }
                        }
                        try {
                            DocumentFileManager.getInstance().close(str, spenWNoteOpen, true);
                        } catch (IOException e10) {
                            Logger.m8698e(TAG, "convert, e when close : " + e10.getMessage());
                        }
                        try {
                            DocumentFileManager.getInstance().delete(filePath, new C0017a(filePath, 0));
                            return zSave;
                        } catch (IOException e11) {
                            Logger.m8698e(TAG, "convert, failed to delete old doc: " + e11.getMessage());
                            return zSave;
                        }
                    } catch (IOException e12) {
                        e = e12;
                    }
                } catch (Throwable th5) {
                    th = th5;
                    th = th;
                    DocumentFileManager.getInstance().close(str, spenWNoteOpen, z);
                    DocumentFileManager.getInstance().delete(filePath, new C0017a(filePath, 0));
                    throw th;
                }
            } catch (IOException e13) {
                e = e13;
                str = strM756B;
                Logger.m8698e(TAG, "convert, e : " + e.getMessage());
                DocumentFileManager.getInstance().close(str, spenWNoteOpen, z);
                DocumentFileManager.getInstance().delete(filePath, new C0017a(filePath, 0));
                return z2;
            } catch (Throwable th6) {
                th = th6;
                str = strM756B;
                th = th;
                DocumentFileManager.getInstance().close(str, spenWNoteOpen, z);
                DocumentFileManager.getInstance().delete(filePath, new C0017a(filePath, 0));
                throw th;
            }
        } catch (IOException e14) {
            e = e14;
            z = true;
            z2 = false;
        } catch (Throwable th7) {
            th = th7;
            str = strM756B;
            z = true;
        }
    }

    @Override // com.samsung.android.support.senl.document.contract.DocumentDataContract
    public int setNoteFavorite(Context context, String str, boolean z) {
        return NotesDataRepositoryFactory.newInstance(context).createDocumentDataRepository().updateFavorite(str, z);
    }

    @Override // com.samsung.android.support.senl.document.contract.DocumentDataContract
    public boolean setNoteLock(Context context, String str, boolean z) {
        return DocumentLockResolver.execute(context, str, z);
    }
}
