package opennlp.tools.formats;

import java.io.File;
import java.io.FileFilter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Stack;
import opennlp.tools.util.ObjectStream;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes10.dex */
public class DirectorySampleStream implements ObjectStream<File> {
    private final Stack<File> directories;
    private final FileFilter fileFilter;
    private final List<File> inputDirectories;
    private final boolean recursive;
    private final Stack<File> textFiles;

    public DirectorySampleStream(File[] fileArr, FileFilter fileFilter, boolean z) {
        this.directories = new Stack<>();
        this.textFiles = new Stack<>();
        this.fileFilter = fileFilter;
        this.recursive = z;
        ArrayList arrayList = new ArrayList(fileArr.length);
        for (File file : fileArr) {
            if (!file.isDirectory()) {
                throw new IllegalArgumentException("All passed in directories must be directories, but \"" + file + "\" is not!");
            }
            arrayList.add(file);
        }
        List<File> listUnmodifiableList = Collections.unmodifiableList(arrayList);
        this.inputDirectories = listUnmodifiableList;
        this.directories.addAll(listUnmodifiableList);
    }

    @Override // opennlp.tools.util.ObjectStream
    public void reset() {
        this.directories.clear();
        this.textFiles.clear();
        this.directories.addAll(this.inputDirectories);
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // opennlp.tools.util.ObjectStream
    public File read() {
        while (this.textFiles.isEmpty() && !this.directories.isEmpty()) {
            File filePop = this.directories.pop();
            FileFilter fileFilter = this.fileFilter;
            File[] fileArrListFiles = fileFilter != null ? filePop.listFiles(fileFilter) : filePop.listFiles();
            Arrays.sort(fileArrListFiles);
            for (File file : fileArrListFiles) {
                if (file.isFile()) {
                    this.textFiles.push(file);
                } else if (this.recursive && file.isDirectory()) {
                    this.directories.push(file);
                }
            }
        }
        if (this.textFiles.isEmpty()) {
            return null;
        }
        return this.textFiles.pop();
    }

    public DirectorySampleStream(File file, FileFilter fileFilter, boolean z) {
        this(new File[]{file}, fileFilter, z);
    }

    @Override // opennlp.tools.util.ObjectStream, java.lang.AutoCloseable
    public void close() {
    }
}
