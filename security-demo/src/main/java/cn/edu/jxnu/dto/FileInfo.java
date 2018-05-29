package cn.edu.jxnu.dto;

/**
 * 文件信息
 * 
 * @author 梦境迷离.
 * @time 2018年5月29日
 * @version v1.0
 */
public class FileInfo {

	public FileInfo(String path) {
		this.path = path;
	}

	private String path;

	public String getPath() {
		return path;
	}

	public void setPath(String path) {
		this.path = path;
	}

	@Override
	public String toString() {
		return "FileInfo [path=" + path + "]";
	}

}
