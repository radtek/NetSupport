package com.hbmcc.wangsen.netsupport.util;

import android.os.Environment;
import android.util.Log;

import com.hbmcc.wangsen.netsupport.App;
import com.hbmcc.wangsen.netsupport.R;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;


public class FileUtils {
    private static final String TAG = "FileUtils";
    private static String appName = App.getContext().getApplicationInfo().loadLabel(App.getContext()
            .getPackageManager
                    ()).toString();
    private static String SDPath = Environment.getExternalStorageDirectory() + "/";
    private static String appPath = Environment.getExternalStorageDirectory() + "/" + appName + "/";
    private static String lteBasestationDatabaseTemplate = App.getContext().getString(R.string
            .lteBasestationDatabaseTemplate);
    private static String lteBasestationDataCustomTemplate = App.getContext().getString(R.string
            .lteBasestationDataCustomTemplate);
    private static String lteBasestationDataTrackTemplate = App.getContext().getString(R.string
            .lteBasestationDataTrackTemplate);
    private static String lteBasestationDataGridTemplate = App.getContext().getString(R.string
            .lteBasestationDataGridTemplate);

    public static String getSDPATH() {
        return SDPath;
    }

    public static String getAppPath() {
        return appPath;
    }

    //在SD卡上创建文件
    public static File createSDFile(String fileName) throws IOException {
        File file = new File(fileName);
        file.createNewFile();
        return file;
    }

    //在SD卡上创建单级目录
    public static File createSDDir(String dirName) {
        File dir = new File(dirName);
        dir.mkdir();
        return dir;
    }

    //在SD卡上创建多级目录
    public static File createSDDirs(String dirsName) {
        File dirs = new File(dirsName);
        dirs.mkdirs();
        return dirs;
    }

    //判断SD卡上的文件或者文件夹是否存在
    public static boolean isFileExist(String fileName) {
        File file = new File(fileName);
        return file.exists();
    }


