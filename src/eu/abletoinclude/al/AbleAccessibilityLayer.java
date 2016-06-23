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

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.List;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import eu.abletoinclude.al.model.Pictogram;
import eu.abletoinclude.al.model.PictogramBase;

/**
 * Class providing easy access to the ABLE Accessibility Layer services.
 * 
 * @author Ariadna Servicios Informaticos, S. L.
 * @version 2.1
 */
public class AbleAccessibilityLayer {
	
	/**
	 * The Accessibility Layer API root.
	 */
	private final static String BASE_URL = "http://al.abletoinclude.eu/";
	
	/**
	 * Returns a <code>TextToPictogramsResponse</code> that contains the
	 * request status and the list of pictograms.
	 * 
	 * @param text The text you want to transform into pictograms.
	 * @param language The language in which the text has been defined.
	 * @param type The <code>PictogramBase</code> used to show select the
	 * pictograms.
	 * @param parallel (Optional) If it is set to true, the pictograms will be
	 * defined by the concept and the image file. Otherwise, they will be
	 * defined just for their image file.
	 * @return The service response.
	 */
	public TextToPictogramsResponse getTextToPictograms(String text, String language, PictogramBase type, boolean parallel) {
		List<Pictogram> pictogramList = new ArrayList<Pictogram>();
		int status = 500;
		TextToPictogramsResponse response = new TextToPictogramsResponse(status, pictogramList);
		
		String textToPictogramsURL = BASE_URL + "Text2Picto.php";
		
		try {
			text = URLEncoder.encode(text, "UTF-8");
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
			return response;
		}
		String parameters = "?";
		parameters += "text="+text;
		parameters += "&language="+language;
		parameters += "&type="+type;
		parameters += "&parallel="+Boolean.toString(parallel);
		JSONObject result;
		try {
			result = sendGET(textToPictogramsURL, parameters);
		} catch (IOException e) {
			e.printStackTrace();
			return response;
		} catch (ParseException e) {
			e.printStackTrace();
			return response;
		}
		//System.out.println(result.toJSONString());
		
		
		if (parallel) {
			JSONArray pictos = (JSONArray) result.get("pictos");
			for(int i=0; i < pictos.size(); i++) {
				JSONArray picto = null;
				try {
					picto = (JSONArray) pictos.get(i);
				} catch(Exception e) {
					continue;
				}
				URL pictogramFile = null;
				String pictogramURL = (String) picto.get(0);
				if (pictogramURL.length() > 0) {
					try {
						pictogramFile = new URL(pictogramURL);		
					} catch (MalformedURLException e) {
						e.printStackTrace();
						continue;
					}
				}
				String concept = (String) picto.get(1);
				response.getPictogramList().add(new Pictogram(pictogramFile, concept));
			}
		} else {
			JSONArray pictos = (JSONArray) result.get("pictos");
			for (int i=0; i < pictos.size(); i++) {
				String picto = (String) pictos.get(i);
				if (!picto.equals("\n")) {
					if (picto.startsWith("http")) {
						try {
							response.getPictogramList().add(new Pictogram(new URL(picto), null));
						} catch (MalformedURLException e) {
							e.printStackTrace();
							return response;
						}
					} else {
						response.getPictogramList().add(new Pictogram(null, picto));
					}
				}
			}
		}
		response.setStatus((long) (result.get("status")));
		
		return response;
	}
	
	/**
	 * Returns a <code>TextToSpeechResponse</code> that contains the
	 * request status and the <code>URL</code> address to the audio file.
	 * 
	 * @param text The text you want to transform into pictograms.
	 * @param language The language in which the text has been defined.
	 * @return The service response.
	 */
	public TextToSpeechResponse getTextToSpeech(String text, String language) {
		TextToSpeechResponse response = new TextToSpeechResponse(500, null);
		URL audioSpeechURL = null;
		
		String textToSpeechURL = BASE_URL + "Text2Speech.php";
		try {
			text = URLEncoder.encode(text, "UTF-8");
			String parameters = "?";
			parameters += "text="+text;
			parameters += "&language="+language;
			
			JSONObject result = sendGET(textToSpeechURL, parameters);
			String audioSpeech = (String) result.get("audioSpeech");
			response.setStatus((long) (result.get("status")));
			audioSpeechURL = new URL(audioSpeech);
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ParseException e) {
			e.printStackTrace();
		}
		response.setSpeechURL(audioSpeechURL);
		return response;
	}
	
	/**
	 * Returns a <code>TextToSimplifiedTextResponse</code> that contains the
	 * request status and the simplified text.
	 * 
	 * @param text The text you want to transform into pictograms.
	 * @param language The language in which the text has been defined.
	 * @return The service response.
	 */
	public TextToSimplifiedTextResponse getTextToSimplifiedText(String text, String language) {
		TextToSimplifiedTextResponse response = new TextToSimplifiedTextResponse(500, "");
		
		String simplextURL = BASE_URL + "Simplext.php";
		
		try {
			text = URLEncoder.encode(text, "UTF-8");
			String parameters = "?";
			parameters += "text="+text;
			parameters += "&language="+language;
			
			JSONObject result = sendGET(simplextURL, parameters);
			String textSimplified = (String) result.get("textSimplified");
			response.setStatus((long) (result.get("status")));
			response.setSimplifiedText(textSimplified);
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return response;
	}
	
	
	/**
	 * Sends an HTTP request using the GET method to the given URL address
	 * using the given parameters.
	 * 
	 * @param url The URL address where the user wants to send the HTTP request.
	 * @param parameters The parameters configuring the request.
	 * @return A JSON object with the response.
	 * @throws IOException
	 * @throws ParseException
	 */
	private JSONObject sendGET(String url, String parameters) throws IOException, ParseException {
		JSONObject result = null;
		URL obj = new URL(url + parameters);
		//System.out.println(obj.toString());
		HttpURLConnection con = (HttpURLConnection) obj.openConnection();
		con.setRequestMethod("GET");
		int responseCode = con.getResponseCode();
		//System.out.println("GET Response Code :: " + responseCode);
		if (responseCode == HttpURLConnection.HTTP_OK) { // success
			BufferedReader in = new BufferedReader(new InputStreamReader(
					con.getInputStream()));
			String inputLine;
			StringBuffer response = new StringBuffer();
			while ((inputLine = in.readLine()) != null) {
				response.append(inputLine);
			}
			in.close();
			JSONParser parser = new JSONParser();
			result = (JSONObject) parser.parse(response.toString());
		} else {
			//System.out.println("GET request not worked");
		}
		return result;
	}
}