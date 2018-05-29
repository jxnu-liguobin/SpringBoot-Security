package cn.edu.jxnu.dto;

/**
 * 文件信息
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
