package org.apache.poi.sun.java2d.cmm;

import java.util.Iterator;
import java.util.Vector;
import org.apache.poi.java.awt.color.ProfileDataException;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes10.dex */
public class ProfileDeferralMgr {
    private static Vector<ProfileActivator> aVector = null;
    public static boolean deferring = true;

    public static void activateProfiles() {
        deferring = false;
        Vector<ProfileActivator> vector = aVector;
        if (vector == null) {
            return;
        }
        vector.size();
        Iterator<ProfileActivator> it = aVector.iterator();
        while (it.hasNext()) {
            try {
                it.next().activate();
            } catch (ProfileDataException unused) {
            }
        }
        aVector.removeAllElements();
        aVector = null;
    }

    public static void registerDeferral(ProfileActivator profileActivator) {
        if (deferring) {
            if (aVector == null) {
                aVector = new Vector<>(3, 3);
            }
            aVector.addElement(profileActivator);
        }
    }

    public static void unregisterDeferral(ProfileActivator profileActivator) {
        Vector<ProfileActivator> vector;
        if (deferring && (vector = aVector) != null) {
            vector.removeElement(profileActivator);
        }
    }
}