    //将一个InputStream里面的数据写入到SD卡中
    //将input写到path这个目录中的fileName文件上
    private File write2SDFromInput(String path, String fileName, InputStream input) {
        File file = null;
        OutputStream output = null;
        try {
            createSDDir(path);
            file = createSDFile(path + fileName);
            //FileInputStream是读取数据，FileOutputStream是写入数据，写入到file这个文件上去
            output = new FileOutputStream(file);
            byte buffer[] = new byte[4 * 1024];
            while ((input.read(buffer)) != -1) {
                output.write(buffer);
            }
            output.flush();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                output.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return file;
    }

    public static int initialStorage() {
        if (!FileUtils.isFileExist(FileUtils.getAppPath())) {

            FileUtils.createSDDirs(FileUtils.getAppPath());
        }

        if (!FileUtils.isFileExist(FileUtils.getAppPath() + lteBasestationDatabaseTemplate)) {
            initFile(App.getContext().getResources().openRawResource(R.raw.lte_database_template),
                    FileUtils.getAppPath() + lteBasestationDatabaseTemplate);
        }
        if (!FileUtils.isFileExist(FileUtils.getAppPath() + lteBasestationDataCustomTemplate)) {
            initFile(App.getContext().getResources().openRawResource(R.raw.lte_datacustom_template),
                    FileUtils.getAppPath() + lteBasestationDataCustomTemplate);
        }
        if (!FileUtils.isFileExist(FileUtils.getAppPath() + lteBasestationDataTrackTemplate)) {
            initFile(App.getContext().getResources().openRawResource(R.raw.lte_datatrack_template),
                    FileUtils.getAppPath() + lteBasestationDataTrackTemplate);
        }
        if (!FileUtils.isFileExist(FileUtils.getAppPath() + lteBasestationDataGridTemplate)) {
            initFile(App.getContext().getResources().openRawResource(R.raw.lte_datagrid_template),
                    FileUtils.getAppPath() + lteBasestationDataGridTemplate);
        }

        return 0;
    }

    public static String getLteInputFile() {
        return FileUtils.getAppPath() + lteBasestationDatabaseTemplate;
    }
    public static String getLteInputFilecustom() {
        return FileUtils.getAppPath() + lteBasestationDataCustomTemplate;
    }
    public static String getLteInputFiletrack() {
        return FileUtils.getAppPath() + lteBasestationDataTrackTemplate;
    }
    public static String getLteInputFileGrid() {
        return FileUtils.getAppPath() + lteBasestationDataGridTemplate;
    }

    public static boolean initFile(InputStream fileInputStream, String newPath$Name) {
        try {
            FileOutputStream fileOutputStream = new FileOutputStream(newPath$Name);
            byte[] buffer = new byte[1024];
            int byteRead;
            while (-1 != (byteRead = fileInputStream.read(buffer))) {
                fileOutputStream.write(buffer, 0, byteRead);
            }
            fileInputStream.close();
            fileOutputStream.flush();
            fileOutputStream.close();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    /**
     * 复制单个文件
     *
     * @param oldPath$Name String 原文件路径+文件名 如：data/user/0/com.test/files/abc.txt
     * @param newPath$Name String 复制后路径+文件名 如：data/user/0/com.test/cache/abc.txt
     * @return <code>true</code> if and only if the file was copied;
     * <code>false</code> otherwise
     */
    public static boolean copyFile(String oldPath$Name, String newPath$Name) {
        try {
            File oldFile = new File(oldPath$Name);
            if (!oldFile.exists()) {
                Log.e("--Method--", "copyFile:  oldFile not exist.");
                return false;
            } else if (!oldFile.isFile()) {
                Log.e("--Method--", "copyFile:  oldFile not file.");
                return false;
            } else if (!oldFile.canRead()) {
                Log.e("--Method--", "copyFile:  oldFile cannot read.");
                return false;
            }

            /* 如果不需要打log，可以使用下面的语句
            if (!oldFile.exists() || !oldFile.isFile() || !oldFile.canRead()) {
                return false;
            }
            */

            FileInputStream fileInputStream = new FileInputStream(oldPath$Name);
            FileOutputStream fileOutputStream = new FileOutputStream(newPath$Name);
            byte[] buffer = new byte[1024];
            int byteRead;
            while (-1 != (byteRead = fileInputStream.read(buffer))) {
                fileOutputStream.write(buffer, 0, byteRead);
            }
            fileInputStream.close();
            fileOutputStream.flush();
            fileOutputStream.close();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    /**
     * 复制文件夹及其中的文件
     *
     * @param oldPath String 原文件夹路径 如：data/user/0/com.test/files
     * @param newPath String 复制后的路径 如：data/user/0/com.test/cache
     * @return <code>true</code> if and only if the directory and files were copied;
     * <code>false</code> otherwise
     */
    public static boolean copyFolder(String oldPath, String newPath) {
        try {
            File newFile = new File(newPath);
            if (!newFile.exists()) {
                if (!newFile.mkdirs()) {
                    Log.e("--Method--", "copyFolder: cannot create directory.");
                    return false;
                }
            }
            File oldFile = new File(oldPath);
            String[] files = oldFile.list();
            File temp;
            for (String file : files) {
                if (oldPath.endsWith(File.separator)) {
                    temp = new File(oldPath + file);
                } else {
                    temp = new File(oldPath + File.separator + file);
                }

                if (temp.isDirectory()) {   //如果是子文件夹
                    copyFolder(oldPath + "/" + file, newPath + "/" + file);
                } else if (!temp.exists()) {
                    Log.e("--Method--", "copyFolder:  oldFile not exist.");
                    return false;
                } else if (!temp.isFile()) {
                    Log.e("--Method--", "copyFolder:  oldFile not file.");
                    return false;
                } else if (!temp.canRead()) {
                    Log.e("--Method--", "copyFolder:  oldFile cannot read.");
                    return false;
                } else {
                    FileInputStream fileInputStream = new FileInputStream(temp);
                    FileOutputStream fileOutputStream = new FileOutputStream(newPath + "/" + temp.getName());
                    byte[] buffer = new byte[1024];
                    int byteRead;
                    while ((byteRead = fileInputStream.read(buffer)) != -1) {
                        fileOutputStream.write(buffer, 0, byteRead);
                    }
                    fileInputStream.close();
                    fileOutputStream.flush();
                    fileOutputStream.close();
                }

                /* 如果不需要打log，可以使用下面的语句
                if (temp.isDirectory()) {   //如果是子文件夹
                    copyFolder(oldPath + "/" + file, newPath + "/" + file);
                } else if (temp.exists() && temp.isFile() && temp.canRead()) {
                    FileInputStream fileInputStream = new FileInputStream(temp);
                    FileOutputStream fileOutputStream = new FileOutputStream(newPath + "/" + temp.getName());
                    byte[] buffer = new byte[1024];
                    int byteRead;
                    while ((byteRead = fileInputStream.read(buffer)) != -1) {
                        fileOutputStream.write(buffer, 0, byteRead);
                    }
                    fileInputStream.close();
                    fileOutputStream.flush();
                    fileOutputStream.close();
                }
                */
            }
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

}
