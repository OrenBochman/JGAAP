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
package com.jgaap.classifiers;

import java.util.Vector;

import com.jgaap.generics.AnalysisDriver;
import com.jgaap.generics.EventHistogram;
import com.jgaap.generics.EventSet;

/**
 * NullAnalysis : no analysis, but prints histogram of event sets received
 */
public class NullHistAnalysis extends AnalysisDriver {
	public String displayName(){
	    return "Null Histogram Analysis";
	}

	public String tooltipText(){
	    return "Prints a Histogram of Event Sets";
	}

	public boolean showInGUI(){
	    return true;
	}

    @Override
    public String analyze(EventSet unknown, Vector<EventSet> known) {
        int i;

        EventHistogram h1 = new EventHistogram();
        EventHistogram h2;

        for (i = 0; i < unknown.size(); i++) {
            h1.add(unknown.eventAt(i));
        }

        // for (Event e : unknown)
        // h1.add(e);

        System.out.println("--- Unknown Event Set ---");
        System.out.println(h1);

        for (i = 0; i < known.size(); i++) {
            h2 = new EventHistogram();
            for (int j = 0; j < known.elementAt(i).size(); j++) {
                h2.add(known.elementAt(i).eventAt(j));
            }
            // for(Event e : known.elementAt(i))
            // h2.add(e);
            System.out.println("--- Known Event Set #" + i + " ---");
            System.out.println(h2);
        }

        return "No analysis performed.\n";
    }

    @Override
    public String analyzeAverage(EventSet u, Vector<EventSet> k) {
        return analyze(u, k);
    }
}