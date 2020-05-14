/**
 * 
 */
package org.waal70.utils.archive;

/**
 * @author awaal
 *
 * Interface that represents a file entry
 */
public interface IFileEntry {
	
	String PREFIX = "File"+CoreProperties.DELIMITER;
	
	public String getHash();
	public long getSize();
	public String getTimeStamp();
	public String getName();
	

}
