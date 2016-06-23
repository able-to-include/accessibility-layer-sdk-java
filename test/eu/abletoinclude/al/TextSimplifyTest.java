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

/**
 * Unit test for the getTextToSimplifiedText method.
 * 
 * @author Ariadna Servicios Informaticos, S. L.
 * @version 2.1
 */
public class TextSimplifyTest {

	@Test
	public void testEN() {
		String text = "Editors, who receive no royalties or expenses and who are only very rarely commissioned by the Society, are encouraged to approach the Editorial Secretary with a detailed proposal of the text they wish to suggest to the Society early in their work.";
		String language = "english";
		AbleAccessibilityLayer al = new AbleAccessibilityLayer();
		
		TextToSimplifiedTextResponse result = al.getTextToSimplifiedText(text, language);
		//System.out.println(result.getSimplifiedText());
		assertEquals(200, result.getStatus());
	}
	
	@Test
	public void testES1() {
		String text = "Se registraron en España un total de 451 agresiones a facultativos.";
		String language = "spanish";
		AbleAccessibilityLayer al = new AbleAccessibilityLayer();
		
		TextToSimplifiedTextResponse result = al.getTextToSimplifiedText(text, language);
		//System.out.println(result.getSimplifiedText());
		assertEquals(200, result.getStatus());
	}
	
	@Test
	public void testES2() {
		String text = "Alrededor de 390.000 personas han regresado a sus casas desde que se vieran obligadas a desplazarse por las inundaciones causadas por las lluvias monzónicas del pasado verano en Pakistán.";
		String language = "spanish";
		AbleAccessibilityLayer al = new AbleAccessibilityLayer();
		
		TextToSimplifiedTextResponse result = al.getTextToSimplifiedText(text, language);
		//System.out.println(result.getSimplifiedText());
		assertEquals(200, result.getStatus());
	}
	
	@Test
	public void testES3() {
		String text = "El alcalde de Madrid, Alberto Ruiz-Gallardón, inauguró hoy esta nueva biblioteca, ubicada dentro del Centro Cultural Eduardo Úrculo y dedicada a la filósofa María Zambrano, que dará servicio a los residentes de seis barrios del distrito de Tetuán.";
		String language = "spanish";
		AbleAccessibilityLayer al = new AbleAccessibilityLayer();
		
		TextToSimplifiedTextResponse result = al.getTextToSimplifiedText(text, language);
		//System.out.println(result.getSimplifiedText());
		assertEquals(200, result.getStatus());
	}

}
