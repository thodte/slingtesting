package de.htsolutions.sling.testing;

import org.apache.felix.scr.annotations.Component;
import org.apache.felix.scr.annotations.Reference;
import org.apache.felix.scr.annotations.Service;
import org.apache.sling.api.resource.Resource;
import org.apache.sling.api.resource.ResourceResolver;
import org.apache.sling.api.resource.ResourceResolverFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.jcr.query.Query;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

@Component(immediate = true)
@Service(FormularService.class)
public class FormularService {

    private static final Logger logger = LoggerFactory.getLogger(FormularService.class);

    @Reference
    private ResourceResolverFactory factory;


    public void findFormByFormId(String formId) {
        try  {
            final ResourceResolver resourceResolver = factory.getAdministrativeResourceResolver(null);
            String query = "SELECT * FROM [sling:OrderedFolder] AS s WHERE ISDESCENDANTNODE(s,'/content/forms') and [formId]=" + formId;
            Iterator<Resource> formsIter = resourceResolver.findResources(query, Query.JCR_SQL2);
            logger.debug("SQL-Abfrage: {}", query);
            //TODO something with the result

        } catch (Exception e) {
            logger.error("Fehler", e);
        }

        logger.warn("no form found");

    }


}
