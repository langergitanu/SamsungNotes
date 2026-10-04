package com.samsung.android.model.contractimpl;

import android.content.res.Resources;
import androidx.annotation.NonNull;
import com.samsung.android.support.senl.p148nt.app.converter.FolderConverterResources;
import com.samsung.android.support.senl.p148nt.base.common.access.folder.FolderAccessHandler;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes7.dex */
public class FolderAccessContractImpl implements FolderAccessHandler.FolderAccessContract {
    @Override // com.samsung.android.support.senl.nt.base.common.access.folder.FolderAccessHandler.FolderAccessContract
    public FolderAccessHandler.FolderColorResourceInjector getResourceInjector(@NonNull Resources resources) {
        return new FolderConverterResources(resources);
    }
}
