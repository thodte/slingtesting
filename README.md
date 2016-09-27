# slingtesting with JCR_MOCK oder JCR_OAK

Trying to use slick mock with resourcetyperesolver other like the default.

Changing to default it works. But an unsupportedoperation exception is raised because I wan't to use queries.

*JCR_MOCK* and *JCR_OAK* doesn't work in this setup. The following excrption is raised 

org.apache.sling.testing.mock.osgi.ReferenceViolationException: Multiple matches found for unary reference 'factory' for class de.htsolutions.sling.testing.FormularService

After debugging I find the the reason: There are two ResourceResolverFactory instances in the context and the framework doesn't know which to use.

Problem in setup or bug or a thinking error by me?