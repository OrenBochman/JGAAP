/**
 *   JGAAP -- Java Graphical Authorship Attribution Program
 *   Copyright (C) 2009 Patrick Juola
 *
 *   This program is free software: you can redistribute it and/or modify
 *   it under the terms of the GNU General Public License as published by
 *   the Free Software Foundation under version 3 of the License.
 *
 *   This program is distributed in the hope that it will be useful,
 *   but WITHOUT ANY WARRANTY; without even the implied warranty of
 *   MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 *   GNU General Public License for more details.
 *
 *   You should have received a copy of the GNU General Public License
 *   along with this program.  If not, see <http://www.gnu.org/licenses/>.
 *
 **/
package com.jgaap.distances;

import java.util.Enumeration;

import com.jgaap.generics.DivergenceFunction;
import com.jgaap.generics.Event;
import com.jgaap.generics.EventHistogram;
import com.jgaap.generics.EventSet;

/**
 * Cross-entropy "divergence" for Nearest Neighbor. It's actually a rather poor
 * distance as it is not only non-commutative, but it isn't zero on identical
 * histograms.
 * 
 * Note: This is a faster implementation of Cross Entropy than the built-in version.
 * 
 * @author Ryan
 * @version 1.0
 */
public class CrossEntropyDivergence extends DivergenceFunction {
	public String displayName(){
	    return "RN Cross Entropy";
	}

	public String tooltipText(){
	    return "Ryan-Noecker Cross Entropy (Faster)";
	}

	public boolean showInGUI(){
	    return true;
	}
    /**
     * Returns cross-entropy between event sets es1 and es2
     * 
     * @param es1
     *            The first EventSet
     * @param es2
     *            The second EventSet
     * @return the cross-entropy H(es1,es2)
     */
    @Override
    public double divergence(EventSet es1, EventSet es2) {
        EventHistogram h1 = new EventHistogram();
        EventHistogram h2 = new EventHistogram();
        double distance = 0;
        Enumeration<Event> EventList;
        Event theEvent;

        for (int i = 0; i < es1.size(); i++) {
            h1.add(es1.eventAt(i));
        }

        for (int i = 0; i < es2.size(); i++) {
            h2.add(es2.eventAt(i));
        }

        EventList = h1.events();
        while (EventList.hasMoreElements()) {

            theEvent = EventList.nextElement();
            // System.out.println(Math.log(h1.getNormalizedFrequency(theEvent)));
            // System.out.println(Math.log(h2.getRelativeFrequency(theEvent))+" "+(h2.getRelativeFrequency(theEvent)));
            distance += (h2.getRelativeFrequency(theEvent) > 0 ? 
            		 -1 * (h1.getRelativeFrequency(theEvent) * Math.log(h2.getRelativeFrequency(theEvent))) 
            		: -1 *(h1.getRelativeFrequency(theEvent) * Math.log(h2.getRelativeFrequencySmoothing())));

            // System.out.println(((h2.getRelativeFrequenceySmoothing())));
        }
        return distance;
    }

	
}