package zip;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

public class Produce_zip {

	public static void main(String[] args) throws IOException {
		String path = "D:/logs/20180524.xls";
		File file1 = new File(path);
		List<File> files = new ArrayList<>();
		files.add(file1);
		File zip_file = new File("D://logs//now.zip");
		OutputStream os = new FileOutputStream(zip_file);
		byte[] buffer = new byte[1024];
		ZipOutputStream zipos = new ZipOutputStream(os);
		for (File file : files) {
			FileInputStream fis = new FileInputStream(file);
			zipos.putNextEntry(new ZipEntry(file.getName()));
			int len;
			while((len = fis.read(buffer)) != -1) {
				zipos.write(buffer, 0, len);
			}
			zipos.flush();
			zipos.closeEntry();
			fis.close();
		}
		zipos.close();
		os.close();
	}
}
