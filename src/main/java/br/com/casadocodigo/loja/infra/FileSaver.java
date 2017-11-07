package br.com.casadocodigo.loja.infra;

import java.io.File;
import java.io.IOException;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

@Component
public class FileSaver {
	@Autowired
    private HttpServletRequest request;
	
	/*
	 * Nesta classe criaremos um método chamado write que fará a transferência
	 * do arquivo e retornará o caminho onde o arquivo foi salvo. Este método
	 * então precisara de duas informações, o local onde o arquivo será salvo e
	 * o arquivo em si. O local será recebido como String e o arquivo como um
	 * objeto MultipartFile. Os quais chamaremos de baseFolder e file
	 * respectivamente.
	 */
	public String write(String baseFolder, MultipartFile file) {
	    try {
	        String realPath = request.getServletContext().getRealPath("/"+baseFolder);
	        String path = realPath + "/" + file.getOriginalFilename();
	        file.transferTo(new File(path));
	        return baseFolder + "/" + file.getOriginalFilename();

	    } catch (IllegalStateException | IOException e) {
	        throw new RuntimeException(e);
	    }
	}
	
}
