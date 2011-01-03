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
package com.jgaap.eventDrivers;

import com.jgaap.generics.DocumentSet;
import com.jgaap.generics.EventSet;

/**
 * Extract tri-grams of words as features.
 * @author John Noecker Jr.
 *
 */
public class WordTriGramEventDriver extends NGramEventDriver {
    @Override
    public String displayName(){
    	return "Word TriGrams";
    }
    
    @Override
    public String tooltipText(){
    	return "Groups of Three Successive Words";
    }
    
    @Override
    public boolean showInGUI(){
    	return true;
    }

    private NGramEventDriver theDriver;

    @Override
    public EventSet createEventSet(DocumentSet ds) {
        theDriver = new NGramEventDriver();
        theDriver.setParameter("N", "3");
        return theDriver.createEventSet(ds);
    }
}