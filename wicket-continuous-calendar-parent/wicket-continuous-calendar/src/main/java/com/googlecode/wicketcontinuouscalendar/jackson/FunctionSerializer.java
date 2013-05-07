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
package com.googlecode.wicketcontinuouscalendar.jackson;

import java.io.IOException;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.googlecode.wicketcontinuouscalendar.options.Function;

/**
 * Serializer for a jQuery functions.
 * 
 * @author Paul Bors (Paul@Bors.ws)
 */
public class FunctionSerializer extends JsonSerializer<Function> {
    
    @Override
    public void serialize(final Function value, final JsonGenerator jgen, final SerializerProvider provider)
        throws IOException, JsonProcessingException {
        
        // Raw values are needed otherwise the JavaScript function can not be evaluated
        jgen.writeRawValue(value.getFunction());
    }

}
