package de.htsolutions.sling.testing;

import com.google.common.collect.ImmutableMap;
import org.apache.sling.api.resource.ResourceResolver;
import org.apache.sling.testing.mock.sling.ResourceResolverType;
import org.apache.sling.testing.mock.sling.builder.ContentBuilder;
import org.apache.sling.testing.mock.sling.junit.SlingContext;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;

/**
 * Created by Christoph on 16.09.2016.
 */
public class FormularServiceTest {

    @Rule
    public final SlingContext slingContext = new SlingContext(ResourceResolverType.JCR_MOCK);

    @Test
    public void testFormService() {
        FormularService formularService = slingContext.registerInjectActivateService(new FormularService());
        formularService.findFormByFormId("331");
//        Assert.assertNotNull(form);
    }

    @Before
    public void prepare() throws Exception {
        ResourceResolver resolver = slingContext.resourceResolver();
        ContentBuilder contentBuilder = new ContentBuilder(resolver);
        contentBuilder.resource("/content/forms/test1", ImmutableMap.<String, Object>builder()
                .put("formId", "331")
                .build());
    }

}