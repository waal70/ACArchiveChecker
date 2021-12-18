/**
 * 
 */
package org.waal70.utils.archive;
import java.io.File;
import java.util.ArrayList;
import java.util.List;

/**
 * @author awaal
 *
 */
public class FileList {

	//contains the list of read companies
	private List<File> files = new ArrayList<File>();
	
	public void addEntity(File f) {
		this.files.add(f);
	}
	
	public String[] getListforCombo() {
		
	//	long[] result = new Long[files.size()];
		
	//	for (int i=0;i<files.size();i++) 
	//		result[i] = files.get(i).length();
	//	return result;
		return null;
	}
	
	public String getArchiveCodeforEntity(String entity) {
		String result = "";
//		for (int i=0;i<files.size();i++)
		{
////			if (files.get(i).getDisplayName().equals(entity))
//				result = files.get(i).getArchiveCode();
		}	
		return result;
			
	}
	
}
