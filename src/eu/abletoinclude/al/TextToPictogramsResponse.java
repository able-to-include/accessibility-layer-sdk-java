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
package eu.abletoinclude.al;

import java.util.Iterator;
import java.util.List;

import eu.abletoinclude.al.model.Pictogram;

/**
 * Abstraction of the text to pictograms service response.
 * 
 * @author Ariadna Servicios Informaticos, S. L.
 * @version 2.1
 */
public class TextToPictogramsResponse {
	/**
	 * The request status.
	 * @see https://github.com/able-to-include/accessibility-layer/wiki/Accessibility-Layer-docs#3-error-codes
	 */
	private long status;
	/**
	 * The list of pictograms.
	 */
	private List<Pictogram> pictogramList;
	
	/**
	 * Constructor of the class.
	 * 
	 * @param status The request status.
	 * @param pictogramList The list of pictograms.
	 */
	protected TextToPictogramsResponse(int status, List<Pictogram> pictogramList) {
		super();
		this.status = status;
		this.pictogramList = pictogramList;
	}

	/**
	 * Returns the request status.
	 * @return The request status.
	 */
	public long getStatus() {
		return status;
	}

	/**
	 * Sets the request status.
	 * @param status The status to set.
	 */
	protected void setStatus(long status) {
		this.status = status;
	}
	
	/**
	 * Returns the list of pictograms.
	 * @return The list of pictograms.
	 */
	public List<Pictogram> getPictogramList() {
		return pictogramList;
	}

	/**
	 * Sets the pictogram list.
	 * @param pictogramList The pictogram list to set.
	 */
	protected void setPictogramList(List<Pictogram> pictogramList) {
		this.pictogramList = pictogramList;
	}
	
	@Override
	public String toString() {
		String string = "status: " + this.getStatus() + "\npictogram list:";
		Iterator<Pictogram> it = this.getPictogramList().iterator();
		while(it.hasNext()) {
			Pictogram pictogram = it.next();
			string += "\n\tconcept: " + pictogram.getConcept() + "\tpictogram URL address: " + pictogram.getPictogramFile();
		}
		return string;
	}
}
