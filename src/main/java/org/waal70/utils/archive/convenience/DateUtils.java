/**
 * 
 */
package org.waal70.utils.archive.convenience;

import java.text.DateFormat;
import java.text.DateFormatSymbols;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.TimeZone;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 * @author awaal
 *
 */
public class DateUtils {
	 public static final TimeZone UTC = TimeZone.getTimeZone("UTC");
	
    public static final TimeZone MIDDAY = TimeZone.getTimeZone("GMT-12:00");
    
    public static String formatLong(long inputDate)
    {
    	log.debug("Received: " + inputDate);
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
        return sdf.format(inputDate);
    }
    
    private static Logger log = LogManager.getLogger(DateUtils.class);
    private static DateFormat createDateFormat(String format, TimeZone timezone) {
        final SimpleDateFormat sdf =
                new SimpleDateFormat(format, new DateFormatSymbols(Locale.GERMANY));
        if (timezone != null) {
            sdf.setTimeZone(timezone);
        }
        return sdf;
    }
    /**
     * So we can return Date objects for these, this is the
     *  list (in preference order) of the various ISO-8601
     *  variants that we try when processing a date based
     *  property.
     */
    @SuppressWarnings("unused")
	private final List<DateFormat> iso8601InputFormats = loadDateFormats();

    private List<DateFormat> loadDateFormats() {
        List<DateFormat> dateFormats = new ArrayList<>();
        // yyyy-mm-ddThh...
        dateFormats.add(createDateFormat("yyyy-MM-dd'T'HH:mm:ss'Z'", UTC));   // UTC/Zulu
        dateFormats.add(createDateFormat("yyyy-MM-dd'T'HH:mm:ssZ", null));    // With timezone
        dateFormats.add(createDateFormat("yyyy-MM-dd'T'HH:mm:ss", null));     // Without timezone
        // yyyy-mm-dd hh...
        dateFormats.add(createDateFormat("yyyy-MM-dd' 'HH:mm:ss'Z'", UTC));   // UTC/Zulu
        dateFormats.add(createDateFormat("yyyy-MM-dd' 'HH:mm:ssZ", null));    // With timezone
        dateFormats.add(createDateFormat("yyyy-MM-dd' 'HH:mm:ss", null));     // Without timezone
        // Date without time, set to Midday UTC
        dateFormats.add(createDateFormat("yyyy-MM-dd", MIDDAY));       // Normal date format
        dateFormats.add(createDateFormat("yyyy:MM:dd", MIDDAY));              // Image (IPTC/EXIF) format
        
        //Some PDFs use this exotic format:
        dateFormats.add(createDateFormat("yyyyMMddHHmmss", null));
        

        return dateFormats;
    }

}
