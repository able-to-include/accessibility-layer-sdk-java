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

import static org.junit.Assert.*;

import org.junit.Test;

import eu.abletoinclude.al.model.PictogramBase;

/**
 * Unit test for the getTextToPictograms method.
 * 
 * @author Ariadna Servicios Informaticos, S. L.
 * @version 2.1
 */
public class TextToPictogramsTest {

	@Test
	public void testScleraES() {
		String text = "El hombre bebe vino tinto.";
		String language = "spanish";
		AbleAccessibilityLayer al = new AbleAccessibilityLayer();
		TextToPictogramsResponse result = al.getTextToPictograms(text, language, PictogramBase.sclera, false);
		/*
		List<Pictogram> pictogramList = result.getPictogramList();
		Iterator<Pictogram> it = pictogramList.iterator();
		while(it.hasNext()) {
			Pictogram pictogram = it.next();
			System.out.println(pictogram.getPictogramFile() + "(" + pictogram.getConcept() + ")");
		}
		*/
		assertEquals(200L, result.getStatus());
	}
	
	@Test
	public void testBetaES() {
		String text = "El hombre bebe vino tinto.";
		String language = "spanish";
		AbleAccessibilityLayer al = new AbleAccessibilityLayer();
		TextToPictogramsResponse result = al.getTextToPictograms(text, language, PictogramBase.beta, false);
		/*
		List<Pictogram> pictogramList = result.getPictogramList();
		Iterator<Pictogram> it = pictogramList.iterator();
		while(it.hasNext()) {
			Pictogram pictogram = it.next();
			System.out.println(pictogram.getPictogramFile() + "(" + pictogram.getConcept() + ")");
		}
		*/
		assertEquals(200L, result.getStatus());
	}
	
	@Test
	public void testScleraEN() {
		String text = "The man drinks red wine.";
		String language = "english";
		AbleAccessibilityLayer al = new AbleAccessibilityLayer();
		TextToPictogramsResponse result = al.getTextToPictograms(text, language, PictogramBase.sclera, false);
		/*
		List<Pictogram> pictogramList = result.getPictogramList();
		Iterator<Pictogram> it = pictogramList.iterator();
		while(it.hasNext()) {
			Pictogram pictogram = it.next();
			System.out.println(pictogram.getPictogramFile() + "(" + pictogram.getConcept() + ")");
		}
		*/
		assertEquals(200L, result.getStatus());
	}
	
	@Test
	public void testBetaEN() {
		String text = "The man drinks red wine.";
		String language = "english";
		AbleAccessibilityLayer al = new AbleAccessibilityLayer();
		TextToPictogramsResponse result = al.getTextToPictograms(text, language, PictogramBase.beta, false);
		/*
		List<Pictogram> pictogramList = result.getPictogramList();
		Iterator<Pictogram> it = pictogramList.iterator();
		while(it.hasNext()) {
			Pictogram pictogram = it.next();
			System.out.println(pictogram.getPictogramFile() + "(" + pictogram.getConcept() + ")");
		}
		*/
		assertEquals(200L, result.getStatus());
	}
	
	@Test
	public void testScleraNL() {
		String text = "Hij drinkt rode wijn.";
		String language = "dutch";
		AbleAccessibilityLayer al = new AbleAccessibilityLayer();
		TextToPictogramsResponse result = al.getTextToPictograms(text, language, PictogramBase.sclera, false);
		/*
		List<Pictogram> pictogramList = result.getPictogramList();
		Iterator<Pictogram> it = pictogramList.iterator();
		while(it.hasNext()) {
			Pictogram pictogram = it.next();
			System.out.println(pictogram.getPictogramFile() + "(" + pictogram.getConcept() + ")");
		}
		*/
		assertEquals(200L, result.getStatus());
	}
	
	@Test
	public void testBetaNL() {
		String text = "Hij drinkt rode wijn.";
		String language = "dutch";
		AbleAccessibilityLayer al = new AbleAccessibilityLayer();
		TextToPictogramsResponse result = al.getTextToPictograms(text, language, PictogramBase.beta, false);
		/*
		List<Pictogram> pictogramList = result.getPictogramList();
		Iterator<Pictogram> it = pictogramList.iterator();
		while(it.hasNext()) {
			Pictogram pictogram = it.next();
			System.out.println(pictogram.getPictogramFile() + "(" + pictogram.getConcept() + ")");
		}
		*/
		assertEquals(200L, result.getStatus());
	}
	
