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

import com.jgaap.generics.*;

/**
 * This event set is the number of syllables in a given word, defined (naively)
 * by the number of vowel clusters. This will not work well for words like
 * "react" or "safes," but should be a decent approximation. Improvements
 * welcome, of course
 */
public class WordSyllablesEventDriver extends NumericEventDriver {

    @Override
    public String displayName(){
    	return "Syllables Per Word";
    }
    
    @Override
    public String tooltipText(){
    	return "Number of vowel clusters/word (min 1)";
    }
    
    @Override
    public boolean showInGUI(){
    	return true;
    }

    public EventDriver wordtokenizer = new NaiveWordEventDriver();

    /* define vowels for cluster elements */
    public String      vowellist     = "aeiouyAEIOUY";

    @Override
    public NumericEventSet createEventSet(DocumentSet ds) {
        EventSet es = wordtokenizer.createEventSet(ds);
        NumericEventSet newEs = new NumericEventSet();
        newEs.setAuthor(es.getAuthor());
        newEs.setNewEventSetID(es.getAuthor());

        for (int i = 0; i < es.size(); i++) {
            String s = (es.eventAt(i)).toString();
            int l = 0;
            for (int j = 0; j < s.length(); j++) {
                if ((vowellist.indexOf(s.charAt(j)) != -1)
                        && ((j == s.length() - 1) || (vowellist.indexOf(s
                                .charAt(j + 1)) == -1))) {
                    l++;
                }
            }
            if (l == 0) {
                l = 1; // handle words like "Dr" by setting to 1
            }
            newEs.events.add(new Event(String.valueOf(l)));
        }
        return newEs;
    }

}