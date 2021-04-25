package com.zhongbin.io;

import java.io.File;
import java.io.FilenameFilter;

public class MyFileNameFilter implements FilenameFilter{

	private final String suffix = ".txt";
	@Override
	public boolean accept(File dir, String name) {
		// TODO Auto-generated method stub
		if(name.endsWith(suffix)){
			return false;
		}
		return true;
	}

}
