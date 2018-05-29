package cn.edu.jxnu.web.controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.io.IOUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import cn.edu.jxnu.dto.FileInfo;
import lombok.extern.slf4j.Slf4j;

/**
 * 文件控制器
 * 
 * @author 梦境迷离.
 * @time 2018年5月29日
 * @version v1.0
 */
@RestController
@RequestMapping("/file")
@Slf4j
public class FileController {

	private String folder = "D:/git_project/SpringBoot-Security/security-demo/src/main/java/cn/edu/jxnu/web/controller";

	@GetMapping("/{id}")
	public void download(@PathVariable String id, HttpServletRequest request, HttpServletResponse response)
			throws Exception {

		try (InputStream inputStream = new FileInputStream(new File(folder, id + ".txt"));
				OutputStream outputStream = response.getOutputStream();) {
			response.setContentType("application/x-download");
			response.addHeader("Content-Disposition", "attachment;filename=test.txt");
			IOUtils.copy(inputStream, outputStream);
			outputStream.flush();
		}

	}

	@PostMapping
	public FileInfo upload(MultipartFile file) throws Exception {

		log.info(file.getName());
		log.info(file.getOriginalFilename());
		log.info(String.valueOf(file.getSize()));

		File localFile = new File(folder, new Date().getTime() + ".txt");
		file.transferTo(localFile);
		return new FileInfo(localFile.getAbsolutePath());
	}

}
