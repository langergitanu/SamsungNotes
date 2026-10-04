package com.samsung.android.support.senl.p148nt.data.repository.category;

import androidx.appcompat.widget.AbstractC0541b;
import com.samsung.android.support.senl.p145cm.base.framework.content.SharedPreferencesCompat;
import com.samsung.android.support.senl.p148nt.base.common.constants.Constants;
import com.samsung.android.support.senl.p148nt.data.common.exceptions.InvalidParentFolderException;
import com.samsung.android.support.senl.p148nt.data.common.log.DataLogger;
import com.samsung.android.support.senl.p148nt.data.database.core.document.dao.NotesCategoryTreeClosureDao;
import com.samsung.android.support.senl.p148nt.data.database.core.document.entity.NotesCategoryTreeEntity;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes3.dex */
public class SoftParentFolderChecker {
    public static final String PREF_KEY_REPAIR_CIRCULAR_CATEGORY = "key_repair_circular_category";
    private static final String TAG = DataLogger.createTag("SoftParentFolderChecker");
    private static final List<String> sLoggedFolders = new ArrayList();
    private final NotesCategoryTreeClosureDao mCategoryTreeClosureDao;

    public SoftParentFolderChecker(NotesCategoryTreeClosureDao notesCategoryTreeClosureDao) {
        this.mCategoryTreeClosureDao = notesCategoryTreeClosureDao;
    }

    private static synchronized boolean isNotLogged(String str) {
        List<String> list = sLoggedFolders;
        if (list.contains(str)) {
            return false;
        }
        list.add(str);
        return true;
    }

    private void resetPreference() {
        SharedPreferencesCompat.getInstance(Constants.APP_LAUNCH_PREFERENCE).putInt(PREF_KEY_REPAIR_CIRCULAR_CATEGORY, 0);
    }

    public void checkInvalidRelationShip(String str, String str2) {
        if (this.mCategoryTreeClosureDao.hasRelationShip(str, str2)) {
            resetPreference();
            String strM774p = AbstractC0541b.m774p("Invalid relationship is detected, src/parent : ", str, " / ", str2);
            if (isNotLogged(AbstractC0541b.m756B(str, str2))) {
                DataLogger.m12305f(TAG, strM774p);
            } else {
                DataLogger.m12309w(TAG, strM774p);
            }
        }
    }

    public void checkInvalidRelationShip(Collection<? extends NotesCategoryTreeEntity> collection) {
        InvalidParentFolderException.Info infoCheckRelationShip = this.mCategoryTreeClosureDao.checkRelationShip(collection);
        if (infoCheckRelationShip != null) {
            resetPreference();
            String str = "Invalid relationship is detected, src/parent : " + infoCheckRelationShip.getSourceFolderUuid() + " / " + infoCheckRelationShip.getTargetFolderUuid() + " / entities : " + collection.size();
            if (isNotLogged(infoCheckRelationShip.getSourceFolderUuid() + infoCheckRelationShip.getTargetFolderUuid())) {
                DataLogger.m12305f(TAG, str);
            } else {
                DataLogger.m12309w(TAG, str);
            }
        }
    }
}
