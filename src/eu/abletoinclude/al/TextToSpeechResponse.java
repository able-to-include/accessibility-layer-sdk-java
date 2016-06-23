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

import java.net.URL;

/**
 * Abstraction of the text to speech service response.
 * 
 * @author Ariadna Servicios Informaticos, S. L.
 * @version 2.1
 */
public class TextToSpeechResponse {
	/**
	 * The request status.
	 * @see https://github.com/able-to-include/accessibility-layer/wiki/Accessibility-Layer-docs#3-error-codes
	 */
	private long status;
	/**
	 * The URL address where the audio file with the text speech can be found.
	 */
	private URL speechURL;
	
	/**
	 * Constructor of the class.
	 * 
	 * @param status The request status.
	 * @param speechURL The URL address where the audio file with the text speech can be found.
	 */
	protected TextToSpeechResponse(long status, URL speechURL) {
		super();
		this.status = status;
		this.speechURL = speechURL;
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
	 * Returns the audio file URL address.
	 * @return The audio file URL address.
	 */
	public URL getSpeechURL() {
		return speechURL;
	}
	
	/**
	 * Sets the audio file URL address.
	 * @param speechURL The audio file URL address.
	 */
	protected void setSpeechURL(URL speechURL) {
		this.speechURL = speechURL;
	}
	
	@Override
	public String toString() {
		return "status: " + this.getStatus() + "\nspeech url: " + this.getSpeechURL().toString() + "";
	}
}