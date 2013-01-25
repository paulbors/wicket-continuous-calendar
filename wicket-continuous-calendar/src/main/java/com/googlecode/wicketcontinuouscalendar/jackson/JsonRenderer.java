/**
 *   Copyright 2012-2013 Wicket Continuous Calendar (http://Wicket-Continuous-Calendar.GoogleCode.com/)
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
package com.googlecode.wicketcontinuouscalendar.jackson;

import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;

/**
 * A renderer for rendering jQueryContinuousCalendar options into JSON objects based on the
 * Jackson Mapping library.
 * 
 * @author Paul Bors (Paul@Bors.ws)
 * 
 */
public class JsonRenderer {

	private final ObjectMapper jacksonMapper;

	private final ContinuousCalendarJacksonModule jacksonModule;

	/**
	 * The default mapper can be used to bypass the serializers registered in the
	 * {@link ContinuousCalendarJacksonModule}.
	 */
	public final static ObjectMapper DEFAULT_MAPPER = createDefaultObjectMapper();

	public JsonRenderer() {
		this.jacksonModule = new ContinuousCalendarJacksonModule();
		this.jacksonMapper = createJacksonMapper();
	}

	/**
	 * This method gives the opportunity to add a custom serializer to serializer
	 * one of the ContinuousCalendar option classes. It may be necessary to serialize
	 * certain option classes differently for different web frameworks.
	 * 
	 * @param clazz
	 *          the option class
	 * @param serializer
	 *          the serializer responsible for serializing objects of the option
	 *          class.
	 */
	public <T> void addSerializer(final Class<T> clazz, final JsonSerializer<T> serializer) {
		this.jacksonModule.addSerializer(clazz, serializer);
	}
	
	private ObjectMapper createJacksonMapper() {
		ObjectMapper mapper = createDefaultObjectMapper();
		mapper.registerModule(this.jacksonModule);
		return mapper;
	}

	private static ObjectMapper createDefaultObjectMapper() {
		ObjectMapper mapper = new ObjectMapper();
		mapper.enable(SerializationFeature.INDENT_OUTPUT);
		mapper.disable(SerializationFeature.WRITE_NULL_MAP_VALUES);
		mapper.disable(SerializationFeature.FAIL_ON_EMPTY_BEANS);
		mapper.setSerializationInclusion(Include.NON_NULL);
		return mapper;
	}

	public String toJson(final Object object) {
		try {
			return this.jacksonMapper.writeValueAsString(object);
		} catch (Exception e) {
			throw new RuntimeException("Error trying to serialize object of type " + object.getClass().getName()
			    + " into JSON!", e);
		}
	}
}
