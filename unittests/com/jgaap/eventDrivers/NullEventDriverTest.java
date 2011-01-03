/**
 * 
 */
package com.jgaap.eventDrivers;

import static org.junit.Assert.*;

import java.util.Vector;

import org.junit.Test;

import com.jgaap.jgaapConstants;
import com.jgaap.generics.Document;
import com.jgaap.generics.DocumentSet;
import com.jgaap.generics.Event;
import com.jgaap.generics.EventSet;

/**
 * @author Joshua Booth
 *
 */

public class NullEventDriverTest{

    /**
     * Test method for {@link com.jgaap.eventDrivers.NullEventDriver#createEventSet(com.jgaap.generics.DocumentSet)}.
     */
	@Test
	public void testCreateEventSetDocumentSet() {
	    /*Test One - Text to Text with new line char*/
	    Document doc = new Document();
	    //Text Taken from Patrick Juola to standardize testing	
	    doc.readStringText("sir I send a rhyme excelling\n"+
				   "in sacred truth and rigid spelling\n"+
				   "numerical sprites elucidate\n"+
				   "for me the lexicons full weight\n"+
				   "if nature gain who can complain\n"+
				   "tho dr johnson fulminate");
	     DocumentSet docSet = new DocumentSet(doc);
	     EventSet sampleEventSet = new NullEventDriver().createEventSet(docSet);
	     EventSet expectedEventSet = new EventSet();
	     Vector<Event> tmp = new Vector();
	     tmp.add(new Event("sir I send a rhyme excelling\n"+
				   "in sacred truth and rigid spelling\n"+
				   "numerical sprites elucidate\n"+
				   "for me the lexicons full weight\n"+
				   "if nature gain who can complain\n"+
			           "tho dr johnson fulminate"));
	     expectedEventSet.events.addAll(tmp);
	     assertTrue(expectedEventSet.equals(sampleEventSet));

	     /*null case would be covered by the spaces in the above test*/
	  }
	}
    