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
import com.jgaap.generics.Event;
import com.jgaap.generics.EventDriver;
import com.jgaap.generics.EventSet;

/** 
 * Extract whitespace-separated words (including punctuation) as features.
 */
public class NaiveWordEventDriver extends EventDriver {

    @Override
    public String displayName(){
    	return "Words";
    }
    
    @Override
    public String tooltipText(){
    	return "Words (White Space as Separators)";
    }
    
    @Override
    public boolean showInGUI(){
    	return true;
    }

 
    @Override
    public EventSet createEventSet(DocumentSet ds) {
        EventSet es = new EventSet(ds.getDocument(0).getAuthor());
        for (int i = 0; i < ds.documentCount(); i++) {
            String current = ds.getDocument(i).stringify();
            // \s is shorthand for whitespace, remember the \\ to get the \
            String[] result = current.split("\\s");
            for (int j = 0; j < result.length; j++) {
                if (result[j].length() > 0) {
                    es.events.add(new Event(result[j]));
                }
            }
            // mark edges between documents
            //es.events.add(new Event("JGAAP:DOCUMENTBOUNDARY"));
        }
        return es;
    }

}