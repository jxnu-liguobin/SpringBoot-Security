package cn.edu.jxnu.dto;

import lombok.Getter;
import lombok.Setter;

/**
 * 文件信息
 * 
 * @author 梦境迷离.
 * @time 2018年5月29日
 * @version v1.0
 */
@Getter
@Setter
public class FileInfo {

	public FileInfo(String path) {
		this.path = path;
	}

	private String path;

	@Override
	public String toString() {
		return "FileInfo [path=" + path + "]";
	}

}
