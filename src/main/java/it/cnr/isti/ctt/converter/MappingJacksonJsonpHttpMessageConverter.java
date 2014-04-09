/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package it.cnr.isti.ctt.converter;

import java.io.IOException;
import org.codehaus.jackson.JsonEncoding;
import org.codehaus.jackson.JsonGenerator;
import org.codehaus.jackson.JsonProcessingException;
import org.springframework.http.HttpOutputMessage;
import org.springframework.http.converter.HttpMessageNotWritableException;
import org.springframework.http.converter.json.MappingJacksonHttpMessageConverter;

/**
 *
 * @author Marco
 */
public class MappingJacksonJsonpHttpMessageConverter extends MappingJacksonHttpMessageConverter {
    @Override
    protected void writeInternal(Object object, HttpOutputMessage outputMessage)
        throws IOException, HttpMessageNotWritableException {
        JsonEncoding encoding = getJsonEncoding(outputMessage.getHeaders().getContentType());
        JsonGenerator jsonGenerator = this.getObjectMapper().getJsonFactory().createJsonGenerator(outputMessage.getBody(), encoding);        
        try {
            String jsonPadding = "callback";                                      
            jsonGenerator.writeRaw(jsonPadding);
            jsonGenerator.writeRaw("(");
            this.getObjectMapper().writeValue(jsonGenerator, object);
            jsonGenerator.writeRaw(")");
            jsonGenerator.flush();
        } catch (JsonProcessingException ex) {
            throw new HttpMessageNotWritableException("Could not write JSON:  "+ ex.getMessage(), ex);
        }
    }
}
