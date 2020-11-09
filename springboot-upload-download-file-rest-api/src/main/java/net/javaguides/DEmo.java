package net.javaguides;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.MalformedURLException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

import org.apache.tomcat.util.http.fileupload.IOUtils;
import org.springframework.core.io.InputStreamSource;
import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.mock.web.MockMultipartFile;
import org.springframework.web.multipart.MultipartFile;

import net.javaguides.property.FileStorageProperties;

public class DEmo {

	public static void main(String[] args) throws Exception {
		
//		final Path fileStorageLocation = Paths.get(FileStorageProperties.getUploadDir())
//                .toAbsolutePath().normalize();
/*		 String fileName = "C:\\Users\\ANKITA\\Pictures\\Screenshots\\Screenshot(2).PNG";
		 Path filePath = Paths.get(fileName).toAbsolutePath().normalize();
         System.out.println("file path->"+filePath.toUri());
         String url = filePath.toUri().getPath();
         System.out.println("url="+url);
         Resource resource = new UrlResource(filePath.toUri());
         System.out.println("FILE->"+resource.getFilename());
    
         File file = new File("C:\\Users\\ANKITA\\Pictures\\Screenshots\\abc.PNG");
         
         FileInputStream input = new FileInputStream(file);
         MultipartFile multipartFile = new MockMultipartFile("abc.PNG", new FileInputStream(file));
         
         try {
             // Copy file to the target location 
            Path targetLocation = Paths.get("C:\\bulkupload\\").toAbsolutePath().normalize();
            Files.copy( multipartFile.getInputStream(), targetLocation, StandardCopyOption.REPLACE_EXISTING);
           // Files.copy(filePath, targetLocation,  StandardCopyOption.REPLACE_EXISTING);
           
        } catch (IOException ex) {
            throw new Exception(ex);
        }
	
*/
		MultipartFile multipartFile = new MockMultipartFile("sourceFile.tmp", "Hello World".getBytes());
		 
		InputStream initialStream = multipartFile.getInputStream();
		byte[] buffer = new byte[initialStream.available()];
		initialStream.read(buffer);
		 
		File targetFile = new File("C:/bulkupload/targetFile.tmp");
		 
		try (OutputStream outStream = new FileOutputStream(targetFile)) {
		    outStream.write(buffer);
		}

}
}