	@Test
	public void testScleraESParallel() {
		String text = "El hombre bebe vino tinto.";
		String language = "spanish";
		AbleAccessibilityLayer al = new AbleAccessibilityLayer();
		TextToPictogramsResponse result = al.getTextToPictograms(text, language, PictogramBase.sclera, true);
		/*
		List<Pictogram> pictogramList = result.getPictogramList();
		Iterator<Pictogram> it = pictogramList.iterator();
		while(it.hasNext()) {
			Pictogram pictogram = it.next();
			System.out.println(pictogram.getPictogramFile() + "(" + pictogram.getConcept() + ")");
		}
		*/
		assertEquals(200L, result.getStatus());
	}
	
	@Test
	public void testBetaESParallel() {
		String text = "El hombre bebe vino tinto.";
		String language = "spanish";
		AbleAccessibilityLayer al = new AbleAccessibilityLayer();
		TextToPictogramsResponse result = al.getTextToPictograms(text, language, PictogramBase.beta, true);
		/*
		List<Pictogram> pictogramList = result.getPictogramList();
		Iterator<Pictogram> it = pictogramList.iterator();
		while(it.hasNext()) {
			Pictogram pictogram = it.next();
			System.out.println(pictogram.getPictogramFile() + "(" + pictogram.getConcept() + ")");
		}
		*/
		assertEquals(200L, result.getStatus());
	}
	
	@Test
	public void testScleraENParallel() {
		String text = "The man drinks red wine.";
		String language = "english";
		AbleAccessibilityLayer al = new AbleAccessibilityLayer();
		TextToPictogramsResponse result = al.getTextToPictograms(text, language, PictogramBase.sclera, true);
		/*
		List<Pictogram> pictogramList = result.getPictogramList();
		Iterator<Pictogram> it = pictogramList.iterator();
		while(it.hasNext()) {
			Pictogram pictogram = it.next();
			System.out.println(pictogram.getPictogramFile() + "(" + pictogram.getConcept() + ")");
		}
		*/
		assertEquals(200L, result.getStatus());
	}
	
	@Test
	public void testBetaENParallel() {
		String text = "The man drinks red wine.";
		String language = "english";
		AbleAccessibilityLayer al = new AbleAccessibilityLayer();
		TextToPictogramsResponse result = al.getTextToPictograms(text, language, PictogramBase.beta, true);
		/*
		List<Pictogram> pictogramList = result.getPictogramList();
		Iterator<Pictogram> it = pictogramList.iterator();
		while(it.hasNext()) {
			Pictogram pictogram = it.next();
			System.out.println(pictogram.getPictogramFile() + "(" + pictogram.getConcept() + ")");
		}
		*/
		assertEquals(200L, result.getStatus());
	}
	
	@Test
	public void testScleraNLParallel() {
		String text = "Hij drinkt rode wijn.";
		String language = "dutch";
		AbleAccessibilityLayer al = new AbleAccessibilityLayer();
		TextToPictogramsResponse result = al.getTextToPictograms(text, language, PictogramBase.sclera, true);
		/*
		List<Pictogram> pictogramList = result.getPictogramList();
		Iterator<Pictogram> it = pictogramList.iterator();
		while(it.hasNext()) {
			Pictogram pictogram = it.next();
			System.out.println(pictogram.getPictogramFile() + "(" + pictogram.getConcept() + ")");
		}
		*/
		assertEquals(200L, result.getStatus());
	}
	
	@Test
	public void testBetaNLParallel() {
		String text = "Hij drinkt rode wijn.";
		String language = "dutch";
		AbleAccessibilityLayer al = new AbleAccessibilityLayer();
		TextToPictogramsResponse result = al.getTextToPictograms(text, language, PictogramBase.beta, true);
		/*
		List<Pictogram> pictogramList = result.getPictogramList();
		Iterator<Pictogram> it = pictogramList.iterator();
		while(it.hasNext()) {
			Pictogram pictogram = it.next();
			System.out.println(pictogram.getPictogramFile() + "(" + pictogram.getConcept() + ")");
		}
		*/
		assertEquals(200L, result.getStatus());
	}
}
