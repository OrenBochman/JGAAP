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
import com.jgaap.generics.EventSet;

/** 
 * Return a random authorship label from the list of known authors.
 * @author John Noecker Jr.
 *
 */
public class RandomAnalysis extends AnalysisDriver {
	public String displayName(){
	    return "Random Analysis";
	}

	public String tooltipText(){
	    return "Assign authorship randomly (useful to establish various baseline results";
	}

	public boolean showInGUI(){
	    return false;
	}
    @Override
    public String analyze(EventSet unknown, Vector<EventSet> known) {
        int numChoices = known.size();
        EventSet s = known.elementAt((int) (Math.random() * numChoices));
        return s.getAuthor();
    }
}