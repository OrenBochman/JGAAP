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
import com.jgaap.generics.NumericEventSet;

/**
 * @author Patrick Juola
 *
 */
public class TruncatedReactionTimeEventDriverTest {

	/**
	 * Test method for {@link com.jgaap.eventDrivers.TruncatedReactionTimeEventDriver#createEventSet(com.jgaap.generics.DocumentSet)}.
	 */
	@Test
	public void testCreateEventSetDocumentSet() {
		/* test case 1 -- no punctuation */
		Document doc = new Document();
		// test just first and last few words rathre than
		// entire 40k corpus
		doc.readStringText(
"a aah Aaron aback abacus abandon abandoned zones zoning zoo " +
"zoologist zoology zoom zooming zooms zucchini Zurich");


		DocumentSet docSet = new DocumentSet(doc);
		EventSet sampleEventSet = new TruncatedReactionTimeEventDriver().createEventSet(docSet);
		EventSet expectedEventSet = new NumericEventSet();
		Vector<Event> tmp = new Vector<Event>();

		tmp.add(new Event("79"));
		tmp.add(new Event("81"));
		tmp.add(new Event("73"));
		tmp.add(new Event("79"));
		tmp.add(new Event("96"));
		tmp.add(new Event("69"));
		tmp.add(new Event("86"));
		tmp.add(new Event("60"));
		tmp.add(new Event("72"));
		tmp.add(new Event("57"));
		tmp.add(new Event("71"));
		tmp.add(new Event("68"));
		tmp.add(new Event("54"));
		tmp.add(new Event("70"));
		tmp.add(new Event("66"));
		tmp.add(new Event("84"));
		tmp.add(new Event("76"));

		expectedEventSet.events.addAll(tmp);

// System.out.println("Expected is " + expectedEventSet.toString());
// System.out.println("Actual is " + sampleEventSet.toString());
		assertTrue(expectedEventSet.equals(sampleEventSet));
	}

}
