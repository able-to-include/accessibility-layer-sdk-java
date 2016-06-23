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

/**
 * 
 * @author Ariadna Servicios Informaticos, S. L.
 * @version 2.1
 */
public class TextToSimplifiedTextResponse {
	/**
	 * The request status.
	 * @see https://github.com/able-to-include/accessibility-layer/wiki/Accessibility-Layer-docs#3-error-codes
	 */
	private long status;
	/**
	 * The simplified text.
	 */
	private String simplifiedText;
	
	/**
	 * Constructor of the class.
	 * @param status The request status.
	 * @param simplifiedText The simplified text.
	 */
	protected TextToSimplifiedTextResponse(long status, String simplifiedText) {
		super();
		this.status = status;
		this.simplifiedText = simplifiedText;
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
	 * Returns the simplified text.
	 * @return The simplified text.
	 */
	public String getSimplifiedText() {
		return simplifiedText;
	}

	/**
	 * Sets the given simplified text.
	 * @param simplifiedText The simplified text.
	 */
	protected void setSimplifiedText(String simplifiedText) {
		this.simplifiedText = simplifiedText;
	}
	
	@Override
	public String toString() {
		return "status: " + this.getStatus() + "\nsimplified text: \"" + this.getSimplifiedText() + "\"";
	}
}