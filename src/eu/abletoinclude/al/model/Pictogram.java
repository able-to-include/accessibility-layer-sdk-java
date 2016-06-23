/**
 * Apache License, Version 2.0
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * The work represented by this file is partially funded by the ABLE-TO-INCLUDE
 * project through the European Commission's ICT Policy Support Programme as
 * part of the Competitiveness & Innovation Programme (Grant no.: 621055)
 * Copyright © 2016, ABLE-TO-INCLUDE Consortium.
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS, WITHOUT
 * WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions & limitations
 * under the License.
 */

package eu.abletoinclude.al.model;

import java.net.URL;

/**
 * Class to represent a Pictogram.
 * 
 * @author Ariadna Servicios Informaticos, S. L.
 * @version 2.1
 */
public class Pictogram {
	/**
	 * The URL address where the pictogram file can be found.
	 */
	private URL pictogramFile;
	/**
	 * The word to which the pictogram is associated.
	 */
	private String concept;
	
	/**
	 * Constructor of the class.
	 * 
	 * @param pictogramFile The pictogram URL address.
	 * @param concept The pictogram concept.
	 */
	public Pictogram(URL pictogramFile, String concept) {
		super();
		this.pictogramFile = pictogramFile;
		this.concept = concept;
	}
	
	/**
	 * Returns the pictogram URL address.
	 * @return The pictogram URL address.
	 */
	public URL getPictogramFile() {
		return pictogramFile;
	}
	
	/**
	 * Sets the pictogram URL address.
	 * 
	 * @param pictogramFile The pictogram URL address.
	 */
	public void setPictogramFile(URL pictogramFile) {
		this.pictogramFile = pictogramFile;
	}
	
	/**
	 * Returns the pictogram concept.
	 * @return The pictogram concept.
	 */
	public String getConcept() {
		return concept;
	}
	
	/**
	 * Sets the pictogram concept.
	 * 
	 * @param concept The pictogram concept.
	 */
	public void setConcept(String concept) {
		this.concept = concept;
	}
}
