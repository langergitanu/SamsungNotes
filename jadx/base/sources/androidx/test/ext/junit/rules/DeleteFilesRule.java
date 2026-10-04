package androidx.test.ext.junit.rules;

import android.content.Context;
import android.os.Environment;
import androidx.test.core.app.ApplicationProvider;
import androidx.test.platform.p118io.PlatformTestStorageRegistry;
import java.io.File;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import org.junit.rules.TestRule;
import org.junit.runner.Description;
import org.junit.runners.model.Statement;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes4.dex */
public final class DeleteFilesRule implements TestRule {
    /* JADX INFO: Access modifiers changed from: private */
    public static void deleteFilesRecursively(Set<File> set, File file) {
        File[] fileArrListFiles = file.listFiles();
        if (fileArrListFiles != null) {
            for (File file2 : fileArrListFiles) {
                if (file2.isDirectory()) {
                    if (!PlatformTestStorageRegistry.getInstance().isTestStorageFilePath(file2.getPath())) {
                        deleteFilesRecursively(set, file2);
                        if (!set.contains(file2) && file2.exists()) {
                            File[] fileArrListFiles2 = file2.listFiles();
                            if (fileArrListFiles2 == null && !file2.delete()) {
                                System.err.println("DeleteRules failed to delete (not a directory or I/O error): " + file2);
                            } else if (fileArrListFiles2.length == 0 && !file2.delete()) {
                                System.err.println("DeleteRules failed to delete: " + file2);
                            }
                        }
                    }
                } else if (!set.contains(file2) && file2.exists() && !isConstant(file2) && !file2.delete()) {
                    System.err.println("DeleteRules failed to delete: " + file2);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void findFilesRecursively(Set<File> set, File file) {
        File[] fileArrListFiles = file.listFiles();
        if (fileArrListFiles != null) {
            for (File file2 : fileArrListFiles) {
                set.add(file2);
                if (file2.isDirectory()) {
                    findFilesRecursively(set, file2);
                }
            }
        }
    }

    private static boolean isConstant(File file) {
        return file.getName().endsWith(".dex");
    }

    @Override // org.junit.rules.TestRule
    public Statement apply(final Statement statement, Description description) {
        return new Statement() { // from class: androidx.test.ext.junit.rules.DeleteFilesRule.1
            @Override // org.junit.runners.model.Statement
            public void evaluate() {
                Context applicationContext = ApplicationProvider.getApplicationContext();
                ArrayList arrayList = new ArrayList();
                arrayList.add(new File(applicationContext.getApplicationInfo().dataDir));
                arrayList.add(Environment.getExternalStorageDirectory());
                arrayList.add(Environment.getDownloadCacheDirectory());
                if (applicationContext.getExternalCacheDir() != null) {
                    arrayList.add(applicationContext.getExternalCacheDir());
                }
                arrayList.add(applicationContext.getNoBackupFilesDir());
                arrayList.add(new File(applicationContext.getApplicationInfo().deviceProtectedDataDir));
                HashSet hashSet = new HashSet();
                Iterator it = arrayList.iterator();
                while (it.hasNext()) {
                    DeleteFilesRule.findFilesRecursively(hashSet, (File) it.next());
                }
                try {
                    statement.evaluate();
                } finally {
                    Iterator it2 = arrayList.iterator();
                    while (it2.hasNext()) {
                        DeleteFilesRule.deleteFilesRecursively(hashSet, (File) it2.next());
                    }
                }
            }
        };
    }
}
