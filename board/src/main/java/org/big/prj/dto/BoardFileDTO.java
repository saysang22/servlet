package org.big.prj.dto;

import lombok.Data;

@Data
public class BoardFileDTO {

	private int idx;
	private int boardIdx;
	private String originalFileName;
	private String storedFilePath;
	private long fileSize;
}
