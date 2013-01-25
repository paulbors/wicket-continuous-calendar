/**
 *   Copyright 2012 Wicket Continuous Calendar (http://Wicket-Continuous-Calendar.GoogleCode.com/)
 *
 *   Licensed under the Apache License, Version 2.0 (the "License");
 *   you may not use this file except in compliance with the License.
 *   You may obtain a copy of the License at
 *        http://www.apache.org/licenses/LICENSE-2.0
 *
 *   Unless required by applicable law or agreed to in writing, software
 *   distributed under the License is distributed on an "AS IS" BASIS,
 *   WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *   See the License for the specific language governing permissions and
 *   limitations under the License.
 */

package com.googlecode.wicketcontinuouscalendar.wicket15;

import com.googlecode.wicketcontinuouscalendar.jackson.JsonRenderer;

/**
 * Factory class responsible for creating a {@link JsonRenderer} instance that
 * matches the needs of wicket-continuous-calendar-wicket15.
 * 
 * @author Paul Bors (Paul@Bors.ws)
 * 
 */
public class Wicket15JsonRendererFactory {

	private static final Wicket15JsonRendererFactory INSTANCE = new Wicket15JsonRendererFactory();

	private static JsonRenderer RENDERER;

	public static Wicket15JsonRendererFactory getInstance() {
		return INSTANCE;
	}

	private Wicket15JsonRendererFactory() {

	}

	/**
	 * Returns the singleton instance of the {@link JsonRenderer} that is
	 * configured for Wicket 1.5.x.
	 * 
	 * @return the singleton {@link JsonRenderer}
	 */
	public JsonRenderer getRenderer() {
		if (RENDERER == null) {
			RENDERER = createWicket15JsonRenderer();
		}
		return RENDERER;
	}

	/**
	 * This method creates a {@link JsonRenderer} that is configured for Wicket
	 * 1.5.x.
	 * 
	 * @return
	 */
	private JsonRenderer createWicket15JsonRenderer() {
		return new JsonRenderer();
	}

}
