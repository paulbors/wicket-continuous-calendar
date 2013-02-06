/**
 *   Copyright (C) ${year} Wicket Continuous Calendar (http://Wicket-Continuous-Calendar.GoogleCode.com/)
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
	private static JsonRenderer RENDERER;
	
	/** Applied <a href="http://en.wikipedia.org/wiki/Initialization_on_demand_holder_idiom">initialization on demand holder idiom</a>
	 * thanks to <a href="http://www.linkedin.com/profile/view?id=15730700">Martin Grigorov</a>.
	 * 
	 * @see Wicket-users mailing list archives announcement for
	 * <a href="http://mail-archives.apache.org/mod_mbox/wicket-users/201301.mbox/%3CC5A4DD21-D941-40E2-BD01-D9471C4CB5B9@Bors.ws%3E">
	   Introducing wicket-continuous-calendar</a>
	 */
	private static class LazyHolder {
	    private static final Wicket15JsonRendererFactory INSTANCE = new Wicket15JsonRendererFactory();
	}
	
	public static Wicket15JsonRendererFactory getInstance() {
		return LazyHolder.INSTANCE;
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
	 * This method creates a {@link JsonRenderer} that is configured for Wicket 1.5.x.
	 * 
	 * @return {@link JsonRenderer}
	 */
	private JsonRenderer createWicket15JsonRenderer() {
		return new JsonRenderer();
	}

}
